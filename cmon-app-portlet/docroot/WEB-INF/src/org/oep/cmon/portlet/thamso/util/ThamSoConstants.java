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

package org.oep.cmon.portlet.thamso.util;

/**
*
* ThamSoConstants class
*   
* This class is used to declare Constant for ThamSo
* 
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
public class ThamSoConstants {
	
	public static final int ACTIVE = 0;
	public static final int INACTIVE = 1;// Da xoa
	
	public static interface KIEUDULIEU {
		public static final int KIEU_STRING = 0;
		public static final int KIEU_INTEGER = 1;
		public static final int KIEU_DOUBLE = 2;
	}

}
