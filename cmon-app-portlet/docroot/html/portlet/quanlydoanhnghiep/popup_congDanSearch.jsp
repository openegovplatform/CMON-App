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
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>

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
	/* String doituong = ParamUtil.getString(request, "dt");

	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl
			.setParameter(ActionRequest.ACTION_NAME, "searchPopUpQLCM");

	int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
	String maCD = ParamUtil.getString(request, "macongdan");
	String tenCD = ParamUtil.getString(request, "tencongdan");
	String soCMND = ParamUtil.getString(request, "socmnd");

	if (ParamUtil.getString(request, "dt") != null)
		doituong = ParamUtil.getString(request, "dt");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage",
			"/html/portlet/capchungchihoatdongy/popupNguoiQLCM.jsp");

	if (Validator.isNull(maCD) || maCD.trim().length() == 0) {
		iteratorUrl.setParameter("macongdan", "");
	}

	if (Validator.isNull(tenCD) || tenCD.trim().length() == 0) {
		iteratorUrl.setParameter("tencongdan", "");
	}

	if (Validator.isNull(soCMND) || soCMND.trim().length() == 0) {
		iteratorUrl.setParameter("socmnd", "");
	}

	List<CongDan> results = null;
	long longTotal = 0;
	int total = 0;
	SearchContainer searchContainer = null;

	longTotal = CongDanLocalServiceUtil.countCongDan(maCD, tenCD,
			soCMND);

	if (cur > 0) {
		searchContainer = new SearchContainer<CongDan>(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, cur, 5,
				iteratorUrl, null, null);
	} else {
		searchContainer = new SearchContainer<CongDan>(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, 5,
				iteratorUrl, null, null);
	}

	
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();

	if (longTotal > 0) {
		results = CongDanLocalServiceUtil.searchCongdan(maCD, tenCD,
				soCMND, start, end);

		if (renderRequest.getPortletSession().getAttribute("macongdan") != null) {
			iteratorUrl.setParameter("macongdan", renderRequest
					.getPortletSession().getAttribute("macongdan")
					.toString());
		}
		if (renderRequest.getPortletSession()
				.getAttribute("tencongdan") != null) {
			iteratorUrl.setParameter("tencongdan", renderRequest
					.getPortletSession().getAttribute("tencongdan")
					.toString());
		}
		if (renderRequest.getPortletSession().getAttribute("socmnd") != null) {
			iteratorUrl.setParameter("socmnd", renderRequest
					.getPortletSession().getAttribute("socmnd")
					.toString());
		}

	}

	total = Integer.parseInt(String.valueOf(longTotal));
	searchContainer.setTotal(total);
	searchContainer.setResults(results); */

	//searchUrl.setParameter("cur", String.valueOf(cur));
%>

<div class="egov-container">
	<p class="egov-p-20">
		Tìm kiếm công dân
	</p>
	<form name="searchForm" class="searchForm" method="post" action="" >
		<table class="egov-table-form" >
			<tbody>
				<tr>
					<td>
						<label class="egov-label-bold" >Nhập Tên/ CMND/ Mã số công dân/ Email :</label>
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
		<%-- <input type="hidden" name="dt" value="<%=doituong%>">  --%>
	</form>
	<form name="resultForm">
		<table class="egov-table cssTable" >
			<tbody>
				<tr>
					<th>STT</th>
					<th>Họ và tên</th>					
					<th>Số CMND</th>
					<th>Ngày sinh</th>
					<th>Chọn</th>
				</tr>
				<%-- <%
					if (total > 0 && results != null) {
						List items = results;//searchContainer.getResultRows();
						for (int i = 0; i < results.size(); i++) {
							CongDan hs = (CongDan) items.get(i);
							String fullName = hs.getHo() + " " + hs.getDem() + " "
									+ hs.getTen();
							String result = hs.getId() + "/" + fullName;

							if (hs.getDiachihiennay() != null)
								result = result + "/"
										+ hs.getDiachihiennay().replace('/', ',');
							else
								result = result + "/" + " ";

							if (hs.getDiachihiennaytinhid() != 0)
								result = result + "/"
										+ String.valueOf(hs.getDiachihiennaytinhid());
							else
								result = result + "/" + " ";

							if (hs.getDiachihiennayhuyenid() != 0)
								result = result + "/"
										+ String.valueOf(hs.getDiachihiennayhuyenid());
							else
								result = result + "/" + " ";

							if (hs.getDiachihiennayxaid() != 0)
								result = result + "/"
										+ String.valueOf(hs.getDiachihiennayxaid());
							else
								result = result + "/" + " ";

							if (hs.getDienthoaididong() != null) {
								if (!hs.getDienthoaididong().isEmpty())
									result = result + "/"
											+ String.valueOf(hs.getDienthoaididong());
								else
									result = result + "/" + " ";
							}
							if (hs.getFax() != null) {
								if (!hs.getFax().isEmpty())
									result = result + "/" + String.valueOf(hs.getFax());
								else
									result = result + "/" + " ";
							}
							if (hs.getEmail() != null) {
								if (!hs.getEmail().isEmpty())
									result = result + "/"
											+ String.valueOf(hs.getEmail());
								else
									result = result + "/" + " ";
							}
							//Get so chung chi hanh nghe va trinh do chuyen mon cong dan
							String soccgp = HoatDongYUtil.findSoCCGPByCongDan(
									hs.getId(), Constants.HoatDongY.HMS_CCHNKCBENH_MA);
							if (soccgp != null)
								result = result + "/" + soccgp.replace('/', ',');
							else
								result = result + "/" + " ";
				%>
				<tr>
					<td class="center"><input type="radio" class="egov-radio"  name="rdmaHoSo" id="rdmaHoSo"
						value="<%=result%>" /></td>
					<td><%=hs.getMa()%></td>
					<td><%=hs.getHo() + " " + hs.getDem() + " "
							+ hs.getTen()%></td>
					<td><%=hs.getSocmnd()%></td>
				</tr>
				<%
					}
					} else {
				%>
				<tr>
					<td colspan="4" align="center"><label class="egov-label">Xin
							nhập thông tin để tìm kiếm hồ sơ cần xử lý</label></td>
				</tr>
				<%
					}
				%> --%>
			</tbody>
		</table>
		<%-- <%
			if (searchContainer != null) {
		%>
		<div id="pagination">
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
		<%
			}
		%>
		<br />
		<table style="margin-bottom: 20pt;" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td align="center"><input name="selectId" type="button"
					value="Chọn" class="egov-button-normal" onclick="getSelectedId()" />
				</td>
			</tr>
		</table> --%>
		<input type="hidden" name="selectedMaHoSo" />
	</form>
</div>
<script type="text/javascript">
	function getSelectedId() {
		
		var radios = document.getElementsByName("rdmaHoSo");
		var value = "";
		for ( var i = 0; i < radios.length; i++) {
			if (radios[i].checked) {
				value = radios[i].value;
				break;
			}
		}
		if (value == "") {
			alert("Bạn cần phải chọn người quản lý!");
		} else {
			
			var arrayParamater = value.split("/");				
			<%-- window.opener.dataCanhan(arrayParamater[0],arrayParamater[1],arrayParamater[2],arrayParamater[3],arrayParamater[4],arrayParamater[5],arrayParamater[6],arrayParamater[7],arrayParamater[8],arrayParamater[9],this,<%=doituong%>); --%>
		}
	}
</script>





