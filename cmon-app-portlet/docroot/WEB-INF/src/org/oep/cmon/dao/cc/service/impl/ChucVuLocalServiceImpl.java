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

package org.oep.cmon.dao.cc.service.impl;

import java.util.List;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.service.base.ChucVuLocalServiceBaseImpl;
import org.oep.cmon.dao.cc.service.persistence.ChucVuFinderImpl;

import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the chuc vu local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.cc.service.ChucVuLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see vn.dtt.cmon.dao.cc.service.base.ChucVuLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.cc.service.ChucVuLocalServiceUtil
 */

/**
*
* ChucVuLocalServiceImpl class
*   
* This class is used to get ChucVu information 
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
public class ChucVuLocalServiceImpl extends ChucVuLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.cc.service.ChucVuLocalServiceUtil} to access the chuc vu local service.
	 */
	
	/**
	  * This is fucntion find ChucVu by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return List<ChucVu>
	  */
	public List<ChucVu> findMa(String ma) throws SystemException {
		return chucVuPersistence.findByMa(ma);
	}
	
	/**
	  * This is fucntion find ChucVu by Ten 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ten
	  * @return List<ChucVu>
	  */
	public List<ChucVu> findTen(String ten) throws SystemException {
		return chucVuPersistence.findByTen(ten);
	}
	
	/**
	  * This is fucntion find ChucVu by trangthai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int : value of TrangThai
	  * @return List<ChucVu>
	  */
	public List<ChucVu> findTrangThai(int daXoa) throws SystemException {
		return chucVuPersistence.findByTrangThai(daXoa);
	}
	
	/**
	  * This is fucntion find ChucVu by CoQuanQuanLy va TrangThai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long: value of coQuanQuanLyId ; long : value of TrangThai
	  * @return List<ChucVu>
	  */
	public List<ChucVu> findByCoQuanQuanLy(long coQuanQuanLyId,long daXoa){
		return chucVuFinder.findByCoQuanQuanLy(coQuanQuanLyId, daXoa);
	}}