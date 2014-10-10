package org.oep.cmon.job.business;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.oep.cmon.job.util.DateUtil;
import org.oep.cmon.user.portlet.util.ElectricCodeGeneratorUtil;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.model.CongDanClp;
import org.oep.cmon.dao.cd.model.GioiTinh;

import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;

/** 
 * This is class CitizenBs
 * 
 * This class will create a citizen in in  database
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  27-May-2013  Nam Dinh    Create new
 */
public class CitizenBs {
	
	/**
	 * This is  function createCitizen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param fullName
	 * @param soCmnd
	 * @param ngaySinh
	 * @param gioiTinh
	 * @param provinceCode
	 * @param motaDiaChi
	 * @throws SystemException
	 * @throws PortalException
	 * @return CongDan
	 */  
	public CongDan createCitizen(String fullName, String soCmnd, String ngaySinh, int gioiTinh, String provinceCode, String motaDiaChi) throws SystemException, PortalException {
		String[] nameElements = this.splitFullName(fullName);
		
		CongDan congDan = new CongDanClp();
		
		congDan.setId(CounterLocalServiceUtil.increment("csms_congdan"));
		
		long provinceId = 1;
		try {
			List<AnhXa> listAnhXa = AnhXaLocalServiceUtil.getDNGFromMaKhacTTHC(provinceCode.trim(), "CMON_DONVIHANHCHINH");
			if (listAnhXa.size() > 0) {
				provinceId = DonViHanhChinhLocalServiceUtil.findByMaDVHC(listAnhXa.get(0).getMaDNG()).getId();
			} else {
				provinceId = DonViHanhChinhLocalServiceUtil.findByMaDVHC(provinceCode).getId();
			}
		} catch (Exception e) {
			provinceId = 1;
		}
		
		// Generate ma so cong dan
		String maCongDan = ElectricCodeGeneratorUtil.generateCode(provinceCode, DateUtil.parseDate(ngaySinh), provinceId); 
		// Tam comment lai vi BA dua du lieu mac dinh sinh Ma bang cach dua excel tang tuan tu.
		
		congDan.setMa(maCongDan);
		
		// Handle HO, DEM, TEN
		congDan.setHo(nameElements[0]);
		
		if ( nameElements.length < 3) {
			// Ten cong dan
			congDan.setTen(nameElements[1]);
		} else {
			String dem = nameElements[1];
			for ( int i = 2; i < nameElements.length - 1; i ++) {
				dem  = dem + StringPool.SPACE + nameElements[i];
				
			}
			
			dem = dem.trim();
						
			congDan.setDem(dem);
			
			congDan.setTen(nameElements[nameElements.length - 1]);
		}
		congDan.setQuocTichId(1L);
		congDan.setDiaChiThuongTruTinhId(provinceId);
		congDan.setTenDayDu(congDan.getHo() + StringPool.SPACE + congDan.getDem() + StringPool.SPACE + congDan.getTen());
		
		congDan.setDiaChiThuongTru(motaDiaChi);
		
		congDan.setNgaySinh(DateUtil.parseDate(ngaySinh));
		
		// Handle giơi tinh
		GioiTinh gioiTinhDb = null;
		
		if ( gioiTinh == 0) {
			String gioiTinhMacDinhMale = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CONG_DAN_GIOI_TINH_MAC_DINH_M");
			gioiTinhDb = GioiTinhLocalServiceUtil.findByMa(gioiTinhMacDinhMale);			
		} else if (gioiTinh == 1) {
			String gioiTinhMacDinhFemale = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CONG_DAN_GIOI_TINH_MAC_DINH_F");
			gioiTinhDb = GioiTinhLocalServiceUtil.findByMa(gioiTinhMacDinhFemale);
		} else {
			String gioiTinhMacDinhKhongXacDinh = WebserviceFactory.getThamSoService().getValue("CMON_JOB_CONG_DAN_GIOI_TINH_MAC_DINH_U");
			gioiTinhDb = GioiTinhLocalServiceUtil.findByMa(gioiTinhMacDinhKhongXacDinh);
		}
		
		congDan.setGioiTinh((int)gioiTinhDb.getId());
		
		// So chung minh nhan dan
		congDan.setSoCmnd(soCmnd);
		
		Date currentDate = new Date();
		
		congDan.setNgayTao(currentDate);
		
		congDan.setNguoiTao("INTEGRATION BATCH");
		
		congDan.setNgaySua(currentDate);
		
		congDan.setNguoiSua("INTEGRATION BATCH");
		
		congDan.setDaXoa(0);
		
		try {
			CongDanLocalServiceUtil.addCongDan(congDan);
		} catch (Exception e) {
			e.printStackTrace();
			congDan = CongDanLocalServiceUtil.findByMa(maCongDan);
		}
		
		return congDan;	
	}	
	
	/**
	 * This is  function runActivity
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param fullName
	 * @param soCmnd
	 * @param ngaySinh
	 * @throws ParseException
	 * @return CongDan
	 */  
	public CongDan getCitizen(String fullName, String soCmnd, String ngaySinh) throws ParseException{

		Date birthDay = DateUtil.parseDate(ngaySinh);
		
		fullName = fullName.toUpperCase();
		
		// Check in database if there's existing person with the same birth day and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("tenDayDu").eq(fullName));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("soCmnd").eq(soCmnd));
		
		List<CongDan> results = null;
		
		try {
			results = CongDanLocalServiceUtil.dynamicQuery(queryCongDan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( results == null ||  results.size() < 1) {
			return null;
		}
		
		// Return the citizen entity
		return (results.get(0));
	}
	
	/**
	 * This is  function splitFullName
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param fullName
	 * @return String[]
	 */  
	private String[] splitFullName(String fullName){
		String[] nameElements = fullName.split(StringPool.SPACE);
		
		for (int i = 0; i < nameElements.length; i++ ){
			nameElements[i] = nameElements[i].toUpperCase().trim();
		}
		
		return nameElements;
	}

}
