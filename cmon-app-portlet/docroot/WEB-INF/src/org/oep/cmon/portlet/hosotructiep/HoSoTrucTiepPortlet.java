/*
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
 */

package org.oep.cmon.portlet.hosotructiep;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;

import org.apache.commons.lang.StringUtils;
import org.oep.cmon.Constants;
import org.oep.cmon.dao.beans.congdan.CongDanImpl;
import org.oep.cmon.dao.beans.thongtinhoso.ThongTinHoSoImpl;
import org.oep.cmon.portlet.canbo2nhomthuctuc.CB2NTTFields;
import org.oep.cmon.portlet.cmon.TiepNhanHoSoPortlet;
import org.oep.cmon.portlet.hosolienthong.HSLTFields;
import org.oep.cmon.portlet.ipmslist.business.FormOfflineBusiness;
import org.oep.cmon.util.EgovUtil;
import org.oep.cmon.util.MaSoBienNhanUtil;
import org.oep.egovcore.language.BusinessMessagerUtil;
import org.oep.egovcore.portlet.AjaxResponse;
import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.util.LiferayURL;
import org.oep.egovcore.util.VNNumberUtil;
import org.oep.egovcore.validate.Validator;
import org.oep.egovcore.validate.term.IsFilled;
import org.oep.egovcore.validate.term.IsNumber;
import org.oep.egovcore.validate.term.IsSelected;
import org.oep.egovcore.validate.term.datetime.IsDayMonthYear;
import org.oep.egovcore.validate.util.DateTimePairValidator;
import org.oep.sharedservice.cmon.provider.form.FormServiceImpl;

