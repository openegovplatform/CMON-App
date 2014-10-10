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

package org.oep.cmon.portlet.ipmslist.utils;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.oep.cmon.dao.cd.model.impl.CongDanImpl;
import org.oep.cmon.dao.hosohcc.model.impl.HoSoAnhXaImpl;
import org.oep.cmon.dao.tlct.model.impl.DanhMucGiayToImpl;
import org.oep.config.ConfigUtils;
import org.oep.dlms.dao.GiayPhepLaiXeExport;
import org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe;
import org.oep.dlms.dao.capgiaypheplaixe.service.CapGiayPhepLaiXeLocalServiceUtil;
import org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX;
import org.oep.dlms.dao.chitietgplx.service.ChiTietGPLXLocalServiceUtil;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl.LyDoCapDoiCapLaiGPLXImpl;
import org.oep.dlms.dao.danhmucgiaypheplaixe.service.HangGiayPhepLaiXeLocalServiceUtil;
import org.oep.dlms.dao.danhmucgiaypheplaixe.service.LyDoCapDoiCapLaiGPLXLocalServiceUtil;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoAnhXa;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoAnhXaLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.persistence.FileDinhKemFinderUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.cmon.consumer.document.IDocumentService;
import vn.dtt.sharedservice.cmon.consumer.document.TaiLieuDinhKem;
import vn.dtt.sharedservice.cmon.consumer.thamso.AnhXaInput;
import vn.dtt.sharedservice.cmon.consumer.thamso.IThamSoService;
import vn.dtt.sharedservice.dlms.consumer.DongBoQuyTrinh;
import vn.dtt.sharedservice.dlms.consumer.ServiceSoap;
import vn.dtt.sharedservice.dlms.consumer.UploadDocumentsAttach;
import vn.dtt.sharedservice.dlms.consumer.UploadImagePortrait;

