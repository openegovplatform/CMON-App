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


package org.oep.cmon.user.portlet.util;

/** 
 * Luhn algorithm class
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  13-Sept-2012  Nam Dinh    Create new
 */
public class LunUtil {
	
	/**
	 * Generate Luhn number
	 * 
	 * @param s
	 * @return
	 */
	public  static String generateDigit(String s) {
        int digit = (10 - doLuhn(s, true) % 10)%10;
       
        return String.valueOf(digit);
    }

	/**
	 * Do Luhn algorithm
	 * 
	 * @param s
	 * @param evenPosition
	 * @return
	 */
    private static int doLuhn(String s, boolean evenPosition) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(s.substring(i, i + 1));
            if (evenPosition) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            evenPosition = !evenPosition;
        }

        return sum;
    }
    
    /**
     * Check if a number is correct
     * 
     * @param s
     * @return
     */
    public static boolean isValidNumber(String s) {
        return doLuhn(s, false) % 10 == 0;
    }
}
