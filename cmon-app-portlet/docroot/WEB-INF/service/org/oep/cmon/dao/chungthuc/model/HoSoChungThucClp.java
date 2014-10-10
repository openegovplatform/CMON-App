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

package org.oep.cmon.dao.chungthuc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author vietho
 */
public class HoSoChungThucClp extends BaseModelImpl<HoSoChungThuc>
	implements HoSoChungThuc {
	public HoSoChungThucClp() {
	}

	public Class<?> getModelClass() {
		return HoSoChungThuc.class;
	}

	public String getModelClassName() {
		return HoSoChungThuc.class.getName();
	}

	public long getPrimaryKey() {
		return _hoSoChungThucId;
	}

	public void setPrimaryKey(long primaryKey) {
		setHoSoChungThucId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hoSoChungThucId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getHoSoChungThucId() {
		return _hoSoChungThucId;
	}

	public void setHoSoChungThucId(long hoSoChungThucId) {
		_hoSoChungThucId = hoSoChungThucId;
	}

	public String getTenChungThuc() {
		return _tenChungThuc;
	}

	public void setTenChungThuc(String tenChungThuc) {
		_tenChungThuc = tenChungThuc;
	}

	public String getSoChungThuc() {
		return _soChungThuc;
	}

	public void setSoChungThuc(String soChungThuc) {
		_soChungThuc = soChungThuc;
	}

	public Date getNgayNopHoSo() {
		return _ngayNopHoSo;
	}

	public void setNgayNopHoSo(Date ngayNopHoSo) {
		_ngayNopHoSo = ngayNopHoSo;
	}

	public Date getNgayTraKetQua() {
		return _ngayTraKetQua;
	}

	public void setNgayTraKetQua(Date ngayTraKetQua) {
		_ngayTraKetQua = ngayTraKetQua;
	}

	public String getHoTenNguoiNopHoSo() {
		return _hoTenNguoiNopHoSo;
	}

	public void setHoTenNguoiNopHoSo(String hoTenNguoiNopHoSo) {
		_hoTenNguoiNopHoSo = hoTenNguoiNopHoSo;
	}

	public String getDiaChiThuongTruNguoiNop() {
		return _diaChiThuongTruNguoiNop;
	}

	public void setDiaChiThuongTruNguoiNop(String diaChiThuongTruNguoiNop) {
		_diaChiThuongTruNguoiNop = diaChiThuongTruNguoiNop;
	}

	public String getSoDienThoaiCoDinhNguoiNop() {
		return _soDienThoaiCoDinhNguoiNop;
	}

	public void setSoDienThoaiCoDinhNguoiNop(String soDienThoaiCoDinhNguoiNop) {
		_soDienThoaiCoDinhNguoiNop = soDienThoaiCoDinhNguoiNop;
	}

	public int getTrangThaiHoSo() {
		return _trangThaiHoSo;
	}

	public void setTrangThaiHoSo(int trangThaiHoSo) {
		_trangThaiHoSo = trangThaiHoSo;
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

	public Long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(Long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public Long getCanBoTiepNhanId() {
		return _canBoTiepNhanId;
	}

	public void setCanBoTiepNhanId(Long canBoTiepNhanId) {
		_canBoTiepNhanId = canBoTiepNhanId;
	}

	public String getSoDienThoaiDiDongNguoiNop() {
		return _soDienThoaiDiDongNguoiNop;
	}

	public void setSoDienThoaiDiDongNguoiNop(String soDienThoaiDiDongNguoiNop) {
		_soDienThoaiDiDongNguoiNop = soDienThoaiDiDongNguoiNop;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public String getMucDichChungThuc() {
		return _mucDichChungThuc;
	}

	public void setMucDichChungThuc(String mucDichChungThuc) {
		_mucDichChungThuc = mucDichChungThuc;
	}

	public String getMaSoBienNhan() {
		return _maSoBienNhan;
	}

	public void setMaSoBienNhan(String maSoBienNhan) {
		_maSoBienNhan = maSoBienNhan;
	}

	public String getChuSoHuu() {
		return _chuSoHuu;
	}

	public void setChuSoHuu(String chuSoHuu) {
		_chuSoHuu = chuSoHuu;
	}

	public int getSoBoHoSo() {
		return _soBoHoSo;
	}

	public void setSoBoHoSo(int soBoHoSo) {
		_soBoHoSo = soBoHoSo;
	}

	public int getSoTo() {
		return _soTo;
	}

	public void setSoTo(int soTo) {
		_soTo = soTo;
	}

	public String getTruongHop() {
		return _truongHop;
	}

	public void setTruongHop(String truongHop) {
		_truongHop = truongHop;
	}

	public int getLePhi() {
		return _lePhi;
	}

	public void setLePhi(int lePhi) {
		_lePhi = lePhi;
	}

	public int getPhiHoSo() {
		return _phiHoSo;
	}

	public void setPhiHoSo(int phiHoSo) {
		_phiHoSo = phiHoSo;
	}

	public String getEmailNguoiNop() {
		return _emailNguoiNop;
	}

	public void setEmailNguoiNop(String emailNguoiNop) {
		_emailNguoiNop = emailNguoiNop;
	}

	public Date getNgaySinhNguoiNop() {
		return _ngaySinhNguoiNop;
	}

	public void setNgaySinhNguoiNop(Date ngaySinhNguoiNop) {
		_ngaySinhNguoiNop = ngaySinhNguoiNop;
	}

	public String getSoCMNDNguoiNop() {
		return _soCMNDNguoiNop;
	}

	public void setSoCMNDNguoiNop(String soCMNDNguoiNop) {
		_soCMNDNguoiNop = soCMNDNguoiNop;
	}

	public int getGioiTinhNguoiNop() {
		return _gioiTinhNguoiNop;
	}

	public void setGioiTinhNguoiNop(int gioiTinhNguoiNop) {
		_gioiTinhNguoiNop = gioiTinhNguoiNop;
	}

	public String getTenCanBoKy() {
		return _tenCanBoKy;
	}

	public void setTenCanBoKy(String tenCanBoKy) {
		_tenCanBoKy = tenCanBoKy;
	}

	public Long getChucVuCanBoKyId() {
		return _chucVuCanBoKyId;
	}

	public void setChucVuCanBoKyId(Long chucVuCanBoKyId) {
		_chucVuCanBoKyId = chucVuCanBoKyId;
	}

	public Long getSoDanhMucId() {
		return _soDanhMucId;
	}

	public void setSoDanhMucId(Long soDanhMucId) {
		_soDanhMucId = soDanhMucId;
	}

	public Long getThuongTruTinhId() {
		return _thuongTruTinhId;
	}

	public void setThuongTruTinhId(Long thuongTruTinhId) {
		_thuongTruTinhId = thuongTruTinhId;
	}

	public Long getThuongTruHuyenId() {
		return _thuongTruHuyenId;
	}

	public void setThuongTruHuyenId(Long thuongTruHuyenId) {
		_thuongTruHuyenId = thuongTruHuyenId;
	}

	public Long getThuongTruXaId() {
		return _thuongTruXaId;
	}

	public void setThuongTruXaId(Long thuongTruXaId) {
		_thuongTruXaId = thuongTruXaId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			HoSoChungThucLocalServiceUtil.addHoSoChungThuc(this);
		}
		else {
			HoSoChungThucLocalServiceUtil.updateHoSoChungThuc(this);
		}
	}

	@Override
	public HoSoChungThuc toEscapedModel() {
		return (HoSoChungThuc)Proxy.newProxyInstance(HoSoChungThuc.class.getClassLoader(),
			new Class[] { HoSoChungThuc.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HoSoChungThucClp clone = new HoSoChungThucClp();

		clone.setHoSoChungThucId(getHoSoChungThucId());
		clone.setTenChungThuc(getTenChungThuc());
		clone.setSoChungThuc(getSoChungThuc());
		clone.setNgayNopHoSo(getNgayNopHoSo());
		clone.setNgayTraKetQua(getNgayTraKetQua());
		clone.setHoTenNguoiNopHoSo(getHoTenNguoiNopHoSo());
		clone.setDiaChiThuongTruNguoiNop(getDiaChiThuongTruNguoiNop());
		clone.setSoDienThoaiCoDinhNguoiNop(getSoDienThoaiCoDinhNguoiNop());
		clone.setTrangThaiHoSo(getTrangThaiHoSo());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setNgaySua(getNgaySua());
		clone.setThuTucHanhChinhId(getThuTucHanhChinhId());
		clone.setCanBoTiepNhanId(getCanBoTiepNhanId());
		clone.setSoDienThoaiDiDongNguoiNop(getSoDienThoaiDiDongNguoiNop());
		clone.setGhiChu(getGhiChu());
		clone.setMucDichChungThuc(getMucDichChungThuc());
		clone.setMaSoBienNhan(getMaSoBienNhan());
		clone.setChuSoHuu(getChuSoHuu());
		clone.setSoBoHoSo(getSoBoHoSo());
		clone.setSoTo(getSoTo());
		clone.setTruongHop(getTruongHop());
		clone.setLePhi(getLePhi());
		clone.setPhiHoSo(getPhiHoSo());
		clone.setEmailNguoiNop(getEmailNguoiNop());
		clone.setNgaySinhNguoiNop(getNgaySinhNguoiNop());
		clone.setSoCMNDNguoiNop(getSoCMNDNguoiNop());
		clone.setGioiTinhNguoiNop(getGioiTinhNguoiNop());
		clone.setTenCanBoKy(getTenCanBoKy());
		clone.setChucVuCanBoKyId(getChucVuCanBoKyId());
		clone.setSoDanhMucId(getSoDanhMucId());
		clone.setThuongTruTinhId(getThuongTruTinhId());
		clone.setThuongTruHuyenId(getThuongTruHuyenId());
		clone.setThuongTruXaId(getThuongTruXaId());

		return clone;
	}

	public int compareTo(HoSoChungThuc hoSoChungThuc) {
		int value = 0;

		value = DateUtil.compareTo(getNgayTao(), hoSoChungThuc.getNgayTao());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HoSoChungThucClp hoSoChungThuc = null;

		try {
			hoSoChungThuc = (HoSoChungThucClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hoSoChungThuc.getPrimaryKey();

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
		StringBundler sb = new StringBundler(73);

		sb.append("{hoSoChungThucId=");
		sb.append(getHoSoChungThucId());
		sb.append(", tenChungThuc=");
		sb.append(getTenChungThuc());
		sb.append(", soChungThuc=");
		sb.append(getSoChungThuc());
		sb.append(", ngayNopHoSo=");
		sb.append(getNgayNopHoSo());
		sb.append(", ngayTraKetQua=");
		sb.append(getNgayTraKetQua());
		sb.append(", hoTenNguoiNopHoSo=");
		sb.append(getHoTenNguoiNopHoSo());
		sb.append(", diaChiThuongTruNguoiNop=");
		sb.append(getDiaChiThuongTruNguoiNop());
		sb.append(", soDienThoaiCoDinhNguoiNop=");
		sb.append(getSoDienThoaiCoDinhNguoiNop());
		sb.append(", trangThaiHoSo=");
		sb.append(getTrangThaiHoSo());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", thuTucHanhChinhId=");
		sb.append(getThuTucHanhChinhId());
		sb.append(", canBoTiepNhanId=");
		sb.append(getCanBoTiepNhanId());
		sb.append(", soDienThoaiDiDongNguoiNop=");
		sb.append(getSoDienThoaiDiDongNguoiNop());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append(", mucDichChungThuc=");
		sb.append(getMucDichChungThuc());
		sb.append(", maSoBienNhan=");
		sb.append(getMaSoBienNhan());
		sb.append(", chuSoHuu=");
		sb.append(getChuSoHuu());
		sb.append(", soBoHoSo=");
		sb.append(getSoBoHoSo());
		sb.append(", soTo=");
		sb.append(getSoTo());
		sb.append(", truongHop=");
		sb.append(getTruongHop());
		sb.append(", lePhi=");
		sb.append(getLePhi());
		sb.append(", phiHoSo=");
		sb.append(getPhiHoSo());
		sb.append(", emailNguoiNop=");
		sb.append(getEmailNguoiNop());
		sb.append(", ngaySinhNguoiNop=");
		sb.append(getNgaySinhNguoiNop());
		sb.append(", soCMNDNguoiNop=");
		sb.append(getSoCMNDNguoiNop());
		sb.append(", gioiTinhNguoiNop=");
		sb.append(getGioiTinhNguoiNop());
		sb.append(", tenCanBoKy=");
		sb.append(getTenCanBoKy());
		sb.append(", chucVuCanBoKyId=");
		sb.append(getChucVuCanBoKyId());
		sb.append(", soDanhMucId=");
		sb.append(getSoDanhMucId());
		sb.append(", thuongTruTinhId=");
		sb.append(getThuongTruTinhId());
		sb.append(", thuongTruHuyenId=");
		sb.append(getThuongTruHuyenId());
		sb.append(", thuongTruXaId=");
		sb.append(getThuongTruXaId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(112);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.chungthuc.model.HoSoChungThuc");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hoSoChungThucId</column-name><column-value><![CDATA[");
		sb.append(getHoSoChungThucId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenChungThuc</column-name><column-value><![CDATA[");
		sb.append(getTenChungThuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soChungThuc</column-name><column-value><![CDATA[");
		sb.append(getSoChungThuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNopHoSo</column-name><column-value><![CDATA[");
		sb.append(getNgayNopHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenNguoiNopHoSo</column-name><column-value><![CDATA[");
		sb.append(getHoTenNguoiNopHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTruNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTruNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDienThoaiCoDinhNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getSoDienThoaiCoDinhNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiHoSo</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiHoSo());
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
			"<column><column-name>thuTucHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getThuTucHanhChinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoTiepNhanId</column-name><column-value><![CDATA[");
		sb.append(getCanBoTiepNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDienThoaiDiDongNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getSoDienThoaiDiDongNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mucDichChungThuc</column-name><column-value><![CDATA[");
		sb.append(getMucDichChungThuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoBienNhan</column-name><column-value><![CDATA[");
		sb.append(getMaSoBienNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chuSoHuu</column-name><column-value><![CDATA[");
		sb.append(getChuSoHuu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soBoHoSo</column-name><column-value><![CDATA[");
		sb.append(getSoBoHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soTo</column-name><column-value><![CDATA[");
		sb.append(getSoTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>truongHop</column-name><column-value><![CDATA[");
		sb.append(getTruongHop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lePhi</column-name><column-value><![CDATA[");
		sb.append(getLePhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phiHoSo</column-name><column-value><![CDATA[");
		sb.append(getPhiHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getEmailNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySinhNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getNgaySinhNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soCMNDNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getSoCMNDNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gioiTinhNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getGioiTinhNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCanBoKy</column-name><column-value><![CDATA[");
		sb.append(getTenCanBoKy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chucVuCanBoKyId</column-name><column-value><![CDATA[");
		sb.append(getChucVuCanBoKyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDanhMucId</column-name><column-value><![CDATA[");
		sb.append(getSoDanhMucId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuongTruTinhId</column-name><column-value><![CDATA[");
		sb.append(getThuongTruTinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuongTruHuyenId</column-name><column-value><![CDATA[");
		sb.append(getThuongTruHuyenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuongTruXaId</column-name><column-value><![CDATA[");
		sb.append(getThuongTruXaId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _hoSoChungThucId;
	private String _tenChungThuc;
	private String _soChungThuc;
	private Date _ngayNopHoSo;
	private Date _ngayTraKetQua;
	private String _hoTenNguoiNopHoSo;
	private String _diaChiThuongTruNguoiNop;
	private String _soDienThoaiCoDinhNguoiNop;
	private int _trangThaiHoSo;
	private int _daXoa;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private Long _thuTucHanhChinhId;
	private Long _canBoTiepNhanId;
	private String _soDienThoaiDiDongNguoiNop;
	private String _ghiChu;
	private String _mucDichChungThuc;
	private String _maSoBienNhan;
	private String _chuSoHuu;
	private int _soBoHoSo;
	private int _soTo;
	private String _truongHop;
	private int _lePhi;
	private int _phiHoSo;
	private String _emailNguoiNop;
	private Date _ngaySinhNguoiNop;
	private String _soCMNDNguoiNop;
	private int _gioiTinhNguoiNop;
	private String _tenCanBoKy;
	private Long _chucVuCanBoKyId;
	private Long _soDanhMucId;
	private Long _thuongTruTinhId;
	private Long _thuongTruHuyenId;
	private Long _thuongTruXaId;
}