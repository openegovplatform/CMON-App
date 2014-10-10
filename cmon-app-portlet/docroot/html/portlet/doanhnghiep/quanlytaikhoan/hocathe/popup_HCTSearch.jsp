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
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

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
</style>

<%
	/* PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchPopUpDoanhnghiep");

	//int currentTransPage  = ParamUtil.getInteger(request,"currentTransPage");\
	int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
	
	//String maHoSo =  ParamUtil.getString(request, "maHoSo");
	//String nguoiNop = ParamUtil.getString(request,"nguoiNop");
	//String nopTuNgay = ParamUtil.getString(request,"nopTuNgay");
	//String denTuNgay = ParamUtil.getString(request,"denTuNgay");
	//String curPage = ParamUtil.getString(request,"curPage");
	String tenDoanhNghiep =ParamUtil.getString(request, "tendoanhnghiep");
	String maDoanhNghiep =ParamUtil.getString(request, "ma");
	String soDangKiKD = ParamUtil.getString(request, "sodangki");
	//Common Parameters
	//String maHMS = ParamUtil.getString(request, Constants.NhomThuTuc.NHOM, Constants.UngDung.MaUngDung_HMS);
	//int statusHoSo=Constants.HoSo.TRANGTHAI_DANGXULY;
	
	//String doSearch = ParamUtil.getString(request, "doSearch");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	//iteratorUrl.setParameter(Constants.NhomThuTuc.NHOM, maHMS);
	iteratorUrl.setParameter("jspPage", "/html/portlet/capchungchihoatdongy/popup_doanhnghiep.jsp");

	//iteratorUrl.setParameter("maHoSo", maHoSo);		 

	List<DoanhNghiep> results = null;
	long longTotal = 0;
	
	int total=0;
	SearchContainer searchContainer = null;
		longTotal = DoanhNghiepLocalServiceUtil.countDoanhNghiep(maDoanhNghiep, tenDoanhNghiep, soDangKiKD);
		
		if (cur > 0) {
			searchContainer = new SearchContainer(renderRequest, null,
					null, SearchContainer.DEFAULT_CUR_PARAM,
					cur, 5, iteratorUrl, null, null);
		} else {
			searchContainer = new SearchContainer(renderRequest, null,
					null, SearchContainer.DEFAULT_CUR_PARAM, 5,
					iteratorUrl, null, null);
		}
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		if (longTotal > 0) {
			results = DoanhNghiepLocalServiceUtil.searchDoanhNghiep(maDoanhNghiep, tenDoanhNghiep, soDangKiKD, start, end);
		}
		total = Integer.parseInt(String.valueOf(longTotal));
		searchContainer.setTotal(total);
		searchContainer.setResults(results); */
	
%>

<div class="egov-container">
	<p class="egov-p-20">
		Tìm kiếm hộ cá thể
	</p>	
	<form name="searchForm" class="searchForm" method="post" action="" >
		<table class="egov-table-form" >
			<tbody>
				<tr>
					<td>
						<label class="egov-label-bold" >Nhập Tên/ Mã giấy phép/ Mã số thuế :</label>
					</td>
				</tr>
				<tr>
					<td> 
						<div class="left" style="width: 50%;">	
							<input style="width: 95%;" name="inputText" id="inputText" type="text" size="25" maxlength="150"
							class="egov-inputfield custom" value="" />
						</div>
						<div>
							<input style="width: 9%;" type="submit" value="Tìm kiếm"
						class="egov-button-search" />
						</div>
					</td>
					
					
				</tr>
			</tbody>
		</table>
	</form>
	<form name="resultForm">
		<table  class="egov-table cssTable">
			<tbody>
				<tr>
					<th>STT</th>					
					<th>Tên</th>
					<th>Mã giấy phép</th>
					<th>Mã số thuế</th>
					<th>Chọn</th>
				</tr>
				<%-- <%
					if (total > 0 && results != null) {
								List items = results;//searchContainer.getResultRows();
								for (int i = 0; i < results.size(); i++) {
									DoanhNghiep hs = (DoanhNghiep) items.get(i);
									
				%>
				<tr>
					<td>
						<input type="radio" name="rdmaHoSo" id="rdmaHoSo"
						value="<%=hs.getId()%>" /> 
						</td>
					<td><%=hs.getMa()%></td>
					<td><%=hs.getTen()%>
					<input type="hidden"
							id="tenDoanhNghiep" name="tenDoanhNghiep"
						value="<%=hs.getTen()%>">
					</td>
					<td><%=hs.getSogcndkkd()%></td>
					<td><%=hs.getMasothue()%></td>
				</tr>
				<%
					}
							} else {
				%>
				<tr>
					<td colspan="6" align="center"><label class="egov-label">Xin
							nhập thông tin để tìm kiếm hồ sơ cần xử lý</label></td>
				</tr>
				<%
					}
				%> --%>
			</tbody>
		</table>
		<table style="margin-bottom: 20pt;" >
			<tr>				
				<td colspan="5" style="padding: 10px !important">
					<input type="submit" class="egov-button" id="chapNhan" value="Chấp nhận">
				   	<input type="button" class="egov-button" onclick="window.close();"value="Đóng lại">			      	
				</td>			
			</tr>
		</table>
		<%-- <% if(searchContainer != null){ %>
		<div id="pagination">
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
		<%} %>
		<br />
		<table cellpadding="0" cellspacing="0" width="100%" style="margin-bottom: 20pt;" >
			<tr>
				<td align="center"><input name="selectId" type="button"
					value="Chọn" class="egov-button-normal" onclick="getSelectedId()" />
				</td>
			</tr>
		</table>
		<input type="hidden" name="selectedMaHoSo" /> --%>
	</form>
</div>
<script type="text/javascript">
	function getSelectedId() {
		var radios = document.getElementsByName("rdmaHoSo");
		var tenDoanhNghieps=document.getElementsByName("tenDoanhNghiep");
		var value = "";	
		var tenDoanhNghiep="";
		for ( var i = 0; i < radios.length; i++) {
			if (radios[i].checked) {
				value = radios[i].value;
				tenDoanhNghiep=tenDoanhNghieps[i].value;
				break;
			}
		}
		if (value == "") {
			alert("Bạn cần phải chọn mã hồ sơ!");
		}
		else {
			window.opener.document.getElementById('iddoanhnghiep').value = value;
			window.opener.document.getElementById('tenDoanhNghiep').value = tenDoanhNghiep;
			
			
			//alert("Doanh nghiệp đã được chọn");
			window.close();
		}
	}
</script>





