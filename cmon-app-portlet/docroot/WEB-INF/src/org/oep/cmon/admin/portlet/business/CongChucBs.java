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

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.admin.portlet.util.LiferayUserGroupUtils;
import org.oep.sharedservice.cmon.provider.document.DocumentServiceImpl;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.CongChucClp;

import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro;
import org.oep.cmon.dao.nsd.model.NguoiDung2VaiTroClp;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro;

import org.oep.cmon.dao.nsd.service.NguoiDung2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/** 
 * This is class CongChucBs
 * 
 * This class contains logics related to cmon_conghuc table
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class CongChucBs {
	
	/** Date format */
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static Log log = LogFactoryUtil.getLog(CongChucBs.class);
	
	/** 
	 * This is function insert CongChuc
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param userRequest
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void insert(Map<String, String> userRequest, ActionRequest request) throws PortalException, SystemException {
		// Get ma co quan quan ly
		CongChuc congChuc = new CongChucClp();

		congChuc.setId(CounterLocalServiceUtil.increment("cmon_congchuc"));
		
		congChuc.setMa(userRequest.get("ma"));
		
		congChuc.setHoVaTen(userRequest.get("hoVaTen"));
		
		// Validate birth date
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Date birthDate = null;
		df.setLenient(false);
		try {
			birthDate = df.parse(userRequest.get("ngaySinh"));
		} catch (Exception e) {
			// Error never happen so this exception will be swallow
		}
		
		congChuc.setNgaySinh(birthDate);
		
		congChuc.setGioiTinhId(Long.parseLong(userRequest.get("gioiTinh")));
		
		String chucVu = userRequest.get("chucVu");
		String idChucVu = chucVu.substring(0, chucVu.indexOf("-"));		
		
		congChuc.setChucVuId(Long.parseLong(idChucVu));
		
		// Co quan quan ly
		// Get id of cap co quan quan ly
		String coQuanQuanLy = userRequest.get("coQuanQuanLy");
		String id = coQuanQuanLy.substring(0, coQuanQuanLy.indexOf("-"));
		
		congChuc.setCoQuanQuanLyId(Long.parseLong(id));
		
		// Tai khoan nguoi dung
		String taiKhoanNguoiDung = userRequest.get("taiKhoanNguoiDung");
		
		if (Validator.isNotNull(taiKhoanNguoiDung)) {
			id = taiKhoanNguoiDung.substring(0, taiKhoanNguoiDung.indexOf("-"));
		
			congChuc.setTaiKhoanNguoiDungId(Long.parseLong(id));
		}
		
		congChuc.setSoCmnd(userRequest.get("soCmnd"));
		
		congChuc.setNoiCapCmnd(userRequest.get("noiCapCmnd"));
		
		if (Validator.isNotNull(userRequest.get("ngayCapCmnd"))) {
			Date ngayCapCmnd = null;
			try {
				ngayCapCmnd = df.parse(userRequest.get("ngayCapCmnd"));
			} catch (Exception e) {
				// Error never happen so this exception will be swallow
			}
			
			congChuc.setNgayCapCmnd(ngayCapCmnd);
		}

		Date currentDate = new Date();
		
		congChuc.setNgayTao(currentDate);
		
		congChuc.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(request);
		
		if ( currentUser != null) {		
			congChuc.setNguoiTao(currentUser.getEmailAddress());
			congChuc.setNguoiSua(currentUser.getEmailAddress());			
		} else {
			// This is for test without logging in
			congChuc.setNguoiTao("DUMMY");
			congChuc.setNguoiSua("DUMMY");	
		}
		
		congChuc.setDaXoa(0);
		
		CongChucLocalServiceUtil.addCongChuc(congChuc);
		
		// them cong chuc den Organization cong chuc.
		if (congChuc.getTaiKhoanNguoiDungId() > 0) {
			try {
				TaiKhoanNguoiDung taiKhoanNguoiDung2 = findTaiKhoanNguoiDungById(congChuc.getTaiKhoanNguoiDungId());

				if (taiKhoanNguoiDung2 != null) {
					// aDD LOGIC TO add cab bo org to tai khoan nguoi dung
					String citizenOrg = getOrganizationForCitizen();
					
					// Add user to organization
					Organization organization = null;
					try {
						 organization = OrganizationLocalServiceUtil.getOrganization(PortalUtil.getCompanyId(request), citizenOrg);
					} catch (Exception es) {
					}
					if (organization != null) {
						long[] userIds = {taiKhoanNguoiDung2.getTaiKhoanNguoiDungId()};
						UserLocalServiceUtil.addOrganizationUsers(organization.getOrganizationId(), userIds);
					}
				}
			} catch (Exception es){
				es.printStackTrace();
			}
		}
		

		// them quyen ben liferay cho cong chuc nay.
		try {
			if (congChuc.getTaiKhoanNguoiDungId() > 0) {
				try {
					TaiKhoanNguoiDung taiKhoanNguoiDung2 = findTaiKhoanNguoiDungById(congChuc.getTaiKhoanNguoiDungId());
					
					if (taiKhoanNguoiDung2 != null) {
						
						// Them can bo den Group
						CoQuanQuanLy _coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(congChuc.getCoQuanQuanLyId());
						ChucVu _chucVu = ChucVuLocalServiceUtil.fetchChucVu(congChuc.getChucVuId());
						//String tenGroup = _coQuanQuanLy.getTen() + "_" + _chucVu.getTen();
						String tenGroup = LiferayUserGroupUtils
								.getUserGroupName(_coQuanQuanLy.getTen(), _chucVu.getTen());
						//tenGroup = coQuanQuanLy.getTen() + "_" + chucVu.getTen();
						UserGroup userGroup = CoQuanQuanLyBusiness.findUserGroupByName(tenGroup, request);
						long[] userIds = {taiKhoanNguoiDung2.getTaiKhoanNguoiDungId()};
						if (userGroup != null) {
							UserLocalServiceUtil.addGroupUsers(userGroup.getGroup().getGroupId(), userIds);
							UserLocalServiceUtil.addUserGroupUsers(userGroup.getUserGroupId(), userIds);
						}
						
						// Them roles rieng cho can bo nay.
						String[] vaiTroThem = userRequest.get("vaiTroThem").split("-");
						TaiNguyen taiNguyen = null;
						for (String data : vaiTroThem) {
							if (ConvertUtil.convertToLong(data) > 0) {
								try {
									addNguoiDung2VaiTro(request, congChuc.getTaiKhoanNguoiDungId(), ConvertUtil.convertToLong(data));
									
									// Them du lieu vao liferay.
									List<TaiNguyen2VaiTro> lNguyen2VaiTros = TaiNguyen2VaiTroLocalServiceUtil.findByVaiTroID(ConvertUtil.convertToLong(data), 0);
									if (lNguyen2VaiTros != null) {
										for (TaiNguyen2VaiTro taiNguyen2VaiTro : lNguyen2VaiTros) {
											try {
												taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyen2VaiTro.getTaiNguyenId());
												if (ConvertUtil.convertToLong(taiNguyen.getGiaTri()) > 0) {
													try {
														UserLocalServiceUtil.addRoleUsers(ConvertUtil.convertToLong(taiNguyen.getGiaTri()), userIds);
													} catch (Exception es1) {
														es1.printStackTrace();
													}
												}
											} catch (Exception ess) {
												ess.printStackTrace();
											}
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
						
					}
				} catch (Exception es){
					es.printStackTrace();
				}
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
	}
	
	/** 
	 * This is function insert NguoiDung2VaiTro
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param request
	 * @param taiKhoanNguoiDungId
	 * @param vaiTroId
	 */
	private void addNguoiDung2VaiTro(ActionRequest request, long taiKhoanNguoiDungId, long vaiTroId) {
		try {
			NguoiDung2VaiTro nguoiDung2VaiTro = new NguoiDung2VaiTroClp();
			nguoiDung2VaiTro.setId(CounterLocalServiceUtil.increment(NguoiDung2VaiTro.class.getName()));
			nguoiDung2VaiTro.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
			nguoiDung2VaiTro.setVaiTroId(vaiTroId);
			nguoiDung2VaiTro.setNgayTao(new Date());
			nguoiDung2VaiTro.setNguoiTao(PortalUtil.getUser(request).getEmailAddress());
			
			NguoiDung2VaiTroLocalServiceUtil.addNguoiDung2VaiTro(nguoiDung2VaiTro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * This is function remove User from UserGroup
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param companyId
	 * @param groupId
	 * @param userGroupId
	 * @param userId
	 */
	private boolean removeUserFromUserGroup(long companyId,long groupId,long userGroupId,long userId){
		try{
			log.info("===========");
			long[] groupIds = {groupId};
			long[] userIds = {userId};	
			log.info("===========1,");
			UserLocalServiceUtil.unsetUserGroupUsers(userGroupId, userIds);
			log.info("===========2,");
			GroupLocalServiceUtil.unsetUserGroups(userId, groupIds);
			log.info("===========3,");
			
			
			
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	/** 
	 * This is function add User to UserGroup
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param groupId
	 * @param userGroupId
	 * @param userId
	 */
	private boolean addUserToUserGroup(long groupId,long userGroupId,long userId){
		try{
			log.info("===========");
			long[] groupIds = {groupId};
			long[] userIds = {userId};	
			log.info("===========1,");
			UserLocalServiceUtil.addGroupUsers(groupId, userIds);
			
			log.info("===========2,");
			UserLocalServiceUtil.addUserGroupUsers(userGroupId, userIds);
			log.info("===========3,");
			
			
			
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	/** 
	 * This is function edit CongChuc
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param userRequest
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void edit(Map<String, String> userRequest, ActionRequest request) throws PortalException, SystemException {
		log.info("1.==============goto edit Cong chuc:");
		CongChuc congChuc = CongChucLocalServiceUtil.getCongChuc(Long.parseLong(userRequest.get("id")));
		
		CongChuc congChucOld = congChuc;
		
		congChuc.setMa(userRequest.get("ma"));
		
		congChuc.setHoVaTen(userRequest.get("hoVaTen"));
		
		// Validate birth date
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Date birthDate = null;
		df.setLenient(false);
		try {
			birthDate = df.parse(userRequest.get("ngaySinh"));
		} catch (Exception e) {
			// Error never happen so this exception will be swallow
		}
		
		congChuc.setNgaySinh(birthDate);
		
		congChuc.setGioiTinhId(Long.parseLong(userRequest.get("gioiTinh")));
		
		String chucVu = userRequest.get("chucVu");
		String idChucVu = chucVu.substring(0, chucVu.indexOf("-"));		
		
		congChuc.setChucVuId(Long.parseLong(idChucVu));
		
		// Co quan quan ly
		// Get id of cap co quan quan ly
		String coQuanQuanLy = userRequest.get("coQuanQuanLy");
		String id = coQuanQuanLy.substring(0, coQuanQuanLy.indexOf("-"));
		
		congChuc.setCoQuanQuanLyId(Long.parseLong(id));
		
		// Tai khoan nguoi dung
		String taiKhoanNguoiDung = userRequest.get("taiKhoanNguoiDung");
		
		if (Validator.isNotNull(taiKhoanNguoiDung)) {
			id = taiKhoanNguoiDung.substring(0, taiKhoanNguoiDung.indexOf("-"));
		
			congChuc.setTaiKhoanNguoiDungId(Long.parseLong(id));
		}
		
		congChuc.setSoCmnd(userRequest.get("soCmnd"));
		
		congChuc.setNoiCapCmnd(userRequest.get("noiCapCmnd"));
		
		if (Validator.isNotNull(userRequest.get("ngayCapCmnd"))) {
			Date ngayCapCmnd = null;
			try {
				ngayCapCmnd = df.parse(userRequest.get("ngayCapCmnd"));
			} catch (Exception e) {
				// Error never happen so this exception will be swallow
			}
			
			congChuc.setNgayCapCmnd(ngayCapCmnd);
		}

		Date currentDate = new Date();		
		
		congChuc.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(request);
		
		if ( currentUser != null) {		
			congChuc.setNguoiSua(currentUser.getEmailAddress());			
		} else {
			// This is for test without logging in
			congChuc.setNguoiSua("DUMMY");	
		}

		congChuc.setDaXoa(0);

		congChuc = CongChucLocalServiceUtil.updateCongChuc(congChuc,true);		

		/*
		 * Loai bo toan bo cac thiet lap quyen cu truoc day.
		 * B1. Bo rang buoc user cu voi org
		 * B2. Bo rang buoc user cu voi Group
		 * B3. Unset tat ca roles rieng thiet lap cho user cu truoc day.
		 */

		// B1.
		try {
			TaiKhoanNguoiDung taiKhoanNguoiDungOld = findTaiKhoanNguoiDungById(congChucOld.getTaiKhoanNguoiDungId());
			if (taiKhoanNguoiDungOld != null) {
				String citizenOrg = getOrganizationForCitizen();
				// Add user to organization
				Organization organization = OrganizationLocalServiceUtil.getOrganization(PortalUtil.getCompanyId(request), citizenOrg);
				long[] userIds = {taiKhoanNguoiDungOld.getTaiKhoanNguoiDungId()};
				UserLocalServiceUtil.unsetOrganizationUsers(organization.getOrganizationId(), userIds);
			}
			// B2.
			if (taiKhoanNguoiDungOld != null) {
				log.info("1.==============xu ly b2 xoa group:");
				CoQuanQuanLy _coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(congChucOld.getCoQuanQuanLyId());
				ChucVu _chucVu = ChucVuLocalServiceUtil.fetchChucVu(congChucOld.getChucVuId());
				//String tenGroup = _coQuanQuanLy.getTen() + "_" + _chucVu.getTen();
				String tenGroup = LiferayUserGroupUtils
						.getUserGroupName(_coQuanQuanLy.getTen(), _chucVu.getTen());
				UserGroup userGroup = CoQuanQuanLyBusiness.findUserGroupByName(tenGroup, request);
				long companyId = PortalUtil.getCompanyId(request);
				long userId =taiKhoanNguoiDungOld.getTaiKhoanNguoiDungId();
				
				if (userGroup != null) {
					removeUserFromUserGroup(companyId, userGroup.getGroup().getGroupId(), userGroup.getUserGroupId(), userId);
				}
				
				//remove all user group
				try{
					List<UserGroup> gList = UserGroupLocalServiceUtil.getUserGroups(companyId);
					if(gList != null && gList.size()>0){
						
						for (UserGroup uG : gList) {
							try{
							removeUserFromUserGroup(companyId, uG.getGroup().getGroupId(), uG.getUserGroupId(), userId);
							}catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
					}
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			}
				
			
			// B3.
			List<NguoiDung2VaiTro> liNguoiDung2VaiTros = NguoiDung2VaiTroLocalServiceUtil.findByTaiKhoanNguoiDungID(congChucOld.getTaiKhoanNguoiDungId(), 0);
			if (liNguoiDung2VaiTros.size() > 0) {
				TaiNguyen taiNguyen = null;
				long[] userIds = {taiKhoanNguoiDungOld.getTaiKhoanNguoiDungId()};
				for (NguoiDung2VaiTro nguoiDung2VaiTro : liNguoiDung2VaiTros) {

					NguoiDung2VaiTroLocalServiceUtil.deleteNguoiDung2VaiTro(nguoiDung2VaiTro.getId());

					// Xoa user toi Role ben liferay
					List<TaiNguyen2VaiTro> lNguyen2VaiTros = TaiNguyen2VaiTroLocalServiceUtil.findByVaiTroID(nguoiDung2VaiTro.getVaiTroId(), 0);
					if (lNguyen2VaiTros != null) {
						for (TaiNguyen2VaiTro taiNguyen2VaiTro : lNguyen2VaiTros) {
							try {
								taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyen2VaiTro.getTaiNguyenId());
								if (ConvertUtil.convertToLong(taiNguyen.getGiaTri()) > 0) {
									try {
										UserLocalServiceUtil.unsetRoleUsers(ConvertUtil.convertToLong(taiNguyen.getGiaTri()), userIds);
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
		} catch (Exception es) {
			es.printStackTrace();
		}
		
		
		try {
			/*
			 * Thiet lap lai toan bo quyen cho can bo nay.
			 * B1. Them rang buoc toi org
			 * B2. Them rang buoc toi Group
			 * B3. Set tat ca roles rieng thiet lap cho user.
			 */

			// B1. Them quyen moi cho rieng user nay.
			log.info("3.==============Gan nhom moi");
			
			TaiKhoanNguoiDung taiKhoanNguoiDungNew = findTaiKhoanNguoiDungById(congChuc.getTaiKhoanNguoiDungId());			
			CoQuanQuanLy _coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(congChuc.getCoQuanQuanLyId());
			if(_coQuanQuanLy == null){
				log.info("3.1==============coquanquanly null");
			}
			ChucVu _chucVu = ChucVuLocalServiceUtil.fetchChucVu(congChuc.getChucVuId());
			if(_chucVu == null){
				log.info("3.1==============chuc vu null");
			}
			//String tenGroup = _coQuanQuanLy.getTen() + "_" + _chucVu.getTen();
			String tenGroup = LiferayUserGroupUtils
					.getUserGroupName(_coQuanQuanLy.getTen(), _chucVu.getTen());
			
			
			log.info("3.1==============ten Group:"+tenGroup);
			UserGroup userGroup = CoQuanQuanLyBusiness.findUserGroupByName(tenGroup, request);
			
			long[] userIds = {taiKhoanNguoiDungNew.getTaiKhoanNguoiDungId()};
			//add new user to new group;
			if(userGroup != null){
				try{
					log.info("3.1==============Gan nhom moi ok new");
					addUserToUserGroup(userGroup.getGroup().getGroupId(), userGroup.getUserGroupId(), taiKhoanNguoiDungNew.getTaiKhoanNguoiDungId());
				}catch (Exception e) {
					// TODO: handle exception
					log.info("3.2==============Gan nhom moi null");
					e.printStackTrace();
				}
			}
			
			if (taiKhoanNguoiDungNew != null) {
				// aDD LOGIC TO add cab bo org to tai khoan nguoi dung
				String citizenOrg = getOrganizationForCitizen();
				// Add user to organization
				Organization organization = OrganizationLocalServiceUtil.getOrganization(PortalUtil.getCompanyId(request), citizenOrg);
				

				UserLocalServiceUtil.addOrganizationUsers(organization.getOrganizationId(), userIds);
			}

			// B2, B3
			
			if (taiKhoanNguoiDungNew != null) {

				// B2.
				
				if (userGroup != null) {
					log.info("4. Them moi nguoi su dung vao nhom");
					UserLocalServiceUtil.addGroupUsers(userGroup.getGroup().getGroupId(), userIds);
					UserLocalServiceUtil.addUserGroupUsers(userGroup.getUserGroupId(), userIds);
				}
				
				// B3.
				String[] vaiTroThem = userRequest.get("vaiTroThem").split("-");
				TaiNguyen taiNguyen = null;
				for (String data : vaiTroThem) {
					if (ConvertUtil.convertToLong(data) > 0) {
						
						try {
							addNguoiDung2VaiTro(request, congChuc.getTaiKhoanNguoiDungId(), ConvertUtil.convertToLong(data));
							
							// Them du lieu vao liferay, day la them role rieng cho user nay.
							List<TaiNguyen2VaiTro> lNguyen2VaiTros = TaiNguyen2VaiTroLocalServiceUtil.findByVaiTroID(ConvertUtil.convertToLong(data), 0);
							if (lNguyen2VaiTros != null) {
								for (TaiNguyen2VaiTro taiNguyen2VaiTro : lNguyen2VaiTros) {
									try {
										taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(taiNguyen2VaiTro.getTaiNguyenId());
										if (ConvertUtil.convertToLong(taiNguyen.getGiaTri()) > 0) {
											try {
												UserLocalServiceUtil.addRoleUsers(ConvertUtil.convertToLong(taiNguyen.getGiaTri()), userIds);
											} catch (Exception es1) {
												es1.printStackTrace();
											}
										}
									} catch (Exception ess) {
										ess.printStackTrace();
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				}
			}
			// End B2,B3.
		} catch (Exception es) {
			es.printStackTrace();
		}
	}
	
	/** 
	 * This is function delete CongChuc
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param id
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void delete(long id) throws PortalException, SystemException {
		CongChuc congChuc = CongChucLocalServiceUtil.getCongChuc(id);
		
		congChuc.setDaXoa(1); // 1: logically deleted
		
		CongChucLocalServiceUtil.updateCongChuc(congChuc);
	}
	
	/** 
	 * This is function Get default organization for citizen
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	  * @return organization name
	 * @throws IOException 
	 * @throws SystemException 
	 */
	private String getOrganizationForCitizen() {
		try {
			String maOrg = WebserviceFactory.getThamSoService().getValue("CMON_ADMIN_CONG_CHUC_ORGANIZATION_ID");
			if (maOrg.length() == 0) {
				maOrg = "CB";
			}
			return DoiTuongSuDungLocalServiceUtil.findByMa(maOrg).getTen();
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return "";
	}

	/** 
	 * This is function find TaiKhoanNguoiDung by TaiKhoanNguoiDungId
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
     * @param taiKhoanNguoiDungId
	 * @return TaiKhoanNguoiDung 
	 */
	private TaiKhoanNguoiDung findTaiKhoanNguoiDungById(long taiKhoanNguoiDungId) {
		try {
			return TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(taiKhoanNguoiDungId);
		} catch (Exception es) {
			try {
				return TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(taiKhoanNguoiDungId);
			} catch (SystemException e) {
			}
		}
		return null;
	}
}
