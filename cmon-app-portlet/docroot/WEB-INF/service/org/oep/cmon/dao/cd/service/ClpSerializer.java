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

package org.oep.cmon.dao.cd.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.oep.cmon.dao.cd.model.ChuyenMonClp;
import org.oep.cmon.dao.cd.model.CongDanClp;
import org.oep.cmon.dao.cd.model.DanTocClp;
import org.oep.cmon.dao.cd.model.GioiTinhClp;
import org.oep.cmon.dao.cd.model.HeThongClp;
import org.oep.cmon.dao.cd.model.HoChieuCMNDClp;
import org.oep.cmon.dao.cd.model.NgheNghiepClp;
import org.oep.cmon.dao.cd.model.QuanHeGiaDinhClp;
import org.oep.cmon.dao.cd.model.TinhTrangHonNhanClp;
import org.oep.cmon.dao.cd.model.TonGiaoClp;
import org.oep.cmon.dao.cd.model.TrinhDoChuyenMonClp;
import org.oep.cmon.dao.cd.model.TrinhDoHocVanClp;

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

		if (oldModelClassName.equals(ChuyenMonClp.class.getName())) {
			return translateInputChuyenMon(oldModel);
		}

		if (oldModelClassName.equals(CongDanClp.class.getName())) {
			return translateInputCongDan(oldModel);
		}

		if (oldModelClassName.equals(DanTocClp.class.getName())) {
			return translateInputDanToc(oldModel);
		}

		if (oldModelClassName.equals(GioiTinhClp.class.getName())) {
			return translateInputGioiTinh(oldModel);
		}

		if (oldModelClassName.equals(HeThongClp.class.getName())) {
			return translateInputHeThong(oldModel);
		}

		if (oldModelClassName.equals(HoChieuCMNDClp.class.getName())) {
			return translateInputHoChieuCMND(oldModel);
		}

		if (oldModelClassName.equals(NgheNghiepClp.class.getName())) {
			return translateInputNgheNghiep(oldModel);
		}

		if (oldModelClassName.equals(QuanHeGiaDinhClp.class.getName())) {
			return translateInputQuanHeGiaDinh(oldModel);
		}

		if (oldModelClassName.equals(TinhTrangHonNhanClp.class.getName())) {
			return translateInputTinhTrangHonNhan(oldModel);
		}

		if (oldModelClassName.equals(TonGiaoClp.class.getName())) {
			return translateInputTonGiao(oldModel);
		}

		if (oldModelClassName.equals(TrinhDoChuyenMonClp.class.getName())) {
			return translateInputTrinhDoChuyenMon(oldModel);
		}

		if (oldModelClassName.equals(TrinhDoHocVanClp.class.getName())) {
			return translateInputTrinhDoHocVan(oldModel);
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

	public static Object translateInputChuyenMon(BaseModel<?> oldModel) {
		ChuyenMonClp oldCplModel = (ChuyenMonClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.ChuyenMonImpl",
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

				Method method3 = newModelClass.getMethod("setPhienban",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getPhienban());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgaytao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgaytao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoitao",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoitao();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNgaysua",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgaysua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoisua",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoisua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDaxoa",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getDaxoa());

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

	public static Object translateInputCongDan(BaseModel<?> oldModel) {
		CongDanClp oldCplModel = (CongDanClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.CongDanImpl",
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

				Method method2 = newModelClass.getMethod("setHo",
						new Class[] { String.class });

				String value2 = oldCplModel.getHo();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setDem",
						new Class[] { String.class });

				String value3 = oldCplModel.getDem();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTen",
						new Class[] { String.class });

				String value4 = oldCplModel.getTen();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgaySinh",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgaySinh();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setSoCmnd",
						new Class[] { String.class });

				String value6 = oldCplModel.getSoCmnd();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgayCapCmnd",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgayCapCmnd();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setGhiChuCmnd",
						new Class[] { String.class });

				String value8 = oldCplModel.getGhiChuCmnd();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setSoHoChieu",
						new Class[] { String.class });

				String value9 = oldCplModel.getSoHoChieu();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNgayCapHoChieu",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getNgayCapHoChieu();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNgayHetHanHoChieu",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getNgayHetHanHoChieu();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setNoiCapHoChieuId",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getNoiCapHoChieuId());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setGhiChuHoChieu",
						new Class[] { String.class });

				String value13 = oldCplModel.getGhiChuHoChieu();

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setSoBaoHiemYTe",
						new Class[] { String.class });

				String value14 = oldCplModel.getSoBaoHiemYTe();

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setMaSoThueCaNhan",
						new Class[] { String.class });

				String value15 = oldCplModel.getMaSoThueCaNhan();

				method15.invoke(newModel, value15);

				Method method16 = newModelClass.getMethod("setDiaChiThuongTru",
						new Class[] { String.class });

				String value16 = oldCplModel.getDiaChiThuongTru();

				method16.invoke(newModel, value16);

				Method method17 = newModelClass.getMethod("setDiaChiHienNay",
						new Class[] { String.class });

				String value17 = oldCplModel.getDiaChiHienNay();

				method17.invoke(newModel, value17);

				Method method18 = newModelClass.getMethod("setDienThoaiCoDinh",
						new Class[] { String.class });

				String value18 = oldCplModel.getDienThoaiCoDinh();

				method18.invoke(newModel, value18);

				Method method19 = newModelClass.getMethod("setDienThoaiDiDong",
						new Class[] { String.class });

				String value19 = oldCplModel.getDienThoaiDiDong();

				method19.invoke(newModel, value19);

				Method method20 = newModelClass.getMethod("setHoTenCha",
						new Class[] { String.class });

				String value20 = oldCplModel.getHoTenCha();

				method20.invoke(newModel, value20);

				Method method21 = newModelClass.getMethod("setHoTenMe",
						new Class[] { String.class });

				String value21 = oldCplModel.getHoTenMe();

				method21.invoke(newModel, value21);

				Method method22 = newModelClass.getMethod("setHoTenVoHoacChong",
						new Class[] { String.class });

				String value22 = oldCplModel.getHoTenVoHoacChong();

				method22.invoke(newModel, value22);

				Method method23 = newModelClass.getMethod("setSoHoKhau",
						new Class[] { String.class });

				String value23 = oldCplModel.getSoHoKhau();

				method23.invoke(newModel, value23);

				Method method24 = newModelClass.getMethod("setLaChuHo",
						new Class[] { Integer.TYPE });

				Integer value24 = new Integer(oldCplModel.getLaChuHo());

				method24.invoke(newModel, value24);

				Method method25 = newModelClass.getMethod("setTinhTrangHonNhanId",
						new Class[] { Long.TYPE });

				Long value25 = new Long(oldCplModel.getTinhTrangHonNhanId());

				method25.invoke(newModel, value25);

				Method method26 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value26 = oldCplModel.getEmail();

				method26.invoke(newModel, value26);

				Method method27 = newModelClass.getMethod("setTrinhDoChuyenMonId",
						new Class[] { Long.TYPE });

				Long value27 = new Long(oldCplModel.getTrinhDoChuyenMonId());

				method27.invoke(newModel, value27);

				Method method28 = newModelClass.getMethod("setSoDinhDanhChaId",
						new Class[] { Long.TYPE });

				Long value28 = new Long(oldCplModel.getSoDinhDanhChaId());

				method28.invoke(newModel, value28);

				Method method29 = newModelClass.getMethod("setSoDinhDanhVoHoacChongId",
						new Class[] { Long.TYPE });

				Long value29 = new Long(oldCplModel.getSoDinhDanhVoHoacChongId());

				method29.invoke(newModel, value29);

				Method method30 = newModelClass.getMethod("setDanTocId",
						new Class[] { Long.TYPE });

				Long value30 = new Long(oldCplModel.getDanTocId());

				method30.invoke(newModel, value30);

				Method method31 = newModelClass.getMethod("setDiaChiHienNayHuyenId",
						new Class[] { Long.TYPE });

				Long value31 = new Long(oldCplModel.getDiaChiHienNayHuyenId());

				method31.invoke(newModel, value31);

				Method method32 = newModelClass.getMethod("setDiaChiHienNayTinhId",
						new Class[] { Long.TYPE });

				Long value32 = new Long(oldCplModel.getDiaChiHienNayTinhId());

				method32.invoke(newModel, value32);

				Method method33 = newModelClass.getMethod("setDiaChiHienNayXaId",
						new Class[] { Long.TYPE });

				Long value33 = new Long(oldCplModel.getDiaChiHienNayXaId());

				method33.invoke(newModel, value33);

				Method method34 = newModelClass.getMethod("setDiaChiThuongTruHuyenId",
						new Class[] { Long.TYPE });

				Long value34 = new Long(oldCplModel.getDiaChiThuongTruHuyenId());

				method34.invoke(newModel, value34);

				Method method35 = newModelClass.getMethod("setDiaChiThuongTruTinhId",
						new Class[] { Long.TYPE });

				Long value35 = new Long(oldCplModel.getDiaChiThuongTruTinhId());

				method35.invoke(newModel, value35);

				Method method36 = newModelClass.getMethod("setDiaChiThuongTruXaId",
						new Class[] { Long.TYPE });

				Long value36 = new Long(oldCplModel.getDiaChiThuongTruXaId());

				method36.invoke(newModel, value36);

				Method method37 = newModelClass.getMethod("setGioiTinh",
						new Class[] { Integer.TYPE });

				Integer value37 = new Integer(oldCplModel.getGioiTinh());

				method37.invoke(newModel, value37);

				Method method38 = newModelClass.getMethod("setNgheNghiepId",
						new Class[] { Long.TYPE });

				Long value38 = new Long(oldCplModel.getNgheNghiepId());

				method38.invoke(newModel, value38);

				Method method39 = newModelClass.getMethod("setNoiSinhHuyenId",
						new Class[] { Long.TYPE });

				Long value39 = new Long(oldCplModel.getNoiSinhHuyenId());

				method39.invoke(newModel, value39);

				Method method40 = newModelClass.getMethod("setNoiSinhTinhId",
						new Class[] { Long.TYPE });

				Long value40 = new Long(oldCplModel.getNoiSinhTinhId());

				method40.invoke(newModel, value40);

				Method method41 = newModelClass.getMethod("setNoiSinhXaId",
						new Class[] { Long.TYPE });

				Long value41 = new Long(oldCplModel.getNoiSinhXaId());

				method41.invoke(newModel, value41);

				Method method42 = newModelClass.getMethod("setNoiSinhChiTiet",
						new Class[] { String.class });

				String value42 = oldCplModel.getNoiSinhChiTiet();

				method42.invoke(newModel, value42);

				Method method43 = newModelClass.getMethod("setNoiCapCmndId",
						new Class[] { Long.TYPE });

				Long value43 = new Long(oldCplModel.getNoiCapCmndId());

				method43.invoke(newModel, value43);

				Method method44 = newModelClass.getMethod("setTonGiaoId",
						new Class[] { Long.TYPE });

				Long value44 = new Long(oldCplModel.getTonGiaoId());

				method44.invoke(newModel, value44);

				Method method45 = newModelClass.getMethod("setSoDinhDanhMeId",
						new Class[] { Long.TYPE });

				Long value45 = new Long(oldCplModel.getSoDinhDanhMeId());

				method45.invoke(newModel, value45);

				Method method46 = newModelClass.getMethod("setTrinhDoHocVanId",
						new Class[] { Long.TYPE });

				Long value46 = new Long(oldCplModel.getTrinhDoHocVanId());

				method46.invoke(newModel, value46);

				Method method47 = newModelClass.getMethod("setTaiKhoanNguoiDungId",
						new Class[] { Long.TYPE });

				Long value47 = new Long(oldCplModel.getTaiKhoanNguoiDungId());

				method47.invoke(newModel, value47);

				Method method48 = newModelClass.getMethod("setQuanHeChuHoId",
						new Class[] { Long.TYPE });

				Long value48 = new Long(oldCplModel.getQuanHeChuHoId());

				method48.invoke(newModel, value48);

				Method method49 = newModelClass.getMethod("setQuocTichId",
						new Class[] { Long.TYPE });

				Long value49 = new Long(oldCplModel.getQuocTichId());

				method49.invoke(newModel, value49);

				Method method50 = newModelClass.getMethod("setDoanhNghiepId",
						new Class[] { Long.TYPE });

				Long value50 = new Long(oldCplModel.getDoanhNghiepId());

				method50.invoke(newModel, value50);

				Method method51 = newModelClass.getMethod("setTenDayDu",
						new Class[] { String.class });

				String value51 = oldCplModel.getTenDayDu();

				method51.invoke(newModel, value51);

				Method method52 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value52 = oldCplModel.getNgayTao();

				method52.invoke(newModel, value52);

				Method method53 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value53 = oldCplModel.getNgaySua();

				method53.invoke(newModel, value53);

				Method method54 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value54 = oldCplModel.getNguoiTao();

				method54.invoke(newModel, value54);

				Method method55 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value55 = oldCplModel.getNguoiSua();

				method55.invoke(newModel, value55);

				Method method56 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value56 = new Integer(oldCplModel.getDaXoa());

				method56.invoke(newModel, value56);

				Method method57 = newModelClass.getMethod("setFax",
						new Class[] { String.class });

				String value57 = oldCplModel.getFax();

				method57.invoke(newModel, value57);

				Method method58 = newModelClass.getMethod("setWebsite",
						new Class[] { String.class });

				String value58 = oldCplModel.getWebsite();

				method58.invoke(newModel, value58);

				Method method59 = newModelClass.getMethod("setTinhtrang",
						new Class[] { Integer.TYPE });

				Integer value59 = new Integer(oldCplModel.getTinhtrang());

				method59.invoke(newModel, value59);

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

	public static Object translateInputDanToc(BaseModel<?> oldModel) {
		DanTocClp oldCplModel = (DanTocClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.DanTocImpl",
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

				Method method3 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getPhienBan());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setLaThieuSo",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getLaThieuSo());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgayTao();

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

				Method method9 = newModelClass.getMethod("setTenKhac",
						new Class[] { String.class });

				String value9 = oldCplModel.getTenKhac();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getNgaySua();

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

	public static Object translateInputGioiTinh(BaseModel<?> oldModel) {
		GioiTinhClp oldCplModel = (GioiTinhClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.GioiTinhImpl",
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

				Method method3 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayTao();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getNgaySua();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiSua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getDaXoa());

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

	public static Object translateInputHeThong(BaseModel<?> oldModel) {
		HeThongClp oldCplModel = (HeThongClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.HeThongImpl",
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

				Method method3 = newModelClass.getMethod("setMoTa",
						new Class[] { String.class });

				String value3 = oldCplModel.getMoTa();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getNgayTao();

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

				Method method8 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getNgaySua();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value9 = new Integer(oldCplModel.getTrangThai());

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

	public static Object translateInputHoChieuCMND(BaseModel<?> oldModel) {
		HoChieuCMNDClp oldCplModel = (HoChieuCMNDClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.HoChieuCMNDImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setSo",
						new Class[] { String.class });

				String value1 = oldCplModel.getSo();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setNgayCap",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getNgayCap();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgayHetHan",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgayHetHan();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNoiCapId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getNoiCapId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNoiCap",
						new Class[] { String.class });

				String value5 = oldCplModel.getNoiCap();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setGiChu",
						new Class[] { String.class });

				String value6 = oldCplModel.getGiChu();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setLoai",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getLoai());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getTrangThai());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value9 = oldCplModel.getNguoiTao();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getNgayTao();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value11 = oldCplModel.getNguoiSua();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value12 = oldCplModel.getNgaySua();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setCongDanID",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getCongDanID());

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

	public static Object translateInputNgheNghiep(BaseModel<?> oldModel) {
		NgheNghiepClp oldCplModel = (NgheNghiepClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.NgheNghiepImpl",
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

				Method method4 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getDaXoa());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoiTao();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiSua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgaySua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getPhienBan());

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

	public static Object translateInputQuanHeGiaDinh(BaseModel<?> oldModel) {
		QuanHeGiaDinhClp oldCplModel = (QuanHeGiaDinhClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.QuanHeGiaDinhImpl",
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

				Method method2 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getNgayTao();

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

				Method method6 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getNgaySua();

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

	public static Object translateInputTinhTrangHonNhan(BaseModel<?> oldModel) {
		TinhTrangHonNhanClp oldCplModel = (TinhTrangHonNhanClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.TinhTrangHonNhanImpl",
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

				Method method2 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getNgayTao();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getNgaySua();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value4 = oldCplModel.getNguoiTao();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getDaXoa());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiSua();

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

	public static Object translateInputTonGiao(BaseModel<?> oldModel) {
		TonGiaoClp oldCplModel = (TonGiaoClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.TonGiaoImpl",
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

				Method method4 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getDaXoa());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoiTao();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiSua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgaySua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getPhienBan());

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

	public static Object translateInputTrinhDoChuyenMon(BaseModel<?> oldModel) {
		TrinhDoChuyenMonClp oldCplModel = (TrinhDoChuyenMonClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.TrinhDoChuyenMonImpl",
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

				Method method4 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getDaXoa());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setChuyenMonId",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getChuyenMonId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiTao();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value7 = oldCplModel.getNguoiSua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getNgaySua();

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

	public static Object translateInputTrinhDoHocVan(BaseModel<?> oldModel) {
		TrinhDoHocVanClp oldCplModel = (TrinhDoHocVanClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.oep.cmon.dao.cd.model.impl.TrinhDoHocVanImpl",
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

				Method method4 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getDaXoa());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value5 = oldCplModel.getNguoiTao();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value6 = oldCplModel.getNguoiSua();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgaySua();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setPhienBan",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getPhienBan());

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
					"org.oep.cmon.dao.cd.model.impl.ChuyenMonImpl")) {
			return translateOutputChuyenMon(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.CongDanImpl")) {
			return translateOutputCongDan(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.DanTocImpl")) {
			return translateOutputDanToc(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.GioiTinhImpl")) {
			return translateOutputGioiTinh(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.HeThongImpl")) {
			return translateOutputHeThong(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.HoChieuCMNDImpl")) {
			return translateOutputHoChieuCMND(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.NgheNghiepImpl")) {
			return translateOutputNgheNghiep(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.QuanHeGiaDinhImpl")) {
			return translateOutputQuanHeGiaDinh(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.TinhTrangHonNhanImpl")) {
			return translateOutputTinhTrangHonNhan(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.TonGiaoImpl")) {
			return translateOutputTonGiao(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.TrinhDoChuyenMonImpl")) {
			return translateOutputTrinhDoChuyenMon(oldModel);
		}

		if (oldModelClassName.equals(
					"org.oep.cmon.dao.cd.model.impl.TrinhDoHocVanImpl")) {
			return translateOutputTrinhDoHocVan(oldModel);
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

	public static Object translateOutputChuyenMon(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ChuyenMonClp newModel = new ChuyenMonClp();

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

				Method method3 = oldModelClass.getMethod("getPhienban");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setPhienban(value3);

				Method method4 = oldModelClass.getMethod("getNgaytao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgaytao(value4);

				Method method5 = oldModelClass.getMethod("getNguoitao");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoitao(value5);

				Method method6 = oldModelClass.getMethod("getNgaysua");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgaysua(value6);

				Method method7 = oldModelClass.getMethod("getNguoisua");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoisua(value7);

				Method method8 = oldModelClass.getMethod("getDaxoa");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setDaxoa(value8);

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

	public static Object translateOutputCongDan(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CongDanClp newModel = new CongDanClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getMa");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setMa(value1);

				Method method2 = oldModelClass.getMethod("getHo");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setHo(value2);

				Method method3 = oldModelClass.getMethod("getDem");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setDem(value3);

				Method method4 = oldModelClass.getMethod("getTen");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setTen(value4);

				Method method5 = oldModelClass.getMethod("getNgaySinh");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgaySinh(value5);

				Method method6 = oldModelClass.getMethod("getSoCmnd");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setSoCmnd(value6);

				Method method7 = oldModelClass.getMethod("getNgayCapCmnd");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgayCapCmnd(value7);

				Method method8 = oldModelClass.getMethod("getGhiChuCmnd");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setGhiChuCmnd(value8);

				Method method9 = oldModelClass.getMethod("getSoHoChieu");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setSoHoChieu(value9);

				Method method10 = oldModelClass.getMethod("getNgayCapHoChieu");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setNgayCapHoChieu(value10);

				Method method11 = oldModelClass.getMethod(
						"getNgayHetHanHoChieu");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setNgayHetHanHoChieu(value11);

				Method method12 = oldModelClass.getMethod("getNoiCapHoChieuId");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setNoiCapHoChieuId(value12);

				Method method13 = oldModelClass.getMethod("getGhiChuHoChieu");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setGhiChuHoChieu(value13);

				Method method14 = oldModelClass.getMethod("getSoBaoHiemYTe");

				String value14 = (String)method14.invoke(oldModel,
						(Object[])null);

				newModel.setSoBaoHiemYTe(value14);

				Method method15 = oldModelClass.getMethod("getMaSoThueCaNhan");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setMaSoThueCaNhan(value15);

				Method method16 = oldModelClass.getMethod("getDiaChiThuongTru");

				String value16 = (String)method16.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiThuongTru(value16);

				Method method17 = oldModelClass.getMethod("getDiaChiHienNay");

				String value17 = (String)method17.invoke(oldModel,
						(Object[])null);

				newModel.setDiaChiHienNay(value17);

				Method method18 = oldModelClass.getMethod("getDienThoaiCoDinh");

				String value18 = (String)method18.invoke(oldModel,
						(Object[])null);

				newModel.setDienThoaiCoDinh(value18);

				Method method19 = oldModelClass.getMethod("getDienThoaiDiDong");

				String value19 = (String)method19.invoke(oldModel,
						(Object[])null);

				newModel.setDienThoaiDiDong(value19);

				Method method20 = oldModelClass.getMethod("getHoTenCha");

				String value20 = (String)method20.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenCha(value20);

				Method method21 = oldModelClass.getMethod("getHoTenMe");

				String value21 = (String)method21.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenMe(value21);

				Method method22 = oldModelClass.getMethod("getHoTenVoHoacChong");

				String value22 = (String)method22.invoke(oldModel,
						(Object[])null);

				newModel.setHoTenVoHoacChong(value22);

				Method method23 = oldModelClass.getMethod("getSoHoKhau");

				String value23 = (String)method23.invoke(oldModel,
						(Object[])null);

				newModel.setSoHoKhau(value23);

				Method method24 = oldModelClass.getMethod("getLaChuHo");

				Integer value24 = (Integer)method24.invoke(oldModel,
						(Object[])null);

				newModel.setLaChuHo(value24);

				Method method25 = oldModelClass.getMethod(
						"getTinhTrangHonNhanId");

				Long value25 = (Long)method25.invoke(oldModel, (Object[])null);

				newModel.setTinhTrangHonNhanId(value25);

				Method method26 = oldModelClass.getMethod("getEmail");

				String value26 = (String)method26.invoke(oldModel,
						(Object[])null);

				newModel.setEmail(value26);

				Method method27 = oldModelClass.getMethod(
						"getTrinhDoChuyenMonId");

				Long value27 = (Long)method27.invoke(oldModel, (Object[])null);

				newModel.setTrinhDoChuyenMonId(value27);

				Method method28 = oldModelClass.getMethod("getSoDinhDanhChaId");

				Long value28 = (Long)method28.invoke(oldModel, (Object[])null);

				newModel.setSoDinhDanhChaId(value28);

				Method method29 = oldModelClass.getMethod(
						"getSoDinhDanhVoHoacChongId");

				Long value29 = (Long)method29.invoke(oldModel, (Object[])null);

				newModel.setSoDinhDanhVoHoacChongId(value29);

				Method method30 = oldModelClass.getMethod("getDanTocId");

				Long value30 = (Long)method30.invoke(oldModel, (Object[])null);

				newModel.setDanTocId(value30);

				Method method31 = oldModelClass.getMethod(
						"getDiaChiHienNayHuyenId");

				Long value31 = (Long)method31.invoke(oldModel, (Object[])null);

				newModel.setDiaChiHienNayHuyenId(value31);

				Method method32 = oldModelClass.getMethod(
						"getDiaChiHienNayTinhId");

				Long value32 = (Long)method32.invoke(oldModel, (Object[])null);

				newModel.setDiaChiHienNayTinhId(value32);

				Method method33 = oldModelClass.getMethod(
						"getDiaChiHienNayXaId");

				Long value33 = (Long)method33.invoke(oldModel, (Object[])null);

				newModel.setDiaChiHienNayXaId(value33);

				Method method34 = oldModelClass.getMethod(
						"getDiaChiThuongTruHuyenId");

				Long value34 = (Long)method34.invoke(oldModel, (Object[])null);

				newModel.setDiaChiThuongTruHuyenId(value34);

				Method method35 = oldModelClass.getMethod(
						"getDiaChiThuongTruTinhId");

				Long value35 = (Long)method35.invoke(oldModel, (Object[])null);

				newModel.setDiaChiThuongTruTinhId(value35);

				Method method36 = oldModelClass.getMethod(
						"getDiaChiThuongTruXaId");

				Long value36 = (Long)method36.invoke(oldModel, (Object[])null);

				newModel.setDiaChiThuongTruXaId(value36);

				Method method37 = oldModelClass.getMethod("getGioiTinh");

				Integer value37 = (Integer)method37.invoke(oldModel,
						(Object[])null);

				newModel.setGioiTinh(value37);

				Method method38 = oldModelClass.getMethod("getNgheNghiepId");

				Long value38 = (Long)method38.invoke(oldModel, (Object[])null);

				newModel.setNgheNghiepId(value38);

				Method method39 = oldModelClass.getMethod("getNoiSinhHuyenId");

				Long value39 = (Long)method39.invoke(oldModel, (Object[])null);

				newModel.setNoiSinhHuyenId(value39);

				Method method40 = oldModelClass.getMethod("getNoiSinhTinhId");

				Long value40 = (Long)method40.invoke(oldModel, (Object[])null);

				newModel.setNoiSinhTinhId(value40);

				Method method41 = oldModelClass.getMethod("getNoiSinhXaId");

				Long value41 = (Long)method41.invoke(oldModel, (Object[])null);

				newModel.setNoiSinhXaId(value41);

				Method method42 = oldModelClass.getMethod("getNoiSinhChiTiet");

				String value42 = (String)method42.invoke(oldModel,
						(Object[])null);

				newModel.setNoiSinhChiTiet(value42);

				Method method43 = oldModelClass.getMethod("getNoiCapCmndId");

				Long value43 = (Long)method43.invoke(oldModel, (Object[])null);

				newModel.setNoiCapCmndId(value43);

				Method method44 = oldModelClass.getMethod("getTonGiaoId");

				Long value44 = (Long)method44.invoke(oldModel, (Object[])null);

				newModel.setTonGiaoId(value44);

				Method method45 = oldModelClass.getMethod("getSoDinhDanhMeId");

				Long value45 = (Long)method45.invoke(oldModel, (Object[])null);

				newModel.setSoDinhDanhMeId(value45);

				Method method46 = oldModelClass.getMethod("getTrinhDoHocVanId");

				Long value46 = (Long)method46.invoke(oldModel, (Object[])null);

				newModel.setTrinhDoHocVanId(value46);

				Method method47 = oldModelClass.getMethod(
						"getTaiKhoanNguoiDungId");

				Long value47 = (Long)method47.invoke(oldModel, (Object[])null);

				newModel.setTaiKhoanNguoiDungId(value47);

				Method method48 = oldModelClass.getMethod("getQuanHeChuHoId");

				Long value48 = (Long)method48.invoke(oldModel, (Object[])null);

				newModel.setQuanHeChuHoId(value48);

				Method method49 = oldModelClass.getMethod("getQuocTichId");

				Long value49 = (Long)method49.invoke(oldModel, (Object[])null);

				newModel.setQuocTichId(value49);

				Method method50 = oldModelClass.getMethod("getDoanhNghiepId");

				Long value50 = (Long)method50.invoke(oldModel, (Object[])null);

				newModel.setDoanhNghiepId(value50);

				Method method51 = oldModelClass.getMethod("getTenDayDu");

				String value51 = (String)method51.invoke(oldModel,
						(Object[])null);

				newModel.setTenDayDu(value51);

				Method method52 = oldModelClass.getMethod("getNgayTao");

				Date value52 = (Date)method52.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value52);

				Method method53 = oldModelClass.getMethod("getNgaySua");

				Date value53 = (Date)method53.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value53);

				Method method54 = oldModelClass.getMethod("getNguoiTao");

				String value54 = (String)method54.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value54);

				Method method55 = oldModelClass.getMethod("getNguoiSua");

				String value55 = (String)method55.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value55);

				Method method56 = oldModelClass.getMethod("getDaXoa");

				Integer value56 = (Integer)method56.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value56);

				Method method57 = oldModelClass.getMethod("getFax");

				String value57 = (String)method57.invoke(oldModel,
						(Object[])null);

				newModel.setFax(value57);

				Method method58 = oldModelClass.getMethod("getWebsite");

				String value58 = (String)method58.invoke(oldModel,
						(Object[])null);

				newModel.setWebsite(value58);

				Method method59 = oldModelClass.getMethod("getTinhtrang");

				Integer value59 = (Integer)method59.invoke(oldModel,
						(Object[])null);

				newModel.setTinhtrang(value59);

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

	public static Object translateOutputDanToc(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DanTocClp newModel = new DanTocClp();

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

				Method method3 = oldModelClass.getMethod("getPhienBan");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setPhienBan(value3);

				Method method4 = oldModelClass.getMethod("getLaThieuSo");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setLaThieuSo(value4);

				Method method5 = oldModelClass.getMethod("getNgayTao");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value5);

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

				Method method9 = oldModelClass.getMethod("getTenKhac");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setTenKhac(value9);

				Method method10 = oldModelClass.getMethod("getNgaySua");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value10);

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

	public static Object translateOutputGioiTinh(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				GioiTinhClp newModel = new GioiTinhClp();

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

				Method method3 = oldModelClass.getMethod("getNgayTao");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value3);

				Method method4 = oldModelClass.getMethod("getNguoiTao");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value4);

				Method method5 = oldModelClass.getMethod("getNgaySua");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value5);

				Method method6 = oldModelClass.getMethod("getNguoiSua");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value6);

				Method method7 = oldModelClass.getMethod("getDaXoa");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value7);

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

	public static Object translateOutputHeThong(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HeThongClp newModel = new HeThongClp();

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

				Method method3 = oldModelClass.getMethod("getMoTa");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setMoTa(value3);

				Method method4 = oldModelClass.getMethod("getNgayTao");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value4);

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

				Method method8 = oldModelClass.getMethod("getNgaySua");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value8);

				Method method9 = oldModelClass.getMethod("getTrangThai");

				Integer value9 = (Integer)method9.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value9);

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

	public static Object translateOutputHoChieuCMND(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HoChieuCMNDClp newModel = new HoChieuCMNDClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getSo");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setSo(value1);

				Method method2 = oldModelClass.getMethod("getNgayCap");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setNgayCap(value2);

				Method method3 = oldModelClass.getMethod("getNgayHetHan");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgayHetHan(value3);

				Method method4 = oldModelClass.getMethod("getNoiCapId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setNoiCapId(value4);

				Method method5 = oldModelClass.getMethod("getNoiCap");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNoiCap(value5);

				Method method6 = oldModelClass.getMethod("getGiChu");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setGiChu(value6);

				Method method7 = oldModelClass.getMethod("getLoai");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setLoai(value7);

				Method method8 = oldModelClass.getMethod("getTrangThai");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value8);

				Method method9 = oldModelClass.getMethod("getNguoiTao");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value9);

				Method method10 = oldModelClass.getMethod("getNgayTao");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value10);

				Method method11 = oldModelClass.getMethod("getNguoiSua");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value11);

				Method method12 = oldModelClass.getMethod("getNgaySua");

				Date value12 = (Date)method12.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value12);

				Method method13 = oldModelClass.getMethod("getCongDanID");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setCongDanID(value13);

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

	public static Object translateOutputNgheNghiep(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				NgheNghiepClp newModel = new NgheNghiepClp();

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

				Method method4 = oldModelClass.getMethod("getDaXoa");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value4);

				Method method5 = oldModelClass.getMethod("getNguoiTao");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value5);

				Method method6 = oldModelClass.getMethod("getNguoiSua");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value6);

				Method method7 = oldModelClass.getMethod("getNgaySua");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value7);

				Method method8 = oldModelClass.getMethod("getPhienBan");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

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

	public static Object translateOutputQuanHeGiaDinh(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				QuanHeGiaDinhClp newModel = new QuanHeGiaDinhClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTen");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTen(value1);

				Method method2 = oldModelClass.getMethod("getNgayTao");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value2);

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

				Method method6 = oldModelClass.getMethod("getNgaySua");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value6);

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

	public static Object translateOutputTinhTrangHonNhan(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TinhTrangHonNhanClp newModel = new TinhTrangHonNhanClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTen");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTen(value1);

				Method method2 = oldModelClass.getMethod("getNgayTao");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value2);

				Method method3 = oldModelClass.getMethod("getNgaySua");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value3);

				Method method4 = oldModelClass.getMethod("getNguoiTao");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value4);

				Method method5 = oldModelClass.getMethod("getDaXoa");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value5);

				Method method6 = oldModelClass.getMethod("getNguoiSua");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value6);

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

	public static Object translateOutputTonGiao(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TonGiaoClp newModel = new TonGiaoClp();

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

				Method method4 = oldModelClass.getMethod("getDaXoa");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value4);

				Method method5 = oldModelClass.getMethod("getNguoiTao");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value5);

				Method method6 = oldModelClass.getMethod("getNguoiSua");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value6);

				Method method7 = oldModelClass.getMethod("getNgaySua");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value7);

				Method method8 = oldModelClass.getMethod("getPhienBan");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

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

	public static Object translateOutputTrinhDoChuyenMon(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TrinhDoChuyenMonClp newModel = new TrinhDoChuyenMonClp();

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

				Method method4 = oldModelClass.getMethod("getDaXoa");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value4);

				Method method5 = oldModelClass.getMethod("getChuyenMonId");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setChuyenMonId(value5);

				Method method6 = oldModelClass.getMethod("getNguoiTao");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value6);

				Method method7 = oldModelClass.getMethod("getNguoiSua");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value7);

				Method method8 = oldModelClass.getMethod("getNgaySua");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value8);

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

	public static Object translateOutputTrinhDoHocVan(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TrinhDoHocVanClp newModel = new TrinhDoHocVanClp();

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

				Method method4 = oldModelClass.getMethod("getDaXoa");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value4);

				Method method5 = oldModelClass.getMethod("getNguoiTao");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setNguoiTao(value5);

				Method method6 = oldModelClass.getMethod("getNguoiSua");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setNguoiSua(value6);

				Method method7 = oldModelClass.getMethod("getNgaySua");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value7);

				Method method8 = oldModelClass.getMethod("getPhienBan");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

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