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

package org.oep.cmon.dao.cc.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.cc.model.ChucVuClp;
import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTucClp;
import org.oep.cmon.dao.cc.model.CongChucClp;

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

		if (oldModelClassName.equals(ChucVuClp.class.getName())) {
			return translateInputChucVu(oldModel);
		}

		if (oldModelClassName.equals(CongChucClp.class.getName())) {
			return translateInputCongChuc(oldModel);
		}

		if (oldModelClassName.equals(CongChuc2NhomThuTucClp.class.getName())) {
			return translateInputCongChuc2NhomThuTuc(oldModel);
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

	public static Object translateInputChucVu(BaseModel<?> oldModel) {
		ChucVuClp oldCplModel = (ChucVuClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cc.model.impl.ChucVuImpl",
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

				Method method3 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getPhienBan());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getDaXoa());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgaySua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value8 = oldCplModel.getNguoiSua();

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

	public static Object translateInputCongChuc(BaseModel<?> oldModel) {
		CongChucClp oldCplModel = (CongChucClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cc.model.impl.CongChucImpl",
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

				Method method2 = newModelClass.getMethod("setHoVaTen",
						new Class[] { String.class });

				String value2 = oldCplModel.getHoVaTen();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgaySinh",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgaySinh();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setSoCmnd",
						new Class[] { String.class });

				String value4 = oldCplModel.getSoCmnd();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgayCapCmnd",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgayCapCmnd();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNoiCapCmnd",
						new Class[] { String.class });

				String value6 = oldCplModel.getNoiCapCmnd();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setGioiTinhId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getGioiTinhId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getNgayTao();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgaySua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getDaXoa());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setTaiKhoanNguoiDungId",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getTaiKhoanNguoiDungId());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value12 = oldCplModel.getNguoiSua();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setChucVuId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getChucVuId());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setCoQuanQuanLyId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getCoQuanQuanLyId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value15 = oldCplModel.getNguoiTao();

				method15.invoke(newModel, value15);

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

	public static Object translateInputCongChuc2NhomThuTuc(
		BaseModel<?> oldModel) {
		CongChuc2NhomThuTucClp oldCplModel = (CongChuc2NhomThuTucClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cc.model.impl.CongChuc2NhomThuTucImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCongChucId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCongChucId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNhomThuTucId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getNhomThuTucId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayTao();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgaySua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiSua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getDaXoa());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDuocPhepEditCongDan",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getDuocPhepEditCongDan());

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
					"org.oep.cmon.dao.cc.model.impl.ChucVuImpl")) {
			return translateOutputChucVu(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cc.model.impl.CongChucImpl")) {
			return translateOutputCongChuc(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cc.model.impl.CongChuc2NhomThuTucImpl")) {
			return translateOutputCongChuc2NhomThuTuc(oldModel);
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

	public static Object translateOutputChucVu(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ChucVuClp newModel = new ChucVuClp();

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

				Method method3 = oldModelClass.getMethod("getPhienBan");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value3);

				Method method4 = oldModelClass.getMethod("getNgayTao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value4);

				Method method5 = oldModelClass.getMethod("getDaXoa");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value5);

				Method method6 = oldModelClass.getMethod("getNgaySua");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value6);

				Method method7 = oldModelClass.getMethod("getNguoiTao");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value7);

				Method method8 = oldModelClass.getMethod("getNguoiSua");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value8);

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

	public static Object translateOutputCongChuc(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CongChucClp newModel = new CongChucClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getMa");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setMa(value1);

				Method method2 = oldModelClass.getMethod("getHoVaTen");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setHoVaTen(value2);

				Method method3 = oldModelClass.getMethod("getNgaySinh");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgaySinh(value3);

				Method method4 = oldModelClass.getMethod("getSoCmnd");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setSoCmnd(value4);

				Method method5 = oldModelClass.getMethod("getNgayCapCmnd");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgayCapCmnd(value5);

				Method method6 = oldModelClass.getMethod("getNoiCapCmnd");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNoiCapCmnd(value6);

				Method method7 = oldModelClass.getMethod("getGioiTinhId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setGioiTinhId(value7);

				Method method8 = oldModelClass.getMethod("getNgayTao");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value8);

				Method method9 = oldModelClass.getMethod("getNgaySua");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value9);

				Method method10 = oldModelClass.getMethod("getDaXoa");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value10);

				Method method11 = oldModelClass.getMethod(
						"getTaiKhoanNguoiDungId");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setTaiKhoanNguoiDungId(value11);

				Method method12 = oldModelClass.getMethod("getNguoiSua");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value12);

				Method method13 = oldModelClass.getMethod("getChucVuId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setChucVuId(value13);

				Method method14 = oldModelClass.getMethod("getCoQuanQuanLyId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setCoQuanQuanLyId(value14);

				Method method15 = oldModelClass.getMethod("getNguoiTao");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value15);

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

	public static Object translateOutputCongChuc2NhomThuTuc(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CongChuc2NhomThuTucClp newModel = new CongChuc2NhomThuTucClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getCongChucId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCongChucId(value1);

				Method method2 = oldModelClass.getMethod("getNhomThuTucId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setNhomThuTucId(value2);

				Method method3 = oldModelClass.getMethod("getNgayTao");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value3);

				Method method4 = oldModelClass.getMethod("getNguoiTao");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value4);

				Method method5 = oldModelClass.getMethod("getNgaySua");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value5);

				Method method6 = oldModelClass.getMethod("getNguoiSua");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value6);

				Method method7 = oldModelClass.getMethod("getDaXoa");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value7);

				Method method8 = oldModelClass.getMethod(
						"getDuocPhepEditCongDan");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setDuocPhepEditCongDan(value8);

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