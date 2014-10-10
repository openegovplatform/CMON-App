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
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.portlet.taocongdan.business.TaoCongDanBusiness"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.portlet.taocongdan.util.FormatUtil"%>
<%@page import="org.oep.cmon.Constants.Paging"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/portlet/init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	int cur =  Integer.valueOf(prefs.getValue("curTK", "1"));
	int delta =  Integer.valueOf(prefs.getValue("deltaTK", String.valueOf(Paging.DELTA)));
	int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
	int deltanext = ParamUtil.getInteger(renderRequest, "delta", Paging.DELTA);
	if(curnext!=cur) {
		cur = curnext;
	}
	if(deltanext!=delta) {
		delta = deltanext;
	}

	PortletURL searchURL = renderResponse.createActionURL();
	searchURL.setParameter(ActionRequest.ACTION_NAME, "searchCongDanRequest");		
		
	String keyWord =ParamUtil.getString(renderRequest, "searchKeyWord", "");
	String statusCD="";
	
	String typeTKNDId=ParamUtil.getString(renderRequest, "typeTKNDId");	
	
	// Get default search value
	if (Validator.isNull(keyWord) && renderRequest.getPortletSession().getAttribute("searchKeyWord") != null) {
		keyWord = renderRequest.getPortletSession().getAttribute("searchKeyWord").toString();
	}
	if (Validator.isNull(typeTKNDId)	&& renderRequest.getPortletSession().getAttribute("typeTKNDId") != null)
	{
		typeTKNDId = renderRequest.getPortletSession().getAttribute("typeTKNDId").toString();
	}
	
	
	PortletURL pagingURL = renderResponse.createRenderURL();
	//iteratorUrl.setParameter(	"jspPage","/html/portlet/taocongdan/tao_cong_dan_list.jsp");
	if (renderRequest.getParameter("searchKeyWord") != null) {
		pagingURL.setParameter("searchKeyWord", keyWord);
	}
	if (renderRequest.getParameter("typeTKNDId") != null) {
		pagingURL.setParameter("typeTKNDId", renderRequest.getPortletSession().getAttribute("typeTKNDId").toString());
	}
	
	
	List<CongDan>  results = new ArrayList<CongDan>(); 
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, pagingURL, null, null);
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	Long longTotal=0L;	
	

	try {
		longTotal = TaoCongDanBusiness.countByCongDan(keyWord, typeTKNDId);
				
		results = TaoCongDanBusiness.findByCongDan(keyWord, typeTKNDId, start, end);
				
	
} catch (Exception e) {
	SessionErrors.add(renderRequest, "errorSearch");
}
	
	if ( results == null ) {	
		 results = new ArrayList<CongDan>();
		
	}
	
	// Paging
	searchContainer.setTotal(longTotal.intValue());
	searchContainer.setResults(results);

%>

<div class="egov-container">
<form name = "<portlet:namespace/>searchThamSoForm" method = "post" action = "<%=searchURL%>" >
<br>
			<table   class="egov-table-form" style="width: 100%">
			  <tr>
			    <td align = "left" width="50%">  
			     	<input name="searchKeyWord" id="searchKeyWord" type="text"  class="egov-inputfield-search" style="width: 94.2%;"
				     	      value = "<%=keyWord%>" placeholder="<%=LanguageUtil.get(pageContext, "org.oep.cmon.taocongdan.list.search.defaultValue")%>"/>
			    </td>
			    <td align = "left" width="20%" style="padding-left: 5px">
		      		<select id="typeTKNDId" name="typeTKNDId" class="egov-select">
		      		<option value=""><liferay-ui:message key="org.oep.cmon.taocongdan.list.taikhoannguoidungid.select"/></option>	 
		      			 <option value="<%=Constants.TaoCongDan.CO_TAI_KHOAN %>" <%=TaoCongDanBusiness.checkSelectedValue(typeTKNDId, String.valueOf(Constants.TaoCongDan.CO_TAI_KHOAN)) %>><liferay-ui:message key="org.oep.cmon.taocongdan.list.taikhoannguoidungid.notnull"/></option>
		      			 <option value="<%=Constants.TaoCongDan.CHUA_CO_TAI_KHOAN %>" <%=TaoCongDanBusiness.checkSelectedValue(typeTKNDId, String.valueOf(Constants.TaoCongDan.CHUA_CO_TAI_KHOAN))%>><liferay-ui:message key="org.oep.cmon.taocongdan.list.taikhoannguoidungid.isnull"/></option>
					      	
		      		</select>	
			    </td>
			   
			    <td  width="5%" valign="top" style="padding-left: 5px">
			 			<input type="submit" name="button" value=""  class="egov-button-search" />
			 	</td>
			 	<%
			 	PortletURL addNewUrl = renderResponse.createRenderURL();
				addNewUrl.setParameter(ActionRequest.ACTION_NAME, "addEditTaoCongDan");
				addNewUrl.setParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_form.jsp");
				addNewUrl.setParameter("mode", TaoCongDanBusiness.ADD_CONGDAN); // Insert mode
				addNewUrl.setParameter("cur", String.valueOf(cur));
				addNewUrl.setParameter("delta", String.valueOf(delta));
			 	%>		
			    <td align = "right" width="25%">
			    	<input type="button" name="button" value="<%=LanguageUtil.get(pageContext, "org.oep.cmon.taocongdan.list.button.add")%>" 
			    	 class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString()%>'" style="float: right;"/>
			    	 
			    </td>
			    
			  </tr>
			  <tr>
			    <td colspan="5">
			    	<liferay-ui:error key="errorSearch" message = "org.oep.cmon.taocongdan.list.error.search"/>
			    	<liferay-ui:error key="errorDeleteTaiKhoan" message = "org.oep.cmon.taocongdan.list.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successDeleteTaiKhoan" message="org.oep.cmon.taocongdan.list.completed.delete"/>
					<%
				}
				%>
			    </td>
			 </tr>
			</table>
		</form>
