package org.oep.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/** 
 * This is class ConfigUtils
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class ConfigUtils {
	public static final String EGOV_APPLICATION_IPMS = "egov.application.ipms";
	public static final String EGOV_IPMS_PROFILE_ID = "egov.application.ipms.profile.id";
	public static final String NOT_FOUND = "notFound";
	
	/** 
	 * This is function getValue
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param key
	 * @return String
	 */
	public static String getValue(String key) {
		Properties prop = new Properties();
		try {
			InputStream is = ConfigUtils.class
					.getResourceAsStream("/ipms_config.properties");
			// InputStream is =
			// ClassLoader.getSystemResourceAsStream("config.properties");
			prop.load(is);
			is.close();
			return prop.getProperty(key);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	/** 
	 * This is function getKey
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param listKey
	 * @param listThamSoMaTTHC
	 * @param maTTHC
	 * @return String
	 */
	public static String getKey(List<String> listKey, List<String> listThamSoMaTTHC, String maTTHC) {
		String out = NOT_FOUND;
		int size = listThamSoMaTTHC.size();
		maTTHC = maTTHC.trim();
		for (int k = 0; k < size; ++ k) {
			if (maTTHC.equals(listThamSoMaTTHC.get(k).trim())) {
				out = listKey.get(k);
				break;
			}
		}
		return out;
	}
	
	/**
	 * Get jsp da duoc config khi goi tu` draft hoac preview
	 * @author hoangtrung.nguyen
	 * @param keyPrefix eg: vn.dtt.csms.form.
	 * @param tthcId
	 * @return
	 * @throws SystemException 
	 * @throws PortalException 
	 */
//	public static String getJSP(String keyPrefix, long tthcId) throws Exception {
//		List<String> listKey = getListKey(keyPrefix);
//		//List<String> listThamSoMaTTHC = WebserviceFactory.getThamSoService().getValues(listKey);
////		List<String> listThamSoMaTTHC = ThamSoLocalServiceUtil.getValues(listKey);
//		//String key = getKey(
//			listKey,
//		//	listThamSoMaTTHC, 
//		ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(tthcId).getMa()
//		);
//		return getValue(keyPrefix + key, NOT_FOUND);
//	}
	
	/** 
	 * This is function getListKey
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param key
	 * @return List<String>
	 */
	public static List<String> getListKey(String key) {
		List<String> result = new ArrayList<String>();
		Properties prop = new Properties();
		try {
			Thread.currentThread()
					.getContextClassLoader();
			InputStream is = ConfigUtils.class
					.getResourceAsStream("/ipms_config.properties");
			// InputStream is =
			// ClassLoader.getSystemResourceAsStream("config.properties");
			prop.load(is);

			is.close();
			Enumeration<Object> keys = prop.keys();
			int k =0;
			while (keys.hasMoreElements()) {
				String value = (String) keys.nextElement();
				if (value != null && value.contains(key)) {
					//int index = value.indexOf(key);
					value = value.substring(key.length());
					result.add(k,value);
					k= k +1;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	/** 
	 * This is function getValue
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param key
	 * @param defaultValue
	 * @return String
	 */
	public static String getValue(String key, String defaultValue) {
		Properties prop = new Properties();
		try {
			Thread.currentThread()
					.getContextClassLoader();
			InputStream is = ConfigUtils.class
					.getResourceAsStream("/ipms_config.properties");
			// InputStream is =
			// ClassLoader.getSystemResourceAsStream("config.properties");
			prop.load(is);

			is.close();
			String value = prop.getProperty(key);
			if (value != null) {
				return value;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return defaultValue;
	}

	/** 
	 * This is function maxlength
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param key
	 * @return int
	 */
	public int maxlength(String key) {
		Properties prop = new Properties();
		try {
			Thread.currentThread()
					.getContextClassLoader();
			InputStream is = ConfigUtils.class
					.getResourceAsStream("/maxlength.properties");
			// InputStream is =
			// ClassLoader.getSystemResourceAsStream("config.properties");
			prop.load(is);
			is.close();
			return Integer.valueOf(prop.getProperty(key));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1000;
	}

}
