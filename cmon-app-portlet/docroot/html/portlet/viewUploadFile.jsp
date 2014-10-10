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
<%@page import="vn.dtt.sharedservice.cmon.consumer.document.IDocumentService"%>
<%@page import="org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="org.apache.commons.lang.ObjectUtils.Null"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.timhoso.portlet.utils.TimHoSoUtils"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page
	import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>

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
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page
	import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
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


<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>

<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.Date"%>

<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/css-citizen.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/css-citizen-transaction.css"
	type="text/css" media="screen" />

<script src="<%=request.getContextPath()%>/js/jquery-migrate-1.2.1.min.js"
	type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery.uniform.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.fancybox-1.3.4.pack.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/js-citizen.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/js_citizen_transaction.js"
	type="text/javascript"></script>
</head>


<%


String id_danh_sach_ho_so = "";
if (request.getParameter(Constants.HO_SO_HANH_CHINH_CONG_ID) != null) {
	id_danh_sach_ho_so = request.getParameter(Constants.HO_SO_HANH_CHINH_CONG_ID).toString();
}
if (Validator.isNull(id_danh_sach_ho_so)) {
	id_danh_sach_ho_so = ParamUtil.getString(request, "hoSoTTHCCongId");
}

FileDinhKem taiLieuChungThucId = null;
List<FileDinhKem> listDinhKems = FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(ConvertUtil.convertToLong(id_danh_sach_ho_so));
if (listDinhKems.size() == 0) {
	listDinhKems = FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(ConvertUtil.convertToLong(id_danh_sach_ho_so));
}

int dsFileCnt = 0;
if (listDinhKems != null) dsFileCnt = listDinhKems.size();


IDocumentService iDocumentService = WebserviceFactory.getDocService();

HoSoTTHCCong hoSoTTHCCong = null;
if (id_danh_sach_ho_so.trim().length() > 0 && ConvertUtil.convertToLong(id_danh_sach_ho_so) > 0) {
	hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(id_danh_sach_ho_so));
}
%>

<div id="wd-content-container" style="min-width: 80px;">
	<div class="wd-center">
		<div id="wd-register-business">
			<div class="wd-register-form-01 wd-register-form-02 wd-register-form-04" style="padding-top: 0px;">
				<table  align="center" style="width: 100%">
					<tr style="background-color: #3A88CB;">
						<td width="8%" valign="middle" style="text-align:center; color:white;"><strong>STT</strong></td>
						<td width="92%"  style="text-align:center; color:white;"><strong>Tên thành phần hồ sơ</strong></td>
					</tr>
					<%
					int counter = 1;
					for (int i = 0; i < dsFileCnt; i++) {
						taiLieuChungThucId = (FileDinhKem)listDinhKems.get(i); 
						if (taiLieuChungThucId != null && taiLieuChungThucId.getNoiLuuTruTaiLieuId() != null && taiLieuChungThucId.getNoiLuuTruTaiLieuId() > 0) {
							vn.dtt.sharedservice.cmon.consumer.document.TaiLieuDinhKem _taiLieuDinhKem = iDocumentService.getTailieuDinhKemBoiId(ConvertUtil.convertToLong(taiLieuChungThucId.getNoiLuuTruTaiLieuId() + ""));
							if (_taiLieuDinhKem != null) {
								%>
								<tr>
									<td> <%= counter++ %> </td>
									<td style="text-align: left;"><a href="<%=_taiLieuDinhKem.getUrl()%>"><%=_taiLieuDinhKem.getTen() %></a></td>
								</tr>
								<%
							} else {
								
							}
						}
					}
					%>
				</table>
				
			</div>
		</div>
	</div>
</div>

<br>
<p class="fs16"><label class="egov-label-bold">Thành phần khác:</label>
<table class="egov-table-form"  style="margin-top:10px; background-color: white; border: 0px solid #D3D3D3;" border="0" >
	<tr>
		<td width="70%" style="border: 0px solid #D3D3D3;"></td>
		<td width="30%" style="border: 0px solid #D3D3D3;"></td>
	</tr>
	<tr>
		<td colspan="2" style="border: 0px solid #D3D3D3;">
			<label class="egov-label" style="text-align:left;">Mô tả giấy tờ :</label> 
				<label class="egov-label"><%= hoSoTTHCCong==null? "": hoSoTTHCCong.getMoTaThanhPhanHoSo()%></label>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="border: 0px solid #D3D3D3;">
			<label class="egov-label" style="text-align:left;">Liên kết tải giấy tờ :</label> 
				<a href="<%= hoSoTTHCCong==null? "#": hoSoTTHCCong.getLienKetThanhPhanHoSo()%>">
					<%= hoSoTTHCCong==null? "": hoSoTTHCCong.getLienKetThanhPhanHoSo()%>
				</a>
		</td>
	</tr>
</table>


<script type = "text/javascript">


	function closeAuiPopUp(){
			top.document.getElementById('closethick').click();
	}	

	
</script>