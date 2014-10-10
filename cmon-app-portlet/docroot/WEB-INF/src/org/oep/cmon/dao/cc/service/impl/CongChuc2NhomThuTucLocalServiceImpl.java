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

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc;
import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTucClp;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cc.service.base.CongChuc2NhomThuTucLocalServiceBaseImpl;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;


import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the cong chuc2 nhom thu tuc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.cc.service.CongChuc2NhomThuTucLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see vn.dtt.cmon.dao.cc.service.base.CongChuc2NhomThuTucLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.cc.service.CongChuc2NhomThuTucLocalServiceUtil
 */
/**
*
* CongChuc2NhomThuTucLocalServiceImpl class
*   
* This class is used to get CongChuc2NhomThuTuc information 
* from database and CRUD to database
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
public class CongChuc2NhomThuTucLocalServiceImpl
	extends CongChuc2NhomThuTucLocalServiceBaseImpl {
	
	/**
	  * This is fucntion fetch CongChuc2NhomThuTuc by ID 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of ID
	  * @return CongChuc2NhomThuTuc infomation
	  */
	public CongChuc2NhomThuTuc fetchById(long id) throws SystemException {
		return congChuc2NhomThuTucPersistence.fetchById(id);
	};
	
	
	/**
	  * This is fucntion find CongChuc2NhomThuTuc by congchucID 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of congchucID
	  * @return List<CongChuc2NhomThuTuc>
	  */
	public List<CongChuc2NhomThuTuc> findByCongChuc(long congChucId) throws SystemException  {
		List<CongChuc2NhomThuTuc> ds = congChuc2NhomThuTucPersistence.findByCongChuc(congChucId);
		if (ds.isEmpty()) {
			CongChuc canBo =  CongChucLocalServiceUtil.fetchCongChuc(congChucId);
			List<NhomThuTucHanhChinh> dsNhom = 
				NhomThuTucHanhChinhLocalServiceUtil.getDSNhomThuTucHanhChinhByCoQuan(canBo.getCoQuanQuanLyId());
			ds = new ArrayList<CongChuc2NhomThuTuc>();
			CongChuc2NhomThuTuc cauHinh;
			for (NhomThuTucHanhChinh nhom : dsNhom) {
				cauHinh = new CongChuc2NhomThuTucClp();
				cauHinh.setNhomThuTucId(nhom.getId());
				cauHinh.setCongChucId(congChucId);
				cauHinh.setDuocPhepEditCongDan(1);
				ds.add(cauHinh);
			}
		}
		return ds;
	};
	
	
	/**
	  * This is fucntion delete CongChuc2NhomThuTuc by congchucID 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of congchucID
	  * @return void
	  */
	
	public void deleteByCongChuc(long congChucId) {
		try {
			congChuc2NhomThuTucPersistence.removeByCongChuc(congChucId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	};
	
	
	/**
	  * This is fucntion fetch CongChuc2NhomThuTuc by congchucID and nhomThuTucId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of congchucID; long: value nhomThuTucId
	  * @return CongChuc2NhomThuTuc
	  */
	public CongChuc2NhomThuTuc fetchByCongChucAndNhomThuTuc(long congChucId, long nhomThuTucId) throws SystemException  {
		CongChuc2NhomThuTuc cauHinh =
			congChuc2NhomThuTucPersistence.fetchByCongChucAndNhomThuTuc(congChucId, nhomThuTucId);
		
		if (cauHinh == null) {
			List<CongChuc2NhomThuTuc> list = findByCongChuc(congChucId);
			for (CongChuc2NhomThuTuc item : list) {
				if (item.getNhomThuTucId() == nhomThuTucId) {
					cauHinh = item;
					break;
				}
			}
		}
		
		return cauHinh;
	};
	
	
	/**
	  * This is fucntion delete CongChuc2NhomThuTuc by congchucID and nhomThuTucId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of congchucID; long: value nhomThuTucId
	  * @return void
	  */
	public void deleteByCongChucAndNhomThuTuc(long congChucId, long nhomThuTucId) {
		try {
			congChuc2NhomThuTucPersistence.removeByCongChucAndNhomThuTuc(congChucId, nhomThuTucId);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (NoSuchCongChuc2NhomThuTucException e) {
			e.printStackTrace();
		}
	};
}