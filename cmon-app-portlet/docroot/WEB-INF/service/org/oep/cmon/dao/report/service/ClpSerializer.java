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

package org.oep.cmon.dao.report.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.report.model.BaocaochitietClp;
import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVucClp;
import org.oep.cmon.dao.report.model.CongChuc2RoleClp;
import org.oep.cmon.dao.report.model.DanhMucBaoCaoClp;
import org.oep.cmon.dao.report.model.DanhMucRoleClp;
import org.oep.cmon.dao.report.model.Lephi_chitietClp;
import org.oep.cmon.dao.report.model.Lephi_linhvucClp;
import org.oep.cmon.dao.report.model.Lephi_tonghopClp;
import org.oep.cmon.dao.report.model.ReportThongKeClp;
import org.oep.cmon.dao.report.model.ReportTongHopChiTietClp;
import org.oep.cmon.dao.report.model.ReportTongHopClp;
import org.oep.cmon.dao.report.model.Role2BaoCaoClp;
import org.oep.cmon.dao.report.model.Role2DonViBaoCaoClp;
import org.oep.cmon.dao.report.model.Role2NhomTTHCClp;
import org.oep.cmon.dao.report.model.Role2TTHCClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
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

		if (oldModelClassName.equals(BaocaochitietClp.class.getName())) {
			return translateInputBaocaochitiet(oldModel);
		}

		if (oldModelClassName.equals(CongChuc2RoleClp.class.getName())) {
			return translateInputCongChuc2Role(oldModel);
		}

		if (oldModelClassName.equals(CoQuanQuanLy2LinhVucClp.class.getName())) {
			return translateInputCoQuanQuanLy2LinhVuc(oldModel);
		}

		if (oldModelClassName.equals(DanhMucBaoCaoClp.class.getName())) {
			return translateInputDanhMucBaoCao(oldModel);
		}

		if (oldModelClassName.equals(DanhMucRoleClp.class.getName())) {
			return translateInputDanhMucRole(oldModel);
		}

		if (oldModelClassName.equals(Lephi_chitietClp.class.getName())) {
			return translateInputLephi_chitiet(oldModel);
		}

		if (oldModelClassName.equals(Lephi_linhvucClp.class.getName())) {
			return translateInputLephi_linhvuc(oldModel);
		}

		if (oldModelClassName.equals(Lephi_tonghopClp.class.getName())) {
			return translateInputLephi_tonghop(oldModel);
		}

		if (oldModelClassName.equals(ReportThongKeClp.class.getName())) {
			return translateInputReportThongKe(oldModel);
		}

		if (oldModelClassName.equals(ReportTongHopClp.class.getName())) {
			return translateInputReportTongHop(oldModel);
		}

		if (oldModelClassName.equals(ReportTongHopChiTietClp.class.getName())) {
			return translateInputReportTongHopChiTiet(oldModel);
		}

		if (oldModelClassName.equals(Role2BaoCaoClp.class.getName())) {
			return translateInputRole2BaoCao(oldModel);
		}

		if (oldModelClassName.equals(Role2DonViBaoCaoClp.class.getName())) {
			return translateInputRole2DonViBaoCao(oldModel);
		}

		if (oldModelClassName.equals(Role2NhomTTHCClp.class.getName())) {
			return translateInputRole2NhomTTHC(oldModel);
		}

		if (oldModelClassName.equals(Role2TTHCClp.class.getName())) {
			return translateInputRole2TTHC(oldModel);
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

	public static Object translateInputBaocaochitiet(BaseModel<?> oldModel) {
		BaocaochitietClp oldCplModel = (BaocaochitietClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.BaocaochitietImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setLINHVUCID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getLINHVUCID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setMASOHOSO",
						new Class[] { String.class });

				String value1 = oldCplModel.getMASOHOSO();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTEN",
						new Class[] { String.class });

				String value2 = oldCplModel.getTEN();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTRANGTHAI",
						new Class[] { String.class });

				String value3 = oldCplModel.getTRANGTHAI();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDIACHIHIENNAY",
						new Class[] { String.class });

				String value4 = oldCplModel.getDIACHIHIENNAY();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDIENTHOAIDIDONG",
						new Class[] { String.class });

				String value5 = oldCplModel.getDIENTHOAIDIDONG();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setHOTENNGUOINOPHOSO",
						new Class[] { String.class });

				String value6 = oldCplModel.getHOTENNGUOINOPHOSO();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNGUOIDAIDIENPHAPLUAT",
						new Class[] { String.class });

				String value7 = oldCplModel.getNGUOIDAIDIENPHAPLUAT();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNGAYNHANHOSO",
						new Class[] { String.class });

				String value8 = oldCplModel.getNGAYNHANHOSO();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNGAYTRAKETQUA",
						new Class[] { String.class });

				String value9 = oldCplModel.getNGAYTRAKETQUA();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNGAYHENTRAKETQUA",
						new Class[] { String.class });

				String value10 = oldCplModel.getNGAYHENTRAKETQUA();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setLINHVUC",
						new Class[] { String.class });

				String value11 = oldCplModel.getLINHVUC();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setGHICHU",
						new Class[] { String.class });

				String value12 = oldCplModel.getGHICHU();

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

	public static Object translateInputCongChuc2Role(BaseModel<?> oldModel) {
		CongChuc2RoleClp oldCplModel = (CongChuc2RoleClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.CongChuc2RoleImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCONGCHUCID",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCONGCHUCID());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setRPDANHMUCROLEID",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getRPDANHMUCROLEID());

				method2.invoke(newModel, value2);

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

	public static Object translateInputCoQuanQuanLy2LinhVuc(
		BaseModel<?> oldModel) {
		CoQuanQuanLy2LinhVucClp oldCplModel = (CoQuanQuanLy2LinhVucClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.CoQuanQuanLy2LinhVucImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setNHOMTHUTUCHANHCHINHID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getNHOMTHUTUCHANHCHINHID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTENNHOMTTHC",
						new Class[] { String.class });

				String value1 = oldCplModel.getTENNHOMTTHC();

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

	public static Object translateInputDanhMucBaoCao(BaseModel<?> oldModel) {
		DanhMucBaoCaoClp oldCplModel = (DanhMucBaoCaoClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.DanhMucBaoCaoImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTENBAOCAO",
						new Class[] { String.class });

				String value1 = oldCplModel.getTENBAOCAO();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDUONGDAN",
						new Class[] { String.class });

				String value2 = oldCplModel.getDUONGDAN();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setORDERS",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getORDERS());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setSTATUS",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getSTATUS());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setPUBLISH",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getPUBLISH());

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

	public static Object translateInputDanhMucRole(BaseModel<?> oldModel) {
		DanhMucRoleClp oldCplModel = (DanhMucRoleClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.DanhMucRoleImpl",
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

				Method method2 = newModelClass.getMethod("setORDERS",
						new Class[] { Integer.TYPE });

				Integer value2 = new Integer(oldCplModel.getORDERS());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setSTATUS",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getSTATUS());

				method3.invoke(newModel, value3);

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

	public static Object translateInputLephi_chitiet(BaseModel<?> oldModel) {
		Lephi_chitietClp oldCplModel = (Lephi_chitietClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.Lephi_chitietImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTENHOSO",
						new Class[] { String.class });

				String value1 = oldCplModel.getTENHOSO();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNGUOINOP",
						new Class[] { String.class });

				String value2 = oldCplModel.getNGUOINOP();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCHUHOSO",
						new Class[] { String.class });

				String value3 = oldCplModel.getCHUHOSO();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDIACHI",
						new Class[] { String.class });

				String value4 = oldCplModel.getDIACHI();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setSOBOHOSO",
						new Class[] { String.class });

				String value5 = oldCplModel.getSOBOHOSO();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setLEPHI",
						new Class[] { String.class });

				String value6 = oldCplModel.getLEPHI();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setPHIHOSO",
						new Class[] { String.class });

				String value7 = oldCplModel.getPHIHOSO();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setTONGLEPHI",
						new Class[] { String.class });

				String value8 = oldCplModel.getTONGLEPHI();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setGHICHU",
						new Class[] { String.class });

				String value9 = oldCplModel.getGHICHU();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNHOMTHUTUCHANHCHINHID",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getNHOMTHUTUCHANHCHINHID());

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

	public static Object translateInputLephi_linhvuc(BaseModel<?> oldModel) {
		Lephi_linhvucClp oldCplModel = (Lephi_linhvucClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.Lephi_linhvucImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setNHOMTHUTUCHANHCHINHID",
						new Class[] { Integer.TYPE });

				Integer value0 = new Integer(oldCplModel.getNHOMTHUTUCHANHCHINHID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTONGHOSO",
						new Class[] { String.class });

				String value1 = oldCplModel.getTONGHOSO();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setLEPHIHOSO",
						new Class[] { String.class });

				String value2 = oldCplModel.getLEPHIHOSO();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setPHIHOSO",
						new Class[] { String.class });

				String value3 = oldCplModel.getPHIHOSO();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTONGLEPHI",
						new Class[] { String.class });

				String value4 = oldCplModel.getTONGLEPHI();

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

	public static Object translateInputLephi_tonghop(BaseModel<?> oldModel) {
		Lephi_tonghopClp oldCplModel = (Lephi_tonghopClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.Lephi_tonghopImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setNHOMTHUTUCHANHCHINHID",
						new Class[] { Integer.TYPE });

				Integer value0 = new Integer(oldCplModel.getNHOMTHUTUCHANHCHINHID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTONGHOSO",
						new Class[] { String.class });

				String value1 = oldCplModel.getTONGHOSO();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setLEPHI",
						new Class[] { String.class });

				String value2 = oldCplModel.getLEPHI();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setPHIHOSO",
						new Class[] { String.class });

				String value3 = oldCplModel.getPHIHOSO();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTONGLEPHI",
						new Class[] { String.class });

				String value4 = oldCplModel.getTONGLEPHI();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTHANGNHAN",
						new Class[] { String.class });

				String value5 = oldCplModel.getTHANGNHAN();

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

	public static Object translateInputReportThongKe(BaseModel<?> oldModel) {
		ReportThongKeClp oldCplModel = (ReportThongKeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.ReportThongKeImpl",
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

	public static Object translateInputReportTongHop(BaseModel<?> oldModel) {
		ReportTongHopClp oldCplModel = (ReportTongHopClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.ReportTongHopImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCOQUANQUANLYID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getCOQUANQUANLYID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNHOMTHUTUCHANHCHINHID",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getNHOMTHUTUCHANHCHINHID());

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

	public static Object translateInputReportTongHopChiTiet(
		BaseModel<?> oldModel) {
		ReportTongHopChiTietClp oldCplModel = (ReportTongHopChiTietClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.ReportTongHopChiTietImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCOQUANQUANLYID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getCOQUANQUANLYID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNHOMTHUTUCHANHCHINHID",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getNHOMTHUTUCHANHCHINHID());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTHUTUCHANHCHINHID",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getTHUTUCHANHCHINHID());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTHANG",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getTHANG());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNAM",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getNAM());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTONGNHAN",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getTONGNHAN());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setTIEPNHAN",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getTIEPNHAN());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setTONDAU",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getTONDAU());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setTONGDAGIAIQUYET",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getTONGDAGIAIQUYET());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setSOM",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getSOM());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDUNG",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getDUNG());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setTRE",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getTRE());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setTONGDANGGIAIQUYET",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getTONGDANGGIAIQUYET());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setCHUADENHAN",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getCHUADENHAN());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setQUAHAN",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getQUAHAN());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setRUTHOSO",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getRUTHOSO());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setKHONGHOPLE",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getKHONGHOPLE());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setTYLE",
						new Class[] { Double.TYPE });

				Double value17 = new Double(oldCplModel.getTYLE());

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setTONCUOI",
						new Class[] { Long.TYPE });

				Long value18 = new Long(oldCplModel.getTONCUOI());

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

	public static Object translateInputRole2BaoCao(BaseModel<?> oldModel) {
		Role2BaoCaoClp oldCplModel = (Role2BaoCaoClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.Role2BaoCaoImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setRPDANHMUCROLEID",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getRPDANHMUCROLEID());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setRPDANHMUCBAOCAOID",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getRPDANHMUCBAOCAOID());

				method2.invoke(newModel, value2);

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

	public static Object translateInputRole2DonViBaoCao(BaseModel<?> oldModel) {
		Role2DonViBaoCaoClp oldCplModel = (Role2DonViBaoCaoClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.Role2DonViBaoCaoImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setRPDANHMUCROLEID",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getRPDANHMUCROLEID());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setRPDANHMUCBAOCAOID",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getRPDANHMUCBAOCAOID());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCOQUANQUANLYID",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCOQUANQUANLYID());

				method3.invoke(newModel, value3);

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

	public static Object translateInputRole2NhomTTHC(BaseModel<?> oldModel) {
		Role2NhomTTHCClp oldCplModel = (Role2NhomTTHCClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.Role2NhomTTHCImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setRPDANHMUCROLEID",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getRPDANHMUCROLEID());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setRPDANHMUCBAOCAOID",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getRPDANHMUCBAOCAOID());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNHOMTHUTUCHANHCHINHID",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getNHOMTHUTUCHANHCHINHID());

				method3.invoke(newModel, value3);

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

	public static Object translateInputRole2TTHC(BaseModel<?> oldModel) {
		Role2TTHCClp oldCplModel = (Role2TTHCClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.report.model.impl.Role2TTHCImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setRPDANHMUCROLEID",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getRPDANHMUCROLEID());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setRPDANHMUCBAOCAOID",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getRPDANHMUCBAOCAOID());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTHUTUCHANHCHINHID",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getTHUTUCHANHCHINHID());

				method3.invoke(newModel, value3);

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
					"org.oep.cmon.dao.report.model.impl.BaocaochitietImpl")) {
			return translateOutputBaocaochitiet(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.CongChuc2RoleImpl")) {
			return translateOutputCongChuc2Role(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.CoQuanQuanLy2LinhVucImpl")) {
			return translateOutputCoQuanQuanLy2LinhVuc(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.DanhMucBaoCaoImpl")) {
			return translateOutputDanhMucBaoCao(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.DanhMucRoleImpl")) {
			return translateOutputDanhMucRole(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.Lephi_chitietImpl")) {
			return translateOutputLephi_chitiet(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.Lephi_linhvucImpl")) {
			return translateOutputLephi_linhvuc(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.Lephi_tonghopImpl")) {
			return translateOutputLephi_tonghop(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.ReportThongKeImpl")) {
			return translateOutputReportThongKe(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.ReportTongHopImpl")) {
			return translateOutputReportTongHop(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.ReportTongHopChiTietImpl")) {
			return translateOutputReportTongHopChiTiet(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.Role2BaoCaoImpl")) {
			return translateOutputRole2BaoCao(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.Role2DonViBaoCaoImpl")) {
			return translateOutputRole2DonViBaoCao(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.Role2NhomTTHCImpl")) {
			return translateOutputRole2NhomTTHC(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.report.model.impl.Role2TTHCImpl")) {
			return translateOutputRole2TTHC(oldModel);
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

	public static Object translateOutputBaocaochitiet(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				BaocaochitietClp newModel = new BaocaochitietClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getLINHVUCID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setLINHVUCID(value0);

				Method method1 = oldModelClass.getMethod("getMASOHOSO");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setMASOHOSO(value1);

				Method method2 = oldModelClass.getMethod("getTEN");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTEN(value2);

				Method method3 = oldModelClass.getMethod("getTRANGTHAI");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setTRANGTHAI(value3);

				Method method4 = oldModelClass.getMethod("getDIACHIHIENNAY");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setDIACHIHIENNAY(value4);

				Method method5 = oldModelClass.getMethod("getDIENTHOAIDIDONG");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setDIENTHOAIDIDONG(value5);

				Method method6 = oldModelClass.getMethod("getHOTENNGUOINOPHOSO");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setHOTENNGUOINOPHOSO(value6);

				Method method7 = oldModelClass.getMethod(
						"getNGUOIDAIDIENPHAPLUAT");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNGUOIDAIDIENPHAPLUAT(value7);

				Method method8 = oldModelClass.getMethod("getNGAYNHANHOSO");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNGAYNHANHOSO(value8);

				Method method9 = oldModelClass.getMethod("getNGAYTRAKETQUA");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setNGAYTRAKETQUA(value9);

				Method method10 = oldModelClass.getMethod("getNGAYHENTRAKETQUA");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNGAYHENTRAKETQUA(value10);

				Method method11 = oldModelClass.getMethod("getLINHVUC");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setLINHVUC(value11);

				Method method12 = oldModelClass.getMethod("getGHICHU");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setGHICHU(value12);

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

	public static Object translateOutputCongChuc2Role(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CongChuc2RoleClp newModel = new CongChuc2RoleClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getCONGCHUCID");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCONGCHUCID(value1);

				Method method2 = oldModelClass.getMethod("getRPDANHMUCROLEID");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setRPDANHMUCROLEID(value2);

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

	public static Object translateOutputCoQuanQuanLy2LinhVuc(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CoQuanQuanLy2LinhVucClp newModel = new CoQuanQuanLy2LinhVucClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod(
						"getNHOMTHUTUCHANHCHINHID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setNHOMTHUTUCHANHCHINHID(value0);

				Method method1 = oldModelClass.getMethod("getTENNHOMTTHC");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTENNHOMTTHC(value1);

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

	public static Object translateOutputDanhMucBaoCao(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanhMucBaoCaoClp newModel = new DanhMucBaoCaoClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getTENBAOCAO");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTENBAOCAO(value1);

				Method method2 = oldModelClass.getMethod("getDUONGDAN");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDUONGDAN(value2);

				Method method3 = oldModelClass.getMethod("getORDERS");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setORDERS(value3);

				Method method4 = oldModelClass.getMethod("getSTATUS");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setSTATUS(value4);

				Method method5 = oldModelClass.getMethod("getPUBLISH");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setPUBLISH(value5);

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

	public static Object translateOutputDanhMucRole(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanhMucRoleClp newModel = new DanhMucRoleClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getNAME");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setNAME(value1);

				Method method2 = oldModelClass.getMethod("getORDERS");

				Integer value2 = (Integer)method2.invoke(oldModel,
						(Object[])null);

				newModel.setORDERS(value2);

				Method method3 = oldModelClass.getMethod("getSTATUS");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setSTATUS(value3);

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

	public static Object translateOutputLephi_chitiet(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Lephi_chitietClp newModel = new Lephi_chitietClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getTENHOSO");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTENHOSO(value1);

				Method method2 = oldModelClass.getMethod("getNGUOINOP");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setNGUOINOP(value2);

				Method method3 = oldModelClass.getMethod("getCHUHOSO");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setCHUHOSO(value3);

				Method method4 = oldModelClass.getMethod("getDIACHI");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setDIACHI(value4);

				Method method5 = oldModelClass.getMethod("getSOBOHOSO");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setSOBOHOSO(value5);

				Method method6 = oldModelClass.getMethod("getLEPHI");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setLEPHI(value6);

				Method method7 = oldModelClass.getMethod("getPHIHOSO");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setPHIHOSO(value7);

				Method method8 = oldModelClass.getMethod("getTONGLEPHI");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setTONGLEPHI(value8);

				Method method9 = oldModelClass.getMethod("getGHICHU");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setGHICHU(value9);

				Method method10 = oldModelClass.getMethod(
						"getNHOMTHUTUCHANHCHINHID");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNHOMTHUTUCHANHCHINHID(value10);

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

	public static Object translateOutputLephi_linhvuc(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Lephi_linhvucClp newModel = new Lephi_linhvucClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod(
						"getNHOMTHUTUCHANHCHINHID");

				Integer value0 = (Integer)method0.invoke(oldModel,
						(Object[])null);

				newModel.setNHOMTHUTUCHANHCHINHID(value0);

				Method method1 = oldModelClass.getMethod("getTONGHOSO");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTONGHOSO(value1);

				Method method2 = oldModelClass.getMethod("getLEPHIHOSO");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setLEPHIHOSO(value2);

				Method method3 = oldModelClass.getMethod("getPHIHOSO");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setPHIHOSO(value3);

				Method method4 = oldModelClass.getMethod("getTONGLEPHI");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setTONGLEPHI(value4);

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

	public static Object translateOutputLephi_tonghop(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Lephi_tonghopClp newModel = new Lephi_tonghopClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod(
						"getNHOMTHUTUCHANHCHINHID");

				Integer value0 = (Integer)method0.invoke(oldModel,
						(Object[])null);

				newModel.setNHOMTHUTUCHANHCHINHID(value0);

				Method method1 = oldModelClass.getMethod("getTONGHOSO");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTONGHOSO(value1);

				Method method2 = oldModelClass.getMethod("getLEPHI");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setLEPHI(value2);

				Method method3 = oldModelClass.getMethod("getPHIHOSO");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setPHIHOSO(value3);

				Method method4 = oldModelClass.getMethod("getTONGLEPHI");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setTONGLEPHI(value4);

				Method method5 = oldModelClass.getMethod("getTHANGNHAN");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setTHANGNHAN(value5);

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

	public static Object translateOutputReportThongKe(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ReportThongKeClp newModel = new ReportThongKeClp();

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

	public static Object translateOutputReportTongHop(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ReportTongHopClp newModel = new ReportTongHopClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCOQUANQUANLYID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setCOQUANQUANLYID(value0);

				Method method1 = oldModelClass.getMethod(
						"getNHOMTHUTUCHANHCHINHID");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setNHOMTHUTUCHANHCHINHID(value1);

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

	public static Object translateOutputReportTongHopChiTiet(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ReportTongHopChiTietClp newModel = new ReportTongHopChiTietClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCOQUANQUANLYID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setCOQUANQUANLYID(value0);

				Method method1 = oldModelClass.getMethod(
						"getNHOMTHUTUCHANHCHINHID");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setNHOMTHUTUCHANHCHINHID(value1);

				Method method2 = oldModelClass.getMethod("getTHUTUCHANHCHINHID");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setTHUTUCHANHCHINHID(value2);

				Method method3 = oldModelClass.getMethod("getTHANG");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setTHANG(value3);

				Method method4 = oldModelClass.getMethod("getNAM");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setNAM(value4);

				Method method5 = oldModelClass.getMethod("getTONGNHAN");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setTONGNHAN(value5);

				Method method6 = oldModelClass.getMethod("getTIEPNHAN");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setTIEPNHAN(value6);

				Method method7 = oldModelClass.getMethod("getTONDAU");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setTONDAU(value7);

				Method method8 = oldModelClass.getMethod("getTONGDAGIAIQUYET");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setTONGDAGIAIQUYET(value8);

				Method method9 = oldModelClass.getMethod("getSOM");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setSOM(value9);

				Method method10 = oldModelClass.getMethod("getDUNG");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setDUNG(value10);

				Method method11 = oldModelClass.getMethod("getTRE");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setTRE(value11);

				Method method12 = oldModelClass.getMethod(
						"getTONGDANGGIAIQUYET");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setTONGDANGGIAIQUYET(value12);

				Method method13 = oldModelClass.getMethod("getCHUADENHAN");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setCHUADENHAN(value13);

				Method method14 = oldModelClass.getMethod("getQUAHAN");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setQUAHAN(value14);

				Method method15 = oldModelClass.getMethod("getRUTHOSO");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setRUTHOSO(value15);

				Method method16 = oldModelClass.getMethod("getKHONGHOPLE");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setKHONGHOPLE(value16);

				Method method17 = oldModelClass.getMethod("getTYLE");

				Double value17 = (Double)method17.invoke(oldModel,
						(Object[])null);

				newModel.setTYLE(value17);

				Method method18 = oldModelClass.getMethod("getTONCUOI");

				Long value18 = (Long)method18.invoke(oldModel, (Object[])null);

				newModel.setTONCUOI(value18);

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

	public static Object translateOutputRole2BaoCao(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Role2BaoCaoClp newModel = new Role2BaoCaoClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getRPDANHMUCROLEID");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setRPDANHMUCROLEID(value1);

				Method method2 = oldModelClass.getMethod("getRPDANHMUCBAOCAOID");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setRPDANHMUCBAOCAOID(value2);

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

	public static Object translateOutputRole2DonViBaoCao(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Role2DonViBaoCaoClp newModel = new Role2DonViBaoCaoClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getRPDANHMUCROLEID");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setRPDANHMUCROLEID(value1);

				Method method2 = oldModelClass.getMethod("getRPDANHMUCBAOCAOID");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setRPDANHMUCBAOCAOID(value2);

				Method method3 = oldModelClass.getMethod("getCOQUANQUANLYID");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCOQUANQUANLYID(value3);

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

	public static Object translateOutputRole2NhomTTHC(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Role2NhomTTHCClp newModel = new Role2NhomTTHCClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getRPDANHMUCROLEID");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setRPDANHMUCROLEID(value1);

				Method method2 = oldModelClass.getMethod("getRPDANHMUCBAOCAOID");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setRPDANHMUCBAOCAOID(value2);

				Method method3 = oldModelClass.getMethod(
						"getNHOMTHUTUCHANHCHINHID");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setNHOMTHUTUCHANHCHINHID(value3);

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

	public static Object translateOutputRole2TTHC(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Role2TTHCClp newModel = new Role2TTHCClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setID(value0);

				Method method1 = oldModelClass.getMethod("getRPDANHMUCROLEID");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setRPDANHMUCROLEID(value1);

				Method method2 = oldModelClass.getMethod("getRPDANHMUCBAOCAOID");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setRPDANHMUCBAOCAOID(value2);

				Method method3 = oldModelClass.getMethod("getTHUTUCHANHCHINHID");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setTHUTUCHANHCHINHID(value3);

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