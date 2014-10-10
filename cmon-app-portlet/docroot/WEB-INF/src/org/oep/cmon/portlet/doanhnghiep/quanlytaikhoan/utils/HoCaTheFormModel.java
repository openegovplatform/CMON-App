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

public class HoCaTheFormModel {
	
	private String primaryKey;	
	private String emailDangNhap;
	//NDD
	private String hoTenNDD;
	private String ngaySinhNDD;
	private String gioiTinhNDD;
	private String quocTichNDD;
	private String danTocNDD;
	
	private String soCMNDNDD;
	private String ngayCapCMNDNDD;
	private String noiCapCMNDNDD;
	
	private String tinhTTNDD;
	private String huyenTTNDD;
	private String xaTTNDD;
	private String moTaTTNDD;
	
	private String tinhHTNDD;
	private String huyenHTNDD;
	private String xaHTNDD;
	private String moTaHTNDD;
	
	private String dTNDD;
	private String faxNDD;
	private String emailTNDD;
	private String webNDD;
	
	//HCT
	private String tenHCT;
	private String maGPHCT;
	private String tinhHCT;
	private String huyenHCT;
	private String xaHCT;
	private String chiTietDCHCT;
	
	private String maThueHCT;
	private String ngayDKHCT;
	private String vonKDHCT;
	
	private String dTHCT;
	private String faxHCT;
	private String emailHCT;
	private String webHCT;
	
	private boolean check;
	
	private String moTaNganhNghe;
	
	private String[] nganhNgheDuocChon;
	
	String[][] dsThanhVien;
	
