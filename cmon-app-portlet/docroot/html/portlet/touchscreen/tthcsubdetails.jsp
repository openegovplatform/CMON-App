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
<%@page
	import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
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
	String idTTHC = "";
	String detailType = "";
	String title = "";
	String content = "";
	if(Validator.isNotNull(request.getParameter("idTTHC"))){
		idTTHC = request.getParameter("idTTHC");
	}
	if(Validator.isNotNull(request.getParameter("detailType"))){
		detailType = request.getParameter("detailType");
	}
	if(Validator.isNotNull(request.getParameter("id_donvi"))){
		id_donvi = request.getParameter("id_donvi");
	}
	if(!idTTHC.equals("")){
		ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(Long.valueOf(idTTHC));
		if(detailType.equals("trinhtuthuchien")){
			title = "Trình tự thực hiện";
			content = thuTuc.getTrinhTuThucHien();
		}
		if(detailType.equals("thanhphanhoso")){
			title = "Thành phần hồ sơ";
			content = thuTuc.getThanhPhanHoSo();
		}
		if(detailType.equals("cancuphaply")){
			title = "Căn cứ pháp lý";
			content = thuTuc.getCanCuPhapLy();
		}
		PortletURL tthcdetails = renderResponse.createRenderURL();
		tthcdetails.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
		tthcdetails.setParameter("viewPage","/html/portlet/touchscreen/tthcdetails.jsp");
		tthcdetails.setParameter("idTTHC",idTTHC);
		tthcdetails.setParameter("id_donvi",id_donvi);
%>
<div class="content-block">
	<div class="header-block">
		<div class="breadcrumb">
			<div class="breadcrumb-title first">
				<h4>
					<span>THỦ TỤC HÀNH CHÍNH</span>
				</h4>
			</div>

			<div class="breadcrumb-title-1">
				<h4>
					<span><%=NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(thuTuc.getNhomThuTucHanhChinhId()).getTen() %></span>
				</h4>
			</div>

			<div class="breadcrumb-title-2 last">
				<h4>
					<p><%=thuTuc.getTen() %></p>
				</h4>
			</div>
		</div>
	</div>
	<!--/header-block-->
	<div class="detailgroup-block">
		<div class="detail-col col-full">
			<div>
				<table class="detail-table">
					<tr>
						<td class="bold color"><p><%=title %></p></td>
					</tr>
					<tr>
						<td class="color">
							<p><%=content %></p>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<!--/col-full-->
	</div>
	<!--/detailgroup-block-->
	
	<div class="back-button">
		<a href="<%=tthcdetails.toString()%>">Trở lại</a>
	</div>
</div>
<%} %>