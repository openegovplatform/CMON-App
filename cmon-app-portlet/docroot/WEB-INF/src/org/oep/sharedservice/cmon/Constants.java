package org.oep.sharedservice.cmon;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {
	//public static String PORTAL_URL = Constants.getValue("vn.dtt.cmon.domain");
	public static int DELETED=1;
	public static int ACTIVATED=0;
	
	
		public static final int DOCUMENT_NEW =0;
		public static final int DOCUMENT_APPROVED =1;
		public static final int DOCUMENT_REJECTED =-1;
		public static final int DOCUMENT_TEMP_DELETED =-2;
		
		public static final String UPLOAD_FILE_TYPE ="FILE_TYPE";
		public static final String UPLOAD_LIMITSIZE ="LIMITSIZE";
		public static final String UPLOAD_DOCUMENT_NOTFOUND_GIAYTO ="UPLOAD_DOCUMENT_NOTFOUND_GIAYTO";
		public static final String UPLOAD_DOCUMENT_TYPE_NOT_FOUND ="DOCUMENT_TYPE_NOT_FOUND";
		public static final String UPLOAD_DOCUMENT_NOTFOUND_ACCOUNT_BY_USER ="UPLOAD_DOCUMENT_NOTFOUND_ACCOUNT_BY_USER";
		public static final String UPLOAD_DOCUMENT_NOTFOUND_APPLICATION_CODE ="UPLOAD_DOCUMENT_NOTFOUND_APPLICATION_CODE";
		public static final String UPLOAD_DOCUMENT_NOTFOUND_HOSO_ID ="UPLOAD_DOCUMENT_NOTFOUND_HOSO_ID";
		public static final String UPLOAD_FOLDER_NOT_FOUND ="FOLDER_NOT_FOUND";
		public static final String UPLOAD_USER_NOT_FOUND ="USER_NOT_FOUND";
		public static final String UPLOAD_SYSTEM ="SYSTEM";
		public static final String UPLOAD_MYFOLDER_NOT_CREATED ="MYFOLDER_NOT_CREATED";
		
		public static final String UPLOAD_FILE_USED ="USED";
		public static final String UPLOAD_FILE_APPROVED ="APPROVED";
		public static final String UPLOAD_OK ="OK";
		public static final int UPLOAD_TYPE_HOSO =0;
		public static final int UPLOAD_TYPE_OTHER =1;
		public static final String UPLOAD_TYPE_ERROR ="UPLOAD_TYPE_ERROR";
		
		
	public static interface STEP{	
		public static final int STEP1 =1;
		public static final int STEP2 =2;
		public static final int STEP3 =3;
	}
	
	public static interface ACTION{	
		public static final int CREATE_NEW =0;
		public static final int TEMP_DELETED =1;
		public static final int RESTORED =2;
		public static final int DELETED =3;
	}
	
	public static interface ThamSo{
		public static final String CMON_DOCUMENT_FOLDER_ID="CMON_DOCUMENT_FOLDER_ID";
		public static final String CMON_DOCUMENT_USER_ADMIN_ID="CMON_DOCUMENT_USER_ADMIN_ID";
		public static final String DOMAIN="DOMAIN";
	}
	
	/*
	public static String getValue(String key){
		Properties prop = new Properties();
		try {
			
			//prop.load(ResourceUtils.class.getResourceAsStream("config.properties"));
			//InputStream is = ConfigUtils.class.getResourceAsStream("brms_config.properties");
			//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream is =  Constants.class.getResourceAsStream("/config.properties");
			//InputStream is =  ClassLoader.getSystemResourceAsStream("config.properties");
			prop.load(is);
			is.close();
			return prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getValue(String key,String defaultValue){
		String value = getValue(key);
		if(value != null) return value;
		return defaultValue;
	}*/
	

}
