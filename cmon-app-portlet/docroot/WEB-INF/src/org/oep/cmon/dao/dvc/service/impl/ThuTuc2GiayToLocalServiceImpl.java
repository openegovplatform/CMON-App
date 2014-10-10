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
import org.oep.cmon.dao.dvc.service.base.ThuTuc2GiayToLocalServiceBaseImpl;

import org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKem;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the thu tuc2 giay to local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.dvc.service.base.ThuTuc2GiayToLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil
 */
/**
*
* ThuTuc2GiayToLocalServiceImpl class
*   
* This class is used to get ThuTuc2GiayTo information 
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
public class ThuTuc2GiayToLocalServiceImpl
	extends ThuTuc2GiayToLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil} to access the thu tuc2 giay to local service.
	 */
	/**
	  * This is fucntion get ThuTuc2GiayTo by thuTucId, giaiDoan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucId, int giaiDoan
	  * @return List<ThuTuc2GiayTo>
	  */
	public List<GiayToDinhKem> getDSGiayToByThuTucVaGiaiDoan(long thuTucId, int giaiDoan) throws Exception {
		return thuTuc2GiayToFinder.getDSGiayToByThuTucVaGiaiDoan(thuTucId, giaiDoan);
	}
	/**
	  * This is fucntion get ThuTuc2GiayTo by thutucId, status,step
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long thutucId,int status,int step
	  * @return List<ThuTuc2GiayTo>
	  */
	public List<ThuTuc2GiayTo> getDSGiayToTheoThuTuc(Long thutucId,int status,int step){
		//return ThuTuc2GiayToLocalServiceUtil.f;\
		try {
			List<ThuTuc2GiayTo> listGiayTo = thuTuc2GiayToPersistence.findByThuTuchanhChinh(thutucId, status,step);
			List<ThuTuc2GiayTo> out = new ArrayList<ThuTuc2GiayTo>();
			for (ThuTuc2GiayTo item : listGiayTo) {
				if (item.getDaXoa() == Constants.ACTIVE) {
					out.add(item);
				}
			}
			return out;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion get ThuTuc2GiayTo by thutucId, giaytoId,step
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long thutucId,Long giaytoId,int step
	  * @return List<ThuTuc2GiayTo>
	  */
	public List<ThuTuc2GiayTo> getDSTT2GiayTo(Long thutucId,Long giaytoId,int step){
		try {
			return thuTuc2GiayToPersistence.findByThuTuc2GiayTo(thutucId, giaytoId, step);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}