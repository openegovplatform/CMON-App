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

import org.oep.cmon.admin.portlet.action.GioiTinhAction;

import org.oep.cmon.dao.cd.model.GioiTinh;

/** 
 * This is class GioiTinhBusiness
 * 
 * This class contains logics related to GioiTinh table
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  21-March-2013  Nam Dinh    Create new
 */
public class GioiTinhBusiness {

	public static final String VIEW_GIOI_TINH = "viewGioiTinh";

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
	 * @param String
	 */
	public static String checkDataReturn(GioiTinh quocGia, String dataInput, int type) {
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

	public static List<GioiTinh> findAll() {
		GioiTinhAction action = new GioiTinhAction();
		return action.findAll();
	}
	
	/** 
	 * This is function check data return
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
		if (dataInput != null && dataInput.compareTo(VIEW_GIOI_TINH) == 0) {
			return "readonly=\"readonly\"";
		}

		return "";
	}
}
