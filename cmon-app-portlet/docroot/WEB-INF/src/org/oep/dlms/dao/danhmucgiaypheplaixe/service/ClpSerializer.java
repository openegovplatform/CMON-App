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

package org.oep.dlms.dao.danhmucgiaypheplaixe.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;


import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvtClp;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXeClp;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLXClp;

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
						"cmon-app-portlet-deployment-context");

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
							"cmon-app-portlet-deployment-context");

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
				_servletContextName = "cmon-app-portlet";
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

		if (oldModelClassName.equals(DonViGtvtClp.class.getName())) {
			return translateInputDonViGtvt(oldModel);
		}

		if (oldModelClassName.equals(HangGiayPhepLaiXeClp.class.getName())) {
			return translateInputHangGiayPhepLaiXe(oldModel);
		}

		if (oldModelClassName.equals(LyDoCapDoiCapLaiGPLXClp.class.getName())) {
			return translateInputLyDoCapDoiCapLaiGPLX(oldModel);
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

	public static Object translateInputDonViGtvt(BaseModel<?> oldModel) {
		DonViGtvtClp oldCplModel = (DonViGtvtClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.impl.DonViGtvtImpl",
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

				Method method3 = newModelClass.getMethod("setCoQuanQl",
						new Class[] { String.class });

				String value3 = oldCplModel.getCoQuanQl();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDienThoai",
						new Class[] { String.class });

				String value4 = oldCplModel.getDienThoai();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setFax",
						new Class[] { String.class });

				String value5 = oldCplModel.getFax();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDiaChi",
						new Class[] { String.class });

				String value6 = oldCplModel.getDiaChi();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setLanhDao",
						new Class[] { String.class });

				String value7 = oldCplModel.getLanhDao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getNgayTao();

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

				Method method12 = newModelClass.getMethod("setXoa",
						new Class[] { Integer.TYPE });

				Integer value12 = new Integer(oldCplModel.getXoa());

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

	public static Object translateInputHangGiayPhepLaiXe(BaseModel<?> oldModel) {
		HangGiayPhepLaiXeClp oldCplModel = (HangGiayPhepLaiXeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.impl.HangGiayPhepLaiXeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTenHang",
						new Class[] { String.class });

				String value1 = oldCplModel.getTenHang();

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

				Method method6 = newModelClass.getMethod("setXoa",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getXoa());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setMa",
						new Class[] { String.class });

				String value7 = oldCplModel.getMa();

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

	public static Object translateInputLyDoCapDoiCapLaiGPLX(
		BaseModel<?> oldModel) {
		LyDoCapDoiCapLaiGPLXClp oldCplModel = (LyDoCapDoiCapLaiGPLXClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.impl.LyDoCapDoiCapLaiGPLXImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setLyDo",
						new Class[] { String.class });

				String value1 = oldCplModel.getLyDo();

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

				Method method6 = newModelClass.getMethod("setXoa",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getXoa());

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
					"vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.impl.DonViGtvtImpl")) {
			return translateOutputDonViGtvt(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.impl.HangGiayPhepLaiXeImpl")) {
			return translateOutputHangGiayPhepLaiXe(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.impl.LyDoCapDoiCapLaiGPLXImpl")) {
			return translateOutputLyDoCapDoiCapLaiGPLX(oldModel);
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

	public static Object translateOutputDonViGtvt(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DonViGtvtClp newModel = new DonViGtvtClp();

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

				Method method3 = oldModelClass.getMethod("getCoQuanQl");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setCoQuanQl(value3);

				Method method4 = oldModelClass.getMethod("getDienThoai");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setDienThoai(value4);

				Method method5 = oldModelClass.getMethod("getFax");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setFax(value5);

				Method method6 = oldModelClass.getMethod("getDiaChi");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setDiaChi(value6);

				Method method7 = oldModelClass.getMethod("getLanhDao");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setLanhDao(value7);

				Method method8 = oldModelClass.getMethod("getNgayTao");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value8);

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

				Method method12 = oldModelClass.getMethod("getXoa");

				Integer value12 = (Integer)method12.invoke(oldModel,
						(Object[])null);

				newModel.setXoa(value12);

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

	public static Object translateOutputHangGiayPhepLaiXe(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HangGiayPhepLaiXeClp newModel = new HangGiayPhepLaiXeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTenHang");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTenHang(value1);

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

				Method method6 = oldModelClass.getMethod("getXoa");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setXoa(value6);

				Method method7 = oldModelClass.getMethod("getMa");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setMa(value7);

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

	public static Object translateOutputLyDoCapDoiCapLaiGPLX(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LyDoCapDoiCapLaiGPLXClp newModel = new LyDoCapDoiCapLaiGPLXClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getLyDo");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setLyDo(value1);

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

				Method method6 = oldModelClass.getMethod("getXoa");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setXoa(value6);

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