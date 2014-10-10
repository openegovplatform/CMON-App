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
<%@page import="vn.dtt.sharedservice.cmon.consumer.citizen.ICitizenService"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="java.util.Collections"%>
<%@page import="vn.dtt.cmon.timhoso.portlet.utils.TimHoSoUtils"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="vn.dtt.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page
	import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="vn.dtt.cmon.dao.hosohcc.model.HoSoTTHCCong"%>

<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.Date"%>

<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<%@page pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<head>

<%-- <script src="<%=request.getContextPath()%>/js/egov-common.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-1.8.0.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ui.core.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.uniform.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery-ui-1.8.15.custom.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ui.accordion.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.fancybox-1.3.4.pack.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/js-citizen.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/js_citizen_transaction.js"
	type="text/javascript"></script>
</head>
 --%>

<%
	ICitizenService service = WebserviceFactory.getCmonService();
	List<YKienTraoDoi> listYkiens = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String noidung = "";
	String url = "";
	String nameFile = "";
	String tentailieu = "";
	// TaiLieuChungThuc taiLieuChungThuc =null;

	long idHoSo = ParamUtil.getLong(request, "idHoSo");
	
	HoSoTTHCCong hoSoTTHCC = HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(idHoSo);
	CongDan congDan = CongDanLocalServiceUtil.getCongDan(hoSoTTHCC.getCongDanNopId());
	
