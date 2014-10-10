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
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DoanhNghiep"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Date"%>
<%@page import="org.oep.cmon.portlet.ipmslist.business.FormOfflineBusiness"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/dialog-ui.css" type="text/css" media="screen" />
<script src="<%=request.getContextPath()%>/js/jquery.form.js"	type="text/javascript"></script>

<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "addHoSoDoanhNghiepRequest");
String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}
String transType = "";
if (renderRequest.getParameter("transType") != null) {
	transType = renderRequest.getParameter("transType");
}
String transactionKeyword = "";
if (renderRequest.getParameter("transactionKeyword") != null) {
	transactionKeyword = renderRequest.getParameter("transactionKeyword");
}

String maSoHoSo = "";
if (renderRequest.getParameter("maSoHoSo") != null) {
	maSoHoSo = renderRequest.getParameter("maSoHoSo");
}

String HosotthcCongId = "";
if (renderRequest.getParameter("HosotthcCongId") != null) {
	HosotthcCongId = renderRequest.getParameter("HosotthcCongId");
}

String searchKeyWord = "";
if (renderRequest.getParameter("searchKeyWord") != null) {
	searchKeyWord = renderRequest.getParameter("searchKeyWord");
}

String _searchKeyWord = "";
if (renderRequest.getParameter("_searchKeyWord") != null) {
	_searchKeyWord = renderRequest.getParameter("_searchKeyWord");
}

String idQuyTrinh = "";
if (renderRequest.getParameter("idQuyTrinh") != null) {
	idQuyTrinh = renderRequest.getParameter("idQuyTrinh");
}
String idCongDan = "";
if (renderRequest.getParameter("idCongDan") != null) {
	idCongDan = renderRequest.getParameter("idCongDan");
}

String idCongDanNop = "";
if (renderRequest.getParameter("idCongDanNop") != null) {
	idCongDanNop = renderRequest.getParameter("idCongDanNop");
}

String soDienThoaiCongDan = "";
if (renderRequest.getParameter("soDienThoaiCongDan") != null) {
	soDienThoaiCongDan = renderRequest.getParameter("soDienThoaiCongDan");
}
DoanhNghiep congDan = ConvertUtil.findDoanhNghiepById(ConvertUtil.convertToLong(idCongDan));
CongDan conDanNop = ConvertUtil.findCongDanById(ConvertUtil.convertToLong(idCongDanNop));
long uid = PortalUtil.getUserId(request);
long cqqlId = -1;
TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(nguoiDung.getId());

if(congChucs.size() > 0 ){
		cqqlId = congChucs.get(0).getCoQuanQuanLyId();
}


PortletURL uploadFileURL = renderResponse.createRenderURL();
uploadFileURL.setParameter("jspPage","/html/portlet/ipmslistportlet/company/dialogUploadFile.jsp");
uploadFileURL.setParameter("transType",transType);
uploadFileURL.setParameter("transactionKeyword",transactionKeyword);
uploadFileURL.setParameter("searchKeyWord",searchKeyWord);
uploadFileURL.setParameter("_searchKeyWord",_searchKeyWord);
uploadFileURL.setParameter("idQuyTrinh",idQuyTrinh);
uploadFileURL.setParameter("idCongDan",idCongDan);
uploadFileURL.setParameter("idCongDanNop",idCongDanNop);
uploadFileURL.setParameter("statusHS",statusHS);
uploadFileURL.setWindowState(LiferayWindowState.POP_UP);
uploadFileURL.setPortletMode(PortletMode.VIEW);

