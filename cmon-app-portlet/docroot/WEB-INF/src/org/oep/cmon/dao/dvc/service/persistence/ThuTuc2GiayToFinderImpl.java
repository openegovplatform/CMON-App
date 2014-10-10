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

package org.oep.cmon.dao.dvc.service.persistence;

import java.util.List;

import org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKemImpl;
import org.oep.egovcore.sqlutil.BeanSQLQuery;

import org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKem;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.service.persistence.ThuTuc2GiayToFinder;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
/**
*
* ThuTuc2GiayToFinderImpl class
*   
* This class is used to get ThuTuc2GiayTo information 
* from database use Custom sql
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
public class ThuTuc2GiayToFinderImpl extends BasePersistenceImpl<ThuTuc2GiayTo> implements ThuTuc2GiayToFinder {
	
	/**
	  * This is fucntion get GiayToDinhKem by thuTucId, giaiDoan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucId, int giaiDoan
	  * @return List<GiayToDinhKem>
	  */
	public List<GiayToDinhKem> getDSGiayToByThuTucVaGiaiDoan(long thuTucId, int giaiDoan) throws Exception {
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.ThuTuc2GiayTo.getDSGiayToByThuTucVaGiaiDoan");
		
		BeanSQLQuery<GiayToDinhKem> query 
			= new BeanSQLQuery<GiayToDinhKem>(GiayToDinhKemImpl.class, this, sql);
	
		query.setLong("thuTucId", thuTucId);
		query.setInteger("giaiDoan", giaiDoan);
		query.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return query.getBeanResult();
	}
}
