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
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ include file="/html/portlet/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.egov-table tr:hover{
	background: #fff !important;
}
.egov-table tr td{
	border:none !important;
	padding: 0px 10px !important;	
}

.cssTable th 
{
	text-align:center; 	    
}
	
	
</style>	

<script type="text/javascript" >
	$(document).ready(function() {	
		//Radio khi chon Giay  chứng thực cá nhân thông tin chu so huu

		 $('input[name=CMNDLoaiCSH1TV_radio]').on('change',function() {		
		    if ($("input[name=CMNDLoaiCSH1TV_radio]:checked").val() == 1) {
		    	$('.showHideCMND_Khac_CSH1TV').fadeIn('fast');
		    	$('.showHideCMND_CSH1TV').fadeOut('fast');
		    	
		    } else {  
		    	$('.showHideCMND_Khac_CSH1TV').fadeOut('fast');	 
		    	$('.showHideCMND_CSH1TV').fadeIn('fast');
		    }
		});
		
		
		
		

		//Radio khi chon Loại chủ sở hữu Cá Nhân / Tổ Chức

		$('input[name=loaiSoHuu_radio]').on('change',function() {		
		    if ($("input[name=loaiSoHuu_radio]:checked").val() == 1) {
		    	$('.toChuc_LoaiSoHuu').fadeIn('fast');
		    	$('.caNhan_LoaiSoHuu').fadeOut('fast');
		    	
		    } else {  
		    	$('.toChuc_LoaiSoHuu').fadeOut('fast');	 
		    	$('.caNhan_LoaiSoHuu').fadeIn('fast');
		    }
		});
		
		
	});

</script>
<portlet:renderURL var="popupAddMem" 
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage"
		value="../doanhnghiep/popup_addMembers.jsp" />
