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
<%@page import="org.oep.egovcore.util.VNNumberUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.ThanhPhanHoSoChungThucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc"%>
<%@page import="org.oep.config.ConfigUtils"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="java.util.LinkedList"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.SoDanhMuc"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.Date"%>
<%@page import="org.oep.cmon.util.DateUtil"%>
<%@page import="vn.dtt.sharedservice.cmon.consumer.citizen.DonViHanhChinhSoap"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="vn.dtt.sharedservice.cmon.consumer.citizen.ICitizenService"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.HoSoChungThuc"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="<%=request.getContextPath()%>/js/core.js"
		type="text/javascript"></script> 
<link href="${pageContext.request.contextPath}/css/egov-custom-form.css" type="text/css" rel="stylesheet">
 <portlet:defineObjects />  
<%
renderResponse.setTitle("Chứng thực");
String today = DateTimeUtil.getDayMonthYear(new java.util.Date());
List<GioiTinh> listGioiTinh = GioiTinhLocalServiceUtil.findAll();
List<DonViHanhChinh> listTinhThanh = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();

long uid = PortalUtil.getUserId(request);
CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(uid);
  	
// get thu tuc hanh chinh by can bo
List<NhomThuTucHanhChinh> listNhomTTHC =  NhomThuTucHanhChinhLocalServiceUtil.
			getDSNhomThuTucHanhChinhByCanBo(congChuc.getId());  

// TEST
/*  List<NhomThuTucHanhChinh> listNhomTTHC =  new LinkedList<NhomThuTucHanhChinh>();
NhomThuTucHanhChinh nhomTTHC = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(19);
listNhomTTHC.add(nhomTTHC);
nhomTTHC = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(20);
listNhomTTHC.add(nhomTTHC);  */
// END TEST

//List<ThuTucHanhChinh> thuTucHanhChinhs = ThuTucHanhChinhLocalServiceUtil.getListTTHCByCanBo(congChuc.getId());
// get id danh muc ung dung chung thuc
String maUngDung = ThamSoLocalServiceUtil.getValue("CTMS");
long idUngDung = DanhMucUngDungLocalServiceUtil.getIdDanhmucUngdung(maUngDung);

List<ThuTucHanhChinh> listTTHC = new LinkedList<ThuTucHanhChinh>();

//filter the tthc by ung dung chung thuc
if (listNhomTTHC != null && !listNhomTTHC.isEmpty()) {
	for (NhomThuTucHanhChinh ntthc: listNhomTTHC) {
		if (ntthc.getDanhMucUngDungId() == idUngDung) {
			List<ThuTucHanhChinh> listTthc = ThuTucHanhChinhLocalServiceUtil.searchByUngDungOrNhom(null, ntthc.getId(), 0, 1000);
			
			listTTHC.addAll(listTthc);
		}
	}
}   

//String nhomTTHCChungThucId = ThamSoLocalServiceUtil.getValue("CT_NHOMTTHCID");

//NhomThuTucHanhChinh ntthc =  NhomThuTucHanhChinhLocalServiceUtil.findTheoMa(nhomTTHCChungThucId); 
//List<ThuTucHanhChinh> listTTHC = ThuTucHanhChinhLocalServiceUtil.searchByUngDungOrNhom(null, (long)21, 0, 100);

ICitizenService service = WebserviceFactory.getCmonService();
List<DonViHanhChinhSoap> donViHanhChinhSoaps = service.getDanhsachDVHC(Long
		.parseLong(ConfigUtils.getValue("egov.application.provin.id", "31")));
List<DonViHanhChinh> danhSachTinhThanh = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();

HoSoChungThuc hsChungThuc = null;
long idHoSo = ParamUtil.getLong(request, "idHoSo");
if (idHoSo > 0) {
	hsChungThuc = HoSoChungThucLocalServiceUtil.getHoSoChungThuc(idHoSo);
}

if (hsChungThuc == null) {
	hsChungThuc = (HoSoChungThuc) request.getAttribute(Constants.ChungThuc.NAME);
}