import org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo;
import org.oep.cmon.dao.beans.thongtinhoso.ThongTinHoSo;
import org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChuc2NhomThuTucLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCongClp;
import org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;
import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToanClp;
import org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil;
import org.oep.egovcore.sqlutil.QueryResult;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class HoSoTrucTiepPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HoSoTrucTiepPortlet extends TiepNhanHoSoPortlet {
	
	/**
	 * This is function serveThongTinHoSoThuTuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws Exception
	 */
	@Override
	public void serveThongTinHoSoThuTuc(ResourceRequest request, AjaxResponse ajaxResponse) throws Exception {

		long 
			thuTucId = ParamUtil.getLong(request, HoSoFields.thuTucHanhChinhId)
		,	coQuanId = ParamUtil.getLong(request, HoSoFields.coQuanQuanLyId)
		,	hoSoId = ParamUtil.getLong(request, HoSoFields.hoSoId)
		;
		
		boolean laBoSung = ParamUtil.getBoolean(request, HoSoFields.laBoSung);
		
		JSONObject thongTinThuTucJSON = null;
		JSONArray dsGiayToJSON = null;
		
		if (laBoSung) {
			HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
			List<GiayToDinhKemHoSo> ds = FileDinhKemLocalServiceUtil.getDSGiayToKhiBoSungHoSo(hoSo);
			ThongTinHoSo thongTinHoSo = new ThongTinHoSoImpl(hoSo);
			thongTinThuTucJSON = HoSoJSON.thuTucCuaHoSo(thongTinHoSo);
			dsGiayToJSON = HoSoJSON.dsGiayToDinhKemHoSo(ds);
		} else {
			
			ThongTinThuTuc2CoQuan info =
				ThuTucHanhChinhLocalServiceUtil.fetchThongTinThuTuc2CoQuan(thuTucId, coQuanId);
			
			List<GiayToDinhKemHoSo> ds =
				FileDinhKemLocalServiceUtil.getDSGiayToKhiTiepNhanHoSo(thuTucId);
			
			CongChuc canBo = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
			
			boolean duocPhepEditCongDan = false;
			
			if (info != null) {
				CongChuc2NhomThuTuc cauHinh =
					CongChuc2NhomThuTucLocalServiceUtil.fetchByCongChucAndNhomThuTuc(
						canBo.getId(), info.getNhomThuTucId()
					);
				
				if (cauHinh != null) {
					duocPhepEditCongDan = (cauHinh.getDuocPhepEditCongDan() == 1);
				}
			}
			
			thongTinThuTucJSON = HoSoJSON.thuTuc2CoQuan(info);
			thongTinThuTucJSON.put(CB2NTTFields.duocPhepEditCongDan, duocPhepEditCongDan);
			dsGiayToJSON = HoSoJSON.dsGiayToDinhKemHoSo(ds);
		}
		
		ajaxResponse
			.send(HoSoFields.thongTinThuTuc, thongTinThuTucJSON)
			.send(HoSoFields.dsGiayToQuyDinh, dsGiayToJSON);
		;
	}
	
	/**
	 * This is function searchCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws Exception
	 */
	public void searchCongDan(ResourceRequest request, AjaxResponse ajaxResponse) throws Exception {
		QueryResult<org.oep.cmon.dao.beans.congdan.CongDan> queryResult = CongDanLocalServiceUtil.search(request);
		JSONArray dsCongDanJSON = JSONFactoryUtil.createJSONArray();
		for (org.oep.cmon.dao.beans.congdan.CongDan congDanBean : queryResult.getResult()) {
			dsCongDanJSON.put(HoSoJSON.congDan(congDanBean));
		}
		ajaxResponse.sendSearchResult( queryResult, dsCongDanJSON );
	}
	
	/**
	 * This is function processTiepNhanTrucTiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws Exception
	 */
	public void processTiepNhanTrucTiep(UploadPortletRequest request, AjaxResponse ajaxResponse) throws Exception {

		if ( !_validate(request, ajaxResponse) ) {
			return;
		}

		// Luu thong tin tiep nhan truc tiep
		_saveInfo(request);
		
		long hoSoId = (Long) request.getAttribute(HSLTFields.hoSoId);
		int trangThaiHoSo = (Integer) request.getAttribute(HSLTFields.trangThaiHoSo);
		String maUngDung = (String) request.getAttribute(HSLTFields.maUngDung);
		
		// Upload file dinh kem
		_upload(request, hoSoId, trangThaiHoSo, maUngDung);
		
		// Chuyen den trang chi tiet giay bien nhan
		LiferayURL inBienNhanURL = HoSoBusinessUtil.getURLInBienNhan(request)
			.setParameter(HoSoFields.hoSoId, request.getAttribute(HoSoFields.hoSoId))
			.setParameter("backURL", ParamUtil.getString(request, "backURL"));
		
		ajaxResponse.redirect(inBienNhanURL.toString());
	}
	
	/**
	 * This is function _saveInfo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void _saveInfo(UploadPortletRequest request) throws PortalException, SystemException {
		
		long hoSoId = ParamUtil.getLong(request, HoSoFields.hoSoId);
		boolean isNew = (hoSoId == 0L);
		
		ThuTucHanhChinh tthc =
			ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(ParamUtil.getLong(request, HoSoFields.thuTucHanhChinhId));
		CoQuanQuanLy cqql =
			CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(ParamUtil.getLong(request, HoSoFields.coQuanQuanLyId));
		String email = PortalUtil.getUser(request).getEmailAddress();
		
		Date now = DateTimeUtil.getDateTimeNow();
		Date ngayNhanHoSo = DateTimeUtil.getRequestDate(request, HoSoFields.ngayNhanHoSo, HoSoFields.gioPhutNhanHoSo);
		if (ngayNhanHoSo == null) {
			ngayNhanHoSo = now;
		}
		
		HoSoTTHCCong hoSo = null;
		int trangThaiHoSo = Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN;
		String maUngDung;
		
		if (isNew) {
			String maSoBienNhan = MaSoBienNhanUtil.get(cqql.getMaCapSoBienNhan(), tthc.getMaDNG(), false);
			maUngDung = new FormServiceImpl().getMaUngDungTheoQuyTrinh(tthc.getId());
			long dvhcId = ParamUtil.getLong(request, HoSoFields.xaThuongTruId);
			if (dvhcId == 0L) {
				dvhcId = ParamUtil.getLong(request, HoSoFields.huyenThuongTruId);
			}
			long canBoTiepNhanId = ParamUtil.getLong(request, HoSoFields.canBoTiepNhanId);
			CongChuc canBoTiepNhan = CongChucLocalServiceUtil.fetchCongChuc(canBoTiepNhanId);
			
			CongDan congDanNop = 
				CongDanLocalServiceUtil.fetchCongDan(ParamUtil.getLong(request, HoSoFields.nguoiNopHoSoCongDanId));
			org.oep.cmon.dao.beans.congdan.CongDan nguoiNop = new CongDanImpl(congDanNop);
			
			int lePhi = (int) VNNumberUtil.toNum(ParamUtil.getString(request, HoSoFields.lePhiHoSo));
			int phi = (int) VNNumberUtil.toNum(ParamUtil.getString(request, HoSoFields.phiHoSo));
			
			hoSo = new HoSoTTHCCongClp();
			hoSoId = CounterLocalServiceUtil.increment(FormOfflineBusiness.CMON_HOSOTTHCCONG_SEQUENCE);
			hoSo.setId(hoSoId);
			hoSo.setMaSoHoSo(Long.toString(System.currentTimeMillis()));
			hoSo.setMaSoBienNhan(maSoBienNhan);
			hoSo.setNgayTao(now);
			hoSo.setNgaySua(now);
			hoSo.setNguoiTao(email);
			hoSo.setDaXoa(Constants.ACTIVE);
			hoSo.setThuTucHanhChinhId(tthc.getId());
			hoSo.setTenThuTucHanhChinh(tthc.getTen());
			hoSo.setMaUngDung(maUngDung);
			hoSo.setLoaiHoSo(Constants.LOAI_HO_SO_TRUC_TIEP);
			hoSo.setCongDanNopId(nguoiNop.getCongDanId());
			hoSo.setHoTenNguoiNopHoSo(ParamUtil.getString(request, HoSoFields.hoTenNguoiNopHoSo).trim());
			hoSo.setDiaChiThuongTruNguoiNop(ParamUtil.getString(request, HoSoFields.diaChiThuongTru).trim());
			hoSo.setDiaChiThuongTruNguoiNopId(dvhcId);
			hoSo.setSoDienThoaiCoDinhNguoiNop(ParamUtil.getString(request, HoSoFields.dienThoaiCoDinh).trim());
			hoSo.setSoDienThoaiDiDongNguoiNop(ParamUtil.getString(request, HoSoFields.dienThoaiDiDong).trim());
			hoSo.setEmailNguoiNop(ParamUtil.getString(request, HoSoFields.email).trim());
			hoSo.setChuSoHuu(ParamUtil.getString(request, HoSoFields.chuSoHuu).trim());
			hoSo.setDiaChiChuHoSo(ParamUtil.getString(request, HoSoFields.diaChiChuHoSo).trim());
			hoSo.setNgayNopHoSo(ngayNhanHoSo);
			hoSo.setNgayNopHoSoGoc(ngayNhanHoSo);
			hoSo.setNgayNhanHoSo(ngayNhanHoSo);
			hoSo.setCanBoTiepNhanId(canBoTiepNhanId);
			hoSo.setCanBoXuLyHienThoiId(canBoTiepNhanId);
			hoSo.setTenCanBoTiepNhan(canBoTiepNhan.getHoVaTen());
			hoSo.setChucVuCanBoTiepNhan(ChucVuLocalServiceUtil.getChucVu(canBoTiepNhan.getChucVuId()).getTen());
			hoSo.setLePhi(lePhi);
			hoSo.setPhiHoSo(phi);
			hoSo.setTrangThaiHoSo(trangThaiHoSo);
			hoSo.setNgayHenTraKetQua(
				DateTimeUtil.getRequestDate(request, HoSoFields.ngayHenTraHoSo, HoSoFields.gioPhutHenTraHoSo));
			hoSo.setCoQuanTiepNhanId(cqql.getId());
			hoSo.setTenCoQuanTiepNhan(cqql.getTen());
			hoSo.setSoBoHoSo(ParamUtil.getInteger(request, HoSoFields.soBoHoSo));
			hoSo.setSoNgayXuLy(ParamUtil.getLong(request, HoSoFields.soNgayXuLy));
			hoSo.setMoTaThanhPhanHoSo(ParamUtil.getString(request, HoSoFields.moTaGiayToKhac));
			hoSo.setLienKetThanhPhanHoSo(ParamUtil.getString(request, HoSoFields.lienKetGiayToKhac));
			hoSo.setGhiChuGiayToDinhKem(ParamUtil.getString(request, HoSoFields.ghiChuFileDinhKem));
			hoSo.setGioiTinh((int) canBoTiepNhan.getGioiTinhId());
			hoSo.setDaDangKyNhanSMS(ParamUtil.getInteger(request, HoSoFields.daDangKyNhanSMS));
			hoSo.setDaDangKyChuyenPhatNhanh(ParamUtil.getInteger(request, HoSoFields.daDangKyChuyenPhatNhanh));
			HoSoTTHCCongLocalServiceUtil.addHoSoTTHCCong(hoSo);
			
			// Luu phi va le phi
			ThongTinThanhToan thanhToan = new ThongTinThanhToanClp();
			thanhToan.setId(CounterLocalServiceUtil.increment(ThongTinThanhToan.class.getName()));
			thanhToan.setHoSoTTHCCongId(hoSoId);
			thanhToan.setTaiKhoanNguoiDungNhanId(canBoTiepNhan.getTaiKhoanNguoiDungId());
			thanhToan.setTaiKhoanNguoiDungNopId(nguoiNop.getTaiKhoanNguoiDungId(false));
			thanhToan.setLoaiThanhToan(Constants.ThongTinThanhToan.HINHTHUC_TIENMAT);
			thanhToan.setTenNguoiNopTien(nguoiNop.getHoTenDayDu());
			thanhToan.setTenCanBoNhanTien(canBoTiepNhan.getHoVaTen());
			thanhToan.setXacNhan(1);
			thanhToan.setNgayThuTien(ngayNhanHoSo);
			thanhToan.setNgayXacNhan(ngayNhanHoSo);
			thanhToan.setNgayTao(now);
			thanhToan.setNguoiTao(email);
			thanhToan.setLoaiPhi(Constants.ThongTinThanhToan.LE_PHI);
			thanhToan.setSoTien(lePhi);
			ThongTinThanhToanLocalServiceUtil.addThongTinThanhToan(thanhToan);
			
			if (phi > 0) {
				thanhToan = new ThongTinThanhToanClp();
				thanhToan.setId(CounterLocalServiceUtil.increment(ThongTinThanhToan.class.getName()));
				thanhToan.setHoSoTTHCCongId(hoSoId);
				thanhToan.setTaiKhoanNguoiDungNhanId(canBoTiepNhan.getTaiKhoanNguoiDungId());
				thanhToan.setTaiKhoanNguoiDungNopId(nguoiNop.getTaiKhoanNguoiDungId(false));
				thanhToan.setLoaiThanhToan(Constants.ThongTinThanhToan.HINHTHUC_TIENMAT);
				thanhToan.setTenNguoiNopTien(nguoiNop.getHoTenDayDu());
				thanhToan.setTenCanBoNhanTien(canBoTiepNhan.getHoVaTen());
				thanhToan.setXacNhan(1);
				thanhToan.setNgayThuTien(ngayNhanHoSo);
				thanhToan.setNgayXacNhan(ngayNhanHoSo);
				thanhToan.setNgayTao(now);
				thanhToan.setNguoiTao(email);
				thanhToan.setLoaiPhi(Constants.ThongTinThanhToan.PHI);
				thanhToan.setSoTien(phi);
				ThongTinThanhToanLocalServiceUtil.addThongTinThanhToan(thanhToan);
			}
			
			// Cap nhat du lieu cong dan neu duoc phep
			if (ParamUtil.getInteger(request, CB2NTTFields.duocPhepEditCongDan) != 0) {
				
				congDanNop.setSoCmnd(ParamUtil.getString(request, HoSoFields.soCMND).trim());
				congDanNop.setNgaySinh(DateTimeUtil.getRequestDate(request, HoSoFields.ngaySinh));
				congDanNop.setGioiTinh(ParamUtil.getInteger(request, HoSoFields.gioiTinh));
				congDanNop.setDienThoaiCoDinh(ParamUtil.getString(request, HoSoFields.dienThoaiCoDinh).trim());
				congDanNop.setDienThoaiDiDong(ParamUtil.getString(request, HoSoFields.dienThoaiDiDong).trim());
				congDanNop.setEmail(ParamUtil.getString(request, HoSoFields.email).trim());
				congDanNop.setDiaChiThuongTru(ParamUtil.getString(request, HoSoFields.diaChiThuongTru).trim());
				congDanNop.setDiaChiThuongTruTinhId(ParamUtil.getLong(request, HoSoFields.tinhThuongTruId));
				congDanNop.setDiaChiThuongTruHuyenId(ParamUtil.getLong(request, HoSoFields.huyenThuongTruId));
				
				long xaThuongTruId = ParamUtil.getLong(request, HoSoFields.xaThuongTruId);
				if (xaThuongTruId != 0L) {
					congDanNop.setDiaChiThuongTruXaId(xaThuongTruId);
				}
				
				String hoTen =
					ParamUtil.getString(request, HoSoFields.hoTenNguoiNopHoSo).trim().replaceAll(" +", StringPool.SPACE);
				String[] arr = hoTen.split(StringPool.SPACE);
				
				if (arr.length == 2) {
					congDanNop.setHo(arr[0]);
					congDanNop.setTen(arr[1]);
				} else if (arr.length > 2) {
					congDanNop.setHo(arr[0]);
					congDanNop.setTen(arr[arr.length - 1]);
					congDanNop.setDem(
						StringUtils.join(
							Arrays.copyOfRange(arr, 1, arr.length - 1), StringPool.SPACE).trim()
					);
				} else {
					congDanNop.setTen(arr[0]);
					congDanNop.setHo(StringPool.SPACE);
				}
				
				congDanNop.setNgaySua(now);
				congDanNop.setNguoiSua(email);
				
				CongDanLocalServiceUtil.updateCongDan(congDanNop);
			}
			
		// Bo sung ho so	
		} else {
			hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
			maUngDung = hoSo.getMaUngDung();
			hoSo.setNguoiSua(email);
			hoSo.setNgaySua(now);
			
			trangThaiHoSo = (hoSo.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN)
				? Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN
				: Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_DANG_XU_LY;
			
			hoSo.setTrangThaiHoSo(trangThaiHoSo);
			hoSo.setNgayBoSung(now);
			hoSo.setNgayHenTraKetQua(
				DateTimeUtil.getRequestDate(request, HoSoFields.ngayHenTraHoSo, HoSoFields.gioPhutHenTraHoSo));
			hoSo.setSoBoHoSo(ParamUtil.getInteger(request, HoSoFields.soBoHoSo));
			hoSo.setSoNgayXuLy(ParamUtil.getLong(request, HoSoFields.soNgayXuLy));
			hoSo.setGhiChu(ParamUtil.getString(request, HoSoFields.ghiChuBoSung));
			hoSo.setGhiChuGiayToDinhKem(ParamUtil.getString(request, HoSoFields.ghiChuFileDinhKem));
			hoSo.setMoTaThanhPhanHoSo(ParamUtil.getString(request, HoSoFields.moTaGiayToKhac));
			hoSo.setLienKetThanhPhanHoSo(ParamUtil.getString(request, HoSoFields.lienKetGiayToKhac));
			hoSo.setDaDangKyNhanSMS(ParamUtil.getInteger(request, HoSoFields.daDangKyNhanSMS));
			hoSo.setDaDangKyChuyenPhatNhanh(ParamUtil.getInteger(request, HoSoFields.daDangKyChuyenPhatNhanh));
			HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);
		}
		
		request.setAttribute(HoSoFields.hoSoId, hoSoId);
		request.setAttribute(HoSoFields.trangThaiHoSo, trangThaiHoSo);
		request.setAttribute(HoSoFields.maUngDung, maUngDung);
	}

	/**
	 * This is function _validate
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws IOException
	 * @throws SystemException
	 * @return boolean
	 */
	private boolean _validate(UploadPortletRequest request, AjaxResponse ajaxResponse)
		throws IOException, SystemException
	{
		Validator validator = new Validator(request, BusinessMessagerUtil.forPrefix(request, _PREFIX));
		IsSelected chuaChon = new IsSelected();
		IsFilled chuaNhap = new IsFilled();
		IsNumber laSo = new IsNumber();
		
		if (validator.check(chuaChon, HoSoFields.nguoiNopHoSoCongDanId, "nguoiNopHoSo")) {
			validator.check(chuaNhap, HoSoFields.hoTenNguoiNopHoSo);
			validator.check(new IsDayMonthYear(), HoSoFields.ngaySinh);
			validator.check(chuaChon.setDefault(-1L), HoSoFields.gioiTinh);
			validator.check(chuaNhap, HoSoFields.diaChiThuongTru);
			validator.check(chuaChon.setDefault(0L), HoSoFields.tinhThuongTruId);
			validator.check(chuaChon, HoSoFields.huyenThuongTruId);
		}
		
		validator.check(chuaChon, HoSoFields.thuTucHanhChinhId);
		validator.check(chuaNhap, HoSoFields.chuSoHuu);
		
		if (!"on".equals(ParamUtil.getString(request, HoSoFields.laNguoiNop))) {
			validator.check(chuaNhap, HoSoFields.diaChiChuHoSo);
		}

		validator.check(laSo.setZeroCompareMark(IsNumber.GT0), HoSoFields.soBoHoSo);
		validator.check(laSo.setZeroCompareMark(IsNumber.GTE0), HoSoFields.soNgayXuLy);
		
		DateTimePairValidator.forDayAndHourMinute(
			validator,
			HoSoFields.ngayNhanHoSo,
			HoSoFields.gioPhutNhanHoSo,
			HoSoFields.ngayHenTraHoSo,
			HoSoFields.gioPhutHenTraHoSo,
			true
		);
		
		// Validate upload tiep nhan
		_validateUpload(request, validator);
		
		return ajaxResponse.sendValidateResult(validator);
	}
	
	private static final String _PREFIX = "field";
	protected static Log _log = LogFactoryUtil.getLog(HoSoTrucTiepPortlet.class);
}