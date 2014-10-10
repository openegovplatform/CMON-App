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

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl;
import org.oep.cmon.dao.nsd.service.base.TaiKhoanNguoiDungLocalServiceBaseImpl;

import org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.persistence.TaiKhoanNguoiDungFinderUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * The implementation of the tai khoan nguoi dung local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see org.oep.cmon.dao.nsd.service.base.TaiKhoanNguoiDungLocalServiceBaseImpl
 * @see org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil
 */

/**
*
* TaiKhoanNguoiDungLocalServiceImpl class
*   
* This class is used to get TaiKhoanNguoiDung information 
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
public class TaiKhoanNguoiDungLocalServiceImpl
	extends TaiKhoanNguoiDungLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil} to access the tai khoan nguoi dung local service.
	 */
	/**
	  * This is fucntion findByTenDangNhap
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String tenDangNhap
	  * @return TaiKhoanNguoiDung
	  */
	public TaiKhoanNguoiDung findByTenDangNhap(String tenDangNhap) {
		try {
			return taiKhoanNguoiDungPersistence.findByTenDangNhap(tenDangNhap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
		
	}
	/**
	  * This is fucntion findByTaiKhoanNguoiDungId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long taiKhoanNguoiDungId
	  * @return TaiKhoanNguoiDung
	  */
	public TaiKhoanNguoiDung findByTaiKhoanNguoiDungId(long taiKhoanNguoiDungId) throws NoSuchTaiKhoanNguoiDungException, SystemException{
		return fetchByLiferayUserId(taiKhoanNguoiDungId);
	}
	/**
	  * This is fucntion findByEmail
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String email
	  * @return List<TaiKhoanNguoiDung>
	  */
	public List<TaiKhoanNguoiDung> findByEmail(String email){
		try {
			return taiKhoanNguoiDungPersistence.findByEmail(email);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
	}
	
	public static final String FIELD_TAIKHOANNGUOIDUNG = "taiKhoanNguoiDungId";
	public static final String FIELD_DAXOA = "daXoa";
	
	/**
	  * This is fucntion fetchByLiferayUserId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long liferayUserId
	  * @return TaiKhoanNguoiDung
	  */
	public TaiKhoanNguoiDung fetchByLiferayUserId(long liferayUserId) {
		try{
			List<TaiKhoanNguoiDung> list = taiKhoanNguoiDungPersistence.findByTaiKhoanNguoiDung(liferayUserId, 0);
			if (list != null && list.size()>0) {
				return list.get(0);
			} else {
				return null;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	/**
	  * This is fucntion findByTaiKhoanNguoiDung
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long taiKhoanId,int daXoa
	  * @return List<TaiKhoanNguoiDung>
	  */
	public List<TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(Long taiKhoanId,int daXoa){
		try {
			TaiKhoanNguoiDung tk = fetchByLiferayUserId(taiKhoanId);
			List<TaiKhoanNguoiDung> list = new ArrayList<TaiKhoanNguoiDung>();
			list.add(tk);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion v
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyWord, String option
	  * @return List<TaiKhoanNguoiDung>
	  */
	public List<TaiKhoanNguoiDung> findTaiKhoanNguoiDungPopup(String keyWord, String option) {
		return TaiKhoanNguoiDungFinderUtil.findTaiKhoanNguoiDungPopup(keyWord, option);
	}
	/**
	  * This is fucntion findTaiKhoanNguoiDung
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyWord, String option
	  * @return List<TaiKhoanNguoiDung>
	  */
	public List<TaiKhoanNguoiDung> findTaiKhoanNguoiDung(String keyWord, String option) {
		return TaiKhoanNguoiDungFinderUtil.findTaiKhoanNguoiDung(keyWord, option);
	}
}