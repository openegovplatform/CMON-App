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

package org.oep.cmon.dao.csms.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDanClp;
import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDanClp;

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

		if (oldModelClassName.equals(
					AnhChanDungYeuCauDangKyCongDanClp.class.getName())) {
			return translateInputAnhChanDungYeuCauDangKyCongDan(oldModel);
		}

		if (oldModelClassName.equals(YeuCauDangKyCongDanClp.class.getName())) {
			return translateInputYeuCauDangKyCongDan(oldModel);
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

	public static Object translateInputAnhChanDungYeuCauDangKyCongDan(
		BaseModel<?> oldModel) {
		AnhChanDungYeuCauDangKyCongDanClp oldCplModel = (AnhChanDungYeuCauDangKyCongDanClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.csms.model.impl.AnhChanDungYeuCauDangKyCongDanImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setAnhChanDung",
						new Class[] { String.class });

				String value1 = oldCplModel.getAnhChanDung();

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

	public static Object translateInputYeuCauDangKyCongDan(
		BaseModel<?> oldModel) {
		YeuCauDangKyCongDanClp oldCplModel = (YeuCauDangKyCongDanClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.csms.model.impl.YeuCauDangKyCongDanImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNgayYeuCau",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getNgayYeuCau();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setSoCmnd",
						new Class[] { String.class });

				String value2 = oldCplModel.getSoCmnd();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgayCapCmnd",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayCapCmnd();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setIDNoiCapCmnd",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getIDNoiCapCmnd());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setGhiChuCmnd",
						new Class[] { String.class });

				String value5 = oldCplModel.getGhiChuCmnd();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value6 = oldCplModel.getEmail();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setHoCongDan",
						new Class[] { String.class });

				String value7 = oldCplModel.getHoCongDan();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setHoVaTen",
						new Class[] { String.class });

				String value8 = oldCplModel.getHoVaTen();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setTenDem",
						new Class[] { String.class });

				String value9 = oldCplModel.getTenDem();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setTenCongDan",
						new Class[] { String.class });

				String value10 = oldCplModel.getTenCongDan();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNgaySinh",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getNgaySinh();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setGioiTinh",
						new Class[] { Integer.TYPE });

				Integer value12 = new Integer(oldCplModel.getGioiTinh());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setIDDanToc",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getIDDanToc());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setIDQuocTich",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getIDQuocTich());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setIDTonGiao",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getIDTonGiao());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setDienThoaiCoDinh",
						new Class[] { String.class });

				String value16 = oldCplModel.getDienThoaiCoDinh();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setDienThoaiDiDong",
						new Class[] { String.class });

				String value17 = oldCplModel.getDienThoaiDiDong();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setIDTrinhDoHocVan",
						new Class[] { Long.TYPE });

				Long value18 = new Long(oldCplModel.getIDTrinhDoHocVan());

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setSoHoChieu",
						new Class[] { String.class });

				String value19 = oldCplModel.getSoHoChieu();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setNgayCapHoChieu",
						new Class[] { Date.class });

				Date value20 = oldCplModel.getNgayCapHoChieu();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setIDNoiCapHoChieu",
						new Class[] { Long.TYPE });

				Long value21 = new Long(oldCplModel.getIDNoiCapHoChieu());

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setNgayHetHanHoChieu",
						new Class[] { Date.class });

				Date value22 = oldCplModel.getNgayHetHanHoChieu();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setGhiChuHoChieu",
						new Class[] { String.class });

				String value23 = oldCplModel.getGhiChuHoChieu();

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setSoBaoHiemYte",
						new Class[] { String.class });

				String value24 = oldCplModel.getSoBaoHiemYte();

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setMaSoThueCaNhan",
						new Class[] { String.class });

				String value25 = oldCplModel.getMaSoThueCaNhan();

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setIDNgheNghiep",
						new Class[] { Long.TYPE });

				Long value26 = new Long(oldCplModel.getIDNgheNghiep());

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setIDTrinhDoChuyenMon",
						new Class[] { Long.TYPE });

				Long value27 = new Long(oldCplModel.getIDTrinhDoChuyenMon());

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setTinhTrangHonNhan",
						new Class[] { Long.TYPE });

				Long value28 = new Long(oldCplModel.getTinhTrangHonNhan());

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setHoVaTenCha",
						new Class[] { String.class });

				String value29 = oldCplModel.getHoVaTenCha();

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setHoVaTenMe",
						new Class[] { String.class });

				String value30 = oldCplModel.getHoVaTenMe();

				method30.invoke(newModel, value30);

				Method method31 = newModelClass.getMethod("setHoVaTenVoChong",
						new Class[] { String.class });

				String value31 = oldCplModel.getHoVaTenVoChong();

				method31.invoke(newModel, value31);

				Method method32 = newModelClass.getMethod("setSoHoKhau",
						new Class[] { String.class });

				String value32 = oldCplModel.getSoHoKhau();

				method32.invoke(newModel, value32);

				Method method33 = newModelClass.getMethod("setChuHo",
						new Class[] { Integer.TYPE });

				Integer value33 = new Integer(oldCplModel.getChuHo());

				method33.invoke(newModel, value33);

				Method method34 = newModelClass.getMethod("setIDQuanHe",
						new Class[] { Long.TYPE });

				Long value34 = new Long(oldCplModel.getIDQuanHe());

				method34.invoke(newModel, value34);

				Method method35 = newModelClass.getMethod("setIDTinhThanhNoiSinh",
						new Class[] { Long.TYPE });

				Long value35 = new Long(oldCplModel.getIDTinhThanhNoiSinh());

				method35.invoke(newModel, value35);

				Method method36 = newModelClass.getMethod("setIDQuanHuyenNoiSinh",
						new Class[] { Long.TYPE });

				Long value36 = new Long(oldCplModel.getIDQuanHuyenNoiSinh());

				method36.invoke(newModel, value36);

				Method method37 = newModelClass.getMethod("setIDPhuongXaNoiSinh",
						new Class[] { Long.TYPE });

				Long value37 = new Long(oldCplModel.getIDPhuongXaNoiSinh());

				method37.invoke(newModel, value37);

				Method method38 = newModelClass.getMethod("setMoTaDiaChiNoiSinh",
						new Class[] { String.class });

				String value38 = oldCplModel.getMoTaDiaChiNoiSinh();

				method38.invoke(newModel, value38);

				Method method39 = newModelClass.getMethod("setIDTinhThanhThuongTru",
						new Class[] { Long.TYPE });

				Long value39 = new Long(oldCplModel.getIDTinhThanhThuongTru());

				method39.invoke(newModel, value39);

				Method method40 = newModelClass.getMethod("setIDQuanHuyenThuongTru",
						new Class[] { Long.TYPE });

				Long value40 = new Long(oldCplModel.getIDQuanHuyenThuongTru());

				method40.invoke(newModel, value40);

				Method method41 = newModelClass.getMethod("setIDPhuongXaThuongTru",
						new Class[] { Long.TYPE });

				Long value41 = new Long(oldCplModel.getIDPhuongXaThuongTru());

				method41.invoke(newModel, value41);

				Method method42 = newModelClass.getMethod("setMoTaDiaChiThuongTru",
						new Class[] { String.class });

				String value42 = oldCplModel.getMoTaDiaChiThuongTru();

				method42.invoke(newModel, value42);

				Method method43 = newModelClass.getMethod("setIDTinhThanhHienTai",
						new Class[] { Long.TYPE });

				Long value43 = new Long(oldCplModel.getIDTinhThanhHienTai());

				method43.invoke(newModel, value43);

				Method method44 = newModelClass.getMethod("setIDQuanHuyenHienTai",
						new Class[] { Long.TYPE });

				Long value44 = new Long(oldCplModel.getIDQuanHuyenHienTai());

				method44.invoke(newModel, value44);

				Method method45 = newModelClass.getMethod("setIDPhuongXaHienTai",
						new Class[] { Long.TYPE });

				Long value45 = new Long(oldCplModel.getIDPhuongXaHienTai());

				method45.invoke(newModel, value45);

				Method method46 = newModelClass.getMethod("setMoTaDiaChiHienTai",
						new Class[] { String.class });

				String value46 = oldCplModel.getMoTaDiaChiHienTai();

				method46.invoke(newModel, value46);

				Method method47 = newModelClass.getMethod("setMaXacNhan",
						new Class[] { String.class });

				String value47 = oldCplModel.getMaXacNhan();

				method47.invoke(newModel, value47);

				Method method48 = newModelClass.getMethod("setNgayChungThuc",
						new Class[] { Date.class });

				Date value48 = oldCplModel.getNgayChungThuc();

				method48.invoke(newModel, value48);

				Method method49 = newModelClass.getMethod("setNguoiChungThuc",
						new Class[] { String.class });

				String value49 = oldCplModel.getNguoiChungThuc();

				method49.invoke(newModel, value49);

				Method method50 = newModelClass.getMethod("setMaCongDanCha",
						new Class[] { String.class });

				String value50 = oldCplModel.getMaCongDanCha();

				method50.invoke(newModel, value50);

				Method method51 = newModelClass.getMethod("setMaCongDanMe",
						new Class[] { String.class });

				String value51 = oldCplModel.getMaCongDanMe();

				method51.invoke(newModel, value51);

				Method method52 = newModelClass.getMethod("setMaCongDanVoChong",
						new Class[] { String.class });

				String value52 = oldCplModel.getMaCongDanVoChong();

				method52.invoke(newModel, value52);

				Method method53 = newModelClass.getMethod("setMaCongDan",
						new Class[] { String.class });

				String value53 = oldCplModel.getMaCongDan();

				method53.invoke(newModel, value53);

				Method method54 = newModelClass.getMethod("setLoaiYeuCau",
						new Class[] { Integer.TYPE });

				Integer value54 = new Integer(oldCplModel.getLoaiYeuCau());

				method54.invoke(newModel, value54);

				Method method55 = newModelClass.getMethod("setTrangThaiYeuCau",
						new Class[] { Integer.TYPE });

				Integer value55 = new Integer(oldCplModel.getTrangThaiYeuCau());

				method55.invoke(newModel, value55);

				Method method56 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value56 = oldCplModel.getNgayTao();

				method56.invoke(newModel, value56);

				Method method57 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value57 = oldCplModel.getNgaySua();

				method57.invoke(newModel, value57);

				Method method58 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value58 = oldCplModel.getNguoiTao();

				method58.invoke(newModel, value58);

				Method method59 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value59 = oldCplModel.getNguoiSua();

				method59.invoke(newModel, value59);

				Method method60 = newModelClass.getMethod("setXoa",
						new Class[] { Integer.TYPE });

				Integer value60 = new Integer(oldCplModel.getXoa());

				method60.invoke(newModel, value60);

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
					"org.oep.cmon.dao.csms.model.impl.AnhChanDungYeuCauDangKyCongDanImpl")) {
			return translateOutputAnhChanDungYeuCauDangKyCongDan(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.csms.model.impl.YeuCauDangKyCongDanImpl")) {
			return translateOutputYeuCauDangKyCongDan(oldModel);
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

	public static Object translateOutputAnhChanDungYeuCauDangKyCongDan(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				AnhChanDungYeuCauDangKyCongDanClp newModel = new AnhChanDungYeuCauDangKyCongDanClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getAnhChanDung");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setAnhChanDung(value1);

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

	public static Object translateOutputYeuCauDangKyCongDan(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				YeuCauDangKyCongDanClp newModel = new YeuCauDangKyCongDanClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNgayYeuCau");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setNgayYeuCau(value1);

				Method method2 = oldModelClass.getMethod("getSoCmnd");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setSoCmnd(value2);

				Method method3 = oldModelClass.getMethod("getNgayCapCmnd");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayCapCmnd(value3);

				Method method4 = oldModelClass.getMethod("getIDNoiCapCmnd");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setIDNoiCapCmnd(value4);

				Method method5 = oldModelClass.getMethod("getGhiChuCmnd");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setGhiChuCmnd(value5);

				Method method6 = oldModelClass.getMethod("getEmail");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setEmail(value6);

				Method method7 = oldModelClass.getMethod("getHoCongDan");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setHoCongDan(value7);

				Method method8 = oldModelClass.getMethod("getHoVaTen");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setHoVaTen(value8);

				Method method9 = oldModelClass.getMethod("getTenDem");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setTenDem(value9);

				Method method10 = oldModelClass.getMethod("getTenCongDan");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setTenCongDan(value10);

				Method method11 = oldModelClass.getMethod("getNgaySinh");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setNgaySinh(value11);

				Method method12 = oldModelClass.getMethod("getGioiTinh");

				Integer value12 = (Integer)method12.invoke(oldModel,
						(Object[])null);

				newModel.setGioiTinh(value12);

				Method method13 = oldModelClass.getMethod("getIDDanToc");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setIDDanToc(value13);

				Method method14 = oldModelClass.getMethod("getIDQuocTich");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setIDQuocTich(value14);

				Method method15 = oldModelClass.getMethod("getIDTonGiao");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setIDTonGiao(value15);

				Method method16 = oldModelClass.getMethod("getDienThoaiCoDinh");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setDienThoaiCoDinh(value16);

				Method method17 = oldModelClass.getMethod("getDienThoaiDiDong");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setDienThoaiDiDong(value17);

				Method method18 = oldModelClass.getMethod("getIDTrinhDoHocVan");

				Long value18 = (Long)method18.invoke(oldModel, (Object[])null);

				newModel.setIDTrinhDoHocVan(value18);

				Method method19 = oldModelClass.getMethod("getSoHoChieu");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setSoHoChieu(value19);

				Method method20 = oldModelClass.getMethod("getNgayCapHoChieu");

				Date value20 = (Date)method20.invoke(oldModel, (Object[])null);

				newModel.setNgayCapHoChieu(value20);

				Method method21 = oldModelClass.getMethod("getIDNoiCapHoChieu");

				Long value21 = (Long)method21.invoke(oldModel, (Object[])null);

				newModel.setIDNoiCapHoChieu(value21);

				Method method22 = oldModelClass.getMethod(
						"getNgayHetHanHoChieu");

				Date value22 = (Date)method22.invoke(oldModel, (Object[])null);

				newModel.setNgayHetHanHoChieu(value22);

				Method method23 = oldModelClass.getMethod("getGhiChuHoChieu");

				String value23 = (String)method23.invoke(oldModel,
						(Object[])null);

				newModel.setGhiChuHoChieu(value23);

				Method method24 = oldModelClass.getMethod("getSoBaoHiemYte");

				String value24 = (String)method24.invoke(oldModel,
						(Object[])null);

				newModel.setSoBaoHiemYte(value24);

				Method method25 = oldModelClass.getMethod("getMaSoThueCaNhan");

				String value25 = (String)method25.invoke(oldModel,
						(Object[])null);

				newModel.setMaSoThueCaNhan(value25);

				Method method26 = oldModelClass.getMethod("getIDNgheNghiep");

				Long value26 = (Long)method26.invoke(oldModel, (Object[])null);

				newModel.setIDNgheNghiep(value26);

				Method method27 = oldModelClass.getMethod(
						"getIDTrinhDoChuyenMon");

				Long value27 = (Long)method27.invoke(oldModel, (Object[])null);

				newModel.setIDTrinhDoChuyenMon(value27);

				Method method28 = oldModelClass.getMethod("getTinhTrangHonNhan");

				Long value28 = (Long)method28.invoke(oldModel, (Object[])null);

				newModel.setTinhTrangHonNhan(value28);

				Method method29 = oldModelClass.getMethod("getHoVaTenCha");

				String value29 = (String)method29.invoke(oldModel,
						(Object[])null);

				newModel.setHoVaTenCha(value29);

				Method method30 = oldModelClass.getMethod("getHoVaTenMe");

				String value30 = (String)method30.invoke(oldModel,
						(Object[])null);

				newModel.setHoVaTenMe(value30);

				Method method31 = oldModelClass.getMethod("getHoVaTenVoChong");

				String value31 = (String)method31.invoke(oldModel,
						(Object[])null);

				newModel.setHoVaTenVoChong(value31);

				Method method32 = oldModelClass.getMethod("getSoHoKhau");

				String value32 = (String)method32.invoke(oldModel,
						(Object[])null);

				newModel.setSoHoKhau(value32);

				Method method33 = oldModelClass.getMethod("getChuHo");

				Integer value33 = (Integer)method33.invoke(oldModel,
						(Object[])null);

				newModel.setChuHo(value33);

				Method method34 = oldModelClass.getMethod("getIDQuanHe");

				Long value34 = (Long)method34.invoke(oldModel, (Object[])null);

				newModel.setIDQuanHe(value34);

				Method method35 = oldModelClass.getMethod(
						"getIDTinhThanhNoiSinh");

				Long value35 = (Long)method35.invoke(oldModel, (Object[])null);

				newModel.setIDTinhThanhNoiSinh(value35);

				Method method36 = oldModelClass.getMethod(
						"getIDQuanHuyenNoiSinh");

				Long value36 = (Long)method36.invoke(oldModel, (Object[])null);

				newModel.setIDQuanHuyenNoiSinh(value36);

				Method method37 = oldModelClass.getMethod(
						"getIDPhuongXaNoiSinh");

				Long value37 = (Long)method37.invoke(oldModel, (Object[])null);

				newModel.setIDPhuongXaNoiSinh(value37);

				Method method38 = oldModelClass.getMethod(
						"getMoTaDiaChiNoiSinh");

				String value38 = (String)method38.invoke(oldModel,
						(Object[])null);

				newModel.setMoTaDiaChiNoiSinh(value38);

				Method method39 = oldModelClass.getMethod(
						"getIDTinhThanhThuongTru");

				Long value39 = (Long)method39.invoke(oldModel, (Object[])null);

				newModel.setIDTinhThanhThuongTru(value39);

				Method method40 = oldModelClass.getMethod(
						"getIDQuanHuyenThuongTru");

				Long value40 = (Long)method40.invoke(oldModel, (Object[])null);

				newModel.setIDQuanHuyenThuongTru(value40);

				Method method41 = oldModelClass.getMethod(
						"getIDPhuongXaThuongTru");

				Long value41 = (Long)method41.invoke(oldModel, (Object[])null);

				newModel.setIDPhuongXaThuongTru(value41);

				Method method42 = oldModelClass.getMethod(
						"getMoTaDiaChiThuongTru");

				String value42 = (String)method42.invoke(oldModel,
						(Object[])null);

				newModel.setMoTaDiaChiThuongTru(value42);

				Method method43 = oldModelClass.getMethod(
						"getIDTinhThanhHienTai");

				Long value43 = (Long)method43.invoke(oldModel, (Object[])null);

				newModel.setIDTinhThanhHienTai(value43);

				Method method44 = oldModelClass.getMethod(
						"getIDQuanHuyenHienTai");

				Long value44 = (Long)method44.invoke(oldModel, (Object[])null);

				newModel.setIDQuanHuyenHienTai(value44);

				Method method45 = oldModelClass.getMethod(
						"getIDPhuongXaHienTai");

				Long value45 = (Long)method45.invoke(oldModel, (Object[])null);

				newModel.setIDPhuongXaHienTai(value45);

				Method method46 = oldModelClass.getMethod(
						"getMoTaDiaChiHienTai");

				String value46 = (String)method46.invoke(oldModel,
						(Object[])null);

				newModel.setMoTaDiaChiHienTai(value46);

				Method method47 = oldModelClass.getMethod("getMaXacNhan");

				String value47 = (String)method47.invoke(oldModel,
						(Object[])null);

				newModel.setMaXacNhan(value47);

				Method method48 = oldModelClass.getMethod("getNgayChungThuc");

				Date value48 = (Date)method48.invoke(oldModel, (Object[])null);

				newModel.setNgayChungThuc(value48);

				Method method49 = oldModelClass.getMethod("getNguoiChungThuc");

				String value49 = (String)method49.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiChungThuc(value49);

				Method method50 = oldModelClass.getMethod("getMaCongDanCha");

				String value50 = (String)method50.invoke(oldModel,
						(Object[])null);

				newModel.setMaCongDanCha(value50);

				Method method51 = oldModelClass.getMethod("getMaCongDanMe");

				String value51 = (String)method51.invoke(oldModel,
						(Object[])null);

				newModel.setMaCongDanMe(value51);

				Method method52 = oldModelClass.getMethod("getMaCongDanVoChong");

				String value52 = (String)method52.invoke(oldModel,
						(Object[])null);

				newModel.setMaCongDanVoChong(value52);

				Method method53 = oldModelClass.getMethod("getMaCongDan");

				String value53 = (String)method53.invoke(oldModel,
						(Object[])null);

				newModel.setMaCongDan(value53);

				Method method54 = oldModelClass.getMethod("getLoaiYeuCau");

				Integer value54 = (Integer)method54.invoke(oldModel,
						(Object[])null);

				newModel.setLoaiYeuCau(value54);

				Method method55 = oldModelClass.getMethod("getTrangThaiYeuCau");

				Integer value55 = (Integer)method55.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiYeuCau(value55);

				Method method56 = oldModelClass.getMethod("getNgayTao");

				Date value56 = (Date)method56.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value56);

				Method method57 = oldModelClass.getMethod("getNgaySua");

				Date value57 = (Date)method57.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value57);

				Method method58 = oldModelClass.getMethod("getNguoiTao");

				String value58 = (String)method58.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value58);

				Method method59 = oldModelClass.getMethod("getNguoiSua");

				String value59 = (String)method59.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value59);

				Method method60 = oldModelClass.getMethod("getXoa");

				Integer value60 = (Integer)method60.invoke(oldModel,
						(Object[])null);

				newModel.setXoa(value60);

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