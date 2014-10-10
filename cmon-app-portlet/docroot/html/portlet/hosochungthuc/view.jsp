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
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="org.oep.cmon.Constants" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<%
	String quiTrinh = portletPreferences.getValue(Constants.QuiTrinh.QUITRINH_PARAMS, "");
	int quiTrinhInt = GetterUtil.getInteger(quiTrinh);
	
	if (quiTrinhInt == Constants.QuiTrinh.CHUNG_THUC) {
%> 
	<%@include file="/html/portlet/hosochungthuc/chungThuc.jsp"%>
	
<%
		} else if (quiTrinhInt == Constants.QuiTrinh.HO_SO_CHUNG_THUC) {
	%>			
	<%@include file="/html/portlet/hosochungthuc/hoSoChungThuc.jsp" %>
	
<%
		}  else if (quiTrinhInt == Constants.QuiTrinh.SO_CHUNG_THUC) {
	%>
	<%@include file="/html/portlet/hosochungthuc/soChungThuc.jsp" %>
<% }  %>

