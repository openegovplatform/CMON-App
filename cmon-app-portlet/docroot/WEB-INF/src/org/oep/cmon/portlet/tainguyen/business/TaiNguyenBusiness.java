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

package org.oep.cmon.portlet.tainguyen.business;

import java.util.List;

import org.oep.cmon.portlet.tainguyen.action.TaiNguyenPortlet;
import org.oep.cmon.portlet.tainguyen.util.FormatUtil;

import org.oep.cmon.dao.cd.model.HeThong;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.nsd.model.TaiNguyen;

/**
 * This is class TaiNguyenBusiness
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class TaiNguyenBusiness {
	public static final String VIEW_TAINGUYEN= "viewTAINGUYEN";
	
	/**
	 * This is function findByTaiNguyen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ten
	 * @param ungDungId
	 * @param heThongId
	 * @param start
	 * @param end
	 * @return List<TaiNguyen>
	 */
	public static List<TaiNguyen> findByTaiNguyen(String ten, Long ungDungId, Long heThongId, int start, int end) {
		TaiNguyenPortlet action = new TaiNguyenPortlet();
		return action.findByTaiNguyen(ten, ungDungId, heThongId, start, end);
	}
	
	/**
	 * This is function countByCongChung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ten
	 * @param ungDungId
	 * @param heThongId
	 * @return Long
	 */
	public static Long countByCongChung(String ten, Long ungDungId, Long heThongId) {
		TaiNguyenPortlet action = new TaiNguyenPortlet();
		return action.countByTaiNguyen(ten, ungDungId, heThongId);
	}
	
	/**
	 * This is function getUngDungList
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<DanhMucUngDung>
	 */
	public static List<DanhMucUngDung> getUngDungList() {
		TaiNguyenPortlet action = new TaiNguyenPortlet();
		return action.getUngDungList();
	}
	
	/**
	 * This is function getHeThongList
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<HeThong>
	 */
	public static List<HeThong> getHeThongList() {
		TaiNguyenPortlet action = new TaiNguyenPortlet();
		return action.getHeThongList();
	}
	
	/**
	 * This is function checkSelectedValue
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
		if (FormatUtil.convertToLong(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	/**
	 * This is function checkSelectedValue
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
	public static String checkSelectedValue(String value1, String value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}

	/**
	 * This is function checkSelectedValue
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
	public static String checkSelectedValue(Long value1, Long value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	
	/**
	 * This is function checkTTSelected
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
	public static String checkTTSelected(TaiNguyen intValue, String outValue, String defaultValue) {
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
	 * This is function checkLoaiSelected
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
	public static String checkLoaiSelected(TaiNguyen intValue, String outValue, String defaultValue) {
		if (intValue != null) {
			if (String.valueOf(intValue.getLoai()).compareTo(defaultValue) == 0) {
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
	 * This is function checkReadOnly
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
		if (dataInput != null && dataInput.compareTo(VIEW_TAINGUYEN) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}
	/**
	 * This is function checkDisabled
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
	public static String checkDisabled(String value1,String value2) {
		if (value1.equals(value2)) {
			return "disabled=\"disabled\"";
		}

		return "";
	}
	
	/**
	 * This is function checkDataReturn
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tnHT
	 * @param dataInput
	 * @param typpe
	 * @return String
	 */
	public static String checkDataReturn(TaiNguyen tnHT, String dataInput, int type) {
		if (dataInput != null && dataInput.length() > 0) {
			return dataInput.trim();
		} else if (tnHT != null) {
			if (type == 3) {
				return tnHT.getGiaTri();
			}
			else if (type == 2) {
				return tnHT.getMoTa();
			} 				
			else {
				return tnHT.getTen();
			}
		}

		return "";
	}
	
}
