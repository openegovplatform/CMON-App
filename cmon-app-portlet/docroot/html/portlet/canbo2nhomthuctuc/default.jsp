/<!-- 
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
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.portlet.canbo2nhomthuctuc.CB2NTTFields"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%
	CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
	CoQuanQuanLy coQuan = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(congChuc.getCoQuanQuanLyId());
	if (coQuan == null) {
%>
	<script type="text/javascript">
	$alert(
		'Tài khoản của bạn chưa được cấu hình cơ quan trực thuộc <br> congChucId:<%=congChuc.getId()%>',
		function() {
			location.replace('/');						
		}
	);
	</script>
<%
	return;
	}
	
	long coQuanId = coQuan.getId();
	List<CoQuanQuanLy> phongBans = CoQuanQuanLyLocalServiceUtil.getDSPhongBanNoiBo(coQuanId);
%>

<style type="text/css">
#checkbox_ctn .checker {
	margin-bottom: 15px;
}
#checkbox_ctn .checker:first-child {
	margin-top: 12px;
	margin-bottom: 13px;
}
</style>

<script type="text/javascript">
$(function() {
	var $form, $selCoQuan, $selCanBo1, $selNhomThuTuc, $showSelCanBoMulti,
	canBoAjax, nhomThuTucCoQuanAjax, nhomThuTucCanBoAjax,
	$checkboxCtn, $checkboxTpl
	,	dsCauHinhEditCongDan = {}
	,	dsNhomThuTucDaChonId = []
	;
	
	$form = $('#main_form');
	$selCoQuan = $('#sel_co_quan');
	$selCanBo1 = $('#sel_can_bo1');
	$selCanBoMulti = $('#sel_can_bo_multi');
	$selCanBoMultiCtn = $('#sel_can_bo_multi_ctn');
	$selNhomThuTuc = $form.findInput('<%=CB2NTTFields.nhomThuTucId%>');
	$showSelCanBoMulti = $('#show_sel_can_bo_multi');
	$submitBtn = $('#submit_btn');
	$checkboxCtn = $('#checkbox_ctn');
	$checkboxTpl = $checkboxCtn.children().clone();
	$checkboxTpl = $checkboxCtn.children().clone();
	;
	
	$checkboxCtn.empty();
	
	function hienThiCanBoCanApDung() {
		$selCanBoMultiCtn.show();
		$showSelCanBoMulti.parent().hide();
		$selCanBoMulti.find('option').each(function() {
			$(this).prop('selected', true);
		});
		$selCanBoMulti.egovSelectUI();
	}
	
	// Fill checkbox after ajax load
	function fillCheckbox() {
		
		$checkboxCtn.empty();
		for (var index = 0; index < dsNhomThuTucDaChonId.length; ++ index) {
				
			var $checkboxUI = $checkboxTpl.clone().attr('index', index)
			,	$checkbox = $checkboxUI.findInput('<%=CB2NTTFields.duocPhepEditCongDan%>')
			;
			
			$checkbox.val(dsNhomThuTucDaChonId[index]);
			
			$checkboxCtn.append($checkboxUI).append('<br>');
			
			var key = 'i' + dsNhomThuTucDaChonId[index];
			if (dsCauHinhEditCongDan[key]) {
				$checkbox.check();
			} else {
				$checkbox.uncheck();
			}
		}
	}
	
	canBoAjax = Ajax.forURL('<%=LiferayURL.createAjaxURL(request, "serveDSCanBo")%>')
		.setLoading('#sel_can_bo1_ctn', true)
		.onSuccess(function(response) {
			var data = response.<%=CB2NTTFields.dsCanBo%>;
			$selCanBo1.fillOptionHTML( data, '<%=CB2NTTFields.id%>', '<%=CB2NTTFields.ten%>' );
			$selCanBoMulti.fillOptionHTML( data, '<%=CB2NTTFields.id%>', '<%=CB2NTTFields.ten%>' );
			$showSelCanBoMulti.parent().hide();
			$selCanBoMultiCtn.hide();
		});
	
	nhomThuTucCoQuanAjax = Ajax.forURL('<%=LiferayURL.createAjaxURL(request, "serveDSNhomThuTucTheoCoQuan")%>')
		.setLoading('#nhom_thu_tuc_ctn', true)
		.onSuccess(function(response) {
			var data = response.<%=CB2NTTFields.dsNhomThuTuc%>;
			$selNhomThuTuc.fillOptionHTML( data, '<%=CB2NTTFields.id%>', '<%=CB2NTTFields.ten%>');
			if (data.length === 0) {
				$alert('Hiện chưa có thủ tục nào được cấu hình cho cơ quan/phòng ban vừa chọn !');
			}
		});
	
	nhomThuTucCanBoAjax = Ajax.forURL('<%=LiferayURL.createAjaxURL(request, "serveDSNhomThuTucTheoCanBo")%>')
		.setLoading('#nhom_thu_tuc_ctn', true)
		.onBefore(function() {
			$checkboxCtn.empty();
		})
		.onSuccess(function(response) {
			
			// GLOBAL
			dsNhomThuTucDaChonId = response.<%=CB2NTTFields.dsNhomThuTucDaChonId%>;
			dsCauHinhEditCongDan = response.<%=CB2NTTFields.dsCauHinhEditCongDan%>;
			
			$selNhomThuTuc.val(dsNhomThuTucDaChonId);
			fillCheckbox();
		});
	
	$selCoQuan.bind('change', function() {
		$selNhomThuTuc.prop('disabled', true);
		$submitBtn.prop('disabled', true);
		canBoAjax.setRequestParam('<%=CB2NTTFields.coQuanId%>', $selCoQuan.val())
			.run();
		nhomThuTucCoQuanAjax.setRequestParam('<%=CB2NTTFields.coQuanId%>',$selCoQuan.val())
			.run();
	});
	
	$selCanBo1.bind('change', function() {
		$selCanBo1.find('option.default').remove();
		nhomThuTucCanBoAjax.setRequestParam('<%=CB2NTTFields.canBoId%>', $selCanBo1.val())
			.run();
		$selCanBo1.egovSelectUI();
		var selectedIndex = this.selectedIndex;
		$('#ten_can_bo_duoc_chon').text($(this.options[selectedIndex]).text());
		$selNhomThuTuc.prop('disabled', false);
		$submitBtn.prop('disabled', false);
		
		var options = $selCanBoMulti.get(0).options
		,	$selectedOption;
		$.each(options, function(index, option) {
			$(option)
				.removeAttr('required')
				.prop('selected', false);
		});
		$selectedOption = $(options[selectedIndex]);
		$selectedOption.attr('required', 'required');
		$selectedOption.prop('selected', true);
		
		if ($selCanBoMultiCtn.is(':visible')) {
			hienThiCanBoCanApDung();
		} else {
			$showSelCanBoMulti.parent().show();
		}
	});
	
	$showSelCanBoMulti.bind('click', function(ev) {
		hienThiCanBoCanApDung();
		ev.preventDefault();
	});
	
	// Add/remove option UI => update checkbox
	$selNhomThuTuc.change(function(ev, params) {
		
		if (params.selected) {
			
			var $checkboxUI = $checkboxTpl.clone().attr('index', $checkboxCtn.find('.checker').length)
			,	$checkbox = $checkboxUI.findInput('<%=CB2NTTFields.duocPhepEditCongDan%>')
			;
			
			$checkbox.val(params.selected);
			$checkboxCtn.append($checkboxUI).append('<br>');
			
			if (dsCauHinhEditCongDan['i' + params.selected] === undefined 
				|| dsCauHinhEditCongDan['i' + params.selected]
			) {
				$checkbox.check();
			} else {
				$checkbox.uncheck();
			}
			
		} else {
			$checkboxCtn.find('input[name="<%=CB2NTTFields.duocPhepEditCongDan%>"]').each(
				function() {
					if (this.value == params.deselected) {
						var $checkboxUI = $(this).closest('.checker');
						$checkboxUI.next('br').remove();
						$checkboxUI.remove();
					}
				}
			);
		}
		
	});
	
	// Hover checkbox => hover option UI
	$checkboxCtn
		.delegate('.checker', 'mouseenter',
			function() {
				var ui = $.data($selNhomThuTuc.get(0), 'ui')
				,	index = $(this).attr('index')
				;
				$(ui).find('.chosen-choices .search-choice').eq(index).addClass('egov-option-ui-hover');
			}
		)
		.delegate('.checker', 'mouseleave',
			function() {
				var ui = $.data($selNhomThuTuc.get(0), 'ui')
				,	index = $(this).attr('index')
				;
					$(ui).find('.chosen-choices .search-choice').eq(index).removeClass('egov-option-ui-hover');
				}
		)
		;
	
	$selCoQuan.trigger('change');
});
</script>
<div class="_outer egov-container" style="min-height: 500px;">
	<div class="hidden-sep">&nbsp;</div>
	<div class="_wrapper">
		<h1 class="lv1-title">
			<label id="main_title" class="lv1-title-text">
				<c:out value="<%=coQuan.getTen()%>"/>
				<br>
				Cấu hình nhóm thủ tục cần tiếp nhận/xử lý cho cán bộ
			</label>
		</h1>
		<form
			id="main_form"
			method="post"
			autocomplete="off"
			class="egov-ajax-form"
			action='<%=LiferayURL.createAjaxURL(request, "processLuuCauHinh")%>'
		>
			
			<div class="fi">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Danh sách cơ quan/phòng ban
						</label>
					</div>
					<div class="fi-input">
						<select id="sel_co_quan" class="egov-select">
							<option value="<%=coQuanId%>"><c:out value="<%=coQuan.getTen()%>"/></option>
						<%
							for (CoQuanQuanLy item : phongBans) {
						%>
							<option value="<%=item.getId()%>">
								&nbsp;&nbsp;
								<c:out value="<%=item.getTen()%>"/>
							</option>
						<%
							}
						%>
						</select>
					</div>
				</div>
			</div>
			<div id="sel_can_bo1_ctn" class="fi clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Danh sách cán bộ trực thuộc
						</label>
					</div>
					<div class="fi-input">
						<select id="sel_can_bo1" class="egov-select egov-select-ui" required="true">
							<option value="0" class="default">Chọn cán bộ</option>
							
						</select>
					</div>
				</div>
			</div>
			<div id="nhom_thu_tuc_ctn" class="fi clear fi90">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Các nhóm thủ tục đã được cấu hình cho cán bộ 
						</label>
						<label id="ten_can_bo_duoc_chon" class="egov-label-bold">
							
						</label>
					</div>
					<div class="fi-input">
						<select
							multiple="multiple" 
							class="egov-multi-select egov-select-ui"
							name="<%=CB2NTTFields.nhomThuTucId%>"
							data-placeholder="Chọn các nhóm thủ tục"
						>
						</select>
					</div>
				</div>
			</div>
			<div class="fi fi10">
				<div class="fi-wrapper">
					<div class="fi-label egov-tooltip-target" tooltip="Được phép chỉnh sửa thông tin công dân hay không">
						<label class="egov-label-bold">
							Edit công dân
						</label>
					</div>
					<div id="checkbox_ctn" class="fi-input center">
						<input
							name="<%=CB2NTTFields.duocPhepEditCongDan%>"
							type="checkbox"
							class="egov-checkbox"
							value="1"
						/>
					</div>
				</div>
			</div>
			<div class="hidden-sep"></div>
			<div class="clear sepleft5 septop10" style="display: none;">
				<a class="font16" id="show_sel_can_bo_multi" href="#">
					Đồng thời áp dụng cấu hình trên cho các cán bộ ...
				</a>
			</div>
			<div id="sel_can_bo_multi_ctn" class="fi clear" style="display: none;">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Các cán bộ sẽ được áp dụng cấu hình trên
						</label>
					</div>
					<div class="fi-input">
						<select
							id="sel_can_bo_multi"
							multiple="multiple" 
							class="egov-multi-select"
							name="<%=CB2NTTFields.canBoId%>"
							data-placeholder="Chọn các cán bộ"
						>
						</select>
					</div>
				</div>
			</div>
			<div class="hidden-sep">&nbsp;</div>
			<div class="button-bar" style="margin-bottom: 200px;">
				<button id="submit_btn" disabled class="egov-button">Áp dụng cấu hình</button>
			</div>
			<div class="hidden-sep">&nbsp;</div>
		</form>
	</div>
</div>