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

package org.oep.cmon.dao.beans.giaytodinhkemhoso;
import org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKemImpl;
import org.oep.egovcore.util.StringPool;

import org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo;


@SuppressWarnings("serial")
public abstract class BaseGiayToDinhKemHoSoImpl extends GiayToDinhKemImpl implements GiayToDinhKemHoSo {

	public BaseGiayToDinhKemHoSoImpl () {}

	public void setFileDinhKemId(long fileDinhKemId) {
		_fileDinhKemId = fileDinhKemId;
	}

	public long getFileDinhKemId() {
		return _fileDinhKemId;
	}

	public void setNoiLuuTruTaiLieuId(Long noiLuuTruTaiLieuId) {
		_noiLuuTruTaiLieuId = noiLuuTruTaiLieuId;
	}

	public Long getNoiLuuTruTaiLieuId(boolean notNull) {
		if (notNull && _noiLuuTruTaiLieuId == null) {
			return 0L;
		}
		return _noiLuuTruTaiLieuId;
	}

	public void setLaBanChinh(boolean laBanChinh) {
		_laBanChinh = laBanChinh;
	}

	public boolean getLaBanChinh() {
		return _laBanChinh;
	}

	public void setDaNhan(boolean daNhan) {
		_daNhan = daNhan;
	}

	public boolean getDaNhan() {
		return _daNhan;
	}

	public void setDownloadLink(String downloadLink) {
		if (downloadLink != null) {
			_downloadLink = downloadLink.trim();
		}
	}

	public String getDownloadLink() {
		return _downloadLink;
	}

	private long _fileDinhKemId;
	private Long _noiLuuTruTaiLieuId;
	private boolean _laBanChinh;
	private boolean _daNhan;
	private String _downloadLink = StringPool.BLANK;
}