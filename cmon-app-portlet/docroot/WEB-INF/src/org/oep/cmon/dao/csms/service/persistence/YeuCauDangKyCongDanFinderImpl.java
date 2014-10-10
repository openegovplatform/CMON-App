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

package org.oep.cmon.dao.csms.service.persistence;

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;
import org.oep.cmon.dao.csms.service.persistence.YeuCauDangKyCongDanFinder;

import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
*
* YeuCauDangKyCongDanFinderImpl class
*   
* This class is used to get YeuCauDangKyCongDan information  
* from database use Custom Sql
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
@SuppressWarnings("unchecked")
public class YeuCauDangKyCongDanFinderImpl extends BasePersistenceImpl<YeuCauDangKyCongDan> implements YeuCauDangKyCongDanFinder {

	/**
	  * This is fucntion find YeuCauDangKyCongDan by keyword, trangthaiyeucau, param paging 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyword, int trangThaiYeuCau, int start, int end
	  * @return List<YeuCauDangKyCongDan>
	  */
	public List<YeuCauDangKyCongDan> findByKeyword(String keyword, int trangThaiYeuCau, int start, int end) throws SystemException {
		List<YeuCauDangKyCongDan> list = new ArrayList<YeuCauDangKyCongDan>();
		String sql = "SELECT yeuCauDangKyCongDan FROM YeuCauDangKyCongDan yeuCauDangKyCongDan where ( SoCmnd like '%" + keyword + "%' or  Email like '%" + keyword + "%' or" +
				" TenCongDan like '%" + keyword + "%')";
		if (trangThaiYeuCau > -1 ) {
			sql += " and TrangThaiYeuCau=" + trangThaiYeuCau;
		}
		
		Session session = null;

		try {
			session = openSession();
			Query q = session.createQuery(sql);
			list = (List<YeuCauDangKyCongDan>)QueryUtil.list(q, getDialect(),
					start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
		return list;
	}

	/**
	  * This is fucntion find YeuCauDangKyCongDan by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyword, int trangThaiYeuCau
	  * @return int
	  */
	public int countByKeyword(String keyword, int trangThaiYeuCau) throws SystemException {
		return 0;
		
	}
}
