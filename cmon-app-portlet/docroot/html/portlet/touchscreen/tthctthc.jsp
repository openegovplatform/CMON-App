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
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionAdminUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
String id_donvi = "";
String idNhomTTHC = "";
List<Long> listIdNhomTTHC = new ArrayList<Long>();
if(Validator.isNotNull(request.getParameter("id_donvi"))){
	id_donvi = request.getParameter("id_donvi");
}
if(Validator.isNotNull(request.getParameter("idNhomTTHC"))){
	idNhomTTHC = request.getParameter("idNhomTTHC");
	listIdNhomTTHC.add(Long.valueOf(idNhomTTHC));
}
List<ThuTucHanhChinh> listresult = new ArrayList<ThuTucHanhChinh>(); 
PortletURL tthcnhomtthc = renderResponse.createRenderURL();
tthcnhomtthc.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
tthcnhomtthc.setParameter("viewPage","/html/portlet/touchscreen/tthcnhomtthc.jsp");
tthcnhomtthc.setParameter("id_donvi",id_donvi);
%>
<div class="content-block">
	<div class="header-block">
		<div class="breadcrumb">
			<div class="breadcrumb-title first">
				<h4>
					<span>THỦ TỤC HÀNH CHÍNH</span>
				</h4>
			</div>
			<div class="breadcrumb-title-1 last">
				<h4>
					<span><%=NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(Long.valueOf(idNhomTTHC)).getTen() %></span>
				</h4>
			</div>
		</div>
	</div>
	<!--/header-block-->

	<div class="listgroup-block">
		<div id="dichvucong" class="owl-carousel owl-theme">
		<%
		if(!id_donvi.equals("0")){
			listresult = ActionAdminUtil.getTTHCByIdNhomTTHC(listIdNhomTTHC, id_donvi);
		}
		float pg = (float) listresult.size()/12;
		int item = (int) Math.ceil(pg);
		for(int i=0;i<item;i++){
		%>
			<div class="item">
			<%
            	int start = ((i+1)-1)*12;
             	int end = (start+12);
             	for(int j=start;j<end;j++){
             		if(j>listresult.size()-1){
             			break;
             		}
             		PortletURL tthcdetails = renderResponse.createRenderURL();
             		tthcdetails.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
             		tthcdetails.setParameter("viewPage","/html/portlet/touchscreen/tthcdetails.jsp");
             		tthcdetails.setParameter("idTTHC",String.valueOf(listresult.get(j).getId()));
             		tthcdetails.setParameter("id_donvi",id_donvi);
             %>
				<div class="list-item">
                	<div class="cont-item">
						<a href="<%=tthcdetails.toString()%>"><p><%=listresult.get(j).getTen() %></p></a>
					</div>
				</div>
			<%} %>
			</div>
		<%} %>
		</div>
	</div>
	<!--/list-block-->
	<div class="back-button">
		<a href="<%=tthcnhomtthc.toString()%>">Trở lại</a>
	</div>
</div>