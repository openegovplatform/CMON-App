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

package org.oep.cmon.admin.portlet.action;

import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.job.util.DateUtil;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;
import org.oep.exch.dao.hoso.NoSuchKetQuaHosoException;
import org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException;
import org.oep.exch.dao.hoso.model.HoSoMotCua;
import org.oep.exch.dao.hoso.model.KetQuaHoso;
import org.oep.exch.dao.hoso.model.TrangThaiHoso;
import org.oep.exch.dao.hoso.service.HoSoMotCuaLocalServiceUtil;
import org.oep.exch.dao.hoso.service.KetQuaHosoLocalServiceUtil;
import org.oep.exch.dao.hoso.service.TrangThaiHosoLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * This is class HoSoTicHopAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HoSoTicHopAction {
	
	/**
	 * This is function edit HoSoMotCua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void editHoSoMotCua(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get data from client
		String maLoaiHoSo = ParamUtil.getString(actionRequest,"maLoaiHoSo");
		
		String maSoHoSo = ParamUtil.getString(actionRequest,"maSoHoSo");
		
		String maDonViTiepNhan = ParamUtil.getString(actionRequest,"maDonViTiepNhan");
		
		String ngayNopHoSo = ParamUtil.getString(actionRequest,"ngayNopHoSo");
		
		String ngayHenTra = ParamUtil.getString(actionRequest,"ngayHenTra");
		
		String hoTenNguoiNop = ParamUtil.getString(actionRequest,"hoTenNguoiNop");
		
		String soCmnd = ParamUtil.getString(actionRequest,"soCmnd");
		
		String ngaySinh = ParamUtil.getString(actionRequest,"ngaySinh");
		
		String maTinhThuongTru = ParamUtil.getString(actionRequest,"maTinhThuongTru");
		
		String moTaDiaChiThuongTru = ParamUtil.getString(actionRequest,"moTaDiaChiThuongTru");
		
		int gioiTinh = ParamUtil.getInteger(actionRequest,"gioiTinh");
		
		String maNguoiTiepNhan = ParamUtil.getString(actionRequest,"maNguoiTiepNhan");
		
		String tenNguoiTiepNhan = ParamUtil.getString(actionRequest,"tenNguoiTiepNhan");
		
		int trangThaiXuLy = ParamUtil.getInteger(actionRequest,"trangThaiXuLy");
		
		long id = ParamUtil.getLong(actionRequest, "id");
		
		// Data validation should be skipped
		
		// Update data to DB
		HoSoMotCua hoSo = HoSoMotCuaLocalServiceUtil.getHoSoMotCua(id);
		
		// Ma loai ho so
		hoSo.setMaLoaiHoSo(maLoaiHoSo);
		
		// Ma so ho so
		hoSo.setMaSoHoSo(maSoHoSo);

		// Ma don vi tiep nhan
		hoSo.setMaDonViTiepNhan(maDonViTiepNhan);
		
		// Ngay nop ho so
		hoSo.setNgayNopHoSo(ngayNopHoSo);
		
		// Ngay hen tra
		hoSo.setNgayHenTra(ngayHenTra);
		
		// Ho va ten nguoi nop
		hoSo.setHoTenNguoiNop(hoTenNguoiNop);
		
		// So chung minh nhan dan
		hoSo.setSoCmnd(soCmnd);
		
		// Ngay sinh
		hoSo.setNgaySinh(ngaySinh);
		
		// Ma tinh thuong tru
		hoSo.setMaTinhThuongTru(maTinhThuongTru);
		
		// Mo ta dia chi thuong tru
		hoSo.setMoTaDiaChiThuongTru(moTaDiaChiThuongTru);
		
		// Gioi tinh
		hoSo.setGioiTinh(gioiTinh);
		
		// Ma nguoi tiep nhan
		hoSo.setMaNguoiTiepNhan(maNguoiTiepNhan);
		
		// Ten nguoi tiep nhan
		hoSo.setTenNguoiTiepNhan(tenNguoiTiepNhan);
		
		// Trang thai xu ly
		hoSo.setTrangThaiXuLy(trangThaiXuLy);
		
		// Update to DB
		HoSoMotCuaLocalServiceUtil.updateHoSoMotCua(hoSo);
		
		// Redirect
		String redirectUrl = ParamUtil.getString(actionRequest,"redirectUrl");
		
		actionResponse.sendRedirect(redirectUrl);
	}
	
	/**
	 * This is function edit TrangThaiHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void editTrangThaiHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get parameters from request
		HashMap<String, String> props = (HashMap<String, String>)actionRequest.getPortletSession().getAttribute("TRANGTHAIHOSO_REQUEST_OBJ");
		
		if ( props == null ) {
			props = new HashMap<String, String>();
		}
		
		String id = ParamUtil.getString(actionRequest,"id");
		
		String onlineId = ParamUtil.getString(actionRequest,"onlineId");
		
		String maSoHoSo = ParamUtil.getString(actionRequest,"maSoHoSo");
		
		String ngayHenTra = ParamUtil.getString(actionRequest,"ngayHenTra");
		
		String maNguoiXuLyHienTai = ParamUtil.getString(actionRequest,"maNguoiXuLyHienTai");
		
		String tenNguoiXuLyHienTai = ParamUtil.getString(actionRequest,"tenNguoiXuLyHienTai");
		
		String tenPhongBanXuLyHienTai = ParamUtil.getString(actionRequest,"tenPhongBanXuLyHienTai");
		
		String ngayGioLuanChuyen = ParamUtil.getString(actionRequest,"ngayGioLuanChuyen");
		
		String soGioThucHien = ParamUtil.getString(actionRequest,"soGioThucHien");
		
		String maNguoiXuLyKeTiep = ParamUtil.getString(actionRequest,"maNguoiXuLyKeTiep");
		
		String tenNguoiXuLyKeTiep = ParamUtil.getString(actionRequest,"tenNguoiXuLyKeTiep");
		
		String tenPhongBanXuLyKeTiep = ParamUtil.getString(actionRequest,"tenPhongBanXuLyKeTiep");
		
		String soGioYeuCauXuLy = ParamUtil.getString(actionRequest,"soGioYeuCauXuLy");
		
		String noiDungYeuCauXuLy = ParamUtil.getString(actionRequest,"noiDungYeuCauXuLy");
		
		String trangThaiKeTiep = ParamUtil.getString(actionRequest,"trangThaiKeTiep");
		
		String trangThaiHienTai = ParamUtil.getString(actionRequest,"trangThaiHienTai");
		
		String trangThaiXuLy = ParamUtil.getString(actionRequest,"trangThaiXuLy");
		
		props.put("id", id);
		
		props.put("onlineId", onlineId);
		
		props.put("maSoHoSo", maSoHoSo);
		
		props.put("ngayHenTra", ngayHenTra);
		
		props.put("maNguoiXuLyHienTai", maNguoiXuLyHienTai);
		
		props.put("tenNguoiXuLyHienTai", tenNguoiXuLyHienTai);
		
		props.put("tenPhongBanXuLyHienTai", tenPhongBanXuLyHienTai);
		
		props.put("ngayGioLuanChuyen", ngayGioLuanChuyen);
		
		props.put("soGioThucHien", soGioThucHien);
		
		props.put("maNguoiXuLyKeTiep", maNguoiXuLyKeTiep);
		
		props.put("tenNguoiXuLyKeTiep", tenNguoiXuLyKeTiep);
		
		props.put("tenPhongBanXuLyKeTiep", tenPhongBanXuLyKeTiep);
		
		props.put("soGioYeuCauXuLy", soGioYeuCauXuLy);
		
		props.put("noiDungYeuCauXuLy", noiDungYeuCauXuLy);
		
		props.put("trangThaiKeTiep", trangThaiKeTiep);
		
		props.put("trangThaiHienTai", trangThaiHienTai);
		
		props.put("trangThaiXuLy", trangThaiXuLy);

		// Validate parameter
		if (!Validator.isNumber(onlineId)) {
			SessionErrors.add(actionRequest, "err.onlineId");
		}
		
		// Validate ngay gio luan chuyen
		if (!DateUtil.isDateTime(ngayGioLuanChuyen)) {
			SessionErrors.add(actionRequest, "err.ngayGioLuanChuyen");
		}
		
		// Validate so gio thuc hien
		if (!Validator.isNumber(soGioThucHien)) {
			SessionErrors.add(actionRequest, "err.soGioThucHien");
		}		
		
		// Validate so gio yeu cau xu ly
		if (!Validator.isNumber(soGioYeuCauXuLy)) {
			SessionErrors.add(actionRequest, "err.soGioYeuCauXuLy");
		}
		
		// Validate trang thai hien tai
		if ( Integer.parseInt(trangThaiHienTai) < 0 ) {
			SessionErrors.add(actionRequest, "err.trangThaiHienTai");
		}
		
		// Validate trang thai ke tiep
		if ( Integer.parseInt(trangThaiKeTiep) < 0 ) {
			SessionErrors.add(actionRequest, "err.trangThaiKeTiep");
		}
		
		// Validate trang thai xu ly
		if ( Integer.parseInt(trangThaiXuLy) < 0 ) {
			SessionErrors.add(actionRequest, "err.trangThaiXuLy");
		}
		
		// Store to session
		actionRequest.getPortletSession().setAttribute("TRANGTHAIHOSO_REQUEST_OBJ", props);
		
		// Redirect
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}	
		
		// Update to DB
		TrangThaiHoso trangThaiHoSo = TrangThaiHosoLocalServiceUtil.getTrangThaiHoso(Long.parseLong(id));		
		
		// Online ID
		trangThaiHoSo.setOnlineId(Long.parseLong(onlineId));
		
		// Ma so ho so
		trangThaiHoSo.setMaSoHoSo(maSoHoSo.trim());
		
		// Ngay hen tra
		trangThaiHoSo.setNgayHenTra(ngayHenTra);
		
		// Ma nguoi xu ly hien tai
		trangThaiHoSo.setMaNguoiXuLyHienTai(maNguoiXuLyHienTai.trim());
		
		// Ten nguoi xu ly hien tai
		trangThaiHoSo.setTenNguoiXuLyHienTai(tenNguoiXuLyHienTai.trim());
		
		// Ten phong ban xu ly hien tai
		trangThaiHoSo.setTenPhongBanXuLyHienTai(tenPhongBanXuLyHienTai.trim());
		
		// Trang thai hien tai
		trangThaiHoSo.setTrangThaiHienTai(Integer.parseInt(trangThaiHienTai));
		
		// Ngay gio luan chuyen
		trangThaiHoSo.setNgayGioLuanChuyen(ngayGioLuanChuyen);
		
		// So gio thuc hien
		trangThaiHoSo.setSoGioThucHien(Integer.parseInt(soGioThucHien));
		
		// Ma nguoi xu ly ke tiep
		trangThaiHoSo.setMaNguoiXuLyKeTiep(maNguoiXuLyKeTiep.trim());
		
		// Ten nguoi xu ly ke tiep
		trangThaiHoSo.setTenNguoiXuLyKeTiep(tenNguoiXuLyKeTiep.trim());
		
		// Ten phong ban xu ly ke tiep
		trangThaiHoSo.setTenPhongBanXuLyKeTiep(tenPhongBanXuLyKeTiep.trim());
		
		// So gio yeu cau xu ly
		trangThaiHoSo.setSoGioYeuCauXuLy(Integer.parseInt(soGioYeuCauXuLy));
		
		// Noi dung yeu cau xu ly
		trangThaiHoSo.setNoiDungYeuCauXuLy(noiDungYeuCauXuLy.trim());
		
		// Trang thai xu ly
		trangThaiHoSo.setTrangThaiXuLy(Integer.parseInt(trangThaiXuLy));
		
		// Update data to DB
		TrangThaiHosoLocalServiceUtil.updateTrangThaiHoso(trangThaiHoSo);
		
		// Redirect to Success page
		actionRequest.getPortletSession().removeAttribute("TRANGTHAIHOSO_REQUEST_OBJ");
		
		String successUrl = ParamUtil.getString(actionRequest, "successUrl");
		
		actionResponse.sendRedirect(successUrl);		
	}
	
	/**
	 * This is function edit KetQuaHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void editKetQuaHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get parameters from request
		HashMap<String, String> props = (HashMap<String, String>)actionRequest.getPortletSession().getAttribute("KETQUAHOSO_REQUEST_OBJ");
		
		if ( props == null ) {
			props = new HashMap<String, String>();
		}
		
		String id = ParamUtil.getString(actionRequest,"id");
		
		String maSoHoSo = ParamUtil.getString(actionRequest,"maSoHoSo");
		
		String tenNguoiNhanKetQua = ParamUtil.getString(actionRequest,"tenNguoiNhanKetQua");
		
		String ngayNhanKetQua = ParamUtil.getString(actionRequest,"ngayNhanKetQua");
		
		String lePhiHoSo = ParamUtil.getString(actionRequest,"lePhiHoSo");
		
		String phiXuLyHoSo = ParamUtil.getString(actionRequest,"phiXuLyHoSo");
		
		String ngayHoanThanh = ParamUtil.getString(actionRequest,"ngayHoanThanh");
		
		String maCanBoTraKetQua = ParamUtil.getString(actionRequest,"maCanBoTraKetQua");
		
		String tenCanBoTraKetQua = ParamUtil.getString(actionRequest,"tenCanBoTraKetQua");
		
		String trangThaiXuLy = ParamUtil.getString(actionRequest,"trangThaiXuLy");
		
		// ID
		props.put("id", id);
		
		// Ma so ho so
		props.put("maSoHoSo", maSoHoSo);
		
		// Ten nguoi nhan ket qua
		props.put("tenNguoiNhanKetQua", tenNguoiNhanKetQua);
		
		// Ngay nhan ket qua
		props.put("ngayNhanKetQua", ngayNhanKetQua);
		
		// Le Phi Ho so
		props.put("lePhiHoSo", lePhiHoSo);
		
		// Phi Xu ly ho so
		props.put("phiXuLyHoSo", phiXuLyHoSo);
		
		// Ngay hoan thanh
		props.put("ngayHoanThanh", ngayHoanThanh);
		
		// Ma can bo tra ket qua
		props.put("maCanBoTraKetQua", maCanBoTraKetQua);
		
		// Ten can bo tra ket qua
		props.put("tenCanBoTraKetQua", tenCanBoTraKetQua);
		
		// Trang thai xu ly
		props.put("trangThaiXuLy", trangThaiXuLy);
		
		// Check parameters		
		// Le phi ho so
		if (!Validator.isNumber(lePhiHoSo)) {
			SessionErrors.add(actionRequest, "err.lePhiHoSo");
		}
		
		// Phi xu ly ho so
		if (!Validator.isNumber(phiXuLyHoSo)) {
			SessionErrors.add(actionRequest, "err.lePhiHoSo");
		}
		
		// Validate trang thai xu ly
		if ( Integer.parseInt(trangThaiXuLy) < 0 ) {
			SessionErrors.add(actionRequest, "err.trangThaiXuLy");
		}
		
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		KetQuaHoso ketQuaHoSo  = KetQuaHosoLocalServiceUtil.getKetQuaHoso(Long.parseLong(id));
		
		ketQuaHoSo.setMaSoHoSo(maSoHoSo.trim());
		
		ketQuaHoSo.setTenNguoiNhanKetQua(tenNguoiNhanKetQua.trim());
		
		ketQuaHoSo.setNgayNhanKetQua(ngayNhanKetQua);
		
		ketQuaHoSo.setLePhiHoSo(Integer.parseInt(lePhiHoSo));
		
		ketQuaHoSo.setPhiXuLyHoSo(Integer.parseInt(phiXuLyHoSo));
		
		ketQuaHoSo.setNgayHoanThanh(ngayHoanThanh);
		
		ketQuaHoSo.setMaCanBoTraKetQua(maCanBoTraKetQua.trim());
		
		ketQuaHoSo.setTenCanBoTraKetQua(tenCanBoTraKetQua.trim());
		
		ketQuaHoSo.setTrangThaiXuLy(Integer.parseInt(trangThaiXuLy));
		
		// Update to DB
		KetQuaHosoLocalServiceUtil.updateKetQuaHoso(ketQuaHoSo);
		
		// Redirect to Success page
		actionRequest.getPortletSession().removeAttribute("KETQUAHOSO_REQUEST_OBJ");
		
		String successUrl = ParamUtil.getString(actionRequest, "successUrl");
		
		actionResponse.sendRedirect(successUrl);		
	}
	
	/**
	 * This is function deltete HoSoMotCua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteHoSoMotCua(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		
		// Delete data
		try {
			HoSoMotCuaLocalServiceUtil.deleteHoSoMotCua(id);
		} catch (NoSuchHoSoMotCuaException e) {
			// Swallow the exception
			//e.printStackTrace();
		}
		
		// redirect
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/exch_data_monitor.jsp");
		actionResponse.setRenderParameter("refresh", "1");		
	}
	
	/**
	 * This is function edit TrangThaiHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteTrangThaiHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		
		// Delete data
		try {
			TrangThaiHosoLocalServiceUtil.deleteTrangThaiHoso(id);
		} catch ( NoSuchTrangThaiHosoException e) {
			// Swallow the exception
			//e.printStackTrace();
		}		
		
		// redirect
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/exch_data_monitor.jsp");
		actionResponse.setRenderParameter("refresh", "1");		
	}
	
	/**
	 * This is function delete KetQuaHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteKetQuaHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		
		// Delete data
		try {
			KetQuaHosoLocalServiceUtil.deleteKetQuaHoso(id);
		} catch ( NoSuchKetQuaHosoException e) {
			// Swallow the exception
			//e.printStackTrace();
		}
		
		// redirect
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/exch_data_monitor.jsp");
		actionResponse.setRenderParameter("refresh", "1");		
	}
	
	/**
	 * This is function search HoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void searchHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Build dynamic query here
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(HoSoTTHCCong.class);
		
		// Always search un-deleted record
		query = query.add( PropertyFactoryUtil.forName("daXoa").eq(0));
		
		// Only query offline ho so
		query = query.add( PropertyFactoryUtil.forName("loaiHoSo").eq(1));
		
		// Get the keyword
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
		
		// Add the criteria incase keyword search is not null
		if ( Validator.isNotNull(keyWord)) {
			Criterion criteria = null;		

			criteria = RestrictionsFactoryUtil.ilike("maSoHoSo", keyWord + "%");
			
			// Define search criteria
			query = query.add( criteria );
		}

		List<HoSoTTHCCong> results = null;
		
		try {
			results = HoSoTTHCCongLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		// Set the result back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_HOSO_RESULT", results);

		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/hoso_list.jsp");

		actionResponse.setRenderParameter("keyWord", keyWord);
	}
}