if (hsChungThuc == null) {
	hsChungThuc = new HoSoChungThucImpl();
	hsChungThuc.setThuongTruTinhId(Long
			.parseLong(ConfigUtils.getValue("egov.application.provin.id", "31")));
	hsChungThuc.setNgayNopHoSo(new Date());
	hsChungThuc.setNgayTraKetQua(new Date());
	if (listTTHC != null && !listTTHC.isEmpty())
		hsChungThuc.setThuTucHanhChinhId(listTTHC.get(0).getId());
	hsChungThuc.setTenChungThuc("");
	hsChungThuc.setHoTenNguoiNopHoSo("");
	hsChungThuc.setSoDienThoaiDiDongNguoiNop("");
	hsChungThuc.setDiaChiThuongTruNguoiNop("");
	hsChungThuc.setChuSoHuu("");
	//hsChungThuc.setSoBoHoSo(1);
	hsChungThuc.setMucDichChungThuc("");
	hsChungThuc.setTenCanBoKy("");
	hsChungThuc.setSoChungThuc("");
	hsChungThuc.setTruongHop("");
	String maCVTP = ThamSoLocalServiceUtil.findByTen("CV_MA_TRUONG_PHONG").getGiaTri();
	
	ChucVu chucVu = ChucVuLocalServiceUtil.findMa(maCVTP).get(0);
	hsChungThuc.setChucVuCanBoKyId(chucVu.getId());
}

List<SoDanhMuc> listSoDanhMuc = new LinkedList<SoDanhMuc>();
if (hsChungThuc.getThuTucHanhChinhId() != null) {
	listSoDanhMuc = SoDanhMucLocalServiceUtil.
			getSoDanhMucByTTHCID(hsChungThuc.getThuTucHanhChinhId());
}


List<ChucVu> listChucVu = ChucVuLocalServiceUtil.getChucVus(0, 100);
//CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
%>

<portlet:actionURL var="saveHoSoChungThuc" name="saveHoSoChungThuc">
	<portlet:param name="targetPage" value="/html/portlet/hosochungthuc/view.jsp"></portlet:param> 
</portlet:actionURL>
<select style="display: none;" id="egov-form-errors">
						<option value="<%= HoSoFields.thuTucHanhChinhId %>">
						<liferay-ui:error key="<%= HoSoFields.thuTucHanhChinhId %>" >Chưa chọn loại hồ sơ</liferay-ui:error>
						</option>
						<option value="<%= HoSoFields.hoTenNguoiNopHoSo %>">
						<liferay-ui:error key="<%= HoSoFields.hoTenNguoiNopHoSo %>" >Chưa nhập tên người nộp hồ sơ</liferay-ui:error>
						</option>
						<option value="<%= HoSoFields.chuSoHuu %>">
						<liferay-ui:error key="<%= HoSoFields.chuSoHuu %>" >Chưa nhập chủ sở hữu</liferay-ui:error>
						</option>
						<option value="<%= HoSoFields.ngayNhanHoSo %>">
						<liferay-ui:error key="<%= HoSoFields.ngayNhanHoSo %>" >Nhập ngày nhận hồ sơ</liferay-ui:error>
						</option>
						<option value="<%= HoSoFields.ngayHenTraHoSo %>">
						<liferay-ui:error key="<%= HoSoFields.ngayHenTraHoSo %>" >Nhập ngày trả hồ sơ</liferay-ui:error>
						</option>
						<option value="<%= HoSoFields.soBoHoSo %>">
						<liferay-ui:error key="<%= HoSoFields.soBoHoSo %>" >Nhập số bộ hồ sơ</liferay-ui:error>
						</option>
						<option value="<%= HoSoFields.phiHoSo %>">
						<liferay-ui:error key="<%= HoSoFields.phiHoSo %>" >Nhập phí</liferay-ui:error>
						</option>
						<option value="<%= HoSoFields.lePhiHoSo %>">
						<liferay-ui:error key="<%= HoSoFields.lePhiHoSo %>" >Nhập lệ phí</liferay-ui:error>
						</option>
						<option value="soDanhMucId">
						<liferay-ui:error key="soDanhMucId" >Chọn sổ danh mục</liferay-ui:error>
						</option>
						
</select>

