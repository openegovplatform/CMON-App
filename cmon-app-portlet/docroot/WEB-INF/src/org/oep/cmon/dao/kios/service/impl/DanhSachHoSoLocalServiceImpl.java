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


package org.oep.cmon.dao.kios.service.impl;

import java.util.List;

import org.oep.cmon.dao.kios.service.base.DanhSachHoSoLocalServiceBaseImpl;

import org.oep.cmon.dao.kios.model.DanhSachCoQuan;
import org.oep.cmon.dao.kios.model.DanhSachHoSo;
import org.oep.cmon.dao.kios.model.DanhSachThongKe;
import org.oep.cmon.dao.report.model.ReportThongKe;

/**
 * The implementation of the danh sach ho so local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.oep.cmon.dao.kios.service.DanhSachHoSoLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author VIENPN
 * @see org.oep.cmon.dao.kios.service.base.DanhSachHoSoLocalServiceBaseImpl
 * @see org.oep.cmon.dao.kios.service.DanhSachHoSoLocalServiceUtil
 */

/**
*
* DanhSachHoSoLocalServiceImpl class
*   
* This class is used to get DanhSachHoSo information 
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
public class DanhSachHoSoLocalServiceImpl extends
		DanhSachHoSoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * org.oep.cmon.dao.kios.service.DanhSachHoSoLocalServiceUtil} to access the
	 * danh sach ho so local service.
	 */
	
	/**
	  * This is fucntion getListHoSo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String id_coquan, int start,	int end
	  * @return List<DanhSachHoSo>
	  */
	public List<DanhSachHoSo> getListHoSo(String id_coquan, int start,
			int end) throws Exception {
		return danhSachHoSoFinder.getListHoSo(id_coquan, start, end);
	}

	/**
	  * This is fucntion getListCoQuan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String arrayCapCoQuanId
	  * @return List<DanhSachCoQuan>
	  */
	public List<DanhSachCoQuan> getListCoQuan(String arrayCapCoQuanId)
			throws Exception {
		return danhSachHoSoFinder.getListCoQuan(arrayCapCoQuanId);
	}

	/**
	  * This is fucntion getListReportThongKeGroupByIDCoQuan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String arrCapCoQuanid, String arrThang, String nam
	  * @return List<DanhSachThongKe>
	  */
	public List<DanhSachThongKe> getListReportThongKeGroupByIDCoQuan(
			String arrCapCoQuanid, String arrThang, String nam)
			throws Exception {
		return danhSachHoSoFinder.getListReportThongKeGroupByIDCoQuan(arrCapCoQuanid,arrThang,nam);
	}
}