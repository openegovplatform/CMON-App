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

import java.util.List;

import org.oep.cmon.admin.portlet.action.DanhMucDonViHanhChinhAction;
import org.oep.cmon.admin.portlet.util.ConvertUtil;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

/** 
 * This is class DonViHanhChinh business
 * 
 * This class contains logics related to DonViHanhChinh table
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  21-March-2013  Nam Dinh    Create new
 */
public class DanhMucDonViHanhChinhBusiness {

	public static final String VIEW_DANH_MUC_DON_VI_HANH_CHINH = "viewDanhMucDonViHanhChinh";

	/** 
	 * This is function check data return
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param quocGia
	 * @param dataInput
	 * @param type , type in (1: ten, 2: ma) 
	 */
	public static String checkDataReturn(DonViHanhChinh quocGia, String dataInput, int type) {
		if (dataInput != null && dataInput.length() > 0) {
			return dataInput.trim();
		} else if (quocGia != null) {
			if (type == 2) {
				return quocGia.getMa();
			} else {
				return quocGia.getTen();
			}
		}

		return "";
	}

	public static List<DonViHanhChinh> findByTenDonViHanhChinh(String keyWord) {
		DanhMucDonViHanhChinhAction action = new DanhMucDonViHanhChinhAction();
		return action.findByTenDonViHanhChinh(keyWord);
	}
	
	/** 
	 * This is function check read only
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param dataInput
	 * @param type , type in (1: ten, 2: ma) 
	 * @return String
	 */
	public static String checkReadOnly(String dataInput) {
		if (dataInput != null && dataInput.compareTo(VIEW_DANH_MUC_DON_VI_HANH_CHINH) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}

	public static String checkSelected(String value1, long value2) {
		if (ConvertUtil.convertToLong(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	/** 
	 * This is function get DonViHanhChinh
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param quocGia
	 * @param chaId
	 * @return String
	 */
	public static String getDonViHanhChinh(DonViHanhChinh quocGia, String chaId) {
		if (chaId.trim().length() > 0) {
			try {
				return DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(ConvertUtil.convertToLong(chaId)).getTen();
			} catch (Exception e) {
			}
		} else if (quocGia != null){
			try {
				return DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(quocGia.getChaId()).getTen();
			} catch (Exception e) {
			}
		}
		return "";
	}
}