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
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type = "text/javascript">
	function getSelectedId() {
		var radios = document.getElementsByName("chucVu");

		var value = "";
		
	    for (var i = 0; i < radios.length; i++) {       
	        if (radios[i].checked) {
	        	value = radios[i].value;
	            break;
	        }
	    }

	    if (value == "") {
			alert ("Bạn cần phải chọn một vai trò");
			return false;
		} else {
			 if (document.getElementById('vaiTroThem').value.trim().length == 0) {
				 document.getElementById('vaiTroThemCheck').value = value;
			 } else {
			    document.getElementById('vaiTroThemCheck').value = document.getElementById('vaiTroThem').value.trim() + "-" + value;
			 }
			 return true;
		}
	}
</script>
<%
	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchPopUpVaiTroChoCanBoAjax");
	
	// Get search keyword
	String keyWord = ParamUtil.getString(request, "keyWord");
	String chucVuID = ParamUtil.getString(request, "chucVuID").trim();
	String vaiTroThem = ParamUtil.getString(request, "vaiTroThem").trim();
	String coQuanQuanLy = ParamUtil.getString(request, "coQuanQuanLy").trim();
	
	
	String _ma = ParamUtil.getString(request, "ma");
	String _hoVaTen = ParamUtil.getString(request, "hoVaTen");
	String _ngaySinh = ParamUtil.getString(request, "ngaySinh");
	String _gioiTinh = ParamUtil.getString(request, "gioiTinh");
	String _chucVu = ParamUtil.getString(request, "chucVu");
	String _soCmnd = ParamUtil.getString(request, "soCmnd");
	String _noiCapCmnd = ParamUtil.getString(request, "noiCapCmnd");
	String _ngayCapCmnd = ParamUtil.getString(request, "ngayCapCmnd");
	String _taiKhoanNguoiDung = ParamUtil.getString(request, "taiKhoanNguoiDung");
	%>
	<portlet:actionURL var="addRoleUrl" name="addRoleCongChucRieng">
		<portlet:param name="jspPage" value="/html/portlet/admin/init.jsp"/>
	</portlet:actionURL>

	<div class="wd-main-content">
	<br/>		
	<form name = "searchForm" method = "post">
		<table border="0" width="100%">
		  <tr>
		    <td align = "left">
		    	<input name="keyWord" id="keyWord" type="text" size = "30" maxlength="150" class = "egov-inputfield custom" value = "<%=keyWord%>"/>
		    	<input type="button" value=""  class="egov-button-search" onclick="javascript: findVaiTroSelect();"/>
		    	<input type = "hidden" name = "popup" value = "1" />		
		    	<input id="chucVuID" name="chucVuID" type="hidden" value="<%=chucVuID %>"/>  
		    	<input id="coQuanQuanLy" name="coQuanQuanLy" type="hidden" value="<%=coQuanQuanLy %>"/>
		    	<input id="vaiTroThem" name="vaiTroThem" type="hidden" value="<%=vaiTroThem %>"/>
				<input id="ma" name="ma" type="hidden" value="<%=_ma %>"/>
				<input id="hoVaTen" name="hoVaTen" type="hidden" value="<%=_hoVaTen %>"/>
				<input id="ngaySinh" name="ngaySinh" type="hidden" value="<%=_ngaySinh %>"/>
				<input id="gioiTinh" name="gioiTinh" type="hidden" value="<%=_gioiTinh %>"/>
				<input id="chucVu" name="chucVu" type="hidden" value="<%=_chucVu %>"/>
				<input id="soCmnd" name="soCmnd" type="hidden" value="<%=_soCmnd %>"/>
				<input id="ngayCapCmnd" name="ngayCapCmnd" type="hidden" value="<%=_ngayCapCmnd %>"/>
				<input id="noiCapCmnd" name="noiCapCmnd" type="hidden" value="<%=_noiCapCmnd %>"/>
				<input id="taiKhoanNguoiDung" name="taiKhoanNguoiDung" type="hidden" value="<%=_taiKhoanNguoiDung %>"/>		    			    	
		    </td>
		    <td align = "right">					    
		    </td>
		  </tr>
		</table>
	</form>
	<form name = "resultForm" method="post" action="<%=addRoleUrl %>" onsubmit="getSelectedId();">	
		<table class="egov-table" width="100%" id="myTable">
			<tr>
	    		<th width = "8%">TT</th>
			    <th  width = "20%">Vai trò</th>
			    <th width = "8%">Chức năng</th>

		</tr>
		</table>
		<br/>
		<input id="vaiTroThemCheck" name="vaiTroThemCheck" type="hidden" value=""/>  		
		<input id="_ma" name="_ma" type="hidden" value="<%=_ma %>"/>
		<input id="_hoVaTen" name="_hoVaTen" type="hidden" value="<%=_hoVaTen %>"/>
		<input id="_ngaySinh" name="_ngaySinh" type="hidden" value="<%=_ngaySinh %>"/>
		<input id="_gioiTinh" name="_gioiTinh" type="hidden" value="<%=_gioiTinh %>"/>
		<input id="_coQuanQuanLy" name="_coQuanQuanLy" type="hidden" value="<%=coQuanQuanLy %>"/>
		<input id="_chucVu" name="_chucVu" type="hidden" value="<%=_chucVu %>"/>
		<input id="_soCmnd" name="_soCmnd" type="hidden" value="<%=_soCmnd %>"/>
		<input id="_ngayCapCmnd" name="_ngayCapCmnd" type="hidden" value="<%=_ngayCapCmnd %>"/>
		<input id="_noiCapCmnd" name="_noiCapCmnd" type="hidden" value="<%=_noiCapCmnd %>"/>
		<input id="_taiKhoanNguoiDung" name="_taiKhoanNguoiDung" type="hidden" value="<%=_taiKhoanNguoiDung %>"/>
		<table>
			<tr>
			    <td align = "center"><input name = "selectId" type = "submit" value = "Chọn" class = "egov-button-normal"/></td>			   
			</tr>
		</table>
	</form>
</div>


<script type="text/javascript">	
	function findVaiTroSelect() {
		var keyWord = document.getElementById('keyWord').value;
		if(keyWord == null) keyWord="";
		
			var chucVuID = document.getElementById('chucVuID').value;
			var vaiTroThem = document.getElementById('vaiTroThem').value;
			var coQuanQuanLy = document.getElementById('coQuanQuanLy').value;
			$.ajax({
				type: 'POST'
				,url: '<%=searchUrl.toString()%>'
				,data : {chucVuID: chucVuID, keyWord: keyWord, vaiTroThem: vaiTroThem, coQuanQuanLy: coQuanQuanLy}
				,success: function(data) {		
		
					// preferred
					var data2 = JSON.parse(data);
					var index = 1;
					var table=document.getElementById("myTable");
					// Xoa cac phan tu cu.
					while (table.rows.length > 1) {
						table.deleteRow(table.rows.length - 1);
					}

					// Insert cac ban ghi moi
					for (var i = 0; i < data2.id.length; i++) {
						var row1=table.insertRow(table.rows.length);
						var cell1=row1.insertCell(0);
						var cell2=row1.insertCell(1);
						var cell3=row1.insertCell(2);
						cell1.innerHTML="" + (index++);
						cell2.innerHTML="" + data2.name[i];
						cell3.innerHTML="<input type=\"radio\" name=\"chucVu\" id=\"chucVu\" value=\"" + data2.id[i] + "\" />";
					}
				}
			});
		
	}
</script>