<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
	<tbody>
		<tr>
			<th style="text-align:center">TT</th>
			<th style="text-align:center">Mã số CDĐT</th>	
			<th style="text-align:center">Tên</th>					
			<th style="text-align:center">CMND</th>			
			<th style="text-align:center">Email</th>			
			<th style="text-align:center">Trạng thái</th>
			<th style="text-align:center">Chức năng</th>
		</tr>
		<%
		List<CongDan> items = results;
		if (items != null && items.size() > 0) {
			for (int i = 0; i < results.size(); i++) {
				CongDan congDan = (CongDan) items.get(i);
										
			
			PortletURL viewRequestUrl = renderResponse.createRenderURL();
			viewRequestUrl.setParameter("mode", TaoCongDanBusiness.VIEW_CONGDAN);
			viewRequestUrl.setParameter("jspPage", "/html/portlet/taocongdan/view_cong_dan.jsp");
			viewRequestUrl.setParameter("congDanId", String.valueOf(congDan.getId()));			
			if (renderRequest.getParameter("searchKeyWord") != null) {
				viewRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			viewRequestUrl.setParameter("cur", String.valueOf(cur));
			viewRequestUrl.setParameter("delta", String.valueOf(delta));
			
			PortletURL editRequestUrl = renderResponse.createRenderURL();
			addNewUrl.setParameter(ActionRequest.ACTION_NAME, "addEditTaoCongDan");
			editRequestUrl.setParameter("mode", TaoCongDanBusiness.UPDATE_CONGDAN);		
			editRequestUrl.setParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_form.jsp");
			editRequestUrl.setParameter("congDanId", String.valueOf(congDan.getId()));	
			editRequestUrl.setParameter("taiKhoanCongDanId", String.valueOf(congDan.getTaiKhoanNguoiDungId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				editRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			editRequestUrl.setParameter("cur", String.valueOf(cur));
			editRequestUrl.setParameter("delta", String.valueOf(delta));
			
			PortletURL deleteUrl = renderResponse.createActionURL();
			deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteCongDanRequest");
			deleteUrl.setParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_list.jsp");
			deleteUrl.setParameter("congDanId", String.valueOf(congDan.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				deleteUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			deleteUrl.setParameter("cur", String.valueOf(cur));
			deleteUrl.setParameter("delta", String.valueOf(delta));
			String strTen = congDan.getHo() + " " + congDan.getDem() + " " + congDan.getTen();
		%>
		<tr>
			<td style="text-align:center"><%=(searchContainer.getStart() + i + 1)%></td>
			<td style="text-align:center"><%=congDan.getMa() %></td>
			<td><%=strTen %></td>
			<td style="text-align:center"><%=congDan.getSoCmnd() %></td>
			<td style="text-align:center"><%=congDan.getEmail() %></td>
			<%
			String classTrangThai = "red";
			if(congDan.getTaiKhoanNguoiDungId()!=null)
			{
				statusCD = LanguageUtil.get(pageContext,"org.oep.cmon.taocongdan.list.taikhoannguoidungid.notnull");
				classTrangThai = "blue";
			}
			else
			{
				statusCD = LanguageUtil.get(pageContext,"org.oep.cmon.taocongdan.list.taikhoannguoidungid.isnull");
				classTrangThai = "red";
			}
				%>
			<td style="text-align:center"><span class="egov-status-<%=classTrangThai%>"><%=statusCD %></span></td>
			<td width="10%" style="text-align:center">
				<table class="egov-table-function"
						style="text-align: center; width: 90px">
						<tbody>
							<tr>
							<td><a href="<%=viewRequestUrl%>">
							<button	class="egov-func-detail" title="<%=LanguageUtil.get(pageContext,"org.oep.cmon.taocongdan.list.button.view")%>"></button></a></td>
							<td>
								<%
								if(congDan.getTaiKhoanNguoiDungId()!=null){
								%>
								<a href="<%=editRequestUrl%>">
								<button	class="egov-func-edit" title="<%=LanguageUtil.get(pageContext,"org.oep.cmon.taocongdan.list.button.edit")%>"></button>
								</a>
								<%} %>
							</td>
							<td><button class="egov-func-delete" title="<%=LanguageUtil.get(pageContext,"org.oep.cmon.taocongdan.list.button.delete") %>" onclick="javascript:<portlet:namespace/>deleteRow('<%=deleteUrl.toString()%>')"></button></td>
							</tr>
						</tbody>
					</table>
				</td>
		</tr>			
			<%
				}
					} else {
			%>
			<tr>
				<td colspan="7" align="center"><label class="egov-label"><liferay-ui:message key="org.oep.cmon.taocongdan.list.nodata"/></label></td>
			</tr>
			<%
				}
			%>
			</tbody>
		</table>
		<%
			if (searchContainer != null) {
		%>
		<div id = "pagination">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
		<%
			}
		%>
</div>
<script type="text/javascript">
function <portlet:namespace/>deleteRow(url) {
	var answer = confirm('<%=LanguageUtil.get(pageContext, "org.oep.cmon.taocongdan.list.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}
	
</script>