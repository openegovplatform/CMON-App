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

package org.oep.cmon.report.portlet.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This is class Test  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class Test {

	public static void main(String[] args) throws Exception {
		List<String> listStr = new ArrayList<String>(0);
		listStr.add("String a");
		listStr.add("String b");
		List<String> listStr1 = new ArrayList<String>(0);
		listStr1.add("String a1");
		listStr1.add("String b1");
		List<String> listStr2 = new ArrayList<String>(0);
		listStr2.add("String a");
		listStr2.add("String b2");
		List<List<String>> listList = new ArrayList<List<String>>();
		listList.add(listStr);
		listList.add(listStr1);
		listList.add(listStr2);
		Map<String,List<List<String>>> map = (Map<String, List<List<String>>>) new HashMap();
		for (int i = 0; i < listList.size(); i++) {
			List<String> a = listList.get(i);
			if(!map.containsKey(a.get(0))){
				map.put(a.get(0),new ArrayList<List<String>>());
				map.get(a.get(0)).add(a);
			}else{
				map.get(a.get(0)).add(a);
			}
		}
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
		}
	}
}
