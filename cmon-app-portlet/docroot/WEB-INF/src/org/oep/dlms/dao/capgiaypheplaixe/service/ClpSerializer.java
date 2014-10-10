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

package org.oep.dlms.dao.capgiaypheplaixe.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;


import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXeClp;

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

		if (oldModelClassName.equals(CapGiayPhepLaiXeClp.class.getName())) {
			return translateInputCapGiayPhepLaiXe(oldModel);
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

	public static Object translateInputCapGiayPhepLaiXe(BaseModel<?> oldModel) {
		CapGiayPhepLaiXeClp oldCplModel = (CapGiayPhepLaiXeClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.dtt.dlms.dao.capgiaypheplaixe.model.impl.CapGiayPhepLaiXeImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setIdCoQuanQuanLy",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getIdCoQuanQuanLy());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setIdCongDan",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getIdCongDan());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setIdLoaiHoSo",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getIdLoaiHoSo());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setSoHoSo",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getSoHoSo());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setHoVaTen",
						new Class[] { String.class });

				String value5 = oldCplModel.getHoVaTen();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgaySinh",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgaySinh();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setIdGioiTinh",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getIdGioiTinh());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setIdQuocTich",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getIdQuocTich());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setSoCMND",
						new Class[] { String.class });

				String value9 = oldCplModel.getSoCMND();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNgayCapCMND",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getNgayCapCMND();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setIdNoiCapCMND",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getIdNoiCapCMND());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setSoHoChieu",
						new Class[] { String.class });

				String value12 = oldCplModel.getSoHoChieu();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setNgayCapHoChieu",
						new Class[] { Date.class });

				Date value13 = oldCplModel.getNgayCapHoChieu();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setNoiCapHoChieu",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getNoiCapHoChieu());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setDienThoai",
						new Class[] { String.class });

				String value15 = oldCplModel.getDienThoai();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value16 = oldCplModel.getEmail();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setGhiChu",
						new Class[] { String.class });

				String value17 = oldCplModel.getGhiChu();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setIdTinhThuongTru",
						new Class[] { Long.TYPE });

				Long value18 = new Long(oldCplModel.getIdTinhThuongTru());

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setIdHuyenThuongTru",
						new Class[] { Long.TYPE });

				Long value19 = new Long(oldCplModel.getIdHuyenThuongTru());

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setIdXaThuongTru",
						new Class[] { Long.TYPE });

				Long value20 = new Long(oldCplModel.getIdXaThuongTru());

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setDiaChiThuongTru",
						new Class[] { String.class });

				String value21 = oldCplModel.getDiaChiThuongTru();

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setIdTinhCuTru",
						new Class[] { Long.TYPE });

				Long value22 = new Long(oldCplModel.getIdTinhCuTru());

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setIdHuyenCuTru",
						new Class[] { Long.TYPE });

				Long value23 = new Long(oldCplModel.getIdHuyenCuTru());

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setIdXaCuTru",
						new Class[] { Long.TYPE });

				Long value24 = new Long(oldCplModel.getIdXaCuTru());

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setDiaChiCuTru",
						new Class[] { String.class });

				String value25 = oldCplModel.getDiaChiCuTru();

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setSoGiayPhepLaiXe",
						new Class[] { String.class });

				String value26 = oldCplModel.getSoGiayPhepLaiXe();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setIdHangGiayPhepLaiXe",
						new Class[] { Long.TYPE });

				Long value27 = new Long(oldCplModel.getIdHangGiayPhepLaiXe());

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setIdDonViCapGPLX",
						new Class[] { Long.TYPE });

				Long value28 = new Long(oldCplModel.getIdDonViCapGPLX());

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setNgayCapGPLX",
						new Class[] { Date.class });

				Date value29 = oldCplModel.getNgayCapGPLX();

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setIdNoiCapGPLX",
						new Class[] { Long.TYPE });

				Long value30 = new Long(oldCplModel.getIdNoiCapGPLX());

				method30.invoke(newModel, value30);

				Method method31 = newModelClass.getMethod("setNgayDauSatHach",
						new Class[] { Date.class });

				Date value31 = oldCplModel.getNgayDauSatHach();

				method31.invoke(newModel, value31);

				Method method32 = newModelClass.getMethod("setIdNoiHocLaiXe",
						new Class[] { Long.TYPE });

				Long value32 = new Long(oldCplModel.getIdNoiHocLaiXe());

				method32.invoke(newModel, value32);

				Method method33 = newModelClass.getMethod("setNamHocLaiXe",
						new Class[] { Integer.TYPE });

				Integer value33 = new Integer(oldCplModel.getNamHocLaiXe());

				method33.invoke(newModel, value33);

				Method method34 = newModelClass.getMethod("setNamTrungTuyenHangCaoNhat",
						new Class[] { Integer.TYPE });

				Integer value34 = new Integer(oldCplModel.getNamTrungTuyenHangCaoNhat());

				method34.invoke(newModel, value34);

				Method method35 = newModelClass.getMethod("setLyDoHoc",
						new Class[] { String.class });

				String value35 = oldCplModel.getLyDoHoc();

				method35.invoke(newModel, value35);

				Method method36 = newModelClass.getMethod("setMucDichHoc",
						new Class[] { String.class });

				String value36 = oldCplModel.getMucDichHoc();

				method36.invoke(newModel, value36);

				Method method37 = newModelClass.getMethod("setSoNamLaiXe",
						new Class[] { Double.TYPE });

				Double value37 = new Double(oldCplModel.getSoNamLaiXe());

				method37.invoke(newModel, value37);

				Method method38 = newModelClass.getMethod("setSoKmLaiXe",
						new Class[] { Double.TYPE });

				Double value38 = new Double(oldCplModel.getSoKmLaiXe());

				method38.invoke(newModel, value38);

				Method method39 = newModelClass.getMethod("setNgayTraGPLX",
						new Class[] { Date.class });

				Date value39 = oldCplModel.getNgayTraGPLX();

				method39.invoke(newModel, value39);

				Method method40 = newModelClass.getMethod("setIdLyDoCapDoiLaiGPLX",
						new Class[] { Long.TYPE });

				Long value40 = new Long(oldCplModel.getIdLyDoCapDoiLaiGPLX());

				method40.invoke(newModel, value40);

				Method method41 = newModelClass.getMethod("setLyDo",
						new Class[] { String.class });

				String value41 = oldCplModel.getLyDo();

				method41.invoke(newModel, value41);

				Method method42 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value42 = oldCplModel.getNgayTao();

				method42.invoke(newModel, value42);

				Method method43 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value43 = oldCplModel.getNgaySua();

				method43.invoke(newModel, value43);

				Method method44 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value44 = oldCplModel.getNguoiTao();

				method44.invoke(newModel, value44);

				Method method45 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value45 = oldCplModel.getNguoiSua();

				method45.invoke(newModel, value45);

				Method method46 = newModelClass.getMethod("setXoa",
						new Class[] { Integer.TYPE });

				Integer value46 = new Integer(oldCplModel.getXoa());

				method46.invoke(newModel, value46);

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
					"vn.dtt.dlms.dao.capgiaypheplaixe.model.impl.CapGiayPhepLaiXeImpl")) {
			return translateOutputCapGiayPhepLaiXe(oldModel);
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

	public static Object translateOutputCapGiayPhepLaiXe(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CapGiayPhepLaiXeClp newModel = new CapGiayPhepLaiXeClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getIdCoQuanQuanLy");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setIdCoQuanQuanLy(value1);

				Method method2 = oldModelClass.getMethod("getIdCongDan");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setIdCongDan(value2);

				Method method3 = oldModelClass.getMethod("getIdLoaiHoSo");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setIdLoaiHoSo(value3);

				Method method4 = oldModelClass.getMethod("getSoHoSo");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setSoHoSo(value4);

				Method method5 = oldModelClass.getMethod("getHoVaTen");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setHoVaTen(value5);

				Method method6 = oldModelClass.getMethod("getNgaySinh");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgaySinh(value6);

				Method method7 = oldModelClass.getMethod("getIdGioiTinh");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setIdGioiTinh(value7);

				Method method8 = oldModelClass.getMethod("getIdQuocTich");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setIdQuocTich(value8);

				Method method9 = oldModelClass.getMethod("getSoCMND");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setSoCMND(value9);

				Method method10 = oldModelClass.getMethod("getNgayCapCMND");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setNgayCapCMND(value10);

				Method method11 = oldModelClass.getMethod("getIdNoiCapCMND");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setIdNoiCapCMND(value11);

				Method method12 = oldModelClass.getMethod("getSoHoChieu");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setSoHoChieu(value12);

				Method method13 = oldModelClass.getMethod("getNgayCapHoChieu");

				Date value13 = (Date)method13.invoke(oldModel, (Object[])null);

				newModel.setNgayCapHoChieu(value13);

				Method method14 = oldModelClass.getMethod("getNoiCapHoChieu");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setNoiCapHoChieu(value14);

				Method method15 = oldModelClass.getMethod("getDienThoai");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setDienThoai(value15);

				Method method16 = oldModelClass.getMethod("getEmail");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setEmail(value16);

				Method method17 = oldModelClass.getMethod("getGhiChu");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setGhiChu(value17);

				Method method18 = oldModelClass.getMethod("getIdTinhThuongTru");

				Long value18 = (Long)method18.invoke(oldModel, (Object[])null);

				newModel.setIdTinhThuongTru(value18);

				Method method19 = oldModelClass.getMethod("getIdHuyenThuongTru");

				Long value19 = (Long)method19.invoke(oldModel, (Object[])null);

				newModel.setIdHuyenThuongTru(value19);

				Method method20 = oldModelClass.getMethod("getIdXaThuongTru");

				Long value20 = (Long)method20.invoke(oldModel, (Object[])null);

				newModel.setIdXaThuongTru(value20);

				Method method21 = oldModelClass.getMethod("getDiaChiThuongTru");

				String value21 = (String)method21.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiThuongTru(value21);

				Method method22 = oldModelClass.getMethod("getIdTinhCuTru");

				Long value22 = (Long)method22.invoke(oldModel, (Object[])null);

				newModel.setIdTinhCuTru(value22);

				Method method23 = oldModelClass.getMethod("getIdHuyenCuTru");

				Long value23 = (Long)method23.invoke(oldModel, (Object[])null);

				newModel.setIdHuyenCuTru(value23);

				Method method24 = oldModelClass.getMethod("getIdXaCuTru");

				Long value24 = (Long)method24.invoke(oldModel, (Object[])null);

				newModel.setIdXaCuTru(value24);

				Method method25 = oldModelClass.getMethod("getDiaChiCuTru");

				String value25 = (String)method25.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiCuTru(value25);

				Method method26 = oldModelClass.getMethod("getSoGiayPhepLaiXe");

				String value26 = (String)method26.invoke(oldModel,
						(Object[])null);

				newModel.setSoGiayPhepLaiXe(value26);

				Method method27 = oldModelClass.getMethod(
						"getIdHangGiayPhepLaiXe");

				Long value27 = (Long)method27.invoke(oldModel, (Object[])null);

				newModel.setIdHangGiayPhepLaiXe(value27);

				Method method28 = oldModelClass.getMethod("getIdDonViCapGPLX");

				Long value28 = (Long)method28.invoke(oldModel, (Object[])null);

				newModel.setIdDonViCapGPLX(value28);

				Method method29 = oldModelClass.getMethod("getNgayCapGPLX");

				Date value29 = (Date)method29.invoke(oldModel, (Object[])null);

				newModel.setNgayCapGPLX(value29);

				Method method30 = oldModelClass.getMethod("getIdNoiCapGPLX");

				Long value30 = (Long)method30.invoke(oldModel, (Object[])null);

				newModel.setIdNoiCapGPLX(value30);

				Method method31 = oldModelClass.getMethod("getNgayDauSatHach");

				Date value31 = (Date)method31.invoke(oldModel, (Object[])null);

				newModel.setNgayDauSatHach(value31);

				Method method32 = oldModelClass.getMethod("getIdNoiHocLaiXe");

				Long value32 = (Long)method32.invoke(oldModel, (Object[])null);

				newModel.setIdNoiHocLaiXe(value32);

				Method method33 = oldModelClass.getMethod("getNamHocLaiXe");

				Integer value33 = (Integer)method33.invoke(oldModel,
						(Object[])null);

				newModel.setNamHocLaiXe(value33);

				Method method34 = oldModelClass.getMethod(
						"getNamTrungTuyenHangCaoNhat");

				Integer value34 = (Integer)method34.invoke(oldModel,
						(Object[])null);

				newModel.setNamTrungTuyenHangCaoNhat(value34);

				Method method35 = oldModelClass.getMethod("getLyDoHoc");

				String value35 = (String)method35.invoke(oldModel,
						(Object[])null);

				newModel.setLyDoHoc(value35);

				Method method36 = oldModelClass.getMethod("getMucDichHoc");

				String value36 = (String)method36.invoke(oldModel,
						(Object[])null);

				newModel.setMucDichHoc(value36);

				Method method37 = oldModelClass.getMethod("getSoNamLaiXe");

				Double value37 = (Double)method37.invoke(oldModel,
						(Object[])null);

				newModel.setSoNamLaiXe(value37);

				Method method38 = oldModelClass.getMethod("getSoKmLaiXe");

				Double value38 = (Double)method38.invoke(oldModel,
						(Object[])null);

				newModel.setSoKmLaiXe(value38);

				Method method39 = oldModelClass.getMethod("getNgayTraGPLX");

				Date value39 = (Date)method39.invoke(oldModel, (Object[])null);

				newModel.setNgayTraGPLX(value39);

				Method method40 = oldModelClass.getMethod(
						"getIdLyDoCapDoiLaiGPLX");

				Long value40 = (Long)method40.invoke(oldModel, (Object[])null);

				newModel.setIdLyDoCapDoiLaiGPLX(value40);

				Method method41 = oldModelClass.getMethod("getLyDo");

				String value41 = (String)method41.invoke(oldModel,
						(Object[])null);

				newModel.setLyDo(value41);

				Method method42 = oldModelClass.getMethod("getNgayTao");

				Date value42 = (Date)method42.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value42);

				Method method43 = oldModelClass.getMethod("getNgaySua");

				Date value43 = (Date)method43.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value43);

				Method method44 = oldModelClass.getMethod("getNguoiTao");

				String value44 = (String)method44.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value44);

				Method method45 = oldModelClass.getMethod("getNguoiSua");

				String value45 = (String)method45.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value45);

				Method method46 = oldModelClass.getMethod("getXoa");

				Integer value46 = (Integer)method46.invoke(oldModel,
						(Object[])null);

				newModel.setXoa(value46);

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