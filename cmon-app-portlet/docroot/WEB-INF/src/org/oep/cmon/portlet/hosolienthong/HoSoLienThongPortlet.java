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

package org.oep.cmon.portlet.hosolienthong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.WindowStateException;

import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.oep.cmon.Constants;
import org.oep.cmon.dao.beans.thongtinhoso.ThongTinHoSoImpl;
import org.oep.cmon.dao.hosolienthong.model.impl.HoSoLienThongModelImpl;
import org.oep.cmon.portlet.cmon.TiepNhanHoSoPortlet;
import org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil;
import org.oep.cmon.portlet.hosotructiep.HoSoJSON;
import org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil;
import org.oep.cmon.util.EgovUtil;
import org.oep.cmon.util.MaSoBienNhanUtil;
import org.oep.egovcore.language.BusinessMessagerUtil;
import org.oep.egovcore.language.CmonMessagerUtil;
import org.oep.egovcore.portlet.AjaxResponse;
import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.util.LiferayURL;
import org.oep.egovcore.validate.Validator;
import org.oep.egovcore.validate.term.IsNumber;
import org.oep.egovcore.validate.util.DateTimePairValidator;
import org.oep.sharedservice.cmon.provider.form.FormServiceImpl;

import org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo;
import org.oep.cmon.dao.beans.thongtinhoso.ThongTinHoSo;
import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc;
import org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiClp;
import org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil;
import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;
import org.oep.cmon.dao.hosolienthong.model.HoSoLienThongClp;
import org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.egovcore.sqlutil.QueryResult;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrms;
import vn.dtt.sharedservice.bpm.consumer.uengine.KeyedParameter;

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
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class HoSoLienThongPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HoSoLienThongPortlet extends TiepNhanHoSoPortlet {
	
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
			thuTucId = ParamUtil.getLong(request, HSLTFields.thuTucHanhChinhId)
		,	coQuanId = ParamUtil.getLong(request, HSLTFields.coQuanQuanLyId)
		,	hoSoId = ParamUtil.getLong(request, HSLTFields.hoSoId)
		;
		
		JSONObject thongTinThuTucJSON = null;
		JSONArray dsGiayToJSON = null;
		
		// Fill thong tin luc tiep nhan khoi tao lien thong
		// soBoHoSo: mac dinh fill thong tin da nop o co quan khoi tai lien thong, cho edit
		// lePhi, phi: mac dinh fill thong tin da nop o co quan khoi tai lien thong, khong cho edit
		HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
		HSLTBusinessUtil.fillThongTinHoSoLucKhoiTaoLienThong(hoSo);
		ThongTinHoSo thongTinHoSo = new ThongTinHoSoImpl(hoSo);
		
		// Thu tuc se la thu tuc can tiep nhan lien thong
		thongTinHoSo.setThuTucId(thuTucId);
		
		// So ngay xu ly: fill so ngay xu ly du kien cua thu tuc can tiep nhan
		ThongTinThuTuc2CoQuan thuTuc2CoQuanInfo =
			ThuTucHanhChinhLocalServiceUtil.fetchThongTinThuTuc2CoQuan(thuTucId, coQuanId);
		thongTinHoSo.setSoNgayXuLy(thuTuc2CoQuanInfo.getSoNgayXuLy());
		
		// DS giay to quy dinh: fill ds giay to cua thu tuc can tiep nhan lien thong
		List<GiayToDinhKemHoSo> ds = FileDinhKemLocalServiceUtil.getDSGiayToKhiTiepNhanHoSo(thuTucId);
		
		thongTinThuTucJSON = HoSoJSON.thuTucCuaHoSo(thongTinHoSo);
		dsGiayToJSON = HoSoJSON.dsGiayToDinhKemHoSo(ds);
		
		ajaxResponse
			.send(HSLTFields.thongTinThuTuc, thongTinThuTucJSON)
			.send(HSLTFields.dsGiayToQuyDinh, dsGiayToJSON);
		;
	}
	
	/**
	 * This is function processTraKetQuaLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSo
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static void processTraKetQuaLienThong(PortletRequest request, HoSoTTHCCong hoSo) 
		throws SystemException, PortalException
	{
		Date now = DateTimeUtil.getDateTimeNow();
		String email = PortalUtil.getUser(request).getEmailAddress();
		HoSoLienThong hoSoLienThong = 
			HoSoLienThongLocalServiceUtil.fetchHoSoLienThong(ParamUtil.getLong(request, HSLTFields.hoSoLienThongId));
		hoSoLienThong.setTrangThaiLienThong(HSLTBusinessUtil.TTLT_DA_TRA_KET_QUA);
		hoSoLienThong.setNgayNoiNhanTraKetQua(now);
		hoSoLienThong.setNgaySua(now);
		hoSoLienThong.setNguoiSua(email);
		HoSoLienThongLocalServiceUtil.updateHoSoLienThong(hoSoLienThong);
		
		hoSo.setTrangThaiHoSo(Constants.TRANGTHAIHOSO.HO_SO_DA_TRA_KET_QUA);
		hoSo.setNgaySua(now);
		hoSo.setNguoiSua(email);
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);
	}
	
	/**
	 * This is function serveChiTietTuChoi
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws SystemException
	 */
	public void serveChiTietTuChoi(ResourceRequest request, AjaxResponse ajaxResponse) throws SystemException {
		
		long hoSoLienThongId = ParamUtil.getLong(request, HSLTFields.hoSoLienThongId);
		HoSoLienThong hoSoLienThong = HoSoLienThongLocalServiceUtil.fetchHoSoLienThong(hoSoLienThongId);
		
		String
			lucTuChoi = StringPool.BLANK
		,	noiDungTuChoi = StringPool.BLANK
		,	hoTenCanBoTuChoi = StringPool.BLANK
		;

		CongChuc congChucDaDangNhap = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
		
		List<YKienTraoDoi> list = 
			YKienTraoDoiLocalServiceUtil.findByHoSoTTHCCongIdAndLoai(
				hoSoLienThong.getHoSoId()
				,Constants.LOAI_Y_KIEN_TRAO_DOI.TU_CHOI_HO_SO
			);

		YKienTraoDoi yKien = null;
		for (YKienTraoDoi item : list) {
			if ( item.getNguoiNhanId().equals(congChucDaDangNhap.getTaiKhoanNguoiDungId()) ) {
				yKien = item;
				break;
			}
		}
		
		if (yKien != null) {
			noiDungTuChoi = yKien.getNoiDungYKien();
			List<CongChuc> ds = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(yKien.getNguoiGuiId());
			if (!ds.isEmpty()) {
				hoTenCanBoTuChoi = ds.get(0).getHoVaTen();
			}
		}

		lucTuChoi = DateTimeUtil.getFullDateTime(hoSoLienThong.getNgayTuChoi(), false);
		
		ajaxResponse.send( HSLTFields.tenThuTucGui, hoSoLienThong.getTenThuTucGui());
		ajaxResponse.send(HSLTFields.hoTenNguoiNopHoSo, hoSoLienThong.getHoTenCongDanNop());
		ajaxResponse.send(HSLTFields.lucGui, DateTimeUtil.getFullDateTime(hoSoLienThong.getNgayGui(), false));
		ajaxResponse.send(HSLTFields.lucTuChoi, lucTuChoi);
		ajaxResponse.send(HSLTFields.yKienTuChoi, noiDungTuChoi);
		ajaxResponse.send(HSLTFields.hoTenCanBoTuChoi, hoTenCanBoTuChoi);
		ajaxResponse.send(HSLTFields.tenCoQuanNhan, hoSoLienThong.getTenCoQuanNhan());
		ajaxResponse.send(HSLTFields.tenCoQuanNhan, hoSoLienThong.getTenCoQuanNhan() );
		
		// Parameter de gui lai lien thong
		ajaxResponse.send(HSLTFields.hoSoId, hoSoLienThong.getHoSoId());
		ajaxResponse.send(HSLTFields.thuTucNhanId, hoSoLienThong.getThuTucNhanId());
		ajaxResponse.send(HSLTFields.coQuanNhanId, hoSoLienThong.getCoQuanNhanId());
	}
	
	/**
	 * This is function processTuChoiLienThong
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
	public void processTuChoiLienThong(ResourceRequest request, AjaxResponse ajaxResponse)
		throws Exception
	{
		long hoSoLienThongId = ParamUtil.getLong(request, HSLTFields.hoSoLienThongId);
		User liferayUser = PortalUtil.getUser(request);
		HoSoLienThong hoSoLienThong = HoSoLienThongLocalServiceUtil.fetchHoSoLienThong(hoSoLienThongId);
		HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoLienThong.getHoSoId());
		String emailCanBo = liferayUser.getEmailAddress();
		
		// GOI WS UENGINE TU CHOI HO SO LIEN THONG
		_pushUengine2NextStep(hoSo.getMaSoHoSo(), emailCanBo, UE_APPROVED_VALUE_NO);
		
		hoSoLienThong.setTrangThaiLienThong(HSLTBusinessUtil.TTLT_DA_TU_CHOI);
		Date now = DateTimeUtil.getDateTimeNow();
		hoSoLienThong.setNgaySua(now);
		hoSoLienThong.setNgayTuChoi(now);
		hoSoLienThong.setNguoiSua(emailCanBo);
		HoSoLienThongLocalServiceUtil.updateHoSoLienThong(hoSoLienThong);
		
		YKienTraoDoi yKienTuChoi = new YKienTraoDoiClp();
		yKienTuChoi.setHoSoTTHCCongId(hoSo.getId());
		yKienTuChoi.setId(CounterLocalServiceUtil.increment(YKienTraoDoi.class.getName()));
		
		String noiDungYKien = ParamUtil.getString(request, HSLTFields.yKienTuChoi).trim();
		yKienTuChoi.setNoiDungYKien(noiDungYKien);
		yKienTuChoi.setNguoiGuiId(EgovUtil.getCongChucDaDangNhap(liferayUser.getUserId()).getTaiKhoanNguoiDungId());
		yKienTuChoi.setNguoiNhanId(
			TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(
				CongChucLocalServiceUtil.fetchCongChuc(hoSoLienThong.getCanBoGuiId())
					.getTaiKhoanNguoiDungId()
			)
			.getId()
		);
		yKienTuChoi.setLoai(Constants.LOAI_Y_KIEN_TRAO_DOI.TU_CHOI_HO_SO);
		yKienTuChoi.setTieuDe(StringPool.SPACE);
		yKienTuChoi.setThoiGianGuiYKien(now);
		yKienTuChoi.setTrangThai(0);
		YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(yKienTuChoi);
		
		ajaxResponse.sendSuccessMessage(CmonMessagerUtil.get("message.xu_ly_thanh_cong"));
		ajaxResponse.redirect(HSLTBusinessUtil.getURLDanhSachHoSoNoiNhan(request).toString());
	}
	
	private static final String _PREFIX = "field";
	
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
	 * @throws SystemException
	 * @return boolean
	 */
	private boolean _validate(UploadPortletRequest request, AjaxResponse ajaxResponse) throws SystemException {
		
		Validator validator = new Validator(request, BusinessMessagerUtil.forPrefix(request, _PREFIX));
		validator.check(new IsNumber(IsNumber.GTE0), HSLTFields.soNgayXuLy);
		DateTimePairValidator.forDayAndHourMinute(
			validator,
			HSLTFields.ngayNhanHoSo,
			HSLTFields.gioPhutNhanHoSo,
			HSLTFields.ngayHenTraHoSo,
			HSLTFields.gioPhutHenTraHoSo,
			true
		);
		
		// Validate upload tiep nhan
		_validateUpload(request, validator);
				
		return ajaxResponse.sendValidateResult(validator);
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
	 * @param hoSoLienThong
	 * @param liferayUser
	 * @throws SystemException
	 * @throws PortalException
	 */
	private void _saveInfo(
		UploadPortletRequest request,
		HoSoLienThong hoSoLienThong,
		User liferayUser
	) throws SystemException, PortalException {
		
		Date now = DateTimeUtil.getDateTimeNow();
		Date ngayNhanHoSo = DateTimeUtil.getRequestDate(request, HSLTFields.ngayNhanHoSo, HSLTFields.gioPhutNhanHoSo);
		if (ngayNhanHoSo == null) {
			ngayNhanHoSo = now;
		}
		ThuTucHanhChinh thuTuc =
			ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSoLienThong.getThuTucNhanId());
		CongChuc canBoTiepNhan = EgovUtil.getCongChucDaDangNhap(liferayUser.getUserId());
		CoQuanQuanLy cqql = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(canBoTiepNhan.getCoQuanQuanLyId());
		String maSoBienNhanMoi = MaSoBienNhanUtil.get(cqql.getMaCapSoBienNhan(), thuTuc.getMaDNG(), false);
		String email = liferayUser.getEmailAddress();
		
		HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoLienThong.getHoSoId());
		hoSo.setNguoiSua(email);
		hoSo.setNgaySua(now);
		hoSo.setCoQuanTiepNhanId(hoSoLienThong.getCoQuanNhanId());
		hoSo.setTenCoQuanTiepNhan(hoSoLienThong.getTenCoQuanNhan());
		hoSo.setCanBoTiepNhanId(canBoTiepNhan.getId());
		hoSo.setTenCanBoTiepNhan(canBoTiepNhan.getHoVaTen());
		hoSo.setThuTucHanhChinhId(hoSoLienThong.getThuTucNhanId());
		hoSo.setTenThuTucHanhChinh(hoSoLienThong.getTenThuTucNhan());
		hoSo.setCanBoXuLyHienThoiId(canBoTiepNhan.getId());
		
		// Truong hop Uengine chua update trang thai, thi Liferay se update thanh Dang Xu Ly
		if (hoSo.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.CHO_THUC_HIEN_LIEN_THONG) {
			hoSo.setTrangThaiHoSo(Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY);
		}
		
		hoSo.setChucVuCanBoTiepNhan(ChucVuLocalServiceUtil.getChucVu(canBoTiepNhan.getChucVuId()).getTen());
		hoSo.setMoTaThanhPhanHoSo(ParamUtil.getString(request, HSLTFields.moTaGiayToKhac));
		hoSo.setLienKetThanhPhanHoSo(ParamUtil.getString(request, HSLTFields.lienKetGiayToKhac));
		hoSo.setMaSoBienNhan(maSoBienNhanMoi);
		hoSo.setSoBoHoSo(ParamUtil.getInteger(request, HSLTFields.soBoHoSo));
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);
		
		hoSoLienThong.setTrangThaiLienThong(HSLTBusinessUtil.TTLT_DA_TIEP_NHAN);
		hoSoLienThong.setCanBoNhanId(canBoTiepNhan.getId());
		hoSoLienThong.setHoTenCanBoNhan(canBoTiepNhan.getHoVaTen());
		hoSoLienThong.setNgayNhan(ngayNhanHoSo);
		
		// Ngay hen tra va so ngay xu ly cua co quan tiep nhan lien thong
		hoSoLienThong.setNgayNoiNhanHenTra(
			DateTimeUtil.getRequestDate(request, HSLTFields.ngayHenTraHoSo, HSLTFields.gioPhutHenTraHoSo));
		hoSoLienThong.setSoNgayNoiNhanXuLyDuKien(ParamUtil.getInteger(request, HSLTFields.soNgayXuLy));
		
		long canBoNopHoSoGiayId = ParamUtil.getLong(request, HSLTFields.canBoNopHoSoGiayId);
		CongChuc canBoNopHoSoGiay = CongChucLocalServiceUtil.fetchCongChuc(canBoNopHoSoGiayId);
		
		if (canBoNopHoSoGiay != null) {
			hoSoLienThong.setCanBoNopHoSoGiayId(canBoNopHoSoGiayId);
			hoSoLienThong.setHoTenCanBoNopHoSoGiay(canBoNopHoSoGiay.getHoVaTen());
		}
		
		hoSoLienThong.setMaSoBienNhanLucNhan(maSoBienNhanMoi);
		hoSoLienThong.setNgaySua(now);
		hoSoLienThong.setNguoiSua(email);
		HoSoLienThongLocalServiceUtil.updateHoSoLienThong(hoSoLienThong);
		
		request.setAttribute(HSLTFields.hoSoId, hoSo.getId());
		request.setAttribute(HSLTFields.trangThaiHoSo, Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED);
		request.setAttribute(HSLTFields.maUngDung, new FormServiceImpl().getMaUngDungTheoQuyTrinh(thuTuc.getId()));
	}
	
	/**
	 * This is function processTiepNhanLienThong
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
	public void processTiepNhanLienThong(UploadPortletRequest request, AjaxResponse ajaxResponse) throws Exception {
		
		if ( !_validate(request, ajaxResponse) ) {
			return;
		}
		
		User liferayUser = PortalUtil.getUser(request);
		long hoSoLienThongId = ParamUtil.getLong(request, HSLTFields.hoSoLienThongId);
		HoSoLienThong hoSoLienThong = HoSoLienThongLocalServiceUtil.fetchHoSoLienThong(hoSoLienThongId);
		HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoLienThong.getHoSoId());
		
		// GOI UENGINE DE CHAY TIEP NHAN LIEN THONG 
		_pushUengine2NextStep(hoSo.getMaSoHoSo(), liferayUser.getEmailAddress(), UE_APPROVED_VALUE_YES);
		
		// Luu thong tin tiep nhan
		_saveInfo(request, hoSoLienThong, liferayUser);
		
		String maUngDung = (String) request.getAttribute(HSLTFields.maUngDung);
		
		// Upload dinh kem giai doan tiep nhan
		_upload( request, hoSo.getId(), hoSo.getTrangThaiHoSo(), maUngDung );
		
		// Chuyen den trang chi tiet giay bien nhan
		LiferayURL inBienNhanURL = HoSoBusinessUtil.getURLInBienNhan(request)
			.setParameter(HSLTFields.hoSoId, hoSo.getId())
			.setParameter(HSLTFields.hoSoLienThongId, hoSoLienThongId)
			.setParameter("backURL", ParamUtil.getString(request, "backURL"))
		;
		
		ajaxResponse.redirect(inBienNhanURL.toString());
	}
	
	protected static Log _log = LogFactoryUtil.getLog(HoSoLienThongPortlet.class);
	
	/**
	 * This is function _pushUengine2NextStep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maHoSo
	 * @param emailCanBo
	 * @param yesOrNo
	 * @throws SystemException
	 */
	private void _pushUengine2NextStep(String maHoSo, String emailCanBo, String yesOrNo) throws SystemException {
		
		IBrms brms = WebserviceFactory.getUengineService();

		List<KeyedParameter> processVariables = new ArrayList<KeyedParameter>();
		KeyedParameter processVariable = new KeyedParameter();
		
         //De quy trinh re nhanh phai "Hồ sơ đầy đủ"
		processVariable.setKey(UE_APPROVED_KEY);
        processVariable.setValue(yesOrNo);
        processVariables.add(processVariable);

        boolean b;
        String rootExceptionMessage = StringPool.BLANK;
        try {
        	_log.info("_____________GOI WS UENGINE " + (yesOrNo.equals(UE_APPROVED_VALUE_YES) ? " TIEP NHAN " : " TU CHOI ") + "LIEN THONG -maHoSo:" + maHoSo + " -emailCanBo:" + emailCanBo);
        	b = brms.completeWorkitemByAddProfile(maHoSo, emailCanBo, processVariables);
		} catch (javax.xml.ws.WebServiceException e) {
			rootExceptionMessage = "<br>Root Exception Message:" + ExceptionUtils.getRootCauseMessage(e);
			b = false;
		}
        
		if ( ! b ) {
			throw new SystemException(
				"LOI KHI GOI WEBSERVICE UENGINE" + 
				(yesOrNo.equals(UE_APPROVED_VALUE_YES) ? " TIEP NHAN " : " TU CHOI ") +
				"HO SO LIEN THONG" +
				"<br>WebserviceFactory.getUengineService().completeWorkitemByAddProfile()" +
				"<br>maHoSo:"+ maHoSo +
				"<br>emailCanBo:"+ emailCanBo +
				"<br>keyedParameter.getKey():" + UE_APPROVED_KEY +
				"<br>keyedParameter.getValue():" + yesOrNo +
				rootExceptionMessage
			);
		}
	}
	
	/**
	 * This is function processNhanKetQuaXuLyLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws PortalException
	 * @throws SystemException
	 * @throws WindowStateException
	 * @throws PortletModeException
	 */
	public void processNhanKetQuaXuLyLienThong(ResourceRequest request, AjaxResponse ajaxResponse)
		throws PortalException, SystemException, WindowStateException, PortletModeException
	{
		HoSoLienThong hoSoLienThong = 
			HoSoLienThongLocalServiceUtil.fetchHoSoLienThong(ParamUtil.getLong(request, HSLTFields.hoSoLienThongId));
		HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoLienThong.getHoSoId());
		Date now = DateTimeUtil.getDateTimeNow();
		String email = PortalUtil.getUser(request).getEmailAddress();
		
		hoSoLienThong.setTrangThaiLienThong(HSLTBusinessUtil.TTLT_DA_NHAN_KET_QUA);
		hoSoLienThong.setNgaySua(now);
		hoSoLienThong.setNgayNoiGuiNhanKetQua(now);
		hoSoLienThong.setNguoiSua(email);
		HoSoLienThongLocalServiceUtil.updateHoSoLienThong(hoSoLienThong);
		
		hoSo.setTrangThaiHoSo(Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG);
		hoSo.setCoQuanTiepNhanId(hoSoLienThong.getCoQuanGuiId());
		hoSo.setTenCoQuanTiepNhan(hoSoLienThong.getTenCoQuanGui());
		hoSo.setThuTucHanhChinhId(hoSoLienThong.getThuTucGuiId());
		hoSo.setTenThuTucHanhChinh(hoSoLienThong.getTenThuTucGui());
		hoSo.setCanBoXuLyHienThoiId(hoSoLienThong.getCanBoGuiId());
		hoSo.setCanBoTiepNhanId(hoSoLienThong.getCanBoTiepNhanNoiGuiId());
		hoSo.setTenCanBoTiepNhan(hoSoLienThong.getHoTenCanBoTiepNhanNoiGui());
		hoSo.setMaSoBienNhan(hoSoLienThong.getMaSoBienNhanLucGui());
		hoSo.setNgaySua(now);
		hoSo.setNguoiSua(email);
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);
		ajaxResponse.sendSuccessMessage(BusinessMessagerUtil.get(request, "message.nhan_ket_qua_thanh_cong"));
		ajaxResponse.reload();
	}
	
	/**
	 * This is function processGuiHoSoLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void processGuiHoSoLienThong(ResourceRequest request, AjaxResponse ajaxResponse)
		throws SystemException, PortalException
	{
		long hoSoId = ParamUtil.getLong(request, HSLTFields.hoSoId)
		,	coQuanNhanId = ParamUtil.getLong(request, HSLTFields.coQuanNhanId)
		,	thuTucNhanId = ParamUtil.getLong(request, HSLTFields.thuTucNhanId)
		;
		
		User liferayUser = PortalUtil.getUser(request);
		String email = liferayUser.getEmailAddress();
		Date now = DateTimeUtil.getDateTimeNow();
		
		CongChuc congChucDaDangNhap = EgovUtil.getCongChucDaDangNhap(liferayUser.getUserId());
		HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
		CoQuanQuanLy coQuanGui = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(hoSo.getCoQuanTiepNhanId()); 
		ThuTucHanhChinh thuTucGui = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSo.getThuTucHanhChinhId());
		CoQuanQuanLy coQuanNhan = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuanNhanId); 
		ThuTucHanhChinh thuTucNhan = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(thuTucNhanId);
		
		HoSoLienThong hoSoLienThong = null;
		boolean laGuiLaiSauKhiBiTuChoi = false;
		
		hoSo.setTrangThaiHoSo(Constants.TRANGTHAIHOSO.CHO_THUC_HIEN_LIEN_THONG);
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);
		
		for (HoSoLienThong item : HSLTBusinessUtil.getDSHoSoLienThong(hoSo)) {
			if ( item.getTrangThaiLienThong() == HSLTBusinessUtil.TTLT_DA_TU_CHOI
				&& item.getCoQuanGuiId() == congChucDaDangNhap.getCoQuanQuanLyId()
			) {
				laGuiLaiSauKhiBiTuChoi = true;
				hoSoLienThong = item;
				break;
			}
		}
		
		if ( !laGuiLaiSauKhiBiTuChoi ) {
			hoSoLienThong = new HoSoLienThongClp();
			hoSoLienThong.setId(CounterLocalServiceUtil.increment(HoSoLienThongModelImpl.TABLE_NAME));
			hoSoLienThong.setNgayTao(now);
			hoSoLienThong.setNguoiTao(email);
			hoSoLienThong.setThuTuLienThong(
				HoSoLienThongLocalServiceUtil.countByHoSoId(hoSo.getId()) + 1
			);
		}
		
		hoSoLienThong.setNgaySua(now);
		hoSoLienThong.setNguoiSua(email);
		hoSoLienThong.setNgayGui(now);
		hoSoLienThong.setCanBoGuiId(congChucDaDangNhap.getId());
		hoSoLienThong.setHoTenCanBoGui(congChucDaDangNhap.getHoVaTen());
		hoSoLienThong.setTrangThaiLienThong(HSLTBusinessUtil.TTLT_CHO_TIEP_NHAN);
		hoSoLienThong.setGhiChuGuiLienThong(ParamUtil.getString(request, HSLTFields.ghiChuGuiLienThong).trim());
		hoSoLienThong.setHoSoId(hoSoId);

		hoSoLienThong.setCoQuanGuiId(coQuanGui.getId());
		hoSoLienThong.setTenCoQuanGui(coQuanGui.getTen());
		hoSoLienThong.setThuTucGuiId(thuTucGui.getId());
		hoSoLienThong.setTenThuTucGui(thuTucGui.getTen());
		hoSoLienThong.setCoQuanNhanId(coQuanNhan.getId());
		hoSoLienThong.setTenCoQuanNhan(coQuanNhan.getTen());
		hoSoLienThong.setThuTucNhanId(thuTucNhan.getId());
		hoSoLienThong.setTenThuTucNhan(thuTucNhan.getTen());
		
		hoSoLienThong.setMaSoBienNhanLucGui(hoSo.getMaSoBienNhan());
		hoSoLienThong.setHoTenCongDanNop(hoSo.getHoTenNguoiNopHoSo());
		hoSoLienThong.setDiaChiDayDuCongDanNop(HoSoBusinessUtil.getDiaChiDayDuCongDanNopHoSo(hoSo));
		hoSoLienThong.setCanBoTiepNhanNoiGuiId(hoSo.getCanBoTiepNhanId());
		hoSoLienThong.setHoTenCanBoTiepNhanNoiGui(hoSo.getTenCanBoTiepNhan());
		
		HoSoLienThongLocalServiceUtil.updateHoSoLienThong(hoSoLienThong);

		ajaxResponse.sendSuccessMessage(BusinessMessagerUtil.get(request, "message.gui_ho_so_thanh_cong"));
		ajaxResponse.reload();
	}
	
	/**
	 * This is function searchHoSoLienThongNoiGui
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
	public void searchHoSoLienThongNoiGui(ResourceRequest request, AjaxResponse ajaxResponse) throws Exception {
		long thuTucGuiId = ParamUtil.getLong(request, HSLTFields.thuTucGuiId);
		long[] thuTucGuiIds;
		CongChuc canBoNoiGui = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
		
		if (thuTucGuiId == 0L) {
			
			List<ThongTinThuTuc> thuTucs = HSLTBusinessUtil.getDSThuTucLienThongNoiGui2CanBo(canBoNoiGui);
			int size = thuTucs.size();
			thuTucGuiIds = new long[size];
			for (int i = 0; i < size; ++ i) {
				thuTucGuiIds[i] = thuTucs.get(i).getThuTucId();
			}
		} else {
			thuTucGuiIds = new long[] {thuTucGuiId};
		}
		
		QueryResult<HoSoLienThong> queryResult =
			HoSoLienThongLocalServiceUtil.searchHoSoNoiGui(request, canBoNoiGui, thuTucGuiIds);
		JSONArray searchResultJSON = JSONFactoryUtil.createJSONArray();
		JSONObject jsitem;
		
		int count = queryResult.getFetchedCount();
		int trangThaiLienThong;
		List<HoSoLienThong> result = queryResult.getResult();
		HoSoLienThong hoSoLienThong = null;
		HoSoTTHCCong hoSo = null;
		
		for (int i = 0; i < count; i ++) {
			hoSoLienThong = result.get(i);
			trangThaiLienThong = hoSoLienThong.getTrangThaiLienThong();
			
			jsitem = JSONFactoryUtil.createJSONObject()
				.put(HSLTFields.hoSoLienThongId, hoSoLienThong.getId())
				.put(HSLTFields.hoSoId, hoSoLienThong.getHoSoId())
				.put(HSLTFields.tenThuTucGui, hoSoLienThong.getTenThuTucGui())
				.put(HSLTFields.maSoBienNhanLucGui, hoSoLienThong.getMaSoBienNhanLucGui())
				.put(HSLTFields.hoTenNguoiNopHoSo, WordUtils.capitalizeFully(hoSoLienThong.getHoTenCongDanNop()))
				.put(HSLTFields.hoTenCanBoGui, WordUtils.capitalizeFully(hoSoLienThong.getHoTenCanBoGui()))
				.put(HSLTFields.lucGui, DateTimeUtil.getFullDateTimeShort(hoSoLienThong.getNgayGui(), false))
				.put(HSLTFields.tenCoQuanNhan, hoSoLienThong.getTenCoQuanNhan())
				.put(HSLTFields.trangThaiLienThong, trangThaiLienThong)
				.put(HSLTFields.tenTrangThaiLienThong,
					HSLTBusinessUtil.getTenTrangThaiLienThong(request, trangThaiLienThong)
			)
			;
			
			jsitem.put(HSLTFields.coTheXemChiTiet,
				(trangThaiLienThong == HSLTBusinessUtil.TTLT_DA_NHAN_KET_QUA
				|| trangThaiLienThong == HSLTBusinessUtil.TTLT_DA_TU_CHOI)
			);
			
			jsitem.put(HSLTFields.daTraKetQua,
				trangThaiLienThong == HSLTBusinessUtil.TTLT_DA_TRA_KET_QUA
			);
			
			hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoLienThong.getHoSoId());
			jsitem.put(HSLTFields.coTheGuiLienThongLai,
				trangThaiLienThong == HSLTBusinessUtil.TTLT_DA_TU_CHOI
				&& ( !hoSo.getDungXuLy() )
			);
			
			if (trangThaiLienThong == HSLTBusinessUtil.TTLT_DA_TIEP_NHAN) {
				jsitem.put(HSLTFields.coTheYeuCauRut,
					RutHoSoBusinessUtil.laHoSoCanBoDuocPhepYeuCauRut(
						HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoLienThong.getHoSoId())
					)
				);
				jsitem.put(
					HSLTFields.yeuCauRutURL,
					RutHoSoBusinessUtil.getURLCanBoYeuCauRut(
						request,
						hoSoLienThong.getHoSoId(),
						HSLTBusinessUtil.getURLDanhSachHoSoNoiGui(request)
					)
				);
			} else {
				jsitem.put(HSLTFields.coTheYeuCauRut, false);
			}
			
			searchResultJSON.put(jsitem);
		}
		
		ajaxResponse.sendSearchResult(queryResult, searchResultJSON);
	}
	
	/**
	 * This is function searchHoSoLienThongNoiNhan
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
	public void searchHoSoLienThongNoiNhan(ResourceRequest request, AjaxResponse ajaxResponse) throws Exception {
		
		long thuTucNhanId = ParamUtil.getLong(request, HSLTFields.thuTucNhanId);
		long[] thuTucNhanIds;
		CongChuc canBoNoiNhan = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
		
		if (thuTucNhanId == 0L) {
			List<ThongTinThuTuc> thuTucs = HSLTBusinessUtil.getDSThuTucLienThongNoiNhan2CanBo(canBoNoiNhan);
			int size = thuTucs.size();
			thuTucNhanIds = new long[size];
			for (int i = 0; i < size; ++ i) {
				thuTucNhanIds[i] = thuTucs.get(i).getThuTucId();
			}
		} else {
			thuTucNhanIds = new long[] { thuTucNhanId };
		}
		
		QueryResult<HoSoLienThong> queryResult =
			HoSoLienThongLocalServiceUtil.searchHoSoNoiNhan(request, canBoNoiNhan, thuTucNhanIds);
		JSONArray searchResultJSON = JSONFactoryUtil.createJSONArray();
		
		int count = queryResult.getFetchedCount();
		int trangThaiLienThong;
		List<HoSoLienThong> result = queryResult.getResult();
		HoSoLienThong hoSoLienThong;
		
		for (int i = 0; i < count; i ++) {
			hoSoLienThong = result.get(i);
			trangThaiLienThong = hoSoLienThong.getTrangThaiLienThong();
			
			searchResultJSON.put(JSONFactoryUtil.createJSONObject()
				.put(HSLTFields.hoSoLienThongId, hoSoLienThong.getId())
				.put(HSLTFields.hoSoId, hoSoLienThong.getHoSoId())
				.put(HSLTFields.tenThuTucNhan, hoSoLienThong.getTenThuTucNhan())
				.put(HSLTFields.hoTenNguoiNopHoSo, WordUtils.capitalizeFully(hoSoLienThong.getHoTenCongDanNop()))
				.put(HSLTFields.diaChiDayDuCongDanNop, hoSoLienThong.getDiaChiDayDuCongDanNop())
				.put(HSLTFields.tenCoQuanGui, hoSoLienThong.getTenCoQuanGui())
				.put(HSLTFields.hoTenCanBoGui, WordUtils.capitalizeFully(hoSoLienThong.getHoTenCanBoGui()))
				.put(HSLTFields.lucGui, DateTimeUtil.getFullDateTimeShort(hoSoLienThong.getNgayGui(), false))
				.put(HSLTFields.trangThaiLienThong, trangThaiLienThong)
				.put(HSLTFields.tenTrangThaiLienThong,
					HSLTBusinessUtil.getTenTrangThaiLienThong(request, trangThaiLienThong))
			);
		}
		
		ajaxResponse.sendSearchResult(queryResult, searchResultJSON);
	}
	
	private static final String UE_APPROVED_KEY = "isApproved";
	private static final String UE_APPROVED_VALUE_YES = "YES";
	private static final String UE_APPROVED_VALUE_NO = "NO";
}
