package org.oep.cmon.job.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.oep.cmon.job.util.DateUtil;

import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.model.ThamSo;
import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;
import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cd.NoSuchGioiTinhException;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCongClp;

import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.qlhc.NoSuchQuocGiaException;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.exch.dao.hoso.model.HoSoMotCua;
import org.oep.exch.dao.hoso.model.HoSoTrucTuyen;
import org.oep.exch.dao.hoso.model.KetQuaHoso;
import org.oep.exch.dao.hoso.model.TrangThaiHoso;
import org.oep.exch.dao.hoso.service.HoSoTrucTuyenLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/** 
 * This is class DocumentBs
 * 
 * This class contains logics to create/update a document in  from OSS document
 *  
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  25-May-2013  Nam Dinh    Create new
 */
public class DocumentBs {
	
	/** OSS unitech user key */
	private static final String OSS_UNITECH_USER_KEY = "OSS_UNITECH_USER";
	
	/** Status mapping file */
	private static final String STATUS_MAPPING_FILE = "vn/dtt/cmon/job/business/status_mapping.properties";
	
	/**
	 * This is  function updateErr
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSoMotCua
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 */  
	public void creareDocument(HoSoMotCua hoSoMotCua) throws SystemException, ParseException, PortalException {
		// Check to see if cong chuc exists
		String maCanBo = hoSoMotCua.getMaNguoiTiepNhan();
		
		CongChucBs congChucBs = new CongChucBs();
		
		CongChuc canBo = congChucBs.getCongChuc(maCanBo);
		
		if ( canBo == null) {
			// Create cong chuc here			
			canBo = congChucBs.createCongChuc(hoSoMotCua.getMaNguoiTiepNhan(), hoSoMotCua.getTenNguoiTiepNhan(), hoSoMotCua.getMaDonViTiepNhan());			
		} 
		
		// Check cong dan
		CitizenBs citizenBs = new CitizenBs();
		
		CongDan congDan = citizenBs.getCitizen(hoSoMotCua.getHoTenNguoiNop(), hoSoMotCua.getSoCmnd(), hoSoMotCua.getNgaySinh());
		
		if ( congDan == null ) {
			
			// Create new cong dan
			congDan = citizenBs.createCitizen(hoSoMotCua.getHoTenNguoiNop(), hoSoMotCua.getSoCmnd()
									, hoSoMotCua.getNgaySinh(), hoSoMotCua.getGioiTinh()
									, hoSoMotCua.getMaTinhThuongTru(), hoSoMotCua.getMoTaDiaChiThuongTru());
		}
		if (congDan == null ) {
			return;
		}
		
		// Create ho so here
		HoSoTTHCCong hoSo = new HoSoTTHCCongClp();

		long idDanhSachHoSo = WebserviceFactory.getCmonService().getAutoIncrement();

		hoSo.setId(idDanhSachHoSo);
		
		// Coquan tiep nhan
		List<AnhXa> listAnhXaCoQuanQuanLy = AnhXaLocalServiceUtil.getDNGFromMaKhacCQQL(hoSoMotCua.getMaDonViTiepNhan(), "CMON_COQUANQUANLY");
		List <CoQuanQuanLy> coQuanLst = CoQuanQuanLyLocalServiceUtil.findByMa(listAnhXaCoQuanQuanLy.get(0).getMaDNG());
		
		long coQuanTiepNhanId = coQuanLst.get(0).getId();
		
		hoSo.setCoQuanTiepNhanId(coQuanTiepNhanId);
		
		List<AnhXa> listAnhXa = AnhXaLocalServiceUtil.getDNGFromMaKhacTTHC(hoSoMotCua.getMaLoaiHoSo().trim(), "CMON_THUTUCHANHCHINH");
		ThuTucHanhChinh dichVuCong = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinhBoiMa(listAnhXa.get(0).getMaDNG());
		
		// ID dich vu cong
		hoSo.setThuTucHanhChinhId(dichVuCong.getId());
		
		// Ten dich vu cong
		hoSo.setTenThuTucHanhChinh(dichVuCong.getTen());
		
		// Ngay nop ho so
		hoSo.setNgayNopHoSo(DateUtil.parseDate(hoSoMotCua.getNgayNopHoSo()));
		
		// Ten nguoi nop ho so
		hoSo.setHoTenNguoiNopHoSo(hoSoMotCua.getHoTenNguoiNop().toUpperCase());
		
		// Dia chi thuong tru nguoi nop
		hoSo.setDiaChiThuongTruNguoiNop(hoSoMotCua.getMoTaDiaChiThuongTru());
		
		hoSo.setTrangThaiHoSo(1);// New hoso
		
		// Cong dan nop ho so
		hoSo.setCongDanNopId(congDan.getId());
		
		// Ten chu so huu ho so
		hoSo.setChuSoHuu(hoSoMotCua.getHoTenNguoiNop().toUpperCase());
		
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
		hoSo.setTenCanBoTiepNhan(hoSoMotCua.getTenNguoiTiepNhan());
		
		// Ngay tiep nhan ho so
		hoSo.setNgayNhanHoSo(DateUtil.parseDate(hoSoMotCua.getNgayNopHoSo()));
		
		// Ten co quan tiep nhan
		// Check Ma don vi tiep nhan		
		hoSo.setTenCoQuanTiepNhan(coQuanLst.get(0).getTen());
		
		// Ngay hen tra ket qua
		hoSo.setNgayHenTraKetQua(DateUtil.parseDate(hoSoMotCua.getNgayHenTra()));
		
		// Ma so ho so
		hoSo.setMaSoHoSo(hoSoMotCua.getMaSoHoSo());
		
		Date currentDate = new Date();
		
		hoSo.setNgayTao(currentDate);
		
		hoSo.setNgaySua(currentDate);
		
		hoSo.setNguoiTao("INTEGRATION BATCH");
		
		hoSo.setNguoiSua("INTEGRATION BATCH");
		
		hoSo.setDaXoa(0);
		
		HoSoTTHCCongLocalServiceUtil.addHoSoTTHCCong(hoSo);			
	}
	
