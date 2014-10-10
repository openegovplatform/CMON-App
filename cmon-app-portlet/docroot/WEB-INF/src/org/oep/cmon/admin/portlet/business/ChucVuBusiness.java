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

import org.oep.cmon.admin.portlet.action.ChucVuAction;
import org.oep.cmon.admin.portlet.util.ConvertUtil;

import org.oep.cmon.dao.cc.model.ChucVu;

/**
 * This is class ChucVuBusiness
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ChucVuBusiness {

	public static final String VIEW_CHUC_VU = "viewChucVu";

	/**
	 * This is function check data return
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param doiTuongSuDung
	 * @param dataInput
	 * @param type
	 * @return String
	 */
	public static String checkDataReturn(ChucVu doiTuongSuDung, String dataInput, int type) {
		if (dataInput != null && dataInput.length() > 0) {
			return dataInput.trim();
		} else if (doiTuongSuDung != null) {
			if (type == 3) {
				return doiTuongSuDung.getMa();
			} else {
				return doiTuongSuDung.getTen();
			}
		}

		return "";
	}

	/**
	 * This is function find ChucVu by TenChucVu
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<ChucVu>
	 */
	public static List<ChucVu> findByTenChucVu(String keyWord) {
		ChucVuAction action = new ChucVuAction();
		return action.findByTenChucVu(keyWord);
	}
	
	/**
	 * This is function check selected value
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
		if (ConvertUtil.convertToLong(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	/**
	 * This is function check selected
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param intValue
	 * @param outValue
	 * @param defaultValue
	 * @return String
	 */
	public static String checkSelected(ChucVu intValue, String outValue, String defaultValue) {
		if (intValue != null) {
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
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
		if (dataInput != null && dataInput.compareTo(VIEW_CHUC_VU) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}
}
