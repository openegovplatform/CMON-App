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

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

@SuppressWarnings("serial")
public class CongDanImpl extends BaseCongDanImpl {

	public CongDanImpl(org.oep.cmon.dao.cd.model.CongDan model) throws SystemException {
		
		if (model != null) {
			Long tinhThuongTruId = model.getDiaChiThuongTruTinhId();;
			boolean thuongTruChuaNhap = (tinhThuongTruId == null);
			Long tinhDiaChiId, huyenDiaChiId, xaDiaChiId;
			String diaChiThuongTruChiTiet, dienThoai,
			tenXaDiaChi = StringPool.BLANK, tenHuyenDiaChi = StringPool.BLANK, tenTinhDiaChi = StringPool.BLANK;
			
			if (thuongTruChuaNhap) {
				
				tinhDiaChiId = model.getDiaChiHienNayTinhId();
				if (tinhDiaChiId != null) {
					tenTinhDiaChi = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(tinhDiaChiId).getTen();
				}
				
				huyenDiaChiId = model.getDiaChiHienNayHuyenId();
				if (huyenDiaChiId != null) {
					tenHuyenDiaChi = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(huyenDiaChiId).getTen();
				}
				
				xaDiaChiId = model.getDiaChiHienNayXaId();
				if (xaDiaChiId != null) {
					tenHuyenDiaChi = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(xaDiaChiId).getTen();
				}
				
			} else {
				
				tinhDiaChiId = tinhThuongTruId;
				tenTinhDiaChi = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(tinhDiaChiId).getTen();
				
				huyenDiaChiId = model.getDiaChiThuongTruHuyenId();
				if (huyenDiaChiId != null) {
					tenHuyenDiaChi = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(huyenDiaChiId).getTen();
				}
				
				xaDiaChiId = model.getDiaChiThuongTruXaId();
				if (xaDiaChiId != null) {
					tenHuyenDiaChi = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(xaDiaChiId).getTen();
				}
				
			}
			
			if (thuongTruChuaNhap) {
				diaChiThuongTruChiTiet = model.getDiaChiHienNay().trim();
			} else {
				diaChiThuongTruChiTiet = model.getDiaChiThuongTru().trim();
			}
			
			dienThoai = model.getDienThoaiDiDong().trim();
			if (dienThoai.isEmpty()) {
				dienThoai = model.getDienThoaiCoDinh().trim();
			}
			
			setCongDanId(model.getId());
			setSoCMND(model.getSoCmnd().trim());
			setNgaySinh(model.getNgaySinh());
			setGioiTinhId(model.getGioiTinh());
			setHo(model.getHo());
			setDem(model.getDem());
			setTen(model.getTen());
			setDienThoaiDiDong(model.getDienThoaiDiDong().trim());
			setDienThoaiCoDinh(model.getDienThoaiCoDinh().trim());
			setDienThoai(dienThoai);
			setEmail(model.getEmail().trim());
			setTinhDiaChiId(tinhDiaChiId);
			setTenTinhDiaChi(tenTinhDiaChi);
			setHuyenDiaChiId(huyenDiaChiId);
			setTenHuyenDiaChi(tenHuyenDiaChi);
			setXaDiaChiId(xaDiaChiId);
			setTenXaDiaChi(tenXaDiaChi);
			setDiaChiChiTiet(diaChiThuongTruChiTiet);
			setTaiKhoanNguoiDungId(model.getTaiKhoanNguoiDungId());
		}
	}
	
	public String getHoTenDayDu() {
		
		String hoTen = super.getHoTenDayDu();
		
		if (hoTen.isEmpty()) {
			
			hoTen = new StringBuilder(getHo())
			.append(StringPool.SPACE)
			.append(getDem())
			.append(StringPool.SPACE)
			.append(getTen())
			.toString()
			.replaceAll(" +", StringPool.SPACE)
			.trim();
			
			setHoTenDayDu(hoTen);
		}
		
		return hoTen;
	}

	public String getDiaChiDayDu() {
		
		String diaChiDayDu = super.getDiaChiDayDu();
		
		if (diaChiDayDu.isEmpty()) {
			
			StringBuilder bdr = new StringBuilder(getDiaChiChiTiet());
			if (!getTenXaDiaChi().isEmpty()) {
				bdr.append(StringPool.COMMA_AND_SPACE).append(getTenXaDiaChi());
			}
			
			if (!getTenHuyenDiaChi().isEmpty()) {
				bdr.append(StringPool.COMMA_AND_SPACE).append(getTenHuyenDiaChi());
			}
			
			if (!getTenTinhDiaChi().isEmpty()) {
				bdr.append(StringPool.COMMA_AND_SPACE).append(getTenTinhDiaChi());
			}
			
			diaChiDayDu = bdr.toString();
			
			setDiaChiDayDu(diaChiDayDu);
		}
		
		return diaChiDayDu;
	}
	
	public CongDanImpl() {}
}