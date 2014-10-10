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

package org.oep.cmon.dao.beans.giaytodinhkem;

import org.oep.egovcore.util.StringPool;

import org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKem;

@SuppressWarnings("serial")
public abstract class BaseGiayToDinhKemImpl implements java.io.Serializable, GiayToDinhKem {

	public BaseGiayToDinhKemImpl () {}

	public void setThuTuc2GiayToId(Long thuTuc2GiayToId) {
		_thuTuc2GiayToId = thuTuc2GiayToId;
	}

	public Long getThuTuc2GiayToId(boolean notNull) {
		if (notNull && _thuTuc2GiayToId == null) {
			return 0L;
		}
		return _thuTuc2GiayToId;
	}

	public void setDanhMucGiayToId(Long danhMucGiayToId) {
		_danhMucGiayToId = danhMucGiayToId;
	}

	public Long getDanhMucGiayToId(boolean notNull) {
		if (notNull && _danhMucGiayToId == null) {
			return 0L;
		}
		return _danhMucGiayToId;
	}

	public void setTenGiayTo(String tenGiayTo) {
		if (tenGiayTo != null) {
			_tenGiayTo = tenGiayTo.trim();
		}
	}

	public String getTenGiayTo() {
		return _tenGiayTo;
	}

	public void setDinhDangChoPhep(String dinhDangChoPhep) {
		if (dinhDangChoPhep != null) {
			_dinhDangChoPhep = dinhDangChoPhep.trim();
		}
	}

	public String getDinhDangChoPhep() {
		return _dinhDangChoPhep;
	}

	public void setGioiHanDungLuong(long gioiHanDungLuong) {
		_gioiHanDungLuong = gioiHanDungLuong;
	}

	public long getGioiHanDungLuong() {
		return _gioiHanDungLuong;
	}

	private Long _thuTuc2GiayToId;
	private Long _danhMucGiayToId;
	private String _tenGiayTo = StringPool.BLANK;
	private String _dinhDangChoPhep = StringPool.BLANK;
	private long _gioiHanDungLuong;
}