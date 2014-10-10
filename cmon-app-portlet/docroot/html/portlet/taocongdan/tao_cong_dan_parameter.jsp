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
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.taocongdan.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.portlet.taocongdan.action.TaoCongDanPortlet"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/init.jsp"%>

<portlet:resourceURL var="listDVHC" id="listDVHC" />

<%

	String strTaiKhoanCongDanId = ParamUtil.getString(request, "taiKhoanCongDanId");	
	String strCongDanId = ParamUtil.getString(request, "congDanId");
	
	CongDan congDan1 = CongDanLocalServiceUtil.fetchCongDan(ConvertUtil.convertToLong(strCongDanId));
	
	//long congDanId = 0;
	//long taiKhoanCongDanId =0;
	String selected = "";
	String mode = ParamUtil.getString(request, "mode", "");	
	String keyWord = request.getParameter("searchKeyWord");
	String taiKhoanNguoiDungId = ParamUtil.getString(request,"taiKhoanNguoiDungId", "");
	
	PortletURL actionUrl =  renderResponse.createActionURL();	
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "addEditTaoCongDan");
	
	PortletURL redirectUrl = renderResponse.createRenderURL();
	redirectUrl.setParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_form.jsp");
	redirectUrl.setParameter("mode", mode); // Insert mode
	redirectUrl.setParameter("congDanId", strCongDanId ); // congDanId
	redirectUrl.setParameter("taiKhoanCongDanId", strTaiKhoanCongDanId ); // taiKhoanCongDanId
		
	TaoCongDanPortlet portlet = new TaoCongDanPortlet();
 	//Create upload avatar URL
 	PortletURL backUrl = renderResponse.createRenderURL();
	backUrl.setParameter("jspPage","/html/portlet/taocongdan/tao_cong_dan_list.jsp");
 	if (keyWord != null) {
 		backUrl.setParameter("searchKeyWord", keyWord);
 	}
 	portlet.setSearchParameter(backUrl, renderRequest);
	
	//Get taikhoancongdang
	if ( Validator.isNull (strTaiKhoanCongDanId)) {
		strTaiKhoanCongDanId = "";
	}
	if(Validator.isNull (strCongDanId)){
		strCongDanId="";
	}		
	
	CongDan congDan = null;
	if (strCongDanId.trim().length() > 0) {
		congDan = CongDanLocalServiceUtil.fetchCongDan(FormatUtil.convertToLong(strCongDanId));
	}	
	TaiKhoanNguoiDung taiKhoanNguoiDung = null;
	if (strTaiKhoanCongDanId.trim().length() > 0) {
		taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(FormatUtil.convertToLong(strTaiKhoanCongDanId));
	}
	
	Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_TK_CONG_DAN_OBJECT");
	
	
	if(congDan!=null)
	{
		userRequest = new HashMap<String, String>();	
		if(taiKhoanNguoiDung !=null){
			userRequest.put("email", taiKhoanNguoiDung.getEmail());  
		}
		userRequest.put("email", congDan.getEmail());
		
		userRequest.put("matKhau", "");
   		userRequest.put("congDanId", String.valueOf(congDan.getId()));
   		userRequest.put("taiKhoanCongDanId", String.valueOf(congDan.getTaiKhoanNguoiDungId()));
   		userRequest.put("ho", congDan.getHo());
   		userRequest.put("dem", congDan.getDem());
   		userRequest.put("ten", congDan.getTen());
   		userRequest.put("ngaySinh", FormatUtil.parseDateToString(congDan.getNgaySinh()));
   		userRequest.put("soCmnd", congDan.getSoCmnd());
   		userRequest.put("ngayCapCmnd", FormatUtil.parseDateToString(congDan.getNgayCapCmnd()));
   		userRequest.put("noiCapCmndId", String.valueOf(congDan.getNoiCapCmndId()));
   		userRequest.put("gioiTinh", String.valueOf(congDan.getGioiTinh()));		
   		userRequest.put("danTocId", String.valueOf(congDan.getDanTocId()));
   		userRequest.put("quocTichId", String.valueOf(congDan.getQuocTichId()));
   		userRequest.put("tonGiaoId", String.valueOf(congDan.getTonGiaoId()));
   		userRequest.put("diaChiThuongTruTinhId", String.valueOf(congDan.getDiaChiThuongTruTinhId()));
   		userRequest.put("diaChiThuongTruHuyenId", String.valueOf(congDan.getDiaChiThuongTruHuyenId()));
   		userRequest.put("diaChiThuongTruXaId", String.valueOf(congDan.getDiaChiThuongTruXaId()));
   		userRequest.put("diaChiThuongTru", congDan.getDiaChiThuongTru());
	}
	
   	if (userRequest == null) {
   		
   		userRequest = new HashMap<String, String>();
   		userRequest.put("email", "");   		
   		userRequest.put("matKhau", "");
   		userRequest.put("congDanId","");
   		userRequest.put("taiKhoanCongDanId","");
   		userRequest.put("ho", "");
   		userRequest.put("dem", "");
   		userRequest.put("ten", "");
   		userRequest.put("ngaySinh", "");
   		userRequest.put("soCmnd", "");
   		userRequest.put("ngayCapCmnd", "");
   		userRequest.put("noiCapCmndId", "");
   		userRequest.put("gioiTinh", "0");		
   		userRequest.put("danTocId", "0");
   		userRequest.put("tonGiaoId", "0");
   		userRequest.put("diaChiThuongTruTinhId", "0");
   		userRequest.put("diaChiThuongTruHuyenId", "0");
   		userRequest.put("diaChiThuongTruXaId", "0");
   		userRequest.put("diaChiThuongTru", "");
   		
   	}
		
%>
<script type="text/javascript">

	var listDVHC 		= '<%=listDVHC%>';
	var form_action		= '<%=mode%>';
	
</script>