<%--
/*
 * Copyright (c) 2014 by OpeneGovPlatform (http:////openegovplatform.org).
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
 */
--%>
Module này được phát triển theo chuẩn Portlet JSR 286 chạy trên nền tảng Liferay Portal CE-GA1


A. Hướng dẫn cài đặt và phát triển
1. Dowload Liferay Portal tích hợp sẵn tomcat tại địa chỉ : 
   http://sourceforge.net/projects/lportal/files/Liferay%20Portal/6.1.0%20GA1/liferay-portal-tomcat-6.1.0-ce-ga1-20120106155615760.zip/download
2. Download Liferay SDK 6.1 GA1 tại địa chỉ 
   http://sourceforge.net/projects/lportal/files/Liferay%20Portal/6.1.0%20GA1/liferay-plugins-sdk-6.1.0-ce-ga1-20120106155615760.zip/download
3. Tham khảo cách cấu hình cài đặt môi trường phát triển Liferay cùng Eclipse tại link:
    http://www.liferay.com/community/wiki/-/wiki/Main/Liferay+IDE+Getting+Started+Tutorial
4. Checkout module cùng với loại dự án của liferay là :  "Liferay Project" và chọn Plugin type là "Portlet" tại đỉa chị:
   https://github.com/openegovplatform/CMON-App/tree/master/cmon-app-portlet
5. Lấy script tạo database và master data với script cho mysql tại địa chỉ
   https://github.com/openegovplatform/Data-Model/tree/master/db-create-scripts
6. Cấu hình datasource cho ứng dụng đến database chuẩn  trong file portal-setup-wizard.properties trong thư mục
     %FOLDER_HOME%\liferay-portal-6.1.0-ce-ga1

      #config datasource for Open eGovPlatform application
	 jdbc.egov.driverClassName=
	 jdbc.egov.url=
	 jdbc.egov.username= 
	 jdbc.egov.password=

7. Deploy thành công và kéo portlet tại chuyên mục "Open eGovPlatform" ra  và sử dụng







