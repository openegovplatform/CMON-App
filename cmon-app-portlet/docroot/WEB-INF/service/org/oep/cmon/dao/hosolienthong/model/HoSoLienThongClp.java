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

package org.oep.cmon.dao.hosolienthong.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author hoangtrung.nguyen
 */
public class HoSoLienThongClp extends BaseModelImpl<HoSoLienThong>
	implements HoSoLienThong {
	public HoSoLienThongClp() {
	}

	public Class<?> getModelClass() {
		return HoSoLienThong.class;
	}

	public String getModelClassName() {
		return HoSoLienThong.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getHoSoId() {
		return _hoSoId;
	}

	public void setHoSoId(long hoSoId) {
		_hoSoId = hoSoId;
	}

	public long getCoQuanGuiId() {
		return _coQuanGuiId;
	}

	public void setCoQuanGuiId(long coQuanGuiId) {
		_coQuanGuiId = coQuanGuiId;
	}

	public long getCoQuanNhanId() {
		return _coQuanNhanId;
	}

	public void setCoQuanNhanId(long coQuanNhanId) {
		_coQuanNhanId = coQuanNhanId;
	}

	public long getThuTucGuiId() {
		return _thuTucGuiId;
	}

	public void setThuTucGuiId(long thuTucGuiId) {
		_thuTucGuiId = thuTucGuiId;
	}

	public long getThuTucNhanId() {
		return _thuTucNhanId;
	}

	public void setThuTucNhanId(long thuTucNhanId) {
		_thuTucNhanId = thuTucNhanId;
	}

	public String getMaSoBienNhanLucGui() {
		return _maSoBienNhanLucGui;
	}

	public void setMaSoBienNhanLucGui(String maSoBienNhanLucGui) {
		_maSoBienNhanLucGui = maSoBienNhanLucGui;
	}

	public String getMaSoBienNhanLucNhan() {
		return _maSoBienNhanLucNhan;
	}

	public void setMaSoBienNhanLucNhan(String maSoBienNhanLucNhan) {
		_maSoBienNhanLucNhan = maSoBienNhanLucNhan;
	}

	public long getCanBoGuiId() {
		return _canBoGuiId;
	}

	public void setCanBoGuiId(long canBoGuiId) {
		_canBoGuiId = canBoGuiId;
	}

	public Long getCanBoNhanId() {
		return _canBoNhanId;
	}

	public void setCanBoNhanId(Long canBoNhanId) {
		_canBoNhanId = canBoNhanId;
	}

	public Date getNgayGui() {
		return _ngayGui;
	}

	public void setNgayGui(Date ngayGui) {
		_ngayGui = ngayGui;
	}

	public Date getNgayNhan() {
		return _ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		_ngayNhan = ngayNhan;
	}

	public String getHoTenCanBoGui() {
		return _hoTenCanBoGui;
	}

	public void setHoTenCanBoGui(String hoTenCanBoGui) {
		_hoTenCanBoGui = hoTenCanBoGui;
	}

	public String getHoTenCanBoNhan() {
		return _hoTenCanBoNhan;
	}

	public void setHoTenCanBoNhan(String hoTenCanBoNhan) {
		_hoTenCanBoNhan = hoTenCanBoNhan;
	}

	public Long getCanBoNopHoSoGiayId() {
		return _canBoNopHoSoGiayId;
	}

	public void setCanBoNopHoSoGiayId(Long canBoNopHoSoGiayId) {
		_canBoNopHoSoGiayId = canBoNopHoSoGiayId;
	}

	public String getHoTenCanBoNopHoSoGiay() {
		return _hoTenCanBoNopHoSoGiay;
	}

	public void setHoTenCanBoNopHoSoGiay(String hoTenCanBoNopHoSoGiay) {
		_hoTenCanBoNopHoSoGiay = hoTenCanBoNopHoSoGiay;
	}

	public int getTrangThaiLienThong() {
		return _trangThaiLienThong;
	}

	public void setTrangThaiLienThong(int trangThaiLienThong) {
		_trangThaiLienThong = trangThaiLienThong;
	}

	public String getGhiChuGuiLienThong() {
		return _ghiChuGuiLienThong;
	}

	public void setGhiChuGuiLienThong(String ghiChuGuiLienThong) {
		_ghiChuGuiLienThong = ghiChuGuiLienThong;
	}

	public String getHoTenCongDanNop() {
		return _hoTenCongDanNop;
	}

	public void setHoTenCongDanNop(String hoTenCongDanNop) {
		_hoTenCongDanNop = hoTenCongDanNop;
	}

	public String getDiaChiDayDuCongDanNop() {
		return _diaChiDayDuCongDanNop;
	}

	public void setDiaChiDayDuCongDanNop(String diaChiDayDuCongDanNop) {
		_diaChiDayDuCongDanNop = diaChiDayDuCongDanNop;
	}

	public Date getNgayTuChoi() {
		return _ngayTuChoi;
	}

	public void setNgayTuChoi(Date ngayTuChoi) {
		_ngayTuChoi = ngayTuChoi;
	}

	public Date getNgayNoiNhanTraKetQua() {
		return _ngayNoiNhanTraKetQua;
	}

	public void setNgayNoiNhanTraKetQua(Date ngayNoiNhanTraKetQua) {
		_ngayNoiNhanTraKetQua = ngayNoiNhanTraKetQua;
	}

	public Date getNgayNoiGuiNhanKetQua() {
		return _ngayNoiGuiNhanKetQua;
	}

	public void setNgayNoiGuiNhanKetQua(Date ngayNoiGuiNhanKetQua) {
		_ngayNoiGuiNhanKetQua = ngayNoiGuiNhanKetQua;
	}

	public long getCanBoTiepNhanNoiGuiId() {
		return _canBoTiepNhanNoiGuiId;
	}

	public void setCanBoTiepNhanNoiGuiId(long canBoTiepNhanNoiGuiId) {
		_canBoTiepNhanNoiGuiId = canBoTiepNhanNoiGuiId;
	}

	public String getHoTenCanBoTiepNhanNoiGui() {
		return _hoTenCanBoTiepNhanNoiGui;
	}

	public void setHoTenCanBoTiepNhanNoiGui(String hoTenCanBoTiepNhanNoiGui) {
		_hoTenCanBoTiepNhanNoiGui = hoTenCanBoTiepNhanNoiGui;
	}

	public String getTenCoQuanGui() {
		return _tenCoQuanGui;
	}

	public void setTenCoQuanGui(String tenCoQuanGui) {
		_tenCoQuanGui = tenCoQuanGui;
	}

	public String getTenThuTucGui() {
		return _tenThuTucGui;
	}

	public void setTenThuTucGui(String tenThuTucGui) {
		_tenThuTucGui = tenThuTucGui;
	}

	public String getTenCoQuanNhan() {
		return _tenCoQuanNhan;
	}

	public void setTenCoQuanNhan(String tenCoQuanNhan) {
		_tenCoQuanNhan = tenCoQuanNhan;
	}

	public String getTenThuTucNhan() {
		return _tenThuTucNhan;
	}

	public void setTenThuTucNhan(String tenThuTucNhan) {
		_tenThuTucNhan = tenThuTucNhan;
	}

	public int getThuTuLienThong() {
		return _thuTuLienThong;
	}

	public void setThuTuLienThong(int thuTuLienThong) {
		_thuTuLienThong = thuTuLienThong;
	}

	public Date getNgayNoiNhanHenTra() {
		return _ngayNoiNhanHenTra;
	}

	public void setNgayNoiNhanHenTra(Date ngayNoiNhanHenTra) {
		_ngayNoiNhanHenTra = ngayNoiNhanHenTra;
	}

	public int getSoNgayNoiNhanXuLyDuKien() {
		return _soNgayNoiNhanXuLyDuKien;
	}

	public void setSoNgayNoiNhanXuLyDuKien(int soNgayNoiNhanXuLyDuKien) {
		_soNgayNoiNhanXuLyDuKien = soNgayNoiNhanXuLyDuKien;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			HoSoLienThongLocalServiceUtil.addHoSoLienThong(this);
		}
		else {
			HoSoLienThongLocalServiceUtil.updateHoSoLienThong(this);
		}
	}

	@Override
	public HoSoLienThong toEscapedModel() {
		return (HoSoLienThong)Proxy.newProxyInstance(HoSoLienThong.class.getClassLoader(),
			new Class[] { HoSoLienThong.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HoSoLienThongClp clone = new HoSoLienThongClp();

		clone.setId(getId());
		clone.setHoSoId(getHoSoId());
		clone.setCoQuanGuiId(getCoQuanGuiId());
		clone.setCoQuanNhanId(getCoQuanNhanId());
		clone.setThuTucGuiId(getThuTucGuiId());
		clone.setThuTucNhanId(getThuTucNhanId());
		clone.setMaSoBienNhanLucGui(getMaSoBienNhanLucGui());
		clone.setMaSoBienNhanLucNhan(getMaSoBienNhanLucNhan());
		clone.setCanBoGuiId(getCanBoGuiId());
		clone.setCanBoNhanId(getCanBoNhanId());
		clone.setNgayGui(getNgayGui());
		clone.setNgayNhan(getNgayNhan());
		clone.setHoTenCanBoGui(getHoTenCanBoGui());
		clone.setHoTenCanBoNhan(getHoTenCanBoNhan());
		clone.setCanBoNopHoSoGiayId(getCanBoNopHoSoGiayId());
		clone.setHoTenCanBoNopHoSoGiay(getHoTenCanBoNopHoSoGiay());
		clone.setTrangThaiLienThong(getTrangThaiLienThong());
		clone.setGhiChuGuiLienThong(getGhiChuGuiLienThong());
		clone.setHoTenCongDanNop(getHoTenCongDanNop());
		clone.setDiaChiDayDuCongDanNop(getDiaChiDayDuCongDanNop());
		clone.setNgayTuChoi(getNgayTuChoi());
		clone.setNgayNoiNhanTraKetQua(getNgayNoiNhanTraKetQua());
		clone.setNgayNoiGuiNhanKetQua(getNgayNoiGuiNhanKetQua());
		clone.setCanBoTiepNhanNoiGuiId(getCanBoTiepNhanNoiGuiId());
		clone.setHoTenCanBoTiepNhanNoiGui(getHoTenCanBoTiepNhanNoiGui());
		clone.setTenCoQuanGui(getTenCoQuanGui());
		clone.setTenThuTucGui(getTenThuTucGui());
		clone.setTenCoQuanNhan(getTenCoQuanNhan());
		clone.setTenThuTucNhan(getTenThuTucNhan());
		clone.setThuTuLienThong(getThuTuLienThong());
		clone.setNgayNoiNhanHenTra(getNgayNoiNhanHenTra());
		clone.setSoNgayNoiNhanXuLyDuKien(getSoNgayNoiNhanXuLyDuKien());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());

		return clone;
	}

	public int compareTo(HoSoLienThong hoSoLienThong) {
		long primaryKey = hoSoLienThong.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HoSoLienThongClp hoSoLienThong = null;

		try {
			hoSoLienThong = (HoSoLienThongClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hoSoLienThong.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", hoSoId=");
		sb.append(getHoSoId());
		sb.append(", coQuanGuiId=");
		sb.append(getCoQuanGuiId());
		sb.append(", coQuanNhanId=");
		sb.append(getCoQuanNhanId());
		sb.append(", thuTucGuiId=");
		sb.append(getThuTucGuiId());
		sb.append(", thuTucNhanId=");
		sb.append(getThuTucNhanId());
		sb.append(", maSoBienNhanLucGui=");
		sb.append(getMaSoBienNhanLucGui());
		sb.append(", maSoBienNhanLucNhan=");
		sb.append(getMaSoBienNhanLucNhan());
		sb.append(", canBoGuiId=");
		sb.append(getCanBoGuiId());
		sb.append(", canBoNhanId=");
		sb.append(getCanBoNhanId());
		sb.append(", ngayGui=");
		sb.append(getNgayGui());
		sb.append(", ngayNhan=");
		sb.append(getNgayNhan());
		sb.append(", hoTenCanBoGui=");
		sb.append(getHoTenCanBoGui());
		sb.append(", hoTenCanBoNhan=");
		sb.append(getHoTenCanBoNhan());
		sb.append(", canBoNopHoSoGiayId=");
		sb.append(getCanBoNopHoSoGiayId());
		sb.append(", hoTenCanBoNopHoSoGiay=");
		sb.append(getHoTenCanBoNopHoSoGiay());
		sb.append(", trangThaiLienThong=");
		sb.append(getTrangThaiLienThong());
		sb.append(", ghiChuGuiLienThong=");
		sb.append(getGhiChuGuiLienThong());
		sb.append(", hoTenCongDanNop=");
		sb.append(getHoTenCongDanNop());
		sb.append(", diaChiDayDuCongDanNop=");
		sb.append(getDiaChiDayDuCongDanNop());
		sb.append(", ngayTuChoi=");
		sb.append(getNgayTuChoi());
		sb.append(", ngayNoiNhanTraKetQua=");
		sb.append(getNgayNoiNhanTraKetQua());
		sb.append(", ngayNoiGuiNhanKetQua=");
		sb.append(getNgayNoiGuiNhanKetQua());
		sb.append(", canBoTiepNhanNoiGuiId=");
		sb.append(getCanBoTiepNhanNoiGuiId());
		sb.append(", hoTenCanBoTiepNhanNoiGui=");
		sb.append(getHoTenCanBoTiepNhanNoiGui());
		sb.append(", tenCoQuanGui=");
		sb.append(getTenCoQuanGui());
		sb.append(", tenThuTucGui=");
		sb.append(getTenThuTucGui());
		sb.append(", tenCoQuanNhan=");
		sb.append(getTenCoQuanNhan());
		sb.append(", tenThuTucNhan=");
		sb.append(getTenThuTucNhan());
		sb.append(", thuTuLienThong=");
		sb.append(getThuTuLienThong());
		sb.append(", ngayNoiNhanHenTra=");
		sb.append(getNgayNoiNhanHenTra());
		sb.append(", soNgayNoiNhanXuLyDuKien=");
		sb.append(getSoNgayNoiNhanXuLyDuKien());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(115);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.hosolienthong.model.HoSoLienThong");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoSoId</column-name><column-value><![CDATA[");
		sb.append(getHoSoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanGuiId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanGuiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanNhanId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTucGuiId</column-name><column-value><![CDATA[");
		sb.append(getThuTucGuiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTucNhanId</column-name><column-value><![CDATA[");
		sb.append(getThuTucNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoBienNhanLucGui</column-name><column-value><![CDATA[");
		sb.append(getMaSoBienNhanLucGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoBienNhanLucNhan</column-name><column-value><![CDATA[");
		sb.append(getMaSoBienNhanLucNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoGuiId</column-name><column-value><![CDATA[");
		sb.append(getCanBoGuiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoNhanId</column-name><column-value><![CDATA[");
		sb.append(getCanBoNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayGui</column-name><column-value><![CDATA[");
		sb.append(getNgayGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNhan</column-name><column-value><![CDATA[");
		sb.append(getNgayNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCanBoGui</column-name><column-value><![CDATA[");
		sb.append(getHoTenCanBoGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCanBoNhan</column-name><column-value><![CDATA[");
		sb.append(getHoTenCanBoNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoNopHoSoGiayId</column-name><column-value><![CDATA[");
		sb.append(getCanBoNopHoSoGiayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCanBoNopHoSoGiay</column-name><column-value><![CDATA[");
		sb.append(getHoTenCanBoNopHoSoGiay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiLienThong</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiLienThong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChuGuiLienThong</column-name><column-value><![CDATA[");
		sb.append(getGhiChuGuiLienThong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCongDanNop</column-name><column-value><![CDATA[");
		sb.append(getHoTenCongDanNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiDayDuCongDanNop</column-name><column-value><![CDATA[");
		sb.append(getDiaChiDayDuCongDanNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTuChoi</column-name><column-value><![CDATA[");
		sb.append(getNgayTuChoi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNoiNhanTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayNoiNhanTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNoiGuiNhanKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayNoiGuiNhanKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoTiepNhanNoiGuiId</column-name><column-value><![CDATA[");
		sb.append(getCanBoTiepNhanNoiGuiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCanBoTiepNhanNoiGui</column-name><column-value><![CDATA[");
		sb.append(getHoTenCanBoTiepNhanNoiGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCoQuanGui</column-name><column-value><![CDATA[");
		sb.append(getTenCoQuanGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenThuTucGui</column-name><column-value><![CDATA[");
		sb.append(getTenThuTucGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCoQuanNhan</column-name><column-value><![CDATA[");
		sb.append(getTenCoQuanNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenThuTucNhan</column-name><column-value><![CDATA[");
		sb.append(getTenThuTucNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTuLienThong</column-name><column-value><![CDATA[");
		sb.append(getThuTuLienThong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNoiNhanHenTra</column-name><column-value><![CDATA[");
		sb.append(getNgayNoiNhanHenTra());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNgayNoiNhanXuLyDuKien</column-name><column-value><![CDATA[");
		sb.append(getSoNgayNoiNhanXuLyDuKien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _hoSoId;
	private long _coQuanGuiId;
	private long _coQuanNhanId;
	private long _thuTucGuiId;
	private long _thuTucNhanId;
	private String _maSoBienNhanLucGui;
	private String _maSoBienNhanLucNhan;
	private long _canBoGuiId;
	private Long _canBoNhanId;
	private Date _ngayGui;
	private Date _ngayNhan;
	private String _hoTenCanBoGui;
	private String _hoTenCanBoNhan;
	private Long _canBoNopHoSoGiayId;
	private String _hoTenCanBoNopHoSoGiay;
	private int _trangThaiLienThong;
	private String _ghiChuGuiLienThong;
	private String _hoTenCongDanNop;
	private String _diaChiDayDuCongDanNop;
	private Date _ngayTuChoi;
	private Date _ngayNoiNhanTraKetQua;
	private Date _ngayNoiGuiNhanKetQua;
	private long _canBoTiepNhanNoiGuiId;
	private String _hoTenCanBoTiepNhanNoiGui;
	private String _tenCoQuanGui;
	private String _tenThuTucGui;
	private String _tenCoQuanNhan;
	private String _tenThuTucNhan;
	private int _thuTuLienThong;
	private Date _ngayNoiNhanHenTra;
	private int _soNgayNoiNhanXuLyDuKien;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private int _daXoa;
}