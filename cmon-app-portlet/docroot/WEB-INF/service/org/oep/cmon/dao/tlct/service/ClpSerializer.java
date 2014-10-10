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

package org.oep.cmon.dao.tlct.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.tlct.model.DanhMucGiayToClp;
import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKemClp;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThucClp;

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

		if (oldModelClassName.equals(DanhMucGiayToClp.class.getName())) {
			return translateInputDanhMucGiayTo(oldModel);
		}

		if (oldModelClassName.equals(LichSuGiayToDinhKemClp.class.getName())) {
			return translateInputLichSuGiayToDinhKem(oldModel);
		}

		if (oldModelClassName.equals(TaiLieuChungThucClp.class.getName())) {
			return translateInputTaiLieuChungThuc(oldModel);
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

	public static Object translateInputDanhMucGiayTo(BaseModel<?> oldModel) {
		DanhMucGiayToClp oldCplModel = (DanhMucGiayToClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.tlct.model.impl.DanhMucGiayToImpl",
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

				Method method3 = newModelClass.getMethod("setMota",
						new Class[] { String.class });

				String value3 = oldCplModel.getMota();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setGioiHanDungLuong",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getGioiHanDungLuong());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setKieuTaiLieu",
						new Class[] { String.class });

				String value5 = oldCplModel.getKieuTaiLieu();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiTao();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgayTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value8 = oldCplModel.getNguoiSua();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgaySua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getDaXoa());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getPhienBan());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setTailieuThayTheId",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getTailieuThayTheId());

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

	public static Object translateInputLichSuGiayToDinhKem(
		BaseModel<?> oldModel) {
		LichSuGiayToDinhKemClp oldCplModel = (LichSuGiayToDinhKemClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.tlct.model.impl.LichSuGiayToDinhKemImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGiayToDinhKemHoSoId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getGiayToDinhKemHoSoId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setHanhDong",
						new Class[] { Integer.TYPE });

				Integer value2 = new Integer(oldCplModel.getHanhDong());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value3 = oldCplModel.getNguoiTao();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNoiLuuTruTaiLieuId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getNoiLuuTruTaiLieuId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgayTao();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setTenTaiLieu",
						new Class[] { String.class });

				String value6 = oldCplModel.getTenTaiLieu();

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

	public static Object translateInputTaiLieuChungThuc(BaseModel<?> oldModel) {
		TaiLieuChungThucClp oldCplModel = (TaiLieuChungThucClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.tlct.model.impl.TaiLieuChungThucImpl",
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

				Method method2 = newModelClass.getMethod("setGhiChu",
						new Class[] { String.class });

				String value2 = oldCplModel.getGhiChu();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNoiLuuTruId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getNoiLuuTruId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayUpload",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayUpload();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setPhienBan",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getPhienBan());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgayDuyet",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgayDuyet();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setHieuLucTuNgay",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getHieuLucTuNgay();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setHieuLucDenNgay",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getHieuLucDenNgay();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgaySua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value10 = oldCplModel.getNguoiSua();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setDanhMucGiayToId",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getDanhMucGiayToId());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value12 = new Integer(oldCplModel.getTrangThai());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setChuSohuuId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getChuSohuuId());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setNguoiUploadId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getNguoiUploadId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setNguoiduyetId",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getNguoiduyetId());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setHoSoTTHCCId",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getHoSoTTHCCId());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setMaUngDung",
						new Class[] { String.class });

				String value17 = oldCplModel.getMaUngDung();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setLoai",
						new Class[] { Integer.TYPE });

				Integer value18 = new Integer(oldCplModel.getLoai());

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
					"org.oep.cmon.dao.tlct.model.impl.DanhMucGiayToImpl")) {
			return translateOutputDanhMucGiayTo(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.tlct.model.impl.LichSuGiayToDinhKemImpl")) {
			return translateOutputLichSuGiayToDinhKem(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.tlct.model.impl.TaiLieuChungThucImpl")) {
			return translateOutputTaiLieuChungThuc(oldModel);
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

	public static Object translateOutputDanhMucGiayTo(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanhMucGiayToClp newModel = new DanhMucGiayToClp();

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

				Method method3 = oldModelClass.getMethod("getMota");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMota(value3);

				Method method4 = oldModelClass.getMethod("getGioiHanDungLuong");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setGioiHanDungLuong(value4);

				Method method5 = oldModelClass.getMethod("getKieuTaiLieu");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setKieuTaiLieu(value5);

				Method method6 = oldModelClass.getMethod("getNguoiTao");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value6);

				Method method7 = oldModelClass.getMethod("getNgayTao");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value7);

				Method method8 = oldModelClass.getMethod("getNguoiSua");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value8);

				Method method9 = oldModelClass.getMethod("getNgaySua");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value9);

				Method method10 = oldModelClass.getMethod("getDaXoa");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value10);

				Method method11 = oldModelClass.getMethod("getPhienBan");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value11);

				Method method12 = oldModelClass.getMethod("getTailieuThayTheId");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setTailieuThayTheId(value12);

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

	public static Object translateOutputLichSuGiayToDinhKem(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LichSuGiayToDinhKemClp newModel = new LichSuGiayToDinhKemClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod(
						"getGiayToDinhKemHoSoId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setGiayToDinhKemHoSoId(value1);

				Method method2 = oldModelClass.getMethod("getHanhDong");

				Integer value2 = (Integer)method2.invoke(oldModel,
						(Object[])null);

				newModel.setHanhDong(value2);

				Method method3 = oldModelClass.getMethod("getNguoiTao");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value3);

				Method method4 = oldModelClass.getMethod(
						"getNoiLuuTruTaiLieuId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setNoiLuuTruTaiLieuId(value4);

				Method method5 = oldModelClass.getMethod("getNgayTao");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value5);

				Method method6 = oldModelClass.getMethod("getTenTaiLieu");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setTenTaiLieu(value6);

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

	public static Object translateOutputTaiLieuChungThuc(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TaiLieuChungThucClp newModel = new TaiLieuChungThucClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTen");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTen(value1);

				Method method2 = oldModelClass.getMethod("getGhiChu");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setGhiChu(value2);

				Method method3 = oldModelClass.getMethod("getNoiLuuTruId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setNoiLuuTruId(value3);

				Method method4 = oldModelClass.getMethod("getNgayUpload");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayUpload(value4);

				Method method5 = oldModelClass.getMethod("getPhienBan");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setPhienBan(value5);

				Method method6 = oldModelClass.getMethod("getNgayDuyet");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgayDuyet(value6);

				Method method7 = oldModelClass.getMethod("getHieuLucTuNgay");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setHieuLucTuNgay(value7);

				Method method8 = oldModelClass.getMethod("getHieuLucDenNgay");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setHieuLucDenNgay(value8);

				Method method9 = oldModelClass.getMethod("getNgaySua");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value9);

				Method method10 = oldModelClass.getMethod("getNguoiSua");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value10);

				Method method11 = oldModelClass.getMethod("getDanhMucGiayToId");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setDanhMucGiayToId(value11);

				Method method12 = oldModelClass.getMethod("getTrangThai");

				Integer value12 = (Integer)method12.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value12);

				Method method13 = oldModelClass.getMethod("getChuSohuuId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setChuSohuuId(value13);

				Method method14 = oldModelClass.getMethod("getNguoiUploadId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setNguoiUploadId(value14);

				Method method15 = oldModelClass.getMethod("getNguoiduyetId");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setNguoiduyetId(value15);

				Method method16 = oldModelClass.getMethod("getHoSoTTHCCId");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setHoSoTTHCCId(value16);

				Method method17 = oldModelClass.getMethod("getMaUngDung");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setMaUngDung(value17);

				Method method18 = oldModelClass.getMethod("getLoai");

				Integer value18 = (Integer)method18.invoke(oldModel,
						(Object[])null);

				newModel.setLoai(value18);

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