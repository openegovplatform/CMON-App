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
<%@page import="org.oep.cmon.dao.beans.cauhinhlienthong.CauHinhLienThong"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	long
		hoSoId = HSRParamUtil.getLong(request, "hoSoId")
	,	coQuanHienTaiId = 0L
	,	thuTucHienTaiId = 0L
	;
	
	HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
	thuTucHienTaiId = hoSo.getThuTucHanhChinhId();
	coQuanHienTaiId = hoSo.getCoQuanTiepNhanId();
	
	CauHinhLienThong cauHinhLienThongTiepTheo = 
		HSLTBusinessUtil.getCauHinhLienThongTiepTheo(thuTucHienTaiId, coQuanHienTaiId);
	
	LiferayURL xuLyGuiHoSoURL = LiferayURL.createAjaxURL(
		request, HSLTBusinessUtil.PORTLET_NAME, "processGuiHoSoLienThong");
	String redirectURL = HSLTBusinessUtil.getURLDanhSachHoSoNoiGui(request);
%>

<% if (cauHinhLienThongTiepTheo == null) { %>
	<label class="egov-label-red strong">Lỗi cấu hình liên thông. Thủ tục:<%= thuTucHienTaiId %>, cơ quan:<%= coQuanHienTaiId %></label>
<% } else { %>

	<button type="button" class="egov-button egov-popup-opener" popup-id="hslt_popup">
		Gửi hồ sơ liên thông
	</button>
	
	<div id="hslt_popup" class="egov-popup septop10" style="display: none;">
		<div class="_wrapper">
			<input type="hidden" name="<%=HSLTFields.hoSoId%>" value="<%=hoSoId%>" />
			<input type="hidden" name="<%=HSLTFields.thuTucNhanId%>" 
				value="<%=cauHinhLienThongTiepTheo.getThuTucId()%>" />
			<div class="fi">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Gửi tới đơn vị
						</label>
						<label class="egov-label-red"> * </label>
					</div>
					<div class="fi-input">
						<select id="hslt_co_quan_nhan_id" class="egov-select" name="<%=HSLTFields.coQuanNhanId%>">
							<option value="<%= cauHinhLienThongTiepTheo.getCoQuanId() %>">
								<c:out value="<%= cauHinhLienThongTiepTheo.getTenCoQuan() %>"/>
							</option>
						</select>
					</div>
				</div>
			</div>
			<div class="fi clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Ghi chú gửi nơi nhận
						</label>
					</div>
					<div class="fi-input">
						<textarea class="egov-textarea" name="<%= HSLTFields.ghiChuGuiLienThong %>"></textarea>
					</div>
				</div>
			</div>
			<div class="hidden-sep">&nbsp;</div>
			<div class="button-bar">
				<button id="hslt_submit_btn" type="button" class="egov-button">Gửi hồ sơ</button>
				<button type="button" class="egov-button egov-popup-closer" popup-id="hslt_popup">Đóng</button>
			</div>
		</div>
	</div>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/customEgovTheme.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/customEgovTheme.js"></script>
	<script type="text/javascript">
	$(function() {
		
		var $popup, $selCoQuanNhan, ajax;
		$popup = $('#hslt_popup');
		$selCoQuanNhan = $('#hslt_co_quan_nhan_id');
		
		// Fix HTML form nested problem when include this jsp file
		$popup.wrapInner('<form id="hslt_form_gui"></form>');
		
		ajax = Ajax.forURL('<%= xuLyGuiHoSoURL %>').setForm('#hslt_form_gui');
		
		$popup.egovPopup('Gửi hồ sơ liên thông', 500);
		
		$('#hslt_submit_btn').click(
			function() {
				var coQuanNhanId = VarUtil.getInteger($selCoQuanNhan.val());
				
				if (coQuanNhanId > 0) {
					ajax.run();
				} else {
					$warning('Mời chọn đơn vị cần gửi', function() { $selCoQuanNhan.focus(); });
				}
			}
		);
	});
	</script>
<% } %>
