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
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	function openWindow(url) {
		var newWindow = window.open(url,'Search popup','height=350,width=700,left=90,top=100,resizable=yes,location=no,status=no,menubar=no,verticalbar=yes');

		if (window.focus) {
			newWindow.focus();
		}

		return false;
	} 
</script>

<div class="wd-main-content">
 	 <a href="javascript:history.go(-1)">>> Quay lại</a>
 	 <br/>
 	 <table width="100%" border="0">
	 	<tr>
        	<td></td>
      	</tr>
	 		<tr>
	 			<td>
	 				<liferay-ui:error key="vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.childExists" message = "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.childExists"/>
	 				<liferay-ui:error key="vn.dtt.cmon.admin.form.err.unKnown" message = "vn.dtt.cmon.admin.form.err.unKnown"/>
	 																			
	 			</td>
	 		</tr>		   
	</table>
</div>


