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
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="org.oep.cmon.czprofile.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.Constants" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.xml.datatype.XMLGregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<portlet:defineObjects />
<head>
<script src="<%=request.getContextPath()%>/js/egov-common.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ui.core.js" type="text/javascript"></script>
</head>
<%
	int ACTIVATED = 0;
	String defaultSearchStr = "Nh&#7853;p m&#227; h&#7891; s&#417;";
	String profileCodeKeyword = ParamUtil.getString(request, "profileCodeKeyword", StringPool.BLANK);
	int currentTransPage = ParamUtil.getInteger(request, "currentTransPage");
	if (profileCodeKeyword.equals(StringPool.BLANK)) {
		profileCodeKeyword = defaultSearchStr;
	}
	PortletURL portletUrl = renderResponse.createRenderURL();
	portletUrl.setParameter(TransactionUtils.PARAM_VIEW_TYPE, TransactionUtils.VIEW_TRANSACTION_LIST);
	long coQuanQuanLyId = 0;
	long uid = PortalUtil.getUserId(request);
	long taikhoanNguoiDungId = -1;
	if (uid > 0) {
		try {
			TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
			taikhoanNguoiDungId = taiKhoanNguoiDung.getId();
			
		} catch (Exception e) {
			taikhoanNguoiDungId = 0;
			e.printStackTrace();
		}

		try {
			List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(taikhoanNguoiDungId);
			
			if (congChucs != null && congChucs.size() > 0) {
				coQuanQuanLyId = congChucs.get(0).getCoQuanQuanLyId();
			}
		} catch (Exception e) {
			coQuanQuanLyId = 0;
			e.printStackTrace();
		}
	}
	
	String requestUrl = PortalUtil.getCurrentURL(request);
%>

<portlet:renderURL var ="xacNhanPhiChuyenKhoan">
	<portlet:param name="typePhi" value="1"></portlet:param>
	<%-- <portlet:param name="hoSoTTHCCongId" value="1102309"></portlet:param> --%>
	<%-- <portlet:param name="thongTinThanhToanId" value="223"></portlet:param> --%>
	<portlet:param name="parentUrl" value="<%= requestUrl %>"></portlet:param>
	<portlet:param name="jspPage" value="/html/portlet/thongtinthanhtoan/xacnhanphichuyenkhoan.jsp"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var ="xacNhanPhiTienMat">
	<portlet:param name="typePhi" value="1"></portlet:param>
	<portlet:param name="parentUrl" value="<%= requestUrl %>"></portlet:param>
	<%-- <portlet:param name="hoSoTTHCCongId" value="1102309"></portlet:param> --%>
	<%-- <portlet:param name="thongTinThanhToanId" value="223"></portlet:param> --%>
	<portlet:param name="jspPage" value="/html/portlet/thongtinthanhtoan/xacnhanphitienmat.jsp"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var ="xacNhanPhiTrucTuyen">
	<portlet:param name="typePhi" value="1"></portlet:param>
	<portlet:param name="parentUrl" value="<%= requestUrl %>"></portlet:param>
	<%-- <portlet:param name="hoSoTTHCCongId" value="1102309"></portlet:param> --%>
	<%-- <portlet:param name="thongTinThanhToanId" value="223"></portlet:param> --%>
	<portlet:param name="jspPage" value="/html/portlet/thongtinthanhtoan/xacnhanphitructuyen.jsp"></portlet:param>
</portlet:renderURL>

