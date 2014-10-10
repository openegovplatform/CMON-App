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

import java.util.List;

import org.oep.cmon.dao.tlct.service.base.DanhMucGiayToLocalServiceBaseImpl;
import org.oep.sharedservice.cmon.Constants;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.service.persistence.DanhMucGiayToFinderUtil;

/**
 * The implementation of the danh muc giay to local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see org.oep.cmon.dao.tlct.service.base.DanhMucGiayToLocalServiceBaseImpl
 * @see org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil
 */
/**
*
* DanhMucGiayToLocalServiceImpl class
*   
* This class is used to get DanhMucGiayTo information 
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
public class DanhMucGiayToLocalServiceImpl
	extends DanhMucGiayToLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil} to access the danh muc giay to local service.
	 */
	/**
	  * This is fucntion getGiayToBoiMa 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ma
	  * @return DanhMucGiayTo
	  */
	public DanhMucGiayTo getGiayToBoiMa(String ma){
		try {
			return danhMucGiayToPersistence.fetchByByMa(ma);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return null;
	}
	
	//upate by duong.pham
	/**
	  * This is fucntion searchDanhMucGiayTo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group, Long doiTuongId,int start, int end
	  * @return List<DanhMucGiayTo>
	  */
	public List<DanhMucGiayTo> searchDanhMucGiayTo(String group, Long doiTuongId,
			int start, int end) {
		return DanhMucGiayToFinderUtil.searchDanhMucGiayTo(group, doiTuongId, start, end);
	}
	/**
	  * This is fucntion countDanhMucGiayTo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group, Long doiTuongId
	  * @return long
	  */
	public long countDanhMucGiayTo(String group, Long doiTuongId) {
		return DanhMucGiayToFinderUtil.countDanhMucGiayTo(group, doiTuongId);
	}
	/**
	  * This is fucntion searchByTTHCIdOrGDId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group,String doituong, Long tthcid, Long dgId, Integer daXoa, int start,int end
	  * @return List<DanhMucGiayTo>
	  */
	public List<DanhMucGiayTo> searchByTTHCIdOrGDId(String group,
			String doituong, Long tthcid, Long dgId, Integer daXoa, int start,int end) {
		try
		{
		return DanhMucGiayToFinderUtil.searchByTTHCIdOrGDId(group, doituong, tthcid, dgId,  daXoa,  start,end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion countByTTHCIdOrGDId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group,String doituong, Long tthcid, Long dgId, Integer daXoa
	  * @return long
	  */
	public long countByTTHCIdOrGDId(String group,
			String doituong, Long tthcid, Long dgId, Integer daXoa) {
		try
		{
		return DanhMucGiayToFinderUtil.countByTTHCIdOrGDId(group, doituong, tthcid, dgId, daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//add quocdv
	/**
	  * This is fucntion findGiayToKetQua 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thutuchanhchinhId
	  * @return List<DanhMucGiayTo>
	  */
	public List<DanhMucGiayTo> findGiayToKetQua(long thutuchanhchinhId)
	{
		try {
			return DanhMucGiayToFinderUtil.listGiayToKetQua(thutuchanhchinhId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//add quocdv
	/**
	  * This is fucntion finlistGiayToBCNopDon
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hosothutuchccId
	  * @return List<DanhMucGiayTo>
	  */
		public List<DanhMucGiayTo> finlistGiayToBCNopDon(long hosothutuchccId)
		{
			try {
				return DanhMucGiayToFinderUtil.listGiayToBCNopDon(hosothutuchccId);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	
	//Add by duongpt
		/**
		  * This is fucntion findTheoMa
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param String ma
		  * @return DanhMucGiayTo
		  */
	public DanhMucGiayTo findTheoMa(String ma) throws com.liferay.portal.kernel.exception.SystemException, NoSuchDanhMucGiayToException {
		return danhMucGiayToPersistence.findByByMa(ma);
	}
	/**
	  * This is fucntion getDanhMucGiayToList 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int daXoa
	  * @return List<DanhMucGiayTo>
	  */
	public List<DanhMucGiayTo> getDanhMucGiayToList(int daXoa){
		try {
			return danhMucGiayToPersistence.findByTrangThai(daXoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion listByCongDan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long doiTuongId
	  * @return List<DanhMucGiayTo>
	  */
	public List<DanhMucGiayTo> listByCongDan(Long doiTuongId) throws SystemException {
		return DanhMucGiayToFinderUtil.listByCongDan(doiTuongId);
	}
}