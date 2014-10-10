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


package org.oep.cmon.dao.cd.service.impl;

import java.util.List;

import org.oep.cmon.dao.cd.service.base.ChuyenMonLocalServiceBaseImpl;

import org.oep.cmon.dao.cd.model.ChuyenMon;

/**
 * The implementation of the chuyen mon local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.cd.service.ChuyenMonLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see org.oep.cmon.dao.cd.service.base.ChuyenMonLocalServiceBaseImpl
 * @see org.oep.cmon.dao.cd.service.ChuyenMonLocalServiceUtil
 */

/**
*
* ChuyenMonLocalServiceImpl class
*   
* This class is used to get ChuyenMon information 
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
public class ChuyenMonLocalServiceImpl extends ChuyenMonLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.cd.service.ChuyenMonLocalServiceUtil} to access the chuyen mon local service.
	 */
	
	/**
	  * This is fucntion fetch ChuyenMon by congDan2CCGPId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of congDan2CCGPId
	  * @return List<ChuyenMon>
	  */
	public List<ChuyenMon> fetchListByCongDan2CCGPId(long congDan2CCGPId) {
		return chuyenMonFinder.fetchListByCongDan2CCGPId(congDan2CCGPId);
	}
	/**
	  * This is fucntion get ChuyenMon by idUngdung and  idCha
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of idUngdung; String idCha
	  * @return List<ChuyenMon>
	  */
	 public List<ChuyenMon> getChuyenMonByChaId(String idUngdung,String idCha)
	 {
		 return  chuyenMonFinder.getChuyenMonChaId(idUngdung, idCha);
	 }
	 /**
	  * This is fucntion get ChuyenMon by idUngdung 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of idUngdung
	  * @return List<ChuyenMon>
	  */
	 public List<ChuyenMon> getChuyenMonByChaIdNull (String idUngdung)
	 {
		 return  chuyenMonFinder.getChuyenMonByChaIdNull(idUngdung);
	 }
	 /**
	  * This is fucntion find ChuyenMon by maDanhMucUngDung 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of maDanhMucUngDung
	  * @return List<ChuyenMon>
	  */
	 public List<ChuyenMon> findByMaDanhMucUngDung(String maDanhMucUngDung) {

			return chuyenMonFinder
					.getDanhSachChuyenMonByMaDanhMucUngDung(maDanhMucUngDung);
		}
	 
	 
		
}