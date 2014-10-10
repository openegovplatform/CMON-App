package org.oep.cmon.job.activity;

import java.util.Date;
import java.util.List;

import org.oep.cmon.job.business.DocumentBs;
import org.oep.cmon.job.util.DateUtil;

import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;
import org.oep.exch.dao.hoso.model.HoSoMotCua;
import org.oep.exch.dao.hoso.service.HoSoMotCuaLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/** 
 * This is class UpdateOssDocumentJa
 * 
 * This class will read data from exch_trangthaihoso, process the data and update document status
 * in database
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  27-May-2013  Nam Dinh    Create new
 */
public class UpdateOssDocumentJa implements IJobActivity{
	
	/** Not process yet status */
	private static final int NOT_PROCESS_STATUS = 0;
	
	/** Processed status */
	private static final int PROCESSED_STATUS = 1;	
	
	/** Data error status */
	private static final int DATA_ERROR_STATUS = 2;	
	
	/**
	 * Default constructor
	 */
	public UpdateOssDocumentJa(){
		// Do nothing
	}
	
	/**
	 * This is  function runActivity
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param args
	 * @throws Exception
	 */
	public void runActivity(String[] args) throws Exception {
		// Get all data in exch_hosomotcua that not processed yet
		List<HoSoMotCua> hoSoMotCuaLst = HoSoMotCuaLocalServiceUtil.findByTrangThaiXuLy(NOT_PROCESS_STATUS);
		
		 DocumentBs bs = new DocumentBs();
		 
		// Initialize the message digest object
		MessageUtil msg = new MessageUtil();
		 
		// Loop all record
		for ( HoSoMotCua hoSoMotCua : hoSoMotCuaLst) {
			
			// Check ma loai ho so
			 String maDichVuCong = hoSoMotCua.getMaLoaiHoSo();
			 List<AnhXa> listAnhXa = AnhXaLocalServiceUtil.getDNGFromMaKhacTTHC(maDichVuCong.trim(), "CMON_THUTUCHANHCHINH");
			 if (listAnhXa.size() == 0) {
				 
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_1"));				
				 
				 continue;
			 }
			 
			 // Check ma so ho so
			 if (Validator.isNull(hoSoMotCua.getMaSoHoSo())) {
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_2"));				
				 
				 continue;
			 }
			 
			 // Check the existence of ma so ho so
			 if ( DateUtil.getHoSoTTHCCongByMaSoHoSo(hoSoMotCua.getMaSoHoSo()).size() > 0 ) {
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_3"));				
				 
				 continue; 
			 }
			 
			 // Check Ma don vi tiep nhan
			 //List <CoQuanQuanLy> coQuanLst = CoQuanQuanLyLocalServiceUtil.findByMa(hoSoMotCua.getMaDonViTiepNhan());
			 List<AnhXa> listAnhXaCoQuanQuanLy = AnhXaLocalServiceUtil.getDNGFromMaKhacCQQL(hoSoMotCua.getMaDonViTiepNhan(), "CMON_COQUANQUANLY");
			 // Incase there's no co quan quan ly
			 if ( listAnhXaCoQuanQuanLy.size() < 1 ) {
				 
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_4"));				
				 
				 continue;				
			 }
			 
			 
			 // Check ngay nop ho so
			 if ( !DateUtil.isDate(hoSoMotCua.getNgayNopHoSo())) {
				 
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_5"));			
				 
				 continue;
			 }
			 
			 // Check ngay hen tra
			 if ( !DateUtil.isDate(hoSoMotCua.getNgayHenTra() )) {
				 
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_6"));
 
				 continue;
			 }
			 
			 // Check ngay sinh
			 if ( !DateUtil.isDate(hoSoMotCua.getNgaySinh())) {
				 
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_7"));
 
				 continue;
			 }
			 
			 // Check gioi tinh
			 int gioiTinh = hoSoMotCua.getGioiTinh();
			 
			 if ( gioiTinh != 0 && gioiTinh != 1 && gioiTinh != 2) {
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_8"));
				 
				 continue;
			 }
			 
			 // Check ma nguoi tiep nhan
			 if (Validator.isNull(hoSoMotCua.getMaNguoiTiepNhan())) {
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_9"));
				 
				 continue;
			 }
			 
			 if (hoSoMotCua.getHoTenNguoiNop().split(StringPool.SPACE).length < 2 ) {
				 this.updateHoSoErr(hoSoMotCua, DATA_ERROR_STATUS, msg.getMessage("ERR_10"));
				 
				 continue;
			 }
			 
			 // Insert ho so mot cua here			 
			 bs.creareDocument(hoSoMotCua);
			 
			 // Update hosomot cua
			 hoSoMotCua.setNgayXuLy(new Date());
			 
			 hoSoMotCua.setTrangThaiXuLy(PROCESSED_STATUS);
			 
			 HoSoMotCuaLocalServiceUtil.updateHoSoMotCua(hoSoMotCua);			 
		} // end loop		
	}
	
	/**
	 * This is  function updateHoSoErr
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param trangThaiHoSo
	 * @param trangThai
	 * @param errMsg
	 * @throws SystemException
	 */  
	private void updateHoSoErr(HoSoMotCua hoSoMotCua, int trangThai, String errMsg) throws SystemException {
		Date currentDate = new Date();
		
		hoSoMotCua.setNgayXuLy(currentDate);
		
		hoSoMotCua.setTrangThaiXuLy(trangThai);				 
		 
		hoSoMotCua.setLoiKhiXuLy(errMsg);
		 
		HoSoMotCuaLocalServiceUtil.updateHoSoMotCua(hoSoMotCua);
	}	
}
