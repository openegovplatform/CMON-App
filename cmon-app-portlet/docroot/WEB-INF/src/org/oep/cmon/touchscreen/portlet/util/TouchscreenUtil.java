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

package org.oep.cmon.touchscreen.portlet.util;

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

/**
 * This is class TouchscreenUtil  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class TouchscreenUtil {

	/**
	 * This is function list HoSo 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id_donvi
	 * @param id_ccqql
	 * @throws Exception
	 * @return List<CoQuanQuanLy>
	 */
	@SuppressWarnings("unchecked")
	public static List<HoSoTTHCCong> listHoSo(long id_donvi, String[] id_ccqql)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(HoSoTTHCCong.class);
		if (id_donvi != 0) {
			query.add(PropertyFactoryUtil.forName("coQuanTiepNhanId").eq(
					id_donvi));
		} else {
			if (id_ccqql.length > 0) {
				query.add(PropertyFactoryUtil.forName("coQuanTiepNhanId").in(
						listIdCoQuanQuanLy(id_ccqql).toArray()));
			}
		}
		query.addOrder(OrderFactoryUtil.desc("id"));
		query.setLimit(0, 100);
		List<HoSoTTHCCong> listresult = HoSoTTHCCongLocalServiceUtil
				.dynamicQuery(query);
		return listresult;
	}

	/**
	 * This is function get list CoQuanQuanLy by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id_coquanquanly
	 * @throws Exception
	 * @return List<CoQuanQuanLy>
	 */
	@SuppressWarnings("unchecked")
	public static List<CoQuanQuanLy> listCoQuanQuanLy(List<Long> id_coquanquanly)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(CoQuanQuanLy.class);
		query.add(PropertyFactoryUtil.forName("capCoQuanQuanlyId").in(
				id_coquanquanly.toArray()));
		query.add(PropertyFactoryUtil.forName("daXoa").eq(0));
		query.addOrder(OrderFactoryUtil.asc("capCoQuanQuanlyId"));
		List<CoQuanQuanLy> listresult = CoQuanQuanLyLocalServiceUtil
				.dynamicQuery(query);
		return listresult;
	}

	/**
	 * This is function get list CoQuanQuanLyId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id_ccqql
	 * @throws Exception
	 * @return List<Long>
	 */
	@SuppressWarnings("unchecked")
	public static List<Long> listIdCoQuanQuanLy(String[] id_ccqql)
			throws Exception {
		List<Long> idcapcoquan = new ArrayList<Long>();
		for (int i = 0; i < id_ccqql.length; i++) {
			idcapcoquan.add(Long.valueOf(id_ccqql[i]));
		}
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(CoQuanQuanLy.class);
		query.add(PropertyFactoryUtil.forName("capCoQuanQuanlyId").in(
				idcapcoquan.toArray()));
		query.add(PropertyFactoryUtil.forName("daXoa").eq(0));
		query.setProjection(ProjectionFactoryUtil.property("id"));
		List<Long> listresult = CoQuanQuanLyLocalServiceUtil
				.dynamicQuery(query);
		return listresult;
	}

	/**
	 * This is function trim string
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param str
	 * @param lenght
	 * @throws Exception
	 * @return String
	 */
	public static String trimString(String str,int length) throws Exception {
		String result =str;
		if(length<str.length()){
			int lastSpaceIndex = str.lastIndexOf(" ",length);
			result = str.substring(0,lastSpaceIndex)+"...";
		}
		return result;
	}
}
