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

package org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.portlet.taocongdan.util.FormatUtil;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.NoSuchQuocGiaException;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class Validators {
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	
	// Validator to check form input
		public static boolean validationInput(ActionRequest request, int mode ) {
			
			String emailDN = request.getParameter("emailDN");
			
			//Thông tin nguoi dai dien
			String hoTenNDD= request.getParameter("hoTenNDD");
			
			String ngaySinhNDD= request.getParameter("ngaySinhNDD");
			
			
			String gioiTinhNDD = request.getParameter("gioiTinhNDD");
			
			String quocTichNDD = request.getParameter("quocTichNDD");
			
			String danTocNDD = request.getParameter("danTocNDD");
			
			String soCMNDNDD = request.getParameter("soCMNDNDD");
			
			String ngayCapCMNDNDD = request.getParameter("ngayCapCMNDNDD");
			
			String noiCapCMNDNDD = request.getParameter("noiCapCMNDNDD");
			
			//Dia chi thuong tru
			String tinhTTNDD = request.getParameter("tinhTTNDD");
			
			String huyenTTNDD = request.getParameter("huyenTTNDD");
			
			String xaTTNDD = request.getParameter("xaTTNDD");
			
			String moTaTTNDD = request.getParameter("moTaTTNDD");
			
			
			
			//Dia chi hien tai
			
			String tinhHTNDD= request.getParameter("tinhHTNDD");
			
			String huyenHTNDD= request.getParameter("huyenHTNDD");
			
			String xaHTNDD= request.getParameter("xaHTNDD");
			
			String moTaHTNDD= request.getParameter("moTaHTNDD");
			
			
			//Ko validator
			String dienThoaiNDD = request.getParameter("dienThoaiNDD");
			String faxNDD = request.getParameter("faxNDD");
			String emailNDD = request.getParameter("emailNDD");
			String websiteNDD = request.getParameter("websiteNDD");
			//End
			
			
			
			//Thông tin kinh doanh hộ cá thể
			String tenHoCaThe= request.getParameter("tenHoCaThe");			
			
			String maGiayPhep= request.getParameter("maGiayPhep");
			
			String tinhId = request.getParameter("tinhId");
			
			String huyenId= request.getParameter("huyenId");			
			
			String xaId= request.getParameter("xaId");
			
			String chiTietDiaDiem= request.getParameter("chiTietDiaDiem");
			
			String maSoThue= request.getParameter("maSoThue");
			
			String ngayDangKy= request.getParameter("ngayDangKy");
			
			String vonKinhDoanh= request.getParameter("vonKinhDoanh");
			
			String dienThoai= request.getParameter("dienThoai");
						
			//Ko validator

			String fax= request.getParameter("fax");
			String email= request.getParameter("email");
			String website= request.getParameter("website");
			//end
			
			String moTaNgheNghiep= request.getParameter("moTaNgheNghiep");
			
			String[] nganhNgheDuocChon=ParamUtil.getParameterValues(request,"nganhNgheDuocChon"); 
			
			
			//String[] loaiHinhId = request.getParameterValues("loaiHinhId");		
			
			
			// Check email dang nhap
			/*if (Validator.isNull(emailDN) ||  emailDN.trim().length() == 0) {
				SessionErrors.add(request, "emptyMailDangNhap");
			}else */
			if(emailDN.trim().length() > 50){ //toi da 50 ky tu
				SessionErrors.add(request, "errorMaxLengMailDangNhap");
			}
			
			if (!Validator.isEmailAddress(emailDN)) {				
				SessionErrors.add(request, "errorMailKhongDungDinhDang");
			}
			
			if (  mode == 0 && emailExists(emailDN)) {
				SessionErrors.add(request, "errorEmailDaTonTai");
			}
			
			/*if (mode == 1) {
				if(emailExists(emailDN))
				SessionErrors.add(request, "errorEmailDaTonTai");
			}*/
			
			
			if (Validator.isNull(hoTenNDD) ||  hoTenNDD.trim().length() == 0) {
				SessionErrors.add(request, "emptyhoTenNDD");
			}
			
			if (Validator.isNull(ngaySinhNDD)) {
				SessionErrors.add(request, "emptyngaySinhNDD");
			}
			
			int gioiTinhIdNDD = Integer.parseInt(gioiTinhNDD.trim());
			if (gioiTinhIdNDD ==0) {
				SessionErrors.add(request, "emptygioiTinhNDD");
			}
			
			int quocTichIdNDD = Integer.parseInt(quocTichNDD.trim());
			if (quocTichIdNDD ==0) {
				SessionErrors.add(request, "emptyquocTichNDD");
			}
			
			int danTocIdNDD = Integer.parseInt(danTocNDD.trim());
			if (danTocIdNDD ==0) {
				SessionErrors.add(request, "emptydanTocNDD");
			}
			
						
			if (soCMNDNDD.trim().length() > 0) {

				
				if (!Validator.isNumber(soCMNDNDD.trim())){
					SessionErrors.add(request, "cmndNotNumber");
				}else if(soCMNDNDD.trim().length() > 12){
					SessionErrors.add(request, "cmndOverLimit");
				}else{
				
					long cmnd = Long.parseLong(soCMNDNDD.trim());
					if (cmnd <= 0) {
						SessionErrors.add(request, "errorsoCMNDNDD");
					} else if (soCMNDNDD.trim().length() != 9 && soCMNDNDD.trim().length() != 12) {
						SessionErrors.add(request, "errorsoCMNDNDD9or12");
					}
				}
				
				
			} else {
				SessionErrors.add(request, "emptysoCMNDNDD");
			}
			
			
			
			
			
			
			
			
			if (Validator.isNull(ngayCapCMNDNDD)) {
				SessionErrors.add(request, "emptyngayCapCMNDNDD");
			}
			
			
			int noiCapCMNDNDDId = Integer.parseInt(noiCapCMNDNDD.trim());
			if (noiCapCMNDNDDId == 0) {
				SessionErrors.add(request, "emptynoiCapCMNDNDD");
			}
			
			
			int tinhTTIdNDD = Integer.parseInt(tinhTTNDD.trim());
			if (tinhTTIdNDD ==0) {
				SessionErrors.add(request, "emptytinhTTIdNDD");
			}
			
			int huyenTTIdNDD = Integer.parseInt(huyenTTNDD.trim());
			if (huyenTTIdNDD ==0) {
				SessionErrors.add(request, "emptyhuyenTTIdNDD");
			}
			
			int xaTTIdNDD = Integer.parseInt(xaTTNDD.trim());
			if (xaTTIdNDD ==0) {
				SessionErrors.add(request, "emptyxaTTIdNDD");
			}
			
			if (Validator.isNull(moTaTTNDD) || moTaTTNDD.trim().length() == 0) {
				SessionErrors.add(request, "emptymoTaTTNDD");
			}else if(moTaTTNDD.trim().length() >100){//toi da 100 ky tu
				SessionErrors.add(request, "errorMaxLengmoTaTTNDD");
			}
			
			
			
			
			int tinhHTIdNDD = Integer.parseInt(tinhHTNDD.trim());
			if (tinhHTIdNDD ==0) {
				SessionErrors.add(request, "emptytinhHTIdNDD");
			}
			
			int huyenHTIdNDD = Integer.parseInt(huyenHTNDD.trim());
			if (huyenHTIdNDD ==0) {
				SessionErrors.add(request, "emptyhuyenHTIdNDD");
			}
			
			int xaHTIdNDD = Integer.parseInt(xaHTNDD.trim());
			if (xaHTIdNDD ==0) {
				SessionErrors.add(request, "emptyxaHTIdNDD");
			}
			
			if (Validator.isNull(moTaHTNDD) || moTaHTNDD.trim().length() == 0) {
				SessionErrors.add(request, "emptymoTaHTNDD");
			}else if(moTaHTNDD.trim().length() >100){//toi da 100 ky tu
				SessionErrors.add(request, "errorMaxLengmoTaHTNDD");
			}
			
			
			
			
			
			if(dienThoaiNDD.trim().length() >15){//toi da 15 ky tu
				SessionErrors.add(request, "errorMaxLengdienThoaiNDD");
			}else if(!Validator.isNumber(dienThoaiNDD.trim())){
				SessionErrors.add(request, "errorNumberdienThoaiNDD");
			}
			
			if(faxNDD.trim().length() >15){//toi da 15 ky tu
				SessionErrors.add(request, "errorMaxLengfaxNDD");
			}else if(!Validator.isNumber(faxNDD.trim())){
				SessionErrors.add(request, "errorNumberFax");
			}
			
			if(emailNDD.trim().length() >50){//toi da 50 ky tu
				SessionErrors.add(request, "errorMaxLengemailNDD");
			}
			
			if(websiteNDD.trim().length() >100){//toi da 100 ky tu
				SessionErrors.add(request, "errorMaxLengwebsiteNDD");
			}
			
			
			
			

			if (Validator.isNull(tenHoCaThe) || tenHoCaThe.trim().length() ==0) {
				SessionErrors.add(request, "emptytenHoCaThe");
			}else if(tenHoCaThe.trim().length() >200){//toi da 200 ky tu
				SessionErrors.add(request, "errorMaxLengtenHoCaThe");
			}
			
			
			if (Validator.isNull(maGiayPhep) || maGiayPhep.trim().length() ==0) {
				SessionErrors.add(request, "emptymaGiayPhep");
			}else if(maGiayPhep.trim().length() >20){//toi da 20 ky tu
				SessionErrors.add(request, "errorMaxLengmaGiayPhep");
			}
			

			int tinhIdHCT = Integer.parseInt(tinhId.trim());
			if (tinhIdHCT ==0) {
				SessionErrors.add(request, "emptytinhId");
			}
			
			int huyenHCT = Integer.parseInt(huyenId.trim());
			if (huyenHCT ==0) {
				SessionErrors.add(request, "emptyhuyenId");
			}
			
			int xaHCT = Integer.parseInt(xaId.trim());
			if (xaHCT ==0) {
				SessionErrors.add(request, "emptyxaId");
			}
			

			if (Validator.isNull(chiTietDiaDiem) || chiTietDiaDiem.trim().length() ==0) {
				SessionErrors.add(request, "emptychiTietDiaDiem");
			}else if(chiTietDiaDiem.trim().length() >200){//toi da 200 ky tu
				SessionErrors.add(request, "errorMaxLengchiTietDiaDiem");
			}
			
			
			if (Validator.isNull(maSoThue) || maSoThue.trim().length() ==0) {
				SessionErrors.add(request, "emptymaSoThue");
			}else if(maSoThue.trim().length() >20){//toi da 20 ky tu
				SessionErrors.add(request, "errorMaxLengmaSoThue");
			}
			
			
			if (Validator.isNull(ngayDangKy)) {
				SessionErrors.add(request, "emptyngayDangKy");
			}
			
						
			if (Validator.isNotNull(vonKinhDoanh)) {
				
				String temp = vonKinhDoanh.replaceAll(",", "");
				double vonThucHien = Double.parseDouble(temp);
				if(vonThucHien ==0f)
					SessionErrors.add(request, "emptyVon");
				else if(!ValidateVon(vonKinhDoanh)){
					SessionErrors.add(request, "errorVon");
				}				
				
			}else
				SessionErrors.add(request, "emptyVon");
			

			if (Validator.isNull(dienThoai) || dienThoai.trim().length() ==0) {
				SessionErrors.add(request, "emptydienThoai");
			}else if(dienThoai.trim().length() >15){//toi da 15 ky tu
				SessionErrors.add(request, "errorMaxLengdienThoai");
			}
			
			
			if(fax.trim().length() >15){//toi da 15 ky tu
				SessionErrors.add(request, "errorMaxfax");
			}
			
			if(email.trim().length() >50){//toi da 50 ky tu
				SessionErrors.add(request, "errorMaxemail");
			}
			
			if(website.trim().length() >100){//toi da 100 ky tu
				SessionErrors.add(request, "errorMaxwebsite");
			}
			
			
			
			if (Validator.isNull(moTaNgheNghiep)) {
				SessionErrors.add(request, "emptymoTaNgheNghiep");
			}			
			
			
			
			if (nganhNgheDuocChon.length == 0) {
				SessionErrors.add(request, "emptyngheDuocChon");				
			}
			
			
			
			
			if (SessionErrors.isEmpty(request)) {
				return true;
			}

			return false;
		}
		
		public static boolean emailExists( String email){
			try{
			if (Validator.isNull(email)) {
				return false;
			}
			
			// Query all cong dan with email
			List<TaiKhoanNguoiDung> taiKhoanLst = TaiKhoanNguoiDungLocalServiceUtil.findByEmail(email);
			
			// Get the first one
			if ( taiKhoanLst.size() < 1) {
				return false;
			}
			
			TaiKhoanNguoiDung taiKhoanNguoiDung = taiKhoanLst.get(0);		
			
			// Check if email exists
			if ( email.equals(taiKhoanNguoiDung.getEmail()) || (taiKhoanNguoiDung.getDaXoa() == FormatUtil.DA_XOA_DEACTIVATE)) {		
				
				// Check if email is owned by another person or not			
					return true;			
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			return false;		
		}
		
		public  String congdanExists(String soCmnd, String ngaySinh) throws ParseException{
			
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			Date birthDay = ConvertUtil.parseStringToDate(ngaySinh);
			
			// Check in database if there's existing person with the same birth day and province code
			DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);
			queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
			queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("soCmnd").eq(soCmnd));
			List<CongDan> results = null;
			
			try {
				results = CongDanLocalServiceUtil.dynamicQuery(queryCongDan);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			if ( results == null ||  results.size() < 1) {
				return StringPool.BLANK;
			}
			
			// Return the id
			return (results.get(0)).getMa();
		}
		
		public static boolean ValidateVon(String param) {
			if (param == null || param.isEmpty()) {
				return false;
			}
			String temp = param.trim();
			temp=temp.replaceAll(",","");			
			if(com.liferay.portal.kernel.util.Validator.isNumber(temp)) {
				return true;
			}
			return false;
		}

		public static boolean validThanhVienSangLap(ActionRequest request) {
			
			String hoTenNDD = request.getParameter("tvslTen");

			String ngaySinhNDD = request.getParameter("tvslNgaySinh");

			String soCMNDNDD = request.getParameter("tvslSoCMND");

			String ngayCapCMNDNDD = request.getParameter("tvslNgayCapCMND");

			String noiCapCMNDNDD = request.getParameter("tvslNoiCapCMND");

			// Dia chi thuong tru
			String tinhTTNDD = request.getParameter("tvslTtTinhId");

			String huyenTTNDD = request.getParameter("tvslTtHuyenId");

			String xaTTNDD = request.getParameter("tvslTtXaId");

			String moTaTTNDD = request.getParameter("tvslTtMoTaDiaChi");

			// Dia chi hien tai

			String tinhHTNDD = request.getParameter("tvslCohtTinhId");

			String huyenHTNDD = request.getParameter("tvslCohtHuyenId");

			String xaHTNDD = request.getParameter("tvslCohtXaId");

			String moTaHTNDD = request.getParameter("tvslCohtMoTaChoO");

			String tvslGiaTri = request.getParameter("tvslGiaTri");
			String tvslTyLe = request.getParameter("tvslTyLe");
			String tvslLoaiTaiSan = request.getParameter("tvslLoaiTaiSan");
			String tvslNgayGopVon = request.getParameter("tvslNgayGopVon");
			String tvslGhiChu = request.getParameter("tvslGhiChu");

			if (Validator.isNull(hoTenNDD) || hoTenNDD.trim().length() == 0) {
				SessionErrors.add(request, "emptyhoTenNDD");
			}else if (hoTenNDD.trim().length() > 100) {// toi da 100 ky tu
				SessionErrors.add(request, "errorMaxLengTenNDD");
			}

			if (Validator.isNull(ngaySinhNDD)) {
				SessionErrors.add(request, "emptyngaySinhNDD");
			}

			if (soCMNDNDD.trim().length() > 0) {
	
				if (!Validator.isNumber(soCMNDNDD.trim())) {
					SessionErrors.add(request, "cmndNotNumber");
				} else if (soCMNDNDD.trim().length() > 12) {
					SessionErrors.add(request, "cmndOverLimit");
				} else {
	
					long cmnd = Long.parseLong(soCMNDNDD.trim());
					if (cmnd <= 0) {
						SessionErrors.add(request, "errorsoCMNDNDD");
					} else if (soCMNDNDD.trim().length() != 9
							&& soCMNDNDD.trim().length() != 12) {
						SessionErrors.add(request, "errorsoCMNDNDD9or12");
					}
				}
	
			} else {
				SessionErrors.add(request, "emptysoCMNDNDD");
			}

			
			if (Validator.isNull(ngayCapCMNDNDD)) {
				SessionErrors.add(request, "emptyngayCapCMNDNDD");
			}

			
			int noiCapCMNDNDDId = Integer.parseInt(noiCapCMNDNDD.trim());
			if (noiCapCMNDNDDId == 0) {
				SessionErrors.add(request, "emptynoiCapCMNDNDD");
			}
			
			
			

			int tinhTTIdNDD = Integer.parseInt(tinhTTNDD.trim());
			if (tinhTTIdNDD == 0) {
				SessionErrors.add(request, "emptytinhTTIdNDD");
			}

			int huyenTTIdNDD = Integer.parseInt(huyenTTNDD.trim());
			if (huyenTTIdNDD == 0) {
				SessionErrors.add(request, "emptyhuyenTTIdNDD");
			}

			int xaTTIdNDD = Integer.parseInt(xaTTNDD.trim());
			if (xaTTIdNDD == 0) {
				SessionErrors.add(request, "emptyxaTTIdNDD");
			}

			if (Validator.isNull(moTaTTNDD) || moTaTTNDD.trim().length() == 0) {
				SessionErrors.add(request, "emptymoTaTTNDD");
			} else if (moTaTTNDD.trim().length() > 100) {// toi da 100 ky tu
				SessionErrors.add(request, "errorMaxLengmoTaTTNDD");
			}

			int tinhHTIdNDD = Integer.parseInt(tinhHTNDD.trim());
			if (tinhHTIdNDD == 0) {
				SessionErrors.add(request, "emptytinhHTIdNDD");
			}

			int huyenHTIdNDD = Integer.parseInt(huyenHTNDD.trim());
			if (huyenHTIdNDD == 0) {
				SessionErrors.add(request, "emptyhuyenHTIdNDD");
			}

			int xaHTIdNDD = Integer.parseInt(xaHTNDD.trim());
			if (xaHTIdNDD == 0) {
				SessionErrors.add(request, "emptyxaHTIdNDD");
			}

			if (Validator.isNull(moTaHTNDD) || moTaHTNDD.trim().length() == 0) {
				SessionErrors.add(request, "emptymoTaHTNDD");
			} else if (moTaHTNDD.trim().length() > 100) {// toi da 100 ky tu
				SessionErrors.add(request, "errorMaxLengmoTaHTNDD");
			}
			
			if (Validator.isNull(tvslGiaTri) || tvslGiaTri.trim().length() == 0) {
				SessionErrors.add(request, "emptyGiaTri");
			}else if(!Validator.isNumber(tvslGiaTri)) {
				SessionErrors.add(request, "notNumberGiaTri");
			}
			
			if (Validator.isNull(tvslTyLe) || tvslTyLe.trim().length() == 0) {
				SessionErrors.add(request, "emptyTyLe");
			}else {
				if (tvslTyLe.trim().length() > 5) {// toi da 15 ky tu
					SessionErrors.add(request, "errorMaxLengTyLe");
				}
				if(!Validator.isNumber(tvslTyLe)) {
					SessionErrors.add(request, "notNumberTyLe");
				}
			}

			if (Validator.isNull(tvslLoaiTaiSan) || tvslLoaiTaiSan.trim().length() == 0) {
				SessionErrors.add(request, "emptyLoaiTaiSan");
			}else if (tvslLoaiTaiSan.trim().length() > 200) {// toi da 50 ky tu
				SessionErrors.add(request, "errorMaxLengLoaiTaiSan");
			}
			
			if (Validator.isNull(tvslNgayGopVon) || tvslNgayGopVon.trim().length() == 0) {// toi da 100 ky tu
				SessionErrors.add(request, "emptyNgayGopVon");
			}
			
			if (Validator.isNotNull(tvslGhiChu)) {
				if(tvslGhiChu.trim().length() > 255){
					SessionErrors.add(request, "errorMaxLengLoaiTaiSan");
				}
			}

			if (SessionErrors.isEmpty(request)) {
				return true;
			}

			return false;
		}

}
