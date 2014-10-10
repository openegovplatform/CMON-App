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
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.beans.cauhinhlienthong.CauHinhLienThong;
import org.oep.cmon.dao.beans.cauhinhlienthong.CauHinhLienThongImpl;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl;
import org.oep.cmon.util.CmonFields;
import org.oep.egovcore.language.BusinessMessagerUtil;
import org.oep.egovcore.util.LiferayURL;
import org.oep.egovcore.util.StringPool;

import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;
import org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;
import org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * This is class HSLTBusinessUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
@SuppressWarnings("unchecked")
public class HSLTBusinessUtil {
	
	public static final String JSP_BUTTON = "/html/portlet/hosolienthong/buttonGuiLienThong.jsp";
	public static final String JSP_TIEPNHAN = "/html/portlet/hosolienthong/formTiepNhan.jsp";
	public static final String PORTLET_NAME = "HoSoLienThongPortlet_WAR_cmonappportlet";
	public static final String PREFIX_TTLT_MESSAGE = "trang_thai_lien_thong.";
	
	public static final int TTLT_CHO_TIEP_NHAN = 1;
	public static final int TTLT_DA_TIEP_NHAN = 2;
	public static final int TTLT_DA_TU_CHOI = 3;
	public static final int TTLT_DA_TRA_KET_QUA = 4;
	public static final int TTLT_DA_NHAN_KET_QUA = 5;
	public static final int THU_TU_LIEN_THONG_DAU_TIEN = 1;
	
	public static final String LDS_NOI_GUI = StringPool.NUMBER1;
	public static final String LDS_NOI_NHAN = StringPool.NUMBER2;
	
	/**
	 * This is function laHoSoLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return boolean
	 */
	public static boolean laHoSoLienThong(HoSoTTHCCong hoSo) throws SystemException {
		boolean out = false;
		if (hoSo != null) {
			long thuTucId = hoSo.getThuTucHanhChinhId();
			ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(thuTucId);
			out = (thuTuc.getThuTucLienThongId() != null)
				|| (ThuTucHanhChinhLocalServiceUtil.countByThuTucLienThongId(thuTucId) > 0L);
		}
		return out;
	}
	
	/**
	 * This is function fillThongTinHoSoLucKhoiTaoLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 */
	public static void fillThongTinHoSoLucKhoiTaoLienThong(HoSoTTHCCong hoSo) throws SystemException {
		HoSoLienThong hoSoLienThong = getHoSoLienThongDauTien(hoSo);
		
		if (hoSoLienThong != null) {
			long coQuanKhoiTaoLienThongId = hoSoLienThong.getCoQuanGuiId();
			hoSo.setThuTucHanhChinhId(hoSoLienThong.getThuTucGuiId());
			hoSo.setTenThuTucHanhChinh(hoSoLienThong.getTenThuTucGui());
			hoSo.setCoQuanTiepNhanId(coQuanKhoiTaoLienThongId);
			hoSo.setTenCoQuanTiepNhan(hoSoLienThong.getTenCoQuanGui());
			hoSo.setCanBoTiepNhanId(hoSoLienThong.getCanBoTiepNhanNoiGuiId());
			hoSo.setTenCanBoTiepNhan(hoSoLienThong.getHoTenCanBoTiepNhanNoiGui());
			hoSo.setMaSoBienNhan(hoSoLienThong.getMaSoBienNhanLucGui());
			
			List<ThongTinThanhToan> listThanhToan = ThongTinThanhToanLocalServiceUtil.findByHoSoId(hoSo.getId());
			long phi = 0, lePhi = 0;
			for (ThongTinThanhToan thanhToan : listThanhToan) {
				List<CongChuc> list =
					CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(thanhToan.getTaiKhoanNguoiDungNhanId());
				
				if ( !list.isEmpty() && (list.get(0).getCoQuanQuanLyId() == coQuanKhoiTaoLienThongId) ) {
					if (thanhToan.getLoaiPhi() == Constants.ThongTinThanhToan.LE_PHI) {
						lePhi = thanhToan.getSoTien();
					} else {
						phi = thanhToan.getSoTien();
					}
				}
			}
			
			hoSo.setPhiHoSo((int) phi);
			hoSo.setLePhi((int) lePhi);
		}
	}
	
	/**
	 * This is function laThuTucKhoiTaoLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thuTuc
	 * @throws SystemException
	 */
	public static boolean laThuTucKhoiTaoLienThong(ThuTucHanhChinh thuTuc) throws SystemException {
		boolean out = false;
		if (thuTuc != null) {
			out = (thuTuc.getThuTucLienThongId() != null)
				
				// Dam bao day la thu tuc dau tien trong chuoi lien thong
				&& (ThuTucHanhChinhLocalServiceUtil.countByThuTucLienThongId(thuTuc.getId()) == 0L)
			;
		}
		return out;
	}

