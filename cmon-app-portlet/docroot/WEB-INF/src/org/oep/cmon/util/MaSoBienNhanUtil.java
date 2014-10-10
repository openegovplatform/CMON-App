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

package org.oep.cmon.util;

import org.oep.egovcore.language.CmonMessagerUtil;
import org.oep.egovcore.language.Messager;

import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.masobiennhan.KetQua;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

/** 
 * This is class MaSoBienNhanUtil
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class MaSoBienNhanUtil {
	
	public static final String USERNAME = "capmasobiennhan";
	public static final String PASSWORD = "eb7efe9997711c24be9e625092a6adf0";
	private static Log _log = LogFactoryUtil.getLog(MaSoBienNhanUtil.class);
	
	/** 
	 * This is function get
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param maDonVi
	 * @param maTTHC
	 * @param isOnline
	 * @throws SystemException
	 * @return String
	 */
	public static String get(String maDonVi, String maTTHC, boolean isOnline) throws SystemException {
		String out = StringPool.BLANK;
		KetQua msbnResult = null;
		int attempt = 0;
		
		_log.info("======THONG TIN GOI WS MA SO BIEN NHAN : madonvi="+maDonVi+",matthc="+maTTHC);
		
		while (((msbnResult == null) || (msbnResult.getMaloi() != 0)) && (attempt ++) < 5) {
			_log.info(new StringBuilder("GOI WS GET MA SO BIEN NHAN LAN ").append(attempt).toString());
			msbnResult = _get(maDonVi, maTTHC, isOnline);
		}
		
		if (msbnResult.getMaloi() == 0) {
			out = msbnResult.getMabiennhan();
		} else {
			throw new SystemException(CmonMessagerUtil.sub(
				"message.masobiennhan.error"
				, msbnResult.getMaloi()
				, msbnResult.getMota()
			));
		}
		return out;
	}
	
	/** 
	 * This is function _get
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param maDonVi
	 * @param maTTHC
	 * @param isOnline
	 * @return KetQua
	 */
	private static KetQua _get(String maDonVi, String maTTHC, boolean isOnline) {
		KetQua result = null;
		Messager msger = CmonMessagerUtil.forPrefix("message.masobiennhan");
		try {
			vn.dtt.sharedservice.masobiennhan.MaBienNhanImplPortType ws = WebserviceFactory.getCapMaSoBienNhanService();
			String token = ws.getToken(USERNAME, PASSWORD, maDonVi);
			result = ws.getMaBienNhan(token, maDonVi, maTTHC, isOnline);
		} catch (javax.xml.ws.WebServiceException e) {
			result = new KetQua();
			result.setMaloi(8);
		}

		int maLoi = result.getMaloi();
		switch (maLoi) {
			case 1:
				result.setMota(msger.sub("_1_user_pass_ko_hop_le", maDonVi, maTTHC));
				break;
			case 2:
				result.setMota(msger.sub("_2_token_ko_hop_le", maDonVi, maTTHC));
				break;
			case 3:
				result.setMota(msger.sub("_3_ma_don_vi_ko_hop_le", maDonVi, maTTHC));
				break;
			case 4:
				result.setMota(msger.sub("_4_ma_thu_tuc_ko_hop_le", maDonVi, maTTHC));
				break;
			case 5:
				result.setMota(msger.sub("_5_ip_bi_khoa", maDonVi, maTTHC));
				break;
			case 6:
				result.setMota(msger.sub("_6_he_thong_bi_timeout", maDonVi, maTTHC));
				break;
			case 7:
				result.setMota(msger.sub("_7_ma_da_day", maDonVi, maTTHC));
				break;
			default:
				result.setMota(msger.sub("_8_loi_goi_ws", ThamSoLocalServiceUtil.getValue("DOMAIN") + "/capmasobiennhan/services/MaBienNhanImplPort?wsdl"));
		}
		
		return result;
	}
}
