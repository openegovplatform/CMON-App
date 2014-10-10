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


package org.oep.cmon.dao.ttthanhtoan.service.impl;

import java.util.List;

import org.oep.cmon.dao.ttthanhtoan.service.base.ThongTinThanhToanLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;
import org.oep.cmon.dao.ttthanhtoan.service.persistence.ThongTinThanhToanFinderUtil;

/**
 * The implementation of the thong tin thanh toan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Thanhdd
 * @see org.oep.cmon.dao.ttthanhtoan.service.base.ThongTinThanhToanLocalServiceBaseImpl
 * @see org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil
 */
/**
*
* ThongTinThanhToanLocalServiceImpl class
*   
* This class is used to get ThongTinThanhToan information 
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
public class ThongTinThanhToanLocalServiceImpl
	extends ThongTinThanhToanLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil} to access the thong tin thanh toan local service.
	 */
	/**
	  * This is fucntion findByHoSoId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoId
	  * @return List<ThongTinThanhToan>
	  */
	public List<ThongTinThanhToan> findByHoSoId(long hoSoId) throws SystemException {
		return thongTinThanhToanPersistence.findByHoSoTTHCCongId(hoSoId);
	}

	/**
	  * This is fucntion searchByCoQuanQuanLyHoSo_QT 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId, String searchProfileCode, int loaiPhi, int start, int end
	  * @return List<ThongTinThanhToan>
	  */
	public List<ThongTinThanhToan> searchByCoQuanQuanLyHoSo_QT(long coQuanQuanLyId, String searchProfileCode, int loaiPhi, int start, int end) {
		return ThongTinThanhToanFinderUtil.searchByCoQuanQuanLyHoSo_QT(coQuanQuanLyId, searchProfileCode, loaiPhi, start, end);
	}

	/**
	  * This is fucntion countByCoQuanQuanLyHoSo_QT 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId, String searchProfileCode, int loaiPhi
	  * @return int
	  */
	public int countByCoQuanQuanLyHoSo_QT(long coQuanQuanLyId, String searchProfileCode, int loaiPhi){
		return ThongTinThanhToanFinderUtil.countByCoQuanQuanLyHoSo_QT(coQuanQuanLyId, searchProfileCode, loaiPhi);
	}
}