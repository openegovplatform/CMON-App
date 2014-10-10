/*
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oep.cmon.dao.beans.congdan;

import org.oep.egovcore.util.StringPool;

import org.oep.cmon.dao.beans.congdan.CongDan;

@SuppressWarnings("serial")
public abstract class BaseCongDanImpl implements java.io.Serializable, CongDan {

	public BaseCongDanImpl () {}

	public void setCongDanId(long congDanId) {
		_congDanId = congDanId;
	}

	public long getCongDanId() {
		return _congDanId;
	}

	public void setHo(String ho) {
		if (ho != null) {
			_ho = ho.trim();
		}
	}

	public String getHo() {
		return _ho;
	}

	public void setDem(String dem) {
		if (dem != null) {
			_dem = dem.trim();
		}
	}

	public String getDem() {
		return _dem;
	}

	public void setTen(String ten) {
		if (ten != null) {
			_ten = ten.trim();
		}
	}

	public String getTen() {
		return _ten;
	}

	public void setGioiTinhId(int gioiTinhId) {
		_gioiTinhId = gioiTinhId;
	}

	public int getGioiTinhId() {
		return _gioiTinhId;
	}

	public void setSoCMND(String soCMND) {
		if (soCMND != null) {
			_soCMND = soCMND.trim();
		}
	}

	public String getSoCMND() {
		return _soCMND;
	}

	public void setNgaySinh(java.util.Date ngaySinh) {
		_ngaySinh = ngaySinh;
	}

	public java.util.Date getNgaySinh() {
		return _ngaySinh;
	}

	public void setDienThoaiCoDinh(String dienThoaiCoDinh) {
		if (dienThoaiCoDinh != null) {
			_dienThoaiCoDinh = dienThoaiCoDinh.trim();
		}
	}

	public String getDienThoaiCoDinh() {
		return _dienThoaiCoDinh;
	}

	public void setDienThoaiDiDong(String dienThoaiDiDong) {
		if (dienThoaiDiDong != null) {
			_dienThoaiDiDong = dienThoaiDiDong.trim();
		}
	}

	public String getDienThoaiDiDong() {
		return _dienThoaiDiDong;
	}

	public void setEmail(String email) {
		if (email != null) {
			_email = email.trim();
		}
	}

	public String getEmail() {
		return _email;
	}

	public void setTinhDiaChiId(Long tinhDiaChiId) {
		_tinhDiaChiId = tinhDiaChiId;
	}

	public Long getTinhDiaChiId(boolean notNull) {
		if (notNull && _tinhDiaChiId == null) {
			return 0L;
		}
		return _tinhDiaChiId;
	}

	public void setTenTinhDiaChi(String tenTinhDiaChi) {
		if (tenTinhDiaChi != null) {
			_tenTinhDiaChi = tenTinhDiaChi.trim();
		}
	}

	public String getTenTinhDiaChi() {
		return _tenTinhDiaChi;
	}

	public void setHuyenDiaChiId(Long huyenDiaChiId) {
		_huyenDiaChiId = huyenDiaChiId;
	}

	public Long getHuyenDiaChiId(boolean notNull) {
		if (notNull && _huyenDiaChiId == null) {
			return 0L;
		}
		return _huyenDiaChiId;
	}

	public void setTenHuyenDiaChi(String tenHuyenDiaChi) {
		if (tenHuyenDiaChi != null) {
			_tenHuyenDiaChi = tenHuyenDiaChi.trim();
		}
	}

	public String getTenHuyenDiaChi() {
		return _tenHuyenDiaChi;
	}

	public void setXaDiaChiId(Long xaDiaChiId) {
		_xaDiaChiId = xaDiaChiId;
	}

	public Long getXaDiaChiId(boolean notNull) {
		if (notNull && _xaDiaChiId == null) {
			return 0L;
		}
		return _xaDiaChiId;
	}

	public void setTenXaDiaChi(String tenXaDiaChi) {
		if (tenXaDiaChi != null) {
			_tenXaDiaChi = tenXaDiaChi.trim();
		}
	}

	public String getTenXaDiaChi() {
		return _tenXaDiaChi;
	}

	public void setDiaChiChiTiet(String diaChiChiTiet) {
		if (diaChiChiTiet != null) {
			_diaChiChiTiet = diaChiChiTiet.trim();
		}
	}

	public String getDiaChiChiTiet() {
		return _diaChiChiTiet;
	}

	public void setHoTenDayDu(String hoTenDayDu) {
		if (hoTenDayDu != null) {
			_hoTenDayDu = hoTenDayDu.trim();
		}
	}

	public String getHoTenDayDu() {
		return _hoTenDayDu;
	}

	public void setDiaChiDayDu(String diaChiDayDu) {
		if (diaChiDayDu != null) {
			_diaChiDayDu = diaChiDayDu.trim();
		}
	}

	public String getDiaChiDayDu() {
		return _diaChiDayDu;
	}

	public void setDienThoai(String dienThoai) {
		if (dienThoai != null) {
			_dienThoai = dienThoai.trim();
		}
	}

	public String getDienThoai() {
		return _dienThoai;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	public Long getTaiKhoanNguoiDungId(boolean notNull) {
		if (notNull && _taiKhoanNguoiDungId == null) {
			return 0L;
		}
		return _taiKhoanNguoiDungId;
	}

	private long _congDanId;
	private String _ho = StringPool.BLANK;
	private String _dem = StringPool.BLANK;
	private String _ten = StringPool.BLANK;
	private int _gioiTinhId;
	private String _soCMND = StringPool.BLANK;
	private java.util.Date _ngaySinh;
	private String _dienThoaiCoDinh = StringPool.BLANK;
	private String _dienThoaiDiDong = StringPool.BLANK;
	private String _email = StringPool.BLANK;
	private Long _tinhDiaChiId;
	private String _tenTinhDiaChi = StringPool.BLANK;
	private Long _huyenDiaChiId;
	private String _tenHuyenDiaChi = StringPool.BLANK;
	private Long _xaDiaChiId;
	private String _tenXaDiaChi = StringPool.BLANK;
	private String _diaChiChiTiet = StringPool.BLANK;
	private String _hoTenDayDu = StringPool.BLANK;
	private String _diaChiDayDu = StringPool.BLANK;
	private String _dienThoai = StringPool.BLANK;
	private Long _taiKhoanNguoiDungId;
}