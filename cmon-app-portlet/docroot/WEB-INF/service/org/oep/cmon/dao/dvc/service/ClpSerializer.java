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

package org.oep.cmon.dao.dvc.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.dvc.model.CapNhatKetQuaClp;
import org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTucClp;
import org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDungClp;
import org.oep.cmon.dao.dvc.model.DanhMucUngDungClp;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDungClp;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinhClp;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLyClp;
import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDungClp;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayToClp;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhClp;
import org.oep.cmon.dao.dvc.model.VanBanHuongDanClp;

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

		if (oldModelClassName.equals(CapNhatKetQuaClp.class.getName())) {
			return translateInputCapNhatKetQua(oldModel);
		}

		if (oldModelClassName.equals(CauHinhPortlet2ThuTucClp.class.getName())) {
			return translateInputCauHinhPortlet2ThuTuc(oldModel);
		}

		if (oldModelClassName.equals(
					DanhMucGiayTo2DoiTuongSuDungClp.class.getName())) {
			return translateInputDanhMucGiayTo2DoiTuongSuDung(oldModel);
		}

		if (oldModelClassName.equals(DanhMucUngDungClp.class.getName())) {
			return translateInputDanhMucUngDung(oldModel);
		}

		if (oldModelClassName.equals(DoiTuongSuDungClp.class.getName())) {
			return translateInputDoiTuongSuDung(oldModel);
		}

		if (oldModelClassName.equals(NhomThuTucHanhChinhClp.class.getName())) {
			return translateInputNhomThuTucHanhChinh(oldModel);
		}

		if (oldModelClassName.equals(ThuTuc2GiayToClp.class.getName())) {
			return translateInputThuTuc2GiayTo(oldModel);
		}

		if (oldModelClassName.equals(ThuTucHanhChinhClp.class.getName())) {
			return translateInputThuTucHanhChinh(oldModel);
		}

		if (oldModelClassName.equals(TTHC2CoQuanQuanLyClp.class.getName())) {
			return translateInputTTHC2CoQuanQuanLy(oldModel);
		}

		if (oldModelClassName.equals(TTHC2DoiTuongSuDungClp.class.getName())) {
			return translateInputTTHC2DoiTuongSuDung(oldModel);
		}

		if (oldModelClassName.equals(VanBanHuongDanClp.class.getName())) {
			return translateInputVanBanHuongDan(oldModel);
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

	public static Object translateInputCapNhatKetQua(BaseModel<?> oldModel) {
		CapNhatKetQuaClp oldCplModel = (CapNhatKetQuaClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.CapNhatKetQuaImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTenBang",
						new Class[] { String.class });

				String value1 = oldCplModel.getTenBang();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setBanGhiId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getBanGhiId());

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

				Method method9 = newModelClass.getMethod("setHosoTTHCCId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getHosoTTHCCId());

				method9.invoke(newModel, value9);

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

	public static Object translateInputCauHinhPortlet2ThuTuc(
		BaseModel<?> oldModel) {
		CauHinhPortlet2ThuTucClp oldCplModel = (CauHinhPortlet2ThuTucClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.CauHinhPortlet2ThuTucImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getThuTucHanhChinhId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setPortletId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getPortletId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setPortletName",
						new Class[] { String.class });

				String value2 = oldCplModel.getPortletName();

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

	public static Object translateInputDanhMucGiayTo2DoiTuongSuDung(
		BaseModel<?> oldModel) {
		DanhMucGiayTo2DoiTuongSuDungClp oldCplModel = (DanhMucGiayTo2DoiTuongSuDungClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.DanhMucGiayTo2DoiTuongSuDungImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getNgayTao();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getNgaySua();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getDaXoa());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoiSua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setLoaiDoiTuongId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getLoaiDoiTuongId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setLoaiGiayToId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getLoaiGiayToId());

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

	public static Object translateInputDanhMucUngDung(BaseModel<?> oldModel) {
		DanhMucUngDungClp oldCplModel = (DanhMucUngDungClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.DanhMucUngDungImpl",
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

				Method method3 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayTao();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgaySua();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getDaXoa());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiSua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiTao();

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

	public static Object translateInputDoiTuongSuDung(BaseModel<?> oldModel) {
		DoiTuongSuDungClp oldCplModel = (DoiTuongSuDungClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.DoiTuongSuDungImpl",
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

				Method method2 = newModelClass.getMethod("setMa",
						new Class[] { String.class });

				String value2 = oldCplModel.getMa();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMota",
						new Class[] { String.class });

				String value3 = oldCplModel.getMota();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgayTao();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiSua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgaySua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getTrangThai());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value9 = new Integer(oldCplModel.getDaXoa());

				method9.invoke(newModel, value9);

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

	public static Object translateInputNhomThuTucHanhChinh(
		BaseModel<?> oldModel) {
		NhomThuTucHanhChinhClp oldCplModel = (NhomThuTucHanhChinhClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.NhomThuTucHanhChinhImpl",
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

				Method method3 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayTao();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgaySua();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getDaXoa());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiSua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDanhMucUngDungId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getDanhMucUngDungId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getPhienBan());

				method9.invoke(newModel, value9);

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

	public static Object translateInputThuTuc2GiayTo(BaseModel<?> oldModel) {
		ThuTuc2GiayToClp oldCplModel = (ThuTuc2GiayToClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.ThuTuc2GiayToImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setGhiChu",
						new Class[] { String.class });

				String value1 = oldCplModel.getGhiChu();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setBatBuoc",
						new Class[] { Integer.TYPE });

				Integer value2 = new Integer(oldCplModel.getBatBuoc());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setThuTuHienThi",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getThuTuHienThi());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgaySua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getDaXoa());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value8 = oldCplModel.getNguoiSua();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getThuTucHanhChinhId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDanhMucGiayToId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getDanhMucGiayToId());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value11 = new Integer(oldCplModel.getTrangThai());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setGiaidoan",
						new Class[] { Integer.TYPE });

				Integer value12 = new Integer(oldCplModel.getGiaidoan());

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

	public static Object translateInputThuTucHanhChinh(BaseModel<?> oldModel) {
		ThuTucHanhChinhClp oldCplModel = (ThuTucHanhChinhClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.ThuTucHanhChinhImpl",
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

				Method method3 = newModelClass.getMethod("setSoNgayXuLy",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getSoNgayXuLy());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgaySua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getDaXoa());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value8 = oldCplModel.getNguoiSua();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNhomThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getNhomThuTucHanhChinhId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getTrangThai());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getPhienBan());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setCanTichHop",
						new Class[] { Integer.TYPE });

				Integer value12 = new Integer(oldCplModel.getCanTichHop());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setTrinhTuThucHien",
						new Class[] { String.class });

				String value13 = oldCplModel.getTrinhTuThucHien();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setCachThucHien",
						new Class[] { String.class });

				String value14 = oldCplModel.getCachThucHien();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setThanhPhanHoSo",
						new Class[] { String.class });

				String value15 = oldCplModel.getThanhPhanHoSo();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setLePhi",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getLePhi());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setDonViLePhi",
						new Class[] { String.class });

				String value17 = oldCplModel.getDonViLePhi();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setPhi",
						new Class[] { Long.TYPE });

				Long value18 = new Long(oldCplModel.getPhi());

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setDonViPhi",
						new Class[] { String.class });

				String value19 = oldCplModel.getDonViPhi();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setTenMauDonToKhai",
						new Class[] { String.class });

				String value20 = oldCplModel.getTenMauDonToKhai();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setYeuCauDieuKienThucHien",
						new Class[] { String.class });

				String value21 = oldCplModel.getYeuCauDieuKienThucHien();

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setCanCuPhapLy",
						new Class[] { String.class });

				String value22 = oldCplModel.getCanCuPhapLy();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setCapCoQuanQuanLyId",
						new Class[] { Long.TYPE });

				Long value23 = new Long(oldCplModel.getCapCoQuanQuanLyId());

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setLinhVucThucHien",
						new Class[] { String.class });

				String value24 = oldCplModel.getLinhVucThucHien();

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setMaDNG",
						new Class[] { String.class });

				String value25 = oldCplModel.getMaDNG();

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setUengineProcessName",
						new Class[] { String.class });

				String value26 = oldCplModel.getUengineProcessName();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setThuTucLienThongId",
						new Class[] { Long.TYPE });

				Long value27 = new Long(oldCplModel.getThuTucLienThongId());

				method27.invoke(newModel, value27);

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

	public static Object translateInputTTHC2CoQuanQuanLy(BaseModel<?> oldModel) {
		TTHC2CoQuanQuanLyClp oldCplModel = (TTHC2CoQuanQuanLyClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.TTHC2CoQuanQuanLyImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getNgayTao();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getNgaySua();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getDaXoa());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoiSua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setSoNgayXyLy",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getSoNgayXyLy());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getThuTucHanhChinhId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setCoQuanQuanLyId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getCoQuanQuanLyId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value9 = new Integer(oldCplModel.getTrangThai());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setPhi",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getPhi());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setLePhi",
						new Class[] { Integer.TYPE });

				Integer value11 = new Integer(oldCplModel.getLePhi());

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

	public static Object translateInputTTHC2DoiTuongSuDung(
		BaseModel<?> oldModel) {
		TTHC2DoiTuongSuDungClp oldCplModel = (TTHC2DoiTuongSuDungClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.TTHC2DoiTuongSuDungImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getNgayTao();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getNgaySua();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getDaXoa());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoiSua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getThuTucHanhChinhId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setLoaiDoiTuongId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getLoaiDoiTuongId());

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

	public static Object translateInputVanBanHuongDan(BaseModel<?> oldModel) {
		VanBanHuongDanClp oldCplModel = (VanBanHuongDanClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.dvc.model.impl.VanBanHuongDanImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNoiLuuTruId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getNoiLuuTruId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTenTaiLieu",
						new Class[] { String.class });

				String value2 = oldCplModel.getTenTaiLieu();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMoTa",
						new Class[] { String.class });

				String value3 = oldCplModel.getMoTa();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setLoaiTaiLieu",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getLoaiTaiLieu());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgayTao();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgaySua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getDaXoa());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value8 = oldCplModel.getNguoiTao();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value9 = oldCplModel.getNguoiSua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getThuTucHanhChinhId());

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
					"org.oep.cmon.dao.dvc.model.impl.CapNhatKetQuaImpl")) {
			return translateOutputCapNhatKetQua(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.CauHinhPortlet2ThuTucImpl")) {
			return translateOutputCauHinhPortlet2ThuTuc(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.DanhMucGiayTo2DoiTuongSuDungImpl")) {
			return translateOutputDanhMucGiayTo2DoiTuongSuDung(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.DanhMucUngDungImpl")) {
			return translateOutputDanhMucUngDung(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.DoiTuongSuDungImpl")) {
			return translateOutputDoiTuongSuDung(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.NhomThuTucHanhChinhImpl")) {
			return translateOutputNhomThuTucHanhChinh(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.ThuTuc2GiayToImpl")) {
			return translateOutputThuTuc2GiayTo(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.ThuTucHanhChinhImpl")) {
			return translateOutputThuTucHanhChinh(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.TTHC2CoQuanQuanLyImpl")) {
			return translateOutputTTHC2CoQuanQuanLy(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.TTHC2DoiTuongSuDungImpl")) {
			return translateOutputTTHC2DoiTuongSuDung(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.dvc.model.impl.VanBanHuongDanImpl")) {
			return translateOutputVanBanHuongDan(oldModel);
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

	public static Object translateOutputCapNhatKetQua(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CapNhatKetQuaClp newModel = new CapNhatKetQuaClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTenBang");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTenBang(value1);

				Method method2 = oldModelClass.getMethod("getBanGhiId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setBanGhiId(value2);

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

				Method method9 = oldModelClass.getMethod("getHosoTTHCCId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setHosoTTHCCId(value9);

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

	public static Object translateOutputCauHinhPortlet2ThuTuc(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CauHinhPortlet2ThuTucClp newModel = new CauHinhPortlet2ThuTucClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getThuTucHanhChinhId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setThuTucHanhChinhId(value0);

				Method method1 = oldModelClass.getMethod("getPortletId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setPortletId(value1);

				Method method2 = oldModelClass.getMethod("getPortletName");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setPortletName(value2);

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

	public static Object translateOutputDanhMucGiayTo2DoiTuongSuDung(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanhMucGiayTo2DoiTuongSuDungClp newModel = new DanhMucGiayTo2DoiTuongSuDungClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNgayTao");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value1);

				Method method2 = oldModelClass.getMethod("getNgaySua");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value2);

				Method method3 = oldModelClass.getMethod("getDaXoa");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value3);

				Method method4 = oldModelClass.getMethod("getNguoiTao");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value4);

				Method method5 = oldModelClass.getMethod("getNguoiSua");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value5);

				Method method6 = oldModelClass.getMethod("getLoaiDoiTuongId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setLoaiDoiTuongId(value6);

				Method method7 = oldModelClass.getMethod("getLoaiGiayToId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setLoaiGiayToId(value7);

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

	public static Object translateOutputDanhMucUngDung(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanhMucUngDungClp newModel = new DanhMucUngDungClp();

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

				Method method3 = oldModelClass.getMethod("getNgayTao");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value3);

				Method method4 = oldModelClass.getMethod("getNgaySua");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value4);

				Method method5 = oldModelClass.getMethod("getDaXoa");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value5);

				Method method6 = oldModelClass.getMethod("getNguoiSua");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value6);

				Method method7 = oldModelClass.getMethod("getNguoiTao");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value7);

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

	public static Object translateOutputDoiTuongSuDung(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DoiTuongSuDungClp newModel = new DoiTuongSuDungClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTen");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTen(value1);

				Method method2 = oldModelClass.getMethod("getMa");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMa(value2);

				Method method3 = oldModelClass.getMethod("getMota");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMota(value3);

				Method method4 = oldModelClass.getMethod("getNguoiTao");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value4);

				Method method5 = oldModelClass.getMethod("getNgayTao");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value5);

				Method method6 = oldModelClass.getMethod("getNguoiSua");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value6);

				Method method7 = oldModelClass.getMethod("getNgaySua");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value7);

				Method method8 = oldModelClass.getMethod("getTrangThai");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value8);

				Method method9 = oldModelClass.getMethod("getDaXoa");

				Integer value9 = (Integer)method9.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value9);

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

	public static Object translateOutputNhomThuTucHanhChinh(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				NhomThuTucHanhChinhClp newModel = new NhomThuTucHanhChinhClp();

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

				Method method3 = oldModelClass.getMethod("getNgayTao");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value3);

				Method method4 = oldModelClass.getMethod("getNgaySua");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value4);

				Method method5 = oldModelClass.getMethod("getDaXoa");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value5);

				Method method6 = oldModelClass.getMethod("getNguoiSua");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value6);

				Method method7 = oldModelClass.getMethod("getNguoiTao");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value7);

				Method method8 = oldModelClass.getMethod("getDanhMucUngDungId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setDanhMucUngDungId(value8);

				Method method9 = oldModelClass.getMethod("getPhienBan");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value9);

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

	public static Object translateOutputThuTuc2GiayTo(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ThuTuc2GiayToClp newModel = new ThuTuc2GiayToClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getGhiChu");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setGhiChu(value1);

				Method method2 = oldModelClass.getMethod("getBatBuoc");

				Integer value2 = (Integer)method2.invoke(oldModel,
						(Object[])null);

				newModel.setBatBuoc(value2);

				Method method3 = oldModelClass.getMethod("getThuTuHienThi");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setThuTuHienThi(value3);

				Method method4 = oldModelClass.getMethod("getNgayTao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value4);

				Method method5 = oldModelClass.getMethod("getNgaySua");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value5);

				Method method6 = oldModelClass.getMethod("getDaXoa");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value6);

				Method method7 = oldModelClass.getMethod("getNguoiTao");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value7);

				Method method8 = oldModelClass.getMethod("getNguoiSua");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value8);

				Method method9 = oldModelClass.getMethod("getThuTucHanhChinhId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setThuTucHanhChinhId(value9);

				Method method10 = oldModelClass.getMethod("getDanhMucGiayToId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setDanhMucGiayToId(value10);

				Method method11 = oldModelClass.getMethod("getTrangThai");

				Integer value11 = (Integer)method11.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value11);

				Method method12 = oldModelClass.getMethod("getGiaidoan");

				Integer value12 = (Integer)method12.invoke(oldModel,
						(Object[])null);

				newModel.setGiaidoan(value12);

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

	public static Object translateOutputThuTucHanhChinh(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ThuTucHanhChinhClp newModel = new ThuTucHanhChinhClp();

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

				Method method3 = oldModelClass.getMethod("getSoNgayXuLy");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setSoNgayXuLy(value3);

				Method method4 = oldModelClass.getMethod("getNgayTao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value4);

				Method method5 = oldModelClass.getMethod("getNgaySua");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value5);

				Method method6 = oldModelClass.getMethod("getDaXoa");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value6);

				Method method7 = oldModelClass.getMethod("getNguoiTao");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value7);

				Method method8 = oldModelClass.getMethod("getNguoiSua");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value8);

				Method method9 = oldModelClass.getMethod(
						"getNhomThuTucHanhChinhId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setNhomThuTucHanhChinhId(value9);

				Method method10 = oldModelClass.getMethod("getTrangThai");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value10);

				Method method11 = oldModelClass.getMethod("getPhienBan");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value11);

				Method method12 = oldModelClass.getMethod("getCanTichHop");

				Integer value12 = (Integer)method12.invoke(oldModel,
						(Object[])null);

				newModel.setCanTichHop(value12);

				Method method13 = oldModelClass.getMethod("getTrinhTuThucHien");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setTrinhTuThucHien(value13);

				Method method14 = oldModelClass.getMethod("getCachThucHien");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setCachThucHien(value14);

				Method method15 = oldModelClass.getMethod("getThanhPhanHoSo");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setThanhPhanHoSo(value15);

				Method method16 = oldModelClass.getMethod("getLePhi");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setLePhi(value16);

				Method method17 = oldModelClass.getMethod("getDonViLePhi");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setDonViLePhi(value17);

				Method method18 = oldModelClass.getMethod("getPhi");

				Long value18 = (Long)method18.invoke(oldModel, (Object[])null);

				newModel.setPhi(value18);

				Method method19 = oldModelClass.getMethod("getDonViPhi");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setDonViPhi(value19);

				Method method20 = oldModelClass.getMethod("getTenMauDonToKhai");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setTenMauDonToKhai(value20);

				Method method21 = oldModelClass.getMethod(
						"getYeuCauDieuKienThucHien");

				String value21 = (String)method21.invoke(oldModel,
						(Object[])null);

				newModel.setYeuCauDieuKienThucHien(value21);

				Method method22 = oldModelClass.getMethod("getCanCuPhapLy");

				String value22 = (String)method22.invoke(oldModel,
						(Object[])null);

				newModel.setCanCuPhapLy(value22);

				Method method23 = oldModelClass.getMethod(
						"getCapCoQuanQuanLyId");

				Long value23 = (Long)method23.invoke(oldModel, (Object[])null);

				newModel.setCapCoQuanQuanLyId(value23);

				Method method24 = oldModelClass.getMethod("getLinhVucThucHien");

				String value24 = (String)method24.invoke(oldModel,
						(Object[])null);

				newModel.setLinhVucThucHien(value24);

				Method method25 = oldModelClass.getMethod("getMaDNG");

				String value25 = (String)method25.invoke(oldModel,
						(Object[])null);

				newModel.setMaDNG(value25);

				Method method26 = oldModelClass.getMethod(
						"getUengineProcessName");

				String value26 = (String)method26.invoke(oldModel,
						(Object[])null);

				newModel.setUengineProcessName(value26);

				Method method27 = oldModelClass.getMethod(
						"getThuTucLienThongId");

				Long value27 = (Long)method27.invoke(oldModel, (Object[])null);

				newModel.setThuTucLienThongId(value27);

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

	public static Object translateOutputTTHC2CoQuanQuanLy(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TTHC2CoQuanQuanLyClp newModel = new TTHC2CoQuanQuanLyClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNgayTao");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value1);

				Method method2 = oldModelClass.getMethod("getNgaySua");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value2);

				Method method3 = oldModelClass.getMethod("getDaXoa");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value3);

				Method method4 = oldModelClass.getMethod("getNguoiTao");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value4);

				Method method5 = oldModelClass.getMethod("getNguoiSua");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value5);

				Method method6 = oldModelClass.getMethod("getSoNgayXyLy");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setSoNgayXyLy(value6);

				Method method7 = oldModelClass.getMethod("getThuTucHanhChinhId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setThuTucHanhChinhId(value7);

				Method method8 = oldModelClass.getMethod("getCoQuanQuanLyId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setCoQuanQuanLyId(value8);

				Method method9 = oldModelClass.getMethod("getTrangThai");

				Integer value9 = (Integer)method9.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value9);

				Method method10 = oldModelClass.getMethod("getPhi");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setPhi(value10);

				Method method11 = oldModelClass.getMethod("getLePhi");

				Integer value11 = (Integer)method11.invoke(oldModel,
						(Object[])null);

				newModel.setLePhi(value11);

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

	public static Object translateOutputTTHC2DoiTuongSuDung(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TTHC2DoiTuongSuDungClp newModel = new TTHC2DoiTuongSuDungClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNgayTao");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value1);

				Method method2 = oldModelClass.getMethod("getNgaySua");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value2);

				Method method3 = oldModelClass.getMethod("getDaXoa");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value3);

				Method method4 = oldModelClass.getMethod("getNguoiTao");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value4);

				Method method5 = oldModelClass.getMethod("getNguoiSua");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value5);

				Method method6 = oldModelClass.getMethod("getThuTucHanhChinhId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setThuTucHanhChinhId(value6);

				Method method7 = oldModelClass.getMethod("getLoaiDoiTuongId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setLoaiDoiTuongId(value7);

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

	public static Object translateOutputVanBanHuongDan(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VanBanHuongDanClp newModel = new VanBanHuongDanClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNoiLuuTruId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setNoiLuuTruId(value1);

				Method method2 = oldModelClass.getMethod("getTenTaiLieu");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTenTaiLieu(value2);

				Method method3 = oldModelClass.getMethod("getMoTa");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMoTa(value3);

				Method method4 = oldModelClass.getMethod("getLoaiTaiLieu");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setLoaiTaiLieu(value4);

				Method method5 = oldModelClass.getMethod("getNgayTao");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value5);

				Method method6 = oldModelClass.getMethod("getNgaySua");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value6);

				Method method7 = oldModelClass.getMethod("getDaXoa");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value7);

				Method method8 = oldModelClass.getMethod("getNguoiTao");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value8);

				Method method9 = oldModelClass.getMethod("getNguoiSua");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value9);

				Method method10 = oldModelClass.getMethod(
						"getThuTucHanhChinhId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setThuTucHanhChinhId(value10);

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