	/**
	 * This is  function updateDocumentStatus
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param trangThaiHoSo
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public void updateDocumentStatus(TrangThaiHoso trangThaiHoSo) throws PortalException, SystemException, UnsupportedEncodingException, IOException {		
		HoSoTTHCCong hoSo = null;
		
		// Check online id
		if ( trangThaiHoSo.getOnlineId() > 0) {
			// Get ho so truc tuyen
			HoSoTrucTuyen hoSoTrucTuyen = HoSoTrucTuyenLocalServiceUtil.getHoSoTrucTuyen(trangThaiHoSo.getOnlineId());
			
			hoSo = HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(hoSoTrucTuyen.getOnlineId());
		} else {
			List<HoSoTTHCCong> lst =  HoSoTTHCCongLocalServiceUtil.findByMaSoHoSo(trangThaiHoSo.getMaSoHoSo());

			// Get the first one
			hoSo = lst.get(0);			
		}
		
		// Update ma so ho so
		if ( Validator.isNotNull(trangThaiHoSo.getMaSoHoSo())) {
			hoSo.setMaSoHoSo(trangThaiHoSo.getMaSoHoSo());
		}
		
		// Update ngay hen tra
		if (Validator.isNotNull(trangThaiHoSo.getNgayHenTra())) {
			hoSo.setNgayHenTraKetQua(DateUtil.parseDate(trangThaiHoSo.getNgayHenTra()));
		}
		
		// Handle nguoi xu ly hien tai
		if (Validator.isNotNull(trangThaiHoSo.getMaNguoiXuLyHienTai())) {
			CongChucBs congChucBs = new CongChucBs();
			
			CongChuc congChuc = congChucBs.getCongChuc(trangThaiHoSo.getMaNguoiXuLyHienTai());
			
			if ( congChuc == null) {	
				congChuc = congChucBs.createCongChuc(trangThaiHoSo.getMaNguoiXuLyHienTai(), trangThaiHoSo.getTenNguoiXuLyHienTai(), hoSo.getCoQuanTiepNhanId());
			}
			
			hoSo.setCanBoXuLyHienThoiId(congChuc.getId());
			
			hoSo.setTenCanBoXuLyHienThoi(congChuc.getHoVaTen());
		}
		
		// Ten phong ban xu ly hien tai
		if ( Validator.isNotNull (trangThaiHoSo.getTenPhongBanXuLyHienTai())) {
			
			hoSo.setTenPhongBanXuLyHienThoi(trangThaiHoSo.getTenPhongBanXuLyHienTai());
		}
		
		// There's no information for next processor, so the code for nguoi xu ky ke tiep is skipped
		
		// Handle trang thai ho so
		int trangThai = trangThaiHoSo.getTrangThaiHienTai();
		
		// Get a list of Unitech user
		ThamSo thamSo = ThamSoLocalServiceUtil.findByTen(OSS_UNITECH_USER_KEY);
		String userList = thamSo.getGiaTri();
		
		if ( userList.contains(trangThaiHoSo.getDonViCungCap()) ) {
			// Read data from properties file
			URL configResource = this.getClass().getClassLoader().getResource(STATUS_MAPPING_FILE);			
			
    		Properties props = new Properties();
    		
    		BufferedReader file = new BufferedReader(new InputStreamReader(configResource.openStream(), "utf-8"));
    		props.load(file);
    		
    		String mapStatus = props.getProperty(trangThai + "");
    		
    		trangThai = Integer.parseInt(mapStatus);    		
		}
		
		hoSo.setTrangThaiHoSo(trangThai);
		
		// Update to DB
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);			
	}
	
	/**
	 * This is  function updateDocumentResult
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ketQuaHoSo
	 * @throws SystemException
	 * @throws NoSuchGioiTinhException
	 * @throws NoSuchQuocGiaException
	 */  
	public void updateDocumentResult(KetQuaHoso ketQuaHoSo) throws SystemException, NoSuchGioiTinhException, NoSuchQuocGiaException {
		HoSoTTHCCong hoSo = null;		

		List<HoSoTTHCCong> lst =  DateUtil.getHoSoTTHCCongByMaSoHoSo(ketQuaHoSo.getMaSoHoSo());

		// Get the first one
		hoSo = lst.get(0);
		
		hoSo.setHoTenNguoiNhanKetQua(ketQuaHoSo.getTenNguoiNhanKetQua());
		
		// Handle can bo tra ket qua
		CongChucBs congChucBs = new CongChucBs();
		
		CongChuc congChuc = congChucBs.getCongChuc(ketQuaHoSo.getMaCanBoTraKetQua());
		
		if ( congChuc == null) {	
			congChuc = congChucBs.createCongChuc(ketQuaHoSo.getMaCanBoTraKetQua(), ketQuaHoSo.getTenCanBoTraKetQua(), hoSo.getCoQuanTiepNhanId());
		}
		
		hoSo.setCanBoTraKetQuaId(congChuc.getId());
		
		hoSo.setTenCanBoTraKetQua(congChuc.getHoVaTen());
		
		// Ngay nhan ket qua
		hoSo.setNgayTraKetQua(DateUtil.parseDate(ketQuaHoSo.getNgayNhanKetQua()));
		
		// Ngay hoan thanh xu ly
		hoSo.setNgayKetThucXuLy(DateUtil.parseDateTime(ketQuaHoSo.getNgayHoanThanh()));
		
		// Le phi ho so
		hoSo.setLePhi(ketQuaHoSo.getLePhiHoSo());
		
		// Phi xu ly ho so
		hoSo.setPhiHoSo(ketQuaHoSo.getPhiXuLyHoSo());
		
		// Update trang thai ho so
		hoSo.setTrangThaiHoSo(5) ;// Da tra ket qua
		
		// Update to DB
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSo);			
	}
}
