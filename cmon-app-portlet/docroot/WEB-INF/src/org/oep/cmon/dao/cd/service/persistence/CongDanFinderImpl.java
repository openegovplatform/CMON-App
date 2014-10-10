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

package org.oep.cmon.dao.cd.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletRequest;

import org.oep.cmon.portlet.hosotructiep.HoSoFields;
import org.oep.egovcore.sqlutil.DynamicSQLBuilder;
import org.oep.egovcore.sqlutil.searchhelper.BeanSearchHelper;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.persistence.CongDanFinder;
import org.oep.cmon.dao.cd.service.persistence.CongDanUtil;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.egovcore.sqlutil.QueryResult;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


/**
*
* CongDanFinderImpl class
*   
* This class is used to get CongDan information 
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
public class CongDanFinderImpl extends BasePersistenceImpl<CongDan> implements CongDanFinder {
	
	/**
	  * This is fucntion search CongDan by request by soCMND, ten, ngaysinh, tinhtrang,trangthai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param request parameter
	  * @return List<CongDan>
	  */
	public QueryResult<org.oep.cmon.dao.beans.congdan.CongDan> search(
			PortletRequest request) throws Exception {
		DynamicSQLBuilder sqlBuider = new DynamicSQLBuilder(
				CustomSQLUtil.get("org.oep.cmon.dao.cd.search"), request);
		sqlBuider.dynStringEQ("CD.SOCMND", HoSoFields.soCMND);
		sqlBuider
				.dynStringFull(
						"TRIM(TO_CHAR(CD.HO)) || TO_CHAR(' ') || TRIM(TO_CHAR(CD.DEM)) || TO_CHAR(' ') ||  TRIM(TO_CHAR(CD.TEN))",
						HoSoFields.hoTenNguoiNopHoSo);
		sqlBuider.dynDateEQ("CD.NGAYSINH", HoSoFields.ngaySinh);
		sqlBuider.eq("CD.TINHTRANG", 1);
		sqlBuider.eq("CD.DAXOA", 0);

		BeanSearchHelper<org.oep.cmon.dao.beans.congdan.CongDan> helper = new BeanSearchHelper<org.oep.cmon.dao.beans.congdan.CongDan>(
				this, sqlBuider,
				org.oep.cmon.dao.beans.congdan.CongDanImpl.class);

		return helper.search();
	}
	
	/**
	  * This is fucntion find CongDan by liferayUserId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long liferayUserId
	  * @return CongDan
	  */
	public CongDan getCongDanByLiferayUserId(Long liferayUserId) {
		// TODO Auto-generated method stub
		Session session = null;
		List<DanhMucGiayTo> list = new ArrayList<DanhMucGiayTo>();
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT MAX(cd.id) AS ID FROM CSMS_CONGDAN cd ");
			sql.append(" JOIN CMON_TAIKHOANNGUOIDUNG t on t.id=cd.taikhoannguoidungid ");
			sql.append(" WHERE cd.daxoa=0 and t.daxoa=0 and t.taikhoannguoidungid= ? ");

			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addScalar("ID", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(liferayUserId)) {
				qPos.add(liferayUserId);
			}
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {
				Long value = itr.next();
				CongDan resutl = CongDanUtil.fetchByPrimaryKey(value);
				if (resutl == null) {
					resutl = CongDanUtil.fetchByPrimaryKey(value);
				}
				return resutl;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeSession(session);
		}
		return null;
	}
	
}
