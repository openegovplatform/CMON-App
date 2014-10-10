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
<%@page import="org.oep.cmon.dao.beans.congdan.CongDanImpl"%>
<%@page import="org.oep.cmon.dao.beans.congdan.CongDan"%>
<%@page import="java.util.Date"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"%>
<%@page import="org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	long 
		hoSoLienThongId = HSRParamUtil.getLong(request, HSLTFields.hoSoLienThongId)
	,	coQuanGuiId = 0L
	,	canBoGuiId = 0L
	,	hoSoId = 0L
	;

	String
		tenCoQuanGui = StringPool.BLANK
	, 	tenCanBoGui = StringPool.BLANK
	,	lucGui = StringPool.BLANK
	,	ghiChuGuiLienThong = StringPool.BLANK
	,	tenChuHoSo = StringPool.BLANK
	;
	
	HoSoLienThong hoSoLienThong =
		HoSoLienThongLocalServiceUtil.fetchHoSoLienThong(hoSoLienThongId);
	hoSoId = hoSoLienThong.getHoSoId();
	coQuanGuiId = hoSoLienThong.getCoQuanGuiId();
	List<CongChuc> dsCanBoCoQuanGui = CongChucLocalServiceUtil.findByCoQuanQuanLyID(coQuanGuiId);
	List<GiayToDinhKemHoSo> dsGiayToDaNhan =
		FileDinhKemLocalServiceUtil.getDSGiayToPhienBanMoiNhatByHoSo(hoSoId);
	canBoGuiId = hoSoLienThong.getCanBoGuiId();
	tenCoQuanGui = hoSoLienThong.getTenCoQuanGui();
	tenCanBoGui = hoSoLienThong.getHoTenCanBoGui();
	lucGui = DateTimeUtil.getFullDateTime(hoSoLienThong.getNgayGui(), false);
	ghiChuGuiLienThong = hoSoLienThong.getGhiChuGuiLienThong();
	
	HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoLienThong.getHoSoId());
	CongDan congDanNop = new CongDanImpl(CongDanLocalServiceUtil.fetchCongDan(hoSo.getCongDanNopId()));
	
	tenChuHoSo = hoSo.getChuSoHuu();
	
	String backURL = HSRParamUtil.getString(request, "backURL").trim();
	if (backURL.isEmpty()) {
		backURL = LiferayURL.createRenderURL(request, "ipmslistportlet_WAR_cmonappportlet", null).toString();
	}
%>

<script type="text/javascript">

$(function() {

	var
		tuChoiHoSoAjax = Ajax.forURL('<%= LiferayURL.createAjaxURL(request, "processTuChoiLienThong") %>')
	,	$gridGiayToDaNop = $('#ds_giay_to_da_nop')
	,	$popup = $('#popup_tu_choi_ho_so');
	;
	
	tuChoiHoSoAjax.setForm('#form_tu_choi_ho_so');
	$popup.egovPopup('Từ chối tiếp nhận hồ sơ liên thông', 500);
	
	$('#toggle_ds_giay_to_da_nop').click(function(ev) {
		if ($gridGiayToDaNop.is(':visible')) {
			$gridGiayToDaNop.hide();
		} else {
			$gridGiayToDaNop.show();
		}
		ev.preventDefault();
	});
	
	$('#button_tu_choi_ho_so').click(function() {
		tuChoiHoSoAjax.run();
	});
	
	$('#main_form').egovAjaxForm(new Ajax().setMergeWithGlobal(false));
});

</script>

