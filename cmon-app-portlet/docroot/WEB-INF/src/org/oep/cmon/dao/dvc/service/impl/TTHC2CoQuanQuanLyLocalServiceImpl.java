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

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.dvc.service.base.TTHC2CoQuanQuanLyLocalServiceBaseImpl;

import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the t t h c2 co quan quan ly local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.dvc.service.base.TTHC2CoQuanQuanLyLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil
 */
/**
*
* TTHC2CoQuanQuanLyLocalServiceImpl class
*   
* This class is used to get TTHC2CoQuanQuanLy information 
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
public class TTHC2CoQuanQuanLyLocalServiceImpl
	extends TTHC2CoQuanQuanLyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil} to access the t t h c2 co quan quan ly local service.
	 */
	/**
	  * This is fucntion get TTHC2CoQuanQuanLy by tthcId, daXoa
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long tthcId, int daXoa
	  * @return List<TTHC2CoQuanQuanLy>
	  */
	public List<TTHC2CoQuanQuanLy> getDSTTHC2CoQuanQuanLy(Long tthcId, int daXoa){
		try {
			return tthc2CoQuanQuanLyPersistence.findByThuTucHanhChinhId(tthcId, daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	/**
	  * This is fucntion find TTHC2CoQuanQuanLy by coQuanId, thuTucId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanId, long thuTucId
	  * @return List<TTHC2CoQuanQuanLy>
	  */
	public List<TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(long coQuanId, long thuTucId) throws SystemException {
		List<TTHC2CoQuanQuanLy> list = tthc2CoQuanQuanLyPersistence.findByCoQuanAndThuTuc(coQuanId, thuTucId);
		List<TTHC2CoQuanQuanLy> out = new ArrayList<TTHC2CoQuanQuanLy>();
		for (TTHC2CoQuanQuanLy item : list) {
			if(item.getDaXoa() == Constants.ACTIVE) {
				out.add(item);
			}
		}
		return out;
	}
}