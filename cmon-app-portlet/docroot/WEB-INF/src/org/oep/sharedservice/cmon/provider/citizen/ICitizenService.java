package org.oep.sharedservice.cmon.provider.citizen;




import javax.jws.WebService;

import org.oep.sharedservice.cmon.provider.model.Citizen;

import org.oep.cmon.dao.cc.model.ChucVuSoap;
import org.oep.cmon.dao.cc.model.CongChucSoap;
import org.oep.cmon.dao.cd.model.DanTocSoap;
import org.oep.cmon.dao.cd.model.GioiTinhSoap;
import org.oep.cmon.dao.cd.model.QuanHeGiaDinhSoap;
import org.oep.cmon.dao.cd.model.TinhTrangHonNhanSoap;
import org.oep.cmon.dao.cd.model.TonGiaoSoap;
import org.oep.cmon.dao.cd.model.TrinhDoChuyenMonSoap;
import org.oep.cmon.dao.cd.model.TrinhDoHocVanSoap;
import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanhSoap;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDungSoap;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhSoap;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungSoap;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLySoap;
import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinhSoap;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLySoap;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinhSoap;
import org.oep.cmon.dao.qlhc.model.QuocGiaSoap;

import com.liferay.portal.kernel.exception.SystemException;



@WebService(name = "ICitizenService", targetNamespace = "http://citizen.provider.cmon.sharedservice.dtt.vn/")
public interface ICitizenService {
	
	/**
	 * This is function get Citizen by code 
	 * @param code
	 * @return null if not found, and info of citize
	 */
	public Citizen getCitizenByUser(Long userId) throws Exception ;
	
	/**
	 * This is function get Citizen by code 
	 * @param code
	 * @return null if not found, and info of citize
	 */
	public Citizen getCitizenByCode(String code) throws Exception ;
	
	

	
	public Citizen getCitizenById(Long id);
	

	/**
	 * This is function get DonViHanhChinh by donviChaId
	 * @param donviChaId
	 * @return null if not found, and info of DonViHanhChinh
	 * if donvichaId = null return all Tinh
	 */
	public DonViHanhChinhSoap[] getDanhsachDVHC(Long donviChaId ) throws Exception ;
	
	/**
	 * This is function get getDVHC by donviId
	 * @param donviId
	 * @return null if not found, and info of DonViHanhChinh
	 * if donvichaId = null return all Don Vi Hanh Chinh
	 */
	public DonViHanhChinhSoap getDVHC(Long donviId ) throws Exception ;

	/**
	 * This is function get DonViHanhChinh by donviChaId
	 * @param donviChaId
	 * @return null if not found, and info of DonViHanhChinh
	 * if donvichaId = null return all Tinh
	 */
	public DonViHanhChinhSoap[] getDSDonViHanhChinhTheoChaId(Long donviChaId ) throws Exception ;
	
	/**
	 * This is function get getDVHC by donviId
	 * @param donviId
	 * @return null if not found, and info of DonViHanhChinh
	 * if donvichaId = null return all Don Vi Hanh Chinh
	 */
	public DonViHanhChinhSoap getDonViHanhChinhTheoId(Long donviId ) throws Exception ;
	
	public DonViHanhChinhSoap getDonViHanhChinhTheoUserId(Long userid);

	/**
	 * This is function get getAllDanhSachDanToc
	 * @param donviId
	 * @return null if not found, and info of DonViHanhChinh
	 * if donvichaId = null return all Tinh
	 */
	public DanTocSoap[] getDanhSachDanToc( ) throws Exception ;

	
	/**
	 * This is function get getAllQuocGia
	 * @param donviId
	 * @return null if not found, and info of DonViHanhChinh
	 * if donvichaId = null return all Tinh
	 */
	public QuocGiaSoap[] getDanhSachQuocGia( ) throws Exception ;
	
	