/* 	listYkiens = YKienTraoDoiLocalServiceUtil
				.findByHoSoTTHCCongId(idHoSo); */
	if (hoSoTTHCC.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG) {
		listYkiens = YKienTraoDoiLocalServiceUtil.findYKienByHoSoTTHCCongIdAndLoai(
				idHoSo, Constants.LOAI_Y_KIEN_TRAO_DOI.LOAI_YEU_CAU_BO_XUNG_HO_SO);
			
	} else {
		listYkiens = YKienTraoDoiLocalServiceUtil.findYKienByHoSoTTHCCongIdAndLoai(
				idHoSo, Constants.LOAI_Y_KIEN_TRAO_DOI.LOAI_DUNG_XU_LY_HO_SO); //findByHoSoTTHCCongId(idHoSo);
	}
				
	if (listYkiens != null && listYkiens.size()> 0) {
		// get the last one						
		YKienTraoDoi ykien = listYkiens.get(0);		
		
		noidung = ykien.getNoiDungYKien();

		if (ykien.getNoiLuuTruId() != null
				&& ykien.getNoiLuuTruId() > 0) {
			url = WebserviceFactory.getOfficerService()
					.getURLCuaGiayToDinhKem(
							ykien.getNoiLuuTruId()); //data test noi luu tru tai lieu ID 278866L
/* 			tentailieu = TaiLieuChungThucLocalServiceUtil
					.getTaiLieuChungThuc(
							ykien.getNoiLuuTruId())
					.getTen(); */
		}

		if (url != null) {
			if (!url.trim().isEmpty()) {
				nameFile = url;
			}
		}

		CongChuc congChuc = CongChucLocalServiceUtil.
			findByTaiKhoanNguoiDungId(ykien.getNguoiGuiId()).get(0);
	
%>
<portlet:renderURL  var="urlBack" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
		<portlet:param name="idHoSo" value="<%=String.valueOf(idHoSo)%>" />
		<portlet:param name="<%=TransactionUtils.PARAM_VIEW_TYPE%>" value="transactionDetails" />
	<portlet:param name="<%=TransactionUtils.TRANSACTION_ID%>"	value="<%=String.valueOf(idHoSo)%>" />
	<portlet:param name="jspPage" value="/html/portlet/transaction/view.jsp" />
</portlet:renderURL>

<portlet:actionURL var="guiDenCongDan"  name="guiDenCongDan">
</portlet:actionURL>

<body>
	<div class="egov-container">
		<div>
			<h6 style="text-align: center; font-size: 16px; margin-bottom: 15px; padding-top: 30px; margin-left: 50px; margin-right: 50px; text-transform: uppercase;">
			Nội dung chi tiết ý kiến của cán bộ
			<%-- <liferay-ui:message key="vn.dtt.html.boxunghoso.title" /> --%>
			</h6> 
		</div>
			
		<form action="<%= guiDenCongDan %>" class="egov-form" method="post">

			<input type="hidden" name="idykien"  value="<%= ykien.getId() %>" />
			<table class="egov-table-form" style="margin-bottom: 20px;">
				<tr>
	    				<td style="width: 20%;"><strong>Trạng thái gửi: </strong></td>
						<td>
						<% if (ykien.getChaiId() != null &&  ykien.getChaiId() > 0) { %>
						Đã gửi thông tin đến công dân
						<% } else { %>
						Thông tin này chưa được gửi đến công dân
						<% } %>
						</td>
				</tr>
				
				<tr>
	    				<td><strong>Tên thủ tục:</strong></td>
						<td><%=hoSoTTHCC.getTenThuTucHanhChinh()%></td>
				</tr>
				
				<tr>
	    				<td><strong>Người gửi:</strong></td>
						<td><%=congChuc.getHoVaTen()%></td>
				</tr>
				
				<tr>
	    				<td><strong><strong>Ý kiến:</strong></td>
	    				<% if (ykien.getTrangThai() == 1) { %>
						<td><textarea name="noidungykien" style="width: 100%; resize:none; display: block; height: 100%; border: none;"  readonly="readonly"><%=noidung%></textarea>
						<% } else { %>
						<td><textarea rows="" cols="" name="noidungykien" style="width: 100%; height: 127px;"> <%=noidung%></textarea>
						<% } %>
						</td>
				</tr>
				
				<tr>
	    				<td><strong>Thời gian gửi:</strong></td>
						<td><%=dateFormat.format(ykien.getThoiGianGuiYKien())%></td>
				</tr>
				
				<tr>
						<td><strong>Văn bản (Công văn):</strong></td>
 		 		      	<td> 
				     	 <%
			     	 		if (ykien.getNoiLuuTruId() != null
			     	 				&& ykien.getNoiLuuTruId() > 0) {
					     	 %>
								<a href="<%= url%>" >
									 	Văn bản đính kèm
							 </a>
						<%
							} else {
						%>
						Không có
						<% }  %>
				      </td> 
				</tr>
				<tr>
					<td><strong>Thông tin công dân:</strong></td>
					<td>
					<%
						if (congDan.getTaiKhoanNguoiDungId() == null || congDan.getTaiKhoanNguoiDungId() == 0) {
					%>
					<div>
					Công dân này chưa có tài khoản
					</div>
					<div>
					Liên hệ với công dân theo: <%= congDan.getTenDayDu() %>
						<div>
						<% if (congDan.getDienThoaiDiDong() != null && congDan.getDienThoaiDiDong().length() > 0) { %>
							<strong>Điện thoại di động:</strong>  <%= congDan.getDienThoaiDiDong() %><br>
						<% }  %>
						<% if (congDan.getDienThoaiCoDinh() != null && congDan.getDienThoaiCoDinh().length() > 0) { %>
							<strong>Điện thoại cố định:</strong>  <%= congDan.getDienThoaiCoDinh() %><br>
						<% }  %>
						<% if (congDan.getEmail() != null && congDan.getEmail().length() > 0) { %>
							<strong>Email:</strong>  <%= congDan.getEmail() %><br>
						<% }  %>
						<% if (congDan.getDiaChiHienNay() != null && congDan.getDiaChiHienNay().length() > 0) { %>
							<strong>Địa chỉ:</strong>  <%= congDan.getDiaChiHienNay() %>, 
							<%= service.getDVHC(congDan.getDiaChiHienNayXaId()).getTen() %>,
							<%= service.getDVHC(congDan.getDiaChiHienNayHuyenId()).getTen() %>,
							<%= service.getDVHC(congDan.getDiaChiHienNayTinhId()).getTen() %>
							<br>
						<% }  %>
						</div>
					</div>
					<% } else { %>
						<input type="hidden" value="<%= congDan.getTaiKhoanNguoiDungId()%>" name="idtaikhoannguoidung" />
						Công dân đã có tài khoản,
						<% if (ykien.getTrangThai() == 0) {%>
						 thông tin sẽ được gửi tới tài khoản công dân
						 <% } else { %>
						 công dân đã đọc thông tin trên
						 <% }  %>
					<% } %>
					</td>
				</tr>
			</table>
			
	   		<input type="submit"  value="Xác nhận đã gửi thông báo cho công dân" class="egov-button" 
	   		<% if ( ykien.getTrangThai() == 0) {
	   		%><% } else { %>disabled="disabled" style="background-color: rgb(189, 184, 184); border-color: #BDB8B8;"<% }  %>/>
			<% }  %>
			 <a href = "javascript:history.back()">
					<input type="button" id="<portlet:namespace/>_back" value="Quay lại" class="egov-button">
			</a>	
		</form>			
	</div>
</body>

					
<script type="text/javascript">
$(document).ready( function( ) {
    $("textarea").each( function(i, el) {
        $(el).height(el.scrollHeight);
    });
  });

function openWindow(url) {

	var newWindow = window
			.open(
					url,
					'Search popup',
					'height=500,width=900,left=90,top=100,resizable=no,location=no,status=no,menubar=no');

	if (window.focus) {
		newWindow.focus();
	}

	return false;
}

</script>
