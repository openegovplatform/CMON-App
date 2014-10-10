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

import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.hosohcc.model.impl.YKienTraoDoiImpl;
import org.oep.cmon.dao.hosohcc.service.base.YKienTraoDoiLocalServiceBaseImpl;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;


/**
 * The implementation of the y kien trao doi local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNn
 * @see org.oep.cmon.dao.hosohcc.service.base.YKienTraoDoiLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil
 */
/**
*
* YKienTraoDoiLocalServiceImpl class
*   
* This class is used to get YKienTraoDoi information 
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
public class YKienTraoDoiLocalServiceImpl
	extends YKienTraoDoiLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil} to access the y kien trao doi local service.
	 */
	/**
	  * This is fucntion findYKienByHoSoTTHCCongIdAndLoai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long idHoSo,long idLoai
	  * @return List<YKienTraoDoi>
	  */
	 public  List<YKienTraoDoi> findYKienByHoSoTTHCCongIdAndLoai(long idHoSo,long idLoai)
				throws com.liferay.portal.kernel.exception.SystemException {
				return yKienTraoDoiFinder.findYKienByHoSoTTHCCongIdAndLoai(idHoSo,idLoai);
		} 
	 
	 
	 /**
	  * This is fucntion getYkienTraoDoi
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long yKienId
	  * @return List<YKienTraoDoi>
	  */
	 public YKienTraoDoi getYkienTraoDoi(long yKienId)
		        throws SystemException {

		    	YKienTraoDoi yKienTraoDoi = yKienTraoDoiPersistence.fetchByPrimaryKey(yKienId);

		        return yKienTraoDoi;

		    }
	 
	 /**
	  * This is fucntion updateStatus 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long resourcePrimKey, long status
	  * @return YKienTraoDoi
	  */
		   public YKienTraoDoi updateStatus( long resourcePrimKey, long status)  throws PortalException, SystemException {


		        YKienTraoDoi ykienTraoDoi = getYkienTraoDoi(resourcePrimKey);
		        //Update Trang thai da doc
		        ykienTraoDoi.setTrangThai(status);

		        yKienTraoDoiPersistence.update(ykienTraoDoi, false);
		        return ykienTraoDoi;
		   }
			
			public static final String FIELD_HOSOTTHCCONGID = "hoSoTTHCCongId";
			public static final String FIELD_LOAI = "loai";
		   
			
			/**
			  * This is fucntion findByHoSoTTHCCongId 
			  * Version: 1.0
			  *  
			  * History: 
			  *   DATE        AUTHOR      DESCRIPTION 
			  *  ------------------------------------------------- 
			  *  3-March-2013  Nam Dinh    Create new
			  * @param long hoSoTTHCCongId, int start, int end
			  * @return List<YKienTraoDoi>
			  */
			public  List<YKienTraoDoi> findByHoSoTTHCCongId(
					long hoSoTTHCCongId, int start, int end)
					throws com.liferay.portal.kernel.exception.SystemException {
				//	return yKienTraoDoiPersistence.findByHoSoTTHCCongId(hoSoTTHCCongId, start, end);
				
					DynamicQuery query = DynamicQueryFactoryUtil.forClass(
						YKienTraoDoiImpl.class,
						PortalClassLoaderUtil.getClassLoader());
					query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCONGID).eq(hoSoTTHCCongId));
					return (List<YKienTraoDoi>) YKienTraoDoiLocalServiceUtil
						.dynamicQuery(query, start, end);
			
			}
			
			
