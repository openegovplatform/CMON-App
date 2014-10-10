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

package org.oep.cmon.dao.job.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.job.model.DanhSachJobClp;
import org.oep.cmon.dao.job.model.LogMailClp;
import org.oep.cmon.dao.job.model.TrangThaiJobClp;

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

		if (oldModelClassName.equals(DanhSachJobClp.class.getName())) {
			return translateInputDanhSachJob(oldModel);
		}

		if (oldModelClassName.equals(LogMailClp.class.getName())) {
			return translateInputLogMail(oldModel);
		}

		if (oldModelClassName.equals(TrangThaiJobClp.class.getName())) {
			return translateInputTrangThaiJob(oldModel);
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

	public static Object translateInputDanhSachJob(BaseModel<?> oldModel) {
		DanhSachJobClp oldCplModel = (DanhSachJobClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.job.model.impl.DanhSachJobImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setJobClass",
						new Class[] { String.class });

				String value1 = oldCplModel.getJobClass();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setJobId",
						new Class[] { Integer.TYPE });

				Integer value2 = new Integer(oldCplModel.getJobId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setJobName",
						new Class[] { String.class });

				String value3 = oldCplModel.getJobName();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value4 = oldCplModel.getDescription();

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

	public static Object translateInputLogMail(BaseModel<?> oldModel) {
		LogMailClp oldCplModel = (LogMailClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.job.model.impl.LogMailImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setType",
						new Class[] { String.class });

				String value1 = oldCplModel.getType();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setHoSoTTHCCongId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getHoSoTTHCCongId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreateTime",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getCreateTime();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getStatus());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value5 = oldCplModel.getDescription();

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

	public static Object translateInputTrangThaiJob(BaseModel<?> oldModel) {
		TrangThaiJobClp oldCplModel = (TrangThaiJobClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.job.model.impl.TrangThaiJobImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setJobId",
						new Class[] { Integer.TYPE });

				Integer value1 = new Integer(oldCplModel.getJobId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setJobName",
						new Class[] { String.class });

				String value2 = oldCplModel.getJobName();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setStartTime",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getStartTime();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setEndTime",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getEndTime();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getStatus());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setRunMode",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getRunMode());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setMessage",
						new Class[] { String.class });

				String value7 = oldCplModel.getMessage();

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
					"org.oep.cmon.dao.job.model.impl.DanhSachJobImpl")) {
			return translateOutputDanhSachJob(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.job.model.impl.LogMailImpl")) {
			return translateOutputLogMail(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.job.model.impl.TrangThaiJobImpl")) {
			return translateOutputTrangThaiJob(oldModel);
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

	public static Object translateOutputDanhSachJob(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanhSachJobClp newModel = new DanhSachJobClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getJobClass");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setJobClass(value1);

				Method method2 = oldModelClass.getMethod("getJobId");

				Integer value2 = (Integer)method2.invoke(oldModel,
						(Object[])null);

				newModel.setJobId(value2);

				Method method3 = oldModelClass.getMethod("getJobName");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setJobName(value3);

				Method method4 = oldModelClass.getMethod("getDescription");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setDescription(value4);

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

	public static Object translateOutputLogMail(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LogMailClp newModel = new LogMailClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getType");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setType(value1);

				Method method2 = oldModelClass.getMethod("getHoSoTTHCCongId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setHoSoTTHCCongId(value2);

				Method method3 = oldModelClass.getMethod("getCreateTime");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreateTime(value3);

				Method method4 = oldModelClass.getMethod("getStatus");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value4);

				Method method5 = oldModelClass.getMethod("getDescription");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setDescription(value5);

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

	public static Object translateOutputTrangThaiJob(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TrangThaiJobClp newModel = new TrangThaiJobClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getJobId");

				Integer value1 = (Integer)method1.invoke(oldModel,
						(Object[])null);

				newModel.setJobId(value1);

				Method method2 = oldModelClass.getMethod("getJobName");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setJobName(value2);

				Method method3 = oldModelClass.getMethod("getStartTime");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setStartTime(value3);

				Method method4 = oldModelClass.getMethod("getEndTime");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setEndTime(value4);

				Method method5 = oldModelClass.getMethod("getStatus");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value5);

				Method method6 = oldModelClass.getMethod("getRunMode");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setRunMode(value6);

				Method method7 = oldModelClass.getMethod("getMessage");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setMessage(value7);

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