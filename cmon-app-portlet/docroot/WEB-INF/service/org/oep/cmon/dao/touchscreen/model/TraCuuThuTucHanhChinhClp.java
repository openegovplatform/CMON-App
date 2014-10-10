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

package org.oep.cmon.dao.touchscreen.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.touchscreen.service.TraCuuThuTucHanhChinhLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author VIENPN
 */
public class TraCuuThuTucHanhChinhClp extends BaseModelImpl<TraCuuThuTucHanhChinh>
	implements TraCuuThuTucHanhChinh {
	public TraCuuThuTucHanhChinhClp() {
	}

	public Class<?> getModelClass() {
		return TraCuuThuTucHanhChinh.class;
	}

	public String getModelClassName() {
		return TraCuuThuTucHanhChinh.class.getName();
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

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public long getSoNgayXuLy() {
		return _soNgayXuLy;
	}

	public void setSoNgayXuLy(long soNgayXuLy) {
		_soNgayXuLy = soNgayXuLy;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
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

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public long getNhomThuTucHanhChinhId() {
		return _nhomThuTucHanhChinhId;
	}

	public void setNhomThuTucHanhChinhId(long nhomThuTucHanhChinhId) {
		_nhomThuTucHanhChinhId = nhomThuTucHanhChinhId;
	}

	public String getNhomThuTucHanhChinhTen() {
		return _nhomThuTucHanhChinhTen;
	}

	public void setNhomThuTucHanhChinhTen(String nhomThuTucHanhChinhTen) {
		_nhomThuTucHanhChinhTen = nhomThuTucHanhChinhTen;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public int getCanTichHop() {
		return _canTichHop;
	}

	public void setCanTichHop(int canTichHop) {
		_canTichHop = canTichHop;
	}

	public String getTrinhTuThucHien() {
		return _trinhTuThucHien;
	}

	public void setTrinhTuThucHien(String trinhTuThucHien) {
		_trinhTuThucHien = trinhTuThucHien;
	}

	public String getCachThucHien() {
		return _cachThucHien;
	}

	public void setCachThucHien(String cachThucHien) {
		_cachThucHien = cachThucHien;
	}

	public String getThanhPhanHoSo() {
		return _thanhPhanHoSo;
	}

	public void setThanhPhanHoSo(String thanhPhanHoSo) {
		_thanhPhanHoSo = thanhPhanHoSo;
	}

	public long getLePhi() {
		return _lePhi;
	}

	public void setLePhi(long lePhi) {
		_lePhi = lePhi;
	}

	public String getDonViLePhi() {
		return _donViLePhi;
	}

	public void setDonViLePhi(String donViLePhi) {
		_donViLePhi = donViLePhi;
	}

	public long getPhi() {
		return _phi;
	}

	public void setPhi(long phi) {
		_phi = phi;
	}

	public String getDonViPhi() {
		return _donViPhi;
	}

	public void setDonViPhi(String donViPhi) {
		_donViPhi = donViPhi;
	}

	public String getTenMauDonToKhai() {
		return _tenMauDonToKhai;
	}

	public void setTenMauDonToKhai(String tenMauDonToKhai) {
		_tenMauDonToKhai = tenMauDonToKhai;
	}

	public String getYeuCauDieuKienThucHien() {
		return _yeuCauDieuKienThucHien;
	}

	public void setYeuCauDieuKienThucHien(String yeuCauDieuKienThucHien) {
		_yeuCauDieuKienThucHien = yeuCauDieuKienThucHien;
	}

	public String getCanCuPhapLy() {
		return _canCuPhapLy;
	}

	public void setCanCuPhapLy(String canCuPhapLy) {
		_canCuPhapLy = canCuPhapLy;
	}

	public Long getCapCoQuanQuanLyId() {
		return _capCoQuanQuanLyId;
	}

	public void setCapCoQuanQuanLyId(Long capCoQuanQuanLyId) {
		_capCoQuanQuanLyId = capCoQuanQuanLyId;
	}

	public String getLinhVucThucHien() {
		return _linhVucThucHien;
	}

	public void setLinhVucThucHien(String linhVucThucHien) {
		_linhVucThucHien = linhVucThucHien;
	}

	public String getMaDNG() {
		return _maDNG;
	}

	public void setMaDNG(String maDNG) {
		_maDNG = maDNG;
	}

	public String getUengineProcessName() {
		return _uengineProcessName;
	}

	public void setUengineProcessName(String uengineProcessName) {
		_uengineProcessName = uengineProcessName;
	}

	public Long getThuTucLienThongId() {
		return _thuTucLienThongId;
	}

	public void setThuTucLienThongId(Long thuTucLienThongId) {
		_thuTucLienThongId = thuTucLienThongId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TraCuuThuTucHanhChinhLocalServiceUtil.addTraCuuThuTucHanhChinh(this);
		}
		else {
			TraCuuThuTucHanhChinhLocalServiceUtil.updateTraCuuThuTucHanhChinh(this);
		}
	}

	@Override
	public TraCuuThuTucHanhChinh toEscapedModel() {
		return (TraCuuThuTucHanhChinh)Proxy.newProxyInstance(TraCuuThuTucHanhChinh.class.getClassLoader(),
			new Class[] { TraCuuThuTucHanhChinh.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TraCuuThuTucHanhChinhClp clone = new TraCuuThuTucHanhChinhClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setSoNgayXuLy(getSoNgayXuLy());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setNhomThuTucHanhChinhId(getNhomThuTucHanhChinhId());
		clone.setNhomThuTucHanhChinhTen(getNhomThuTucHanhChinhTen());
		clone.setTrangThai(getTrangThai());
		clone.setPhienBan(getPhienBan());
		clone.setCanTichHop(getCanTichHop());
		clone.setTrinhTuThucHien(getTrinhTuThucHien());
		clone.setCachThucHien(getCachThucHien());
		clone.setThanhPhanHoSo(getThanhPhanHoSo());
		clone.setLePhi(getLePhi());
		clone.setDonViLePhi(getDonViLePhi());
		clone.setPhi(getPhi());
		clone.setDonViPhi(getDonViPhi());
		clone.setTenMauDonToKhai(getTenMauDonToKhai());
		clone.setYeuCauDieuKienThucHien(getYeuCauDieuKienThucHien());
		clone.setCanCuPhapLy(getCanCuPhapLy());
		clone.setCapCoQuanQuanLyId(getCapCoQuanQuanLyId());
		clone.setLinhVucThucHien(getLinhVucThucHien());
		clone.setMaDNG(getMaDNG());
		clone.setUengineProcessName(getUengineProcessName());
		clone.setThuTucLienThongId(getThuTucLienThongId());

		return clone;
	}

	public int compareTo(TraCuuThuTucHanhChinh traCuuThuTucHanhChinh) {
		long primaryKey = traCuuThuTucHanhChinh.getPrimaryKey();

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

		TraCuuThuTucHanhChinhClp traCuuThuTucHanhChinh = null;

		try {
			traCuuThuTucHanhChinh = (TraCuuThuTucHanhChinhClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = traCuuThuTucHanhChinh.getPrimaryKey();

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
		StringBundler sb = new StringBundler(59);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", soNgayXuLy=");
		sb.append(getSoNgayXuLy());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", nhomThuTucHanhChinhId=");
		sb.append(getNhomThuTucHanhChinhId());
		sb.append(", nhomThuTucHanhChinhTen=");
		sb.append(getNhomThuTucHanhChinhTen());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", phienBan=");
		sb.append(getPhienBan());
		sb.append(", canTichHop=");
		sb.append(getCanTichHop());
		sb.append(", trinhTuThucHien=");
		sb.append(getTrinhTuThucHien());
		sb.append(", cachThucHien=");
		sb.append(getCachThucHien());
		sb.append(", thanhPhanHoSo=");
		sb.append(getThanhPhanHoSo());
		sb.append(", lePhi=");
		sb.append(getLePhi());
		sb.append(", donViLePhi=");
		sb.append(getDonViLePhi());
		sb.append(", phi=");
		sb.append(getPhi());
		sb.append(", donViPhi=");
		sb.append(getDonViPhi());
		sb.append(", tenMauDonToKhai=");
		sb.append(getTenMauDonToKhai());
		sb.append(", yeuCauDieuKienThucHien=");
		sb.append(getYeuCauDieuKienThucHien());
		sb.append(", canCuPhapLy=");
		sb.append(getCanCuPhapLy());
		sb.append(", capCoQuanQuanLyId=");
		sb.append(getCapCoQuanQuanLyId());
		sb.append(", linhVucThucHien=");
		sb.append(getLinhVucThucHien());
		sb.append(", maDNG=");
		sb.append(getMaDNG());
		sb.append(", uengineProcessName=");
		sb.append(getUengineProcessName());
		sb.append(", thuTucLienThongId=");
		sb.append(getThuTucLienThongId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(91);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ma</column-name><column-value><![CDATA[");
		sb.append(getMa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNgayXuLy</column-name><column-value><![CDATA[");
		sb.append(getSoNgayXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nhomThuTucHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getNhomThuTucHanhChinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nhomThuTucHanhChinhTen</column-name><column-value><![CDATA[");
		sb.append(getNhomThuTucHanhChinhTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phienBan</column-name><column-value><![CDATA[");
		sb.append(getPhienBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canTichHop</column-name><column-value><![CDATA[");
		sb.append(getCanTichHop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trinhTuThucHien</column-name><column-value><![CDATA[");
		sb.append(getTrinhTuThucHien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cachThucHien</column-name><column-value><![CDATA[");
		sb.append(getCachThucHien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thanhPhanHoSo</column-name><column-value><![CDATA[");
		sb.append(getThanhPhanHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lePhi</column-name><column-value><![CDATA[");
		sb.append(getLePhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>donViLePhi</column-name><column-value><![CDATA[");
		sb.append(getDonViLePhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phi</column-name><column-value><![CDATA[");
		sb.append(getPhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>donViPhi</column-name><column-value><![CDATA[");
		sb.append(getDonViPhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenMauDonToKhai</column-name><column-value><![CDATA[");
		sb.append(getTenMauDonToKhai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yeuCauDieuKienThucHien</column-name><column-value><![CDATA[");
		sb.append(getYeuCauDieuKienThucHien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canCuPhapLy</column-name><column-value><![CDATA[");
		sb.append(getCanCuPhapLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capCoQuanQuanLyId</column-name><column-value><![CDATA[");
		sb.append(getCapCoQuanQuanLyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linhVucThucHien</column-name><column-value><![CDATA[");
		sb.append(getLinhVucThucHien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maDNG</column-name><column-value><![CDATA[");
		sb.append(getMaDNG());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uengineProcessName</column-name><column-value><![CDATA[");
		sb.append(getUengineProcessName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTucLienThongId</column-name><column-value><![CDATA[");
		sb.append(getThuTucLienThongId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ma;
	private String _ten;
	private long _soNgayXuLy;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _nhomThuTucHanhChinhId;
	private String _nhomThuTucHanhChinhTen;
	private int _trangThai;
	private long _phienBan;
	private int _canTichHop;
	private String _trinhTuThucHien;
	private String _cachThucHien;
	private String _thanhPhanHoSo;
	private long _lePhi;
	private String _donViLePhi;
	private long _phi;
	private String _donViPhi;
	private String _tenMauDonToKhai;
	private String _yeuCauDieuKienThucHien;
	private String _canCuPhapLy;
	private Long _capCoQuanQuanLyId;
	private String _linhVucThucHien;
	private String _maDNG;
	private String _uengineProcessName;
	private Long _thuTucLienThongId;
}