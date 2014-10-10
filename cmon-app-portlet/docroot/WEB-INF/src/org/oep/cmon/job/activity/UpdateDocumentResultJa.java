package org.oep.cmon.job.activity;

import java.util.Date;
import java.util.List;

import org.oep.cmon.job.business.DocumentBs;
import org.oep.cmon.job.util.DateUtil;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.exch.dao.hoso.model.HoSoMotCua;
import org.oep.exch.dao.hoso.model.KetQuaHoso;
import org.oep.exch.dao.hoso.service.HoSoMotCuaLocalServiceUtil;
import org.oep.exch.dao.hoso.service.KetQuaHosoLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/** 
 * This is class UploadDocumentResultJa
 * 
 * This class will read data from exch_ketquahoso, process the data and update document result
 * in  database
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  28-May-2013  Nam Dinh    Create new
 */
public class UpdateDocumentResultJa implements IJobActivity {
	/** Not process yet status */
	private static final int NOT_PROCESS_STATUS = 0;
	
	/** Processed status */
	private static final int PROCESSED_STATUS = 1;	
	
	/** Data error status */
	private static final int DATA_ERROR_STATUS = 2;	
	
	/**
	 * Constructor
	 */
	public UpdateDocumentResultJa() {
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
		// Get all data in exch_ketquahoso that not processed yet
		List<KetQuaHoso> ketQuaHoSoLst = KetQuaHosoLocalServiceUtil.findByTrangThaiXuLy(NOT_PROCESS_STATUS);
		
		DocumentBs documentBs = new DocumentBs();
		
		// Initialize the message digest object
		MessageUtil msg = new MessageUtil();
		
		for( KetQuaHoso ketQuaHoSo:ketQuaHoSoLst) {
			// Check ma so ho so
			if ( Validator.isNull(ketQuaHoSo.getMaSoHoSo())) {
				this.updateErr(ketQuaHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_18"));
				
				continue;
			}
			
			// Check the existence of ma so ho so							
			List<HoSoTTHCCong> lst =  DateUtil.getHoSoTTHCCongByMaSoHoSo(ketQuaHoSo.getMaSoHoSo());
			
			// Incase ma so ho so not found
			if ( lst.size() < 1) {					
				// Check if the document exists in exch_hosomotcua
				List<HoSoMotCua> hoSoMotCuaLst = HoSoMotCuaLocalServiceUtil.findByMaSoHoSo(ketQuaHoSo.getMaSoHoSo(), 0);
				
				if ( hoSoMotCuaLst.size() < 1) {
					this.updateErr(ketQuaHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_13"));
					
					continue;
				} else {
					// Ignore this record, will process it in the next run
					continue;
				}					
			}				
			
			// Check ngay nhan ket qua
			if ( !DateUtil.isDate(ketQuaHoSo.getNgayNhanKetQua())) {
				this.updateErr(ketQuaHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_19"));
				
				continue;
			}
			
			// Check ngay gio hoan thanh
			if ( !DateUtil.isDateTime(ketQuaHoSo.getNgayHoanThanh())) {
				this.updateErr(ketQuaHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_20"));
				
				continue;			
			}
			
			// Check ma can bo tra ket qua
			if ( Validator.isNull(ketQuaHoSo.getMaCanBoTraKetQua())) {
				this.updateErr(ketQuaHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_21"));
				
				continue;
			}
			
			// Ten can bo tra ket qua
			if ( Validator.isNull(ketQuaHoSo.getTenCanBoTraKetQua())) {
				this.updateErr(ketQuaHoSo, DATA_ERROR_STATUS, msg.getMessage("ERR_22"));
				
				continue;
			}
			
			// Update data here
			documentBs.updateDocumentResult(ketQuaHoSo);	
						
			// Update trang thai
			ketQuaHoSo.setNgayXuLy(new Date());
			 
			ketQuaHoSo.setTrangThaiXuLy(PROCESSED_STATUS);
			 
			KetQuaHosoLocalServiceUtil.updateKetQuaHoso(ketQuaHoSo);	
		} // End loop
		
		
		
	}
	
	/**
	 * This is  function updateErr
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ketQuaHoSo
	 * @param trangThai
	 * @param errMsg
	 * @throws SystemException
	 */  
	private void updateErr(KetQuaHoso ketQuaHoSo, int trangThai, String errMsg) throws SystemException {
		Date currentDate = new Date();
		
		ketQuaHoSo.setNgayXuLy(currentDate);
		
		ketQuaHoSo.setTrangThaiXuLy(trangThai);				 
		 
		ketQuaHoSo.setLoiKhiXuLy(errMsg);
		 
		KetQuaHosoLocalServiceUtil.updateKetQuaHoso(ketQuaHoSo);		
	}	

}
