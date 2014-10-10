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

package org.oep.cmon.portlet.thamso.business;

import java.util.List;

import org.oep.cmon.portlet.thamso.action.ThamSoPortlet;
import org.oep.cmon.portlet.thamso.util.FormatUtil;

import org.oep.cmon.dao.cd.model.HeThong;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.thamso.model.ThamSo;

/**
*
* ThamSoBusiness class
*   
* This class is used to process ThamSoBusiness
* from database
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class ThamSoBusiness {

	public static final String VIEW_THAM_SO = "viewThamSo";

	/**
	  * This is fucntion findByTenThamSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyWord, Long ungDungId, Long heThongId, int start, int end
	  * @return List<ThamSo>
	  */
	public static List<ThamSo> findByTenThamSo(String keyWord, Long ungDungId, Long heThongId, int start, int end) {
		ThamSoPortlet action = new ThamSoPortlet();
		return action.findByTenThamSo(keyWord, ungDungId, heThongId, start, end);
	}
	
	/**
	  * This is fucntion getUngDungList
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<DanhMucUngDung>
	  */
	public static List<DanhMucUngDung> getUngDungList() {
		ThamSoPortlet action = new ThamSoPortlet();
		return action.getUngDungList();
	}
	/**
	  * This is fucntion getHeThongList
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<HeThong>
	  */
	public static List<HeThong> getHeThongList() {
		ThamSoPortlet action = new ThamSoPortlet();
		return action.getHeThongList();
	}
	/**
	  * This is fucntion checkSelectedValue
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String value1, long value2
	  * @return String
	  */
	public static String checkSelectedValue(String value1, long value2) {
		if (FormatUtil.convertToLong(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}
	/**
	  * This is fucntion checkSelectedValue
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String value1, String value2
	  * @return String
	  */
	public static String checkSelectedValue(String value1, String value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}

	/**
	  * This is fucntion checkSelectedValue
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long value1, Long value2
	  * @return String
	  */
	public static String checkSelectedValue(Long value1, Long value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}

	/**
	  * This is fucntion checkDataReturn
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ThamSo tsHT, String dataInput, int type
	  * @return String
	  */
	public static String checkDataReturn(ThamSo tsHT, String dataInput, int type) {
		if (dataInput != null && dataInput.length() > 0) {
			return dataInput.trim();
		} else if (tsHT != null) {
			if (type == 3) {
				return tsHT.getGiaTri();
			}
			else if (type == 2) {
				return tsHT.getMota();
			} 				
			else {
				return tsHT.getTen();
			}
		}

		return "";
	}

	/**
	  * This is fucntion checkSelected
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ThamSo intValue, String outValue, String defaultValue
	  * @return String
	  */
	public static String checkSelected(ThamSo intValue, String outValue, String defaultValue) {
		if (intValue != null) {
		} else {
			if (outValue.compareTo(defaultValue) == 0) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}
	/**
	  * This is fucntion checkStatusSelected
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ThamSo intValue, String outValue, String defaultValue
	  * @return String
	  */
	public static String checkStatusSelected(ThamSo intValue, String outValue, String defaultValue) {
		if (intValue != null) {
			if (String.valueOf(intValue.getDaXoa()).compareTo(defaultValue) == 0) {
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
	  * This is fucntion checkReadOnly
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dataInput
	  * @return String
	  */
	public static String checkReadOnly(String dataInput) {
		if (dataInput != null && dataInput.compareTo(VIEW_THAM_SO) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}

	/**
	  * This is fucntion checkDisabled
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String value1,String value2
	  * @return String
	  */
	public static String checkDisabled(String value1,String value2) {
		if (value1.equals(value2)) {
			return "disabled=\"disabled\"";
		}

		return "";
	}

}
