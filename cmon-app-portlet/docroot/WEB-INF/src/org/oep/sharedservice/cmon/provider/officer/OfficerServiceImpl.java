package org.oep.sharedservice.cmon.provider.officer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.oep.sharedservice.cmon.Constants;
import org.oep.sharedservice.cmon.SharedserviceUtil;
import org.oep.sharedservice.cmon.provider.model.ResultUpload;
import org.oep.sharedservice.cmon.provider.officer.soap.GiayToDinhKem;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;






import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;

import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem;

import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKemClp;
import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKemSoap;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThucClp;

import org.oep.cmon.dao.tlct.service.LichSuGiayToDinhKemLocalServiceUtil;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;

@WebService(targetNamespace = "http://officer.provider.cmon.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.cmon.provider.officer.IOfficerService", portName = "OfficerServiceImplPort", serviceName = "OfficerServiceImplService")
public class OfficerServiceImpl implements IOfficerService {
	
	
	public List<GiayToDinhKem> getDSGiayToDinhKemTheoHoSoId(Long hosoId) {
		// TODO Auto-generated method stub
		
		try{
			IDocumentStorage storage = new DocumentStorageImpl();
			
			List<TaiLieuChungThuc> listTLCT=TaiLieuChungThucLocalServiceUtil.getHoSoId(hosoId);
			
			if (listTLCT != null && listTLCT.size() > 0) {
				List<GiayToDinhKem> result = new ArrayList<GiayToDinhKem>();
				
				for (TaiLieuChungThuc taiLieuChungThuc : listTLCT) {
					GiayToDinhKem dinhKem = GiayToDinhKem.toSoapModel(taiLieuChungThuc);
					dinhKem.setUrl(storage.getURLById(taiLieuChungThuc.getNoiLuuTruId()));
					result.add(dinhKem);
				}
				return result;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;		
	}

	
	public List<GiayToDinhKem> getDSGiayToDinhKemTheoMaHoSo(String maHoSo) {
		// TODO Auto-generated method stub
		try {
			List<HoSoTTHCCong> hoSoList = HoSoTTHCCongLocalServiceUtil.findByMaSoHoSo(maHoSo);
			if(hoSoList != null && hoSoList.size()>0){
				return getDSGiayToDinhKemTheoHoSoId(hoSoList.get(0).getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			
	}
	

	
	public List<LichSuGiayToDinhKemSoap> getDSLichSuCuaGiayToDinhKem(Long giayToDinhKemId){
		// TODO Auto-generated method stub
		try {
			
			List<LichSuGiayToDinhKem> lichsuList=LichSuGiayToDinhKemLocalServiceUtil.getNoiLuuTruId(giayToDinhKemId);
			if(lichsuList != null && lichsuList.size()>0){
				List<LichSuGiayToDinhKemSoap> result = new ArrayList<LichSuGiayToDinhKemSoap>();
				
				for (LichSuGiayToDinhKem tlDK : lichsuList) {
					LichSuGiayToDinhKemSoap dinhKem = LichSuGiayToDinhKemSoap.toSoapModel(tlDK);					
					result.add(dinhKem);
				}
				return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	public String getURLCuaGiayToDinhKem(Long giayToDinhKemId) {
		// TODO Auto-generated method stub
		try {
			String domain =WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN);
			IDocumentStorage storage = new DocumentStorageImpl();
			
			TaiLieuChungThuc lieuChungThuc=TaiLieuChungThucLocalServiceUtil
					.fetchTaiLieuChungThuc(giayToDinhKemId);
			
			if (lieuChungThuc != null ) {
				return domain+storage.getURLById(lieuChungThuc.getNoiLuuTruId());
			}else{
				lieuChungThuc=TaiLieuChungThucLocalServiceUtil
						.findByNoiLuuTruId(giayToDinhKemId);
				 if (lieuChungThuc != null ) {
						return domain+storage.getURLById(lieuChungThuc.getNoiLuuTruId());
				 }
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	public boolean yeuCauXoaGiayToDinhKem(Long giayToDinhKemId,Long taikhoanLiferayId) {
		// TODO Auto-generated method stub
		try {
			 	TaiKhoanNguoiDung account =  SharedserviceUtil.
			 			getTaiKhoanNguoiDungByLiferayId(taikhoanLiferayId);
			   if(account == null) return false;
				TaiLieuChungThuc tlct=TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(giayToDinhKemId);
				tlct.setTrangThai(Constants.DOCUMENT_TEMP_DELETED);
				TaiLieuChungThucLocalServiceUtil.updateTaiLieuChungThuc(tlct);
				//crate history
				LichSuGiayToDinhKem lichsu = new LichSuGiayToDinhKemClp();
				lichsu.setNoiLuuTruTaiLieuId(tlct.getId());
				lichsu.setHanhDong(Constants.ACTION.TEMP_DELETED);
				lichsu.setNgayTao(new Date());
				lichsu.setTenTaiLieu(tlct.getTen());
				lichsu.setNguoiTao(account.getEmail());
				lichsu = LichSuGiayToDinhKemLocalServiceUtil.add(lichsu);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean yeuCauPhucHoiGiayToDinhKem(Long giayToDinhKemId,Long taikhoanLiferayId){
		// TODO Auto-generated method stub
				try {
					   TaiKhoanNguoiDung account =  SharedserviceUtil.
							   getTaiKhoanNguoiDungByLiferayId(taikhoanLiferayId);
					   if(account == null) return false;
					   
						TaiLieuChungThuc tlct=TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(giayToDinhKemId);
						tlct.setTrangThai(Constants.DOCUMENT_NEW);
						TaiLieuChungThucLocalServiceUtil.updateTaiLieuChungThuc(tlct);
						//crate history
						LichSuGiayToDinhKem lichsu = new LichSuGiayToDinhKemClp();
						lichsu.setNoiLuuTruTaiLieuId(tlct.getId());
						lichsu.setHanhDong(Constants.ACTION.RESTORED);
						lichsu.setNgayTao(new Date());
						lichsu.setTenTaiLieu(tlct.getTen());
						lichsu.setNguoiTao(account.getEmail());
						lichsu = LichSuGiayToDinhKemLocalServiceUtil.add(lichsu);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
	}

	
	public boolean xoaGiayToDinhKem(Long giayToDinhKemId,Long taikhoanLiferayId) {
		// TODO Auto-generated method stub
		try {
			IDocumentStorage storage = new DocumentStorageImpl();
			TaiLieuChungThuc  chungThuc = TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(giayToDinhKemId);
			if(chungThuc != null 
					&& chungThuc.getTrangThai() == Constants.DOCUMENT_NEW){	
				List<LichSuGiayToDinhKem> lList = LichSuGiayToDinhKemLocalServiceUtil.getNoiLuuTruId(chungThuc.getId());
				if(lList != null){
					for (LichSuGiayToDinhKem lichSuGiayToDinhKem : lList) {
						LichSuGiayToDinhKemLocalServiceUtil.deleteLichSuGiayToDinhKem(lichSuGiayToDinhKem);
					}
				}
				storage.deleteFile(chungThuc.getNoiLuuTruId());
				try{
					TaiLieuChungThucLocalServiceUtil.deleteTaiLieuChungThuc(giayToDinhKemId);
				}catch (Exception e) {
					// TODO: handle exception
				}
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public GiayToDinhKem  upload(String maUngDung,int loai,Long hosoId,Long taikhoanLiferayId,String tenGiayTo,String mota,byte[]b,String tenFile){
		// TODO Auto-generated method stub
		GiayToDinhKem  result = new GiayToDinhKem();
		IDocumentStorage storage = new DocumentStorageImpl();
		
		TaiKhoanNguoiDung taiKhoanNguoiDung = SharedserviceUtil
				.getTaiKhoanNguoiDungByLiferayId(taikhoanLiferayId);
		if(taiKhoanNguoiDung == null){
			result.setCode(Constants.UPLOAD_DOCUMENT_NOTFOUND_ACCOUNT_BY_USER);
			return result;
		}
		
		if(DanhMucUngDungLocalServiceUtil.getUngDungTheoMa(maUngDung) == null){
			result.setCode(Constants.UPLOAD_DOCUMENT_NOTFOUND_APPLICATION_CODE);
			return result;
		}
		
		if(loai != Constants.UPLOAD_TYPE_HOSO 
				&& loai != Constants.UPLOAD_TYPE_OTHER){
			result.setCode(Constants.UPLOAD_TYPE_ERROR);
			return result;
		}
		
		if(loai == Constants.UPLOAD_TYPE_HOSO){
			try {
				HoSoTTHCCong hoso = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hosoId);
				if(hoso == null){
				result.setCode(Constants.UPLOAD_DOCUMENT_NOTFOUND_HOSO_ID);
				return result;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result.setCode(Constants.UPLOAD_DOCUMENT_NOTFOUND_HOSO_ID);
				return result;
				
			}
		}
				
		ResultUpload resultUpload =storage.uploadXuLyHoSo(hosoId,maUngDung,loai, taiKhoanNguoiDung.getId(), b, tenFile);
		if(resultUpload.isResult()){

			//tao metadata noi luu tru
			TaiLieuChungThuc luuTru = new TaiLieuChungThucClp();
			luuTru.setTen(tenGiayTo);
			luuTru.setChuSohuuId(taiKhoanNguoiDung.getId());
			luuTru.setHoSoTTHCCId(hosoId);
			luuTru.setTrangThai(Constants.DOCUMENT_NEW);
			luuTru.setNgayUpload(new Date());
			luuTru.setNguoiUploadId(taiKhoanNguoiDung.getId());
			luuTru.setPhienBan(1);
			luuTru.setNoiLuuTruId(resultUpload.getFileId());
			luuTru = TaiLieuChungThucLocalServiceUtil.add(luuTru);
			luuTru.setMaUngDung(maUngDung);
			luuTru.setLoai(loai);
			if(luuTru != null){
				LichSuGiayToDinhKem lichsu = new LichSuGiayToDinhKemClp();
				lichsu.setNoiLuuTruTaiLieuId(luuTru.getId());
				lichsu.setHanhDong(Constants.ACTION.CREATE_NEW);
				lichsu.setNgayTao(new Date());
				lichsu.setTenTaiLieu(tenGiayTo);
				lichsu.setNguoiTao(taiKhoanNguoiDung.getEmail());
				lichsu = LichSuGiayToDinhKemLocalServiceUtil.add(lichsu);
				if(lichsu == null){
					result.setCode("NOT_CREATED_LICHSU");				
					return result;
				}
				
			}else{
				result.setCode("NOT_CREATED_NOILUUTRU");				
				return result;
			}
			result = GiayToDinhKem.toSoapModel(luuTru);
			result.setCode(Constants.UPLOAD_OK);
			result.setResult(true);
			result.setUrl(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN)+resultUpload.getUrl());
			
			return result;
		}else{
			result.setCode(resultUpload.getCode());
			return result;
		}
	}
	
	
	

	
	

}
