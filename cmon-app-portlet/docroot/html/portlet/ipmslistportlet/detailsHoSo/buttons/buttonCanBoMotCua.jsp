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
  -->/
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@page import="org.oep.cmon.util.CmonFields"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="static org.oep.cmon.portlet.ipmslist.utils.HoSoMotCuaURLUtil.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	HoSoTTHCCong hoSo = (HoSoTTHCCong) request.getAttribute(HoSoFields.hoSo);
	long hoSoId = hoSo.getId();
	
	String
		currentURL = PortalUtil.getCurrentCompleteURL(request)
	,	backURL = getBackURLTaiTrangChiTiet(request)
	;
%>

<% if (laHoSoCanChuyenPhongChuyenMon(hoSo)) { %>
	<button class="egov-button MOVEHS" type="button" onclick="moveOneHS('<%=hoSoId%>');">
		Chuyển hồ sơ
	</button>
<% } %>

<% if (laHoSoCanTiepNhan(hoSo)) { %>
	<button type="submit" class="egov-button">
		Tiếp nhận
	</button> 
	<input type="hidden" name="idHoSo" value="<%= hoSoId %>" />
<% } %>

<% if (laHoSoCanTraKetQua(hoSo)) { %>
	<button type="button" class="egov-button"
		onclick="location.href='<%= getURLTraKetQua(request, hoSo, currentURL) %>'"
	>
		Trả kết quả
	</button> 
<% } %>

<% if (laHoSoCoTheInBienNhan(hoSo)) { %>
	<button type="button" class="egov-button"
		onclick="location.href='<%= getURLInBienNhan(request, hoSo, currentURL) %>'"
	>
		In biên nhận
	</button> 
<% } %>

<% if (laHoSoCoTheInPhieuLuuChuyen(hoSo)) { %>
	<button type="button" class="egov-button"
		onclick="location.href='<%= getURLInPhieuLuuChuyen(request, hoSo, currentURL) %>'"
	>
		In phiếu lưu chuyển
	</button> 
<% } %>

<% if (laHoSoCoTheDoiChieu(hoSo)) { %>
	<button type="button" class="egov-button"
		onclick="location.href='<%= getURLDoiChieu(request, hoSo, currentURL) %>'"
	>
		Đối chiếu
	</button> 
<% } %>

<% if (laHoSoCoTheTaiKetQuaSo(hoSo)) { %>
	<button type="button" class="egov-button"
		onclick="location.href='<%= getURLTaiKetQuaSo(request, hoSo, currentURL) %>'"
	>
		Tải kết quả số
	</button> 
<% } %>

<% if (laHoSoCoTheThuTien(hoSo)) { %>
	<button type="button" class="egov-button"
		onclick="location.href='<%= getURLThuTien(request, hoSo, currentURL) %>'"
	>
		Thu tiền
	</button> 
<% } %>

<% if (laHoSoCoTheTuChoi(hoSo)) { %>
	<button type="button" class="egov-button"
		onclick="location.href='<%= getURLTuChoi(request, hoSo, currentURL) %>'"
	>
		Từ chối
	</button> 
<% } %>

<% if (laHoSoCoTheXemYeuCauBoSung(hoSo)) { %>
	<button type="button" class="egov-button"
		onclick="location.href='<%= getURLXemYeuCauBoSung(request, hoSo, currentURL) %>'"
	>
		Xem yêu cầu bổ sung
	</button> 
<% } %>

<% if (laHoSoCoTheXemYKienTuChoi(hoSo)) { %>
	<button type="button" class="egov-button"
		onclick="location.href='<%= getURLXemYKienTuChoi(request, hoSo, currentURL) %>'"
	>
		Xem yêu cầu bổ sung
	</button> 
<% } %>

	<jsp:include page="<%=RutHoSoBusinessUtil.JSP_PATH_BUTTONS%>">
		<jsp:param value="<%=hoSoId%>" name="hoSoId" />
	</jsp:include>

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
		onclick="location.href='<%= getURLTraoDoiThongTin(request, hoSo, currentURL) %>'"
	>
		Trao đổi thông tin
	</button>
	
	<button class="egov-button" type="button" 
		onclick="location.href='<%= backURL %>'"
	>
		Quay lại
	</button>
 
<div id="loading" title="Đang chuyển hồ sơ"></div>
<script type="text/javascript">
function moveOneHS(idHoSo) {
	var title = 'Đang chuyển hồ sơ ...';
	postDataToServer('<%=LiferayURL.createResourceURL(request, "moveListHoSo")%>', idHoSo, title);
}		
		
function postDataToServer(url, idHoSo, title) {	
	$('.MOVEHS').attr("disabled","disabled");
	
	$.ajax({
	  url : url,
	  data : 'idHoSo=' + idHoSo,
	  type: 'POST',
	  dataType : "json",
	  beforeSend: function(){
		  $("#loading").dialog({
			    title: title
			});
           $("#loading").dialog('open');
        },
	  success : function(data) {
		 $("#loading").dialog('close');
		 var  status = jQuery.parseJSON(data.status);			  
		 
		 if (status) {
			  location.reload();
		 }
		 
		 $('.MOVEHS').removeAttr("disabled");
	  }
	});
}
$(function() {
	$("#loading").dialog({
	    hide: 'close',
		show: 'slide',
		autoOpen: false,
	    height: 30,
	    width: 250,
	    resizable: false,
	    title: "Đang chuyển hồ sơ ...",
	    close: function() {
	    	$('.MOVEHS').removeAttr("disabled");
	    }
	});
});
</script>