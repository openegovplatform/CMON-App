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
<%@page import="org.oep.cmon.portlet.canbo2nhomthuctuc.CB2NTTFields"%>
<%@page import="org.oep.cmon.dao.beans.congdan.CongDanImpl"%>
<%@page import="org.oep.cmon.dao.beans.congdan.CongDan"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	long
		hoSoId = HSRParamUtil.getLong(request, HoSoFields.hoSoId)
	,	newCongDanId = HSRParamUtil.getLong(request, "newCongDanId")
	;

	boolean
		laBoSung = (hoSoId > 0L)
	,	daDangKyCongDanMoi = (newCongDanId > 0L)
	,	daDangKyNhanSMS = false
	,	daDangKyChuyenPhatNhanh = false
	;
	
	// BIEN DUNG CHO BO SUNG
	String chuSoHuu = StringPool.BLANK;
	CongDan congDanNop = new CongDanImpl();
	CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));

	String diaChiChuHoSo = "";
	if (laBoSung) {

		HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
		
		if (hoSo != null) {
			
			congDanNop = new CongDanImpl(CongDanLocalServiceUtil.fetchCongDan(hoSo.getCongDanNopId()));
			chuSoHuu = hoSo.getChuSoHuu();
			diaChiChuHoSo = hoSo.getDiaChiChuHoSo();
			daDangKyNhanSMS = (hoSo.getDaDangKyNhanSMS() == 1);
			daDangKyChuyenPhatNhanh = (hoSo.getDaDangKyChuyenPhatNhanh() == 1);
			
		} else {
			laBoSung = false;
			hoSoId = 0L;
		}

	} else if (daDangKyCongDanMoi) {
		
		congDanNop = new CongDanImpl(CongDanLocalServiceUtil.fetchCongDan(newCongDanId));
		chuSoHuu = congDanNop.getHoTenDayDu();
	}
	
	long tinhDiaChiCongDanNopId = congDanNop.getTinhDiaChiId(true);
	
	List<GioiTinh> listGioiTinh = GioiTinhLocalServiceUtil.getDSGioiTinh();
	List<DonViHanhChinh> listTinhThanh = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
	String today = DateTimeUtil.getDayMonthYear(new java.util.Date());
	
	// URL gọi màn hình đăng ký công dân
	LiferayURL currentURL = LiferayURL.createRenderURL(request);
	String dangKyCongDanURL = new StringBuilder() 
		.append(
			LiferayURL
				.createActionURL(request, "csmsquanlycongdan_WAR_csmsappportlet", "editCongDan")
				.setParameter("update", "addNew")
				.toString()
		)
		.append("&hoSoTrucTiepURL=")
		.append(currentURL.toString())
		.toString();
	
	String backURL = HSRParamUtil.getString(request, "backURL").trim();
	if (backURL.isEmpty()) {
		backURL = HoSoBusinessUtil.getURLDanhSachHoSoMoiTiepNhan(request).toString();
	}
