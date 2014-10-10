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
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<%@page pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<head>
</head>
<%
    long idHoSo =0;
	List<YKienTraoDoi> listYkien = null;
    String noidung ="";
    String url ="";
    String nameFile ="";
    String tentailieu ="";
    YKienTraoDoi ykien =null;
    
    if(ParamUtil.getLong(request, "idHoSo") !=0)
    {
    	idHoSo = ParamUtil.getLong(request, "idHoSo");
    	try
    	{
        	listYkien = YKienTraoDoiLocalServiceUtil.findByHoSoTTHCCongIdAndLoai(idHoSo,Constants.LOAI_Y_KIEN_TRAO_DOI.LOAI_YEU_CAU_BO_XUNG_HO_SO); //findByHoSoTTHCCongId(idHoSo);
        	
        	if(listYkien != null)
        	{
        		if(listYkien.size() >0)
        		{
         			Collections.sort(listYkien);
         		     ykien = listYkien.get(listYkien.size() -1);
         		
         			if(ykien != null)
         			{
         				try
         				{
         					noidung = ykien.getNoiDungYKien();
         					url = WebserviceFactory.getOfficerService().getURLCuaGiayToDinhKem(TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(ykien.getNoiLuuTruId()).getNoiLuuTruId()); //data test noi luu tru tai lieu ID 278866L
         	        		tentailieu = TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(ykien.getNoiLuuTruId()).getTen();
         				}
         				catch (Exception e)
         				{
         					e.printStackTrace();
         				}
         		    }
        	    }
    		}
        	
			if(url != null)
			{
				if(!url.trim().isEmpty())
				{
			       nameFile = url;		
				}
			}	
    	}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    }  
%>
<body>
	<div class="egov-container">
		<div
			style="height: 26px; padding-left: 20px; margin-top: 10px; border-color: gray; border-style: solid; border-width: 1px; padding-top: 15px;">
			<span
				style="font-family: Arial; font-size: 18px; font-weight: bold; font-style: normal; text-decoration: none; color: #333333;"><liferay-ui:message key="org.oep.html.boxunghoso.title" /></span> 
		</div>
		<br /> <br />
		<table align="center" border="0" class="egov-table-form"
			style="width: 100%">
			<tr>
				<td><label class="egov-label-bold"><liferay-ui:message key="org.oep.html.boxunghoso.ykien" /></label></td>
				<td colspan="3"><span
					style="padding-left: 50px; font-family: Arial; font-size: 13px; font-weight: normal; font-style: normal; text-decoration: none; color: #333333;"><%=noidung%></span></td>
			</tr>
			<tr>
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.html.boxunghoso.vanban" /></label></td>
				<td colspan="2"><a href="#" target="_blank"
					onclick="openWindow('<%=url%>')"><%=tentailieu %></a></td> 
			</tr>
			<tr>
				<td colspan="4">
					<div align="left">
						<br /> 	<a href = "javascript:history.back()">
     						 <input type="button" id="<portlet:namespace/>_back" value="<liferay-ui:message key="org.oep.html.form.thontinhoso.congdan.button.quaylai"/>" class="egov-button-normal">
    					 </a>	
					</div>
				</td>
			</tr>
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
</script>
