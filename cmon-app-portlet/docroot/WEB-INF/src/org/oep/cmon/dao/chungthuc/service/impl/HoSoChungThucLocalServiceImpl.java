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

import org.oep.cmon.dao.chungthuc.service.base.HoSoChungThucLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.chungthuc.model.HoSoChungThuc;

/**
 * The implementation of the ho so chung thuc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.chungthuc.service.HoSoChungThucLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vietho
 * @see vn.dtt.cmon.dao.chungthuc.service.base.HoSoChungThucLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil
 */
/**
*
* HoSoChungThucLocalServiceImpl class
*   
* This class is used to get HoSoChungThuc information 
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
public class HoSoChungThucLocalServiceImpl
	extends HoSoChungThucLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil} to access the ho so chung thuc local service.
	 */
	/**
	  * This is fucntion get HoSoChungThuc by tthcId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long tthcId
	  * @return List<HoSoChungThuc>
	  */
	public List<HoSoChungThuc> getHSChungThucByTTHC(long tthcId) throws SystemException {
		return hoSoChungThucPersistence.findByTheoTTHCID(tthcId);
	}
	
	/**
	  * This is fucntion get HoSoChungThuc by tthcId and paging
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long tthcId, int start, int end
	  * @return List<HoSoChungThuc>
	  */
	public List<HoSoChungThuc> getHSChungThucByTTHC(long tthcId, int start, int end) throws SystemException {
		return hoSoChungThucPersistence.findByTheoTTHCID(tthcId, start, end);
	}
	
	/**
	  * This is fucntion count HoSoChungThuc  by tthcId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long tthcId, int start, int end
	  * @return List<HoSoChungThuc>
	  */
	public long countHSChungThucByTTHC(long tthcId, int start, int end) throws SystemException {
		return hoSoChungThucPersistence.countByTheoTTHCID(tthcId);
	}
	
	/**
	  * This is fucntion get HoSoChungThuc by tthcId ,canBoTiepNhanId, coQuanId,soChungThuc 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long tthcId, long canBoTiepNhanId, long coQuanId, String soChungThuc, int start, int end
	  * @return List<HoSoChungThuc>
	  */
	public List<HoSoChungThuc> getHoSoChungThucByTTHCAndSCT(long tthcId, long canBoTiepNhanId, long coQuanId, String soChungThuc, int start, int end) throws SystemException {
		return hoSoChungThucFinder.getHoSoChungThucByTTHCAndSCT(tthcId, canBoTiepNhanId, coQuanId, soChungThuc, start, end);
	}
	
	/**
	  * This is fucntion count HoSoChungThuc by tthcId,canBoTiepNhanId, coQuanId, soChungThuc
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long tthcId, long canBoTiepNhanId, long coQuanId, String soChungThuc, int start, int end
	  * @return int
	  */
	public int countHoSoChungThucByTTHCAndSCT(long tthcId, long canBoTiepNhanId, long coQuanId, String soChungThuc, int start, int end) throws SystemException {
		return hoSoChungThucFinder.countHoSoChungThucByTTHCAndSCT(tthcId, canBoTiepNhanId, coQuanId, soChungThuc, start, end);
	}
	
	/**
	  * This is fucntion find HoSoChungThuc by thuTucHanhChinhId,soDanhMucId  
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : long thuTucHanhChinhId, long soDanhMucId
	  * @return List<HoSoChungThuc>
	  */
	public List<HoSoChungThuc> findByTheoTTHCIDAndSoDanhMucId(long thuTucHanhChinhId, long soDanhMucId) throws SystemException {
		return hoSoChungThucPersistence.findByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId, soDanhMucId);
	}
			
}