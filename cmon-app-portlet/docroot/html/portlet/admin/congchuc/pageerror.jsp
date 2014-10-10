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
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
	PortletURL indexURL = renderResponse.createRenderURL();
	indexURL.setParameter("jspPage","/html/portlet/admin/congchuc/view.jsp");
%>
<div class="egov-container">
	<div style="width: 100%;text-align: center;padding: 10px;color: red;">
		<h3>CHỨC NĂNG TẠM THỜI KHÔNG XỬ LÝ ĐƯỢC!</h3>
	</div>
	<div style="width: 100%;text-align: center;margin-top: 10px;margin-bottom: 10px">
		<a href="<%=indexURL%>"><button class="egov-button-normal">Quay lại</button></a>
	</div>
</div>