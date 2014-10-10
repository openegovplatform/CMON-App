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
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoFields"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	HoSoTTHCCong hoSo = (HoSoTTHCCong) request.getAttribute(RutHoSoFields.hoSo);
	long hoSoId = hoSo.getId();
%>

<%-- 
	1) BUTTON_CD1
		Trường hợp hồ sơ mới nộp online, chưa vào tới một cửa
		hiển thị button "Rút hồ sơ"
		công dân click thì xóa hồ sơ
	
	2) BUTTON_CD2
		Trường hợp hồ sơ đã được tiếp nhận
		thì hiển thị button "Yêu cầu rút hồ sơ"
		công dân click sẽ nhảy đến màn hình yêu cầu rút hồ sơ 
--%>

<%-- BUTTON_CD1, Hồ sơ được phép rút ngay --%>
<% if (RutHoSoBusinessUtil.laHoSoCongDanDuocPhepRutNgay(hoSo)) { %>

	<jsp:include page="/html/cmon/rutHoSo/buttonPopupCongDanRutNgay.jsp"/>
	
<% } %>

<%-- BUTTON_CD2, Hồ sơ đã chuyển vào xử lý, muốn rút thì phải yêu cầu --%>
<% if (RutHoSoBusinessUtil.laHoSoCongDanDuocPhepYeuCauRut(hoSo)) { %>

	<button
		class="egov-button span-button" 
		type="button" 
		onclick="location.href='<%=
			RutHoSoBusinessUtil.getURLCongDanYeuCauRut(request, hoSoId, PortalUtil.getCurrentCompleteURL(request))
		%>'"
	>
		Yêu cầu rút hồ sơ
	</button>
	
<% } %>