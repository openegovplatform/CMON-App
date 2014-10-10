/*
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
 */

package org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils;

import java.util.Date;

public class CongDanFormModelView {
	
	private String primaryKey;	
	private String ma;
	private String ho;	
	private String dem;
	private String ten;
	private String gioiTinhId;	
	
	private String quocTichId;
	private String danTocId;
	
	private String diaChiHienNayTinhId;
	private String diaChiHienNayHuyenId;
	private String diaChiHienNayXaId;
	private String diaChiHienNay;
	
	private String diaChiThuongTruTinhId;
	private String diaChiThuongTruHuyenId;
	private String diaChiThuongTruXaId;
	private String diaChiThuongTru;
	
	
	private String soCMND;
	private Date ngayCapCmnd;	
	private String noiCapCmndId;
	private String email;
	
	private Date ngaySinh;
	
	private String dienThoaiDiDong;
	private String fax;
	private String website;
	
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String getPrimaryKey) {
		this.primaryKey = getPrimaryKey;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getDem() {
		return dem;
	}
	public void setDem(String dem) {
		this.dem = dem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinhId() {
		return gioiTinhId;
	}
	public void setGioiTinhId(String gioiTinhId) {
		this.gioiTinhId = gioiTinhId;
	}
	public String getQuocTichId() {
		return quocTichId;
	}
	public void setQuocTichId(String quocTichId) {
		this.quocTichId = quocTichId;
	}
	public String getDanTocId() {
		return danTocId;
	}
	public void setDanTocId(String danTocId) {
		this.danTocId = danTocId;
	}
	public String getDiaChiHienNayTinhId() {
		return diaChiHienNayTinhId;
	}
	public void setDiaChiHienNayTinhId(String diaChiHienNayTinhId) {
		this.diaChiHienNayTinhId = diaChiHienNayTinhId;
	}
	public String getDiaChiHienNayHuyenId() {
		return diaChiHienNayHuyenId;
	}
	public void setDiaChiHienNayHuyenId(String diaChiHienNayHuyenId) {
		this.diaChiHienNayHuyenId = diaChiHienNayHuyenId;
	}
	public String getDiaChiHienNayXaId() {
		return diaChiHienNayXaId;
	}
	public void setDiaChiHienNayXaId(String diaChiHienNayXaId) {
		this.diaChiHienNayXaId = diaChiHienNayXaId;
	}
	
	public String getDiaChiHienNay() {
		return diaChiHienNay;
	}
	public void setDiaChiHienNay(String diaChiHienNay) {
		this.diaChiHienNay = diaChiHienNay;
	}
	public String getDiaChiThuongTruTinhId() {
		return diaChiThuongTruTinhId;
	}
	public void setDiaChiThuongTruTinhId(String diaChiThuongTruTinhId) {
		this.diaChiThuongTruTinhId = diaChiThuongTruTinhId;
	}
	public String getDiaChiThuongTruHuyenId() {
		return diaChiThuongTruHuyenId;
	}
	public void setDiaChiThuongTruHuyenId(String diaChiThuongTruHuyenId) {
		this.diaChiThuongTruHuyenId = diaChiThuongTruHuyenId;
	}
	public String getDiaChiThuongTruXaId() {
		return diaChiThuongTruXaId;
	}
	public void setDiaChiThuongTruXaId(String diaChiThuongTruXaId) {
		this.diaChiThuongTruXaId = diaChiThuongTruXaId;
	}
	public String getDiaChiThuongTru() {
		return diaChiThuongTru;
	}
	public void setDiaChiThuongTru(String diaChiThuongTru) {
		this.diaChiThuongTru = diaChiThuongTru;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public Date getNgayCapCmnd() {
		return ngayCapCmnd;
	}
	public void setNgayCapCmnd(Date ngayCapCmnd) {
		this.ngayCapCmnd = ngayCapCmnd;
	}
	public String getNoiCapCmndId() {
		return noiCapCmndId;
	}
	public void setNoiCapCmndId(String noiCapCmndId) {
		this.noiCapCmndId = noiCapCmndId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDienThoaiDiDong() {
		return dienThoaiDiDong;
	}
	public void setDienThoaiDiDong(String dienThoaiDiDong) {
		this.dienThoaiDiDong = dienThoaiDiDong;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
}
