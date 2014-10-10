package org.oep.sharedservice.cmon.provider.citizen;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.oep.sharedservice.cmon.Constants;
import org.oep.sharedservice.cmon.SharedserviceUtil;
import org.oep.sharedservice.cmon.provider.model.Citizen;



import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.oep.cmon.dao.cc.model.ChucVuSoap;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.CongChucSoap;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.model.CongDanSoap;
import org.oep.cmon.dao.cd.model.DanToc;
import org.oep.cmon.dao.cd.model.DanTocSoap;
import org.oep.cmon.dao.cd.model.GioiTinhSoap;
import org.oep.cmon.dao.cd.model.NgheNghiep;
import org.oep.cmon.dao.cd.model.NgheNghiepSoap;
import org.oep.cmon.dao.cd.model.QuanHeGiaDinh;
import org.oep.cmon.dao.cd.model.QuanHeGiaDinhSoap;
import org.oep.cmon.dao.cd.model.TinhTrangHonNhan;
import org.oep.cmon.dao.cd.model.TinhTrangHonNhanSoap;
import org.oep.cmon.dao.cd.model.TonGiao;
import org.oep.cmon.dao.cd.model.TonGiaoSoap;
import org.oep.cmon.dao.cd.model.TrinhDoChuyenMon;
import org.oep.cmon.dao.cd.model.TrinhDoChuyenMonSoap;
import org.oep.cmon.dao.cd.model.TrinhDoHocVan;
import org.oep.cmon.dao.cd.model.TrinhDoHocVanSoap;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.DanTocLocalServiceUtil;
import org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil;
import org.oep.cmon.dao.cd.service.NgheNghiepLocalServiceUtil;
import org.oep.cmon.dao.cd.service.QuanHeGiaDinhLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TinhTrangHonNhanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TonGiaoLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TrinhDoChuyenMonLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TrinhDoHocVanLocalServiceUtil;
import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh;
import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanhSoap;
import org.oep.cmon.dao.dn.service.NganhNgheKinhDoanhLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDungSoap;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhSoap;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;

import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungSoap;

import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLySoap;
import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh;
import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinhSoap;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLySoap;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinhSoap;
import org.oep.cmon.dao.qlhc.model.QuocGia;
import org.oep.cmon.dao.qlhc.model.QuocGiaSoap;
import org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil;




