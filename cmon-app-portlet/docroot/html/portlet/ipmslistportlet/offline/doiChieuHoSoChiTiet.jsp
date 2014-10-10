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
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Date"%>
<%@page import="org.oep.cmon.portlet.mapping.utils.Constaints"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="java.util.List"%>

<%@page pageEncoding="UTF-8"%>

<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>

<script src="<%=request.getContextPath()%>/js/jquery.form.js"	type="text/javascript"></script>
<style>
.table-form{
	border-collapse: separate; border-spacing: 10px;text-align: left;
}
</style>
<%

String backUrl = ParamUtil.getString(request, "backUrl");

String HosotthcCongId = "";
if (renderRequest.getParameter("HosotthcCongId") != null) {
	HosotthcCongId = renderRequest.getParameter("HosotthcCongId");
}
int fromLuanChuyen = ParamUtil.getInteger(request, "fromLuanChuyen");
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

HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
List<FileDinhKem> liFileUploadsIservice1 = ConvertUtil.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoTTHCCong.getId()));
%>
<div class="egov-container">
	<table style="width: 100%; background-color: white;">
		<tr>
			<td align = "right"></td>
			<td align = "right">
				<%
					PortletURL timCongDanRequestUrl = renderResponse.createRenderURL();
					timCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/view.jsp");
					timCongDanRequestUrl.setParameter("transactionKeyword", transactionKeyword);
					timCongDanRequestUrl.setParameter("transType", transType);
					timCongDanRequestUrl.setParameter("statusHS", statusHS);
					%>
					<a href="<%=timCongDanRequestUrl.toString() %>"><!-- Quay lại&nbsp;&nbsp;&nbsp;&nbsp; --> </a>
			</td>
		</tr>
	</table>
	<% if (fromLuanChuyen != 1) { %>	
	<table cellspacing="0" cellpadding="0" width="100%" class="table-form">
		<tr>
			<td colspan="2" align="left"><label class="egov-label-header">Đối chiếu hồ sơ</label></td>
		</tr>
		<tr>
			<td colspan="2" align = "left">
				<%
					if (Validator.isNotNull(request.getAttribute("doi_chieu_completed"))) {
				%>
						<div class="portlet-msg-success" style="padding-left: 20px;">
					 		Yêu cầu của bạn đã được thực hiện thành công
					 	 </div>
				<%
					}
				%>
				<liferay-ui:error key="errorDoiChieuHoSo" message="Hồ sơ đính kèm không đối chiếu được"></liferay-ui:error>
				<liferay-ui:error key="errorHieuLuc" message="Trường Hiệu lực đến ngày phải lớn hơn Hiệu lực từ ngày"></liferay-ui:error>
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Tên dịch vụ công:</label>
			</td>
			<td>
				<label class ="egov-label"><%=hoSoTTHCCong.getTenThuTucHanhChinh() %></label> 
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Mã hồ sơ:</label>
			</td>
			<td>
				<label class ="egov-label"><%=hoSoTTHCCong.getMaSoHoSo() %></label> 
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Người nộp hồ sơ:</label>
			</td>
			<td>
				<label class ="egov-label"><%=hoSoTTHCCong.getHoTenNguoiNopHoSo() %></label> 
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Ngày nộp hồ sơ:</label>
			</td>
			<td>
				<label class ="egov-label"><%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayNopHoSo()) %></label> 
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Ngày hết hiệu lực:</label>
			</td>
			<td>
				<label class ="egov-label"><%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayKetThucXuLy()) %></label> 
			</td>
		</tr>
		<tr>
			<td colspan="2" align = "center">
			</td>
		</tr>
	</table>
	
	<p><label class ="egov-label-bold">Danh sách tài liệu đối chiếu:</label></p>
	<% } else { %>
	<p><label class ="egov-label-bold">Danh sách thành phần hồ sơ:</label></p>
	<% } %>
	<br>
	<%
		PortletURL actionUrl = renderResponse.createActionURL();
		actionUrl.setParameter(ActionRequest.ACTION_NAME, "doiChieuHoSoRequest");
	%>
	<form id="traHoSoRequestForm" name="traHoSoRequestForm" method="post" action="<%=actionUrl.toString() %>">
		<input id="HosotthcCongId" name="HosotthcCongId" type="hidden" value="<%=HosotthcCongId %>"/>
		<input id="transactionKeyword" name="transactionKeyword" type="hidden" value="<%=transactionKeyword %>"/>
		<input id="statusHS" name="statusHS" type="hidden" value="<%=statusHS %>"/>
		<input id="transType" name="transType" type="hidden" value="<%=transType %>"/>
		<input id="backUrl" name="backUrl" type="hidden" value="<%=backUrl %>"/>
		
		<table cellpadding="0" cellspacing="0"  class="egov-table"  width="100%">
			<tr>
			    <th align = "center" width="2%">STT</th>
			    <th scope="col" width="30%">Tên tài liệu</th>
			    <th scope="col" width="3%">Lịch sử</th>
			    <th scope="col" width="15%">Đối chiếu</th>
			    <th scope="col" width="25%">Hiệu lực từ ngày</th>
			    <th scope="col" width="25%">Hiệu lực đến ngày</th>
			</tr>
			<%
				TaiLieuChungThuc taiLieuChungThuc = null;
				for (int i =0; i < liFileUploadsIservice1.size(); i++) {
					FileDinhKem fileUpload = liFileUploadsIservice1.get(i);
					
					taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
					if (taiLieuChungThuc != null) {
						int trangThaiTL = taiLieuChungThuc.getTrangThai();
						long taiLieuChungThucId = taiLieuChungThuc.getId();
						
						
					%>
						<tr>
							<td style="text-align:center;"><%=i+1 %></td>
							<td style="padding-left: 3px;"><%=taiLieuChungThuc.getTen() %>
							<td style="text-align:center;">
								<%
										if (trangThaiTL == Constaints.Document.chuaDoiChieu) {
									%>
										 	<img title="Tài liệu mới" src="<%=request.getContextPath()%>/images/phienbanfile_new.png" />
									<%	} else if (trangThaiTL == Constaints.Document.doiChieuKhop) { %>
											<img title="Tài liệu đã đối chiếu khớp" src="<%=request.getContextPath()%>/images/phienbanfile_approved.png" />
									<%  } else if (trangThaiTL == Constaints.Document.doiChieuKhongKhop) { %>
											<img title="Tài liệu đối chiếu không khớp" src="<%=request.getContextPath()%>/images/phienbanfile_new.png" />
									<%  } %>
							</td>
							<td style="text-align:center;">
								<% if (fromLuanChuyen == 0) { %>
								 <select class="egov-select" style="width:150px;"  name="doiChieu_<%=taiLieuChungThucId %>">
							        <option value = "<%=Constaints.Document.chuaDoiChieu%>">
										--Chưa đối chiếu-- 
									</option>					
									<option <%=trangThaiTL==Constaints.Document.doiChieuKhop? "selected":""%> value = "<%=Constaints.Document.doiChieuKhop%>">
										Đối chiếu khớp
									</option>
									<option <%=trangThaiTL==Constaints.Document.doiChieuKhongKhop? "selected":""%> value = "<%=Constaints.Document.doiChieuKhongKhop%>">
										Đối chiếu không khớp 
									</option>
							    </select>
							    <% } else { 
										String doiChieuStr = "";							    		
							    		if (trangThaiTL == Constaints.Document.chuaDoiChieu) {
							    			doiChieuStr = "Chưa đối chiếu";
							    		} else if (trangThaiTL == Constaints.Document.doiChieuKhop) {
							    			doiChieuStr = "Đối chiếu khớp";
							    		} else if (trangThaiTL == Constaints.Document.doiChieuKhongKhop) {
							    			doiChieuStr = "Đối chiếu không khớp";
							    		}
							    %>
							    	<label  class ="egov-label"><%= doiChieuStr %></label>
							    <% } %>
							</td>
							
							<%
								String tuNgay = "";
								String denNgay = "";
								tuNgay = ConvertUtil.parseDateToTring(taiLieuChungThuc.getHieuLucTuNgay());
								denNgay = ConvertUtil.parseDateToTring(taiLieuChungThuc.getHieuLucDenNgay());
								if (Validator.isNull(tuNgay)) {
									tuNgay = ConvertUtil.parseDateToTring(new Date());
								}
							%>
							<td style="text-align:center;">
								<input type="text" class="egov-calendar" name="tuNgay_<%=taiLieuChungThucId%>" value="<%=tuNgay %>" style="width: 75%;" />
							</td>
							<td style="text-align:center;">
								<input type="text" class="egov-calendar" name="denNgay_<%=taiLieuChungThucId%>" value="<%=denNgay %>"  style="width: 75%;" />
							</td>
						</tr>
			
			<% 		}
				} %>		
		</table>
		<br>
		<%
			//if (fromLuanChuyen==0 && !SessionMessages.contains(renderRequest, "doi_chieu_completed")) {
			if (fromLuanChuyen==0) {
		%>
				<input type="submit" class = "egov-button-normal" name="submitButton"  value="Đối chiếu" />
		<%
			}
		%>
		<%
			PortletURL urlDoiChieu = renderResponse.createRenderURL();
			urlDoiChieu.setParameter("jspPage","/html/portlet/ipmslistportlet/offline/viewUploadFile.jsp");
			urlDoiChieu.setParameter("HosotthcCongId", HosotthcCongId);
			urlDoiChieu.setWindowState(LiferayWindowState.POP_UP);
			urlDoiChieu.setPortletMode(PortletMode.VIEW);
			
		%>	
		
	     	<input type="button" id="<portlet:namespace/>_back" value="Quay lại" onclick="javascript: window.location = '<%=backUrl %>';" class="egov-button-normal">
	</form>
	
</div>
<script type="text/javascript">

function deleteFileUpload(fileId) {

	var giatri = document.getElementById(fileId).value;
	if (giatri.length > 0) {
		document.getElementById(fileId).value = '';
	} else {
		document.getElementById(fileId).value = fileId;
	}
	
}

function showDocumentPopupDoiChieu(viewDocumentURL, popupTitle) {	

	AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {

		var dialog = new A.Dialog({
			title : popupTitle,
			draggable : true,
			modal : true,
			centered : true,
			width : $(window).width() * 0.5,
			//height : $(window).height() * 0.7,

		}).plug(A.Plugin.IO, {
			uri : viewDocumentURL
		}).render();
	});
}

</script>
