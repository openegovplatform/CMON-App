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


package org.oep.cmon.dao.nsd.service.impl;

import java.util.List;

import org.oep.cmon.dao.nsd.service.base.TaiNguyenLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.nsd.NoSuchTaiNguyenException;
import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.service.persistence.TaiNguyenFinderUtil;


/**
 * The implementation of the tai nguyen local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.nsd.service.TaiNguyenLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see org.oep.cmon.dao.nsd.service.base.TaiNguyenLocalServiceBaseImpl
 * @see org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil
 */
/**
*
* TaiNguyenLocalServiceImpl class
*   
* This class is used to get TaiNguyenLocal information 
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
public class TaiNguyenLocalServiceImpl extends TaiNguyenLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil} to access the tai nguyen local service.
	 */
	/**
	  * This is fucntion findByTen
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten, int loai, String giaTri,
			Long ungDungId, Long heThongId, int daXoa
	  * @return TaiNguyen
	  */
	public TaiNguyen findByTen(String ten, int loai, String giaTri,
			Long ungDungId, Long heThongId, int daXoa) throws SystemException, NoSuchTaiNguyenException {
		return taiNguyenPersistence.findByTen(ten, loai, giaTri, ungDungId, heThongId, daXoa);
	}
	/**
	  * This is fucntion searchByVaiTroId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long vaiTroId, int daXoa, int start,int end
	  * @return List<TaiNguyen>
	  */
	public List<TaiNguyen> searchByVaiTroId(Long vaiTroId, int daXoa, int start,int end) {
		try
		{
		return TaiNguyenFinderUtil.searchByVaiTroId(vaiTroId, daXoa, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion countByVaiTroId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long vaiTroId, int daXoa
	  * @return long
	  */
	public long countByVaiTroId(Long vaiTroId, int daXoa) {
		try
		{
		return TaiNguyenFinderUtil.countByVaiTroId(vaiTroId, daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}