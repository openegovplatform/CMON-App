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

package org.oep.cmon.portlet.hosotructiep;

import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.util.VNNumberUtil;

import org.oep.cmon.dao.beans.congdan.CongDan;
import org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKem;
import org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo;
import org.oep.cmon.dao.beans.thongtinhoso.ThongTinHoSo;
import org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * This is class HoSoJSON
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HoSoJSON {
	
	/**
	 * This is function thuTuc2CoQuan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param info
	 * @throws SystemException
	 * @return JSONObject
	 */
	public static JSONObject thuTuc2CoQuan(ThongTinThuTuc2CoQuan info) throws SystemException {
		JSONObject out = JSONFactoryUtil.createJSONObject();
		if (info != null) {
			out
			.put(HoSoFields.thuTucHanhChinhId, info.getThuTucId())
			.put(HoSoFields.nhomThuTucId, info.getNhomThuTucId())
			.put(HoSoFields.lePhiHoSo, VNNumberUtil.toVNNum(info.getLePhiHoSo()))
			.put(HoSoFields.phiHoSo, VNNumberUtil.toVNNum(info.getPhiHoSo()))
			.put(HoSoFields.soNgayXuLy, info.getSoNgayXuLy())
			.put(HoSoFields.laNhomThuTucCongAn, info.getThuocUngDungCongAn())
		;
		}
		return out;
	}
	
	/**
	 * This is function thuTuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tthc2cq
	 * @throws Exception
	 * @return JSONObject
	 */
	public static JSONObject thuTuc(TTHC2CoQuanQuanLy tthc2cq) throws Exception {
		JSONObject out = JSONFactoryUtil.createJSONObject();
		
		if (tthc2cq != null) {
			ThongTinThuTuc2CoQuan info = 
				ThuTucHanhChinhLocalServiceUtil.fetchThongTinThuTuc2CoQuan(
					tthc2cq.getThuTucHanhChinhId(), tthc2cq.getCoQuanQuanLyId());
			
			out = thuTuc2CoQuan(info);
		}
		
		return out;
	}
	
	/**
	 * This is function thuTucCuaHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param info
	 * @throws SystemException
	 * @return JSONObject
	 */
	public static JSONObject thuTucCuaHoSo(ThongTinHoSo info) throws SystemException {
		JSONObject out = JSONFactoryUtil.createJSONObject();
		if (info != null) {
			out
			.put(HoSoFields.thuTucHanhChinhId, info.getThuTucId())
			.put(HoSoFields.nhomThuTucId, info.getNhomThuTucId())
			.put(HoSoFields.soBoHoSo, info.getSoBoHoSo())
			.put(HoSoFields.lePhiHoSo, VNNumberUtil.toVNNum(info.getLePhiHoSo()))
			.put(HoSoFields.phiHoSo, VNNumberUtil.toVNNum(info.getPhiHoSo()))
			.put(HoSoFields.soNgayXuLy, info.getSoNgayXuLy())
			.put(HoSoFields.laNhomThuTucCongAn, info.getThuocUngDungCongAn())
		;
		}
		return out;
	}
	
	/**
	 * This is function dsGiayToDinhKemHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param dsGiayTo
	 * @throws SystemException
	 * @return JSONArray
	 */
	public static JSONArray dsGiayToDinhKemHoSo(List<GiayToDinhKemHoSo> dsGiayTo) throws SystemException {
		JSONArray out = JSONFactoryUtil.createJSONArray();
		if (dsGiayTo != null) {
			for (GiayToDinhKemHoSo giayTo : dsGiayTo) {
				out.put(giayToDinhKemHoSo(giayTo));
			}
		}
		return out;
	}
	
	/**
	 * This is function dsGiayToDinhKem
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param dsGiayTo
	 * @throws SystemException
	 * @return JSONArray
	 */
	public static JSONArray dsGiayToDinhKem(List<GiayToDinhKem> dsGiayTo) throws SystemException {
		JSONArray out = JSONFactoryUtil.createJSONArray();
		if (dsGiayTo != null) {
			for (GiayToDinhKem giayTo: dsGiayTo) {
				out.put(giayToDinhKem(giayTo));
			}
		}
		return out;
	}
	
	/**
	 * This is function giayToDinhKemHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param giayTo
	 * @return JSONObject
	 */

	public static JSONObject giayToDinhKemHoSo(GiayToDinhKemHoSo giayTo) {
		JSONObject out = JSONFactoryUtil.createJSONObject();
		if (giayTo != null) {
			out = giayToDinhKem(giayTo)
				.put(HoSoFields.fileDinhKemId, giayTo.getFileDinhKemId())
				.put(HoSoFields.daNhan, giayTo.getDaNhan())
				.put(HoSoFields.banChinhGiayToQuyDinh, giayTo.getLaBanChinh())
				.put(HoSoFields.fileGiayToQuyDinh, giayTo.getDownloadLink())
			;
		}
		return out; 
	}
	
	/**
	 * This is function giayToDinhKem
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param giayTo
	 * @return JSONObject
	 */
	public static JSONObject giayToDinhKem(GiayToDinhKem giayTo) {
		JSONObject out = JSONFactoryUtil.createJSONObject();
		if (giayTo != null) {
			out
			.put(HoSoFields.loaiGiayToId, giayTo.getDanhMucGiayToId(true))
			.put(HoSoFields.thuTuc2GiayToId, giayTo.getThuTuc2GiayToId(true))
			.put(HoSoFields.tenGiayToQuyDinh, giayTo.getTenGiayTo())
			.put(HoSoFields.dinhDangChoPhep, giayTo.getDinhDangChoPhep())
			.put(HoSoFields.gioiHanDungLuong, giayTo.getGioiHanDungLuong())
			;
		}
		return out;
	}
	
	/**
	 * This is function congDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congDan
	 * @return JSONObject
	 */
	public static JSONObject congDan(CongDan congDan) {
		JSONObject out = JSONFactoryUtil.createJSONObject();
		if (congDan != null) {
			out
			.put(HoSoFields.nguoiNopHoSoCongDanId, congDan.getCongDanId())
			.put(HoSoFields.hoTenNguoiNopHoSo, WordUtils.capitalizeFully(congDan.getHoTenDayDu()))
			.put(HoSoFields.ngaySinh, DateTimeUtil.getDayMonthYear(congDan.getNgaySinh()))
			.put(HoSoFields.gioiTinh, congDan.getGioiTinhId())
			.put(HoSoFields.soCMND, congDan.getSoCMND())
			.put(HoSoFields.dienThoaiCoDinh, congDan.getDienThoaiCoDinh())
			.put(HoSoFields.dienThoaiDiDong, congDan.getDienThoaiDiDong())
			.put(HoSoFields.email, congDan.getEmail())
			.put(HoSoFields.tinhThuongTruId, congDan.getTinhDiaChiId(true))
			.put(HoSoFields.huyenThuongTruId, congDan.getHuyenDiaChiId(true))
			.put(HoSoFields.xaThuongTruId, congDan.getXaDiaChiId(true))
			.put(HoSoFields.diaChiThuongTru, congDan.getDiaChiChiTiet())
			.put(HoSoFields.diaChiThuongTruDayDu, congDan.getDiaChiDayDu())
			;
		}
		return out;
	}
}
