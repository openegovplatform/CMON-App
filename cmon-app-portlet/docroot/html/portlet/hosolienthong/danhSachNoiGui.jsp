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
<%@page import="org.oep.cmon.util.CmonFields"%>
<%@page import="org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoFields"%>
<%@page import="org.oep.egovcore.language.BusinessMessagerUtil"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="egov" uri="/WEB-INF/tld/egov.tld"%>
<%
	CongChuc canBo = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
	List<ThongTinThuTuc> dsThuTuc = HSLTBusinessUtil.getDSThuTucLienThongNoiGui2CanBo(canBo);
	
	String chiTietHoSoURL = LiferayURL
		.createRenderURL(request, Constants.DEFAULT_PORTLET_NAME, "/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp")
		.setParameter("loaiCanBo", Constants.LOAI_CAN_BO.LOAI_CAN_BO_XU_LY)
		.setParameter(CmonFields.backURL, PortalUtil.getCurrentCompleteURL(request))
		.toString()
		.concat("&idHoSo=")
	;
%>

<script type="text/javascript">

$(function() {
	
	var fields = {};
	fields.hoSoLienThongId = '<%=HSLTFields.hoSoLienThongId%>';
	fields.hoSoId = '<%=HSLTFields.hoSoId%>';
	fields.daTraKetQua = '<%=HSLTFields.daTraKetQua%>';
	fields.yeuCauRutURL = '<%=HSLTFields.yeuCauRutURL%>';
	fields.coTheYeuCauRut = '<%=HSLTFields.coTheYeuCauRut%>';
	fields.coTheXemChiTiet = '<%=HSLTFields.coTheXemChiTiet%>';
	fields.coTheGuiLienThongLai = '<%=HSLTFields.coTheGuiLienThongLai%>';
	
	var
		nhanKQURL = '<%=LiferayURL.createAjaxURL(request, "processNhanKetQuaXuLyLienThong")%>'
	,	chiTietHoSoURL = '<%=chiTietHoSoURL%>'
	,	nhanKQAjax = new Ajax().setLoading(SCREEN_LOADING)
	,	chiTietTuChoiAjax = Ajax.forURL('<%=LiferayURL.createAjaxURL(request, "serveChiTietTuChoi")%>')
	,	guiLienThongAjax = Ajax.forURL('<%=LiferayURL.createAjaxURL(request, "processGuiHoSoLienThong")%>')
	,	_searchURL = '<%=LiferayURL.createAjaxURL(request, "searchHoSoLienThongNoiGui")%>'
	,	searchGrid
	,	$popup = $('#popup_chi_tiet_tu_choi').egovPopup('Chi tiết từ chối hồ sơ', 600)
	,	$grid = $('#grid_ho_so_lien_thong')
	,	$btnGuiLaiLienThong = $('#button_gui_lai_lien_thong')
	,	$guiLienThongForm = $('#gui_lien_thong_form')
	;
	
	searchGrid = new Ajax.SearchGrid({
		grid: $grid,
		form: '#form_ho_so_lien_thong',
		searchURL: _searchURL,
		afterAddRow: function(data) {
			var $row = this
			,	$linkChiTiet
			;
			
			$linkChiTiet = $row.find('.chi-tiet-ho-so-link');
			
			if (data[fields.coTheXemChiTiet]) {
				$linkChiTiet.attr('href', chiTietHoSoURL + data[fields.hoSoId]);
			} else {
				$linkChiTiet.closest('td').append($linkChiTiet.children());
				$linkChiTiet.remove();
			}
			
			if (data[fields.daTraKetQua]) {
				
				$row.find('.nhanketqua')
					.show()
					.attr('href', nhanKQURL.urlParam(fields.hoSoLienThongId, data[fields.hoSoLienThongId]));
				
			}
			
			if (data[fields.coTheGuiLienThongLai]) {
				
				$row.find('.gui-lien-thong-lai')
					.show()
					.prop('id', data[fields.hoSoLienThongId]);
			}
			
			if (data[fields.coTheYeuCauRut]) {
				
				$row.find('.yeu-cau-rut-link')
					.show()
					.attr('href', data[fields.yeuCauRutURL]);
			}
		}
	});
	
	searchGrid
		.bindEvent('.nhanketqua', 'click',
			function(ev) {
				nhanKQAjax.setURL($(this).attr('href')).run();
				ev.preventDefault();
			}
		)
		.bindEvent('.gui-lien-thong-lai', 'click',
			function(ev) {
				chiTietTuChoiAjax
					.setRequestParam(fields.hoSoLienThongId, $(this).prop('id'));
				$popup.dialog('open');
				ev.preventDefault();
			}
		)
	;
	
	chiTietTuChoiAjax
		.setLoading($popup)
		.onSuccess(function(response) {
			$btnGuiLaiLienThong.show();
			$popup.fillData(response);
		});
	
	$popup.bind('dialogopen', function(ev) {
		chiTietTuChoiAjax.run();
	});
	
	$('#sel_loai_ho_so, #sel_trang_thai_lien_thong').change(function() {
		searchGrid.load();
	});
	
	guiLienThongAjax.setForm($guiLienThongForm);
	$btnGuiLaiLienThong.click(function() {
		guiLienThongAjax.run();
	});

	searchGrid.load();
});

