/**
 * 
 */
package org.oep.cmon.job.business;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.job.util.DateUtil;
import org.oep.cmon.user.portlet.util.ElectricCodeGeneratorUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.ChucVuClp;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.CongChucClp;

import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.NoSuchGioiTinhException;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.model.CongDanClp;
import org.oep.cmon.dao.cd.model.GioiTinh;

import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoAnhXa;
import org.oep.cmon.dao.hosohcc.model.HoSoAnhXaClp;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCongClp;

import org.oep.cmon.dao.hosohcc.service.HoSoAnhXaLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.dlms.consumer.HoSoMotCua;
import vn.dtt.sharedservice.dlms.consumer.ServiceSoap;

/**
 * @author win_64
 *
 */
public class GiayPhepLaiXeBs {

//	final String AUTO_GENERATE_KEY = "AUTO_GENERATE_KEY_HO_SO_ANH_XA_MOT_CUA";
	private SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");
	
	public void getDanhSachHoSoMotCua() {
		ServiceSoap serviceSoap = WebserviceFactory.getDlmsService();
		vn.dtt.sharedservice.dlms.consumer.ArrayOfHoSoMotCua listHoSoMotCua = serviceSoap.getHoSoMotCua();
		if (listHoSoMotCua != null) {
			for (HoSoMotCua hoSoMotCua : listHoSoMotCua.getHoSoMotCua()) {
				addSoSoMotCua(hoSoMotCua);
			}
		}
	}
	
