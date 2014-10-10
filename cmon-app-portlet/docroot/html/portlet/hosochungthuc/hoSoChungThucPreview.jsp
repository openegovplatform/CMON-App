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
<%@page import="org.oep.cmon.dao.chungthuc.service.ThanhPhanHoSoChungThucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="vn.dtt.sharedservice.cmon.consumer.citizen.ICitizenService"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.util.DateUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.HoSoChungThuc"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />

<%
renderResponse.setTitle("Chứng thực");
ICitizenService service = WebserviceFactory.getCmonService();
	
long idHoSo = ParamUtil.getLong(request, "idHoSo");
HoSoChungThuc hsChungThuc = HoSoChungThucLocalServiceUtil.getHoSoChungThuc(idHoSo);

%>

<div class="_outer egov-container">
	<div class="_wrapper">
			<h1 class="center clear septop20 sepbot20" style="padding: 15px 0">
				<label id="main_title" class="egov-label font20-bu">
					Hồ sơ chứng thực
				</label>
			</h1>

			<div class="fi clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Loại hồ sơ
						</label>
					</div>
					<div class="fi-input">
						<%= ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(hsChungThuc.getThuTucHanhChinhId()).getTen() %>
					</div>
				</div>
			</div>
			
			<div class="fi fi66 clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Sổ danh mục
						</label>
					</div>
					<div class="fi-input"> <%= SoDanhMucLocalServiceUtil.getSoDanhMuc(hsChungThuc.getSoDanhMucId()).getTenSo() %>
					</div>
				</div>
			</div>
			
			<div class="fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Số chứng thực
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getSoChungThuc() != null ? hsChungThuc.getSoChungThuc() : "" %>
					</div>
				</div>
			</div>
			
			<div class="fi  clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Tên chứng thực
						</label>
					</div>
					<div class="fi-input">
						<%= hsChungThuc.getTenChungThuc() != null ? hsChungThuc.getTenChungThuc() : "" %>
					</div>
				</div>
			</div>
			
			<div class="fi fi33 clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Người nộp hồ sơ
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getHoTenNguoiNopHoSo() != null ?  hsChungThuc.getHoTenNguoiNopHoSo() : "" %>
					</div>
				</div>
			</div>

			<div class="fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Chứng minh nhân dân
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getSoCMNDNguoiNop() != null ? hsChungThuc.getSoCMNDNguoiNop() : "" %>
					</div>
				</div>
			</div>
			
			<div class="fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Điện thoại di động
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getSoDienThoaiDiDongNguoiNop() != null ? hsChungThuc.getSoDienThoaiDiDongNguoiNop() : "" %>
					</div>
				</div>
			</div>
			
			<div class="clear sepbot5 sepleft5">
				<label class="egov-label font16-b"> Địa chỉ thường trú </label>
			</div>

			<div class="clear fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Chủ hồ sơ
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getChuSoHuu() != null ? hsChungThuc.getChuSoHuu() : ""%>
					</div>
				</div>
			</div>
			
			<div class="fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label id="ngay_nhan_ho_so_label" class="egov-label-bold">
							Nhận hồ sơ ngày
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getNgayNopHoSo() != null ? DateUtil.parseDateToString(hsChungThuc.getNgayNopHoSo()) : "" %>
					</div>
				</div>
			</div>
			<div class="fi fi33 ngay-hen-tra-loading">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Hẹn trả hồ sơ ngày
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getNgayTraKetQua() != null ? DateUtil.parseDateToString(hsChungThuc.getNgayTraKetQua()) : "" %>
					</div>
				</div>
			</div>

			<div class="clear fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Số lượng bản sao
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getSoBoHoSo() %>
					</div>
				</div>
			</div>
			
						<div class=" fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Số tờ
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getSoTo() %>
					</div>
				</div>
			</div>
			
			<div class=" fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Trường hợp
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getTruongHop() != null ? hsChungThuc.getTruongHop() : "" %>
					</div>
				</div>
			</div>
			
			<div class="clear fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Lệ phí (VNĐ)
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getLePhi()%>
					</div>
				</div>
			</div>
			<div class="fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Phí (VNĐ)
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getPhiHoSo()%>
					</div>
				</div>
			</div>

			<div class="fi clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Mục đích chứng thực
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getMucDichChungThuc() != null ? hsChungThuc.getMucDichChungThuc() : "" %>
					</div>
				</div>
			</div>
			
			<div class="fi clear fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Tên cán bộ ký
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getTenCanBoKy() != null ? hsChungThuc.getTenCanBoKy() : "" %>
					</div>
				</div>
			</div>
			
			<div class="fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Chức vụ cán bộ ký
						</label>
					</div>
					<div class="fi-input"><%= hsChungThuc.getChucVuCanBoKyId() != null ? ChucVuLocalServiceUtil.getChucVu(hsChungThuc.getChucVuCanBoKyId()).getTen() : "" %>
					</div>
				</div>
			</div>
			
			<% 
				List<ThanhPhanHoSoChungThuc> thanhPhanHsCT = ThanhPhanHoSoChungThucLocalServiceUtil.
				getThanhPhanHoSoChungThucListBy(hsChungThuc.getHoSoChungThucId(), 0, 100);
				
				if (thanhPhanHsCT != null && thanhPhanHsCT.size() > 0) {
			%>
 			<div id="giay_to_quy_dinh_grid" class="clear result-grid-ctn">
				<table class="egov-table result-grid sg">
					<thead>
						<tr>
							<th style="width: 0">STT</th>
							<th>Tiêu đề</th>
							<th>Tập tin đính kèm</th>
						</tr>
					</thead>
					<tbody>
					<%

					int index = 1;
					for (ThanhPhanHoSoChungThuc thanhPhanHoSo: thanhPhanHsCT) {
						String urlImage =  WebserviceFactory.getOfficerService().getURLCuaGiayToDinhKem(thanhPhanHoSo.getNoiLuuTruHoSoDinhKemId());
					%>
						<tr>	
							<td><%= index ++ %></td>
							<td><%= thanhPhanHoSo.getTieuDe() != null ? thanhPhanHoSo.getTieuDe() : "" %></td>
							<td><% if (urlImage != null && urlImage.length() > 0) { %>
								<a href="<%= urlImage %>" >File đính kèm</a>
							<% }  else {%>Không có<% } %></td>
						</tr>
						<% }  %>
					</tbody>
				</table>
			</div>
			<% }  %>
			
			<div class="button-bar left">
				<input type="button" onclick="javascript:history.go(-1);" class="egov-button" value="Quay lại"/>
			</div>
			
	</div>
</div>

<script>
function openWindow(url) {
	var newWindow = window.open(url,
					'View image',
					'height=750,width=650,left=90,top=100,resizable=no,location=no,status=no,menubar=yes');

	if (window.focus) {
		newWindow.focus();
	}
	return false;
}
</script>