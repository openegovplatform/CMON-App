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

import org.oep.cmon.dao.report.service.base.CongChuc2RoleLocalServiceBaseImpl;

import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.report.model.DanhMucBaoCao;

/**
 * The implementation of the cong chuc2 role local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.oep.cmon.dao.report.service.CongChuc2RoleLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author VIENPN
 * @see org.oep.cmon.dao.report.service.base.CongChuc2RoleLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.CongChuc2RoleLocalServiceUtil
 */

/**
*
* CongChuc2RoleLocalServiceImpl class
*   
* This class is used to get CongChuc2Role information 
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
public class CongChuc2RoleLocalServiceImpl extends
		CongChuc2RoleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * org.oep.cmon.dao.report.service.CongChuc2RoleLocalServiceUtil} to access
	 * the cong chuc2 role local service.
	 */
	
	/**
	  * This is fucntion getDanhsachbaocao
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long user_id
	  * @return List<DanhMucBaoCao>
	  */
	public List<DanhMucBaoCao> getDanhsachbaocao(long user_id) throws Exception {
		return congChuc2RoleFinder.getDanhsachbaocao(user_id);
	}
	
	/**
	  * This is fucntion getCoQuanQuanLy
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long user_id,long baocao_id
	  * @return List<CoQuanQuanLy>
	  */
	public List<CoQuanQuanLy> getCoQuanQuanLy(long user_id,long baocao_id) throws Exception {
		return congChuc2RoleFinder.getCoQuanQuanLy(user_id, baocao_id);
	}
	
	/**
	  * This is fucntion getNhomTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long user_id,long baocao_id,long donvi_id
	  * @return List<NhomThuTucHanhChinh>
	  */
	public List<NhomThuTucHanhChinh> getNhomTTHC(long user_id,long baocao_id,long donvi_id) throws Exception {
		return congChuc2RoleFinder.getNhomTTHC(user_id, baocao_id, donvi_id);
	}
	
	/**
	  * This is fucntion testReportPermission 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long user_id,long baocao_id
	  * @return Boolean
	  */
	
	public Boolean testReportPermission(long user_id,long baocao_id) throws Exception {
		return congChuc2RoleFinder.testReportPermission(user_id, baocao_id);
	}
	
	
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
	public List<ThuTucHanhChinh> getThutuchanhchinh(long user_id,long baocao_id,long donvi_id) throws Exception {
		return congChuc2RoleFinder.getThutuchanhchinh(user_id, baocao_id, donvi_id);
	}
	

}