%>
<div class="egov-container">
	<form id="addHoSoRequestForm" name="addHoSoRequestForm" method="post" action="<%=actionUrl.toString() %>">
		<table style="width: 100%;background-color: white;">
			<tr>
				<td align = "right" width="100%">
					<%
					PortletURL timCongTyRequestUrl = renderResponse.createRenderURL();
					timCongTyRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/timCompany.jsp");
					timCongTyRequestUrl.setParameter("searchKeyWord", searchKeyWord);
					timCongTyRequestUrl.setParameter("_searchKeyWord", _searchKeyWord);
					timCongTyRequestUrl.setParameter("idQuyTrinh", idQuyTrinh);
					timCongTyRequestUrl.setParameter("statusHS", statusHS);
					timCongTyRequestUrl.setParameter("transactionKeyword", transactionKeyword);
					timCongTyRequestUrl.setParameter("transType", transType);
					%>
					<a href="<%=timCongTyRequestUrl.toString() %>">Quay lại&nbsp;&nbsp;&nbsp;&nbsp;</a>
				</td>
			</tr>
		</table>
		<table  class="egov-table-form">
			<tr>
				<td colspan="2" align = "center">
					<label class="egov-label-header">Nộp đơn cho doanh nghiệp</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<liferay-ui:error key="erorTelephone" message = "vn.dtt.form.offline.form.error.phone"/>
				<liferay-ui:error key="erorAddForm" message = "vn.dtt.form.offline.add.company.form.error"/>
				<span style="color: red" id="message_error_delete_file"></span>
				<liferay-ui:success key="add_ho_so_completed" message="vn.dtt.form.offline.add.company.form.completed"></liferay-ui:success>
			</tr>
			<tr>
				<td >
					<label class ="egov-label-bold">Cơ quan tiếp nhận:</label>
				</td>
				<td>
					<input id="coQuanTiepNhanTen" name="coQuanTiepNhanTen" class = "egov-inputfield custom" readonly="readonly" type="text" size="70" value="<%=ConvertUtil.getTenCoQuanQuanLy(cqqlId) %>"/>
					<input id="coQuanTiepNhanId" name="coQuanTiepNhanId" type="hidden" value="<%=cqqlId %>"/>
					<input id="searchKeyWord" name="searchKeyWord" type="hidden" value="<%=searchKeyWord %>"/>
					<input id="_searchKeyWord" name="_searchKeyWord" type="hidden" value="<%=_searchKeyWord %>"/>
					<input id="HosotthcCongId" name="HosotthcCongId" type="hidden" value="<%=HosotthcCongId %>"/>
					<input type="hidden" name = "transType" id = "transType" value = "<%=transType%>"/>
					<input type="hidden" name = "statusHS" id = "statusHS" value = "<%=statusHS%>"/>
					<input type="hidden" name = "transactionKeyword" id = "transactionKeyword" value = "<%=transactionKeyword%>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên quy trình:</label>
				</td>
				<td>
					<input id="tenQuyTrinh" name="tenQuyTrinh" class = "egov-inputfield custom" readonly="readonly" value="<%=ConvertUtil.getTenThuTucHanhChinh(idQuyTrinh) %>" type="text" size="70"/>
					<input id="idQuyTrinh" name="idQuyTrinh" type="hidden" value="<%=idQuyTrinh %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold" style="color: blue;">Thông tin công dân nộp hồ sơ</label>
				</td>
				<td>
				<%
				PortletURL timCongDanRequestUrl = renderResponse.createRenderURL();
				timCongDanRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/timCongDan.jsp");
				timCongDanRequestUrl.setParameter("transType",transType);
				timCongDanRequestUrl.setParameter("transactionKeyword",transactionKeyword);
				timCongDanRequestUrl.setParameter("searchKeyWordOld",searchKeyWord);
				timCongDanRequestUrl.setParameter("_searchKeyWord",_searchKeyWord);
				timCongDanRequestUrl.setParameter("idQuyTrinh",idQuyTrinh);
				timCongDanRequestUrl.setParameter("idCongDan",idCongDan);
				timCongDanRequestUrl.setParameter("idCongDanNop",idCongDanNop);
				timCongDanRequestUrl.setParameter("statusHS",statusHS);
				timCongDanRequestUrl.setParameter("soDienThoaiCongDan",soDienThoaiCongDan);
				%>
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=timCongDanRequestUrl.toString() %>">Thêm thông tin công dân nộp</a>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số CMND của công dân:</label>
				</td>
				<td>
					<input id="cmndCongDanNop" name="cmndCongDanNop" class = "egov-inputfield custom" readonly="readonly" value="<%=ConvertUtil.getCMNDCongDan(conDanNop) %>" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Họ tên công dân:</label>
				</td>
				<td>
					<input id="tenCongDanNop" name="tenCongDanNop" class = "egov-inputfield custom" value="<%=ConvertUtil.getTenCongDan(conDanNop) %>" readonly="readonly" type="text" size="70"/>
					<input id="idCongDanNop" name="idCongDanNop" type="hidden" value="<%=idCongDanNop %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Địa chỉ thường trú:</label>
				</td>
				<td>
					<input id="diaChiThuongTruCongDanNop" name="diaChiThuongTruCongDanNop" class = "egov-inputfield custom" value="<%=ConvertUtil.getDiaChiThuongTruCongDan(conDanNop) %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Số điện thoại:</label>
				</td>
				<td>
					<input id="soDienThoaiCongDan" name="soDienThoaiCongDan" class = "egov-inputfield custom" value="<%=ConvertUtil.getTelphoneCongDan(conDanNop, renderRequest.getParameter("soDienThoaiCongDan")) %>" type="text" maxlength="11" size="70"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<label class ="egov-label-bold" style="color: blue;">Thông tin doanh nghiệp</label>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Tên doanh nghiệp:</label>
				</td>
				<td>
					<input id="tenCongDan" name="tenCongDan" class = "egov-inputfield custom" value="<%=congDan.getTen() %>" readonly="readonly" type="text" size="70"/>
					<input id="idCongDan" name="idCongDan" type="hidden" value="<%=idCongDan %>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Mã số doanh nghiệp:</label>
				</td>
				<td>
					<input id="maSoDoanhNghiep" name="maSoDoanhNghiep" class = "egov-inputfield custom" readonly="readonly" value="<%=congDan.getMa() %>" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Mã số thuế:</label>
				</td>
				<td>
					<input id="maSoThueDoanhNghiep" name="maSoThueDoanhNghiep" class = "egov-inputfield custom" value="<%=congDan.getMaSoThue() %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Địa chỉ doanh nghiệp:</label>
				</td>
				<td>
					<input id="diaChiThuongTruCongDan" name="diaChiThuongTruCongDan" class = "egov-inputfield custom" value="<%=ConvertUtil.getDiaChiDoanhNghiep(congDan) %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Ngày nộp hồ sơ:</label>
				</td>
				<td>
					<input id="ngayNopHoSo" name="ngayNopHoSo" class = "egov-inputfield custom" value="<%=ConvertUtil.parseDateToTring(new Date()) %>" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td>
					<label class ="egov-label-bold">Ngày trả hồ sơ:</label>
				</td>
				<td>
					<input id="ngayTraHoSo" name="ngayTraHoSo"  value="<%=ConvertUtil.getNgayHenTraHoSo(idQuyTrinh) %>" class = "egov-inputfield custom" readonly="readonly" type="text" size="70"/>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<label class ="egov-label-bold">Tài liệu đính kèm:</label>
				</td>
				<td align="left">
					<%
					if (renderRequest.getPortletSession().getAttribute(FormOfflineBusiness.DATA_UPLOAD_FILE) != null) {
						List<FileDinhKem> listResult = (ArrayList<FileDinhKem>)renderRequest.getPortletSession().getAttribute("data_upload");
						TaiLieuChungThuc taiLieuChungThuc = null;
						if (listResult.size() > 0) {
							%>
							<table style="background-color: white;">
							<%
							for (FileDinhKem fileUpload : listResult) {
								taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
								if (taiLieuChungThuc != null) {
									%>
									<portlet:actionURL var="deleteTaiLieuURL" name="deleteFileUpload">
										<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/view.jsp"/>
										<portlet:param name="idCongDan" value="<%=idCongDan %>"/>
										<portlet:param name="idCongDanNop" value="<%=idCongDanNop %>"/>
										<portlet:param name="idQuyTrinh" value="<%=idQuyTrinh %>"/>
										<portlet:param name="searchKeyWord" value="<%=searchKeyWord %>"/>
										<portlet:param name="_searchKeyWord" value="<%=_searchKeyWord %>"/>
										<portlet:param name="fileId" value="<%=String.valueOf(fileUpload.getNoiLuuTruTaiLieuId()) %>"/>
									</portlet:actionURL>
									<tr>
										<td>
											<a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) %>" id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>" style="display: inherit;"><%=taiLieuChungThuc.getTen() %></a>
										</td>
										<td>
											<%
											if (!SessionMessages.contains(renderRequest, "add_ho_so_completed")) {
											%>
											<img id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>_image_delete" style="display: inherit;" src="/cmon-app-portlet/images/delete-user.png" title="Xóa tài liệu đã upload" onclick="javascript: deleteFileUpload('<%=deleteTaiLieuURL.toString()%>', '<%=fileUpload.getNoiLuuTruTaiLieuId() %>')"/>
											<%
											}
											%>
										</td>
									</tr>
									<%
								}
							}
							%>
							</table>
							<%
						}
					}
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
					if (!SessionMessages.contains(renderRequest, "add_ho_so_completed")) {
						%>
						<a href="javascript: showDocumentPopup('<%=uploadFileURL.toString() %>' ,'Đính kèm tài liệu')" id="themtailieudinhkem_popup">Tải tài liệu</a>
						<%
					}
					%>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
				</td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
					<%
					if (!SessionMessages.contains(renderRequest, "add_ho_so_completed")) {
						%>
						<input type="submit" style="height: 35px;padding:10px;" class = "egov-button" name="submitButton"  value="Lưu lại" />
						<input type="reset" style="height: 35px;padding:10px;" class = "egov-button" name="reset"  value="Nhập lại" />
						<%
					} else {
						PortletURL inGiayHenURL = renderResponse.createRenderURL();
						inGiayHenURL.setParameter("jspPage", "/html/portlet/ipmslistportlet/company/traGiayHen.jsp");
						inGiayHenURL.setParameter("idCongDan", idCongDan);
						inGiayHenURL.setParameter("idCongDanNop", idCongDanNop);
						inGiayHenURL.setParameter("idQuyTrinh", idQuyTrinh);
						inGiayHenURL.setParameter("maSoHoSo", maSoHoSo);
						inGiayHenURL.setParameter("cqqlId", String.valueOf(cqqlId));
						inGiayHenURL.setParameter("HosotthcCongId", HosotthcCongId);
						inGiayHenURL.setParameter("transactionKeyword", transactionKeyword);
						inGiayHenURL.setParameter("transType", transType);
						inGiayHenURL.setParameter("statusHS", statusHS);
						inGiayHenURL.setWindowState(LiferayWindowState.POP_UP);
						inGiayHenURL.setPortletMode(PortletMode.VIEW);
						%>
						<input type="button" style="height: 35px;padding:10px;" class = "egov-button" name="submitButton" onclick="javascript: viewFileUpload('<%=inGiayHenURL.toString() %>')" value="In giấy hẹn" />
						<br><br>
						<%
					}
					%>
				</td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
