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

import org.oep.cmon.dao.dvc.service.base.CapNhatKetQuaLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.dvc.model.CapNhatKetQua;
import org.oep.cmon.dao.dvc.model.CapNhatKetQuaSoap;

/**
 * The implementation of the cap nhat ket qua local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dvc.service.CapNhatKetQuaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.dvc.service.base.CapNhatKetQuaLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.CapNhatKetQuaLocalServiceUtil
 */

/**
*
* CapNhatKetQuaLocalServiceImpl class
*   
* This class is used to get CapNhatKetQua information 
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
public class CapNhatKetQuaLocalServiceImpl
	extends CapNhatKetQuaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.dvc.service.CapNhatKetQuaLocalServiceUtil} to access the cap nhat ket qua local service.
	 */
	/**
	  * This is fucntion add CapNhatKetQua 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CapNhatKetQua new 
	  * @return CapNhatKetQua
	  */
	public CapNhatKetQua addCapNhatKetQua(CapNhatKetQua model){
		try {
			long id = CounterLocalServiceUtil.increment(CapNhatKetQua.class.getName());
			CapNhatKetQua newObj = capNhatKetQuaPersistence.create(id);
			
			newObj.setTenBang(model.getTenBang());
			newObj.setBanGhiId(model.getBanGhiId());
			newObj.setHanhDong(model.getHanhDong());
			newObj.setNgayTao(model.getNgayTao());
			newObj.setNguoiTao(model.getNguoiTao());
			newObj.setNgaySua(model.getNgaySua());
			newObj.setNguoiSua(model.getNguoiSua());
			newObj.setDaXoa(model.getDaXoa());
			newObj.setHosoTTHCCId(model.getHosoTTHCCId());
			return capNhatKetQuaPersistence.update(newObj, false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
	/**
	  * This is fucntion update CapNhatKetQua 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CapNhatKetQua new object
	  * @return CapNhatKetQua 
	  */
	public CapNhatKetQua updateCapNhatKetQua(CapNhatKetQua model){
		try {
			
			CapNhatKetQua newObj = capNhatKetQuaPersistence.fetchByPrimaryKey(model.getId());
			if(newObj == null) return null;
			
			newObj.setTenBang(model.getTenBang());
			newObj.setBanGhiId(model.getBanGhiId());
			newObj.setHanhDong(model.getHanhDong());
			newObj.setNgayTao(model.getNgayTao());
			newObj.setNguoiTao(model.getNguoiTao());
			newObj.setNgaySua(model.getNgaySua());
			newObj.setNguoiSua(model.getNguoiSua());
			newObj.setDaXoa(model.getDaXoa());
			newObj.setHosoTTHCCId(model.getHosoTTHCCId());
			return capNhatKetQuaPersistence.update(newObj, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
}