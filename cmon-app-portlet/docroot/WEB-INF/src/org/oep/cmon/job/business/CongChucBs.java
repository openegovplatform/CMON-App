package org.oep.cmon.job.business;

import java.util.Date;
import java.util.List;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.ChucVuClp;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.CongChucClp;

import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.NoSuchGioiTinhException;
import org.oep.cmon.dao.cd.model.GioiTinh;
import org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.NoSuchQuocGiaException;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/** 
 * This is class CongChucBs
 * 
 * This class will create a can bo in database
 * in  database
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  27-May-2013  Nam Dinh    Create new
 */
public class CongChucBs {
	
	/**
	 * This is  function getCongChuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maCongChuc
	 * @throws SystemException
	 * @return CongChuc
	 */  
	public CongChuc getCongChuc(String maCongChuc) throws SystemException {
		List<CongChuc> congChucLst = CongChucLocalServiceUtil.findByMa(maCongChuc);
		
		if ( congChucLst.size() < 1) {
			return null;
			
		}
		
		return congChucLst.get(0);		
	}
	
	/**
	 * This is  function createCongChuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param code
	 * @param name
	 * @param maDonViTiepNhan
	 * @throws SystemException
	 * @throws NoSuchGioiTinhException
	 * @throws NoSuchQuocGiaException
	 * @return CongChuc
	 */  
	public CongChuc createCongChuc(String code, String name, String maDonViTiepNhan) throws SystemException, NoSuchGioiTinhException, NoSuchQuocGiaException {
		
		// Get co quan
		//List<CoQuanQuanLy> coQuanLst = CoQuanQuanLyLocalServiceUtil.findByMa(maDonViTiepNhan);
		List<AnhXa> listAnhXaCoQuanQuanLy = AnhXaLocalServiceUtil.getDNGFromMaKhacCQQL(maDonViTiepNhan, "CMON_COQUANQUANLY");
		List <CoQuanQuanLy> coQuanLst = CoQuanQuanLyLocalServiceUtil.findByMa(listAnhXaCoQuanQuanLy.get(0).getMaDNG());
		
		CoQuanQuanLy coQuan = coQuanLst.get(0);
		
		return this.createCongChuc(code, name, coQuan.getId());
	}
	
	/**
	 * This is  function createCongChuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param code
	 * @param name
	 * @param maDonViTiepNhan
	 * @throws SystemException
	 * @throws NoSuchGioiTinhException
	 * @throws NoSuchQuocGiaException
	 * @return CongChuc
	 */  
	public CongChuc createCongChuc(String code, String name, long donViTiepNhan) throws SystemException, NoSuchGioiTinhException, NoSuchQuocGiaException {
		CongChuc canBo = new CongChucClp();
		
		canBo.setId(CounterLocalServiceUtil.increment("cmon_congchuc"));
		
		String gioiTinhMacDinh = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CONG_CHUC_GIOI_TINH_MAC_DINH_M");
		String chucVuMacDinh = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CHUC_VU_MAC_DINH_OSS_DE_DUNG_LOGIC");
		
		// Get gioi tinh
		GioiTinh gioiTinh = GioiTinhLocalServiceUtil.findByMa(gioiTinhMacDinh); // Default is male		
		
		// Get chuc vu
		List<ChucVu> chucVuLst  = ChucVuLocalServiceUtil.findMa(chucVuMacDinh);
		if (chucVuLst.size() == 0) {
			try {
				ChucVu doiTuongSuDung = new ChucVuClp();
				doiTuongSuDung.setId(CounterLocalServiceUtil.increment(ChucVu.class.getName()));
				doiTuongSuDung.setTen(chucVuMacDinh);
				doiTuongSuDung.setMa(chucVuMacDinh);
				doiTuongSuDung.setNgaySua(new Date());
				doiTuongSuDung.setNguoiSua("test@liferay.com.vn");
				doiTuongSuDung.setNgayTao(new Date());
				doiTuongSuDung.setNguoiTao("test@liferay.com.vn");
				ChucVuLocalServiceUtil.addChucVu(doiTuongSuDung);
				chucVuLst  = ChucVuLocalServiceUtil.findMa(chucVuMacDinh);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		ChucVu chucVu = chucVuLst.get(0);
		
		// Gioi tinh, default is Male
		canBo.setGioiTinhId(gioiTinh.getId());
		
		// Default chuc vu
		canBo.setChucVuId(chucVu.getId());
		
		// Co quan quan ly
		canBo.setCoQuanQuanLyId(donViTiepNhan);
		
		// 
		canBo.setMa(code);
		
		canBo.setHoVaTen(name);
		
		// Get current date
		Date currentDate = new Date();
		
		canBo.setNgaySinh(currentDate);
		
		canBo.setNgaySua(currentDate);
		
		canBo.setNgayTao(currentDate);
		
		canBo.setNguoiTao("INTEGRATION BATCH");
		
		canBo.setNguoiSua("INTEGRATION BATCH");
		
		canBo.setDaXoa(0);
		
		// Add to DB		
		CongChucLocalServiceUtil.addCongChuc(canBo);
		
		return canBo;		
	}
}
