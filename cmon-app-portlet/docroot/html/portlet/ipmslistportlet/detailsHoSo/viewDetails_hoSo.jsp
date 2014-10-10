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
<%@page import="org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.cmon.util.DateUtil"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="java.util.Collections"%>
<%@page
	import="org.oep.cmon.dao.dvc.service.CauHinhPortlet2ThuTucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="org.apache.commons.lang.ObjectUtils.Null"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.timhoso.portlet.utils.TimHoSoUtils"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page
	import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.Date"%>

<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%	
	String nguoinhan = "";
	String nguoitra = "";
	String thoigianTra = "", thoiGianNop = "";
	int statusHoSo = -1;
	int traTrucTuyen = 1;
	int traTrucTiep = 0;
	String loaiCanBo = "";
	String urlQuayLaiViewDetail = "";

	if (ParamUtil.getString(request, "loaiCanBo") != null) {
		loaiCanBo = ParamUtil.getString(request, "loaiCanBo");
	}

	String statuscb = ParamUtil.getString(request, Constants.CanBoXuLy.PROCESSING_CAN_BO_PREF_PARAM, Constants.CanBoXuLy.NHAN_VIEN);
	

	//
	//instance =HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(id_hoso);
	if (instance.getHoTenNguoiNhanKetQua() != null)
		nguoinhan = instance.getHoTenNguoiNhanKetQua();

	if (instance.getTenCanBoTraKetQua() != null)
		nguoitra = instance.getTenCanBoTraKetQua();

	if (instance.getNgayTraKetQua() != null)
		thoigianTra = ConvertUtil.parseDateToTring(instance
		.getNgayTraKetQua());
	
	thoiGianNop = DateTimeUtil.getDayMonthYear(instance.getNgayNopHoSo());

	statusHoSo = instance.getTrangThaiHoSo();

	//Store list status of ho so for view tai lieu trong qua trinh xu ly
	List<Integer> listStatusThanhPhan = new ArrayList<Integer>();

	listStatusThanhPhan.add(Integer
	.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN));
	listStatusThanhPhan.add(Integer
	.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY));
	listStatusThanhPhan.add(Integer
	.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG));
	listStatusThanhPhan.add(Integer
	.valueOf(Constants.TRANGTHAIHOSO.HO_SO_KHONG_TIEP_NHAN));
	listStatusThanhPhan.add(Integer
	.valueOf(Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG));
	listStatusThanhPhan.add(Integer
	.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DA_BO_XUNG_CHO_TN));
	listStatusThanhPhan.add(Integer
	.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DA_TRA_KET_QUA));
	listStatusThanhPhan.add(Integer
	.valueOf(Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG));

	//Xử lý liên kết với porlet khác
	String transType = ParamUtil.getString(request, "transType", "");
	String currentTransPage = ParamUtil.getString(request,
	"currentTransPage", "");
	String transactionKeyword = ParamUtil.getString(request,
	"transactionKeyword", "");
	String CanBoXuLyHienThoiId = null;
%>
<!-- link xem don dang ki -->
<%
	long transPortletId = 0;

	String transPortletName = "";
	String schemaName = instance.getMaUngDung().trim().toLowerCase();
	String maQuyTrinh = "";
	String delimiter = "_";

	//schemaName ="dkkd";// schemaName.split(delimiter);
	//transPortletId = Long.parseLong(prefs.getValue(schemaName+"Id","0"));

	transPortletName = prefs.getValue(schemaName + "Name", "");
	ThuTucHanhChinh thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil
	.fetchThuTucHanhChinh(instance.getThuTucHanhChinhId());
	if (thuTucHanhChinh != null) {
		maQuyTrinh = thuTucHanhChinh.getMa();
	}
	
	HoSoLienThong hoSoLienThongDaTraKetQua =
		HSLTBusinessUtil.getHoSoLienThongDaTraKetQua(instance, instance.getCoQuanTiepNhanId());
	boolean laHoSoLienThongDaTraKetQua = (hoSoLienThongDaTraKetQua != null);
	if (laHoSoLienThongDaTraKetQua) {
		nguoitra = hoSoLienThongDaTraKetQua.getHoTenCanBoNhan();
		nguoinhan = hoSoLienThongDaTraKetQua.getHoTenCanBoNopHoSoGiay();
		thoiGianNop = DateTimeUtil.getDayMonthYear(hoSoLienThongDaTraKetQua.getNgayNhan());
		thoigianTra = DateTimeUtil.getDayMonthYear(hoSoLienThongDaTraKetQua.getNgayNoiNhanTraKetQua());
	}