<%-- <a href="<%= xacNhanPhiChuyenKhoan %>">xac nhan phi chuyen khoan</a> --%>
<div class="egov-container">
<form name="searchForm" method="post" action="<%=portletUrl.toString()%>" >
			<liferay-ui:success message="org.oep.registry.sucessfuly.message" key="org.oep.registry.sucessfuly.message" />

			<table cellspacing="0" cellpadding="0" class="egov-table-form" width="100%">
				<tr>
					<td colspan="3">
						<input name="profileCodeKeyword" type="text" class="egov-inputfield" size="40" value="<%=profileCodeKeyword%>" onfocus="if(this.value=='<%=defaultSearchStr%>') this.value='';"
						onblur="if(this.value=='') this.value='<%=defaultSearchStr%>'" colspan="3" style="width:50%; " />
						<input type="button" name="button" onclick="submitProfileCodeForm('<%=defaultSearchStr%>');" value="Tìm kiếm" class="egov-button-search" />
					</td>
				</tr>
				
			</table>
			<table cellspacing="0" cellpadding="0" class="egov-table" width="100%">
				<tr>
					<th scope="col" width="4%" ><liferay-ui:message key="STT" /></th>
					<th scope="col" width="10%" ><liferay-ui:message key="Mã hồ sơ" /></th>
					<th scope="col" width="10%" ><liferay-ui:message key="Mã số biên nhận" /></th>
					<th scope="col" width="24%" ><liferay-ui:message key="Dịch vụ công" /></th>
					<th scope="col" width="10%" ><liferay-ui:message key="Tổ chức, Công<br> dân nộp hồ sơ" /></th>
					<th scope="col" width="7%" ><liferay-ui:message key="Ngày nộp" /></th>
					<th scope="col" width="10%" ><liferay-ui:message key="Tiền mặt" /></th>
					<th scope="col" colspan="2" width="10%" ><liferay-ui:message key="Chuyển khoản <br> ngân hàng" /></th>
					<th scope="col" colspan="2" width="10%" ><liferay-ui:message key="Nộp phí <br>trực tuyến" /></th>
					<th scope="col" width="5%" ><liferay-ui:message key="Thao tác" /></th>
				</tr>
				<%
					String searchProfileCodeKeyword = profileCodeKeyword;
					if (searchProfileCodeKeyword.equals(defaultSearchStr)) {
						searchProfileCodeKeyword = null;
					}
					if (searchProfileCodeKeyword != null) {
						portletUrl.setParameter("profileCodeKeyword", searchProfileCodeKeyword);
					}
					SearchContainer searchContainer = null;
					if (currentTransPage > 0) {
						searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, currentTransPage, 10, portletUrl, null, null);
					} else {
						searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, portletUrl, null, null);
					}
					int start = searchContainer.getStart();
					int end = searchContainer.getEnd();

					List<ThongTinThanhToan> results = ThongTinThanhToanLocalServiceUtil.searchByCoQuanQuanLyHoSo_QT(coQuanQuanLyId, searchProfileCodeKeyword, Constants.ThongTinThanhToan.PHI, start, end);
					long longTotal = ThongTinThanhToanLocalServiceUtil.countByCoQuanQuanLyHoSo_QT(coQuanQuanLyId, searchProfileCodeKeyword, Constants.ThongTinThanhToan.PHI);
					int total = Integer.parseInt(String.valueOf(longTotal));
					searchContainer.setTotal(total);
					searchContainer.setResults(results);
					int bgColor = 2;
					for (int i = 0; i < results.size(); i++) {
						bgColor = bgColor == 1 ? 2:1;
						ThongTinThanhToan instance = (ThongTinThanhToan) results.get(i);
						HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(instance.getHoSoTTHCCongId());
				%>
				<tr class="bgcolor-<%= bgColor%>">
					<td width="4%" style="text-align: center;"><%=(searchContainer.getStart() + i + 1)%></td>
					<td width="10%" style="text-align: center;"><%=hoSoTTHCCong.getMaSoHoSo()%></td>
					<td width="10%" style="text-align: center;"><%=hoSoTTHCCong.getMaSoBienNhan() == null ? "" : hoSoTTHCCong.getMaSoBienNhan()%></td>
					<td width="24%" class="text-left"><%=hoSoTTHCCong.getTenThuTucHanhChinh()%></td>
					<td width="10%" class="text-left"><%=instance.getTenNguoiNopTien()%></td>
					<% if (instance.getLoaiThanhToan() == 1 || instance.getLoaiThanhToan() == 2) { %>
					<td width="10%" align="center" style="text-align: center;"><%=ConvertUtil.parseDateToTring(instance.getNgayThuTien())%></td>
					<% } else if (instance.getLoaiThanhToan() == 3) {%>
					<td width="10%" align="center" style="text-align: center;"><%=ConvertUtil.parseDateToTring(instance.getNgayChuyenTien())%></td>
					<% } %>
					<td width="10%">
						<% if (instance.getLoaiThanhToan() == 1 && instance.getXacNhan() == 1) { %>
							<a href="#" onclick="gotoXacNhanPhi('<%= xacNhanPhiTienMat %>','<%= hoSoTTHCCong.getId() %>','<%= instance.getId() %>', true);"><img alt="" src="<%=request.getContextPath()%>/images/xac_nhan_thanh_toan.png" title="Chi tiết thông tin nộp phí tiền mặt"></a>
						<% } %>
					</td>
					<%
						String urlPhieuChuyenKhoan = null;
						if (instance.getNoiLuuTruId() > 0) {
							int index = 0;
							while (urlPhieuChuyenKhoan == null && index < 3) {
								urlPhieuChuyenKhoan = WebserviceFactory.getOfficerService().getURLCuaGiayToDinhKem(instance.getNoiLuuTruId());
								index++;
							}
						}
					%>
					<td width="6%">
						<% 
							if (urlPhieuChuyenKhoan != null && instance.getLoaiThanhToan() == 2 && instance.getXacNhan() == 1) { %>
								<a href="<%=urlPhieuChuyenKhoan%>" style="padding: 1px">Phiếu chuyển khoản</a>
						<%	} %>
					</td>
					<td width="4%">
						<% if (instance.getLoaiThanhToan() == 2 && instance.getXacNhan() == 1) { %>
							<a href="#" onclick="gotoXacNhanPhi('<%= xacNhanPhiChuyenKhoan %>','<%= hoSoTTHCCong.getId() %>','<%= instance.getId() %>', true);"><img alt="" src="<%=request.getContextPath()%>/images/xac_nhan_thanh_toan.png" title="Chi tiết thông tin nộp phí chuyển khoản"></a>
						<% } %>
					</td>
					<td width="6%">
						<% if (instance.getLoaiThanhToan() == 3 && instance.getXacNhan() == 1) { %>
							<%=instance.getSoTien()%>
						<% } %>
					</td>
					<td width="4%">
						<% if (instance.getLoaiThanhToan() == 3 && instance.getXacNhan() == 1) { %>
							<a href="#"  onclick="gotoXacNhanPhi('<%= xacNhanPhiTrucTuyen %>','<%= hoSoTTHCCong.getId() %>','<%= instance.getId() %>', true);"><img alt="" src="<%=request.getContextPath()%>/images/xac_nhan_thanh_toan.png" title="Chi tiết thông tin nộp phí trực tuyến"></a>
						<% } %>
					</td>
					<td width="5%">
						<% if (instance.getXacNhan() == 0) { %>
							<%
								switch ((int) instance.getLoaiThanhToan()) {
										case 0:
							%>
									<a href="#" onclick="gotoXacNhanPhi('<%= xacNhanPhiTienMat %>','<%= hoSoTTHCCong.getId() %>','<% if (instance.getNgayTao() != null) {%><%= instance.getId() %><%} else {%>0<%} %>', false);" style="padding:1px;"><span class="icon-20" title="Nhập thông tin nộp phí trực tiếp"></span></a>
	<%-- 								<a href="#" onclick="gotoXacNhanPhi('<%= xacNhanPhiChuyenKhoan %>','<%= hoSoTTHCCong.getId() %>','<%= instance.getId() %>', false);" ><img alt="" src="<%=request.getContextPath()%>/images/chuyen_khoan.png" title="Nhập thông tin chuyển khoản"></a>
									<a href="#" onclick="gotoXacNhanPhi('<%= xacNhanPhiTrucTuyen %>','<%= hoSoTTHCCong.getId() %>','<%= instance.getId() %>', false);"><img alt="" src="<%=request.getContextPath()%>/images/thanh_toan_truc_tuyen.png" title="Nhập thông tin thanh toán trực tuyến"></a> --%>
							<%
											break;
										case 1:
							%>
									<a href="#" onclick="gotoXacNhanPhi('<%= xacNhanPhiTienMat %>','<%= hoSoTTHCCong.getId() %>','<% if (instance.getNgayTao() != null) {%><%= instance.getId() %><%} else {%>0<%} %>', false);" style="padding:1px;"><span class="icon-20" title="Nhập thông tin nộp phí trực tiếp"></span></a>
							<%
											break;
										case 2:
							%>
								<a href="#" onclick="gotoXacNhanPhi('<%= xacNhanPhiChuyenKhoan %>','<%= hoSoTTHCCong.getId() %>','<% if (instance.getNgayTao() != null) {%><%= instance.getId() %><%} else {%>0<%} %>', false);" style="padding:1px;"><span class="icon-22" title="Nhập thông tin chuyển khoản"></span></a>
							<%
											break;
										default:
							%>
										<a href="#" onclick="gotoXacNhanPhi('<%= xacNhanPhiTrucTuyen %>','<%= hoSoTTHCCong.getId() %>','<% if (instance.getNgayTao() != null) {%><%= instance.getId() %><%} else {%>0<%} %>', false);" style="padding:1px;"><span class="icon-21" title="Nhập thông tin thanh toán trực tuyến"></span></a>
								<%
								}
								%>
						<% } %>
					</td>
				</tr>
				<%
					}
				%>
			</table>

			<br />
			<div id="paginationTrans">
				<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
			</div>
</form>
</div>
<script type="text/javascript">
	function gotoXacNhanPhi(url, hoSoTTHCCongId, thongTinThanhToanIds, view) {
		window.location = url + "&hoSoTTHCCongId=" + hoSoTTHCCongId + "&thongTinThanhToanId=" + thongTinThanhToanIds + "&view=" + view;
	}

	if (<%=searchContainer.getStart() < 5%>) {
		var pageTrans = document.searchForm.<portlet:namespace />page;
		if (pageTrans) {
			pageTrans.value = "1";
		}
	}

	function submitProfileCodeForm(defaultSearchStr)
	{
		var form = document.searchForm;
		if (form.profileCodeKeyword.value == defaultSearchStr){
			form.profileCodeKeyword.value = "";
		}
		form.submit();
	}
</script>