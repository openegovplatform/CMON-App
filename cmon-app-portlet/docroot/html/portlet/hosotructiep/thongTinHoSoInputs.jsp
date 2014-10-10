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
<%@page import="java.util.Date"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@page import="org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"%>
<%@page import="org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="egov" uri="/WEB-INF/tld/egov.tld"%>
<%
	boolean
		laBoSung = HSRParamUtil.getBoolean(request, "laBoSung")
	,	laTiepNhanLienThong = HSRParamUtil.getBoolean(request, "laTiepNhanLienThong")
	;
	
	long 
		hoSoId = HSRParamUtil.getLong(request, "hoSoId")
	,	hoSoLienThongId = HSRParamUtil.getLong(request, "hoSoLienThongId")
	,	thuTucId = 0L
	;
	
	String
		lucNhanHoSo = StringPool.BLANK
	,	ghiChuFileDinhKem = StringPool.BLANK
	,	moTaGiayToKhac = StringPool.BLANK
	,	lienKetGiayToKhac = StringPool.BLANK
	,	tenCoQuanKhoiTaoLienThong = StringPool.BLANK
	;
	
	CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
	
	if (laBoSung) {
		
		HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
		
		if (hoSo != null) {
			thuTucId = hoSo.getThuTucHanhChinhId();
			lucNhanHoSo = DateTimeUtil.getFullDateTime(hoSo.getNgayNopHoSo(), false);
			ghiChuFileDinhKem = GetterUtil.getString(hoSo.getGhiChuGiayToDinhKem());
			moTaGiayToKhac = GetterUtil.getString(hoSo.getMoTaThanhPhanHoSo());
			lienKetGiayToKhac = GetterUtil.getString(hoSo.getLienKetThanhPhanHoSo());
		} else {
			laBoSung = false;
		}
	}

	if (laTiepNhanLienThong) {
		HoSoLienThong hoSoLienThong = HoSoLienThongLocalServiceUtil.fetchHoSoLienThong(hoSoLienThongId);
		thuTucId = hoSoLienThong.getThuTucNhanId();
		tenCoQuanKhoiTaoLienThong = HSLTBusinessUtil.getTenCoQuanKhoiTaoLienThong(hoSoLienThong);
	}

	List<ThongTinThuTuc> dsThuTuc = HoSoBusinessUtil.getDSThuTuc2CanBo(congChuc);
	
	Date now = DateTimeUtil.getDateTimeNow();
	String
		dayNow = DateTimeUtil.getDayMonthYear(now)
	,	hourMinuteNow = DateTimeUtil.getHourMinute(now)
	;
%>
	<input type="hidden" name="<%=HoSoFields.coQuanQuanLyId%>" value="<%=congChuc.getCoQuanQuanLyId()%>" />
	<div class="fi clear">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					Loại hồ sơ
				</label>
				<label class="egov-label-red">*</label> 
			</div>
			<div class="fi-input">
				<select
					id="tthc_select" 
					class="egov-select"
					name="<%=HoSoFields.thuTucHanhChinhId%>"
					<%= (laTiepNhanLienThong || laBoSung) ? "disabled-by-script" : StringPool.BLANK %>
					auto-tooltip="true"
				>
					<option value="0" class="default">- Chọn loại hồ sơ - </option>
					<egov:option-list 
						data="<%= dsThuTuc %>"
						selectedValue="<%= thuTucId %>"
						isGroupable="<%= true %>"
						isDataSorted="<%= true %>"
					/>
				</select>
			</div>
		</div>
	</div>