	public String[][] getDsThanhVien() {
		return dsThanhVien;
	}
	public void setDsThanhVien(String[][] dsThanhVien) {
		this.dsThanhVien = dsThanhVien;
	}
	private int mode;
	
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getEmailDangNhap() {
		return emailDangNhap;
	}
	public void setEmailDangNhap(String emailDangNhap) {
		this.emailDangNhap = emailDangNhap;
	}
	public String getHoTenNDD() {
		return hoTenNDD;
	}
	public void setHoTenNDD(String hoTenNDD) {
		this.hoTenNDD = hoTenNDD;
	}
	public String getNgaySinhNDD() {
		return ngaySinhNDD;
	}
	public void setNgaySinhNDD(String ngaySinhNDD) {
		this.ngaySinhNDD = ngaySinhNDD;
	}
	public String getGioiTinhNDD() {
		return gioiTinhNDD;
	}
	public void setGioiTinhNDD(String gioiTinhNDD) {
		this.gioiTinhNDD = gioiTinhNDD;
	}
	public String getQuocTichNDD() {
		return quocTichNDD;
	}
	public void setQuocTichNDD(String quocTichNDD) {
		this.quocTichNDD = quocTichNDD;
	}
	public String getDanTocNDD() {
		return danTocNDD;
	}
	public void setDanTocNDD(String danTocNDD) {
		this.danTocNDD = danTocNDD;
	}
	public String getSoCMNDNDD() {
		return soCMNDNDD;
	}
	public void setSoCMNDNDD(String soCMNDNDD) {
		this.soCMNDNDD = soCMNDNDD;
	}
	public String getNgayCapCMNDNDD() {
		return ngayCapCMNDNDD;
	}
	public void setNgayCapCMNDNDD(String ngayCapCMNDNDD) {
		this.ngayCapCMNDNDD = ngayCapCMNDNDD;
	}
	public String getNoiCapCMNDNDD() {
		return noiCapCMNDNDD;
	}
	public void setNoiCapCMNDNDD(String noiCapCMNDNDD) {
		this.noiCapCMNDNDD = noiCapCMNDNDD;
	}
	public String getTinhTTNDD() {
		return tinhTTNDD;
	}
	public void setTinhTTNDD(String tinhTTNDD) {
		this.tinhTTNDD = tinhTTNDD;
	}
	public String getHuyenTTNDD() {
		return huyenTTNDD;
	}
	public void setHuyenTTNDD(String huyenTTNDD) {
		this.huyenTTNDD = huyenTTNDD;
	}
	public String getXaTTNDD() {
		return xaTTNDD;
	}
	public void setXaTTNDD(String xaTTNDD) {
		this.xaTTNDD = xaTTNDD;
	}
	public String getMoTaTTNDD() {
		return moTaTTNDD;
	}
	public void setMoTaTTNDD(String moTaTTNDD) {
		this.moTaTTNDD = moTaTTNDD;
	}
	public String getTinhHTNDD() {
		return tinhHTNDD;
	}
	public void setTinhHTNDD(String tinhHTNDD) {
		this.tinhHTNDD = tinhHTNDD;
	}
	public String getHuyenHTNDD() {
		return huyenHTNDD;
	}
	public void setHuyenHTNDD(String huyenHTNDD) {
		this.huyenHTNDD = huyenHTNDD;
	}
	public String getXaHTNDD() {
		return xaHTNDD;
	}
	public void setXaHTNDD(String xaHTNDD) {
		this.xaHTNDD = xaHTNDD;
	}
	public String getMoTaHTNDD() {
		return moTaHTNDD;
	}
	public void setMoTaHTNDD(String moTaHTNDD) {
		this.moTaHTNDD = moTaHTNDD;
	}
	public String getdTNDD() {
		return dTNDD;
	}
	public void setdTNDD(String dTNDD) {
		this.dTNDD = dTNDD;
	}
	public String getFaxNDD() {
		return faxNDD;
	}
	public void setFaxNDD(String faxNDD) {
		this.faxNDD = faxNDD;
	}
	public String getEmailTNDD() {
		return emailTNDD;
	}
	public void setEmailTNDD(String emailTNDD) {
		this.emailTNDD = emailTNDD;
	}
	public String getWebNDD() {
		return webNDD;
	}
	public void setWebNDD(String webNDD) {
		this.webNDD = webNDD;
	}
	public String getTenHCT() {
		return tenHCT;
	}
	public void setTenHCT(String tenHCT) {
		this.tenHCT = tenHCT;
	}
	public String getMaGPHCT() {
		return maGPHCT;
	}
	public void setMaGPHCT(String maGPHCT) {
		this.maGPHCT = maGPHCT;
	}
	public String getTinhHCT() {
		return tinhHCT;
	}
	public void setTinhHCT(String tinhHCT) {
		this.tinhHCT = tinhHCT;
	}
	public String getHuyenHCT() {
		return huyenHCT;
	}
	public void setHuyenHCT(String huyenHCT) {
		this.huyenHCT = huyenHCT;
	}
	public String getXaHCT() {
		return xaHCT;
	}
	public void setXaHCT(String xaHCT) {
		this.xaHCT = xaHCT;
	}
	public String getChiTietDCHCT() {
		return chiTietDCHCT;
	}
	public void setChiTietDCHCT(String chiTietDCHCT) {
		this.chiTietDCHCT = chiTietDCHCT;
	}
	public String getMaThueHCT() {
		return maThueHCT;
	}
	public void setMaThueHCT(String maThueHCT) {
		this.maThueHCT = maThueHCT;
	}
	public String getNgayDKHCT() {
		return ngayDKHCT;
	}
	public void setNgayDKHCT(String ngayDKHCT) {
		this.ngayDKHCT = ngayDKHCT;
	}
	public String getVonKDHCT() {
		return vonKDHCT;
	}
	public void setVonKDHCT(String vonKDHCT) {
		this.vonKDHCT = vonKDHCT;
	}
	public String getdTHCT() {
		return dTHCT;
	}
	public void setdTHCT(String dTHCT) {
		this.dTHCT = dTHCT;
	}
	public String getFaxHCT() {
		return faxHCT;
	}
	public void setFaxHCT(String faxHCT) {
		this.faxHCT = faxHCT;
	}
	public String getEmailHCT() {
		return emailHCT;
	}
	public void setEmailHCT(String emailHCT) {
		this.emailHCT = emailHCT;
	}
	public String getWebHCT() {
		return webHCT;
	}
	public void setWebHCT(String webHCT) {
		this.webHCT = webHCT;
	}
	public String getMoTaNganhNghe() {
		return moTaNganhNghe;
	}
	public void setMoTaNganhNghe(String moTaNganhNghe) {
		this.moTaNganhNghe = moTaNganhNghe;
	}
	public String[] getNganhNgheDuocChon() {
		return nganhNgheDuocChon;
	}
	public void setNganhNgheDuocChon(String[] nganhNgheDuocChon) {
		this.nganhNgheDuocChon = nganhNgheDuocChon;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
}