/**
 * This is class TichHopLaiXeUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class TichHopLaiXeUtil {

	private SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatDateLong = new SimpleDateFormat("dd-mm-yyyyy-hh-mm-ss");
	
	
	final String AUTO_GENERATE_KEY = "AUTO_GENERATE_KEY_HO_SO_ANH_XA_MOT_CUA";
	
	private static final String DATA_DELIMITER = "|";
	private SimpleDateFormat formatDateYYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	
	private SimpleDateFormat formatDateYYYY = new SimpleDateFormat("yyyy");
	
	private static final String TRANG_THAI_HO_SO_DANG_HOAT_DONG = "1";
	
	private static final String TRANG_THAI_HO_SO_NHAN_HO_SO = "01";
	
	private static final String GIAY_KHAM_SUC_KHOE_CO = "1";
	
	private static final int HO_VA_TEN_IN_MAX_LENGTH = 25;
	
	private static final int LY_DO_CAP_DOI_MAX_LENGTH = 50;
	
	private static final int MUC_DICH_CAP_DOI_MAX_LENGTH = 50;
	
	private static final int DIA_CHI_THUONG_TRU_MAX_LENGTH = 50;
	
	private static final int DIA_CHI_CU_TRU_MAX_LENGTH = 50;
	
	private static final String UNDEFINED_DATE = "99991231";
	
	private static Logger log = Logger.getLogger(TichHopLaiXeUtil.class.getName());

	/**
	 * This is function tichHopVoiSoGiaoThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSoHanhChinhCongId
	 * @return boolean
	 */
	public boolean tichHopVoiSoGiaoThong(long hoSoHanhChinhCongId) {
		try {
			
			log.log(Level.INFO, "******************* DLMS khoi tao DlmsService");
			ServiceSoap serviceSoap = WebserviceFactory.getDlmsService();
			
			log.log(Level.INFO, "******************* DLMS khoi tao getThamSoService");
			IThamSoService thamSoSVC = WebserviceFactory.getThamSoService();
	
			String appCode = thamSoSVC.getValue("DLMS");
			
			log.log(Level.INFO, "DLMS appCode: [{0}]", appCode);
	
			DongBoQuyTrinh dongBoQuyTrinh = new DongBoQuyTrinh();
			
			AnhXaInput anhXaDVHC = new AnhXaInput();
			anhXaDVHC.setAppCode(appCode);
			anhXaDVHC.setTable("CMON_DONVIHANHCHINH");
			
			AnhXaInput anhXaQuocGia = new AnhXaInput();
	        anhXaQuocGia.setAppCode(appCode);
	        anhXaQuocGia.setTable("CMON_QUOCGIA");
	        
	        AnhXaInput anhXaThuTucHanhChinh = new AnhXaInput();
			anhXaThuTucHanhChinh.setAppCode(appCode);
			anhXaThuTucHanhChinh.setTable("CMON_THUTUCHANHCHINH");
			
			// Lay Ho So Thu Tuc Hanh Chinh cong
			// teo: code cho nay hoi di !!!
	        HoSoTTHCCong hoSoTTHCCong = null;
	        try {
	        	hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoHanhChinhCongId);
	        	if (hoSoTTHCCong == null) {
	            	hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoHanhChinhCongId);
	            }
	        } catch (Exception e) {
	        	if (hoSoTTHCCong == null) {
	            	hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoHanhChinhCongId);
	            }
	        	e.printStackTrace();
			}
	        
	        log.log(Level.INFO, "DLMS hoSoTTHCCong: [{0}]", hoSoTTHCCong);        
	        CapGiayPhepLaiXe capGiayPhepLaiXe = CapGiayPhepLaiXeLocalServiceUtil.fetchCapGiayPhepLaiXe(hoSoHanhChinhCongId);
	        
	        // MaLoaiHs
	        log.log(Level.INFO, "DLMS ThuTucHanhChinhId: [{0}]", hoSoTTHCCong.getThuTucHanhChinhId());
	        anhXaThuTucHanhChinh.setId(hoSoTTHCCong.getThuTucHanhChinhId());
	        
	        String maAnhXaTTHC = null;
	        if (thamSoSVC.getAnhXa(anhXaThuTucHanhChinh) != null) {
	        	
	        	maAnhXaTTHC = thamSoSVC.getAnhXa(anhXaThuTucHanhChinh).getMaKhac();	        	
	        } else {
	        	log.log(Level.INFO, "*** DLMS:err Khong ton tai anh xa voi TTHC Id= [{0}]", hoSoTTHCCong.getThuTucHanhChinhId());
	        }
	        
	        // Theo anh Liem thi neu WS tra ve null thi khong tich hop voi 1 cua
	        if (maAnhXaTTHC != null) {
	        	
	        	// MaLoaiHs
		        dongBoQuyTrinh.setMaLoaiHs1(maAnhXaTTHC);
		        
		        // Gia tri don vi tiep nhan.
		        String donViNhanHoSo = ConfigUtils.getValue("org.oep.tichhoplaixe.sogtvt.donvitiepnhan.ma");
		        dongBoQuyTrinh.setDonViNhanHSo1(donViNhanHoSo);
		
		        // HoDemNLX.
		        CongDan congDanNop = getCongDan(hoSoTTHCCong.getCongDanNopId());
		        dongBoQuyTrinh.setHoDemNLX1(upperCaseString(congDanNop.getHo()) + " " + upperCaseString(congDanNop.getDem())); // teo add ho cong dan
		
		       // TenNLX.
		        dongBoQuyTrinh.setTenNLX1(upperCaseString(congDanNop.getTen()));
		
		        // HoVaTen
		        if (capGiayPhepLaiXe.getHoVaTen() == null) {
		        	dongBoQuyTrinh.setHoVaTen1(upperCaseString(congDanNop.getTenDayDu()));
		        } else {
		        	dongBoQuyTrinh.setHoVaTen1(upperCaseString(capGiayPhepLaiXe.getHoVaTen()));
		        }
		
		        // MaQuocTich
		        anhXaQuocGia.setId(capGiayPhepLaiXe.getIdQuocTich());
		        String maAnhXaQuocTich = "";
		        if (thamSoSVC.getAnhXa(anhXaQuocGia) != null) {
		        	maAnhXaQuocTich = thamSoSVC.getAnhXa(anhXaQuocGia).getMaKhac();
		        } else {
		        	log.log(Level.INFO, "*** DLMS:err Khong ton tai anh xa voi Quoc Gia Id= [{0}]", capGiayPhepLaiXe.getIdQuocTich());
		        }	
		        dongBoQuyTrinh.setMaQuocTich1(maAnhXaQuocTich);
		
		        // NgaySinh
		        GregorianCalendar gcal = new GregorianCalendar();
		        if (capGiayPhepLaiXe.getNgaySinh() == null) {
		        	gcal.setTime(congDanNop.getNgaySinh());
		        } else {
		        	gcal.setTime(capGiayPhepLaiXe.getNgaySinh());
		        }
		        XMLGregorianCalendar ngaySinh = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		        dongBoQuyTrinh.setNgaySinh1(ngaySinh);
		
		        // NoiTT
		        String diaChiThuongTru = capGiayPhepLaiXe.getDiaChiThuongTru();
		        if (diaChiThuongTru == null) diaChiThuongTru = "";
		        else diaChiThuongTru = diaChiThuongTru.trim();
		        
		        log.log(Level.INFO, "DLMS Dia Chi Thuong Tru: [{0}]", diaChiThuongTru);
		        if (diaChiThuongTru.length() < DIA_CHI_THUONG_TRU_MAX_LENGTH) {
		        	dongBoQuyTrinh.setNoiTT1(diaChiThuongTru);
		        } else {
		        	dongBoQuyTrinh.setNoiTT1(diaChiThuongTru.substring(0, DIA_CHI_THUONG_TRU_MAX_LENGTH));
		        }
		
		        // NoiTT_MaDVHC
		        log.log(Level.INFO, "DLMS Xa Thuong Tru Id: [{0}]", capGiayPhepLaiXe.getIdXaThuongTru());		        
		        anhXaDVHC.setId(capGiayPhepLaiXe.getIdXaThuongTru());	       
		        
		        String maAnhXaNoiTT_Xa = "";
		        if (thamSoSVC.getAnhXa(anhXaDVHC) != null) {
		        	maAnhXaNoiTT_Xa = thamSoSVC.getAnhXa(anhXaDVHC).getMaKhac();
		        }
		        
		        log.log(Level.INFO, "DLMS Ma Anh Xa Noi Thuong Tru (Xa): [{0}]", maAnhXaNoiTT_Xa);
		        
		        dongBoQuyTrinh.setNoiTTMaDVHC1(maAnhXaNoiTT_Xa);
	
		        // NoiTT_MaDVQL
		        // Cai nay WS se lay tu MaDVHC trong bang DM_DVHC cua 1 cua.
		        
		        // NoiCT
		        String diaChiCuTru = capGiayPhepLaiXe.getDiaChiCuTru();
		        if (diaChiCuTru == null) diaChiCuTru = "";
		        else diaChiCuTru = diaChiCuTru.trim();
		        
		        if (diaChiCuTru.length() > 0) {
		        	if (diaChiCuTru.length() < DIA_CHI_CU_TRU_MAX_LENGTH) {
			        	dongBoQuyTrinh.setNoiCT1(diaChiCuTru);
			        } else {
			        	dongBoQuyTrinh.setNoiCT1(diaChiCuTru.substring(0, DIA_CHI_CU_TRU_MAX_LENGTH));
			        }
		        } else { // teo: dong nay that ra thua vi dia chi cu tru tren form la bat buoc
		        	if (hoSoTTHCCong.getDiaChiThuongTruNguoiNop().trim().length() < DIA_CHI_CU_TRU_MAX_LENGTH) {
			        	dongBoQuyTrinh.setNoiCT1(hoSoTTHCCong.getDiaChiThuongTruNguoiNop());
			        } else {
			        	dongBoQuyTrinh.setNoiCT1(hoSoTTHCCong.getDiaChiThuongTruNguoiNop().trim().substring(0, DIA_CHI_CU_TRU_MAX_LENGTH));
			        }
		        }
		
		        // NoiCT_MaDVHC
		        // teo: comment because of cu tru <> thuong tru
		        // dongBoQuyTrinh.setNoiCTMaDVHC1(dongBoQuyTrinh.getNoiTTMaDVHC1());
		        long idXaCuTru = capGiayPhepLaiXe.getIdXaCuTru();
		        log.log(Level.INFO, "DLMS Xa Cu Tru Id: [{0}]", idXaCuTru);		        
		        anhXaDVHC.setId(idXaCuTru);		        
		        String maAnhXaNoiCT_Xa = "ERR";		        
		        if (thamSoSVC.getAnhXa(anhXaDVHC) != null)
		        	maAnhXaNoiCT_Xa = thamSoSVC.getAnhXa(anhXaDVHC).getMaKhac();
		        else {
		        	log.log(Level.ALL, "DLMS:err Khong ton tai Anh xa DVHC voi Id=[{0}] !!!", idXaCuTru);
		        }
		        
		        log.log(Level.INFO, "DLMS Ma Anh Xa Noi Cu Tru (Xa): [{0}]", maAnhXaNoiCT_Xa);
		        if ("ERR".equals(maAnhXaNoiCT_Xa))
		        	maAnhXaNoiCT_Xa = maAnhXaNoiTT_Xa;
		        
		        dongBoQuyTrinh.setNoiCTMaDVHC1(maAnhXaNoiCT_Xa);
		
		        // NoiCT_MaDVQL
		        //Cai nay WS se lay tu MaDVHC trong bang DM_DVHC cua 1 cua.
		
		        // SoCMT
		        if (capGiayPhepLaiXe.getSoCMND() != null && capGiayPhepLaiXe.getSoCMND().trim().length() > 0) {
		        	dongBoQuyTrinh.setSoCMT1(capGiayPhepLaiXe.getSoCMND());
		        } else {
		        	dongBoQuyTrinh.setSoCMT1(congDanNop.getSoCmnd());
		        }
		
		        // NgayCapCMT
		        GregorianCalendar gcal1 = new GregorianCalendar();
		        if (capGiayPhepLaiXe.getNgayCapCMND() != null) {
		        	 gcal1.setTime(capGiayPhepLaiXe.getNgayCapCMND());
		        } else {
		        	 gcal1.setTime(congDanNop.getNgayCapCmnd());
		        }
		        XMLGregorianCalendar ngayCapCmnd = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal1);
		        dongBoQuyTrinh.setNgayCapCMT1(ngayCapCmnd);
		        
		        // NoiCapCMT
		        // missing
		        // dongBoQuyTrinh.setNoiCapCMT1
		
		        // TrangThai
		        dongBoQuyTrinh.setTrangThai1(TRANG_THAI_HO_SO_DANG_HOAT_DONG);
		
		        // GioiTinh
		        if (capGiayPhepLaiXe.getIdGioiTinh() > 0) {
		        	dongBoQuyTrinh.setGioiTinh1(getGioiTinh(capGiayPhepLaiXe.getIdGioiTinh()));
		        } else {
		        	dongBoQuyTrinh.setGioiTinh1(getGioiTinh(congDanNop.getGioiTinh()));
		        }
		
		        // HoVaTenIn
		        // teo: truong nay can xem lai, vi may tinh tu cat chuoi la khong hop ly
		        if (congDanNop.getTenDayDu().trim().length() < HO_VA_TEN_IN_MAX_LENGTH) {
		        	dongBoQuyTrinh.setHoVaTenIn1(capGiayPhepLaiXe.getHoVaTen().trim());
		        } else {
		        	dongBoQuyTrinh.setHoVaTenIn1(capGiayPhepLaiXe.getHoVaTen().trim().substring(0, HO_VA_TEN_IN_MAX_LENGTH));
		        }
		        
		        // MaSoGTVT
		        String maSoGTVTDaNang = ConfigUtils.getValue("org.oep.tichhoplaixe.sogtvt.ma");	        
		        dongBoQuyTrinh.setMaSoGTVT1(maSoGTVTDaNang);       
		        
		
		        // MaDVNhanHSo
		        String maDonViNhanHoSo = ConfigUtils.getValue("org.oep.tichhoplaixe.sogtvt.donvitiepnhan.ma");
		        dongBoQuyTrinh.setMaDVNhanHSo1(maDonViNhanHoSo);
		
		        // NgayNhanHSo
		        // dongBoQuyTrinh.setNgayNhanHSo1(formatDateShort.format(hoSoTTHCCong.getNgayNopHoSo()));
		        Date currentDate = new Date();
		        dongBoQuyTrinh.setNgayNhanHSo1(formatDateShort.format(currentDate));
		
		        // NguoiNhanHSo, set cau hinh ben WS
		
		        // NgayHenTra
		        ThuTucHanhChinh tthc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(hoSoTTHCCong.getThuTucHanhChinhId());
				long tthcSoNgayXuLy = tthc.getSoNgayXuLy();	       
		        dongBoQuyTrinh.setNgayHenTra1(formatDateShort.format(getNgayHenTraHoSo(hoSoTTHCCong.getNgayNopHoSo(), tthcSoNgayXuLy)));
		
		        // TT_XuLy
		        dongBoQuyTrinh.setTTXuLy1(TRANG_THAI_HO_SO_NHAN_HO_SO);
		        
		        // GiayCNSK
		        dongBoQuyTrinh.setGiayCNSK1(GIAY_KHAM_SUC_KHOE_CO);
		        
		        // ::teo:: start lay danh sach chi tiet giay phep lai xe
		        StringBuilder soGPLXDaCo = new StringBuilder();
		        
		        // Hang giay phep lai xe da co 
		        StringBuilder hangGPLXDaCo = new StringBuilder();
		        
		        // Don Vi Cap Giay phep lai xe da co (****** danh cho nguoi VN *******)
		        StringBuilder donViCapGPLXDaCo = new StringBuilder();
		        
		        // Anh xa Noi Cap Giay phep lai xe da co (***** danh cho nguoi nuoc ngoai *****)
		        StringBuilder noiCapGPLXDaCo = new StringBuilder();
		        
		        	        
		        
		        // Ngay cap giay phep lai xe da co 
		        StringBuilder ngayCapGPLXDaCo = new StringBuilder();
		        
		        // Ngay trung tuyen giay phep lai xe da co 
		        StringBuilder ngayTrungTuyenGPLXDaCo = new StringBuilder();
		        
		        // Ngay het han giay phep lai xe da co 
		        StringBuilder ngayHetHanGPLXDaCo = new StringBuilder();
		        
		        List<ChiTietGPLX> dsChiIietGPLX = ChiTietGPLXLocalServiceUtil.findByGPLX(capGiayPhepLaiXe.getId());
		        
		        String tmpDelimiter = "";
		        String tmpDate = "";
		        String tmpHangGPLX = "";
		        String tmpHangGPLXCaoNhat = "";
		        String tmpNamTTHangGPLXCaoNhat = "";
		        
		        for (ChiTietGPLX chitietGPLX: dsChiIietGPLX) {
		        	// So Giay Phep Lai Xe da co
		        	soGPLXDaCo.append(tmpDelimiter).append(chitietGPLX.getSoGPLX().trim());
		        	
		        	// Hang giay phep lai xe da co
	//	        	anhXaHangGiayPhep.setId(chitietGPLX.getIdHangGPLX());
	//	        	hangGPLXDaCo.append(tmpDelimiter).append(thamSoSVC.getAnhXa(anhXaHangGiayPhep).getMaKhac());
		        	
		        	tmpHangGPLX = HangGiayPhepLaiXeLocalServiceUtil.getHangGiayPhepLaiXe(chitietGPLX.getIdHangGPLX()).getMa().trim();
		        	if (tmpHangGPLXCaoNhat.compareTo(tmpHangGPLX) < 0) { 
		        		tmpHangGPLXCaoNhat = tmpHangGPLX;
		        		tmpNamTTHangGPLXCaoNhat = parseDateTo_YYYY_String(chitietGPLX.getNgayTrungTuyen());
		        	}
		        	
		        	hangGPLXDaCo.append(tmpDelimiter).append(tmpHangGPLX);
		        	
		        	// Don vi cap lai xe da co = noi cap trong dlms_chitietgplx (danh cho nguoi viet nam)
		        	Long idNoiCapGPLX = chitietGPLX.getIdNoiCapGPLX();
		        	if (idNoiCapGPLX != null && idNoiCapGPLX != 0){
		        		// donViCapGPLXDaCo.append(tmpDelimiter).append(DonViGtvtLocalServiceUtil.getDonViGtvt(chitietGPLX.getIdNoiCapGPLX()).getMa());
		        		// teo: lay theo don vi hanh chinh thay vi don vi GTVT
		        		anhXaDVHC.setId(idNoiCapGPLX);
		        		
		        		if (thamSoSVC.getAnhXa(anhXaDVHC) != null) 
		        			donViCapGPLXDaCo.append(tmpDelimiter).append(thamSoSVC.getAnhXa(anhXaDVHC).getMaKhac());
		        		else {
		        			log.log(Level.ALL, "DLMS:err Khong ton tai Anh xa DVHC voi Id=[{0}] !!!", idNoiCapGPLX);
		        			
		        			donViCapGPLXDaCo.append(tmpDelimiter);
		        		}
		        	} else {
		        		donViCapGPLXDaCo.append(tmpDelimiter);
		        	}	
		        	
		        	// Noi cap lai xe da co (***** danh cho nguoi nuoc ngoai ******)
		        	long idNoiCapGPLXNuocNgoai = chitietGPLX.getIdNoiCapGPLXNuocNgoai();	        	
		        	log.log(Level.INFO, "DLMS IdNoiCapGPLXNuocNgoai: [{0}]", idNoiCapGPLXNuocNgoai);
		        	
		        	if (idNoiCapGPLXNuocNgoai != 0) {
		        		
		        		anhXaQuocGia.setId(idNoiCapGPLXNuocNgoai);
		        		
		        		if (thamSoSVC.getAnhXa(anhXaQuocGia) != null) {
		        			
		        			noiCapGPLXDaCo.append(tmpDelimiter).append(thamSoSVC.getAnhXa(anhXaQuocGia).getMaKhac());
		        		} else {
		        			
		        			log.log(Level.ALL, "DLMS:err Khong ton tai Anh xa quoc gia voi Id=[{0}] !!!", idNoiCapGPLXNuocNgoai);
		        			noiCapGPLXDaCo.append(tmpDelimiter);
		        		}
		        	} else {
		        		noiCapGPLXDaCo.append(tmpDelimiter);
		        	}
		        	
		        	// Ngay cap giay phep lai xe da co
		        	tmpDate = parseDateTo_YYYYMMDD_String(chitietGPLX.getNgayCapGPLX());
		        	ngayCapGPLXDaCo.append(tmpDelimiter).append(tmpDate);
		        	
		        	// Ngay trung tuyen giay phep lai xe da co
		        	tmpDate = parseDateTo_YYYYMMDD_String(chitietGPLX.getNgayTrungTuyen());
		        	ngayTrungTuyenGPLXDaCo.append(tmpDelimiter).append(tmpDate);
		        	
		        	// Ngay het han giay phep lai xe da co
		        	tmpDate = parseDateTo_YYYYMMDD_String(chitietGPLX.getNgayHetHan());
		        	if ("".equals(tmpDate)) tmpDate = UNDEFINED_DATE;
		        	ngayHetHanGPLXDaCo.append(tmpDelimiter).append(tmpDate);
		        	
		        	tmpDelimiter = DATA_DELIMITER;
		        }
		        // end lay danh sach chi tiet giay phep lai xe
		        
		        // NamcapLandau (Nam trung tuyen hang cao nhat GPLX den doi)	
		        if ("".equals(tmpNamTTHangGPLXCaoNhat)) 
		        	dongBoQuyTrinh.setNamcapLandau1(0);
		        else
		        	dongBoQuyTrinh.setNamcapLandau1(Integer.parseInt(tmpNamTTHangGPLXCaoNhat));
		        
		        log.info("***** Nam Trung Tuyen GPLX Hang Cao Nhat ********" + tmpNamTTHangGPLXCaoNhat);
		        
		        // SoGPLXDaCo			        
		        dongBoQuyTrinh.setSoGPLXDaCo1(soGPLXDaCo.toString());
		        
		        // HangGPLXDaCo
		        dongBoQuyTrinh.setHangGPLXDaCo1(hangGPLXDaCo.toString());
		
		        // DonViCapGPLXDaCo
			    dongBoQuyTrinh.setDonViCapGPLXDaCo1(donViCapGPLXDaCo.toString());
		
		        // NoiCapGPLXDaCo
			    dongBoQuyTrinh.setNoiCapGPLXDaCo1(noiCapGPLXDaCo.toString());
		        
		        // NgayCapGPLXDaCo 
			    if (ngayCapGPLXDaCo.length() > 0)
			    	dongBoQuyTrinh.setNgayCapGPLXDaCo1(ngayCapGPLXDaCo.toString());
		
		        // NgayTTGPLXDaCo
			    if (ngayTrungTuyenGPLXDaCo.length() > 0)
			    	dongBoQuyTrinh.setNgayTTGPLXDaCo1(ngayTrungTuyenGPLXDaCo.toString());
		        
		        // NgayHHGPLXDaCo
			    if (ngayHetHanGPLXDaCo.length() > 0)
			    	dongBoQuyTrinh.setNgayHHGPLXDaCo1(ngayHetHanGPLXDaCo.toString());
			    	
		
		        // HangGPLX	       
			    dongBoQuyTrinh.setHangGPLX1(getHangLaiXe(hangGPLXDaCo.toString()));
		
		        // LyDoCapDoi
