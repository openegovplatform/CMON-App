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
<%@page import="org.oep.cmon.portlet.taocongdan.business.TaoCongDanBusiness"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.portlet.taocongdan.util.FormatUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/portlet/init.jsp" %>
<div>
<%
	String searchKeyWord = ParamUtil.getString(renderRequest,"CongDan_searchKeyWord");
		
	int cur =  Integer.valueOf(prefs.getValue("curCD", "1"));
	int delta =  Integer.valueOf(prefs.getValue("deltaCD", String.valueOf(Constants.Paging.DELTA)));
	int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
	int deltanext = ParamUtil.getInteger(renderRequest, "delta", Constants.Paging.DELTA);
	if(curnext!=cur) {
		cur = curnext;
	}
	if(deltanext!=delta) {
		delta = deltanext;
	}
	
	PortletURL searchCongDanUrl = renderResponse.createRenderURL();
	searchCongDanUrl.setWindowState(LiferayWindowState.EXCLUSIVE);
	searchCongDanUrl.setParameter("jspPage", "/html/portlet/taocongdan/cong_dan_popup.jsp");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setWindowState(LiferayWindowState.EXCLUSIVE);
	iteratorUrl.setParameter("jspPage", "/html/portlet/taocongdan/cong_dan_popup.jsp");
	
	if(!FormatUtil.isEmpty(searchKeyWord)) {
		iteratorUrl.setParameter("CongDan_searchKeyWord", searchKeyWord);
	}
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, iteratorUrl, null, null);
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();

	List<CongDan> list = TaoCongDanBusiness.findByCongDan(searchKeyWord, String.valueOf(Constants.TaoCongDan.CHUA_CO_TAI_KHOAN), start, end);
	long count = TaoCongDanBusiness.countByCongDan(searchKeyWord, String.valueOf(Constants.TaoCongDan.CHUA_CO_TAI_KHOAN));
	
	searchContainer.setTotal((int)count);
	searchContainer.setResults(list);
	
