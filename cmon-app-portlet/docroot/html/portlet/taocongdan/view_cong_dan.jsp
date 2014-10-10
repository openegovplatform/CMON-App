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

	  		
		<table width="100%" class="egov-table-form" >
			<tr>
				<td width="30%" scope="col">&nbsp;</td>
				<td colspan="4" scope="col">&nbsp;</td>
			</tr>

   			<tr>
				<td colspan="6" align="center"><label class="egov-label-header"><liferay-ui:message
							key="Thông tin công dân" /></label>							
			</td>
			</tr>				
			<tr>
				<td colspan="4">
				<label class="egov-label-bold"><liferay-ui:message
							key="org.oep.taocongdan.form.email" />: <%=congDan1.getEmail() %></label>
					
				
				
			
			<!-- bang cong dan -->
			<tr>
				<td colspan="6"><br> <label class="egov-label-bold"><liferay-ui:message
							key="org.oep.taocongdan.form.hoVaTen" />: <%=congDan1.getTenDayDu() %> </label></td>
				<td align="right"></td>		   	
		   	
			<tr >
				
		   	</tr>	
			
			<tr>
			 <td colspan="3">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.ngaySinh" />: <%=FormatUtil.parseDateToString(congDan1.getNgaySinh()) %></label></td>
		   	
		   	<td colspan="3">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.gioiTinh" />:</label>
		     	
		       <%
		      	List <GioiTinh> gioiTinhList = GioiTinhLocalServiceUtil.findAll();
		      %>
	     		<%
	      	   		for ( GioiTinh gioiTinh: gioiTinhList) {
	      	   			if ( Validator.isNotNull(congDan1.getGioiTinh()) && gioiTinh.getId() 
	      	   					== congDan1.getGioiTinh() ) {
	      	   				%>
	      	   				<label class="egov-label-bold">		
	      	   				<%=gioiTinh.getTen() %>
	      	   			  	</label>
	      	   			  <%
	        			} 
	        	%>
	        	<%} %>
	        	
		    
		      </td>
		   	</tr>
			
			<tr>
		 		<td colspan="2">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.soCmnd" />: <%=congDan1.getSoCmnd() %></label>
		     
		      </td>		      
		  
		      <td colspan="2">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.ngayCapCmnd" />: <%=FormatUtil.parseDateToString(congDan1.getNgayCapCmnd()) %></label>
		     </td>
		   	
		      
		 </tr>	
		 <tr>
		<td colspan="2" ><label class ="egov-label-bold"><liferay-ui:message key="org.oep.taocongdan.form.quocTich" />
         		: Việt Nam</label>
        
      	  
          </td>
         
	  
		     <td colspan="2">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.danTocId" />: </label>
		     		
		       <%
		      	List <DanToc> listDanToc = DanTocLocalServiceUtil.findAll();
		      %>
	     		<%
	        		
	      	   		for ( DanToc danToc: listDanToc) {
	      	   			if ( congDan1.getDanTocId() >0 && danToc.getId()
	      	   					== congDan1.getDanTocId())  {
	      	   			%>
	      	   			<label class="egov-label-bold">
	      	   			<%=danToc.getTen() %>
	      	   			</label>
	      	   			
	      	   	<%		
	        			} 
	        	%>
	        	<%} %>
		      </td>
		       <td colspan="2">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.tonGiaoId" /> :</label>
		     	
		       <%
		      	List <TonGiao> listTonGiao = TonGiaoLocalServiceUtil.findAll();
		      %>
	     		<%
	        		
	      	   		for ( TonGiao tonGiao: listTonGiao) {
	      	   			if ( congDan1.getTonGiaoId() >0  && tonGiao.getId()
	      	   					== congDan1.getTonGiaoId() ) {
	      	   				%>
	      	   				<label class="egov-label-bold"><%=tonGiao.getTen() %></label>
	      	   	<%			
	        			} 
	        	%>
	        	<%} %>
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
								key="org.oep.taocongdan.form.diaChiThuongTruTinhId" />:</label>
								
						<% 		   
      				List <DonViHanhChinh> tinhThanhLis1t = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
						long diaChiThuongTruTinhId = 0;
			      		if (congDan1.getDiaChiThuongTruTinhId() >0) {
			      			diaChiThuongTruTinhId = congDan1.getDiaChiThuongTruTinhId();
			      		}
			      		
							
						for (DonViHanhChinh tinhThanh: tinhThanhLis1t) {
							if ( tinhThanh.getId() == diaChiThuongTruTinhId){
						%>
						<label class="egov-label-bold">
						<%=tinhThanh.getTen()%>
						</label>
						<%		
							}
						%>
								
					 <%	} 
					%>		</td>
					
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.diaChiThuongTruHuyenId" /> :</label>
						<% 		   
		      		long diaChiThuongTruHuyenId= 0;
		      		if (congDan1.getDiaChiThuongTruHuyenId()>0) {
		      			diaChiThuongTruHuyenId = congDan1.getDiaChiThuongTruHuyenId();
		      		}
					
						// Get quan huyen belong to tinh thanh
						if (diaChiThuongTruTinhId > 0) {
							// Get all quan huyen
							List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(diaChiThuongTruTinhId, 0);
									
							for (DonViHanhChinh quanHuyen: quanHuyenList) {
								if ( quanHuyen.getId() == diaChiThuongTruHuyenId){
									%>
									<label class="egov-label-bold"><%=quanHuyen.getTen()%></label>
							<%		
								}
						%>
		
								<%		} // for
						} // If
				  // else %>

				</td>
				<td colspan="2"><label class="egov-label-bold">
					<liferay-ui:message	key="org.oep.taocongdan.form.diaChiThuongTruXaId" />: </label>
						<% 		   
      		long diaChiThuongTruXaId = 0;
      		
    		if (congDan1.getDiaChiThuongTruXaId()>0) {
    			diaChiThuongTruXaId = FormatUtil.convertToLong(userRequest.get("diaChiThuongTruXaId"));
      		}
    		
			 
				// Get quan huyen belong to quan huyen
				if (diaChiThuongTruHuyenId > 0) {
					// Get all quan huyen
					List <DonViHanhChinh> phuongXaList =DonViHanhChinhLocalServiceUtil.findByChaId(diaChiThuongTruHuyenId, 0);
							
					for (DonViHanhChinh phuongXa: phuongXaList) {
						if ( phuongXa.getId() == diaChiThuongTruXaId){
							%>
							
						<label class="egov-label-bold"><%=phuongXa.getTen()%></label>	
				<%			
						}
				%>

						<%		} // for
				} // If
		 %>

				</td>
			
			
			</tr>
			<tr>
				<td colspan="6">
		      		<label class="egov-label-bold"><liferay-ui:message
								key="org.oep.taocongdan.form.moTaDiaChiThuongTru" />: <%=congDan1.getDiaChiThuongTru() %></label>
								</td>
			</tr>	
			<!-- -done -->
			<tr>
		    <td colspan="6" align="center">
		    			
    			
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
