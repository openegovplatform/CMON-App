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

package org.oep.cmon.portlet.admin.congchuc.business;

import java.util.ArrayList;
import java.util.List;


import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.Session;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;

/**
 * This is class ChucVuBusiness
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ChucVuBusiness {
	
	/**
	 * This is  function find all ChucVu by CoQuanQuanLyId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param coQuanQuanLyId
	 * @return List<ChucVu>
	 */
	public static List<ChucVu> findAllByCoQuanQuanLyId(long coQuanQuanLyId){
		//DynamicQuery query = DynamicQueryFactoryUtil.forClass(ChucVuLocalServiceUtil.class);
		List<ChucVu> results = new ArrayList<ChucVu>();
		DynamicQuery queryJoin = DynamicQueryFactoryUtil.forClass(ChucVu2VaiTro.class, "b")
				.setProjection(ProjectionFactoryUtil.property("b.id"))
				.add(PropertyFactoryUtil.forName("b.chucvuid").eqProperty("a.id"))
				.add(PropertyFactoryUtil.forName("b.coquanquanlyid").eqProperty(String.valueOf(coQuanQuanLyId)));
				
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ChucVu.class, "a")
				.add(PropertyFactoryUtil.forName("a.id").in(queryJoin))
				.addOrder(OrderFactoryUtil.desc("a.ten"));
		try{
			results =  ChucVuLocalServiceUtil.dynamicQuery(query);			
		}catch (Exception e){
			e.printStackTrace();
		} 
		return results;	   
	   
	}
}
