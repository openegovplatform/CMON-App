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
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<%
	String loaiDanhSach = portletPreferences.getValue(
		HSLTFields.loaiDanhSach,
		HSLTBusinessUtil.LDS_NOI_NHAN
	);
%>
<%
	if (HSLTBusinessUtil.LDS_NOI_NHAN.equals(loaiDanhSach)) {
%>

	<jsp:include page="/html/portlet/hosolienthong/danhSachNoiNhan.jsp"/>
	
<% } else { %>

	<jsp:include page="/html/portlet/hosolienthong/danhSachNoiGui.jsp"/>
	
<% } %>