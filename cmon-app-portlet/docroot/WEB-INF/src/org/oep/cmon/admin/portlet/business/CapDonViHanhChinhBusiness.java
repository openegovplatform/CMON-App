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

import org.oep.cmon.admin.portlet.action.CapDonViHanhChinhAction;

import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh;

/**
 * This is class CapDonViHanhChinhBusiness
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CapDonViHanhChinhBusiness {

	public static final String VIEW_DON_VI_HANH_CHINH = "viewCapDonViHanhChinh";

	/**
	 * This is function check data return
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param quocGia
	 * @param dataInput
	 * @param type
	 * @return String
	 */
	public static String checkDataReturn(CapDonViHanhChinh quocGia, String dataInput, int type) {
		if (dataInput != null && dataInput.length() > 0) {
			return dataInput.trim();
		} else if (quocGia != null) {
			if (type == 4) {
				return quocGia.getMota().trim();
			} else if (type == 3) {
				return String.valueOf(quocGia.getCap());
			} else if (type == 2) {
				return quocGia.getMa();
			} else {
				return quocGia.getTen();
			}
		}

		return "";
	}

	/**
	 * This is function find CapDonViHanhChinh by TenDonViHanhChinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<CapDonViHanhChinh>
	 */
	public static List<CapDonViHanhChinh> findByTenDonViHanhChinh(String keyWord) {
		CapDonViHanhChinhAction action = new CapDonViHanhChinhAction();
		return action.findByTenCapDonViHanhChinh(keyWord);
	}
	
	/**
	 * This is function check read only
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param dataInput
	 * @return String
	 */
	public static String checkReadOnly(String dataInput) {
		if (dataInput != null && dataInput.compareTo(VIEW_DON_VI_HANH_CHINH) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}
}