<div class="_outer egov-container">
	<%
		if (request.getAttribute("savemessage") != null) {
	%>
	<div class="portlet-msg-success" style="padding-left: 20px;">Đã lưu hồ sơ</div>
	<%
		}
	%>
	
	<div class="hidden-sep">&nbsp;</div>
	<div class="_wrapper">
		<form
			id="main_form"
			method="post"
			action="<%= saveHoSoChungThuc %>" 
			enctype="multipart/form-data"
		>
			<input  type="hidden" name="idHoSo" value="<%= idHoSo%>"/>
			<input type="hidden" name=<%= HoSoFields.coQuanQuanLyId %> value="<%= congChuc.getCoQuanQuanLyId() %>" />
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
						<label class="egov-label-red">*</label> 
					</div>
					<div class="fi-input">
						<select class="egov-select" id="<%= HoSoFields.thuTucHanhChinhId %>" name="<%= HoSoFields.thuTucHanhChinhId%>" >
							<!-- <option value="0">- Chọn loại hồ sơ - </option>  -->
							<% 
								for (ThuTucHanhChinh tthc: listTTHC) {
							%>
									<option value="<%= tthc.getId()%>" 
									<%	if (hsChungThuc.getThuTucHanhChinhId() != null && hsChungThuc.getThuTucHanhChinhId() == tthc.getId())  { %>
									selected="selected"
									<% } %>><%= tthc.getTen() %>
									</option> 
							<%
								}
							%>
						</select>
					</div>
				</div>
			</div>
			
			<div class="fi fi66 clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Chọn sổ danh mục
						</label>
						<label class="egov-label-red">*</label> 
					</div>
					<div class="fi-input">
						<select class="egov-select"  name="soDanhMucId"  id="soDanhMucId" >
							 <!-- <option value="0">- Chọn loại hồ sơ - </option> -->
							<% 
								for (SoDanhMuc soDanhMuc: listSoDanhMuc) {
							%>
									<option value="<%= soDanhMuc.getId()%>" sochungthuc="<%= soDanhMuc.getSoSo() %>"
									<%	if (hsChungThuc.getSoDanhMucId() != null && hsChungThuc.getSoDanhMucId() == soDanhMuc.getId())  { %>
									selected="selected"
									<% } %>><%= soDanhMuc.getSoSo()%>
									</option> 
							<%
								}
							%>
						</select>
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
					<div class="fi-input">
						<input 
							id="soChungThuc"
							type="text"
							class="egov-inputfield NUMERIC"
							value="<%= hsChungThuc.getSoChungThuc()%>"
							name="soChungThuc"
						/>
					</div>
				</div>
			</div>
			
			<div class="fi  clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Tên tài liệu chứng thực
						</label>
					</div>
					<div class="fi-input">
						<input 
							id="<%= HoSoFields.ten %>"
							type="text"
							class="egov-inputfield"
							value="<%= hsChungThuc.getTenChungThuc()%>"
							name="<%= HoSoFields.ten %>"
						/>
					</div>
				</div>
			</div>
			
			<div class="fi fi33 clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Người nộp hồ sơ
						</label>
						<label class="egov-label-red">*</label> 
					</div>
					<div class="fi-input">
						<input 
							id="<%= HoSoFields.hoTenNguoiNopHoSo %>"
							type="text"
							class="egov-inputfield"
							value="<%= hsChungThuc.getHoTenNguoiNopHoSo()%>"
							name="<%= HoSoFields.hoTenNguoiNopHoSo %>"
							maxlength="30"
						/>
					</div>
				</div>
			</div>
			
						
			<div class="fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label id="ngay_nhan_ho_so_label" class="egov-label-bold">
							Nhận hồ sơ ngày
						</label>
						<label class="egov-label-red">*</label> 
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-calendar"
							value="<%= DateUtil.parseDateToString(hsChungThuc.getNgayNopHoSo())%>"
							name="<%= HoSoFields.ngayNhanHoSo %>"
							maxlength="10"
							id="<%= HoSoFields.ngayNhanHoSo %>"
						/>
					</div>
				</div>
			</div>