%>
<div class="_outer egov-container">
	<div class="hidden-sep">&nbsp;</div>
	<div class="_wrapper">
		<form
			id="main_form"
			method="post"
			autocomplete="off"
			action='<%=LiferayURL.createAjaxURL(request, "processTiepNhanTrucTiep")%>'
			enctype="multipart/form-data"
			prevent-submit-on-textbox-enter-key="true"
		>
			<input type="hidden" name="<%=HoSoFields.hoSoId%>" value="<%=hoSoId%>" />
			<input type="hidden" name="<%=HoSoFields.nguoiNopHoSoCongDanId%>" value="<%= congDanNop.getCongDanId() %>" />
			<input type="hidden" name="<%=HoSoFields.canBoTiepNhanId%>" value="<%=congChuc.getId()%>" />
			<input type="hidden" name="<%=HoSoFields.laNhomThuTucCongAn%>" value="" />
			<input type="hidden" name="backURL" value="<%=backURL%>" />
			
			<h1 class="lv1-title">
				<label id="main_title" class="lv1-title-text">
				<% if (laBoSung) { %>
					Bổ sung hồ sơ đã nộp trực tiếp
				<% } else { %>
					Tiếp nhận hồ sơ trực tiếp
				<% } %>
				</label>
			</h1>
			
			<div class="group-title pos-rel" id="nguoiNopHoSo">
				<label class="lv2-title-text">
					Thông tin người nộp hồ sơ
				</label>
				<button 
					id="tim_cong_dan_open_btn"
					type="button"
					class="egov-button-search small pos-abs"
					style="top: 5px; left: 310px;"
					title="Tìm người nộp"
					<%= laBoSung ? StringPool.DISABLED : StringPool.BLANK %>
				>
					&nbsp;
				</button>
			</div>
			<div id="cong_dan_info_ctn" class="clearfix">
				<div class="fi fi33 clear">
					<div class="fi-wrapper">
						<div class="fi-label pos-rel">
							<label class="egov-label-bold">
								Chứng minh nhân dân
							</label>
							<% if (!laBoSung) { %>
								<div
									class="egov-func-comment pos-abs egov-tooltip-target"
									tooltip="Nhập chính xác số CMND và bấm Enter để tìm kiếm nhanh thông tin công dân"
									style="top:0; left: 156px;"
								>
									&nbsp;
								</div>
							<% } %>
						</div>
						<div class="fi-input">
							<input
								type="text"
								class="egov-inputfield"
								value='<c:out value="<%= congDanNop.getSoCMND() %>"/>'
								name="<%=HoSoFields.soCMND%>"
								maxlength="12"
								<%= laBoSung ? StringPool.DISABLED : StringPool.BLANK %>
							/>
						</div>
					</div>
				</div>
				<div class="fi fi33">
					<div class="fi-wrapper">
						<div class="fi-label">
							<label class="egov-label-bold">
								Người nộp hồ sơ
							</label>
							<label class="egov-label-red">*</label> 
						</div>
						<div class="fi-input">
							<input
								type="text"
								class="egov-inputfield"
								value='<c:out value="<%= congDanNop.getHoTenDayDu() %>"/>'
								id="ten_nguoi_nop_input"
								name="<%=HoSoFields.hoTenNguoiNopHoSo%>"
								maxlength="30"
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
							/>
						</div>
					</div>
				</div>
				<div class="fi fi33">
					<div class="fi-wrapper">
						<div class="fi-label">
							<label class="egov-label-bold">
								Ngày sinh
							</label>
							<label class="egov-label-red">*</label> 
						</div>
						<div class="fi-input">
							<input
								type="text"
								class="egov-calendar egov-calendar-prev"
								milestone="<%=today%>"
								name="<%=HoSoFields.ngaySinh%>"
								maxlength="10"
								value='<c:out value="<%= DateTimeUtil.getDayMonthYear(congDanNop.getNgaySinh()) %>"/>'
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
							/>
						</div>
					</div>
				</div>
				<div class="fi fi33 clear">
					<div class="fi-wrapper">
						<div class="fi-label">
							<label class="egov-label-bold">
								Giới tính
							</label>
							<label class="egov-label-red">*</label> 
						</div>
						<div class="fi-input">
							<select 
								class="egov-select"
								name="<%=HoSoFields.gioiTinh%>"
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
							>
								<option value="-1" class="default">- Chọn giới tính - </option>
								<% for(GioiTinh item : listGioiTinh) { %>
									<option value="<%= item.getId() %>"
									<%= (congDanNop.getCongDanId() != 0L) 
										&& (item.getId() == congDanNop.getGioiTinhId()) ? StringPool.SELECTED : StringPool.BLANK %>
									>
										<c:out value="<%= item.getTen() %>"/>
									</option>
								<% } %>
							</select>
						</div>
					</div>
				</div>
				<div class="fi fi33">
					<div class="fi-wrapper">
						<div class="fi-label">
							<label class="egov-label-bold">
								Điện thoại cố định
							</label>
						</div>
						<div class="fi-input">
							<input
								type="text"
								class="egov-inputfield"
								value='<c:out value="<%= congDanNop.getDienThoaiCoDinh() %>"/>'
								name="<%=HoSoFields.dienThoaiCoDinh%>"
								maxlength="15"
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
							/>
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
						<div class="fi-input">
							<input
								type="text"
								class="egov-inputfield"
								value='<c:out value="<%= congDanNop.getDienThoaiDiDong() %>"/>'
								name="<%=HoSoFields.dienThoaiDiDong%>"
								maxlength="15"
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
							/>
						</div>
					</div>
				</div>
				<div class="fi clear sepbot10">
					<div class="fi-wrapper">
						<div class="fi-label">
							<label class="egov-label-bold">
								Email
							</label>
						</div>
						<div class="fi-input">
							<input
								type="text"
								class="egov-inputfield"
								value='<c:out value="<%= congDanNop.getEmail() %>"/>'
								name="<%=HoSoFields.email%>"
								maxlength="50"
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
							/>
						</div>
					</div>
				</div>
				<div class="clear lv3-title">
					<label class="lv3-title-text">Địa chỉ thường trú</label>
				</div>
				<div class="fi clear">
					<div class="fi-wrapper">
						<div class="fi-label">
							<label class="egov-label-bold">
								Số  nhà, đường phố, tổ/ thôn/ ấp 
							</label>
							<label class="egov-label-red">*</label> 
						</div>
						<div class="fi-input">
							<input
								type="text"
								class="egov-inputfield"
								value='<c:out value="<%= congDanNop.getDiaChiChiTiet() %>"/>'
								name="<%= HoSoFields.diaChiThuongTru %>"
								maxlength="100"
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
							/>
						</div>
					</div>
				</div>
				<div class="fi fi33 clear">
					<div class="fi-wrapper">
						<div class="fi-label">
							<label class="egov-label-bold">
								Tỉnh/thành phố
							</label>
							<label class="egov-label-red">*</label> 
						</div>
						<div class="fi-input">
							<select 
								class="egov-select egov-dvhc-select" 
								id="<%=HoSoFields.tinhThuongTruId%>"
								name="<%=HoSoFields.tinhThuongTruId%>"
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
								quanHuyenId="<%=HoSoFields.huyenThuongTruId%>"
								xaPhuongId="<%=HoSoFields.xaThuongTruId%>"
								url='<%=LiferayURL.createAjaxURL(request, "getListDVHCByParent")%>'
								defaultTinh="<%= tinhDiaChiCongDanNopId != 0L ? tinhDiaChiCongDanNopId : Constants.DEFAULT_DVHC_ID %>"
								defaultHuyen="<%= congDanNop.getHuyenDiaChiId(true) %>"
								defaultXa="<%= congDanNop.getXaDiaChiId(true) %>"
							>
								<% for(DonViHanhChinh item : listTinhThanh) { %>
									<option value="<%= item.getId() %>">
										<c:out value="<%= item.getTen() %>"/>
									</option>
								<% } %>
								
							</select>
						</div>
					</div>
				</div>
				<div class="fi fi33">
					<div class="fi-wrapper">
						<div class="fi-label">
							<label class="egov-label-bold">
								Quận/huyện
							</label>
							<label class="egov-label-red">*</label> 
						</div>
						<div class="fi-input">
							<select 
								class="egov-select" 
								id="<%=HoSoFields.huyenThuongTruId%>"
								name="<%=HoSoFields.huyenThuongTruId%>"
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
							>
								<option value="0" class="default">- Chọn quận/huyện - </option>
							</select>
						</div>
					</div>
				</div>
				<div class="fi fi33 sepbot10">
					<div class="fi-wrapper">
						<div class="fi-label">
							<label class="egov-label-bold">
								Xã/phường/thị trấn
							</label>
						</div>
						<div class="fi-input">
							<select
								class="egov-select"
								id="<%=HoSoFields.xaThuongTruId%>"
								name="<%=HoSoFields.xaThuongTruId%>"
								<%= daDangKyCongDanMoi ? StringPool.BLANK : StringPool.DISABLED %>
							>
								<option value="0" class="default">- Chọn xã/phường/thị trấn - </option>
							</select>
						</div>
					</div>
				</div>
				<div id="checkbox_edit_cd_ctn" class="clear fi" style="display: none;">
					<div class="fi-wrapper nonseptop">
						<div class="fi-label"> </div>
						<div class="fi-input">
							<input
								name="<%= CB2NTTFields.duocPhepEditCongDan %>"
								id="editcd_checkbox"
								type="checkbox"
								class="egov-checkbox"
								value="1"
							/>
							<label for="editcd_checkbox" class="egov-label highlight">Cập nhật các thay đổi (nếu có) vào cơ sở dữ liệu công dân</label>
						</div>
					</div>
				</div>
			</div>
			<div class="group-title">
				<label class="lv2-title-text">
					Thông tin hồ sơ
				</label>
			</div>
			<div class="clear fi">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Chủ hồ sơ
						</label>
						<label class="egov-label-red">*</label> 
						&nbsp;
						<input class="egov-checkbox" type="checkbox" id="is_the_same_chk" name="<%=  HoSoFields.laNguoiNop%>"
							<%-- <%= laBoSung &&  diaChiChuHoSo.length() > 0 ? StringPool.DISABLED : StringPool.CHECKED + " " +  laBoSung ?  StringPool.DISABLED : ""%> --%>
								<%
									if (laBoSung &&  diaChiChuHoSo.length() > 0) {
								%>
									<%= StringPool.DISABLED %>
								<%
									} else {
								%>
										<%= StringPool.CHECKED %>
										<%= laBoSung ?  StringPool.DISABLED : ""%>									
								<%
									}
								%>
						 />
						<label class="egov-label" for="is_the_same_chk">Cũng là người nộp</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield"
							value='<c:out value="<%= chuSoHuu %>"/>'
							id="chu_ho_so_input"
							name="<%=HoSoFields.chuSoHuu%>"
							maxlength="200"
							<%= laBoSung ? StringPool.DISABLED : StringPool.BLANK %>
						/>
					</div>
				</div>
			</div>
				
			<div class="clear fi" id="dia_chi_chu_ho_so_input" style="display: <%= diaChiChuHoSo.length() > 0 ? "block":"none"%>">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Địa chỉ chủ hồ sơ
						</label>
						<label class="egov-label-red">*</label> 
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield"
							value='<c:out value="<%= diaChiChuHoSo %>"/>'
							name="<%=HoSoFields.diaChiChuHoSo%>"
							maxlength="500"
							<%= laBoSung ? StringPool.DISABLED : StringPool.BLANK %>
							placeholder="Số nhà, đường phố, tổ/ thôn/ ấp, xã/phường, quận/huyện, tỉnh/TP"
						/>
					</div>
				</div>
			</div>
			
			<jsp:include page="/html/portlet/hosotructiep/thongTinHoSoInputs.jsp">
				<jsp:param value="<%= hoSoId %>" name="hoSoId"/>
				<jsp:param value="<%= laBoSung ? 1 : 0 %>" name="laBoSung"/>
			</jsp:include>
							
			<div class="clear fi">
				<div class="fi-wrapper">
					<div class="fi-label"> </div>
					<div class="fi-input">
						<input
							name="<%= HoSoFields.daDangKyNhanSMS %>"
							id="sms_checkbox"
							type="checkbox"
							class="egov-checkbox"
							value="1"
							<%= daDangKyNhanSMS ? StringPool.CHECKED : StringPool.BLANK %>
						/>
						<label for="sms_checkbox" class="egov-label">Đăng ký nhận SMS mỗi khi cập nhật tình trạng xử lý hồ sơ</label>
					</div>
				</div>
			</div>
			<div class="clear fi">
				<div class="fi-wrapper">
					<div class="fi-label"> </div>
					<div class="fi-input">
						<input
							name="<%= HoSoFields.daDangKyChuyenPhatNhanh %>"
							id="cpn_checkbox"
							type="checkbox"
							class="egov-checkbox"
							value="1"
							<%= daDangKyChuyenPhatNhanh ? StringPool.CHECKED : StringPool.BLANK %>
						/>
						<label for="cpn_checkbox" class="egov-label">Đăng ký nhận kết quả bằng chuyển phát nhanh (EMS)</label>
					</div>
				</div>
			</div>
			
			<div class="hidden-sep">&nbsp;</div>
			<div class="button-bar clear">
				<button type="submit" class="egov-button">Lưu và in giấy biên nhận</button>
				<button id="in_huong_dan" type="button" class="egov-button">In hướng dẫn thực hiện thủ tục</button>
				<button type="button" class="egov-button" onclick="location.href='<%=backURL%>'">Quay lại</button>
			</div>
			<div class="hidden-sep">&nbsp;</div>
		</form>
	</div>
