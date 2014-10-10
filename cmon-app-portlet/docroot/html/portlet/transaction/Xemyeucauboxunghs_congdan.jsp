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
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="java.util.Collections"%>
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
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<%@page pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/css-citizen.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/css-citizen-transaction.css"
	type="text/css" media="screen" />

<script src="<%=request.getContextPath()%>/js/egov-common.js"
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
<%
	long idHoSo = ParamUtil.getLong(request, "idHoSo");
	List<YKienTraoDoi> listYkien = null;
	String noidung = "";
	String url = null;
	String tentailieu = "";
	long idTableNoiLuuTru = 0L;
	YKienTraoDoi ykien = null;

	HoSoTTHCCong instance = HoSoTTHCCongLocalServiceUtil
			.fetchHoSoTTHCCong(idHoSo);

	if (instance.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG) {
		listYkien = YKienTraoDoiLocalServiceUtil
				.findYKienByHoSoTTHCCongIdAndLoai(
						idHoSo,
						Constants.LOAI_Y_KIEN_TRAO_DOI.LOAI_YEU_CAU_BO_XUNG_HO_SO);

	} else {
		listYkien = YKienTraoDoiLocalServiceUtil
				.findYKienByHoSoTTHCCongIdAndLoai(
						idHoSo,
						Constants.LOAI_Y_KIEN_TRAO_DOI.LOAI_DUNG_XU_LY_HO_SO);
	}

	if (listYkien != null) {
		if (listYkien.size() > 0) {
			if (listYkien.size() > 0)
				ykien = listYkien.get(0);

			if (ykien != null) {
				// mart the content is read
				ykien.setTrangThai(1);
				YKienTraoDoiLocalServiceUtil.updateYKienTraoDoi(ykien);
				
				try {
					noidung = ykien.getNoiDungYKien();

					if (ykien.getNoiLuuTruId() != null) {
						url = WebserviceFactory
								.getOfficerService()
								.getURLCuaGiayToDinhKem(
										ykien.getNoiLuuTruId());

						idTableNoiLuuTru = ykien
								.getNoiLuuTruId().longValue();
						TaiLieuChungThuc tailieu = TaiLieuChungThucLocalServiceUtil
								.getTaiLieuChungThuc(idTableNoiLuuTru);

						if (tailieu != null) {
							/* 	         							try
							 {
							 url = WebserviceFactory.getOfficerService().getURLCuaGiayToDinhKem(Long.valueOf(tailieu.getNoiLuuTruId())); //data test noi luu tru tai lieu ID 278866L

							 }
							 catch(Exception ex)
							 {
							 
							 ex.printStackTrace();
							 } */

							tentailieu = tailieu.getTen();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		}
	}

	String schemaName = instance.getMaUngDung().trim().toLowerCase();
	String transPortletName = renderRequest.getPreferences().getValue(
			schemaName + "Name", "");
	ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil
			.fetchThuTucHanhChinh(instance.getThuTucHanhChinhId());
	String backURL = HSRParamUtil.getString(request, "backURL");
	
%>
	<liferay-portlet:renderURL
	 	plid="<%=PortalUtil.getPlidFromPortletId(
						themeDisplay.getScopeGroupId(), transPortletName)%>" 
		portletName="<%=transPortletName%>"
		var="boSungURL">
	   <liferay-portlet:param name="<%=TransactionUtils.PARAM_PORTLET_NAME%>" value="<%=schemaName%>"/>
	   <liferay-portlet:param name="<%=TransactionUtils.PARAM_ID%>" value="<%=String.valueOf(instance.getId())%>"/>
	   <liferay-portlet:param name="<%=TransactionUtils.PARAM_ID_QUY_TRINH%>" value="<%=String.valueOf(thuTuc.getId())%>"/>
	   <liferay-portlet:param name="maQuyTrinh" value="<%=thuTuc.getMa()%>" />
	   <liferay-portlet:param name="backURL" value="<%=PortalUtil.getCurrentCompleteURL(request)%>"/>
	</liferay-portlet:renderURL>

<body>
	<div class="egov-container">
		<div><h2  style="width: 100%; text-align: center; padding-top: 30px; font-size: 17px;">THÔNG TIN CHI TIẾT PHẢN HỒI TỪ CÁN BỘ</h2></div>
		<table class="egov-table-form" style="margin: 15px;">
			<%
				if (ykien != null && ykien.getChaiId() != null
						&& ykien.getChaiId() > 0) {
			%>
			<tr>
				<th style="width: 20%;"><label class="egov-label-bold" >Nội dung yêu cầu:</label></th>
				<td  style="padding: 0px;">
					<textarea rows="" cols="" readonly="readonly" style="resize: none; border: medium none; width: 100%; height: auto;"><%=noidung%></textarea></td>
			</tr>
			
			<%
				if (url != null) {
			%>
			<tr>
				<td style="width: 20%;"><label class="egov-label-bold" >Văn bản đính kèm:</label></td> 
			  	<td  ><a href="#" onclick="openWindow('<%=url%>');">Xem tài liệu đính kèm</a></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td style="width: 20%;"></td>
				<td >
					<%
						if ((instance.getLoaiHoSo() == Constants.QuanLiHoSo.TYPE_HOSO_ONLINE) && 
								(instance.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG)) {
					%>
		        	<button type="button" class="egov-button-normal" onclick="location.href='${boSungURL}'">
				        	<liferay-ui:message key="org.oep.html.form.thontinhoso.congdan.button.boxunghoso"/>
			        </button>
			        <%
			        	}
			        %>
			        <button type="button" class="egov-button-normal" onclick="location.href='<%=backURL%>'">
			        	<liferay-ui:message key="org.oep.html.form.thontinhoso.congdan.button.quaylai"/>
			        </button>
				</td>
			</tr>				
			<%
				} else {
			%>			
			<tr>
				<td style="width: 20%;"></td>
				<td >
					<p style=" margin-bottom: 20px !important;">Hồ sơ đang đợi cán bộ một cửa xử lý</p>
					
		        	<button type="button" class="egov-button-normal" onclick="location.href='<%=backURL%>'">
		        		<liferay-ui:message key="org.oep.html.form.thontinhoso.congdan.button.quaylai"/>
		        	</button>
   				</td>
			</tr>		
			<%
				}
			%>
		</table>
	</div>
</body>
<script type="text/javascript">
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
	
	$(document).ready( function( ) {

	    $("textarea").each( function( i, el ) {
	        $(el).height( el.scrollHeight );
	    ​});

	});
</script>
