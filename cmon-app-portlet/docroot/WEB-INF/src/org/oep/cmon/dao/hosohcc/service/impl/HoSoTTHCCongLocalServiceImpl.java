/*
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oep.cmon.dao.hosohcc.service.impl;

import java.util.Date;
import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.hosohcc.model.impl.HoSoTTHCCongImpl;
import org.oep.cmon.dao.hosohcc.service.base.HoSoTTHCCongLocalServiceBaseImpl;
import org.oep.cmon.util.CmonFields;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.persistence.HoSoTTHCCongFinderUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
/**
*
* HoSoTTHCCongLocalServiceImpl class
*   
* This class is used to get HoSoTTHCCong information 
* from database
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class HoSoTTHCCongLocalServiceImpl
	extends HoSoTTHCCongLocalServiceBaseImpl {
	
	public static final String FIELD_MASOBIENNHAN = "maSoBienNhan";
	
	/*
	 * @TODO Fetch HoSoTTHCCong by maSoBienNhan
	 */
	/**
	  * This is fucntion fetchByMaSoBienNhan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoBienNhan
	  * @return HoSoTTHCCong
	  */
	@SuppressWarnings("unchecked")
	public HoSoTTHCCong fetchByMaSoBienNhan(String maSoBienNhan) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			HoSoTTHCCongImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(FIELD_MASOBIENNHAN).eq(maSoBienNhan));
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(Constants.ACTIVE));
		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>) hoSoTTHCCongPersistence
			.findWithDynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return (list.isEmpty()) ? null : list.get(0);
	}	

	/**
	  * This is fucntion countByMaCongDanHoSo_QT
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long congDanNopId, String maSoHoSo, long thuTucHanhChinhId
	  * @return long
	  */
	public long countByMaCongDanHoSo_QT(long congDanNopId, String maSoHoSo, long thuTucHanhChinhId) throws SystemException{
		return HoSoTTHCCongFinderUtil.countByMaCongDanHoSo_QT(congDanNopId, maSoHoSo, thuTucHanhChinhId);
	}
	
	/**
	  * This is fucntion searchByMaCongDanHoSo_QT 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long congDanNopId, String maSoHoSo, long thuTucHanhChinhId, param paging (start, end)
	  * @return List<HoSoTTHCCong>
	  */
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchByMaCongDanHoSo_QT(
		long congDanNopId,
		String maSoHoSo,
		long thuTucHanhChinhId,
		int start,
		int end
	) throws SystemException{
		return HoSoTTHCCongFinderUtil.findByMaCongDanHoSo_QT(congDanNopId, maSoHoSo, thuTucHanhChinhId, start, end) ;
	}
	
	/**
	  * This is fucntion findByCQQL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo,	long thuTucHanhChinhId,	String maUngDung,long cqqlId,int trangThai,	int start,int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findByCQQL(
		String maSoHoSo,
		long thuTucHanhChinhId,
		String maUngDung,
		long cqqlId,
		int trangThai,
		int start,
		int end
	) throws SystemException {
		return HoSoTTHCCongFinderUtil.findByCQQL(maSoHoSo,thuTucHanhChinhId,maUngDung, cqqlId,trangThai, start, end);
	}
	
	/**
	  * This is fucntion findByMutilStatusAndTTHC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String tthcsIds,	String maSoHoSo,long idCanBo,String maUngDung,
	  *		long cqqlId,
	  *		String trangThais,
	  *		int yeuCauRut,
	  *		String tuNgay,
	  *		String denNgay, 
	  *		int start,
	  *		int end
	  * @return List<HoSoTTHCCong>
	  */
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMutilStatusAndTTHC(
		String tthcsIds,
		String maSoHoSo,
		long idCanBo,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		String tuNgay,
		String denNgay, 
		int start,
		int end
	) throws com.liferay.portal.kernel.exception.SystemException {
		return HoSoTTHCCongFinderUtil.findByMutilStatusAndTTHC(
			tthcsIds, maSoHoSo, idCanBo, maUngDung, cqqlId, trangThais, yeuCauRut,tuNgay,denNgay, start, end);
	}
	
	/**
	  * This is fucntion findByCBXLMutilStatusAndTTHC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo,
		String thuTucHanhChinhIds,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCBXLMutilStatusAndTTHC(
		String maSoHoSo,
		String thuTucHanhChinhIds,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		int start,
		int end
	) throws com.liferay.portal.kernel.exception.SystemException {
		return hoSoTTHCCongFinder.getDSCongChuc2ThuTuc(
			maSoHoSo, thuTucHanhChinhIds, maUngDung, cqqlId, trangThais, yeuCauRut, start, end);
	}
	
	/**
	  * This is fucntion countByCQQL 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo,long thuTucHanhChinhId, String maUngDung,long cqqlId, int trangThai
	  * @return int
	  */
	public int countByCQQL(String maSoHoSo,long thuTucHanhChinhId, String maUngDung,long cqqlId, int trangThai) throws SystemException {
		return HoSoTTHCCongFinderUtil.countByCQQL(maSoHoSo,thuTucHanhChinhId,maUngDung, cqqlId, trangThai);
	}
	
	/**
	  * This is fucntion countHoSoTTHCCongByCoQuanQuanLy 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo, int trangThaiHoSo, long cqqlId
	  * @return long
	  */
	public long countHoSoTTHCCongByCoQuanQuanLy(String maSoHoSo, int trangThaiHoSo, long cqqlId) {
		return HoSoTTHCCongFinderUtil.countHoSoTTHCCongByCoQuanQuanLy(maSoHoSo, trangThaiHoSo, cqqlId);
	}
	
	/**
	  * This is fucntion countByMutilStatusAndTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String tthcsIds,
		String maSoHoSo,
		long idCanBo,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return int
	  */
	public int countByMutilStatusAndTTHC(
		String tthcsIds,
		String maSoHoSo,
		long idCanBo,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) {
		return HoSoTTHCCongFinderUtil.countByMutilStatusAndTTHC(tthcsIds, maSoHoSo, idCanBo, maUngDung,
			cqqlId, trangThais, yeuCauRut, tuNgay, denNgay, start, end);
	}
	
	/**
	  * This is fucntion findHoSoTTHCCong 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo,	int trangThaiHoSo, long cqqlId, int start, int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findHoSoTTHCCong(String maSoHoSo,	int trangThaiHoSo, long cqqlId, int start, int end) {
		return HoSoTTHCCongFinderUtil.findHoSoTTHCCong(maSoHoSo, trangThaiHoSo, cqqlId, start, end);
	}
	
	/**
	  * This is fucntion updateHOSOTTHCCONGById 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, int status
	  * @return int
	  */
	public int updateHOSOTTHCCONGById(long hoSoTTHCCongId, int status) throws SystemException {
		return HoSoTTHCCongFinderUtil.updateHOSOTTHCCONGById(hoSoTTHCCongId, status);
	}

	/**
	  * This is fucntion findByMaSoHoSo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findByMaSoHoSo(String maSoHoSo) throws SystemException {
		return hoSoTTHCCongPersistence.findBymaSoHoSo(maSoHoSo);
	}
	
	/**
	  * This is fucntion findByMaSoBienNhan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoBienNhan
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findByMaSoBienNhan(String maSoBienNhan) throws SystemException {
		return hoSoTTHCCongPersistence.findBymaSoBienNhan(maSoBienNhan);
	}
	
	/**
	  * This is fucntion findByLoaiHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int loaiHoSo
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findByLoaiHoSo(int loaiHoSo) throws SystemException {
		return hoSoTTHCCongPersistence.findByLoaiHoSo(loaiHoSo);
	}
	
	/**
	  * This is fucntion findByLoaiHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int loaiHoSo, int start, int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findByLoaiHoSo(int loaiHoSo, int start, int end) throws SystemException {
		return hoSoTTHCCongPersistence.findByLoaiHoSo(loaiHoSo, start, end);
	}
	
	/**
	  * This is fucntion capNhatTrangThai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long id, int status
	  * @return HoSoTTHCCong
	  */
	public HoSoTTHCCong capNhatTrangThai(Long id, int status) {
		try {
			HoSoTTHCCong tthcCong = hoSoTTHCCongPersistence.findByPrimaryKey(id);
			tthcCong.setTrangThaiHoSo(status);	
			
			if(status == 6){
				tthcCong.setNgayKetThucXuLy(new Date());
			}
			
			hoSoTTHCCongPersistence.update(tthcCong, true);
			return tthcCong;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	/**
	  * This is fucntion searchHSDangXuLy 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo,
		long thuTucHanhChinhId,
		int status,
		String emailCanBo,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> searchHSDangXuLy(
		String maSoHoSo,
		long thuTucHanhChinhId,
		int status,
		String emailCanBo,
		int start,
		int end
	) throws com.liferay.portal.kernel.exception.SystemException {
		return HoSoTTHCCongFinderUtil.searchHSDangXuLy(maSoHoSo, thuTucHanhChinhId, status, emailCanBo, start, end);
	}

	/**
	  * This is fucntion countHSDangXuLy
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param tring maSoHoSo, long thuTucHanhChinhId, int status, String emailCanBo, int start, int end
	  * @return int
	  */
	public int countHSDangXuLy(String maSoHoSo, long thuTucHanhChinhId, int status, String emailCanBo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return HoSoTTHCCongFinderUtil.countHSDangXuLy(maSoHoSo, thuTucHanhChinhId, status, emailCanBo, start, end);
	}
	
	/**
	  * This is fucntion searchHSDangXuLyMutilStatusAndTTHC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status, 
		String emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> searchHSDangXuLyMutilStatusAndTTHC(
		String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status, 
		String emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) throws SystemException {
		return HoSoTTHCCongFinderUtil.searchHSDangXuLyMutilStatusAndTTHC(
			maSoOrTenNguoiNopHoSo, thuTucHanhChinhIds, status, emailCanBo, tuNgay, denNgay, start, end);
	}
	
	/**
	  * This is fucntion countHSDangXuLyMutilStatusAndTTHC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoOrTenNguoiNopHoSo, 
		String thuTucHanhChinhIds,
		String status,
		String emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return int
	  */
	public int countHSDangXuLyMutilStatusAndTTHC(
		String maSoOrTenNguoiNopHoSo, 
		String thuTucHanhChinhIds,
		String status,
		String emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) throws SystemException {
		return HoSoTTHCCongFinderUtil.countHSDangXuLyMutilStatusAndTTHC(
			maSoOrTenNguoiNopHoSo, thuTucHanhChinhIds, status, emailCanBo,tuNgay,denNgay, start, end);
	}
	
	/**
	  * This is fucntion searchAllHSDangXuLyMutilStatusAndTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		List<String> emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> searchAllHSDangXuLyMutilStatusAndTTHC(
		String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		List<String> emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) throws SystemException {
		return hoSoTTHCCongFinder.searchAllHSDangXuLyMutilStatusAndTTHC(
			maSoOrTenNguoiNopHoSo, thuTucHanhChinhIds, status, emailCanBo, tuNgay, denNgay, start, end);
	}
	
	/**
	  * This is fucntion countAllHSDangXuLyMutilStatusAndTTHC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		List<String> emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return int
	  */
	public int countAllHSDangXuLyMutilStatusAndTTHC(
		String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		List<String> emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) throws SystemException {
		return HoSoTTHCCongFinderUtil.countAllHSDangXuLyMutilStatusAndTTHC(
			maSoOrTenNguoiNopHoSo, thuTucHanhChinhIds, status, emailCanBo, tuNgay, denNgay, start, end);
	}
	
	/**
	  * This is fucntion findByTrangThaiHoSo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int trangThaiHoSo, Long coQuanTiepNhanId
	  * @return List<HoSoTTHCCong>
	  */
	public java.util.List<HoSoTTHCCong> findByTrangThaiHoSo(int trangThaiHoSo, Long coQuanTiepNhanId){
		try {
			return hoSoTTHCCongPersistence.findByTrangThaiHoSo(trangThaiHoSo, 0, coQuanTiepNhanId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	  * This is fucntion findByThutucId_CongDanId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long thutucId, Long congdanId
	  * @return List<HoSoTTHCCong>
	  */
	public java.util.List<HoSoTTHCCong> findByThutucId_CongDanId(Long thutucId, Long congdanId){
		try{
			return hoSoTTHCCongPersistence.findByThuTuc_CongDan(thutucId, congdanId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}