<%-- 			<div class="fi fi25">
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
							name="<%= HoSoFields.gioPhutNhanHoSo %>"
							class="egov-inputfield egov-timepicker"
							value="<%= DateTimeUtil.getHourMinuteNow() %>"
							maxlength="20"
						/>
					</div>
				</div>
			</div> --%>
			<div class="fi fi33 ngay-hen-tra-loading">
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
							value="<%= DateUtil.parseDateToString(hsChungThuc.getNgayTraKetQua())%>"
							name="<%= HoSoFields.ngayHenTraHoSo %>"
							maxlength="10"
							id="<%= HoSoFields.ngayHenTraHoSo %>"
						/>
					</div>
				</div>
			</div>
			
			<div class="clear fi fi20">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Số bộ
						</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield NUMERIC"
							value="<%= hsChungThuc.getSoBoHoSo() > 0 ?   hsChungThuc.getSoBoHoSo(): "" %>"
							name="<%= HoSoFields.soBoHoSo %>"
							id="<%= HoSoFields.soBoHoSo %>"
						/>
					</div>
				</div>
			</div>
			
						<div class=" fi fi20">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Số tờ
						</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield NUMERIC"
							value="<%= hsChungThuc.getSoTo() > 0 ?  hsChungThuc.getSoTo(): "" %>"
							name="soTo"
							id="soTo"
						/>
					</div>
				</div>
			</div>
			
			<div class=" fi fi20">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Trường hợp
						</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield NUMERIC"
							value="<%= hsChungThuc.getTruongHop() != null ? hsChungThuc.getTruongHop(): "" %>"
							name="truongHop"
							id="truongHop"
						/>
					</div>
				</div>
			</div>
			
			<div class="fi fi20">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Lệ phí (VNĐ)
						</label>
						
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield vn-num"
							numsetting="10.0"
							value="<%= hsChungThuc.getLePhi() > 0 ? VNNumberUtil.toVNNum(hsChungThuc.getLePhi()) : ""%>"
							name="<%= HoSoFields.lePhiHoSo %>"
							id="<%= HoSoFields.lePhiHoSo %>"
						/>
					</div>
				</div>
			</div>
			<div class="fi fi20">
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
							value="<%= hsChungThuc.getPhiHoSo() > 0 ? VNNumberUtil.toVNNum(hsChungThuc.getPhiHoSo()) : ""%>"
							name="<%= HoSoFields.phiHoSo %>"
							id="<%= HoSoFields.phiHoSo %>"
						/>
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
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield"
							value="<%= hsChungThuc.getTenCanBoKy() != null ? hsChungThuc.getTenCanBoKy() : ""%>"
							name="canBoKy"
							maxlength="1000"
						/>
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
					<div class="fi-input">
						<select class="egov-select"  name="chucVuCanBoKyId">
							<!-- <option value="0">- Chọn loại hồ sơ - </option> -->
							<% 
								for (ChucVu chucVu: listChucVu) {
							%>
									<option value="<%= chucVu.getId()%>" 
									<%	if (hsChungThuc.getChucVuCanBoKyId() != null && hsChungThuc.getChucVuCanBoKyId() == chucVu.getId())  { %>
									selected
									<% } %>><%= chucVu.getTen() %>
									</option> 
							<%
								}
							%>
						</select>
					</div>
				</div>
			</div>
			
<%-- 			<div class="fi fi33">
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
							milestone="<%= today %>"
							name="<%= HoSoFields.ngaySinh %>"
							maxlength="10"
						/>
					</div>
				</div>
			</div> --%>
			
<%-- 			<div class="fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Giới tính
						</label>
					</div>
					<div class="fi-input">
						<select class="egov-select" name="<%= HoSoFields.gioiTinh %>" >
							<option value="-1">- Chọn giới tính - </option>
							<% 
								for (GioiTinh gioiTinh: listGioiTinh) {
							%>
									<option value="<%= gioiTinh.getId()%>" 
									<%	if (hsChungThuc.getGioiTinhNguoiNop() == gioiTinh.getId())  { %>
									selected
									<% } %>><%= gioiTinh.getTen() %>
									</option> 
							<%
								}
							%>	
						</select>
					</div>
				</div>
			</div> --%>
			
	
			
