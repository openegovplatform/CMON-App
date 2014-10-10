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

import org.oep.cmon.dao.qlhc.model.impl.QuocGiaImpl;

import org.oep.cmon.dao.qlhc.model.QuocGia;
import org.oep.cmon.dao.qlhc.service.persistence.QuocGiaFinder;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


/**
*
* QuocGiaFinderImpl class
*   
* This class is used to get QuocGia information 
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
public class QuocGiaFinderImpl extends BasePersistenceImpl<QuocGia> implements QuocGiaFinder {
	
	
	/**
	  * This is fucntion findAll
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return List<QuocGia>
	  */
	@SuppressWarnings("unchecked")
	public List<QuocGia> findAll() {
		Session session = openSession();
		SQLQuery query = session.createSQLQuery(
			"SELECT * FROM CMON_QUOCGIA QG WHERE QG.DAXOA = 0 ORDER BY NLSSORT(QG.TEN, 'NLS_SORT = BINARY_AI')");
		query.addEntity(QuocGia.class.getSimpleName(), QuocGiaImpl.class);
		List<QuocGia> out = (List<QuocGia>) query.list();
		closeSession(session);
		return out;
	}
}
