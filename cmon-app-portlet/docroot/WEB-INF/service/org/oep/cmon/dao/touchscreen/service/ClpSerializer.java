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

package org.oep.cmon.dao.touchscreen.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.touchscreen.model.TouchScreenClp;
import org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCongClp;
import org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinhClp;

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

		if (oldModelClassName.equals(TouchScreenClp.class.getName())) {
			return translateInputTouchScreen(oldModel);
		}

		if (oldModelClassName.equals(TraCuuHoSoTTHCCongClp.class.getName())) {
			return translateInputTraCuuHoSoTTHCCong(oldModel);
		}

		if (oldModelClassName.equals(TraCuuThuTucHanhChinhClp.class.getName())) {
			return translateInputTraCuuThuTucHanhChinh(oldModel);
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

	public static Object translateInputTouchScreen(BaseModel<?> oldModel) {
		TouchScreenClp oldCplModel = (TouchScreenClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.touchscreen.model.impl.TouchScreenImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNAME",
						new Class[] { String.class });

				String value1 = oldCplModel.getNAME();

				method1.invoke(newModel, value1);

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

	public static Object translateInputTraCuuHoSoTTHCCong(BaseModel<?> oldModel) {
		TraCuuHoSoTTHCCongClp oldCplModel = (TraCuuHoSoTTHCCongClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.touchscreen.model.impl.TraCuuHoSoTTHCCongImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNgayNhanHoSo",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getNgayNhanHoSo();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTenCoQuanTiepNhan",
						new Class[] { String.class });

				String value2 = oldCplModel.getTenCoQuanTiepNhan();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTenThuTucHanhChinh",
						new Class[] { String.class });

				String value3 = oldCplModel.getTenThuTucHanhChinh();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayHenTraKetQua",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayHenTraKetQua();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgayTraKetQua",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgayTraKetQua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setHoTenNguoiNopHoSo",
						new Class[] { String.class });

				String value6 = oldCplModel.getHoTenNguoiNopHoSo();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setDiaChiThuongTruNguoiNop",
						new Class[] { String.class });

				String value7 = oldCplModel.getDiaChiThuongTruNguoiNop();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setSoDienThoaiDiDongNguoiNop",
						new Class[] { String.class });

				String value8 = oldCplModel.getSoDienThoaiDiDongNguoiNop();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgayKetThucXuLy",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgayKetThucXuLy();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setLoaiHoSo",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getLoaiHoSo());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setMaSoBienNhan",
						new Class[] { String.class });

				String value11 = oldCplModel.getMaSoBienNhan();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setChuSoHuu",
						new Class[] { String.class });

				String value12 = oldCplModel.getChuSoHuu();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLePhi",
						new Class[] { Integer.TYPE });

				Integer value13 = new Integer(oldCplModel.getLePhi());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setPhiHoSo",
						new Class[] { Integer.TYPE });

				Integer value14 = new Integer(oldCplModel.getPhiHoSo());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setEmailNguoiNop",
						new Class[] { String.class });

				String value15 = oldCplModel.getEmailNguoiNop();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setSoDienThoaiCoDinhNguoiNop",
						new Class[] { String.class });

				String value16 = oldCplModel.getSoDienThoaiCoDinhNguoiNop();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setNhomThuTucHanhChinhTen",
						new Class[] { String.class });

				String value17 = oldCplModel.getNhomThuTucHanhChinhTen();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setTrangThaiHoSoTen",
						new Class[] { String.class });

				String value18 = oldCplModel.getTrangThaiHoSoTen();

				method18.invoke(newModel, value18);

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

	public static Object translateInputTraCuuThuTucHanhChinh(
		BaseModel<?> oldModel) {
		TraCuuThuTucHanhChinhClp oldCplModel = (TraCuuThuTucHanhChinhClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.touchscreen.model.impl.TraCuuThuTucHanhChinhImpl",
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

				Method method3 = newModelClass.getMethod("setSoNgayXuLy",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getSoNgayXuLy());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgaySua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getDaXoa());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value8 = oldCplModel.getNguoiSua();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNhomThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getNhomThuTucHanhChinhId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNhomThuTucHanhChinhTen",
						new Class[] { String.class });

				String value10 = oldCplModel.getNhomThuTucHanhChinhTen();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value11 = new Integer(oldCplModel.getTrangThai());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getPhienBan());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setCanTichHop",
						new Class[] { Integer.TYPE });

				Integer value13 = new Integer(oldCplModel.getCanTichHop());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setTrinhTuThucHien",
						new Class[] { String.class });

				String value14 = oldCplModel.getTrinhTuThucHien();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setCachThucHien",
						new Class[] { String.class });

				String value15 = oldCplModel.getCachThucHien();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setThanhPhanHoSo",
						new Class[] { String.class });

				String value16 = oldCplModel.getThanhPhanHoSo();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setLePhi",
						new Class[] { Long.TYPE });

				Long value17 = new Long(oldCplModel.getLePhi());

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setDonViLePhi",
						new Class[] { String.class });

				String value18 = oldCplModel.getDonViLePhi();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setPhi",
						new Class[] { Long.TYPE });

				Long value19 = new Long(oldCplModel.getPhi());

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setDonViPhi",
						new Class[] { String.class });

				String value20 = oldCplModel.getDonViPhi();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setTenMauDonToKhai",
						new Class[] { String.class });

				String value21 = oldCplModel.getTenMauDonToKhai();

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setYeuCauDieuKienThucHien",
						new Class[] { String.class });

				String value22 = oldCplModel.getYeuCauDieuKienThucHien();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setCanCuPhapLy",
						new Class[] { String.class });

				String value23 = oldCplModel.getCanCuPhapLy();

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setCapCoQuanQuanLyId",
						new Class[] { Long.TYPE });

				Long value24 = new Long(oldCplModel.getCapCoQuanQuanLyId());

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setLinhVucThucHien",
						new Class[] { String.class });

				String value25 = oldCplModel.getLinhVucThucHien();

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setMaDNG",
						new Class[] { String.class });

				String value26 = oldCplModel.getMaDNG();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setUengineProcessName",
						new Class[] { String.class });

				String value27 = oldCplModel.getUengineProcessName();

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setThuTucLienThongId",
						new Class[] { Long.TYPE });

				Long value28 = new Long(oldCplModel.getThuTucLienThongId());

				method28.invoke(newModel, value28);

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
					"org.oep.cmon.dao.touchscreen.model.impl.TouchScreenImpl")) {
			return translateOutputTouchScreen(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.touchscreen.model.impl.TraCuuHoSoTTHCCongImpl")) {
			return translateOutputTraCuuHoSoTTHCCong(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.touchscreen.model.impl.TraCuuThuTucHanhChinhImpl")) {
			return translateOutputTraCuuThuTucHanhChinh(oldModel);
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

	public static Object translateOutputTouchScreen(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TouchScreenClp newModel = new TouchScreenClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getNAME");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setNAME(value1);

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

	public static Object translateOutputTraCuuHoSoTTHCCong(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TraCuuHoSoTTHCCongClp newModel = new TraCuuHoSoTTHCCongClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNgayNhanHoSo");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setNgayNhanHoSo(value1);

				Method method2 = oldModelClass.getMethod("getTenCoQuanTiepNhan");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTenCoQuanTiepNhan(value2);

				Method method3 = oldModelClass.getMethod(
						"getTenThuTucHanhChinh");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setTenThuTucHanhChinh(value3);

				Method method4 = oldModelClass.getMethod("getNgayHenTraKetQua");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayHenTraKetQua(value4);

				Method method5 = oldModelClass.getMethod("getNgayTraKetQua");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgayTraKetQua(value5);

				Method method6 = oldModelClass.getMethod("getHoTenNguoiNopHoSo");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setHoTenNguoiNopHoSo(value6);

				Method method7 = oldModelClass.getMethod(
						"getDiaChiThuongTruNguoiNop");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setDiaChiThuongTruNguoiNop(value7);

				Method method8 = oldModelClass.getMethod(
						"getSoDienThoaiDiDongNguoiNop");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setSoDienThoaiDiDongNguoiNop(value8);

				Method method9 = oldModelClass.getMethod("getNgayKetThucXuLy");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgayKetThucXuLy(value9);

				Method method10 = oldModelClass.getMethod("getLoaiHoSo");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setLoaiHoSo(value10);

				Method method11 = oldModelClass.getMethod("getMaSoBienNhan");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setMaSoBienNhan(value11);

				Method method12 = oldModelClass.getMethod("getChuSoHuu");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setChuSoHuu(value12);

				Method method13 = oldModelClass.getMethod("getLePhi");

				Integer value13 = (Integer)method13.invoke(oldModel,
						(Object[])null);

				newModel.setLePhi(value13);

				Method method14 = oldModelClass.getMethod("getPhiHoSo");

				Integer value14 = (Integer)method14.invoke(oldModel,
						(Object[])null);

				newModel.setPhiHoSo(value14);

				Method method15 = oldModelClass.getMethod("getEmailNguoiNop");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setEmailNguoiNop(value15);

				Method method16 = oldModelClass.getMethod(
						"getSoDienThoaiCoDinhNguoiNop");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setSoDienThoaiCoDinhNguoiNop(value16);

				Method method17 = oldModelClass.getMethod(
						"getNhomThuTucHanhChinhTen");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setNhomThuTucHanhChinhTen(value17);

				Method method18 = oldModelClass.getMethod("getTrangThaiHoSoTen");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiHoSoTen(value18);

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

	public static Object translateOutputTraCuuThuTucHanhChinh(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TraCuuThuTucHanhChinhClp newModel = new TraCuuThuTucHanhChinhClp();

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

				Method method3 = oldModelClass.getMethod("getSoNgayXuLy");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setSoNgayXuLy(value3);

				Method method4 = oldModelClass.getMethod("getNgayTao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value4);

				Method method5 = oldModelClass.getMethod("getNgaySua");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value5);

				Method method6 = oldModelClass.getMethod("getDaXoa");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value6);

				Method method7 = oldModelClass.getMethod("getNguoiTao");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value7);

				Method method8 = oldModelClass.getMethod("getNguoiSua");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value8);

				Method method9 = oldModelClass.getMethod(
						"getNhomThuTucHanhChinhId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setNhomThuTucHanhChinhId(value9);

				Method method10 = oldModelClass.getMethod(
						"getNhomThuTucHanhChinhTen");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNhomThuTucHanhChinhTen(value10);

				Method method11 = oldModelClass.getMethod("getTrangThai");

				Integer value11 = (Integer)method11.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value11);

				Method method12 = oldModelClass.getMethod("getPhienBan");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value12);

				Method method13 = oldModelClass.getMethod("getCanTichHop");

				Integer value13 = (Integer)method13.invoke(oldModel,
						(Object[])null);

				newModel.setCanTichHop(value13);

				Method method14 = oldModelClass.getMethod("getTrinhTuThucHien");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setTrinhTuThucHien(value14);

				Method method15 = oldModelClass.getMethod("getCachThucHien");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setCachThucHien(value15);

				Method method16 = oldModelClass.getMethod("getThanhPhanHoSo");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setThanhPhanHoSo(value16);

				Method method17 = oldModelClass.getMethod("getLePhi");

				Long value17 = (Long)method17.invoke(oldModel, (Object[])null);

				newModel.setLePhi(value17);

				Method method18 = oldModelClass.getMethod("getDonViLePhi");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setDonViLePhi(value18);

				Method method19 = oldModelClass.getMethod("getPhi");

				Long value19 = (Long)method19.invoke(oldModel, (Object[])null);

				newModel.setPhi(value19);

				Method method20 = oldModelClass.getMethod("getDonViPhi");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setDonViPhi(value20);

				Method method21 = oldModelClass.getMethod("getTenMauDonToKhai");

				String value21 = (String)method21.invoke(oldModel,
						(Object[])null);

				newModel.setTenMauDonToKhai(value21);

				Method method22 = oldModelClass.getMethod(
						"getYeuCauDieuKienThucHien");

				String value22 = (String)method22.invoke(oldModel,
						(Object[])null);

				newModel.setYeuCauDieuKienThucHien(value22);

				Method method23 = oldModelClass.getMethod("getCanCuPhapLy");

				String value23 = (String)method23.invoke(oldModel,
						(Object[])null);

				newModel.setCanCuPhapLy(value23);

				Method method24 = oldModelClass.getMethod(
						"getCapCoQuanQuanLyId");

				Long value24 = (Long)method24.invoke(oldModel, (Object[])null);

				newModel.setCapCoQuanQuanLyId(value24);

				Method method25 = oldModelClass.getMethod("getLinhVucThucHien");

				String value25 = (String)method25.invoke(oldModel,
						(Object[])null);

				newModel.setLinhVucThucHien(value25);

				Method method26 = oldModelClass.getMethod("getMaDNG");

				String value26 = (String)method26.invoke(oldModel,
						(Object[])null);

				newModel.setMaDNG(value26);

				Method method27 = oldModelClass.getMethod(
						"getUengineProcessName");

				String value27 = (String)method27.invoke(oldModel,
						(Object[])null);

				newModel.setUengineProcessName(value27);

				Method method28 = oldModelClass.getMethod(
						"getThuTucLienThongId");

				Long value28 = (Long)method28.invoke(oldModel, (Object[])null);

				newModel.setThuTucLienThongId(value28);

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