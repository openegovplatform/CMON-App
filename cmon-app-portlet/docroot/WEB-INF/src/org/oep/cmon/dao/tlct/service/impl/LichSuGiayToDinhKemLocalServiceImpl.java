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

import org.oep.cmon.dao.tlct.service.base.LichSuGiayToDinhKemLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.service.persistence.LichSuGiayToDinhKemPersistence;


/**
 * The implementation of the lich su giay to dinh kem local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.tlct.service.LichSuGiayToDinhKemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see org.oep.cmon.dao.tlct.service.base.LichSuGiayToDinhKemLocalServiceBaseImpl
 * @see org.oep.cmon.dao.tlct.service.LichSuGiayToDinhKemLocalServiceUtil
 */
/**
*
* LichSuGiayToDinhKemLocalServiceImpl class
*   
* This class is used to get LichSuGiayToDinhKem information 
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
public class LichSuGiayToDinhKemLocalServiceImpl
	extends LichSuGiayToDinhKemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.tlct.service.LichSuGiayToDinhKemLocalServiceUtil} to access the lich su giay to dinh kem local service.
	 */
	//add by duong.pham
	/**
	  * This is fucntion getGiayToDKHSId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long hosoId
	  * @return List<LichSuGiayToDinhKem>
	  */
	public List<LichSuGiayToDinhKem> getGiayToDKHSId(Long hosoId){
		try {
			
		return lichSuGiayToDinhKemPersistence.findByByGiayToDinhKemHoSoId(hosoId);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	/**
	  * This is fucntion getNoiLuuTruId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long noiLuuTruId
	  * @return List<LichSuGiayToDinhKem>
	  */
	public List<LichSuGiayToDinhKem> getNoiLuuTruId(Long noiLuuTruId){
		try {
			
		return lichSuGiayToDinhKemPersistence.findByByNoiLuuTruTaiLieuId(noiLuuTruId);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	

	/**
	  * This is fucntion add
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param LichSuGiayToDinhKem model
	  * @return LichSuGiayToDinhKem
	  */
	public LichSuGiayToDinhKem add(LichSuGiayToDinhKem model){
		
		try {
			model.setId(CounterLocalServiceUtil.increment(LichSuGiayToDinhKem.class.getName()));
			model = lichSuGiayToDinhKemLocalService.addLichSuGiayToDinhKem(model);
			return model;
		} catch (Exception e) {
			
		}

		return null;
	}
	
}