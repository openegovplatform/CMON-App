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

package org.oep.cmon.dao.qlhc.service.persistence;


import java.util.List;

import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.persistence.DonViHanhChinhFinder;


import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* DonViHanhChinhFinderImpl class
*   
* This class is used to get DonViHanhChinh information 
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
public class DonViHanhChinhFinderImpl extends BasePersistenceImpl<DonViHanhChinh> implements DonViHanhChinhFinder {
	
	
	/**
	  * This is fucntion dsTinhThanh
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<DonViHanhChinh>
	  */
  public	java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> dsTinhThanh(){
	  
		Session session = null;
		StringBuffer sql = new StringBuffer();		
		try {
			session = openSession();
			sql.append("SELECT d from DonViHanhChinh d ");
			sql.append(" WHERE d.chaId is null AND d.daXoa=0");			
			sql.append(" ORDER BY d.ten ASC ");			
			Query q = session.createQuery(sql.toString());
			QueryPos qPos = QueryPos.getInstance(q);	
			List<DonViHanhChinh> list = (List<DonViHanhChinh>)QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS, false);
			return list;	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			closeSession(session);
		}
		
		return null;
	

	}

}
