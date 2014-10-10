package org.oep.sharedservice.exch.provider.hoso.business;

import java.util.Date;

import org.oep.cmon.job.util.DateUtil;
import org.oep.sharedservice.exch.provider.soap.DocumentStatusSoap;
import org.oep.sharedservice.exch.provider.soap.DocumentStatusSoapList;

import org.oep.exch.dao.hoso.model.TrangThaiHoso;
import org.oep.exch.dao.hoso.model.TrangThaiHosoClp;

import org.oep.exch.dao.hoso.service.TrangThaiHosoLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/** 
 * DocumentStatusBs class
 * 
 * This class contains all logics to get/set data in exch_trangthaihoso table
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  20-May-2013  Nam Dinh    Create new
 */
public class DocumentStatusBs {
	
	/**
	 * Create a record in exch_trangthaihoso table
	 * 
	 * @param documentStatusSoapList
	 * @throws SystemException
	 */
	public void createDocumentStatus( DocumentStatusSoapList documentStatusSoapList ) throws SystemException, Exception {
		DocumentStatusSoap[] documentStatusLst = documentStatusSoapList.getDocumentStatusSoapList();
		
		Date currentDate = new Date();
		
		for (int i = 0; i< documentStatusLst.length; i++) {
			DocumentStatusSoap documentStatusSoap = documentStatusLst[i];
			
			TrangThaiHoso trangThaiHoSo = new TrangThaiHosoClp();
			
			// Id cua record
			trangThaiHoSo.setId(CounterLocalServiceUtil.increment("exch_trangthaihoso"));
			
			
			trangThaiHoSo.setNgayChuyen(currentDate);
			
			// Online id (id cua record)
			trangThaiHoSo.setOnlineId(documentStatusSoap.getOnlineId());
			
			// Ma so ho so
			trangThaiHoSo.setMaSoHoSo(documentStatusSoap.getMaSoHoSo());
			
			// Ngay hen tra
			if (DateUtil.isDate(documentStatusSoap.getNgayHenTra())) {
				trangThaiHoSo.setNgayHenTra(documentStatusSoap.getNgayHenTra());
			} else {
				trangThaiHoSo.setNgayHenTra(DateUtil.parseDateTime(new Date()));
			}
			
			// Ma nguoi xu ly hien tai
			trangThaiHoSo.setMaNguoiXuLyHienTai(documentStatusSoap.getMaNguoiXuLyHienTai());
			
			// Ten nguoi xu ly hien tai
			trangThaiHoSo.setTenNguoiXuLyHienTai(documentStatusSoap.getTenNguoiXuLyHienTai());
			
			// Ten phong ban xu ly hien tai
			trangThaiHoSo.setTenPhongBanXuLyHienTai(documentStatusSoap.getTenPhongBanXuLyHienTai());
			
			// Ngay gio luan chuyen ho so
			trangThaiHoSo.setNgayGioLuanChuyen(documentStatusSoap.getNgayGioLuanChuyen());
			
			// So gio yeu cau xu ly
			trangThaiHoSo.setSoGioYeuCauXuLy(documentStatusSoap.getSoGioYeuCauXuLy());
			
			// Noi dung yeu cau xu ly
			trangThaiHoSo.setNoiDungYeuCauXuLy(documentStatusSoap.getNoiDungYeuCauXuLy());
			
			// So gio thuc hien
			trangThaiHoSo.setSoGioThucHien(documentStatusSoap.getSoGioThucHien());
			
			// Trang thai hien tai cua ho so
			trangThaiHoSo.setTrangThaiHienTai(documentStatusSoap.getTrangThaiHienTai());
			
			// Ma nguoi xu ly ke tiep
			trangThaiHoSo.setMaNguoiXuLyKeTiep(documentStatusSoap.getMaNguoiXuLyKeTiep());
			
			// Ten nguoi xu ly ke teo
			trangThaiHoSo.setTenNguoiXuLyKeTiep(documentStatusSoap.getTenNguoiXuLyKeTiep());
			
			// Ten phong ban xu ly ke tiep
			trangThaiHoSo.setTenPhongBanXuLyKeTiep(documentStatusSoap.getTenPhongBanXuLyKeTiep());
			
			// Trang thai ke tiep cua ho so
			trangThaiHoSo.setTrangThaiKeTiep(documentStatusSoap.getTrangThaiKeTiep());
			
			// Don vi cung cap du lieu
			trangThaiHoSo.setDonViCungCap(documentStatusSoapList.getUserName());
			
			trangThaiHoSo.setTrangThaiXuLy(0); //0: Chua xy ly
			
			TrangThaiHosoLocalServiceUtil.addTrangThaiHoso(trangThaiHoSo);		
		}
	}

}
