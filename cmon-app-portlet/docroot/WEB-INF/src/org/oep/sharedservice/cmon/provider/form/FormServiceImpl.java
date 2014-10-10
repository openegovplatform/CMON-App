package org.oep.sharedservice.cmon.provider.form;


import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.oep.sharedservice.cmon.Constants;
import org.oep.sharedservice.cmon.SharedserviceUtil;
import org.oep.sharedservice.cmon.provider.model.TaiLieuDinhKem;
import org.oep.sharedservice.cmon.provider.model.ThuTucHanhChinh;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;



import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.DanhMucUngDungSoap;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDungSoap;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinhSoap;

import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhSoap;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.TTHC2DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.model.DanhMucGiayToSoap;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThucSoap;
import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;



@WebService(targetNamespace = "http://form.provider.cmon.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.cmon.provider.form.IFormService", portName = "FormServiceImplPort", serviceName = "FormServiceImplService")
public class FormServiceImpl implements IFormService {
	/**
	 * Lay ve danh sach nhom ung dung he thong
	 * @author liemnn
	 * @return : Danh sach thu tuc hanh chinh dang active
	 * 
	 */
	public DoiTuongSuDungSoap[] getDSDoiTuongSuDung(){
		return DoiTuongSuDungSoap.toSoapModels(
				DoiTuongSuDungLocalServiceUtil
				.getDSDoiTuongSuDung(Constants.ACTIVATED));
	}
	/**
	 * Lay ve danh sach nhom ung dung he thong
	 * @author liemnn
	 * @return : Danh sach thu tuc hanh chinh dang active
	 * 
	 */
	public DanhMucUngDungSoap[] getDSUngDung(){
		return DanhMucUngDungSoap.toSoapModels(
				DanhMucUngDungLocalServiceUtil.getDSUngDung(Constants.ACTIVATED));
	}
	
	/**
	 * Lay ve danh sach nhom ung dung he thong
	 * @author liemnn
	 * @return : Danh sach thu tuc hanh chinh dang active
	 * 
	 */
	
