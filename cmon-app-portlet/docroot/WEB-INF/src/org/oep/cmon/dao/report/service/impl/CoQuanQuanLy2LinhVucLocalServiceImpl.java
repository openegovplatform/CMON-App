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

import org.oep.cmon.dao.report.service.base.CoQuanQuanLy2LinhVucLocalServiceBaseImpl;

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc;

/**
 * The implementation of the co quan quan ly2 linh vuc local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author VIENPN
 * @see org.oep.cmon.dao.report.service.base.CoQuanQuanLy2LinhVucLocalServiceBaseImpl
 * @see org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalServiceUtil
 */
/**
*
* CoQuanQuanLy2LinhVucLocalServiceImpl class
*   
* This class is used to get CoQuanQuanLy2LinhVuc information 
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
public class CoQuanQuanLy2LinhVucLocalServiceImpl extends
		CoQuanQuanLy2LinhVucLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalServiceUtil} to
	 * access the co quan quan ly2 linh vuc local service.
	 */
	
	/**
	  * This is fucntion getLinhvucByIdDonvi
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String id_donvibaocao
	  * @return List<CoQuanQuanLy2LinhVuc>
	  */
	public List<CoQuanQuanLy2LinhVuc> getLinhvucByIdDonvi(String id_donvibaocao)
			throws Exception {
		return coQuanQuanLy2LinhVucFinder.getLinhvucByIdDonvi(id_donvibaocao);
	}
	
	/**
	  * This is fucntion getTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String nhomtthc_id,String donvi_id
	  * @return List<ThuTucHanhChinh>
	  */
	public List<ThuTucHanhChinh> getTTHC(String nhomtthc_id,String donvi_id)
			throws Exception {
		return coQuanQuanLy2LinhVucFinder.getTTHC(nhomtthc_id,donvi_id);
	}
}