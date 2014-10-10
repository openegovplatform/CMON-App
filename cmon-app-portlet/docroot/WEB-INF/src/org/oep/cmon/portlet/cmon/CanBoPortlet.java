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

package org.oep.cmon.portlet.cmon;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.oep.cmon.util.EgovUtil;

import org.oep.cmon.dao.cc.model.CongChuc;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class CanBoPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class CanBoPortlet extends EgovPortlet {
	
	/**
	 * This is  function doView
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 */
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		CongChuc congChuc = null;
		try {
			congChuc = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
		} catch (SystemException e) {
			throw new PortletException(e);
		}

		if (congChuc == null) {
			forward2NoAuthPage(request, response);
		} else {
			super.doView(request, response);
		}
	}
}
