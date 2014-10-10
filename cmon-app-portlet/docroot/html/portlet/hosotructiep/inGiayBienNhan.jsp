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
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ComUtils"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>
<%@page import="org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo"%>
<%@page import="org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"%>
<%@page import="org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.egovcore.language.CmonMessager"%>
<%@page import="org.oep.egovcore.language.cmonkey.Label"%>
<%@page import="org.oep.egovcore.language.CmonMessagerUtil"%>
<%@page import="org.oep.egovcore.util.VNNumberUtil"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="java.util.Date"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/in_giay_bien_nhan.css">
<%
	long 
		hoSoId = HSRParamUtil.getLong(request, HoSoFields.hoSoId),
		hoSoLienThongId = HSRParamUtil.getLong(request, HSLTFields.hoSoLienThongId),
		donDangKyId = 0L
	;
	String tenCanBo, tenChucVu, soDienThoai, tenToKhai, maCapCQQL, backURL, tenNguoiNop;
	Date lucTiepNhan, lucHenTra;
	boolean laLienThong = false, laTinhHuyenXa = false;

	CmonMessager label = CmonMessagerUtil.forPrefix(Label.PREFIX);
	HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
	HoSoLienThong hoSoLienThong = null;
	
	CoQuanQuanLy coQuan = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(hoSo.getCoQuanTiepNhanId());
	ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSo.getThuTucHanhChinhId());

	tenCanBo = GetterUtil.getString(hoSo.getTenCanBoTiepNhan()).trim();
	tenChucVu = GetterUtil.getString(hoSo.getChucVuCanBoTiepNhan()).trim();
	if (tenCanBo.isEmpty()) {
		CongChuc canBo = CongChucLocalServiceUtil.fetchCongChuc(hoSo.getCanBoTiepNhanId());
		tenCanBo = canBo.getHoVaTen();
		if (tenChucVu.isEmpty()) {
			tenChucVu = ChucVuLocalServiceUtil.fetchChucVu(canBo.getChucVuId()).getTen();
		}
	}

	soDienThoai = GetterUtil.getString(hoSo.getSoDienThoaiCoDinhNguoiNop()).trim();
	if (soDienThoai.isEmpty()) {
		soDienThoai = GetterUtil.getString(hoSo.getSoDienThoaiDiDongNguoiNop());
	}
	
	List<GiayToDinhKemHoSo> ds = FileDinhKemLocalServiceUtil.getDSGiayToPhienBanMoiNhatByHoSo(hoSoId);
	List<GiayToDinhKemHoSo> dsDinhKem = new ArrayList<GiayToDinhKemHoSo>();
	DanhMucGiayTo donDangKy = DanhMucGiayToLocalServiceUtil.findTheoMa(ThamSoLocalServiceUtil.getValue("DONDANGKY_MA"));
	if ( (donDangKy != null) && (donDangKy.getDaXoa() == Constants.ACTIVE) ) {
		donDangKyId = donDangKy.getId();
	}
	
	boolean daNhanDonDangKy = false;
	for (GiayToDinhKemHoSo item : ds) {
		dsDinhKem.add(item);
		if (item.getDanhMucGiayToId(true) == donDangKyId) {
			daNhanDonDangKy = true;
		}
	}
	
	if ( !daNhanDonDangKy ) {
		tenToKhai = GetterUtil.getString(ThuTucHanhChinhLocalServiceUtil.
			fetchThuTucHanhChinh(hoSo.getThuTucHanhChinhId()).getTenMauDonToKhai()).trim();
		if ( !tenToKhai.isEmpty() ) {
			GiayToDinhKemHoSo toKhai = new GiayToDinhKemHoSoImpl();
			toKhai.setTenGiayTo(tenToKhai);
			dsDinhKem.add(0, toKhai);
		}
	}
	
	tenNguoiNop = hoSo.getHoTenNguoiNopHoSo();
	lucTiepNhan = hoSo.getNgayBoSung();
	if (lucTiepNhan == null) {
		lucTiepNhan = hoSo.getNgayNhanHoSo();
	}
	lucHenTra = hoSo.getNgayHenTraKetQua();
	
	if (hoSoLienThongId == 0L) {
		hoSoLienThong = HSLTBusinessUtil.getHoSoLienThongDaTiepNhan(hoSo, hoSo.getCoQuanTiepNhanId());
		laLienThong = (hoSoLienThong != null);
	} else {
		hoSoLienThong = HoSoLienThongLocalServiceUtil.fetchHoSoLienThong(hoSoLienThongId);
		laLienThong = true;
	}
	
	if (laLienThong) {
		tenNguoiNop = hoSoLienThong.getHoTenCanBoNopHoSoGiay().trim();
		if (tenNguoiNop.isEmpty()) {
			tenNguoiNop = hoSoLienThong.getHoTenCanBoGui();
		}
		
		lucTiepNhan = hoSoLienThong.getNgayNhan();
		lucHenTra = hoSoLienThong.getNgayNoiNhanHenTra();
	}
	
	maCapCQQL = 
		CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(coQuan.getCapCoQuanQuanlyId()).getMa().trim();
	laTinhHuyenXa = 
		maCapCQQL.equals(ThamSoLocalServiceUtil.getValue("CMON_CAP_CQQL_TINH_MA"))
		|| maCapCQQL.equals(ThamSoLocalServiceUtil.getValue("CMON_CAP_CQQL_QUAN_HUYEN_MA"))
		|| maCapCQQL.equals(ThamSoLocalServiceUtil.getValue("CMON_CAP_CQQL_PHUONG_XA_MA"));
	
	backURL = HSRParamUtil.getString(request, "backURL").trim();
	if (backURL.isEmpty()) {
		backURL = HoSoBusinessUtil.getURLDanhSachHoSoMoiTiepNhan(request).toString();
	}
	
	LiferayURL urlInPhieuLuanChuyen = ComUtils.getURLInPhieuLuanChuyen(request)
		.setParameter(HoSoFields.hoSoId, hoSoId)
		.setParameter("backURL", PortalUtil.getCurrentCompleteURL(request));
