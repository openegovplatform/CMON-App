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
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Collections"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dn.model.DoanhNghiep"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>

<%@page import="org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.business.QuanLyTaiKhoan"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
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
long doiTuongType = 0l;
int trangThaiType = 99;
String maOrTenOrEmail = "";
int total = 0;
long longTotal=0l;
if ( Validator.isNotNull(ParamUtil.getString(request,"doiTuongType")) ) {
	doiTuongType = ParamUtil.getLong(request,"doiTuongType");
}
if ( Validator.isNotNull(ParamUtil.getString(request,"trangThaiType")) ) {
	trangThaiType = ParamUtil.getInteger(request,"trangThaiType");
}
if ( Validator.isNotNull(ParamUtil.getString(request,"maOrTenOrEmail")) ) {
	maOrTenOrEmail = URLDecoder.decode(ParamUtil.getString(request,"maOrTenOrEmail"),StringPool.UTF8);
}
//end get param values
PortletURL pagingUrl = renderResponse.createRenderURL();
pagingUrl.setParameter("maOrTenOrEmail",URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8));
pagingUrl.setParameter("trangThaiType",String.valueOf(trangThaiType));
pagingUrl.setParameter("doiTuongType",String.valueOf(doiTuongType));


PortletURL searchUrl = renderResponse.createActionURL();
searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchListYeuCau");

SearchContainer searchContainer = null;
int currentTransPage = ParamUtil.getInteger(request,"currentTransPage");
if (currentTransPage > 0) {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			currentTransPage, 10, pagingUrl, null, null);
} else {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, 10,
			pagingUrl, null, null);
}

int start = searchContainer.getStart();
int end = searchContainer.getEnd();
//get total records here

longTotal = QuanLyTaiKhoan.countByDoanhNghiep( maOrTenOrEmail,doiTuongType,trangThaiType);
List<DoanhNghiep> listDoanhNghiep = QuanLyTaiKhoan.getListDoanhNghiep(maOrTenOrEmail, doiTuongType, trangThaiType, start, end);
total = Integer.parseInt(String.valueOf(longTotal));
searchContainer.setTotal(total);
searchContainer.setResults(listDoanhNghiep);



		/* 	String searchText = (String) session.getAttribute("inputTextSearchDN");
			String param = (String) request.getAttribute("inputTextSearchDN");
			param = param == null? StringPool.BLANK :param;
			searchText = searchText == null? StringPool.BLANK :searchText;
			
			if (param == searchText && param.isEmpty()) {
			    // Do nothing
			} else if (param.isEmpty()) {
			    session.setAttribute(param, StringPool.BLANK);
			    searchText =  StringPool.BLANK;
			} else {
			    searchText = param;
			    session.setAttribute(param, searchText);
			}
			
			PortletURL hsInteratorURL = renderResponse.createRenderURL();
			hsInteratorURL.setParameter("jspPage", "/html/portlet/doanhnghiep/quanlytaikhoan/view.jsp"); */

%>
<liferay-portlet:actionURL name="reportSearch" var="doSearchURL">
    <%-- <liferay-portlet:param name="duAnId" value="<%= duAnId %>" /> --%>
</liferay-portlet:actionURL>

<portlet:actionURL var="addNewHCT" name="addNewHCT">
    <portlet:param name="jspPage" value="/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/hocathe.jsp" />
</portlet:actionURL>
<portlet:actionURL var="addNewHTX" name="addNewHTX">
    <portlet:param name="jspPage" value="/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/hocathe.jsp" />
</portlet:actionURL>
<portlet:actionURL var="addNewDN" name="addNewDN">
    <portlet:param name="jspPage" value="/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/hocathe.jsp" />
</portlet:actionURL>

