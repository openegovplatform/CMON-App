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
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="org.oep.cmon.dao.touchscreen.service.TouchScreenLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cổng dịch vụ công trực tuyến thành phố Đà Nẵng</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<%
    PortletPreferences prefs = renderRequest.getPreferences();
    String portletResource = ParamUtil.getString(request, "portletResource");
    if(Validator.isNotNull(portletResource)){
    	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
    }
    String id_donvi = prefs.getValue("id_donvi","0");
%>
<body>
	<div class="background">
		<div class="header-full">
			<div class="container-header">
				<!-- Banner -->
				<div class="lt-header col-head-4">
					<div class="bglt-header">
						<div class="logolt-header">
							<img
								src="<%=request.getContextPath()%>/html/portlet/touchscreen/images/logo.png" />
						</div>
					</div>
				</div>
				<div class="rt-header col-head-8 ">
					<div class="bgrt-header">
						<div class="logort-header">
							<div class="bn-header collapse">
								<img
									src="<%=request.getContextPath()%>/html/portlet/touchscreen/images/banner.png" />
							</div>
							<div class="rt-action">
								<div class="rt-button">
									<%
                            	PortletURL home = renderResponse.createRenderURL();
                            	home.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
                            	home.setParameter("viewPage","/html/portlet/touchscreen/slidehoso.jsp");
                            	
                            	PortletURL lookup = renderResponse.createRenderURL();
                            	lookup.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
                            	lookup.setParameter("viewPage","/html/portlet/touchscreen/lookup.jsp");
                            	
                            	PortletURL lookupTTHC = renderResponse.createRenderURL();
                            	lookupTTHC.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
                            	if(id_donvi.equals("0")){
                            		lookupTTHC.setParameter("viewPage","/html/portlet/touchscreen/tthccapcoquan.jsp");
                            	}else{
                            		lookupTTHC.setParameter("viewPage","/html/portlet/touchscreen/tthcnhomtthc.jsp");
                            	}
                            	
                            	%>
								<ul class="rt-button">
                                    <li class="bthome"><a href="<%=home.toString()%>"></a></li>
                                    <li class="btsearch"><a href="<%=lookup.toString()%>"></a></li>
                                    <li class="btlist"><a href="<%=lookupTTHC.toString()%>"></a></li>
                                </ul>
								</div>
							</div>
						</div>
					</div>
					<div class="mrt-header collapse"></div>
					<div class="brt-header collapse"></div>
				</div>
			</div>
			<!-- /container-header -->
		</div>

		<div class="content-full">
			<div class="container">
				<%
        	String viewPage = request.getParameter("viewPage")!=null?request.getParameter("viewPage"):"/html/portlet/touchscreen/slidehoso.jsp";
        	%>
				<jsp:include page="<%=viewPage%>"></jsp:include>
			</div>
		</div>
		<%
