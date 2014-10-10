<!-- 
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
  -->
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.egovcore.language.CmonMessagerUtil"%>
<div class="center" style="padding: 20px 0;">
	<label class="egov-label highlight">
		<%= CmonMessagerUtil.sub("message.noauth", PortalUtil.getUserId(request)) %>
	</label>
</div>