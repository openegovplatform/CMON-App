<!-- 
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
  -->
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="vn.dtt.sharedservice.bpm.consumer.uengine.WorkList"%>
<%@page import="vn.dtt.sharedservice.bpm.consumer.uengine.IBrmsService"%>
<%@page import="vn.dtt.sharedservice.bpm.consumer.uengine.IBrms"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.config.ConfigUtils"%>
<%@page import="org.oep.cmon.portlet.ipmslist.business.FileKetQua"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>

<%@ include file="/html/portlet/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<script src="<%=request.getContextPath()%>/js/jquery-ui.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/js_citizen_transaction.js" type="text/javascript"></script>
	<!-- hoangtrung.nguyen fix 2 man hinh danh sach ho so  -->
	<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/core.css" />
	<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/customEgovTheme.css" />
</head>
<%
String HosotthcCongId = "";
if (renderRequest.getParameter("HosotthcCongId") != null) {
	HosotthcCongId = renderRequest.getParameter("HosotthcCongId");
}

String transactionKeyword = "";
if (renderRequest.getParameter("transactionKeyword") != null) {
	transactionKeyword = renderRequest.getParameter("transactionKeyword");
}

String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}

String transType = "";
if (renderRequest.getParameter("transType") != null) {
	transType = renderRequest.getParameter("transType");
}

HoSoTTHCCong instance = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
String maHoSo = instance.getMaSoHoSo();
String emailCanBoDaDangNhap = PortalUtil.getUser(request).getEmailAddress();
String portalUrl = PortalUtil.getPortalURL(request); //"http://dichvucong.dtt.vn";
String uengineUrl = portalUrl + "/uengine-web";

//uengineUrl = "http://qa.dichvucong.dtt.vn/uengine-web";
//maHoSo = "1409307430083";

IBrms  service = new IBrmsService().getIBrmsPort();
List<WorkList> workLists = service.getWorkListByMaHoSo(maHoSo);
String taskid = StringPool.BLANK, tracingTag = StringPool.BLANK, instaneId = StringPool.BLANK;
if (workLists.size() > 0) {
	WorkList workList1 = workLists.get(workLists.size()-1);
	taskid = workList1.getTaskid();
	tracingTag = workList1.getTrctag();
	instaneId = workList1.getInstid();
}

if (HoSoBusinessUtil.laCanBoDangDuocPhanCongXuLyHoSo(emailCanBoDaDangNhap, instance)) {
	uengineUrl += "/processparticipant/worklist/workitemHandler.jsp";
	uengineUrl += "?taskId="+taskid+"&instanceId="+instaneId+"&tracingTag="+tracingTag+"&from=DNG";
} else {
	uengineUrl += "/processparticipant/viewProcessInformation.jsp?omitHeader=yes&instanceId="+instaneId;
}

// dsp
if (uengineUrl.contains("https")) {
	uengineUrl = uengineUrl.replace("https", "http");
}


%>
<div  class="egov-container">
	
	<table border="0" class="egov-table-form" width="100%">
		<tr>
			<td width="40%"></td>
			<td width="60%"></td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Mã hồ sơ:</label>
				<label><%=instance.getMaSoHoSo() %></label>
			</td>
			<td>
			<%
				String resultStr = "";
				Date ngayNhan = instance.getNgayNhanHoSo();	
				Date hienTai = new Date();
				Date ngayHenTra = instance.getNgayHenTraKetQua();
				
				
				if (ngayNhan != null) {
					Calendar calNgayNhan = GregorianCalendar.getInstance();
					calNgayNhan.setTime(ngayNhan);
					Calendar calHienTai = GregorianCalendar.getInstance();
					calHienTai.setTime(hienTai);
					int soNgay = 0;
					while (calNgayNhan.getTimeInMillis() < calHienTai.getTimeInMillis()) {
						int dayOfWeek = calNgayNhan.get(Calendar.DAY_OF_WEEK);
						if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
							soNgay++;
						}
						calNgayNhan.add(Calendar.DAY_OF_MONTH, 1);
					}
					resultStr = String.valueOf(soNgay);
					if (ngayHenTra != null) {
						int soNgayHenTra = 0;
						calNgayNhan.setTime(ngayNhan);
						Calendar calNgayHenTra = GregorianCalendar.getInstance();
						calNgayHenTra.setTime(ngayHenTra);
						while (calNgayNhan.getTimeInMillis() < calNgayHenTra.getTimeInMillis()) {
							int dayOfWeek = calNgayNhan.get(Calendar.DAY_OF_WEEK);
							if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
								soNgayHenTra++;
							}
							calNgayNhan.add(Calendar.DAY_OF_MONTH, 1);
						}
						resultStr = resultStr + "/" + String.valueOf(soNgayHenTra);
					}
				}
				
			%>
				<label class ="egov-label-bold">Thời gian xử lý hồ sơ trên cả quy trình:</label>
				<label><%=resultStr%> ngày</label>
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Số biên nhận: </label>
				<label><%=instance.getMaSoBienNhan() %></label>
			</td>
			<td>
				<label class ="egov-label-bold">Ngày tiếp nhận:</label>
				<label><%= ConvertUtil.parseDateToTring(instance.getNgayNhanHoSo()) %></label>
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Tên người nộp hồ sơ:</label>
				<label><%=instance.getHoTenNguoiNopHoSo() %></label>
			</td>
			<td>
				<label class ="egov-label-bold">Ngày hẹn trả:</label>
				<label><%= ConvertUtil.parseDateToTring(instance.getNgayHenTraKetQua()) %></label>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<label class ="egov-label-bold">Tên dịch vụ công:</label>
				<label><%=instance.getTenThuTucHanhChinh() %></label>
			</td>
		</tr>
	</table>

