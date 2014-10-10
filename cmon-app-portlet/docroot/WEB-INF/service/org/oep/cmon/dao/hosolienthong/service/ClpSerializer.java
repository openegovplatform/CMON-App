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

package org.oep.cmon.dao.hosolienthong.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.hosolienthong.model.HoSoLienThongClp;

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

		if (oldModelClassName.equals(HoSoLienThongClp.class.getName())) {
			return translateInputHoSoLienThong(oldModel);
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

	public static Object translateInputHoSoLienThong(BaseModel<?> oldModel) {
		HoSoLienThongClp oldCplModel = (HoSoLienThongClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.hosolienthong.model.impl.HoSoLienThongImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setHoSoId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getHoSoId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCoQuanGuiId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCoQuanGuiId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCoQuanNhanId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCoQuanNhanId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setThuTucGuiId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getThuTucGuiId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setThuTucNhanId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getThuTucNhanId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setMaSoBienNhanLucGui",
						new Class[] { String.class });

				String value6 = oldCplModel.getMaSoBienNhanLucGui();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setMaSoBienNhanLucNhan",
						new Class[] { String.class });

				String value7 = oldCplModel.getMaSoBienNhanLucNhan();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setCanBoGuiId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getCanBoGuiId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setCanBoNhanId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getCanBoNhanId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNgayGui",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getNgayGui();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNgayNhan",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getNgayNhan();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setHoTenCanBoGui",
						new Class[] { String.class });

				String value12 = oldCplModel.getHoTenCanBoGui();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setHoTenCanBoNhan",
						new Class[] { String.class });

				String value13 = oldCplModel.getHoTenCanBoNhan();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setCanBoNopHoSoGiayId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getCanBoNopHoSoGiayId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setHoTenCanBoNopHoSoGiay",
						new Class[] { String.class });

				String value15 = oldCplModel.getHoTenCanBoNopHoSoGiay();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setTrangThaiLienThong",
						new Class[] { Integer.TYPE });

				Integer value16 = new Integer(oldCplModel.getTrangThaiLienThong());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setGhiChuGuiLienThong",
						new Class[] { String.class });

				String value17 = oldCplModel.getGhiChuGuiLienThong();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setHoTenCongDanNop",
						new Class[] { String.class });

				String value18 = oldCplModel.getHoTenCongDanNop();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setDiaChiDayDuCongDanNop",
						new Class[] { String.class });

				String value19 = oldCplModel.getDiaChiDayDuCongDanNop();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setNgayTuChoi",
						new Class[] { Date.class });

				Date value20 = oldCplModel.getNgayTuChoi();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setNgayNoiNhanTraKetQua",
						new Class[] { Date.class });

				Date value21 = oldCplModel.getNgayNoiNhanTraKetQua();

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setNgayNoiGuiNhanKetQua",
						new Class[] { Date.class });

				Date value22 = oldCplModel.getNgayNoiGuiNhanKetQua();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setCanBoTiepNhanNoiGuiId",
						new Class[] { Long.TYPE });

				Long value23 = new Long(oldCplModel.getCanBoTiepNhanNoiGuiId());

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setHoTenCanBoTiepNhanNoiGui",
						new Class[] { String.class });

				String value24 = oldCplModel.getHoTenCanBoTiepNhanNoiGui();

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setTenCoQuanGui",
						new Class[] { String.class });

				String value25 = oldCplModel.getTenCoQuanGui();

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setTenThuTucGui",
						new Class[] { String.class });

				String value26 = oldCplModel.getTenThuTucGui();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setTenCoQuanNhan",
						new Class[] { String.class });

				String value27 = oldCplModel.getTenCoQuanNhan();

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setTenThuTucNhan",
						new Class[] { String.class });

				String value28 = oldCplModel.getTenThuTucNhan();

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setThuTuLienThong",
						new Class[] { Integer.TYPE });

				Integer value29 = new Integer(oldCplModel.getThuTuLienThong());

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setNgayNoiNhanHenTra",
						new Class[] { Date.class });

				Date value30 = oldCplModel.getNgayNoiNhanHenTra();

				method30.invoke(newModel, value30);

				Method method31 = newModelClass.getMethod("setSoNgayNoiNhanXuLyDuKien",
						new Class[] { Integer.TYPE });

				Integer value31 = new Integer(oldCplModel.getSoNgayNoiNhanXuLyDuKien());

				method31.invoke(newModel, value31);

				Method method32 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value32 = oldCplModel.getNguoiTao();

				method32.invoke(newModel, value32);

				Method method33 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value33 = oldCplModel.getNgayTao();

				method33.invoke(newModel, value33);

				Method method34 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value34 = oldCplModel.getNguoiSua();

				method34.invoke(newModel, value34);

				Method method35 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value35 = oldCplModel.getNgaySua();

				method35.invoke(newModel, value35);

				Method method36 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value36 = new Integer(oldCplModel.getDaXoa());

				method36.invoke(newModel, value36);

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
					"org.oep.cmon.dao.hosolienthong.model.impl.HoSoLienThongImpl")) {
			return translateOutputHoSoLienThong(oldModel);
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

	public static Object translateOutputHoSoLienThong(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HoSoLienThongClp newModel = new HoSoLienThongClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getHoSoId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setHoSoId(value1);

				Method method2 = oldModelClass.getMethod("getCoQuanGuiId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCoQuanGuiId(value2);

				Method method3 = oldModelClass.getMethod("getCoQuanNhanId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCoQuanNhanId(value3);

				Method method4 = oldModelClass.getMethod("getThuTucGuiId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setThuTucGuiId(value4);

				Method method5 = oldModelClass.getMethod("getThuTucNhanId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setThuTucNhanId(value5);

				Method method6 = oldModelClass.getMethod(
						"getMaSoBienNhanLucGui");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setMaSoBienNhanLucGui(value6);

				Method method7 = oldModelClass.getMethod(
						"getMaSoBienNhanLucNhan");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setMaSoBienNhanLucNhan(value7);

				Method method8 = oldModelClass.getMethod("getCanBoGuiId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setCanBoGuiId(value8);

				Method method9 = oldModelClass.getMethod("getCanBoNhanId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setCanBoNhanId(value9);

				Method method10 = oldModelClass.getMethod("getNgayGui");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setNgayGui(value10);

				Method method11 = oldModelClass.getMethod("getNgayNhan");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setNgayNhan(value11);

				Method method12 = oldModelClass.getMethod("getHoTenCanBoGui");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenCanBoGui(value12);

				Method method13 = oldModelClass.getMethod("getHoTenCanBoNhan");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenCanBoNhan(value13);

				Method method14 = oldModelClass.getMethod(
						"getCanBoNopHoSoGiayId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setCanBoNopHoSoGiayId(value14);

				Method method15 = oldModelClass.getMethod(
						"getHoTenCanBoNopHoSoGiay");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenCanBoNopHoSoGiay(value15);

				Method method16 = oldModelClass.getMethod(
						"getTrangThaiLienThong");

				Integer value16 = (Integer)method16.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiLienThong(value16);

				Method method17 = oldModelClass.getMethod(
						"getGhiChuGuiLienThong");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setGhiChuGuiLienThong(value17);

				Method method18 = oldModelClass.getMethod("getHoTenCongDanNop");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenCongDanNop(value18);

				Method method19 = oldModelClass.getMethod(
						"getDiaChiDayDuCongDanNop");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiDayDuCongDanNop(value19);

				Method method20 = oldModelClass.getMethod("getNgayTuChoi");

				Date value20 = (Date)method20.invoke(oldModel, (Object[])null);

				newModel.setNgayTuChoi(value20);

				Method method21 = oldModelClass.getMethod(
						"getNgayNoiNhanTraKetQua");

				Date value21 = (Date)method21.invoke(oldModel, (Object[])null);

				newModel.setNgayNoiNhanTraKetQua(value21);

				Method method22 = oldModelClass.getMethod(
						"getNgayNoiGuiNhanKetQua");

				Date value22 = (Date)method22.invoke(oldModel, (Object[])null);

				newModel.setNgayNoiGuiNhanKetQua(value22);

				Method method23 = oldModelClass.getMethod(
						"getCanBoTiepNhanNoiGuiId");

				Long value23 = (Long)method23.invoke(oldModel, (Object[])null);

				newModel.setCanBoTiepNhanNoiGuiId(value23);

				Method method24 = oldModelClass.getMethod(
						"getHoTenCanBoTiepNhanNoiGui");

				String value24 = (String)method24.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenCanBoTiepNhanNoiGui(value24);

				Method method25 = oldModelClass.getMethod("getTenCoQuanGui");

				String value25 = (String)method25.invoke(oldModel,
						(Object[])null);

				newModel.setTenCoQuanGui(value25);

				Method method26 = oldModelClass.getMethod("getTenThuTucGui");

				String value26 = (String)method26.invoke(oldModel,
						(Object[])null);

				newModel.setTenThuTucGui(value26);

				Method method27 = oldModelClass.getMethod("getTenCoQuanNhan");

				String value27 = (String)method27.invoke(oldModel,
						(Object[])null);

				newModel.setTenCoQuanNhan(value27);

				Method method28 = oldModelClass.getMethod("getTenThuTucNhan");

				String value28 = (String)method28.invoke(oldModel,
						(Object[])null);

				newModel.setTenThuTucNhan(value28);

				Method method29 = oldModelClass.getMethod("getThuTuLienThong");

				Integer value29 = (Integer)method29.invoke(oldModel,
						(Object[])null);

				newModel.setThuTuLienThong(value29);

				Method method30 = oldModelClass.getMethod(
						"getNgayNoiNhanHenTra");

				Date value30 = (Date)method30.invoke(oldModel, (Object[])null);

				newModel.setNgayNoiNhanHenTra(value30);

				Method method31 = oldModelClass.getMethod(
						"getSoNgayNoiNhanXuLyDuKien");

				Integer value31 = (Integer)method31.invoke(oldModel,
						(Object[])null);

				newModel.setSoNgayNoiNhanXuLyDuKien(value31);

				Method method32 = oldModelClass.getMethod("getNguoiTao");

				String value32 = (String)method32.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value32);

				Method method33 = oldModelClass.getMethod("getNgayTao");

				Date value33 = (Date)method33.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value33);

				Method method34 = oldModelClass.getMethod("getNguoiSua");

				String value34 = (String)method34.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value34);

				Method method35 = oldModelClass.getMethod("getNgaySua");

				Date value35 = (Date)method35.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value35);

				Method method36 = oldModelClass.getMethod("getDaXoa");

				Integer value36 = (Integer)method36.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value36);

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