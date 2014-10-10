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
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoFields"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	long hoSoId = HSRParamUtil.getLong(request, RutHoSoFields.hoSoId);
	HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
	String backURL = HSRParamUtil.getString(request, RutHoSoFields.redirectURL);
	String tenLoaiHoSo = StringPool.BLANK
	,	maSoBienNhan = StringPool.BLANK
	,	tenNguoiNop = StringPool.BLANK
	,	ngayNopHoSo = StringPool.BLANK
	,	tenCanBoTiepNhan = StringPool.BLANK
	,	tenCanBoDangXuLy = StringPool.BLANK
	;
	if (hoSo != null) {
		maSoBienNhan = hoSo.getMaSoBienNhan();
		tenLoaiHoSo = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSo.getThuTucHanhChinhId()).getTen();
		tenNguoiNop = hoSo.getHoTenNguoiNopHoSo();
		ngayNopHoSo = DateTimeUtil.getDayMonthYear(hoSo.getNgayNopHoSo());
		tenCanBoTiepNhan = hoSo.getTenCanBoTiepNhan();
		//tenCanBoDangXuLy = HoSoBusinessUtil.getHoTenCanBoVuaThucHienXuLy(hoSo);
	}
	
	boolean laCanBoDaDangNhap = EgovUtil.laCongChucDangNhap(
		TaiKhoanNguoiDungLocalServiceUtil.fetchByLiferayUserId(PortalUtil.getUserId(request)));

%>
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/customEgovTheme.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/customEgovTheme.js"></script>

<style type="text/css">
.table-form{
	
	border-collapse: separate; border-spacing: 10px;text-align: left;
	background: white !important;
}
.table-form caption {
	text-align: left;
	font-weight: bold;
}
.div-content{
	padding-top: 10px;
}
</style>
<div class="egov-container _outer">
	<div class="_wrapper">
		<div class="hidden-sep">&nbsp;</div>
		<h1 class="lv1-title">
			<label id="main_title" class="lv1-title-text">
				Yêu cầu rút hồ sơ
			</label>
		</h1>
		<div class="mix">
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Loại hồ sơ:</label>
					<label class="egov-label"><c:out value="<%= tenLoaiHoSo %>"/></label>
				</div>			
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Mã số biên nhận:</label>
					<label class="egov-label"><c:out value="<%= maSoBienNhan %>"/></label>
				</div>			
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Người nộp:</label>
					<label class="egov-label"><c:out value="<%= tenNguoiNop %>"/></label>
				</div>			
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Ngày nộp:</label>
					<label class="egov-label"><%= ngayNopHoSo %></label>
				</div>			
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Cán bộ tiếp nhận:</label>
					<label class="egov-label"><c:out value="<%= tenCanBoTiepNhan %>"/></label>
				</div>			
			</div>
			<%-- <div class="line">
				<div class="item">
					<label class="egov-label strong">Cán bộ đang xử lý:</label>
					<label class="egov-label"><c:out value="<%= tenCanBoDangXuLy %>"/></label>
				</div>			
			</div> --%>
		</div>
		<form 
			method="post" 
			action="<%= LiferayURL.createAjaxURL(request, RutHoSoBusinessUtil.PORTLET_NAME, "processYeuCauRutHoSo") %>"
			class="septop20 egov-ajax-form"
			autocomplete="off"
		>
			<input type="hidden" name="<%= RutHoSoFields.hoSoId %>" value="<%= hoSoId %>">
			<input type="hidden" name="<%= RutHoSoFields.redirectURL %>" value="<%= backURL %>">
			
		<% if (!laCanBoDaDangNhap) { %>
			
			<div class="hidden-sep">&nbsp;</div>			
			<div class="sepline septop15 sepbot15">&nbsp;</div>			
		
			<div class="clear fi fi33">
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
					style="cursor: pointer; display: none;" alt="Mã bảo mật"
					src="<%= request.getContextPath() %>/images/loading"
				>
			</div>
			<div class="clear septop10 sepbot10 sepleft5">
				<label id="captcha_hint" class="egov-label hint">
					(nếu khó đọc, bấm vào hình để đổi mã khác)
				</label>
			</div>
			
			<script type="text/javascript">
				var	$captchaImg = $('#captcha_img'),
					$captchaCtn = $('#captcha_ctn'),
					captchaURL = '<%= LiferayURL.createResourceURL(request, RutHoSoBusinessUtil.PORTLET_NAME, "captcha") %>';
				;
				$captchaImg
					.load(function() {
						$captchaCtn.hideLoading(true);
						$(this).show();
					})
					.click(function() {
						$captchaCtn.showLoading(true);
						this.src = captchaURL.urlParam('r', Math.random());
						$('#captcha_input').focus();
					})
					.prop('src', captchaURL);
				
					$captchaCtn.showLoading(true);
			</script>
			
		<% } %>
			<div class="clear fi">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Ý kiến gửi cán bộ đang xử lý hồ sơ
						</label>
					</div>
					<div class="fi-input">
						<textarea class="egov-textarea" name="<%= RutHoSoFields.yKienYeuCauRut %>"></textarea>
					</div>
				</div>
			</div>
			<div class="hidden-sep">&nbsp;</div>
			<div class="button-bar">
				<button type="submit" class="egov-button-normal">
					Gửi yêu cầu rút hồ sơ
				</button>
				<button type="button" class="egov-button-normal" 
					onclick="location.href='<%= backURL %>'"
				>
					Quay lại
				</button>
			</div>
			<div class="hidden-sep">&nbsp;</div>
		</form>
	</div>
</div>