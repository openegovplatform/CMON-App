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

package org.oep.cmon.portlet.admin.congchuc.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.dao.nsd.model.impl.VaiTroImpl;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl;
import org.oep.cmon.util.CmonFields;
import org.oep.sharedservice.cmon.Constants;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.service.NguoiDung2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil;
import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.NoSuchQuocGiaException;
import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTroClp;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLyClp;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class CongChucUtils
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CongChucUtils {
	private static Log log = LogFactoryUtil.getLog(CongChucUtils.class);
	private static LiferayUtils liferayUtils = new LiferayUtils();

	/**
	 * This is  function delete ChucVu to CanBo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congChuc
	 * @param coQuanQuanLy
	 * @return boolean
	 */
	public static boolean xoaChucVuToCanBo(CongChuc congChuc,
			CoQuanQuanLy coQuanQuanLy) {

		// step 1: get tai khoan nguoid ung
		TaiKhoanNguoiDung taiKhoanNguoiDung = null;
		try {
			taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil
					.getTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
		} catch (Exception e) {
			// TODO: handle exception
		}

		User user = null;
		try {
			user = UserLocalServiceUtil.getUserById(taiKhoanNguoiDung
					.getTaiKhoanNguoiDungId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		ChucVu chucVu = null;
		try {
			chucVu = ChucVuLocalServiceUtil.fetchChucVu(congChuc.getChucVuId());
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (chucVu == null) {
			return false;
		}
		if (user == null)
			return false;

		long companyId = user.getCompanyId();

		String userGroupName = getUserGroupName(chucVu.getTen(),
				coQuanQuanLy.getTen());
		UserGroup userGroup = findUserGroupByName(companyId, userGroupName);
		if (userGroup != null) {
			try {
				liferayUtils.removeUserFromUserGroup(companyId, userGroup
						.getGroup().getGroupId(), userGroup.getUserGroupId(),
						user.getUserId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}

	/**
	 * This is  function assing ChucVu To can bo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congChuc
	 * @param coQuanQuanLy
	 * @param chucVu
	 * @return boolean
	 */
	public static boolean ganChucVuToCanBo(CongChuc congChuc,
			CoQuanQuanLy coQuanQuanLy, ChucVu chucVu) {

		// step 1: get tai khoan nguoid ung
		TaiKhoanNguoiDung taiKhoanNguoiDung = null;
		try {
			taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil
					.getTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
		} catch (Exception e) {
			// TODO: handle exception
		}

		User user = null;
		try {
			user = UserLocalServiceUtil.getUserById(taiKhoanNguoiDung
					.getTaiKhoanNguoiDungId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		if (user == null)
			return false;

		long companyId = user.getCompanyId();

		String userGroupName = getUserGroupName(chucVu.getTen(),
				coQuanQuanLy.getTen());
		UserGroup userGroup = findUserGroupByName(companyId, userGroupName);
		if (userGroup != null) {
			try {
				liferayUtils.addUserToUserGroup(userGroup.getGroup()
						.getGroupId(), userGroup.getUserGroupId(), user
						.getUserId());
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}

	/**
	 * This is  function assign list Vaitro to Canbo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congChuc
	 * @param vaitroIds
	 * @return boolean
	 */
	public static boolean ganQuyenToCanBo(CongChuc congChuc, long[] vaitroIds) {
		if (congChuc == null || vaitroIds == null || vaitroIds.length <= 0) {
			return false;
		}

		// step 1: get tai khoan nguoid ung
		TaiKhoanNguoiDung taiKhoanNguoiDung = null;
		try {
			taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil
					.getTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
		} catch (Exception e) {
		}
		List<TaiNguyen2VaiTro> lNguyen2VaiTros = null;
		if (taiKhoanNguoiDung != null) {
			for (long _vaiTroId : vaitroIds) {
				try {

					lNguyen2VaiTros = TaiNguyen2VaiTroLocalServiceUtil
							.findByVaiTroID(_vaiTroId, 0);
					if (lNguyen2VaiTros != null) {
						TaiNguyen taiNguyen = null;

						for (TaiNguyen2VaiTro taiNguyen2VaiTro : lNguyen2VaiTros) {
							try {

								taiNguyen = TaiNguyenLocalServiceUtil
										.fetchTaiNguyen(taiNguyen2VaiTro
												.getTaiNguyenId());
								if (taiNguyen == null) {
									taiNguyen = TaiNguyenLocalServiceUtil
											.fetchTaiNguyen(taiNguyen2VaiTro
													.getTaiNguyenId());
								}

								if (taiNguyen != null) {
									RoleLocalServiceUtil.addUserRoles(
											taiKhoanNguoiDung
													.getTaiKhoanNguoiDungId(),
											new long[] { Long.valueOf(taiNguyen
													.getGiaTri()) });
								}

							} catch (Exception e) {
								e.printStackTrace();
							}
						}

					}
				} catch (Exception e) {
					e.printStackTrace();

				}

			}
		}

		return true;
	}

	/**
	 * This is  function delete nguoi dung 2 vai tro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congChuc
	 * @param coQuanQuanLy
	 * @return boolean
	 */
	public static boolean xoaQuyenToCanBo(CongChuc congChuc, long vaiTroId) {
		if (congChuc == null) {
			return false;
		}

		// step 1: get tai khoan nguoid ung
		TaiKhoanNguoiDung taiKhoanNguoiDung = null;
		try {
			taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil
					.getTaiKhoanNguoiDung(congChuc.getTaiKhoanNguoiDungId());
		} catch (Exception e) {
			// TODO: handle exception
		}

		List<NguoiDung2VaiTro> nList = NguoiDung2VaiTroLocalServiceUtil
				.findByTaiKhoanNguoiDungID(taiKhoanNguoiDung.getId(),
						Constants.ACTIVATED);
		if (nList != null) {
			List<TaiNguyen2VaiTro> lNguyen2VaiTros = null;
			for (NguoiDung2VaiTro nguoiDung2VaiTro : nList) {
				if (nguoiDung2VaiTro.getVaiTroId().longValue() != vaiTroId) {
					continue;
				}
				try {
					// delete vai tro

					lNguyen2VaiTros = TaiNguyen2VaiTroLocalServiceUtil
							.findByVaiTroID(nguoiDung2VaiTro.getVaiTroId(), 0);
					if (lNguyen2VaiTros != null) {
						TaiNguyen taiNguyen = null;

						for (TaiNguyen2VaiTro taiNguyen2VaiTro : lNguyen2VaiTros) {
							try {

								taiNguyen = TaiNguyenLocalServiceUtil
										.fetchTaiNguyen(taiNguyen2VaiTro
												.getTaiNguyenId());
								if (taiNguyen == null) {
									taiNguyen = TaiNguyenLocalServiceUtil
											.fetchTaiNguyen(taiNguyen2VaiTro
													.getTaiNguyenId());
								}

								if (taiNguyen != null) {
									RoleLocalServiceUtil.unsetUserRoles(
											taiKhoanNguoiDung
													.getTaiKhoanNguoiDungId(),
											new long[] { Long.valueOf(taiNguyen
													.getGiaTri()) });
								}

							} catch (Exception e) {
								e.printStackTrace();
							}
						}

					}
					NguoiDung2VaiTroLocalServiceUtil
							.deleteNguoiDung2VaiTro(nguoiDung2VaiTro.getId());
				} catch (Exception e) {
					// TODO: handle exception

				}

			}

		}

		return true;
	}

	/**
	 * This is  function delete ChucVu at CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congChuc
	 * @param coQuanQuanLy
	 * @param creatorUser
	 * @return boolean
	 */
	public static boolean xoaChucVuToCoQuanQuanLy(ChucVu chucVu,
			CoQuanQuanLy coQuanQuanLy, User creatorUser) {
		long chucVuId = chucVu.getId();
		long coQuanQuanLyId = coQuanQuanLy.getId();

		long companyId = creatorUser.getCompanyId();

		log.info("Function====gan chuc vu to co quan qua ly");

		// step 1: tao userGroup tren lifeay
		log.info("step1====Tao usergroup");
		String userGroupName = getUserGroupName(chucVu.getTen(),
				coQuanQuanLy.getTen());
		UserGroup userGroup = findUserGroupByName(companyId, userGroupName);
		if (userGroup != null) {
			// da ton tai usergroup va xoa het quyen cu di
			log.info("step1====: 2.da ton tai usser group va  xoa toan bo role trong group nay");
			liferayUtils.unsetRoleGroups(userGroup, companyId);
			liferayUtils.removeUserGroup(userGroup.getUserGroupId());
		}

		// Sua lai tai nguyen to vai tro
		log.info("step2====: xoa chuc vu to vai tro ton tai truoc day");
		List<ChucVu2VaiTro> cvList = ChucVu2VaiTroLocalServiceUtil
				.findByIdChucVuAndIdCoQuanQuanLy(chucVuId, coQuanQuanLyId,
						Constants.ACTIVATED);
		if (cvList != null && cvList.size() > 0) {
			for (ChucVu2VaiTro chucVu2VaiTro : cvList) {
				try {
					ChucVu2VaiTroLocalServiceUtil
							.deleteChucVu2VaiTro(chucVu2VaiTro.getId());
				} catch (Exception e) {
					return false;
				}
			}
		}

		return true;

	}

	/**
	 * This is  function assing ChucVu to CoquanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param chucVu
	 * @param vaitroIds
	 * @param coQuanQuanLy
	 * @param creatorUser
	 * @return boolean
	 */
	public static boolean ganChucVuToCoQuanQuanLy(ChucVu chucVu,
			long[] vaitroIds, CoQuanQuanLy coQuanQuanLy, User creatorUser) {
		long chucVuId = chucVu.getId();
		long coQuanQuanLyId = coQuanQuanLy.getId();
		long creatorUserid = creatorUser.getUserId();
		long companyId = creatorUser.getCompanyId();

		log.info("Function====gan chuc vu to co quan qua ly");

		// step 1: tao userGroup tren lifeay
		log.info("step1====Tao usergroup");
		String userGroupName = getUserGroupName(chucVu.getTen(),
				coQuanQuanLy.getTen());
		UserGroup userGroup = findUserGroupByName(companyId, userGroupName);
		if (userGroup == null) {
			// chua ton tai usergroup tao moi
			userGroup = liferayUtils.addUserGroup(creatorUserid, companyId,
					userGroupName);
			if (userGroup == null) {
				log.info("step1====1.Khong the tao moi cung ten:"
						+ userGroupName);
				return false;
			}
		} else {
			// da ton tai usergroup va xoa het quyen cu di
			log.info("step1====: 2.da ton tai usser group va  xoa toan bo role trong group nay");
			liferayUtils.unsetRoleGroups(userGroup, companyId);
		}

		// Sua lai tai nguyen to vai tro
		log.info("step2====: xoa chuc vu to vai tro ton tai truoc day");
		List<ChucVu2VaiTro> cvList = ChucVu2VaiTroLocalServiceUtil
				.findByIdChucVuAndIdCoQuanQuanLy(chucVuId, coQuanQuanLyId,
						Constants.ACTIVATED);
		if (cvList != null && cvList.size() > 0) {
			for (ChucVu2VaiTro chucVu2VaiTro : cvList) {
				try {
					ChucVu2VaiTroLocalServiceUtil
							.deleteChucVu2VaiTro(chucVu2VaiTro.getId());
				} catch (Exception e) {
				}
			}
		}

		log.info("step3====: gan chuc vu to vai tro moi");
		ChucVu2VaiTro _chucVu2VaiTro = null;
		List<TaiNguyen2VaiTro> lNguyen2VaiTros = null;
		for (long _vaiTroId : vaitroIds) {
			try {
				log.info("step3====:1. tao moi chuc vu to vai tro");

				_chucVu2VaiTro = new ChucVu2VaiTroClp();
				_chucVu2VaiTro.setId(CounterLocalServiceUtil
						.increment(ChucVu2VaiTro.class.getName()));
				_chucVu2VaiTro.setChucVuId(chucVuId);
				_chucVu2VaiTro.setVaiTroId(_vaiTroId);
				_chucVu2VaiTro.setCoQuanQuanLyId(coQuanQuanLyId);
				_chucVu2VaiTro.setNgaySua(new Date());
				_chucVu2VaiTro.setNguoiSua(creatorUser.getEmailAddress());
				_chucVu2VaiTro.setNgayTao(new Date());
				_chucVu2VaiTro.setNguoiTao(creatorUser.getEmailAddress());
				ChucVu2VaiTroLocalServiceUtil.addChucVu2VaiTro(_chucVu2VaiTro);

				log.info("step3====:2. gan role tuong duong tai nguyen to user group");
				lNguyen2VaiTros = TaiNguyen2VaiTroLocalServiceUtil
						.findByVaiTroID(_vaiTroId, 0);
				if (lNguyen2VaiTros != null) {
					TaiNguyen taiNguyen = null;

					for (TaiNguyen2VaiTro taiNguyen2VaiTro : lNguyen2VaiTros) {
						try {

							taiNguyen = TaiNguyenLocalServiceUtil
									.fetchTaiNguyen(taiNguyen2VaiTro
											.getTaiNguyenId());
							if (taiNguyen == null) {
								taiNguyen = TaiNguyenLocalServiceUtil
										.fetchTaiNguyen(taiNguyen2VaiTro
												.getTaiNguyenId());
							}

							if (taiNguyen != null
									&& taiNguyen.getGiaTri().trim().length() > 0) {
								try {
									GroupLocalServiceUtil.addRoleGroups(
											ConvertUtil.convertToLong(taiNguyen
													.getGiaTri()),
											new long[] { userGroup.getGroup()
													.getGroupId() });
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
				// TODO: handle exception

			}

		}

		return true;

	}

	/**
	 * This is  function find UserGroup by Name
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param companyId
	 * @param name
	 * @return UserGroup
	 */
	private static UserGroup findUserGroupByName(long companyId, String name) {

		try {
			List<UserGroup> results = UserGroupLocalServiceUtil
					.getUserGroups(companyId);
			for (UserGroup userGroup : results) {
				if (userGroup.getName().toLowerCase()
						.equals(name.toLowerCase())) {
					return userGroup;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * This is  function get UserGroupName
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congChuc
	 * @param coQuanQuanLy
	 * @return boolean
	 */
	private static String getUserGroupName(String tenCoQuan, String chucVu) {
		try {
			String ten = tenCoQuan + "_" + chucVu;

			ten = ten.replace("?", "");

			ten = ten.replace(",", "");
			return ten;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * This is  function search CoQuanQuanLy by Ma or Ten
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param searchInputText
	 * @param daXoa
	 * @throws Exception
	 * @return List<CoQuanQuanLy>
	 */
	@SuppressWarnings("unchecked")
	public static List<CoQuanQuanLy> searchCoQuanQuanLyByMaOrTen(
			String searchInputText, int daXoa) throws Exception {
		List<CoQuanQuanLy> listCoQuanQuanLy = new ArrayList<CoQuanQuanLy>();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				CoQuanQuanLyImpl.class, PortalClassLoaderUtil.getClassLoader());
		if (!searchInputText.equals("")) {
			Criterion creterion = RestrictionsFactoryUtil.ilike("ten",
					StringPool.PERCENT + searchInputText + StringPool.PERCENT);
			creterion = RestrictionsFactoryUtil.or(
					creterion,
					RestrictionsFactoryUtil.ilike("ma", StringPool.PERCENT
							+ searchInputText + StringPool.PERCENT));
			query.add(creterion);
		}
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(
				Constants.ACTIVATED));
		query.add(PropertyFactoryUtil.forName("capCoQuanQuanlyId").ne(
				Long.valueOf(ThamSoLocalServiceUtil
						.getValue("HMS_COQUANHCSN_ID"))));
		query.addOrder(OrderFactoryUtil.asc("ten"));
		listCoQuanQuanLy = CoQuanQuanLyLocalServiceUtil.dynamicQuery(query,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return listCoQuanQuanLy;
	}

	/**
	 * This is  function search VaiTro by TenVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param searchInputText
	 * @param daXoa
	 * @throws Exception
	 * @return List<VaiTro>
	 */
	@SuppressWarnings("unchecked")
	public static List<VaiTro> searchVaiTroByTen(String searchInputText,
			int daXoa) throws Exception {
		List<VaiTro> listVaiTro = new ArrayList<VaiTro>();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTroImpl.class,
				PortalClassLoaderUtil.getClassLoader());
		if (!searchInputText.equals("")) {
			Criterion creterion = RestrictionsFactoryUtil.ilike("ten",
					StringPool.PERCENT + searchInputText + StringPool.PERCENT);
			query.add(creterion);
		}
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(
				Constants.ACTIVATED));
		query.addOrder(OrderFactoryUtil.asc("ten"));
		listVaiTro = VaiTroLocalServiceUtil.dynamicQuery(query,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return listVaiTro;
	}

	/**
	 * This is  function validation CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congChuc
	 * @param coQuanQuanLy
	 * @throws NoSuchQuocGiaException
	 * @throws SystemException
	 * @return List<String>
	 */
	public static List<String> validCoQuanQuanLy(ActionRequest request)
			throws NoSuchQuocGiaException, SystemException {
		List<String> errors = new ArrayList<String>();
		if (Validator.isNull(ParamUtil.getString(request, "ten"))) {
			errors.add("error_name_required");
		}else{
			if(ParamUtil.getString(request, "ten").length()>100){
				errors.add("error_name_toolong");
			}
		}
		// Check ma
		if (Validator.isNull(ParamUtil.getString(request, "ma"))) {
			errors.add("error_code_required");
		} else {
			if(ParamUtil.getString(request, "ma").length()>8){
				errors.add("error_ma_toolong");
			}
			if (ParamUtil.getString(request, "type").equals("add")) {
				List<CoQuanQuanLy> lst = CoQuanQuanLyLocalServiceUtil
						.findByMa(ParamUtil.getString(request, "ma"));
				if (lst.size() > 0) {
					CoQuanQuanLy coQuan = lst.get(0);
					if (coQuan.getDaXoa() != 1) {
						errors.add("error_ma_duplicate");
					}
				}
			} else {
				CoQuanQuanLy curentCq = CoQuanQuanLyLocalServiceUtil
						.fetchCoQuanQuanLy(ParamUtil.getLong(request, "id"));
				if (!curentCq.getMa()
						.equals(ParamUtil.getString(request, "ma"))) {
					List<CoQuanQuanLy> lst = CoQuanQuanLyLocalServiceUtil
							.findByMa(ParamUtil.getString(request, "ma"));
					if (lst.size() > 0) {
						CoQuanQuanLy coQuan = lst.get(0);
						if (coQuan.getDaXoa() != 1) {
							errors.add("error_ma_duplicate");
						}
					}
				}
			}
		}
		if (Validator.isNull(ParamUtil.getString(request, "idTinh"))) {
			errors.add("error_idTinh_required");
		}
		if (Validator.isNull(ParamUtil.getString(request, "diaChi"))) {
			errors.add("error_address_required");
		}else{
			if(ParamUtil.getString(request, "diaChi").length()>150){
				errors.add("error_diachi_toolong");
			}
		}
		if (Validator.isNull(ParamUtil.getString(request, "dienThoai"))) {
			errors.add("error_phone_required");
		}else{
			if(ParamUtil.getString(request, "dienThoai").length()>15){
				errors.add("error_phone_toolong");
			}
		}
		if (Validator.isNull(ParamUtil.getString(request, "capCoQuanQuanLyId"))) {
			errors.add("error_ccq_required");
		}
		if (Validator.isNotNull(ParamUtil.getString(request, "email"))
				&& !Validator.isEmailAddress(ParamUtil.getString(request,
						"email"))) {
			errors.add("error_email_invalid");
		}
		if (Validator.isNotNull(ParamUtil.getString(request, "fax"))) {
			if(ParamUtil.getString(request, "fax").length()>15){
				errors.add("error_fax_toolong");
			}
		}
		if (Validator.isNotNull(ParamUtil.getString(request, "email"))) {
			if(ParamUtil.getString(request, "email").length()>50){
				errors.add("error_email_toolong");
			}
		}
		if (Validator.isNotNull(ParamUtil.getString(request, "website"))) {
			if(ParamUtil.getString(request, "website").length()>100){
				errors.add("error_website_toolong");
			}
		}
		return errors;
	}

	/**
	 * This is  function validation CongChuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @return List<String<
	 */
	public static List<String> validCongChuc(ActionRequest actionRequest)
			throws SystemException {
		List<String> errors = new ArrayList<String>();
		if (Validator.isNull(ParamUtil.getString(actionRequest, "hoVaTen"))) {
			errors.add("empty.hoVaTen");
		}else{
			if(ParamUtil.getString(actionRequest, "hoVaTen").length()>100){
				errors.add("toolong.hoVaTen");
			}
		}
		if (Validator.isNull(ParamUtil.getString(actionRequest, "ma"))) {
			errors.add("empty.ma");
		} else {
			if(ParamUtil.getString(actionRequest, "ma").length()>20){
				errors.add("toolong.ma");
			}
			if (ParamUtil.getLong(actionRequest, "id", 0) == 0) {
				List<CongChuc> lcc = CongChucLocalServiceUtil
						.findByMa(ParamUtil.getString(actionRequest, "ma"));
				if (lcc.size() > 0) {
					CongChuc congChuc = lcc.get(0);
					if (congChuc.getDaXoa() != 1) {
						errors.add("duplicate.ma");
					}
				}
			} else {
				CongChuc currentCongChuc = CongChucLocalServiceUtil
						.fetchCongChuc(ParamUtil.getLong(actionRequest, "id"));
				if (!currentCongChuc.getMa().equals(
						ParamUtil.getString(actionRequest, "ma"))) {
					List<CongChuc> lcc = CongChucLocalServiceUtil
							.findByMa(ParamUtil.getString(actionRequest, "ma"));
					if (lcc.size() > 0) {
						CongChuc congChuc = lcc.get(0);
						if (congChuc.getDaXoa() != 1) {
							errors.add("duplicate.ma");
						}
					}
				}
			}
		}
		if (Validator.isNull(ParamUtil.getString(actionRequest, "email"))) {
			errors.add("empty.email");
		} else {
			if(ParamUtil.getString(actionRequest, "email").length()>50){
				errors.add("toolong.email");
			}
			if (ParamUtil.getLong(actionRequest, "id", 0) == 0) {
				List<TaiKhoanNguoiDung> ltk = TaiKhoanNguoiDungLocalServiceUtil
						.findByEmail(ParamUtil
								.getString(actionRequest, "email"));
				if (ltk.size() > 0) {
					TaiKhoanNguoiDung taiKhoan = ltk.get(0);
					if (taiKhoan.getDaXoa() != 1) {
						errors.add("duplicate.email");
					}
				}
			} else {
				CongChuc currentCongChuc = CongChucLocalServiceUtil
						.fetchCongChuc(ParamUtil.getLong(actionRequest, "id"));
				TaiKhoanNguoiDung currentTaiKhoan = TaiKhoanNguoiDungLocalServiceUtil
						.fetchTaiKhoanNguoiDung(currentCongChuc
								.getTaiKhoanNguoiDungId());
				if (!currentTaiKhoan.getEmail().equals(
						ParamUtil.getString(actionRequest, "email"))) {
					List<TaiKhoanNguoiDung> ltk = TaiKhoanNguoiDungLocalServiceUtil
							.findByEmail(ParamUtil.getString(actionRequest,
									"email"));
					if (ltk.size() > 0) {
						TaiKhoanNguoiDung taiKhoan = ltk.get(0);
						if (taiKhoan.getDaXoa() != 1) {
							errors.add("duplicate.email");
						}
					}
				}
			}
		}
		if (Validator.isNotNull(ParamUtil.getString(actionRequest, "email"))
				&& !Validator.isEmailAddress(ParamUtil.getString(actionRequest,
						"email"))) {
			errors.add("invalid.email");
		}
		if (Validator.isNull(ParamUtil.getString(actionRequest, "ngaySinh"))) {
			errors.add("empty.ngaySinh");
		}
		if (Validator.isNull(ParamUtil.getString(actionRequest, "gioiTinh"))) {
			errors.add("empty.gioiTinh");
		}
		if (Validator.isNull(ParamUtil.getString(actionRequest, "cqqlId"))) {
			errors.add("empty.cqqlId");
		}else{
			if(ParamUtil.getLong(actionRequest, "cqqlId")==0){
				errors.add("empty.cqqlId");
			}
		}
		if (Validator.isNull(ParamUtil.getString(actionRequest, "chucVuId"))) {
			errors.add("empty.chucVuId");
		}
		if (ParamUtil.getLong(actionRequest, "id",0)==0) {
			if (Validator
					.isNull(ParamUtil.getString(actionRequest, "password"))) {
				errors.add("empty.password");
			}
			if (Validator.isNull(ParamUtil.getString(actionRequest,
					"rePassword"))) {
				errors.add("empty.rePassword");
			}
			if (Validator.isNotNull(ParamUtil.getString(actionRequest,
					"rePassword"))
					&& Validator.isNotNull(ParamUtil.getString(actionRequest,
							"password"))) {
				if(!ParamUtil.getString(actionRequest,"rePassword").equals(ParamUtil.getString(actionRequest,"password"))){
					errors.add("missmatch.password");
				}
			}
		}
		if (Validator.isNotNull(ParamUtil.getString(actionRequest, "soCmnd"))) {
			if(ParamUtil.getString(actionRequest, "soCmnd").length()>15){
				errors.add("toolong.soCmnd");
			}
		}
		if (Validator.isNotNull(ParamUtil.getString(actionRequest, "noiCapCmnd"))) {
			if(ParamUtil.getString(actionRequest, "noiCapCmnd").length()>15){
				errors.add("toolong.noiCapCmnd");
			}
		}
		return errors;
	}

	/**
	 * This is  function get Map CoQuanQuanLy from Request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @return Map
	 */
	public static Map<String, String> getMapCQQLFromRequest(
			ActionRequest request) {
		String chaId = null;
		if(ParamUtil.getLong(request, "chaId")!=0){
			chaId = ParamUtil.getString(request, "chaId");
		}
		Map<String, String> userRequest = new HashMap<String, String>();
		userRequest.put("id", ParamUtil.getString(request, "id"));
		userRequest.put("ma", ParamUtil.getString(request, "ma"));
		userRequest.put("ten", ParamUtil.getString(request, "ten"));
		userRequest.put("diaChi", ParamUtil.getString(request, "diaChi"));
		userRequest.put("dienThoai", ParamUtil.getString(request, "dienThoai"));
		userRequest.put("email", ParamUtil.getString(request, "email"));
		userRequest.put("fax", ParamUtil.getString(request, "fax"));
		userRequest.put("website", ParamUtil.getString(request, "website"));
		userRequest.put("noiBo", ParamUtil.getString(request, "noiBo"));
		userRequest.put("chaId", chaId);
		userRequest.put("merChant", ParamUtil.getString(request, "merChant"));
		userRequest.put("accessCode",
				ParamUtil.getString(request, "accessCode"));
		userRequest.put("secureSecret",
				ParamUtil.getString(request, "secureSecret"));
		userRequest.put("maCapSoBienNhan",
				ParamUtil.getString(request, "maCapSoBienNhan"));
		userRequest.put("capCoQuanQuanLyId",
				ParamUtil.getString(request, "capCoQuanQuanLyId"));
		userRequest.put("idTinh", ParamUtil.getString(request, "idTinh"));
		userRequest.put("idHuyen", ParamUtil.getString(request, "idHuyen"));
		userRequest.put("idXa", ParamUtil.getString(request, "idXa"));
		return userRequest;
	}

	/**
	 * This is  function get Map CoQuanQuanLy from CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param coQuanQuanLy
	 * @throws SystemException
	 * @throws PortalException
	 * @return Map
	 */
	public static Map<String, String> getMapCQQLFromCQQL(
			CoQuanQuanLy coQuanQuanLy) throws SystemException, PortalException {
		Map<String, String> userRequest = new HashMap<String, String>();
		userRequest.put("id", String.valueOf(coQuanQuanLy.getId()));
		userRequest.put("ma", coQuanQuanLy.getMa());
		userRequest.put("ten", coQuanQuanLy.getTen());
		userRequest.put("diaChi", coQuanQuanLy.getDiaChi());
		userRequest.put("dienThoai", coQuanQuanLy.getDienThoai());
		userRequest.put("email", coQuanQuanLy.getEmail());
		userRequest.put("fax", coQuanQuanLy.getFax());
		userRequest.put("website", coQuanQuanLy.getWebsite());
		userRequest.put("noiBo", String.valueOf(coQuanQuanLy.getNoiBo()));
		userRequest.put("chaId", String.valueOf(coQuanQuanLy.getChaId()));
		userRequest.put("merChant", coQuanQuanLy.getMerchant());
		userRequest.put("accessCode", coQuanQuanLy.getAccessCode());
		userRequest.put("secureSecret", coQuanQuanLy.getSecureSecret());
		userRequest.put("maCapSoBienNhan", coQuanQuanLy.getMaCapSoBienNhan());
		userRequest.put("capCoQuanQuanLyId",
				String.valueOf(coQuanQuanLy.getCapCoQuanQuanlyId()));
		// don vi hanh chinh
		DonViHanhChinh donViHanhChinh = DonViHanhChinhLocalServiceUtil
				.fetchDonViHanhChinh(coQuanQuanLy.getDonViHanhChinhId());
		CapDonViHanhChinh capDonViHanhChinh = CapDonViHanhChinhLocalServiceUtil
				.fetchCapDonViHanhChinh(donViHanhChinh.getCapDonViHanhChinhId());
		if (donViHanhChinh != null && capDonViHanhChinh != null) {
			if (capDonViHanhChinh.getMa().equals(
					ThamSoLocalServiceUtil.getValue("MATHANHPHO"))
					|| capDonViHanhChinh.getMa().equals(
							ThamSoLocalServiceUtil.getValue("MATINH"))) {
				userRequest.put("idTinh", coQuanQuanLy.getDonViHanhChinhId()
						+ "");
				userRequest.put("idHuyen", "");
				userRequest.put("idXa", "");
			} else if (capDonViHanhChinh.getMa().equals(
					ThamSoLocalServiceUtil.getValue("MAQUAN"))
					|| capDonViHanhChinh.getMa().equals(
							ThamSoLocalServiceUtil.getValue("MAHUYEN"))) {
				DonViHanhChinh tinh = DonViHanhChinhLocalServiceUtil
						.getDonViHanhChinh(donViHanhChinh.getChaId());
				userRequest.put("idTinh", tinh.getId() + "");
				userRequest.put("idHuyen", coQuanQuanLy.getDonViHanhChinhId()
						+ "");
				userRequest.put("idXa", "");
			} else if (capDonViHanhChinh.getMa().equals(
					ThamSoLocalServiceUtil.getValue("MAPHUONG"))
					|| capDonViHanhChinh.getMa().equals(
							ThamSoLocalServiceUtil.getValue("MAXA"))
					|| capDonViHanhChinh.getMa().equals(
							ThamSoLocalServiceUtil.getValue("MATHITRAN"))) {
				DonViHanhChinh huyen = DonViHanhChinhLocalServiceUtil
						.getDonViHanhChinh(donViHanhChinh.getChaId());
				DonViHanhChinh tinh = DonViHanhChinhLocalServiceUtil
						.getDonViHanhChinh(huyen.getChaId());
				userRequest.put("idTinh", tinh.getId() + "");
				userRequest.put("idHuyen", huyen.getId() + "");
				userRequest
						.put("idXa", coQuanQuanLy.getDonViHanhChinhId() + "");
			}
		}
		return userRequest;
	}

	/**
	 * This is  function insert CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param userRequest
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void insertCoQuanQuanLy(Map<String, String> userRequest,
			ActionRequest request) throws PortalException, SystemException {
		// Get ma co quan quan ly
		String donViHanhChinhId = userRequest.get("idXa");
		if (donViHanhChinhId.isEmpty()) {
			donViHanhChinhId = userRequest.get("idHuyen");
			if (donViHanhChinhId.isEmpty()) {
				donViHanhChinhId = userRequest.get("idTinh");
			}
		}
		CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyClp();

		coQuanQuanLy.setId(CounterLocalServiceUtil.increment(CoQuanQuanLy.class
				.getName()));

		coQuanQuanLy.setMa(userRequest.get("ma"));

		coQuanQuanLy.setTen(userRequest.get("ten"));

		coQuanQuanLy.setDonViHanhChinhId(Long.parseLong(donViHanhChinhId));

		coQuanQuanLy.setDiaChi(userRequest.get("diaChi"));

		coQuanQuanLy.setDienThoai(userRequest.get("dienThoai"));

		coQuanQuanLy.setEmail(userRequest.get("email"));

		coQuanQuanLy.setFax(userRequest.get("fax"));

		coQuanQuanLy.setWebsite(userRequest.get("website"));

		coQuanQuanLy.setMerchant(userRequest.get("merChant"));

		coQuanQuanLy.setAccessCode(userRequest.get("accessCode"));

		coQuanQuanLy.setSecureSecret(userRequest.get("secureSecret"));

		coQuanQuanLy.setMaCapSoBienNhan(userRequest.get("maCapSoBienNhan"));

		if (Validator.isNotNull(userRequest.get("noiBo"))) {
			coQuanQuanLy.setNoiBo(Integer.parseInt(userRequest.get("noiBo")));
		}

		coQuanQuanLy.setCapCoQuanQuanlyId(Long.valueOf(userRequest
				.get("capCoQuanQuanLyId")));

		if (Validator.isNotNull(userRequest.get("chaId"))) {
			coQuanQuanLy.setChaId(Long.valueOf(userRequest.get("chaId")));
		}

		Date currentDate = new Date();

		coQuanQuanLy.setNgayTao(currentDate);

		coQuanQuanLy.setNgaySua(currentDate);

		User currentUser = PortalUtil.getUser(request);

		if (currentUser != null) {
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
	 * This is  function update CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param userRequest
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void updateCoQuanQuanLy(Map<String, String> userRequest,
			ActionRequest request) throws PortalException, SystemException {
		// Get ma co quan quan ly
		String donViHanhChinhId = userRequest.get("idXa");
		if (donViHanhChinhId.isEmpty()) {
			donViHanhChinhId = userRequest.get("idHuyen");
			if (donViHanhChinhId.isEmpty()) {
				donViHanhChinhId = userRequest.get("idTinh");
			}
		}
		CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil
				.getCoQuanQuanLy(Long.parseLong(userRequest.get("id")));

		coQuanQuanLy.setMa(userRequest.get("ma"));

		coQuanQuanLy.setTen(userRequest.get("ten"));

		coQuanQuanLy.setDonViHanhChinhId(Long.parseLong(donViHanhChinhId));

		coQuanQuanLy.setDiaChi(userRequest.get("diaChi"));

		coQuanQuanLy.setDienThoai(userRequest.get("dienThoai"));

		coQuanQuanLy.setEmail(userRequest.get("email"));

		coQuanQuanLy.setFax(userRequest.get("fax"));

		coQuanQuanLy.setWebsite(userRequest.get("website"));

		coQuanQuanLy.setMerchant(userRequest.get("merChant"));

		coQuanQuanLy.setAccessCode(userRequest.get("accessCode"));

		coQuanQuanLy.setSecureSecret(userRequest.get("secureSecret"));

		coQuanQuanLy.setMaCapSoBienNhan(userRequest.get("maCapSoBienNhan"));

		if (Validator.isNotNull(userRequest.get("noiBo"))) {
			coQuanQuanLy.setNoiBo(Integer.parseInt(userRequest.get("noiBo")));
		}

		coQuanQuanLy.setCapCoQuanQuanlyId(Long.valueOf(userRequest
				.get("capCoQuanQuanLyId")));

		Date currentDate = new Date();

		coQuanQuanLy.setNgaySua(currentDate);

		User currentUser = PortalUtil.getUser(request);

		if (currentUser != null) {
			coQuanQuanLy.setNguoiSua(currentUser.getFullName());
		}

		CoQuanQuanLyLocalServiceUtil.updateCoQuanQuanLy(coQuanQuanLy);
	}

	/**
	 * This is  function delete CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void delete(long id) throws PortalException, SystemException {
		CoQuanQuanLyLocalServiceUtil.deleteCoQuanQuanLy(id);
	}

	/**
	 * This is  function create md5 code
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param input
	 * @return String
	 */
	public static String md5(String input) {

		String md5 = null;

		if (null == input)
			return null;

		try {

			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}
}
