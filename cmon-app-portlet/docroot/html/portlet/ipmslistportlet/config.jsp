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
<%@page import="org.oep.cmon.util.ComUtils"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo"%>
<%@page import="org.oep.egovcore.language.BusinessMessagerUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="org.oep.cmon.Constants" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<%
	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	PortletPreferences portletPrefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
	
	// status config
	String statusPreParam = Constants.QuanLiHoSo.HSTTHCC_CURRENT_STATUS_PREF_PARAM;
	String statusPreParamValue = portletPrefs.getValue(statusPreParam, "");
	
	// request "rut ho so"
	String yeuCauRutValue = portletPrefs.getValue( Constants.QuanLiHoSo.YEU_CAU_RUT, "");
%>
<aui:form action="<%=configurationURL%>" method="post" name="fm" onSubmit="getValue();">
	<input name="<portlet:namespace /><%=com.liferay.portal.kernel.util.Constants.CMD%>" type="hidden" value="<%=com.liferay.portal.kernel.util.Constants.UPDATE%>" />
	<div class="wd-list-transaction wd-list-citizen">
	<fieldset class="wd-list-transaction-form">
		<table class="wd-list-transaction-table">
			<thead>
				<tr>
					<td><liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.stt" /></td>
					<td><liferay-ui:message key="vn.dtt.brms.registry.config.tenUngDung" /></td>
					<td><liferay-ui:message key="vn.dtt.brms.registry.config.tenPortlet" /></td>
					<td><liferay-ui:message key="vn.dtt.brms.registry.config.portletId" /></td>
				</tr>
			</thead>
			<tbody>
			<%
				//String portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
					//PortletPreferences resourcePrefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
					List<DanhMucUngDung> ungDungs = DanhMucUngDungLocalServiceUtil.getDSUngDung(0);// ACTIVED
					for (int i=0; i < ungDungs.size(); i++) {
						DanhMucUngDung instance = (DanhMucUngDung) ungDungs.get(i);
						String maUngDung = instance.getMa().trim().toLowerCase();
						String paramName = maUngDung+"Name";
						String paramId = maUngDung+"Id";
						String instancePortletName = portletPrefs.getValue(paramName,"");
						String instancePortletId = portletPrefs.getValue(paramId,"");
			%>
				<tr>
					<td><%=(i+1)%></td>
					<td><b><%=instance.getTen()%></b></td>
					<td>
						<input type="text" title="<%=instancePortletName%>" value="<%=instancePortletName%>" name="<portlet:namespace /><%=paramName%>" />
					</td>
					<td>
						<input type="text" title="<%=instancePortletId%>" value="<%=instancePortletId%>" name="<portlet:namespace /><%=paramId%>" />
					</td>
				</tr>	
				<%
						}
					%>
			</tbody>
		</table>
	</fieldset>
	</div>

	<br/>
	<p>Cấu hình xử lý hồ sơ</p>
	<div class="wd-list-transaction wd-list-citizen">
		<fieldset class="wd-list-transaction-form">
			<%
				//portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
					//resourcePrefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
					String processingProfilePrefParam = org.oep.cmon.Constants.XuLyHoSo.PROCESSING_PROFILE_PREF_PARAM;
					String processingProfilePrefValue = portletPrefs.getValue(processingProfilePrefParam,"");
			%>
				<select name="<%=processingProfilePrefParam%>">
					<aui:option value="other" selected="<%=processingProfilePrefValue.equals(\"other\")%>">Cán bộ một cửa</aui:option>
					<aui:option value="processingProfile" selected="<%=processingProfilePrefValue.equals(\"processingProfile\")%>">Cán bộ xử lý</aui:option>
				</select>
		</fieldset>
	</div>
	<br/>
	
	<p>Vai Trò</p>
	<div class="VaiTro">
		<fieldset class="vai-tro">
			<%
				//portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
					//resourcePrefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
					String processingLanhDaoParam = org.oep.cmon.Constants.CanBoXuLy.PROCESSING_CAN_BO_PREF_PARAM;
					String processingLanhDaoValue = portletPrefs.getValue(processingLanhDaoParam,"");
			%>
				<select name="<%=processingLanhDaoParam%>">
					<aui:option value="<%=Constants.CanBoXuLy.LANH_DAO %>" selected="<%= processingLanhDaoValue.equals(Constants.CanBoXuLy.LANH_DAO)%>">Lãnh đạo</aui:option>
					<aui:option value="<%=Constants.CanBoXuLy.NHAN_VIEN %>" selected="<%= processingLanhDaoValue.equals(Constants.CanBoXuLy.NHAN_VIEN)%>">Nhân viên</aui:option>
				</select>
		</fieldset>
	</div>
	
	
	<br/>
	
	<p>Cấu hình trạng thái hồ sơ</p>
	<div class="wd-list-transaction wd-list-citizen">
		<fieldset class="wd-list-transaction-form">
<%-- 				<select name="<%= statusPreParam %>" >
			    	<option value="-1">
						<!-- <liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.filter" /> -->
						Chọn trạng thái hồ sơ
					</option>	
			    	<%				    	
			    		List<TrangThaiHoSo> listThaiHoSos = TrangThaiHoSoLocalServiceUtil.getListTrangThaiHoSo(0);
			    		for (TrangThaiHoSo trangThaiHoSo2 : listThaiHoSos) {
			    	%>
						<option <%=statusPreParamValue.equals(String.valueOf(trangThaiHoSo2.getId()))? "selected":""%> value="<%=trangThaiHoSo2.getId()%>" >
							<%=trangThaiHoSo2.getTrangThai()%>	 							
						</option>					    
						<%
					    } 
					    %>
		    	</select> --%>
		    	
				    <%				    	
				    	String[] statusArray = statusPreParamValue.split(",");
			    		List<TrangThaiHoSo> listThaiHoSos = TrangThaiHoSoLocalServiceUtil.getListTrangThaiHoSo(0);
			    		for (TrangThaiHoSo trangThaiHoSo2 : listThaiHoSos) {
			    	%>
						<input type="checkbox" <%=ComUtils.checkValueInArray(statusArray, trangThaiHoSo2.getId())? "checked=\"checked\"":""%> value="<%=trangThaiHoSo2.getId()%>" class="STATUS-HS"> <%=trangThaiHoSo2.getTrangThai()%></input><br>    
						<%
					    } 
					    %>
					    
					    <input type="checkbox" <%="on".equals(yeuCauRutValue)? "checked=\"checked\"":""%> name="yeucaurut"> Yêu cầu rút</input><br>
					    
		    	<input type="hidden" name="<%= statusPreParam %>" id="statusValue" value="<%=statusPreParamValue%>">
		</fieldset>
	</div>
	<br/>
	
	<aui:button-row>
		<aui:button type="submit" value="<%=LanguageUtil.get(pageContext, \"vn.dtt.brms.registry.viewTransaction.config.save\")%>" />
	</aui:button-row>
</aui:form>

<script>
function getValue() {
	var status = "";
	$('.STATUS-HS').each(function () {
        if (this.checked) {
            status += $(this).val() + ",";
        }
	});
	
	if (status.length > 0) {
		$("#statusValue").val(status.substring(0, status.length - 1));
	} else {
		$("#statusValue").val(status);
	}
	
}
</script>