</div>

<div id="tim_cong_dan_popup" class="egov-container" style="display: none">
	<div class="clearfix septop10">
		<form 
			id="tim_cong_dan_form"
			method="post"
			autocomplete="off"
		>
			<div class="clear fi fi30">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Họ tên công dân
						</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield"
							value=""
							name="<%=HoSoFields.hoTenNguoiNopHoSo%>"
							maxlength="30"
						/>
					</div>
				</div>
			</div>
			<div class="fi fi25">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Chứng minh nhân dân
						</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield"
							value=""
							name="<%=HoSoFields.soCMND%>"
							maxlength="12"
							title="Hãy nhập chính xác số CMND của người cần tìm"
						/>
					</div>
				</div>
			</div>
			<div class="fi fi25">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Ngày sinh
						</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-calendar egov-calendar-prev"
							value=""
							name="<%=HoSoFields.ngaySinh%>"
							maxlength="10"
							milestone="<%=today%>"
						/>
					</div>
				</div>
			</div>
			<div class="left">
				<div class="fi-wrapper">
					<div class="fi-label">&nbsp;</div>
					<div class="fi-input">
						<button type="submit" class="egov-button-search small" title="Tìm kiếm">&nbsp;</button>
						&nbsp;&nbsp;
						<a href="#" class="button clear-search" title="Hủy tìm kiếm" style="font-size: 14px;">Hủy</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="button-bar septop5">
		<button type="button" class="egov-button-normal chon-cong-dan-btn" disabled="disabled">
			Chọn công dân
		</button>
		&nbsp;&nbsp;
		<label class="egov-label hint">Có thể double click trên lưới để chọn công dân</label>
	</div>
	<div id="tim_cong_dan_grid" class="result-grid-ctn">
		<table class="egov-table result-grid" >
			<thead>
				<tr>
					<th class="autowidth">Chọn</th>
					<th>Họ tên</th>
					<th class="autowidth">Số CMND</th>
					<th class="autowidth">Ngày sinh</th>
					<th>Địa chỉ thường trú</th>
				</tr>
			</thead>
			<tbody>
				<tr>	
					<td class="center autowidth" style="padding: 0 !important;">
						<input class="egov-radio" field="index" name="radio_cong_dan" type="radio" style="width: 100%;"/>
					</td>
					<td>
						<label field="<%=HoSoFields.hoTenNguoiNopHoSo%>" class="egov-label">&nbsp;</label>
					</td>
					<td class="center autowidth">
						<label field="<%=HoSoFields.soCMND%>" class="egov-label">&nbsp;</label>
					</td>
					<td class="center autowidth">
						<label field="<%=HoSoFields.ngaySinh%>" class="egov-label">&nbsp;</label>
					</td>
					<td>
						<label field="<%=HoSoFields.diaChiThuongTruDayDu%>" class="egov-label">&nbsp;</label>
					</td>
				</tr>
			</tbody>	
		</table>
	</div>
	<div class="button-bar">
		<button type="button" class="egov-button-normal chon-cong-dan-btn" disabled="disabled">
			Chọn công dân
		</button>
		<button type="button" class="egov-button-normal" onclick="location.href='<%= dangKyCongDanURL %>'">
			Đăng ký công dân
		</button>
		<button id="tim_cong_dan_close_btn" type="button" class="egov-button-normal">Thoát</button>
	</div>
