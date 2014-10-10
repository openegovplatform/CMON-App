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
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.report.model.DanhMucBaoCao"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<style>
	/*---menu admin--*/
.div_report_menu ul{margin:0; padding:0; list-style:none;padding:10px 0 15px; background:#fff}
.div_report_menu ul li{ display:inline; margin-right:-4px}
.div_report_menu ul li{
	background: none repeat scroll 0 0 #005e97;
    border-bottom: 3px solid #ff8400;
    border-right: 1px solid #fff;
    padding: 7px 10px;}
.div_report_menu ul li:last-child{border-right:none}
.div_report_menu a{
	color: #fff;
    font-size: 14px;
    padding: 7px 10px;
}
.div_report_menu a:hover{text-decoration:none}
.div_report_menu li:hover, .div_report_menu li.active {
    background: none repeat scroll 0 0 #ff8400;
}
</style>
<%
if (renderRequest != null) {
	long idBaoCao = 0;
	String viewPage = "";
	if(Validator.isNotNull(request.getParameter("idBaoCao"))){
		idBaoCao = Integer.valueOf(request.getParameter("idBaoCao").toString());

	}
	if(Validator.isNotNull(request.getParameter("viewPage"))){
		viewPage = request.getParameter("viewPage").toString();
	}
	List<DanhMucBaoCao> listBaoCao = new ArrayList<DanhMucBaoCao>();
	if(themeDisplay.isSignedIn()){
		TaiKhoanNguoiDung loginUser = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUserId(request));
		if(loginUser!=null){
			listBaoCao = ActionUtil.getDanhmucbaocao(loginUser.getId());
		}else{
			listBaoCao = ActionUtil.getDanhmucbaocao(0);
		}
	}else{
		listBaoCao = ActionUtil.getDanhmucbaocao(0);
	}
	/* if(idBaoCao==0){
		if(listBaoCao.size()!=0){
			idBaoCao = listBaoCao.get(0).getID();	
			viewPage = listBaoCao.get(0).getDUONGDAN();
		}
	} */
	// sort bao cao theo order
	/* Collections.sort(listBaoCao, new Comparator<DanhMucBaoCao>() {
        @Override
        public int compare(DanhMucBaoCao  bc1, DanhMucBaoCao  bc2)
        {
            return  bc1.getORDERS()-bc2.getORDERS();
        }
    }); */
%>
<div class="div_report_menu"><ul>
<%
	for(int i = 0;i<listBaoCao.size();i++){
		PortletURL url = renderResponse.createRenderURL();
		url.setParameter("idBaoCao",String.valueOf(listBaoCao.get(i).getID()));
		url.setParameter("viewPage",listBaoCao.get(i).getDUONGDAN());
		boolean active = false;
		if(idBaoCao==listBaoCao.get(i).getID()){
			active = true;
		}
%>
<li <%=active?"class='active'":"" %> ><a href="<%=url.toString()%>" ><%=listBaoCao.get(i).getTENBAOCAO() %></a></li>
<%} %>
</ul>
</div>
<%
if(idBaoCao!=0){
%>
<jsp:include page="<%=viewPage %>"></jsp:include>
<%}}%> 