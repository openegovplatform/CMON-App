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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.Constants;


import org.oep.cmon.dao.dn.model.DoanhNghiep;

import org.oep.cmon.dao.dn.service.DoanhNghiepLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * This is class QuanLyTaiKhoan
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class QuanLyTaiKhoan {
	private static final Log LOG = LogFactoryUtil.getLog(QuanLyTaiKhoan.class);
	
	/**
	 * This is  function get count DoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ten
	 * @param loaiDoiTuongId
	 * @throws trangThai
	 * @return long
	 */
	public static long countByDoanhNghiep(String ten,long loaiDoiTuongId,int trangThai)
	{
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DoanhNghiep.class);		
		
		if(!ten.equals("")){
			Criterion criterion = null;
			ten = ten.toUpperCase();			
			criterion = RestrictionsFactoryUtil.ilike("ten",  StringPool.PERCENT + ten + StringPool.PERCENT);
			
			
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("tenTiengNuocNgoai", StringPool.PERCENT + ten + StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("tenVietTat", StringPool.PERCENT + ten + StringPool.PERCENT));
			
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("emailDoanhNghiep", StringPool.PERCENT + ten + StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("soGCNDKKD", StringPool.PERCENT + ten + StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
			query = query.add(criterion);
		}
		if(loaiDoiTuongId!=0){
			Criterion criterion1 = RestrictionsFactoryUtil.eq("loaiDoiTuongId", loaiDoiTuongId);
			criterion1 = RestrictionsFactoryUtil.and(criterion1, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
			query = query.add(criterion1);
		}
		if(trangThai!=99){
			Criterion criterion2=null;
			if(trangThai == 2){
				criterion2 = RestrictionsFactoryUtil.isNull("taiKhoanNguoiDungId");
			}else
				criterion2 = RestrictionsFactoryUtil.isNotNull("taiKhoanNguoiDungId");
			
			criterion2 = RestrictionsFactoryUtil.and(criterion2, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
			query = query.add(criterion2);
		}
		
		
		
		//query.setProjection(ProjectionFactoryUtil.max("thuTuHienThi"));
		query.setProjection(ProjectionFactoryUtil.rowCount());
		//query.setProjection(ProjectionFactoryUtil.sum("counter"));
		//DynamicQueryInitializ dqi = new DynamicQueryInitializerImpl(query);

		long count = 0;

		try {
			Iterator<Long>  resultsItr = 
					DoanhNghiepLocalServiceUtil.dynamicQuery(query).iterator();

			if (resultsItr.hasNext()) {
				count = ((Long)resultsItr.next()).longValue();
			}
		}
		catch (SystemException se) {
			// _log.error(se.getMessage(), se);
		}

		return count;
	}
	
	/**
	 * This is  function get list DoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ten
	 * @param loaiDoiTuongId
	 * @param trangThai
	 * @param start
	 * @param end
	 * @throws SystemException
	 */
	public static List<DoanhNghiep> getListDoanhNghiep(String ten,long loaiDoiTuongId,int trangThai, int start, int end) throws SystemException{
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DoanhNghiep.class);		
		List<DoanhNghiep> results=null;
		if(!ten.equals("")){
			Criterion criterion = null;
			ten = ten.toUpperCase();			
			criterion = RestrictionsFactoryUtil.ilike("ten",  StringPool.PERCENT + ten + StringPool.PERCENT);			
			
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("tenTiengNuocNgoai", StringPool.PERCENT + ten + StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("tenVietTat", StringPool.PERCENT + ten + StringPool.PERCENT));
			
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("emailDoanhNghiep", StringPool.PERCENT + ten + StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("soGCNDKKD", StringPool.PERCENT + ten + StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
			query = query.add(criterion);
		}
		if(loaiDoiTuongId!=0){
			Criterion criterion1 = RestrictionsFactoryUtil.eq("loaiDoiTuongId", loaiDoiTuongId);
			criterion1 = RestrictionsFactoryUtil.and(criterion1, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
			query = query.add(criterion1);
		}
		if(trangThai!=99){
			Criterion criterion2=null;
			if(trangThai == 2){
				criterion2 = RestrictionsFactoryUtil.isNull("taiKhoanNguoiDungId");
			}else
				criterion2 = RestrictionsFactoryUtil.isNotNull("taiKhoanNguoiDungId");
			
			criterion2 = RestrictionsFactoryUtil.and(criterion2, RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE));
			query = query.add(criterion2);
		}
		results = DoanhNghiepLocalServiceUtil.dynamicQuery(query);
		if (results == null) {
			results = new ArrayList<DoanhNghiep>();
		}
		return results;

	}
	
	

}