	/**
	 * This is function getCauHinhLienThongTiepTheo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thuTucHienTaiId
	 * @param coQuanHienTaiId
	 * @throws SystemException
	 * @return CauHinhLienThong
	 */
	public static CauHinhLienThong getCauHinhLienThongTiepTheo(
		long thuTucHienTaiId, long coQuanHienTaiId
	) throws SystemException {
		
		CauHinhLienThong out = null;
		
		ThuTucHanhChinh thuTucHienTai =
			ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(thuTucHienTaiId);
		CoQuanQuanLy coQuanHienTai =
			CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuanHienTaiId);
		
		if (thuTucHienTai == null || coQuanHienTai == null) {
			return out;
		}
		
		Long coQuanTiepTheoId = coQuanHienTai.getChaId(),
			thuTucTiepTheoId = thuTucHienTai.getThuTucLienThongId()
		;
		
		TTHC2CoQuanQuanLy cauHinhTTHC2CQTiepTheo = null;
		if (coQuanTiepTheoId != null && thuTucTiepTheoId != null) {
			List<TTHC2CoQuanQuanLy> list = TTHC2CoQuanQuanLyLocalServiceUtil
				.findByCoQuanAndThuTuc(coQuanTiepTheoId, thuTucTiepTheoId);
			if ( !list.isEmpty() ) {
				cauHinhTTHC2CQTiepTheo = list.get(0);
			}
		}
		
		if (cauHinhTTHC2CQTiepTheo != null) {
			
			ThuTucHanhChinh thuTucTiepTheo =
				ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(thuTucTiepTheoId);
			CoQuanQuanLy coQuanTiepTheo =
				CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuanTiepTheoId);
			