<br>
	<div id="wd-fancy-configuration-template" class="wd-fancy-document-list">
		<fieldset>					
			<div class="wd-submit">
				<%
					long transPortletId = 0; 
					String transPortletName = "";
					String schemaName =instance.getMaUngDung().trim().toLowerCase();
					String maQuyTrinh="";
					String delimiter = "_";
					String schemaNameStr = prefs.getValue(schemaName+"Id","0");
					if (Validator.isNotNull(schemaNameStr)) {
						transPortletId = Long.parseLong(schemaNameStr);
					} else {
						
					}
					transPortletName = prefs.getValue(schemaName+"Name","");
					ThuTucHanhChinh thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(instance.getThuTucHanhChinhId());
					if(thuTucHanhChinh !=null) {
						maQuyTrinh = thuTucHanhChinh.getMa();
					}
				%>
				<liferay-portlet:renderURL plid="<%=transPortletId%>" 
					portletName="<%=transPortletName%>" var="LINK">
						<liferay-portlet:param name="<%=TransactionUtils.PARAM_PORTLET_NAME%>" value="<%=schemaName%>" />
						<liferay-portlet:param name="<%=TransactionUtils.PARAM_ID%>" value="<%=String.valueOf(instance.getId())%>" />
						<liferay-portlet:param name="<%=TransactionUtils.PARAM_ID_QUY_TRINH%>" value="<%=String.valueOf(instance.getThuTucHanhChinhId())%>" />
						<liferay-portlet:param name="backURL" value="<%= PortalUtil.getCurrentCompleteURL(request) %>" />
						<liferay-portlet:param name="maQuyTrinh" value="<%=maQuyTrinh%>" />
				</liferay-portlet:renderURL>
				<% if (instance.getLoaiHoSo() != 1) { %>
						<input  type="button" class="wd-button"  style="height: 30px; width: 160px" onclick="javascript: window.location='<%=LINK%>';" 
						 	value="Xem chi tiết" />
				<% } %>
			
			<%  
			 PortletURL doiChieuHoSoRequestUrl = renderResponse.createRenderURL();
		     doiChieuHoSoRequestUrl.setParameter("HosotthcCongId", String.valueOf(HosotthcCongId));
		     doiChieuHoSoRequestUrl.setParameter("fromLuanChuyen", "1");
		     doiChieuHoSoRequestUrl.setParameter("backUrl", PortalUtil.getCurrentCompleteURL(request));
			 if (ConvertUtil.checkLoaiDoiTuongCongDan(instance.getThuTucHanhChinhId(), "003") && instance.getDoiTuongCanXuLyId() != null && instance.getDoiTuongCanXuLyId() > 0) { 
		      doiChieuHoSoRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/doiChieuHoSoChiTiet.jsp");
		      } else {
		       doiChieuHoSoRequestUrl.setParameter("jspPage","/html/portlet/ipmslistportlet/offline/doiChieuHoSoChiTiet.jsp");
		      }
	 		%> 	
			   		<input type="button" onclick="sendRedirect('<%=doiChieuHoSoRequestUrl%>') ;" 
			   			class="wd-button" style="height: 30px; width: 160px;" value="Xem thành phần hồ sơ"/>
			   		
			   		<portlet:renderURL var="viewProcess" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
					 	<portlet:param name="hoSoTTHCCongId" value="<%=String.valueOf(instance.getId())%>" />
					 	<portlet:param name="coQuanTiepNhanId" value="<%=String.valueOf(instance.getCoQuanTiepNhanId())%>" />
					 	<portlet:param name="type" value="<%=Constants.CONG_DAN%>" />
					 	<portlet:param name="jspPage" value="/html/cmon/process/view_process.jsp" />
					 </portlet:renderURL>
			   		<input type="button" class="wd-button" id="<%= instance.getMaSoHoSo()%>" name="viewProcessButtonName" style="height: 30px; width: 160px" value="Xem tiến trình xử lý"/>

				<%
					PortletURL quayLaiUrl = renderResponse.createRenderURL();
					//quayLaiUrl.setParameter("jspPage", ParamUtil.getString(request, "backJspPage"));
				%>
					<input type="button" class="wd-button" style="height: 30px; width: 160px" 
			   			onclick="sendRedirect('<%= quayLaiUrl%>')" value="Quay lại danh sách"/>
			   			
			</div>
		</fieldset>
	</div>
<br>
	<iframe frameborder="0" src="<%=uengineUrl%>" width="100%" id="uengine-iframe" height="1300px">
		<p>Your browser does not support iframes.</p>
	</iframe>
	
	
</div>

<script type="text/javascript">
	function sendRedirect(url) {
		window.location = url;
	}
</script>
<%@ include file="/html/portlet/ipmslistportlet/viewProcess.jsp"%>