	public DanhMucUngDungSoap getUngDungTheoMa(String ma) {
		// TODO Auto-generated method stub
		try{
			return DanhMucUngDungSoap.toSoapModel(
				DanhMucUngDungLocalServiceUtil.getUngDungTheoMa(ma));
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * Lay ve danh sach nhom thu tuc hanh chinh
	 * @author liemnn
	 * @return : Danh sach thu tuc hanh chinh dang active
	 * 
	 */
	public NhomThuTucHanhChinhSoap[] getDSNhomThuTucHanhChinh(Long ungdungId){
		return NhomThuTucHanhChinhSoap
				.toSoapModels(NhomThuTucHanhChinhLocalServiceUtil
						.getDSNhomThuTucHanhChinhBoiUngDung(ungdungId, Constants.ACTIVATED));
	}
	
	/**
	 * Lay ve danh sach cac thu tuc hanh chinh theo nhom
	 * @author liemnn
	 * @param nhomId
	 * @return : Tat ca cac thu tuc hannh chinh theo nhom
	 */
	public ThuTucHanhChinhSoap[]getDSThuTucHanhChinhTheoNhom(Long nhomId){
		return ThuTucHanhChinhSoap
				.toSoapModels(ThuTucHanhChinhLocalServiceUtil
						.getDSThuTucHanhChinh(nhomId, Constants.ACTIVATED));
	}
	
	
	public List<ThuTucHanhChinhSoap> getDSThuTucHanhChinhTheoNhomVaVaiTro(Long nhomId,Long vaiTroId){
		ThuTucHanhChinhSoap[] chinhSoaps = getDSThuTucHanhChinhTheoNhom(nhomId);
		
		if(chinhSoaps !=null){
			List<ThuTucHanhChinhSoap> result = new ArrayList<ThuTucHanhChinhSoap>();
			
			for (ThuTucHanhChinhSoap thuTucHanhChinhSoap : chinhSoaps) {
				if(TTHC2DoiTuongSuDungLocalServiceUtil.countTTHCTheoDoiTuongSuDung(thuTucHanhChinhSoap.getId()
						, vaiTroId, Constants.ACTIVATED)>0){
					result.add(thuTucHanhChinhSoap);
				}
			}
			
			return result;
			
			
		}
		return null;
	}
	
	/**
	 * Lay ve 1 Thu tuc hanh chinh theo id
	 * @author liemnn
	 * @param id
	 * @return
	 */
	public ThuTucHanhChinh getThuTucHanhChinhTheoId(Long userId,Long id){
		
		try {
			ThuTucHanhChinh thuTucHanhChinh = new ThuTucHanhChinh(ThuTucHanhChinhSoap
					.toSoapModel(ThuTucHanhChinhLocalServiceUtil
												.getThuTucHanhChinh(id)));
			//lay ve danh sach tai lieu dinh kem
			TaiKhoanNguoiDung  account =  SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(userId);
			if(account == null) return null;
			
			List<ThuTuc2GiayTo> thuTuc2GiayTos = ThuTuc2GiayToLocalServiceUtil
					.getDSGiayToTheoThuTuc(id, Constants.ACTIVATED,Constants.STEP.STEP1);
			if(thuTuc2GiayTos != null){
				
				List<TaiLieuDinhKem> taiLieuDinhKems = new ArrayList<TaiLieuDinhKem>();
				
				for (ThuTuc2GiayTo tt2gt : thuTuc2GiayTos) {
					try{
						DanhMucGiayTo danhMucGiayTo =DanhMucGiayToLocalServiceUtil.getDanhMucGiayTo(tt2gt.getDanhMucGiayToId());
						if(danhMucGiayTo == null) continue;
						
						TaiLieuDinhKem taiLieuDinhKem = FormUtils
								.getTaiLieuDinhKem(tt2gt, danhMucGiayTo,account.getId());
						//tai lieu thay the.
						try{
							if(danhMucGiayTo.getTailieuThayTheId() != null 
									&& danhMucGiayTo.getTailieuThayTheId() !=0){
								DanhMucGiayTo taiLieuthaythe =DanhMucGiayToLocalServiceUtil
										.getDanhMucGiayTo(danhMucGiayTo.getTailieuThayTheId());
								taiLieuDinhKem.setTaiLieuThayThe(FormUtils.getTaiLieuDinhKem(tt2gt, taiLieuthaythe,account.getId()));
							}
						}catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						taiLieuDinhKems.add(taiLieuDinhKem);
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					//TaiLieuChungThuc taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil. 
					
				}
				
				thuTucHanhChinh.setTaiLieuDinhKems(taiLieuDinhKems);
				
			}
			
			
			
		//	DanhMucGiayToLocalServiceUtil.		
			//thuTucHanhChinh.setTaiLieuDinhKems(taiLieuDinhKems);
			return thuTucHanhChinh;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	
	/**
	 * Lay ve 1 Thu tuc hanh chinh theo theo ma
	 * @author liemnn
	 * @param id
	 * @return
	 */
	public ThuTucHanhChinh getThuTucHanhChinhTheoMa(Long userId,String code){
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh hanhChinh	= ThuTucHanhChinhLocalServiceUtil
					   .getThuTucHanhChinhBoiMa(code);
		if(hanhChinh != null){
			return getThuTucHanhChinhTheoId(userId,hanhChinh.getId());
		}
		return null;
	}
	
	public String getMaUngDungTheoQuyTrinh(Long quytrinhId) {
		// TODO Auto-generated method stub
		try {
			org.oep.cmon.dao.dvc.model.ThuTucHanhChinh tthc 
				= ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(quytrinhId);
			if(tthc != null){
				NhomThuTucHanhChinh nhom = NhomThuTucHanhChinhLocalServiceUtil
						.getNhomThuTucHanhChinh(tthc.getNhomThuTucHanhChinhId());
				if(nhom != null){
					DanhMucUngDung ungdung = DanhMucUngDungLocalServiceUtil
							.getDanhMucUngDung(nhom.getDanhMucUngDungId());
					if(ungdung != null){
						return ungdung.getMa();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
