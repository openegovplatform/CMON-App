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


package org.oep.cmon.dao.dvc.service.impl;

import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.dvc.model.impl.ThuTucHanhChinhImpl;
import org.oep.cmon.dao.dvc.service.base.ThuTucHanhChinhLocalServiceBaseImpl;
import org.oep.cmon.util.CmonFields;

import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc;
import org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.VanBanHuongDan;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;


/**
 * The implementation of the thu tuc hanh chinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.dvc.service.base.ThuTucHanhChinhLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil
 */
/**
*
* ThuTucHanhChinhLocalServiceImpl class
*   
* This class is used to get ThongTinThuTuc information 
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
public class ThuTucHanhChinhLocalServiceImpl
	extends ThuTucHanhChinhLocalServiceBaseImpl {
	
	public static final String FIELD_NHOMTHUTUCID = "nhomThuTucHanhChinhId";
	public static final String FIELD_THUTUCLIENTHONGID = "thuTucLienThongId";
	/**
	  * This is fucntion get ThongTinThuTuc by ungDungId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long ungDungId
	  * @return List<ThongTinThuTuc>
	  */
	public List<ThongTinThuTuc> getDSThongTinThuTucByUngDung(long ungDungId) throws Exception {
		return thuTucHanhChinhFinder.getDSThongTinThuTucByUngDung(ungDungId);
	}
	/**
	  * This is fucntion count ThuTucHanhChinh by thuTucLienThongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucLienThongId
	  * @return long
	  */
	public long countByThuTucLienThongId(long thuTucLienThongId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			ThuTucHanhChinhImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(FIELD_THUTUCLIENTHONGID).eq(thuTucLienThongId));
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(Constants.ACTIVE));
		return ThuTucHanhChinhLocalServiceUtil.dynamicQueryCount(query);
	}
	/**
	  * This is fucntion fetch ThongTinThuTuc2CoQuan by thuTucId, coQuanId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucId, long coQuanId
	  * @return ThongTinThuTuc2CoQuan
	  */
	public ThongTinThuTuc2CoQuan fetchThongTinThuTuc2CoQuan(long thuTucId, long coQuanId) throws Exception {
		return thuTucHanhChinhFinder.fetchThongTinThuTuc2CoQuan(thuTucId, coQuanId);
	}
	/**
	  * This is fucntion get ThongTinThuTuc by canBo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CongChuc canBo
	  * @return List<ThongTinThuTuc>
	  */
	public List<ThongTinThuTuc> getDSThongTinThuTuc2CanBo(CongChuc canBo) throws Exception {
		return thuTucHanhChinhFinder.getDSThongTinThuTuc2CanBo(canBo);
	}
	/**
	  * This is fucntion get ThongTinThuTuc send by CongChuc 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CongChuc canBo
	  * @return List<ThongTinThuTuc>
	  */
	public List<ThongTinThuTuc> getDSThongTinThuTucLienThongNoiGui2CanBo(CongChuc canBo) throws Exception {
		return thuTucHanhChinhFinder.getDSThongTinThuTucLienThongNoiGui2CanBo(canBo);
	}
	/**
	  * This is fucntion get ThongTinThuTuc receive by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CongChuc canBo
	  * @return List<ThongTinThuTuc>
	  */
	public List<ThongTinThuTuc> getDSThongTinThuTucLienThongNoiNhan2CanBo(CongChuc canBo) throws Exception {
		return thuTucHanhChinhFinder.getDSThongTinThuTucLienThongNoiNhan2CanBo(canBo);
	}
	/**
	  * This is fucntion count QuanQuanLyId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId
	  * @return long
	  */
	public long countByCQQL(long coQuanQuanLyId) {
		return thuTucHanhChinhFinder.countByCQQL(coQuanQuanLyId);
	}
	/**
	  * This is fucntion get ThuTucHanhChinh by coQuanQuanLyId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId
	  * @return List<ThuTucHanhChinh>
	  */
	public List<ThuTucHanhChinh> getListTTHCByCQQL(long coQuanQuanLyId) {
		return  thuTucHanhChinhFinder.getListTTHCByCQQL(coQuanQuanLyId);
	}
	/**
	  * This is fucntion get ThuTucHanhChinh by nhomId, status
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long nhomId,int status
	  * @return List<ThuTucHanhChinh>
	  */
	public List<ThuTucHanhChinh> getDSThuTucHanhChinh(Long nhomId,int status){
		try {
			return thuTucHanhChinhPersistence.findByNhomDanhMucHanhChinh(nhomId, status);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion find ThuTucHanhChinh by code 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String code
	  * @return ThuTucHanhChinh
	  */
	public ThuTucHanhChinh getThuTucHanhChinhBoiMa(String code){
		try {
			return thuTucHanhChinhPersistence.fetchByMa(code);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	* Returns all the thu tuc hanh chinhs.
	*
	* @return the thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	
	/**
	  * This is fucntion findAll ThuTucHanhChinh by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<ThuTucHanhChinh>
	  */
	public  java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return thuTucHanhChinhPersistence.findAll();
	}
	
	/**
	* Returns all the thu tuc hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	
	/**
	  * This is fucntion find ThuTucHanhChinh by TrangThai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int daXoa
	  * @return List<ThuTucHanhChinh>
	  */
	public  java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return thuTucHanhChinhPersistence.findByTrangThai(daXoa);
	}

	/**
	  * This is fucntion get ThuTucHanhChinh by coQuanQuanLyId ,ma
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId, String ma
	  * @return List<ThuTucHanhChinh>
	  */
	public List<ThuTucHanhChinh> getListTTHCByCQQLAndMa(long coQuanQuanLyId, String ma) throws SystemException{
		return  thuTucHanhChinhFinder.getListTTHCByCQQLAndMa(coQuanQuanLyId, ma);
	}
	
	/**
	  * This is fucntion find ThuTucHanhChinh by ungDungId, nhomId, param paging
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long ungDungId,Long nhomId,int start,int end
	  * @return List<ThuTucHanhChinh>
	  */
	public List<ThuTucHanhChinh> searchByUngDungOrNhom(Long ungDungId,Long nhomId,int start,int end){
		try {
			return  thuTucHanhChinhFinder.searchByUngDungOrNhom(ungDungId, nhomId, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion count ThuTucHanhChinh by ungDungId, nhomId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long ungDungId,Long nhomId
	  * @return long
	  */
	public long countByUngDungOrNhom(Long ungDungId,Long nhomId){
		try {
			return  thuTucHanhChinhFinder.countByUngDungOrNhom(ungDungId, nhomId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	  * This is fucntion find ThuTuc2GiayTo by tthcid, dgId,daXoa, param paging
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long tthcid,Long dgId, Integer daXoa, int start,int end
	  * @return List<ThuTuc2GiayTo>
	  */
	public List<ThuTuc2GiayTo> searchByTTHCIdOrGDId(Long tthcid,Long dgId, Integer daXoa, int start,int end){
		try {
			return  thuTucHanhChinhFinder.searchByTTHCIdOrGDId(tthcid, dgId, daXoa, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion count ThuTucHanhChinh by ChucVu by tthcid, dgId,trangthai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long tthcid,Long dgId, Integer daXoa
	  * @return long
	  */
	public long countByTTHCIdOrGDId(Long tthcid,Long dgId, Integer daXoa){
		try {
			return  thuTucHanhChinhFinder.countByTTHCIdOrGDId(tthcid, dgId, daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//Huong dan va Bieu Mau
	/**
	  * This is fucntion search VanBanHuongDan by tthcid, loaiTL,daXoa, param paging
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long tthcid,Long loaiTL, Integer daXoa, int start,int end
	  * @return List<VanBanHuongDan>
	  */
	public List<VanBanHuongDan> searchByTTHC2HDBM(Long tthcid,Long loaiTL, Integer daXoa, int start,int end){
		try {
			return  thuTucHanhChinhFinder.searchByTTHC2HDBM(tthcid, loaiTL, daXoa, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion count ThuTucHanhChinh by  tthcid,loaiTL, daXoa
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long tthcid,Long loaiTL, Integer daXoa
	  * @return long
	  */
	public long countByTTHC2HDBM(Long tthcid,Long loaiTL, Integer daXoa){
		try {
			return  thuTucHanhChinhFinder.countByTTHC2HDBM(tthcid, loaiTL, daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	  * This is fucntion get Name of CapCoQuanQuanLy by thuTucHanhChinhId,param paging 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucHanhChinhId,  int start, int end
	  * @return List<CapCoQuanQuanLy>
	  */
	public List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> getTenCQQL(long thuTucHanhChinhId,  int start, int end){
		try {
			return thuTucHanhChinhFinder.getTenCQQL(thuTucHanhChinhId, start, end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion get Name DoiTuongSuDung by thuTucHanhChinhId,param paging 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucHanhChinhId,  int start, int end
	  * @return List<DoiTuongSuDung>
	  */
	public List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getTenDTSD(long thuTucHanhChinhId,  int start, int end){
		try {
			return thuTucHanhChinhFinder.getTenDTSD(thuTucHanhChinhId, start, end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion get Name DanhMucGiayTo by thuTucHanhChinhId,param paging 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucHanhChinhId,  int start, int end
	  * @return List<DanhMucGiayTo>
	  */
	public List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getTenDMGT(long thuTucHanhChinhId,  int start, int end){
		try {
			return thuTucHanhChinhFinder.getTenDMGT(thuTucHanhChinhId, start, end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}