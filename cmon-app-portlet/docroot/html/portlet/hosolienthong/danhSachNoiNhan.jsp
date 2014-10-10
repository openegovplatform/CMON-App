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
<%@page import="org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="egov" uri="/WEB-INF/tld/egov.tld"%>
<%
	CongChuc canBo = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
	List<ThongTinThuTuc> dsThuTuc = HSLTBusinessUtil.getDSThuTucLienThongNoiNhan2CanBo(canBo);

	// Danh sach co quan lien thong buoc ke truoc
	List<CoQuanQuanLy> dsCoQuan = HSLTBusinessUtil.getDSCoQuanLienThongBuocKeTruoc(canBo.getCoQuanQuanLyId());
	LiferayURL tiepNhanURL = LiferayURL.createRenderURL(request, HSLTBusinessUtil.JSP_TIEPNHAN);
	tiepNhanURL.setParameter("backURL", PortalUtil.getCurrentCompleteURL(request));
%>

<script type="text/javascript">

$(function() {
	var
		_pkField = '<%=HSLTFields.hoSoLienThongId%>'
	,	FIELD_TRANTHAILIENTHONG = '<%=HSLTFields.trangThaiLienThong%>'
	,	TTLT_CHOTIEPNHAN = <%=HSLTBusinessUtil.TTLT_CHO_TIEP_NHAN%>
	,	searchGrid = undefined
	;
	searchGrid = new Ajax.SearchGrid({
		searchURL: '<%=LiferayURL.createAjaxURL(request, "searchHoSoLienThongNoiNhan")%>',
		grid: '#grid_ho_so_lien_thong',
		form: '#form_ho_so_lien_thong',
		pkField: _pkField,
		afterAddRow: function(rowData, index, pk) {
			
			$linkTiepNhan = this.find('.link-tiep-nhan');
			if (rowData[FIELD_TRANTHAILIENTHONG] === TTLT_CHOTIEPNHAN) {
				$linkTiepNhan.prop('href', $linkTiepNhan.prop('href').urlParam(_pkField, pk));
			} else {
				$linkTiepNhan.remove();
			}
		}
	});
	
	$('#sel_loai_ho_so, #sel_don_vi, #sel_trang_thai_lien_thong').change(function() {
		searchGrid.load();
	});
	
	searchGrid.load();
	
});

</script>

<div class="_outer egov-container">
	<div class="hidden-sep">&nbsp;</div>
	<div class="_wrapper">
		<h1 class="lv1-title">
			<label id="main_title" class="lv1-title-text">
				Danh sách hồ sơ liên thông - đơn vị nhận
			</label>
		</h1>
		<form id="form_ho_so_lien_thong" method="post" autocomplete="off">
			<div class="fi fi50">
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
							name="<%=HSLTFields.thuTucNhanId%>"
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
			<div class="fi fi25">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Đơn vị gửi
						</label>
					</div>
					<div class="fi-input">
						<select id="sel_don_vi" class="egov-select" name="<%=HSLTFields.coQuanGuiId%>">
							<option class="default" value="0">Tất cả</option>
							<% for(CoQuanQuanLy item : dsCoQuan) { %>
								<option value="<%=item.getId()%>"><c:out value="<%=item.getTen()%>"/></option>
							<% } %>
						</select>
					</div>
				</div>
			</div>
			<div class="fi fi25">
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
							<option value="<%=HSLTBusinessUtil.TTLT_CHO_TIEP_NHAN%>" selected="selected">
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
			<table class="egov-table result-grid" id="grid_ho_so_lien_thong">
				<thead>
					<tr>
						<th style="width: 1%">STT</th>
						<th>Loại hồ sơ</th>
						<th>Tên công dân nộp</th>
						<th>Địa chỉ công dân nộp</th>
						<th>Đơn vị gửi</th>
						<th>Cán bộ gửi</th>
						<th>Lúc gửi</th>
						<th>Trạng thái</th>
						<th style="width: 1%">Thao tác</th>
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
							<label field="<%=HSLTFields.tenThuTucNhan%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.hoTenNguoiNopHoSo%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.diaChiDayDuCongDanNop%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.tenCoQuanGui%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.hoTenCanBoGui%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.lucGui%>" class="egov-label"></label>
						</td>
						<td>
							<label field="<%=HSLTFields.tenTrangThaiLienThong%>" class="egov-label"></label>
						</td>
						<td class="center">
							<a 
								href="<%= tiepNhanURL %>" 
								class="link-tiep-nhan egov-func-detail btn-16 egov-tooltip-target"
								tooltip="Xem chi tiết và thực hiện tiếp nhận hoặc từ chối"
								tooltip-no-wrap-text="true"
							>&nbsp;</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="hidden-sep">&nbsp;</div>
	</div>
</div>