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
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.portlet.tracuuhoso.TCHSFields"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
	div.egov-container {
		background-color: transparent !important; 
	}
	#tra_cuu_form_ctn {
		width: 350px;
	}
	#result_ctn {
		min-height: 383px;
	}
	#search_input {
		width: 300px !important;
	}
	.item-label {
		width: 20%;
	}
	.item-value {
		width: 80%;
		padding-left: 10px;
	}
	.wrap2 .item-label {
		width: 30%;
	}
	.wrap2 .item-value {
		width: 70%;
	}
	._left {
		float: left !important;
	}
</style>
<script type="text/javascript">
$(function() {
	var
		$searchInput = $('#search_input')
	,	$form = $('#tra_cuu_form')
	,	$result = $('#result')
	,	$noResult = $('#no_result')
	,	ajax = Ajax
			.forURL('<%= LiferayURL.createAjaxURL(request, "serveThongTinHoSo") %>')
			.setForm($form)
			.setLoading('#result_ctn')
	;
	
	function initSearchInputTooltip() {
		$searchInput.egovTooltip({
			content: 'Mời nhập chính xác 15 ký tự mã số biên nhận'
		});
		$searchInput.egovTooltip('disable');
	}
	
	function validateSearchInput() {
		return (/^\d{15}$/.test($searchInput.val().trim()));
	}
	
	function handlerInvalidSearchInput() {
		$searchInput.egovTooltip('enable');
		$searchInput.egovTooltip('open');
	}
	
	function doBeforeAjaxSearch() {
		
		$searchInput.egovTooltip('disable');
		
		// Prevent holding Enter Key make spam requests
		$searchInput.trigger('blur');
	}
	
	function doAfterAjaxSearchSuccess(response) {
		var isExist = response.<%= TCHSFields.isExist %>
		if (isExist) {
			$result.fillData(response.<%= TCHSFields.thongTinHoSo %>).show();
			$noResult.hide();
		} else {
			$result.hide();
			$noResult.show();
		}
	}
	
	function main() {
		
		// Events binding
		ajax
			.onBefore(doBeforeAjaxSearch)
			.onSuccess(doAfterAjaxSearchSuccess)
		;
		
		$form.submit(function(ev) {
			if ( validateSearchInput() ) {
				ajax.run();
			} else {
				handlerInvalidSearchInput();
			}
			ev.preventDefault();
		});
		
		initSearchInputTooltip();
	}
	
	main();
	
});
</script>
<div class="_outer egov-container">
	<div class="_wrapper">
		<h1 class="lv1-title">
			<label id="main_title" class="lv1-title-text">
				Tra cứu thông tin hồ sơ
			</label>
		</h1>
		<div id="tra_cuu_form_ctn" class="blockcenter">
			<form id="tra_cuu_form" class="clearfix">
				<div class="_left">
					<input
						id="search_input"
						type="text"
						class="egov-inputfield"
						name="<%=TCHSFields.maSoBienNhan%>"
						maxlength="15"
						placeholder="Nhập mã số biên nhận"
						autocomplete="off"
					/>
				</div>
				<div class="_left sepleft10">
					<button id="search_btn" type="submit" class="egov-button-search small">
						&nbsp;	
					</button>			
				</div>
			</form>
		</div>
		
		<div id="result_ctn" class="septop15">
			<div id="result" class="clearfix clear" style="display: none">
				<div class="_left fi55">
					<div class="wrap wrap1">
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Lĩnh vực
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.tenNhomThuTucHanhChinh%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Loại hồ sơ
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.tenThuTucHanhChinh%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Phí
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.phiHoSo%>"></label>
								<label class="egov-label">(VNĐ)</label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Mã số biên nhận
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.maSoBienNhan%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Người nộp
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.hoTenNguoiNopHoSo%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Email
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.email%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Địa chỉ
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.diaChiThuongTruDayDu%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Ngày tiếp nhận
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.ngayNhanHoSo%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Trạng thái
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.tenTrangThaiHoSo%>"></label>
							</div>
						</div>
					</div>
				</div>
				<div class="_left fi45">
					<div class="wrap wrap2 sepleft20">
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Nộp tại
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.tenCoQuanNhanHoSo%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Cách nộp
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.tenLoaiHoSo%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Lệ phí
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.lePhiHoSo%>"></label>
								<label class="egov-label">(VNĐ)</label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Chủ hồ sơ
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.chuSoHuu%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Điện thoại
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.dienThoaiChuHoSo%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Ngày hẹn trả kết quả
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.ngayHenTraHoSo%>"></label>
							</div>
						</div>
						<div class="line">
							<div class="item item-label">
								<label class="egov-label strong">
									Ngày trả thực tế
								</label>
							</div>
							<div class="item item-value">
								<label class="egov-label" field="<%= TCHSFields.ngayTraKetQuaThucTe%>"></label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="no_result" class="center" style="display: none;">
				<label class="egov-label highlight">
					Không có hồ sơ nào được tìm thấy, mời nhập mã biên nhận khác và tra cứu
				</label>
			</div>
		</div>
	</div>
</div>
	
