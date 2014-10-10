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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	
	<div class="egov-info-success" style='width:700px;margin-top:0px;margin-left:0px'>
		
		<label class ="egov-label-bold">
			Thông tin chi tiết về bạn chưa có trong hệ thống của chúng tôi!
			<br/>
			<%
			 	PortletURL inputDetailUrl = renderResponse.createRenderURL();            
				inputDetailUrl.setParameter("jspPage","/html/portlet/userreg/input_detail.jsp");
			%>
			Bạn hãy <a href = "<%=inputDetailUrl%>"><input type="button" class="egov-button" name="cancel"  id="cancel" value="Bấm vào đây" 	/></a> để nhập thông tin chi tiết về mình.
			<br>
			Mọi thông tin đăng ký của bạn sẽ được bảo mật tuyệt đối, được bảo đảm bởi chính sách bảo mật thông tin của chính quyền thành phố Đà Nẵng.
			</label>	
	</div>
	
