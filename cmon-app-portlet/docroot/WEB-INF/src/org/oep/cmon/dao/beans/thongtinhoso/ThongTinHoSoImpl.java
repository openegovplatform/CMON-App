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

package org.oep.cmon.dao.beans.thongtinhoso;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil;

import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@SuppressWarnings("serial")
public class ThongTinHoSoImpl extends BaseThongTinHoSoImpl {
	
	public ThongTinHoSoImpl (HoSoTTHCCong hoSo) throws SystemException {
		if (hoSo != null) {
			setSoBoHoSo(hoSo.getSoBoHoSo());
			setThuTucId(hoSo.getThuTucHanhChinhId());
			
			HoSoBusinessUtil.fillThongTinThanhToan(hoSo);
			
			setLePhiHoSo(hoSo.getLePhi());
			setPhiHoSo(hoSo.getPhiHoSo());
			
			setSoNgayXuLy(hoSo.getSoNgayXuLy() == null ? 0 : hoSo.getSoNgayXuLy().intValue());
			
			ThuTucHanhChinh thuTuc = 
				ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSo.getThuTucHanhChinhId());
			setMaThuTuc(thuTuc.getMa());
			setTenThuTuc(thuTuc.getTen());
			
			NhomThuTucHanhChinh nhomThuTuc =
				NhomThuTucHanhChinhLocalServiceUtil.fetchNhomThuTucHanhChinh(thuTuc.getNhomThuTucHanhChinhId());
			setNhomThuTucId(nhomThuTuc.getId());
			setMaNhomThuTuc(nhomThuTuc.getMa());
			setTenNhomThuTuc(nhomThuTuc.getTen());

			DanhMucUngDung dmud = 
				DanhMucUngDungLocalServiceUtil.fetchDanhMucUngDung(nhomThuTuc.getDanhMucUngDungId());
			setDanhMucUngDungId(dmud.getId());	
			setMaDanhMucUngDung(dmud.getMa());	
			setTenDanhMucUngDung(dmud.getTen());
			setThuocUngDungCongAn(dmud.getMa().equals(
				ThamSoLocalServiceUtil.getValue(Constants.TEN_THAMSO_MA_UNG_DUNG_CONG_AN)));
		}
	}
	
	public ThongTinHoSoImpl() {}
}