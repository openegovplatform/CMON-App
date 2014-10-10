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


package org.oep.cmon.dao.qlhc.service.impl;

import java.util.List;

import org.oep.cmon.dao.qlhc.service.base.CoQuanHanhChinhSuNghiepLocalServiceBaseImpl;

import org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep;

/**
 * The implementation of the co quan hanh chinh su nghiep local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.qlhc.service.CoQuanHanhChinhSuNghiepLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see org.oep.cmon.dao.qlhc.service.base.CoQuanHanhChinhSuNghiepLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.CoQuanHanhChinhSuNghiepLocalServiceUtil
 */
/**
*
* CoQuanHanhChinhSuNghiepLocalServiceImpl class
*   
* This class is used to get CoQuanHanhChinhSuNghiep information 
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
public class CoQuanHanhChinhSuNghiepLocalServiceImpl
	extends CoQuanHanhChinhSuNghiepLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.qlhc.service.CoQuanHanhChinhSuNghiepLocalServiceUtil} to access the co quan hanh chinh su nghiep local service.
	 */
	/**
	  * This is fucntion getDonViHanhChinhCha
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<CoQuanHanhChinhSuNghiep>
	  */
public List<CoQuanHanhChinhSuNghiep> getDonViHanhChinhCha() {
		
		return coQuanHanhChinhSuNghiepFinder.getDonViHanhChinhCha();
	}
}