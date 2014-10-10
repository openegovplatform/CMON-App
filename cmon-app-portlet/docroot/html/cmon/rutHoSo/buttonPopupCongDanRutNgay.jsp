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
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoFields"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	HoSoTTHCCong hoSo = (HoSoTTHCCong) request.getAttribute(RutHoSoFields.hoSo);
	long hoSoId = hoSo.getId();

	String captchaURL = 
		LiferayURL.createResourceURL(request, RutHoSoBusinessUtil.PORTLET_NAME, "captcha")
			.toString();

	String rutHoSoURL = 
		LiferayURL.createAjaxURL(request, RutHoSoBusinessUtil.PORTLET_NAME, "processCongDanRutHoSoMoiNop")
			.toString();
%>

<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/customEgovTheme.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/customEgovTheme.js"></script>

<button
	class="egov-button egov-popup-opener"
	popup-id="popup_rut_ho_so"
	type="button"
>
	Rút hồ sơ
</button>

<div id="popup_rut_ho_so" style="display: none;">
	<div class="_wrapper septop20">
		<input type="hidden" name="<%= RutHoSoFields.hoSoId %>" value="<%= hoSoId %>" />
		<input 
			type="hidden" 
			name="<%= RutHoSoFields.redirectURL %>"
			value="<%= LiferayURL.createRenderURL(request, "transactionportlet_WAR_cmonappportlet", null) %>" 
		/>
		<div class="clear fi fi50">
			<div class="fi-wrapper">
				<div class="fi-label">
					<label class="egov-label-bold">
						Mời nhập mã bảo mật
					</label>
					<label class="egov-label-red"> * </label>
				</div>
				<div class="fi-input">
					<input
						id="captcha_input"
						type="text"
						class="egov-inputfield"
						value=""
						name="<%= RutHoSoFields.captcha %>"
					/>
				</div>
			</div>
		</div>
		<div id="captcha_ctn" class="left sepleft10" style="margin-top: 8px; min-width: 160px; min-height: 50px;">
			<img
				id="captcha_img"
				style="cursor: pointer;" alt="Mã bảo mật"
				src=""
			>
		</div>
		<div class="clear septop10 sepleft5">
			<label id="captcha_hint" class="egov-label hint">
				(nếu khó đọc, bấm vào hình để đổi mã khác)
			</label>
		</div>
		<div class="button-bar">
			<button type="submit" class="egov-button-normal">
				Hủy hồ sơ
			</button>
			<button type="button" class="egov-button-normal egov-popup-closer" popup-id="popup_rut_ho_so">
				Thoát
			</button>
		</div>
	</div>
</div>
	
<script type="text/javascript">
$(function() {
	var $popup = $('#popup_rut_ho_so'),
		$captchaImg = $('#captcha_img'),
		$captchaCtn = $('#captcha_ctn'),
		captchaURL = '<%= captchaURL %>';
	;
	$popup.egovPopup('Hủy hồ sơ đã nộp trực tuyến', 400);
	
	$popup.bind('dialogopen', function() {
		$captchaCtn.showLoading(true);
		$captchaImg.prop('src', captchaURL);
	});
	
	$captchaImg
		.load(function() {
			$captchaCtn.hideLoading();
		})
		.click(function() {
			$captchaCtn.showLoading(true);
			this.src = captchaURL.urlParam('r', Math.random());
			$('#captcha_input').focus();
		})
	;

	$popup.wrapInner('<form method="post" action="<%= rutHoSoURL %>" autocomplete="off"></form>');
	$popup.children().egovAjaxForm();
});
</script>