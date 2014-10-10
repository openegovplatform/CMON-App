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
<%@page import="org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
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
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if(Validator.isNotNull(portletResource)){
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String id_donvi = prefs.getValue("id_donvi","0");
if(Validator.isNotNull(request.getParameter("id_donvi"))){
	id_donvi = request.getParameter("id_donvi");
}
List<CoQuanQuanLy2LinhVuc> listresult = new ArrayList<CoQuanQuanLy2LinhVuc>(); 
if(!id_donvi.equals("0")){
	listresult = CoQuanQuanLy2LinhVucLocalServiceUtil.getLinhvucByIdDonvi(id_donvi);
}
%>
<div class="content-block">
	<div class="header-block">
     	<div class="breadcrumb">
         	<div class="breadcrumb-title only">
                 <h4><span>THỦ TỤC HÀNH CHÍNH&nbsp;<%=CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(id_donvi)).getTen().toUpperCase() %></span></h4>                            
             </div>
         </div>
     </div>
	<div class="list-block">
        <div id="dichvucong" class="owl-carousel owl-theme">
		<%
		float pg = (float) listresult.size()/6;
		int item = (int) Math.ceil(pg);
		for(int i=0;i<item;i++){
		%>
			<div class="item">
			 <%
            	int start = ((i+1)-1)*6;
             	int end = (start+6);
             	for(int j=start;j<end;j++){
             		if(j>listresult.size()-1){
             			break;
             		}
             		PortletURL tthctthc = renderResponse.createRenderURL();
             		tthctthc.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
             		tthctthc.setParameter("viewPage","/html/portlet/touchscreen/tthctthc.jsp");
             		tthctthc.setParameter("idNhomTTHC",String.valueOf(listresult.get(j).getNHOMTHUTUCHANHCHINHID()));
             		tthctthc.setParameter("id_donvi",id_donvi);
             %>
             	<div class="tit-left">
                    <div class="cont-left">
						<h5><a href="<%=tthctthc.toString()%>"><%=listresult.get(j).getTENNHOMTTHC().toUpperCase() %></a></h5>
					</div>
				</div>
			<%} %>
			</div>
		<%} %>
		</div>
	</div>
	<!--/list-block-->
	<%
	if(prefs.getValue("id_donvi","0").toString().equals("0")){
		PortletURL tthccoquan = renderResponse.createRenderURL();
 		tthccoquan.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
 		tthccoquan.setParameter("viewPage","/html/portlet/touchscreen/tthccoquan.jsp");
 		tthccoquan.setParameter("idCapCoQuan",String.valueOf(CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(id_donvi)).getCapCoQuanQuanlyId()));
	%>
	<div class="back-button">
		<a href="<%=tthccoquan.toString()%>">Trở lại</a>
	</div>
	<%} %>
</div>
<!--/content-block-->