%>
<portlet:renderURL var="urlViewShare">
	<portlet:param name="idHoSo" value="<%=String.valueOf(id_hoso)%>" />
	<portlet:param name="loaiCanBo" value="<%=loaiCanBo%>" />
	<portlet:param name="jspPage"
		value="/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp" />
</portlet:renderURL>
<portlet:renderURL var="backURL" />
<liferay-portlet:renderURL
	plid="<%=PortalUtil.getPlidFromPortletId(
						themeDisplay.getScopeGroupId(), transPortletName)%>"
	portletName="<%=transPortletName%>" var="LINK">
	<liferay-portlet:param name="<%=TransactionUtils.PARAM_PORTLET_NAME%>"
		value="<%=schemaName%>" />
	<liferay-portlet:param name="<%=TransactionUtils.PARAM_ID%>"
		value="<%=String.valueOf(instance.getId())%>" />
	<liferay-portlet:param name="<%=TransactionUtils.PARAM_ID_QUY_TRINH%>"
		value="<%=String.valueOf(instance.getThuTucHanhChinhId())%>" />
	<liferay-portlet:param name="maQuyTrinh" value="<%=maQuyTrinh%>" />
	<liferay-portlet:param name="backURL"
		value="<%=PortalUtil.getCurrentCompleteURL(request)%>" />
</liferay-portlet:renderURL>

<style type="text/css">
	div.egov-container table.egov-table-form .normal-table tr td,
	div.egov-container table.egov-table-form .normal-table tr th
	{
	  border: 1px solid #eee9e9 !important;
	  padding: 5px !important;
	}
</style>
<portlet:renderURL var="urlYeuCauBoXung">
	<portlet:param name="idHoSo" value="<%=String.valueOf(id_hoso)%>" />
	<portlet:param name="ulrRoleBack" value="<%=urlViewShare%>" />
	<portlet:param name="loaiCanBo" value="<%=loaiCanBo%>" />
	<portlet:param name="jspPage"
		value="/html/cmon/yeucaubosung/bosunghoso_form.jsp" />
</portlet:renderURL>

