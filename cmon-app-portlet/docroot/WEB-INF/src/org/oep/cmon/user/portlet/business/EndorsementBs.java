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

package org.oep.cmon.user.portlet.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.portlet.ActionRequest;

import org.oep.cmon.admin.portlet.util.EncryptionUtil;
import org.oep.cmon.user.portlet.ldap.LDAP;
import org.oep.cmon.user.portlet.mail.UserCreationMail;
import org.oep.cmon.user.portlet.util.ElectricCodeGeneratorUtil;
import org.oep.cmon.user.portlet.util.StringUtil;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.model.CongDanClp;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;
import org.oep.cmon.dao.csms.service.YeuCauDangKyCongDanLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungClp;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import vn.dtt.cmon.mail.MailContext;
import vn.dtt.cmon.mail.MailTemplateUtil;
import vn.dtt.cmon.mail.SendMailUtil;
import vn.dtt.sharedservice.WebserviceFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/** 
 * This is class CitizenUserBs
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class EndorsementBs {
	
	/** Citizen sequence */
	public static final String CITIZEN_SEQUENCE = "csms_congdan";
	
	private static final String MAIL_TEMPLATE_HUY = "vn/dtt/cmon/user/portlet/mail/user_cancel_mail.template";
	private static final String MAIL_CONFIG_HUY = "vn/dtt/cmon/user/portlet/mail/mail_cancel_config.properties";
	
	/** Tai khoan nguoi dung sequence */
	public static final String TAIKHOANNGUOIDUNG_SEQUENCE = "cmon_taikhoannguoidung";
	
	/** Birth date format */
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	private ActionRequest actionRequest = null;
	
	/**
	 * Constructor
	 * 
	 * @param actionRequest
	 */
	public EndorsementBs(ActionRequest actionRequest) {
		this.actionRequest = actionRequest;
	}

	/**
	 * This is function create tai khoan nguoi dung on cmon_taikhoannguoidung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param portalUserId
	 * @param fullname
	 * @param email
	 * @param password
	 * @throws Exception
	 */
	public long createTaiKhoan(long portalUserId, String fullName, String email, String password) throws Exception {
			
		// Check if login name exists
		TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTenDangNhap(email);
		String maOrg = WebserviceFactory.getThamSoService().getValue("CMON_CONG_DAN_ORGANIZATION_ID");
		if (maOrg.length() == 0) {
			maOrg = "CD";
		}
		DoiTuongSuDung doiTuong = DoiTuongSuDungLocalServiceUtil.findByMa(maOrg);
		if ( taiKhoan != null ) {
			// Incase taikhoan exists, only update the password and name
			taiKhoan.setTenNguoiDung(fullName);
			
			// update password
			String encryptedPassword = EncryptionUtil.encrypt(password);
			taiKhoan.setMatKhau(encryptedPassword);
			
			// Update loai doi tuong
			taiKhoan.setLoaiDoiTuongId(doiTuong.getId());
			
			// Update the link to liferay user id
			taiKhoan.setTaiKhoanNguoiDungId(portalUserId);
			
			// Update to DB
			TaiKhoanNguoiDungLocalServiceUtil.updateTaiKhoanNguoiDung(taiKhoan);
			
			return taiKhoan.getId();			
		}
		
		// Insert nguoi dung here
		taiKhoan = new TaiKhoanNguoiDungClp();
		
		taiKhoan.setId(CounterLocalServiceUtil.increment(TAIKHOANNGUOIDUNG_SEQUENCE));	
		
		taiKhoan.setTenDangNhap(email);		
		
		// Encrypt the password
		String encryptedPassword = EncryptionUtil.encrypt(password);
		
		taiKhoan.setMatKhau(encryptedPassword);
		
		taiKhoan.setTenNguoiDung(fullName);
		
		taiKhoan.setEmail(email);
		
		taiKhoan.setTrangThai(1);// 1: active
		
		taiKhoan.setLoaiDoiTuongId(doiTuong.getId());
		
		taiKhoan.setTaiKhoanNguoiDungId(portalUserId);
		
		// Common columns
		Date currentDate = new Date();

		taiKhoan.setNgayTao(currentDate);

		
		taiKhoan.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(this.actionRequest);
		
		if ( currentUser != null) {
			taiKhoan.setNguoiTao(currentUser.getEmailAddress());
			
			taiKhoan.setNguoiSua(currentUser.getEmailAddress());			
		} else {
			// This is for test without logging in		
			taiKhoan.setNguoiTao("DUMMY");
			
			taiKhoan.setNguoiSua("DUMMY");	
		}
		
		taiKhoan.setDaXoa(0); // Un deleted
		
		return TaiKhoanNguoiDungLocalServiceUtil.addTaiKhoanNguoiDung(taiKhoan).getId();
	}
	
	/**
	 * This is function create user on LDAP server
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param fullname
	 * @param email
	 * @param password
	 */
	public boolean createLDAPEntry( String fullName, String email, String password) {
		try{			
			LDAP ldap = new LDAP();
			
			if ( ldap.isExist(email) ){
				ldap.delete(email);
			}
			
			ldap.addEntry(email, password, fullName);
			
		} catch (Exception e){
			// Print out error stack
			e.printStackTrace();		
			return false;			
		}
		return true;
	}
	
	/**
	 * This is function send email
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param fullname
	 * @param email
	 * @param password
	 * @param url
	 * @param actionRequest
	 * @throws IOException
	 */
	public void sendEmail( String fullName, String email, String password, String url, ActionRequest actionRequest) throws IOException {
		// Send email
		UserCreationMail mail = new UserCreationMail();
		
		mail.setEmail(email);
		mail.setFullName(fullName);
		
		// We use email as login name as well
		mail.setUserName(email);
		mail.setPassword(password);
		mail.setUrl(url);
		// Send the email
		mail.send(actionRequest);
	}
	
	/**
	 * This is function send email destroy registration
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param fullname
	 * @param email
	 * @param password
	 * @param url
	 * @param actionRequest
	 * @throws IOException
	 */
	public void sendEmailHuyDK( String fullName, String email, String url, ActionRequest actionRequest) throws IOException {
		// Get Mail template content
		URL resource = this.getClass().getClassLoader().getResource(MAIL_TEMPLATE_HUY);   
		MailContext context = new MailContext();                  
		context.setProperty("citizen_name", fullName);
		context.setProperty("url", url);
		try{
            String mailContent = MailTemplateUtil.getContent("user_cancel_mail_template", resource.openStream(), context);
    		URL configResource = this.getClass().getClassLoader().getResource(MAIL_CONFIG_HUY);			
    		Properties props = new Properties();
    		BufferedReader file = new BufferedReader(new InputStreamReader(configResource.openStream(), "utf-8"));
    		props.load(file);
    		
    		String mailSubject = props.getProperty("MAIL_SUBJECT_USER_CREATION");
    		//String fromAddress = props.getProperty("FROM_ADDRESS");
    		//String fromPerson = props.getProperty("FROM_PERSON");
    		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
    		//String fromPerson = props.getProperty("FROM_PERSON");
    		String fromPerson = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),PropsKeys.ADMIN_EMAIL_FROM_NAME);
    		
            SendMailUtil.send(email, fromAddress, fromPerson, mailSubject, mailContent);

		} catch (Exception e) {
            e.printStackTrace();
		}
	}
	
	/**
	 * This is function createCitizen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param yeuCau
	 * @param userId
	 * @param request
	 * @throws SystemException
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @return long
	 */
	public long createCitizen(YeuCauDangKyCongDan yeuCau, long userId, String maCongDan) throws SystemException, NumberFormatException, PortalException {
		CongDan congDan = null;		
		// Check if the citizen exists or not
		if (Validator.isNotNull(maCongDan)) {
			congDan = CongDanLocalServiceUtil.findByMa(maCongDan);
			
			if ( congDan != null) {
				
				// update tai khoan nguoi dung id
				congDan.setTaiKhoanNguoiDungId(userId);
				
				//Update
				CongDanLocalServiceUtil.updateCongDan(congDan);
				
				return congDan.getId();				
				
			}
		}
		
		congDan = new CongDanClp();
		
		long id = CounterLocalServiceUtil.increment(CITIZEN_SEQUENCE);
		
		congDan.setId( id );
		
		congDan.setMa( ElectricCodeGeneratorUtil.generateCode(yeuCau.getIDTinhThanhThuongTru(), yeuCau.getNgaySinh()));	
		
		congDan.setHo(yeuCau.getHoCongDan());
		
		congDan.setDem( yeuCau.getTenDem());
		
		congDan.setTen(yeuCau.getTenCongDan());
		
		congDan.setTenDayDu(yeuCau.getHoCongDan() + StringPool.SPACE +yeuCau.getTenDem() + StringPool.SPACE + yeuCau.getTenCongDan());
		
		congDan.setNgaySinh(yeuCau.getNgaySinh());
		
		congDan.setSoCmnd(yeuCau.getSoCmnd());
		
		congDan.setNgayCapCmnd(yeuCau.getNgayCapCmnd());
		
		congDan.setGhiChuCmnd(yeuCau.getGhiChuCmnd());
		
		congDan.setSoHoChieu(yeuCau.getSoHoChieu());
		
		congDan.setNgayCapHoChieu(yeuCau.getNgayCapHoChieu());
		
		congDan.setNgayHetHanHoChieu(yeuCau.getNgayHetHanHoChieu());
		
		congDan.setGhiChuHoChieu(yeuCau.getGhiChuHoChieu());
		
		congDan.setSoBaoHiemYTe(yeuCau.getSoBaoHiemYte());
		
		congDan.setMaSoThueCaNhan(yeuCau.getMaSoThueCaNhan());
		
		congDan.setDiaChiThuongTru(yeuCau.getMoTaDiaChiThuongTru());
		
		congDan.setDiaChiHienNay(yeuCau.getMoTaDiaChiHienTai());
		
		congDan.setDienThoaiCoDinh(yeuCau.getDienThoaiCoDinh());
		
		congDan.setDienThoaiDiDong(yeuCau.getDienThoaiDiDong());
		
//		congDan.setHoTenCha(yeuCau.getHoVaTenCha());
//		
//		congDan.setHoTenMe(yeuCau.getHoVaTenMe());
//		
//		congDan.setHoTenVoHoacChong(yeuCau.getHoVaTenVoChong());
		
		congDan.setSoHoKhau(yeuCau.getSoHoKhau());
		
		congDan.setLaChuHo(yeuCau.getChuHo());
		
		congDan.setEmail(yeuCau.getEmail());
		
		if (yeuCau.getIDDanToc() != null && yeuCau.getIDDanToc() > 0)
			congDan.setDanTocId(yeuCau.getIDDanToc());
		if (yeuCau.getIDPhuongXaHienTai() != null && yeuCau.getIDPhuongXaHienTai() > 0)
		congDan.setDiaChiHienNayXaId(yeuCau.getIDPhuongXaHienTai());
		if (yeuCau.getIDQuanHuyenHienTai() != null && yeuCau.getIDQuanHuyenHienTai() > 0)
		congDan.setDiaChiHienNayHuyenId(yeuCau.getIDQuanHuyenHienTai());
		if (yeuCau.getIDTinhThanhHienTai() != null && yeuCau.getIDTinhThanhHienTai() > 0)
		congDan.setDiaChiHienNayTinhId(yeuCau.getIDTinhThanhHienTai());
		if (yeuCau.getIDQuanHuyenThuongTru() != null && yeuCau.getIDQuanHuyenThuongTru() > 0)
		congDan.setDiaChiThuongTruHuyenId(yeuCau.getIDQuanHuyenThuongTru());
		if (yeuCau.getIDPhuongXaThuongTru() != null && yeuCau.getIDPhuongXaThuongTru() > 0)
		congDan.setDiaChiThuongTruXaId(yeuCau.getIDPhuongXaThuongTru());
		if (yeuCau.getIDTinhThanhThuongTru() != null && yeuCau.getIDTinhThanhThuongTru() > 0)
		congDan.setDiaChiThuongTruTinhId(yeuCau.getIDTinhThanhThuongTru());
		congDan.setGioiTinh(yeuCau.getGioiTinh());
		if (yeuCau.getIDNgheNghiep() != null && yeuCau.getIDNgheNghiep() > 0)
		congDan.setNgheNghiepId(yeuCau.getIDNgheNghiep());
		if (yeuCau.getIDNoiCapCmnd() != null && yeuCau.getIDNoiCapCmnd() > 0)
		congDan.setNoiCapCmndId(yeuCau.getIDNoiCapCmnd());
		if (yeuCau.getIDNoiCapHoChieu() != null && yeuCau.getIDNoiCapHoChieu() > 0)
		congDan.setNoiCapHoChieuId(yeuCau.getIDNoiCapHoChieu());
		if (yeuCau.getIDTinhThanhNoiSinh() != null && yeuCau.getIDTinhThanhNoiSinh() > 0)
		congDan.setNoiSinhTinhId(yeuCau.getIDTinhThanhNoiSinh());
		if (yeuCau.getIDPhuongXaNoiSinh() != null && yeuCau.getIDPhuongXaNoiSinh() > 0)
		congDan.setNoiSinhXaId(yeuCau.getIDPhuongXaNoiSinh());
		if (yeuCau.getIDQuanHuyenNoiSinh() != null && yeuCau.getIDQuanHuyenNoiSinh() > 0)
		congDan.setNoiSinhHuyenId(yeuCau.getIDQuanHuyenNoiSinh());
		
		congDan.setNoiSinhChiTiet(yeuCau.getMoTaDiaChiNoiSinh());
		if (yeuCau.getIDQuanHe() != null && yeuCau.getIDQuanHe() > 0)
		congDan.setQuanHeChuHoId(yeuCau.getIDQuanHe());
		if (yeuCau.getIDQuocTich() != null && yeuCau.getIDQuocTich() > 0) {
			congDan.setQuocTichId(yeuCau.getIDQuocTich());
		} else {
			String idStr = WebserviceFactory.getThamSoService().getValue("VIETNAM");
			
			if (Validator.isNotNull(idStr)) {
				try {
					congDan.setQuocTichId(Long.parseLong(idStr));
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		congDan.setTaiKhoanNguoiDungId(userId);	
		
		if (yeuCau.getTinhTrangHonNhan() != null && yeuCau.getTinhTrangHonNhan() > 0)
			congDan.setTinhTrangHonNhanId(yeuCau.getTinhTrangHonNhan());
		
		try {
			congDan.setTonGiaoId(yeuCau.getIDTonGiao());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (yeuCau.getIDTrinhDoChuyenMon() != null && yeuCau.getIDTrinhDoChuyenMon() > 0)
		congDan.setTrinhDoChuyenMonId(yeuCau.getIDTrinhDoChuyenMon());
		if (yeuCau.getIDTrinhDoHocVan() != null && yeuCau.getIDTrinhDoHocVan() > 0)
		congDan.setTrinhDoHocVanId(yeuCau.getIDTrinhDoHocVan());
		
		Date currentDate = new Date();		
	
		congDan.setNgayTao(currentDate);
		
		congDan.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(this.actionRequest);
		
		if ( currentUser != null) {		
			// Nguoi chung thuc
			congDan.setNguoiTao(currentUser.getEmailAddress());
			congDan.setNguoiSua(currentUser.getEmailAddress());			
		} else {
			congDan.setNguoiTao("DUMMY");
			congDan.setNguoiSua("DUMMY");	
		}
		
		congDan.setDaXoa(0);
		
		CongDanLocalServiceUtil.addCongDan(congDan);
		
		/*
		byte[] avatar = (byte[])this.actionRequest.getPortletSession().getAttribute("PROFILE_PIC");
		
		if ( avatar != null && avatar.length > 0 ){
			// Update avatar
			AnhCongDan anhChanDung = AnhCongDanLocalServiceUtil.getAnhCongDan(id);
			
			anhChanDung.setAnh(avatar);
			
			AnhCongDanLocalServiceUtil.updateAnhCongDan(anhChanDung);
		}
		*/
		return congDan.getId();		
	}
	

	/**
	 * This is function create portal user
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param yeuCau
	 * @param userId
	 * @param password
	 * @throws SystemException
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @return long
	 */
	public long createPortalCitizenUser( YeuCauDangKyCongDan yeuCau, String password ) throws SystemException, PortalException, IOException {
		// Create portal user
		CitizenUserBs user = new CitizenUserBs();
		
		// Full name
		user.setFullName( yeuCau.getHoCongDan() + StringPool.SPACE + yeuCau.getTenDem() + StringPool.SPACE + yeuCau.getTenCongDan());
		
		// Email
		user.setEmail( yeuCau.getEmail() );
		
		// Anh chan dung
		byte[] avatar = (byte[])actionRequest.getPortletSession().getAttribute("PROFILE_PIC");
		
		if ( avatar != null && avatar.length > 0 ){
			user.setAvatar(avatar);
		}
		
		// Ngay sinh
		user.setBirthDate(yeuCau.getNgaySinh());
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// Create portal user
		return user.createCitizenUser(password, themeDisplay, yeuCau);
	}
	
	/**
	 * This is function update user request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param userRequest
	 * @throws SystemException
	 * @throws NumberFormatException
	 * @throws ParseException
	 * @throws PortalException
	 * @return long
	 */
	public YeuCauDangKyCongDan updateUserRequest( Map <String, String> userRequest ) throws PortalException, SystemException, ParseException {
		
		// Get the request id from URL parameter
		long reqId = Long.parseLong(userRequest.get("ID"));
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setLenient(false);
		
		// Get record from DB
		YeuCauDangKyCongDan yeuCau = YeuCauDangKyCongDanLocalServiceUtil.getYeuCauDangKyCongDan(reqId);
		
		String ho = userRequest.get("HOCONGDAN");
		yeuCau.setHoCongDan(ho);
		
		String tenDem = userRequest.get("TENDEM");
		yeuCau.setTenDem(tenDem);
		
		String ten = userRequest.get("TENCONGDAN");
		yeuCau.setTenCongDan(ten);
		
		StringBuilder fullName = new StringBuilder();
		fullName.append(ho);
		if (!Validator.isNull(tenDem)) {
			if (fullName.length() > 0) {
				fullName.append(" ");
			}
			fullName.append(tenDem);
		}
		if (!Validator.isNull(ten)) {
			if (fullName.length() > 0) {
				fullName.append(" ");
			}
			fullName.append(ten);
		}
		yeuCau.setHoVaTen(fullName.toString());
		
		yeuCau.setSoCmnd(userRequest.get("SOCMND"));
		
		if (Validator.isNotNull(userRequest.get("NGAYCAPCMND")))
			yeuCau.setNgayCapCmnd(df.parse(userRequest.get("NGAYCAPCMND")));
		
		if (Validator.isNotNull(userRequest.get("IDNOICAPCMND")))
		yeuCau.setIDNoiCapCmnd(Long.parseLong(userRequest.get("IDNOICAPCMND")));
		
		yeuCau.setGhiChuCmnd(userRequest.get("GHICHUCMND"));
		
		yeuCau.setEmail(userRequest.get("EMAIL"));
		
		yeuCau.setSoHoChieu(userRequest.get("SOHOCHIEU"));
		
		if ( Validator.isNotNull(userRequest.get("NGAYCAPHOCHIEU"))) {
			yeuCau.setNgayCapHoChieu(df.parse(userRequest.get("NGAYCAPHOCHIEU")));
		}
		if (Validator.isNotNull(userRequest.get("IDNOICAPHOCHIEU")))
		yeuCau.setIDNoiCapHoChieu((Long.parseLong(userRequest.get("IDNOICAPHOCHIEU"))));
		
		if ( Validator.isNotNull(userRequest.get("NGAYHETHANHOCHIEU"))) {
			yeuCau.setNgayHetHanHoChieu(df.parse(userRequest.get("NGAYHETHANHOCHIEU")));
		}
		
		yeuCau.setGhiChuHoChieu(userRequest.get("GHICHUHOCHIEU"));
		if (Validator.isNotNull(userRequest.get("IDGIOITINH")))
		yeuCau.setGioiTinh(Integer.parseInt(userRequest.get("IDGIOITINH")));
		if (Validator.isNotNull(userRequest.get("IDDANTOC")))
		yeuCau.setIDDanToc(Long.parseLong(userRequest.get("IDDANTOC")));
		if (Validator.isNotNull(userRequest.get("IDTONGIAO")))
		yeuCau.setIDTonGiao(Long.parseLong(userRequest.get("IDTONGIAO")));
		if (Validator.isNotNull(userRequest.get("IDQUOCTICH")))
		yeuCau.setIDQuocTich(Long.parseLong(userRequest.get("IDQUOCTICH")));
		if (Validator.isNotNull(userRequest.get("NGAYSINH")))
		yeuCau.setNgaySinh(df.parse(userRequest.get("NGAYSINH")));
		
		yeuCau.setDienThoaiCoDinh(userRequest.get("DIENTHOAICODINH"));
		
		yeuCau.setDienThoaiDiDong(userRequest.get("DIENTHOAIDIDONG"));
		if (Validator.isNotNull(userRequest.get("IDTRINHDOHOCVAN")))
		yeuCau.setIDTrinhDoHocVan(Long.parseLong(userRequest.get("IDTRINHDOHOCVAN")));
		
		yeuCau.setSoBaoHiemYte(userRequest.get("SOBAOHIEMYTE"));
		
		yeuCau.setMaSoThueCaNhan(userRequest.get("MASOTHUECANHAN"));
		if (Validator.isNotNull(userRequest.get("IDNGHENGHIEP")))
		yeuCau.setIDNgheNghiep(Long.parseLong(userRequest.get("IDNGHENGHIEP")));
		if (Validator.isNotNull(userRequest.get("IDTRINHDOCHUYENMON")))
		yeuCau.setIDTrinhDoChuyenMon(Long.parseLong(userRequest.get("IDTRINHDOCHUYENMON")));
		if (Validator.isNotNull(userRequest.get("IDTINHTRANGHONNHAN")))
		yeuCau.setTinhTrangHonNhan(Long.parseLong(userRequest.get("IDTINHTRANGHONNHAN")));
		if (Validator.isNotNull(userRequest.get("IDTINHTHANHNOISINH")))
		yeuCau.setIDTinhThanhNoiSinh(Long.parseLong(userRequest.get("IDTINHTHANHNOISINH")));
		if (Validator.isNotNull(userRequest.get("IDQUANHUYENNOISINH")))
		yeuCau.setIDQuanHuyenNoiSinh(Long.parseLong(userRequest.get("IDQUANHUYENNOISINH")));
		if (Validator.isNotNull(userRequest.get("IDPHUONGXANOISINH")))
		yeuCau.setIDPhuongXaNoiSinh(Long.parseLong(userRequest.get("IDPHUONGXANOISINH")));
		
		yeuCau.setMoTaDiaChiNoiSinh(userRequest.get("MOTADIACHINOISINH"));
		if (Validator.isNotNull(userRequest.get("IDTINHTHANHTHUONGTRU")))
		yeuCau.setIDTinhThanhThuongTru(Long.parseLong(userRequest.get("IDTINHTHANHTHUONGTRU")));
		if (Validator.isNotNull(userRequest.get("IDQUANHUYENTHUONGTRU")))
		yeuCau.setIDQuanHuyenThuongTru(Long.parseLong(userRequest.get("IDQUANHUYENTHUONGTRU")));
		if (Validator.isNotNull(userRequest.get("IDPHUONGXATHUONGTRU")))
		yeuCau.setIDPhuongXaThuongTru(Long.parseLong(userRequest.get("IDPHUONGXATHUONGTRU")));
		
		yeuCau.setMoTaDiaChiThuongTru(userRequest.get("MOTADIACHITHUONGTRU"));
		if (Validator.isNotNull(userRequest.get("IDTINHTHANHHIENTAI")))
		yeuCau.setIDTinhThanhHienTai(Long.parseLong(userRequest.get("IDTINHTHANHHIENTAI")));
		if (Validator.isNotNull(userRequest.get("IDQUANHUYENHIENTAI")))
		yeuCau.setIDQuanHuyenHienTai(Long.parseLong(userRequest.get("IDQUANHUYENHIENTAI")));
		if (Validator.isNotNull(userRequest.get("IDPHUONGXAHIENTAI")))
		yeuCau.setIDPhuongXaHienTai(Long.parseLong(userRequest.get("IDPHUONGXAHIENTAI")));
		
		yeuCau.setMoTaDiaChiHienTai(userRequest.get("MOTADIACHIHIENTAI"));
		
		yeuCau.setHoVaTenCha(userRequest.get("HOVATENCHA"));
		
		yeuCau.setMaCongDanCha(userRequest.get("MACONGDANCHA"));
		
		yeuCau.setHoVaTenMe(userRequest.get("HOVATENME"));
		
		yeuCau.setMaCongDanMe(userRequest.get("MACONGDANME"));
		
		yeuCau.setHoVaTenVoChong(userRequest.get("HOVATENVOCHONG"));
		
		yeuCau.setMaCongDanVoChong(userRequest.get("MACONGDANVOCHONG"));
		
		yeuCau.setSoHoKhau(userRequest.get("SOHOKHAU"));
		if (Validator.isNotNull(userRequest.get("CHUHO")))
		yeuCau.setChuHo(Integer.parseInt(userRequest.get("CHUHO")));
		if (Validator.isNotNull(userRequest.get("IDQUANHE")))
		yeuCau.setIDQuanHe(Long.parseLong(userRequest.get("IDQUANHE")));
		
		yeuCau.setNgaySua(new Date());
		
		yeuCau.setTrangThaiYeuCau(StringUtil.TRANG_THAI_YEU_CAU_DK_CONG_DAN_DA_CHUNG_THUC); // Endorsed
		
		User currentUser = PortalUtil.getUser(actionRequest);
		
		if ( currentUser != null) {		
			yeuCau.setNguoiSua(currentUser.getEmailAddress());			
		}
		
		// Update picture
		/*
		byte[] imgBytes = (byte[])actionRequest.getPortletSession().getAttribute("PROFILE_PIC");
		
		AnhChanDungYeuCauDangKyCongDan anh = AnhChanDungYeuCauDangKyCongDanLocalServiceUtil.getAnhChanDungYeuCauDangKyCongDan(reqId);
		
		if ( imgBytes!=null && imgBytes.length > 0 ){
			anh.setAnhChanDung(imgBytes);
		}
		*/
		// Update data
		YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCau);		
		
		//AnhChanDungYeuCauDangKyCongDanLocalServiceUtil.updateAnhChanDungYeuCauDangKyCongDan(anh);
		
		return yeuCau;
	}
	
	/**
	 * This is function update user request status
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param reqId
	 * @param status
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void updateUpdateRequestStatus(long reqId, int status) throws PortalException, SystemException {
		
		YeuCauDangKyCongDan yeuCau = YeuCauDangKyCongDanLocalServiceUtil.getYeuCauDangKyCongDan(reqId);
		
		yeuCau.setTrangThaiYeuCau(status);
		
		YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCau);		
	}
	
	/**
	 * This is function check if a citizen exists
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ho
	 * @param dem
	 * @param ten
	 * @param soCmnd
	 * @param ngaySinh
	 * @throws ParseExceptio
	 * @return String
	 */
	public String citizenExists(String ho, String dem, String ten, String soCmnd, String ngaySinh) throws ParseException{
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setLenient(false);
		Date birthDay = df.parse(ngaySinh);
		
		ho = ho.toUpperCase();
		
		dem = dem.toUpperCase();
		
		ten = ten.toUpperCase();
		
		// Check in database if there's existing person with the same birth day and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ho").eq(ho));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("dem").eq(dem));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ten").eq(ten));
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
}
