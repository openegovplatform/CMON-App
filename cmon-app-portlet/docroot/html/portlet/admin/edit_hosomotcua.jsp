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
<%@page import="org.oep.exch.dao.hoso.service.HoSoMotCuaLocalServiceUtil"%>
<%@page import="org.oep.exch.dao.hoso.model.HoSoMotCua"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
</script>
<%
	PortletURL actionUrl = renderResponse.createActionURL();
	
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "editHoSoMotCua");
	
	long id = ParamUtil.getLong(request, "id");
	
	HoSoMotCua hoSo = HoSoMotCuaLocalServiceUtil.getHoSoMotCua(id);
	
%>
<div class="egov-container">
	<br/>		
	<form id="inputForm" name="inputForm" method="post" action="<%=actionUrl%>">
	 	 <table class = "egov-table-form2" width = "50%">

			<tr>
		        <td>Mã loại hồ sơ</td>
		        <td><input name="maLoaiHoSo"  value = "<%=hoSo.getMaLoaiHoSo() %>" size = "8" class = "egov-inputfield custom" type="text" maxlength="15" /></td>
		      </tr>
		      <tr>
		        <td align = "left">Mã số hồ sơ</td>
		        <td><input name="maSoHoSo"  value = "<%=hoSo.getMaSoHoSo() %>" size = "15" class = "egov-inputfield custom" type="text"  maxlength="13" /></td>
		      </tr>
	
		      
		      <tr>
		        <td>Mã đơn vị tiếp nhận</td>
		        <td><input name="maDonViTiepNhan"  value = "<%=hoSo.getMaDonViTiepNhan() %>" size = "8" class = "egov-inputfield custom" type="text"  maxlength="15" /></td>
		      </tr>	 
		      
		      <tr>
		        <td>Ngày nộp hồ sơ</td>
		        <td><input name="ngayNopHoSo"  value = "<%=hoSo.getNgayNopHoSo() %>" size = "15" class = "egov-calendar custom" type="text" maxlength="10" /></td>
		      </tr>	
		        
		      <tr>
		        <td>Ngày hẹn trả</td>
		        <td><input name="ngayHenTra"  value = "<%=hoSo.getNgayHenTra() %>"  size = "15" class = "egov-calendar custom" type="text" maxlength="10" /></td>
		      </tr>	
		      
		      <tr>
		        <td>Họ và tên người nộp</td>
		        <td><input name="hoTenNguoiNop"  value = "<%=hoSo.getHoTenNguoiNop()%>" size = "40" class = "egov-inputfield custom" type="text" maxlength="90" /></td>
		      </tr>	
		      
			  <tr>
		        <td>Số chứng minh nhân dân</td>
		        <td><input name="soCmnd"  value = "<%=hoSo.getSoCmnd()%>" size = "15" class = "egov-inputfield custom" type="text" maxlength="15" /></td>
		      </tr>		      
		        		          
		      <tr>
		        <td>Ngày sinh</td>
		        <td><input name="ngaySinh"  value = "<%=hoSo.getNgaySinh()%>" size = "15" class = "egov-calendar custom" type="text"  maxlength="10" /></td>
		      </tr>	
		      
			  <tr>
		        <td>Mã tỉnh thường trú</td>
		        <td><input name="maTinhThuongTru"  value = "<%=hoSo.getMaTinhThuongTru()%>" size = "8" class = "egov-inputfield custom" type="text"  maxlength="2" /></td>
		      </tr>	      		      
		      
			  <tr>
		        <td>Mô tả địa chỉ thường trú</td>
		        <td><input name="moTaDiaChiThuongTru"  value = "<%=hoSo.getMoTaDiaChiThuongTru()%>" size = "60" class = "egov-inputfield custom" type="text" maxlength="200" /></td>
		      </tr>	
		      
			  <tr>
		        <td>Giới tính</td>
		        <td>
		        	<select name="gioiTinh" id="gioiTinh" class = "egov-select custom" >		        	
		        		<%
		        			String[] gioiTinhArr = {"Nam", "Nữ", "Không rõ ràng"};
		        		
		        			int gioiTinh = hoSo.getGioiTinh();
		        			
		        			String selected = "";
		        			
		        			for (int i = 0; i < gioiTinhArr.length; i ++) {
		        				if ( i==gioiTinh ) {
		        					selected = "selected";
		        				} else {
		        					selected = "";
		        				}
		        		
		        		%>
		        		
		        		<option value = "<%=i%>" <%=selected %>><%= gioiTinhArr[i]%></option>
		     			
		     			<%
		        			}
		     			%>	        		
		        	</select>
		        </td>
		      </tr>			      		      
		      
			 <tr>
		        <td>Mã người tiếp nhận</td>
		        <td><input name="maNguoiTiepNhan"  value = "<%=hoSo.getMaNguoiTiepNhan()%>"  size = "8" class = "egov-inputfield custom" type="text" maxlength="20" /></td>
		     </tr>
		     
			 <tr>
		        <td>Tên người tiếp nhận</td>
		        <td><input name="tenNguoiTiepNhan"  value = "<%=hoSo.getTenNguoiTiepNhan()%>" size = "40" class = "egov-inputfield custom" type="text" maxlength="30" /></td>
		     </tr>
		     
		     <tr>
		        <td>Trạng thái xử lý</td>
		        <td>
		        	<select name="trangThaiXuLy" id="trangThaiXuLy" class = "egov-select custom" >
						<%
		        			String[] trangThaiArr = {"Chưa xử lý", "Đã xử lý thành công", "Dữ liệu có lỗi"};
		        		
		        			int trangThai = hoSo.getTrangThaiXuLy();
		        			
		        			for (int i = 0; i < trangThaiArr.length; i ++) {
		        				if ( i==trangThai ) {
		        					selected = "selected";
		        				} else {
		        					selected = "";
		        				}
		        		
		        		%>
		        		
		        		<option value = "<%=i%>" <%=selected %>><%= trangThaiArr[i]%></option>
		     			
		     			<%
		        			}
		     			%>
        		
		        	</select>
		        </td>
		      </tr>	
		 
		      <tr>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		      </tr>
		      <tr>
		        <td>&nbsp;</td>
		        <td>
		        <%
		        	PortletURL backUrl = renderResponse.createRenderURL();
		        	backUrl.setParameter("jspPage", "/html/portlet/admin/exch_data_monitor.jsp");
		        %>
		        <a href = "<%=backUrl %>"><input type="button" class = "egov-button-normal" name="button1" value="Quay lại" /></a>
		        <input type="submit" class = "egov-button-normal" name="button" id="button" value="Cập nhật dữ liệu" /></td>
		      </tr>
		        <%
			  		PortletURL redirectUrl = renderResponse.createRenderURL();
			  		redirectUrl.setParameter("jspPage", "/html/portlet/admin/exch_data_monitor.jsp");
			  		redirectUrl.setParameter("refresh", "1");
	 			%>
  				<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl%>"/>
  				<input type = "hidden" name = "id" value = "<%=hoSo.getId()%>"/>
		</table>
	 </form>
</div>
<script>
	this.document.inputForm.maLoaiHoSo.focus();
</script>