<% if (laBoSung) { %>
	
	<div id="ngay_nhan_ho_so_display" class="clear fi septop10">
		<div class="fi-wrapper">
			<label class="egov-label highlight">
				Đã nhận hồ sơ lúc:
				<%= lucNhanHoSo %>
			</label>	
		</div>
	</div>
	
<% } %>
	
	<div class="clear fi fi25">
		<div class="fi-wrapper">
			<div class="fi-label pos-rel">
				<label id="ngay_nhan_ho_so_label" class="egov-label-bold">
				<% if (laBoSung) { %>
					Bổ sung hồ sơ ngày
				<% } else {%>
					Nhận hồ sơ ngày
				<% } %>
				</label>
				<label class="egov-label-red">*</label> 
			</div>
			<div class="fi-input">
				<input
					type="text"
					class="egov-calendar"
					name="<%=HoSoFields.ngayNhanHoSo%>"
					value="<%= dayNow %>"
					maxlength="10"
					disabled="disabled"
				/>
			</div>
		</div>
	</div>
	<div class="fi fi25">
		<div class="fi-wrapper">
			<div class="fi-label pos-rel">
				<label class="egov-label-bold">
					lúc
				</label>
				<label class="egov-label-red">*</label>
			</div>
			<div class="fi-input">
				<input
					type="text"
					name="<%=HoSoFields.gioPhutNhanHoSo%>"
					class="egov-inputfield egov-timepicker"
					value="<%= hourMinuteNow %>"
					maxlength="11"
					disabled="disabled"
				/>
			</div>
		</div>
	</div>
	<div class="fi fi25 ngay-hen-tra-loading">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					Hẹn trả hồ sơ ngày
				</label>
				<label class="egov-label-red">*</label> 
			</div>
			<div class="fi-input">
				<input
					type="text"
					class="egov-calendar"
					value=""
					name="<%=HoSoFields.ngayHenTraHoSo%>"
					maxlength="10"
				/>
			</div>
		</div>
	</div>
	<div class="fi fi25">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					lúc
				</label>
				<label class="egov-label-red">*</label> 
			</div>
			<div class="fi-input">
				<input
					type="text"
					name="<%=HoSoFields.gioPhutHenTraHoSo%>"
					class="egov-inputfield egov-timepicker"
					value=""
					maxlength="11"
				/>
			</div>
		</div>
	</div>
	<div class="clear fi fi25">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					Số bộ hồ sơ
				</label>
				<label class="egov-label-red">*</label> 
			</div>
			<div class="fi-input">
				<input
					type="text"
					class="egov-inputfield"
					value="1"
					name="<%=HoSoFields.soBoHoSo%>"
					maxlength="1"
				/>
			</div>
		</div>
	</div>
	<div class="fi fi25">
		<div class="fi-wrapper">
			<div class="fi-label pos-rel">
				<label class="egov-label-bold">
					Lệ phí (VNĐ)
				</label>
				
				<% if (laTiepNhanLienThong) { %>
					<div
						class="egov-func-comment egov-tooltip-target pos-abs"
						style="top:0; left: 85px"
						tooltip="Lệ phí/phí công dân đã nộp ở <%= tenCoQuanKhoiTaoLienThong %>"
					>&nbsp; </div>
				<% } %>
				
			</div>
			<div class="fi-input">
				<input
					type="text"
					class="egov-inputfield vn-num"
					numsetting="10.0"
					value=""
					name="<%=HoSoFields.lePhiHoSo%>"
					maxlength="10"
					<%= (laBoSung || laTiepNhanLienThong) ? StringPool.DISABLED : StringPool.BLANK %>
				/>
			</div>
		</div>
	</div>
	<div class="fi fi25">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					Phí (VNĐ)
				</label>
			</div>
			<div class="fi-input">
				<input
					type="text"
					class="egov-inputfield vn-num"
					numsetting="10.0"
					name="<%=HoSoFields.phiHoSo%>"
					maxlength="10"
					<%= (laBoSung || laTiepNhanLienThong) ? StringPool.DISABLED : StringPool.BLANK %>
				/>
			</div>
		</div>
	</div>
	<div class="fi fi25">
		<div class="fi-wrapper">
			<div class="fi-label pos-rel">
				<label class="egov-label-bold">
					Số ngày giải quyết
				</label>
				<label class="egov-label-red">*</label>
				<div
					id="so_ngay_xu_ly_comment"
					class="egov-func-comment egov-tooltip-target pos-abs"
					style="top:0; left: 133px"
					tooltip="Nếu xử lý xong trong ngày thì nhập 0 <br>Sau đó nhấn Enter và chọn giờ phút hẹn trả thích hợp"
					default-tooltip="Nếu xử lý xong trong ngày thì nhập 0<br>Sau đó nhấn Enter và chọn giờ phút hẹn trả thích hợp"
				>&nbsp; </div>
			</div>
			<div class="fi-input pos-rel">
				<input
					type="text"
					class="egov-inputfield"
					value=""
					name="<%=HoSoFields.soNgayXuLy%>"
					maxlength="3"
				/>
			</div>
		</div>
	</div>

