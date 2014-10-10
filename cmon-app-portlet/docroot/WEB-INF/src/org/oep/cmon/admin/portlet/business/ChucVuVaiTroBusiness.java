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

import org.oep.cmon.admin.portlet.action.ChucVuVaiTroAction;
import org.oep.cmon.admin.portlet.util.ConvertUtil;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;

/**
 * This is class ChucVuVaiTroBusiness
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ChucVuVaiTroBusiness {
	public static final String VIEW_CHUC_VU_VAI_TRO = "viewChucVuVaiTro";

	/**
	 * This is function find CoQuanQuanLy by keyword
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<CoQuanQuanLy>
	 */
	public static List<CoQuanQuanLy> findByCoQuanQuanLy(String keyWord) {
		ChucVuVaiTroAction action = new ChucVuVaiTroAction();
		return action.findByCoQuanQuanLy(keyWord);
	}
	
	/**
	 * This is function find TenCapCoQuanQuanLy by CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param coQuanQuanLyId
	 * @return String
	 */
	public static String getCapCoQuanQuanLyByIdCoQuanQuanLy(long coQuanQuanLyId) {
		try {
			return CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(coQuanQuanLyId).getTen();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function find ChucVu by CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param coQuanQuanLyId
	 * @return List<ChucVu2VaiTro>
	 */
	public static List<ChucVu2VaiTro> findChucVuByCoQuanQuanLy(long coQuanQuanLyId) {
		ChucVuVaiTroAction action = new ChucVuVaiTroAction();
		return action.findChucVuByCoQuanQuanLyId(coQuanQuanLyId);
	}
	
	/**
	 * This is function find ChucVu by ChucVuId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param chucVuId
	 * @return ChucVu
	 */
	public static ChucVu findChucVuByChucVuId(long chucVuId) {
		try {
			return ChucVuLocalServiceUtil.fetchChucVu(chucVuId);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * This is function find VaiTro by VaiTroId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param vaiTroId
	 * @return VaiTro
	 */
	public static VaiTro findVaiTroByVaiTroId(long vaiTroId) {
		try {
			return VaiTroLocalServiceUtil.fetchVaiTro(vaiTroId);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * This is function find CoQuanQuanLy by CoQuanQuanLyId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param coQuanQuanLyId
	 * @return CoQuanQuanLy
	 */
	public static CoQuanQuanLy getCoQuanQuanLyByIdCoQuanQuanLy(String coQuanQuanLyId) {
		try {
			return CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(ConvertUtil.convertToLong(coQuanQuanLyId));
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * This is function find check selected ChuVu
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param chucVu2VaiTro
	 * @param value2
	 * @param chucVuId
	 * @return String
	 */
	public static String checkSelectedChucVu(ChucVu2VaiTro chucVu2VaiTro, long value2, String chucVuId) {
		if (chucVu2VaiTro == null && chucVuId == null) {
			return "";
		}
		
		if (chucVu2VaiTro != null && chucVu2VaiTro.getChucVuId() == value2) {
			return "selected=\"selected\"";
		} else if (chucVuId != null) {
			if (ConvertUtil.convertToLong(chucVuId) == value2) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}
	
	/**
	 * This is function checked selected VaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param chucVu2VaiTro
	 * @param value2
	 * @param vaiTroId
	 * @return String
	 */
	public static String checkSelectedVaiTro(ChucVu2VaiTro chucVu2VaiTro, long value2, String vaiTroId) {
		if (chucVu2VaiTro == null && vaiTroId == null) {
			return "";
		}
		
		if (chucVu2VaiTro != null && chucVu2VaiTro.getVaiTroId() == value2) {
			return "selected=\"selected\"";
		} else if (vaiTroId != null) {
			if (ConvertUtil.convertToLong(vaiTroId) == value2) {
				return "selected=\"selected\"";
			}
		}
		return "";
	}

	/**
	 * This is function get TenChucVu by ChucVuId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param chucVuId
	 * @return String
	 */
	public static String getChucVuByIdChucVu(String chucVuId) {
		try {
			return ChucVuLocalServiceUtil.fetchChucVu(ConvertUtil.convertToLong(chucVuId)).getTen();
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * This is function get ChuVu by  TrangThai
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<ChucVu>
	 */
	public static List<ChucVu> findChucVuByTrangThai() {
		ChucVuVaiTroAction action = new ChucVuVaiTroAction();
		return action.findChucVuByTrangThai();
	}
	
	
	/**
	 * This is function get VaiTro by TrangThai
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<VaiTro>
	 */
	public static List<VaiTro> findVaiTroByTrangThai() {
		ChucVuVaiTroAction action = new ChucVuVaiTroAction();
		return action.findVaiTroByTrangThai();
	}
}
