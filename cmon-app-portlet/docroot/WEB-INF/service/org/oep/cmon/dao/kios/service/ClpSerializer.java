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

package org.oep.cmon.dao.kios.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.kios.model.DanhSachCoQuanClp;
import org.oep.cmon.dao.kios.model.DanhSachHoSoClp;
import org.oep.cmon.dao.kios.model.DanhSachThongKeClp;

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

		if (oldModelClassName.equals(DanhSachCoQuanClp.class.getName())) {
			return translateInputDanhSachCoQuan(oldModel);
		}

		if (oldModelClassName.equals(DanhSachHoSoClp.class.getName())) {
			return translateInputDanhSachHoSo(oldModel);
		}

		if (oldModelClassName.equals(DanhSachThongKeClp.class.getName())) {
			return translateInputDanhSachThongKe(oldModel);
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

	public static Object translateInputDanhSachCoQuan(BaseModel<?> oldModel) {
		DanhSachCoQuanClp oldCplModel = (DanhSachCoQuanClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.kios.model.impl.DanhSachCoQuanImpl",
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

				Method method2 = newModelClass.getMethod("setChaId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getChaId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTenCapCoQuanQuanly",
						new Class[] { String.class });

				String value3 = oldCplModel.getTenCapCoQuanQuanly();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCapCoQuanQuanLyId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getCapCoQuanQuanLyId());

				method4.invoke(newModel, value4);

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

	public static Object translateInputDanhSachHoSo(BaseModel<?> oldModel) {
		DanhSachHoSoClp oldCplModel = (DanhSachHoSoClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.kios.model.impl.DanhSachHoSoImpl",
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

				Method method19 = newModelClass.getMethod("setRNum",
						new Class[] { Integer.TYPE });

				Integer value19 = new Integer(oldCplModel.getRNum());

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

	public static Object translateInputDanhSachThongKe(BaseModel<?> oldModel) {
		DanhSachThongKeClp oldCplModel = (DanhSachThongKeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.kios.model.impl.DanhSachThongKeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCAPCOQUANQUANLYID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getCAPCOQUANQUANLYID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCOQUANQUANLYID",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCOQUANQUANLYID());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTHANG",
						new Class[] { Integer.TYPE });

				Integer value2 = new Integer(oldCplModel.getTHANG());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNAM",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getNAM());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTONGNHAN",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getTONGNHAN());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTIEPNHAN",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getTIEPNHAN());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setTONDAU",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getTONDAU());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setTONGDAGIAIQUYET",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getTONGDAGIAIQUYET());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setSOM",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getSOM());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setDUNG",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getDUNG());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setTRE",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getTRE());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setTONGDANGGIAIQUYET",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getTONGDANGGIAIQUYET());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setCHUADENHAN",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getCHUADENHAN());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setQUAHAN",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getQUAHAN());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setRUTHOSO",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getRUTHOSO());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setKHONGHOPLE",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getKHONGHOPLE());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setTYLE",
						new Class[] { Double.TYPE });

				Double value16 = new Double(oldCplModel.getTYLE());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setTONCUOI",
						new Class[] { Long.TYPE });

				Long value17 = new Long(oldCplModel.getTONCUOI());

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setTENCAPCOQUANQUANLY",
						new Class[] { String.class });

				String value18 = oldCplModel.getTENCAPCOQUANQUANLY();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setTENCOQUANQUANLY",
						new Class[] { String.class });

				String value19 = oldCplModel.getTENCOQUANQUANLY();

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
					"org.oep.cmon.dao.kios.model.impl.DanhSachCoQuanImpl")) {
			return translateOutputDanhSachCoQuan(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.kios.model.impl.DanhSachHoSoImpl")) {
			return translateOutputDanhSachHoSo(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.kios.model.impl.DanhSachThongKeImpl")) {
			return translateOutputDanhSachThongKe(oldModel);
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

	public static Object translateOutputDanhSachCoQuan(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanhSachCoQuanClp newModel = new DanhSachCoQuanClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTen");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTen(value1);

				Method method2 = oldModelClass.getMethod("getChaId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setChaId(value2);

				Method method3 = oldModelClass.getMethod(
						"getTenCapCoQuanQuanly");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setTenCapCoQuanQuanly(value3);

				Method method4 = oldModelClass.getMethod("getCapCoQuanQuanLyId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setCapCoQuanQuanLyId(value4);

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

	public static Object translateOutputDanhSachHoSo(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanhSachHoSoClp newModel = new DanhSachHoSoClp();

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

				Method method19 = oldModelClass.getMethod("getRNum");

				Integer value19 = (Integer)method19.invoke(oldModel,
						(Object[])null);

				newModel.setRNum(value19);

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

	public static Object translateOutputDanhSachThongKe(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanhSachThongKeClp newModel = new DanhSachThongKeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCAPCOQUANQUANLYID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setCAPCOQUANQUANLYID(value0);

				Method method1 = oldModelClass.getMethod("getCOQUANQUANLYID");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCOQUANQUANLYID(value1);

				Method method2 = oldModelClass.getMethod("getTHANG");

				Integer value2 = (Integer)method2.invoke(oldModel,
						(Object[])null);

				newModel.setTHANG(value2);

				Method method3 = oldModelClass.getMethod("getNAM");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setNAM(value3);

				Method method4 = oldModelClass.getMethod("getTONGNHAN");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setTONGNHAN(value4);

				Method method5 = oldModelClass.getMethod("getTIEPNHAN");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setTIEPNHAN(value5);

				Method method6 = oldModelClass.getMethod("getTONDAU");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setTONDAU(value6);

				Method method7 = oldModelClass.getMethod("getTONGDAGIAIQUYET");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setTONGDAGIAIQUYET(value7);

				Method method8 = oldModelClass.getMethod("getSOM");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setSOM(value8);

				Method method9 = oldModelClass.getMethod("getDUNG");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setDUNG(value9);

				Method method10 = oldModelClass.getMethod("getTRE");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setTRE(value10);

				Method method11 = oldModelClass.getMethod(
						"getTONGDANGGIAIQUYET");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setTONGDANGGIAIQUYET(value11);

				Method method12 = oldModelClass.getMethod("getCHUADENHAN");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setCHUADENHAN(value12);

				Method method13 = oldModelClass.getMethod("getQUAHAN");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setQUAHAN(value13);

				Method method14 = oldModelClass.getMethod("getRUTHOSO");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setRUTHOSO(value14);

				Method method15 = oldModelClass.getMethod("getKHONGHOPLE");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setKHONGHOPLE(value15);

				Method method16 = oldModelClass.getMethod("getTYLE");

				Double value16 = (Double)method16.invoke(oldModel,
						(Object[])null);

				newModel.setTYLE(value16);

				Method method17 = oldModelClass.getMethod("getTONCUOI");

				Long value17 = (Long)method17.invoke(oldModel, (Object[])null);

				newModel.setTONCUOI(value17);

				Method method18 = oldModelClass.getMethod(
						"getTENCAPCOQUANQUANLY");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setTENCAPCOQUANQUANLY(value18);

				Method method19 = oldModelClass.getMethod("getTENCOQUANQUANLY");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setTENCOQUANQUANLY(value19);

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