	private void addSoSoMotCua(HoSoMotCua hoSoMotCua) {
		String maDichVuCong = hoSoMotCua.getMALOAIHOSO1();
		 List<AnhXa> listAnhXa = AnhXaLocalServiceUtil.getDNGFromMaKhacGPLX(maDichVuCong.trim(), "CMON_THUTUCHANHCHINH");
		 if (listAnhXa.size() == 0) {
			return;
		 }
		 
		 // Check ma so ho so
		 if (getHoSoAnhXaByMaDK(hoSoMotCua.getMaDK1().trim()).size() > 0) {
			 return;
		 }
		 try {
			if (HoSoTTHCCongLocalServiceUtil.findByMaSoHoSo(hoSoMotCua.getMaDK1().trim()).size() > 0) {
				 return;
			 }
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 try {
			long hoSoHanhChinhCongId = creareDocument(hoSoMotCua);
			if (hoSoHanhChinhCongId > 0) {
				HoSoAnhXa hoSoAnhXa = new HoSoAnhXaClp();
	        	hoSoAnhXa.setHoSoTTHCCongId(hoSoHanhChinhCongId);
	        	hoSoAnhXa.setMaHoSo(hoSoMotCua.getMaDK1());
	        	hoSoAnhXa.setNgaySua(new Date());
	        	hoSoAnhXa.setNgayTao(new Date());
	        	hoSoAnhXa.setTrangThai(ConvertUtil.convertToInt(hoSoMotCua.getTRANGTHAIXULY1()));
	        	hoSoAnhXa.setId(WebserviceFactory.getCmonService().getAutoIncrement());
				
	        	HoSoAnhXaLocalServiceUtil.addHoSoAnhXa(hoSoAnhXa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<HoSoAnhXa> getHoSoAnhXaByMaDK(String maHoSo) {
		return HoSoAnhXaLocalServiceUtil.findByMaHoSo(maHoSo);
	}
	
	private String getMaDNGFromMaKhac(String maDNG, String tableName) {
		return AnhXaLocalServiceUtil.getDNGFromMaKhacGPLX(maDNG, tableName).get(0).getMaDNG();
	}
	
	private long creareDocument(HoSoMotCua hoSoMotCua) throws Exception {
		// Check to see if cong chuc exists
		String maDonViTiepNhan = WebserviceFactory.getThamSoService().getValue("DLMS_MADONVITIEPNHAN_MOTCUA");
		String maCanBo = hoSoMotCua.getMANGUOITIEPNHAN1();
		
		CongChuc canBo = getCongChuc(maCanBo);
		
		if ( canBo == null) {
			// Create cong chuc here			
			canBo = createCongChuc(hoSoMotCua.getMANGUOITIEPNHAN1(), hoSoMotCua.getTENNGUOITIEPNHAN1(), maDonViTiepNhan);			
		} 
		
		// Check cong dan
		CongDan congDan = getCitizen(hoSoMotCua.getHOTENNGUOINOP1(), hoSoMotCua.getSOCMND1(), formatDateShort.format(hoSoMotCua.getNGAYSINH1().toGregorianCalendar().getTime()));
		
		if ( congDan == null ) {
			
			// Create new cong dan
			congDan = createCitizen(hoSoMotCua.getHOTENNGUOINOP1(), hoSoMotCua.getSOCMND1()
									, formatDateShort.format(hoSoMotCua.getNGAYSINH1().toGregorianCalendar().getTime()), hoSoMotCua.getGIOITINH1()
									, hoSoMotCua.getMATINHTHUONGTRU1(), hoSoMotCua.getMOTADIACHITHUONGTRU1());
		}
		if (congDan == null ) {
			return 0;
		}
		
		// Create ho so here
		HoSoTTHCCong hoSo = new HoSoTTHCCongClp();

		long idDanhSachHoSo = WebserviceFactory.getCmonService().getAutoIncrement();

		hoSo.setId(idDanhSachHoSo);
		
		// Coquan tiep nhan
		List <CoQuanQuanLy> coQuanLst = CoQuanQuanLyLocalServiceUtil.findByMa(maDonViTiepNhan);
		long coQuanTiepNhanId = coQuanLst.get(0).getId();
		
		hoSo.setCoQuanTiepNhanId(coQuanTiepNhanId);
		
		String maThuTucHanhChinh = getMaDNGFromMaKhac(hoSoMotCua.getMALOAIHOSO1().trim(), "CMON_THUTUCHANHCHINH");
		ThuTucHanhChinh dichVuCong = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinhBoiMa(maThuTucHanhChinh);
		
		// ID dich vu cong
		hoSo.setThuTucHanhChinhId(dichVuCong.getId());
		
		// Ten dich vu cong
		hoSo.setTenThuTucHanhChinh(dichVuCong.getTen());
		
		// Ngay nop ho so
		hoSo.setNgayNopHoSo(hoSoMotCua.getNGAYNOPHOSO1().toGregorianCalendar().getTime());
		
		// Ten nguoi nop ho so
		hoSo.setHoTenNguoiNopHoSo(hoSoMotCua.getHOTENNGUOINOP1().toUpperCase());
		
		// Dia chi thuong tru nguoi nop
		if (hoSoMotCua.getMOTADIACHITHUONGTRU1() == null  || hoSoMotCua.getMOTADIACHITHUONGTRU1().trim().length() == 0) {
			hoSo.setDiaChiThuongTruNguoiNop("Khong co mo ta tu 1 cua");
		} else {
			hoSo.setDiaChiThuongTruNguoiNop(hoSoMotCua.getMOTADIACHITHUONGTRU1());
		}
		
		hoSo.setTrangThaiHoSo(1);// New hoso
		
		// Cong dan nop ho so
		hoSo.setCongDanNopId(congDan.getId());
		
		// Ten chu so huu ho so
		hoSo.setChuSoHuu(hoSoMotCua.getHOTENNGUOINOP1().toUpperCase());
		
		// Get gropu dich vu cong id
		long dvcGroupId = dichVuCong.getNhomThuTucHanhChinhId();
		
		NhomThuTucHanhChinh nhomDvc = NhomThuTucHanhChinhLocalServiceUtil.fetchNhomThuTucHanhChinh(dvcGroupId);
		long appId = nhomDvc.getDanhMucUngDungId();
		
		// Get applcation code
		DanhMucUngDung app = DanhMucUngDungLocalServiceUtil.getDanhMucUngDung(appId);
		
		// Ma ung dung
		hoSo.setMaUngDung(app.getMa());
		
		hoSo.setLoaiHoSo(1); // OSS document
		
		// Can bo tiep nhan ho so
		hoSo.setCanBoTiepNhanId(canBo.getId());
		
		// Ten can bo tiep nhan
		hoSo.setTenCanBoTiepNhan(hoSoMotCua.getTENNGUOITIEPNHAN1());
		
		// Ngay tiep nhan ho so
		hoSo.setNgayNhanHoSo(hoSoMotCua.getNGAYNOPHOSO1().toGregorianCalendar().getTime());
		
		// Ten co quan tiep nhan
		// Check Ma don vi tiep nhan		
		hoSo.setTenCoQuanTiepNhan(coQuanLst.get(0).getTen());
		
		// Ngay hen tra ket qua
		hoSo.setNgayHenTraKetQua(hoSoMotCua.getNGAYHENTRA1().toGregorianCalendar().getTime());
		
		// Ma so ho so
		hoSo.setMaSoHoSo(hoSoMotCua.getMaDK1());
		
		Date currentDate = new Date();
		
		hoSo.setNgayTao(currentDate);
		
		hoSo.setNgaySua(currentDate);
		
		hoSo.setNguoiTao("INTEGRATION BATCH");
		
		hoSo.setNguoiSua("INTEGRATION BATCH");
		
		hoSo.setDaXoa(0);
		
		HoSoTTHCCongLocalServiceUtil.addHoSoTTHCCong(hoSo);		
		return idDanhSachHoSo;
	}
	
	private CongChuc getCongChuc(String maCongChuc) throws SystemException {
		List<CongChuc> congChucLst = CongChucLocalServiceUtil.findByMa(maCongChuc);
		
		if ( congChucLst.size() < 1) {
			return null;
			
		}
		
		return congChucLst.get(0);		
	}
	
	/**
	 * Create a cong chuc in database
	 * 
	 * @param code
	 * @param name
	 * @param maDonViTiepNhan
	 * @return
	 * @throws SystemException
	 * @throws NoSuchGioiTinhException
	 * @throws NoSuchQuocGiaException
	 */
	private CongChuc createCongChuc(String code, String name, String maDonViTiepNhan) throws Exception {
		
		// Get co quan
		List <CoQuanQuanLy> coQuanLst = CoQuanQuanLyLocalServiceUtil.findByMa(maDonViTiepNhan);
		
		CoQuanQuanLy coQuan = coQuanLst.get(0);
		
		return createCongChuc(code, name, coQuan.getId());
	}
	
	/**
	 * Create cong chuc
	 * 
	 * @param code
	 * @param name
	 * @param donViTiepNhan
	 * @return
	 * @throws SystemException
	 * @throws NoSuchGioiTinhException
	 * @throws NoSuchQuocGiaException
	 */
	private CongChuc createCongChuc(String code, String name, long donViTiepNhan) throws Exception {
		CongChuc canBo = new CongChucClp();
		
		canBo.setId(CounterLocalServiceUtil.increment("cmon_congchuc"));
		
		String gioiTinhMacDinh = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CONG_CHUC_GIOI_TINH_MAC_DINH_M");
		String chucVuMacDinh = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CHUC_VU_MAC_DINH_OSS_DE_DUNG_LOGIC");
		
		// Get gioi tinh
		GioiTinh gioiTinh = GioiTinhLocalServiceUtil.findByMa(gioiTinhMacDinh); // Default is male		
		
		// Get chuc vu
		List<ChucVu> chucVuLst  = ChucVuLocalServiceUtil.findMa(chucVuMacDinh);
		if (chucVuLst.size() == 0) {
			try {
				ChucVu doiTuongSuDung = new ChucVuClp();
				doiTuongSuDung.setId(CounterLocalServiceUtil.increment(ChucVu.class.getName()));
				doiTuongSuDung.setTen(chucVuMacDinh);
				doiTuongSuDung.setMa(chucVuMacDinh);
				doiTuongSuDung.setNgaySua(new Date());
				doiTuongSuDung.setNguoiSua("test@liferay.com.vn");
				doiTuongSuDung.setNgayTao(new Date());
				doiTuongSuDung.setNguoiTao("test@liferay.com.vn");
				ChucVuLocalServiceUtil.addChucVu(doiTuongSuDung);
				chucVuLst  = ChucVuLocalServiceUtil.findMa(chucVuMacDinh);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		ChucVu chucVu = chucVuLst.get(0);
		
		// Gioi tinh, default is Male
		canBo.setGioiTinhId(gioiTinh.getId());
		
		// Default chuc vu
		canBo.setChucVuId(chucVu.getId());
		
		// Co quan quan ly
		canBo.setCoQuanQuanLyId(donViTiepNhan);
		
		// 
		canBo.setMa(code);
		
		canBo.setHoVaTen(name);
		
		// Get current date
		Date currentDate = new Date();
		
		canBo.setNgaySinh(currentDate);
		
		canBo.setNgaySua(currentDate);
		
		canBo.setNgayTao(currentDate);
		
		canBo.setNguoiTao("INTEGRATION BATCH");
		
		canBo.setNguoiSua("INTEGRATION BATCH");
		
		canBo.setDaXoa(0);
		
		// Add to DB		
		CongChucLocalServiceUtil.addCongChuc(canBo);
		
		return canBo;		
	}
	
	private CongDan createCitizen(String fullName, String soCmnd, String ngaySinh, String gioiTinh, String provinceCode, String motaDiaChi) throws SystemException, PortalException {
		String[] nameElements = this.splitFullName(fullName);
		
		CongDan congDan = new CongDanClp();
		
		congDan.setId(CounterLocalServiceUtil.increment("csms_congdan"));
		
		long provinceId = 1;
		try {
			List<AnhXa> listAnhXa = AnhXaLocalServiceUtil.getDNGFromMaKhacTTHC(provinceCode.trim(), "CMON_DONVIHANHCHINH");
			if (listAnhXa.size() > 0) {
				provinceId = DonViHanhChinhLocalServiceUtil.findByMaDVHC(listAnhXa.get(0).getMaDNG()).getId();
			} else {
				provinceId = DonViHanhChinhLocalServiceUtil.findByMaDVHC(provinceCode).getId();
			}
		} catch (Exception e) {
			provinceId = 1;
		}
		
		// Generate ma so cong dan
		String maCongDan = ElectricCodeGeneratorUtil.generateCode(provinceCode, DateUtil.parseDate(ngaySinh), provinceId); 
		// Tam comment lai vi BA dua du lieu mac dinh sinh Ma bang cach dua excel tang tuan tu.
		
		congDan.setMa(maCongDan);
		
		// Handle HO, DEM, TEN
		congDan.setHo(nameElements[0]);
		
		if ( nameElements.length < 3) {
			// Ten cong dan
			congDan.setTen(nameElements[1]);
		} else {
			String dem = nameElements[1];
			for ( int i = 2; i < nameElements.length - 1; i ++) {
				dem  = dem + StringPool.SPACE + nameElements[i];
				
			}
			
			dem = dem.trim();
						
			congDan.setDem(dem);
			
			congDan.setTen(nameElements[nameElements.length - 1]);
		}
		congDan.setQuocTichId(1L);
		congDan.setDiaChiThuongTruTinhId(provinceId);
		congDan.setTenDayDu(congDan.getHo() + StringPool.SPACE + congDan.getDem() + StringPool.SPACE + congDan.getTen());
		
		congDan.setDiaChiThuongTru(motaDiaChi);
		
		congDan.setNgaySinh(DateUtil.parseDate(ngaySinh));
		
		// Handle giơi tinh
		GioiTinh gioiTinhDb = null;
		
		if (gioiTinh.toUpperCase().compareTo("M") == 0) {
			String gioiTinhMacDinhMale = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CONG_DAN_GIOI_TINH_MAC_DINH_M");
			gioiTinhDb = GioiTinhLocalServiceUtil.findByMa(gioiTinhMacDinhMale);			
		} else if (gioiTinh.toUpperCase().compareTo("F") == 0) {
			String gioiTinhMacDinhFemale = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CONG_DAN_GIOI_TINH_MAC_DINH_F");
			gioiTinhDb = GioiTinhLocalServiceUtil.findByMa(gioiTinhMacDinhFemale);
		} else {
			String gioiTinhMacDinhKhongXacDinh = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CONG_DAN_GIOI_TINH_MAC_DINH_U");
			gioiTinhDb = GioiTinhLocalServiceUtil.findByMa(gioiTinhMacDinhKhongXacDinh);
		}
		
		congDan.setGioiTinh((int)gioiTinhDb.getId());
		
		// So chung minh nhan dan
		congDan.setSoCmnd(soCmnd);
		
		Date currentDate = new Date();
		
		congDan.setNgayTao(currentDate);
		
		congDan.setNguoiTao("INTEGRATION BATCH");
		
		congDan.setNgaySua(currentDate);
		
		congDan.setNguoiSua("INTEGRATION BATCH");
		
		congDan.setDaXoa(0);
		
		try {
			CongDanLocalServiceUtil.addCongDan(congDan);
		} catch (Exception e) {
			e.printStackTrace();
			congDan = CongDanLocalServiceUtil.findByMa(maCongDan);
		}
		
		return congDan;	
	}	
	
	/**
	 * Get citizen id
	 * 
	 * @param ho
	 * @param dem
	 * @param ten
	 * @param soCmnd
	 * @param ngaySinh
	 * @return
	 * @throws ParseException
	 */
	private CongDan getCitizen(String fullName, String soCmnd, String ngaySinh) throws ParseException{

		Date birthDay = DateUtil.parseDate(ngaySinh);
		
		fullName = fullName.toUpperCase();
		
		// Check in database if there's existing person with the same birth day and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("tenDayDu").eq(fullName));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("soCmnd").eq(soCmnd));
		
		List<CongDan> results = null;
		
		try {
			results = CongDanLocalServiceUtil.dynamicQuery(queryCongDan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( results == null ||  results.size() < 1) {
			return null;
		}
		
		// Return the citizen entity
		return (results.get(0));
	}
	
	/**
	 * Spilt full name to array, in order to define ho, dem, ten
	 * 
	 * @param fullName
	 * @return
	 */
	private String[] splitFullName(String fullName){
		String[] nameElements = fullName.split(StringPool.SPACE);
		
		for (int i = 0; i < nameElements.length; i++ ){
			nameElements[i] = nameElements[i].toUpperCase().trim();
		}
		
		return nameElements;
	}
}
