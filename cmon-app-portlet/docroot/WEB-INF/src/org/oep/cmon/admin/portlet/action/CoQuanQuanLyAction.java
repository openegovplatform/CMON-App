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

package org.oep.cmon.admin.portlet.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.admin.portlet.business.CoQuanQuanLyBusiness;
import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.admin.portlet.util.LiferayUserGroupUtils;
import org.oep.cmon.admin.portlet.util.UserGroupUtils;
import org.oep.cmon.portlet.taocongdan.action.TaoCongDanAction;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro;
import org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTroClp;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;

import org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class CoQuanQuanLyAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CoQuanQuanLyAction {
	
	/** Search by code option */
	private static String SEARCH_CODE_OPTION = "0";
	
	/** Search by name option */
	private static String SEARCH_NAME_OPTION = "1";
	
	/** Action mode, 0: insert, 1: edit */
	private static int INSERT_MODE = 0;
	
	/** Action mode, 0: insert, 1: edit */
	private static int EDIT_MODE = 1;
	private final String CMON_ADMIN_COMPANY_ID = "CMON_ADMIN_COMPANY_ID";
	private static Log log = LogFactoryUtil.getLog(CoQuanQuanLyAction.class);
	
	/**
	 * This is function search CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void searchCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the search option
		String searchOption = ParamUtil.getString(actionRequest, "searchOption");
		
		// Get the parent id if submitted
		String strParentId = ParamUtil.getString(actionRequest, "parentId");
		long parentId = 0;
		
		if ( Validator.isNotNull(strParentId)) {
			parentId = Long.parseLong(strParentId);
		}
		
		// Get the search keyword if submitted
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
		
		this.searchCoQuanQuanLy(searchOption, parentId, keyWord, actionRequest, actionResponse);
	}
	
	/**
	 * This is function search CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param searchOption
	 * @param parentId
	 * @param keyWord
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void searchCoQuanQuanLy(String searchOption, long parentId, String keyWord, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Build the query		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CoQuanQuanLy.class);
		
		// Always search un-deleted record
		query = query.add( PropertyFactoryUtil.forName("daXoa").eq(0));		
		
		// Add the criteria incase keyword search is not null
		if ( Validator.isNotNull(searchOption) && Validator.isNotNull(keyWord)) {
			Criterion criteria = null;		
			
			// Define search criteria
			if ( searchOption.equals(SEARCH_CODE_OPTION)) {
				criteria = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");	
			} else {
				criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");
			} 
			
			// Define search criteria
			query = query.add( criteria );
		}

// BinhNT Comemnt lai theo yeu cau anh Giang muon search all 2013-11-01		
//		// Query by parent id
//		if (parentId > 0) {
//			query = query.add( PropertyFactoryUtil.forName("chaId").eq(parentId));		
//		} else {
//			// Search all highest level			
//			Criterion cr1 = RestrictionsFactoryUtil.isNull("chaId");
//			Criterion cr2 = RestrictionsFactoryUtil.eq("chaId", new Long(0));
//			
//			query = query.add( RestrictionsFactoryUtil.or(cr1, cr2));			
//		}
// End Binh Comment

		// BinhNT Add 2013-11-01
		// Query by parent id
		if (parentId > 0) {
			query = query.add( PropertyFactoryUtil.forName("chaId").eq(parentId));		
		}
		// End BinhNT Add 2013-11-01

		List<CoQuanQuanLy> results = null;
		
		try {
			results = CoQuanQuanLyLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		// Set the result back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_CO_QUAN_QUAN_LY_RESULT", results);
		
		// Store the search option to session for coming back to search screen from edit screen
		Map<String, String> searchParam = new HashMap<String, String>();

		if (Validator.isNull(searchOption)) {
			searchOption = SEARCH_NAME_OPTION;
		}
		
		searchParam.put("searchOption", searchOption);		
		searchParam.put("keyWord", keyWord);
		searchParam.put("parentId", String.valueOf(parentId ));
		
		// Set the search param back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_CO_QUAN_QUAN_LY_PARAMS", searchParam);
		
		// Redirect User
		String popup = ParamUtil.getString(actionRequest, "popup");
		if ( Validator.isNotNull(popup)) {
			actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/co_quan_quan_ly_list_popup.jsp");
		} else {
			actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/co_quan_quan_ly_list.jsp");
		}
		
		actionResponse.setRenderParameter("parentId", String.valueOf(parentId ));
		actionResponse.setRenderParameter("searchOption", searchOption);
		actionResponse.setRenderParameter("keyWord", keyWord);
	}
	
	/**
	 * This is function reload role CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void reloadQuyenToCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String chuc_vu_id = ParamUtil.getString(actionRequest, "chuc_vu_id");
		String coQuanQuanLyID = ParamUtil.getString(actionRequest, "coQuanQuanLyID");
		
		actionResponse.setRenderParameter("coQuanQuanLyID", coQuanQuanLyID);
		actionResponse.setRenderParameter("chuc_vu_id", chuc_vu_id);
		actionResponse.setRenderParameter("keyWord", ParamUtil.getString(actionRequest, "keyWord").trim());
		actionResponse.setRenderParameter("searchOption", ParamUtil.getString(actionRequest, "searchOption").trim());
		actionResponse.setRenderParameter("parentId", ParamUtil.getString(actionRequest, "parentId").trim());
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/themvaitro_chucvucho_coquanquanly.jsp");
	}
	
	/**
	 * This is function delete role CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteQuyenToCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String chuc_vu_id = ParamUtil.getString(actionRequest, "chuc_vu_id");
		String vaitro_id = ParamUtil.getString(actionRequest, "vaitro_id");
		String coQuanQuanLyID = ParamUtil.getString(actionRequest, "coQuanQuanLyID");
		ChucVu2VaiTro chucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil.findChucVu2VaiTro(ConvertUtil.convertToLong(vaitro_id), ConvertUtil.convertToLong(coQuanQuanLyID), ConvertUtil.convertToLong(chuc_vu_id));
		if (chucVu2VaiTro != null) {
			// Tim ten UserGroup
			UserGroup userGroup = null;
			String tenGroup = "";
			long groupIdS[] = null; 
			try {
				ChucVu2VaiTroLocalServiceUtil.deleteChucVu2VaiTro(chucVu2VaiTro.getId());
				CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(ConvertUtil.convertToLong(coQuanQuanLyID));
				ChucVu chucVu = ChucVuLocalServiceUtil.fetchChucVu(ConvertUtil.convertToLong(chuc_vu_id));
				//tenGroup = coQuanQuanLy.getTen() + "_" + chucVu.getTen();
				tenGroup = LiferayUserGroupUtils
						.getUserGroupName(coQuanQuanLy.getTen(), chucVu.getTen());

				// Tim xem da tao Group voi ten nhu tren chua
				userGroup = CoQuanQuanLyBusiness.findUserGroupByName(tenGroup, actionRequest);
				if (userGroup != null) {
					groupIdS = new long[]{userGroup.getGroup().getGroupId()};
				}
			} catch (Exception e) {
			}
			
			// Bo thiet lap role den group ben liferay.
			if (groupIdS != null) {
				TaiNguyen taiNguyen = null;
				List<TaiNguyen2VaiTro> lNguyen2VaiTros = TaiNguyen2VaiTroLocalServiceUtil.findByVaiTroID(chucVu2VaiTro.getVaiTroId(), 0);
				if (lNguyen2VaiTros != null) {
					for (TaiNguyen2VaiTro taiNguyen2VaiTro : lNguyen2VaiTros) {
						try {
							taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyen2VaiTro.getTaiNguyenId());
							if (ConvertUtil.convertToLong(taiNguyen.getGiaTri()) > 0) {
								try {
									GroupLocalServiceUtil.unsetRoleGroups(ConvertUtil.convertToLong(taiNguyen.getGiaTri()), groupIdS);
								} catch (Exception es1) {
									es1.printStackTrace();
								}
							}
						} catch (Exception ess) {
							ess.printStackTrace();
						}
					}
				}
			}
		}
		
		actionResponse.setRenderParameter("coQuanQuanLyID", coQuanQuanLyID);
		actionResponse.setRenderParameter("chuc_vu_id", chuc_vu_id);
		actionResponse.setRenderParameter("keyWord", ParamUtil.getString(actionRequest, "keyWord").trim());
		actionResponse.setRenderParameter("searchOption", ParamUtil.getString(actionRequest, "searchOption").trim());
		actionResponse.setRenderParameter("parentId", ParamUtil.getString(actionRequest, "parentId").trim());
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/themvaitro_chucvucho_coquanquanly.jsp");
	}
	
	/**
	 * This is function add role to CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void addQuyenToCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//		long companyId = ConvertUtil.convertToLong(WebserviceFactory.getThamSoService().getValue(CMON_ADMIN_COMPANY_ID));
		long companyId = PortalUtil.getUser(actionRequest).getCompanyId();
		long chuc_vu_id = ParamUtil.getLong(actionRequest, "chuc_vu_id");
		long coQuanQuanLyID = ParamUtil.getLong(actionRequest, "coQuanQuanLyID");
		String[] vaiTroId = ParamUtil.getParameterValues(actionRequest, "select-selected-id");
		
		//Tao ChucVu2VaiTro.
		List<ChucVu2VaiTro> liChucVu2VaiTros = ChucVu2VaiTroLocalServiceUtil.findByIdChucVuAndIdCoQuanQuanLy(chuc_vu_id, coQuanQuanLyID, 0);

		// Neu chua co thi tao moi
		if (liChucVu2VaiTros.size() > 0) {
			for (ChucVu2VaiTro chucVu2VaiTro : liChucVu2VaiTros) {
				try {
					ChucVu2VaiTroLocalServiceUtil.deleteChucVu2VaiTro(chucVu2VaiTro.getId());
				} catch (Exception e) {
				}
			}
		}
		
		
		
		
		ChucVu2VaiTro _chucVu2VaiTro = null;
		for (String _vaiTroId : vaiTroId) {
			try {
				_chucVu2VaiTro = new ChucVu2VaiTroClp();
				_chucVu2VaiTro.setId(CounterLocalServiceUtil.increment(ChucVu2VaiTro.class.getName()));
				_chucVu2VaiTro.setChucVuId(chuc_vu_id);
				_chucVu2VaiTro.setVaiTroId(ConvertUtil.convertToLong(_vaiTroId));
				_chucVu2VaiTro.setCoQuanQuanLyId(coQuanQuanLyID);
				_chucVu2VaiTro.setNgaySua(new Date());
				_chucVu2VaiTro.setNguoiSua(PortalUtil.getUser(actionRequest).getEmailAddress());
				_chucVu2VaiTro.setNgayTao(new Date());
				_chucVu2VaiTro.setNguoiTao(PortalUtil.getUser(actionRequest).getEmailAddress());
				ChucVu2VaiTroLocalServiceUtil.addChucVu2VaiTro(_chucVu2VaiTro);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		
		// Tao Organization tren liferay
		try {
			log.info("===========add usergroup");
			UserGroup userGroup = null;
			CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuanQuanLyID);
			ChucVu chucVu = ChucVuLocalServiceUtil.fetchChucVu(chuc_vu_id);
			//String tenGroup = coQuanQuanLy.getTen() + "_" + chucVu.getTen();
			String tenGroup = LiferayUserGroupUtils
					.getUserGroupName(coQuanQuanLy.getTen(), chucVu.getTen());
			log.info("1===========add usergroup name:"+tenGroup);
			// Tim xem da tao Group voi ten nhu tren chua
			userGroup = CoQuanQuanLyBusiness.findUserGroupByName(tenGroup, actionRequest);
			
			long groupIdS[] = null; 
			
			// Neu tao roi thi xoa toan bo cac lien ket di
			if (userGroup != null) {
				log.info("2===========update role for group :");
				groupIdS = new long[]{userGroup.getGroup().getGroupId()};
				
				/*
				 *  Xoa toan bo role ep den group truoc day
				 *  b1. Lay toan bo Vatro theo chuc vu.
				 *  b2. Lay toan bo tai nguye theo vai tro.
				 *  b3. unset role vao group
				 */
				List<TaiNguyen2VaiTro> lNguyen2VaiTros = null;
				TaiNguyen taiNguyen = null;
				
				//delete all role assign for Group
				List<Role> rList = RoleLocalServiceUtil.getRoles(companyId);
				if(rList != null){
					for (Role role : rList) {
						try{
							GroupLocalServiceUtil.unsetRoleGroups(role.getRoleId(), groupIdS);	
						}catch (Exception e) {
							// TODO: handle exception
						}
					}
				}			
				
			
			} else {
				//create new group
				try{
				log.info("3===========create new group :");
				userGroup = UserGroupLocalServiceUtil.addUserGroup(PortalUtil.getUserId(actionRequest), companyId, tenGroup, "");
				groupIdS = new long[]{userGroup.getGroup().getGroupId()};
				log.info("3===========create OK ! :");
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
					
			// Gan cac vatro tren liferay vao Group tren liferay
			List<TaiNguyen2VaiTro> lNguyen2VaiTros = null;
			TaiNguyen taiNguyen = null;
			for (String _vaiTroId : vaiTroId) {
				lNguyen2VaiTros = TaiNguyen2VaiTroLocalServiceUtil.findByVaiTroID(ConvertUtil.convertToLong(_vaiTroId), 0);
				if (lNguyen2VaiTros != null) {
					for (TaiNguyen2VaiTro taiNguyen2VaiTro : lNguyen2VaiTros) {
						try {
							taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyen2VaiTro.getTaiNguyenId());
							if(taiNguyen == null){
								taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyen2VaiTro.getTaiNguyenId());
							}
							if (taiNguyen != null && taiNguyen.getGiaTri().trim().length()>0) {
								try {
									GroupLocalServiceUtil.addRoleGroups(ConvertUtil.convertToLong(taiNguyen.getGiaTri()), groupIdS);
								} catch (Exception es1) {
									es1.printStackTrace();
								}
							}
						} catch (Exception ess) {
							ess.printStackTrace();
						}
					}
				}
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		
		actionResponse.setRenderParameter("coQuanQuanLyID", String.valueOf(coQuanQuanLyID));
		actionResponse.setRenderParameter("chuc_vu_id", String.valueOf(chuc_vu_id));
		actionResponse.setRenderParameter("keyWord", ParamUtil.getString(actionRequest, "keyWord").trim());
		actionResponse.setRenderParameter("searchOption", ParamUtil.getString(actionRequest, "searchOption").trim());
		actionResponse.setRenderParameter("parentId", ParamUtil.getString(actionRequest, "parentId").trim());
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/themvaitro_chucvucho_coquanquanly.jsp");
	}
	/**
	 * This is function add or edit CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void addEditCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the 2 required parameters
		long parentId = ParamUtil.getLong(actionRequest, "parentId");
		
		// Mode
		int mode = ParamUtil.getInteger(actionRequest, "mode");
		
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_CQQL_OBJECT");
		if (userRequest == null ) {
			userRequest = new HashMap<String, String>();
		}
			
		// Get ma co quan quan ly
		String ma = ParamUtil.getString(actionRequest, "ma");
		userRequest.put("ma", ma);
		
		String ten = ParamUtil.getString(actionRequest, "ten");
		userRequest.put("ten", ten);
		
		String tinh = ParamUtil.getString(actionRequest, "tinh");
		userRequest.put("tinh", tinh);
		
		String huyen = ParamUtil.getString(actionRequest, "huyen");
		userRequest.put("huyen", huyen);
		
		String xa = ParamUtil.getString(actionRequest, "xa");
		userRequest.put("xa", xa);
		
		String motaDiaChi = ParamUtil.getString(actionRequest, "motaDiaChi");
		userRequest.put("motaDiaChi", motaDiaChi);
		
		String dienThoai = ParamUtil.getString(actionRequest, "dienThoai");
		userRequest.put("dienThoai", dienThoai);
		
		String email = ParamUtil.getString(actionRequest, "email");
		userRequest.put("email", email);		
		
		String fax = ParamUtil.getString(actionRequest, "fax");
		userRequest.put("fax", fax);
		
		String website = ParamUtil.getString(actionRequest, "website");
		userRequest.put("website", website);
		
		String noiBo = ParamUtil.getString(actionRequest, "noiBo");
		userRequest.put("noiBo", noiBo);
		
		String capCoQuanQuanLy = ParamUtil.getString(actionRequest, "capCoQuanQuanLy");
		userRequest.put("capCoQuanQuanLy", capCoQuanQuanLy);
		
		String merChant = ParamUtil.getString(actionRequest, "merChant");
		userRequest.put("merChant", merChant);
		
		String accessCode = ParamUtil.getString(actionRequest, "accessCode");
		userRequest.put("accessCode", accessCode);
		
		String secureSecret = ParamUtil.getString(actionRequest, "secureSecret");
		userRequest.put("secureSecret", secureSecret);
		
		// Validate parameteter
		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_CQQL_OBJECT", userRequest);
				
		// Check ma co quan quan ly
		if (Validator.isNull(ma)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.ma");
		}
		
		// Check ten co quan quan ly
		if (Validator.isNull(ten)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.ten");
		}
		//boolean checkDonViHanhChi = true;
		if(tinh.isEmpty() && huyen.isEmpty() && xa.isEmpty()){
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.tinh");
		}
		/*
		// Check tinh co quan quan ly
		if (Validator.isNull(tinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.tinh");
		}
		
		// Check huyen co quan quan ly
		if (Validator.isNull(huyen)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.huyen");
		}
		
		// Check xa co quan quan ly
		if (Validator.isNull(xa)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.xa");
		}
		*/
		
		// Check mo ta dia chi
		if (Validator.isNull(motaDiaChi)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.motaDiaChi");
		}
		
		// Check dien thoai
		if (Validator.isNull(dienThoai)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.dienThoai");
		}
		
		if (Validator.isNull(capCoQuanQuanLy)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.capCoQuanQuanLy");
		}
		
		if (Validator.isNotNull(merChant)) {
			if (Validator.isNull(accessCode) || Validator.isNull(secureSecret)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.merChant");
			}
		}
		
		if (Validator.isNotNull(accessCode)) {
			if (Validator.isNull(merChant) || Validator.isNull(secureSecret)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.accessCode");
			}
		}
		
		if (Validator.isNotNull(secureSecret)) {
			if (Validator.isNull(merChant) || Validator.isNull(accessCode)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.secureSecret");
			}
		}
		
		if ( Validator.isNotNull(email) && !Validator.isEmailAddress(email)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.email");
		}
		
		// Check ma
		if ( Validator.isNotNull(ma) && mode == INSERT_MODE) {
			List <CoQuanQuanLy> lst = CoQuanQuanLyLocalServiceUtil.findByMa(ma);
			
			if ( lst.size() > 0 ) {
				CoQuanQuanLy coQuan = lst.get(0);
				if (coQuan.getDaXoa() != 1) {
					SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.dublicateMa");
				}
			}
		}
		
		// Redirect
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		// Insert/updatye record here
		if (mode == INSERT_MODE) {
			// Temporily remove cmon_cqql_cmon_cqql_fk
			try {
				new CoQuanQuanLyBusiness().insert(userRequest, parentId, actionRequest);
			} catch (Exception e) {
				e.printStackTrace();
				
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.unKnown");
				
				// Redirect to error page
				actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/err_page.jsp");
				
				return;
			}
		} else {
			try{
				new CoQuanQuanLyBusiness().edit(userRequest, actionRequest);
			} catch (Exception e) {
				e.printStackTrace();
				
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.unKnown");
				
				// Redirect to error page
				actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/err_page.jsp");
				
				return;
			}
		}
		
		// Remove attribute
		actionRequest.getPortletSession().removeAttribute("USER_REQUEST_CQQL_OBJECT");
		
		// Redirect user
		if (mode == INSERT_MODE) {
			// Add success message
			SessionMessages.add(actionRequest, "success");
			
			actionResponse.sendRedirect(redirectUrl);
		} else {
			// Redirect to search screen
			Map<String,String> searchParam = (Map<String,String>)actionRequest.getPortletSession().getAttribute("SEARCH_CO_QUAN_QUAN_LY_PARAMS");
			
			String searchOption = searchParam.get("searchOption");
			
			String strParentId = searchParam.get("parentId");
			
			String keyWord = searchParam.get("keyWord");
			
			// Do the search
			this.searchCoQuanQuanLy(searchOption, Long.parseLong(strParentId), keyWord, actionRequest, actionResponse);
		}		
	}
	
	/**
	 * This is function view CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void viewCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		
		// Get the record
		CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(id);
		
		// Initiate the object
		Map <String, String> userRequest = new HashMap<String, String>();
		
		userRequest.put("id", coQuanQuanLy.getId() + "");

		userRequest.put("ma", coQuanQuanLy.getMa());

		userRequest.put("ten", coQuanQuanLy.getTen());
		
		//userRequest.put("xa", coQuanQuanLy.getDonViHanhChinhId() + "");
		// co quan hanh chinh
		CapCoQuanQuanLy capCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil.getCapCoQuanQuanLy(coQuanQuanLy.getCapCoQuanQuanlyId());
		
		userRequest.put("capCoQuanQuanLy", capCoQuanQuanLy.getId() + "-" + capCoQuanQuanLy.getTen());
		// don vi hanh chinh
		DonViHanhChinh donViHanhChinh = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(coQuanQuanLy.getDonViHanhChinhId());
		CapDonViHanhChinh capDonViHanhChinh = CapDonViHanhChinhLocalServiceUtil.getCapDonViHanhChinh(donViHanhChinh.getCapDonViHanhChinhId());
		if(capDonViHanhChinh.getMa().equals(ThamSoLocalServiceUtil.getValue("MATHANHPHO")) || capDonViHanhChinh.getMa().equals(ThamSoLocalServiceUtil.getValue("MATINH")) ) {
			userRequest.put("tinh",coQuanQuanLy.getDonViHanhChinhId() + "");			
			userRequest.put("huyen","");
			userRequest.put("xa","");
			
		}else if(capDonViHanhChinh.getMa().equals(ThamSoLocalServiceUtil.getValue("MAQUAN")) || capDonViHanhChinh.getMa().equals(ThamSoLocalServiceUtil.getValue("MAHUYEN"))){
			DonViHanhChinh tinh = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(donViHanhChinh.getChaId());
			userRequest.put("tinh",tinh.getId() + "");
			userRequest.put("huyen",coQuanQuanLy.getDonViHanhChinhId() + "");
			userRequest.put("xa","");
		}
		else if(capDonViHanhChinh.getMa().equals(ThamSoLocalServiceUtil.getValue("MAPHUONG")) || capDonViHanhChinh.getMa().equals(ThamSoLocalServiceUtil.getValue("MAXA")) || capDonViHanhChinh.getMa().equals(ThamSoLocalServiceUtil.getValue("MATHITRAN")) ){
			DonViHanhChinh huyen = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(donViHanhChinh.getChaId());
			DonViHanhChinh tinh = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(huyen.getChaId());
			userRequest.put("tinh",tinh.getId() + "");
			userRequest.put("huyen",huyen.getId() + "");
			userRequest.put("xa",coQuanQuanLy.getDonViHanhChinhId() + "");	
		}
//		// Get xa
//		DonViHanhChinh xa = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(coQuanQuanLy.getDonViHanhChinhId());
//		// Get huyen id
//		DonViHanhChinh huyen = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(xa.getChaId());
//		userRequest.put("huyen", huyen.getId() + "");
//		// Get tinh
//		//DonViHanhChinh tinh = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(huyen.getChaId());
//		//userRequest.put("tinh", tinh.getId() + "");
//		userRequest.put("tinh", 1 + "");
	
		userRequest.put("motaDiaChi", coQuanQuanLy.getDiaChi());

		userRequest.put("dienThoai", coQuanQuanLy.getDienThoai());
		
		userRequest.put("email", coQuanQuanLy.getEmail());		
		
		userRequest.put("fax", coQuanQuanLy.getFax());
		
		userRequest.put("website", coQuanQuanLy.getWebsite());
		
		userRequest.put("noiBo", coQuanQuanLy.getNoiBo() + "");
		
		userRequest.put("merChant", coQuanQuanLy.getMerchant());
		
		userRequest.put("accessCode", coQuanQuanLy.getAccessCode());
		
		userRequest.put("secureSecret", coQuanQuanLy.getSecureSecret());
		// Set the data to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_CQQL_OBJECT", userRequest);
		
		// Redirect to add/edit screen
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/co_quan_quan_ly_add_edit.jsp");
		actionResponse.setRenderParameter("parentId", coQuanQuanLy.getChaId() + "");
		actionResponse.setRenderParameter("mode", EDIT_MODE + "");		
	}
	
	/**
	 * This is function search popup CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void searchPopupCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get the search option
		String searchOption = ParamUtil.getString(actionRequest, "searchOption");
		
		// Get the parent id if submitted
		String strParentId = ParamUtil.getString(actionRequest, "parentId");
		long parentId = 0;
		
		if ( Validator.isNotNull(strParentId)) {
			parentId = Long.parseLong(strParentId);
		}
		
		// Get the search keyword if submitted
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
		
		// Build the query		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CapCoQuanQuanLy.class);
		
		// Always search un-deleted record
		query = query.add( PropertyFactoryUtil.forName("daXoa").eq(0));		
		
		// Add the criteria incase keyword search is not null
		if ( Validator.isNotNull(searchOption) && Validator.isNotNull(keyWord)) {
			Criterion criteria = null;		
			
			// Define search criteria
			if ( searchOption.equals(SEARCH_CODE_OPTION)) {
				criteria = RestrictionsFactoryUtil.ilike("ma", keyWord + "%");	
			} else {
				criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");
			} 
			
			// Define search criteria
			query = query.add( criteria );
		}
		
		// Query by parent id
		if (parentId > 0) {
			query = query.add( PropertyFactoryUtil.forName("chaId").eq(parentId));		
		} else {
			// Search all highest level
			query = query.add( PropertyFactoryUtil.forName("chaId").isNull());
		}

		List<CapCoQuanQuanLy> results = null;
		
		try {
			results = CapCoQuanQuanLyLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		// Set the result back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_CO_QUAN_QUAN_LY_POPUP_RESULT", results);
		
		// Redirect User
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/cap_co_quan_quan_ly_list_popup.jsp");
		actionResponse.setRenderParameter("parentId", String.valueOf(parentId ));
		
		if (Validator.isNull(searchOption)) {
			searchOption = SEARCH_NAME_OPTION;
		}
		
		actionResponse.setRenderParameter("searchOption", searchOption);
		actionResponse.setRenderParameter("keyWord", keyWord);
	}
	
	/**
	 * This is function delete CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		
		// Check if co quan quan ly has child
	
		List<CoQuanQuanLy> lst =  CoQuanQuanLyLocalServiceUtil.findByParentId(id, 0);
		
		if (lst.size() > 0 ){
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.childExists");
			
			// Redirect to error page
			actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/err_page.jsp");
			
			return;
		}
		
		try {
			new CoQuanQuanLyBusiness().delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.unKnown");
			
			// Redirect to error page
			actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/err_page.jsp");
			
			return;
		}
		
		// Redirect to search page
		Map<String,String> searchParam = (Map<String,String>)actionRequest.getPortletSession().getAttribute("SEARCH_CO_QUAN_QUAN_LY_PARAMS");
		
		String searchOption = searchParam.get("searchOption");
		
		String strParentId = searchParam.get("parentId");
		
		String keyWord = searchParam.get("keyWord");
		
		// Do the search
		this.searchCoQuanQuanLy(searchOption, Long.parseLong(strParentId), keyWord, actionRequest, actionResponse);
	}
}
