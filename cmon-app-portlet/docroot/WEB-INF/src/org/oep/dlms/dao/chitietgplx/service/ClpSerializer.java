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

package org.oep.dlms.dao.chitietgplx.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;


import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.oep.dlms.dao.chitietgplx.model.ChiTietGPLXClp;

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

		if (oldModelClassName.equals(ChiTietGPLXClp.class.getName())) {
			return translateInputChiTietGPLX(oldModel);
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

	public static Object translateInputChiTietGPLX(BaseModel<?> oldModel) {
		ChiTietGPLXClp oldCplModel = (ChiTietGPLXClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.dtt.dlms.dao.chitietgplx.model.impl.ChiTietGPLXImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setIdGPLX",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getIdGPLX());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setSoGPLX",
						new Class[] { String.class });

				String value2 = oldCplModel.getSoGPLX();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setIdHangGPLX",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getIdHangGPLX());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setIdNoiCapGPLX",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getIdNoiCapGPLX());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setIdNoiCapGPLXNuocNgoai",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getIdNoiCapGPLXNuocNgoai());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgayCapGPLX",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgayCapGPLX();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgayTrungTuyen",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgayTrungTuyen();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNgayHetHan",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getNgayHetHan();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setIdNoiHocLaiXe",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getIdNoiHocLaiXe());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setIdNoiHocLaiXeNuocNgoai",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getIdNoiHocLaiXeNuocNgoai());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNamHocLaiXe",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getNamHocLaiXe());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setNoiHocLaiXeNuocNgoai",
						new Class[] { String.class });

				String value12 = oldCplModel.getNoiHocLaiXeNuocNgoai();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setNoiHocLaiXe",
						new Class[] { String.class });

				String value13 = oldCplModel.getNoiHocLaiXe();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setNoiCapGPLXNuocNgoai",
						new Class[] { String.class });

				String value14 = oldCplModel.getNoiCapGPLXNuocNgoai();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setNoiCapGPLX",
						new Class[] { String.class });

				String value15 = oldCplModel.getNoiCapGPLX();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value16 = oldCplModel.getNgayTao();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value17 = oldCplModel.getNgaySua();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value18 = oldCplModel.getNguoiTao();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value19 = oldCplModel.getNguoiSua();

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
					"vn.dtt.dlms.dao.chitietgplx.model.impl.ChiTietGPLXImpl")) {
			return translateOutputChiTietGPLX(oldModel);
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

	public static Object translateOutputChiTietGPLX(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ChiTietGPLXClp newModel = new ChiTietGPLXClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getIdGPLX");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setIdGPLX(value1);

				Method method2 = oldModelClass.getMethod("getSoGPLX");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setSoGPLX(value2);

				Method method3 = oldModelClass.getMethod("getIdHangGPLX");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setIdHangGPLX(value3);

				Method method4 = oldModelClass.getMethod("getIdNoiCapGPLX");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setIdNoiCapGPLX(value4);

				Method method5 = oldModelClass.getMethod(
						"getIdNoiCapGPLXNuocNgoai");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setIdNoiCapGPLXNuocNgoai(value5);

				Method method6 = oldModelClass.getMethod("getNgayCapGPLX");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgayCapGPLX(value6);

				Method method7 = oldModelClass.getMethod("getNgayTrungTuyen");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgayTrungTuyen(value7);

				Method method8 = oldModelClass.getMethod("getNgayHetHan");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setNgayHetHan(value8);

				Method method9 = oldModelClass.getMethod("getIdNoiHocLaiXe");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setIdNoiHocLaiXe(value9);

				Method method10 = oldModelClass.getMethod(
						"getIdNoiHocLaiXeNuocNgoai");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setIdNoiHocLaiXeNuocNgoai(value10);

				Method method11 = oldModelClass.getMethod("getNamHocLaiXe");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setNamHocLaiXe(value11);

				Method method12 = oldModelClass.getMethod(
						"getNoiHocLaiXeNuocNgoai");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setNoiHocLaiXeNuocNgoai(value12);

				Method method13 = oldModelClass.getMethod("getNoiHocLaiXe");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setNoiHocLaiXe(value13);

				Method method14 = oldModelClass.getMethod(
						"getNoiCapGPLXNuocNgoai");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setNoiCapGPLXNuocNgoai(value14);

				Method method15 = oldModelClass.getMethod("getNoiCapGPLX");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setNoiCapGPLX(value15);

				Method method16 = oldModelClass.getMethod("getNgayTao");

				Date value16 = (Date)method16.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value16);

				Method method17 = oldModelClass.getMethod("getNgaySua");

				Date value17 = (Date)method17.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value17);

				Method method18 = oldModelClass.getMethod("getNguoiTao");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value18);

				Method method19 = oldModelClass.getMethod("getNguoiSua");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value19);

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