<div class="egov-container">
	<!--Show dialog  -->
	<% 
	PortletURL addNewDT   = renderResponse.createRenderURL();	
	addNewDT.setParameter("jspPage","/html/portlet/doanhnghiep/quanlytaikhoan/hocathe/hocathe.jsp");
	%>
	<div id="dialog_chonLoaiDoiTuong"  title="Chọn loại đối tượng" style="display: none;">
		<form id="addNewDT" name="addNewDT" action="<%= addNewDT %>" method="POST">
			<table style="height: 130pt;" class="egov-table">
				<tr>
					<td  colspan="3">
						<select id="doiTuongDialog" name="doiTuongDialog" class="egov-select" >
								<option value="0">Lọc theo đối tượng</option>
								<% 
											List<DoiTuongSuDung> listDtDialog=Collections.emptyList();
											listDtDialog=DoiTuongSuDungLocalServiceUtil.getDSDoiTuongSuDung(0);
											
											//String loaiDoiTuong = userRequest.get("loaiDoiTuong");
							        		for ( DoiTuongSuDung obj: listDtDialog) {
							        			//String selected = "";
							        			
							        			if( obj.getMa().equals("DN") || obj.getMa().equals("HTX") || obj.getMa().equals("HKDCT")){
							        				%>
									        		<option value  = "<%=obj.getId() %>" ><%=obj.getTen() %></option>
									        	<%
							        			}
							        		}
							      %>								
						</select>	
					</td>
				</tr>
				
				<tr>
					<td colspan="3" style="padding: 10px !important">
						<input type="button" onclick="submitFormDT();"  class="egov-button" id="Them" value="Chọn">
					   	<input type="button" class="egov-button" id="Dong" value="Đóng">
				      	
					</td>
				</tr>
			
			</table>
		</form>
	</div>
	<!--End Show dialog  -->
	<p class="egov-p-20">
		Quản lý tài khoản Doanh nghiệp /Hộ cá thể /Hợp tác xã
	</p>
	
	
	
	
	
	<%-- <form name="searchForm" class="searchForm" action="<%= doSearchURL %>" method="POST">
        <div class="wd-add-new-project wd-list-branch">   
             <fieldset>
                
                <label class="egov-label-bold" >Nhập mã giấy phép / Email / Tên :</label><br>
                <div style="margin-bottom: 30pt;">
		                <div class="left" style="width: 32%;">	
									<input style="width: 100%;" name="inputTextSearchDN" id="inputTextSearchDN" type="text" size="25" maxlength="150"
									class="egov-inputfield custom" />
						</div>
						<div class="left sepleft10 ">
									<input style="width: 20%;" value="" type="submit" onclick="submitForm'<%=searchText%>');" class="egov-button-search small" />
						</div>
					
						<div class="left" style="width: 18%;margin-left: 13%;">	
									<select name="doiTuongType" class="egov-select" onchange="submitForm'<%=searchText%>');">
										<option value="0">Lọc theo đối tượng</option>
										<% 
											List<DoiTuongSuDung> listDt=Collections.emptyList();
											listDt=DoiTuongSuDungLocalServiceUtil.getDSDoiTuongSuDung(0);
											
											//String loaiDoiTuong = userRequest.get("loaiDoiTuong");
							        		for ( DoiTuongSuDung obj: listDt) {
							        			//String selected = "";
							        			
							        			if( obj.getMa().equals("DN") || obj.getMa().equals("HTX") || obj.getMa().equals("HKDCT")){
							        				%>
									        		<option value  = "<%=obj.getId() %>" ><%=obj.getTen() %></option>
									        	<%
							        			}
							        		}
							        	%>
									</select>						
						</div>
						<div class="left searchType" style="width: 18%;">
									<select  name="trangThaiType" class="egov-select" onchange="submitForm'<%=searchText%>');">
										<option  value="0">Lọc theo trạng thái</option>
										<option  value="1">Có tài khoản </option>
										<option  value="2">Không có tài khoản</option>
									</select>
						</div>
						<div>
									<input style="float: right;" type="button" id="addNewQLDN" class="egov-button" value="Thêm mới"/>
						</div>		
				</div>
				
                  <div class="egov-table result-grid clear">

                    <% int i = 1; %>
                    <liferay-ui:search-container delta="10" iteratorURL="<%= hsInteratorURL %>" emptyResultsMessage="Không tìm thấy !">
                        <liferay-ui:search-container-results>
                        <%
                       /*  pageContext.setAttribute("total", Integer.valueOf(listResult.size()));
                        pageContext.setAttribute("results", ListUtil.subList(listResult, searchContainer.getStart(), searchContainer.getEnd())); */
                        %>
                        </liferay-ui:search-container-results>
                        <liferay-ui:search-container-row className=" org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.DanhSachQuanLyTKModel"                         
                        modelVar="model" keyProperty="primaryKey">
                            <liferay-portlet:actionURL name="reportAddGET" var="editURL">
                                <liferay-portlet:param name="baoCaoId" value="<%= model.getPrimaryKey() %>" />
                                <liferay-portlet:param name="mode" value="1" />
                            </liferay-portlet:actionURL>
                            <liferay-portlet:actionURL name="reportAddGET" var="detailReportURL">
                                <liferay-portlet:param name="baoCaoId" value="<%= model.getPrimaryKey() %>" />
                                <liferay-portlet:param name="mode" value="2" />
                            </liferay-portlet:actionURL>
                            <liferay-portlet:actionURL name="reportRemove" var="removeReportURL">
                                <liferay-portlet:param name="baoCaoId" value="<%= model.getPrimaryKey() %>" />
                            </liferay-portlet:actionURL>

                            <%
                            String editColumn = "<a href=\"" + editURL.toString() + "\" class=\"egov-func-edit\" title=\"" + LanguageUtil.get(pageContext, "vn.tcx.ipms.baocaotinhhinh.view.list.link_edit") + "\">&nbsp;&nbsp;&nbsp;&nbsp;</a>";
                            String finalColumn = "<a href=\"" + detailReportURL.toString() +"\" class=\"egov-func-detail\" title=\"" + LanguageUtil.get(pageContext, "vn.tcx.ipms.baocaotinhhinh.view.list.link_detail") + "\">&nbsp;&nbsp;&nbsp;&nbsp;</a>";
                            String deleteColumn = "<a class='egov-func-delete' onClick=\"return ipms_bcth_delete_confirm('" + removeReportURL.toString() + "')\" href='javascript:void(0)' title=\"" + LanguageUtil.get(pageContext, "vn.tcx.ipms.baocaotinhhinh.view.list.link_remove") + "\">&nbsp;&nbsp;&nbsp;&nbsp;</a>";
                                                        
                            if("NA".equals("nguoiDung") || "DOANHNGHIEP".equals("nguoiDung"))
                            {
                            	finalColumn += StringPool.SPACE + editColumn;
                            }else
                            	finalColumn += StringPool.SPACE + editColumn + deleteColumn;
                            
                            %>
                            <liferay-ui:search-container-column-text name="STT" align="center" value="<%= Integer.toString(i++ + searchContainer.getStart()) %>" cssClass="ipms_report_col_id" />
                            <liferay-ui:search-container-column-text name="Mã giấy phép" property="date" align="center" cssClass="ipms_report_col_date"/>
                            <liferay-ui:search-container-column-text name="Email" property="ten" cssClass="ipms_report_col_name" />
                            <liferay-ui:search-container-column-text name="Tên" property="tenChiNhanh" cssClass="ipms_report_col_name" />
                            <liferay-ui:search-container-column-text name="Địa chỉ" property="noiDung" cssClass="ipms_report_col_content" />
                            <liferay-ui:search-container-column-text name="Đối tượng" property="nguoiNop" cssClass="ipms_report_col_name" />
                            <liferay-ui:search-container-column-text name="Trạng thái" property="nguoiNop" cssClass="ipms_report_col_name" />
                            <liferay-ui:search-container-column-text name="Hành động" value="<%= finalColumn %>" cssClass="ipms_report_actions_link" align="center"/>
                        </liferay-ui:search-container-row>

                        <liferay-ui:search-iterator />
                    </liferay-ui:search-container>
                </div>
             </fieldset>
        </div>
    </form> --%>
	
	
	
	
	
	 <form name="searchForm" id="searchForm" class="searchForm" method="post" action="<%= searchUrl %>" >
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
							<input style="width: 95%;" name="maOrTenOrEmail" id="maOrTenOrEmail" type="text" size="25" maxlength="150"
							class="egov-inputfield custom" value="" />
						</div>
						<div>
							<input style="width: 20%;" type="submit" value="Tìm kiếm"
						class="egov-button-search" />
						</div>
					</td>
					<td colspan="3"> 
						<div class="left" style="width: 35%;">	
							<select id="doiTuongType" name="doiTuongType" onchange="submitForm()" class="egov-select" >
								<option value="0">Lọc theo đối tượng</option>
								<option value="<%=ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE")%>" <%=Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE"))==doiTuongType?"selected":""%>>Hộ kinh doanh cá thể</option>
								<option value="<%=ThamSoLocalServiceUtil.getValue("LDT_DOANHNGHIEP")%>" <%=Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_DOANHNGHIEP"))==doiTuongType?"selected":""%>>Doanh nghiệp</option>
								<option value="<%=ThamSoLocalServiceUtil.getValue("LDT_HOPTACXA")%>" <%=Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOPTACXA"))==doiTuongType?"selected":""%>>Hợp tác xã</option>
							</select>						
						</div>
						<div class="left searchType" style="width: 35%;">
							<select  name="trangThaiType" onchange="submitForm()" class="egov-select" >
								<option  value="0">Lọc theo trạng thái</option>
								<option  value="1" <%=trangThaiType==1?"selected":""%> >Có tài khoản </option>
								<option  value="2" <%=trangThaiType==2?"selected":""%>>Không có tài khoản</option>
							</select>
						</div>
						<div>
							<input style="float: right;" type="button" id="addNewQLDN" class="egov-button" value="Thêm mới"/>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		
	</form>
	<form name="resultForm">
		<table class="egov-table cssTable" >
			<thead>
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
				
			</thead>
			<tbody>
	<%
	int stt = 1;
	String diaChi=""; 
	List <DonViHanhChinh> listDV;
	String tinh="", huyen="" ,xa="";
	
	
	for(int i = 0;i<listDoanhNghiep.size();i++){
		DoanhNghiep dn = listDoanhNghiep.get(i);
		if(dn.getDiaChiDoanhNghiep() != null && !dn.getDiaChiDoanhNghiep().isEmpty())
			diaChi= dn.getDiaChiDoanhNghiep() ;
		
		if(dn.getDiaChiDoanhNghiepXaId() != null){
			xa = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(dn.getDiaChiDoanhNghiepXaId()).getTen();
			diaChi= diaChi + "," + xa;
		}
		if(dn.getDiaChiDoanhNghiepHuyenId() != null){
			huyen = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(dn.getDiaChiDoanhNghiepHuyenId()).getTen();
			diaChi= diaChi + "," + huyen;
		}
		if(dn.getDiaChiDoanhNghiepTinhId() != null){
			tinh = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(dn.getDiaChiDoanhNghiepTinhId()).getTen();
			diaChi= diaChi + "," + tinh;
		}
		
		
		
		
		String loaiDoiTuong = "";
		if(dn.getLoaiDoiTuongId()==Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE"))){
			loaiDoiTuong = "Hộ cá thể";
		}
		if(dn.getLoaiDoiTuongId()==Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_DOANHNGHIEP"))){
			loaiDoiTuong = "Doanh nghiệp";
		}
		if(dn.getLoaiDoiTuongId()==Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOPTACXA"))){
			loaiDoiTuong = "Hợp tác xã";
		}
		
		
		
		String strTrangThai = "";
		if(dn.getTaiKhoanNguoiDungId() != null && dn.getTaiKhoanNguoiDungId() > 0  ){
			strTrangThai = "Có tài khoản";
		}else
			strTrangThai = "Không có tài khoản";
		
		/* PortletURL xacThucUrl = renderResponse.createActionURL();
		xacThucUrl.setParameter(ActionRequest.ACTION_NAME, "xacThucHoCaThe");
		xacThucUrl.setParameter("idYeuCau",String.valueOf(yeuCau.getId()));
		xacThucUrl.setParameter("maOrTenOrEmail",URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8));
		xacThucUrl.setParameter("trangThai",String.valueOf(trangThaiType));
		xacThucUrl.setParameter("loaiDoiTuongId",String.valueOf("doiTuongType")); */
	%>
	
					<liferay-portlet:actionURL name="addDN" var="detailURL">
                                <liferay-portlet:param name="maDN" value="<%=dn.getMa()%>" />
                                <liferay-portlet:param name="mode" value="1" />
                            </liferay-portlet:actionURL>
                            <liferay-portlet:actionURL name="editDN" var="editURL">
                                <liferay-portlet:param name="maDN" value="<%=dn.getMa()%>" />
                                <liferay-portlet:param name="mode" value="2" />
                            </liferay-portlet:actionURL>
                            <liferay-portlet:actionURL name="removeDN" var="removeURL">
                                <liferay-portlet:param name="maDN" value="<%=dn.getMa()%>" />
                   </liferay-portlet:actionURL>
		<tr>
			<td style="text-align: center;"><%=stt+searchContainer.getStart()%></td>
			<td style="text-align: center;"><%=dn.getSoGCNDKKD()%></td>
			<td style="text-align: center;"><%=dn.getEmailDoanhNghiep()%></td>
			<td><%=dn.getTen() %></td>
			<td><%=diaChi%></td>
			<td style="text-align: center;"><%=loaiDoiTuong %></td>
			<td style="text-align: center;"><%=strTrangThai %></td>
			<td>
				<%
				String detailColumn = "<a href=\"" + detailURL.toString() +"\">Xem</a>";
				String editColumn = "<a href=\"" + editURL.toString() +"\">Sửa</a>";
				String deleteColumn = "<a onClick=\"return dn_delete_confirm('" + removeURL.toString() + "')\" href='javascript:void(0)'>Xóa</a>";
               	String finalCol ;
				
				if(dn.getTaiKhoanNguoiDungId() !=null && dn.getTaiKhoanNguoiDungId() >0){
					finalCol =   detailColumn  + editColumn + deleteColumn;
				%>
				
				<%} else{
					finalCol =   detailColumn +  deleteColumn;
				}%>
					
				<%= finalCol %>
			</td>
		</tr>
	<%} %>
	</tbody>
		</table>
		<%
			if (searchContainer != null) {
		%>
		<div id="pagination">
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
		<%
			}
		%>
		<br />				
	</form> 
