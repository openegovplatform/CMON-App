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
<%@page import="org.apache.commons.lang.exception.ExceptionUtils"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.egovcore.language.CmonMessagerUtil"%>

<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/core.css"/>
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/customEgovTheme.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/core.js"></script>
<% String errMsg = CmonMessagerUtil.sub("message.error", 
	ExceptionUtils.getRootCauseMessage((Throwable) request.getAttribute("exception"))); %>
<script type="text/javascript">
	$error( '<%= errMsg %>' );
</script>