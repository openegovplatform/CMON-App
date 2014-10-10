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

package org.oep.cmon.dao.nsd.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.nsd.model.NguoiDung2VaiTroClp;
import org.oep.cmon.dao.nsd.model.NhomNguoiDungClp;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungClp;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTroClp;
import org.oep.cmon.dao.nsd.model.TaiNguyenClp;
import org.oep.cmon.dao.nsd.model.VaiTroClp;

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

		if (oldModelClassName.equals(NguoiDung2VaiTroClp.class.getName())) {
			return translateInputNguoiDung2VaiTro(oldModel);
		}

		if (oldModelClassName.equals(NhomNguoiDungClp.class.getName())) {
			return translateInputNhomNguoiDung(oldModel);
		}

		if (oldModelClassName.equals(TaiKhoanNguoiDungClp.class.getName())) {
			return translateInputTaiKhoanNguoiDung(oldModel);
		}

		if (oldModelClassName.equals(TaiNguyenClp.class.getName())) {
			return translateInputTaiNguyen(oldModel);
		}

		if (oldModelClassName.equals(TaiNguyen2VaiTroClp.class.getName())) {
			return translateInputTaiNguyen2VaiTro(oldModel);
		}

		if (oldModelClassName.equals(VaiTroClp.class.getName())) {
			return translateInputVaiTro(oldModel);
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

	public static Object translateInputNguoiDung2VaiTro(BaseModel<?> oldModel) {
		NguoiDung2VaiTroClp oldCplModel = (NguoiDung2VaiTroClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.nsd.model.impl.NguoiDung2VaiTroImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setVaiTroId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getVaiTroId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTaiKhoanNguoiDungId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getTaiKhoanNguoiDungId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayTao();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getDaXoa());

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

	public static Object translateInputNhomNguoiDung(BaseModel<?> oldModel) {
		NhomNguoiDungClp oldCplModel = (NhomNguoiDungClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.nsd.model.impl.NhomNguoiDungImpl",
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

				Method method3 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayTao();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getDaXoa());

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

				Method method8 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getTrangThai());

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

	public static Object translateInputTaiKhoanNguoiDung(BaseModel<?> oldModel) {
		TaiKhoanNguoiDungClp oldCplModel = (TaiKhoanNguoiDungClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTenDangNhap",
						new Class[] { String.class });

				String value1 = oldCplModel.getTenDangNhap();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMatKhau",
						new Class[] { String.class });

				String value2 = oldCplModel.getMatKhau();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTenNguoiDung",
						new Class[] { String.class });

				String value3 = oldCplModel.getTenNguoiDung();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCauHoiMatKhau",
						new Class[] { String.class });

				String value4 = oldCplModel.getCauHoiMatKhau();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCauTraLoiMatKhau",
						new Class[] { String.class });

				String value5 = oldCplModel.getCauTraLoiMatKhau();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value6 = oldCplModel.getEmail();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgayTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getDaXoa());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgaySua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value10 = oldCplModel.getNguoiTao();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value11 = oldCplModel.getNguoiSua();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value12 = new Integer(oldCplModel.getTrangThai());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLoaiDoiTuongId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getLoaiDoiTuongId());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setTaiKhoanNguoiDungId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getTaiKhoanNguoiDungId());

				method14.invoke(newModel, value14);

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

	public static Object translateInputTaiNguyen(BaseModel<?> oldModel) {
		TaiNguyenClp oldCplModel = (TaiNguyenClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.nsd.model.impl.TaiNguyenImpl",
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

				Method method3 = newModelClass.getMethod("setLoai",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getLoai());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setGiaTri",
						new Class[] { String.class });

				String value4 = oldCplModel.getGiaTri();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getTrangThai());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgayTao();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getNgaySua();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value9 = oldCplModel.getNguoiSua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getDaXoa());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setUngDungId",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getUngDungId());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setHeThongId",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getHeThongId());

				method12.invoke(newModel, value12);

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

	public static Object translateInputTaiNguyen2VaiTro(BaseModel<?> oldModel) {
		TaiNguyen2VaiTroClp oldCplModel = (TaiNguyen2VaiTroClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.nsd.model.impl.TaiNguyen2VaiTroImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTaiNguyenId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getTaiNguyenId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setVaiTroId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getVaiTroId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setHanhDong",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getHanhDong());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoiTao();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgaySua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiSua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getDaXoa());

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

	public static Object translateInputVaiTro(BaseModel<?> oldModel) {
		VaiTroClp oldCplModel = (VaiTroClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.nsd.model.impl.VaiTroImpl",
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

				Method method5 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getDaXoa());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiTao();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgaySua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value8 = oldCplModel.getNguoiSua();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value9 = new Integer(oldCplModel.getTrangThai());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setUngDungId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getUngDungId());

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
					"org.oep.cmon.dao.nsd.model.impl.NguoiDung2VaiTroImpl")) {
			return translateOutputNguoiDung2VaiTro(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.nsd.model.impl.NhomNguoiDungImpl")) {
			return translateOutputNhomNguoiDung(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl")) {
			return translateOutputTaiKhoanNguoiDung(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.nsd.model.impl.TaiNguyenImpl")) {
			return translateOutputTaiNguyen(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.nsd.model.impl.TaiNguyen2VaiTroImpl")) {
			return translateOutputTaiNguyen2VaiTro(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.nsd.model.impl.VaiTroImpl")) {
			return translateOutputVaiTro(oldModel);
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

	public static Object translateOutputNguoiDung2VaiTro(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				NguoiDung2VaiTroClp newModel = new NguoiDung2VaiTroClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getVaiTroId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setVaiTroId(value1);

				Method method2 = oldModelClass.getMethod(
						"getTaiKhoanNguoiDungId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setTaiKhoanNguoiDungId(value2);

				Method method3 = oldModelClass.getMethod("getNgayTao");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value3);

				Method method4 = oldModelClass.getMethod("getNguoiTao");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value4);

				Method method5 = oldModelClass.getMethod("getDaXoa");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value5);

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

	public static Object translateOutputNhomNguoiDung(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				NhomNguoiDungClp newModel = new NhomNguoiDungClp();

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

				Method method3 = oldModelClass.getMethod("getNgayTao");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value3);

				Method method4 = oldModelClass.getMethod("getDaXoa");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value4);

				Method method5 = oldModelClass.getMethod("getNgaySua");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value5);

				Method method6 = oldModelClass.getMethod("getNguoiTao");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value6);

				Method method7 = oldModelClass.getMethod("getNguoiSua");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value7);

				Method method8 = oldModelClass.getMethod("getTrangThai");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value8);

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

	public static Object translateOutputTaiKhoanNguoiDung(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TaiKhoanNguoiDungClp newModel = new TaiKhoanNguoiDungClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTenDangNhap");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTenDangNhap(value1);

				Method method2 = oldModelClass.getMethod("getMatKhau");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMatKhau(value2);

				Method method3 = oldModelClass.getMethod("getTenNguoiDung");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setTenNguoiDung(value3);

				Method method4 = oldModelClass.getMethod("getCauHoiMatKhau");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCauHoiMatKhau(value4);

				Method method5 = oldModelClass.getMethod("getCauTraLoiMatKhau");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setCauTraLoiMatKhau(value5);

				Method method6 = oldModelClass.getMethod("getEmail");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setEmail(value6);

				Method method7 = oldModelClass.getMethod("getNgayTao");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value7);

				Method method8 = oldModelClass.getMethod("getDaXoa");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value8);

				Method method9 = oldModelClass.getMethod("getNgaySua");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value9);

				Method method10 = oldModelClass.getMethod("getNguoiTao");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value10);

				Method method11 = oldModelClass.getMethod("getNguoiSua");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value11);

				Method method12 = oldModelClass.getMethod("getTrangThai");

				Integer value12 = (Integer)method12.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value12);

				Method method13 = oldModelClass.getMethod("getLoaiDoiTuongId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setLoaiDoiTuongId(value13);

				Method method14 = oldModelClass.getMethod(
						"getTaiKhoanNguoiDungId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setTaiKhoanNguoiDungId(value14);

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

	public static Object translateOutputTaiNguyen(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TaiNguyenClp newModel = new TaiNguyenClp();

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

				Method method3 = oldModelClass.getMethod("getLoai");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setLoai(value3);

				Method method4 = oldModelClass.getMethod("getGiaTri");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setGiaTri(value4);

				Method method5 = oldModelClass.getMethod("getTrangThai");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value5);

				Method method6 = oldModelClass.getMethod("getNgayTao");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value6);

				Method method7 = oldModelClass.getMethod("getNguoiTao");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value7);

				Method method8 = oldModelClass.getMethod("getNgaySua");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value8);

				Method method9 = oldModelClass.getMethod("getNguoiSua");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value9);

				Method method10 = oldModelClass.getMethod("getDaXoa");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value10);

				Method method11 = oldModelClass.getMethod("getUngDungId");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setUngDungId(value11);

				Method method12 = oldModelClass.getMethod("getHeThongId");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setHeThongId(value12);

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

	public static Object translateOutputTaiNguyen2VaiTro(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TaiNguyen2VaiTroClp newModel = new TaiNguyen2VaiTroClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTaiNguyenId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setTaiNguyenId(value1);

				Method method2 = oldModelClass.getMethod("getVaiTroId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setVaiTroId(value2);

				Method method3 = oldModelClass.getMethod("getHanhDong");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setHanhDong(value3);

				Method method4 = oldModelClass.getMethod("getNgayTao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value4);

				Method method5 = oldModelClass.getMethod("getNguoiTao");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value5);

				Method method6 = oldModelClass.getMethod("getNgaySua");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value6);

				Method method7 = oldModelClass.getMethod("getNguoiSua");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value7);

				Method method8 = oldModelClass.getMethod("getDaXoa");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value8);

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

	public static Object translateOutputVaiTro(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VaiTroClp newModel = new VaiTroClp();

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

				Method method5 = oldModelClass.getMethod("getDaXoa");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value5);

				Method method6 = oldModelClass.getMethod("getNguoiTao");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value6);

				Method method7 = oldModelClass.getMethod("getNgaySua");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value7);

				Method method8 = oldModelClass.getMethod("getNguoiSua");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value8);

				Method method9 = oldModelClass.getMethod("getTrangThai");

				Integer value9 = (Integer)method9.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value9);

				Method method10 = oldModelClass.getMethod("getUngDungId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setUngDungId(value10);

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