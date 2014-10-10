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
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<html>
<style>
.egov-table tr:hover{
	background: #fff !important;
}
.egov-table tr td{
	border:none !important;
	padding: 0px 10px !important;	
}
</style>	
<div class="egov-container">
<form method="post" name="frmXacThucHoCaTheMotThanhVien" id="frmXacThucHoCaTheMotThanhVien">
	<table class="egov-table" width="100%">
		<thead>
			<tr>
				<td colspan="6">
					<h3>Xác thực tài khoản Doanh nghiệp</h3>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="6">
					<select style="display: none;" id="egov-form-errors">
			      		<option value='<portlet:namespace/>ten'><liferay-ui:error key="error_name_required" message = "vn.dtt.cmon.admin.portlet.cqql.err.empty.ten"/></option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="width: 60% !important">
					<label class="egov-label-bold" >Loại doanh nghiệp</label>
					<select class="egov-select" >
						<option>Doanh nghiệp tư nhân</option>
					</select>
				</td>
				<td colspan="2" style="width: 30% !important"></td>
			</tr>
			<tr>
				<td colspan="4">
					<label class="egov-label-bold" >Email </label><label class="egov-label-note" > (Tài khoản đăng nhập) </label><label class='egov-label-red'>(*)</label>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="4"  style="width: 60% !important">
					<div class="left" style="width: 30%;margin-top: 10pt;">	
						<label class='egov-label-red'>Thông tin doanh nghiệp</label>
					</div>
					<div class="left fi20">
						<input type="button" style="width: 100% !important;float: right;margin-top: 10pt;" value="Tìm kiếm doanh nghiệp" class="egov-button-search normal"/>
					</div>
				</td>
				<td colspan="2" style="width: 20% !important"></td>
			</tr>
			
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Tên tiếng việt </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="4">
					<label class="egov-label-bold" >Tên nước ngoài (nếu có) </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Tên viết tắt </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Địa chỉ trụ sở chính </label>					
				</td>
			</tr>
			<tr>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>Thành phố Đà Nẵng</option>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2" style="width: 30% !important" >
					<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
			</tr>
			
			<tr>
				<td colspan="6" >
					<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="width: 45% !important">
					<label class="egov-label-bold" >Điện thoại </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3" style="width: 45% !important">
					<label class="egov-label-bold" >Fax </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Email </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Website </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<label class='egov-label-bold'>Mã số thuế </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Mã giấy phép </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày cấp </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-calendar" />
				</td>
			</tr>
			
			<tr>
				<td colspan="6" style="padding: 0px !important">
					<table class="egov-table" width="100%" border="0">
						<tbody>
							<tr>
								<td width="40%">
									<label class="egov-label-bold" >Ngành nghề kinh doanh</label><br/>
									<select name="" id="select-system-id" class="egov-multi-select" multiple="multiple" size="11">
										<option>abc</option>
										<option>cde</option>
									</select>
										<!-- du lieu cache du lieu nguon -->
									<select id="select-data-system" name="" style="display:none;">
										<option>abc</option>
										<option>cde</option>
									</select>
									<div>
					   					<input id="input-search-nganh-nghe" style="width: 70% !important" type="text" class="egov-inputfield"  onkeyup="searchOptions(this.value,'select-data-system','select-system-id','select-selected-id');" />
					   					<input type="button" value="reset" class="egov-button" onclick="resetSearchNganhNghe();" >
					   				</div>
								</td>
								<td width="10%" style="text-align: center !important">
									<input type="button" class="egov-func-select" value=">>" 
									onclick="moveOptions('select-system-id','select-selected-id');">
									<br><br>
									<input  type="button" class="egov-func-select" value="<<" 
									onclick="moveOptions('select-selected-id','select-system-id');">
								</td>
								<td width="40%">
									<label class="egov-label-bold" >Ngành nghề được chọn </label><label class='egov-label-red'>(*)</label><br/>
									<select name="" id="select-selected-id" multiple="multiple" class="egov-multi-select" size="13">
									</select>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Vốn đầu tư </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Vốn pháp định </label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Tên chi nhánh </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Địa chỉ chi nhánh </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Tên văn phòng đại diện </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Địa chỉ văn phòng đại diện </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Tên địa điểm kinh doanh </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Địa chỉ địa điểm kinh doanh </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
					<label class='egov-label-red'>Thông tin chủ doanh nghiệp</label>
				</td>
			</tr>
			
			<tr>
				<td colspan="4">
					<label class="egov-label-bold" >Họ và tên </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-inputfield" style="width: 80% !important"/>
					<input type="button" value="Tìm kiếm" class="egov-button-search"/>
				</td>
				<td colspan="2" >
					<label class="egov-label-bold" >Ngày sinh </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-calendar" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Giới tính </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Quốc tịch </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Dân tộc </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>				
			</tr>
			
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Giấy chứng thực cá nhân </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <input class="egov-radio"
			        	id="CMND" 
			        	type="radio"
			        	name="CMND"
			        	value="1"
			        />
			        <label class="egov-label-bold" for="CMND">CMND</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <input class="egov-radio"
			        	id="Khac"
			        	type="radio"
			        	name="CMND"
			        	value="0"
			        />
			        <label for="Khac">Khác</label>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<label class="egov-label-bold" >Số CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Ngày cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-calendar" />	
				</td>
				<td colspan="2">
					<label class="egov-label-bold" >Nơi cấp CMND </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>				
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Tên giấy tờ chứng thức cá nhân </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Số giấy tờ chứng thức cá nhân</label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<label class="egov-label-bold" >Ngày cấp  </label><label class='egov-label-red'>(*)</label><br/>
					<input readonly="readonly" class="egov-calendar" />	
				</td>
				<td colspan="3">
					<label class="egov-label-bold" >Nơi cấp  </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>	
			</tr>
			
			<tr>
				<td colspan="6">
					<label class='egov-label-bold'>Địa chỉ thường trú</label>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>Thành phố Đà Nẵng</option>
					</select>	
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
					<label class='egov-label-bold'>Chỗ ở hiện tại</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label class='egov-label-bold'>Tỉnh/Thành phố </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>Thành phố Đà Nẵng</option>
					</select>	
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Quận/Huyện </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
				<td colspan="2">
					<label class='egov-label-bold'>Phường/Xã </label><label class='egov-label-red'>(*)</label><br/>
					<select class="egov-select" >
						<option>--Hãy chọn--</option>
					</select>	
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold" >Mô tả chổ ở </label><label class='egov-label-red'>(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
			</tr>	
		</tbody>
		<tfoot>
			<tr>
			<%
				PortletURL backUrl = renderResponse.createRenderURL();
			 %>
				<td colspan="6" style="padding: 10px !important">
					<input type="button" class="egov-button" id="dangKy" value="Xác thực" onClick="selectAllSelected()">
				   	<input type="button" class="egov-button" id="huydangKy" value="Hủy đăng ký">
			      	<a href="<%=backUrl%>"><input value="Quay lại danh sách"  type="button" class="egov-button-normal"/></a>
				</td>
			</tr>
		</tfoot>	
	</table>
</form>
</div>
</html>
<script type="text/javascript" >
function selectAllSelected(){
	$('#select-selected-id option').prop('selected', true);
}
function resetSearchNganhNghe(){
	$("input#input-search-nganh-nghe").val("");
	searchOptions('','select-data-system','select-system-id','select-selected-id');
}
</script>