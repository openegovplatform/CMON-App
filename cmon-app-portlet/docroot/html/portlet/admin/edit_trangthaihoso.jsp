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
<%@page import="java.util.HashMap"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo"%>
<%@page import="org.oep.exch.dao.hoso.service.TrangThaiHosoLocalServiceUtil"%>
<%@page import="org.oep.exch.dao.hoso.model.TrangThaiHoso"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
</script>
<%
	PortletURL actionUrl = renderResponse.createActionURL();
	
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "editTrangThaiHoSo");

	long id = ParamUtil.getLong(request, "id");

	HashMap<String, String> props = (HashMap<String, String>)renderRequest.getPortletSession().getAttribute("TRANGTHAIHOSO_REQUEST_OBJ");
	if ( props == null ) {	
		TrangThaiHoso trangThaiHoSo = TrangThaiHosoLocalServiceUtil.getTrangThaiHoso(id);
		
		props = new HashMap<String, String>();
		
		props.put("id", trangThaiHoSo.getId() + "");
		
		props.put("onlineId", trangThaiHoSo.getOnlineId() + "");
		
		props.put("maSoHoSo", trangThaiHoSo.getMaSoHoSo());
		
		props.put("ngayHenTra", trangThaiHoSo.getNgayHenTra());
		
		props.put("maNguoiXuLyHienTai", trangThaiHoSo.getMaNguoiXuLyHienTai());
		
		props.put("tenNguoiXuLyHienTai", trangThaiHoSo.getTenNguoiXuLyHienTai());
		
		props.put("tenPhongBanXuLyHienTai", trangThaiHoSo.getTenPhongBanXuLyHienTai());
		
		props.put("ngayGioLuanChuyen", trangThaiHoSo.getNgayGioLuanChuyen());
		
		props.put("soGioThucHien", trangThaiHoSo.getSoGioThucHien() + "");
		
		props.put("maNguoiXuLyKeTiep", trangThaiHoSo.getMaNguoiXuLyKeTiep());
		
		props.put("tenNguoiXuLyKeTiep", trangThaiHoSo.getTenNguoiXuLyKeTiep());
		
		props.put("tenPhongBanXuLyKeTiep", trangThaiHoSo.getTenPhongBanXuLyKeTiep());
		
		props.put("soGioYeuCauXuLy", trangThaiHoSo.getSoGioYeuCauXuLy() + "");		
		
		props.put("noiDungYeuCauXuLy", trangThaiHoSo.getNoiDungYeuCauXuLy());
		
		props.put("trangThaiKeTiep", trangThaiHoSo.getTrangThaiKeTiep() + "");
		
		props.put("trangThaiHienTai", trangThaiHoSo.getTrangThaiHienTai() + "");
		
		props.put("trangThaiXuLy", trangThaiHoSo.getTrangThaiXuLy() + "");		
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
		        <td>Online ID</td>
		        <td><input name="onlineId"  value = "<%=props.get("onlineId") %>" size = "15" class = "egov-inputfield custom" type="text" maxlength="15" /></td>
		      </tr>
		      <tr>
		        <td align = "left">Mã số hồ sơ</td>
		        <td><input name="maSoHoSo"  value = "<%=props.get("maSoHoSo") %>" size = "15" class = "egov-inputfield custom" type="text"  maxlength="13" /></td>
		      </tr>
		        
		      <tr>
		        <td>Ngày hẹn trả</td>
		        <td><input name="ngayHenTra"  value = "<%=props.get("ngayHenTra") %>"  size = "15" class = "egov-calendar custom" type="text" maxlength="10" /></td>
		      </tr>	
		      
		      <tr>
		        <td>Mã người xử lý hiện tại</td>
		        <td><input name="maNguoiXuLyHienTai"  value = "<%=props.get("maNguoiXuLyHienTai")%>"  size = "8" class = "egov-inputfield custom" type="text" maxlength="20" /></td>
		     </tr>
		     
			 <tr>
		        <td>Tên người xử lý hiện tại</td>
		        <td><input name="tenNguoiXuLyHienTai"  value = "<%=props.get("tenNguoiXuLyHienTai")%>" size = "30" class = "egov-inputfield custom" type="text" maxlength="30" /></td>
		     </tr>
		     
		     <tr>
		        <td>Tên phòng ban xử lý hiện tại</td>
		        <td><input name="tenPhongBanXuLyHienTai"  value = "<%=props.get("tenPhongBanXuLyHienTai")%>" size = "50" class = "egov-inputfield custom" type="text" maxlength="50" /></td>
		     </tr>		      
		      
		     <tr>
		        <td>Ngày giờ luân chuyển</td>
		        <td><input name="ngayGioLuanChuyen"  value = "<%=props.get("ngayGioLuanChuyen")%>" size = "20" class = "egov-inputfield custom" type="text" maxlength="19" /></td>
		     </tr>
	 		 <tr>
		        <td>Số giờ thực hiện</td>
		        <td><input name="soGioThucHien"  value = "<%=props.get("soGioThucHien")%>" size = "4" class = "egov-inputfield custom" type="text" maxlength="4" /></td>
		     </tr>
		     
		     <tr>
		        <td>Trạng thái hồ sơ hiện tại</td>
		        <td>
		        <%
		        	List<TrangThaiHoSo> trangThaiLst = TrangThaiHoSoLocalServiceUtil.findAll();
		        	long status = Long.parseLong(props.get("trangThaiHienTai"));
		        	String selected = "";
		        %>
		        <select name="trangThaiHienTai" id="trangThaiHienTai" class = "egov-select custom" >
		        	<option value = "-1">-- Chọn -- </option>
		        	<% for (TrangThaiHoSo th: trangThaiLst )  {
		        		if (status == th.getId() ) {
		        			selected = "selected";
		        		} else {
		        			selected = "";
		        		}
		        	%>
		        	
		        		<option value = "<%=th.getId() %>" <%=selected %>><%=th.getTrangThai() %></option>
		        	<%} %>		        
		        </select>
		        </td>
		     </tr>
		     			     
		     
		      <tr>
		        <td>Mã người xử lý kế tiếp</td>
		        <td><input name="maNguoiXuLyKeTiep"  value = "<%=props.get("maNguoiXuLyKeTiep")%>"  size = "8" class = "egov-inputfield custom" type="text" maxlength="20" /></td>
		     </tr>
		     
			 <tr>
		        <td>Tên người xử lý kế tiếp</td>
		        <td><input name="tenNguoiXuLyKeTiep"  value = "<%=props.get("tenNguoiXuLyKeTiep")%>" size = "30" class = "egov-inputfield custom" type="text" maxlength="30" /></td>
		     </tr>
		     
		     <tr>
		        <td>Tên phòng ban xử lý kế tiếp</td>
		        <td><input name="tenPhongBanXuLyKeTiep"  value = "<%=props.get("tenPhongBanXuLyKeTiep")%>" size = "50" class = "egov-inputfield custom" type="text" maxlength="50" /></td>
		     </tr>	
		     
			 <tr>
		        <td>Số giờ yêu cầu xử lý</td>
		        <td><input name="soGioYeuCauXuLy"  value = "<%=props.get("soGioYeuCauXuLy")%>" size = "4" class = "egov-inputfield custom" type="text" maxlength="4" /></td>
		     </tr>	
		 	 <tr>
		        <td>Nội dung yêu cầu xử lý</td>
		        <td><input name="noiDungYeuCauXuLy"  value = "<%=props.get("noiDungYeuCauXuLy")%>" size = "80" class = "egov-inputfield custom" type="text" maxlength="300" /></td>
		     </tr>	
		     
		     <tr>
		        <td>Trạng thái hồ sơ kế tiếp</td>
		        <td>
			         <%
			        	status = Long.parseLong(props.get("trangThaiKeTiep"));
			        %>
			        <select name="trangThaiKeTiep" id="trangThaiKeTiep" class = "egov-select custom" >
			        	<option value = "-1">-- Chọn -- </option>
			        	<% for (TrangThaiHoSo th: trangThaiLst )  {
			        		if (status == th.getId() ) {
			        			selected = "selected";
			        		} else {
			        			selected = "";
			        		}
			        	%>
			        	
			        		<option value = "<%=th.getId() %>" <%=selected %>><%=th.getTrangThai() %></option>
			        	<%} %>		        
			        </select>		        
		        </td>
		     </tr>	 

		     <tr>
		        <td>Trạng thái xử lý</td>
		        <td>
		        	<select name="trangThaiXuLy" id="trangThaiXuLy" class = "egov-select custom" >
						<%
		        			String[] trangThaiArr = {"Chưa xử lý", "Đã xử lý thành công", "Dữ liệu có lỗi"};
		        		
		        			int trangThai = Integer.parseInt(props.get("trangThaiXuLy"));
		        			
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
					redirectUrl.setParameter("jspPage", "/html/portlet/admin/edit_trangthaihoso.jsp");
		        	
	 			%>
  				<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl%>"/>
  				<input type = "hidden" name = "successUrl" value = "<%=successUrl%>"/>
  				<input type = "hidden" name = "id" value = "<%=props.get("id")%>"/>
		</table>
	 </form>
</div>
<script>
	this.document.inputForm.onlineId.focus();
</script>

