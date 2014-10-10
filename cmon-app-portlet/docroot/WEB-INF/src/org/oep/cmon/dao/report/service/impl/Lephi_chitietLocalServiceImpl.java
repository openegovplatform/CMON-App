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


package org.oep.cmon.dao.report.service.impl;

import java.util.List;

import org.oep.cmon.dao.report.service.base.Lephi_chitietLocalServiceBaseImpl;

import org.oep.cmon.dao.report.model.Lephi_chitiet;

/**
 * The implementation of the lephi_chitiet local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.oep.cmon.dao.report.service.Lephi_chitietLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author VIENPN
 * @see org.oep.cmon.dao.report.service.base.Lephi_chitietLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.Lephi_chitietLocalServiceUtil
 */

/**
*
* Lephi_chitietLocalServiceImpl class
*   
* This class is used to get Lephi_chitiet information 
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
public class Lephi_chitietLocalServiceImpl extends
		Lephi_chitietLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * org.oep.cmon.dao.report.service.Lephi_chitietLocalServiceUtil} to access
	 * the lephi_chitiet local service.
	 */
	
	/**
	  * This is fucntion lephichitiet
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String id_loaihoso,String ngaynhan_tungay, String ngaynhan_denngay
	  * @return List<Lephi_chitiet>
	  */
	public List<Lephi_chitiet> lephichitiet(String id_loaihoso,
			String ngaynhan_tungay, String ngaynhan_denngay) throws Exception {
		return lephi_chitietFinder.lephichitiet(id_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
	}
}