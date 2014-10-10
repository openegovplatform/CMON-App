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
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoFields"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	long hoSoId = HSRParamUtil.getLong(request, "hoSoId");
	HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
	request.setAttribute(RutHoSoFields.hoSo, hoSo);
%>

<%-- ĐỐI VỚI CÁN BỘ --%>
<% if (EgovUtil.laCongChucDangNhap(PortalUtil.getUserId(request))) { %>
	
	<jsp:include page="/html/cmon/rutHoSo/buttonCanBo.jsp"/>
	
<%-- ĐỐI VỚI CÔNG DÂN --%>
<% } else { %>
		
	<jsp:include page="/html/cmon/rutHoSo/buttonCongDan.jsp"/>
	
<% } %>	
