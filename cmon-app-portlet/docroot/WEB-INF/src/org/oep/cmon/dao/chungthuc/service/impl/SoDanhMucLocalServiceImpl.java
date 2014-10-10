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


package org.oep.cmon.dao.chungthuc.service.impl;

import java.util.List;

import org.oep.cmon.dao.chungthuc.service.base.SoDanhMucLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.chungthuc.model.SoDanhMuc;

/**
 * The implementation of the so danh muc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.chungthuc.service.SoDanhMucLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vietho
 * @see vn.dtt.cmon.dao.chungthuc.service.base.SoDanhMucLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil
 */

/**
*
* SoDanhMucLocalServiceImpl class
*   
* This class is used to get SoDanhMuc information 
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
public class SoDanhMucLocalServiceImpl extends SoDanhMucLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil} to access the so danh muc local service.
	 */
	/**
	  * This is fucntion get SoDanhMuc by tthcId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long tthcId
	  * @return List<SoDanhMuc>
	  */
	public List<SoDanhMuc> getSoDanhMucByTTHCID(long tthcId) throws SystemException {
		return soDanhMucPersistence.findByTheoTTHCID(tthcId);
	}
	/**
	  * This is fucntion find SoDanhMuc by tthcId, coQuanId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long tthcId, long coQuanId
	  * @return List<SoDanhMuc>
	  */
	public List<SoDanhMuc> getSoDanhMucByTTHCIDAndCQQLID(long tthcId, long coQuanId) throws SystemException {
		return soDanhMucPersistence.findByTheoTTHCIDAndCQQLID(tthcId, coQuanId);
	}
	/**
	  * This is fucntion find SoDanhMuc by coQuanId and paging
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanId, int start, int end
	  * @return List<SoDanhMuc>
	  */
	public List<SoDanhMuc> getSoDanhMucByCoQuanQuanLyId(long coQuanId, int start, int end) throws SystemException {
		return soDanhMucPersistence.findByTheoCOQUANQUANLYID(coQuanId, start, end);
	}
	/**
	  * This is fucntion count SoDanhMuc by coQuanId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanId
	  * @return List<SoDanhMuc>
	  */
	public int countSoDanhMucByCoQuanQuanLyId(long coQuanId) throws SystemException {
		return soDanhMucPersistence.countByTheoCOQUANQUANLYID(coQuanId);
	}
}