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


    <tr class="vonDieuLe">
				<td colspan="4">
					<label class="egov-label-bold" >Vốn điều lệ </label><label class="egov-label-red">(*)</label><br/>
					<input type="text" class="egov-inputfield"/>
				</td>
				<td colspan="2">
					
				</td>
	</tr>
	
	<tr class="showHideLoaiSoHuu">
				<td colspan="6">
					<table>
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
						        	name="loaiSoHuu"
						        	value="0"
						        	checked="checked"
						        />
						        <label class="egov-label-bold" for="CMND">Cá nhân </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        
						        <input class="egov-radio"
						        	id="toChuc"
						        	type="radio"
						        	name="loaiSoHuu"
						        	value="1"
						        />
						        <label for="Khac">Tổ chức</label>
							</td>
						</tr>
						<!-- Start Loai so huu la To chuc -->
						<tr class="toChuc_LoaiSoHuu">
							<td colspan="6">
								<table>
									<tr>
										<td colspan="6">
											<label class="egov-label-bold" >Tên chủ sở hữu </label><label class='egov-label-red'>(*)</label><br/>
											<input readonly="readonly" class="egov-inputfield" style="width: 80% !important"/>
											<input type="button" value="Tìm kiếm" onclick="openWindow('<%=popupAddMem%>')"  class="egov-button-search"/>
										</td>
									</tr>
									<tr class="showHideCMND_CP">
											<td colspan="2">
												<label class="egov-label-bold" >Mã giấy phép </label><label class='egov-label-red'>(*)</label><br/>
												<input type="text" class="egov-inputfield"/>
											</td>
											<td colspan="2">
												<label class="egov-label-bold" >Nơi cấp </label><label class='egov-label-red'>(*)</label><br/>
												<input readonly="readonly" class="egov-calendar" />	
											</td>
											<td colspan="2">
												<label class="egov-label-bold" >Ngày cấp </label><label class='egov-label-red'>(*)</label><br/>
												<input type="text" class="egov-inputfield"/>
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
						        	name="CMND_LoaiSH"
						        	value="0"
						        	checked="checked"
						        />
						        <label class="egov-label-bold" for="CMND">CMND</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        <input class="egov-radio"
						        	id="Khac"
						        	type="radio"
						        	name="CMND_LoaiSH"
						        	value="1"
						        />
						        <label for="Khac">Khác</label>
							</td>
						</tr>
						
						<tr class="showHideCMND_CP">
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
						
						<tr class="showHideKhac_CP">
							<td colspan="3">
								<label class="egov-label-bold" >Tên giấy tờ chứng thức cá nhân </label><label class="egov-label-red">(*)</label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
							<td colspan="3">
								<label class="egov-label-bold" >Số giấy tờ chứng thức cá nhân</label><label class="egov-label-red">(*)</label><br/>
								<input type="text" class="egov-inputfield"/>
							</td>
						</tr>
						
						<tr class="showHideKhac_CP">
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