%>
<div class="egov-container" id="__congdan_popup">
	<form name = "<portlet:namespace/>searchCongDanForm" method="post" action="">
		<table class="egov-table-form" style="width: 100%">
		  <tr>
		    <td align="left" width="60%">
		    	<input name="searchKeyWord" id="<portlet:namespace/>_searchKeyWord" style="width: 90%;" type="text" value="<%=HtmlUtil.escape(searchKeyWord) %>" class="egov-inputfield-search"
		    		placeholder="<liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.search.keyword"/>"/>
		    </td>
		    
		    <td align="left" valign="middle">	
		 		<input type="button" onclick="<portlet:namespace/>_searchCongDan();" value="" title="<liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.search.submit"/>" class="egov-button-search" />
		 	</td>	
		  </tr>
		</table>
	</form>
	<table cellpadding="0" cellspacing="0" class="egov-table" width="100%"  >
		<tbody>
			<tr>
				<th width="5%" style="text-align: center;padding: 10px 5px;"><liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.list.stt"/></th>
				<th width="20%" style="text-align: center;padding: 10px 5px;"><liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.list.ma"/></th>
				<th width="35%" style="text-align: center;padding: 10px 5px;"><liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.list.hovaten"/></th>
				<th width="15%" style="text-align: center;padding: 10px 5px;"><liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.list.cmnd_hochieu"/></th>
				<th width="10%" style="text-align: center;padding: 10px 5px;"><liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.list.ngaysinh"/></th>
				<th width="10%" style="text-align: center;padding: 10px 5px;"><liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.list.email"/></th>
				<th width="5%" style="text-align: center;padding: 10px 5px;"><liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.list.chon"/></th>
			</tr>
			<%
			if(!FormatUtil.isEmpty(list)) {
				for (int i = 0; i < list.size(); i++) {
					CongDan congDan = list.get(i);
					String strTen = congDan.getHo() + " " + congDan.getDem() + " " + congDan.getTen();
			%>
			<tr>
				<td style="text-align: center;padding: 0;"><%=(i+1)%></td>
				<td style="text-align: center;padding: 0;"><%=HtmlUtil.escape(congDan.getMa())%></td>
				<td style="text-align: left;padding: 0; padding-left: 5px;"><%=HtmlUtil.escape(strTen)%></td>
				<td style="text-align: center;padding: 0;"><%=HtmlUtil.escape(congDan.getSoCmnd())%></td>
				<td style="text-align: center;padding: 0;"><%=FormatUtil.getFormatDate(congDan.getNgaySinh())%></td>
				<td style="text-align: center;padding: 0;"><%=HtmlUtil.escape(congDan.getEmail())%></td>
				<td style="text-align: center;padding: 0;">
					<input type="radio" name="id" id="<portlet:namespace/>_id" value="<%=congDan.getId()%>" class="egov-radio" title="<liferay-ui:message key="vn.dtt.vsattp.cosokinhdoanh.popup.congdan.item.chon"/>">
					<input type="hidden" id="<portlet:namespace/>_ho_<%=congDan.getId()%>" value="<%=HtmlUtil.escape(congDan.getHo())%>">
					<input type="hidden" id="<portlet:namespace/>_dem_<%=congDan.getId()%>" value="<%=HtmlUtil.escape(congDan.getDem())%>">
					<input type="hidden" id="<portlet:namespace/>_ten_<%=congDan.getId()%>" value="<%=HtmlUtil.escape(congDan.getTen())%>">
					<input type="hidden" id="<portlet:namespace/>_email_<%=congDan.getId()%>" value="<%=HtmlUtil.escape(congDan.getEmail())%>">
					<input type="hidden" id="<portlet:namespace/>_ngaySinh_<%=congDan.getId()%>" value="<%=HtmlUtil.escape(FormatUtil.getFormatDate(congDan.getNgaySinh()))%>">
					<input type="hidden" id="<portlet:namespace/>_soCMND_<%=congDan.getId()%>" value="<%=HtmlUtil.escape(congDan.getSoCmnd())%>">
					<input type="hidden" id="<portlet:namespace/>_ngayCap_<%=congDan.getId()%>" value="<%=HtmlUtil.escape(FormatUtil.getFormatDate(congDan.getNgayCapCmnd()))%>">
					<input type="hidden" id="<portlet:namespace/>_noiCapId_<%=congDan.getId()%>" value="<%=String.valueOf(congDan.getNoiCapCmndId())%>">
					<input type="hidden" id="<portlet:namespace/>_quocTichId_<%=congDan.getId()%>" value="<%=String.valueOf(congDan.getQuocTichId())%>">
					<input type="hidden" id="<portlet:namespace/>_gioiTinhId_<%=congDan.getId()%>" value="<%=String.valueOf(congDan.getGioiTinh())%>">
					<input type="hidden" id="<portlet:namespace/>_danTocId_<%=congDan.getId()%>" value="<%=String.valueOf(congDan.getDanTocId())%>">
					<input type="hidden" id="<portlet:namespace/>_tonGiaoId_<%=congDan.getId()%>" value="<%=String.valueOf(congDan.getTonGiaoId())%>">
					<input type="hidden" id="<portlet:namespace/>_diaChiThuongTru_<%=congDan.getId()%>" value="<%=HtmlUtil.escape(congDan.getDiaChiThuongTru())%>">
					<input type="hidden" id="<portlet:namespace/>_tinhId_<%=congDan.getId()%>" value="<%=congDan.getDiaChiThuongTruTinhId()%>">
					<input type="hidden" id="<portlet:namespace/>_huyenId_<%=congDan.getId()%>" value="<%=congDan.getDiaChiThuongTruHuyenId()%>">
					<input type="hidden" id="<portlet:namespace/>_xaId_<%=congDan.getId()%>" value="<%=congDan.getDiaChiThuongTruXaId()%>">
				</td>
			</tr>
			<%
				}
			} else {
			%>
			<tr>
				<td colspan="7" align="center" style="padding: 0;"><label class="egov-label">
					<liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.list.search.noData"/></label></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<div id="pagination">
		<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
	</div>
	<div class="egov-button-bar">
	<br>
		<table cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td align="left">
					<button id="<portlet:namespace/>_select" class="egov-button-normal" 
						title="<liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.select"/>" 
						onclick="javascript: <portlet:namespace/>_onSelect();"><liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.select"/></button>
					<button id="<portlet:namespace/>_closeForm" class="egov-button-normal" 
						title="" 
						onclick="javascript: <portlet:namespace/>_onClose();"><liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.close"/></button>
				</td>
			</tr>
		</table>
	</div>
<aui:script>
function <portlet:namespace/>_onSelect() {
	var id = $('#__congdan_popup').find('#<portlet:namespace/>_id:checked').val();
	if(id == null) {
		return alert('<liferay-ui:message key="vn.dtt.cmon.taocongdan.popup.empty"/>');
	}
	var ten = $('#__congdan_popup').find('#<portlet:namespace/>_ten_' + id).val();
	var ho = $('#__congdan_popup').find('#<portlet:namespace/>_ho_' + id).val();
	var dem = $('#__congdan_popup').find('#<portlet:namespace/>_dem_' + id).val();
	var email = $('#__congdan_popup').find('#<portlet:namespace/>_email_' + id).val();
	var ngaySinh = $('#__congdan_popup').find('#<portlet:namespace/>_ngaySinh_' + id).val();
	var gioiTinhId = $('#__congdan_popup').find('#<portlet:namespace/>_gioiTinhId_' + id).val();
	var soCMND = $('#__congdan_popup').find('#<portlet:namespace/>_soCMND_' + id).val();
	var ngayCap = $('#__congdan_popup').find('#<portlet:namespace/>_ngayCap_' + id).val();
	var noiCapId = $('#__congdan_popup').find('#<portlet:namespace/>_noiCapId_' + id).val();
	var quocTichId = $('#__congdan_popup').find('#<portlet:namespace/>_quocTichId_' + id).val();
	var diaChiThuongTru= $('#__congdan_popup').find('#<portlet:namespace/>_diaChiThuongTru_' + id).val();

	var danTocId = $('#__congdan_popup').find('#<portlet:namespace/>_danTocId_' + id).val();
	var tonGiaoId = $('#__congdan_popup').find('#<portlet:namespace/>_tonGiaoId_' + id).val();
	var tinhId = $('#__congdan_popup').find('#<portlet:namespace/>_tinhId_' + id).val();
	var huyenId = $('#__congdan_popup').find('#<portlet:namespace/>_huyenId_' + id).val();
	var xaId = $('#__congdan_popup').find('#<portlet:namespace/>_xaId_' + id).val();
	
	var data = {
			'id' : id,
			'ten' : ten,
			'ho' : ho,
			'dem' : dem,
			'email' : email,
			'ngaySinh' : ngaySinh,
			'email' : email,
			'gioiTinhId' : gioiTinhId,
			'soCMND' : soCMND,
			'ngayCap' : ngayCap,
			'noiCapId' : noiCapId,
			'quocTichId' : quocTichId,
			'diaChiThuongTru' : diaChiThuongTru,
			'danTocId' : danTocId,
			'tonGiaoId' : tonGiaoId,
			'tinhId' : tinhId,
			'huyenId' : huyenId,
			'xaId' : xaId
		};
	
	Liferay.Util.getOpener().onSelectCongDan(data, this);
	AUI().DialogManager.closeByChild('#<portlet:namespace/>_closeForm');
}

function <portlet:namespace/>_onClose() {
	AUI().DialogManager.closeByChild('#<portlet:namespace/>_closeForm');
}
function <portlet:namespace/>_searchCongDan() {
	var searchKeyWord = $('#__congdan_popup').find('#<portlet:namespace/>_searchKeyWord').val();
	
	$.ajax({
		url : '<%=searchCongDanUrl.toString()%>',
		type : 'post', 
		data : {
			'CongDan_searchKeyWord' : searchKeyWord,			
		},
		success : function(data) {
			$('#__congdan_popup').html($(data).find('#__congdan_popup').html());
		},
		error : function(xhr, ajaxOptions, thrownError) {
//			alert(xhr.status);
//			alert(thrownError);
		}
	});
}

function <portlet:namespace/>_iterator(url, param) {
	if(param) {
		url = url + param;
	}
	$.ajax({
		url : url,
		type : 'post', 
		success : function(data) {
			$('#__congdan_popup').html($(data).find('#__congdan_popup').html());
		},
		error : function(xhr, ajaxOptions, thrownError) {
//			alert(xhr.status);
//			alert(thrownError);
		}
	});
}

$(window).keydown(function(event){
	if(event.keyCode == 27) {
		$('#closeForm').trigger('click');
	} else if(event.keyCode == 13) {
		<portlet:namespace/>_searchCongDan();
		return false;
	}
});

$(".delta-selector").hide(0); // Will hide the div and free its space.
$(".delta-selector").css('visibility', 'hidden');
AUI().ready('aui-io-plugin','node', function(A) {
	var paginatorBar = A.one('.taglib-page-iterator');
	if(typeof paginatorBar !== "undefined" && paginatorBar != null) {
		paginatorBar.all('a').on('click',function(event) {
			event.preventDefault();
			var uri = event.currentTarget.get('href').replace('normal', 'exclusive');
			<portlet:namespace/>_iterator(uri);
		});
		var url = paginatorBar.one('a').get('href').replace('normal', 'exclusive');
		url = url.substring(0, url.length - 1);

		var page = A.one('#<portlet:namespace />page').getDOM();+
		$(page).attr('onchange','<portlet:namespace/>_iterator(\''+url+'\',$(this).val())');
	}
});

</aui:script>
</div>
</div>