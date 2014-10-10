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

package org.oep.cmon.dao.thamso.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.thamso.model.AnhXaClp;
import org.oep.cmon.dao.thamso.model.ThamSoClp;

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

		if (oldModelClassName.equals(AnhXaClp.class.getName())) {
			return translateInputAnhXa(oldModel);
		}

		if (oldModelClassName.equals(ThamSoClp.class.getName())) {
			return translateInputThamSo(oldModel);
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

	public static Object translateInputAnhXa(BaseModel<?> oldModel) {
		AnhXaClp oldCplModel = (AnhXaClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.thamso.model.impl.AnhXaImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setMaDNG",
						new Class[] { String.class });

				String value1 = oldCplModel.getMaDNG();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTenDNG",
						new Class[] { String.class });

				String value2 = oldCplModel.getTenDNG();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMaKhac",
						new Class[] { String.class });

				String value3 = oldCplModel.getMaKhac();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTenKhac",
						new Class[] { String.class });

				String value4 = oldCplModel.getTenKhac();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTenBang",
						new Class[] { String.class });

				String value5 = oldCplModel.getTenBang();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setUngDungId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getUngDungId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgayTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value8 = oldCplModel.getNguoiTao();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgaySua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value10 = oldCplModel.getNguoiSua();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value11 = new Integer(oldCplModel.getDaXoa());

				method11.invoke(newModel, value11);

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

	public static Object translateInputThamSo(BaseModel<?> oldModel) {
		ThamSoClp oldCplModel = (ThamSoClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.thamso.model.impl.ThamSoImpl",
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

				Method method2 = newModelClass.getMethod("setGiaTri",
						new Class[] { String.class });

				String value2 = oldCplModel.getGiaTri();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setKieuDuLieu",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getKieuDuLieu());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setMota",
						new Class[] { String.class });

				String value4 = oldCplModel.getMota();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setUngDungId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getUngDungId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setHeThongId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getHeThongId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgayTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value8 = oldCplModel.getNguoiTao();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgaySua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value10 = oldCplModel.getNguoiSua();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value11 = new Integer(oldCplModel.getDaXoa());

				method11.invoke(newModel, value11);

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
					"org.oep.cmon.dao.thamso.model.impl.AnhXaImpl")) {
			return translateOutputAnhXa(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.thamso.model.impl.ThamSoImpl")) {
			return translateOutputThamSo(oldModel);
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

	public static Object translateOutputAnhXa(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				AnhXaClp newModel = new AnhXaClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getMaDNG");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setMaDNG(value1);

				Method method2 = oldModelClass.getMethod("getTenDNG");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTenDNG(value2);

				Method method3 = oldModelClass.getMethod("getMaKhac");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMaKhac(value3);

				Method method4 = oldModelClass.getMethod("getTenKhac");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setTenKhac(value4);

				Method method5 = oldModelClass.getMethod("getTenBang");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setTenBang(value5);

				Method method6 = oldModelClass.getMethod("getUngDungId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setUngDungId(value6);

				Method method7 = oldModelClass.getMethod("getNgayTao");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value7);

				Method method8 = oldModelClass.getMethod("getNguoiTao");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value8);

				Method method9 = oldModelClass.getMethod("getNgaySua");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value9);

				Method method10 = oldModelClass.getMethod("getNguoiSua");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value10);

				Method method11 = oldModelClass.getMethod("getDaXoa");

				Integer value11 = (Integer)method11.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value11);

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

	public static Object translateOutputThamSo(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ThamSoClp newModel = new ThamSoClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTen");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTen(value1);

				Method method2 = oldModelClass.getMethod("getGiaTri");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setGiaTri(value2);

				Method method3 = oldModelClass.getMethod("getKieuDuLieu");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setKieuDuLieu(value3);

				Method method4 = oldModelClass.getMethod("getMota");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setMota(value4);

				Method method5 = oldModelClass.getMethod("getUngDungId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setUngDungId(value5);

				Method method6 = oldModelClass.getMethod("getHeThongId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setHeThongId(value6);

				Method method7 = oldModelClass.getMethod("getNgayTao");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value7);

				Method method8 = oldModelClass.getMethod("getNguoiTao");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value8);

				Method method9 = oldModelClass.getMethod("getNgaySua");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value9);

				Method method10 = oldModelClass.getMethod("getNguoiSua");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value10);

				Method method11 = oldModelClass.getMethod("getDaXoa");

				Integer value11 = (Integer)method11.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value11);

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