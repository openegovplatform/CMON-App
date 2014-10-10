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
<%@page import="java.net.URLDecoder"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="java.util.Collections"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="java.util.Date"%>
<%@page import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.egovcore.language.CmonMessagerUtil"%>
<%@page import="org.oep.egovcore.language.CmonMessager"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.egovcore.language.cmonkey.Label"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	long thuTucId = HSRParamUtil.getLong(request,HoSoFields.thuTucHanhChinhId);
	String
	 	tenThuTuc = StringPool.BLANK
	, 	dienThoai = StringPool.BLANK;
	List<ThuTuc2GiayTo> listGiayTo = Collections.emptyList();
	CmonMessager label = CmonMessagerUtil.forPrefix(Label.PREFIX);
	
	ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(thuTucId);
	
	if (thuTuc != null) {
		tenThuTuc = thuTuc.getTen();
		listGiayTo = ThuTuc2GiayToLocalServiceUtil.getDSGiayToTheoThuTuc(
			thuTucId, Constants.ACTIVE, Constants.GIAIDOAN_GIAYTO_DAUVAO);
	}

	CongChuc canBo = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request));
	CoQuanQuanLy coQuan = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(
		canBo.getCoQuanQuanLyId()
	);
	
	String maCapCQQL = CapCoQuanQuanLyLocalServiceUtil.
		fetchCapCoQuanQuanLy(coQuan.getCapCoQuanQuanlyId()).getMa().trim();
	
	boolean laTinhHuyenXa = 
		maCapCQQL.equals(ThamSoLocalServiceUtil.getValue("CMON_CAP_CQQL_TINH_MA"))
		|| maCapCQQL.equals(ThamSoLocalServiceUtil.getValue("CMON_CAP_CQQL_QUAN_HUYEN_MA"))
		|| maCapCQQL.equals(ThamSoLocalServiceUtil.getValue("CMON_CAP_CQQL_PHUONG_XA_MA"));
	
%>
<link href="${pageContext.request.contextPath}/css/in_huong_dan_thu_tuc.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
$(function() {
	
	var $stextarea = $('#giayto_input');
	
	$('#print_button').click(function() {
		$('#to_be_printed').print(
			[
			 '${pageContext.request.contextPath}/css/core.css'
			 ,'${pageContext.request.contextPath}/css/in_huong_dan_thu_tuc.css'
			 ],
			function() {
				var $body = $(this.body);
				$body.find('textarea').parent().remove();
				$body.find('#to_be_filled').show()
					.find('.egov-label').html(
						$stextarea.val()
							.replace(/^\s+$/gm, '')
							.replace(/^\n/gm, '')
							.replace(/^\s+(\d)/gm, '$1')
							.replace(/\n/gm, '<br>')
					);
			}
		);
	});
	
	$('#exit_button').click(function() {
		window.opener.__child.close();
	});
	
	var $giayToInput = $('#giayto_input');
	
	$giayToInput.val(
		$giayToInput.val().trim()
			.replace(/^\s+$/gm, '')
			.replace(/^\n/gm, '')
			.replace(/^\s+(\d)/gm, '$1')
	);
	$giayToInput.focusToEnd();
	
	// #SPECIAL_DATA_PASSING (search #SPECIAL_DATA_PASSING in "/html/portlet/hosotructiep/default.jsp" for more detail)
	$('#hoTenCongDan').text(__hoTenNguoiNopHoSo);
});
</script>
<div class="_outer egov-container preview">
	<div class="hidden-sep">&nbsp;</div>
	<div id="to_be_printed">
		<div class="_wrapper">
			<div class="line septop10 nonsepbot">
				<div class="item fi30 center nonsepbot">
					<label class="egov-label upper ubnd">
					<% if (laTinhHuyenXa) { %>
						UBND <c:out value='<%= DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(coQuan.getDonViHanhChinhId()).getTen() %>'/>
					<% } else {  %>
					 	<c:out value='<%= CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuan.getChaId()).getTen() %>'/>
					<% } %>
					</label>
				</div>
				<div class="item fi70 center nonsepbot">
					<label class="egov-label strong upper"><c:out value='<%=label.get(Label.chxhcnvn)%>'/></label>
				</div>
			</div>
			<div class="line nonseptop">
				<div class="item fi30 center">
					<label class="egov-label strong upper underline">
					<% if (laTinhHuyenXa) { %>
					 	Bộ phận TN&amp;TKQ
					<% } else {  %>
						<c:out value='<%= coQuan.getTen() %>'/>
					<% } %>
					</label>
				</div>
				<div class="item fi70 center">
					<label class="egov-label strong underline"><c:out value='<%=label.get(Label.dltdhp)%>'/></label>
				</div>
			</div>
			<div class="line">
				<div class="item fi30 center sobiennhan">
					<label class="egov-label">Số: ................</label>
					<label class="egov-label"></label>
				</div>
			</div>
			<div class="line septop20 sepbot20">
				<div class="item center">
					<label class="egov-label strong upper">Phiếu hướng dẫn</label>
					<br>
					<label class="egov-label upper">Thực hiện thủ tục hành chính</label>
				</div>
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label">Hồ sơ của Ông (Bà):</label>
					<label class="egov-label strong" id="hoTenCongDan"></label>
				</div>
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label">Loại thủ tục:</label>
					<label class="egov-label strong"><c:out value="<%= tenThuTuc %>" /></label>
				</div>
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label">Đề nghị Ông (Bà) bổ sung các loại giấy tờ sau:</label>
				</div>
			</div>
			<div>
				<textarea class="egov-textarea" id="giayto_input" autocomplete="off" rows="15" style="font-size: 1.2em">
					<% int i = 1; %>
					<% for(ThuTuc2GiayTo gt : listGiayTo) { %>
						<%= i ++ %>. <c:out value='<%= DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(gt.getDanhMucGiayToId()).getTen() %>'/>
					<% } %>
				</textarea>
			</div>
			<div id="to_be_filled" class="line sepleft15" style="display: none;">
				<div class="item">
					<label class="egov-label em">
					
					</label>
				</div>
			</div>
			<div class="line">
				<div class="item">
					<label class="egov-label">Để biết thêm thông tin về thủ tục hành chính, tình trạng xử lý hồ sơ,
						Ông (Bà) vui lòng gọi điện thoại đến số <%= coQuan.getDienThoai() %>. Khi đi ông (bà) nhớ đem theo chứng minh nhân dân.
					</label>
				</div>
			</div>
			<div class="line septop10">
				<div class="item right fi50 center">
					<label class="egov-label em">
						Đà Nẵng, <%= DateTimeUtil.getDayMonthYearLong(DateTimeUtil.getDateTimeNow()) %>
					</label>
				</div>
			</div>
			<div class="line">
				<div class="item right fi50 center">
					<label class="egov-label strong upper">Người hướng dẫn</label>
				</div>
			</div>
			<div class="line huong-dan-vien">
				<div class="item right fi50 center">
					<label class="egov-label strong">
						<c:out value="<%= canBo.getHoVaTen() %>"/>
					</label>
				</div>
			</div>
		</div>
	</div>
	<div class="button-bar">
		<button id="print_button" type="button" class="egov-button">In hướng dẫn</button>
		<button id="exit_button" type="button" class="egov-button">Thoát</button>
	</div>
	<div class="hidden-sep">&nbsp;</div>
</div>
