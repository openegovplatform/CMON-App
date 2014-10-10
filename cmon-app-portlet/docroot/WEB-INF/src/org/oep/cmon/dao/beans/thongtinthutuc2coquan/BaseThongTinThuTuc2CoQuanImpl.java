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

package org.oep.cmon.dao.beans.thongtinthutuc2coquan;
import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTucImpl;

import org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan;

@SuppressWarnings("serial")
public abstract class BaseThongTinThuTuc2CoQuanImpl extends ThongTinThuTucImpl implements ThongTinThuTuc2CoQuan {

	public BaseThongTinThuTuc2CoQuanImpl () {}

	public void setLePhiHoSo(int lePhiHoSo) {
		_lePhiHoSo = lePhiHoSo;
	}

	public int getLePhiHoSo() {
		return _lePhiHoSo;
	}

	public void setPhiHoSo(int phiHoSo) {
		_phiHoSo = phiHoSo;
	}

	public int getPhiHoSo() {
		return _phiHoSo;
	}

	public void setSoNgayXuLy(int soNgayXuLy) {
		_soNgayXuLy = soNgayXuLy;
	}

	public int getSoNgayXuLy() {
		return _soNgayXuLy;
	}

	private int _lePhiHoSo;
	private int _phiHoSo;
	private int _soNgayXuLy;
}