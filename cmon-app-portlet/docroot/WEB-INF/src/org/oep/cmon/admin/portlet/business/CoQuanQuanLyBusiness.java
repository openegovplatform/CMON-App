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

package org.oep.cmon.admin.portlet.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.oep.cmon.admin.portlet.util.ConvertUtil;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLyClp;

import org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/** 
 * This is class CoQuanQuanLyBusiness
 * 
 * This class contains logics related to CoQuanQuanLy table
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  21-March-2013  Nam Dinh    Create new
 */
public class CoQuanQuanLyBusiness {
	
	/** 
	 * This is function insert CoQuanQuanLy
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param userRequest
	 * @param parentId
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void insert(Map<String, String> userRequest, long parentId, ActionRequest request) throws PortalException, SystemException {
		// Get ma co quan quan ly
		String donViHanhChinhId = userRequest.get("xa");
		if(donViHanhChinhId.isEmpty()){
			donViHanhChinhId = userRequest.get("huyen");
			if(donViHanhChinhId.isEmpty()){
				donViHanhChinhId = userRequest.get("tinh");
			}
		}
		CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyClp();
		
		coQuanQuanLy.setId(CounterLocalServiceUtil.increment(this.getClass().getName()));
		
		coQuanQuanLy.setMa(userRequest.get("ma"));

		coQuanQuanLy.setTen(userRequest.get("ten"));

		coQuanQuanLy.setDonViHanhChinhId(Long.parseLong(donViHanhChinhId));
		
		coQuanQuanLy.setDiaChi(userRequest.get("motaDiaChi"));
		
		coQuanQuanLy.setDienThoai(userRequest.get("dienThoai"));
		
		coQuanQuanLy.setEmail(userRequest.get("email"));
		
		coQuanQuanLy.setFax(userRequest.get("fax"));
		
		coQuanQuanLy.setWebsite(userRequest.get("website"));
		
		coQuanQuanLy.setMerchant(userRequest.get("merChant"));
		
		coQuanQuanLy.setAccessCode(userRequest.get("accessCode"));
		
		coQuanQuanLy.setSecureSecret(userRequest.get("secureSecret"));
		
		if ( Validator.isNotNull(userRequest.get("noiBo"))){
			coQuanQuanLy.setNoiBo(Integer.parseInt(userRequest.get("noiBo")));
		}
		
		// Get id of cap co quan quan ly
		String capCoQuanQuanLy = userRequest.get("capCoQuanQuanLy");
		String id = capCoQuanQuanLy.substring(0, capCoQuanQuanLy.indexOf("-"));
		
		if (ConvertUtil.convertToLong(id) > 0) {
			coQuanQuanLy.setCapCoQuanQuanlyId(ConvertUtil.convertToLong(id));
		}
		
		if (parentId > 0) {
			coQuanQuanLy.setChaId(parentId);
		}
		
		Date currentDate = new Date();
		
		coQuanQuanLy.setNgayTao(currentDate);
		
		coQuanQuanLy.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(request);
		
		if ( currentUser != null) {		
			coQuanQuanLy.setNguoiTao(currentUser.getFullName());
			coQuanQuanLy.setNguoiSua(currentUser.getFullName());			
		} else {
			// This is for test without logging in
			coQuanQuanLy.setNguoiTao("DUMMY");
			coQuanQuanLy.setNguoiSua("DUMMY");	
		}
		
		coQuanQuanLy.setDaXoa(0);
		CoQuanQuanLyLocalServiceUtil.addCoQuanQuanLy(coQuanQuanLy);		
	}
	
	/** 
	 * This is function Edit CoQuanQuanLy
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param userRequest
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void edit(Map<String, String> userRequest, ActionRequest request) throws PortalException, SystemException {
		// Get ma co quan quan ly
		String donViHanhChinhId = userRequest.get("xa");
		if(donViHanhChinhId.isEmpty()){
			donViHanhChinhId = userRequest.get("huyen");
			if(donViHanhChinhId.isEmpty()){
				donViHanhChinhId = userRequest.get("tinh");
			}
		}
		CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.parseLong(userRequest.get("id")));
		
		coQuanQuanLy.setMa(userRequest.get("ma"));

		coQuanQuanLy.setTen(userRequest.get("ten"));

		coQuanQuanLy.setDonViHanhChinhId(Long.parseLong(donViHanhChinhId));		
		
		coQuanQuanLy.setDiaChi(userRequest.get("motaDiaChi"));
		
		coQuanQuanLy.setDienThoai(userRequest.get("dienThoai"));
		
		coQuanQuanLy.setEmail(userRequest.get("email"));
		
		coQuanQuanLy.setFax(userRequest.get("fax"));
		
		coQuanQuanLy.setWebsite(userRequest.get("website"));
		
		coQuanQuanLy.setMerchant(userRequest.get("merChant"));
		
		coQuanQuanLy.setAccessCode(userRequest.get("accessCode"));
		
		coQuanQuanLy.setSecureSecret(userRequest.get("secureSecret"));
		
		if ( Validator.isNotNull(userRequest.get("noiBo"))){
			coQuanQuanLy.setNoiBo(Integer.parseInt(userRequest.get("noiBo")));
		}
		
		// Get id of cap co quan quan ly
		String capCoQuanQuanLy = userRequest.get("capCoQuanQuanLy");
		String id = capCoQuanQuanLy.substring(0, capCoQuanQuanLy.indexOf("-"));
		
		coQuanQuanLy.setCapCoQuanQuanlyId(Long.parseLong(id));
		
		Date currentDate = new Date();
		
		coQuanQuanLy.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(request);
		
		if ( currentUser != null) {		
			coQuanQuanLy.setNguoiSua(currentUser.getFullName());			
		}
		
		CoQuanQuanLyLocalServiceUtil.updateCoQuanQuanLy(coQuanQuanLy);		
	}
	
	/** 
	 * This is function delete CoQuanQuanLy
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param id
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void delete(long id) throws PortalException, SystemException {
		CoQuanQuanLyLocalServiceUtil.deleteCoQuanQuanLy(id);
	}
	/** 
	 * This is function find ChucVu by DaXoa
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param daXoa
	 * @return List<ChucVu>
	 * @throws SystemException
	 */
	public static List<ChucVu> findChucVuByDaXoa(int daXoa) {
		List<ChucVu> results = null;

		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(ChucVu.class);		
			
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", daXoa);
					
			// Define search criteria
			query = query.add(criteriaTrangThai);
					
			results = ChucVuLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if (results == null) {
			results = new ArrayList<ChucVu>();
		}

		return results;
	}
	