<table border="0" class="egov-table-form" style="width: 98%">
	<tr>
		<td><label class="egov-label-bold">Mã số biên nhận </label></td>
		<td colspan="3" class="egov-label-bold"><%=GetterUtil.getString(instance.getMaSoBienNhan())%></td>
	</tr>
	<tr>
		<td><label class="egov-label-bold">Mã hồ sơ</label></td>
		<td colspan="3" class="egov-label-bold"><%=instance.getMaSoHoSo()%></td>
	</tr>
	<tr>
		<td><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.tendichvucong" /> </label></td>
		<td colspan="3" class="egov-label-bold"><%=instance.getTenThuTucHanhChinh()%>
		</td>
	</tr>
	<tr>
		<td><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.nguoinophoso" /></label></td>
		<td colspan="3" class="egov-label-bold"><%=instance.getHoTenNguoiNopHoSo()%>
		</td>
	</tr>
	
	<tr>
		<td><label class="egov-label-bold">Địa chỉ:</label></td>
		<td colspan="3" class="egov-label">
			<c:out value="<%=HoSoBusinessUtil.getDiaChiDayDuCongDanNopHoSo(instance)%>" />
		</td>
	</tr>
	<tr>
		<td><label class="egov-label-bold">Chủ hồ sơ:</label></td>
		<td colspan="3" class="egov-label">
			<c:out value="<%= instance.getChuSoHuu() %>" />
		</td>
	</tr>
	<% String diaChiChuHoSo = instance.getDiaChiChuHoSo(); %>
	<% if (diaChiChuHoSo == null || diaChiChuHoSo.trim().isEmpty()) { %>
		<% diaChiChuHoSo = HoSoBusinessUtil.getDiaChiDayDuCongDanNopHoSo(instance); %>
	<% } %>
	<tr>
		<td><label class="egov-label-bold">Dịa chỉ Chủ hồ sơ:</label></td>
		<td colspan="3" class="egov-label">
			<c:out value="<%= diaChiChuHoSo %>" />
		</td>
	</tr>
	
	<%-- <tr>
		<td><label class="egov-label-bold">Cán bộ đang xử lý:</label></td>
		<td colspan="3" class="egov-label">
			<c:out value="<%= HoSoBusinessUtil.getHoTenCanBoVuaThucHienXuLy(instance) %>" />
		</td>
	</tr> --%>
	<tr>
		<td><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.ngaynophoso" /></label></td>
		<td><%=thoiGianNop%></td>
	</tr>
	<tr>
		<td><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.trangthai" /></label></td>
		<td colspan="3" class="egov-label-bold"><%=TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(
					instance.getTrangThaiHoSo()).getTrangThai()%></td>
	</tr>
	<% if (isOnline == Constants.ACTIVE) { %>
	<tr>
		<td><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.dondangkitructuyen" /></label></td>
		<td class="egov-label-bold"><a href="<%=LINK%>"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.xemdondangki" /></a></td>
		<td colspan="2" class="egov-label-bold"><em><liferay-ui:message
					key="org.oep.html.form.thontinhoso.message.xemdondangki" /></em></td>
	</tr>
	<% } %>
	<%
		List<GiayToDinhKemHoSo> lFileUploads = FileDinhKemLocalServiceUtil.
			getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(instance.getId(), Constants.GIAIDOAN_GIAYTO_DAUVAO);
	%>
	<tr>
		<td colspan="2"><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.thanhphantheoquidinh" /></label></td>
		<td colspan="2">
			<span style="font-style: italic;">
				Click vào liên kết (nếu có) để tải xuống thành phần hồ sơ
			</span>
		</td>
	</tr>
	<tr>
		<td colspan="4" style="padding-left: 30px;">
			<ol class="egov-ol nonseptop">
				<% for (GiayToDinhKemHoSo fileUpload : lFileUploads) { %>
					<% boolean isUploaded = !fileUpload.getDownloadLink().isEmpty(); %>
					<li>
						<% if (isUploaded) { %>
						
							<a href="<%= fileUpload.getDownloadLink() %>">
								<label class="egov-label">
									<%= fileUpload.getTenGiayTo() %>"
									<% if (fileUpload.getLaBanChinh()) { %>
										(Bản chính)
									<% } %>
								</label>
							</a>
							
						<% } else { %>
						
							<label class="egov-label">
								<%= fileUpload.getTenGiayTo() %>
								<% if (fileUpload.getLaBanChinh()) { %>
									(Bản chính)
								<% } %>
							</label>
		
						<% } %>
					</li>
				<% } %>
			</ol>
		</td>
	</tr>
	<%
		String url = "";
		String nameFile = "";

		if (instance != null) {
			url = instance.getLienKetThanhPhanHoSo();
			nameFile = instance.getMoTaThanhPhanHoSo();

			if (!nameFile.isEmpty()) {
	%>
	<tr>
		<td colspan="4"><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.thanhphankhac" /></label> <a
			href="<%=url%>" target="_bank"><%=nameFile%></a></td>
	</tr>
	<%
		}
		}
	%>
	<!-- Thông tin trang thai ho so dừng xử  lý -->
	<%
		if (instance.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG) {
			if (instance.getDungXuLy()) {
	%>
	<tr>
		<td colspan="4"><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.hoantat.ykiencanbo"></liferay-ui:message></label></td>
	</tr>
	<tr>
		<td colspan="4"><textarea
				style="text-align: left; height: 160px; width: 100%"
				name="ykiencanbo" id="ykiencanbo" readonly="readonly">
				    	 <%=noidungDungXuLy%>
				    	</textarea></td>
	</tr>
	<tr>
		<td colspan="4"><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.hoantat.congvantraloi"></liferay-ui:message></label></td>
	</tr>
	<tr>
		<td colspan="4"><a href="<%=urlFileDungXuLy%>"><%=nameFileDungXuLy%></a>
		</td>
	</tr>
	<%
		}
		}
	%>
	<!--  Tai lieu trong qua trinh xu ly ho so -->
	<%
		if (instance != null) {
			if (listStatusThanhPhan.contains(instance.getTrangThaiHoSo())) {
				int j = 1;
				String urlTaiLieu = null;
				List<TaiLieuChungThuc> taiLieuQuaTrinhXuLy = null;
				long noilutruTailieu = 0;
				String nameFileTailieu = "";

				try {
					//taiLieuQuaTrinhXuLy =  TaiLieuChungThucLocalServiceUtil.findByHosotthcCongIdAndLoai(instance.getId(),1);
					taiLieuQuaTrinhXuLy = TaiLieuChungThucLocalServiceUtil
							.findTaiLieuXuLyByHoSoAndLoai(instance.getId(),
									1); //TaiLieuChungThucLocalServiceUtil.findByHosotthcCongIdAndLoai(instance.getId(),1);

				} catch (Exception e) {

					e.printStackTrace();
				}

				if (taiLieuQuaTrinhXuLy != null) {
					if (taiLieuQuaTrinhXuLy.size() > 0) {
	%>
	<tr>
		<td colspan="2"><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.tailieuquatrinhxuly"></liferay-ui:message></label></td>
	</tr>
	<tr>
		<td colspan="4">
			<table class="normal-table"  style="width: 95%; margin-left: 5px;">
				<tr>
					<th style='width: 7%; text-align: center;'>Thứ tự</th>
					<th style='text-align: center;'>Tài liệu</th>
					<th style='text-align: center;'>Người upload</th>
					<th style='text-align: center;'>Ngày upload</th>
				</tr>
			<%
				for (TaiLieuChungThuc taiLieuXuLy : taiLieuQuaTrinhXuLy) {
					noilutruTailieu = taiLieuXuLy.getNoiLuuTruId();
					nameFileTailieu = taiLieuXuLy.getTen();
					//CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(taiLieuXuLy.getNguoiUploadId());
					CongChuc congChuc = CongChucLocalServiceUtil.fetchByTaiKhoanNguoiDung(taiLieuXuLy.getNguoiUploadId());
					String tenNguoiUpload = "";
					if (congChuc != null) {
						tenNguoiUpload = congChuc.getHoVaTen();
					}
					
					if (noilutruTailieu != 0) {
						try {
							urlTaiLieu = WebserviceFactory
									.getOfficerService()
									.getURLCuaGiayToDinhKem(
											Long.valueOf(noilutruTailieu)); //data test noi luu tru tai lieu ID 278866L
						} catch (Exception e) {
							e.printStackTrace();
						}
		
						nameFileTailieu = taiLieuXuLy.getTen();
					}
			%>
			<tr>
				<td style="text-align: center;"><%=j++%></td>
				<td class="wd-fw-bold"  style="width: 40%;"><a href="<%=urlTaiLieu%>"><%=nameFileTailieu%></a></td>
				<td class="wd-fw-bold" style="width: 20%;"><%= tenNguoiUpload %></td>
				<td class="wd-fw-bold" style="width: 20%; text-align: center;"><%= DateUtil.parseDateToString(taiLieuXuLy.getNgayUpload()) %></td>
			</tr>
			<%
				}
			%>
			</table>
		
		</td>
	</tr>
	<%
					}
				}
			}
		}
	%>
	<!-- Ket qua xu ly ho so -->
	<%
		if (instance != null) {
			if (instance.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_DA_TRA_KET_QUA) {

				int k = 1;
				String urlTaiLieuKq = "";
				List<FileDinhKem> fileTaiLieuKq = null;
				Long noilutruTailieuKq = null;
				String nameFileTailieuKq = "";
				TaiLieuChungThuc taiLieuKQ = null;
				FileDinhKem giayToDinhKem = null;

				try {
					//Dung lay tai lieu upload ket qua khi thuc hien button upload ket qua
					//Private for message 
					List<FileDinhKem> listFileDinhKemKQ = FileDinhKemLocalServiceUtil
							.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(
									id_hoso,
									Constants.PHASE_PROCESS_HOSO.PHASE_BA);

					FileDinhKem giayToDinhKemHoSo = null;
					TaiLieuChungThuc taiLieuChungThucKetQua = null;

					if (listFileDinhKemKQ != null) {
						if (listFileDinhKemKQ.size() > 0) {
							giayToDinhKem = listFileDinhKemKQ
									.get(listFileDinhKemKQ.size() - 1);
							if (giayToDinhKem != null) {
								if (giayToDinhKem.getNoiLuuTruTaiLieuId() != null) {
									taiLieuKQ = TaiLieuChungThucLocalServiceUtil
											.getTaiLieuChungThuc(giayToDinhKem
													.getNoiLuuTruTaiLieuId());

									if (taiLieuKQ != null) {
										if (taiLieuKQ.getNoiLuuTruId() != 0) {
											urlTaiLieuKq = WebserviceFactory
													.getOfficerService()
													.getURLCuaGiayToDinhKem(
															taiLieuKQ
																	.getNoiLuuTruId());
										}
									}
								}
							}
						}
					}
	%>
	<%
		//Dung version cu

					fileTaiLieuKq = FileDinhKemLocalServiceUtil
							.findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(
									id_hoso,
									Constants.PHASE_PROCESS_HOSO.PHASE_BA);
					//

				} catch (Exception e) {
					e.printStackTrace();
					fileTaiLieuKq = null;
				}

				if (fileTaiLieuKq != null) {
					if (fileTaiLieuKq.size() > 0) {
	%>
	<tr>
		<td colspan="4"><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.ketquaxulyhoso" /></label></td>
	</tr>
	<%
		for (FileDinhKem fileXuLyKq : fileTaiLieuKq) {

							if (fileXuLyKq.getDanhMucGiayToId() != null) {
								nameFileTailieuKq = DanhMucGiayToLocalServiceUtil
										.getDanhMucGiayTo(
												fileXuLyKq
														.getDanhMucGiayToId()
														.longValue())
										.getTen();
							}

							noilutruTailieuKq = fileXuLyKq
									.getNoiLuuTruTaiLieuId();

							if (Validator.isNotNull(noilutruTailieuKq)) {

								taiLieuKQ = TaiLieuChungThucLocalServiceUtil
										.getTaiLieuChungThuc(noilutruTailieuKq
												.longValue());

								if (taiLieuKQ != null) {
									nameFileTailieuKq = taiLieuKQ.getTen();
								}

							}
	%>
	<tr>
		<td colspan="4" class="wd-fw-bold" style="padding-left: 30px;"><%=k++%>.
			<a href="<%=urlTaiLieuKq%>"><%=nameFileTailieuKq%></a></td>
	</tr>
	<%
		}
					}
				}
			}
		}

		if (instance != null) {
			if (instance.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_DA_TRA_KET_QUA
					&& instance.getDaTraKetQuaTrucTuyen() != null) {
				if (instance.getDaTraKetQuaTrucTuyen().toString()
						.matches(Constants.NUMBER_CONSTANT.VALUE_KHONG)) {
	%>

	<tr>
		<td><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.thongtintraketqua" /></label></td>
		<td colspan="3" class="wd-fw-bold"></td>
	</tr>
	
	<% if (laHoSoLienThongDaTraKetQua) { %>
		<tr>
			<td><label class="egov-label-bold">Cơ quan nhận kết quả:</label></td>
			<td colspan="3" class="wd-fw-bold"><%=hoSoLienThongDaTraKetQua.getTenCoQuanGui()%></td>
		</tr>
		<tr>
			<td><label class="egov-label-bold">Cán bộ nhận kết quả:</label></td>
			<td colspan="3" class="wd-fw-bold"><%=nguoinhan%></td>
		</tr>
	<% } else { %>
		<tr>
			<td><label class="egov-label-bold"><liferay-ui:message
						key="org.oep.html.form.thontinhoso.nguoinhanketqua" /></label></td>
			<td colspan="3" class="wd-fw-bold"><%=nguoinhan%></td>
		</tr>
	<% }%>
	
	<tr>
		<td><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.nguoitraketqua" /></label></td>
		<td colspan="3" class="wd-fw-bold"><%=nguoitra%></td>
	</tr>
	<tr>
		<td><label class="egov-label-bold"><liferay-ui:message
					key="org.oep.html.form.thontinhoso.thoigiantrakq" /></label></td>
		<td colspan="3" class="wd-fw-bold"><%=thoigianTra%></td>
	</tr>
	<%
		}
			}
		}
	%>
	
