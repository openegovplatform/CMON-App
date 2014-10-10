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
<%@page import="org.oep.cmon.dao.dvc.service.CauHinhPortlet2ThuTucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc"%>
<%@page import="org.oep.cmon.portlet.document.business.DanhMucGiayToBusiness"%>
<%@page import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
		
	String tthcId = ParamUtil.getString(request,"tthcId");
	
	CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc =null;
	if (tthcId !=null && FormatUtil.convertToLong(tthcId) >0){
		cauHinhPortlet2ThuTuc = CauHinhPortlet2ThuTucLocalServiceUtil.fetchCauHinhPortlet2ThuTuc(FormatUtil.convertToLong(tthcId));
	}
	
	PortletURL updatePortlet2TTHC = renderResponse.createActionURL();
	updatePortlet2TTHC.setParameter(ActionRequest.ACTION_NAME, "updatePortlet2TTHC");	

%>
<form name="<portlet:namespace/>searchTTHCForm" method="post" action="<%=updatePortlet2TTHC%>" >
<br>
<table   cellpadding="0" cellspacing="0" class="egov-table-form" style="width: 100%;table-layout: fixed;">
	<tbody>
		<tr>
			<input type="hidden" value="<%=tthcId %>" name="tthcId"/>
			<td>
					<label class ="egov-label-bold">Tên portlet: </label>
					
					<input type="text"  name="portletName" id="portletName" value="	<%if (cauHinhPortlet2ThuTuc !=null){ %><%=cauHinhPortlet2ThuTuc.getPortletName()%> <%} %>" class="egov-inputfield"  style="width:95%;" />	
					
			</td>
			<td >
			
			</td>
		</tr>
		<tr>
			<td >			
			<input type="submit" class="egov-button-normal" value="Ghi lại" ></td>
		</tr>
		 <tr>
			<td align="right" width="60%">			
			</td>
		</tr>
	</tbody>
</table>
</form>



<script type="text/javascript">
function <portlet:namespace/>deleteRow(url) {
	var answer = confirm('<%=LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.tthc.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}
function <portlet:namespace/>checkForm(){
	var form = document.<portlet:namespace/>searchTTHCForm;
	
	if (form.ungDung.options.selectedIndex > 0){
		form.nhomTTHC.options.selectedIndex = 0;
	}

	form.nhomTTHC.options.selectedIndex = 0;
	form.submit();
};
</script>