<div class="_outer egov-container">
	<div class="hidden-sep">&nbsp;</div>
	<div class="_wrapper">
	<form
		id="main_form"
		method="post"
		autocomplete="off"
		action='<%=LiferayURL.createAjaxURL(request, "processTiepNhanLienThong")%>'
		enctype="multipart/form-data"
		prevent-submit-on-textbox-enter-key="true"
	>
		<input type="hidden" name="<%=HSLTFields.hoSoLienThongId%>" value="<%=hoSoLienThongId%>" />
		<input type="hidden" name="backURL" value="<%=backURL%>" />
		
		<h1 class="lv1-title">
			<label id="main_title" class="lv1-title-text">
				Tiếp nhận hồ sơ liên thông
			</label>
		</h1>
			
		<div class="mix">
			<div class="group-title">
				<label class="lv2-title-text">
					Thông tin đơn vị gửi hồ sơ liên thông
				</label>
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Đơn vị gửi:</label>
					<label class="egov-label">
						<c:out value="<%= tenCoQuanGui %>"/>
					</label>
				</div>
			</div>
			<div class="line">
				<div class="item fi50">
					<label class="egov-label strong">Cán bộ gửi:</label>
					<label class="egov-label">
						<c:out value="<%= tenCanBoGui %>"/>
					</label>
				</div>
				<div class="item fi50">
					<label class="egov-label strong">Lúc gửi:</label>
					<label class="egov-label">
						<%= lucGui %>
					</label>
				</div>
			</div>
			
		<% if (!ghiChuGuiLienThong.isEmpty()) { %>
			
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Ý kiến đơn vị gửi:</label>
					<label class="egov-label">
						<c:out value="<%= ghiChuGuiLienThong %>"/>
					</label>
				</div>
			</div>
			
		<% } %>
		
			<div class="fi fi50">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Cán bộ nộp hồ sơ giấy
						</label>
						<label class="egov-label-red">*</label> 
					</div>
					<div class="fi-input">
						<select class="egov-select egov-select-ui"
							name="<%=HSLTFields.canBoNopHoSoGiayId%>"
							data-placeholder=""
						>
						<% for (CongChuc item : dsCanBoCoQuanGui) { %>	
							
							<option 
								value="<%= item.getId() %>" 
								<%= (item.getId() == canBoGuiId) ? StringPool.SELECTED : StringPool.BLANK %>
							>
								<c:out value="<%= item.getHoVaTen() %>"/>
							</option>
														
						<% } %>	
						</select>
					</div>
				</div>
			</div>
			
		<% if (!dsGiayToDaNhan.isEmpty()) { %>	
			<div class="clear">
				<div class="lv3-title">
					<a class="lv3-title-text" href="#" id="toggle_ds_giay_to_da_nop">
						Danh sách giấy tờ đã nhận ở đơn vị gửi
					</a>
				</div>
				<ol id="ds_giay_to_da_nop" class="egov-ol nonseptop" style="display: none;">
				<% for (GiayToDinhKemHoSo item : dsGiayToDaNhan) { %>
					<% boolean isUploaded = !item.getDownloadLink().isEmpty(); %>
					
					<li>
					<% if (isUploaded) { %>
					
						<a href="<%= item.getDownloadLink() %>">
							<label class="egov-label">
								<c:out value="<%= item.getTenGiayTo() %>"/>
								<% if (item.getLaBanChinh()) { %>
									(Bản chính)
								<% } %>
							</label>
						</a>
						
					<% } else { %>
					
						<label class="egov-label">
							<c:out value="<%= item.getTenGiayTo() %>"/>
							<% if (item.getLaBanChinh()) { %>
								(Bản chính)
							<% } %>
						</label>

					<% } %>
					</li>
					
				<% } %>
				</ol>
			</div>
		
		<% } %>	
		
		</div>
		
		<div class="mix">
			<div class="group-title">
				<label class="lv2-title-text">
					Thông tin người nộp hồ sơ
				</label>
			</div>
			
			<div class="line">
				<div class="item fi50">
					<label class="egov-label strong">Họ và tên:</label>
					<label class="egov-label">
						<c:out value="<%= congDanNop.getHoTenDayDu() %>"/>
					</label>
				</div>
				<div class="item fi50">
					<label class="egov-label strong">CMND:</label>
					<label class="egov-label">
						<c:out value="<%= congDanNop.getSoCMND() %>"/>
					</label>
				</div>
			</div>
			<div class="line">
				<div class="item fi50">
					<label class="egov-label strong">Ngày sinh:</label>
					<label class="egov-label">
						<c:out value="<%= DateTimeUtil.getDayMonthYear(congDanNop.getNgaySinh()) %>"/>
					</label>
				</div>
				<div class="item fi50">
					<label class="egov-label strong">Điện thoại:</label>
					<label class="egov-label">
						<c:out value="<%= congDanNop.getDienThoai() %>"/>
					</label>
				</div>
			</div>
		<% if (!congDanNop.getEmail().isEmpty()) { %>
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Email:</label>
					<label class="egov-label">
						<c:out value="<%= congDanNop.getEmail() %>"/>
					</label>
				</div>
			</div>
		<% } %>
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Địa chỉ:</label>
					<label class="egov-label">
						<c:out value="<%= congDanNop.getDiaChiDayDu() %>"/>
					</label>
				</div>
			</div>
		</div>
		
		<div class="mix">
			<div class="group-title">
				<label class="lv2-title-text">
					Thông tin hồ sơ
				</label>
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label strong">Chủ hồ sơ:</label>
					<label class="egov-label">
						<c:out value="<%= tenChuHoSo %>"/>
					</label>
				</div>
			</div>
		</div>
		
		<jsp:include page="/html/portlet/hosotructiep/thongTinHoSoInputs.jsp">
			<jsp:param value="<%= hoSoId %>" name="hoSoId"/>
			<jsp:param value="1" name="laTiepNhanLienThong"/>
			<jsp:param value="<%= hoSoLienThongId %>" name="hoSoLienThongId"/>
		</jsp:include>
		
		<div class="hidden-sep">&nbsp;</div>
		<div class="button-bar">
			<button type="submit" class="egov-button">Tiếp nhận hồ sơ liên thông</button>				
			<button type="button" class="egov-button egov-popup-opener" popup-id="popup_tu_choi_ho_so">
				Từ chối hồ sơ này
			</button>
			<button type="button" class="egov-button" onclick="location.href='<%=backURL%>'">Quay lại</button>				
		</div>
		<div class="hidden-sep">&nbsp;</div>
	</form>
	</div>
</div>

<div id="popup_tu_choi_ho_so" style="display: none;">
	<form id="form_tu_choi_ho_so">
		<input type="hidden" name="<%= HSLTFields.hoSoLienThongId %>" value="<%= hoSoLienThongId %>"/>
		<div class="_wrapper septop20">
			<div class="clear fi">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Ghi chú/lý do từ chối
						</label>
					</div>
					<div class="fi-input">
						<textarea name="<%= HSLTFields.yKienTuChoi %>" class="egov-textarea"></textarea>
					</div>
				</div>
			</div>
			<div class="hidden-sep">&nbsp;</div>
			<div class="button-bar">
				<button id="button_tu_choi_ho_so" type="button" class="egov-button-normal">
					Trả hồ sơ lại nơi gửi
				</button>
				<button type="button" class="egov-button-normal egov-popup-closer" popup-id="popup_tu_choi_ho_so">
					Đóng
				</button>
			</div>
		</div>
	</form>
</div>