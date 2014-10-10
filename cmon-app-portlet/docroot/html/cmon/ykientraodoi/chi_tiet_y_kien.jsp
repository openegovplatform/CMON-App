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
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="javax.portlet.PortletRequest"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.xml.datatype.XMLGregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> 
<%@page pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>


<%@ include file="/html/portlet/init.jsp" %>

<portlet:defineObjects />
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/customEgovTheme.css"
	type="text/css" media="screen" />

	<script src="<%=request.getContextPath()%>/js/egov-common.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-1.8.0.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.ui.core.js" type="text/javascript"></script>		
</head>
 <%
 
 long userId = PortalUtil.getUserId(request);
 String yKienTraoDoiId =  request.getParameter("yKienTraoDoiId");
 String hoSoTTHCCongId =  request.getParameter("hoSoTTHCCongId");
 
 String loaiCanBo = request.getParameter("loaiCanBo");
 String type = request.getParameter("type");	
 
 YKienTraoDoi yKienTraoDoi = YKienTraoDoiLocalServiceUtil.fetchYKienTraoDoi(FormatUtil.convertToLong(yKienTraoDoiId));
 
 HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(FormatUtil.convertToLong(hoSoTTHCCongId)); 
 
 
 String url =null;
 if (yKienTraoDoi.getNoiLuuTruId() !=null && yKienTraoDoi.getNoiLuuTruId()>0){
 	 url = WebserviceFactory.getOfficerService().getURLCuaGiayToDinhKem(yKienTraoDoi.getNoiLuuTruId());
 }
 
 	PortletURL backUrl = renderResponse.createRenderURL();
	backUrl.setParameter("jspPage",	"/html/cmon/ykientraodoi/danh_sach_y_kien.jsp");
	backUrl.setParameter("hoSoTTHCCongId", String.valueOf(hoSoTTHCCongId));
	backUrl.setParameter("loaiCanBo", loaiCanBo);
	backUrl.setParameter("type", String.valueOf(type));
	
	TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(userId);
	//TaiKhoanNguoiDung taiKhoanNguoiDung1 = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(yKienTraoDoi.getNguoiGuiId());
	TaiKhoanNguoiDung taiKhoanNguoiDung1 = null;
	if (yKienTraoDoi.getNguoiGuiId() > 0){
		taiKhoanNguoiDung1 = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(yKienTraoDoi.getNguoiGuiId());
	}
	
	
	String urlQuaylai = "/html/cmon/ykientraodoi/chi_tiet_y_kien.jsp";
 %>
<form name = "<portlet:namespace/>searchThamSoForm" id = "<portlet:namespace/>searchThamSoForm" method = "post"  >
<div class="egov-container">

			<table cellpadding="0" cellspacing="0"  class="egov-table" >
				
				<tr>
				    <td><label class="egov-label-bold">Tiêu đề: </label></td>
				    <td><%=yKienTraoDoi.getTieuDe() %></td>
				</tr>
				
				<tr>
				     <td><label class="egov-label-bold">Người gửi:</label></td>
				    <td><%=taiKhoanNguoiDung1.getTenNguoiDung() %> </td>
				</tr>
				
				<tr>
				     <td><label class="egov-label-bold">Ngày gửi:</label></td>
				    <td><%= FormatUtil.parseDateToTring(yKienTraoDoi.getThoiGianGuiYKien()) %></td>
				</tr>
				<tr>
				     <td><label class="egov-label-bold">Nội dung:</label></td>
				    <td><%=yKienTraoDoi.getNoiDungYKien() %></td>
				</tr>
				
				<%
					if (type.equals(Constants.CONG_DAN) ){
						if (yKienTraoDoi.getNoiLuuTruId() != null && yKienTraoDoi.getNoiLuuTruId() >0){
				%>
					<tr>
					     <td><label class="egov-label-bold">Văn bản:</label></td>
					    <td><a href="<%=url%>">
								 
						 		Xem văn bản đính kèm</td>
					</tr>
				<%
					}}
				%>
				
				<tr>
					<td colspan="6" align="center">
						<portlet:renderURL  var="urlTraLoi" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
			 				<portlet:param name="hoSoTTHCCongId" value="<%=String.valueOf(hoSoTTHCCongId)%>" />
			 				<portlet:param name="nguoiGuiId" value="<%=String.valueOf(yKienTraoDoi.getNguoiGuiId())%>" />
			 				<portlet:param name="type" value="<%=String.valueOf(type)%>" />
			 				<portlet:param name="yKienTraoDoiId" value="<%=String.valueOf(yKienTraoDoi.getId())%>" />
			 				<portlet:param name="quayLai" value="<%=String.valueOf(urlQuaylai)%>" />
			 				<portlet:param name="loaiCanBo" value="<%=loaiCanBo %>" />
							<portlet:param name="jspPage" value="/html/cmon/ykientraodoi/canbo_traodoi_form.jsp" />
						</portlet:renderURL>
						<% 
							if (taiKhoanNguoiDung.getId() != taiKhoanNguoiDung1.getId()){
								
						%>
						
							<input type="button" class="egov-button" name="traodoi"  id="traodoi" 
								value="Trả lời " 	 onclick="sendRedirect('<%= urlTraLoi%>')"/>	
						<% }%>	
							
				<a	href="<%=backUrl.toString()%>" ><input type="button" class="egov-button" name="cancel"  id="cancel" 
					value="Quay lại" 	/>	</a>			
							
					</td>	
							
				</tr>
			</table>
		
		<br />
		
</div>
</form>		
<script type="text/javascript">
function sendRedirect(url) {
	window.location = url;
}
function confirmDelete(){
	return confirm("Bạn có chắc chắn muốn xóa ý kiến này không ?");
}

	
	
</script>