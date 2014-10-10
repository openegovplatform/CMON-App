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

package org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.cd.model.impl.CongDanImpl;
import org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.CongDanFormModelView;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.persistence.CongDanUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * This is class CongDanBusiness
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CongDanBusiness {
	
	/**
	 * This is  function countByCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ten
	 * @return long
	 */
	public static long countByCongDan(String ten)
	{
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongDan.class);
		Criterion criterion = null;
		ten = ten.toUpperCase();

		criterion = RestrictionsFactoryUtil.ilike("ten", StringPool.PERCENT
				+ ten + StringPool.PERCENT);
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("ho", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("dem", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("tenDayDu", StringPool.PERCENT
						+ ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("email", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("ma", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("soCmnd", StringPool.PERCENT
						+ ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("tinhtrang",
						Constants.TINHTRANG_SONG));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));

		query = query.add(criterion);
		query.setProjection(ProjectionFactoryUtil.rowCount());

		long count = 0;

		try {
			Iterator<Long> resultsItr = CongDanLocalServiceUtil.dynamicQuery(
					query).iterator();

			if (resultsItr.hasNext()) {
				count = ((Long) resultsItr.next()).longValue();
			}
		} catch (SystemException se) {
			// _log.error(se.getMessage(), se);
		}

		return count;
	}
	
	/**
	 * This is  function find CongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ten
	 * @param start
	 * @param end
	 * @return list<CongDan>
	 */
	public static List<CongDan> findByCongDan(String ten, int start, int end)
	{
		List<CongDan> results = null;
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongDan.class);
		query.addOrder(OrderFactoryUtil.asc("ten"));
		query.setLimit(start, end);
		Criterion criterion = null;

		ten = ten.toUpperCase();

		criterion = RestrictionsFactoryUtil.ilike("ten", StringPool.PERCENT
				+ ten + StringPool.PERCENT);
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("ho", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("dem", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("tenDayDu", StringPool.PERCENT
						+ ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("email", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("ma", StringPool.PERCENT + ten
						+ StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.or(
				criterion,
				RestrictionsFactoryUtil.ilike("soCmnd", StringPool.PERCENT
						+ ten + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("tinhtrang",
						Constants.TINHTRANG_SONG));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));

		// Define search criteria
		query = query.add(criterion);

		try {
			results = CongDanLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
		}

		if (results == null) {
			results = new ArrayList<CongDan>();
		}
		return results;
		
	}
	
	/**
	 * This is  function get CongDan from request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @throws SystemException
	 * @return CongDan
	 */
	public static CongDan getCongDanFromRequest(ActionRequest request) throws SystemException{
		CongDan congDan = null;
		if (Validator.isNotNull(ParamUtil.getString(request, "tvslId"))
				&& ParamUtil.getLong(request, "tvslId") != 0) {
			congDan = CongDanLocalServiceUtil.fetchCongDan(ParamUtil.getLong(
					request, "tvslId"));
		} else {
			congDan = new CongDanImpl();
		}
		congDan.setTenDayDu(ParamUtil.getString(request, "tvslTen"));
		congDan.setGioiTinh(ParamUtil.getInteger(request, "tvslGioiTinh"));
		if(Validator.isNotNull(ParamUtil.getString(request, "tvslNgaySinh"))){
			congDan.setNgaySinh(ParamUtil.getDate(request, "tvslNgaySinh",
					new SimpleDateFormat("dd/MM/yyyy")));
		}else{
			congDan.setNgaySinh(null);
		}
		congDan.setQuocTichId(ParamUtil.getLong(request, "tvslQuocTich"));
		congDan.setDanTocId(ParamUtil.getLong(request, "tvslDanToc"));
		congDan.setSoCmnd(ParamUtil.getString(request, "tvslSoCMND"));
		if(Validator.isNotNull(ParamUtil.getString(request, "tvslNgayCapCMND"))){
			congDan.setNgayCapCmnd(ParamUtil.getDate(request, "tvslNgayCapCMND",
					new SimpleDateFormat("dd/MM/yyyy")));
		}else{
			congDan.setNgayCapCmnd(null);
		}
		congDan.setNoiCapCmndId(ParamUtil.getLong(request,"tvslNoiCapCMND"));
		congDan.setDiaChiThuongTruTinhId(ParamUtil.getLong(request,
				"tvslTtTinhId"));
		congDan.setDiaChiThuongTruHuyenId(ParamUtil.getLong(request,
				"tvslTtHuyenId"));
		congDan.setDiaChiThuongTruXaId(ParamUtil.getLong(request, "tvslTtXaId"));
		congDan.setDiaChiThuongTru(ParamUtil.getString(request,
				"tvslTtMoTaDiaChi"));
		congDan.setDiaChiHienNayTinhId(ParamUtil.getLong(request,
				"tvslCohtTinhId"));
		congDan.setDiaChiHienNayHuyenId(ParamUtil.getLong(request,
				"tvslCohtHuyenId"));
		congDan.setDiaChiHienNayXaId(ParamUtil.getLong(request, "tvslCohtXaId"));
		congDan.setDiaChiHienNay(ParamUtil.getString(request,
				"tvslCohtMoTaChoO"));
		return congDan;
	}
	
	
	
	
	
	
	
	
	
}