</script>
<div class="_outer egov-container">
	<div class="hidden-sep">&nbsp;</div>
	<div class="_wrapper">
		<h1 class="lv1-title">
			<label id="main_title" class="lv1-title-text">
				Danh sách hồ sơ liên thông - đơn vị gửi
			</label>
		</h1>
		<form id="form_ho_so_lien_thong" method="post" autocomplete="off" action=''>
			<div class="fi fi70">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Loại hồ sơ
						</label>
					</div>
					<div class="fi-input">
						<select
							id="sel_loai_ho_so"
							class="egov-select"
							name="<%=HSLTFields.thuTucGuiId%>"
							auto-tooltip="true"
						>
							<option class="default" value="0">Tất cả</option>
							<egov:option-list 
								data="<%=dsThuTuc%>"
								isGroupable="<%=true%>"
								isDataSorted="<%= true %>"
							/>
						</select>
					</div>
				</div>
			</div>
			<div class="fi fi30">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Trạng thái liên thông
						</label>
					</div>
					<div class="fi-input">
						<select id="sel_trang_thai_lien_thong" class="egov-select" name="<%=HSLTFields.trangThaiLienThong%>">
							<option value="0">
								Tất cả
							</option>
							<option value="<%=HSLTBusinessUtil.TTLT_CHO_TIEP_NHAN%>">
								<%=HSLTBusinessUtil.getTenTrangThaiLienThong(request, HSLTBusinessUtil.TTLT_CHO_TIEP_NHAN)%>
							</option>
							<option value="<%=HSLTBusinessUtil.TTLT_DA_TIEP_NHAN%>">
								<%=HSLTBusinessUtil.getTenTrangThaiLienThong(request, HSLTBusinessUtil.TTLT_DA_TIEP_NHAN)%>
							</option>
							<option value="<%=HSLTBusinessUtil.TTLT_DA_TRA_KET_QUA%>">
								<%=HSLTBusinessUtil.getTenTrangThaiLienThong(request, HSLTBusinessUtil.TTLT_DA_TRA_KET_QUA)%>
							</option>
							<option value="<%=HSLTBusinessUtil.TTLT_DA_NHAN_KET_QUA%>">
								<%=HSLTBusinessUtil.getTenTrangThaiLienThong(request, HSLTBusinessUtil.TTLT_DA_NHAN_KET_QUA)%>
							</option>
							<option value="<%=HSLTBusinessUtil.TTLT_DA_TU_CHOI%>">
								<%=HSLTBusinessUtil.getTenTrangThaiLienThong(request, HSLTBusinessUtil.TTLT_DA_TU_CHOI)%>
							</option>
						</select>
					</div>
				</div>
			</div>
		</form>
		
		<div class="septop10 sepbot10 sepleft5">
			<label class="egov-label hint">Chú thích viết tắt ở cột "Trạng thái":</label>
			<label class="egov-label hint strong">ĐV=Đơn vị</label>
			&nbsp;&nbsp;&nbsp;
			<label class="egov-label hint strong">KQ=Kết quả</label>
		</div>
		
		<div id="grid_ho_so_lien_thong" class="result-grid-ctn">
			<table class="egov-table result-grid" >
				<thead>
					<tr>
						<th style="width: 1%">STT</th>
						<th>Loại hồ sơ</th>
						<th>Mã biên nhận</th>
						<th>Công dân nộp</th>
						<th>Gửi lúc</th>
						<th>Đơn vị nhận</th>
						<th>Trạng thái</th>
						<th class="center">Thao<br>tác</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="center">
							<label field="stt" class="egov-label"></label>
							<input type="hidden" name="<%=HSLTFields.hoSoLienThongId%>" />
							<input type="hidden" name="<%=HSLTFields.hoSoId%>" />
						</td>
						<td>
							<a class="chi-tiet-ho-so-link" href="#">
								<label field="<%=HSLTFields.tenThuTucGui%>" class="egov-label"></label>
							</a>
						</td>
						<td>
							<label field="<%=HSLTFields.maSoBienNhanLucGui%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.hoTenNguoiNopHoSo%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.lucGui%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.tenCoQuanNhan%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.tenTrangThaiLienThong%>" class="egov-label"></label>
						</td>
						<td class="center autowidth">
							<a href="#" 
								class="nhanketqua btn-16 egov-tooltip-target"
								tooltip="Nhận kết quả xử lý liên thông"
								tooltip-no-wrap-text="true"
								style="display: none;"
							>&nbsp;</a>
							<a href="#"
								class="gui-lien-thong-lai btn-16 icon-13 egov-tooltip-target"
								tooltip="Gửi lại hồ sơ liên thông"
								tooltip-no-wrap-text="true"
								style="display: none;"
							>&nbsp;</a>
							<a href="#"
								class="yeu-cau-rut-link stop-deny btn-16 egov-tooltip-target"
								tooltip="Yêu cầu rút hồ sơ"
								tooltip-no-wrap-text="true"
								style="display: none;"
							>&nbsp;</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="hidden-sep">&nbsp;</div>
	</div>
