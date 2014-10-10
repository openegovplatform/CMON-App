package org.oep.sharedservice.cmon.provider.document;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.oep.sharedservice.cmon.Constants;
import org.oep.sharedservice.cmon.SharedserviceUtil;
import org.oep.sharedservice.cmon.provider.form.FormUtils;
import org.oep.sharedservice.cmon.provider.model.ResultUpload;
import org.oep.sharedservice.cmon.provider.model.TaiLieuDinhKem;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;
import org.oep.sharedservice.cmon.provider.thamso.ThamSoServiceImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;



import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;

import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.model.DanhMucGiayToSoap;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThucClp;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThucSoap;
import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;














@WebService(targetNamespace = "http://document.provider.cmon.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.cmon.provider.document.IDocumentService", portName = "DocumentServiceImplPort", serviceName = "DocumentServiceImplService")
public class DocumentServiceImpl implements IDocumentService {
	private static Log log = LogFactoryUtil.getLog(DocumentServiceImpl.class);
	private IDocumentStorage storage = new DocumentStorageImpl();

	
	public ResultUpload doUpload(Long  userId,Long thutucId, String documentTypeCode, byte[] b,String fileName,boolean overwriteIfUsed,boolean overwriteIfApproved) {
		// TODO Auto-generated method stub
		ResultUpload result = new ResultUpload();
		log.info("1.-----------------start upload file with:userid,thutucId,codeId,filename:"+userId+":"+thutucId+":"+documentTypeCode+":"+fileName);
		try{
			
			DanhMucGiayTo type = null;
			try{
				type =DanhMucGiayToLocalServiceUtil.getGiayToBoiMa(documentTypeCode);
				
			}catch (Exception e) {
				// TODO: handle exception
				result.setCode(Constants.UPLOAD_DOCUMENT_NOTFOUND_GIAYTO);				
				return result;
			}
		 
			log.info("2.------kiem tra tai khoan-");
			//get last version
			Long taikhoanId = userId;
			try {
				
				TaiKhoanNguoiDung account = SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(userId);
				if(account != null){
					taikhoanId = account.getId();
					
				}else{
					result.setCode(Constants.UPLOAD_DOCUMENT_NOTFOUND_ACCOUNT_BY_USER);				
					return result;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				result.setCode(Constants.UPLOAD_DOCUMENT_NOTFOUND_ACCOUNT_BY_USER);				
				return result;
				
			}
			TaiLieuChungThuc lastDocument =null;
			log.info("3.------lay ve version-");
			int version =1;
			try{
				 lastDocument = TaiLieuChungThucLocalServiceUtil.getCurrentVersion(type.getId(), taikhoanId);
				 version = TaiLieuChungThucLocalServiceUtil.getMaxVersion(taikhoanId, type.getId());
				 version = version +1;
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			if(type == null ){
				result.setCode(Constants.UPLOAD_DOCUMENT_TYPE_NOT_FOUND);
											
				return result;
			}else{
				log.info("4. xu ly ten file");
				String vFile =""+version;
				try {
					vFile = vFile+"_"
								+CounterLocalServiceUtil.increment(DocumentServiceImpl.class.getName());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
				}
				
				String typeFile = fileName.substring(fileName.lastIndexOf(".")+1 , fileName.length());
				fileName = type.getMa().toUpperCase()+"_V"+vFile+"."+typeFile;
				typeFile = typeFile.toLowerCase().trim();
				if(type.getKieuTaiLieu().trim().length() != 0 
						&& type.getKieuTaiLieu().trim().toLowerCase().indexOf(typeFile) == -1){
					//not config type format for file
					result.setCode(Constants.UPLOAD_FILE_TYPE);
					return result;
				}
			}
			
			
			
			if(lastDocument != null){
				
				if(lastDocument.getTrangThai() == Constants.DOCUMENT_APPROVED){
					if(!overwriteIfApproved){
						result.setCode(Constants.UPLOAD_FILE_APPROVED);
						return result;
					}
					
				}else if(lastDocument.getTrangThai() == Constants.DOCUMENT_NEW){
					log.info("5.------xoa file-");
					deleteTaiLieuChungThuc(lastDocument);
				}
				
				
			}
			Long folderId = Long.valueOf(new ThamSoServiceImpl().getValue(Constants.ThamSo.CMON_DOCUMENT_FOLDER_ID));
			Long limit = 99999999999999L;
			try{
				limit = Long.valueOf(type.getGioiHanDungLuong());
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			log.info("5. xu ly upload");
			ResultUpload upload = storage.upload(userId, folderId, b, fileName,limit);
			
			if(upload.getCode().equals(Constants.UPLOAD_OK)){
					
				TaiLieuChungThuc  document = new TaiLieuChungThucClp();				
				document.setNoiLuuTruId(upload.getFileId());
				document.setTen(type.getTen());
				document.setNguoiUploadId(taikhoanId);
				document.setChuSohuuId(taikhoanId);
				//document.setHoSoTTHCCId(1L);
				//document.setNguoiduyetId(userId);
				
				document.setNgayUpload(new Date());
				document.setPhienBan(version);
				document.setDanhMucGiayToId(type.getId());
				//document.setUrl(upload.getUrl());
				document.setTrangThai(Constants.DOCUMENT_NEW);
				
				
				try {
					log.info("6. them moi");
										
					document = TaiLieuChungThucLocalServiceUtil.add(document);
					log.info("6.1 da qua phan them moi");
					result.setCode(Constants.UPLOAD_OK);
					result.setDocument(TaiLieuChungThucSoap.toSoapModel(document));
					result.setFileId(upload.getFileId());
					result.setUrl(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN)+upload.getUrl());
					result.setResult(true);
					Long tt2GiayToId = getIDTTHC2GiayTo(thutucId, document.getId());
					if(tt2GiayToId != null){
						result.setThuTuc2GiayToId(tt2GiayToId);
					}
					log.info("return result:"+ result.toString());
					return result;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					result.setCode(e.getMessage());
					return result;
				}
				
			}else{
				result.setCode(upload.getCode());
				return result;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setCode(e.getMessage());
			return result;
			
		}
		
		
	}
	
	private boolean deleteTaiLieuChungThuc(TaiLieuChungThuc taiLieuChungThuc) {
		// TODO Auto-generated method stub
		//get last version
		if(TaiLieuChungThucLocalServiceUtil.isUsed(taiLieuChungThuc.getId())){
			//if it was used by other table
			return true;
		}
		
		if(taiLieuChungThuc.getTrangThai() == Constants.DOCUMENT_NEW){
			
			try {
				TaiLieuChungThuc chungThuc =TaiLieuChungThucLocalServiceUtil
									.getTaiLieuChungThuc(taiLieuChungThuc.getId());
				if( chungThuc != null){
					
					//delete data
					TaiLieuChungThucLocalServiceUtil
										.deleteTaiLieuChungThuc(taiLieuChungThuc.getId());
					//delete file;
					
						if(storage.existFile(taiLieuChungThuc.getNoiLuuTruId())){
							storage.deleteFile(taiLieuChungThuc.getNoiLuuTruId());
						}
					
				}else{
					//delete data
					
						if(storage.existFile(taiLieuChungThuc.getNoiLuuTruId())){
							storage.deleteFile(taiLieuChungThuc.getNoiLuuTruId());
						}
					
				}
				
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
		}
		return false;
	}


	
	public boolean doDelete(Long userId, String documentTypeCode) {
		// TODO Auto-generated method stub
		//get last version
		
		DanhMucGiayTo type = null;
		try{
			type =DanhMucGiayToLocalServiceUtil.getGiayToBoiMa(documentTypeCode);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		TaiKhoanNguoiDung account = SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(userId);
		if(account == null) return false;
		
		//get last version
		TaiLieuChungThuc lastDocument =null;
		
		try{
			 lastDocument = TaiLieuChungThucLocalServiceUtil.getCurrentVersion(type.getId(), account.getId());
			 
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(lastDocument == null) return true;
		
		if(lastDocument.getTrangThai() == Constants.DOCUMENT_NEW){
			
			try {
				lastDocument =TaiLieuChungThucLocalServiceUtil.delete(lastDocument.getId());
				if(lastDocument != null){
					try{
						storage.deleteFile(lastDocument.getNoiLuuTruId());
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}


	
	public TaiLieuDinhKem getPhienBanMoiNhatTheoMa(Long userId, String code) {
		// TODO Auto-generated method stub
		DanhMucGiayTo type = 
				DanhMucGiayToLocalServiceUtil.getGiayToBoiMa(code);
		TaiKhoanNguoiDung account = SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(userId);
		if(account == null) return null;
		
		if(type != null){
			try{
				TaiLieuChungThuc  chungThuc = TaiLieuChungThucLocalServiceUtil
						.getCurrentVersion(type.getId(), account.getId());
				if(chungThuc != null){
					TaiLieuDinhKem dinhKem = new TaiLieuDinhKem(DanhMucGiayToSoap.toSoapModel(type));
					dinhKem.setTailieuChungThuc(TaiLieuChungThucSoap.toSoapModel(chungThuc));
					dinhKem.setUrl(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN)+storage.getURLById(chungThuc.getNoiLuuTruId()));
					return dinhKem;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		return null;
	}


	
	public TaiLieuDinhKem getTailieuDinhKemTheoPhienBan(Long userId, String code, int version) {
		// TODO Auto-generated method stub
		DanhMucGiayTo type = 
				DanhMucGiayToLocalServiceUtil.getGiayToBoiMa(code);
		TaiKhoanNguoiDung account = SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(userId);
		if(account == null) return null;
		
		if(type != null){
			TaiLieuChungThuc  chungThuc = TaiLieuChungThucLocalServiceUtil
					.getTheoPhienBan(type.getId(), version, account.getId());
			if(chungThuc != null){
				TaiLieuDinhKem dinhKem = new TaiLieuDinhKem(DanhMucGiayToSoap.toSoapModel(type));
				dinhKem.setTailieuChungThuc(TaiLieuChungThucSoap.toSoapModel(chungThuc));
				dinhKem.setUrl(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN)+storage.getURLById(chungThuc.getNoiLuuTruId()));
				return dinhKem;
			}
		}
		
		return null;
	}
	
	


	


	
	public TaiLieuDinhKem getTailieuDinhKemBoiId(Long chungthucId) {
		// TODO Auto-generated method stub
		log.info("1.step 1 chungthuc Id:"+chungthucId);
		try {
			TaiLieuChungThuc  chungThuc = TaiLieuChungThucLocalServiceUtil
					.fetchTaiLieuChungThuc(chungthucId);
			if(chungThuc == null){
				log.info("2. null objct chungthuc by id");
				chungThuc = TaiLieuChungThucLocalServiceUtil
						.getTaiLieuChungThuc(chungthucId);
			}
			if(chungThuc !=null){
				DanhMucGiayTo type = 
						DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(chungThuc.getDanhMucGiayToId());
				
				if(type ==null){
					log.info("3. null object  danhmuc by id");
					type = 
							DanhMucGiayToLocalServiceUtil.getDanhMucGiayTo(chungThuc.getDanhMucGiayToId());
				}
				if(type != null){
					TaiLieuDinhKem dinhKem = new TaiLieuDinhKem(DanhMucGiayToSoap.toSoapModel(type));
					dinhKem.setTailieuChungThuc(TaiLieuChungThucSoap.toSoapModel(chungThuc));
					dinhKem.setUrl(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN)+storage.getURLById(chungThuc.getNoiLuuTruId()));
					return dinhKem;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("document-------------error:"+e.getMessage());
			
			//e.printStackTrace();
		} 
		return getTailieuDinhKemBoiIdStep2(chungthucId);
		
	}
	
	private TaiLieuDinhKem getTailieuDinhKemBoiIdStep2(Long chungthucId) {
		// TODO Auto-generated method stub
		log.info("1.step 1 chungthuc Id:"+chungthucId);
		try {
			TaiLieuChungThuc  chungThuc = TaiLieuChungThucLocalServiceUtil
					.fetchTaiLieuChungThuc(chungthucId);
			if(chungThuc == null){
				log.info("2. null objct chungthuc by id");
				chungThuc = TaiLieuChungThucLocalServiceUtil
						.getTaiLieuChungThuc(chungthucId);
			}
			if(chungThuc !=null){
				DanhMucGiayTo type = 
						DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(chungThuc.getDanhMucGiayToId());
				
				if(type ==null){
					log.info("3. null object  danhmuc by id");
					type = 
							DanhMucGiayToLocalServiceUtil.getDanhMucGiayTo(chungThuc.getDanhMucGiayToId());
				}
				if(type != null){
					TaiLieuDinhKem dinhKem = new TaiLieuDinhKem(DanhMucGiayToSoap.toSoapModel(type));
					dinhKem.setTailieuChungThuc(TaiLieuChungThucSoap.toSoapModel(chungThuc));
					dinhKem.setUrl(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN)+storage.getURLById(chungThuc.getNoiLuuTruId()));
					return dinhKem;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("document-------------error:"+e.getMessage());
			
			//e.printStackTrace();
		} 
		return null;
	}


	
	public boolean doDeleteById(Long chungthucId) {
				
			try {
				TaiLieuChungThuc  chungThuc = TaiLieuChungThucLocalServiceUtil
						.getTaiLieuChungThuc(chungthucId);
				if(chungThuc != null 
						&& chungThuc.getTrangThai() == Constants.DOCUMENT_NEW){		
					try{
					storage.deleteFile(chungThuc.getNoiLuuTruId());
					}catch (Exception e) {
						// TODO: handle exception
					}
					TaiLieuChungThucLocalServiceUtil.deleteTaiLieuChungThuc(chungThuc.getId());
					return true;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			
		
		return false;
	}


	@Override
	public Long getIDTTHC2GiayTo(Long thutucId, Long taiLieuChungthucId) {
		// TODO Auto-generated method stub
		try {
			TaiLieuChungThuc  chungThuc = TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(taiLieuChungthucId);
			if(chungThuc != null){		
				
				List<ThuTuc2GiayTo> tList =ThuTuc2GiayToLocalServiceUtil.getDSTT2GiayTo(thutucId
						, chungThuc.getDanhMucGiayToId(), Constants.STEP.STEP1);
				if(tList != null && tList.size()>0){
					return tList.get(0).getId();
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return null;
	}
	
	public TaiLieuDinhKem getPhienBanMoiNhatTheoTTHC2GiayTo(Long  userId
			, Long thuTuc2GiayToId){
		try {
			TaiKhoanNguoiDung account = SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(userId);
			if(account == null) return null;
			
			
			ThuTuc2GiayTo tt2GiayTo = ThuTuc2GiayToLocalServiceUtil
					.getThuTuc2GiayTo(thuTuc2GiayToId);
			if(tt2GiayTo != null){
				DanhMucGiayTo danhMucGiayTo =DanhMucGiayToLocalServiceUtil
						.getDanhMucGiayTo(tt2GiayTo.getDanhMucGiayToId());
				if(danhMucGiayTo != null){
					return getPhienBanMoiNhatTheoMa(account.getId(), danhMucGiayTo.getMa());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		} 
		return null;
	}
	
	public TaiLieuDinhKem getPhienBanMoiNhatTheoGiayTo(Long  userId, Long giayToId){
		try {
			TaiKhoanNguoiDung account = SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(userId);
			if(account == null) return null;
			
			DanhMucGiayTo danhMucGiayTo =DanhMucGiayToLocalServiceUtil
					.getDanhMucGiayTo(giayToId);
			if(danhMucGiayTo != null){
				return getPhienBanMoiNhatTheoMa(account.getId(), danhMucGiayTo.getMa());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		} 
		return null;
	}
	
	public TaiLieuDinhKem getDanhMucGiayTheoId(Long userId,Long giayToId){
		try {
			TaiKhoanNguoiDung account = SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(userId);
			if(account == null) return null;
			DanhMucGiayTo danhMucGiayTo =DanhMucGiayToLocalServiceUtil
					.getDanhMucGiayTo(giayToId);
			if(danhMucGiayTo != null){
				return  FormUtils.getTaiLieuDinhKem(danhMucGiayTo,account.getId());
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		} 
		return null;
	}

	public TaiLieuDinhKem getThongTinTaiLieuDinhKem(Long thutucId,Long chungthucId){
		// TODO Auto-generated method stub
				try {
					TaiLieuChungThuc  chungThuc = TaiLieuChungThucLocalServiceUtil
							.getTaiLieuChungThuc(chungthucId);
					
					if(chungThuc !=null){
						List<ThuTuc2GiayTo> gList = ThuTuc2GiayToLocalServiceUtil
								.getDSTT2GiayTo(thutucId, chungThuc.getDanhMucGiayToId(), Constants.STEP.STEP1);
						if(gList != null && gList.size()>0){
							DanhMucGiayTo type = 
									DanhMucGiayToLocalServiceUtil.getDanhMucGiayTo(chungThuc.getDanhMucGiayToId());
							if(type != null){
								TaiLieuDinhKem dinhKem = new TaiLieuDinhKem(DanhMucGiayToSoap.toSoapModel(type));
								dinhKem.setTailieuChungThuc(TaiLieuChungThucSoap.toSoapModel(chungThuc));
								dinhKem.setUrl(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN)
										+storage.getURLById(chungThuc.getNoiLuuTruId()));
								if(gList.get(0).getBatBuoc()== 1){
									dinhKem.setBatBuoc(true);
								}else{
									dinhKem.setBatBuoc(false);
								}
								
								return dinhKem;
							}	
						}
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				} 
				return null;
	}
	

}