<% if (RutHoSoBusinessUtil.laHoSoDaYeuCauRut(instance)) { %>
	<tr>
		<td colspan="5"><label class="egov-label-bold" style="font-size: 16px;">Đã có yêu cầu rút hồ sơ này</label></td>
	</tr>
	<%
		List<YKienTraoDoi> listYKienRut = 
			YKienTraoDoiLocalServiceUtil.findByHoSoTTHCCongIdAndLoai(instance.getId(), Constants.LOAI_Y_KIEN_TRAO_DOI.RUT_HO_SO);
		if (! listYKienRut.isEmpty()) {
	%>
	<tr>
		<td><label class="egov-label-bold">Ý kiến yêu cầu rút:</label></td>
		<td colspan="3" class="egov-label">
			<c:out value="<%= listYKienRut.get(0).getNoiDungYKien() %>" />
		</td>
	</tr>
	<% 	}%>
<% }%>
	

	<!-- View button on page -->
	<tr>
		<td colspan="4">
			<jsp:include page="/html/portlet/ipmslistportlet/detailsHoSo/buttonChiTietHoSo.jsp">
				<jsp:param name="hoSoId" value="<%= instance.getId() %>"/>
				<jsp:param name="laLanhDao" value="<%= statuscb.equals(Constants.CanBoXuLy.LANH_DAO) ? 1 : 0 %>"/>
				<jsp:param name="loaiCanBo" value="<%= loaiCanBo %>"/>
			</jsp:include> 
 		</td>
	</tr>
</table>

<script type="text/javascript">
$(document).ready(function () {
	var  title = $('#title').val();
	$('.portlet-title-text').text(title);
		
});
	
	function checkUpload() {		
		var value = $('#dataUpload').val().length;
		if (value == 0) {
			alert("Vui lòng chọn file ảnh để tải lên!");
			return false;
			
		} else {
			var ext = $('#dataUpload').val().split('.').pop().toLowerCase();		
			if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
			    alert('Vui lòng chọn tệp tin kiểu ảnh!');
			    return false;
			}
			return true;
		}		
	}
	
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