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
<%@page import="org.oep.cmon.util.CmonFields"%>
<%@page import="org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.document.util.DocumentConstants.TTHC2CQQL"%>
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

<%
	long id_hoso =0;
	String accountCanBo ="";
	User currentUser = PortalUtil.getUser(request);
	long congDanId =0;
	long tKCongdanId = 0;
	HoSoTTHCCong instance = null;
	int isOnline =0;//Trang thai ho so online
	String urlQuayLaiListCanBo ="";
	int haveProcess = 1;
	ThuTucHanhChinh thutuchanhchinh = null;
	
	if (ParamUtil.getString(request, CmonFields.backURL) != null) {
		urlQuayLaiListCanBo = ParamUtil.getString(request, CmonFields.backURL);
	}
	
	//if( ParamUtil.getString(request, "accountCanBo") != null)
		//accountCanBo =ParamUtil.getString(request, "accountCanBo");

	if(ParamUtil.getLong(request, "idHoSo") != 0)
	  {
		  id_hoso = ParamUtil.getLong(request, "idHoSo");	  
	  }
	
	if(ConvertUtil.convertToLong( request.getParameter("idHoSo")) != 0)
	  {
		  id_hoso = ConvertUtil.convertToLong(request.getParameter("idHoSo"));	  
	  }

	try
	  {
	  	instance =HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(id_hoso); // TransactionUtils.getHoSoTTHCCong(id_hoso);
	  	
	  	thutuchanhchinh = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(instance.getThuTucHanhChinhId().longValue());
	  	
/* 	  	if(thutuchanhchinh != null) {
	  		if(thutuchanhchinh.getUengineProcessName().isEmpty()) {
	  			haveProcess = 0;
	  		}
	  	} */
	  	
	  	if(instance.getLoaiHoSo() == Constants.INACTIVE)
	  	{
	  	  	isOnline =1;  
	  	}	
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	
	
	  List<YKienTraoDoi> ykienHoanTatDungXuLy = null;
	  String noidungDungXuLy = "";
	  String urlFileDungXuLy ="";
	  String nameFileDungXuLy ="";
	  
	  if(instance.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG)
	  {
		 if(instance.getDungXuLy() == true)
		 { 
	 try
	 {
		   	    ykienHoanTatDungXuLy  = YKienTraoDoiLocalServiceUtil.findByHoSoTTHCCongIdAndLoai(id_hoso, Constants.LOAI_Y_KIEN_TRAO_DOI.LOAI_DUNG_XU_LY_HO_SO);
	 }
	 catch (Exception e)
	 {
		 e.printStackTrace();
	 }
	 
	 if(ykienHoanTatDungXuLy != null)
	 {
		 if(ykienHoanTatDungXuLy.size() > 0)
		 {
	       	YKienTraoDoi ykien = ykienHoanTatDungXuLy.get(0);
	       	noidungDungXuLy = ykien.getNoiDungYKien();
	       	TaiLieuChungThuc tailieu= null;
	       	
	       	try
	       	{
	       		tailieu = TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(ykien.getNoiLuuTruId());
	       	}
	       	catch(Exception e)
	       	{
	
	       		e.printStackTrace();
	       	}
	       	if(tailieu != null)
	       	{
	       		try
	       		{
	       	   		urlFileDungXuLy = WebserviceFactory.getOfficerService().getURLCuaGiayToDinhKem(tailieu.getNoiLuuTruId());
	       		}
	       		catch (Exception ex)
	       		{
	       		  	
	       		}
	       		
	       		nameFileDungXuLy = tailieu.getTen();
	       	}	
		 }
	 }
		 }  
	  }
	  //Check nop phi

	  
	  /*
	  if( PortalUtil.getUser(request) != null)
	  	user = PortalUtil.getUser(request);
	  
       String portalUrl = PortalUtil.getPortalURL(request);
       
    	List<TaiKhoanNguoiDung> taiKhoanNguoiDungs = null;
    	 
    	if(instance != null)
    		congDanId = instance.getCongDanNopId();
    	    	
    	if (congDanId > 0 ){
	 		CongDan congDan = CongDanLocalServiceUtil.getCongDan(congDanId); // ConvertUtil.findCongDanById(congDanId);
	 		if(congDan != null){
	 			tKCongdanId= congDan.getTaiKhoanNguoiDungId() == null ? 0 : congDan.getTaiKhoanNguoiDungId() ;
	 			if(tKCongdanId  ==  0){
	 			}
	 		}
    	}
    	
    	String status ; 
		String maHoSo = instance.getMaSoHoSo(); 
	   // String actionName = ParamUtil.getString(request, "actionName");
	   */
%>
<body>

	<portlet:actionURL var="tiepNhanHoSo" name="tiepNhanHoSo">
		<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp" />
		<liferay-portlet:param name="accountCanBo" value="<%=currentUser.getEmailAddress()%>" />
		
		<portlet:param name="urlQuayLai" value="<%=urlQuayLaiListCanBo%>" />
	</portlet:actionURL>
	<div class="egov-container" id="text">
	<aui:form action="<%=tiepNhanHoSo%>" method="POST" name="myForm" id="myForm">
			<%
				if (instance != null) {
			%>
			<h1 align="left" style="padding-top: 20px;font-size: 16px; margin-top: 0;"><liferay-ui:message key="org.oep.html.form.thontinhoso.thogntinchung" /></h1>
					<%@ include file="/html/portlet/ipmslistportlet/detailsHoSo/viewDetails_hoSo.jsp"%>
	<% } else { %>
	<br />
	<liferay-ui:message
		key="org.oep.brms.registry.viewTransactionDetails.khongCoGiaoDich" />
	<% } %>
	</aui:form>
	<!--  Thong bao -->
	<%
	if (ConvertUtil.getValueString(request, "type_completed_upload_data").length() >0) 
	{
	 %>
	 <table  class="egov-table-form" style="width: 98%">
		<tr>
			<td colspan="4"><label class="egov-label-bold">Mã số
					biên nhận  : <%=instance.getMaSoBienNhan() %></label></td>
		</tr>
		<tr>
			<td colspan="4"><label class="egov-label-bold">Ngày hẹn
					trả  : <%=ConvertUtil.parseDateToTring(instance.getNgayHenTraKetQua())%></label></td>
		</tr>
	</table>
	<%}%>
</div>
	
	<script type="text/javascript">
		function sendRedirect(url) {
			window.location = url;
		}
	</script>
	