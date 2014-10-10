package org.oep.cmon.job.activity;

import java.util.Date;
import java.util.List;

import org.oep.cmon.job.business.DocumentBs;
import org.oep.cmon.job.util.DateUtil;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;
import org.oep.exch.dao.hoso.model.HoSoMotCua;
import org.oep.exch.dao.hoso.model.TrangThaiHoso;
import org.oep.exch.dao.hoso.service.HoSoMotCuaLocalServiceUtil;
import org.oep.exch.dao.hoso.service.HoSoTrucTuyenLocalServiceUtil;
import org.oep.exch.dao.hoso.service.TrangThaiHosoLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/** 
 * This is class UpdateDocumentStatusJa
 * 
 * This class will read data from exch_hosomotcua, process the data and create a document
 * in  database
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-May-2013  Nam Dinh    Create new
 */
public class UpdateDocumentStatusJa implements IJobActivity{
	
	/** Not process yet status */
	private static final int NOT_PROCESS_STATUS = 0;
	
	/** Processed status */
	private static final int PROCESSED_STATUS = 1;	
	
	/** Data error status */
	private static final int DATA_ERROR_STATUS = 2;	
	
	/**
	 * Default constructor
	 */
	public UpdateDocumentStatusJa(){
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
		// Get all data in exch_trangthaihoso that not processed yet
		List<TrangThaiHoso> trangThaiHoSoLst = TrangThaiHosoLocalServiceUtil.findByTrangThaiXuLy(NOT_PROCESS_STATUS);
		
		DocumentBs documentBs = new DocumentBs();
		
		// Initialize the message digest object
		MessageUtil msg = new MessageUtil();
		
		// Loop all record
		for ( TrangThaiHoso trangThaiHoSo : trangThaiHoSoLst) {
			
			// Check online id
			long onlineId = trangThaiHoSo.getOnlineId();
			
			if ( onlineId > 0) {
				// Check if online id exists
				try {
					HoSoTrucTuyenLocalServiceUtil.getHoSoTrucTuyen(onlineId);
				} catch (NoSuchHoSoTrucTuyenException e) {
					this.updateErr(trangThaiHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_11"));
					
					continue;
				}			
			}
			
			// Check ma so ho so
			if (Validator.isNull(trangThaiHoSo.getMaSoHoSo()) && onlineId < 1 ) {
				this.updateErr(trangThaiHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_12"));
				
				continue;
			}
			
			// Check the existence of ma so ho so
			if ((onlineId < 1) && Validator.isNotNull(trangThaiHoSo.getMaSoHoSo())) {
				
				List<HoSoTTHCCong> lst =  DateUtil.getHoSoTTHCCongByMaSoHoSo(trangThaiHoSo.getMaSoHoSo());
				
				// Incase ma so ho so not found
				if ( lst.size() < 1) {					
					// Check if the document exists in exch_hosomotcua
					List<HoSoMotCua> hoSoMotCuaLst = HoSoMotCuaLocalServiceUtil.findByMaSoHoSo(trangThaiHoSo.getMaSoHoSo(), 0);
					
					if ( hoSoMotCuaLst.size() < 1) {
						this.updateErr(trangThaiHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_13"));
						
						continue;
					} else {
						// Ignore this record, will process it in the next run
						continue;
					}					
				}			
			}			
			
			// Check ngay hen tra			
			if (Validator.isNotNull(trangThaiHoSo.getNgayHenTra()) && !DateUtil.isDate(trangThaiHoSo.getNgayHenTra())) {
				this.updateErr(trangThaiHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_14"));
				
				continue;
			}
			
			// Check ngay gio luan chuan
			if (Validator.isNotNull(trangThaiHoSo.getNgayGioLuanChuyen()) && !DateUtil.isDateTime(trangThaiHoSo.getNgayGioLuanChuyen())) {
				this.updateErr(trangThaiHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_15"));
				
				continue;
			}
			
			// Check ma nguoi xu ly hien tai and ten nguoi xu ly hien tai
			if (Validator.isNotNull(trangThaiHoSo.getMaNguoiXuLyHienTai()) && Validator.isNull(trangThaiHoSo.getTenNguoiXuLyHienTai())) {
				this.updateErr(trangThaiHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_16"));
				
				continue;
			}
			
			// Check ma nguoi xu ly ke tiep and ten nguoi xu ly ke tiep
			if (Validator.isNotNull(trangThaiHoSo.getMaNguoiXuLyKeTiep()) && Validator.isNull(trangThaiHoSo.getTenNguoiXuLyKeTiep())) {
				this.updateErr(trangThaiHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_17"));
				
				continue;
			}
			
			
			documentBs.updateDocumentStatus(trangThaiHoSo);
			
			// Update trang thai
			trangThaiHoSo.setNgayXuLy(new Date());
			 
			trangThaiHoSo.setTrangThaiXuLy(PROCESSED_STATUS);
			 
			TrangThaiHosoLocalServiceUtil.updateTrangThaiHoso(trangThaiHoSo);		 
		} // end loop		
	}
	

	/**
	 * This is  function updateErr
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
	private void updateErr(TrangThaiHoso trangThaiHoSo, int trangThai, String errMsg) throws SystemException {
		Date currentDate = new Date();
		
		trangThaiHoSo.setNgayXuLy(currentDate);
		
		trangThaiHoSo.setTrangThaiXuLy(trangThai);				 
		 
		trangThaiHoSo.setLoiKhiXuLy(errMsg);
		 
		TrangThaiHosoLocalServiceUtil.updateTrangThaiHoso(trangThaiHoSo);		
	}	
}