function showDocumentPopup(viewDocumentURL, popupTitle) {			
	var _soDienThoaiCongDan = document.getElementById('soDienThoaiCongDan').value.trim();
    AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {

    	var dialog = new A.Dialog({
            title: popupTitle,
            draggable: true,
            modal: true,
            centered: true,
            width: $(window).width()*0.6,
            height: $(window).height()*0.5,
            
        }).plug(A.Plugin.IO, {uri: viewDocumentURL, data: {soDienThoaiCongDan: _soDienThoaiCongDan}}).render();
  });
}
</script>

<script type="text/javascript">

	function deleteFileUpload(UrlDelete, fileId) {
		document.getElementById('message_error_delete_file').innerHTML = '';
		$.ajax({
			type: 'POST'
			,url: UrlDelete
			,data : {}
			,success: function(data) {		

				// preferred
				var data2 = JSON.parse(data);
				// Xoa cac old item in select

				if (data2.deleteComplete == 'completed') {
					document.getElementById(fileId).style.display = 'none';
					document.getElementById(fileId + '_image_delete').style.display = 'none';
					document.getElementById('message_error_delete_file').innerHTML = messageDeleted;
				} else {
					document.getElementById('message_error').innerHTML = '';
					document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "vn.dtt.form.offline.error.delete.file.upload") %>';
				}
			}
		});
	}

	function viewFileUpload(url)
	{
	    var w=screen.width;
	    var h=screen.height;
	    var left = (screen.width/2)-(w/2);
	    var top = (screen.height/2)-(h/2);
	    popupWindow = window.open(url, '', 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
	    popupWindow.focus();
	}
</script>