<%-- 			<div class="fi clear sepbot10">
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
							value="<%= hsChungThuc.getEmailNguoiNop()%>"
							name="<%= HoSoFields.email %>"
							maxlength="50"
							
						/>
					</div>
				</div>
			</div> --%>
			
		<div class="clear fi100" >
			<div class="fi-wrapper" id="collape-container">
					<span class="collape-close"></span>
					<label class="egov-label-bold">
						Thông tin thêm
					</label>
			</div>
		</div>
		
		<div id="collape-content">
			<div class="clear sepbot5 sepleft5">
				<label class="egov-label font16-b"> Địa chỉ thường trú </label>
			</div>
			<div class="fi fi33 clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Tỉnh/thành phố
						</label>
					</div>
					<div class="fi-input">
						<select 
							class="egov-select egov-dvhc-select" 
							id="idTinh"
							name="<%= HoSoFields.tinhThuongTruId %>"
							onchange="reDrawSelectBox('idTinh','idHuyen')"
						>
							<option value="0">- Chọn tỉnh/thành - </option>
							<%
								for (DonViHanhChinh item : danhSachTinhThanh) {
							%>
								<option value="<%=item.getId()%>" <% if (hsChungThuc.getThuongTruTinhId() != null && 
										item.getId() == hsChungThuc.getThuongTruTinhId()) {%>
								selected
								<% }  %>><%=item.getTen()%></option>
							<% }  %>
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
					</div>
					<div class="fi-input">
						<select 
							class="egov-select" 
							id="idHuyen"
							name="<%= HoSoFields.huyenThuongTruId %>"
							onchange="reDrawSelectBox('idHuyen','idXa')"
						>
							<option value="0">- Chọn quận/huyện - </option>
							<%
								donViHanhChinhSoaps = service.getDanhsachDVHC(hsChungThuc.getThuongTruTinhId());
							
								for (DonViHanhChinhSoap item : donViHanhChinhSoaps) {
							%>
								<option value="<%=item.getId()%>" <% if (hsChungThuc.getThuongTruHuyenId() != null && 
												item.getId() == hsChungThuc.getThuongTruHuyenId()) {%>
								selected
								<% }  %>><%=item.getTen()%></option>
							<% }  %>
							
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
							id="idXa"
							name="<%= HoSoFields.xaThuongTruId %>"
						>
							<option value="0">- Chọn xã/phường/thị trấn - </option>
 							<%
								donViHanhChinhSoaps = service.getDanhsachDVHC(hsChungThuc.getThuongTruHuyenId());
							
								for (DonViHanhChinhSoap item : donViHanhChinhSoaps) {
							%>
								<option value="<%=item.getId()%>" <% if (hsChungThuc.getThuongTruXaId() != null && 
											item.getId() == hsChungThuc.getThuongTruXaId()) {%>
								selected
								<% }  %>><%=item.getTen()%></option>
							<% }  %> 
						</select>
					</div>
				</div>
			</div>

			<div class="fi clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Số  nhà, đường phố, tổ/ thôn/ ấp 
						</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield"
							value="<%= hsChungThuc.getDiaChiThuongTruNguoiNop() != null ? hsChungThuc.getDiaChiThuongTruNguoiNop() : ""%>"
							name="<%= HoSoFields.diaChiThuongTru %>"
							maxlength="100"
							
						/>
					</div>
				</div>
			</div>
			
			<div class="clear fi fi33">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Chủ hồ sơ
						</label>
						<label class="egov-label-red">*</label> 
						&nbsp;
						<input class="egov-checkbox" type="checkbox" id="is_the_same_chk" checked="checked" />
						<label class="egov-label" for="is_the_same_chk">Là người nộp</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield"
							value="<%= hsChungThuc.getChuSoHuu()%>"
							id="<%= HoSoFields.chuSoHuu %>"
							name="<%= HoSoFields.chuSoHuu %>"
							maxlength="200"
						/>
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
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield NUMERIC"
							value="<%= hsChungThuc.getSoCMNDNguoiNop() != null ? hsChungThuc.getSoCMNDNguoiNop() : ""%>"
							name="<%= HoSoFields.soCMND %>"
							maxlength="12"
						/>
					</div>
				</div>
			</div>
			
<%-- 			<div class="fi fi33">
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
							value="<%= hsChungThuc.getSoDienThoaiCoDinhNguoiNop()%>"
							name="<%= HoSoFields.dienThoaiCoDinh %>"
							maxlength="15"
							
						/>
					</div>
				</div>
			</div> --%>
			
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
							class="egov-inputfield NUMERIC"
							value="<%= hsChungThuc.getSoDienThoaiDiDongNguoiNop() != null ? hsChungThuc.getSoDienThoaiDiDongNguoiNop() : ""%>"
							name="<%= HoSoFields.dienThoaiDiDong %>"
							maxlength="15"
							
						/>
					</div>
				</div>
			</div>
			
<%-- 			<div class="fi fi25 ngay-hen-tra-loading">
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
							name="<%= HoSoFields.gioPhutHenTraHoSo %>"
							class="egov-inputfield egov-timepicker"
							value="<%= hsChungThuc.get%>"
							maxlength="20"
						/>
					</div>
				</div>
			</div> --%>
			

