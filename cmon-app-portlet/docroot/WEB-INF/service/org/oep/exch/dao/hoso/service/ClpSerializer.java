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

package org.oep.exch.dao.hoso.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.exch.dao.hoso.model.ExchFileDinhKemClp;
import org.oep.exch.dao.hoso.model.HoSoMotCuaClp;
import org.oep.exch.dao.hoso.model.HoSoTrucTuyenClp;
import org.oep.exch.dao.hoso.model.KetQuaHosoClp;
import org.oep.exch.dao.hoso.model.TrangThaiHosoClp;
import org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyenClp;

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

		if (oldModelClassName.equals(ExchFileDinhKemClp.class.getName())) {
			return translateInputExchFileDinhKem(oldModel);
		}

		if (oldModelClassName.equals(HoSoMotCuaClp.class.getName())) {
			return translateInputHoSoMotCua(oldModel);
		}

		if (oldModelClassName.equals(HoSoTrucTuyenClp.class.getName())) {
			return translateInputHoSoTrucTuyen(oldModel);
		}

		if (oldModelClassName.equals(KetQuaHosoClp.class.getName())) {
			return translateInputKetQuaHoso(oldModel);
		}

		if (oldModelClassName.equals(TrangThaiHosoClp.class.getName())) {
			return translateInputTrangThaiHoso(oldModel);
		}

		if (oldModelClassName.equals(UpdateHoSoTrucTuyenClp.class.getName())) {
			return translateInputUpdateHoSoTrucTuyen(oldModel);
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

	public static Object translateInputExchFileDinhKem(BaseModel<?> oldModel) {
		ExchFileDinhKemClp oldCplModel = (ExchFileDinhKemClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.exch.dao.hoso.model.impl.ExchFileDinhKemImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setOnlineId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getOnlineId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTenTaiLieuDinhKem",
						new Class[] { String.class });

				String value2 = oldCplModel.getTenTaiLieuDinhKem();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUrlTaiLieuDinhKem",
						new Class[] { String.class });

				String value3 = oldCplModel.getUrlTaiLieuDinhKem();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTenFile",
						new Class[] { String.class });

				String value4 = oldCplModel.getTenFile();

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

	public static Object translateInputHoSoMotCua(BaseModel<?> oldModel) {
		HoSoMotCuaClp oldCplModel = (HoSoMotCuaClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.exch.dao.hoso.model.impl.HoSoMotCuaImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNgayChuyen",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getNgayChuyen();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMaSoHoSo",
						new Class[] { String.class });

				String value2 = oldCplModel.getMaSoHoSo();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMaLoaiHoSo",
						new Class[] { String.class });

				String value3 = oldCplModel.getMaLoaiHoSo();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setMaDonViTiepNhan",
						new Class[] { String.class });

				String value4 = oldCplModel.getMaDonViTiepNhan();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgayNopHoSo",
						new Class[] { String.class });

				String value5 = oldCplModel.getNgayNopHoSo();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgayHenTra",
						new Class[] { String.class });

				String value6 = oldCplModel.getNgayHenTra();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setHoTenNguoiNop",
						new Class[] { String.class });

				String value7 = oldCplModel.getHoTenNguoiNop();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setSoCmnd",
						new Class[] { String.class });

				String value8 = oldCplModel.getSoCmnd();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgaySinh",
						new Class[] { String.class });

				String value9 = oldCplModel.getNgaySinh();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setMaTinhThuongTru",
						new Class[] { String.class });

				String value10 = oldCplModel.getMaTinhThuongTru();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setMoTaDiaChiThuongTru",
						new Class[] { String.class });

				String value11 = oldCplModel.getMoTaDiaChiThuongTru();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setGioiTinh",
						new Class[] { Integer.TYPE });

				Integer value12 = new Integer(oldCplModel.getGioiTinh());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setMaNguoiTiepNhan",
						new Class[] { String.class });

				String value13 = oldCplModel.getMaNguoiTiepNhan();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setTenNguoiTiepNhan",
						new Class[] { String.class });

				String value14 = oldCplModel.getTenNguoiTiepNhan();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setDonViCungCap",
						new Class[] { String.class });

				String value15 = oldCplModel.getDonViCungCap();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setTrangThaiXuLy",
						new Class[] { Integer.TYPE });

				Integer value16 = new Integer(oldCplModel.getTrangThaiXuLy());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setNgayXuLy",
						new Class[] { Date.class });

				Date value17 = oldCplModel.getNgayXuLy();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setLoiKhiXuLy",
						new Class[] { String.class });

				String value18 = oldCplModel.getLoiKhiXuLy();

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

	public static Object translateInputHoSoTrucTuyen(BaseModel<?> oldModel) {
		HoSoTrucTuyenClp oldCplModel = (HoSoTrucTuyenClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.exch.dao.hoso.model.impl.HoSoTrucTuyenImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNgayTrichXuat",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getNgayTrichXuat();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setOnlineId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getOnlineId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMaLoaiHoSo",
						new Class[] { String.class });

				String value3 = oldCplModel.getMaLoaiHoSo();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setMaDonViTiepNhan",
						new Class[] { String.class });

				String value4 = oldCplModel.getMaDonViTiepNhan();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setHoTenNguoiNop",
						new Class[] { String.class });

				String value5 = oldCplModel.getHoTenNguoiNop();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDiaChiNguoiNop",
						new Class[] { String.class });

				String value6 = oldCplModel.getDiaChiNguoiNop();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgaySinh",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgaySinh();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setSoCmnd",
						new Class[] { String.class });

				String value8 = oldCplModel.getSoCmnd();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value9 = oldCplModel.getEmail();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setSoDtDiDong",
						new Class[] { String.class });

				String value10 = oldCplModel.getSoDtDiDong();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setSoDtCoDinh",
						new Class[] { String.class });

				String value11 = oldCplModel.getSoDtCoDinh();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setNgayDangKyHoSo",
						new Class[] { Date.class });

				Date value12 = oldCplModel.getNgayDangKyHoSo();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setNoiChuyenHoSo",
						new Class[] { String.class });

				String value13 = oldCplModel.getNoiChuyenHoSo();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setTrangThaiXuLy",
						new Class[] { Integer.TYPE });

				Integer value14 = new Integer(oldCplModel.getTrangThaiXuLy());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setNgayChuyen",
						new Class[] { Date.class });

				Date value15 = oldCplModel.getNgayChuyen();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setGioiTinh",
						new Class[] { Integer.TYPE });

				Integer value16 = new Integer(oldCplModel.getGioiTinh());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setChuSoHuuHoSo",
						new Class[] { String.class });

				String value17 = oldCplModel.getChuSoHuuHoSo();

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

	public static Object translateInputKetQuaHoso(BaseModel<?> oldModel) {
		KetQuaHosoClp oldCplModel = (KetQuaHosoClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.exch.dao.hoso.model.impl.KetQuaHosoImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNgayChuyen",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getNgayChuyen();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMaSoHoSo",
						new Class[] { String.class });

				String value2 = oldCplModel.getMaSoHoSo();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTenNguoiNhanKetQua",
						new Class[] { String.class });

				String value3 = oldCplModel.getTenNguoiNhanKetQua();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayNhanKetQua",
						new Class[] { String.class });

				String value4 = oldCplModel.getNgayNhanKetQua();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setLePhiHoSo",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getLePhiHoSo());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setPhiXuLyHoSo",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getPhiXuLyHoSo());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgayHoanThanh",
						new Class[] { String.class });

				String value7 = oldCplModel.getNgayHoanThanh();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setMaCanBoTraKetQua",
						new Class[] { String.class });

				String value8 = oldCplModel.getMaCanBoTraKetQua();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setTenCanBoTraKetQua",
						new Class[] { String.class });

				String value9 = oldCplModel.getTenCanBoTraKetQua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDonViCungCap",
						new Class[] { String.class });

				String value10 = oldCplModel.getDonViCungCap();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setTrangThaiXuLy",
						new Class[] { Integer.TYPE });

				Integer value11 = new Integer(oldCplModel.getTrangThaiXuLy());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setNgayXuLy",
						new Class[] { Date.class });

				Date value12 = oldCplModel.getNgayXuLy();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLoiKhiXuLy",
						new Class[] { String.class });

				String value13 = oldCplModel.getLoiKhiXuLy();

				method13.invoke(newModel, value13);

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

	public static Object translateInputTrangThaiHoso(BaseModel<?> oldModel) {
		TrangThaiHosoClp oldCplModel = (TrangThaiHosoClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.exch.dao.hoso.model.impl.TrangThaiHosoImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNgayChuyen",
						new Class[] { Date.class });

				Date value1 = oldCplModel.getNgayChuyen();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setOnlineId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getOnlineId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setMaSoHoSo",
						new Class[] { String.class });

				String value3 = oldCplModel.getMaSoHoSo();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayHenTra",
						new Class[] { String.class });

				String value4 = oldCplModel.getNgayHenTra();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setMaNguoiXuLyHienTai",
						new Class[] { String.class });

				String value5 = oldCplModel.getMaNguoiXuLyHienTai();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setTenNguoiXuLyHienTai",
						new Class[] { String.class });

				String value6 = oldCplModel.getTenNguoiXuLyHienTai();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setTenPhongBanXuLyHienTai",
						new Class[] { String.class });

				String value7 = oldCplModel.getTenPhongBanXuLyHienTai();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNgayGioLuanChuyen",
						new Class[] { String.class });

				String value8 = oldCplModel.getNgayGioLuanChuyen();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setSoGioYeuCauXuLy",
						new Class[] { Integer.TYPE });

				Integer value9 = new Integer(oldCplModel.getSoGioYeuCauXuLy());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNoiDungYeuCauXuLy",
						new Class[] { String.class });

				String value10 = oldCplModel.getNoiDungYeuCauXuLy();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setSoGioThucHien",
						new Class[] { Integer.TYPE });

				Integer value11 = new Integer(oldCplModel.getSoGioThucHien());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setTrangThaiHienTai",
						new Class[] { Integer.TYPE });

				Integer value12 = new Integer(oldCplModel.getTrangThaiHienTai());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setMaNguoiXuLyKeTiep",
						new Class[] { String.class });

				String value13 = oldCplModel.getMaNguoiXuLyKeTiep();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setTenNguoiXuLyKeTiep",
						new Class[] { String.class });

				String value14 = oldCplModel.getTenNguoiXuLyKeTiep();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setTenPhongBanXuLyKeTiep",
						new Class[] { String.class });

				String value15 = oldCplModel.getTenPhongBanXuLyKeTiep();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setTrangThaiKeTiep",
						new Class[] { Integer.TYPE });

				Integer value16 = new Integer(oldCplModel.getTrangThaiKeTiep());

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setDonViCungCap",
						new Class[] { String.class });

				String value17 = oldCplModel.getDonViCungCap();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setTrangThaiXuLy",
						new Class[] { Integer.TYPE });

				Integer value18 = new Integer(oldCplModel.getTrangThaiXuLy());

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setNgayXuLy",
						new Class[] { Date.class });

				Date value19 = oldCplModel.getNgayXuLy();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setLoiKhiXuLy",
						new Class[] { String.class });

				String value20 = oldCplModel.getLoiKhiXuLy();

				method20.invoke(newModel, value20);

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

	public static Object translateInputUpdateHoSoTrucTuyen(
		BaseModel<?> oldModel) {
		UpdateHoSoTrucTuyenClp oldCplModel = (UpdateHoSoTrucTuyenClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.exch.dao.hoso.model.impl.UpdateHoSoTrucTuyenImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTrangThaiXuLy",
						new Class[] { Integer.TYPE });

				Integer value1 = new Integer(oldCplModel.getTrangThaiXuLy());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNgayChuyen",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getNgayChuyen();

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
					"org.oep.exch.dao.hoso.model.impl.ExchFileDinhKemImpl")) {
			return translateOutputExchFileDinhKem(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.exch.dao.hoso.model.impl.HoSoMotCuaImpl")) {
			return translateOutputHoSoMotCua(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.exch.dao.hoso.model.impl.HoSoTrucTuyenImpl")) {
			return translateOutputHoSoTrucTuyen(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.exch.dao.hoso.model.impl.KetQuaHosoImpl")) {
			return translateOutputKetQuaHoso(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.exch.dao.hoso.model.impl.TrangThaiHosoImpl")) {
			return translateOutputTrangThaiHoso(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.exch.dao.hoso.model.impl.UpdateHoSoTrucTuyenImpl")) {
			return translateOutputUpdateHoSoTrucTuyen(oldModel);
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

	public static Object translateOutputExchFileDinhKem(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ExchFileDinhKemClp newModel = new ExchFileDinhKemClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getOnlineId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setOnlineId(value1);

				Method method2 = oldModelClass.getMethod("getTenTaiLieuDinhKem");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTenTaiLieuDinhKem(value2);

				Method method3 = oldModelClass.getMethod("getUrlTaiLieuDinhKem");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setUrlTaiLieuDinhKem(value3);

				Method method4 = oldModelClass.getMethod("getTenFile");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setTenFile(value4);

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

	public static Object translateOutputHoSoMotCua(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HoSoMotCuaClp newModel = new HoSoMotCuaClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNgayChuyen");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setNgayChuyen(value1);

				Method method2 = oldModelClass.getMethod("getMaSoHoSo");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMaSoHoSo(value2);

				Method method3 = oldModelClass.getMethod("getMaLoaiHoSo");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMaLoaiHoSo(value3);

				Method method4 = oldModelClass.getMethod("getMaDonViTiepNhan");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setMaDonViTiepNhan(value4);

				Method method5 = oldModelClass.getMethod("getNgayNopHoSo");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNgayNopHoSo(value5);

				Method method6 = oldModelClass.getMethod("getNgayHenTra");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNgayHenTra(value6);

				Method method7 = oldModelClass.getMethod("getHoTenNguoiNop");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setHoTenNguoiNop(value7);

				Method method8 = oldModelClass.getMethod("getSoCmnd");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setSoCmnd(value8);

				Method method9 = oldModelClass.getMethod("getNgaySinh");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setNgaySinh(value9);

				Method method10 = oldModelClass.getMethod("getMaTinhThuongTru");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setMaTinhThuongTru(value10);

				Method method11 = oldModelClass.getMethod(
						"getMoTaDiaChiThuongTru");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setMoTaDiaChiThuongTru(value11);

				Method method12 = oldModelClass.getMethod("getGioiTinh");

				Integer value12 = (Integer)method12.invoke(oldModel,
						(Object[])null);

				newModel.setGioiTinh(value12);

				Method method13 = oldModelClass.getMethod("getMaNguoiTiepNhan");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setMaNguoiTiepNhan(value13);

				Method method14 = oldModelClass.getMethod("getTenNguoiTiepNhan");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setTenNguoiTiepNhan(value14);

				Method method15 = oldModelClass.getMethod("getDonViCungCap");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setDonViCungCap(value15);

				Method method16 = oldModelClass.getMethod("getTrangThaiXuLy");

				Integer value16 = (Integer)method16.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiXuLy(value16);

				Method method17 = oldModelClass.getMethod("getNgayXuLy");

				Date value17 = (Date)method17.invoke(oldModel, (Object[])null);

				newModel.setNgayXuLy(value17);

				Method method18 = oldModelClass.getMethod("getLoiKhiXuLy");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setLoiKhiXuLy(value18);

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

	public static Object translateOutputHoSoTrucTuyen(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HoSoTrucTuyenClp newModel = new HoSoTrucTuyenClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNgayTrichXuat");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setNgayTrichXuat(value1);

				Method method2 = oldModelClass.getMethod("getOnlineId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setOnlineId(value2);

				Method method3 = oldModelClass.getMethod("getMaLoaiHoSo");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMaLoaiHoSo(value3);

				Method method4 = oldModelClass.getMethod("getMaDonViTiepNhan");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setMaDonViTiepNhan(value4);

				Method method5 = oldModelClass.getMethod("getHoTenNguoiNop");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setHoTenNguoiNop(value5);

				Method method6 = oldModelClass.getMethod("getDiaChiNguoiNop");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setDiaChiNguoiNop(value6);

				Method method7 = oldModelClass.getMethod("getNgaySinh");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgaySinh(value7);

				Method method8 = oldModelClass.getMethod("getSoCmnd");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setSoCmnd(value8);

				Method method9 = oldModelClass.getMethod("getEmail");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setEmail(value9);

				Method method10 = oldModelClass.getMethod("getSoDtDiDong");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setSoDtDiDong(value10);

				Method method11 = oldModelClass.getMethod("getSoDtCoDinh");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setSoDtCoDinh(value11);

				Method method12 = oldModelClass.getMethod("getNgayDangKyHoSo");

				Date value12 = (Date)method12.invoke(oldModel, (Object[])null);

				newModel.setNgayDangKyHoSo(value12);

				Method method13 = oldModelClass.getMethod("getNoiChuyenHoSo");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setNoiChuyenHoSo(value13);

				Method method14 = oldModelClass.getMethod("getTrangThaiXuLy");

				Integer value14 = (Integer)method14.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiXuLy(value14);

				Method method15 = oldModelClass.getMethod("getNgayChuyen");

				Date value15 = (Date)method15.invoke(oldModel, (Object[])null);

				newModel.setNgayChuyen(value15);

				Method method16 = oldModelClass.getMethod("getGioiTinh");

				Integer value16 = (Integer)method16.invoke(oldModel,
						(Object[])null);

				newModel.setGioiTinh(value16);

				Method method17 = oldModelClass.getMethod("getChuSoHuuHoSo");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setChuSoHuuHoSo(value17);

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

	public static Object translateOutputKetQuaHoso(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				KetQuaHosoClp newModel = new KetQuaHosoClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNgayChuyen");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setNgayChuyen(value1);

				Method method2 = oldModelClass.getMethod("getMaSoHoSo");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMaSoHoSo(value2);

				Method method3 = oldModelClass.getMethod(
						"getTenNguoiNhanKetQua");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setTenNguoiNhanKetQua(value3);

				Method method4 = oldModelClass.getMethod("getNgayNhanKetQua");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayNhanKetQua(value4);

				Method method5 = oldModelClass.getMethod("getLePhiHoSo");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setLePhiHoSo(value5);

				Method method6 = oldModelClass.getMethod("getPhiXuLyHoSo");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setPhiXuLyHoSo(value6);

				Method method7 = oldModelClass.getMethod("getNgayHoanThanh");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNgayHoanThanh(value7);

				Method method8 = oldModelClass.getMethod("getMaCanBoTraKetQua");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setMaCanBoTraKetQua(value8);

				Method method9 = oldModelClass.getMethod("getTenCanBoTraKetQua");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setTenCanBoTraKetQua(value9);

				Method method10 = oldModelClass.getMethod("getDonViCungCap");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setDonViCungCap(value10);

				Method method11 = oldModelClass.getMethod("getTrangThaiXuLy");

				Integer value11 = (Integer)method11.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiXuLy(value11);

				Method method12 = oldModelClass.getMethod("getNgayXuLy");

				Date value12 = (Date)method12.invoke(oldModel, (Object[])null);

				newModel.setNgayXuLy(value12);

				Method method13 = oldModelClass.getMethod("getLoiKhiXuLy");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setLoiKhiXuLy(value13);

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

	public static Object translateOutputTrangThaiHoso(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TrangThaiHosoClp newModel = new TrangThaiHosoClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getNgayChuyen");

				Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

				newModel.setNgayChuyen(value1);

				Method method2 = oldModelClass.getMethod("getOnlineId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setOnlineId(value2);

				Method method3 = oldModelClass.getMethod("getMaSoHoSo");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMaSoHoSo(value3);

				Method method4 = oldModelClass.getMethod("getNgayHenTra");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayHenTra(value4);

				Method method5 = oldModelClass.getMethod(
						"getMaNguoiXuLyHienTai");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setMaNguoiXuLyHienTai(value5);

				Method method6 = oldModelClass.getMethod(
						"getTenNguoiXuLyHienTai");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setTenNguoiXuLyHienTai(value6);

				Method method7 = oldModelClass.getMethod(
						"getTenPhongBanXuLyHienTai");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setTenPhongBanXuLyHienTai(value7);

				Method method8 = oldModelClass.getMethod("getNgayGioLuanChuyen");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setNgayGioLuanChuyen(value8);

				Method method9 = oldModelClass.getMethod("getSoGioYeuCauXuLy");

				Integer value9 = (Integer)method9.invoke(oldModel,
						(Object[])null);

				newModel.setSoGioYeuCauXuLy(value9);

				Method method10 = oldModelClass.getMethod(
						"getNoiDungYeuCauXuLy");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNoiDungYeuCauXuLy(value10);

				Method method11 = oldModelClass.getMethod("getSoGioThucHien");

				Integer value11 = (Integer)method11.invoke(oldModel,
						(Object[])null);

				newModel.setSoGioThucHien(value11);

				Method method12 = oldModelClass.getMethod("getTrangThaiHienTai");

				Integer value12 = (Integer)method12.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiHienTai(value12);

				Method method13 = oldModelClass.getMethod(
						"getMaNguoiXuLyKeTiep");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setMaNguoiXuLyKeTiep(value13);

				Method method14 = oldModelClass.getMethod(
						"getTenNguoiXuLyKeTiep");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setTenNguoiXuLyKeTiep(value14);

				Method method15 = oldModelClass.getMethod(
						"getTenPhongBanXuLyKeTiep");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setTenPhongBanXuLyKeTiep(value15);

				Method method16 = oldModelClass.getMethod("getTrangThaiKeTiep");

				Integer value16 = (Integer)method16.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiKeTiep(value16);

				Method method17 = oldModelClass.getMethod("getDonViCungCap");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setDonViCungCap(value17);

				Method method18 = oldModelClass.getMethod("getTrangThaiXuLy");

				Integer value18 = (Integer)method18.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiXuLy(value18);

				Method method19 = oldModelClass.getMethod("getNgayXuLy");

				Date value19 = (Date)method19.invoke(oldModel, (Object[])null);

				newModel.setNgayXuLy(value19);

				Method method20 = oldModelClass.getMethod("getLoiKhiXuLy");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setLoiKhiXuLy(value20);

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

	public static Object translateOutputUpdateHoSoTrucTuyen(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				UpdateHoSoTrucTuyenClp newModel = new UpdateHoSoTrucTuyenClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTrangThaiXuLy");

				Integer value1 = (Integer)method1.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThaiXuLy(value1);

				Method method2 = oldModelClass.getMethod("getNgayChuyen");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setNgayChuyen(value2);

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