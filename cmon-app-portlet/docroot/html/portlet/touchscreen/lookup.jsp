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
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:actionURL var="tracuuHosoURL" name="tracuuHoSo"/>
<%
String masohs = request.getParameter("masohs")!=null?request.getParameter("masohs"):"";
%>
<div class="content-block">
	<div class="header-block">
		<div class="title-header">
			<h4>Tra cứu trạng thái hồ sơ đã nộp</h4>
		</div>
	</div>
	<!--/header-block-->
	<div class="form-block">
		<div class="input-form">
			<div>
				<img src="<%=request.getContextPath()%>/html/portlet/touchscreen/images/highlight.png" />
				<form id="searchform" name="searchform" class="searchform" action="<%=tracuuHosoURL.toString()%>" method="post">
					<input type="text" name="masohs" id="masohs" value="<%=masohs%>" /> 
					<input type="button" id="btn-tracuu" name="search" value="Tra cứu" /> 
					<input type="button" name="reset" id="btn-reset" value="Làm lại" />
				</form>
			</div>
		</div>
		<div class="keyboard-form">
			<ul id="keyboard">
				<li class="number"><span class="s0">0</span></li>
				<li class="number"><span class="s1">1</span></li>
				<li class="number"><span class="s2">2</span></li>
				<li class="number"><span class="s3">3</span></li>
				<li class="number"><span class="s4">4</span></li>
				<li class="number"><span class="s5">5</span></li>
				<li class="number"><span class="s6">6</span></li>
				<li class="number"><span class="s7">7</span></li>
				<li class="number"><span class="s8">8</span></li>
				<li class="number"><span class="s9">9</span></li>
				<li class="number"><span class="dot">.</span></li>
				<li class="number"><span class="delete bksp">Backspace</span></li>
			</ul>
		</div>
	</div>
	<!--/container-block-->
</div>
<!--/content-block-->