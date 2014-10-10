package org.oep.sharedservice.exch.provider.hoso.business;

import java.util.Date;

import org.oep.sharedservice.exch.provider.soap.OSSDocumentSoap;
import org.oep.sharedservice.exch.provider.soap.OSSDocumentSoapList;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import org.oep.exch.dao.hoso.model.HoSoMotCua;
import org.oep.exch.dao.hoso.model.HoSoMotCuaClp;

import org.oep.exch.dao.hoso.service.HoSoMotCuaLocalServiceUtil;

/** 
 * OSSDocumentBs class
 * 
 * This class contains all logics to get/set data in exch_hosomotcua table
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  20-May-2013  Nam Dinh    Create new
 */
public class OSSDocumentBs {
	
	/**
	 * Create a record in table exch_hosomotcua
	 * 
	 * @param ossDocumentSoapList
	 * @throws SystemException
	 */
	public void createOSSDocument( OSSDocumentSoapList ossDocumentSoapList ) throws SystemException, Exception {
		
		// Get array of document transfered from OSS
		OSSDocumentSoap[] ossDocumentLst = ossDocumentSoapList.getOssDocumentSoapList();
		
		Date currentDate = new Date();
		for ( int i = 0; i < ossDocumentLst.length; i++ ) {
			
			OSSDocumentSoap ossDocumentSoap = ossDocumentLst[i];
			
			// Create new object here
			HoSoMotCua hoSoMotCua = new HoSoMotCuaClp();
			
			// Record id
			hoSoMotCua.setId(CounterLocalServiceUtil.increment("exch_hosomotcua"));
			
			// Ngay chuyen data
			hoSoMotCua.setNgayChuyen(currentDate);
			
			// Ma so ho so
			hoSoMotCua.setMaSoHoSo(ossDocumentSoap.getMaSoHoSo());
			
			// Ma loai ho so
			hoSoMotCua.setMaLoaiHoSo(ossDocumentSoap.getMaLoaiHoSo());
			
			// Ma don vi tiep nhan
			hoSoMotCua.setMaDonViTiepNhan(ossDocumentSoap.getMaDonViTiepNhan());
			
			// Ngay nop ho so
			hoSoMotCua.setNgayNopHoSo(ossDocumentSoap.getNgayNopHoSo());
			
			// Ngay hen tra
			hoSoMotCua.setNgayHenTra(ossDocumentSoap.getNgayHenTra());
			
			// Ho va ten nguoi nop ho so
			hoSoMotCua.setHoTenNguoiNop(ossDocumentSoap.getHoTenNguoiNop());

			// So CMND
			hoSoMotCua.setSoCmnd(ossDocumentSoap.getSoCmnd());
			
			// Ngay sinh
			hoSoMotCua.setNgaySinh(ossDocumentSoap.getNgaySinh());
			
			// Ma tinh thuong tru
			hoSoMotCua.setMaTinhThuongTru(ossDocumentSoap.getMaTinhThuongTru());
			
			// Mo ta dia chi thuong tru
			hoSoMotCua.setMoTaDiaChiThuongTru(ossDocumentSoap.getMoTaDiaChiThuongTru());
			
			// Gioi tinh
			hoSoMotCua.setGioiTinh(ossDocumentSoap.getGioiTinh());
			
			// Ma nguoi tiep nhan
			hoSoMotCua.setMaNguoiTiepNhan(ossDocumentSoap.getMaNguoiTiepNhan());
			
			// Ten nguoi tiep nhan
			hoSoMotCua.setTenNguoiTiepNhan(ossDocumentSoap.getTenNguoiTiepNhan());
			
			// Don vi cung cap
			hoSoMotCua.setDonViCungCap(ossDocumentSoapList.getUserName());
			
			// Trang thai xu ly
			hoSoMotCua.setTrangThaiXuLy(0); // Chua xu ly	
			
			HoSoMotCuaLocalServiceUtil.addHoSoMotCua(hoSoMotCua);
		}
	}

}