			out = new CauHinhLienThongImpl();
			out.setCoQuanId(coQuanTiepTheo.getId());
			out.setTenCoQuan(coQuanTiepTheo.getTen());
			out.setCoQuanTiepTheoId(coQuanTiepTheo.getChaId());
			out.setThuTucId(thuTucTiepTheo.getId());
			out.setTenThuTuc(thuTucTiepTheo.getTen());
			out.setThuTucTiepTheoId(thuTucTiepTheo.getThuTucLienThongId());
			out.setThuTucTruocId(thuTucHienTai.getId());
			out.setSoNgayXy(cauHinhTTHC2CQTiepTheo.getSoNgayXyLy());
			out.setPhi(cauHinhTTHC2CQTiepTheo.getPhi());
			out.setLePhi(cauHinhTTHC2CQTiepTheo.getLePhi());
		}
		
		return out;
	}
	
	/**
	 * This is function getDSCauHinhLienThongTiepTheo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thuTucHienTaiId
	 * @param coQuanHienTaiId
	 * @throws SystemException
	 * @return List<CauHinhLienThong>
	 */
	public static List<CauHinhLienThong> getDSCauHinhLienThongTiepTheo(
		long thuTucHienTaiId, long coQuanHienTaiId
	) throws SystemException 
	{
		List<CauHinhLienThong> out = Collections.emptyList();
		CauHinhLienThong cauHinhTiepTheo = getCauHinhLienThongTiepTheo(thuTucHienTaiId, coQuanHienTaiId);
		
		if (cauHinhTiepTheo != null) {
			out = new ArrayList<CauHinhLienThong>();
			out.add(cauHinhTiepTheo);
			thuTucHienTaiId = cauHinhTiepTheo.getThuTucId();
			coQuanHienTaiId = cauHinhTiepTheo.getCoQuanId();
			cauHinhTiepTheo = getCauHinhLienThongTiepTheo(thuTucHienTaiId, coQuanHienTaiId);
			if (cauHinhTiepTheo != null) {
				out.add(cauHinhTiepTheo);
			}
		}
		
		return out;
	}
	
	/**
	 * This is function getDSHoSoLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param coQuanHienTaiId
	 * @throws SystemException
	 * @return List<CoQuanQuanLy>
	 */
	public static List<CoQuanQuanLy> getDSCoQuanLienThongBuocKeTruoc(long coQuanHienTaiId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			CoQuanQuanLyImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(CmonFields.chaId).eq(coQuanHienTaiId));
		query.add(PropertyFactoryUtil.forName("noiBo").eq(0));
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(Constants.ACTIVE));
		return (List<CoQuanQuanLy>) CoQuanQuanLyLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	/**
	 * This is function getDSHoSoLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSoLienThong
	 * @throws SystemException
	 * @return List<HoSoLienThong>
	 */
	public static List<HoSoLienThong> getDSHoSoLienThong(HoSoTTHCCong hoSo) throws SystemException {
		if (hoSo == null) {
			return Collections.emptyList();
		} else {
			return HoSoLienThongLocalServiceUtil.findByHoSoId(hoSo.getId());
		}
	}
	
	/**
	 * This is function getHoSoLienThongDauTien
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSoLienThong
	 * @throws SystemException
	 * @return HoSoLienThong
	 */
	public static HoSoLienThong getHoSoLienThongDauTien(HoSoLienThong hoSoLienThong) throws SystemException {
		if (hoSoLienThong == null) {
			return null;
		}
		
		if (hoSoLienThong.getThuTuLienThong() == THU_TU_LIEN_THONG_DAU_TIEN) {
			return hoSoLienThong;
		} else {
			return HoSoLienThongLocalServiceUtil
				.fetchByHoSoIdAndThuTuLienThong(hoSoLienThong.getHoSoId(), THU_TU_LIEN_THONG_DAU_TIEN);
		}
	}
	
	/**
	 * This is function getHoSoLienThongDauTien
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return HoSoLienThong
	 */
	public static HoSoLienThong getHoSoLienThongDauTien(HoSoTTHCCong hoSo) throws SystemException {
		if (hoSo == null) {
			return null;
		} else {
			return HoSoLienThongLocalServiceUtil
				.fetchByHoSoIdAndThuTuLienThong(hoSo.getId(), THU_TU_LIEN_THONG_DAU_TIEN);
		}
	}
	
	/**
	 * This is function getTenCoQuanKhoiTaoLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSoLienThong
	 * @throws SystemException
	 * @return String
	 */
	public static final String getTenCoQuanKhoiTaoLienThong(HoSoLienThong hoSoLienThong) throws SystemException {
		String out = StringPool.BLANK;
		
		hoSoLienThong = getHoSoLienThongDauTien(hoSoLienThong);
		if (hoSoLienThong != null) {
			out = hoSoLienThong.getTenCoQuanGui();
		}
		
		return out;
	}
	
	/**
	 * This is function getTenCoQuanKhoiTaoLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return String
	 */
	public static final String getTenCoQuanKhoiTaoLienThong(HoSoTTHCCong hoSo) throws SystemException {
		String out = StringPool.BLANK;
		HoSoLienThong hoSoLienThong = getHoSoLienThongDauTien(hoSo);
		if (hoSoLienThong != null) {
			out = hoSoLienThong.getTenCoQuanGui();
		}
		return out;
	}
	
	/**
	 * This is function getHoSoLienThongDaTraKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @param coQuanTraId
	 * @throws SystemException
	 * @return HoSoLienThong
	 */
	public static HoSoLienThong getHoSoLienThongDaTraKetQua(HoSoTTHCCong hoSo, long coQuanTraId)
		throws SystemException
	{
		HoSoLienThong out = null;
		if (hoSo != null) {
			for (HoSoLienThong item : getDSHoSoLienThong(hoSo)) {
				if ((item.getCoQuanNhanId() == coQuanTraId)
					&& (item.getTrangThaiLienThong() == TTLT_DA_TRA_KET_QUA
						|| item.getTrangThaiLienThong() == TTLT_DA_NHAN_KET_QUA)
				) {
					out = item;
					break;
				}
			}
		}
		
		return out;
	}
	
	/**
	 * This is function getHoSoLienThongCanTraKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return HoSoLienThong
	 */
	public static HoSoLienThong getHoSoLienThongCanTraKetQua(HoSoTTHCCong hoSo) throws SystemException {
		
		HoSoLienThong out = null;
		if ( (hoSo != null) && (hoSo.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG) ) {
			for (HoSoLienThong item : getDSHoSoLienThong(hoSo)) {
				if ( (item.getTrangThaiLienThong() == TTLT_DA_TIEP_NHAN) 
					&& (item.getCoQuanNhanId() == hoSo.getCoQuanTiepNhanId()) 
				) {
					out = item;
					break;
				}
			}
		}
		
		return out;
	}
	
	/**
	 * This is function getHoSoLienThongDaTiepNhan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @param coQuanTiepNhanId
	 * @throws SystemException
	 * @return HoSoLienThong
	 */
	public static HoSoLienThong getHoSoLienThongDaTiepNhan(HoSoTTHCCong hoSo, long coQuanTiepNhanId) throws SystemException {
		
		HoSoLienThong out = null;
		if (hoSo != null) {
			for (HoSoLienThong item : getDSHoSoLienThong(hoSo)) {
				if ((item.getCoQuanNhanId() == coQuanTiepNhanId)
					&& (item.getTrangThaiLienThong() == TTLT_DA_TIEP_NHAN
						|| item.getTrangThaiLienThong() == TTLT_DA_TRA_KET_QUA
					)
				) {
					out = item;
					break;
				}
			}
		}
		
		return out;
	}
	
	/**
	 * This is function laHoSoCanGuiLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSo
	 * @throws SystemException
	 * @return boolean
	 */
	public static boolean laHoSoCanGuiLienThong(HoSoTTHCCong hoSo) throws SystemException {
		
		boolean b = (hoSo != null)
			&& (hoSo.getTrangThaiHoSo() == Constants.TRANGTHAIHOSO.CHO_THUC_HIEN_LIEN_THONG);
		
		if (b) {
			ThuTucHanhChinh thuTucHienTai =
				ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSo.getThuTucHanhChinhId());
			
			Long thuTucLienThongId = thuTucHienTai.getThuTucLienThongId();
				
			b = (thuTucLienThongId != null);
		}
		
		if (b) {
			
			List<HoSoLienThong> list = getDSHoSoLienThong(hoSo);
			int count = list.size();
			
			// Truong hop chua gui lien thong lan nao`
			if (count == 0L) {
				b = true;

			// Truong hop da gui lien thong it' nhat' 1 lan`
			} else {
				HoSoLienThong hoSoLienThong = list.get(count - 1);
				b =

				// Cap 2 da~ tiep' nhan. va` dang can` gui lien thong len cap co quan thu' 3
					(hoSoLienThong.getTrangThaiLienThong() == TTLT_DA_TIEP_NHAN)

				// Da bi tu choi thi cho gui lai
					|| (hoSoLienThong.getTrangThaiLienThong() == TTLT_DA_TU_CHOI);
			}
		}
		
		return b;
	}
	
	/**
	 * This is function getTenTrangThaiLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param trangThai
	 * @return String
	 */
	public static String getTenTrangThaiLienThong(HttpServletRequest request, int trangThai) {
		return BusinessMessagerUtil.get(request, PREFIX_TTLT_MESSAGE + trangThai);
	}
	
	/**
	 * This is function getTenTrangThaiLienThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param trangThai
	 * @return String
	 */
	public static String getTenTrangThaiLienThong(PortletRequest request, int trangThai) {
		return BusinessMessagerUtil.get(request, PREFIX_TTLT_MESSAGE + trangThai);
	}
	
	/**
	 * This is function getURLDanhSachHoSoNoiGui
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @throws Exception
	 * @return String
	 */
	public static String getURLDanhSachHoSoNoiGui(HttpServletRequest request)
		throws Exception
	{
		
		return LiferayURL.getPageURLByConfig(
			request,
			PORTLET_NAME,
			HSLTFields.loaiDanhSach,
			LDS_NOI_GUI,
			LiferayURL.createRenderURL(request, Constants.DEFAULT_PORTLET_NAME, null)
		).toString();
		
	}
	
	/**
	 * This is function getURLDanhSachHoSoNoiGui
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @throws Exception
	 * @return String
	 */
	public static String getURLDanhSachHoSoNoiGui(PortletRequest request)
		throws Exception
	{

		return LiferayURL.getPageURLByConfig(
			request,
			PORTLET_NAME,
			HSLTFields.loaiDanhSach,
			LDS_NOI_GUI,
			LiferayURL.createRenderURL(request, Constants.DEFAULT_PORTLET_NAME, null)
		).toString();
	}
	
	/**
	 * This is function getURLDanhSachHoSoNoiNhan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @throws Exception
	 * @return String
	 */
	public static String getURLDanhSachHoSoNoiNhan(PortletRequest request)
		throws Exception
	{
		
		return LiferayURL.getPageURLByConfig(
			request,
			PORTLET_NAME,
			HSLTFields.loaiDanhSach,
			LDS_NOI_NHAN,
			LiferayURL.createRenderURL(request, Constants.DEFAULT_PORTLET_NAME, null)
		).toString();
		
	}
	
	/**
	 * This is function getDSThuTucLienThongNoiGui2CanBo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param canBo
	 * @throws Exception
	 * @return List<ThongTinThuTuc>
	 */
	public static List<ThongTinThuTuc> getDSThuTucLienThongNoiGui2CanBo(CongChuc canBo) throws Exception {
		return ThuTucHanhChinhLocalServiceUtil.getDSThongTinThuTucLienThongNoiGui2CanBo(canBo);
	}
	
	/**
	 * This is function getDSThuTucLienThongNoiNhan2CanBo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param canBo
	 * @throws Exception
	 * @return List<ThongTinThuTuc>
	 */
	public static List<ThongTinThuTuc> getDSThuTucLienThongNoiNhan2CanBo(CongChuc canBo) throws Exception {
		return ThuTucHanhChinhLocalServiceUtil.getDSThongTinThuTucLienThongNoiNhan2CanBo(canBo);
	}
	
	protected static Log _log = LogFactoryUtil.getLog(HSLTBusinessUtil.class);
}