%>
<script type="text/javascript">

$(function() {
	var $rcontent, $lcontent;
	$rcontent = $('#_to_be_print').children();
	$lcontent = $rcontent.clone();
	$lcontent.find('#_giao_cho').text('(Liên 1: Lưu tại bộ phận TN&TKQ)');
	$lcontent.find('#_thong_tin').remove();
	$lcontent.find('#_dang_ky_sms').remove();
	$lcontent.find('#_dang_ky_ems').remove();
	$lcontent.insertBefore($rcontent.get(0));
	$rcontent.children().addClass('line-to-cut-left');
	
	var $checkInHaiTo = $('.in-hai-to')
	,	$printArea = $('#_to_be_print')
	,	cssURLArr = [
		'${pageContext.request.contextPath}/css/core.css', 
		'${pageContext.request.contextPath}/css/in_giay_bien_nhan.css'
	]
	,	callback = undefined
	
	// In trang dọc
	,	isPortraintLayout = false
	;
	
	$('.print-btn').click(function() {
		isPortraintLayout = $checkInHaiTo.prop('checked');
		
		if (isPortraintLayout) {
			callback = function() {
				var $body = $(this.body)
				,	$page = $body.find('.lv2')
				;
				$body.removeClass('trang-doc');
				$page.last().removeClass('line-to-cut-top');
				$page.css('margin-top', '5pt');
			};
		};
		
		$printArea.print(cssURLArr, callback, !isPortraintLayout);
		
		if ($('.INLUUCHUYEN').is(":checked")) {
			// print phieu luu chuyen
			 window.open( '<%= urlInPhieuLuanChuyen%>&print=print', 'Print', 'left=200, top=200, width=10, height=10, toolbar=0, resizable=0');
		}
	});
	
	$checkInHaiTo.click(function() {
		
		$checkInHaiTo.check(this.checked);
		
		var $page = $printArea.find('.lv2')
		, $pageWrapper;

		if (this.checked) {
			
			$printArea.append($page);
			$pageWrapper = $printArea.find('.lv1');
			$.data($printArea.get(0), 'tmp', $pageWrapper.clone());
			$pageWrapper.remove();
			$printArea.addClass('trang-doc');
			$page.first().css('page-break-after', 'always');
			$page.last()
				.removeClass('line-to-cut-left')
				.addClass('line-to-cut-top')
			;
			
		} else {
			
			$pageWrapper = $.data($printArea.get(0), 'tmp');
			$printArea.append($pageWrapper);
			$pageWrapper.first().append($page.first().css('page-break-after', 'auto'));
			$pageWrapper.last().append($page.last());
			$printArea.removeClass('trang-doc');
			$page.last()
				.removeClass('line-to-cut-top')
				.addClass('line-to-cut-left')
			;
		}
	});
});
</script>