<%-- 			<div class="fi fi25">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Số ngày giải quyết
						</label>
						<label class="egov-label-red">*</label> 
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield"
							value="<%= hsChungThuc.%>"
							name="<%= HoSoFields.soNgayXuLy %>"
							maxlength="3"
						/>
					</div>
				</div>
			</div> --%>
<%-- 			<div class="fi clear sepbot10" id="ghi_chu_bo_sung_ctn" style="display: none;">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Ghi chú bổ sung hồ sơ
						</label>
					</div>
					<div class="fi-input">
						<textarea class="egov-textarea" name="<%= HoSoFields.ghiChuBoSung %>"></textarea>
					</div>
				</div>
			</div> --%>
			


			<div class="fi clear">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Mục đích chứng thực
						</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-inputfield"
							value="<%= hsChungThuc.getMucDichChungThuc() != null ? hsChungThuc.getMucDichChungThuc() : ""%>"
							name="mucDich"
							maxlength="1000"
						/>
					</div>
				</div>
			</div>
			

			
<%-- 			<div class="fi clear">
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
							value="<%= hsChungThuc.%>"
							name="<%= HoSoFields.lienKetGiayToKhac %>"
							maxlength="500"
						/>
					</div>
				</div>
			</div> --%>

			<div class="clear sub-form-title">
				<label class="egov-label font18-b">
					Thành phần hồ sơ
				</label>
			</div>

			<div id="giay_to_quy_dinh_grid" class="clear result-grid-ctn">
				<table class="egov-table result-grid sg">
					<thead>
						<tr>
							<th style="width: 0">STT</th>
							<th>Mô tả</th>
							<th style="width: 0; text-align: center;" title="Đã nhận hồ sơ hay chưa">Đã nhận <br><input  type="checkbox"  id="check-all-tiepnhan" /></th>
	<!-- 						<th style="width: 0">Bản chính</th> -->
							<th>Tập tin đính kèm</th>
						</tr>
					</thead>
					<tbody id="table-content">
						<tr>	
							<td class="center">
								<label field="stt" class="egov-label"></label>
								<input type="hidden" name="<%= HoSoFields.thuTuc2GiayToId %>" />
								<input type="hidden" name="<%= HoSoFields.loaiGiayToId %>" />
								<input type="hidden" name="<%= HoSoFields.tenGiayToQuyDinh %>" />
								<input type="hidden" name="<%= HoSoFields.fileDinhKemId %>" />
							</td>
							<td>
								<label field="<%= HoSoFields.tenGiayToQuyDinh %>" class="egov-label">&nbsp;</label>
							</td>
							<td class="center"  title="Đã nhận hồ sơ này hay chưa">
								<input type="checkbox" name="<%= HoSoFields.daNhan %>" />
							</td>
<%-- 							<td class="center">
								<input field="index" type="checkbox" name="<%= HoSoFields.banChinhGiayToQuyDinh %>" class="egov-checkbox" />
							</td> --%>
							<td>
								<input uniqueid="true" type="file" name="<%= HoSoFields.fileGiayToQuyDinh %>" class="egov-uploadfile" />
							</td>

						</tr>
					</tbody>
				</table>
			</div>
			
			</div> 
			<!-- end the collape content -->
			
			<div class="hidden-sep">&nbsp;</div>
			<div class="button-bar clear">
				<input type="submit" class="egov-button" value="Lưu hồ sơ"/>
			</div>
		</form>
	</div>
</div>

<portlet:actionURL var="getDonViHanhChinhByIdURL"
	name="getDonViHanhChinhById">
</portlet:actionURL>

