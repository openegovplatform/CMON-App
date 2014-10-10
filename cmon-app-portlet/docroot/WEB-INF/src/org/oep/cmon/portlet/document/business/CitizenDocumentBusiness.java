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

package org.oep.cmon.portlet.document.business;

import java.util.Iterator;
import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.thamso.util.FormatUtil;

import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * This is class CongChucPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CitizenDocumentBusiness {
	
	private static Log _log = LogFactoryUtil
			.getLog(CitizenDocumentBusiness.class);
	
	public static String VIEW_TAI_LIEU 		= "View";
	public static String ADD_TAI_LIEU 		= "Add";
	public static String UPDATE_TAI_LIEU 	= "Update";

	public static List<TaiLieuChungThuc> findByChungThucHistory(Long danhMucGiayToId, Long congDanId, int start, int end) throws Exception {

		List<TaiLieuChungThuc> results = null;
		try {
	
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiLieuChungThuc.class);
			//query.addOrder(OrderFactoryUtil.desc("tuNgay"));
			query.addOrder(OrderFactoryUtil.desc("phienBan"));
			//query.addOrder(OrderFactoryUtil.asc("id"));
			query.setLimit(start, end);
			// This is a test line for display all request if there's no search
			// criteria
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("chuSohuuId", congDanId);
	
			if (Validator.isNotNull(danhMucGiayToId)) {
				criterion = RestrictionsFactoryUtil.and(criterion,
						RestrictionsFactoryUtil.eq("danhMucGiayToId", danhMucGiayToId));
			}
						
			// Define search criteria
			query = query.add(criterion);


			results = TaiLieuChungThucLocalServiceUtil.dynamicQuery(query);
			
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}
		return results;
	}

	public static Long countByChungThucHistory(Long danhMucGiayToId, Long congDanId) throws Exception {
		
		long count = 0;
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiLieuChungThuc.class);		
			
			Criterion criterion = null;

			criterion = RestrictionsFactoryUtil.eq("chuSohuuId", congDanId);
			
			if (Validator.isNotNull(danhMucGiayToId)) {
				criterion = RestrictionsFactoryUtil.and(criterion,
						RestrictionsFactoryUtil.eq("danhMucGiayToId", danhMucGiayToId));
			}
						
			query = query.add(criterion);
			query.setProjection(ProjectionFactoryUtil.rowCount());


			Iterator<Long>  resultsItr = 
					TaiLieuChungThucLocalServiceUtil.dynamicQuery(query).iterator();

			if (resultsItr.hasNext()) {
				count = ((Long)resultsItr.next()).longValue();
			}
		}
		catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}

		return count;
	}
	
	public static boolean checkExistChungThuc(long dmgtId, long congDanId)
			throws SystemException {

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiLieuChungThuc.class);
		// This is a test line for display all request if there's no search
		// criteria
		Criterion criterion = RestrictionsFactoryUtil.eq("trangThai", Constants.Citizen.TrangThai_ChungThuc);
		

		if (dmgtId > 0) {
			criterion = RestrictionsFactoryUtil.and(criterion,
					RestrictionsFactoryUtil.eq("danhMucGiayToId", dmgtId));
		}
		if (congDanId > 0) {
			criterion = RestrictionsFactoryUtil.and(criterion,
					RestrictionsFactoryUtil.eq("chuSohuuId", congDanId));
		}

		// Define search criteria
		query = query.add(criterion);

		query.setProjection(ProjectionFactoryUtil.max("phienBan"));

		return TaiLieuChungThucLocalServiceUtil.dynamicQueryCount(query) > 0;
	}
	
	public static int getMaxPhienBan(Long dmgtId, Long congDanId) throws Exception {
	      
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiLieuChungThuc.class);		
		
		Criterion criterion = null;

		criterion = RestrictionsFactoryUtil.eq("chuSohuuId", congDanId);
		
		if (Validator.isNotNull(dmgtId)) {
			criterion = RestrictionsFactoryUtil.and(criterion,
					RestrictionsFactoryUtil.eq("danhMucGiayToId", dmgtId));
		}
		// Define search criteria			
		query = query.add(criterion);
		query.setProjection(ProjectionFactoryUtil.max("phienBan"));
	      
	      int max = 0;
	      
	      try {
	    	
	        Iterator<Integer>  resultsItr = TaiLieuChungThucLocalServiceUtil.dynamicQuery(query).iterator();
	        if (resultsItr.hasNext()) {
	        	max = ((Integer)resultsItr.next()).intValue();
	        }
	       
	      }
	      catch (SystemException se) {
	          _log.error(se.getMessage(), se);
	    	  throw se;
	      }
	      
	      return max;
	}

	public static String checkSelectedValue(String value1, long value2) {
		if (value1 != null && !"".equals(StringUtil.trim(value1)) && FormatUtil.convertToLong(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	public static String checkSelectedValue(String value1, int value2) {
		if (value1 != null && !"".equals(StringUtil.trim(value1)) && FormatUtil.convertToInt(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}

	public static String checkSelectedValue(int value1, int value2) {
		if (value1 == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}

	public static String checkSelectedValue(String value1, String value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}

	public static String checkSelectedValue(Long value1, Long value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}

}
