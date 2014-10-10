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

/* 
 * Authentication code utility class
 * This class is used to generate unique authentication code
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  4-Sept-2012  Nam Dinh    Create new
 */
package org.oep.cmon.user.portlet.util;

/**
 * This class is used to generate unique authentication code
 * 
 * @author Nam Dinh
 * @date 4/9/2012
 *
 */
public class AuthenticateCodeUtil {
	
	/**
	 * Generate authenticate code
	 * 
	 * @return
	 */
    public static String generateAuthCode() {
        // Getting the current time in nanoseconds
        long decimalNumber=System.nanoTime();
 
        //To convert time stamp to alphanumeric code.
        //We need to convert base10(decimal) to base36
        String strBaseDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String strTempVal = "";
        
        int mod = 0;
        
        // String concat is costly, instead we could have use stringbuffer or stringbuilder
        // but here it wont make much difference.
        while(decimalNumber!= 0){
            mod=(int) (decimalNumber % 36);
        
            strTempVal=strBaseDigits.substring(mod,mod+1)+strTempVal;
            
            decimalNumber=decimalNumber/36;
        }       

        return strTempVal; 
    }
}