//			public  List<YKienTraoDoi> findByHoSoTTHCCongId(
//					long hoSoTTHCCongId)
//					throws com.liferay.portal.kernel.exception.SystemException {
//					return yKienTraoDoiPersistence.findByHoSoTTHCCongId(hoSoTTHCCongId);
//			}
			
			
			/**
			  * This is fucntion findByHoSoTTHCCongIdAndLoai
			  * Version: 1.0
			  *  
			  * History: 
			  *   DATE        AUTHOR      DESCRIPTION 
			  *  ------------------------------------------------- 
			  *  3-March-2013  Nam Dinh    Create new
			  * @param long hoSoTTHCCongId,long loai
			  * @return List<YKienTraoDoi>
			  */
			public  List<YKienTraoDoi> findByHoSoTTHCCongIdAndLoai(
					long hoSoTTHCCongId,long loai)
					throws com.liferay.portal.kernel.exception.SystemException {
					//return yKienTraoDoiPersistence.findByHoSoTTHCCongIdAndLoai(hoSoTTHCCongId, loai);
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(
					YKienTraoDoiImpl.class,
					PortalClassLoaderUtil.getClassLoader());
				query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCONGID).eq(hoSoTTHCCongId));
				query.add(PropertyFactoryUtil.forName(FIELD_LOAI).eq(loai));
				return (List<YKienTraoDoi>) YKienTraoDoiLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				
					
			}
			/**
			* Returns the number of y kien trao dois where hoSoTTHCCongId = &#63;.
			*
			* @param hoSoTTHCCongId the ho so t t h c cong ID
			* @return the number of matching y kien trao dois
			* @throws SystemException if a system exception occurred
			*/
			
			/**
			  * This is fucntion countByHoSoTTHCCongId 
			  * Version: 1.0
			  *  
			  * History: 
			  *   DATE        AUTHOR      DESCRIPTION 
			  *  ------------------------------------------------- 
			  *  3-March-2013  Nam Dinh    Create new
			  * @param long hoSoTTHCCongId
			  * @return int
			  */
			public  int countByHoSoTTHCCongId(long hoSoTTHCCongId)
				throws com.liferay.portal.kernel.exception.SystemException {
				//return yKienTraoDoiPersistence.countByHoSoTTHCCongId(hoSoTTHCCongId);
				
				return findByHoSoTTHCCongId(hoSoTTHCCongId).size();
			}

			
			/**
			  * This is fucntion addYkien_Traodoi 
			  * Version: 1.0
			  *  
			  * History: 
			  *   DATE        AUTHOR      DESCRIPTION 
			  *  ------------------------------------------------- 
			  *  3-March-2013  Nam Dinh    Create new
			  * @param YKienTraoDoi newYKienTraoDoi
			  * @return YKienTraoDoi
			  */
			   public YKienTraoDoi addYkien_Traodoi( YKienTraoDoi newYKienTraoDoi)  throws  SystemException {

				 	YKienTraoDoi yKienTraoDoi  =  yKienTraoDoiPersistence.create(CounterLocalServiceUtil.increment(YKienTraoDoi.class.getName()));
				 	yKienTraoDoi.setTieuDe(newYKienTraoDoi.getTieuDe());
				 	yKienTraoDoi.setNoiDungYKien(newYKienTraoDoi.getNoiDungYKien());
				 	yKienTraoDoi.setHoSoTTHCCongId(newYKienTraoDoi.getHoSoTTHCCongId());
				 	yKienTraoDoi.setThoiGianGuiYKien(newYKienTraoDoi.getThoiGianGuiYKien());
				 	yKienTraoDoi.setTrangThai(newYKienTraoDoi.getTrangThai());
				 	yKienTraoDoi.setNguoiNhanId(newYKienTraoDoi.getNguoiNhanId());
				 	yKienTraoDoi.setNguoiGuiId(newYKienTraoDoi.getNguoiGuiId());
				 	yKienTraoDoi.setChaiId(yKienTraoDoi.getId());
				 	//yKienTraoDoi.setId(id);

				 	yKienTraoDoiPersistence.update(yKienTraoDoi, false);

				 return yKienTraoDoi;
			   }		
			   
			   /**
				  * This is fucntion updateYkien_Traodoi 
				  * Version: 1.0
				  *  
				  * History: 
				  *   DATE        AUTHOR      DESCRIPTION 
				  *  ------------------------------------------------- 
				  *  3-March-2013  Nam Dinh    Create new
				  * @param YKienTraoDoi
				  * @return List<YKienTraoDoi>
				  */
			   public YKienTraoDoi updateYkien_Traodoi( YKienTraoDoi newYKienTraoDoi)  throws  SystemException {

				 	YKienTraoDoi yKienTraoDoi  =  yKienTraoDoiPersistence.fetchByPrimaryKey(newYKienTraoDoi.getId());
				 	if(yKienTraoDoi == null) return null;
				 	
				 	yKienTraoDoi.setTieuDe(newYKienTraoDoi.getTieuDe());
				 	yKienTraoDoi.setNoiDungYKien(newYKienTraoDoi.getNoiDungYKien());
				 	yKienTraoDoi.setHoSoTTHCCongId(newYKienTraoDoi.getHoSoTTHCCongId());
				 	yKienTraoDoi.setThoiGianGuiYKien(newYKienTraoDoi.getThoiGianGuiYKien());
				 	yKienTraoDoi.setTrangThai(newYKienTraoDoi.getTrangThai());
				 	yKienTraoDoi.setNguoiNhanId(newYKienTraoDoi.getNguoiNhanId());
				 	yKienTraoDoi.setNguoiGuiId(newYKienTraoDoi.getNguoiGuiId());
				 	yKienTraoDoi.setChaiId(yKienTraoDoi.getId());
				 	yKienTraoDoiPersistence.update(yKienTraoDoi, true);
				 	
				 	return yKienTraoDoi;
			   }	
			   
			   
			   /**
				  * This is fucntion listYKienTraoDoi
				  * Version: 1.0
				  *  
				  * History: 
				  *   DATE        AUTHOR      DESCRIPTION 
				  *  ------------------------------------------------- 
				  *  3-March-2013  Nam Dinh    Create new
				  * @param long hoSoTTHCCongId, long tkNguoiDungId, String tieuDe, int start, int end
				  * @return List<YKienTraoDoi>
				  */
			   public  List<YKienTraoDoi> listYKienTraoDoi(
						long hoSoTTHCCongId, long tkNguoiDungId, String tieuDe, int start, int end)
						throws com.liferay.portal.kernel.exception.SystemException {
						return yKienTraoDoiFinder.listYKienTraoDoi(hoSoTTHCCongId, tkNguoiDungId, tieuDe, start, end);
					} 
			   
			   /**
				  * This is fucntion listCanBoTiepNhan
				  * Version: 1.0
				  *  
				  * History: 
				  *   DATE        AUTHOR      DESCRIPTION 
				  *  ------------------------------------------------- 
				  *  3-March-2013  Nam Dinh    Create new
				  * @param long coQuanQuanLyId, int start, int end
				  * @return List<CongChuc>
				  */
			   public  List<CongChuc> listCanBoTiepNhan(
						long coQuanQuanLyId, int start, int end)
						throws com.liferay.portal.kernel.exception.SystemException {
						return yKienTraoDoiFinder.listCanBoTiepNhan(coQuanQuanLyId, start, end);
					}
			   
			   
			   /**
				  * This is fucntion listYKienTraoDoiAndLoai 
				  * Version: 1.0
				  *  
				  * History: 
				  *   DATE        AUTHOR      DESCRIPTION 
				  *  ------------------------------------------------- 
				  *  3-March-2013  Nam Dinh    Create new
				  * @param long hoSoTTHCCongId, long tkNguoiDungId, String loai, String tieuDe, int start, int end
				  * @return List<YKienTraoDoi>
				  */
			   public  List<YKienTraoDoi> listYKienTraoDoiAndLoai(
						long hoSoTTHCCongId, long tkNguoiDungId, String loai, String tieuDe, int start, int end)
						throws com.liferay.portal.kernel.exception.SystemException {
						return yKienTraoDoiFinder.listYKienTraoDoiAndLoai(hoSoTTHCCongId, tkNguoiDungId, loai, tieuDe, start, end);
				} 
			   
			   
			   /**
				  * This is fucntion countYKienTraoDoiAndLoai
				  * Version: 1.0
				  *  
				  * History: 
				  *   DATE        AUTHOR      DESCRIPTION 
				  *  ------------------------------------------------- 
				  *  3-March-2013  Nam Dinh    Create new
				  * @param long hoSoTTHCCongId, long tkNguoiDungId, String loai, String tieuDe
				  * @return int
				  */
			   public  int countYKienTraoDoiAndLoai(long hoSoTTHCCongId, long tkNguoiDungId, String loai, String tieuDe)
						throws com.liferay.portal.kernel.exception.SystemException {
						return yKienTraoDoiFinder.countYKienTraoDoiAndLoai(hoSoTTHCCongId, tkNguoiDungId, loai, tieuDe);
					}
			   
			   /**
				  * This is fucntion findByHoSoTTHCCongId
				  * Version: 1.0
				  *  
				  * History: 
				  *   DATE        AUTHOR      DESCRIPTION 
				  *  ------------------------------------------------- 
				  *  3-March-2013  Nam Dinh    Create new
				  * @param long hoSoTTHCCongId
				  * @return List<YKienTraoDoi>
				  */   
			@Override
			public List<YKienTraoDoi> findByHoSoTTHCCongId(long hoSoTTHCCongId)
					throws SystemException {
				// TODO Auto-generated method stub
				return findByHoSoTTHCCongId(hoSoTTHCCongId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}
			
			
			  
}