<% if (laBoSung) { %>
	<div class="fi clear sepbot10" id="ghi_chu_bo_sung_ctn">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					Ghi chú bổ sung hồ sơ
				</label>
			</div>
			<div class="fi-input">
				<textarea class="egov-textarea" maxlength="200" name="<%=HoSoFields.ghiChuBoSung%>"></textarea>
			</div>
		</div>
	</div>
<% } %>
	<div class="hidden-sep">&nbsp;</div>
	<div class="group-title">
		<label class="lv2-title-text">
			Thành phần hồ sơ theo quy định
		</label>
	</div>
	<div id="giay_to_quy_dinh_grid" class="clear result-grid-ctn">
		<table class="egov-table result-grid sg">
			<thead>
				<tr>
					<th class="autowidth">STT</th>
					<th>Mô tả</th>
					<th class="center egov-tooltip-target" tooltip="Đã nhận giấy tờ này này hay chưa">
						Đã nhận
						<input id="_check_all_da_nhan" type="checkbox" class="egov-checkbox" />
					</th>
					<th class="center">
						Bản chính
						<input id="_check_all_ban_chinh" type="checkbox" class="egov-checkbox" />
					</th>
					<th>Tập tin đính kèm</th>
					<th class="autowidth">Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<tr>	
					<td class="center autowidth">
						<label field="stt" class="egov-label"></label>
						<input type="hidden" name="<%=HoSoFields.thuTuc2GiayToId%>" />
						<input type="hidden" name="<%=HoSoFields.loaiGiayToId%>" />
						<input type="hidden" name="<%=HoSoFields.tenGiayToQuyDinh%>" />
						<input type="hidden" name="<%=HoSoFields.fileDinhKemId%>" />
					</td>
					<td>
						<label field="<%=HoSoFields.tenGiayToQuyDinh%>" class="egov-label">&nbsp;</label>
					</td>
					<td class="center autowidth"  title="Đã nhận giấy tờ này này hay chưa">
						<input field="index" type="checkbox" name="<%=HoSoFields.daNhan%>" class="egov-checkbox" />
					</td>
					<td class="center autowidth">
						<input field="index" type="checkbox" name="<%=HoSoFields.banChinhGiayToQuyDinh%>" class="egov-checkbox" />
					</td>
					<td>
						<input uniqueid="true" type="file" name="<%=HoSoFields.fileGiayToQuyDinh%>" class="egov-uploadfile" />
					</td>
					<td class="center">
						<button type="button" fn="delete" class="egov-func-delete delete-btn">&nbsp;</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="fi clear">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					Ghi chú thành phần hồ sơ
				</label>
			</div>
			<div class="fi-input">
				<textarea class="egov-textarea" maxlength="500" name="<%=HoSoFields.ghiChuFileDinhKem%>"
				><c:out value="<%= ghiChuFileDinhKem %>" /></textarea>
			</div>
		</div>
	</div>
	<div class="hidden-sep">&nbsp;</div>
	<div class="group-title">
		<label class="lv2-title-text">
			Thành phần khác (nếu có)
		</label>
	</div>
	<div class="fi clear">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					Mô tả giấy tờ
				</label>
			</div>
			<div class="fi-input">
				<input
					type="text"
					class="egov-inputfield"
					value='<c:out value="<%= moTaGiayToKhac %>"/>'
					name="<%=HoSoFields.moTaGiayToKhac%>"
					maxlength="200"
				/>
			</div>
		</div>
	</div>
	<div class="fi clear">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					Liên kết tải giấy tờ
				</label>
			</div>
			<div class="fi-input">
				<input
					type="text"
					class="egov-inputfield"
					value='<c:out value="<%= lienKetGiayToKhac %>"/>'
					name="<%=HoSoFields.lienKetGiayToKhac%>"
					maxlength="500"
				/>
			</div>
		</div>
	</div>
	
