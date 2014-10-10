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

package org.oep.cmon.dao.beans.cauhinhlienthong;

import org.oep.cmon.dao.beans.cauhinhlienthong.CauHinhLienThong;
import org.oep.egovcore.util.StringPool;


@SuppressWarnings("serial")
public abstract class BaseCauHinhLienThongImpl implements java.io.Serializable, CauHinhLienThong {

	public BaseCauHinhLienThongImpl () {}

	public void setCoQuanId(long coQuanId) {
		_coQuanId = coQuanId;
	}

	public long getCoQuanId() {
		return _coQuanId;
	}

	public void setCoQuanTiepTheoId(Long coQuanTiepTheoId) {
		_coQuanTiepTheoId = coQuanTiepTheoId;
	}

	public Long getCoQuanTiepTheoId(boolean notNull) {
		if (notNull && _coQuanTiepTheoId == null) {
			return 0L;
		}
		return _coQuanTiepTheoId;
	}

	public void setThuTucId(long thuTucId) {
		_thuTucId = thuTucId;
	}

	public long getThuTucId() {
		return _thuTucId;
	}

	public void setThuTucTruocId(Long thuTucTruocId) {
		_thuTucTruocId = thuTucTruocId;
	}

	public Long getThuTucTruocId(boolean notNull) {
		if (notNull && _thuTucTruocId == null) {
			return 0L;
		}
		return _thuTucTruocId;
	}

	public void setThuTucTiepTheoId(Long thuTucTiepTheoId) {
		_thuTucTiepTheoId = thuTucTiepTheoId;
	}

	public Long getThuTucTiepTheoId(boolean notNull) {
		if (notNull && _thuTucTiepTheoId == null) {
			return 0L;
		}
		return _thuTucTiepTheoId;
	}

	public void setTenCoQuan(String tenCoQuan) {
		if (tenCoQuan != null) {
			_tenCoQuan = tenCoQuan.trim();
		}
	}

	public String getTenCoQuan() {
		return _tenCoQuan;
	}

	public void setTenThuTuc(String tenThuTuc) {
		if (tenThuTuc != null) {
			_tenThuTuc = tenThuTuc.trim();
		}
	}

	public String getTenThuTuc() {
		return _tenThuTuc;
	}

	public void setSoNgayXy(int soNgayXy) {
		_soNgayXy = soNgayXy;
	}

	public int getSoNgayXy() {
		return _soNgayXy;
	}

	public void setPhi(int phi) {
		_phi = phi;
	}

	public int getPhi() {
		return _phi;
	}

	public void setLePhi(int lePhi) {
		_lePhi = lePhi;
	}

	public int getLePhi() {
		return _lePhi;
	}

	private long _coQuanId;
	private Long _coQuanTiepTheoId;
	private long _thuTucId;
	private Long _thuTucTruocId;
	private Long _thuTucTiepTheoId;
	private String _tenCoQuan = StringPool.BLANK;
	private String _tenThuTuc = StringPool.BLANK;
	private int _soNgayXy;
	private int _phi;
	private int _lePhi;
}