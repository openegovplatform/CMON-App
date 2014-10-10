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

package org.oep.cmon.dao.chungthuc.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.chungthuc.model.HoSoChungThucClp;
import org.oep.cmon.dao.chungthuc.model.SoDanhMucClp;
import org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThucClp;

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

		if (oldModelClassName.equals(HoSoChungThucClp.class.getName())) {
			return translateInputHoSoChungThuc(oldModel);
		}

		if (oldModelClassName.equals(SoDanhMucClp.class.getName())) {
			return translateInputSoDanhMuc(oldModel);
		}

		if (oldModelClassName.equals(ThanhPhanHoSoChungThucClp.class.getName())) {
			return translateInputThanhPhanHoSoChungThuc(oldModel);
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

	public static Object translateInputHoSoChungThuc(BaseModel<?> oldModel) {
		HoSoChungThucClp oldCplModel = (HoSoChungThucClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setHoSoChungThucId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getHoSoChungThucId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTenChungThuc",
						new Class[] { String.class });

				String value1 = oldCplModel.getTenChungThuc();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setSoChungThuc",
						new Class[] { String.class });

				String value2 = oldCplModel.getSoChungThuc();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgayNopHoSo",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayNopHoSo();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTraKetQua",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTraKetQua();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setHoTenNguoiNopHoSo",
						new Class[] { String.class });

				String value5 = oldCplModel.getHoTenNguoiNopHoSo();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDiaChiThuongTruNguoiNop",
						new Class[] { String.class });

				String value6 = oldCplModel.getDiaChiThuongTruNguoiNop();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setSoDienThoaiCoDinhNguoiNop",
						new Class[] { String.class });

				String value7 = oldCplModel.getSoDienThoaiCoDinhNguoiNop();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setTrangThaiHoSo",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getTrangThaiHoSo());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value9 = new Integer(oldCplModel.getDaXoa());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value10 = oldCplModel.getNguoiTao();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getNgayTao();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value12 = oldCplModel.getNguoiSua();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value13 = oldCplModel.getNgaySua();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getThuTucHanhChinhId());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setCanBoTiepNhanId",
						new Class[] { Long.TYPE });

				Long value15 = new Long(oldCplModel.getCanBoTiepNhanId());

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setSoDienThoaiDiDongNguoiNop",
						new Class[] { String.class });

				String value16 = oldCplModel.getSoDienThoaiDiDongNguoiNop();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setGhiChu",
						new Class[] { String.class });

				String value17 = oldCplModel.getGhiChu();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setMucDichChungThuc",
						new Class[] { String.class });

				String value18 = oldCplModel.getMucDichChungThuc();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setMaSoBienNhan",
						new Class[] { String.class });

				String value19 = oldCplModel.getMaSoBienNhan();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setChuSoHuu",
						new Class[] { String.class });

				String value20 = oldCplModel.getChuSoHuu();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setSoBoHoSo",
						new Class[] { Integer.TYPE });

				Integer value21 = new Integer(oldCplModel.getSoBoHoSo());

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setSoTo",
						new Class[] { Integer.TYPE });

				Integer value22 = new Integer(oldCplModel.getSoTo());

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setTruongHop",
						new Class[] { String.class });

				String value23 = oldCplModel.getTruongHop();

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setLePhi",
						new Class[] { Integer.TYPE });

				Integer value24 = new Integer(oldCplModel.getLePhi());

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setPhiHoSo",
						new Class[] { Integer.TYPE });

				Integer value25 = new Integer(oldCplModel.getPhiHoSo());

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setEmailNguoiNop",
						new Class[] { String.class });

				String value26 = oldCplModel.getEmailNguoiNop();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setNgaySinhNguoiNop",
						new Class[] { Date.class });

				Date value27 = oldCplModel.getNgaySinhNguoiNop();

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setSoCMNDNguoiNop",
						new Class[] { String.class });

				String value28 = oldCplModel.getSoCMNDNguoiNop();

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setGioiTinhNguoiNop",
						new Class[] { Integer.TYPE });

				Integer value29 = new Integer(oldCplModel.getGioiTinhNguoiNop());

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setTenCanBoKy",
						new Class[] { String.class });

				String value30 = oldCplModel.getTenCanBoKy();

				method30.invoke(newModel, value30);

				Method method31 = newModelClass.getMethod("setChucVuCanBoKyId",
						new Class[] { Long.TYPE });

				Long value31 = new Long(oldCplModel.getChucVuCanBoKyId());

				method31.invoke(newModel, value31);

				Method method32 = newModelClass.getMethod("setSoDanhMucId",
						new Class[] { Long.TYPE });

				Long value32 = new Long(oldCplModel.getSoDanhMucId());

				method32.invoke(newModel, value32);

				Method method33 = newModelClass.getMethod("setThuongTruTinhId",
						new Class[] { Long.TYPE });

				Long value33 = new Long(oldCplModel.getThuongTruTinhId());

				method33.invoke(newModel, value33);

				Method method34 = newModelClass.getMethod("setThuongTruHuyenId",
						new Class[] { Long.TYPE });

				Long value34 = new Long(oldCplModel.getThuongTruHuyenId());

				method34.invoke(newModel, value34);

				Method method35 = newModelClass.getMethod("setThuongTruXaId",
						new Class[] { Long.TYPE });

				Long value35 = new Long(oldCplModel.getThuongTruXaId());

				method35.invoke(newModel, value35);

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

	public static Object translateInputSoDanhMuc(BaseModel<?> oldModel) {
		SoDanhMucClp oldCplModel = (SoDanhMucClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.chungthuc.model.impl.SoDanhMucImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTenSo",
						new Class[] { String.class });

				String value1 = oldCplModel.getTenSo();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setSoSo",
						new Class[] { String.class });

				String value2 = oldCplModel.getSoSo();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setThuTucHanhChinhId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getThuTucHanhChinhId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNam",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getNam());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTheoQuyetDinh",
						new Class[] { String.class });

				String value5 = oldCplModel.getTheoQuyetDinh();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCoQuanQuanLiId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getCoQuanQuanLiId());

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

	public static Object translateInputThanhPhanHoSoChungThuc(
		BaseModel<?> oldModel) {
		ThanhPhanHoSoChungThucClp oldCplModel = (ThanhPhanHoSoChungThucClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setThanhPhanHoSoId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getThanhPhanHoSoId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTieuDe",
						new Class[] { String.class });

				String value1 = oldCplModel.getTieuDe();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMoTa",
						new Class[] { String.class });

				String value2 = oldCplModel.getMoTa();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setHoSoChungThucId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getHoSoChungThucId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setThuTuc2GiayToId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getThuTuc2GiayToId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNoiLuuTruHoSoDinhKemId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getNoiLuuTruHoSoDinhKemId());

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
					"org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl")) {
			return translateOutputHoSoChungThuc(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.chungthuc.model.impl.SoDanhMucImpl")) {
			return translateOutputSoDanhMuc(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucImpl")) {
			return translateOutputThanhPhanHoSoChungThuc(oldModel);
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

	public static Object translateOutputHoSoChungThuc(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HoSoChungThucClp newModel = new HoSoChungThucClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getHoSoChungThucId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setHoSoChungThucId(value0);

				Method method1 = oldModelClass.getMethod("getTenChungThuc");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTenChungThuc(value1);

				Method method2 = oldModelClass.getMethod("getSoChungThuc");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setSoChungThuc(value2);

				Method method3 = oldModelClass.getMethod("getNgayNopHoSo");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayNopHoSo(value3);

				Method method4 = oldModelClass.getMethod("getNgayTraKetQua");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTraKetQua(value4);

				Method method5 = oldModelClass.getMethod("getHoTenNguoiNopHoSo");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setHoTenNguoiNopHoSo(value5);

				Method method6 = oldModelClass.getMethod(
						"getDiaChiThuongTruNguoiNop");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setDiaChiThuongTruNguoiNop(value6);

				Method method7 = oldModelClass.getMethod(
						"getSoDienThoaiCoDinhNguoiNop");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setSoDienThoaiCoDinhNguoiNop(value7);

				Method method8 = oldModelClass.getMethod("getTrangThaiHoSo");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiHoSo(value8);

				Method method9 = oldModelClass.getMethod("getDaXoa");

				Integer value9 = (Integer)method9.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value9);

				Method method10 = oldModelClass.getMethod("getNguoiTao");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value10);

				Method method11 = oldModelClass.getMethod("getNgayTao");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value11);

				Method method12 = oldModelClass.getMethod("getNguoiSua");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value12);

				Method method13 = oldModelClass.getMethod("getNgaySua");

				Date value13 = (Date)method13.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value13);

				Method method14 = oldModelClass.getMethod(
						"getThuTucHanhChinhId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setThuTucHanhChinhId(value14);

				Method method15 = oldModelClass.getMethod("getCanBoTiepNhanId");

				Long value15 = (Long)method15.invoke(oldModel, (Object[])null);

				newModel.setCanBoTiepNhanId(value15);

				Method method16 = oldModelClass.getMethod(
						"getSoDienThoaiDiDongNguoiNop");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setSoDienThoaiDiDongNguoiNop(value16);

				Method method17 = oldModelClass.getMethod("getGhiChu");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setGhiChu(value17);

				Method method18 = oldModelClass.getMethod("getMucDichChungThuc");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setMucDichChungThuc(value18);

				Method method19 = oldModelClass.getMethod("getMaSoBienNhan");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setMaSoBienNhan(value19);

				Method method20 = oldModelClass.getMethod("getChuSoHuu");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setChuSoHuu(value20);

				Method method21 = oldModelClass.getMethod("getSoBoHoSo");

				Integer value21 = (Integer)method21.invoke(oldModel,
						(Object[])null);

				newModel.setSoBoHoSo(value21);

				Method method22 = oldModelClass.getMethod("getSoTo");

				Integer value22 = (Integer)method22.invoke(oldModel,
						(Object[])null);

				newModel.setSoTo(value22);

				Method method23 = oldModelClass.getMethod("getTruongHop");

				String value23 = (String)method23.invoke(oldModel,
						(Object[])null);

				newModel.setTruongHop(value23);

				Method method24 = oldModelClass.getMethod("getLePhi");

				Integer value24 = (Integer)method24.invoke(oldModel,
						(Object[])null);

				newModel.setLePhi(value24);

				Method method25 = oldModelClass.getMethod("getPhiHoSo");

				Integer value25 = (Integer)method25.invoke(oldModel,
						(Object[])null);

				newModel.setPhiHoSo(value25);

				Method method26 = oldModelClass.getMethod("getEmailNguoiNop");

				String value26 = (String)method26.invoke(oldModel,
						(Object[])null);

				newModel.setEmailNguoiNop(value26);

				Method method27 = oldModelClass.getMethod("getNgaySinhNguoiNop");

				Date value27 = (Date)method27.invoke(oldModel, (Object[])null);

				newModel.setNgaySinhNguoiNop(value27);

				Method method28 = oldModelClass.getMethod("getSoCMNDNguoiNop");

				String value28 = (String)method28.invoke(oldModel,
						(Object[])null);

				newModel.setSoCMNDNguoiNop(value28);

				Method method29 = oldModelClass.getMethod("getGioiTinhNguoiNop");

				Integer value29 = (Integer)method29.invoke(oldModel,
						(Object[])null);

				newModel.setGioiTinhNguoiNop(value29);

				Method method30 = oldModelClass.getMethod("getTenCanBoKy");

				String value30 = (String)method30.invoke(oldModel,
						(Object[])null);

				newModel.setTenCanBoKy(value30);

				Method method31 = oldModelClass.getMethod("getChucVuCanBoKyId");

				Long value31 = (Long)method31.invoke(oldModel, (Object[])null);

				newModel.setChucVuCanBoKyId(value31);

				Method method32 = oldModelClass.getMethod("getSoDanhMucId");

				Long value32 = (Long)method32.invoke(oldModel, (Object[])null);

				newModel.setSoDanhMucId(value32);

				Method method33 = oldModelClass.getMethod("getThuongTruTinhId");

				Long value33 = (Long)method33.invoke(oldModel, (Object[])null);

				newModel.setThuongTruTinhId(value33);

				Method method34 = oldModelClass.getMethod("getThuongTruHuyenId");

				Long value34 = (Long)method34.invoke(oldModel, (Object[])null);

				newModel.setThuongTruHuyenId(value34);

				Method method35 = oldModelClass.getMethod("getThuongTruXaId");

				Long value35 = (Long)method35.invoke(oldModel, (Object[])null);

				newModel.setThuongTruXaId(value35);

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

	public static Object translateOutputSoDanhMuc(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				SoDanhMucClp newModel = new SoDanhMucClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTenSo");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTenSo(value1);

				Method method2 = oldModelClass.getMethod("getSoSo");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setSoSo(value2);

				Method method3 = oldModelClass.getMethod("getThuTucHanhChinhId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setThuTucHanhChinhId(value3);

				Method method4 = oldModelClass.getMethod("getNam");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setNam(value4);

				Method method5 = oldModelClass.getMethod("getTheoQuyetDinh");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setTheoQuyetDinh(value5);

				Method method6 = oldModelClass.getMethod("getCoQuanQuanLiId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setCoQuanQuanLiId(value6);

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

	public static Object translateOutputThanhPhanHoSoChungThuc(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ThanhPhanHoSoChungThucClp newModel = new ThanhPhanHoSoChungThucClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getThanhPhanHoSoId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setThanhPhanHoSoId(value0);

				Method method1 = oldModelClass.getMethod("getTieuDe");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTieuDe(value1);

				Method method2 = oldModelClass.getMethod("getMoTa");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMoTa(value2);

				Method method3 = oldModelClass.getMethod("getHoSoChungThucId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setHoSoChungThucId(value3);

				Method method4 = oldModelClass.getMethod("getThuTuc2GiayToId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setThuTuc2GiayToId(value4);

				Method method5 = oldModelClass.getMethod(
						"getNoiLuuTruHoSoDinhKemId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setNoiLuuTruHoSoDinhKemId(value5);

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