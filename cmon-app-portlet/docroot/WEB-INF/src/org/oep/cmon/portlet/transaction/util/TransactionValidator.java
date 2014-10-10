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

package org.oep.cmon.portlet.transaction.util;

import java.util.List;

import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;




import com.liferay.portal.kernel.util.Validator;
/**
 * @author HungvQ
 */
/**
*
* TransactionValidator class
*   
* This class is used to Validator
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
public class TransactionValidator {

	/**
	  * This is fucntion validateYcHuyHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param YKienTraoDoi traoDoi, List errors
	  * @return boolean
	  */
    @SuppressWarnings("unchecked")
    public static boolean validateYcHuyHoSo (YKienTraoDoi traoDoi, List errors) {

        boolean valid = true;

        if (Validator.isNull(traoDoi.getNoiDungYKien())) {
            valid = false;
            errors.add("YCHuy-required");
        }
        
        if (Validator.isNull(traoDoi.getNguoiNhanId()) || traoDoi.getNguoiNhanId() < 1) {
            valid = false;
            errors.add("canboxuly-required");
			
		}
        return valid;
    }
    /**
	  * This is fucntion validateTraoDoiHoSoHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param YKienTraoDoi traoDoi, List errors
	  * @return boolean
	  */
    public static boolean validateTraoDoiHoSoHoSo (YKienTraoDoi traoDoi, List errors) {

        boolean valid = true;
        if (Validator.isNull(traoDoi.getTieuDe())) {
            valid = false;
            errors.add("TieuDe-required");
        }

        if (Validator.isNull(traoDoi.getNoiDungYKien())) {
            valid = false;
            errors.add("YCHuy-required");
        }
        
        if (Validator.isNull(traoDoi.getNguoiNhanId()) || traoDoi.getNguoiNhanId() < 1) {
            valid = false;
            errors.add("canboxuly-required");
			
		}
        return valid;
    }    
}
