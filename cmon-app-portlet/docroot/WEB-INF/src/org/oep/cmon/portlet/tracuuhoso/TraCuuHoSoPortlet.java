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

package org.oep.cmon.portlet.tracuuhoso;

import javax.portlet.ResourceRequest;

import org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil;
import org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil;
import org.oep.egovcore.language.BusinessMessagerUtil;
import org.oep.egovcore.portlet.AjaxMVCPortlet;
import org.oep.egovcore.portlet.AjaxResponse;
import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.util.VNNumberUtil;

import org.oep.cmon.dao.beans.congdan.CongDan;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil;
import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;
import org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;


/**
*
* TraCuuHoSoPortlet class
*   
* This class is used to process TraCuuHoSoPortlet
* from database
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class TraCuuHoSoPortlet extends AjaxMVCPortlet {

	/**
	  * This is fucntion serveThongTinHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ResourceRequest request, AjaxResponse ajaxResponse
	  * @return void
	  */
	public void serveThongTinHoSo(ResourceRequest request, AjaxResponse ajaxResponse) throws SystemException {
		
		String maSoBienNhan = ParamUtil.getString(request, TCHSFields.maSoBienNhan);
		HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchByMaSoBienNhan(maSoBienNhan);
		if (hoSo == null) {
			HoSoLienThong hoSoLienThong = HoSoLienThongLocalServiceUtil.fetchByMaSoBienNhanLucGui(maSoBienNhan);
			if (hoSoLienThong != null) {
				hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoLienThong.getHoSoId());
				HSLTBusinessUtil.fillThongTinHoSoLucKhoiTaoLienThong(hoSo);
			}
		} else {
			HoSoBusinessUtil.fillThongTinThanhToan(hoSo);
		}
		
		boolean isExist = (hoSo != null);
		JSONObject thongTinHoSoJSON = JSONFactoryUtil.createJSONObject();
		
		if (isExist) {
			
			CongDan congDanNop = HoSoBusinessUtil.getCongDanNopHoSo(hoSo);
			ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSo.getThuTucHanhChinhId());
			NhomThuTucHanhChinh nhomThuTuc =
				NhomThuTucHanhChinhLocalServiceUtil.fetchNhomThuTucHanhChinh(thuTuc.getNhomThuTucHanhChinhId());
			TrangThaiHoSo trangThai = TrangThaiHoSoLocalServiceUtil.fetchTrangThaiHoSo(hoSo.getTrangThaiHoSo());
			
			thongTinHoSoJSON = JSONFactoryUtil.createJSONObject()
				.put(TCHSFields.tenNhomThuTucHanhChinh, nhomThuTuc.getTen())
				.put(TCHSFields.tenThuTucHanhChinh, hoSo.getTenThuTucHanhChinh())
				.put(TCHSFields.maSoBienNhan, hoSo.getMaSoBienNhan())
				.put(TCHSFields.hoTenNguoiNopHoSo, congDanNop.getHoTenDayDu())
				.put(TCHSFields.email, congDanNop.getEmail())
				.put(TCHSFields.diaChiThuongTruDayDu, congDanNop.getDiaChiDayDu())
				.put(TCHSFields.ngayNhanHoSo, DateTimeUtil.getDayMonthYear(hoSo.getNgayNhanHoSo()))
				.put(TCHSFields.ngayHenTraHoSo, DateTimeUtil.getDayMonthYear(hoSo.getNgayHenTraKetQua()))
				.put(TCHSFields.ngayTraKetQuaThucTe, DateTimeUtil.getDayMonthYear(hoSo.getNgayTraKetQua()))
				.put(TCHSFields.tenCoQuanNhanHoSo, hoSo.getTenCoQuanTiepNhan())
				.put(TCHSFields.tenLoaiHoSo, BusinessMessagerUtil.get(request, "tenLoaiHoSo._" + hoSo.getLoaiHoSo()))
				.put(TCHSFields.phiHoSo, VNNumberUtil.toVNNum(hoSo.getPhiHoSo()))
				.put(TCHSFields.lePhiHoSo, VNNumberUtil.toVNNum(hoSo.getLePhi()))
				.put(TCHSFields.chuSoHuu, hoSo.getChuSoHuu())
				.put(TCHSFields.dienThoaiChuHoSo, congDanNop.getDienThoai())
				.put(TCHSFields.tenTrangThaiHoSo, trangThai.getTrangThai());
			
		}
		
		ajaxResponse.send(TCHSFields.isExist, isExist);
		ajaxResponse.send(TCHSFields.thongTinHoSo, thongTinHoSoJSON);
	}
}
