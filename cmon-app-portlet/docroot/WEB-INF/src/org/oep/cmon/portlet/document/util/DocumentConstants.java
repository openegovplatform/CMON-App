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

/**
 * This is class DocumentConstants
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class DocumentConstants {

	public static final int ACTIVE = 0;
	public static final int INACTIVE = 1;// Da xoa
	
	public static interface GIAIDOAN{
		public static int NOPHOSO = 1;
		public static int XULY = 2;
		public static int TRAKETQUA = 3;
	}

	public static interface Tab {
		public static String TAB = "tab";
		public static String DOCUMENT = "doc";
		public static String APPLICATION = "app";
		public static String GROUP = "group";
		public static String TTHC = "tthc";
	}

	public static interface Group {
		public static final String CD = "CD";
		public static final String CB = "CB";
		public static final String DN = "DN";
		public static final String HTX = "HTX";
		public static final String HKDCT = "HKDCT";
		public static final String Other = "Other";
	}
	public static interface GT2DT {
		public static final int TrangThai = 1;
		public static final int DaXoa = 0;		
		
	}
	public static interface TTHC2DT {
		public static final int TrangThai = 1;
		public static final int DaXoa = 0;
		public static final int BatBuoc = 1;	
		public static final int Default_BatBuoc = 0;
		
	}
	public static interface TTHC2CQQL {
		public static final int TrangThai = 1;
		public static final int DaXoa = 0;
	}
	public static interface TTHC2VBBM {
		public static final int HUONG_DAN = 1;
		public static final int BIEU_MAU = 2;
	}
	public static interface MA_CAPDVHC {
		public static final String CAP_TINH = "001";
		public static final String CAP_HUYEN = "002";
		public static final String CAP_XA = "003";	
		public static final String TP_TW = "004";
		public static final String CAP_QUAN = "005";
		public static final String CAP_PHUONG = "006";
		public static final String CAP_THI_TRAN = "007";		
		
	}
	
	public static interface TypeSelect {
		public static final int CAP_TINH = 1;
		public static final int CAP_HUYEN =2;
		public static final int CAP_XA = 3;	
		
	}

}
