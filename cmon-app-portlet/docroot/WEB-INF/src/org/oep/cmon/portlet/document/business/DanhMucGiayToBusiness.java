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

package org.oep.cmon.portlet.document.business;

import java.util.List;

import org.oep.cmon.portlet.document.util.FormatUtil;

import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
/**
 * @author duong.pham
 *
 */
public class DanhMucGiayToBusiness {

	public static final String VIEW_DM_GIAYTO = "viewDMGT";
	
	public static String checkSelectedValue(String value1, long value2) {
		if (FormatUtil.convertToLong(value1) == value2) {
			return "selected=\"selected\"";
		}
		return "";
	}
	public static String checkSelectedValue(String value1, String value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	public static String checkSelectedValue(Long value1, Long value2) {
		if (value1 != null && value2 != null && value1.equals(value2)) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
		public static String checkDataReturn(DanhMucGiayTo dMGT, String dataInput, int type) {
			if (dataInput != null && dataInput.length() > 0) {
				return dataInput.trim();
			} else if (dMGT != null) {
				if (type == 3) {
					return dMGT.getMa();
				}
				else if (type == 2) {
					return dMGT.getMota();
				} 
				else if (type == 4) {
					return dMGT.getKieuTaiLieu();
				} 
				else if (type == 5) {
					return String.valueOf(dMGT.getGioiHanDungLuong());
				} 
				else {
					return dMGT.getTen();
				}
			}

			return "";
		}
		
		public static String checkSelected(DanhMucGiayTo intValue, String outValue, String defaultValue) {
			if (intValue != null) {
			} else {
				if (outValue.compareTo(defaultValue) == 0) {
					return "selected=\"selected\"";
				}
			}
			return "";
		}
		public static String checkStatuSelected(DanhMucGiayTo intValue, String outValue, String defaultValue) {
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
		 * @param Danh muc giay to
		 * @param dataInput
		 * @param type , type in (1: ten, 2: ma) 
		 * @return
		 */
		public static String checkReadOnly(String dataInput) {
			if (dataInput != null && dataInput.compareTo(VIEW_DM_GIAYTO) == 0) {
				return "readonly=\"readonly\"";
			}

			return "";
		}
		
		/**
		 * @param Danh muc giay to
		 * @param dataInput
		 * @param type , type in (1: ten, 2: ma) 
		 * @return
		 */
		public static String checkDisabled(String value1,String value2) {
			if (value1.equals(value2)) {
				return "disabled=\"disabled\"";
			}

			return "";
		}
}
