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
	int trangThai = hoSo.getTrangThaiHoSo();
%>
<%-- 
	1) BUTTON_CB1
		Trường hợp hồ sơ đang nằm ở 1 cửa
		công dân tới yêu cầu rút
		thì hiển thị button "Rút hồ sơ"
		cán bộ click sẽ nhảy đến màn hình trả hồ sơ
			
	2) BUTTON_CB2
		Trường hợp hồ sơ đã đưa vào xử lý
		thì hiển thị button "Yêu cầu rút hồ sơ"
		cán bộ click sẽ nhảy đến màn hình yêu cầu rút hồ sơ
	
	2) BUTTON_CB3
		Trường hợp hồ sơ đã có yêu cầu rút rồi
		thì hiển thị button "Trả hồ sơ đã yêu cầu rút" 
--%>

<%-- BUTTON_CB1, Hồ sơ được phép rút ngay --%>
	<% if (RutHoSoBusinessUtil.laHoSoCanBoDuocPhepRutNgay(hoSo)) { %>
	
		<button 
			class="egov-button" 
			type="button" 
			onclick="location.href='<%=
				RutHoSoBusinessUtil.getURLTraHoSoDaYeuCauRut(request, hoSoId, trangThai)
			%>'"
		>
			Rút hồ sơ
		</button>
		
	<% } %>
	
	<%-- BUTTON_CB1, Hồ sơ đã chuyển vào xử lý, muốn rút thì phải yêu cầu --%>
	<% if (RutHoSoBusinessUtil.laHoSoCanBoDuocPhepYeuCauRut(hoSo)) { %>
	
		<button 
			class="egov-button" 
			type="button" 
			onclick="location.href='<%=
				RutHoSoBusinessUtil.getURLCanBoYeuCauRut(request, hoSoId, PortalUtil.getCurrentCompleteURL(request))
			%>'"
		>
			Yêu cầu rút hồ sơ
		</button>

	<% } %>
	
	<%-- BUTTON_CB3, trường hợp đã có yêu cầu rút hồ sơ --%>
	<% if (RutHoSoBusinessUtil.laHoSoDaYeuCauRut(hoSo)) { %>
	
		<button 
			class="egov-button" 
			type="button" 
			onclick="location.href='<%=
				RutHoSoBusinessUtil.getURLTraHoSoDaYeuCauRut(request, hoSoId, trangThai)
			%>'"
		>
			Trả hồ sơ yêu cầu rút
		</button>
	<% } %>