	/** 
	 * This is function find VaiTro By DaXoa
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param daXoa
	 * @return List<VaiTro>
	 */
	public static List<VaiTro> findVaiTroByDaXoa(int daXoa) {
		List<VaiTro> results = null;

		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);		
			
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", daXoa);
					
			// Define search criteria
			query = query.add(criteriaTrangThai);
					
			results = VaiTroLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if (results == null) {
			results = new ArrayList<VaiTro>();
		}

		return results;
	}
	
	/** 
	 * This is function find list VaiTro by ChucVuId
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param chucVuId
	 * @param coQuanQuanLyId
	 * @return List<VaiTro>
	 */
	public static List<VaiTro> findListVaiTroByChucVuId(long chucVuId, long coQuanQuanLyId) {
		List<VaiTro> results = new ArrayList<VaiTro>();

		try {
			List<ChucVu2VaiTro> listVaiTros = ChucVu2VaiTroLocalServiceUtil.findByIdChucVuAndIdCoQuanQuanLy(chucVuId, coQuanQuanLyId, 0);
			for (ChucVu2VaiTro chucVu2VaiTro : listVaiTros) {
				try {
					results.add(VaiTroLocalServiceUtil.fetchVaiTro(chucVu2VaiTro.getVaiTroId()));
				} catch (Exception e) {
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}
	
	/** 
	 * This is function check list VaiTro not selected
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param liTrosAll
	 * @param liTrosSelected
	 * @return List<VaiTro>
	 */
	public static List<VaiTro> checkListVaiTroNotSelected(List<VaiTro> liTrosAll, List<VaiTro> liTrosSelected) {
		List<VaiTro> results = new ArrayList<VaiTro>();
		boolean flag = true;

		try {
			for (VaiTro chucVu2VaiTro : liTrosAll) {
				for (VaiTro vaiTro : liTrosSelected) {
					if (chucVu2VaiTro.getId() == vaiTro.getId()) {
						flag = false;
						break;
					}
				}
				if (flag) {
					results.add(chucVu2VaiTro);
				}
				flag = true;
			}
			
		} catch (Exception e) {
		}
		
		return results;
	}
	
	/** 
	 * This is function find UserGroup by Name
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param name
	 * @param actionRequest
	 * @return UserGroup
	 */
	public static UserGroup findUserGroupByName(String name, ActionRequest actionRequest) {
		//long companyId = ConvertUtil.convertToLong(WebserviceFactory.getThamSoService().getValue("CMON_ADMIN_COMPANY_ID"));
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			List<UserGroup> results = UserGroupLocalServiceUtil.getUserGroups(companyId);
			for (UserGroup userGroup : results) {
				if (userGroup.getName().toLowerCase().equals(name.toLowerCase()) ) {
					return userGroup;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
