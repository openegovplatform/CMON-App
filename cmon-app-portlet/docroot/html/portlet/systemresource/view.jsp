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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/portlet/init.jsp" %>

<portlet:defineObjects />

<portlet:actionURL var="linkTest" name="rolePage">
</portlet:actionURL>
<form action="<%=linkTest.toString()%>" method="post">
	<input type="text" readonly="readonly" value="<%=themeDisplay.getLayout().getGroup().getGroupId() %>" name="groupId">
	<input  type="submit" value="Page-> Tai nguyen">
</form>
