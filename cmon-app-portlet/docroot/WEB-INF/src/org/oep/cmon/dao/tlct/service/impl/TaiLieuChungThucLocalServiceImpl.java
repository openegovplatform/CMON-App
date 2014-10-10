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


package org.oep.cmon.dao.tlct.service.impl;

import java.util.Date;
import java.util.List;

import org.oep.cmon.dao.tlct.model.impl.TaiLieuChungThucImpl;
import org.oep.cmon.dao.tlct.service.base.TaiLieuChungThucLocalServiceBaseImpl;
import org.oep.cmon.util.DateUtil;
import org.oep.sharedservice.cmon.Constants;

import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;
import org.oep.cmon.dao.tlct.service.persistence.TaiLieuChungThucFinderUtil;


import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * The implementation of the tai lieu chung thuc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see org.oep.cmon.dao.tlct.service.base.TaiLieuChungThucLocalServiceBaseImpl
 * @see org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil
 */

/**
*
* TaiLieuChungThucLocalServiceImpl class
*   
* This class is used to get TaiLieuChungThuc information 
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
@SuppressWarnings("unchecked")
public class TaiLieuChungThucLocalServiceImpl
	extends TaiLieuChungThucLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(TaiLieuChungThucLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil} to access the tai lieu chung thuc local service.
	 */
	
	public static final String FIELD_DANHMUCGIAYTOID = "danhMucGiayToId";
	public static final String FIELD_CHUSOHUUID = "chuSohuuId";
	public static final String FIELD_NGUOIUPLOADID = "nguoiUploadId";
	public static final String FIELD_PHIENBAN = "phienBan";
	public static final String FIELD_HOSOTTHCCID = "hoSoTTHCCId";
	public static final String FIELD_TEN = "ten";
	
	/**
	  * This is fucntion isUsed 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long id
	  * @return boolean
	  */
	public boolean isUsed(Long id){
		Long count = TaiLieuChungThucFinderUtil.isUsed(id);
		if(count.intValue()>0){
			return true;
		}
		return false;
	}
	
	/**
	  * This is fucntion delete 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long id
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc delete(Long id){
		TaiLieuChungThuc taiLieuChungThuc = null;
		try {
			taiLieuChungThuc = taiLieuChungThucLocalService.getTaiLieuChungThuc(id);
			if(taiLieuChungThuc != null){
				
				taiLieuChungThucPersistence.remove(id);	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
			
		} 
		
		return taiLieuChungThuc;
	}
	
	/**
	  * This is fucntion add 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param TaiLieuChungThuc
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc add(TaiLieuChungThuc model){
		long id  =0;
		try {
			id  =CounterLocalServiceUtil.increment(TaiLieuChungThuc.class.getName());
			TaiLieuChungThuc newObj = taiLieuChungThucPersistence.create(id);
			
			newObj.setTen(model.getTen());
			newObj.setGhiChu(model.getGhiChu());
			newObj.setNoiLuuTruId(model.getNoiLuuTruId());
			newObj.setNgayUpload(model.getNgayUpload());
			newObj.setPhienBan(model.getPhienBan());
			newObj.setNgayDuyet(model.getNgayDuyet());
			newObj.setHieuLucTuNgay(model.getHieuLucTuNgay());
			newObj.setHieuLucDenNgay(model.getHieuLucDenNgay());
			newObj.setNgaySua(model.getNgaySua());
			newObj.setNguoiSua(model.getNguoiSua());
			newObj.setDanhMucGiayToId(model.getDanhMucGiayToId());
			newObj.setTrangThai(model.getTrangThai());
			newObj.setChuSohuuId(model.getChuSohuuId());
			newObj.setNguoiUploadId(model.getNguoiUploadId());
			newObj.setNguoiduyetId(model.getNguoiduyetId());
			newObj.setHoSoTTHCCId(model.getHoSoTTHCCId());
			newObj.setMaUngDung(model.getMaUngDung());
			newObj.setLoai(model.getLoai());
			
			taiLieuChungThucPersistence.update(newObj, false);
			return newObj;
			
		} catch (Exception e) {
			try {
				return taiLieuChungThucPersistence.fetchByPrimaryKey(id);
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//e.printStackTrace();
			
		}

		return null;
	}
	
	/**
	  * This is fucntion findByDanhMucGiayTo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long danhmucGiayToId
	  * @return List<TaiLieuChungThuc>
	  */
	public List<TaiLieuChungThuc> findByDanhMucGiayTo(Long danhmucGiayToId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			TaiLieuChungThucImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		if (danhmucGiayToId == null) {
			query.add(PropertyFactoryUtil.forName(FIELD_DANHMUCGIAYTOID).isNull());
		} else {
			query.add(PropertyFactoryUtil.forName(FIELD_DANHMUCGIAYTOID).eq(danhmucGiayToId));
		}
		return (List<TaiLieuChungThuc>) TaiLieuChungThucLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	
	/**
	  * This is fucntion findByPhienBanMoiNhat 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long danhmucGiayToId, Long chuSohuuId
	  * @return List<TaiLieuChungThuc>
	  */
	public List<TaiLieuChungThuc> findByPhienBanMoiNhat(Long danhmucGiayToId, Long chuSohuuId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			TaiLieuChungThucImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		if (danhmucGiayToId == null) {
			query.add(PropertyFactoryUtil.forName(FIELD_DANHMUCGIAYTOID).isNull());
		} else {
			query.add(PropertyFactoryUtil.forName(FIELD_DANHMUCGIAYTOID).eq(danhmucGiayToId));
		}
		if (chuSohuuId == null) {
			query.add(PropertyFactoryUtil.forName(FIELD_CHUSOHUUID).isNull());
		} else {
			query.add(PropertyFactoryUtil.forName(FIELD_CHUSOHUUID).eq(chuSohuuId));
		}
		return (List<TaiLieuChungThuc>) TaiLieuChungThucLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	
	/**
	  * This is fucntion findByPhienBan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long danhmucGiayToId, int phienBan, Long nguoiUpLoadId
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc findByPhienBan(Long danhmucGiayToId, int phienBan, Long nguoiUpLoadId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			TaiLieuChungThucImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		if (danhmucGiayToId == null) {
			query.add(PropertyFactoryUtil.forName(FIELD_DANHMUCGIAYTOID).isNull());
		} else {
			query.add(PropertyFactoryUtil.forName(FIELD_DANHMUCGIAYTOID).eq(danhmucGiayToId));
		}
		query.add(PropertyFactoryUtil.forName(FIELD_PHIENBAN).eq(phienBan));
		if (nguoiUpLoadId == null) {
			query.add(PropertyFactoryUtil.forName(FIELD_NGUOIUPLOADID).isNull());
		} else {
			query.add(PropertyFactoryUtil.forName(FIELD_NGUOIUPLOADID).eq(nguoiUpLoadId));
		}
		List<TaiLieuChungThuc> list = (List<TaiLieuChungThuc>) TaiLieuChungThucLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	/**
	  * This is fucntion findByHoSoTTHCCongIdAndTen 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long hoSoTTHCCId, String ten
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc findByHoSoTTHCCongIdAndTen(Long hoSoTTHCCId, String ten) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			TaiLieuChungThucImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		if (hoSoTTHCCId == null) {
			query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCID).isNull());
		} else {
			query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCID).eq(hoSoTTHCCId));
		}
		query.add(PropertyFactoryUtil.forName(FIELD_TEN).eq(ten));
		List<TaiLieuChungThuc> list = (List<TaiLieuChungThuc>) TaiLieuChungThucLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	
	/**
	  * This is fucntion getCurrentVersion
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long danhmucGiayToId
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc getCurrentVersion(Long danhmucGiayToId){
		try {
			List<TaiLieuChungThuc> tList = findByDanhMucGiayTo(danhmucGiayToId);
			if(tList !=null && tList.size()>0){
				for (TaiLieuChungThuc taiLieuChungThuc : tList) {
						if(taiLieuChungThuc.getTrangThai() != Constants.DOCUMENT_REJECTED){
							return taiLieuChungThuc;
						}
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	/**
	  * This is fucntion getCurrentVersion 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long danhMucGiayToId,Long userId
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc getCurrentVersion(Long danhMucGiayToId,Long userId){
		try {
			TaiLieuChungThuc doc  = taiLieuChungThucFinder.getLastVersion(userId, danhMucGiayToId);
			Date today= new Date();		
			if(doc != null){
				_log.info("get tai lieu not null:"+doc.getId());
				
					if(doc.getTrangThai() != Constants.DOCUMENT_REJECTED){
						// if new return document
						if(doc.getTrangThai() == Constants.DOCUMENT_NEW){
							_log.info("1.tai lieu trang thai moi");
							return doc;
						}else if(doc.getTrangThai() == Constants.DOCUMENT_TEMP_DELETED){
							//temp return null;
							_log.info("2.tai lieu trang thai bi xoa");
							return null;
						}
						
						if(doc.getHieuLucTuNgay() != null){
							//co hieu luc
							if(doc.getHieuLucDenNgay() != null){
								if(DateUtil.equalDateByDay(today , doc.getHieuLucTuNgay()) >=0  
										&& DateUtil.equalDateByDay(today , doc.getHieuLucDenNgay()) <=0){
									//tai lieu van con hieu luc									
									return doc;
								}else{
									_log.info("3.tai lieu khong nam trong khoang date:from:"+doc.getHieuLucTuNgay()+",to:"+doc.getHieuLucDenNgay());
								}
							}else{
								//tai lieu con hieu luc
								if(DateUtil.equalDateByDay(today , doc.getHieuLucTuNgay()) >=0){
									return doc;
								}else{
									_log.info("4.tai lieu khong nam trong khoang date:from:"+doc.getHieuLucTuNgay());
								}
							}
						}else{
							// khong thiet lap hieu luc
							_log.info("4. khong co hieu luc tu ngay den ngay");
							return doc;
						}
					}
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			_log.error(e.fillInStackTrace());
		}
		_log.info("5.cac truong hop con lai");
		return null;
		
		
	}
	
	
	/**
	  * This is fucntion getTheoPhienBan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long danhMucGiayToId,int phienban,Long userId
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc getTheoPhienBan(Long danhMucGiayToId,int phienban,Long userId){
		try {
			TaiLieuChungThuc chungThuc = findByPhienBan(danhMucGiayToId, phienban, userId);
		return chungThuc;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	//add by duong.pham
	/**
	  * This is fucntion getHoSoId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long hosoId
	  * @return List<TaiLieuChungThuc>
	  */
	public List<TaiLieuChungThuc> getHoSoId(Long hosoId){
		try {
			
		return TaiLieuChungThucFinderUtil.findByHoSoId(hosoId);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
		
		
	}
	
	/**
	  * This is fucntion findByNoiLuuTruId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long noiLuuTruId
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc findByNoiLuuTruId(long noiLuuTruId){
		try {
			return taiLieuChungThucPersistence.findBynoiLuuTruId(noiLuuTruId);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	  * This is fucntion findByHosotthcCongIdAndLoai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCId, int loai
	  * @return List<TaiLieuChungThuc>
	  */
	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByHosotthcCongIdAndLoai(long hoSoTTHCCId, int loai){
		try {
			return taiLieuChungThucPersistence.findByHosotthcCongIdAndLoai(hoSoTTHCCId, loai);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion findByHosotthcCongIdAndTen
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hosotthcCongId, String ten
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc findByHosotthcCongIdAndTen(long hosotthcCongId, String ten){
		try {
			return findByHoSoTTHCCongIdAndTen(hosotthcCongId, ten);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	  * This is fucntion getMaxVersion 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long userId, Long giayToId
	  * @return int
	  */
	public int getMaxVersion(Long userId, Long giayToId){
		return taiLieuChungThucFinder.getMaxVersion(userId, giayToId);
	}
	
	//upate by duong.pham
	/**
	  * This is fucntion searchCongDanId2DanhMucGiayTo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group, Long congDanId, Long doiTuongId,int start, int end
	  * @return List<TaiLieuChungThuc>
	  */
	public List<TaiLieuChungThuc> searchCongDanId2DanhMucGiayTo(String group, Long congDanId, Long doiTuongId,
			int start, int end) {
		return TaiLieuChungThucFinderUtil.searchByCongDanId2DanhMucGiayTo(group, congDanId, doiTuongId, start, end);
	}
	
	//upate by quocdv
	/**
	  * This is fucntion findTaiLieuXuLyByHoSoAndLoai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long idHoSo,int loai
	  * @return List<TaiLieuChungThuc>
	  */
		public List<TaiLieuChungThuc> findTaiLieuXuLyByHoSoAndLoai(long idHoSo,int loai) {
			return TaiLieuChungThucFinderUtil.findTaiLieuXuLyByHoSoAndLoai(idHoSo, loai);
		}
		
		/**
		  * This is fucntion countCongDanId2DanhMucGiayTo
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param String group, Long congDanId, Long doiTuongId
		  * @return long
		  */
	public long countCongDanId2DanhMucGiayTo(String group, Long congDanId, Long doiTuongId) {
		return TaiLieuChungThucFinderUtil.countByCongDanId2DanhMucGiayTo(group, congDanId, doiTuongId);
	}
}