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
<%@page import="vn.dtt.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page
	import="vn.dtt.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dao.dvc.model.ThuTucHanhChinh"%>
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
<style>
h3.egov-h-header{
	padding-top:10px;
	padding-bottom: 10px; 
}
.table-form{	
	border-collapse: separate; border-spacing: 10px;text-align: left;
	background: white !important;
}
table.table-form tfoot tr td{
	padding-top: 10px;
}
</style>
<%
String urlRoleBack = request.getParameter("ulrRoleBack");
    long idHoSo =0;
	List<YKienTraoDoi> listYkien = null;
    String noidung ="";
    String url ="";
    String nameFile ="";
    String tentailieu ="";
    YKienTraoDoi ykien =null;
   // TaiLieuChungThuc taiLieuChungThuc =null;
    
    if(ConvertUtil.convertToLong( request.getParameter("idHoSo")) !=0)
    {
    	idHoSo =ConvertUtil.convertToLong( request.getParameter("idHoSo"));
    	System.err.println("idHoSo:" +idHoSo);
    	try
    	{
        	//listYkien = YKienTraoDoiLocalServiceUtil.findByHoSoTTHCCongIdAndLoai(idHoSo,Constants.LOAI_Y_KIEN_TRAO_DOI.LOAI_YEU_CAU_BO_XUNG_HO_SO); //findByHoSoTTHCCongId(idHoSo);
        	//System.err.println("listYkien:" +listYkien.size());
        	listYkien = YKienTraoDoiLocalServiceUtil.findByHoSoTTHCCongId(idHoSo);
        	System.err.println("listYkien:" +listYkien.size());
        		if(listYkien.size() >0)
        		{
         		   ykien = listYkien.get(0);
         			if(ykien != null)
         			{
         				try
         				{
         					noidung = ykien.getNoiDungYKien();
         					 System.err.println("getNoiLuuTruId:" +ykien.getNoiLuuTruId());
         					url = WebserviceFactory.getOfficerService().getURLCuaGiayToDinhKem(ykien.getNoiLuuTruId()); //data test noi luu tru tai lieu ID 278866L
         					 System.err.println("url 000000000000:" +url);
         					
         	        		tentailieu = TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(ykien.getNoiLuuTruId()).getTen();
         	        		//taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(ykien.getNoiLuuTruId());
         	        		
         	        		// System.err.println("tentailieu:" +taiLieuChungThuc.getTen());
         				}
         				catch (Exception e)
         				{
         					e.printStackTrace();
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
	<div class="egov-container">

		<h3 class="egov-label-header egov-h-header"><liferay-ui:message key="vn.dtt.html.boxunghoso.title" /></h3>
		
		<table cellspacing="0" cellpadding="0" width="100%"  class="table-form">
		<tbody>
			<tr>
	     				<td nowrap="nowrap"><label class="egov-label-bold">Ý kiến từ chối tiếp nhận hồ sơ:</label> 
						
						</td>
						<td width="100%"><%=noidung %>
						
						</td>
				</tr>
				
				<tr>
					<td nowrap="nowrap"> <label class="egov-label-bold">
								Văn bản (Công văn) từ chối tiếp nhận hồ sơ:
						</label> 
				      </td>
				     <td> 
				     <%
				     if (ykien!= null){
					     	if (ykien.getNoiLuuTruId() !=null && ykien.getNoiLuuTruId() >0){
				     %>
							<a href="<%=url %>">
								 
								 	<%=tentailieu %>
						 		Xem văn bản từ chối
						 		
						 </a>
						<%}} %>
				      </td> 
				</tr>
	</tbody>
	<tfoot>		
  			<tr>
				<td>
			
						<a href = "javascript:history.back()">
      				<input type="button" id="<portlet:namespace/>_back" value="Quay lại" class="egov-button">
   					  </a>
					
				</td>
			</tr>
	</tfoot>		
			
		</table>
	</div>
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
