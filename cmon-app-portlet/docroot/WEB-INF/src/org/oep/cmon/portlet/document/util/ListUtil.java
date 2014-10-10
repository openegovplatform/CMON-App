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

package org.oep.cmon.portlet.document.util;

import java.util.List;

import org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;

/**
 * This is class ListUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ListUtil {
	
	/**
	 * This is function isExist
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param docList
	 * @param doiTuongId
	 * @return boolean
	 */
	public static boolean isExist(List<DanhMucGiayTo2DoiTuongSuDung> docList,long doiTuongId){
		if(docList != null){
			for (DanhMucGiayTo2DoiTuongSuDung dm2Dt : docList) {
				if(dm2Dt.getLoaiDoiTuongId()== doiTuongId){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This is function isTTHCExist
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param docList
	 * @param doiTuongId
	 * @return boolean
	 */
	public static boolean isTTHCExist(List<TTHC2DoiTuongSuDung> docList,long doiTuongId){
		if(docList != null){
			for (TTHC2DoiTuongSuDung dm2Dt : docList) {
				if(dm2Dt.getLoaiDoiTuongId()== doiTuongId){
					return true;
				}
			}
		}
		return false;
	}
	

	/**
	 * This is function isTT2GTExist
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param docList
	 * @param loaiGiayToId
	 * @return boolean
	 */  
	public static boolean isTT2GTExist(List<ThuTuc2GiayTo> docList,long loaiGiayToId){
		if(docList != null){
			for (ThuTuc2GiayTo tt2GT : docList) {
				if(tt2GT.getDanhMucGiayToId()== loaiGiayToId){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This is function isTT2CQQLExist
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tthcList
	 * @param cqqlId
	 * @return boolean
	 */
	public static boolean isTT2CQQLExist(List<TTHC2CoQuanQuanLy> tthcList, long cqqlId){
		if(tthcList != null){
			for (TTHC2CoQuanQuanLy tt2CQQL : tthcList) {
				if(tt2CQQL.getCoQuanQuanLyId()== cqqlId){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This is function isTT2CQQLOrTTHCExist
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tthcList
	 * @param cqqlId
	 * @param tthcid
	 * @return boolean
	 */    
	public static boolean isTT2CQQLOrTTHCExist(List<TTHC2CoQuanQuanLy> tthcList, long cqqlId, long tthcid){
		if(tthcList != null){
			for (TTHC2CoQuanQuanLy tt2CQQL : tthcList) {
				if(tt2CQQL.getCoQuanQuanLyId()== cqqlId && tt2CQQL.getThuTucHanhChinhId() == tthcid){
					return true;
				}
			}
		}
		return false;
	}

}
