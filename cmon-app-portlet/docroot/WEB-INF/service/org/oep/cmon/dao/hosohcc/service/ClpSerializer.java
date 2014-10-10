/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.oep.cmon.dao.hosohcc.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.hosohcc.model.FileDinhKemClp;
import org.oep.cmon.dao.hosohcc.model.HoSoAnhXaClp;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCongClp;
import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSoClp;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"cmon-app-portlet_v1.1_201410-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"cmon-app-portlet_v1.1_201410-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "cmon-app-portlet_v1.1_201410-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(FileDinhKemClp.class.getName())) {
			return translateInputFileDinhKem(oldModel);
		}

		if (oldModelClassName.equals(HoSoAnhXaClp.class.getName())) {
			return translateInputHoSoAnhXa(oldModel);
		}

		if (oldModelClassName.equals(HoSoTTHCCongClp.class.getName())) {
			return translateInputHoSoTTHCCong(oldModel);
		}

		if (oldModelClassName.equals(TrangThaiHoSoClp.class.getName())) {
			return translateInputTrangThaiHoSo(oldModel);
		}

		if (oldModelClassName.equals(YKienTraoDoiClp.class.getName())) {
			return translateInputYKienTraoDoi(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputFileDinhKem(BaseModel<?> oldModel) {
		FileDinhKemClp oldCplModel = (FileDinhKemClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.hosohcc.model.impl.FileDinhKemImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setSoBanGiay",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getSoBanGiay());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDaDoiChieu",
						new Class[] { Integer.TYPE });

				Integer value2 = new Integer(oldCplModel.getDaDoiChieu());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTrangThaiHoSoTaiThoiDiemDinhKem",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getTrangThaiHoSoTaiThoiDiemDinhKem());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNoiLuuTruTaiLieuId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getNoiLuuTruTaiLieuId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCanBoId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getCanBoId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setHoSoTTHCCongId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getHoSoTTHCCongId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setThuTuc2GiayToId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getThuTuc2GiayToId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDanhMucGiayToId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getDanhMucGiayToId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgayUpload",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgayUpload();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getNgaySua();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNguoiUpload",
						new Class[] { String.class });

				String value11 = oldCplModel.getNguoiUpload();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setMaLoaiTaiLieuDuocThayThe",
						new Class[] { String.class });

				String value12 = oldCplModel.getMaLoaiTaiLieuDuocThayThe();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value13 = oldCplModel.getNguoiSua();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setXoa",
						new Class[] { Integer.TYPE });

				Integer value14 = new Integer(oldCplModel.getXoa());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setDaTra",
						new Class[] { Integer.TYPE });

				Integer value15 = new Integer(oldCplModel.getDaTra());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setBanChinh",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getBanChinh());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setGhiChu",
						new Class[] { String.class });

				String value17 = oldCplModel.getGhiChu();

				method17.invoke(newModel, value17);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputHoSoAnhXa(BaseModel<?> oldModel) {
		HoSoAnhXaClp oldCplModel = (HoSoAnhXaClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.hosohcc.model.impl.HoSoAnhXaImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setHoSoTTHCCongId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getHoSoTTHCCongId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMaHoSo",
						new Class[] { String.class });

				String value2 = oldCplModel.getMaHoSo();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getTrangThai());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgaySua();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgayTao();

				method5.invoke(newModel, value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputHoSoTTHCCong(BaseModel<?> oldModel) {
		HoSoTTHCCongClp oldCplModel = (HoSoTTHCCongClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.hosohcc.model.impl.HoSoTTHCCongImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setMaSoHoSo",
						new Class[] { String.class });

				String value1 = oldCplModel.getMaSoHoSo();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNgayNopHoSo",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getNgayNopHoSo();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgayNhanHoSo",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayNhanHoSo();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTenCoQuanTiepNhan",
						new Class[] { String.class });

				String value4 = oldCplModel.getTenCoQuanTiepNhan();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTenThuTucHanhChinh",
						new Class[] { String.class });

				String value5 = oldCplModel.getTenThuTucHanhChinh();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgayHenTraKetQua",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgayHenTraKetQua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgayTraKetQua",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgayTraKetQua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNgayNopHoSoGoc",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getNgayNopHoSoGoc();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgayHenNopHoSoGoc",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgayHenNopHoSoGoc();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setTenCanBoTiepNhan",
						new Class[] { String.class });

				String value10 = oldCplModel.getTenCanBoTiepNhan();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setChucVuCanBoTiepNhan",
						new Class[] { String.class });

				String value11 = oldCplModel.getChucVuCanBoTiepNhan();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setHoTenNguoiNopHoSo",
						new Class[] { String.class });

				String value12 = oldCplModel.getHoTenNguoiNopHoSo();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setDiaChiThuongTruNguoiNop",
						new Class[] { String.class });

				String value13 = oldCplModel.getDiaChiThuongTruNguoiNop();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setSoDienThoaiCoDinhNguoiNop",
						new Class[] { String.class });

				String value14 = oldCplModel.getSoDienThoaiCoDinhNguoiNop();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setTenCanBoTraKetQua",
						new Class[] { String.class });

				String value15 = oldCplModel.getTenCanBoTraKetQua();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setChucVuCanBoTraKetQua",
						new Class[] { String.class });

				String value16 = oldCplModel.getChucVuCanBoTraKetQua();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setHoTenNguoiNhanKetQua",
						new Class[] { String.class });

				String value17 = oldCplModel.getHoTenNguoiNhanKetQua();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setDiaChiThuongTruNguoiNhanKQ",
						new Class[] { String.class });

				String value18 = oldCplModel.getDiaChiThuongTruNguoiNhanKQ();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setSoDienThoaiNguoiNhan",
						new Class[] { String.class });

				String value19 = oldCplModel.getSoDienThoaiNguoiNhan();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setNgayCap",
						new Class[] { Date.class });

				Date value20 = oldCplModel.getNgayCap();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setLanCap",
						new Class[] { Long.TYPE });

				Long value21 = new Long(oldCplModel.getLanCap());

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setTenCoQuanCap",
						new Class[] { String.class });

				String value22 = oldCplModel.getTenCoQuanCap();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setHieuLucTuNgay",
						new Class[] { Date.class });

				Date value23 = oldCplModel.getHieuLucTuNgay();

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setHieuLucDenNgay",
						new Class[] { Date.class });

				Date value24 = oldCplModel.getHieuLucDenNgay();

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setTrangThaiHoSo",
						new Class[] { Integer.TYPE });

				Integer value25 = new Integer(oldCplModel.getTrangThaiHoSo());

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value26 = new Integer(oldCplModel.getDaXoa());

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value27 = oldCplModel.getNguoiTao();

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value28 = oldCplModel.getNgayTao();

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value29 = oldCplModel.getNguoiSua();

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value30 = oldCplModel.getNgaySua();

				method30.invoke(newModel, value30);

				Method method31 = newModelClass.getMethod("setThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value31 = new Long(oldCplModel.getThuTucHanhChinhId());

				method31.invoke(newModel, value31);

				Method method32 = newModelClass.getMethod("setCongDanNopId",
						new Class[] { Long.TYPE });

				Long value32 = new Long(oldCplModel.getCongDanNopId());

				method32.invoke(newModel, value32);

				Method method33 = newModelClass.getMethod("setDiaChiThuongTruNguoiNhanKQId",
						new Class[] { Long.TYPE });

				Long value33 = new Long(oldCplModel.getDiaChiThuongTruNguoiNhanKQId());

				method33.invoke(newModel, value33);

				Method method34 = newModelClass.getMethod("setCoQuanTiepNhanId",
						new Class[] { Long.TYPE });

				Long value34 = new Long(oldCplModel.getCoQuanTiepNhanId());

				method34.invoke(newModel, value34);

				Method method35 = newModelClass.getMethod("setCanBoTraKetQuaId",
						new Class[] { Long.TYPE });

				Long value35 = new Long(oldCplModel.getCanBoTraKetQuaId());

				method35.invoke(newModel, value35);

				Method method36 = newModelClass.getMethod("setCanBoTiepNhanId",
						new Class[] { Long.TYPE });

				Long value36 = new Long(oldCplModel.getCanBoTiepNhanId());

				method36.invoke(newModel, value36);

				Method method37 = newModelClass.getMethod("setDiaChiThuongTruNguoiNopId",
						new Class[] { Long.TYPE });

				Long value37 = new Long(oldCplModel.getDiaChiThuongTruNguoiNopId());

				method37.invoke(newModel, value37);

				Method method38 = newModelClass.getMethod("setSoDienThoaiDiDongNguoiNop",
						new Class[] { String.class });

				String value38 = oldCplModel.getSoDienThoaiDiDongNguoiNop();

				method38.invoke(newModel, value38);

				Method method39 = newModelClass.getMethod("setPhongBanXuLyHienThoiId",
						new Class[] { Long.TYPE });

				Long value39 = new Long(oldCplModel.getPhongBanXuLyHienThoiId());

				method39.invoke(newModel, value39);

				Method method40 = newModelClass.getMethod("setTenPhongBanXuLyHienThoi",
						new Class[] { String.class });

				String value40 = oldCplModel.getTenPhongBanXuLyHienThoi();

				method40.invoke(newModel, value40);

				Method method41 = newModelClass.getMethod("setCanBoXuLyHienThoiId",
						new Class[] { Long.TYPE });

				Long value41 = new Long(oldCplModel.getCanBoXuLyHienThoiId());

				method41.invoke(newModel, value41);

				Method method42 = newModelClass.getMethod("setTenCanBoXuLyHienThoi",
						new Class[] { String.class });

				String value42 = oldCplModel.getTenCanBoXuLyHienThoi();

				method42.invoke(newModel, value42);

				Method method43 = newModelClass.getMethod("setDanhGiaKetQua",
						new Class[] { Integer.TYPE });

				Integer value43 = new Integer(oldCplModel.getDanhGiaKetQua());

				method43.invoke(newModel, value43);

				Method method44 = newModelClass.getMethod("setGhiChu",
						new Class[] { String.class });

				String value44 = oldCplModel.getGhiChu();

				method44.invoke(newModel, value44);

				Method method45 = newModelClass.getMethod("setNgayKetThucXuLy",
						new Class[] { Date.class });

				Date value45 = oldCplModel.getNgayKetThucXuLy();

				method45.invoke(newModel, value45);

				Method method46 = newModelClass.getMethod("setLoaiHoSo",
						new Class[] { Integer.TYPE });

				Integer value46 = new Integer(oldCplModel.getLoaiHoSo());

				method46.invoke(newModel, value46);

				Method method47 = newModelClass.getMethod("setYeuCauHuyHoSo",
						new Class[] { Integer.TYPE });

				Integer value47 = new Integer(oldCplModel.getYeuCauHuyHoSo());

				method47.invoke(newModel, value47);

				Method method48 = newModelClass.getMethod("setMaSoBienNhan",
						new Class[] { String.class });

				String value48 = oldCplModel.getMaSoBienNhan();

				method48.invoke(newModel, value48);

				Method method49 = newModelClass.getMethod("setTenBangChuaHoSo",
						new Class[] { String.class });

				String value49 = oldCplModel.getTenBangChuaHoSo();

				method49.invoke(newModel, value49);

				Method method50 = newModelClass.getMethod("setChuSoHuu",
						new Class[] { String.class });

				String value50 = oldCplModel.getChuSoHuu();

				method50.invoke(newModel, value50);

				Method method51 = newModelClass.getMethod("setSoBoHoSo",
						new Class[] { Integer.TYPE });

				Integer value51 = new Integer(oldCplModel.getSoBoHoSo());

				method51.invoke(newModel, value51);

				Method method52 = newModelClass.getMethod("setLePhi",
						new Class[] { Integer.TYPE });

				Integer value52 = new Integer(oldCplModel.getLePhi());

				method52.invoke(newModel, value52);

				Method method53 = newModelClass.getMethod("setPhiHoSo",
						new Class[] { Integer.TYPE });

				Integer value53 = new Integer(oldCplModel.getPhiHoSo());

				method53.invoke(newModel, value53);

				Method method54 = newModelClass.getMethod("setTrichYeu",
						new Class[] { String.class });

				String value54 = oldCplModel.getTrichYeu();

				method54.invoke(newModel, value54);

				Method method55 = newModelClass.getMethod("setNgayHenTBThue",
						new Class[] { Date.class });

				Date value55 = oldCplModel.getNgayHenTBThue();

				method55.invoke(newModel, value55);

				Method method56 = newModelClass.getMethod("setEmailNguoiNop",
						new Class[] { String.class });

				String value56 = oldCplModel.getEmailNguoiNop();

				method56.invoke(newModel, value56);

				Method method57 = newModelClass.getMethod("setMaUngDung",
						new Class[] { String.class });

				String value57 = oldCplModel.getMaUngDung();

				method57.invoke(newModel, value57);

				Method method58 = newModelClass.getMethod("setDaGuiGiayHen",
						new Class[] { Integer.TYPE });

				Integer value58 = new Integer(oldCplModel.getDaGuiGiayHen());

				method58.invoke(newModel, value58);

				Method method59 = newModelClass.getMethod("setNguoiDaiDienPhapLuat",
						new Class[] { String.class });

				String value59 = oldCplModel.getNguoiDaiDienPhapLuat();

				method59.invoke(newModel, value59);

				Method method60 = newModelClass.getMethod("setNguoiDaiDienPhapLuatId",
						new Class[] { Long.TYPE });

				Long value60 = new Long(oldCplModel.getNguoiDaiDienPhapLuatId());

				method60.invoke(newModel, value60);

				Method method61 = newModelClass.getMethod("setChuyenSangMotCua",
						new Class[] { Integer.TYPE });

				Integer value61 = new Integer(oldCplModel.getChuyenSangMotCua());

				method61.invoke(newModel, value61);

				Method method62 = newModelClass.getMethod("setDoiTuongCanXuLyId",
						new Class[] { Long.TYPE });

				Long value62 = new Long(oldCplModel.getDoiTuongCanXuLyId());

				method62.invoke(newModel, value62);

				Method method63 = newModelClass.getMethod("setLyDo",
						new Class[] { String.class });

				String value63 = oldCplModel.getLyDo();

				method63.invoke(newModel, value63);

				Method method64 = newModelClass.getMethod("setMoTaThanhPhanHoSo",
						new Class[] { String.class });

				String value64 = oldCplModel.getMoTaThanhPhanHoSo();

				method64.invoke(newModel, value64);

				Method method65 = newModelClass.getMethod("setLienKetThanhPhanHoSo",
						new Class[] { String.class });

				String value65 = oldCplModel.getLienKetThanhPhanHoSo();

				method65.invoke(newModel, value65);

				Method method66 = newModelClass.getMethod("setSoNgayXuLy",
						new Class[] { Long.TYPE });

				Long value66 = new Long(oldCplModel.getSoNgayXuLy());

				method66.invoke(newModel, value66);

				Method method67 = newModelClass.getMethod("setDaTraKetQuaTrucTuyen",
						new Class[] { Long.TYPE });

				Long value67 = new Long(oldCplModel.getDaTraKetQuaTrucTuyen());

				method67.invoke(newModel, value67);

				Method method68 = newModelClass.getMethod("setEMailNguoiNhan",
						new Class[] { String.class });

				String value68 = oldCplModel.getEMailNguoiNhan();

				method68.invoke(newModel, value68);

				Method method69 = newModelClass.getMethod("setNgaySinhNguoiNhan",
						new Class[] { Date.class });

				Date value69 = oldCplModel.getNgaySinhNguoiNhan();

				method69.invoke(newModel, value69);

				Method method70 = newModelClass.getMethod("setDienThoiCoDinhNguoiNhan",
						new Class[] { String.class });

				String value70 = oldCplModel.getDienThoiCoDinhNguoiNhan();

				method70.invoke(newModel, value70);

				Method method71 = newModelClass.getMethod("setCmndNguoiNhan",
						new Class[] { String.class });

				String value71 = oldCplModel.getCmndNguoiNhan();

				method71.invoke(newModel, value71);

				Method method72 = newModelClass.getMethod("setGioiTinh",
						new Class[] { Integer.TYPE });

				Integer value72 = new Integer(oldCplModel.getGioiTinh());

				method72.invoke(newModel, value72);

				Method method73 = newModelClass.getMethod("setDungXuLy",
						new Class[] { Boolean.TYPE });

				Boolean value73 = new Boolean(oldCplModel.getDungXuLy());

				method73.invoke(newModel, value73);

				Method method74 = newModelClass.getMethod("setNgayBoSung",
						new Class[] { Date.class });

				Date value74 = oldCplModel.getNgayBoSung();

				method74.invoke(newModel, value74);

				Method method75 = newModelClass.getMethod("setGhiChuGiayToDinhKem",
						new Class[] { String.class });

				String value75 = oldCplModel.getGhiChuGiayToDinhKem();

				method75.invoke(newModel, value75);

				Method method76 = newModelClass.getMethod("setDaDangKyNhanSMS",
						new Class[] { Integer.TYPE });

				Integer value76 = new Integer(oldCplModel.getDaDangKyNhanSMS());

				method76.invoke(newModel, value76);

				Method method77 = newModelClass.getMethod("setDaDangKyChuyenPhatNhanh",
						new Class[] { Integer.TYPE });

				Integer value77 = new Integer(oldCplModel.getDaDangKyChuyenPhatNhanh());

				method77.invoke(newModel, value77);

				Method method78 = newModelClass.getMethod("setDiaChiChuHoSo",
						new Class[] { String.class });

				String value78 = oldCplModel.getDiaChiChuHoSo();

				method78.invoke(newModel, value78);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputTrangThaiHoSo(BaseModel<?> oldModel) {
		TrangThaiHoSoClp oldCplModel = (TrangThaiHoSoClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.hosohcc.model.impl.TrangThaiHoSoImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTrangThai",
						new Class[] { String.class });

				String value1 = oldCplModel.getTrangThai();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value2 = oldCplModel.getNguoiTao();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayTao();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiSua();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgaySua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getDaXoa());

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputYKienTraoDoi(BaseModel<?> oldModel) {
		YKienTraoDoiClp oldCplModel = (YKienTraoDoiClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.hosohcc.model.impl.YKienTraoDoiImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTieuDe",
						new Class[] { String.class });

				String value1 = oldCplModel.getTieuDe();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNoiDungYKien",
						new Class[] { String.class });

				String value2 = oldCplModel.getNoiDungYKien();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setThoiGianGuiYKien",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getThoiGianGuiYKien();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTrangThai",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getTrangThai());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setHoSoTTHCCongId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getHoSoTTHCCongId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiNhanId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getNguoiNhanId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiGuiId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getNguoiGuiId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setChaiId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getChaiId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNoiLuuTruId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getNoiLuuTruId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setLoai",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getLoai());

				method10.invoke(newModel, value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.hosohcc.model.impl.FileDinhKemImpl")) {
			return translateOutputFileDinhKem(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.hosohcc.model.impl.HoSoAnhXaImpl")) {
			return translateOutputHoSoAnhXa(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.hosohcc.model.impl.HoSoTTHCCongImpl")) {
			return translateOutputHoSoTTHCCong(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.hosohcc.model.impl.TrangThaiHoSoImpl")) {
			return translateOutputTrangThaiHoSo(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.hosohcc.model.impl.YKienTraoDoiImpl")) {
			return translateOutputYKienTraoDoi(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputFileDinhKem(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				FileDinhKemClp newModel = new FileDinhKemClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getSoBanGiay");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setSoBanGiay(value1);

				Method method2 = oldModelClass.getMethod("getDaDoiChieu");

				Integer value2 = (Integer)method2.invoke(oldModel,
						(Object[])null);

				newModel.setDaDoiChieu(value2);

				Method method3 = oldModelClass.getMethod(
						"getTrangThaiHoSoTaiThoiDiemDinhKem");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiHoSoTaiThoiDiemDinhKem(value3);

				Method method4 = oldModelClass.getMethod(
						"getNoiLuuTruTaiLieuId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setNoiLuuTruTaiLieuId(value4);

				Method method5 = oldModelClass.getMethod("getCanBoId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setCanBoId(value5);

				Method method6 = oldModelClass.getMethod("getHoSoTTHCCongId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setHoSoTTHCCongId(value6);

				Method method7 = oldModelClass.getMethod("getThuTuc2GiayToId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setThuTuc2GiayToId(value7);

				Method method8 = oldModelClass.getMethod("getDanhMucGiayToId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setDanhMucGiayToId(value8);

				Method method9 = oldModelClass.getMethod("getNgayUpload");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgayUpload(value9);

				Method method10 = oldModelClass.getMethod("getNgaySua");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value10);

				Method method11 = oldModelClass.getMethod("getNguoiUpload");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiUpload(value11);

				Method method12 = oldModelClass.getMethod(
						"getMaLoaiTaiLieuDuocThayThe");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setMaLoaiTaiLieuDuocThayThe(value12);

				Method method13 = oldModelClass.getMethod("getNguoiSua");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value13);

				Method method14 = oldModelClass.getMethod("getXoa");

				Integer value14 = (Integer)method14.invoke(oldModel,
						(Object[])null);

				newModel.setXoa(value14);

				Method method15 = oldModelClass.getMethod("getDaTra");

				Integer value15 = (Integer)method15.invoke(oldModel,
						(Object[])null);

				newModel.setDaTra(value15);

				Method method16 = oldModelClass.getMethod("getBanChinh");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setBanChinh(value16);

				Method method17 = oldModelClass.getMethod("getGhiChu");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setGhiChu(value17);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputHoSoAnhXa(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HoSoAnhXaClp newModel = new HoSoAnhXaClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getHoSoTTHCCongId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setHoSoTTHCCongId(value1);

				Method method2 = oldModelClass.getMethod("getMaHoSo");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMaHoSo(value2);

				Method method3 = oldModelClass.getMethod("getTrangThai");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value3);

				Method method4 = oldModelClass.getMethod("getNgaySua");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value4);

				Method method5 = oldModelClass.getMethod("getNgayTao");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputHoSoTTHCCong(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HoSoTTHCCongClp newModel = new HoSoTTHCCongClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getMaSoHoSo");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setMaSoHoSo(value1);

				Method method2 = oldModelClass.getMethod("getNgayNopHoSo");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setNgayNopHoSo(value2);

				Method method3 = oldModelClass.getMethod("getNgayNhanHoSo");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayNhanHoSo(value3);

				Method method4 = oldModelClass.getMethod("getTenCoQuanTiepNhan");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setTenCoQuanTiepNhan(value4);

				Method method5 = oldModelClass.getMethod(
						"getTenThuTucHanhChinh");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setTenThuTucHanhChinh(value5);

				Method method6 = oldModelClass.getMethod("getNgayHenTraKetQua");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgayHenTraKetQua(value6);

				Method method7 = oldModelClass.getMethod("getNgayTraKetQua");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgayTraKetQua(value7);

				Method method8 = oldModelClass.getMethod("getNgayNopHoSoGoc");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setNgayNopHoSoGoc(value8);

				Method method9 = oldModelClass.getMethod("getNgayHenNopHoSoGoc");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgayHenNopHoSoGoc(value9);

				Method method10 = oldModelClass.getMethod("getTenCanBoTiepNhan");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setTenCanBoTiepNhan(value10);

				Method method11 = oldModelClass.getMethod(
						"getChucVuCanBoTiepNhan");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setChucVuCanBoTiepNhan(value11);

				Method method12 = oldModelClass.getMethod(
						"getHoTenNguoiNopHoSo");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenNguoiNopHoSo(value12);

				Method method13 = oldModelClass.getMethod(
						"getDiaChiThuongTruNguoiNop");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiThuongTruNguoiNop(value13);

				Method method14 = oldModelClass.getMethod(
						"getSoDienThoaiCoDinhNguoiNop");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setSoDienThoaiCoDinhNguoiNop(value14);

				Method method15 = oldModelClass.getMethod(
						"getTenCanBoTraKetQua");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setTenCanBoTraKetQua(value15);

				Method method16 = oldModelClass.getMethod(
						"getChucVuCanBoTraKetQua");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setChucVuCanBoTraKetQua(value16);

				Method method17 = oldModelClass.getMethod(
						"getHoTenNguoiNhanKetQua");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenNguoiNhanKetQua(value17);

				Method method18 = oldModelClass.getMethod(
						"getDiaChiThuongTruNguoiNhanKQ");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiThuongTruNguoiNhanKQ(value18);

				Method method19 = oldModelClass.getMethod(
						"getSoDienThoaiNguoiNhan");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setSoDienThoaiNguoiNhan(value19);

				Method method20 = oldModelClass.getMethod("getNgayCap");

				Date value20 = (Date)method20.invoke(oldModel, (Object[])null);

				newModel.setNgayCap(value20);

				Method method21 = oldModelClass.getMethod("getLanCap");

				Long value21 = (Long)method21.invoke(oldModel, (Object[])null);

				newModel.setLanCap(value21);

				Method method22 = oldModelClass.getMethod("getTenCoQuanCap");

				String value22 = (String)method22.invoke(oldModel,
						(Object[])null);

				newModel.setTenCoQuanCap(value22);

				Method method23 = oldModelClass.getMethod("getHieuLucTuNgay");

				Date value23 = (Date)method23.invoke(oldModel, (Object[])null);

				newModel.setHieuLucTuNgay(value23);

				Method method24 = oldModelClass.getMethod("getHieuLucDenNgay");

				Date value24 = (Date)method24.invoke(oldModel, (Object[])null);

				newModel.setHieuLucDenNgay(value24);

				Method method25 = oldModelClass.getMethod("getTrangThaiHoSo");

				Integer value25 = (Integer)method25.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiHoSo(value25);

				Method method26 = oldModelClass.getMethod("getDaXoa");

				Integer value26 = (Integer)method26.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value26);

				Method method27 = oldModelClass.getMethod("getNguoiTao");

				String value27 = (String)method27.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value27);

				Method method28 = oldModelClass.getMethod("getNgayTao");

				Date value28 = (Date)method28.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value28);

				Method method29 = oldModelClass.getMethod("getNguoiSua");

				String value29 = (String)method29.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value29);

				Method method30 = oldModelClass.getMethod("getNgaySua");

				Date value30 = (Date)method30.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value30);

				Method method31 = oldModelClass.getMethod(
						"getThuTucHanhChinhId");

				Long value31 = (Long)method31.invoke(oldModel, (Object[])null);

				newModel.setThuTucHanhChinhId(value31);

				Method method32 = oldModelClass.getMethod("getCongDanNopId");

				Long value32 = (Long)method32.invoke(oldModel, (Object[])null);

				newModel.setCongDanNopId(value32);

				Method method33 = oldModelClass.getMethod(
						"getDiaChiThuongTruNguoiNhanKQId");

				Long value33 = (Long)method33.invoke(oldModel, (Object[])null);

				newModel.setDiaChiThuongTruNguoiNhanKQId(value33);

				Method method34 = oldModelClass.getMethod("getCoQuanTiepNhanId");

				Long value34 = (Long)method34.invoke(oldModel, (Object[])null);

				newModel.setCoQuanTiepNhanId(value34);

				Method method35 = oldModelClass.getMethod("getCanBoTraKetQuaId");

				Long value35 = (Long)method35.invoke(oldModel, (Object[])null);

				newModel.setCanBoTraKetQuaId(value35);

				Method method36 = oldModelClass.getMethod("getCanBoTiepNhanId");

				Long value36 = (Long)method36.invoke(oldModel, (Object[])null);

				newModel.setCanBoTiepNhanId(value36);

				Method method37 = oldModelClass.getMethod(
						"getDiaChiThuongTruNguoiNopId");

				Long value37 = (Long)method37.invoke(oldModel, (Object[])null);

				newModel.setDiaChiThuongTruNguoiNopId(value37);

				Method method38 = oldModelClass.getMethod(
						"getSoDienThoaiDiDongNguoiNop");

				String value38 = (String)method38.invoke(oldModel,
						(Object[])null);

				newModel.setSoDienThoaiDiDongNguoiNop(value38);

				Method method39 = oldModelClass.getMethod(
						"getPhongBanXuLyHienThoiId");

				Long value39 = (Long)method39.invoke(oldModel, (Object[])null);

				newModel.setPhongBanXuLyHienThoiId(value39);

				Method method40 = oldModelClass.getMethod(
						"getTenPhongBanXuLyHienThoi");

				String value40 = (String)method40.invoke(oldModel,
						(Object[])null);

				newModel.setTenPhongBanXuLyHienThoi(value40);

				Method method41 = oldModelClass.getMethod(
						"getCanBoXuLyHienThoiId");

				Long value41 = (Long)method41.invoke(oldModel, (Object[])null);

				newModel.setCanBoXuLyHienThoiId(value41);

				Method method42 = oldModelClass.getMethod(
						"getTenCanBoXuLyHienThoi");

				String value42 = (String)method42.invoke(oldModel,
						(Object[])null);

				newModel.setTenCanBoXuLyHienThoi(value42);

				Method method43 = oldModelClass.getMethod("getDanhGiaKetQua");

				Integer value43 = (Integer)method43.invoke(oldModel,
						(Object[])null);

				newModel.setDanhGiaKetQua(value43);

				Method method44 = oldModelClass.getMethod("getGhiChu");

				String value44 = (String)method44.invoke(oldModel,
						(Object[])null);

				newModel.setGhiChu(value44);

				Method method45 = oldModelClass.getMethod("getNgayKetThucXuLy");

				Date value45 = (Date)method45.invoke(oldModel, (Object[])null);

				newModel.setNgayKetThucXuLy(value45);

				Method method46 = oldModelClass.getMethod("getLoaiHoSo");

				Integer value46 = (Integer)method46.invoke(oldModel,
						(Object[])null);

				newModel.setLoaiHoSo(value46);

				Method method47 = oldModelClass.getMethod("getYeuCauHuyHoSo");

				Integer value47 = (Integer)method47.invoke(oldModel,
						(Object[])null);

				newModel.setYeuCauHuyHoSo(value47);

				Method method48 = oldModelClass.getMethod("getMaSoBienNhan");

				String value48 = (String)method48.invoke(oldModel,
						(Object[])null);

				newModel.setMaSoBienNhan(value48);

				Method method49 = oldModelClass.getMethod("getTenBangChuaHoSo");

				String value49 = (String)method49.invoke(oldModel,
						(Object[])null);

				newModel.setTenBangChuaHoSo(value49);

				Method method50 = oldModelClass.getMethod("getChuSoHuu");

				String value50 = (String)method50.invoke(oldModel,
						(Object[])null);

				newModel.setChuSoHuu(value50);

				Method method51 = oldModelClass.getMethod("getSoBoHoSo");

				Integer value51 = (Integer)method51.invoke(oldModel,
						(Object[])null);

				newModel.setSoBoHoSo(value51);

				Method method52 = oldModelClass.getMethod("getLePhi");

				Integer value52 = (Integer)method52.invoke(oldModel,
						(Object[])null);

				newModel.setLePhi(value52);

				Method method53 = oldModelClass.getMethod("getPhiHoSo");

				Integer value53 = (Integer)method53.invoke(oldModel,
						(Object[])null);

				newModel.setPhiHoSo(value53);

				Method method54 = oldModelClass.getMethod("getTrichYeu");

				String value54 = (String)method54.invoke(oldModel,
						(Object[])null);

				newModel.setTrichYeu(value54);

				Method method55 = oldModelClass.getMethod("getNgayHenTBThue");

				Date value55 = (Date)method55.invoke(oldModel, (Object[])null);

				newModel.setNgayHenTBThue(value55);

				Method method56 = oldModelClass.getMethod("getEmailNguoiNop");

				String value56 = (String)method56.invoke(oldModel,
						(Object[])null);

				newModel.setEmailNguoiNop(value56);

				Method method57 = oldModelClass.getMethod("getMaUngDung");

				String value57 = (String)method57.invoke(oldModel,
						(Object[])null);

				newModel.setMaUngDung(value57);

				Method method58 = oldModelClass.getMethod("getDaGuiGiayHen");

				Integer value58 = (Integer)method58.invoke(oldModel,
						(Object[])null);

				newModel.setDaGuiGiayHen(value58);

				Method method59 = oldModelClass.getMethod(
						"getNguoiDaiDienPhapLuat");

				String value59 = (String)method59.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiDaiDienPhapLuat(value59);

				Method method60 = oldModelClass.getMethod(
						"getNguoiDaiDienPhapLuatId");

				Long value60 = (Long)method60.invoke(oldModel, (Object[])null);

				newModel.setNguoiDaiDienPhapLuatId(value60);

				Method method61 = oldModelClass.getMethod("getChuyenSangMotCua");

				Integer value61 = (Integer)method61.invoke(oldModel,
						(Object[])null);

				newModel.setChuyenSangMotCua(value61);

				Method method62 = oldModelClass.getMethod(
						"getDoiTuongCanXuLyId");

				Long value62 = (Long)method62.invoke(oldModel, (Object[])null);

				newModel.setDoiTuongCanXuLyId(value62);

				Method method63 = oldModelClass.getMethod("getLyDo");

				String value63 = (String)method63.invoke(oldModel,
						(Object[])null);

				newModel.setLyDo(value63);

				Method method64 = oldModelClass.getMethod(
						"getMoTaThanhPhanHoSo");

				String value64 = (String)method64.invoke(oldModel,
						(Object[])null);

				newModel.setMoTaThanhPhanHoSo(value64);

				Method method65 = oldModelClass.getMethod(
						"getLienKetThanhPhanHoSo");

				String value65 = (String)method65.invoke(oldModel,
						(Object[])null);

				newModel.setLienKetThanhPhanHoSo(value65);

				Method method66 = oldModelClass.getMethod("getSoNgayXuLy");

				Long value66 = (Long)method66.invoke(oldModel, (Object[])null);

				newModel.setSoNgayXuLy(value66);

				Method method67 = oldModelClass.getMethod(
						"getDaTraKetQuaTrucTuyen");

				Long value67 = (Long)method67.invoke(oldModel, (Object[])null);

				newModel.setDaTraKetQuaTrucTuyen(value67);

				Method method68 = oldModelClass.getMethod("getEMailNguoiNhan");

				String value68 = (String)method68.invoke(oldModel,
						(Object[])null);

				newModel.setEMailNguoiNhan(value68);

				Method method69 = oldModelClass.getMethod(
						"getNgaySinhNguoiNhan");

				Date value69 = (Date)method69.invoke(oldModel, (Object[])null);

				newModel.setNgaySinhNguoiNhan(value69);

				Method method70 = oldModelClass.getMethod(
						"getDienThoiCoDinhNguoiNhan");

				String value70 = (String)method70.invoke(oldModel,
						(Object[])null);

				newModel.setDienThoiCoDinhNguoiNhan(value70);

				Method method71 = oldModelClass.getMethod("getCmndNguoiNhan");

				String value71 = (String)method71.invoke(oldModel,
						(Object[])null);

				newModel.setCmndNguoiNhan(value71);

				Method method72 = oldModelClass.getMethod("getGioiTinh");

				Integer value72 = (Integer)method72.invoke(oldModel,
						(Object[])null);

				newModel.setGioiTinh(value72);

				Method method73 = oldModelClass.getMethod("getDungXuLy");

				Boolean value73 = (Boolean)method73.invoke(oldModel,
						(Object[])null);

				newModel.setDungXuLy(value73);

				Method method74 = oldModelClass.getMethod("getNgayBoSung");

				Date value74 = (Date)method74.invoke(oldModel, (Object[])null);

				newModel.setNgayBoSung(value74);

				Method method75 = oldModelClass.getMethod(
						"getGhiChuGiayToDinhKem");

				String value75 = (String)method75.invoke(oldModel,
						(Object[])null);

				newModel.setGhiChuGiayToDinhKem(value75);

				Method method76 = oldModelClass.getMethod("getDaDangKyNhanSMS");

				Integer value76 = (Integer)method76.invoke(oldModel,
						(Object[])null);

				newModel.setDaDangKyNhanSMS(value76);

				Method method77 = oldModelClass.getMethod(
						"getDaDangKyChuyenPhatNhanh");

				Integer value77 = (Integer)method77.invoke(oldModel,
						(Object[])null);

				newModel.setDaDangKyChuyenPhatNhanh(value77);

				Method method78 = oldModelClass.getMethod("getDiaChiChuHoSo");

				String value78 = (String)method78.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiChuHoSo(value78);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputTrangThaiHoSo(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TrangThaiHoSoClp newModel = new TrangThaiHoSoClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTrangThai");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTrangThai(value1);

				Method method2 = oldModelClass.getMethod("getNguoiTao");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value2);

				Method method3 = oldModelClass.getMethod("getNgayTao");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value3);

				Method method4 = oldModelClass.getMethod("getNguoiSua");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value4);

				Method method5 = oldModelClass.getMethod("getNgaySua");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value5);

				Method method6 = oldModelClass.getMethod("getDaXoa");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputYKienTraoDoi(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				YKienTraoDoiClp newModel = new YKienTraoDoiClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTieuDe");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTieuDe(value1);

				Method method2 = oldModelClass.getMethod("getNoiDungYKien");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setNoiDungYKien(value2);

				Method method3 = oldModelClass.getMethod("getThoiGianGuiYKien");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setThoiGianGuiYKien(value3);

				Method method4 = oldModelClass.getMethod("getTrangThai");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setTrangThai(value4);

				Method method5 = oldModelClass.getMethod("getHoSoTTHCCongId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setHoSoTTHCCongId(value5);

				Method method6 = oldModelClass.getMethod("getNguoiNhanId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiNhanId(value6);

				Method method7 = oldModelClass.getMethod("getNguoiGuiId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiGuiId(value7);

				Method method8 = oldModelClass.getMethod("getChaiId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setChaiId(value8);

				Method method9 = oldModelClass.getMethod("getNoiLuuTruId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setNoiLuuTruId(value9);

				Method method10 = oldModelClass.getMethod("getLoai");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setLoai(value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}