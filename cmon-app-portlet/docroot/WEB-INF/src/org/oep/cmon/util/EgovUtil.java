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

package org.oep.cmon.util;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.Constants;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;

/** 
 * This is class EgovUtil
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class EgovUtil {
	
	/** 
	 * This is function getCongChucDaDangNhap
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param request
	 * @throws SystemException
	 * @return CongChuc
	 */
	public static CongChuc getCongChucDaDangNhap(PortletRequest request) throws SystemException {
		return getCongChucDaDangNhap(PortalUtil.getUserId(request));
	}
	
	/** 
	 * This is function getCongChucDaDangNhap
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param request
	 * @throws SystemException
	 * @return CongChuc
	 */
	public static CongChuc getCongChucDaDangNhap(HttpServletRequest request) throws SystemException {
		return getCongChucDaDangNhap(PortalUtil.getUserId(request));
	}
	
	/** 
	 * This is function getCongChucDaDangNhap
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param liferayUserId
	 * @throws SystemException
	 * @return CongChuc
	 */
	public static CongChuc getCongChucDaDangNhap(long liferayUserId) throws SystemException {
		CongChuc out = null;
		TaiKhoanNguoiDung tknd = TaiKhoanNguoiDungLocalServiceUtil.fetchByLiferayUserId(liferayUserId);
		if (tknd != null) {
			out = CongChucLocalServiceUtil.fetchByTaiKhoanNguoiDung(tknd.getId());
		}
		return out;
	}
	
	/** 
	 * This is function getCongChucDaDangNhap
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param liferayUserId
	 * @throws SystemException
	 * @return CongDan
	 */
	public static CongDan getCongDanDaDangNhap(long liferayUserId) throws SystemException {
		CongDan out = null;
		TaiKhoanNguoiDung tknd = TaiKhoanNguoiDungLocalServiceUtil.fetchByLiferayUserId(liferayUserId);
		if (tknd != null) {
			out = CongDanLocalServiceUtil.findByTaiKhoanNguoiDungId(tknd.getId());
		}
		return out;
	}
	
	/** 
	 * This is function laCongChucDangNhap
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param liferayUserId
	 * @throws SystemException
	 * @return boolean
	 */
	public static boolean laCongChucDangNhap(long liferayUserId) throws SystemException {
		return laCongChucDangNhap(TaiKhoanNguoiDungLocalServiceUtil.fetchByLiferayUserId(liferayUserId));
	}
 	/** 
	 * This is function laCongChucDangNhap
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param tknd
	 * @return boolean
	 */
	public static boolean laCongChucDangNhap(TaiKhoanNguoiDung tknd) {
		return tknd == null
			? false
			: tknd.getLoaiDoiTuongId() == Constants.LDT_CANBO;
	}
}