</portlet:renderURL>


	<table >
		    <tr>
						<td colspan="3">
							<label class="egov-label-bold" >Vốn điều lệ </label><label class="egov-label-red">(*)</label><br/>
							<input type="text" style="width: 54%;"class="egov-inputfield"/>
						</td>
						<td colspan="3">
							
						</td>
			</tr>
			
			<tr>
						<td colspan="6" style="padding: 0px 0px !important;">
							<table >
								<!-- Start Loại Cty TNHH 1 Thanh Vien  -->
								<tr >
									<td colspan="6">
										<label class='egov-label-red'>Thông tin chủ sở hữu</label>
									</td>
								</tr>
								<tr >
									<td colspan="6">
										<label class="egov-label-bold" >Loại chủ sở hữu </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								        
								        <input class="egov-radio"
								        	id="caNhan" 
								        	type="radio"
								        	name="loaiSoHuu_radio"
								        	value="0"
								        	checked="checked"
								        />
								        <label class="egov-label-bold" for="CMND">Cá nhân </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								        
								        <input class="egov-radio"
								        	id="toChuc"
								        	type="radio"
								        	name="loaiSoHuu_radio"
								        	value="1"
								        />
								        <label for="Khac">Tổ chức</label>
									</td>
								</tr>
								<!-- Start Loai so huu la To chuc -->
								<tr class="toChuc_LoaiSoHuu" style="display: none;">
									<td colspan="6" style="padding: 0px 0px !important;">
										<table >
											<tr>
												<td colspan="6">
													<label class="egov-label-bold" >Tên chủ sở hữu </label><label class='egov-label-red'>(*)</label><br/>
													<input readonly="readonly" class="egov-inputfield" style="width: 80% !important"/>
													<input type="button" value="Tìm kiếm" onclick="openWindow('<%=popupAddMem%>')"  class="egov-button-search"/>
												</td>
											</tr>
											<tr>
													<td colspan="2">
														<label class="egov-label-bold" >Mã giấy phép </label><label class='egov-label-red'>(*)</label><br/>
														<input type="text" class="egov-inputfield"/>
													</td>
													<td colspan="2">
														<label class="egov-label-bold" >Nơi cấp </label><label class='egov-label-red'>(*)</label><br/>
														<input type="text" class="egov-inputfield"/>
													</td>
													<td colspan="2">
														<label class="egov-label-bold" >Ngày cấp </label><label class='egov-label-red'>(*)</label><br/>
														<input readonly="readonly" class="egov-calendar" />	
														
													</td>				
											</tr>
											<tr >
												<td colspan="6">
													<label class='egov-label-bold'>Địa chỉ trụ sở chính</label>
												</td>
											</tr>
								
											<tr >
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
											<tr >
												<td colspan="6">
													<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
													<input type="text" class="egov-inputfield"/>
												</td>
											</tr>
											<tr >
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
											
										</table>
									</td>
								</tr>
								<!-- End Loai so huu la To chuc -->
								
								<!-- Start Loai so huu la Ca Nhan class="caNhan_LoaiSoHuu"-->
								<tr class="caNhan_LoaiSoHuu" >
									<td colspan="6" style="padding: 0px 0px !important;">
										<table >
								
											<tr>
												<td colspan="4">
													<label class="egov-label-bold" >Tên chủ sở hữu </label><label class='egov-label-red'>(*)</label><br/>
													<input readonly="readonly" class="egov-inputfield" style="width: 80% !important"/>
													<input type="button" value="Tìm kiếm" onclick="openWindow('<%=popupAddMem%>')"  class="egov-button-search"/>
												</td>
												<td colspan="2" >
													<label class="egov-label-bold" >Ngày sinh </label><label class='egov-label-red'>(*)</label><br/>
													<input readonly="readonly" class="egov-calendar" />
												</td>
											</tr>
											
											<tr >
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
											
											<tr >
												<td colspan="6">
													<label class="egov-label-bold" >Giấy chứng thực cá nhân </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											        <input class="egov-radio"
											        	id="CMND" 
											        	type="radio"
											        	name="CMNDLoaiCSH1TV_radio"  
											        	value="0"
											        	checked="checked"
											        />
											        <label class="egov-label-bold" for="CMND">CMND</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											        <input class="egov-radio"
											        	id="Khac"
											        	type="radio"
											        	name="CMNDLoaiCSH1TV_radio"
											        	value="1"
											        />
											        <label for="Khac">Khác</label>
												</td>
											</tr>
											
											<tr class="showHideCMND_CSH1TV">
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
											
											<tr class="showHideCMND_Khac_CSH1TV" style="display: none;">
												<td colspan="3">
													<label class="egov-label-bold" >Tên giấy tờ chứng thực cá nhân </label><label class="egov-label-red">(*)</label><br/>
													<input type="text" class="egov-inputfield"/>
												</td>
												<td colspan="3">
													<label class="egov-label-bold" >Số giấy tờ chứng thực cá nhân</label><label class="egov-label-red">(*)</label><br/>
													<input type="text" class="egov-inputfield"/>
												</td>
											</tr>
											
											<tr class="showHideCMND_Khac_CSH1TV" style="display: none;">
												<td colspan="3">
													<label class="egov-label-bold" >Ngày cấp  </label><label class='egov-label-red'>(*)</label><br/>
													<input readonly="readonly" class="egov-calendar" />	
												</td>
												<td colspan="3">
													<label class="egov-label-bold" >Nơi cấp  </label><label class='egov-label-red'>(*)</label><br/>
													<input type="text" class="egov-inputfield"/>
												</td>	
											</tr>
											
											<tr >
												<td colspan="6">
													<label class='egov-label-bold'>Địa chỉ thường trú</label>
												</td>
											</tr>
											
											<tr >
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
											<tr >
												<td colspan="6">
													<label class="egov-label-bold" >Mô tả địa chỉ </label><label class='egov-label-red'>(*)</label><br/>
													<input type="text" class="egov-inputfield"/>
												</td>
											</tr>
											
											<tr >
												<td colspan="6">
													<label class='egov-label-bold'>Chỗ ở hiện tại</label>
												</td>
											</tr>
											<tr >
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
											<tr >
												<td colspan="6">
													<label class="egov-label-bold" >Mô tả chổ ở </label><label class='egov-label-red'>(*)</label><br/>
													<input type="text" class="egov-inputfield"/>
												</td>
											</tr>
											
											<tr >
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
								<!-- End Loại Cty TNHH 1 Thanh Vien  la Ca Nhan-->
							</table>
						</td>
					</tr>
					
			</table>
		</td>
	</tr>
</table>