<script type="text/javascript">

$(function() {
	
	// Constants from server
	var
		FIELD_NGAYNHANHOSO = '<%=HoSoFields.ngayNhanHoSo%>'
	,	FIELD_NGAYHENTRAHOSO = '<%=HoSoFields.ngayHenTraHoSo%>'
	,	FIELD_GIOPHUTHENTRAHOSO = '<%=HoSoFields.gioPhutHenTraHoSo%>'
	,	FIELD_GIOPHUTNHANHOSO = '<%=HoSoFields.gioPhutNhanHoSo%>'
	,	FIELD_THUTUCID = '<%=HoSoFields.thuTucHanhChinhId%>'
	,	FIELD_SONGAYXULY = '<%=HoSoFields.soNgayXuLy%>'
	,	FIELD_FILEGIAYTOQUYDINH = '<%=HoSoFields.fileGiayToQuyDinh%>'
	,	FIELD_DANHAN = '<%=HoSoFields.daNhan%>'
	,	FIELD_LABANCHINH = '<%=HoSoFields.banChinhGiayToQuyDinh%>'
	,	FIELD_THONGTINTHUTUC = '<%=HoSoFields.thongTinThuTuc%>'
	,	FIELD_DSGIAYTOQUYDINH = '<%=HoSoFields.dsGiayToQuyDinh%>'
	,	FIELD_COQUANQUANLYID = '<%=HoSoFields.coQuanQuanLyId%>'
	,	FIELD_HOSOID = '<%=HoSoFields.hoSoId%>'
	,	FIELD_LATIEPNHANKHOITAOHSLT = '<%=HSLTFields.laTiepNhanKhoiTaoLienThong%>'
	,	FIELD_FILEDINHKEMID = '<%=HSLTFields.fileDinhKemId%>'
	,	FIELD_TENGIAYTO = '<%=HSLTFields.tenGiayToQuyDinh%>'
	,	FIELD_LABOSUNG = '<%=HoSoFields.laBoSung%>'
	,	FIELD_DSTENCOQUANLIENTHONG = '<%=HSLTFields.dsTenCoQuanLienThong%>'
	;
	
	var
	
	// FORM CHÍNH Ở FILE JSP NƠI GỌI
		$form = $('#main_form')
	
	,	hoSoId = <%= hoSoId %>
	,	laBoSung = <%= laBoSung %>
	
	// datepicker
	,	$ngayNhanHoSo = $form.findInput(FIELD_NGAYNHANHOSO)
	,	$ngayHenTraHoSo = $form.findInput(FIELD_NGAYHENTRAHOSO)
	
	// timepicker
	,	$gioPhutHenTraHoSo = $form.findInput(FIELD_GIOPHUTHENTRAHOSO)
	,	$gioPhutNhanHoSo = $form.findInput(FIELD_GIOPHUTNHANHOSO)
	
	// Ajax
	,	hoSoThuTucInfoAjax = Ajax.forURL('<%=LiferayURL.createAjaxURL(request, "serveThongTinHoSoThuTuc")%>')
	,	ngayHenTraAjax = Ajax.forURL('<%=LiferayURL.createAjaxURL(request, "serveNgayHenTra")%>')
	
	// jQuery elems
	,	$selThuTuc = $form.findInput(FIELD_THUTUCID)
	,	$soNgayXuLy = $form.findInput(FIELD_SONGAYXULY)
	,	$giayToGrid = $('#giay_to_quy_dinh_grid')
	,	$checAllDaNhan = $('#_check_all_da_nhan')
	,	$checAllBanChinh = $('#_check_all_ban_chinh')
	,	$soNgayXuLyComment = $('#so_ngay_xu_ly_comment')
	
	// Grid
	,	giayToGrid = null
	
	// Callbacks
	,	onThuTucAjaxSuccess = null
	,	onNgayHenTraAjaxSuccess = null
	;
	
	//KHAI BÁO GLOBAL FUNCTIONS CÓ THỂ ĐƯỢC TRUY XUẤT TỪ JAVASCRIPT Ở FILE JSP NƠI GỌI FILE NÀY
	window.globalFunctions = 
	{
		getThuTucIdDuocChon: function() {
			return VarUtil.getInteger($selThuTuc.val());
		},
		
		onThuTucAjaxSuccess: function(callback) {
			onThuTucAjaxSuccess = callback;
		},
		
		focusThuTucSelect: function() {
			$selThuTuc.scrollToMe(function() { $selThuTuc.focus(); });
		},
		
		focusGiayToGrid: function() {
			$giayToGrid.scrollToMe();
		},
		
		getUploadedFileWillBeDeleted: function() {
			var out = [], rowIndex, data;
			$giayToGrid.findInput(FIELD_DANHAN).each(function() {
				rowIndex = this.value;
				data = giayToGrid.getRowData(rowIndex);
				if (data[FIELD_FILEDINHKEMID] !== 0 && !this.checked) {
					out.push(data[FIELD_TENGIAYTO]);
				}
			});
			return out;
		}
	};
	
	// Setting ajax global, disable submit button before request, and enable it after all
	Ajax.global()
		.onBefore(function() {
			$form.find('[type="submit"]').prop('disabled', true);
		})
		.onComplete(function() {
			$form.find('[type="submit"]').prop('disabled', false);
		});
	
	// LOCAL FUNCTIONS
	function updateNgayTra() {
		var nod = VarUtil.getInteger($soNgayXuLy.val());
		if (nod > -1) {
			if (nod === 0) {
				$ngayHenTraHoSo.val($ngayNhanHoSo.val());
				$gioPhutHenTraHoSo.focus();
			} else {
				ngayHenTraAjax
					.setRequestParam($ngayNhanHoSo.prop('name'), $ngayNhanHoSo.val())
					.setRequestParam($soNgayXuLy.prop('name'), $soNgayXuLy.val())
					.setRequestParam($selThuTuc.prop('name'), $selThuTuc.val())
					.setRequestParam(FIELD_HOSOID, hoSoId)
					.run()
				;
			}
		}
	}
	
	ngayHenTraAjax
		.setLoading('.ngay-hen-tra-loading', true)
		.onSuccess(function(response) {
			$ngayHenTraHoSo.val(response[FIELD_NGAYHENTRAHOSO]);
			$gioPhutHenTraHoSo.timepicker('setTime', $gioPhutNhanHoSo.timepicker('getTime'));
			
			var laTiepNhanKhoiTaoHSLT = response[FIELD_LATIEPNHANKHOITAOHSLT]
			,	soNgayXuLyTooltip = ''
			;
			
			// Lan tiep nhan dau tien trong chuoi lien thong
			if (laTiepNhanKhoiTaoHSLT) {
				
				// Cong don so ngay xu ly cua cac co quan tiep nhan lien thong
				$soNgayXuLy.val(response[FIELD_SONGAYXULY]);
				var tenCacCoQuanLienThong = response[FIELD_DSTENCOQUANLIENTHONG].join(' và ');
				soNgayXuLyTooltip = 'Đã bao gồm số ngày xử lý dự kiến của ' + tenCacCoQuanLienThong;
				
				$soNgayXuLyComment.egovTooltip('option', 'content', soNgayXuLyTooltip);
				$soNgayXuLyComment.egovTooltip('open');
				setTimeout(
					function() {
						$soNgayXuLyComment.egovTooltip('close');
					},
					5000
				);
				
			} else {
				soNgayXuLyTooltip = $soNgayXuLyComment.attr('default-tooltip');
				$soNgayXuLyComment.egovTooltip('option', 'content', soNgayXuLyTooltip);
			}

			if ($.isFunction(onNgayHenTraAjaxSuccess)) {
				onNgayHenTraAjaxSuccess(response);
			}
		});
	
	giayToGrid = new SimpleGrid({
		grid: $giayToGrid,
		deleteFn: function(data) {
			var $row = this;
			$row.fillData(data);
			$row.findInput(FIELD_DANHAN).enable();
		}
	});
	
	giayToGrid
		.bindEvent('[name="' + FIELD_FILEGIAYTOQUYDINH + '"]', 'change', 
			function() {
				$(this).closest('tr').findInput(FIELD_DANHAN).check().disable();
			}
		)
		.bindEvent('[name="' + FIELD_DANHAN + '"]', 'click', 
			function() {
				if (!this.checked) {
					$checAllDaNhan.uncheck();
				}
			}
		)
		.bindEvent('[name="' + FIELD_LABANCHINH + '"]', 'click', 
			function() {
				if (!this.checked) {
					$checAllBanChinh.uncheck();
				}
			}
		)
		;
	
	hoSoThuTucInfoAjax
		.setLoading($giayToGrid)
		.onSuccess(function(response) {
			$form.fillData(response[FIELD_THONGTINTHUTUC]);
			giayToGrid.fill(response[FIELD_DSGIAYTOQUYDINH]);
			updateNgayTra();
			
			if ($.isFunction(onThuTucAjaxSuccess)) {
				onThuTucAjaxSuccess(response[FIELD_THONGTINTHUTUC]);
			}
		});
	
	$selThuTuc.change(function() {
		if (this.value !== '0') {
			hoSoThuTucInfoAjax
				.setRequestParam(this.name, this.value)
				.setRequestParam( FIELD_COQUANQUANLYID, $form.findInput(FIELD_COQUANQUANLYID).val() )
				.setRequestParam(FIELD_HOSOID, hoSoId)
				.setRequestParam(FIELD_LABOSUNG, laBoSung ? 1 : 0)
				.run()
			;
		}
	});
	
	$soNgayXuLy
		.change(updateNgayTra)
		.keydown(function(ev) {
			if (ev.which === 13) {
				updateNgayTra();
			}
		});
	;
	
	$gioPhutNhanHoSo.timepicker('option', 'onClose', updateNgayTra);
	
	$ngayNhanHoSo.datepicker('option', 'onSelect', 
		function() {
			$gioPhutNhanHoSo.focus();
			updateNgayTra();
		}
	);
	
	$ngayHenTraHoSo.datepicker('option', 'onSelect', 
		function() {
			$gioPhutHenTraHoSo.focus();
		}
	);

	$checAllDaNhan.click(function() {
		var checked = this.checked;
		$giayToGrid.findInput(FIELD_DANHAN).each(function() {
			if (!this.disabled) {
				$(this).check(checked);
			}
		});
	});
	
	$checAllBanChinh.click(function() {
		$giayToGrid.findInput(FIELD_LABANCHINH).check(this.checked);
	});
	
	// Load default data
	$selThuTuc.trigger('change');
	
});
	
</script>