<script>
var url = '<%=getDonViHanhChinhByIdURL.toString()%>';
//Ve lai danh sach don vi hanh chinh
function reDrawSelectBox(selectName, changeName) {
	var id = document.getElementById(selectName).options[document.getElementById(selectName).selectedIndex].value;

	// if quan huyen is not selected then return
	if (id == "") return;
	
	var obj = document.getElementById(changeName);

	$.ajax({
		type: 'POST'
		,url: url
		,data : {id: id}
		,success: function(data) {		
			var data2 = JSON.parse(data);
			while (obj.options.length > 1) {
				obj.remove(1);
			}				
            
			for (var i = 0; i < data2.id.length; i++) {
				obj.add(new Option(data2.name[i], data2.id[i]), null);
			}
		}
	});
}

	
$(document).ready(function() {
	$("input[type='text']").click(function () {
		   $(this).select();
		   
	});
	
	// set chu so huu value when lost focus ten nguoi nop
	$( "#hoTenNguoiNopHoSo" ).blur(function() {
		$("#chuSoHuu").val($("#hoTenNguoiNopHoSo").val());
	});
	
	// select on da tiep nhan check box
  $('#check-all-tiepnhan').click(function(event) {  //on click
        if(this.checked) { // check select status
            $('input[type=checkbox]').each(function() { //loop through each checkbox
                this.checked = true;  //select all checkboxes with class "checkbox1"              
            });
        }else{
            $('input[type=checkbox]').each(function() { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox1"                      
            });        
        }
    });
	
	// hidden save message
  	$('.portlet-msg-success').fadeOut("slow");
	
	$('.NUMERIC').keypress(function(event){   
	    // stop entering characters and backspace
	    if(event.which != 8 && event.which != 0 && isNaN(String.fromCharCode(event.which))){
	        event.preventDefault();
	    }  
	});
	
	// set so chung thuc
	//setValueSoChungThuc();
	
	var $collapeContent = $('#collape-content');
	// default collape is close
	$collapeContent.hide();
	 
	// collape the content
	var $container = $('#collape-container span');
			
	$('#collape-container').click(function(){
		if ($container.hasClass('collape-expand')) {
			$container.removeClass('collape-expand');
			$container.addClass('collape-close');
			
		} else {
			$container.removeClass('collape-close');
			$container.addClass('collape-expand');
		}
		
	    $collapeContent.slideToggle('fast');
	});
	
 	tthcAjax =  Ajax.forURL('<%=LiferayURL.createAjaxURL(request, "getTTHCInfo")%>')
	.setLoading('#giay_to_quy_dinh_grid')
	.onSuccess(function(response) {
		fillSoDanhMuc(response.dsSoDanhMuc);
		setValueSoChungThuc(response.soChungThuc);
		drawTableTPHS(response.<%= HoSoFields.dsGiayToQuyDinh %>);
	});
 	
	$('#<%= HoSoFields.thuTucHanhChinhId %>').bind('change', function() {
		if (this.value !== '0') {
			tthcAjax
			.setRequestParam(this.name, this.value)
			.setRequestParam(
				'<%= HoSoFields.coQuanQuanLyId %>',
				$form.findInput('<%= HoSoFields.coQuanQuanLyId %>').val()
			)
		.setRequestParam(
		"idHoSo",
		$form.findInput("idHoSo").val()
		)
			.run();
		}
		this.title = $(this).find('option:selected').text();
	});
	
 	// cal ajax when the app starting
	tthcAjax
	.setRequestParam($('#<%= HoSoFields.thuTucHanhChinhId %>').attr("name"), $('#<%= HoSoFields.thuTucHanhChinhId %>').val())
	.setRequestParam(
		'<%= HoSoFields.coQuanQuanLyId %>',
		$form.findInput('<%= HoSoFields.coQuanQuanLyId %>').val()
	)
	.setRequestParam(
		"idHoSo",
		$form.findInput("idHoSo").val()
	)
	.run();
 	
 	soChungThucAjax =  Ajax.forURL('<%=LiferayURL.createAjaxURL(request, "getSoChungThuc")%>')
	.onSuccess(function(response) {
		setValueSoChungThuc(response.soChungThuc);
	});
 	
	$('#soDanhMucId').bind('change', function() {
		if (this.value !== '0') {
			soChungThucAjax
			.setRequestParam(this.name, this.value)
			.setRequestParam(
				'<%= HoSoFields.thuTucHanhChinhId %>',
				$form.findInput('<%= HoSoFields.thuTucHanhChinhId %>').val())
			.run();
		}
		this.title = $(this).find('option:selected').text();
	});
	
	$(document.body)
	.delegate('input.vn-num', 'keydown',
		function(ev) {
			var setting = parseSetting($(this).attr('numsetting'));
			var key = ev.charCode || ev.keyCode;
			if (!( isNumberKey(key) || isControlKey(key)
				|| key === 86  // v
				|| ((key === 188) && (setting.decLen > 0)) // ,
			)) {
				ev.preventDefault();
			}
		}
	)
	.delegate('input.vn-num', 'keyup',
		function(ev) {
			var key = ev.charCode || ev.keyCode;
			var lastChar = this.value.charAt(this.value.length - 1);
			if ((isNumberKey(key) && ((this.value.indexOf(',') === -1) || (lastChar !== '0')))
				|| key === 46 // delete
				|| key === 8 // backspace
				|| (key === 188 // , 
					&& (lastChar !== ','))
			) {
				$(this).toVNNum();
			}
		}
	)
	.delegate('input.vn-num', 'change',
		function() {
			$(this).toVNNum();
		}
	);
});


