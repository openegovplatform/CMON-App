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


package org.oep.cmon.portlet.quanlyvaitro.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.thamso.util.FormatUtil;
import org.oep.cmon.util.Helpers;

import sun.awt.UngrabEvent;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * This is class FormOfflineBusiness
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class QuanLyVaiTroBusiness {

	private static Log _log = LogFactoryUtil
			.getLog(QuanLyVaiTroBusiness.class);
	
	public static String VIEW_VAI_TRO 	= "View";
	public static String ADD_VAI_TRO 	= "Add";
	public static String UPDATE_VAI_TRO = "Update";

	/**
	 * This is function findByVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maTen
	 * @param start
	 * @param end
	 * @throws Exception
	 * @return List<VaiTro>
	 */
	public static List<VaiTro> findByVaiTro(String maTen, int start, int end) throws Exception {

		List<VaiTro> results = null;
		try {
	
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);
			query.addOrder(OrderFactoryUtil.asc("ten"));
			query.setLimit(start, end);
			// This is a test line for display all request if there's no search
			// criteria
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("daXoa",	Constants.ACTIVE);
	
			if (!Helpers.isEmpty(maTen)) {
				criterion = RestrictionsFactoryUtil.and(criterion,
							RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.ilike("ten", StringPool.PERCENT + maTen + StringPool.PERCENT),
													   RestrictionsFactoryUtil.ilike("ma",	StringPool.PERCENT + maTen + StringPool.PERCENT)));
			}
				// Define search criteria
			query = query.add(criterion);


			results = VaiTroLocalServiceUtil.dynamicQuery(query);
			
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}
		return results;
	}

	/**
	 * This is function countByVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maTen
	 * @throws Exception
	 * @return Long
	 */
	public static Long countByVaiTro(String maTen) throws Exception {
		
		long count = 0;
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);		
			
			// This is a test line for display all request if there's no search
			// criteria
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("daXoa",	Constants.ACTIVE);
	
			if (!Helpers.isEmpty(maTen)) {
				criterion = RestrictionsFactoryUtil.and(criterion,
							RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.ilike("ten", StringPool.PERCENT + maTen + StringPool.PERCENT),
													   RestrictionsFactoryUtil.ilike("ma",	StringPool.PERCENT + maTen + StringPool.PERCENT)));
			}
			
			query = query.add(criterion);
			query.setProjection(ProjectionFactoryUtil.rowCount());


			Iterator<Long>  resultsItr = 
					VaiTroLocalServiceUtil.dynamicQuery(query).iterator();

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
	
	
	
	/**
	 * This is function saveVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param vaiTro
	 * @throws Exception
	 * @return VaiTro
	 */
	public static VaiTro saveVaiTro(VaiTro vaiTro) throws Exception {

		try {
			if (vaiTro != null) {
				//vaiTro.getUngDungId();
				vaiTro.setId(CounterLocalServiceUtil.increment(VaiTro.class.getName()));
				VaiTroLocalServiceUtil.addVaiTro(vaiTro);
			}
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}		
		return vaiTro;
	}
	
	/**
	 * This is function saveTaiNguyen2VaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param taiNguyen2VaiTro
	 * @throws Exception
	 */
	public static void saveTaiNguyen2VaiTro(TaiNguyen2VaiTro taiNguyen2VaiTro) throws Exception {

		try {
			if (taiNguyen2VaiTro != null) {
				taiNguyen2VaiTro.setId(CounterLocalServiceUtil.increment(TaiNguyen2VaiTro.class.getName()));
				TaiNguyen2VaiTroLocalServiceUtil.addTaiNguyen2VaiTro(taiNguyen2VaiTro);
			}
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}		
		return;
	}
	
	/**
	 * This is function updateVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param vaiTro
	 * @throws Exception
	 */
	public static void updateVaiTro(VaiTro vaiTro) throws Exception {

		try {
			if (vaiTro != null) {
				VaiTro vaiTroDB = VaiTroLocalServiceUtil.getVaiTro(vaiTro.getId());
				if (vaiTroDB != null) {

					vaiTroDB.setTen(vaiTro.getTen());
					vaiTroDB.setMa(vaiTro.getMa());
					vaiTroDB.setMoTa(vaiTro.getMoTa());
					vaiTroDB.setUngDungId(vaiTro.getUngDungId());
					vaiTroDB.setTrangThai(vaiTro.getTrangThai());
					vaiTroDB.setDaXoa(vaiTro.getDaXoa());
					vaiTroDB.setNgaySua(new Date());
					vaiTroDB.setNguoiSua(vaiTro.getNguoiSua());
					VaiTroLocalServiceUtil.updateVaiTro(vaiTroDB);
				}
			}
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}		
		return;
	}
	
	/**
	 * This is function findByDanhMucUngDung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws Exception
	 * @return List<DanhMucUngDung>
	 */
	public static List<DanhMucUngDung> findByDanhMucUngDung() throws Exception {
		
		List<DanhMucUngDung> results = null;
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(DanhMucUngDung.class);
			query.addOrder(OrderFactoryUtil.asc("ten"));
			// This is a test line for display all request if there's no search
			// criteria
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("daXoa",	Constants.ACTIVE);
		
			// Define search criteria
			query = query.add(criterion);
	
			results = DanhMucUngDungLocalServiceUtil.dynamicQuery(query);
	
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}

		return results;
	}
	
	/**
	 * This is function checkExistingVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param vaiTroId
	 * @param ma
	 * @throws Exception
	 * @return boolean
	 */
	public static boolean checkExistingVaiTro(String vaiTroId, String ma) throws Exception {
		long count = 0;
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);		
			
			// This is a test line for display all request if there's no search
			// criteria
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("daXoa",	Constants.ACTIVE);
	
			if (!Helpers.isEmpty(vaiTroId)) {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ne("id", Long.valueOf(vaiTroId)));
			}
			
			if (!Helpers.isEmpty(ma)) {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("ma", ma));
			}
			
			query = query.add(criterion);
			query.setProjection(ProjectionFactoryUtil.rowCount());


			Iterator<Long>  resultsItr = 
					VaiTroLocalServiceUtil.dynamicQuery(query).iterator();

			if (resultsItr.hasNext()) {
				count = ((Long)resultsItr.next()).longValue();
			}
		}
		catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}

		return (count>0)?true:false;
	}

	/**
	 * This is function getVaiTroById
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @throws Exception
	 * @return VaiTro
	 */
	public static VaiTro getVaiTroById(Long id) throws Exception {
		VaiTro vaiTro = null;
		try {
			vaiTro = VaiTroLocalServiceUtil.getVaiTro(id);
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}		
		return vaiTro;
	}	
	
	/**
	 * This is function findAllTaiNguyenByVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param vaiTroId
	 * @throws Exception
	 * @return List<List<TaiNguyen>>
	 */
	public static List<List<TaiNguyen>> findAllTaiNguyenByVaiTro(String vaiTroId) throws Exception {
		List<List<TaiNguyen>> results = new ArrayList<List<TaiNguyen>>();
		try {			
				// Get dot VaiTro
				// VaiTro vaiTro = VaiTroLocalServiceUtil.getVaiTro(Long.valueOf(vaiTroId));
				
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiNguyen.class);
				query.addOrder(OrderFactoryUtil.asc("ten"));
				// This is a test line for display all request if there's no search criteria
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE);
				//criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("loai",  vai));

				// Define search criteria			
				query = query.add(criterion);	
				List<TaiNguyen> taiNguyenList = TaiNguyenLocalServiceUtil.dynamicQuery(query);
	
				// Get config
				List<TaiNguyen2VaiTro> configList = null;
				if (!Helpers.isEmpty(vaiTroId)) {
					configList = findAllConfigByVaiTro(vaiTroId);
				}
				
				List<TaiNguyen> taiNguyen1 = new ArrayList<TaiNguyen>();
				List<TaiNguyen> taiNguyen2 = new ArrayList<TaiNguyen>();
				TaiNguyen taiNguyen = null;
				TaiNguyen2VaiTro taiNguyen2VaiTro = null;
				if (taiNguyenList != null && taiNguyenList.size() > 0) {
					for (int i = 0; i < taiNguyenList.size(); i++) {
						taiNguyen = taiNguyenList.get(i);
						boolean flag = true;
						if (configList != null && configList.size() > 0) {
							for (int j = 0; j < configList.size(); j++) {
								taiNguyen2VaiTro = configList.get(j);
								if (taiNguyen.getId() == taiNguyen2VaiTro.getTaiNguyenId().longValue()) {
									flag = false;
									break;
								}
							}
						}
						if (flag) {
							taiNguyen1.add(taiNguyen);
						} else {
							taiNguyen2.add(taiNguyen);
						}
					}
				}
				results.add(taiNguyen1);
				results.add(taiNguyen2);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			throw e;
		}
		return results;
	}
	
	/**
	 * This is function findAllTaiNguyenByVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param taiNguyenDest
	 * @throws Exception
	 * @return List<List<TaiNguyen>>
	 */
	public static List<List<TaiNguyen>> findAllTaiNguyenByVaiTro(String[] taiNguyenDest) throws Exception {
		List<List<TaiNguyen>> results = new ArrayList<List<TaiNguyen>>();
		try {			
				// Get dot VaiTro
				// VaiTro vaiTro = VaiTroLocalServiceUtil.getVaiTro(Long.valueOf(vaiTroId));
				
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiNguyen.class);
				query.addOrder(OrderFactoryUtil.asc("ten"));
				// This is a test line for display all request if there's no search criteria
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE);
				//criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("loai",  vai));

				// Define search criteria			
				query = query.add(criterion);	
				List<TaiNguyen> taiNguyenList = TaiNguyenLocalServiceUtil.dynamicQuery(query);
				
				List<TaiNguyen> taiNguyen1 = new ArrayList<TaiNguyen>();
				List<TaiNguyen> taiNguyen2 = new ArrayList<TaiNguyen>();
				TaiNguyen taiNguyen = null;
				if (taiNguyenList != null && taiNguyenList.size() > 0) {
					for (int i = 0; i < taiNguyenList.size(); i++) {
						taiNguyen = taiNguyenList.get(i);
						boolean flag = true;
						if (taiNguyenDest != null && taiNguyenDest.length > 0) {
							for (int j = 0; j < taiNguyenDest.length; j++) {
								if (taiNguyen.getId() == Long.valueOf(taiNguyenDest[j]).longValue()) {
									flag = false;
									break;
								}
							}
						}
						if (flag) {
							taiNguyen1.add(taiNguyen);
						} else {
							taiNguyen2.add(taiNguyen);
						}
					}
				}
				results.add(taiNguyen1);
				results.add(taiNguyen2);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			throw e;
		}
		return results;
	}
	
	/**
	 * This is function findAllConfigByVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param vaiTroId
	 * @throws Exception
	 * @return List<TaiNguyen2VaiTro>
	 */
	public static List<TaiNguyen2VaiTro> findAllConfigByVaiTro(String vaiTroId) throws Exception {
		List<TaiNguyen2VaiTro> results = null;
		try {

			DynamicQuery query = DynamicQueryFactoryUtil.forClass(TaiNguyen2VaiTro.class);
			// query.addOrder(OrderFactoryUtil.asc("ten"));
			// This is a test line for display all request if there's no search criteria
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("daXoa", Constants.ACTIVE);
		
			if (!Helpers.isEmpty(vaiTroId)) {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("vaiTroId",  Long.valueOf(vaiTroId)));
			}
			// Define search criteria			
			query = query.add(criterion);
	
			results = TaiNguyen2VaiTroLocalServiceUtil.dynamicQuery(query);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			throw e;
		}
		return results;
	}
	
	/**
	 * This is function deleteTaiNguyen2VaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param vaiTroId
	 * @throws Exception
	 */
	public static void deleteTaiNguyen2VaiTro(String vaiTroId) throws Exception {

		try {
			if (!Helpers.isEmpty(vaiTroId)) {
				List<TaiNguyen2VaiTro> list = findAllConfigByVaiTro(vaiTroId);
				for (TaiNguyen2VaiTro taiNguyen2VaiTro : list) {
					TaiNguyen2VaiTroLocalServiceUtil.deleteTaiNguyen2VaiTro(taiNguyen2VaiTro.getId());
				}				
			}
		} catch (Exception se) {
			_log.error(se.getMessage(), se);
			throw se;
		}		
		return;
	}

	/**
	 * This is function checkSelectedValue
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value1
	 * @param value2
	 * @return String
	 */
	public static String checkSelectedValue(String value1, long value2) {
		if (value1 != null && !"".equals(StringUtil.trim(value1)) && FormatUtil.convertToLong(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	/**
	 * This is function checkSelectedValue
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value1
	 * @param value2
	 * @return String
	 */
	public static String checkSelectedValue(String value1, int value2) {
		if (value1 != null && !"".equals(StringUtil.trim(value1)) && FormatUtil.convertToInt(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}

	/**
	 * This is function checkSelectedValue
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value1
	 * @param value2
	 * @return String
	 */
	public static String checkSelectedValue(int value1, int value2) {
		if (value1 == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}

	/**
	 * This is function checkSelectedValue
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value1
	 * @param value2
	 * @return String
	 */
	public static String checkSelectedValue(String value1, String value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}

	/**
	 * This is function checkSelectedValue
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value1
	 * @param value2
	 * @return String
	 */
	public static String checkSelectedValue(Long value1, Long value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}

}
