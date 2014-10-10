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
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="java.util.List"%>
<%@page
	import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
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
<div class="content-block">
	<div class="header-block">
		<div class="breadcrumb">
			<div class="breadcrumb-title only">
				<h4>
					<span>THỦ TỤC HÀNH CHÍNH</span>
				</h4>
			</div>
		</div>
	</div>
	<!--/header-block-->
	<div class="listgroup-block">
		<div id="dichvucong" class="owl-carousel owl-theme">
		<%
			long idCapCoQuan = 0;
			if(Validator.isNotNull(request.getParameter("idCapCoQuan"))){
				idCapCoQuan = Long.valueOf(request.getParameter("idCapCoQuan").toString());
			}
			List<CoQuanQuanLy> listresult = new ArrayList<CoQuanQuanLy>();
			PortletURL lookupTTHC = renderResponse.createRenderURL();
        	lookupTTHC.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
        	lookupTTHC.setParameter("viewPage","/html/portlet/touchscreen/tthccapcoquan.jsp");
			if(idCapCoQuan!=0){
				listresult = CoQuanQuanLyLocalServiceUtil.findByCapCoQuanQuanLyId(idCapCoQuan, 0);
				float pg = (float) listresult.size()/15;
				int item = (int) Math.ceil(pg);
				for(int i=0;i<item;i++){
		%>
			<div class="item">
			<%
            	int start = ((i+1)-1)*15;
             	int end = (start+15);
             	for(int j=start;j<end;j++){
             		if(j>listresult.size()-1){
             			break;
             		}
             		PortletURL tthcnhomtthc = renderResponse.createRenderURL();
             		tthcnhomtthc.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
             		tthcnhomtthc.setParameter("viewPage","/html/portlet/touchscreen/tthcnhomtthc.jsp");
             		tthcnhomtthc.setParameter("id_donvi",String.valueOf(listresult.get(j).getId()));
             %>
				<div class="khoi-item">
					<a href="<%=tthcnhomtthc.toString()%>"><span><%=listresult.get(j).getTen() %></span></a>
				</div>
				<%} %>
			</div>
			<%}} %>
		</div>
	</div>
	<!--/list-block-->
	<div class="back-button">
		<a href="<%=lookupTTHC.toString()%>">Trở lại</a>
	</div>
</div>