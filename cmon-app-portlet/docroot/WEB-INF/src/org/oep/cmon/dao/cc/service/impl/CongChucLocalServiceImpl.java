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

import org.oep.cmon.Constants;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.base.CongChucLocalServiceBaseImpl;
import org.oep.cmon.dao.cc.service.persistence.CongChucUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;



/**
 * The implementation of the cong chuc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.cc.service.CongChucLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see vn.dtt.cmon.dao.cc.service.base.CongChucLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.cc.service.CongChucLocalServiceUtil
 */
/**
*
* CongChucLocalServiceImpl class
*   
* This class is used to get CongChuc information 
* from database and CRUD to Db
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
public class CongChucLocalServiceImpl extends CongChucLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.cc.service.CongChucLocalServiceUtil} to access the cong chuc local service.
	 */
	
	
	/**
	  * This is fucntion find CongChuc by taiKhoanNguoiDungId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of taiKhoanNguoiDungId
	  * @return List<CongChuc>
	  */
	public  java.util.List<CongChuc> findByTaiKhoanNguoiDungId(
			long taiKhoanNguoiDungId)
			throws com.liferay.portal.kernel.exception.SystemException {
			return congChucPersistence
					   .findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}
	
	
	/**
	  * This is fucntion fetch CongChuc by taiKhoanNguoiDungId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of taiKhoanNguoiDungId
	  * @return CongChuc
	  */
	public CongChuc fetchByTaiKhoanNguoiDung(long taiKhoanNguoiDungId) throws SystemException {
		java.util.List<CongChuc> list = congChucPersistence.findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
		if (!list.isEmpty() && list.get(0).getDaXoa() == Constants.ACTIVE) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	/**
	  * This is fucntion find CongChuc by trangthai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int : Value of trangthai
	  * @return List<CongChuc>
	  */
	public  java.util.List<CongChuc> findByStatus(int daXoa) throws SystemException{
		return congChucPersistence.findByTrangThai(daXoa);
	}

	/**
	  * This is fucntion find CongChuc by ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param string : Value of ma
	  * @return List<CongChuc>
	  */
	public List<CongChuc> findByMa(String ma) throws SystemException {
		return congChucPersistence.findByMa(ma);
	}
	

	/**
	  * This is fucntion get CongChuc by coQuanQuanLyId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of coQuanQuanLyId, int : start ; int: end; 
	  * @return List<CongChuc>
	  */
	 public  List<CongChuc> listCanBoTiepNhan(
				long coQuanQuanLyId, int start, int end)
				throws com.liferay.portal.kernel.exception.SystemException {
				return congChucFinder.listCanBoTiepNhan(coQuanQuanLyId, start, end);
			}
	 /**
	  * This is fucntion get CongChuc by coQuanQuanLyId and ma or Ten or Email
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of coQuanQuanLyId,String : keyword; int : start ; int: end; 
	  * @return List<CongChuc>
	  */
	 public  List<CongChuc> listCongChuc(long coQuanQuanLyId,String maOrTenOrEmail, int start, int end)
				throws com.liferay.portal.kernel.exception.SystemException {
				return congChucFinder.listCongChuc(coQuanQuanLyId,maOrTenOrEmail, start, end);
	 }
	 
	 /**
	  * This is fucntion count CongChuc by coQuanQuanLyId and ma or Ten or Email
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of coQuanQuanLyId,String : keyword
	  * @return int 
	  */
	 public int countListCongChuc(long coQuanQuanLyId,String maOrTenOrEmail)
				throws com.liferay.portal.kernel.exception.SystemException {
				return congChucFinder.countListCongChuc(coQuanQuanLyId, maOrTenOrEmail);
	 }
	 
	 /**
	  * This is fucntion find CongChuc by coQuanQuanLyId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of coQuanQuanLyId
	  * @return List<CongChuc> 
	  */
	 public List<CongChuc> findByCoQuanQuanLyID(long idCQQL) throws SystemException {
			congChucPersistence.clearCache();
			
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongChuc.class)
	                .add(PropertyFactoryUtil.forName("daXoa").eq(0))
	                .add(RestrictionsFactoryUtil.eq("coQuanQuanLyId", Long.valueOf(idCQQL)))
	                .addOrder(OrderFactoryUtil.desc("ngaySua"));
			
			return CongChucUtil.findWithDynamicQuery(query);
		}
	 
	 /**
	  * This is fucntion get CongChuc by taiKhoanNguoiDungId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long : Value of taiKhoanNguoiDungId
	  * @return CongChuc 
	  */
	 
	 public CongChuc getCongChucByTaiKhoanNguoiDung(Long taiKhoanNguoiDungId) {
			try {
				java.util.List<CongChuc> congChucs = congChucPersistence
						.findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
				if (congChucs != null && congChucs.size() > 0) {
					return congChucs.get(0);
				} else {
					return null;
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				return null;
			}
		}
	 
}