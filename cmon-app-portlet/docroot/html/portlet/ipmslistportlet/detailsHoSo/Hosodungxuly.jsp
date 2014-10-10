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
<%@page import="java.util.ArrayList"%>
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
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="javax.portlet.PortletURL"%> 
<script src="<%=request.getContextPath() %>/js/customEgovTheme.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/customEgovTheme.css" />
<portlet:defineObjects />
<liferay-theme:defineObjects />
<head>
</head>
<body>

<%

	long id_hoso =0;
	String accountCanBo ="";
	User currentUser = null;
	long congDanId =0;
	long tKCongdanId = 0;
	HoSoTTHCCong instance = null;
	int isOnline =0;
	 String urlQuayLaiViewShare =""; 
	 String urlQuayLaiList ="";
	
	//it can user for 2 opiton go to : 1: list ,2 :view detail information
	//User list
	if (ParamUtil.getString(request, "ulrRollBack") != null) {
		if(!ParamUtil.getString(request, "ulrRollBack").isEmpty())
		{
			urlQuayLaiViewShare  = ParamUtil.getString(request, "ulrRollBack");
		}
	}
	urlQuayLaiList  = ParamUtil.getString(request, "urlQuayLaiList");
	
	if(ParamUtil.getLong(request, "idHoSo") != 0)
	  {
		  id_hoso = ParamUtil.getLong(request, "idHoSo");
	  }

	  try
	  {
	  	instance =HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(id_hoso); // TransactionUtils.getHoSoTTHCCong(id_hoso);
	  
	  	if(instance.getLoaiHoSo() == Constants.INACTIVE)
	  	{
	  	  	isOnline =1;
	  	}	
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
			String nguoinhan = "";
			String nguoitra = "";
			String thoigianTra = "";
			int statusHoSo = -1;
			int traTrucTuyen = 1;
			int traTrucTiep = 0;
			String loaiCanBo = "";
		    //String urlQuayLaiListCanBo ="";
		   
		    
			if (ParamUtil.getString(request, "loaiCanBo") != null) {
				if(!ParamUtil.getString(request, "loaiCanBo").isEmpty())
				{
					loaiCanBo = ParamUtil.getString(request, "loaiCanBo");
				}
			}
			
			/*
			if (ParamUtil.getString(request, "urlQuayLai") != null) {
				urlQuayLaiListCanBo = ParamUtil.getString(request, "urlQuayLai");
			}
			*/
			//
			//instance =HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(id_hoso);
			if(instance.getTenCanBoTiepNhan() != null)
				nguoinhan = instance.getTenCanBoTiepNhan();
			
			if(instance.getTenCanBoTraKetQua() != null)
				nguoitra = instance.getTenCanBoTraKetQua();
		
			if (instance.getNgayTraKetQua() != null)
				thoigianTra = ConvertUtil.parseDateToTring(instance
						.getNgayTraKetQua());
		
			statusHoSo = instance.getTrangThaiHoSo();
			//Store list status of ho so for view tai lieu trong qua trinh xu ly
			List<Integer> listStatusThanhPhan = new ArrayList<Integer>();
		
			listStatusThanhPhan.add(Integer
					.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN));
			listStatusThanhPhan.add(Integer
					.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG));
			listStatusThanhPhan.add(Integer
					.valueOf(Constants.TRANGTHAIHOSO.HO_SO_KHONG_TIEP_NHAN));
			listStatusThanhPhan.add(Integer
					.valueOf(Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG));
			listStatusThanhPhan.add(Integer
					.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DA_BO_XUNG_CHO_TN));
			listStatusThanhPhan.add(Integer
					.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DA_TRA_KET_QUA));
			
			//Xử lý liên kết với porlet khác
			String transType = ParamUtil.getString(request, "transType","");
			String currentTransPage = ParamUtil.getString(request, "currentTransPage","");
			String transactionKeyword = ParamUtil.getString(request, "transactionKeyword","");
			String CanBoXuLyHienThoiId =  null;
		  %>
		<!-- link xem don dang ki -->
			<%
			long transPortletId = 0; 
			
			String transPortletName = "";
			String schemaName =instance.getMaUngDung().trim().toLowerCase();
			String maQuyTrinh="";
			String delimiter = "_";
			
			//schemaName ="dkkd";// schemaName.split(delimiter);
			//transPortletId = Long.parseLong(prefs.getValue(schemaName+"Id","0"));
			
			transPortletName = renderRequest.getPreferences().getValue(schemaName+"Name","");
			ThuTucHanhChinh thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(instance.getThuTucHanhChinhId());
			if(thuTucHanhChinh !=null) {
				maQuyTrinh = thuTucHanhChinh.getMa();
			}
			
			%>
		 
		<portlet:renderURL var="urlViewShare">
		<portlet:param name="idHoSo"
		value="<%=String.valueOf(id_hoso)%>" />
		<portlet:param name="loaiCanBo" value="<%=loaiCanBo%>" />
	    <portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp" />
		<portlet:param name="urlQuayLai" value="<%=urlQuayLaiViewShare.toString()%>"></portlet:param>	
   		</portlet:renderURL>	
   		 
   		<liferay-portlet:renderURL plid="<%=PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), transPortletName)%>" 
			portletName="<%=transPortletName%>" var="LINK">
			<liferay-portlet:param
				name="<%=TransactionUtils.PARAM_PORTLET_NAME%>"
				value="<%=schemaName%>" />
			<liferay-portlet:param name="<%=TransactionUtils.PARAM_ID%>"
				value="<%=String.valueOf(instance.getId())%>" />
			<liferay-portlet:param
				name="<%=TransactionUtils.PARAM_ID_QUY_TRINH%>"
				value="<%=String.valueOf(instance.getThuTucHanhChinhId())%>" />
			<liferay-portlet:param name="maQuyTrinh" value="<%=maQuyTrinh%>" />
			<liferay-portlet:param name="backURL" value="<%=PortalUtil.getCurrentCompleteURL(request)%>" />
		</liferay-portlet:renderURL>

	<portlet:actionURL var="urldungXuLyHoSo" name="dungXuLyHoSo">
		<portlet:param name="urlQuayLaiList" value="<%=urlQuayLaiList %>" />
	</portlet:actionURL>
	
	<div class="egov-container" id="text">
		<form action="<%=urldungXuLyHoSo%>" method="post" enctype="multipart/form-data" name="uploadphieu" id="uploadphieu" >
		    <input type="hidden" name="idHoSoTTHCC" value="<%=id_hoso%>">
		    <h1 align="left" style="padding-top: 20px;font-size: 16px;"><liferay-ui:message key="org.oep.html.form.thontinhoso.thogntinchung" /></h1>
					
		    	    		
			<table border="0" class="egov-table-form" style="width: 98%">
			<tr>
				<td><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.html.form.thontinhoso.tendichvucong" /> </label></td>
				<td colspan="3" class="egov-label-bold"><%=instance.getTenThuTucHanhChinh()%>
				</td>
			</tr>
			<tr>
				<td><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.html.form.thontinhoso.nguoinophoso" /></label></td>
				<td colspan="3" class="egov-label-bold"><%=instance.getHoTenNguoiNopHoSo()%>
				</td>
			</tr>
			<tr>
				<td><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.html.form.thontinhoso.ngaynophoso" /></label></td>
				<td><%=instance.getNgayNopHoSo() == null ? "" : ConvertUtil
								.parseDateToTring(instance.getNgayNopHoSo())%>
				</td>
			</tr>
			<tr>
				<td><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.html.form.thontinhoso.trangthai" /></label></td>
				<td colspan="3" class="egov-label-bold"><%=TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(
								instance.getTrangThaiHoSo()).getTrangThai()%>
				</td>
			</tr>
			<%
			    if(isOnline == Constants.ACTIVE)
			    {
			    %>
			    <tr>
				<td><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.html.form.thontinhoso.dondangkitructuyen" /></label></td>
				<td class="egov-label-bold"><a href="<%=LINK%>"><liferay-ui:message
							key="org.oep.html.form.thontinhoso.xemdondangki" /></a></td>
				<td colspan="2" class="egov-label-bold"><em><liferay-ui:message
						key="org.oep.html.form.thontinhoso.message.xemdondangki" /></em></td>
			</tr>
			    <%	
			    }
			%>
				<%
					StringBuilder idFileImage = new StringBuilder();
					List<FileDinhKem> lFileUploads = FileDinhKemLocalServiceUtil
							.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(instance.getId());
					TaiLieuChungThuc taiLieuChungThuc = null;
					String urlPhanChinh ="";
				%>                  
				<%
					int i = 1;
					if (lFileUploads != null) {
						if(lFileUploads.size() >0)
						{
						%>
						<tr>
							<td colspan="2">
							<label class="egov-label-bold"><liferay-ui:message
										key="org.oep.html.form.thontinhoso.thanhphantheoquidinh" /></label>
							</td>
							<td colspan="2">
							<span style="font-style: italic;"><liferay-ui:message
										key="org.oep.html.form.thontinhoso.message.xemthanhphanhoso" /></span>
							</td>
						</tr>
						<%
						for (FileDinhKem fileUpload : lFileUploads) {
							if(fileUpload.getNoiLuuTruTaiLieuId()!= null)
							{
							taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(fileUpload.getNoiLuuTruTaiLieuId().longValue()); // ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							
							if (taiLieuChungThuc != null) {
								try
								{
							    	urlPhanChinh =WebserviceFactory.getOfficerService().getURLCuaGiayToDinhKem(taiLieuChungThuc.getNoiLuuTruId());
								}
								catch (Exception e)
								{
									e.printStackTrace();
								}
						%>
							<tr>
								<td colspan="4" style="padding-left: 30px;"><%=i++%> . <a href="<%=urlPhanChinh%>"><%=taiLieuChungThuc.getTen()%></a>
								</td>
							</tr>
						<%
									}
								}
				  			}
						}	
					}
				%>
				
    <!-- Y kiến cán bộ dừng xử lý hồ sơ -->
      	<tr>
		    <td colspan="4"><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.html.form.thontinhoso.hoantat.ykiencanbo"></liferay-ui:message></label></td>
		  </tr>
		  <tr>
		    <td colspan="4">
		    	<textarea style="display: block; height: 160px;width: 100%" name="ykiencanbo" id="ykiencanbo"></textarea>
		    </td>
		  </tr>
		  <tr>
		    <td colspan="4"><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.html.form.thontinhoso.hoantat.congvantraloi"></liferay-ui:message></label></td>
		  </tr>
		  <tr>
		    <td colspan="4">
		       <input  size="40" class="egov-uploadfile"  type="file" name="upLoadDungXuLy"   id="upLoadDungXuLy"/>
		    </td>
		 </tr>
    				
	<!-- View button on page -->
	<tr>
	 <td colspan="4">
	  <br/>
					  <input type="submit" class="egov-button-normal"
					value="Hoàn tất dừng xử lý" />
					
					<portlet:renderURL var="urlLutailieu">
						<portlet:param name="HosotthcCongId"
							value="<%=String.valueOf(id_hoso)%>" />
						<portlet:param name="backUrl"
							value="/html/portlet/ipmslistportlet/detailsHoSo/viewDetails_hoSo.jsp" />
						<portlet:param name="jspPage" value="/html/cmon/upload/dangxuly_upload_form.jsp" />	
	   			   </portlet:renderURL>		   
	 
					<a href="<%=urlLutailieu%>"> <input type="button" class="egov-button-normal"
					  value="Lưu tài liệu" />
					</a>
					
					<portlet:renderURL var="urlXemTienTrinhXuLy">
						<portlet:param name="idHoSo"
							value="<%=String.valueOf(id_hoso)%>" />
						<portlet:param name="jspPage" value="" />	
				   </portlet:renderURL>		   
				   
					<input type="button" class="egov-button-normal" id="<%= instance.getMaSoHoSo()%>" name="viewProcessButtonName" value="Xem tiến trình xử lý" />  
			 		
			 		<a href="<%=urlQuayLaiViewShare%>"><input
					type="button" id="<portlet:namespace/>_back" value="Quay lại"
					class="egov-button-normal"></a>
		</td>
	</tr>
</table>	    
</form>
</div>

<script type="text/javascript">
	$(document).ready(
			function () {
				var  title = $('#title').val();
				$('.portlet-title-text').text(title);	
			}
			
			
			);
	/*
	function checkUpload() {		
		var value = $('#dataUpload').val().length;
		if (value == 0) {
			alert("Vui lòng chọn file ảnh để tải lên!");
			return false;
			
		} else {
			var ext = $('#dataUpload').val().split('.').pop().toLowerCase();		
			if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
			    alert('Vui lòng chọn tệp tin kiểu ảnh!');
			    return false;
			}
			return true;
		}		
	}
	*/
	function openWindow(url) {
		var newWindow = window.open(url,
						'View image',
						'height=750,width=650,left=90,top=100,resizable=no,location=no,status=no,menubar=yes');

		if (window.focus) {
			newWindow.focus();
		}
		return false;
	}
</script>
<%@ include file="/html/portlet/ipmslistportlet/viewProcess.jsp"%>