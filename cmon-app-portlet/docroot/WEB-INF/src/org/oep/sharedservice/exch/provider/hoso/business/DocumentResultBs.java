package org.oep.sharedservice.exch.provider.hoso.business;

import java.util.Date;

import org.oep.sharedservice.exch.provider.soap.DocumentResultSoap;
import org.oep.sharedservice.exch.provider.soap.DocumentResultSoapList;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import org.oep.exch.dao.hoso.model.KetQuaHoso;
import org.oep.exch.dao.hoso.model.KetQuaHosoClp;

import org.oep.exch.dao.hoso.service.KetQuaHosoLocalServiceUtil;

/** 
 * DocumentResultBs class
 * 
 * This class contains all logics to get/set data in exch_ketquahoso table
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  20-May-2013  Nam Dinh    Create new
 */
public class DocumentResultBs {
	
	/**
	 * Create document result record
	 * 
	 * @param documentResultSoapList
	 * @throws SystemException
	 */
	public void createDocumentResult( DocumentResultSoapList documentResultSoapList ) throws SystemException, Exception {
		DocumentResultSoap[] documentResultLst = documentResultSoapList.getDocumentResultSoapList();
		
		Date currentDate = new Date();
		
		for (int i = 0; i < documentResultLst.length; i++) {
			DocumentResultSoap documentResultSoap = documentResultLst[i];
			
			KetQuaHoso ketQuaHoSo = new KetQuaHosoClp();
			
			// ID cua record
			ketQuaHoSo.setId(CounterLocalServiceUtil.increment("exch_ketquahoso"));
			
			// Ngay chuyen data
			ketQuaHoSo.setNgayChuyen(currentDate);
			
			// Ma so ho so
			ketQuaHoSo.setMaSoHoSo(documentResultSoap.getMaSoHoSo());
			
			// Ten nguoi nhan ket qua
			ketQuaHoSo.setTenNguoiNhanKetQua(documentResultSoap.getTenNguoiNhanKetQua());
			
			// Ngay nhan ket qua
			ketQuaHoSo.setNgayNhanKetQua(documentResultSoap.getNgayNhanKetQua());
			
			// Le phi ho so
			ketQuaHoSo.setLePhiHoSo(documentResultSoap.getLePhiHoSo());
			
			// Phi xu ly ho so
			ketQuaHoSo.setPhiXuLyHoSo(documentResultSoap.getPhiXuLyHoSo());
			
			// Ngay hoan thanh ho so
			ketQuaHoSo.setNgayHoanThanh(documentResultSoap.getNgayHoanThanh());
			
			// Ma can bo tra ket qua
			ketQuaHoSo.setMaCanBoTraKetQua(documentResultSoap.getMaCanBoTraKetQua());
			
			// Ten can bo tra ket qua
			ketQuaHoSo.setTenCanBoTraKetQua(documentResultSoap.getTenCanBoTraKetQua());
			
			// Don vi cung cap du lieu
			ketQuaHoSo.setDonViCungCap(documentResultSoapList.getUserName());
			
			// Trang thai xu ly
			ketQuaHoSo.setTrangThaiXuLy(0); // 0: Chua xu ly			
			
			KetQuaHosoLocalServiceUtil.addKetQuaHoso(ketQuaHoSo);			
		}		
	}
}
