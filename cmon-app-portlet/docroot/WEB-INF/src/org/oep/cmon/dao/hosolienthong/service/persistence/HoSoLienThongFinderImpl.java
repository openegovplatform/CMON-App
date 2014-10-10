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

package org.oep.cmon.dao.hosolienthong.service.persistence;

import javax.portlet.PortletRequest;

import org.oep.cmon.dao.hosolienthong.model.impl.HoSoLienThongImpl;
import org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil;
import org.oep.cmon.portlet.hosolienthong.HSLTFields;
import org.oep.egovcore.sqlutil.DynamicSQLBuilder;
import org.oep.egovcore.sqlutil.SQLBuilder;
import org.oep.egovcore.sqlutil.searchhelper.SearchHelper;
import org.oep.egovcore.validate.term.IsNumeral;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;
import org.oep.cmon.dao.hosolienthong.service.persistence.HoSoLienThongFinder;
import org.oep.egovcore.sqlutil.QueryResult;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


/**
*
* HoSoLienThongFinderImpl class
*   
* This class is used to get HoSoLienThong information 
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
public class HoSoLienThongFinderImpl extends BasePersistenceImpl<HoSoLienThong> implements HoSoLienThongFinder {
	
	/**
	  * This is fucntion searchHoSoNoiNhan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, CongChuc canBoNoiNhan, long[] thuTucNhanIds
	  * @return QueryResult<HoSoLienThong>
	  */
	public QueryResult<HoSoLienThong> searchHoSoNoiNhan(PortletRequest request, CongChuc canBoNoiNhan, long[] thuTucNhanIds) {
		
		DynamicSQLBuilder sqlBuilder = new DynamicSQLBuilder(
			CustomSQLUtil.get("org.oep.cmon.dao.hosolienthong.searchHoSoNoiNhan"),
			request
		);
		
		sqlBuilder.in("THUTUCNHANID", thuTucNhanIds);
		sqlBuilder.dynLongEQ("COQUANGUIID", HSLTFields.coQuanGuiId);
		sqlBuilder.dynIntegerEQ("TRANGTHAILIENTHONG", HSLTFields.trangThaiLienThong);
		sqlBuilder.eq("DAXOA", 0);
		sqlBuilder.orderDESC("NGAYSUA");
		
		SearchHelper<HoSoLienThong> helper = new SearchHelper<HoSoLienThong>(this, sqlBuilder);
		helper.createQuery()
			.addEntity(HoSoLienThong.class.getSimpleName(), HoSoLienThongImpl.class)
			.setInteger("TTLT_CHO_TIEP_NHAN", HSLTBusinessUtil.TTLT_CHO_TIEP_NHAN)
			.setLong("canBoNhanId", canBoNoiNhan.getId())
		;
		
		return helper.search();
	}
	
	/**
	  * This is fucntion searchHoSoNoiGui
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, CongChuc canBoNoiGui, long[] thuTucGuiIds
	  * @return QueryResult<HoSoLienThong>
	  */
	public QueryResult<HoSoLienThong> searchHoSoNoiGui(PortletRequest request, CongChuc canBoNoiGui, long[] thuTucGuiIds) {
		
		String tenCongDanHoacMaBienNhan = ParamUtil.getString(request, HSLTFields.tenCongDanORMaBienNhanKhiGui);
		String sql = "SELECT * FROM CMON_HOSOLIENTHONG " + SQLBuilder.WHERE_HOLDER;
		DynamicSQLBuilder sqlBuilder = new DynamicSQLBuilder(sql, request);
		
		sqlBuilder.eq("CANBOGUIID", canBoNoiGui.getId());
		sqlBuilder.in("THUTUCGUIID", thuTucGuiIds);
		sqlBuilder.dynIntegerEQ("TRANGTHAILIENTHONG", HSLTFields.trangThaiLienThong);
		
		// La ma Bien Nhan
		if (IsNumeral.check(tenCongDanHoacMaBienNhan)) {
	
			sqlBuilder.stringLeft("MASOBIENNHANGUI", tenCongDanHoacMaBienNhan);
			
		// La ten cong dan nop
		} else if (!tenCongDanHoacMaBienNhan.isEmpty()) {
			
			sqlBuilder.stringRight("HOTENCONGDANNOP", tenCongDanHoacMaBienNhan);
			
		}
		
		sqlBuilder.eq("DAXOA", 0);
		sqlBuilder.orderDESC("NGAYSUA");
		
		SearchHelper<HoSoLienThong> helper = new SearchHelper<HoSoLienThong>(this, sqlBuilder);
		helper.createQuery()
			.addEntity(HoSoLienThong.class.getSimpleName(), HoSoLienThongImpl.class);
		
		return helper.search();
	}
}
