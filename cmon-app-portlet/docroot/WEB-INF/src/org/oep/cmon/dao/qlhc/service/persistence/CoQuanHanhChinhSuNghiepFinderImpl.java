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

import org.oep.cmon.dao.qlhc.model.impl.CoQuanHanhChinhSuNghiepImpl;

import org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep;
import org.oep.cmon.dao.qlhc.service.persistence.CoQuanHanhChinhSuNghiepFinder;


import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class CoQuanHanhChinhSuNghiepFinderImpl   extends BasePersistenceImpl<CoQuanHanhChinhSuNghiep> implements CoQuanHanhChinhSuNghiepFinder {
	
	public java.util.List<CoQuanHanhChinhSuNghiep> getDonViHanhChinhCha(){
		
		java.util.List<CoQuanHanhChinhSuNghiep> result = null;
		
        Session session = null;
        
        try {  
            
        	session = openSession();  
            
            String base = "select * from cmon_coquanhanhchinhsunghiep " ;  
            StringBuffer sqlBuilder = new StringBuffer(base);  

            sqlBuilder.append("where daxoa = 0 ");
            sqlBuilder.append("and chaid is null");
                
            String sql = sqlBuilder.toString();  
            // Now that we have built the query, we can do all the usual stuff.  
            SQLQuery q = session.createSQLQuery(sql);  
            q.setCacheable(false);  
            q.addEntity("CoQuanHanhChinhSuNghiep", CoQuanHanhChinhSuNghiepImpl.class);  
  
            QueryPos qPos = QueryPos.getInstance(q);  
            //execute the query and return a list from the db  
            result= (List<CoQuanHanhChinhSuNghiep>) QueryUtil.list(q, getDialect(), 0, 100);
            
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            //must have this to close the hibernate session..  
            // if you fail to do this.. you will have a lot of open sessions�   
            closeSession(session);  
        }
        return result;
		
	}

}
