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

package org.oep.cmon.admin.portlet.util;

import java.security.MessageDigest;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/** 
 * This is class EncryptionUtil
 * 
 * This class is used to encrypt/decrypt a string
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  1-April-2013  Nam Dinh    Create new
 */
public class EncryptionUtil {
	/** Password encryption secret key*/
	private static final String ENCRYPTION_SECRET_KEY = "DNG-DNG-67";

	/** Password encryption algorithm */ 
	private static final String ENCRYPTION_ALGORITHM = "AES";

	/** Secret key spec used to generate secret key */
	private static SecretKeySpec secretKeySpec;

	/**
	 * This is function turns array of bytes into string
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param buf[]
	 * @return String
	 */
	private static String asHexStr(byte buf[]) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		int i;
	
		for (i = 0; i < buf.length; i++) {
			if (((int) buf[i] & 0xff) < 0x10)
				strbuf.append("0");
			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}
		return strbuf.toString();
	}

	/**
	 * This is function convert a string to an array of bytes
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param s
	 * @return byte[]
	 */
	private static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    
	    return data;
	}	

	/**
	 * This is function get secret key specs
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param encryptKey
	 * @return SecretKeySpec
	 * @throws Exception
	 */
	private static SecretKeySpec getSecretKeySpec(String encryptKey) throws Exception {
		// 8-byte Salt - SHOULD NOT BE DISCLOSED
		// alternative approach is to have the salt passed from the
		// calling class (pass-the-salt)?
		byte[] salt = { (byte) 0xA9, (byte) 0x87, (byte) 0xC8, (byte) 0x32,
				(byte) 0x56, (byte) 0xA5, (byte) 0xE3, (byte) 0xB2 };
	
		// Iteration count
		int iterationCount = 1024;
	
		KeySpec keySpec = new PBEKeySpec(encryptKey.toCharArray(), salt,
				iterationCount);
	
		SecretKey secretKey = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
				.generateSecret(keySpec);
	
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(secretKey.getEncoded());
		md.update(salt);
		for (int i = 1; i < iterationCount; i++)
			md.update(md.digest());
	
		byte[] keyBytes = md.digest();
		SecretKeySpec skeyspec = new SecretKeySpec(keyBytes, ENCRYPTION_ALGORITHM);
	
		return skeyspec;
	}	

	/**
	 * This is function encrypt a string
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param message
	 * @return String
	 * @throws Exception
	 */
	public static String encrypt(String message)
			throws Exception {
		
		// Convert input message to byte array
		byte[] messages = message.getBytes();
		
		// init mySecretKeySpec if it is not initialized
		if (secretKeySpec == null)
			secretKeySpec = getSecretKeySpec(ENCRYPTION_SECRET_KEY);
		
		// create cipher object
		Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		
		// Do encryption
		byte[] encrypted = cipher.doFinal(messages);
		
		// Return hexString of encrypted message
		return asHexStr(encrypted);
	}

	/**
	 * This is function decrypt a message
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param message
	 * @return String
	 * @throws Exception
	 */
	public static String decrypt(String message)
			throws Exception {
		
		// init secret
		if (secretKeySpec == null)
			secretKeySpec = getSecretKeySpec(ENCRYPTION_SECRET_KEY);
		
		// Create cipher object
		Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		
		// convert hexEncryptedString to byte array
		byte[] messages = hexStringToByteArray(message);
		
		// Do decryption
		byte[] decrypted = cipher.doFinal(messages);
		
		// Convert decrypted message to hexString
		String hexString = asHexStr(decrypted);
		
		// Convert decrypted hex string to character string and return 
		return hexStringToCharacter(hexString);
	}

	/**
	 * This is function convert from hex string to character string
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hexString
	 * @return String
	 */
	private static String hexStringToCharacter(String hexString) {
		
		if (hexString == null) return null;
		
		StringBuffer chacterString = new StringBuffer();
		int chacterLength = hexString.length();
		StringBuffer buf;
		for (int i = 0; i < chacterLength; i = i+2) {
			buf = new StringBuffer();
			buf.append(hexString.charAt(i)).append(hexString.charAt(i+1));
			chacterString.append((char) Long.parseLong(buf.toString(), 16));
		}
		return chacterString.toString();
	}
}
