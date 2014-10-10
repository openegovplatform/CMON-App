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
<%@ include file="/html/portlet/endorse/init.jsp" %>
<%@page import="org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function submitDocument(){		
		var fileName = document.getElementById("file").value;	

		if (fileName != '') {
			var ext = fileName.split('.').pop().toLowerCase();

			if ( !(ext == 'gif' || ext == 'png' || ext == 'jpg' || ext == 'jpeg') ){

			    alert('File ảnh không đúng định dạng, vui lòng chọn file khác.');

			    return;
			}

			// Submit document
			document.uploadForm.submit();	
		}		
	}

	function disableForm(theform) {
		for (var i = 0; i < theform.length; i++) {
			theform.elements[i].disabled = true;
		}
	}
</script>
<body>
<%
	// Create image upload URL
	PortletURL uploadUrl = renderResponse.createActionURL();
	uploadUrl.setParameter( ActionRequest.ACTION_NAME, "uploadAvatar");
	
	int status = ParamUtil.getInteger(request, "status");
%>
	<form name = "uploadForm" action = "<%=uploadUrl %>" method="post" enctype="multipart/form-data">
		<table width="40%" border="0">
	        <tr>
		          <td scope="col" align = "center">
		          <% 
		          	boolean avatarExist = false;
		          	byte[] img = (byte[])renderRequest.getPortletSession().getAttribute("PROFILE_PIC");
		          	
		          	if ( img != null && img.length > 0) {		          
		          		avatarExist = true;
		          	}
		          	
		          	if ( !avatarExist) { %>
						<img src="<%=request.getContextPath() %>/images/profile-img.jpg" alt="" width="160" height="160" />
				   <%} else {
						PortletURL getAvatarUrl = renderResponse.createActionURL();
						getAvatarUrl.setParameter( ActionRequest.ACTION_NAME, "getAvatar");%>
						
						<img src="<%=getAvatarUrl%>" alt="" width="160" height="160" />															
					<%} %>		    
		         </td>
	        </tr>
	        <tr>
	          <td align = "center"><span class="egov-uploadfile">
							<input  type="file" onchange = "submitDocument()" name = "file" id = "file" /> 
							</span></td>
	        </tr>
		</table>
	</form>
	   	<%
		      		
		      		if ( status == 2) {		      		
		      %>
		      <script type="text/javascript">
		      	disableForm(document.uploadForm);
		      </script>
		      <%
		      		}
		      %>
</body>