	/**
	* Returns all the thu tuc hanh chinhs.
	*
	* @return the thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public  ThuTucHanhChinhSoap[] getDanhSachThucTucHanhChinh() throws Exception ;
	
	/**
	* Returns all the nganh nghe kinh doanh
	*
	* @return the nganh nghe kinh doanh
	* @throws SystemException if a system exception occurred
	*/
	public  NganhNgheKinhDoanhSoap[] getDanhSachNganhNgheKinhDoanh(long cap) throws Exception ;
	
	public  NganhNgheKinhDoanhSoap getNganhNgheKinhDoanhTheoMa(String ma) throws Exception ;
	/**
	* Returns all the nganh nghe kinh doanh
	*
	* @return the nganh nghe kinh doanh
	* @throws SystemException if a system exception occurred
	*/
	public Long getAutoIncrement();
	
	/**
	* Returns all the nganh nghe kinh doanh
	*
	* @return the nganh nghe kinh doanh
	* @throws SystemException if a system exception occurred
	*/
	public Long getCitizenId();
	
	/**
	* Returns all the nganh nghe kinh doanh
	*
	* @return the nganh nghe kinh doanh
	* @throws SystemException if a system exception occurred
	*/
	public GioiTinhSoap[] getDSGioiTinh();
	
	/**
	* Returns all the nganh nghe kinh doanh
	*
	* @return the nganh nghe kinh doanh
	* @throws SystemException if a system exception occurred
	*/
	public CoQuanQuanLySoap[] getDSCoQuanQuanLyTheoTTHC(Long thuTucHanhChinhId);
	
	public CoQuanQuanLySoap getCoQuanQuanLyTheoId(Long id);
	public CoQuanQuanLySoap getCoQuanQuanLyTheoUserId(Long liferayUserid);
	public CoQuanQuanLySoap[] getCoQuanQuanLyTheoChaId(Long chaId);
	public CoQuanQuanLySoap[] getDSCoQuanQLTheoCapCoQuanQLId(Long capCoQuanQuanLyId);
	
	public CapCoQuanQuanLySoap getCapCoQuanQuanLyTheoId(Long id);
	
	public DoiTuongSuDungSoap[] getDSLoaiDoiTuong();
		

	public DonViHanhChinhSoap[] getDSDVHCTheoCapDVHCId(Long capDVHCId);
	
	public CapDonViHanhChinhSoap getCapDonViHanhChinhTheoId(Long id);
				

	

	public GioiTinhSoap getGioiTinhTheoId(Long id);
	public DanTocSoap getDanTocTheoId(Long id);
	public QuocGiaSoap getQuocGiaTheoId(Long id);
	
	
	
   public TinhTrangHonNhanSoap[] getDSTinhTrangHonNhan();
   public TinhTrangHonNhanSoap getTinhTrangHonNhanTheoId(Long id);
   public TrinhDoHocVanSoap[] getDSTrinhDoHocVan();
   public TrinhDoHocVanSoap getTrinhDoHocVanTheoId(Long id);
   public TrinhDoChuyenMonSoap[] getDSTrinhDoChuyenMon();
   public TrinhDoChuyenMonSoap getTrinhDoChuyenMonTheoId(Long id);
   
   public TonGiaoSoap[] getDSTonGiao();
   public TonGiaoSoap getTonGiaoTheoId(Long id);
   
   public QuanHeGiaDinhSoap[] getDSQuanHeGiaDinh();
   public QuanHeGiaDinhSoap getQuanHeGiaDinhTheoId(Long id);
   
   public CongChucSoap[] getDSCongChuc();
   public CongChucSoap getCongChucTheoId(Long id);
   public CongChucSoap getCongChucTheoUserId(Long liferayUserId);
   public ChucVuSoap getChucVuTheoId(Long chucVuId);
   public  TaiKhoanNguoiDungSoap getTaiKhoanNguoiDungTheoUserId(Long liferayUserId);
   
 

}