@WebService(targetNamespace = "http://citizen.provider.cmon.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.cmon.provider.citizen.ICitizenService", portName = "CitizenServiceImplPort", serviceName = "CitizenServiceImplService")
public class CitizenServiceImpl implements ICitizenService {
	private static Log log = LogFactoryUtil.getLog(CitizenServiceImpl.class);
	public Citizen getCitizenByUser(Long userId){
		try{
			log.info("1.====userLiferayId:"+userId);	
			TaiKhoanNguoiDung taiKhoanNguoiDung= TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(userId);
			if(taiKhoanNguoiDung != null){
				log.info("2.====taikhoannguoidungid:"+taiKhoanNguoiDung.getId());
				CongDan congDan = CongDanLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());
				if(congDan != null){
					log.info("3.====congdanid:"+congDan.getId());
					
					return getCongDanSoap(congDan);
				}else{
					log.info("====Khong tim thay cong dan voi taikhoanid:"+taiKhoanNguoiDung.getId());
				}
			}else{
				log.info("=====Khong tim thay tai khoan voi account:"+userId);
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.error("===lOI XAY RA", e);
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public Citizen getCitizenById(Long id){
		if(id == null) return null;
		try{
			
			CongDan congDan = CongDanLocalServiceUtil
					.fetchCongDan(id);
			
			if (congDan !=  null) {
				return  getCitizenByCode(congDan.getMa());
			}
	
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	
	public Citizen getCitizenByCode(String code){
		try{
			if(code == null) return null;
			CongDan congDan = CongDanLocalServiceUtil.findByMa(code);
			if(congDan == null) {
				log.info("=====Khong tim thaycong dan oi ma:"+code);
				return null;
			}
			return getCongDanSoap(congDan);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	private Citizen getCongDanSoap(CongDan congDan){
		try{
		CongDanSoap congDanSoap = CongDanSoap.toSoapModel(congDan);
		Citizen citizen = new Citizen();
		citizen.setCongDan(congDanSoap);
		
		

		if (congDan.getQuanHeChuHoId() != null) {
			citizen.setQuanHeChuHo(getQuanHeGiaDinhTheoId(congDan.getQuanHeChuHoId()));
		}

		
		if (congDan.getQuocTichId() != null) {
			//set quoc tich
			citizen.setQuocTich(getQuocGiaTheoId(congDan.getQuocTichId()));
		}

		

		if (congDan.getTrinhDoChuyenMonId() != null) {
			citizen.setTrinhDoChuyenMon(getTrinhDoChuyenMonTheoId(congDan.getTrinhDoChuyenMonId()));
		}
		
		
		if (congDan.getSoDinhDanhChaId() != null) {
			CongDan soDinhDanhCha = CongDanLocalServiceUtil
					.fetchCongDan(congDan.getSoDinhDanhChaId());
			if (soDinhDanhCha != null) {
				CongDanSoap congDanSoap2 = CongDanSoap
						.toSoapModel(soDinhDanhCha);
				citizen.setSoDinhDanhCha(congDanSoap2);
			}
		}
		
		if (congDan.getTrinhDoHocVanId() != null) {
			citizen.setTrinhDoHocVan(getTrinhDoHocVanTheoId(congDan.getTrinhDoHocVanId()));
		}
		
		if (congDan.getDanTocId() != null) {
			citizen.setDanToc(getDanTocTheoId(congDan.getDanTocId()));
		}
		

		
		if (congDan.getNgheNghiepId()!= null) {
			
			NgheNghiep ngheNghiep = NgheNghiepLocalServiceUtil
					.fetchNgheNghiep((new Long(congDan.getNgheNghiepId())).intValue());
			if (ngheNghiep != null) {
				NgheNghiepSoap ngheNghiepSoap = NgheNghiepSoap
						.toSoapModel(ngheNghiep);
				citizen.setNgheNghiep(ngheNghiepSoap);
			}
		}

		
		if (congDan.getTonGiaoId() != null) {
			citizen.setTonGiao(getTonGiaoTheoId(congDan.getTonGiaoId()));
		}

		
		if (congDan.getSoDinhDanhMeId() != null) {
			CongDan congDan2 = CongDanLocalServiceUtil.fetchCongDan((new Long(
					congDan.getSoDinhDanhMeId())).intValue());
			if (congDan2 != null) {
				CongDanSoap congDanSoap2 = CongDanSoap.toSoapModel(congDan2);
				citizen.setSoDinhDanhMe(congDanSoap2);
			}
		}

		
		if (congDan.getSoDinhDanhVoHoacChongId() != null) {
			CongDan congDan2 = CongDanLocalServiceUtil.fetchCongDan((new Long(
					congDan.getSoDinhDanhVoHoacChongId())).intValue());
			if (congDan2 != null) {
				CongDanSoap congDanSoap2 = CongDanSoap.toSoapModel(congDan2);
				citizen.setSoDinhDanhMe(congDanSoap2);
			}
		}

		
		if (congDan.getDiaChiHienNayTinhId() != null ) {
			citizen.setDiaChiHienNayTinh(getDonViHanhchinhTheoId(congDan.getDiaChiHienNayTinhId()));
		}
		
		if (congDan.getDiaChiHienNayHuyenId() != null) {
			citizen.setDiaChiHienNayHuyen(getDonViHanhchinhTheoId(congDan.getDiaChiHienNayHuyenId()));
			
		}
		if (congDan.getDiaChiHienNayXaId() != null) {
			citizen.setDiaChiHienNayXa(getDonViHanhchinhTheoId(congDan.getDiaChiHienNayXaId()));
			
		}
		
		if (congDan.getDiaChiThuongTruTinhId() != null) {
			citizen.setDiaChiThuongTruTinh(getDonViHanhchinhTheoId(congDan.getDiaChiThuongTruTinhId()));
			
		}
		
		if (congDan.getDiaChiThuongTruHuyenId() != null) {
			citizen.setDiaChiThuongTruHuyen(getDonViHanhchinhTheoId(congDan.getDiaChiThuongTruHuyenId()));				
		}
		if (congDan.getDiaChiThuongTruXaId() != null) {
			citizen.setDiaChiThuongTruXa(getDonViHanhchinhTheoId(congDan.getDiaChiThuongTruXaId()));				
		}
		// CongDanLocalServiceUtil.getCongDan(id)
		return citizen;
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}

	
	public DonViHanhChinhSoap[] getDSDonViHanhChinhTheoChaId(Long donviChaId)
			 {
		try{
			DonViHanhChinhSoap[] result = null;
			java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> donViHanhChinhs = null;
			if(donviChaId == null){
				donViHanhChinhs =  DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
			}else{
					donViHanhChinhs = DonViHanhChinhLocalServiceUtil
					.findByChaId(donviChaId,Constants.ACTIVATED);
			}
			if (donViHanhChinhs != null && donViHanhChinhs.size() > 0) {
				result = DonViHanhChinhSoap.toSoapModels(donViHanhChinhs);
			}
			
			return result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	@Override
	public DonViHanhChinhSoap getDonViHanhChinhTheoId(Long donviId)  {
		try{
			DonViHanhChinh donViHanhChinh = DonViHanhChinhLocalServiceUtil
					.fetchDonViHanhChinh(donviId);
			DonViHanhChinhSoap donViHanhChinhSoap = null;
			if (donViHanhChinh != null) {
				donViHanhChinhSoap = DonViHanhChinhSoap.toSoapModel(donViHanhChinh);
			}
			
			return donViHanhChinhSoap;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public DonViHanhChinhSoap getDonViHanhChinhTheoUserId(Long userid){
		try {
			
			List<TaiKhoanNguoiDung> cList = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDung(userid,Constants.ACTIVATED);
			if(cList != null && cList.size()>0){				
				TaiKhoanNguoiDung  account = cList.get(0);
				List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(account.getId());
				long coquanId = 0;
				if(congChucs.size() > 0 ){
					coquanId = congChucs.get(0).getCoQuanQuanLyId();
				}
				
				if(coquanId>0){
					
						CoQuanQuanLy coquan = CoQuanQuanLyLocalServiceUtil
								.fetchCoQuanQuanLy(coquanId);
						if(coquan != null){
							long donviId =coquan.getDonViHanhChinhId();
							if(donviId >0){
							 return getDonViHanhchinhTheoId(donviId);
							}
						}
				
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * This is function get DonViHanhChinh by donviChaId
	 * @param donviChaId
	 * @return null if not found, and info of DonViHanhChinh
	 * if donvichaId = null return all Tinh
	 */
	public DonViHanhChinhSoap[] getDanhsachDVHC(Long donviChaId ){
		return getDSDonViHanhChinhTheoChaId(donviChaId);
	}
	
	/**
	 * This is function get getDVHC by donviId
	 * @param donviId
	 * @return null if not found, and info of DonViHanhChinh
	 * if donvichaId = null return all Don Vi Hanh Chinh
	 */
	public DonViHanhChinhSoap getDVHC(Long donviId ){
		return getDonViHanhchinhTheoId(donviId);
	}
	
	@Override
	public DanTocSoap[] getDanhSachDanToc()  {
		try{
			List<DanToc> danTocs = DanTocLocalServiceUtil.findAll();
			DanTocSoap[] result = null;
	
			if (danTocs != null && danTocs.size() > 0) {
				result = DanTocSoap.toSoapModels(danTocs);
			}
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public QuocGiaSoap[] getDanhSachQuocGia()  {
		try{
			List<QuocGia> quocGias = QuocGiaLocalServiceUtil.findAll();
			QuocGiaSoap[] result = null;
	
			if (quocGias != null && quocGias.size() > 0) {
				result = QuocGiaSoap.toSoapModels(quocGias);
			}
	
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ThuTucHanhChinhSoap[] getDanhSachThucTucHanhChinh(){
		try{
			ThuTucHanhChinhSoap[] thuTucHanhChinhSoaps = null;
			 //List<ThuTucHanhChinh> hanhChinhs = ThuTucHanhChinhLocalServiceUtil.findAll();;
			List<ThuTucHanhChinh> hanhChinhs = ThuTucHanhChinhLocalServiceUtil.findByTrangThai(Constants.ACTIVATED);
			 if(hanhChinhs!=null){
				 thuTucHanhChinhSoaps = ThuTucHanhChinhSoap.toSoapModels(hanhChinhs);
			 }
			return thuTucHanhChinhSoaps;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NganhNgheKinhDoanhSoap[] getDanhSachNganhNgheKinhDoanh(long cap){
		try{
			NganhNgheKinhDoanhSoap[] nganhNgheKinhDoanhSoaps = null;
			List<NganhNgheKinhDoanh> kinhDoanhs= NganhNgheKinhDoanhLocalServiceUtil.findByCap(cap,Constants.ACTIVATED);
			if(kinhDoanhs!=null){
				nganhNgheKinhDoanhSoaps = NganhNgheKinhDoanhSoap.toSoapModels(kinhDoanhs);
			}
			return nganhNgheKinhDoanhSoaps;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * This is function get nganhnghekinhdoanh by code
	 */
	public  NganhNgheKinhDoanhSoap getNganhNgheKinhDoanhTheoMa(String ma){
		try{
		
		NganhNgheKinhDoanh kinhDoanh = NganhNgheKinhDoanhLocalServiceUtil
				.findByCode(ma, Constants.ACTIVATED);
		
		if(kinhDoanh != null){
			return NganhNgheKinhDoanhSoap.toSoapModel(kinhDoanh);
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	
   public Long getAutoIncrement(){
	   try {
		return CounterLocalServiceUtil.increment("CMON_HOSOTTHCCONG_AUTO_INCREMENT");
	} catch (SystemException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return null;
   }
   
   public Long getCitizenId(){
	   try {
			return CounterLocalServiceUtil.increment(Citizen.class.getName());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return 0L;
   }
   
   /**
	* Returns all the nganh nghe kinh doanh
	*
	* @return the nganh nghe kinh doanh
	* @throws SystemException if a system exception occurred
	*/
	public GioiTinhSoap[] getDSGioiTinh(){
		try{
			return GioiTinhSoap.toSoapModels(GioiTinhLocalServiceUtil.getDSGioiTinh());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public CoQuanQuanLySoap[] getDSCoQuanQuanLyTheoTTHC(Long thuTucHanhChinhId){
		try{
			List<TTHC2CoQuanQuanLy> cList = TTHC2CoQuanQuanLyLocalServiceUtil
					.getDSTTHC2CoQuanQuanLy(thuTucHanhChinhId, Constants.ACTIVATED);
			if(cList != null){
				List<CoQuanQuanLy> result = new ArrayList<CoQuanQuanLy>();
				for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : cList) {
					try {
						CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
								.getCoQuanQuanLy(tthc2CoQuanQuanLy.getCoQuanQuanLyId());
						result.add(coQuanQuanLy);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
				}
				return CoQuanQuanLySoap.toSoapModels(result);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public CoQuanQuanLySoap getCoQuanQuanLyTheoId(Long id){
		try {
			return CoQuanQuanLySoap.toSoapModel(
					CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(id));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	public CoQuanQuanLySoap getCoQuanQuanLyTheoUserId(Long liferayUserid){
		try {
			
			List<TaiKhoanNguoiDung> cList = TaiKhoanNguoiDungLocalServiceUtil
					.findByTaiKhoanNguoiDung(liferayUserid,Constants.ACTIVATED);
			
			if(cList != null && cList.size()>0){				
				TaiKhoanNguoiDung  account = cList.get(0);
				List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(account.getId());
				//long coquanId = account.getCoQuanQuanLyId();
				if(congChucs.size() > 0 ){
					long coquanId = congChucs.get(0).getCoQuanQuanLyId();
					return CoQuanQuanLySoap.toSoapModel(CoQuanQuanLyLocalServiceUtil
							.fetchCoQuanQuanLy(coquanId));
				}				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/** 
	 * 
	 */
	public CoQuanQuanLySoap[] getCoQuanQuanLyTheoChaId(Long chaId){
		try{
			List<CoQuanQuanLy> cList = CoQuanQuanLyLocalServiceUtil
					.findByParentId(chaId, Constants.ACTIVATED);
			if(cList != null){
				return CoQuanQuanLySoap.toSoapModels(cList);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public CoQuanQuanLySoap[] getDSCoQuanQLTheoCapCoQuanQLId(Long capCoQuanQuanLyId){
		try{
			List<CoQuanQuanLy> cList = CoQuanQuanLyLocalServiceUtil
					.findByCapCoQuanQuanLyId(capCoQuanQuanLyId, Constants.ACTIVATED);
			if(cList != null){
				return CoQuanQuanLySoap.toSoapModels(cList);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public CapCoQuanQuanLySoap getCapCoQuanQuanLyTheoId(Long id){
		try {
			return CapCoQuanQuanLySoap.toSoapModel(
					CapCoQuanQuanLyLocalServiceUtil
					.fetchCapCoQuanQuanLy(id));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	public DoiTuongSuDungSoap[] getDSLoaiDoiTuong(){
		try{
			List<DoiTuongSuDung> dList = DoiTuongSuDungLocalServiceUtil
					.getDSDoiTuongSuDung(Constants.ACTIVATED);
			if(dList != null){
				return DoiTuongSuDungSoap.toSoapModels(dList);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public DonViHanhChinhSoap getDonViHanhchinhTheoId(Long id){
		DonViHanhChinh chinh;
		try {
			chinh = DonViHanhChinhLocalServiceUtil
					.fetchDonViHanhChinh(id);
			if(chinh != null){
				return DonViHanhChinhSoap.toSoapModel(chinh);
			}else{
				chinh = DonViHanhChinhLocalServiceUtil
						.fetchDonViHanhChinh(id);
				if(chinh != null){
					return DonViHanhChinhSoap.toSoapModel(chinh);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public DonViHanhChinhSoap[] getDSDVHCTheoCapDVHCId(Long capDVHCId){
		try{
			List<DonViHanhChinh> dList = DonViHanhChinhLocalServiceUtil
					.getDSDonViHanhChinhTheoCapId(capDVHCId, Constants.ACTIVATED);
			if(dList != null){
				return DonViHanhChinhSoap.toSoapModels(dList);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public CapDonViHanhChinhSoap getCapDonViHanhChinhTheoId(Long id){
	    CapDonViHanhChinh cap;
		try {
			cap = CapDonViHanhChinhLocalServiceUtil.
					fetchCapDonViHanhChinh(id);
			if(cap != null){
		    	return CapDonViHanhChinhSoap.toSoapModel(cap);
		    	
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
	}
	
	
	@Override
	public GioiTinhSoap getGioiTinhTheoId(Long id) {
		// TODO Auto-generated method stub
		try {
			return GioiTinhSoap.toSoapModel(GioiTinhLocalServiceUtil.getGioiTinh(id));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}

	@Override
	public DanTocSoap getDanTocTheoId(Long id) {
		// TODO Auto-generated method stub
		try {
			return DanTocSoap.toSoapModel(DanTocLocalServiceUtil.getDanToc(id));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}

	@Override
	public QuocGiaSoap getQuocGiaTheoId(Long id) {
		// TODO Auto-generated method stub
		try {
			return QuocGiaSoap.toSoapModel(QuocGiaLocalServiceUtil.getQuocGia(id));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	public TinhTrangHonNhanSoap[] getDSTinhTrangHonNhan(){
		try{
			List<TinhTrangHonNhan> result = TinhTrangHonNhanLocalServiceUtil.getAll(Constants.ACTIVATED);
			if (result != null) {
				return TinhTrangHonNhanSoap.toSoapModels(result);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public TinhTrangHonNhanSoap getTinhTrangHonNhanTheoId(Long id){
		  
			try {
				 TinhTrangHonNhan honNhan= TinhTrangHonNhanLocalServiceUtil.
						 fetchTinhTrangHonNhan(id);
				 if(honNhan != null){
					 return TinhTrangHonNhanSoap.toSoapModel(honNhan);
				 }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    return null;
	}
	
	public TrinhDoHocVanSoap[] getDSTrinhDoHocVan(){
		try{
			List<TrinhDoHocVan> result = TrinhDoHocVanLocalServiceUtil.findByStatus(Constants.ACTIVATED);
			if (result != null) {
				return TrinhDoHocVanSoap.toSoapModels(result);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
    public TrinhDoHocVanSoap getTrinhDoHocVanTheoId(Long id){
    	try {
    		TrinhDoHocVan honNhan= TrinhDoHocVanLocalServiceUtil.
					 fetchTrinhDoHocVan(id);
			 if(honNhan != null){
				 return TrinhDoHocVanSoap.toSoapModel(honNhan);
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
    }
	
    
    public TrinhDoChuyenMonSoap[] getDSTrinhDoChuyenMon(){
    	try{
			List<TrinhDoChuyenMon> result = TrinhDoChuyenMonLocalServiceUtil.findByStatus(Constants.ACTIVATED);
			if (result != null) {
				return TrinhDoChuyenMonSoap.toSoapModels(result);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
    	
    }
    public TrinhDoChuyenMonSoap getTrinhDoChuyenMonTheoId(Long id){
    	try {
    		TrinhDoChuyenMon honNhan= TrinhDoChuyenMonLocalServiceUtil.
					 fetchTrinhDoChuyenMon(id);
			 if(honNhan != null){
				 return TrinhDoChuyenMonSoap.toSoapModel(honNhan);
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
    }
    
    
    public TonGiaoSoap[] getDSTonGiao(){
    	try{
			List<TonGiao> result = TonGiaoLocalServiceUtil.findByStatus(Constants.ACTIVATED);
			if (result != null) {
				return TonGiaoSoap.toSoapModels(result);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
    }
    public TonGiaoSoap getTonGiaoTheoId(Long id){
    	try {
    		TonGiao result= TonGiaoLocalServiceUtil.
					 fetchTonGiao(id);
			 if(result != null){
				 return TonGiaoSoap.toSoapModel(result);
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
    }
    
    public QuanHeGiaDinhSoap[] getDSQuanHeGiaDinh(){
    	try{
			List<QuanHeGiaDinh> result = QuanHeGiaDinhLocalServiceUtil.findByStatus(Constants.ACTIVATED);
			if (result != null) {
				return QuanHeGiaDinhSoap.toSoapModels(result);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
    }
    public QuanHeGiaDinhSoap getQuanHeGiaDinhTheoId(Long id){
    	try {
    		QuanHeGiaDinh result= QuanHeGiaDinhLocalServiceUtil.
					 fetchQuanHeGiaDinh(id);
			 if(result != null){
				 return QuanHeGiaDinhSoap.toSoapModel(result);
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
    }
    
    
    public CongChucSoap[] getDSCongChuc(){
    	try{
			List<CongChuc> result = CongChucLocalServiceUtil.findByStatus(Constants.ACTIVATED);
			if (result != null) {
				return CongChucSoap.toSoapModels(result);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
    }
    public CongChucSoap getCongChucTheoId(Long id){
    	try {
    		CongChuc result= CongChucLocalServiceUtil.
					 fetchCongChuc(id);
			 if(result != null){
				 return CongChucSoap.toSoapModel(result);
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
    }
    
    
    public CongChucSoap getCongChucTheoUserId(Long liferayUserId){
    	
    		try {
    			TaiKhoanNguoiDungSoap tSoap =getTaiKhoanNguoiDungTheoUserId(liferayUserId);
    	    	
    	    	if(tSoap != null){
    	    		List<CongChuc> cList = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(tSoap.getId());
    	    		if(cList != null && cList.size()>0){
    	    			return CongChucSoap.toSoapModel(cList.get(0));
    	    		}
    	    	}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				
			
    	}
    	
    	return null;
    }
    public ChucVuSoap getChucVuTheoId(Long chucVuId){
    	try{
    		return ChucVuSoap.toSoapModel(ChucVuLocalServiceUtil.fetchChucVu(chucVuId));
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }
    
    public  TaiKhoanNguoiDungSoap getTaiKhoanNguoiDungTheoUserId(Long liferayUserId){
    	try {
			return TaiKhoanNguoiDungSoap.toSoapModel(SharedserviceUtil
								.getTaiKhoanNguoiDungByLiferayId(liferayUserId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		} 
    	return null;
    }

}