</div>


<div style="display:none;" id="dn-dialog-confirm" title='Xác nhận'>
    <liferay-ui:message key="Bạn có muốn xóa không ?" />
</div>












<%-- <!--Test new function  -->

<%			PortletURL url1   = renderResponse.createRenderURL();			
			
			url1.setParameter("jspPage","/html/portlet/doanhnghiep/quanlytaikhoan/doanhnghiep/DoanhNghiep.jsp");
			String backUrl1 =url1.toString();
						
	      	%>
	      	
	      	<h1>SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS</h1>
<button class="egov-button" type="button" onclick="location.href='<%=backUrl1%>'"></button> 


<!--End Test new function  --> --%>

<script type="text/javascript">
		/* dialog  properties */
		$('#dialog_chonLoaiDoiTuong').dialog({
			width: 400,
		    height: 250,
		    autoOpen: false,
		    show: 'slide',
		    hide: 'slide',
		    /* buttons: { 'Close': function() { $(this).dialog('close'); } }, */
		    closeOnEscape: true,
		    resizable: false,
		});
		 /* dialog open/close */
		$('#addNewQLDN').click(function() {
		    if ($('#dialog_chonLoaiDoiTuong').dialog('isOpen') == true)
		        $('#dialog_chonLoaiDoiTuong').dialog('close');
		    else
		        $('#dialog_chonLoaiDoiTuong').dialog('open');
		    return false;
		});
		 
		 
		$('#Them').click(function() {
			 $('#dialog_chonLoaiDoiTuong').dialog('close'); 
		});
		
		 
		
		
		$('#Dong').click(function() {
			 $('#dialog_chonLoaiDoiTuong').dialog('close'); 
		});
		
		
		
		function submitFormDT()
		{	
			var id = $("#doiTuongDialog").val();			
			if(id==0)			
				preventDefault();			
			else
				$('#addNewDT').submit();			
			
		};
		
		
		
		function submitForm(searchStr)
		{			
			$('.searchForm').submit();
		};
		
		
		function dn_delete_confirm(url) {
			console.log('ádasdasd');
		    $("#dn-dialog-confirm").dialog({
		      resizable: false,
		      height:200,
		      width: 400,
		      modal: true,
		      buttons: {
		          "Ok": function() {
		            $( this ).dialog("close");
		            window.location.href = url;
		            console.log('ádasd');
		            return true;
		        },
		        Cancel: function() {
		          $( this ).dialog("close");
		          console.log('ádasd213');
		          return false;
		        }
		      }
		    });
		}
		
</script>

