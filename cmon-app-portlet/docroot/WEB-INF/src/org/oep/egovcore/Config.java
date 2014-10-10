package org.oep.egovcore;

import java.io.IOException;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Vector;

import org.oep.egovcore.language.Messager;


/**
 * This is class Config  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class Config extends Messager {

	public Config(String prefix) {
		super(prefix);
	}
	
	public static String getRootKey(String key) {
		return key.split("\\" + SEP)[0];
	}
	
	/**
	 * This is function getKeys  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return Enumration<String>
	 */
	public Enumeration<String> getKeys() {
		Enumeration<String> keys = _bundle.getKeys();
		Vector<String> vector = new Vector<String>();
		String[] arr;
		StringBuilder bdr;
		for (Enumeration<String> e = keys; keys.hasMoreElements();) {
			arr = e.nextElement().split("\\" + SEP);
			if (arr.length > 1 && arr[0].equals(_prefix)) {
				bdr = new StringBuilder();
				for (int i = 1; i < arr.length; ++ i) {
					bdr.append(arr[i]).append(SEP);
				}
				bdr.deleteCharAt(bdr.length() - 1);
				vector.add(bdr.toString());
			}
		}
		return vector.elements();
	}
	
	@Override
	public String get(String key) {
		return _bundle.getString(createKey(_prefix, key));
	}

	@Override
	public String sub(String key, Object... args) {
		return substitute(get(key), args);
	}

	@Override
	public String getEN(String key) {
		return _bundle.getString(createKey(_prefix, key));
	}

	@Override
	public String subEN(String key, Object... args) {
		return substitute(get(key), args);
	}
	
	public static Config forClass(Class<?> cls) {
		return new Config(cls.getSimpleName());
	}
	
	private static ResourceBundle _bundle;
	static {
		 try {
			 _bundle = new PropertyResourceBundle(Config.class.getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
