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
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.oep.cmon.portlet.taocongdan.action.TaoCongDanPortlet"%>
<%@page import="org.oep.cmon.Constants.TaoCongDan"%>
<%@page import="org.oep.cmon.portlet.taocongdan.business.TaoCongDanBusiness"%>
<%@page import="org.oep.cmon.portlet.taocongdan.util.FormatUtil"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.cd.service.TonGiaoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.TonGiao"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.DanTocLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.DanToc"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customEgovTheme.css" type="text/css" media="screen" />	

<!-- include all parameters and variables -->
<%@ include file="/html/portlet/taocongdan/tao_cong_dan_parameter.jsp" %>

<div class="egov-container" >
<%
%>
	<form  id="<portlet:namespace/>inputForm" name="<portlet:namespace/>inputForm" method="post" action="<%=actionUrl%>">
		<input type = "hidden" name = "successUrl" value = "<%=backUrl %>" />		      
		<input type = "hidden" id="taiKhoanCongDanId" name = "taiKhoanCongDanId" value = "<%=strTaiKhoanCongDanId%>" />
		<input type = "hidden" id="congDanId" name = "congDanId" value = "<%=strCongDanId%>" />
	  	<input type = "hidden"  id="mode" name = "mode" value = "<%=mode%>"/> 	  	
		<input type = "hidden"  id="redirectUrl" name = "redirectUrl" value = "<%=redirectUrl%>"/>   
		<input type = "hidden"  id="isLoaded" name = "isLoaded" value = "<%=HtmlUtil.escape(userRequest.get("isLoaded"))%>"/>   

	  		
		<table width="100%" class="egov-table-form" >
			<tr>
				<td colspan="6">	
					<!-- include all validation -->			
					<%@ include file="/html/portlet/taocongdan/tao_cong_dan_validation.jsp" %>
				</td>
			</tr>
			<tr>
				<td width="30%" scope="col">&nbsp;</td>
				<td colspan="4" scope="col">&nbsp;</td>
			</tr>

   			<tr>
				<td colspan="6" align="center"><label class="egov-label-header"><liferay-ui:message
							key="org.oep.taocongdan.form.themCongDan" /></label>							
			</td>
			</tr>				
			<tr>
				<td colspan="4"><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.taocongdan.form.email" /></label><font color="red">(*)</font>  
					
				<%
					if (mode.equals(TaoCongDanBusiness.ADD_CONGDAN)){
				%>
				
				<input name="email"	class="egov-inputfield custom" type="text" id="email"
					 value='<%=HtmlUtil.escape(userRequest.get("email"))%>' placeholder="Nhập email của bạn vào"/>					 
					 
				<%} else {
					
					if (userRequest.get("email") !=null){
				%>
					
					<input name="email"	class="egov-inputfield custom" type="text" id="email" readonly="readonly"
					 value='<%=HtmlUtil.escape(userRequest.get("email"))%>' placeholder="Nhập email của bạn vào"/>
				<%} }%>
				</td>
				<td colspan="2" align="right"><br>
			<%if(mode.equals(TaoCongDanBusiness.ADD_CONGDAN)) { %>
				<%				
					PortletURL popupTaoCongDanUrl= renderResponse.createRenderURL();
					// This will remove header and footer in theme
					popupTaoCongDanUrl.setWindowState(LiferayWindowState.EXCLUSIVE);
					//addCongDanUrl.setParameter("action", "loadCongDan");
					popupTaoCongDanUrl.setParameter("jspPage", "/html/portlet/taocongdan/cong_dan_popup.jsp");
				%>
		
			<input type="button" name="popupCongDan" id="popupCongDan" class="egov-button-normal" 
				 onclick="javascript:showPopup('<%=popupTaoCongDanUrl.toString()%>')" 
				value="Tìm kiếm Công Dân"></td>				
			<%}else{ %>	
			<%} %>	
			</tr>
			
			<%
				if (mode.equals(TaoCongDanBusiness.ADD_CONGDAN)){
			%>
				<tr >
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.taocongdan.form.matKhau" /></label><font color="red">(*)</font><br>
					<input name="matKhau" type="password" id="matKhau" 
					maxlength="100" class="egov-inputfield custom"
					placeholder="Nhập mật khẩu"
					value="<%=HtmlUtil.escape(userRequest.get("matKhau"))%>" /></td>

				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.taocongdan.form.nhapLaiMk" /></label><font color="red">(*)</font><br>
					<input name="reMatKhau" type="password" id="reMatKhau" 
					maxlength="100" class="egov-inputfield custom"
					placeholder="Gõ lại mật khẩu"
					value="" /></td>				
					<td colspan="2"></td>
			</tr>
			
			<%} else { %>
			<tr id="password_click_changeid">
				<td colspan="3">
				Nếu bạn muốn đổi mật khẩu click <a href="#" onclick="showDoiMatKhau('password_click_changeid','show_area_change_pass');"> vào đây </a>
			</td>
			</tr>
			
			<tr style='display:none;' id="show_area_change_pass">
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.taocongdan.form.matKhau" /></label><font color="red">(*)</font><br>
					<input name="matKhau" type="password" id="matKhau" 
					maxlength="100" class="egov-inputfield custom"
					placeholder="Nhập mật khẩu"
					value="<%=HtmlUtil.escape(userRequest.get("matKhau"))%>" /></td>

				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message
							key="org.oep.taocongdan.form.nhapLaiMk" /></label><font color="red">(*)</font><br>
					<input name="reMatKhau" type="password" id="reMatKhau" 
					maxlength="100" class="egov-inputfield custom"
					placeholder="Gõ lại mật khẩu"
					value="" /></td>				
					<td colspan="2"></td>
			</tr>
			<script type="text/javascript">
				function showDoiMatKhau(id1,id2){
					var obj1=document.getElementById(id1);
					var obj2=document.getElementById(id2);
					obj1.style.display="none";
					obj2.style.display="";
					}
			</script>
			
			<%} %>
			
			<!-- bang cong dan -->
			<tr>
				<td colspan="6"><br> <label class="egov-label-bold"><liferay-ui:message
							key="org.oep.taocongdan.form.hoVaTen" /> </label><font color="red">(*)</font></td>
				<td align="right"></td>		   	
		   	
			<tr >
				
		   	</tr>	
			<tr>
				<td><input name="ho" type="text" id="ho"
					maxlength="100" class="egov-inputfield custom" size=" 20" placeholder="Họ"
					value="<%=HtmlUtil.escape(userRequest.get("ho"))%>" /></td>

				<td ><input name="dem" type="text" id="dem"
					 maxlength="100" class="egov-inputfield custom" size="20" placeholder="Đệm"
					value="<%=HtmlUtil.escape(userRequest.get("dem"))%>" /></td>
				<td ><input name="ten" type="text" id="ten"
					 maxlength="100" class="egov-inputfield custom" size="20" placeholder="Tên"
					value="<%=HtmlUtil.escape(userRequest.get("ten"))%>" /></td>

			</tr>
			<tr>
			 <td colspan="3">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.ngaySinh" /></label><font color="red">(*)</font> <br>
		     <input name="ngaySinh" title="Ngày sinh" type="text" id="ngaySinh" maxlength="10" class = "egov-calendar custom"  
		     	value = "<%=HtmlUtil.escape(userRequest.get("ngaySinh"))%>"  /></td>
		   	
		   	<td colspan="3">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.gioiTinh" /></label><font color="red">(*)</font> <br>
		     		
		       <%
		      	List <GioiTinh> gioiTinhList = GioiTinhLocalServiceUtil.findAll();
		      %>
		      <select name="gioiTinh" id="gioiTinh" class = "egov-select custom" style="width:220px; display:block;">
	     		<%
	      	   		for ( GioiTinh gioiTinh: gioiTinhList) {
	      	   			selected = "";
	      	   			if ( Validator.isNotNull(userRequest.get("gioiTinh")) && gioiTinh.getId() 
	      	   					== Long.parseLong(userRequest.get("gioiTinh")) ) {
	        				selected = "selected";
	        			} 
	        	%>
	        	<option value = "<%=gioiTinh.getId()%>" <%=selected %> ><%=gioiTinh.getTen() %></option>
	        	<%} %>
		      </select>
		      </td>
		   	</tr>
			
			<tr>
		 		<td colspan="2">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.soCmnd" /></label><font color="red">(*)</font> <br>
		     		<input name="soCmnd"  type="text" id="soCmnd" title="Số Cmnd"
					maxlength="100" class="egov-inputfield custom"
					value="<%=HtmlUtil.escape(userRequest.get("soCmnd"))%>" />
		     
		      </td>		      
		  
		      <td colspan="2">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.ngayCapCmnd" /></label><font color="red">(*)</font> <br>
		     <input name="ngayCapCmnd" type="text" id="ngayCapCmnd" maxlength="10" class = "egov-calendar custom" title="Ngày cấp Cmnd"
		      value = "<%=HtmlUtil.escape(userRequest.get("ngayCapCmnd"))%>"  />
		     </td>
		   	
		       <td colspan="2">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.noiCapCmndId" /></label><font color="red">(*)</font> <br>
		     		
		       <%
		      	List <DonViHanhChinh> lisDonViHanhChinh = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
		      %>
		      <select name="noiCapCmndId" id="noiCapCmndId" class = "egov-select custom" style="width:220px; display:block;">
		      <option  value="">-Chọn-</option>
		      
	     		<%
	      	   		for ( DonViHanhChinh donViHanhChinhSo: lisDonViHanhChinh) {
	      	   			selected = "";
	      	   			if ( Validator.isNotNull(userRequest.get("noiCapCmndId")) && donViHanhChinhSo.getId()
	      	   					== Long.parseLong(userRequest.get("noiCapCmndId")) ) {
	        				selected = "selected";
	        			} 
	        	%>
	        	<option value = "<%=donViHanhChinhSo.getId()%>" <%=selected %> >Công an <%=donViHanhChinhSo.getTen() %></option>
	        	<%} %>
		      </select>
		      </td>
		 </tr>	
		 <tr>
		<td colspan="2" ><label class ="egov-label-bold"><liferay-ui:message key="org.oep.taocongdan.form.quocTich" />
         		<font color = "red">(*)</font></label> <br>
        
      	  	<%
          	List <QuocGia> quocGiaList =  QuocGiaLocalServiceUtil.findAll();
        	 %>
           <select name="quocTichId" id="quocTichId" class = "egov-select custom" style="width:220px; display:block;">
           <option id = "chonquoctich" value = "0" selected>-Chọn quốc gia-</option>
	     		<%
	     		//String maQGDefault =  WebserviceFactory.getThamSoService().getValue(Constants.MA_QUOC_GIA);
	      	   		for ( QuocGia quocGia : quocGiaList) {
	      	   			selected = "";
	      	   			if ( Validator.isNotNull(userRequest.get("quocTichId")) && quocGia.getId() 
	      	   					== Long.parseLong(userRequest.get("quocTichId")) ) {
	        				selected = "selected";
	        			} 
	      	   			//else if(quocGia.getMa().equals(maQGDefault))
	      	   			//{
	      	   			//	selected = "selected";
	      	   			//}
	      	   			
	        	%>
	        	<option value = "<%=quocGia.getId()%>" <%=selected %> ><%=quocGia.getTen() %></option>
	        	<%} %>
		      </select>
          </td>
         
	  
		     <td colspan="2">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.danTocId" /></label><font color="red">(*)</font> <br>
		     		
		       <%
		      	List <DanToc> listDanToc = DanTocLocalServiceUtil.findAll();
		      %>
		      <select name="danTocId" id="danTocId" class = "egov-select custom" style="width:220px; display:block;">
	     		<%
	        		
	      	   		for ( DanToc danToc: listDanToc) {
	      	   			selected = "";
	      	   			if ( Validator.isNotNull(userRequest.get("danTocId")) && danToc.getId()
	      	   					== Long.parseLong(userRequest.get("danTocId")) ) {
	        				selected = "selected";
	        			} 
	        	%>
	        	<option value = "<%=danToc.getId()%>" <%=selected %> ><%=danToc.getTen() %></option>
	        	<%} %>
		      </select>
		      </td>
		       <td colspan="2">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.tonGiaoId" /></label><font color="red">(*)</font> <br>
		     	
		       <%
		      	List <TonGiao> listTonGiao = TonGiaoLocalServiceUtil.findAll();
		      %>
		      <select name="tonGiaoId" id="tonGiaoId" class = "egov-select custom" style="width:220px; display:block;">
	     		<%
	        		
	      	   		for ( TonGiao tonGiao: listTonGiao) {
	      	   			selected = "";
	      	   			if ( Validator.isNotNull(userRequest.get("tonGiaoId")) && tonGiao.getId()
	      	   					== Long.parseLong(userRequest.get("tonGiaoId")) ) {
	        				selected = "selected";
	        			} 
	        	%>
	        	<option value = "<%=tonGiao.getId()%>" <%=selected %> ><%=tonGiao.getTen() %></option>
	        	<%} %>
		      </select>
		      </td>
		 </tr>
		 
		 <!-- test -->	
		  <tr>
					<td colspan="6"><br> <label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.diaChiThuongTru" />
					</label> </td>
					
		</tr>

			<tr>
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.diaChiThuongTruTinhId" /><font color="red">(*)</font> </label></br>
				<select name="diaChiThuongTruTinhId" id="diaChiThuongTruTinhId" 
					onchange="<portlet:namespace/>_list_dvhc_huyen();"
					class="egov-select custom" style="width: 135px; display: block;"  >
					<option id = "chontinh" value = "0" selected>-Chọn-</option>
						<% 		   
      				List <DonViHanhChinh> tinhThanhLis1t = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
						long diaChiThuongTruTinhId = 0;
			      		if (Validator.isNotNull(userRequest.get("diaChiThuongTruTinhId"))) {
			      			diaChiThuongTruTinhId = FormatUtil.convertToLong(userRequest.get("diaChiThuongTruTinhId"));
			      		}
			      		
							
						for (DonViHanhChinh tinhThanh: tinhThanhLis1t) {
							selected = "";
							if ( tinhThanh.getId() == diaChiThuongTruTinhId){
								selected = "selected";
							}
						%>
							<option value="<%=tinhThanh.getId()%>" <%=selected %>><%=tinhThanh.getTen()%></option>
								
					 <%	} // for
					%>		</td>
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.diaChiThuongTruHuyenId" /> <font color="red">(*)</font></label></br>
					<select name="diaChiThuongTruHuyenId" id="diaChiThuongTruHuyenId"
						onchange="<portlet:namespace/>_list_dvhc_xa();"
						class="egov-select custom" style="width: 135px; display: block;"
						>
						<option id="chonhuyen" value="0">-Chọn-</option>
						<% 		   
		      		long diaChiThuongTruHuyenId= 0;
		      		if (Validator.isNotNull(userRequest.get("diaChiThuongTruHuyenId"))) {
		      			diaChiThuongTruHuyenId = FormatUtil.convertToLong(userRequest.get("diaChiThuongTruHuyenId"));
		      		}
					
						// Get quan huyen belong to tinh thanh
						if (diaChiThuongTruTinhId > 0) {
							// Get all quan huyen
							List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(diaChiThuongTruTinhId, 0);
									
							for (DonViHanhChinh quanHuyen: quanHuyenList) {
								selected = "";
								if ( quanHuyen.getId() == diaChiThuongTruHuyenId){
									selected = "selected";
								}
						%>
								<option value="<%=quanHuyen.getId()%>" <%=selected %>><%=quanHuyen.getTen()%></option>
		
								<%		} // for
						} // If
				  // else %>

				</select></td>
				<td colspan="2"><label class="egov-label-bold">
					<liferay-ui:message	key="org.oep.taocongdan.form.diaChiThuongTruXaId" /></label><font color="red">(*)</font></br>
				<select name="diaChiThuongTruXaId" id="diaChiThuongTruXaId"
					class="egov-select custom" style="width: 135px; display: block;">
					<option id="chonxa" value="">-Chọn-</option>
						<% 		   
      		long diaChiThuongTruXaId = 0;
      		
    		if (Validator.isNotNull(userRequest.get("diaChiThuongTruXaId"))) {
    			diaChiThuongTruXaId = FormatUtil.convertToLong(userRequest.get("diaChiThuongTruXaId"));
      		}
    		
			 
				// Get quan huyen belong to quan huyen
				if (diaChiThuongTruHuyenId > 0) {
					// Get all quan huyen
					List <DonViHanhChinh> phuongXaList =DonViHanhChinhLocalServiceUtil.findByChaId(diaChiThuongTruHuyenId, 0);
							
					for (DonViHanhChinh phuongXa: phuongXaList) {
						selected = "";
						if ( phuongXa.getId() == diaChiThuongTruXaId){
							selected = "selected";
						}
				%>
						<option value="<%=phuongXa.getId()%>" <%=selected %>><%=phuongXa.getTen()%></option>

						<%		} // for
				} // If
		 %>

				</select></td>
			
			
			</tr>
			<tr>
				<td colspan="6">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.moTaDiaChiThuongTru" /></label>
				<input name="diaChiThuongTru" type="text"
					id="diaChiThuongTru" class="egov-inputfield " title="Địa chỉ thường trú"
					maxlength="200" value="<%=HtmlUtil.escape(userRequest.get("diaChiThuongTru"))%>" /></td>
			</tr>	
			<!-- -done -->
			<tr>
		    <td colspan="6" align="center">
		    			<% if (TaoCongDanBusiness.ADD_CONGDAN.equals(mode)) { %>				
							<input type="submit" class = "egov-button" name="submitButton"  value="Tạo tài khoản công dân"/>
						<% } else if (TaoCongDanBusiness.UPDATE_CONGDAN.equals(mode)) { %>
							<input type="submit" class = "egov-button" name="submitButton"  value="Cập nhật tài khoản công dân"/>
						<% } %>		
    			
		    	 <a id="linkBackToList"
						href="<%=backUrl.toString()%>">
						<input type="button" id="buttonBackToList"	name="backUrl" 
							class="egov-button-normal" value="Quay lại danh sách" />
				</a>	
			</td>			
			</tr>
		</table>
	</form>

</div>

<!-- include all js -->
<%@ include file="/html/portlet/taocongdan/tao_cong_dan_js.jsp" %>