//		        LyDoCapDoiCapLaiGPLX laiGPLX = getLyDoCapDoiCapLaiGPLX(capGiayPhepLaiXe.getIdLyDoCapDoiLaiGPLX());
//		        if (laiGPLX.getLyDo().trim().length() < LY_DO_CAP_DOI_MAX_LENGTH) {
//		        	dongBoQuyTrinh.setLyDoCapDoi1(laiGPLX.getLyDo().trim());
//		        } else {
//		        	dongBoQuyTrinh.setLyDoCapDoi1(laiGPLX.getLyDo().trim().substring(0, LY_DO_CAP_DOI_MAX_LENGTH));
//		        }
			    dongBoQuyTrinh.setLyDoCapDoi1(""); // set empty to ly do cap doi
		
		        // MucDichCapDoi
		        String mucDichCapDoi = capGiayPhepLaiXe.getGhiChu();
		        if (mucDichCapDoi == null) 
		        	mucDichCapDoi = "";
		        else 
		        	mucDichCapDoi = mucDichCapDoi.trim();
		        	
		        if (mucDichCapDoi.length() < MUC_DICH_CAP_DOI_MAX_LENGTH) {
		        	dongBoQuyTrinh.setMucDichCapDoi1(mucDichCapDoi);
		        } else {
		        	dongBoQuyTrinh.setMucDichCapDoi1(mucDichCapDoi.substring(0, MUC_DICH_CAP_DOI_MAX_LENGTH));
		        }
		
		        // GhiChu
		        dongBoQuyTrinh.setGhiChu1(mucDichCapDoi);
		
		        // MaHTCap, tam thoi khong set
		        dongBoQuyTrinh.setMaHTCap1("CD_VN");
		
		        // Transfer_flag
		        dongBoQuyTrinh.setTransferFlag1("0");
		        
		        // NamHocLX
		        // missing
		        // dongBoQuyTrinh.setNamHocLaiXe
		        
		        // Donvihoclx
		        // missing
		        // dongBoQuyTrinh.setDonviHocLaiXe
		
		        // Goi ham dong bo ho so.KHOI
		        String maDK = serviceSoap.taoMoiHoSo(dongBoQuyTrinh);
		        
		        log.log(Level.INFO, "DLMS Ma Da Dang Ky Sau khi goi WS: [{0}]", maDK);
		
		        if (maDK != null && maDK.trim().length() > 0) {
		        	
		        	// Them mapping.
		        	HoSoAnhXa hoSoAnhXa = new HoSoAnhXaImpl();
		        	hoSoAnhXa.setHoSoTTHCCongId(hoSoHanhChinhCongId);
		        	hoSoAnhXa.setMaHoSo(maDK);
		        	hoSoAnhXa.setNgaySua(new Date());
		        	hoSoAnhXa.setNgayTao(new Date());
		        	hoSoAnhXa.setTrangThai(Integer.parseInt("01"));
		        	AddHoSoMapping(hoSoAnhXa);
		        	
		        	// Upload file anh sang ben 1 cua.
			        //List listDinhKems = FileDinhKemLocalServiceUtil.findTaiLieuDinhKemTichHop(hoSoHanhChinhCongId);	        	
		        	List listDinhKems = FileDinhKemFinderUtil.findTaiLieuDinhKemTichHop(hoSoHanhChinhCongId);
		        	
			        Object[] listData = null;
			        BigDecimal noiLuuTruTaiLieuId = null;
			        try {
			        	IDocumentService iDocumentService = WebserviceFactory.getDocService();
			        	String maAnhChanDung = thamSoSVC.getValue("CMON_ANHCHANDUNG_MA");
			        	TaiLieuDinhKem taiLieuDinhKem = null;
			        	DanhMucGiayTo danhMucGiayTo = null;
			        	
			        	for (int i = 0; i < listDinhKems.size(); i++) {
			        		listData = (Object[]) listDinhKems.get(i);
			        		if (listData != null ) {
			        			noiLuuTruTaiLieuId = (BigDecimal)listData[0];
			        			taiLieuDinhKem = iDocumentService.getTailieuDinhKemBoiId(noiLuuTruTaiLieuId.longValue());
			        			danhMucGiayTo = getDanhMucGiayTo(taiLieuDinhKem.getTailieuChungThuc().getDanhMucGiayToId());
			
			        			// Neu la anh chan dung
			        			if (danhMucGiayTo.getMa().toLowerCase().trim().compareTo(maAnhChanDung.toLowerCase().trim()) == 0) {
			        				byte[] data = openISToFile(taiLieuDinhKem.getUrl());
			        				UploadImagePortrait uploadImagePortrait = new UploadImagePortrait();
			        				uploadImagePortrait.setData(data);
			        				uploadImagePortrait.setMaDK(maDK);
			        				uploadImagePortrait.setFileExtension(getFileExtension(taiLieuDinhKem.getUrl()));
			        				String maDk1 = serviceSoap.taiAnhChanDung(uploadImagePortrait);
			        			} else {
			        				byte[] data = openISToFile(taiLieuDinhKem.getUrl());
			        				UploadDocumentsAttach uploadImagePortrait = new UploadDocumentsAttach();
			        				uploadImagePortrait.setData(data);
			        				uploadImagePortrait.setMaDK(maDK);
			        				uploadImagePortrait.setTenAnh(taiLieuDinhKem.getTen());
			        				uploadImagePortrait.setFileExtension(getFileExtension(taiLieuDinhKem.getUrl()));
			        				String maDk2 = serviceSoap.taiAnhDinhKem(uploadImagePortrait);
			        			}
			        		}
			        	}
			        } catch (Exception es) {
			        	es.printStackTrace();
			        	return false;
			        }
		        } else {
		        	log.log(Level.INFO, "!!!!!!!! VIEC GOI WS DLMS KHONG THANH CONG !!!!!!!!!");
		        	return false;
		        }
	        } else {
	        	return false;
	        }
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * This is function upperCaseString
	 * Upper String, incase input string is null then return BLANK
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param inputString
	 * @return String
	 */
	protected static String upperCaseString(String inputString) {
		
		if (inputString == null) return "";
		else return inputString.toUpperCase();
	}

	/**
	 * This is function getHangLaiXe
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param dsHangLaiXe
	 * @return String
	 */
	public static String getHangLaiXe(String dsHangLaiXe)
	{
		String[] tmpArr = dsHangLaiXe.split("\\|");
		
		String tempString = "";
		for (String item: tmpArr) {
			
			if (item.compareToIgnoreCase(tempString) > 0) tempString = item;
		}
		
		return tempString.toUpperCase();
	}
	
	/**
	 * This is function AddHoSoMapping
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSoAnhXa
	 */
	private void AddHoSoMapping(HoSoAnhXa hoSoAnhXa) {
		try {
			hoSoAnhXa.setId(WebserviceFactory.getCmonService().getAutoIncrement());
			HoSoAnhXaLocalServiceUtil.addHoSoAnhXa(hoSoAnhXa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is function openISToFile
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param urlString
	 * @return byte[]
	 */
	private byte[] openISToFile(String urlString) {
		String _url = urlString;
		InputStream is = null;
		byte[] result = null;
		try {
			if (!_url.contains("http://")) {
				_url = "http://" + urlString;
			}
			URL url = new URL(_url);
			URLConnection conn = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			int responseCode = httpConn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				is = httpConn.getInputStream();
	//			result = new byte[is.available()];
	//			is.read(result);
	//			is.close();
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				int next = is.read();
				while (next > -1) {
				    bos.write(next);
				    next = is.read();
				}
				bos.flush();
				result = bos.toByteArray();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This is function getFileExtension
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param urlString
	 * @return String
	 */
	private String getFileExtension(String urlString) {
		try {
			URL url = new URL(urlString);
			String path = url.getPath();
			return path.substring(path.lastIndexOf("."));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jpg";
	}

	/**
	 * This is function writeData
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param test
	 */
	private void writeData(GiayPhepLaiXeExport test) {
		String rootDirectory = "";
		try {
			rootDirectory = WebserviceFactory.getThamSoService().getValue("ROOT_PATH_EXPORT_FILE_GIAY_PHEP_LAI_XE");
		} catch (Exception e) {
		}
		try {
			if (rootDirectory.trim().length() == 0) {
				rootDirectory = "d:\\";
			}
			JAXBContext jc = JAXBContext.newInstance(GiayPhepLaiXeExport.class);

			// Kiem tra thu muc luu tru, neu chua co thi tao moi.
			if (!rootDirectory.contains("data_giaypheplaixe")) {
				rootDirectory += "\\data_giaypheplaixe";
			}
			File fileCheck = new File(rootDirectory);
			if (!fileCheck.exists()) {
				fileCheck.mkdirs();
			}

			// Ghi du lieu ra file.
	        File xml = new File(rootDirectory + "\\" + test.getTENTHUTUCHANHCHINH() + test.getHOTENNGUOINOPHOSO() + formatDateLong.format(new Date()) + ".xml");
	        Marshaller marshaller = jc.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.marshal(test, xml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This is function parseDateToTring
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return String
	 */
	private String parseDateToTring(Date date) {
		try {
			return formatDateShort.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	/**
	 * This is function parseDateTo_YYYYMMDD_String
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return String
	 */
	private String parseDateTo_YYYYMMDD_String(Date date) {
		try {
			return formatDateYYYYMMDD.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	/**
	 * This is function parseDateTo_YYYY_String
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return String
	 */
	private String parseDateTo_YYYY_String(Date date) {
		try {
			return formatDateYYYY.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	/**
	 * This is function getGioiTinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param CongChucId
	 * @return String
	 */
	private String getGioiTinh(long CongChucId) {
		try {
			return GioiTinhLocalServiceUtil.getGioiTinh(CongChucId).getMa();
		} catch (Exception e) {
			try {
				return GioiTinhLocalServiceUtil.getGioiTinh(CongChucId).getMa();
			} catch (Exception e1) {
			}
		}
		return "F";
	}

	/**
	 * This is function getDanhMucGiayTo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param CongChucId
	 * @return DanhMucGiayTo
	 */
	private DanhMucGiayTo getDanhMucGiayTo(long CongChucId) {
		try {
			return DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(CongChucId);
		} catch (Exception e) {
			try {
				return DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(CongChucId);
			} catch (Exception e1) {
			}
		}
		return new DanhMucGiayToImpl();
	}
	
	/**
	 * This is function getQuocGiaTen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param CongChucId
	 * @return String
	 */
	private String getQuocGiaTen(long CongChucId) {
		try {
			return QuocGiaLocalServiceUtil.fetchQuocGia(CongChucId).getTen();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function getHangGiayPhepLaiXeTen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param CongChucId
	 * @return String
	 */
	private String getHangGiayPhepLaiXeTen(long CongChucId) {
		try {
			return HangGiayPhepLaiXeLocalServiceUtil.fetchHangGiayPhepLaiXe(CongChucId).getTenHang();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function getLyDoCapDoiCapLaiTen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param CongChucId
	 * @return String
	 */
	private String getLyDoCapDoiCapLaiTen(long CongChucId) {
		try {
			return LyDoCapDoiCapLaiGPLXLocalServiceUtil.fetchLyDoCapDoiCapLaiGPLX(CongChucId).getLyDo();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function getThuTucHanhChinhTen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param thuTucHanhChinhId
	 * @return String
	 */
	private String getThuTucHanhChinhTen(long thuTucHanhChinhId) {
		try {
			return ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(thuTucHanhChinhId).getTen();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function getDonViHanhChinhTen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param donViHanhChinhId
	 * @return String
	 */
	private String getDonViHanhChinhTen(long donViHanhChinhId) {
		try {
			return DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(donViHanhChinhId).getTen();
		} catch (Exception e) {
			try {
				return DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(donViHanhChinhId).getTen();
			} catch (Exception e1) {
			}
		}
		return "";
	}

	/**
	 * This is function getTrangThaiHoSoTen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param trangThaiHoSoId
	 * @return String
	 */
	private String getTrangThaiHoSoTen(int trangThaiHoSoId) {
		try {
			return TrangThaiHoSoLocalServiceUtil.fetchTrangThaiHoSo(trangThaiHoSoId).getTrangThai();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function getCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congDanId
	 * @return String
	 */
	private String getCongDanTen(long congDanId) {
		try {
			return CongDanLocalServiceUtil.fetchCongDan(congDanId).getTenDayDu();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function getHangLaiXe
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param dsHangLaiXe
	 * @return String
	 */
	private CongDan getCongDan(long congDanId) {
		try {
			return CongDanLocalServiceUtil.fetchCongDan(congDanId);
		} catch (Exception e) {
			try {
				return CongDanLocalServiceUtil.fetchCongDan(congDanId);
			} catch (Exception e1) {
			}
		}
		return new CongDanImpl();
	}
	
	/**
	 * This is function getLyDoCapDoiCapLaiGPLX
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congDanId
	 * @return LyDoCapDoiCapLaiGPLX
	 */
	private LyDoCapDoiCapLaiGPLX getLyDoCapDoiCapLaiGPLX(long congDanId) {
		try {
			return LyDoCapDoiCapLaiGPLXLocalServiceUtil.fetchLyDoCapDoiCapLaiGPLX(congDanId);
		} catch (Exception e) {
			try {
				return LyDoCapDoiCapLaiGPLXLocalServiceUtil.fetchLyDoCapDoiCapLaiGPLX(congDanId);
			} catch (Exception e1) {
			}
		}
		return new LyDoCapDoiCapLaiGPLXImpl();
	}	
	

	/**
	 * This is function getNgayHenTraHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param baseDate
	 * @param numberOfDays
	 * @return Date
	 */
	private Date getNgayHenTraHoSo(Date baseDate, long numberOfDays) {
		
		if (baseDate == null) {
			baseDate = new Date();
		}

	    Calendar baseDateCal = Calendar.getInstance();
	    baseDateCal.setTime(baseDate);

		for (int i = 0; i < numberOfDays; i++) {

			baseDateCal.add(Calendar.DATE, 1);
			if (baseDateCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				baseDateCal.add(Calendar.DATE, 2);
			}
			if (baseDateCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				baseDateCal.add(Calendar.DATE, 1);
			}
	    }
	    return baseDateCal.getTime();
	}
}