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

package org.oep.cmon.dao.ttthanhtoan.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToanClp;
import org.oep.cmon.dao.ttthanhtoan.model.TienTeClp;

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

		if (oldModelClassName.equals(ThongTinThanhToanClp.class.getName())) {
			return translateInputThongTinThanhToan(oldModel);
		}

		if (oldModelClassName.equals(TienTeClp.class.getName())) {
			return translateInputTienTe(oldModel);
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

	public static Object translateInputThongTinThanhToan(BaseModel<?> oldModel) {
		ThongTinThanhToanClp oldCplModel = (ThongTinThanhToanClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.ttthanhtoan.model.impl.ThongTinThanhToanImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setHoSoTTHCCongId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getHoSoTTHCCongId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTaiKhoanNguoiDungNopId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getTaiKhoanNguoiDungNopId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTaiKhoanNguoiDungNhanId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getTaiKhoanNguoiDungNhanId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setLoaiThanhToan",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getLoaiThanhToan());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTenNguoiNopTien",
						new Class[] { String.class });

				String value5 = oldCplModel.getTenNguoiNopTien();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setTenCanBoNhanTien",
						new Class[] { String.class });

				String value6 = oldCplModel.getTenCanBoNhanTien();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setXacNhan",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getXacNhan());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setLoaiPhi",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getLoaiPhi());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setSoTien",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getSoTien());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNgayThuTien",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getNgayThuTien();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNgayXacNhan",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getNgayXacNhan();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setNgayChuyenTien",
						new Class[] { Date.class });

				Date value12 = oldCplModel.getNgayChuyenTien();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setYKien",
						new Class[] { String.class });

				String value13 = oldCplModel.getYKien();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setNoiLuuTruId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getNoiLuuTruId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value15 = oldCplModel.getNguoiTao();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value16 = oldCplModel.getNguoiSua();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value17 = oldCplModel.getNgayTao();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value18 = oldCplModel.getNgaySua();

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

	public static Object translateInputTienTe(BaseModel<?> oldModel) {
		TienTeClp oldCplModel = (TienTeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.ttthanhtoan.model.impl.TienTeImpl",
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

				Method method3 = newModelClass.getMethod("setTyGia",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getTyGia());

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

				Method method8 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getTrangThai());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setPhienBan",
						new Class[] { Integer.TYPE });

				Integer value9 = new Integer(oldCplModel.getPhienBan());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getDaXoa());

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
					"org.oep.cmon.dao.ttthanhtoan.model.impl.ThongTinThanhToanImpl")) {
			return translateOutputThongTinThanhToan(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.ttthanhtoan.model.impl.TienTeImpl")) {
			return translateOutputTienTe(oldModel);
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

	public static Object translateOutputThongTinThanhToan(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ThongTinThanhToanClp newModel = new ThongTinThanhToanClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getHoSoTTHCCongId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setHoSoTTHCCongId(value1);

				Method method2 = oldModelClass.getMethod(
						"getTaiKhoanNguoiDungNopId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setTaiKhoanNguoiDungNopId(value2);

				Method method3 = oldModelClass.getMethod(
						"getTaiKhoanNguoiDungNhanId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setTaiKhoanNguoiDungNhanId(value3);

				Method method4 = oldModelClass.getMethod("getLoaiThanhToan");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setLoaiThanhToan(value4);

				Method method5 = oldModelClass.getMethod("getTenNguoiNopTien");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setTenNguoiNopTien(value5);

				Method method6 = oldModelClass.getMethod("getTenCanBoNhanTien");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setTenCanBoNhanTien(value6);

				Method method7 = oldModelClass.getMethod("getXacNhan");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setXacNhan(value7);

				Method method8 = oldModelClass.getMethod("getLoaiPhi");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setLoaiPhi(value8);

				Method method9 = oldModelClass.getMethod("getSoTien");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setSoTien(value9);

				Method method10 = oldModelClass.getMethod("getNgayThuTien");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setNgayThuTien(value10);

				Method method11 = oldModelClass.getMethod("getNgayXacNhan");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setNgayXacNhan(value11);

				Method method12 = oldModelClass.getMethod("getNgayChuyenTien");

				Date value12 = (Date)method12.invoke(oldModel, (Object[])null);

				newModel.setNgayChuyenTien(value12);

				Method method13 = oldModelClass.getMethod("getYKien");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setYKien(value13);

				Method method14 = oldModelClass.getMethod("getNoiLuuTruId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setNoiLuuTruId(value14);

				Method method15 = oldModelClass.getMethod("getNguoiTao");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value15);

				Method method16 = oldModelClass.getMethod("getNguoiSua");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value16);

				Method method17 = oldModelClass.getMethod("getNgayTao");

				Date value17 = (Date)method17.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value17);

				Method method18 = oldModelClass.getMethod("getNgaySua");

				Date value18 = (Date)method18.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value18);

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

	public static Object translateOutputTienTe(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TienTeClp newModel = new TienTeClp();

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

				Method method3 = oldModelClass.getMethod("getTyGia");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setTyGia(value3);

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

				Method method8 = oldModelClass.getMethod("getTrangThai");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value8);

				Method method9 = oldModelClass.getMethod("getPhienBan");

				Integer value9 = (Integer)method9.invoke(oldModel,
						(Object[])null);

				newModel.setPhienBan(value9);

				Method method10 = oldModelClass.getMethod("getDaXoa");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value10);

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