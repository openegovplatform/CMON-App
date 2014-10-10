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

import org.oep.cmon.admin.portlet.action.VaiTroAction;
import org.oep.cmon.admin.portlet.util.ConvertUtil;


import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.nsd.model.VaiTro;

/** 
 * This is class VaiTroBusiness
 * 
 * This class contains logics related to VaiTro table
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  28-March-2013  Nam Dinh    Create new
 */
public class VaiTroBusiness {

	public static final String VIEW_VAI_TRO = "viewVaiTro";

	/** 
	 * This is function check data return
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	  * @param DoiTuongSuDung
	 * @param dataInput
	 * @param type , type in (1: ten, 2: ma) 
	 * @return
	 */
	public static String checkDataReturn(VaiTro doiTuongSuDung, String dataInput, int type) {
		if (dataInput != null && dataInput.length() > 0) {
			return dataInput.trim();
		} else if (doiTuongSuDung != null) {
			if (type == 3) {
				return doiTuongSuDung.getMa();
			} else if (type == 2) {
				return doiTuongSuDung.getMoTa();
			} else {
				return doiTuongSuDung.getTen();
			}
		}

		return "";
	}
	
	/** 
	 * This is function find DanhMucUngDung by TenUngDung
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<DanhMucUngDung>
	 */
	public static List<DanhMucUngDung> findByTenUngDung(String keyWord) {
		VaiTroAction action = new VaiTroAction();
		return action.findByTenUngDung(keyWord);
	}

	/** 
	 * This is function find VaiTro by TenVaiTro
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<VaiTro>
	 */
	public static List<VaiTro> findByTenVaiTro(String keyWord) {
		VaiTroAction action = new VaiTroAction();
		return action.findByTenVaiTro(keyWord);
	}
	
	/** 
	 * This is function check selected value
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
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
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param intValue
	 * @param outValue
	 * @param defaultValue
	 * @return String
	 */
	public static String checkSelected(VaiTro intValue, String outValue, String defaultValue) {
		if (intValue != null) {
			if (String.valueOf(intValue.getTrangThai()).compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
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
	 * @return String
	 */
	public static String checkReadOnly(String dataInput) {
		if (dataInput != null && dataInput.compareTo(VIEW_VAI_TRO) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}
}
