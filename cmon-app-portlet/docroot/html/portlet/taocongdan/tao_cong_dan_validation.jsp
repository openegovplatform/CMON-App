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
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <table cellspacing="0" cellpadding="0" class="egov-table-form" width="100%">
	  	<tr>
	  		<td colspan = "6">
		  		<select style="display: none;"	id="egov-form-errors" >
		  			<option value="email">
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.email" message = "vn.dtt.taocongdan.form.err.email"/>
					</option>	
					<option value="email">
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.emailTontai" message = "Tài khoản này đã tồn tại, vui lòng nhập tài khoản khác"/>
					</option>
					<option value="matKhau">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.matKhau" message = "vn.dtt.taocongdan.form.err.matKhau"/>
					</option>	
					<option value="captcha">	
						<liferay-ui:error key="vn.dtt.taocongdan.forms.err.captcha" message = "vn.dtt.taocongdan.forms.err.captcha"/>
					</option>
					<option value="ho">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.ho" message = "vn.dtt.taocongdan.form.err.ho"/>
					</option>	
					<option value="dem">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.dem" message = "vn.dtt.taocongdan.form.err.dem"/>
					</option>	
					<option value="ten">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.ten" message = "vn.dtt.taocongdan.form.err.ten"/>
					</option>	
					<option value="ngaySinh">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.ngaySinh" message = "vn.dtt.taocongdan.form.err.ngaySinh"/>
					</option>	
					<option value="soCmnd">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.soCmnd" message = "vn.dtt.taocongdan.form.err.soCmnd"/>
					</option>	
					
					<option value=ngayCapCmnd>	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.ngayCapCmnd" message = "Bạn chưa chọn ngày cấp CMND "/>
					</option>
					<option value="gioiTinh">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.gioiTinh" message = "vn.dtt.taocongdan.form..err.gioiTinh"/>
					</option>
					<option value="reMatKhau">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.matKhau.KhongGiong" message = "Bạn nhập sai mật khẩu"/>
					</option>	
					
					<option value="email">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.email.daCo" message = "vn.dtt.taocongdan.form.err.email.daCo"/>
					</option>
					<option value="email">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.email.khongDungDinhDang" message = "vn.dtt.taocongdan.form.err.email.khongDungDinhDang"/>	
					</option>	
					<option value="soCmnd">				
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.soCmnd.daCo" message = "vn.dtt.taocongdan.form.err.soCmnd.daCo"/>
					</option>	
					
					<option value="noiCapCmndId">				
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.noiCapCmndId" message = "Bạn chưa chọn nơi cấp cmnd"/>
					</option>	
					
					<option value="quocTichId">				
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.quocTichId" message = "Bạn chưa chọn quốc tịch"/>
					</option>
					<option value="diaChiThuongTruTinhId">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.diaChiThuongTruTinhId" message = "vn.dtt.taocongdan.form.err.diaChiThuongTruTinhId"/>
					</option>	
					<option value="diaChiThuongTruHuyenId">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.diaChiThuongTruHuyenId" message = "vn.dtt.taocongdan.form.err.diaChiThuongTruHuyenId"/>
					</option>	
					<option value="diaChiThuongTruXaId">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.diaChiThuongTruXaId" message = "vn.dtt.taocongdan.form.err.diaChiThuongTruXaId"/>
					</option>	
					<option value="diaChiThuongTru">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.diaChiThuongTru" message = "vn.dtt.taocongdan.form.err.diaChiThuongTru"/>
					</option>	
					<option value="soCmnd">	
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.soCmnd.9or12" message = "vn.dtt.taocongdan.form.err.soCmnd.9or12"/>	
					</option>	
					<option value="matKhau">				
						<liferay-ui:error key="vn.dtt.taocongdan.form.err.matKhau.KhongGiong" message = "vn.dtt.taocongdan.form.err.matKhau.KhongGiong"/>
					</option>	
						
				</select>
			</td>	
		</tr>
		<tr>
			<td colspan = "6">
				<liferay-ui:error key="vn.dtt.taocongdan.forms.err.Error.TTKND" message = "vn.dtt.taocongdan.forms.err.Error.TTKND"/>
				<liferay-ui:error key="vn.dtt.taocongdan.forms.err.isNotCreatedUserLiferay" message = "vn.dtt.taocongdan.forms.err.isNotCreatedUserLiferay"/>
				<liferay-ui:error key="vn.dtt.taocongdan.forms.err.isNotCreatedUserTKND" message = "vn.dtt.taocongdan.forms.err.isNotCreatedUserTKND"/>
				<liferay-ui:error key="vn.dtt.taocongdan.form.err.congDandatontai" message = "<font color='red'>Công dân này đã tồn tại trong CSDL dân cư </font>"/>
				<liferay-ui:success key="success" message="vn.dtt.taocongdan.form.err.successful" />
				<liferay-ui:success key="successAddTKND" message = "Thêm mới tài khoản người dùng thành công"/>
				<liferay-ui:success key="successAddTKCD" message = "Thêm mới công dân thành công"/>	
				<liferay-ui:success key="successEditTKCD" message = "Update thông tin công dân thành công"/>
				<liferay-ui:error key="vn.dtt.taocongdan.forms.err.unKnown" message = "vn.dtt.taocongdan.forms.err.unKnown"/>
				<liferay-ui:error key="failseAddTKCD" message = "<font color='red'> Không tạo được tài khoản công dân </font>"/>
			</td>
		</tr>
	</table>			