<div class="hidden-sep">&nbsp;</div>
<div class="button-bar">
	&nbsp;&nbsp;&nbsp;
	<input type="checkbox" class="egov-checkbox in-hai-to" id="_in_hai_to1" autocomplete="off" />
	<label class="egov-label" for="_in_hai_to1">In thành hai tờ</label>
	&nbsp;
	<button type="button" class="egov-button print-btn">In giấy biên nhận</button>
</div>
<div class="_outer egov-container preview clearfix" id="_to_be_print">
	<div class="lv1 fi50 left">
		<div class="lv2">
			<div class="lv3 _wrapper">
				<div class="hidden-sep">&nbsp;</div>
				<div class="line septop10 nonsepbot">
					<div class="item fi45 center nonsepbot">
						<label class="egov-label upper ubnd">
							<% if (laTinhHuyenXa) { %>
								ỦY BAN NHÂN DÂN
							<% } else { %>
							 	<c:out value='<%=CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuan.getChaId()).getTen()%>'/>
							<% } %>
						</label>
					</div>
					<div class="item fi55 center nonsepbot">
						<label class="egov-label strong upper"><c:out value='<%=label.get(Label.chxhcnvn)%>'/></label>
					</div>
				</div>
				<div class="line nonseptop">
					<div class="item fi45 center">
						<label class="egov-label strong upper underline">
							<% if (laTinhHuyenXa) { %>
							 	<c:out value='<%=DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(coQuan.getDonViHanhChinhId()).getTen()%>'/>
							<% } else { %>
								<c:out value='<%=coQuan.getTen()%>'/>
							<% } %>
						</label>
					</div>
					<div class="item fi55 center">
						<label class="egov-label strong underline"><c:out value='<%=label.get(Label.dltdhp)%>'/></label>
					</div>
				</div>
				<div class="line">
					<div class="item fi45 center sobiennhan">
						<label class="egov-label">Số:</label>
						<label class="egov-label"><c:out value='<%=hoSo.getMaSoBienNhan()%>' /></label>
					</div>
				</div>
				<div class="line septop10 sepbot10">
					<div class="item center">
						<label class="egov-label strong upper">Giấy biên nhận hồ sơ</label>
						<br>
						<label class="egov-label em" id="_giao_cho">
							<% if (laLienThong) { %>
								(Liên 2: Giao cho cán bộ nộp)
							<% } else { %>
								(Liên 2: Giao cho công dân)
							<% } %>
						</label>						
					</div>
				</div>
				<div class="line">
					<div class="item fi60">
						<label class="egov-label">Họ và tên:</label>
						<label class="egov-label strong"><c:out value="<%=tenCanBo%>"/></label>
					</div>
					<div class="item fi40">
						<label class="egov-label">Chức vụ:</label>
						<label class="egov-label">Cán bộ tiếp nhận</label>
					</div>
				</div>
				<div class="line">
					<div class="item">
						<label class="egov-label">Đã tiếp nhận hồ sơ của ông (bà):</label>
						<label class="egov-label strong"><c:out value="<%=hoSo.getHoTenNguoiNopHoSo()%>"/></label>
					</div>
				</div>
				<div class="line">
					<div class="item">
						<label class="egov-label">Thường trú tại:</label>
						<label class="egov-label">
							<c:out value="<%=HoSoBusinessUtil.getDiaChiDayDuCongDanNopHoSo(hoSo)%>"/>
						</label>
					</div>
				</div>
				<div class="line">
					<div class="item">
						<label class="egov-label">Điện thoại:</label>
						<label class="egov-label"> <c:out value="<%= soDienThoai %>"/> </label>
					</div>
				</div>
				
				<%  if (hoSo.getDiaChiChuHoSo() != null && hoSo.getDiaChiChuHoSo().length() > 0) {%>
				<div class="line">
					<div class="item">
						<label class="egov-label">Chủ hồ sơ:</label>
						<label class="egov-label strong"><c:out value="<%=hoSo.getChuSoHuu()%>"/></label>
					</div>
				</div>
				<div class="line">
					<div class="item">
						<label class="egov-label">Thường trú tại:</label>
						<label class="egov-label">
							<c:out value="<%= hoSo.getDiaChiChuHoSo()%>"/>
						</label>
					</div>
				</div>
				<% } %>
				
				<div class="line">
					<div class="item">
						<label class="egov-label">Thủ tục tiếp nhận:</label>
						<label class="egov-label">
							<c:out value="<%= thuTuc.getTen() %>"/>
						</label>
					</div>
				</div>
				<div class="line">
					<div class="item fi30">
						<label class="egov-label">Lệ phí:</label>
						<label class="egov-label">
							<%= VNNumberUtil.toVNNum(hoSo.getLePhi()) %> đồng;
						</label>
					</div>
					<div class="item fi30">
						<label class="egov-label">Phí:</label>
						<label class="egov-label">
							<%= VNNumberUtil.toVNNum(hoSo.getPhiHoSo()) %> đồng;
						</label>
					</div>
					<div class="item fi40">
						<label class="egov-label">Tổng cộng:</label>
						<label class="egov-label">
							<%= VNNumberUtil.toVNNum(hoSo.getLePhi() + hoSo.getPhiHoSo()) %> đồng;
						</label>
					</div>
				</div>
				<div class="line">
					<div class="item">
						<label class="egov-label">Ghi bằng chữ:</label>
						<label class="egov-label vn-num-text em">
							<%= hoSo.getLePhi() + hoSo.getPhiHoSo() %>
						</label>
						<label class="egov-label em">đồng</label>
					</div>
				</div>
				<div class="line">
					<div class="item">
						<label class="egov-label">Hồ sơ bao gồm:</label>
					</div>
				</div>
				<div class="line sepleft10">
					<div class="item nonseptop">
						<% for (GiayToDinhKemHoSo item : dsDinhKem) { %>
							<div>
								<label class="egov-label">
									- <c:out value="<%= item.getTenGiayTo() %>"/>
								</label>
							</div>
						<% } %>
						<% if (!GetterUtil.getString(hoSo.getMoTaThanhPhanHoSo()).isEmpty()) { %>
							<div>
								<label class="egov-label">
									- <c:out value="<%= hoSo.getMoTaThanhPhanHoSo() %>"/>
								</label>
							</div>
						<% } %>
					</div>
				</div>
				<div class="line">
					<div class="item">
						<label class="egov-label">Nhận lúc:</label>
						<label class="egov-label"><%= DateTimeUtil.getFullDateTime(lucTiepNhan, false) %></label>
					</div>
				</div>
				<div class="line">
					<div class="item">
						<label class="egov-label">Thời gian trả kết quả:</label>
						<label class="egov-label"><%= DateTimeUtil.getFullDateTime(lucHenTra, false) %></label>
					</div>
				</div>
				<div class="line septop10">
					<div class="item fi50">
						<label class="egov-label em strong">Nơi nhận</label>
					</div>
					<div class="item fi50 center">
						<label class="egov-label strong upper">người tiếp nhận</label>
					</div>
				</div>
				<div class="line nonseptop">
					<div class="item fi50 nonseptop">
						<label class="egov-label em">- Cá nhân, tổ chức;</label>
					</div>
				</div>
				<div class="line nonseptop">
					<div class="item fi50 nonseptop">
						<label class="egov-label em">- Lưu: Bộ phận <c:out value="TN&TKQ"/></label>.
					</div>
				</div>
				<div class="line septop20">
					<div class="item fi50">
						&nbsp;
					</div>
					<div class="item fi50 center">
						<label class="egov-label strong"><c:out value="<%= tenCanBo %>"/></label>
					</div>
				</div>
				
				<% if (hoSo.getGhiChuGiayToDinhKem().isEmpty()) { %>
				
					<div class="line" style="overflow: hidden;">
						<div class="nonbreak-wrapper">
							<div class="nonbreak" style="width: 0;">
								<label class="egov-label strong">Ghi chú:</label>
							</div>
							<div class="nonbreak" style=" width: 0;">
								<label class="egov-label">
									......................................................................................................................................................................................................................................
								</label>
							</div>
						</div>
					</div>
					<div class="line" style="overflow: hidden;">
						<div style="display: table-cell; width: 0; white-space: nowrap;">
							<label class="egov-label">
								......................................................................................................................................................................................................................................
							</label>
						</div>
					</div>
				
				<% } else { %>
				
					<div class="line">
						<div class="item ghi-chu">
							<label class="egov-label strong">Ghi chú:</label>
							<label class="egov-label"><c:out value="<%= hoSo.getGhiChuGiayToDinhKem() %>"/></label>
						</div>
					</div>
				
				<% } %>

				<div class="left clear fi40 sepbot10">
					<div class="khung-ky border">
						<div class="septop5 line">
							<div class="item center">
								<label class="egov-label strong upper">
								<% if (laLienThong) { %>
									cán bộ nộp hồ sơ
								<% } else { %>
									người nộp hồ sơ
								<% } %>
								</label>
							</div>
						</div>
						<div class="line ten-nguoi-nop">
							<div class="item center">
								<label class="egov-label strong">
									<c:out value="<%= tenNguoiNop %>"/>
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="left fi60 sepbot10">
					<div class="khung-ky border" style="border-left: 0 none;">
						<div class="septop5 line">
							<div class="item center">
								<label class="egov-label strong upper">người nhận kết quả</label>
								<br>
								<label class="egov-label">(Ký và ghi rõ họ tên)</label>
							</div>
						</div>
						<div class="line thoi-gian-tra">
							<div class="item center">
								<label class="egov-label">Thời gian trả kết quả thực tế</label>
								<br>
								<label class="egov-label">..... giờ ..... phút, ngày ..... tháng ..... năm .....</label>
							</div>
						</div>
					</div>
				</div>
				<div id="_thong_tin" class="line clear bordertop">
					<div class="item">
						<label class="egov-label em">
							Để biết thêm thông tin về thủ tục hành chính, tình trạng xử lý hồ sơ, ông (bà) điện thoại đến số
						</label>
						<label class="egov-label em">
							<%= coQuan.getDienThoai() %>
						</label>
						<label class="egov-label em">
							hoặc truy cập website: <%= ThamSoLocalServiceUtil.getValue("DOMAIN") %>
						</label>
						<br>
						<label class="egov-label em strong text-underline">
							Khi đi ông (bà) đem theo chứng minh nhân dân và giấy biên nhận này
						</label>
						
						<% if (hoSo.getDaDangKyNhanSMS() == 1) { %>
							<label class="egov-label em" id="_dang_ky_sms">
								<br>
								- Ông (bà) đã đăng ký nhận tin SMS theo dõi tình trạng xử lý hồ sơ
							</label>
						<% } %>
						
						<% if (hoSo.getDaDangKyChuyenPhatNhanh() == 1) { %>
							<label class="egov-label em" id="_dang_ky_ems">
								<br>
								- Ông (bà) đã đăng ký nhận kết qủa bằng chuyển phát nhanh (EMS)
							</label>
						<% } %>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="button-bar">
	&nbsp;&nbsp;&nbsp;
	<input type="checkbox" class="egov-checkbox in-hai-to" id="_in_hai_to2" autocomplete="off" />
	<label class="egov-label" for="_in_hai_to2">In thành hai tờ</label>
	&nbsp;
	<input type="checkbox" class="egov-checkbox INLUUCHUYEN" autocomplete="off" />
	<label class="egov-label" >In luôn phiếu lưu chuyển</label>
	&nbsp;
	<button type="button" class="egov-button print-btn">In giấy biên nhận</button>
	<button type="button" class="egov-button" onclick="location.href='<%= urlInPhieuLuanChuyen %>'">In phiếu lưu chuyển</button>
	<button type="button" onclick="location.href='<%= backURL %>'" class="egov-button">Quay lại</button>
</div>
<div class="hidden-sep">&nbsp;</div>