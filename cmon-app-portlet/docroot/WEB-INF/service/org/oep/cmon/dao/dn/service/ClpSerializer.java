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

package org.oep.cmon.dao.dn.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNgheClp;
import org.oep.cmon.dao.dn.model.DoanhNghiepClp;
import org.oep.cmon.dao.dn.model.LoaiDoanhNghiepClp;
import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanhClp;
import org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiepClp;
import org.oep.cmon.dao.dn.model.YeuCauDangKyDNClp;
import org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiepClp;

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

		if (oldModelClassName.equals(DoanhNghiepClp.class.getName())) {
			return translateInputDoanhNghiep(oldModel);
		}

		if (oldModelClassName.equals(DoanhNghiep2NganhNgheClp.class.getName())) {
			return translateInputDoanhNghiep2NganhNghe(oldModel);
		}

		if (oldModelClassName.equals(LoaiDoanhNghiepClp.class.getName())) {
			return translateInputLoaiDoanhNghiep(oldModel);
		}

		if (oldModelClassName.equals(NganhNgheKinhDoanhClp.class.getName())) {
			return translateInputNganhNgheKinhDoanh(oldModel);
		}

		if (oldModelClassName.equals(TrangThaiDoanhNghiepClp.class.getName())) {
			return translateInputTrangThaiDoanhNghiep(oldModel);
		}

		if (oldModelClassName.equals(YeuCauDangKyDNClp.class.getName())) {
			return translateInputYeuCauDangKyDN(oldModel);
		}

		if (oldModelClassName.equals(YeuCauDangKyDoanhNghiepClp.class.getName())) {
			return translateInputYeuCauDangKyDoanhNghiep(oldModel);
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

	public static Object translateInputDoanhNghiep(BaseModel<?> oldModel) {
		DoanhNghiepClp oldCplModel = (DoanhNghiepClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dn.model.impl.DoanhNghiepImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setMa",
						new Class[] { String.class });

				String value1 = oldCplModel.getMa();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTen",
						new Class[] { String.class });

				String value2 = oldCplModel.getTen();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMaSoThue",
						new Class[] { String.class });

				String value3 = oldCplModel.getMaSoThue();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTenTiengNuocNgoai",
						new Class[] { String.class });

				String value4 = oldCplModel.getTenTiengNuocNgoai();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTenVietTat",
						new Class[] { String.class });

				String value5 = oldCplModel.getTenVietTat();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDiaChiDoanhNghiep",
						new Class[] { String.class });

				String value6 = oldCplModel.getDiaChiDoanhNghiep();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setDienThoaiDoanhNghiep",
						new Class[] { String.class });

				String value7 = oldCplModel.getDienThoaiDoanhNghiep();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setFax",
						new Class[] { String.class });

				String value8 = oldCplModel.getFax();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setEmailDoanhNghiep",
						new Class[] { String.class });

				String value9 = oldCplModel.getEmailDoanhNghiep();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setWebsite",
						new Class[] { String.class });

				String value10 = oldCplModel.getWebsite();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setTongSoVon",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getTongSoVon());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setMoTaNganhNgheKinhDoanh",
						new Class[] { String.class });

				String value12 = oldCplModel.getMoTaNganhNgheKinhDoanh();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setSoGCNDKKD",
						new Class[] { String.class });

				String value13 = oldCplModel.getSoGCNDKKD();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setNgayCapGCNDKKD",
						new Class[] { Date.class });

				Date value14 = oldCplModel.getNgayCapGCNDKKD();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setNoiLuuTruId",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getNoiLuuTruId());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setNgayDieuLeDuocThongQua",
						new Class[] { Date.class });

				Date value16 = oldCplModel.getNgayDieuLeDuocThongQua();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setTenChiNhanh",
						new Class[] { String.class });

				String value17 = oldCplModel.getTenChiNhanh();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setDiaChiChiNhanh",
						new Class[] { String.class });

				String value18 = oldCplModel.getDiaChiChiNhanh();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setTenVanPhongDaiDien",
						new Class[] { String.class });

				String value19 = oldCplModel.getTenVanPhongDaiDien();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setDiaChiVanPhongDaiDien",
						new Class[] { String.class });

				String value20 = oldCplModel.getDiaChiVanPhongDaiDien();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setNgayBatDauTamNgung",
						new Class[] { Date.class });

				Date value21 = oldCplModel.getNgayBatDauTamNgung();

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setNgayKetThucTamNgung",
						new Class[] { Date.class });

				Date value22 = oldCplModel.getNgayKetThucTamNgung();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setLyDoTamNgung",
						new Class[] { String.class });

				String value23 = oldCplModel.getLyDoTamNgung();

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setNgayChamDutHoatDongKD",
						new Class[] { Date.class });

				Date value24 = oldCplModel.getNgayChamDutHoatDongKD();

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setLoai",
						new Class[] { Long.TYPE });

				Long value25 = new Long(oldCplModel.getLoai());

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setDiaChiDoanhNghiepHuyenId",
						new Class[] { Long.TYPE });

				Long value26 = new Long(oldCplModel.getDiaChiDoanhNghiepHuyenId());

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setDiaChiDoanhNghiepTinhId",
						new Class[] { Long.TYPE });

				Long value27 = new Long(oldCplModel.getDiaChiDoanhNghiepTinhId());

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setDiaChiDoanhNghiepXaId",
						new Class[] { Long.TYPE });

				Long value28 = new Long(oldCplModel.getDiaChiDoanhNghiepXaId());

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setLoaiDoiTuongId",
						new Class[] { Long.TYPE });

				Long value29 = new Long(oldCplModel.getLoaiDoiTuongId());

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setNguoiDaiDienId",
						new Class[] { Long.TYPE });

				Long value30 = new Long(oldCplModel.getNguoiDaiDienId());

				method30.invoke(newModel, value30);

				Method method31 = newModelClass.getMethod("setTrangThaiDoanhNghiepId",
						new Class[] { Long.TYPE });

				Long value31 = new Long(oldCplModel.getTrangThaiDoanhNghiepId());

				method31.invoke(newModel, value31);

				Method method32 = newModelClass.getMethod("setVonDieuLe",
						new Class[] { Long.TYPE });

				Long value32 = new Long(oldCplModel.getVonDieuLe());

				method32.invoke(newModel, value32);

				Method method33 = newModelClass.getMethod("setVonToiThieuMotXaVien",
						new Class[] { Long.TYPE });

				Long value33 = new Long(oldCplModel.getVonToiThieuMotXaVien());

				method33.invoke(newModel, value33);

				Method method34 = newModelClass.getMethod("setGhiChu",
						new Class[] { String.class });

				String value34 = oldCplModel.getGhiChu();

				method34.invoke(newModel, value34);

				Method method35 = newModelClass.getMethod("setQuocGiaId",
						new Class[] { Long.TYPE });

				Long value35 = new Long(oldCplModel.getQuocGiaId());

				method35.invoke(newModel, value35);

				Method method36 = newModelClass.getMethod("setCoQuanCapId",
						new Class[] { Long.TYPE });

				Long value36 = new Long(oldCplModel.getCoQuanCapId());

				method36.invoke(newModel, value36);

				Method method37 = newModelClass.getMethod("setTenCoQuanCap",
						new Class[] { Long.TYPE });

				Long value37 = new Long(oldCplModel.getTenCoQuanCap());

				method37.invoke(newModel, value37);

				Method method38 = newModelClass.getMethod("setSoLanDieuChinh",
						new Class[] { String.class });

				String value38 = oldCplModel.getSoLanDieuChinh();

				method38.invoke(newModel, value38);

				Method method39 = newModelClass.getMethod("setNgayDieuChinh",
						new Class[] { Date.class });

				Date value39 = oldCplModel.getNgayDieuChinh();

				method39.invoke(newModel, value39);

				Method method40 = newModelClass.getMethod("setChucVuNguoiDaiDien",
						new Class[] { String.class });

				String value40 = oldCplModel.getChucVuNguoiDaiDien();

				method40.invoke(newModel, value40);

				Method method41 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value41 = oldCplModel.getNgayTao();

				method41.invoke(newModel, value41);

				Method method42 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value42 = new Integer(oldCplModel.getDaXoa());

				method42.invoke(newModel, value42);

				Method method43 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value43 = oldCplModel.getNgaySua();

				method43.invoke(newModel, value43);

				Method method44 = newModelClass.getMethod("setChaId",
						new Class[] { Long.TYPE });

				Long value44 = new Long(oldCplModel.getChaId());

				method44.invoke(newModel, value44);

				Method method45 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value45 = oldCplModel.getNguoiTao();

				method45.invoke(newModel, value45);

				Method method46 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value46 = oldCplModel.getNguoiSua();

				method46.invoke(newModel, value46);

				Method method47 = newModelClass.getMethod("setTaiKhoanNguoiDungId",
						new Class[] { Long.TYPE });

				Long value47 = new Long(oldCplModel.getTaiKhoanNguoiDungId());

				method47.invoke(newModel, value47);

				Method method48 = newModelClass.getMethod("setTenDiaDiemKinhDoanh",
						new Class[] { String.class });

				String value48 = oldCplModel.getTenDiaDiemKinhDoanh();

				method48.invoke(newModel, value48);

				Method method49 = newModelClass.getMethod("setNgayDangKyKinhDoanh",
						new Class[] { Date.class });

				Date value49 = oldCplModel.getNgayDangKyKinhDoanh();

				method49.invoke(newModel, value49);

				Method method50 = newModelClass.getMethod("setLoaiHinhDoanhNghiepId",
						new Class[] { Long.TYPE });

				Long value50 = new Long(oldCplModel.getLoaiHinhDoanhNghiepId());

				method50.invoke(newModel, value50);

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

	public static Object translateInputDoanhNghiep2NganhNghe(
		BaseModel<?> oldModel) {
		DoanhNghiep2NganhNgheClp oldCplModel = (DoanhNghiep2NganhNgheClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dn.model.impl.DoanhNghiep2NganhNgheImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setLaNganhChinh",
						new Class[] { Integer.TYPE });

				Integer value1 = new Integer(oldCplModel.getLaNganhChinh());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getNgayTao();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgaySua();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoiSua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getDaXoa());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setDoanhNghiepId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getDoanhNghiepId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNganhNgheId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getNganhNgheId());

				method8.invoke(newModel, value8);

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

	public static Object translateInputLoaiDoanhNghiep(BaseModel<?> oldModel) {
		LoaiDoanhNghiepClp oldCplModel = (LoaiDoanhNghiepClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dn.model.impl.LoaiDoanhNghiepImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setMa",
						new Class[] { String.class });

				String value1 = oldCplModel.getMa();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTen",
						new Class[] { String.class });

				String value2 = oldCplModel.getTen();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMoTa",
						new Class[] { String.class });

				String value3 = oldCplModel.getMoTa();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgaySua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiTao();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiSua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setPhienBan",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getPhienBan());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value9 = new Integer(oldCplModel.getDaXoa());

				method9.invoke(newModel, value9);

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

	public static Object translateInputNganhNgheKinhDoanh(BaseModel<?> oldModel) {
		NganhNgheKinhDoanhClp oldCplModel = (NganhNgheKinhDoanhClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dn.model.impl.NganhNgheKinhDoanhImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setMa",
						new Class[] { String.class });

				String value1 = oldCplModel.getMa();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTen",
						new Class[] { String.class });

				String value2 = oldCplModel.getTen();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setChaId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getChaId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getDaXoa());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiTao();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiSua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getNgaySua();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setCap",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getCap());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getPhienBan());

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

	public static Object translateInputTrangThaiDoanhNghiep(
		BaseModel<?> oldModel) {
		TrangThaiDoanhNghiepClp oldCplModel = (TrangThaiDoanhNghiepClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dn.model.impl.TrangThaiDoanhNghiepImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTen",
						new Class[] { String.class });

				String value1 = oldCplModel.getTen();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMoTa",
						new Class[] { String.class });

				String value2 = oldCplModel.getMoTa();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value3 = oldCplModel.getNguoiTao();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoiSua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgaySua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getDaXoa());

				method7.invoke(newModel, value7);

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

	public static Object translateInputYeuCauDangKyDN(BaseModel<?> oldModel) {
		YeuCauDangKyDNClp oldCplModel = (YeuCauDangKyDNClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dn.model.impl.YeuCauDangKyDNImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTen",
						new Class[] { String.class });

				String value1 = oldCplModel.getTen();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMaSoThue",
						new Class[] { String.class });

				String value2 = oldCplModel.getMaSoThue();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMaGiayPhep",
						new Class[] { String.class });

				String value3 = oldCplModel.getMaGiayPhep();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayCap",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayCap();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value5 = oldCplModel.getEmail();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setHoNguoiDaiDien",
						new Class[] { String.class });

				String value6 = oldCplModel.getHoNguoiDaiDien();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setTenDemNguoiDaiDien",
						new Class[] { String.class });

				String value7 = oldCplModel.getTenDemNguoiDaiDien();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setTenNguoiDaiDien",
						new Class[] { String.class });

				String value8 = oldCplModel.getTenNguoiDaiDien();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setSoCmnd",
						new Class[] { String.class });

				String value9 = oldCplModel.getSoCmnd();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNgayCapCmnd",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getNgayCapCmnd();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNoiCapCmndId",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getNoiCapCmndId());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setMoTa",
						new Class[] { String.class });

				String value12 = oldCplModel.getMoTa();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLoaiDoiTuongId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getLoaiDoiTuongId());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setTruSoTinhId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getTruSoTinhId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setTruSoHuyenId",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getTruSoHuyenId());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setTruSoXaId",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getTruSoXaId());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setTruSo",
						new Class[] { String.class });

				String value17 = oldCplModel.getTruSo();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value18 = new Integer(oldCplModel.getDaXoa());

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value19 = oldCplModel.getNgayTao();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value20 = oldCplModel.getNguoiTao();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value21 = oldCplModel.getNgaySua();

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value22 = oldCplModel.getNguoiSua();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value23 = new Integer(oldCplModel.getTrangThai());

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setLoaiHinhDoanhNghiepId",
						new Class[] { Long.TYPE });

				Long value24 = new Long(oldCplModel.getLoaiHinhDoanhNghiepId());

				method24.invoke(newModel, value24);

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

	public static Object translateInputYeuCauDangKyDoanhNghiep(
		BaseModel<?> oldModel) {
		YeuCauDangKyDoanhNghiepClp oldCplModel = (YeuCauDangKyDoanhNghiepClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dn.model.impl.YeuCauDangKyDoanhNghiepImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setLoaiDoiTuongId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getLoaiDoiTuongId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTen",
						new Class[] { String.class });

				String value2 = oldCplModel.getTen();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMaSoThue",
						new Class[] { String.class });

				String value3 = oldCplModel.getMaSoThue();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setMaGiayPhep",
						new Class[] { String.class });

				String value4 = oldCplModel.getMaGiayPhep();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgayCap",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgayCap();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value6 = oldCplModel.getEmail();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setHoNguoiDaiDien",
						new Class[] { String.class });

				String value7 = oldCplModel.getHoNguoiDaiDien();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setTenDemNguoiDaiDien",
						new Class[] { String.class });

				String value8 = oldCplModel.getTenDemNguoiDaiDien();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setTenNguoiDaiDien",
						new Class[] { String.class });

				String value9 = oldCplModel.getTenNguoiDaiDien();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setSoCMND",
						new Class[] { String.class });

				String value10 = oldCplModel.getSoCMND();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNgayCapCMND",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getNgayCapCMND();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setNoiCapCMND",
						new Class[] { String.class });

				String value12 = oldCplModel.getNoiCapCMND();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setMoTaNganhNgheKinhDoanh",
						new Class[] { String.class });

				String value13 = oldCplModel.getMoTaNganhNgheKinhDoanh();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setLoaiHinhDoanhNghiep",
						new Class[] { String.class });

				String value14 = oldCplModel.getLoaiHinhDoanhNghiep();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setTruSo",
						new Class[] { String.class });

				String value15 = oldCplModel.getTruSo();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setTruSoXaId",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getTruSoXaId());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setTruSoHuyenId",
						new Class[] { Long.TYPE });

				Long value17 = new Long(oldCplModel.getTruSoHuyenId());

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setTruSoTinhId",
						new Class[] { Long.TYPE });

				Long value18 = new Long(oldCplModel.getTruSoTinhId());

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value19 = new Integer(oldCplModel.getTrangThai());

				method19.invoke(newModel, value19);

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
					"org.oep.cmon.dao.dn.model.impl.DoanhNghiepImpl")) {
			return translateOutputDoanhNghiep(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dn.model.impl.DoanhNghiep2NganhNgheImpl")) {
			return translateOutputDoanhNghiep2NganhNghe(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dn.model.impl.LoaiDoanhNghiepImpl")) {
			return translateOutputLoaiDoanhNghiep(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dn.model.impl.NganhNgheKinhDoanhImpl")) {
			return translateOutputNganhNgheKinhDoanh(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dn.model.impl.TrangThaiDoanhNghiepImpl")) {
			return translateOutputTrangThaiDoanhNghiep(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dn.model.impl.YeuCauDangKyDNImpl")) {
			return translateOutputYeuCauDangKyDN(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dn.model.impl.YeuCauDangKyDoanhNghiepImpl")) {
			return translateOutputYeuCauDangKyDoanhNghiep(oldModel);
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

	public static Object translateOutputDoanhNghiep(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DoanhNghiepClp newModel = new DoanhNghiepClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getMa");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setMa(value1);

				Method method2 = oldModelClass.getMethod("getTen");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTen(value2);

				Method method3 = oldModelClass.getMethod("getMaSoThue");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMaSoThue(value3);

				Method method4 = oldModelClass.getMethod("getTenTiengNuocNgoai");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setTenTiengNuocNgoai(value4);

				Method method5 = oldModelClass.getMethod("getTenVietTat");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setTenVietTat(value5);

				Method method6 = oldModelClass.getMethod("getDiaChiDoanhNghiep");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setDiaChiDoanhNghiep(value6);

				Method method7 = oldModelClass.getMethod(
						"getDienThoaiDoanhNghiep");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setDienThoaiDoanhNghiep(value7);

				Method method8 = oldModelClass.getMethod("getFax");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setFax(value8);

				Method method9 = oldModelClass.getMethod("getEmailDoanhNghiep");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setEmailDoanhNghiep(value9);

				Method method10 = oldModelClass.getMethod("getWebsite");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setWebsite(value10);

				Method method11 = oldModelClass.getMethod("getTongSoVon");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setTongSoVon(value11);

				Method method12 = oldModelClass.getMethod(
						"getMoTaNganhNgheKinhDoanh");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setMoTaNganhNgheKinhDoanh(value12);

				Method method13 = oldModelClass.getMethod("getSoGCNDKKD");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setSoGCNDKKD(value13);

				Method method14 = oldModelClass.getMethod("getNgayCapGCNDKKD");

				Date value14 = (Date)method14.invoke(oldModel, (Object[])null);

				newModel.setNgayCapGCNDKKD(value14);

				Method method15 = oldModelClass.getMethod("getNoiLuuTruId");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setNoiLuuTruId(value15);

				Method method16 = oldModelClass.getMethod(
						"getNgayDieuLeDuocThongQua");

				Date value16 = (Date)method16.invoke(oldModel, (Object[])null);

				newModel.setNgayDieuLeDuocThongQua(value16);

				Method method17 = oldModelClass.getMethod("getTenChiNhanh");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setTenChiNhanh(value17);

				Method method18 = oldModelClass.getMethod("getDiaChiChiNhanh");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiChiNhanh(value18);

				Method method19 = oldModelClass.getMethod(
						"getTenVanPhongDaiDien");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setTenVanPhongDaiDien(value19);

				Method method20 = oldModelClass.getMethod(
						"getDiaChiVanPhongDaiDien");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiVanPhongDaiDien(value20);

				Method method21 = oldModelClass.getMethod(
						"getNgayBatDauTamNgung");

				Date value21 = (Date)method21.invoke(oldModel, (Object[])null);

				newModel.setNgayBatDauTamNgung(value21);

				Method method22 = oldModelClass.getMethod(
						"getNgayKetThucTamNgung");

				Date value22 = (Date)method22.invoke(oldModel, (Object[])null);

				newModel.setNgayKetThucTamNgung(value22);

				Method method23 = oldModelClass.getMethod("getLyDoTamNgung");

				String value23 = (String)method23.invoke(oldModel,
						(Object[])null);

				newModel.setLyDoTamNgung(value23);

				Method method24 = oldModelClass.getMethod(
						"getNgayChamDutHoatDongKD");

				Date value24 = (Date)method24.invoke(oldModel, (Object[])null);

				newModel.setNgayChamDutHoatDongKD(value24);

				Method method25 = oldModelClass.getMethod("getLoai");

				Long value25 = (Long)method25.invoke(oldModel, (Object[])null);

				newModel.setLoai(value25);

				Method method26 = oldModelClass.getMethod(
						"getDiaChiDoanhNghiepHuyenId");

				Long value26 = (Long)method26.invoke(oldModel, (Object[])null);

				newModel.setDiaChiDoanhNghiepHuyenId(value26);

				Method method27 = oldModelClass.getMethod(
						"getDiaChiDoanhNghiepTinhId");

				Long value27 = (Long)method27.invoke(oldModel, (Object[])null);

				newModel.setDiaChiDoanhNghiepTinhId(value27);

				Method method28 = oldModelClass.getMethod(
						"getDiaChiDoanhNghiepXaId");

				Long value28 = (Long)method28.invoke(oldModel, (Object[])null);

				newModel.setDiaChiDoanhNghiepXaId(value28);

				Method method29 = oldModelClass.getMethod("getLoaiDoiTuongId");

				Long value29 = (Long)method29.invoke(oldModel, (Object[])null);

				newModel.setLoaiDoiTuongId(value29);

				Method method30 = oldModelClass.getMethod("getNguoiDaiDienId");

				Long value30 = (Long)method30.invoke(oldModel, (Object[])null);

				newModel.setNguoiDaiDienId(value30);

				Method method31 = oldModelClass.getMethod(
						"getTrangThaiDoanhNghiepId");

				Long value31 = (Long)method31.invoke(oldModel, (Object[])null);

				newModel.setTrangThaiDoanhNghiepId(value31);

				Method method32 = oldModelClass.getMethod("getVonDieuLe");

				Long value32 = (Long)method32.invoke(oldModel, (Object[])null);

				newModel.setVonDieuLe(value32);

				Method method33 = oldModelClass.getMethod(
						"getVonToiThieuMotXaVien");

				Long value33 = (Long)method33.invoke(oldModel, (Object[])null);

				newModel.setVonToiThieuMotXaVien(value33);

				Method method34 = oldModelClass.getMethod("getGhiChu");

				String value34 = (String)method34.invoke(oldModel,
						(Object[])null);

				newModel.setGhiChu(value34);

				Method method35 = oldModelClass.getMethod("getQuocGiaId");

				Long value35 = (Long)method35.invoke(oldModel, (Object[])null);

				newModel.setQuocGiaId(value35);

				Method method36 = oldModelClass.getMethod("getCoQuanCapId");

				Long value36 = (Long)method36.invoke(oldModel, (Object[])null);

				newModel.setCoQuanCapId(value36);

				Method method37 = oldModelClass.getMethod("getTenCoQuanCap");

				Long value37 = (Long)method37.invoke(oldModel, (Object[])null);

				newModel.setTenCoQuanCap(value37);

				Method method38 = oldModelClass.getMethod("getSoLanDieuChinh");

				String value38 = (String)method38.invoke(oldModel,
						(Object[])null);

				newModel.setSoLanDieuChinh(value38);

				Method method39 = oldModelClass.getMethod("getNgayDieuChinh");

				Date value39 = (Date)method39.invoke(oldModel, (Object[])null);

				newModel.setNgayDieuChinh(value39);

				Method method40 = oldModelClass.getMethod(
						"getChucVuNguoiDaiDien");

				String value40 = (String)method40.invoke(oldModel,
						(Object[])null);

				newModel.setChucVuNguoiDaiDien(value40);

				Method method41 = oldModelClass.getMethod("getNgayTao");

				Date value41 = (Date)method41.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value41);

				Method method42 = oldModelClass.getMethod("getDaXoa");

				Integer value42 = (Integer)method42.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value42);

				Method method43 = oldModelClass.getMethod("getNgaySua");

				Date value43 = (Date)method43.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value43);

				Method method44 = oldModelClass.getMethod("getChaId");

				Long value44 = (Long)method44.invoke(oldModel, (Object[])null);

				newModel.setChaId(value44);

				Method method45 = oldModelClass.getMethod("getNguoiTao");

				String value45 = (String)method45.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value45);

				Method method46 = oldModelClass.getMethod("getNguoiSua");

				String value46 = (String)method46.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value46);

				Method method47 = oldModelClass.getMethod(
						"getTaiKhoanNguoiDungId");

				Long value47 = (Long)method47.invoke(oldModel, (Object[])null);

				newModel.setTaiKhoanNguoiDungId(value47);

				Method method48 = oldModelClass.getMethod(
						"getTenDiaDiemKinhDoanh");

				String value48 = (String)method48.invoke(oldModel,
						(Object[])null);

				newModel.setTenDiaDiemKinhDoanh(value48);

				Method method49 = oldModelClass.getMethod(
						"getNgayDangKyKinhDoanh");

				Date value49 = (Date)method49.invoke(oldModel, (Object[])null);

				newModel.setNgayDangKyKinhDoanh(value49);

				Method method50 = oldModelClass.getMethod(
						"getLoaiHinhDoanhNghiepId");

				Long value50 = (Long)method50.invoke(oldModel, (Object[])null);

				newModel.setLoaiHinhDoanhNghiepId(value50);

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

	public static Object translateOutputDoanhNghiep2NganhNghe(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DoanhNghiep2NganhNgheClp newModel = new DoanhNghiep2NganhNgheClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getLaNganhChinh");

				Integer value1 = (Integer)method1.invoke(oldModel,
						(Object[])null);

				newModel.setLaNganhChinh(value1);

				Method method2 = oldModelClass.getMethod("getNgayTao");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value2);

				Method method3 = oldModelClass.getMethod("getNgaySua");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value3);

				Method method4 = oldModelClass.getMethod("getNguoiTao");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value4);

				Method method5 = oldModelClass.getMethod("getNguoiSua");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value5);

				Method method6 = oldModelClass.getMethod("getDaXoa");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value6);

				Method method7 = oldModelClass.getMethod("getDoanhNghiepId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setDoanhNghiepId(value7);

				Method method8 = oldModelClass.getMethod("getNganhNgheId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setNganhNgheId(value8);

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

	public static Object translateOutputLoaiDoanhNghiep(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LoaiDoanhNghiepClp newModel = new LoaiDoanhNghiepClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getMa");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setMa(value1);

				Method method2 = oldModelClass.getMethod("getTen");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTen(value2);

				Method method3 = oldModelClass.getMethod("getMoTa");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMoTa(value3);

				Method method4 = oldModelClass.getMethod("getNgayTao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value4);

				Method method5 = oldModelClass.getMethod("getNgaySua");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value5);

				Method method6 = oldModelClass.getMethod("getNguoiTao");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value6);

				Method method7 = oldModelClass.getMethod("getNguoiSua");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value7);

				Method method8 = oldModelClass.getMethod("getPhienBan");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setPhienBan(value8);

				Method method9 = oldModelClass.getMethod("getDaXoa");

				Integer value9 = (Integer)method9.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value9);

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

	public static Object translateOutputNganhNgheKinhDoanh(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				NganhNgheKinhDoanhClp newModel = new NganhNgheKinhDoanhClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getMa");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setMa(value1);

				Method method2 = oldModelClass.getMethod("getTen");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTen(value2);

				Method method3 = oldModelClass.getMethod("getChaId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setChaId(value3);

				Method method4 = oldModelClass.getMethod("getNgayTao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value4);

				Method method5 = oldModelClass.getMethod("getDaXoa");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value5);

				Method method6 = oldModelClass.getMethod("getNguoiTao");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value6);

				Method method7 = oldModelClass.getMethod("getNguoiSua");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value7);

				Method method8 = oldModelClass.getMethod("getNgaySua");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value8);

				Method method9 = oldModelClass.getMethod("getCap");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setCap(value9);

				Method method10 = oldModelClass.getMethod("getPhienBan");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value10);

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

	public static Object translateOutputTrangThaiDoanhNghiep(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TrangThaiDoanhNghiepClp newModel = new TrangThaiDoanhNghiepClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTen");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTen(value1);

				Method method2 = oldModelClass.getMethod("getMoTa");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMoTa(value2);

				Method method3 = oldModelClass.getMethod("getNguoiTao");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value3);

				Method method4 = oldModelClass.getMethod("getNgayTao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value4);

				Method method5 = oldModelClass.getMethod("getNguoiSua");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value5);

				Method method6 = oldModelClass.getMethod("getNgaySua");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value6);

				Method method7 = oldModelClass.getMethod("getDaXoa");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value7);

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

	public static Object translateOutputYeuCauDangKyDN(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				YeuCauDangKyDNClp newModel = new YeuCauDangKyDNClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTen");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTen(value1);

				Method method2 = oldModelClass.getMethod("getMaSoThue");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMaSoThue(value2);

				Method method3 = oldModelClass.getMethod("getMaGiayPhep");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMaGiayPhep(value3);

				Method method4 = oldModelClass.getMethod("getNgayCap");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayCap(value4);

				Method method5 = oldModelClass.getMethod("getEmail");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setEmail(value5);

				Method method6 = oldModelClass.getMethod("getHoNguoiDaiDien");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setHoNguoiDaiDien(value6);

				Method method7 = oldModelClass.getMethod(
						"getTenDemNguoiDaiDien");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setTenDemNguoiDaiDien(value7);

				Method method8 = oldModelClass.getMethod("getTenNguoiDaiDien");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setTenNguoiDaiDien(value8);

				Method method9 = oldModelClass.getMethod("getSoCmnd");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setSoCmnd(value9);

				Method method10 = oldModelClass.getMethod("getNgayCapCmnd");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setNgayCapCmnd(value10);

				Method method11 = oldModelClass.getMethod("getNoiCapCmndId");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setNoiCapCmndId(value11);

				Method method12 = oldModelClass.getMethod("getMoTa");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setMoTa(value12);

				Method method13 = oldModelClass.getMethod("getLoaiDoiTuongId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setLoaiDoiTuongId(value13);

				Method method14 = oldModelClass.getMethod("getTruSoTinhId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setTruSoTinhId(value14);

				Method method15 = oldModelClass.getMethod("getTruSoHuyenId");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setTruSoHuyenId(value15);

				Method method16 = oldModelClass.getMethod("getTruSoXaId");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setTruSoXaId(value16);

				Method method17 = oldModelClass.getMethod("getTruSo");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setTruSo(value17);

				Method method18 = oldModelClass.getMethod("getDaXoa");

				Integer value18 = (Integer)method18.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value18);

				Method method19 = oldModelClass.getMethod("getNgayTao");

				Date value19 = (Date)method19.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value19);

				Method method20 = oldModelClass.getMethod("getNguoiTao");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value20);

				Method method21 = oldModelClass.getMethod("getNgaySua");

				Date value21 = (Date)method21.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value21);

				Method method22 = oldModelClass.getMethod("getNguoiSua");

				String value22 = (String)method22.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value22);

				Method method23 = oldModelClass.getMethod("getTrangThai");

				Integer value23 = (Integer)method23.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value23);

				Method method24 = oldModelClass.getMethod(
						"getLoaiHinhDoanhNghiepId");

				Long value24 = (Long)method24.invoke(oldModel, (Object[])null);

				newModel.setLoaiHinhDoanhNghiepId(value24);

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

	public static Object translateOutputYeuCauDangKyDoanhNghiep(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				YeuCauDangKyDoanhNghiepClp newModel = new YeuCauDangKyDoanhNghiepClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getLoaiDoiTuongId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setLoaiDoiTuongId(value1);

				Method method2 = oldModelClass.getMethod("getTen");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTen(value2);

				Method method3 = oldModelClass.getMethod("getMaSoThue");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMaSoThue(value3);

				Method method4 = oldModelClass.getMethod("getMaGiayPhep");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setMaGiayPhep(value4);

				Method method5 = oldModelClass.getMethod("getNgayCap");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgayCap(value5);

				Method method6 = oldModelClass.getMethod("getEmail");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setEmail(value6);

				Method method7 = oldModelClass.getMethod("getHoNguoiDaiDien");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setHoNguoiDaiDien(value7);

				Method method8 = oldModelClass.getMethod(
						"getTenDemNguoiDaiDien");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setTenDemNguoiDaiDien(value8);

				Method method9 = oldModelClass.getMethod("getTenNguoiDaiDien");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setTenNguoiDaiDien(value9);

				Method method10 = oldModelClass.getMethod("getSoCMND");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setSoCMND(value10);

				Method method11 = oldModelClass.getMethod("getNgayCapCMND");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setNgayCapCMND(value11);

				Method method12 = oldModelClass.getMethod("getNoiCapCMND");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setNoiCapCMND(value12);

				Method method13 = oldModelClass.getMethod(
						"getMoTaNganhNgheKinhDoanh");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setMoTaNganhNgheKinhDoanh(value13);

				Method method14 = oldModelClass.getMethod(
						"getLoaiHinhDoanhNghiep");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setLoaiHinhDoanhNghiep(value14);

				Method method15 = oldModelClass.getMethod("getTruSo");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setTruSo(value15);

				Method method16 = oldModelClass.getMethod("getTruSoXaId");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setTruSoXaId(value16);

				Method method17 = oldModelClass.getMethod("getTruSoHuyenId");

				Long value17 = (Long)method17.invoke(oldModel, (Object[])null);

				newModel.setTruSoHuyenId(value17);

				Method method18 = oldModelClass.getMethod("getTruSoTinhId");

				Long value18 = (Long)method18.invoke(oldModel, (Object[])null);

				newModel.setTruSoTinhId(value18);

				Method method19 = oldModelClass.getMethod("getTrangThai");

				Integer value19 = (Integer)method19.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value19);

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