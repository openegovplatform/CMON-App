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
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="org.oep.cmon.util.CmonFields"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="static org.oep.cmon.portlet.ipmslist.utils.HoSoXuLyURLUtil.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	HoSoTTHCCong hoSo = (HoSoTTHCCong) request.getAttribute(HoSoFields.hoSo);
	long hoSoId = hoSo.getId();
	
	String
		currentURL = PortalUtil.getCurrentCompleteURL(request)
	,	backURL = getBackURLTaiTrangChiTiet(request)
	,	emailCanBoDaDangNhap = PortalUtil.getUser(request).getEmailAddress()
	;
	
	LiferayURL capChungChiURL = getURLCapChungChiGiayPhep(request, hoSo, currentURL);
%>
<% if (HoSoBusinessUtil.laCanBoDangDuocPhanCongXuLyHoSo(emailCanBoDaDangNhap, hoSo)) { %>

	<% if (laHoSoCanLuanChuyen(hoSo)) { %>
		<button class="egov-button" type="button"
			onclick="location.href='<%= getURLLuanChuyen(request, hoSo, currentURL) %>'"
			<%= HSLTBusinessUtil.laHoSoCanGuiLienThong(hoSo) ? StringPool.DISABLED : StringPool.BLANK %>
		>
			Luân chuyển
		</button>
	<% } %>
	
	<% if (HSLTBusinessUtil.laHoSoCanGuiLienThong(hoSo)) { %>
	 	<jsp:include page="<%=HSLTBusinessUtil.JSP_BUTTON%>">
			<jsp:param value="<%=hoSo.getId()%>" name="hoSoId" />
		</jsp:include> 
	<% } %>
	
	<% if ( (capChungChiURL != null) && laHoSoCoTheCapChungChiGiayPhep(hoSo) ) { %>
		<button class="egov-button" type="button"
		onclick="location.href='<%= capChungChiURL %>'"
	>
			Xử lý hồ sơ
		</button>
	<% } %>
	
	<% if (laHoSoCoTheLuuTaiLieu(hoSo)) { %>
		<button class="egov-button" type="button"
			onclick="location.href='<%= getURLLuuTaiLieu(request, hoSo, currentURL) %>'"
		>
			Lưu tài liệu
		</button>
	<% } %>
	
	<% if (laHoSoCoTheDungXuLy(hoSo)) { %>
		<button class="egov-button" type="button"
			onclick="location.href='<%= getURLDungXuLy(request, hoSo, currentURL) %>'"
		>
			Dừng xử lý
		</button>
	<% } %>
	
	<% if (laHoSoCoTheYeuCauBoSung(hoSo)) { %>
		<button class="egov-button" type="button"
			onclick="location.href='<%= getURLYeuCauBoSung(request, hoSo, currentURL) %>'"
		>
			Yêu cầu bổ sung
		</button>
	<% } %>
	
<% } %>

<% if (laHoSoCoTheTraoDoiThongTin(hoSo)) { %>
	<button class="egov-button" type="button"
		onclick="location.href='<%= getURLTraoDoiThongTin(request, hoSo, currentURL) %>'"
	>
		Trao đổi thông tin
	</button>
<% } %>
	
<% if (laHoSoCoTheXemTienTrinhXuLy(hoSo)) { %>
	<input 
		class="egov-button" 
		type="button" 
		id="<%=hoSo.getMaSoHoSo()%>"
		name="viewProcessButtonName"
		value="Xem tiến trình xử lý"
	/>
	<jsp:include page="/html/portlet/ipmslistportlet/viewProcess.jsp"/>
<% } %>

	<button class="egov-button" type="button" 
		onclick="location.href='<%= backURL %>'"
	>
		Quay lại
	</button>