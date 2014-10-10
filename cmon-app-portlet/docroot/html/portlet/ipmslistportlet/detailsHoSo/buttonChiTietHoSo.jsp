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
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%
	long hoSoId = HSRParamUtil.getLong(request, "hoSoId");
	HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
	request.setAttribute(HoSoFields.hoSo, hoSo);
	
	boolean laLanhDao = HSRParamUtil.getBoolean(request, "laLanhDao");
	String loaiCanBo = HSRParamUtil.getString(request, "loaiCanBo");
%>

<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/customEgovTheme.css"/>
<style type="text/css">
	.button-bar.hoso-button-bar .egov-button:first-child {
		margin-left: 0 !important;
	}
</style>
<div id="hoso_button_bar" class="button-bar hoso-button-bar">
	<% if (laLanhDao) { %>
						
			<jsp:include page="/html/portlet/ipmslistportlet/detailsHoSo/buttons/buttonLanhDao.jsp"/>
		
	<% } else { %>
		<% if (loaiCanBo.equals(Constants.LOAI_CAN_BO.LOAI_MOT_CUA)) { %>
		
			<jsp:include page="/html/portlet/ipmslistportlet/detailsHoSo/buttons/buttonCanBoMotCua.jsp"/>
			
		<% } else { %>
		
			<jsp:include page="/html/portlet/ipmslistportlet/detailsHoSo/buttons/buttonCanBoXuLy.jsp"/>
	
		<% } %>
	<% } %>
</div>
<script type="text/javascript">
$(function() {
	
	//@TODO Wrap button bar
	
	var buttonsPerRow = 5
	,	$buttonBar = $('#hoso_button_bar')
	,	$buttons = $buttonBar.children('.egov-button')
	;
	
	if ($buttons.length > buttonsPerRow) {
		var $secondBar = $('<div class="button-bar hoso-button-bar"/>').insertAfter($buttonBar);
		$secondBar.append($buttons.clone(true));
		
		for (var i = buttonsPerRow; i < $buttons.length; ++ i) {
			$buttons.eq(i).remove();
		}
		
		var $secondButtons = $secondBar.children('.egov-button');
		for (var i = 0; i < buttonsPerRow; ++ i) {
			$secondButtons.eq(i).remove();
		}
	}
});
</script>