$form = $('#main_form');
$soDanhMuc = $("#soDanhMucId");

<%-- giayToGrid = new SimpleGrid({
	grid: '#giay_to_quy_dinh_grid',
	pkField: '<%= HoSoFields.thuTuc2GiayToId %>'
});

giayToGrid.$elem.delegate('[name="<%= HoSoFields.fileGiayToQuyDinh %>"]', 'change', 
		function() {
			$(this).closest('tr').findInput('<%= HoSoFields.daNhan %>').check().disable();
		}
	); --%>
	

	
function fillDataHoSo(dsGiayToQuyDinh) {
	giayToGrid.fill(dsGiayToQuyDinh);
	//$form.fillData(thongTinThuTuc);
	//$soNgayXuLy.trigger('change');
}

function setValueSoChungThuc(soChungThuc) {
	$("#soChungThuc").val(soChungThuc.soChungThuc);
}

function fillSoDanhMuc(dsSoDanhMuc) {
   	$('#soDanhMucId').empty();
   
    $.each(dsSoDanhMuc, function(arrayID, danhMuc) {
    	$('#soDanhMucId').append('<option value= ' + danhMuc.id +' sochungthuc= ' + danhMuc.so + '  ' + danhMuc.check + '=' +  danhMuc.check +' >' + danhMuc.so +'</option>');
	});
}

function drawTableTPHS(dsGiayToQuiDinh) {
	$('#table-content').empty();
	var $contentTable = $('#table-content');
	
	 $.each(dsGiayToQuiDinh, function(arrayID, giayTo) {
		 var html = "";
			html += "<tr>";	
			html += "<td class=\"center\">";
			html += "<label field=\"stt\" class=\"egov-label\">" + (arrayID + 1) +"</label>";
			html += "<input type=\"hidden\" name=\"<%= HoSoFields.thuTuc2GiayToId %>\"  value=\"" + giayTo.<%= HoSoFields.thuTuc2GiayToId %> + "\" />";
			html += "<input type=\"hidden\" name=\"<%= HoSoFields.loaiGiayToId %>\"  value=\"" + giayTo.<%= HoSoFields.loaiGiayToId %> + "\" />";
			html += "<input type=\"hidden\" name=\"<%= HoSoFields.tenGiayToQuyDinh %>\"  value=\"" + giayTo.<%= HoSoFields.tenGiayToQuyDinh %> + "\" />";
			html += "<input type=\"hidden\" name=\"noiLuuTruId\"  value=\"" + giayTo.noiLuuTruId + "\" />";
			html += "</td>";
			html += "<td>";
			html += "<label field=\"<%= HoSoFields.tenGiayToQuyDinh %>\" class=\"egov-label\">" + giayTo.<%= HoSoFields.tenGiayToQuyDinh %> + "</label>";
			html += "</td>";
			html += "<td class=\"center\"  title=\"Đã nhận hồ sơ này hay chưa\">";
			html += "<input  type=\"checkbox\"  value=\"" + arrayID + "\"  name=\"<%= HoSoFields.daNhan %>\"  "+ giayTo.daNhan +"=\"" + giayTo.daNhan + "\" />";
			html += "</td>";
			html += "<td>";
			html += "<input uniqueid=\"true\" type=\"file\" name=\"<%= HoSoFields.fileGiayToQuyDinh %>\" class=\"egov-uploadfile\" />";
			html += "</td>";
			html += "</tr>";
			
			$contentTable.append(html);
	 });
}
</script>

<style type="text/css">
#collape-container {
	width: 98.5%;
	height: 30px;
	background-color: rgba(4, 27, 38, 0.27);
	border-radius: 2px;
	padding-top: 7px;
	float: left;
	margin-top: 10px;
	margin-bottom: 17px;
	cursor: pointer;
}

</style>