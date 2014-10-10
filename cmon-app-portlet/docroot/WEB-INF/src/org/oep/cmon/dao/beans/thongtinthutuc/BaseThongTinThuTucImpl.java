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

package org.oep.cmon.dao.beans.thongtinthutuc;

import org.oep.egovcore.util.StringPool;

import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc;

@SuppressWarnings("serial")
public abstract class BaseThongTinThuTucImpl implements java.io.Serializable, ThongTinThuTuc {

	public BaseThongTinThuTucImpl () {}

	public void setThuTucId(long thuTucId) {
		_thuTucId = thuTucId;
	}

	public long getThuTucId() {
		return _thuTucId;
	}

	public void setMaThuTuc(String maThuTuc) {
		if (maThuTuc != null) {
			_maThuTuc = maThuTuc.trim();
		}
	}

	public String getMaThuTuc() {
		return _maThuTuc;
	}

	public void setTenThuTuc(String tenThuTuc) {
		if (tenThuTuc != null) {
			_tenThuTuc = tenThuTuc.trim();
		}
	}

	public String getTenThuTuc() {
		return _tenThuTuc;
	}

	public void setNhomThuTucId(long nhomThuTucId) {
		_nhomThuTucId = nhomThuTucId;
	}

	public long getNhomThuTucId() {
		return _nhomThuTucId;
	}

	public void setMaNhomThuTuc(String maNhomThuTuc) {
		if (maNhomThuTuc != null) {
			_maNhomThuTuc = maNhomThuTuc.trim();
		}
	}

	public String getMaNhomThuTuc() {
		return _maNhomThuTuc;
	}

	public void setTenNhomThuTuc(String tenNhomThuTuc) {
		if (tenNhomThuTuc != null) {
			_tenNhomThuTuc = tenNhomThuTuc.trim();
		}
	}

	public String getTenNhomThuTuc() {
		return _tenNhomThuTuc;
	}

	public void setDanhMucUngDungId(long danhMucUngDungId) {
		_danhMucUngDungId = danhMucUngDungId;
	}

	public long getDanhMucUngDungId() {
		return _danhMucUngDungId;
	}

	public void setMaDanhMucUngDung(String maDanhMucUngDung) {
		if (maDanhMucUngDung != null) {
			_maDanhMucUngDung = maDanhMucUngDung.trim();
		}
	}

	public String getMaDanhMucUngDung() {
		return _maDanhMucUngDung;
	}

	public void setTenDanhMucUngDung(String tenDanhMucUngDung) {
		if (tenDanhMucUngDung != null) {
			_tenDanhMucUngDung = tenDanhMucUngDung.trim();
		}
	}

	public String getTenDanhMucUngDung() {
		return _tenDanhMucUngDung;
	}

	public void setThuocUngDungCongAn(boolean thuocUngDungCongAn) {
		_thuocUngDungCongAn = thuocUngDungCongAn;
	}

	public boolean getThuocUngDungCongAn() {
		return _thuocUngDungCongAn;
	}

	private long _thuTucId;
	private String _maThuTuc = StringPool.BLANK;
	private String _tenThuTuc = StringPool.BLANK;
	private long _nhomThuTucId;
	private String _maNhomThuTuc = StringPool.BLANK;
	private String _tenNhomThuTuc = StringPool.BLANK;
	private long _danhMucUngDungId;
	private String _maDanhMucUngDung = StringPool.BLANK;
	private String _tenDanhMucUngDung = StringPool.BLANK;
	private boolean _thuocUngDungCongAn;
}