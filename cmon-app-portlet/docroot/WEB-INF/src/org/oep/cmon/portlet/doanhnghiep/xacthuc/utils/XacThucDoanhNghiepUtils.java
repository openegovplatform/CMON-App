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

package org.oep.cmon.portlet.doanhnghiep.xacthuc.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.dao.cd.model.impl.CongDanImpl;
import org.oep.cmon.dao.dn.model.impl.DoanhNghiep2NganhNgheImpl;
import org.oep.cmon.dao.dn.model.impl.DoanhNghiepImpl;
import org.oep.cmon.dao.dn.model.impl.NganhNgheKinhDoanhImpl;
import org.oep.cmon.portlet.taocongdan.util.FormatUtil;
import org.oep.cmon.util.CmonFields;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dn.model.DoanhNghiep;
import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh;
import org.oep.cmon.dao.dn.model.YeuCauDangKyDN;
import org.oep.cmon.dao.dn.service.YeuCauDangKyDNLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class XacThucDoanhNghiepUtils {
	private static Log log = LogFactoryUtil
			.getLog(XacThucDoanhNghiepUtils.class);

	@SuppressWarnings("unchecked")
	public static List<DoanhNghiep> searchDoanhNghiep(String searchInputText,
			long idLoaiDoiTuong, int daXoa, int start, int end)
			throws Exception {
		List<DoanhNghiep> listDoanhNghiep = new ArrayList<DoanhNghiep>();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				DoanhNghiepImpl.class, PortalClassLoaderUtil.getClassLoader());
		if (!searchInputText.equals("")) {
			Criterion creterion = RestrictionsFactoryUtil.ilike("ten",
					StringPool.PERCENT + searchInputText + StringPool.PERCENT);
			creterion = RestrictionsFactoryUtil.or(creterion,
					RestrictionsFactoryUtil.ilike("soGCNDKKD",
							StringPool.PERCENT + searchInputText
									+ StringPool.PERCENT));
			creterion = RestrictionsFactoryUtil.or(creterion,
					RestrictionsFactoryUtil.ilike("maSoThue",
							StringPool.PERCENT + searchInputText
									+ StringPool.PERCENT));
			query.add(creterion);
		}
		query.add(PropertyFactoryUtil.forName("taiKhoanNguoiDungId").isNull());
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(daXoa));
		query.add(PropertyFactoryUtil.forName("loaiDoiTuongId").eq(
				idLoaiDoiTuong));
		query.addOrder(OrderFactoryUtil.asc("ten"));
		listDoanhNghiep = CoQuanQuanLyLocalServiceUtil.dynamicQuery(query,
				start, end);
		return listDoanhNghiep;
	}

	@SuppressWarnings("unchecked")
	public static int countDoanhNghiep(String searchInputText,
			long idLoaiDoiTuong, int daXoa) throws Exception {
		List<DoanhNghiep> listDoanhNghiep = new ArrayList<DoanhNghiep>();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				DoanhNghiepImpl.class, PortalClassLoaderUtil.getClassLoader());
		if (!searchInputText.equals("")) {
			Criterion creterion = RestrictionsFactoryUtil.ilike("ten",
					StringPool.PERCENT + searchInputText + StringPool.PERCENT);
			creterion = RestrictionsFactoryUtil.or(
					creterion,
					RestrictionsFactoryUtil.ilike("soGCNDKKD", StringPool.PERCENT
							+ searchInputText + StringPool.PERCENT));
			creterion = RestrictionsFactoryUtil.or(creterion,
					RestrictionsFactoryUtil.ilike("maSoThue",
							StringPool.PERCENT + searchInputText
									+ StringPool.PERCENT));
			query.add(creterion);
		}
		query.add(PropertyFactoryUtil.forName("taiKhoanNguoiDungId").isNull());
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(daXoa));
		query.add(PropertyFactoryUtil.forName("loaiDoiTuongId").eq(
				idLoaiDoiTuong));
		listDoanhNghiep = CoQuanQuanLyLocalServiceUtil.dynamicQuery(query,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return listDoanhNghiep.size();
	}

	@SuppressWarnings("unchecked")
	public static List<NganhNgheKinhDoanh> getNganhNgheByIdDoanhNghiep(
			long doanhNghiepId) throws Exception {
		List<NganhNgheKinhDoanh> listNganhNghe = new ArrayList<NganhNgheKinhDoanh>();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				NganhNgheKinhDoanhImpl.class,
				PortalClassLoaderUtil.getClassLoader());
		DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(
				DoanhNghiep2NganhNgheImpl.class,
				PortalClassLoaderUtil.getClassLoader()).setProjection(
				ProjectionFactoryUtil.property("nganhNgheId"));
		subQuery.add(PropertyFactoryUtil.forName("doanhNghiepId").eq(
				doanhNghiepId));
		query.add(PropertyFactoryUtil.forName("id").in(subQuery));
		listNganhNghe = CoQuanQuanLyLocalServiceUtil.dynamicQuery(query,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return listNganhNghe;
	}

	@SuppressWarnings("unchecked")
	public static long countListCongDan(String ten) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongDan.class);
		Criterion criterion = null;
		ten = ten.toUpperCase();

		criterion = RestrictionsFactoryUtil.ilike("ten", StringPool.PERCENT
				+ ten + StringPool.PERCENT);
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("ho", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("dem", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("tenDayDu", StringPool.PERCENT
						+ ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("email", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("ma", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("soCmnd", StringPool.PERCENT
						+ ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("tinhtrang",
						Constants.TINHTRANG_SONG));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));

		query = query.add(criterion);
		query.setProjection(ProjectionFactoryUtil.rowCount());

		long count = 0;

		try {
			Iterator<Long> resultsItr = CongDanLocalServiceUtil.dynamicQuery(
					query).iterator();

			if (resultsItr.hasNext()) {
				count = ((Long) resultsItr.next()).longValue();
			}
		} catch (SystemException se) {
			// _log.error(se.getMessage(), se);
		}

		return count;
	}

	@SuppressWarnings("unchecked")
	public static List<CongDan> getListCongDan(String ten, int start, int end) {
		List<CongDan> results = null;
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongDan.class);
		query.addOrder(OrderFactoryUtil.asc("ten"));
		query.setLimit(start, end);
		Criterion criterion = null;

		ten = ten.toUpperCase();

		criterion = RestrictionsFactoryUtil.ilike("ten", StringPool.PERCENT
				+ ten + StringPool.PERCENT);
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("ho", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("dem", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("tenDayDu", StringPool.PERCENT
						+ ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("email", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("ma", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("soCmnd", StringPool.PERCENT
						+ ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("tinhtrang",
						Constants.TINHTRANG_SONG));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));

		// Define search criteria
		query = query.add(criterion);

		try {
			results = CongDanLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
		}

		if (results == null) {
			results = new ArrayList<CongDan>();
		}
		return results;

	}

	@SuppressWarnings("unchecked")
	public static List<YeuCauDangKyDN> getListYeuCauDangKy(
			String maOrTenOrEmail, long loaiDoiTuongId, int trangThai,
			int start, int end) {
		List<YeuCauDangKyDN> results = new ArrayList<YeuCauDangKyDN>();
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(YeuCauDangKyDN.class);
		query.addOrder(OrderFactoryUtil.asc("id"));
		query.setLimit(start, end);
		if (!maOrTenOrEmail.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("ten",
					StringPool.PERCENT + maOrTenOrEmail + StringPool.PERCENT);
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.ilike("maGiayPhep",
							StringPool.PERCENT + maOrTenOrEmail
									+ StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.ilike("maSoThue",
							StringPool.PERCENT + maOrTenOrEmail
									+ StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.or(
					criterion,
					RestrictionsFactoryUtil.ilike("email", StringPool.PERCENT
							+ maOrTenOrEmail + StringPool.PERCENT));
			query = query.add(criterion);
		}
		if (loaiDoiTuongId != 0) {
			Criterion criterion1 = RestrictionsFactoryUtil.eq("loaiDoiTuongId",
					loaiDoiTuongId);
			query = query.add(criterion1);
		}
		if (trangThai != 99) {
			Criterion criterion2 = RestrictionsFactoryUtil.eq("trangThai",
					trangThai);
			query = query.add(criterion2);
		}

		try {
			results = YeuCauDangKyDNLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
		}

		if (results == null) {
			results = new ArrayList<YeuCauDangKyDN>();
		}
		return results;

	}

	@SuppressWarnings("unchecked")
	public static int countListYeuCauDangKy(String maOrTenOrEmail,
			long loaiDoiTuongId, int trangThai) {
		List<YeuCauDangKyDN> results = new ArrayList<YeuCauDangKyDN>();
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(YeuCauDangKyDN.class);
		if (!maOrTenOrEmail.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("ten",
					StringPool.PERCENT + maOrTenOrEmail + StringPool.PERCENT);
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.ilike("maGiayPhep",
							StringPool.PERCENT + maOrTenOrEmail
									+ StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.ilike("maSoThue",
							StringPool.PERCENT + maOrTenOrEmail
									+ StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.or(
					criterion,
					RestrictionsFactoryUtil.ilike("email", StringPool.PERCENT
							+ maOrTenOrEmail + StringPool.PERCENT));
			query = query.add(criterion);
		}
		if (loaiDoiTuongId != 0) {
			Criterion criterion1 = RestrictionsFactoryUtil.eq("loaiDoiTuongId",
					loaiDoiTuongId);
			query = query.add(criterion1);
		}
		if (loaiDoiTuongId != 99) {
			Criterion criterion2 = RestrictionsFactoryUtil.eq("trangThai",
					trangThai);
			query = query.add(criterion2);
		}

		try {
			results = YeuCauDangKyDNLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
		}

		if (results == null) {
			results = new ArrayList<YeuCauDangKyDN>();
		}
		return results.size();

	}

	public static Map<String, String> getMapHctFromYcdk(long idYeuCau)
			throws SystemException, PortalException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Map<String, String> HCT_OBJECT = new HashMap<String, String>();
		YeuCauDangKyDN yeuCau = YeuCauDangKyDNLocalServiceUtil
				.fetchYeuCauDangKyDN(idYeuCau);
		HCT_OBJECT.put("taiKhoanDangNhap", yeuCau.getEmail());
		
		HCT_OBJECT.put("idYeuCau", String.valueOf(yeuCau.getId()));
		HCT_OBJECT.put("trangThaiId", String.valueOf(yeuCau.getTrangThai()));
		
		HCT_OBJECT.put(
				"nddTen",
				yeuCau.getHoNguoiDaiDien() + " "
						+ yeuCau.getTenDemNguoiDaiDien() + " "
						+ yeuCau.getTenNguoiDaiDien());
		HCT_OBJECT.put("nddId","");		
		HCT_OBJECT.put("nddNgaySinh","");
		HCT_OBJECT.put("nddGioiTinh","0");
		HCT_OBJECT.put("nddQuocTich","0");
		HCT_OBJECT.put("nddDanToc","0");
		HCT_OBJECT.put("nddSoCMND", yeuCau.getSoCmnd());
		HCT_OBJECT.put("nddNgayCapCMND", df.format(yeuCau.getNgayCapCmnd()));
		HCT_OBJECT.put("nddNoiCapCMND",
				String.valueOf(yeuCau.getNoiCapCmndId()));
		//ndd thuong tru
		HCT_OBJECT.put("nddTtTinhId","0");
		HCT_OBJECT.put("nddTtHuyenId","0");
		HCT_OBJECT.put("nddTtXaId","0");
		HCT_OBJECT.put("nddTtMoTaDiaChi","");
		//ndd cho o hien tai
		HCT_OBJECT.put("nddCohtTinhId","0");
		HCT_OBJECT.put("nddCohtHuyenId","0");
		HCT_OBJECT.put("nddCohtXaId","0");
		HCT_OBJECT.put("nddCohtMoTaChoO","");
		HCT_OBJECT.put("nddEmail", yeuCau.getEmail());
		HCT_OBJECT.put("nddDienThoai","");
		HCT_OBJECT.put("nddFax","");
		HCT_OBJECT.put("nddWebsite","");
		
		HCT_OBJECT.put("ten", yeuCau.getTen());
		HCT_OBJECT.put("id","");
		HCT_OBJECT.put("maSoThue", yeuCau.getMaSoThue());
		HCT_OBJECT.put("ngayDangKy",df.format(yeuCau.getNgayCap()));
		HCT_OBJECT.put("maGiayPhep", yeuCau.getMaGiayPhep());
		HCT_OBJECT.put("moTaNgheNghiep", yeuCau.getMoTa());
		HCT_OBJECT.put("chiTietDiaDiem", yeuCau.getTruSo());
		HCT_OBJECT.put("tinhId", String.valueOf(yeuCau.getTruSoTinhId()));
		HCT_OBJECT.put("huyenId", String.valueOf(yeuCau.getTruSoHuyenId()));
		HCT_OBJECT.put("xaId", String.valueOf(yeuCau.getTruSoXaId()));
		HCT_OBJECT.put("vonKinhDoanh","");
		HCT_OBJECT.put("dienThoai","");
		HCT_OBJECT.put("fax","");
		HCT_OBJECT.put("email","");
		HCT_OBJECT.put("website","");
		
		return HCT_OBJECT;
	}
	public static Map<String, String> getMapHctFromRequest(ActionRequest request)
			throws SystemException, PortalException {
		Map<String, String> HCT_OBJECT = new HashMap<String, String>();
		HCT_OBJECT.put("taiKhoanDangNhap", ParamUtil.getString(request,"taiKhoanDangNhap"));
		// yeu cau dang ky
		HCT_OBJECT.put("idYeuCau", ParamUtil.getString(request,"idYeuCau"));
		HCT_OBJECT.put("trangThaiId",ParamUtil.getString(request,"trangThaiId"));
		// nguoi dai dien
		HCT_OBJECT.put("nddTen",ParamUtil.getString(request,"nddTen"));
		HCT_OBJECT.put("nddId",ParamUtil.getString(request,"nddId"));		
		HCT_OBJECT.put("nddNgaySinh",ParamUtil.getString(request,"nddNgaySinh"));
		HCT_OBJECT.put("nddGioiTinh",ParamUtil.getString(request,"nddGioiTinh"));
		HCT_OBJECT.put("nddQuocTich",ParamUtil.getString(request,"nddQuocTich"));
		HCT_OBJECT.put("nddDanToc",ParamUtil.getString(request,"nddDanToc"));
		HCT_OBJECT.put("nddSoCMND", ParamUtil.getString(request,"nddSoCMND"));
		HCT_OBJECT.put("nddNgayCapCMND", ParamUtil.getString(request,"nddNgayCapCMND"));
		HCT_OBJECT.put("nddNoiCapCMND",ParamUtil.getString(request,"nddNoiCapCMND"));
		//ndd thuong tru
		HCT_OBJECT.put("nddTtTinhId",ParamUtil.getString(request,"nddTtTinhId"));
		HCT_OBJECT.put("nddTtHuyenId",ParamUtil.getString(request,"nddTtHuyenId"));
		HCT_OBJECT.put("nddTtXaId",ParamUtil.getString(request,"nddTtXaId"));
		HCT_OBJECT.put("nddTtMoTaDiaChi",ParamUtil.getString(request,"nddTtMoTaDiaChi"));
		//ndd cho o hien tai
		HCT_OBJECT.put("nddCohtTinhId",ParamUtil.getString(request,"nddCohtTinhId"));
		HCT_OBJECT.put("nddCohtHuyenId",ParamUtil.getString(request,"nddCohtHuyenId"));
		HCT_OBJECT.put("nddCohtXaId",ParamUtil.getString(request,"nddCohtXaId"));
		HCT_OBJECT.put("nddCohtMoTaChoO",ParamUtil.getString(request,"nddCohtMoTaChoO"));
		
		HCT_OBJECT.put("nddDienThoai",ParamUtil.getString(request,"nddDienThoai"));
		HCT_OBJECT.put("nddFax",ParamUtil.getString(request,"nddFax"));
		HCT_OBJECT.put("nddWebsite",ParamUtil.getString(request,"nddWebsite"));
		HCT_OBJECT.put("nddEmail",ParamUtil.getString(request,"nddEmail"));
		// ho ca the
		HCT_OBJECT.put("ten",ParamUtil.getString(request,"ten"));
		HCT_OBJECT.put("id",ParamUtil.getString(request,"id"));
		HCT_OBJECT.put("maGiayPhep",ParamUtil.getString(request,"maGiayPhep"));
		HCT_OBJECT.put("tinhId",ParamUtil.getString(request,"tinhId"));
		HCT_OBJECT.put("huyenId",ParamUtil.getString(request,"huyenId"));
		HCT_OBJECT.put("xaId",ParamUtil.getString(request,"xaId"));
		HCT_OBJECT.put("chiTietDiaDiem",ParamUtil.getString(request,"chiTietDiaDiem"));
		HCT_OBJECT.put("maSoThue",ParamUtil.getString(request,"maSoThue"));
		HCT_OBJECT.put("ngayDangKy",ParamUtil.getString(request,"ngayDangKy"));


		HCT_OBJECT.put("vonKinhDoanh",ParamUtil.getString(request,"vonKinhDoanh"));
		HCT_OBJECT.put("dienThoai",ParamUtil.getString(request,"dienThoai"));
		HCT_OBJECT.put("fax",ParamUtil.getString(request,"fax"));
		HCT_OBJECT.put("email",ParamUtil.getString(request,"email"));
		HCT_OBJECT.put("website",ParamUtil.getString(request,"website"));
		HCT_OBJECT.put("moTaNgheNghiep",ParamUtil.getString(request,"moTaNgheNghiep"));
		
		return HCT_OBJECT;
	}

	@SuppressWarnings("unchecked")
	public static List<DonViHanhChinh> findDonViHanhChinhByChaId(long chaId) {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(DonViHanhChinh.class);

		// This is a test line for display all request if there's no search
		// criteria
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
		Criterion criteriaChaId = RestrictionsFactoryUtil.eq("chaId", chaId);

		// Define search criteria
		query = query.add(criteriaChaId).add(criteriaTrangThai);

		try {
			return DonViHanhChinhLocalServiceUtil.dynamicQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<DonViHanhChinh>();
	}

	public static boolean validThanhVienSangLap(ActionRequest request) {

		String hoTenNDD = request.getParameter("tvslTen");

		String ngaySinhNDD = request.getParameter("tvslNgaySinh");

		String soCMNDNDD = request.getParameter("tvslSoCMND");

		String ngayCapCMNDNDD = request.getParameter("tvslNgayCapCMND");

		String noiCapCMNDNDD = request.getParameter("tvslNoiCapCMND");

		// Dia chi thuong tru
		String tinhTTNDD = request.getParameter("tvslTtTinhId");

		String huyenTTNDD = request.getParameter("tvslTtHuyenId");

		String xaTTNDD = request.getParameter("tvslTtXaId");

		String moTaTTNDD = request.getParameter("tvslTtMoTaDiaChi");

		// Dia chi hien tai

		String tinhHTNDD = request.getParameter("tvslCohtTinhId");

		String huyenHTNDD = request.getParameter("tvslCohtHuyenId");

		String xaHTNDD = request.getParameter("tvslCohtXaId");

		String moTaHTNDD = request.getParameter("tvslCohtMoTaChoO");

		String tvslGiaTri = request.getParameter("tvslGiaTri");
		String tvslTyLe = request.getParameter("tvslTyLe");
		String tvslLoaiTaiSan = request.getParameter("tvslLoaiTaiSan");
		String tvslNgayGopVon = request.getParameter("tvslNgayGopVon");
		String tvslGhiChu = request.getParameter("tvslGhiChu");

		if (Validator.isNull(hoTenNDD) || hoTenNDD.trim().length() == 0) {
			SessionErrors.add(request, "emptyhoTenNDD");
		} else if (hoTenNDD.trim().length() > 100) {// toi da 100 ky tu
			SessionErrors.add(request, "errorMaxLengTenNDD");
		}

		if (Validator.isNull(ngaySinhNDD)) {
			SessionErrors.add(request, "emptyngaySinhNDD");
		}

		if (Validator.isNull(soCMNDNDD) || soCMNDNDD.trim().length() > 0) {
			if (Validator.isNumber(soCMNDNDD)) {
				long cmnd = Long.parseLong(soCMNDNDD.trim());
				if (cmnd <= 0) {
					SessionErrors.add(request, "errorsoCMNDNDD");
				} else if (soCMNDNDD.trim().length() != 9
						&& soCMNDNDD.trim().length() != 12) {
					SessionErrors.add(request, "errorsoCMNDNDD9or12");
				}
			} else {
				SessionErrors.add(request, "notNumberCMNDNDD");
			}
		} else {
			SessionErrors.add(request, "emptysoCMNDNDD");
		}

		if (Validator.isNull(ngayCapCMNDNDD)) {
			SessionErrors.add(request, "emptyngayCapCMNDNDD");
		}

		int noiCapCMNDNDDId = Integer.parseInt(noiCapCMNDNDD.trim());
		if (noiCapCMNDNDDId==0) {
			SessionErrors.add(request, "emptynoiCapCMNDNDD");
		}

		int tinhTTIdNDD = Integer.parseInt(tinhTTNDD.trim());
		if (tinhTTIdNDD == 0) {
			SessionErrors.add(request, "emptytinhTTIdNDD");
		}

		int huyenTTIdNDD = Integer.parseInt(huyenTTNDD.trim());
		if (huyenTTIdNDD == 0) {
			SessionErrors.add(request, "emptyhuyenTTIdNDD");
		}

		int xaTTIdNDD = Integer.parseInt(xaTTNDD.trim());
		if (xaTTIdNDD == 0) {
			SessionErrors.add(request, "emptyxaTTIdNDD");
		}

		if (Validator.isNull(moTaTTNDD) || moTaTTNDD.trim().length() == 0) {
			SessionErrors.add(request, "emptymoTaTTNDD");
		} else if (moTaTTNDD.trim().length() > 100) {// toi da 100 ky tu
			SessionErrors.add(request, "errorMaxLengmoTaTTNDD");
		}

		int tinhHTIdNDD = Integer.parseInt(tinhHTNDD.trim());
		if (tinhHTIdNDD == 0) {
			SessionErrors.add(request, "emptytinhHTIdNDD");
		}

		int huyenHTIdNDD = Integer.parseInt(huyenHTNDD.trim());
		if (huyenHTIdNDD == 0) {
			SessionErrors.add(request, "emptyhuyenHTIdNDD");
		}

		int xaHTIdNDD = Integer.parseInt(xaHTNDD.trim());
		if (xaHTIdNDD == 0) {
			SessionErrors.add(request, "emptyxaHTIdNDD");
		}

		if (Validator.isNull(moTaHTNDD) || moTaHTNDD.trim().length() == 0) {
			SessionErrors.add(request, "emptymoTaHTNDD");
		} else if (moTaHTNDD.trim().length() > 100) {// toi da 100 ky tu
			SessionErrors.add(request, "errorMaxLengmoTaHTNDD");
		}

		if (Validator.isNull(tvslGiaTri) || tvslGiaTri.trim().length() == 0) {
			SessionErrors.add(request, "emptyGiaTri");
		} else if (!Validator.isNumber(tvslGiaTri)) {
			SessionErrors.add(request, "notNumberGiaTri");
		}

		if (Validator.isNull(tvslTyLe) || tvslTyLe.trim().length() == 0) {
			SessionErrors.add(request, "emptyTyLe");
		} else {
			if (tvslTyLe.trim().length() > 5) {// toi da 15 ky tu
				SessionErrors.add(request, "errorMaxLengTyLe");
			}
			if (!Validator.isNumber(tvslTyLe)) {
				SessionErrors.add(request, "notNumberTyLe");
			}
		}

		if (Validator.isNull(tvslLoaiTaiSan)
				|| tvslLoaiTaiSan.trim().length() == 0) {
			SessionErrors.add(request, "emptyLoaiTaiSan");
		} else if (tvslLoaiTaiSan.trim().length() > 200) {// toi da 50 ky tu
			SessionErrors.add(request, "errorMaxLengLoaiTaiSan");
		}

		if (Validator.isNull(tvslNgayGopVon)
				|| tvslNgayGopVon.trim().length() == 0) {// toi da 100 ky tu
			SessionErrors.add(request, "emptyNgayGopVon");
		}

		if (Validator.isNotNull(tvslGhiChu)) {
			if (tvslGhiChu.trim().length() > 255) {
				SessionErrors.add(request, "errorMaxLengLoaiTaiSan");
			}
		}

		if (SessionErrors.isEmpty(request)) {
			return true;
		}

		return false;
	}

	public static boolean validHoCaThe(ActionRequest request ) {
		String taiKhoanDangNhap = request.getParameter("taiKhoanDangNhap");
		//Thông tin nguoi dai dien
		String hoTenNDD = request.getParameter("nddTen");
		String ngaySinhNDD = request.getParameter("nddNgaySinh");
		String gioiTinhNDD = request.getParameter("nddGioiTinh");
//		String quocTichNDD = request.getParameter("nddQuocTich");
//		String danTocNDD = request.getParameter("nddDanToc");
		String soCMNDNDD = request.getParameter("nddSoCMND");
		String ngayCapCMNDNDD = request.getParameter("nddNgayCapCMND");
		String noiCapCMNDNDD = request.getParameter("nddNoiCapCMND");
		// Dia chi thuong tru
		String tinhTTNDD = request.getParameter("nddTtTinhId");
		String huyenTTNDD = request.getParameter("nddTtHuyenId");
		String xaTTNDD = request.getParameter("nddTtXaId");
		String moTaTTNDD = request.getParameter("nddTtMoTaDiaChi");
		// Dia chi hien tai
		String tinhHTNDD = request.getParameter("nddCohtTinhId");
		String huyenHTNDD = request.getParameter("nddCohtHuyenId");
		String xaHTNDD = request.getParameter("nddCohtXaId");
		String moTaHTNDD = request.getParameter("nddCohtMoTaChoO");
		//Ko validator
		String dienThoaiNDD = request.getParameter("nddDienThoai");
		String faxNDD = request.getParameter("nddFax");
		String emailNDD = request.getParameter("nddEmail");
		String websiteNDD = request.getParameter("nddWebsite");
		//End
				
		//Thông tin kinh doanh hộ cá thể
		String tenHoCaThe= request.getParameter("ten");			
		String maGiayPhep= request.getParameter("maGiayPhep");
		String tinhId = request.getParameter("tinhId");
		String huyenId= request.getParameter("huyenId");			
		String xaId= request.getParameter("xaId");
		String chiTietDiaDiem= request.getParameter("chiTietDiaDiem");
		String maSoThue= request.getParameter("maSoThue");
		String ngayDangKy= request.getParameter("ngayDangKy");
		String vonKinhDoanh= request.getParameter("vonKinhDoanh");
		String dienThoai= request.getParameter("dienThoai");
		//Ko validator
		String fax= request.getParameter("fax");
		String email= request.getParameter("email");
		String website= request.getParameter("website");
		String moTaNgheNghiep= request.getParameter("moTaNgheNghiep");
		String[] nganhNgheDuocChon=ParamUtil.getParameterValues(request,"nganhNgheDuocChon"); 
		//end
		
		if(Validator.isNull(taiKhoanDangNhap)){
			SessionErrors.add(request, "errorEmptyMailDangNhap");
		}
		if(taiKhoanDangNhap.trim().length() > 50){ //toi da 50 ky tu
			SessionErrors.add(request, "errorMaxLengMailDangNhap");
		}		
		if (!Validator.isEmailAddress(taiKhoanDangNhap)) {				
			SessionErrors.add(request, "errorMailKhongDungDinhDang");
		}
		if ( emailExists( taiKhoanDangNhap)) {
			SessionErrors.add(request, "errorEmailDaTonTai");
		}
		
		if (Validator.isNull(hoTenNDD) || hoTenNDD.trim().length() == 0) {
			SessionErrors.add(request, "emptyhoTenNDD");
		} else if (hoTenNDD.trim().length() > 100) {// toi da 100 ky tu
			SessionErrors.add(request, "errorMaxLengTenNDD");
		}
		
		if (Validator.isNull(ngaySinhNDD)) {
			SessionErrors.add(request, "emptyngaySinhNDD");
		}
		
		int gioiTinhIdNDD = Integer.parseInt(gioiTinhNDD.trim());
		if (gioiTinhIdNDD ==0) {
			SessionErrors.add(request, "emptygioiTinhNDD");
		}
		
//		int quocTichIdNDD = Integer.parseInt(quocTichNDD.trim());
//		if (quocTichIdNDD ==0) {
//			SessionErrors.add(request, "emptyquocTichNDD");
//		}
//		
//		int danTocIdNDD = Integer.parseInt(danTocNDD.trim());
//		if (danTocIdNDD ==0) {
//			SessionErrors.add(request, "emptydanTocNDD");
//		}
			
		if (Validator.isNull(soCMNDNDD) || soCMNDNDD.trim().length() > 0) {
			if (Validator.isNumber(soCMNDNDD)) {
				long cmnd = Long.parseLong(soCMNDNDD.trim());
				if (cmnd <= 0) {
					SessionErrors.add(request, "errorsoCMNDNDD");
				} else if (soCMNDNDD.trim().length() != 9
						&& soCMNDNDD.trim().length() != 12) {
					SessionErrors.add(request, "errorsoCMNDNDD9or12");
				}
			} else {
				SessionErrors.add(request, "notNumberCMNDNDD");
			}
		} else {
			SessionErrors.add(request, "emptysoCMNDNDD");
		}

		if (Validator.isNull(ngayCapCMNDNDD)) {
			SessionErrors.add(request, "emptyngayCapCMNDNDD");
		}

		int noiCapCMNDNDDId = Integer.parseInt(noiCapCMNDNDD.trim());
		if (noiCapCMNDNDDId==0) {
			SessionErrors.add(request, "emptynoiCapCMNDNDD");
		}

		int tinhTTIdNDD = Integer.parseInt(tinhTTNDD.trim());
		if (tinhTTIdNDD == 0) {
			SessionErrors.add(request, "emptytinhTTIdNDD");
		}

		int huyenTTIdNDD = Integer.parseInt(huyenTTNDD.trim());
		if (huyenTTIdNDD == 0) {
			SessionErrors.add(request, "emptyhuyenTTIdNDD");
		}

		int xaTTIdNDD = Integer.parseInt(xaTTNDD.trim());
		if (xaTTIdNDD == 0) {
			SessionErrors.add(request, "emptyxaTTIdNDD");
		}

		if (Validator.isNull(moTaTTNDD) || moTaTTNDD.trim().length() == 0) {
			SessionErrors.add(request, "emptymoTaTTNDD");
		} else if (moTaTTNDD.trim().length() > 100) {// toi da 100 ky tu
			SessionErrors.add(request, "errorMaxLengmoTaTTNDD");
		}

		int tinhHTIdNDD = Integer.parseInt(tinhHTNDD.trim());
		if (tinhHTIdNDD == 0) {
			SessionErrors.add(request, "emptytinhHTIdNDD");
		}

		int huyenHTIdNDD = Integer.parseInt(huyenHTNDD.trim());
		if (huyenHTIdNDD == 0) {
			SessionErrors.add(request, "emptyhuyenHTIdNDD");
		}

		int xaHTIdNDD = Integer.parseInt(xaHTNDD.trim());
		if (xaHTIdNDD == 0) {
			SessionErrors.add(request, "emptyxaHTIdNDD");
		}

		if (Validator.isNull(moTaHTNDD) || moTaHTNDD.trim().length() == 0) {
			SessionErrors.add(request, "emptymoTaHTNDD");
		} else if (moTaHTNDD.trim().length() > 100) {// toi da 100 ky tu
			SessionErrors.add(request, "errorMaxLengmoTaHTNDD");
		}
		if(dienThoaiNDD.trim().length() >15){//toi da 15 ky tu
			SessionErrors.add(request, "errorMaxLengdienThoaiNDD");
		}
		
		if(faxNDD.trim().length() >15){//toi da 15 ky tu
			SessionErrors.add(request, "errorMaxLengfaxNDD");
		}
		
		if(emailNDD.trim().length() >50){//toi da 50 ky tu
			SessionErrors.add(request, "errorMaxLengemailNDD");
		}
		
		if(websiteNDD.trim().length() >100){//toi da 100 ky tu
			SessionErrors.add(request, "errorMaxLengwebsiteNDD");
		}
		
		if (Validator.isNull(tenHoCaThe) || tenHoCaThe.trim().length() ==0) {
			SessionErrors.add(request, "emptytenHoCaThe");
		}else if(tenHoCaThe.trim().length() >200){//toi da 200 ky tu
			SessionErrors.add(request, "errorMaxLengtenHoCaThe");
		}
		
		
		if (Validator.isNull(maGiayPhep) || maGiayPhep.trim().length() ==0) {
			SessionErrors.add(request, "emptymaGiayPhep");
		}else if(maGiayPhep.trim().length() >20){//toi da 20 ky tu
			SessionErrors.add(request, "errorMaxLengmaGiayPhep");
		}
		
		int tinhIdHCT = Integer.parseInt(tinhId.trim());
		if (tinhIdHCT ==0) {
			SessionErrors.add(request, "emptytinhId");
		}
		
		int huyenHCT = Integer.parseInt(huyenId.trim());
		if (huyenHCT ==0) {
			SessionErrors.add(request, "emptyhuyenId");
		}
		
		int xaHCT = Integer.parseInt(xaId.trim());
		if (xaHCT ==0) {
			SessionErrors.add(request, "emptyxaId");
		}
		
		if (Validator.isNull(chiTietDiaDiem) || chiTietDiaDiem.trim().length() ==0) {
			SessionErrors.add(request, "emptychiTietDiaDiem");
		}else if(chiTietDiaDiem.trim().length() >200){//toi da 200 ky tu
			SessionErrors.add(request, "errorMaxLengchiTietDiaDiem");
		}
				
		if (Validator.isNull(maSoThue) || maSoThue.trim().length() ==0) {
			SessionErrors.add(request, "emptymaSoThue");
		}else if(maSoThue.trim().length() >20){//toi da 20 ky tu
			SessionErrors.add(request, "errorMaxLengmaSoThue");
		}
				
		if (Validator.isNull(ngayDangKy)) {
			SessionErrors.add(request, "emptyngayDangKy");
		}
						
		if (Validator.isNotNull(vonKinhDoanh)) {			
			String temp = vonKinhDoanh.replaceAll(",", "");
			double vonThucHien = Double.parseDouble(temp);
			if(vonThucHien ==0f){
				SessionErrors.add(request, "emptyVon");
			}
			else if(!ValidateVon(vonKinhDoanh)){
				SessionErrors.add(request, "errorVon");
			}				
			
		}else{
			SessionErrors.add(request, "emptyVon");
		}
		
		if (Validator.isNull(dienThoai) || dienThoai.trim().length() ==0) {
			SessionErrors.add(request, "emptydienThoai");
		}else if(dienThoai.trim().length() >15){//toi da 15 ky tu
			SessionErrors.add(request, "errorMaxLengdienThoai");
		}
				
		if(fax.trim().length() >15){//toi da 15 ky tu
			SessionErrors.add(request, "errorMaxfax");
		}
		
		if(email.trim().length() >50){//toi da 50 ky tu
			SessionErrors.add(request, "errorMaxemail");
		}
		
		if(website.trim().length() >100){//toi da 100 ky tu
			SessionErrors.add(request, "errorMaxwebsite");
		}
			
		if (Validator.isNull(moTaNgheNghiep)) {
			SessionErrors.add(request, "emptymoTaNgheNghiep");
		}			
		
		if (nganhNgheDuocChon.length == 0) {
			SessionErrors.add(request, "emptyngheDuocChon");				
		}

		if (SessionErrors.isEmpty(request)) {
			return true;
		}

		return false;
	}

	public static boolean emailExists(String email) {
		try {
			if (Validator.isNull(email)) {
				return false;
			}

			// Query all cong dan with email
			List<TaiKhoanNguoiDung> taiKhoanLst = TaiKhoanNguoiDungLocalServiceUtil
					.findByEmail(email);

			// Get the first one
			if (taiKhoanLst.size() < 1) {
				return false;
			}

			TaiKhoanNguoiDung taiKhoanNguoiDung = taiKhoanLst.get(0);

			// Check if email exists
			if (email.equals(taiKhoanNguoiDung.getEmail())
					|| (taiKhoanNguoiDung.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE)) {

				// Check if email is owned by another person or not
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public static String congdanExists(String soCmnd, String ngaySinh)
			throws ParseException {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		Date birthDay = ConvertUtil.parseStringToDate(ngaySinh);

		// Check in database if there's existing person with the same birth day
		// and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil
				.forClass(CongDan.class);
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh")
				.eq(birthDay));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("soCmnd")
				.eq(soCmnd));
		List<CongDan> results = null;

		try {
			results = CongDanLocalServiceUtil.dynamicQuery(queryCongDan);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		if (results == null || results.size() < 1) {
			return StringPool.BLANK;
		}

		// Return the id
		return (results.get(0)).getMa();
	}

	public static boolean ValidateVon(String param) {
		if (param == null || param.isEmpty()) {
			return false;
		}
		String temp = param.trim();
		temp = temp.replaceAll(",", "");
		if (com.liferay.portal.kernel.util.Validator.isNumber(temp)) {
			return true;
		}
		return false;
	}

	public static CongDan getCongDanFromRequest(ActionRequest request)
			throws SystemException {
		CongDan congDan = null;
		if (Validator.isNotNull(ParamUtil.getString(request, "tvslId"))
				&& ParamUtil.getLong(request, "tvslId") != 0) {
			congDan = CongDanLocalServiceUtil.fetchCongDan(ParamUtil.getLong(
					request, "tvslId"));
		} else {
			congDan = new CongDanImpl();
		}
		congDan.setTenDayDu(ParamUtil.getString(request, "tvslTen"));
		congDan.setGioiTinh(ParamUtil.getInteger(request, "tvslGioiTinh"));
		if (Validator.isNotNull(ParamUtil.getString(request, "tvslNgaySinh"))) {
			congDan.setNgaySinh(ParamUtil.getDate(request, "tvslNgaySinh",
					new SimpleDateFormat("dd/MM/yyyy")));
		} else {
			congDan.setNgaySinh(null);
		}
		congDan.setQuocTichId(ParamUtil.getLong(request, "tvslQuocTich"));
		congDan.setDanTocId(ParamUtil.getLong(request, "tvslDanToc"));
		congDan.setSoCmnd(ParamUtil.getString(request, "tvslSoCMND"));
		if (Validator
				.isNotNull(ParamUtil.getString(request, "tvslNgayCapCMND"))) {
			congDan.setNgayCapCmnd(ParamUtil.getDate(request,
					"tvslNgayCapCMND", new SimpleDateFormat("dd/MM/yyyy")));
		} else {
			congDan.setNgayCapCmnd(null);
		}
		congDan.setNoiCapCmndId(ParamUtil.getLong(request, "tvslNoiCapCMND"));
		congDan.setDiaChiThuongTruTinhId(ParamUtil.getLong(request,
				"tvslTtTinhId"));
		congDan.setDiaChiThuongTruHuyenId(ParamUtil.getLong(request,
				"tvslTtHuyenId"));
		congDan.setDiaChiThuongTruXaId(ParamUtil.getLong(request, "tvslTtXaId"));
		congDan.setDiaChiThuongTru(ParamUtil.getString(request,
				"tvslTtMoTaDiaChi"));
		congDan.setDiaChiHienNayTinhId(ParamUtil.getLong(request,
				"tvslCohtTinhId"));
		congDan.setDiaChiHienNayHuyenId(ParamUtil.getLong(request,
				"tvslCohtHuyenId"));
		congDan.setDiaChiHienNayXaId(ParamUtil.getLong(request, "tvslCohtXaId"));
		congDan.setDiaChiHienNay(ParamUtil.getString(request,
				"tvslCohtMoTaChoO"));
		return congDan;
	}
}
