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

package org.oep.cmon.dao.qlhc.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLyClp;
import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinhClp;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTroClp;
import org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiepClp;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLyClp;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinhClp;
import org.oep.cmon.dao.qlhc.model.QuocGiaClp;

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

		if (oldModelClassName.equals(CapCoQuanQuanLyClp.class.getName())) {
			return translateInputCapCoQuanQuanLy(oldModel);
		}

		if (oldModelClassName.equals(CapDonViHanhChinhClp.class.getName())) {
			return translateInputCapDonViHanhChinh(oldModel);
		}

		if (oldModelClassName.equals(ChucVu2VaiTroClp.class.getName())) {
			return translateInputChucVu2VaiTro(oldModel);
		}

		if (oldModelClassName.equals(CoQuanHanhChinhSuNghiepClp.class.getName())) {
			return translateInputCoQuanHanhChinhSuNghiep(oldModel);
		}

		if (oldModelClassName.equals(CoQuanQuanLyClp.class.getName())) {
			return translateInputCoQuanQuanLy(oldModel);
		}

		if (oldModelClassName.equals(DonViHanhChinhClp.class.getName())) {
			return translateInputDonViHanhChinh(oldModel);
		}

		if (oldModelClassName.equals(QuocGiaClp.class.getName())) {
			return translateInputQuocGia(oldModel);
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

	public static Object translateInputCapCoQuanQuanLy(BaseModel<?> oldModel) {
		CapCoQuanQuanLyClp oldCplModel = (CapCoQuanQuanLyClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.qlhc.model.impl.CapCoQuanQuanLyImpl",
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

				Method method3 = newModelClass.getMethod("setCap",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCap());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setChaId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getChaId());

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

				Method method8 = newModelClass.getMethod("setPhienBan",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getPhienBan());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value9 = oldCplModel.getNguoiTao();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value10 = oldCplModel.getNguoiSua();

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

	public static Object translateInputCapDonViHanhChinh(BaseModel<?> oldModel) {
		CapDonViHanhChinhClp oldCplModel = (CapDonViHanhChinhClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.qlhc.model.impl.CapDonViHanhChinhImpl",
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

				Method method3 = newModelClass.getMethod("setCap",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCap());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getPhienBan());

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

				Method method10 = newModelClass.getMethod("setMota",
						new Class[] { String.class });

				String value10 = oldCplModel.getMota();

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

	public static Object translateInputChucVu2VaiTro(BaseModel<?> oldModel) {
		ChucVu2VaiTroClp oldCplModel = (ChucVu2VaiTroClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.qlhc.model.impl.ChucVu2VaiTroImpl",
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

				Method method6 = newModelClass.getMethod("setVaiTroId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getVaiTroId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCoQuanQuanLyId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getCoQuanQuanLyId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setChucVuId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getChucVuId());

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

	public static Object translateInputCoQuanHanhChinhSuNghiep(
		BaseModel<?> oldModel) {
		CoQuanHanhChinhSuNghiepClp oldCplModel = (CoQuanHanhChinhSuNghiepClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.qlhc.model.impl.CoQuanHanhChinhSuNghiepImpl",
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

				Method method3 = newModelClass.getMethod("setSoDTDuongDayNong",
						new Class[] { String.class });

				String value3 = oldCplModel.getSoDTDuongDayNong();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNoiBo",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getNoiBo());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setChucNang",
						new Class[] { String.class });

				String value5 = oldCplModel.getChucNang();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setTongSoCBNV",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getTongSoCBNV());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setSoDT",
						new Class[] { String.class });

				String value7 = oldCplModel.getSoDT();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setFax",
						new Class[] { String.class });

				String value8 = oldCplModel.getFax();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value9 = oldCplModel.getEmail();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setTongSoGiuongBenh",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getTongSoGiuongBenh());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setViDo",
						new Class[] { String.class });

				String value11 = oldCplModel.getViDo();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setKinhDo",
						new Class[] { String.class });

				String value12 = oldCplModel.getKinhDo();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setDiaChiCoQuanHCSNXaId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getDiaChiCoQuanHCSNXaId());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setTuyenId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getTuyenId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setDiaChiCoQuanHCSNTinhId",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getDiaChiCoQuanHCSNTinhId());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setNguoiDaiDienId",
						new Class[] { Long.TYPE });

				Long value16 = new Long(oldCplModel.getNguoiDaiDienId());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setDiaChiCoQuanHCSNHuyenId",
						new Class[] { Long.TYPE });

				Long value17 = new Long(oldCplModel.getDiaChiCoQuanHCSNHuyenId());

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setHangId",
						new Class[] { Long.TYPE });

				Long value18 = new Long(oldCplModel.getHangId());

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setCoQuanQuanLyId",
						new Class[] { String.class });

				String value19 = oldCplModel.getCoQuanQuanLyId();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setLoaiId",
						new Class[] { String.class });

				String value20 = oldCplModel.getLoaiId();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setSoQdThanhLap",
						new Class[] { String.class });

				String value21 = oldCplModel.getSoQdThanhLap();

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setMoTaDiaChi",
						new Class[] { String.class });

				String value22 = oldCplModel.getMoTaDiaChi();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setTenNguoiDaiDien",
						new Class[] { String.class });

				String value23 = oldCplModel.getTenNguoiDaiDien();

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value24 = oldCplModel.getNgayTao();

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value25 = new Integer(oldCplModel.getDaXoa());

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value26 = oldCplModel.getNgaySua();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setChaId",
						new Class[] { Long.TYPE });

				Long value27 = new Long(oldCplModel.getChaId());

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value28 = oldCplModel.getNguoiTao();

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value29 = oldCplModel.getNguoiSua();

				method29.invoke(newModel, value29);

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

	public static Object translateInputCoQuanQuanLy(BaseModel<?> oldModel) {
		CoQuanQuanLyClp oldCplModel = (CoQuanQuanLyClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl",
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

				Method method3 = newModelClass.getMethod("setDiaChi",
						new Class[] { String.class });

				String value3 = oldCplModel.getDiaChi();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDienThoai",
						new Class[] { String.class });

				String value4 = oldCplModel.getDienThoai();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value5 = oldCplModel.getEmail();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setFax",
						new Class[] { String.class });

				String value6 = oldCplModel.getFax();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setWebsite",
						new Class[] { String.class });

				String value7 = oldCplModel.getWebsite();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNoiBo",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getNoiBo());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getPhienBan());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getDaXoa());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setDonViHanhChinhId",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getDonViHanhChinhId());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setCapCoQuanQuanlyId",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getCapCoQuanQuanlyId());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setChaId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getChaId());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value14 = oldCplModel.getNguoiTao();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value15 = oldCplModel.getNgayTao();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value16 = oldCplModel.getNguoiSua();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value17 = oldCplModel.getNgaySua();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setMerchant",
						new Class[] { String.class });

				String value18 = oldCplModel.getMerchant();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setAccessCode",
						new Class[] { String.class });

				String value19 = oldCplModel.getAccessCode();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setSecureSecret",
						new Class[] { String.class });

				String value20 = oldCplModel.getSecureSecret();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setMaCapSoBienNhan",
						new Class[] { String.class });

				String value21 = oldCplModel.getMaCapSoBienNhan();

				method21.invoke(newModel, value21);

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

	public static Object translateInputDonViHanhChinh(BaseModel<?> oldModel) {
		DonViHanhChinhClp oldCplModel = (DonViHanhChinhClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.qlhc.model.impl.DonViHanhChinhImpl",
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

				Method method4 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getPhienBan());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getDaXoa());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgaySua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCapDonViHanhChinhId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getCapDonViHanhChinhId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setChaId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getChaId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value9 = oldCplModel.getNguoiTao();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setQuocGiaId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getQuocGiaId());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value11 = oldCplModel.getNguoiSua();

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

	public static Object translateInputQuocGia(BaseModel<?> oldModel) {
		QuocGiaClp oldCplModel = (QuocGiaClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.qlhc.model.impl.QuocGiaImpl",
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

				Method method6 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiTao();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiSua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setPhienBan",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getPhienBan());

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
					"org.oep.cmon.dao.qlhc.model.impl.CapCoQuanQuanLyImpl")) {
			return translateOutputCapCoQuanQuanLy(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.qlhc.model.impl.CapDonViHanhChinhImpl")) {
			return translateOutputCapDonViHanhChinh(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.qlhc.model.impl.ChucVu2VaiTroImpl")) {
			return translateOutputChucVu2VaiTro(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.qlhc.model.impl.CoQuanHanhChinhSuNghiepImpl")) {
			return translateOutputCoQuanHanhChinhSuNghiep(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl")) {
			return translateOutputCoQuanQuanLy(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.qlhc.model.impl.DonViHanhChinhImpl")) {
			return translateOutputDonViHanhChinh(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.qlhc.model.impl.QuocGiaImpl")) {
			return translateOutputQuocGia(oldModel);
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

	public static Object translateOutputCapCoQuanQuanLy(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CapCoQuanQuanLyClp newModel = new CapCoQuanQuanLyClp();

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

				Method method3 = oldModelClass.getMethod("getCap");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCap(value3);

				Method method4 = oldModelClass.getMethod("getChaId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setChaId(value4);

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

				Method method8 = oldModelClass.getMethod("getPhienBan");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setPhienBan(value8);

				Method method9 = oldModelClass.getMethod("getNguoiTao");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value9);

				Method method10 = oldModelClass.getMethod("getNguoiSua");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value10);

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

	public static Object translateOutputCapDonViHanhChinh(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CapDonViHanhChinhClp newModel = new CapDonViHanhChinhClp();

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

				Method method3 = oldModelClass.getMethod("getCap");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCap(value3);

				Method method4 = oldModelClass.getMethod("getPhienBan");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value4);

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

				Method method10 = oldModelClass.getMethod("getMota");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setMota(value10);

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

	public static Object translateOutputChucVu2VaiTro(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ChucVu2VaiTroClp newModel = new ChucVu2VaiTroClp();

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

				Method method6 = oldModelClass.getMethod("getVaiTroId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setVaiTroId(value6);

				Method method7 = oldModelClass.getMethod("getCoQuanQuanLyId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setCoQuanQuanLyId(value7);

				Method method8 = oldModelClass.getMethod("getChucVuId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setChucVuId(value8);

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

	public static Object translateOutputCoQuanHanhChinhSuNghiep(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CoQuanHanhChinhSuNghiepClp newModel = new CoQuanHanhChinhSuNghiepClp();

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

				Method method3 = oldModelClass.getMethod("getSoDTDuongDayNong");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setSoDTDuongDayNong(value3);

				Method method4 = oldModelClass.getMethod("getNoiBo");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setNoiBo(value4);

				Method method5 = oldModelClass.getMethod("getChucNang");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setChucNang(value5);

				Method method6 = oldModelClass.getMethod("getTongSoCBNV");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setTongSoCBNV(value6);

				Method method7 = oldModelClass.getMethod("getSoDT");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setSoDT(value7);

				Method method8 = oldModelClass.getMethod("getFax");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setFax(value8);

				Method method9 = oldModelClass.getMethod("getEmail");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setEmail(value9);

				Method method10 = oldModelClass.getMethod("getTongSoGiuongBenh");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setTongSoGiuongBenh(value10);

				Method method11 = oldModelClass.getMethod("getViDo");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setViDo(value11);

				Method method12 = oldModelClass.getMethod("getKinhDo");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setKinhDo(value12);

				Method method13 = oldModelClass.getMethod(
						"getDiaChiCoQuanHCSNXaId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setDiaChiCoQuanHCSNXaId(value13);

				Method method14 = oldModelClass.getMethod("getTuyenId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setTuyenId(value14);

				Method method15 = oldModelClass.getMethod(
						"getDiaChiCoQuanHCSNTinhId");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setDiaChiCoQuanHCSNTinhId(value15);

				Method method16 = oldModelClass.getMethod("getNguoiDaiDienId");

				Long value16 = (Long)method16.invoke(oldModel, (Object[])null);

				newModel.setNguoiDaiDienId(value16);

				Method method17 = oldModelClass.getMethod(
						"getDiaChiCoQuanHCSNHuyenId");

				Long value17 = (Long)method17.invoke(oldModel, (Object[])null);

				newModel.setDiaChiCoQuanHCSNHuyenId(value17);

				Method method18 = oldModelClass.getMethod("getHangId");

				Long value18 = (Long)method18.invoke(oldModel, (Object[])null);

				newModel.setHangId(value18);

				Method method19 = oldModelClass.getMethod("getCoQuanQuanLyId");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setCoQuanQuanLyId(value19);

				Method method20 = oldModelClass.getMethod("getLoaiId");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setLoaiId(value20);

				Method method21 = oldModelClass.getMethod("getSoQdThanhLap");

				String value21 = (String)method21.invoke(oldModel,
						(Object[])null);

				newModel.setSoQdThanhLap(value21);

				Method method22 = oldModelClass.getMethod("getMoTaDiaChi");

				String value22 = (String)method22.invoke(oldModel,
						(Object[])null);

				newModel.setMoTaDiaChi(value22);

				Method method23 = oldModelClass.getMethod("getTenNguoiDaiDien");

				String value23 = (String)method23.invoke(oldModel,
						(Object[])null);

				newModel.setTenNguoiDaiDien(value23);

				Method method24 = oldModelClass.getMethod("getNgayTao");

				Date value24 = (Date)method24.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value24);

				Method method25 = oldModelClass.getMethod("getDaXoa");

				Integer value25 = (Integer)method25.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value25);

				Method method26 = oldModelClass.getMethod("getNgaySua");

				Date value26 = (Date)method26.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value26);

				Method method27 = oldModelClass.getMethod("getChaId");

				Long value27 = (Long)method27.invoke(oldModel, (Object[])null);

				newModel.setChaId(value27);

				Method method28 = oldModelClass.getMethod("getNguoiTao");

				String value28 = (String)method28.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value28);

				Method method29 = oldModelClass.getMethod("getNguoiSua");

				String value29 = (String)method29.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value29);

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

	public static Object translateOutputCoQuanQuanLy(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CoQuanQuanLyClp newModel = new CoQuanQuanLyClp();

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

				Method method3 = oldModelClass.getMethod("getDiaChi");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setDiaChi(value3);

				Method method4 = oldModelClass.getMethod("getDienThoai");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setDienThoai(value4);

				Method method5 = oldModelClass.getMethod("getEmail");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setEmail(value5);

				Method method6 = oldModelClass.getMethod("getFax");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setFax(value6);

				Method method7 = oldModelClass.getMethod("getWebsite");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setWebsite(value7);

				Method method8 = oldModelClass.getMethod("getNoiBo");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setNoiBo(value8);

				Method method9 = oldModelClass.getMethod("getPhienBan");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value9);

				Method method10 = oldModelClass.getMethod("getDaXoa");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value10);

				Method method11 = oldModelClass.getMethod("getDonViHanhChinhId");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setDonViHanhChinhId(value11);

				Method method12 = oldModelClass.getMethod(
						"getCapCoQuanQuanlyId");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setCapCoQuanQuanlyId(value12);

				Method method13 = oldModelClass.getMethod("getChaId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setChaId(value13);

				Method method14 = oldModelClass.getMethod("getNguoiTao");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value14);

				Method method15 = oldModelClass.getMethod("getNgayTao");

				Date value15 = (Date)method15.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value15);

				Method method16 = oldModelClass.getMethod("getNguoiSua");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value16);

				Method method17 = oldModelClass.getMethod("getNgaySua");

				Date value17 = (Date)method17.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value17);

				Method method18 = oldModelClass.getMethod("getMerchant");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setMerchant(value18);

				Method method19 = oldModelClass.getMethod("getAccessCode");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setAccessCode(value19);

				Method method20 = oldModelClass.getMethod("getSecureSecret");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setSecureSecret(value20);

				Method method21 = oldModelClass.getMethod("getMaCapSoBienNhan");

				String value21 = (String)method21.invoke(oldModel,
						(Object[])null);

				newModel.setMaCapSoBienNhan(value21);

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

	public static Object translateOutputDonViHanhChinh(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DonViHanhChinhClp newModel = new DonViHanhChinhClp();

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

				Method method4 = oldModelClass.getMethod("getPhienBan");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value4);

				Method method5 = oldModelClass.getMethod("getDaXoa");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value5);

				Method method6 = oldModelClass.getMethod("getNgaySua");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value6);

				Method method7 = oldModelClass.getMethod(
						"getCapDonViHanhChinhId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setCapDonViHanhChinhId(value7);

				Method method8 = oldModelClass.getMethod("getChaId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setChaId(value8);

				Method method9 = oldModelClass.getMethod("getNguoiTao");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value9);

				Method method10 = oldModelClass.getMethod("getQuocGiaId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setQuocGiaId(value10);

				Method method11 = oldModelClass.getMethod("getNguoiSua");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value11);

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

	public static Object translateOutputQuocGia(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				QuocGiaClp newModel = new QuocGiaClp();

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

				Method method6 = oldModelClass.getMethod("getNguoiTao");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value6);

				Method method7 = oldModelClass.getMethod("getNguoiSua");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value7);

				Method method8 = oldModelClass.getMethod("getPhienBan");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setPhienBan(value8);

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