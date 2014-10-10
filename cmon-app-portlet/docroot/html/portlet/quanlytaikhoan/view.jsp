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
<%@ include file="/html/portlet/init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--Test new function  -->

<%			PortletURL url1   = renderResponse.createRenderURL();	
			PortletURL url2  = renderResponse.createRenderURL();
			
			url1.setParameter("jspPage","/html/portlet/quanlydoanhnghiep/DoanhNghiep.jsp");
			String backUrl1 =url1.toString();;
			
			url2.setParameter("jspPage","/html/portlet/quanlydoanhnghiep/viewQuanLyTaiKhoanDN.jsp");
			String backUrl2 =url2.toString();;
			
			
	      	%>
<button class="egov-button" type="button" onclick="location.href='<%=backUrl1%>'"></button> 

<button class="egov-button" type="button" onclick="location.href='<%=backUrl2%>'">Quản lý DN/HCT</button>
<!--End Test new function  -->