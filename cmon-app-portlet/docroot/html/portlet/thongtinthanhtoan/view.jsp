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
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page import="org.oep.cmon.Constants" %>
<div class="wd-main-content.brms">
	<div id="wd-tab-data">
			<%
				String thongTinThanhToanPrefParam = Constants.ThongTinThanhToan.THONG_TIN_THANH_TOAN_PREF_PARAM;
				String thongTinThanhToanPrefValue = portletPreferences.getValue(thongTinThanhToanPrefParam, "" + Constants.ThongTinThanhToan.PHI);
				int thongTinThanhToan_view = GetterUtil.getInteger(thongTinThanhToanPrefValue);
				if(thongTinThanhToan_view == Constants.ThongTinThanhToan.LE_PHI) {
			%> 
				<%@include file="/html/portlet/thongtinthanhtoan/lePhiList.jsp"%>
			<%
				} else {
			%>			
				<%@include file="/html/portlet/thongtinthanhtoan/phiList.jsp" %>
			<%	} %>
	</div>
</div>

