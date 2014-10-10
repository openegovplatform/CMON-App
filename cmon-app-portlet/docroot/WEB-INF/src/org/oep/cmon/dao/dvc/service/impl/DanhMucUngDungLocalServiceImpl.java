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

import java.util.List;

import org.oep.cmon.dao.dvc.service.base.DanhMucUngDungLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.DanhMucUngDungModel;

/**
 * The implementation of the danh muc ung dung local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.dvc.service.base.DanhMucUngDungLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil
 */
/**
*
* DanhMucUngDungLocalServiceImpl class
*   
* This class is used to get DanhMucUngDung information 
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
public class DanhMucUngDungLocalServiceImpl
	extends DanhMucUngDungLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil} to access the danh muc ung dung local service.
	 */
	/**
	  * This is fucntion get DanhMucUngDung by status 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int status
	  * @return List<DanhMucUngDung>
	  */
	public List<DanhMucUngDung> getDSUngDung(int status){
		try {
			return danhMucUngDungPersistence.findByTrangThai(status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion get DanhMucUngDung by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return DanhMucUngDung
	  */
	public DanhMucUngDung getUngDungTheoMa(String ma){
		try {
			return (DanhMucUngDung) danhMucUngDungPersistence.findByMa(ma);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	/**
	  * This is fucntion find DanhMucUngDung by ten 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ten
	  * @return List<DanhMucUngDung>
	  */
	public List<DanhMucUngDung> findTen(String ten) throws SystemException {
		return danhMucUngDungPersistence.findByTen(ten);
	}
	/**
	  * This is fucntion getId DanhMucUngDung by maDMUngdung 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of maDMUngdung
	  * @return int
	  */
	public int getIdDanhmucUngdung(String maDMUngdung) throws SystemException{ 
		
		 try{
			 return (int)((DanhMucUngDungModel) danhMucUngDungPersistence.findByMa(maDMUngdung)).getId();
		 
		 }catch (Exception e) {
			 return 0;
			// TODO: handle exception
		}
		 
	 }
}