Calendar cal = Calendar.getInstance();
Long hosotructiep = TouchScreenLocalServiceUtil.countHoSoTrucTiep(1,String.valueOf(cal.get(Calendar.YEAR)));
Long hosotructuyen = TouchScreenLocalServiceUtil.countHoSoTrucTiep(0,String.valueOf(cal.get(Calendar.YEAR)));
Long hosodangxuly = TouchScreenLocalServiceUtil.countHoSoByTrangThai("1,12,15",String.valueOf(cal.get(Calendar.YEAR)),"");
Long truocthoihan = TouchScreenLocalServiceUtil.countHoSoByTrangThai("5",String.valueOf(cal.get(Calendar.YEAR)),"som");
Long dungthoihan = TouchScreenLocalServiceUtil.countHoSoByTrangThai("5",String.valueOf(cal.get(Calendar.YEAR)),"dung");
Long quathoihan = TouchScreenLocalServiceUtil.countHoSoByTrangThai("5",String.valueOf(cal.get(Calendar.YEAR)),"tre");
%>
		<div class="footer-full hidden-mobile">
			<div class="container">
				<div class="result-block">
					<div class="block">
						<div class="line black"></div>
						<div class="cont-block">
							<h3><%=hosotructiep%></h3>
							<p>Hồ sơ trực tiếp</p>
						</div>
					</div>
					<div class="block">
						<div class="line lightgreen"></div>
						<div class="cont-block">
							<h3><%=hosotructuyen%></h3>
							<p>Hồ sơ trực tuyến</p>
						</div>
					</div>
					<div class="block">
						<div class="line yellow"></div>
						<div class="cont-block">
							<h3><%=hosodangxuly%></h3>
							<p>Hồ sơ đang xử lý</p>
						</div>
					</div>
					<div class="block">
						<div class="line darkgreen"></div>
						<div class="cont-block">
							<h3><%=truocthoihan%></h3>
							<p>Hồ sơ hoàn thành trước thời hạn</p>
						</div>
					</div>
					<div class="block">
						<div class="line lightblue"></div>
						<div class="cont-block">
							<h3><%=dungthoihan%></h3>
							<p>Hồ sơ hoàn thành đúng thời hạn</p>
						</div>
					</div>
					<div class="block">
						<div class="line darkorgance"></div>
						<div class="cont-block">
							<h3><%=quathoihan%></h3>
							<p>Hồ sơ quá thời hạn</p>
						</div>
					</div>
				</div>
				<!--/result-block-->

				<div class="footer-block">
					<div class="info">
						<p>
							Chủ đầu tư:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
								href="http://tttt.danang.gov.vn" class="bold color">Sở Thông
								tin và Truyền thông</a> &nbsp;&nbsp; <a href="#" class="bold color">Ban
								Quản lý dự án</a>
						<p>
						<p>
							Đơn vị thực hiện: <img
								src="<%=request.getContextPath()%>/html/portlet/touchscreen/images/hyundai.png" />
							| <img
								src="<%=request.getContextPath()%>/html/portlet/touchscreen/images/dtt.png" />
						</p>
						<p>
							Đơn vị phối hợp:&nbsp; <img
								src="<%=request.getContextPath()%>/html/portlet/touchscreen/images/tcx.png" />
							| <img
								src="<%=request.getContextPath()%>/html/portlet/touchscreen/images/vidagis.png" />
							| <img
								src="<%=request.getContextPath()%>/html/portlet/touchscreen/images/unitech.png" />
							| <img
								src="<%=request.getContextPath()%>/html/portlet/touchscreen/images/softech.png" />
						</p>
					</div>
					<div class="copyright bold color">
						<p>Copyright &copy;2013 Danang E-Gov Service</p>
					</div>
				</div>
				<!--/footer-block-->
			</div>
			<!--/container-->
		</div>

		<%if(viewPage.equals("/html/portlet/touchscreen/lookup.jsp")){%>
		<script language="javascript">
			$(document).ready(function() {
				var $write = $('#masohs');
				$('#keyboard li span').click(function(){
					var $this = $(this);
					character = $this.html(); 
						
					if ($this.hasClass('bksp')) {
						var html = $write.val();				 
						$write.val(html.substr(0, html.length - 1));
						return false;
					}
					$write.val($write.val() + character);
				});	
				$('#btn-tracuu').click(function(){
					if($('#masohs').val()!=""){
						document.searchform.submit();
					}else{
						alert("Vui lòng nhập mã số biên nhận");
					}
				});
				$('#btn-reset').click(function(){
					$('#masohs').val("");
					$('#masohs').focus();
				});
				
			});
		</script>
		<%}else{%>
		<script language="javascript">
			$(document).ready(function() {
				$("#dichvucong").owlCarousel({
					autoPlay : 5000,
					stopOnHover : true,
					navigation : true,
					responsive : true,
					paginationSpeed : 2000,
					goToFirstSpeed : 4000,
					singleItem : true
				});
			});
		</script>
		<%}%>
	</div>
</body>
</html>