</div>
<script type="text/javascript">
$(function() {
	
	// Constants from server
	var
		FIELD_SOCMND = '<%=HoSoFields.soCMND%>'
	,	FIELD_TINHTHUONGTRUID = '<%=HoSoFields.tinhThuongTruId%>'
	,	FIELD_HUYENTHUONGTRUID = '<%=HoSoFields.huyenThuongTruId%>'
	,	FIELD_XATHUONGTRUID = '<%=HoSoFields.xaThuongTruId%>'
	,	FIELD_THUTUCID = '<%=HoSoFields.thuTucHanhChinhId%>'
	,	FIELD_HOTENNGUOINOP = '<%=HoSoFields.hoTenNguoiNopHoSo%>'
	,	FIELD_DUOCPHEPEDITCONGDAN = '<%=CB2NTTFields.duocPhepEditCongDan%>'
	;
	
	var 
		$form = $('#main_form')
	,	$popup = $('#tim_cong_dan_popup')
	,	$isTheSameChk = $('#is_the_same_chk')
	,	$chonCongDanBtn = $popup.find('.chon-cong-dan-btn')
	,	$soCMND = $form.findInput(FIELD_SOCMND)
	,	congDanSearchGrid = undefined
	,	inHuongDanURL = '<%=LiferayURL.createRenderURL(request, "/html/portlet/hosotructiep/inHuongDan.jsp")%>'
	,	searchCongDanURL = '<%=LiferayURL.createAjaxURL(request, "searchCongDan")%>'
	,	dangKyCongDanURL = '<%=dangKyCongDanURL%>'
	,	mainFormAjax = new Ajax()
	,	quickSearchAjax = Ajax.forURL(searchCongDanURL)
	;

	// SEE /html/portlet/hosotructiep/cmon_tiep_nhan_inputs.jsp
	var global = window.globalFunctions;

	// Nếu chọn thủ tục công an thì công bắt buộc nhập CMND
	global.onThuTucAjaxSuccess(function(thongTinThuTuc) {
		
		var $chkboxEditCongDanCtn = $('#checkbox_edit_cd_ctn');
		if (thongTinThuTuc[FIELD_DUOCPHEPEDITCONGDAN]) {
			$chkboxEditCongDanCtn.show();
			$chkboxEditCongDanCtn.findInput(FIELD_DUOCPHEPEDITCONGDAN).check();
		} else {
			$chkboxEditCongDanCtn.findInput(FIELD_DUOCPHEPEDITCONGDAN).uncheck();
			$chkboxEditCongDanCtn.hide();
		}
	});
	
	function quickSearchCongDan() {
		
		var soCMND = $soCMND.val().trim();
		if ((soCMND.length === 9 || soCMND.length === 12) && (/^\d+$/).test(soCMND)) {
			$soCMND.prop('disabled', true);
			$soCMND.egovTooltip('disable');
			quickSearchAjax.setRequestParam(FIELD_SOCMND, soCMND).run();
		} else {
			$soCMND.prop('disabled', false);
			$soCMND.egovTooltip('enable');
			$soCMND.egovTooltip('open');
		}
	}
	
	function selectCongDan() {
		$popup.dialog('close');
		var rowIndex = $popup.findInput('radio_cong_dan').filter(':checked').val();
		fillDataCongDan(congDanSearchGrid.getRowData(rowIndex));
	}
	
	function fillDataCongDan(data, keepLocking) {
		
		if ($.isEmptyObject(data)) {
			return;
		}
		
		var $input;
		
		for (var key in data) {
			$input = $form.findInput(key);
			$input.val( data[key] );
			if (!keepLocking) {
				$input.prop('disabled', false);
			}
		}
		
		$form.findInput(FIELD_TINHTHUONGTRUID).loadDonViHanhChinh(
			data[FIELD_TINHTHUONGTRUID],
			data[FIELD_HUYENTHUONGTRUID],
			data[FIELD_XATHUONGTRUID]
		);
		
		$isTheSameChk.trigger('change');
	}
	
	$soCMND.bind('keydown',
		function(ev) {
			if (ev.which === 13) {
				ev.stopImmediatePropagation();
				ev.preventDefault();
				quickSearchCongDan();
			}
		}
	);
	
	$soCMND.egovTooltip({
		content: 'Vui lòng nhập chính xác 9 hoặc 12 chữ số CMND',
		disabled: true
	});
	quickSearchAjax
		.setLoading('#cong_dan_info_ctn')
		.onSuccess(function(response) {
			
			var data = response.getSearchResult();
			
			$soCMND.prop('disabled', false);
			
			if (data.length > 1) {
				congDanSearchGrid.setParam($soCMND.prop('name'), $soCMND.val());
				$popup.dialog('open');
			} else {
				data = data[0];
				if (data === undefined) {
					$message(
						'Không tìm thấy công dân nào có số CMND ' + $soCMND.val(),
						['Thêm công dân mới',
						 	function() {
								location.href = dangKyCongDanURL;
							}
						],
						['Nhập lại CMND khác',
						 	function() {
								$('#cong_dan_info_ctn')
									.find(':input')
									.val('').prop('disabled', true);
								$soCMND.prop('disabled', false);
								$soCMND.focus();
							}
						]
					);
				} else {
					fillDataCongDan(data);
				}
			}
		});

	congDanSearchGrid = new Ajax.SearchGrid({
		grid: '#tim_cong_dan_grid',
		form: '#tim_cong_dan_form',
		searchURL: searchCongDanURL,
		afterFill: function() {
			$chonCongDanBtn.prop('disabled', true);
			this.find('.egov-radio').uncheck();
		}
	});
	
	congDanSearchGrid.bindEvent('[name="radio_cong_dan"]', 'click', function() {
		if (this.checked) {
			$chonCongDanBtn.prop('disabled', false);
		}
	});
	
	$('#tim_cong_dan_grid').delegate('tr', 'dblclick', function() {
		$(this).findInput('radio_cong_dan').check();
		selectCongDan();
	});

	$isTheSameChk.bind('change', function() {
		if (this.checked) {
			$('#chu_ho_so_input').val($('#ten_nguoi_nop_input').val());
			$('#dia_chi_chu_ho_so_input').css({ display: "none"});
			
		} else {
			$('#dia_chi_chu_ho_so_input').css({ display: "block"});
			$('#chu_ho_so_input').val('').focus();
		}
	});
	
	$popup.egovPopup('Tìm kiếm thông tin công dân', '80%');
	
	$popup.bind('dialogopen', function() {
		congDanSearchGrid.load();
	});
	
	$('#tim_cong_dan_open_btn').bind('click', function() {
		$popup.dialog('open');
	});
	
	$('#tim_cong_dan_close_btn').bind('click', function() {
		$popup.dialog('close');
	});
	
	$chonCongDanBtn.bind('click', selectCongDan);
	
	$('#in_huong_dan').click(function() {
		
		var thuTucId = global.getThuTucIdDuocChon();
		
		if (thuTucId > 0) {
			var url = inHuongDanURL;
			url = url.urlParam( FIELD_THUTUCID, thuTucId );
			
			window.__child = open(url, '_blank');
			
			// #SPECIAL_DATA_PASSING
			__child.__hoTenNguoiNopHoSo = $form.findInput(FIELD_HOTENNGUOINOP).val();
			
			__child.focus();
			
		} else {
			$alert('Mời chọn thủ tục trước', global.focusThuTucSelect);
		}
	});
	
	var isConfirmed = false;
	mainFormAjax.setMergeWithGlobal(false);
	mainFormAjax.onBefore(function() {
		
		if (isConfirmed) {
			return true;
		}
		
		var 
			uploadedFileWillBeDeleted = global.getUploadedFileWillBeDeleted()
		,	confirmMsg = '';
		
		for (var i = 0; i < uploadedFileWillBeDeleted.length; ++ i) {
			confirmMsg += '<br> - ' + uploadedFileWillBeDeleted[i]; 
		}
		
		if (confirmMsg !== '') {
			confirmMsg = 
				'Bởi vì bạn đã click bỏ chọn "Đã nhận" nên ' 
				+ (uploadedFileWillBeDeleted.length > 1 ? 'các ' : '')
				+ 'thành phần hồ sơ sau sẽ bị xóa<br>'
				+ confirmMsg;
				
			confirmMsg += '<br><br> Bạn chắc chắn muốn tiếp tục ?';
			
			$message(
				confirmMsg,
				['Tôi chắc chắn',
				 	function() {
						isConfirmed = true;
						$form.trigger('submit');
					}
				],
				['Không',
				 	function() {
						global.focusGiayToGrid();
					}
				]
			);
			return false;
		} else {
			return true;
		}
	});
	
	$form.egovAjaxForm(mainFormAjax);
});
</script>