package org.oep.sharedservice.cmon.provider.form;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.oep.sharedservice.cmon.provider.model.ThuTucHanhChinh;

import org.oep.cmon.dao.dvc.model.DanhMucUngDungSoap;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDungSoap;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinhSoap;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhSoap;


@WebService(name = "IFormService", targetNamespace = "http://form.provider.cmon.sharedservice.dtt.vn/")
public interface IFormService {
	
	/**
	 * Lay ve danh sach nhom ung dung he thong
	 * @author liemnn
	 * @return : Danh sach thu tuc hanh chinh dang active
	 * 
	 */
	public DoiTuongSuDungSoap[] getDSDoiTuongSuDung();
	
	
	/**
	 * Lay ve danh sach nhom ung dung he thong
	 * @author liemnn
	 * @return : Danh sach thu tuc hanh chinh dang active
	 * 
	 */
	public DanhMucUngDungSoap[] getDSUngDung();
	
	/**
	 * Lay ve danh sach nhom ung dung he thong
	 * @author liemnn
	 * @return : Danh sach thu tuc hanh chinh dang active
	 * 
	 */
	public DanhMucUngDungSoap getUngDungTheoMa(String ma);
	
	/**
	 * Lay ve danh sach nhom thu tuc hanh chinh
	 * @author liemnn
	 * @return : Danh sach thu tuc hanh chinh dang active
	 * 
	 */
	
	
	public NhomThuTucHanhChinhSoap[] getDSNhomThuTucHanhChinh(Long ungdungId);
	
	/**
	 * Lay ve danh sach cac thu tuc hanh chinh theo nhom
	 * @author liemnn
	 * @param nhomId
	 * @return : Tat ca cac thu tuc hannh chinh theo nhom
	 */
	public ThuTucHanhChinhSoap[]getDSThuTucHanhChinhTheoNhom(Long nhomId);
	
	
	/**
	 * Lay ve danh sach cac thu tuc hanh chinh theo nhom
	 * @author liemnn
	 * @param nhomId
	 * @return : Tat ca cac thu tuc hannh chinh theo nhom
	 */
	public List<ThuTucHanhChinhSoap> getDSThuTucHanhChinhTheoNhomVaVaiTro(Long nhomId,Long vaiTroId);
	
	/**
	 * Lay ve 1 Thu tuc hanh chinh theo id
	 * @author liemnn
	 * @param id
	 * @return
	 */
	public ThuTucHanhChinh getThuTucHanhChinhTheoId(Long userId,Long id);
	
	public ThuTucHanhChinh getThuTucHanhChinhTheoMa(Long userId,String code);
	
	public String getMaUngDungTheoQuyTrinh(Long quytrinhId);
	
	
	
	
	

}
