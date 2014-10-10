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


package org.oep.cmon.dao.csms.service.impl;

import org.oep.cmon.dao.csms.service.base.YeuCauDangKyCongDanLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;

/**
 * The implementation of the yeu cau dang ky cong dan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.csms.service.YeuCauDangKyCongDanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NAM
 * @see org.oep.cmon.dao.csms.service.base.YeuCauDangKyCongDanLocalServiceBaseImpl
 * @see org.oep.cmon.dao.csms.service.YeuCauDangKyCongDanLocalServiceUtil
 */

/**
*
* YeuCauDangKyCongDanLocalServiceImpl class
*   
* This class is used to get YeuCauDangKyCongDan information 
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
public class YeuCauDangKyCongDanLocalServiceImpl
	extends YeuCauDangKyCongDanLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.csms.service.YeuCauDangKyCongDanLocalServiceUtil} to access the yeu cau dang ky cong dan local service.
	 */

	/**
	* Returns all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	*
	* @param MaXacNhan the ma xac nhan
	* @return the matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	/**
	  * This is fucntion find YeuCauDangKyCongDan by MaXacNhan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of MaXacNhan
	  * @return List<YeuCauDangKyCongDan>
	  */
	public  java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findByMaXacNhan(
		java.lang.String MaXacNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return yeuCauDangKyCongDanPersistence.findByMaXacNhan(MaXacNhan);
	}

	/**
	  * This is fucntion find YeuCauDangKyCongDan by soCmnd 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of soCmnd
	  * @return List<YeuCauDangKyCongDan>
	  */
	public  java.util.List<YeuCauDangKyCongDan> findBySoCmnd(String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		//return yeuCauDangKyCongDanPersistence.findBySoCmnd(soCmnd);
		return null;
	}
	
	/**
	  * This is fucntion find YeuCauDangKyCongDan by Keyword and param paging 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of keyword;int trangThaiYeuCau, int start, int end
	  * @return List<YeuCauDangKyCongDan>
	  */
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findByKeyword(
			java.lang.String keyword, int trangThaiYeuCau, int start, int end)
			throws com.liferay.portal.kernel.exception.SystemException {
		return yeuCauDangKyCongDanFinder.findByKeyword(keyword, trangThaiYeuCau, start, end);
	}
	
	/**
	  * This is fucntion count YeuCauDangKyCongDan by keyword and  trangThaiYeuCau
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of keyword, int trangThaiYeuCau
	  * @return int
	  */
	public int countByKeyword(java.lang.String keyword, int trangThaiYeuCau)
			throws com.liferay.portal.kernel.exception.SystemException {
		return yeuCauDangKyCongDanFinder.countByKeyword(keyword, trangThaiYeuCau);
	}
}