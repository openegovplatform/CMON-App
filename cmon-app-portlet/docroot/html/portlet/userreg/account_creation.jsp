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
<%@ include file="/html/portlet/userreg/init.jsp" %>
<%
	String authCode = ParamUtil.getString(request, "authCode");
	
	// Create acion URL
	PortletURL actionUrl = renderResponse.createActionURL();
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "endorse");
	actionUrl.setParameter("authCode", authCode);
%>


<br/>
<div class="egov-container">	
  <table width="20%" align = "center">
  	<tr>
  		<td>
			<img src="<%=request.getContextPath() %>/images/progressbar.gif">  			
  		</td>
  	</tr>
  </table>
</div>

<script type = "text/javascript">
	window.location.href = '<%=actionUrl%>';
</script>
