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
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


<style>
	.cssTable th 
	{
	    text-align:center; 	    
	}
	.searchForm
	{
		margin-bottom: 10pt;
		margin-top: 20pt;
	}
	.searchType{
		margin-left: 10pt;
	}
</style>

<%
	
%>

<div class="egov-container">
	<div id="dialog_chonLoaiDoiTuong"  title="Chọn loại đối tượng" style="display: none;">
		<form>
			<table style="height: 130pt;" class="egov-table">
				<tr>
					<td  colspan="3">
						<select name="doiTuongDialog" class="egov-select" >
								<option value="0">Lọc theo đối tượng</option>
								<option value="1">Doanh nghiệp</option>
								<option value="2">Hộ cá thể</option>
								<option value="3">Hợp tác xã</option>
						</select>	
					</td>
				</tr>
				
				<tr>
					<td colspan="3" style="padding: 10px !important">
						<input type="submit" class="egov-button" id="Them" value="Chọn">
					   	<input type="button" class="egov-button" id="Dong" value="Đóng">
				      	
					</td>
				</tr>
			
			</table>
		</form>
	</div>
	<p class="egov-p-20">
		Quản lý tài khoản Doanh nghiệp /Hộ cá thể /Hợp tác xã
	</p>
	<form name="searchForm" class="searchForm" method="post" action="" >
		<table class="egov-table-form" >
			<tbody>
				<tr>
					<td colspan="6">
						<label class="egov-label-bold" >Nhập mã giấy phép / Email / Tên :</label>
					</td>
				</tr>
				<tr>
					<td colspan="3"> 
						<div class="left" style="width: 75%;">	
							<input style="width: 95%;" name="inputText" id="inputText" type="text" size="25" maxlength="150"
							class="egov-inputfield custom" value="" />
						</div>
						<div>
							<input style="width: 20%;" type="submit" value="Tìm kiếm"
						class="egov-button-search" />
						</div>
					</td>
					<td colspan="3"> 
						<div class="left" style="width: 35%;">	
							<select name="doiTuongType" class="egov-select" >
								<option value="0">Lọc theo đối tượng</option>
								<option value="1">Doanh nghiệp</option>
								<option value="2">Hộ cá thể</option>
								<option value="3">Hợp tác xã</option>
							</select>						
						</div>
						<div class="left searchType" style="width: 35%;">
							<select  name="trangThaiType" class="egov-select" >
								<option  value="0">Lọc theo trạng thái</option>
								<option  value="1">Có tài khoản </option>
								<option  value="2">Không có tài khoản</option>
							</select>
						</div>
						<div>
							<input style="float: right;" type="button" id="addNewQL" class="egov-button" value="Thêm mới"/>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<%-- <input type="hidden" name="dt" value="<%=doituong%>">  --%>
	</form>
	<form name="resultForm">
		<table class="egov-table cssTable" >
			<tbody>
				<tr>
					<th>STT</th>
					<th>Mã giấy phép</th>					
					<th>Email</th>
					<th>Tên</th>
					<th>Địa chỉ</th>
					<th>Đối tượng</th>
					<th>Trạng thái</th>
					<th>Hành động</th>
				</tr>
				
			</tbody>
		</table>
		<%-- <%
			if (searchContainer != null) {
		%>
		<div id="pagination">
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
		<%
			}
		%>
		<br />
		<table style="margin-bottom: 20pt;" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td align="center"><input name="selectId" type="button"
					value="Chọn" class="egov-button-normal" onclick="getSelectedId()" />
				</td>
			</tr>
		</table> --%>
		<input type="hidden" name="selectedMaHoSo" />
	</form>
</div>
<script type="text/javascript">
//dialog  properties
$('#dialog_chonLoaiDoiTuong').dialog({
	width: 400,
    height: 250,
    autoOpen: false,
    show: 'slide',
    hide: 'slide',
    /* buttons: { 'Close': function() { $(this).dialog('close'); } }, */
    closeOnEscape: true,
    resizable: false
});
// dialog open/close
$('#addNewQL').click(function() {
    if ($('#dialog_chonLoaiDoiTuong').dialog('isOpen') == true)
        $('#dialog_chonLoaiDoiTuong').dialog('close');
    else
        $('#dialog_chonLoaiDoiTuong').dialog('open');
    return false;
});

$('#Dong').click(function() {
	 $('#dialog_chonLoaiDoiTuong').dialog('close'); 
});

</script>