</div>

<div id="popup_chi_tiet_tu_choi" style="display: none;">
	<div class="_wrapper septop20 mix">
		<div class="line">
			<div class="item">
				<label class="egov-label strong">Hồ sơ:</label>
				<label class="egov-label" field="<%= HSLTFields.tenThuTucGui %>"></label>
			</div>
		</div>
		<div class="line">
			<div class="item">
				<label class="egov-label strong">Công dân nộp:</label>
				<label class="egov-label" field="<%= HSLTFields.hoTenNguoiNopHoSo %>"></label>
			</div>
		</div>
		<div class="line">
			<div class="item">
				<label class="egov-label strong">Gửi liên thông lúc:</label>
				<label class="egov-label" field="<%= HSLTFields.lucGui %>"></label>
			</div>
		</div>
		<div class="line">
			<div class="item">
				<label class="egov-label strong">Đã bị từ chối lúc:</label>
				<label class="egov-label" field="<%= HSLTFields.lucTuChoi %>"></label>
			</div>
		</div>
		<div class="line">
			<div class="item">
				<label class="egov-label strong">Ghi chú/lý do từ chối:</label>
				<label class="egov-label" field="<%= HSLTFields.yKienTuChoi %>"></label>
			</div>
		</div>
		<div class="line">
			<div class="item fi50">
				<label class="egov-label strong">Cán bộ từ chối:</label>
				<label class="egov-label" field="<%= HSLTFields.hoTenCanBoTuChoi %>"></label>
			</div>
			<div class="item fi50">
				<label class="egov-label strong">Đơn vị:</label>
				<label class="egov-label" field="<%= HSLTFields.tenCoQuanNhan %>"></label>
			</div>
		</div>
		
		<form id="gui_lien_thong_form">
			<div class="fi clear">
				<input type="hidden" name="<%=HSLTFields.hoSoId%>" value="" />
				<input type="hidden" name="<%=HSLTFields.thuTucNhanId%>" value="" />
				<input type="hidden" name="<%=HSLTFields.coQuanNhanId%>" value="" />
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
				<button id="button_gui_lai_lien_thong" class="egov-button-normal" type="button">
					Gửi lại hồ sơ này
				</button>
				<button class="egov-button-normal egov-popup-closer" type="button" popup-id="popup_chi_tiet_tu_choi">
					Đóng
				</button>
			</div>
		</form>
	</div>
</div>