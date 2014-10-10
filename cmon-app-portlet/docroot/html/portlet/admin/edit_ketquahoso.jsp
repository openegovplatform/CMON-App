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
<%@page import="org.oep.exch.dao.hoso.service.KetQuaHosoLocalServiceUtil"%>
<%@page import="org.oep.exch.dao.hoso.model.KetQuaHoso"%>
<%@page import="java.util.HashMap"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
</script>
<%
	PortletURL actionUrl = renderResponse.createActionURL();
	
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "editKetQuaHoSo");
	
	long id = ParamUtil.getLong(request, "id");
	
	HashMap<String, String> props = (HashMap<String, String>)renderRequest.getPortletSession().getAttribute("KETQUAHOSO_REQUEST_OBJ");
	if ( props == null ) {	
		KetQuaHoso ketQuaHoSo = KetQuaHosoLocalServiceUtil.getKetQuaHoso(id);
		
		props = new HashMap<String, String>();
		
		props.put("id", ketQuaHoSo.getId() + "");
		
		props.put("maSoHoSo", ketQuaHoSo.getMaSoHoSo());
		
		props.put("tenNguoiNhanKetQua", ketQuaHoSo.getTenNguoiNhanKetQua());
		
		props.put("ngayNhanKetQua", ketQuaHoSo.getNgayNhanKetQua());
		
		props.put("lePhiHoSo", ketQuaHoSo.getLePhiHoSo() + "");
		
		props.put("phiXuLyHoSo", ketQuaHoSo.getPhiXuLyHoSo() + "");
		
		props.put("ngayHoanThanh", ketQuaHoSo.getNgayHoanThanh());
		
		props.put("maCanBoTraKetQua", ketQuaHoSo.getMaCanBoTraKetQua());
		
		props.put("tenCanBoTraKetQua", ketQuaHoSo.getTenCanBoTraKetQua());
		
		props.put("trangThaiXuLy", ketQuaHoSo.getTrangThaiXuLy() + "");		
	}	
	
%>
<div class="egov-container">
	<br/>		
	<form id="inputForm" name="inputForm" method="post" action="<%=actionUrl%>">
	 	 <table class = "egov-table-form2" width = "50%">
			<tr>
				<td colspan = "2">
					<liferay-ui:error key="err.onlineId" message = "Online ID không phải là giá trị số"/>
					<liferay-ui:error key="err.ngayGioLuanChuyen" message = "Ngày giờ luân chuyển không đúng"/>
					<liferay-ui:error key="err.soGioThucHien" message = "Số giờ thực hiện không phải là giá trị số"/>
					<liferay-ui:error key="err.soGioYeuCauXuLy" message = "Số giờ yêu cầu xử lý không phải là giá trị số"/>
					<liferay-ui:error key="err.trangThaiHienTai" message = "Bạn chưa chọn trạng thái hồ sơ hiện tại"/>
					<liferay-ui:error key="err.trangThaiKeTiep" message = "Bạn chưa chọn trạng thái hồ sơ kế tiếp"/>
					<liferay-ui:error key="err.trangThaiXuLy" message = "Bạn chưa chọn trạng thái xử lý"/>
				
				</td>
			</tr>
		      <tr>
		        <td align = "left">Mã số hồ sơ</td>
		        <td><input name="maSoHoSo"  value = "<%=props.get("maSoHoSo") %>" size = "15" class = "egov-inputfield custom" type="text"  maxlength="13" /></td>
		      </tr>
		      
		      <tr>
		        <td>Tên người nhận kết quả</td>
		        <td><input name="tenNguoiNhanKetQua"  value = "<%=props.get("tenNguoiNhanKetQua")%>" size = "30" class = "egov-inputfield custom" type="text" maxlength="90" /></td>
		     </tr>
		        
		      <tr>
		        <td>Ngày nhận kết quả</td>
		        <td><input name="ngayNhanKetQua"  value = "<%=props.get("ngayNhanKetQua") %>"  size = "15" class = "egov-calendar custom" type="text" maxlength="10" /></td>
		      </tr>	
		      
		      <tr>
		        <td>Lệ phí hồ sơ</td>
		        <td><input name="lePhiHoSo"  value = "<%=props.get("lePhiHoSo")%>"  size = "15" class = "egov-inputfield custom" type="text" maxlength="9" /></td>
		     </tr>
			 
			 <tr>
		        <td>Phí xử lý hồ sơ</td>
		        <td><input name="phiXuLyHoSo"  value = "<%=props.get("phiXuLyHoSo")%>"  size = "15" class = "egov-inputfield custom" type="text" maxlength="9" /></td>
		     </tr>
		     
	      	<tr>
		        <td>Ngày hoàn thành</td>
		        <td><input name="ngayHoanThanh"  value = "<%=props.get("ngayHoanThanh") %>"  size = "15" class = "egov-calendar custom" type="text" maxlength="10" /></td>
		      </tr>
		      
		     <tr>
		        <td>Mã cán bộ trả kết quả</td>
		        <td><input name="maCanBoTraKetQua"  value = "<%=props.get("maCanBoTraKetQua")%>"  size = "8" class = "egov-inputfield custom" type="text" maxlength="20" /></td>
		     </tr>
		     
			 <tr>
		        <td>Tên cán bộ trả kết quả</td>
		        <td><input name="tenCanBoTraKetQua"  value = "<%=props.get("tenCanBoTraKetQua")%>" size = "30" class = "egov-inputfield custom" type="text" maxlength="30" /></td>
		     </tr>
		     <tr>
		        <td>Trạng thái xử lý</td>
		        <td>
		        	<select name="trangThaiXuLy" id="trangThaiXuLy" class = "egov-select custom" >
						<%
		        			String[] trangThaiArr = {"Chưa xử lý", "Đã xử lý thành công", "Dữ liệu có lỗi"};
		        		
		        			int trangThai = Integer.parseInt(props.get("trangThaiXuLy"));
		        			
		        			String selected = null;
		        			
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
			  		PortletURL successUrl = renderResponse.createRenderURL();
		        	successUrl.setParameter("jspPage", "/html/portlet/admin/exch_data_monitor.jsp");
		        	successUrl.setParameter("refresh", "1");
		        	
		        	// Redirect URL
					PortletURL redirectUrl = renderResponse.createRenderURL();
					redirectUrl.setParameter("jspPage", "/html/portlet/admin/edit_ketquahoso.jsp");
		        	
	 			%>
  				<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl%>"/>
  				<input type = "hidden" name = "successUrl" value = "<%=successUrl%>"/>
  				<input type = "hidden" name = "id" value = "<%=props.get("id")%>"/>
		</table>
	 </form>
</div>
<script>
	this.document.inputForm.maSoHoSo.focus();
</script>

