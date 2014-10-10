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

import java.util.List;



import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

/** 
 * This is class OrganizationLiferayUtils
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class OrganizationLiferayUtils {
		private static Log _log = LogFactoryUtil.getLog(OrganizationLiferayUtils.class);
	
		/** 
		 * This is function getOrganization
		 * 
		 * Version: 1.0
		 *  
		 * History: 
		 *   DATE        AUTHOR      DESCRIPTION 
		 *  ------------------------------------------------- 
		 *  10-April-2013  Nam Dinh    Create new
		 * @param companyId
		 * @param name
		 * @return Organization
		 */
		public static Organization getOrganization(long companyId,String name){
			if(name == null || name.trim().length()==0)return null;
			List<Organization> oList = null;
			try {
				oList = OrganizationLocalServiceUtil.getOrganizations(0, 90000);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(oList != null && oList.size()>0){
				for (Organization organization : oList) {
					_log.info("\n.==:"+organization.getName());
					if(organization.getName().toLowerCase().equals(name.toLowerCase())){
						return organization;
					}
				}
			}else{
				_log.info("not found by name:"+name);
				return null;
				
			}
			return null;
			
		}

}
