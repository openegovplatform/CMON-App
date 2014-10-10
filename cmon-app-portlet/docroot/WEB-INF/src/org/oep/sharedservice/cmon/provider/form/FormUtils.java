package org.oep.sharedservice.cmon.provider.form;

import org.oep.sharedservice.cmon.Constants;
import org.oep.sharedservice.cmon.provider.model.TaiLieuDinhKem;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;


import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.model.DanhMucGiayToSoap;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThucSoap;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;


import vn.dtt.sharedservice.WebserviceFactory;

public class FormUtils {
	
	private static DocumentStorageImpl impl =new DocumentStorageImpl();  
	
	public static TaiLieuDinhKem getTaiLieuDinhKem(ThuTuc2GiayTo thuTuc2GiayTo,DanhMucGiayTo danhMucGiayTo,Long taikhoanId) throws PortalException, SystemException{
		
		TaiLieuDinhKem taiLieuDinhKem = new TaiLieuDinhKem(DanhMucGiayToSoap.toSoapModel(danhMucGiayTo));
		
		taiLieuDinhKem.setThuTuc2GiayToId(thuTuc2GiayTo.getId());
	
		if(thuTuc2GiayTo.getBatBuoc()== 1){
			taiLieuDinhKem.setBatBuoc(true);
		}else{
			taiLieuDinhKem.setBatBuoc(false);
		}
		//set to dinh kem
		TaiLieuChungThuc newVersion = TaiLieuChungThucLocalServiceUtil.getCurrentVersion(taiLieuDinhKem.getId(),taikhoanId);
		if(newVersion != null){
				taiLieuDinhKem.setTailieuChungThuc(
				TaiLieuChungThucSoap.toSoapModel(newVersion));
		        taiLieuDinhKem.setUrl(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN)
		        		+impl.getURLById(newVersion.getNoiLuuTruId()));
		}
		return taiLieuDinhKem;
	  
	}
	
 public static TaiLieuDinhKem getTaiLieuDinhKem(DanhMucGiayTo danhMucGiayTo,Long taikhoanId) throws PortalException, SystemException{
		
		TaiLieuDinhKem taiLieuDinhKem = new TaiLieuDinhKem(DanhMucGiayToSoap
						.toSoapModel(danhMucGiayTo));
		taiLieuDinhKem.setBatBuoc(false);
		//set to dinh kem
		TaiLieuChungThuc newVersion = TaiLieuChungThucLocalServiceUtil
				.getCurrentVersion(taiLieuDinhKem.getId(),taikhoanId);
		if(newVersion != null){
				
				taiLieuDinhKem.setTailieuChungThuc(
				TaiLieuChungThucSoap.toSoapModel(newVersion));
		        taiLieuDinhKem.setUrl(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.DOMAIN)
		        		+impl.getURLById(newVersion.getNoiLuuTruId()));
		}
		return taiLieuDinhKem;
	  
	}

}
