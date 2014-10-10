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

package org.oep.cmon.portlet.ipmslist.business;

/**
 * This is class FileKetQua
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class FileKetQua {

	private long danhMucGiayToId;
	private long thuTuc2GiayToId;
	private String maTaiLieu;
	private String tenTaiLieu;
	private String kieuTaiLieu;
	private int batBuoc;
	private long gioiHanDungLuong;

	public FileKetQua() {
	}

	/**
	 * @return the batBuoc
	 */
	public int getBatBuoc() {
		return batBuoc;
	}

	/**
	 * @param batBuoc the batBuoc to set
	 */
	public void setBatBuoc(int batBuoc) {
		this.batBuoc = batBuoc;
	}

	/**
	 * @return the danhMucGiayToId
	 */
	public long getDanhMucGiayToId() {
		return danhMucGiayToId;
	}
	/**
	 * @param danhMucGiayToId the danhMucGiayToId to set
	 */
	public void setDanhMucGiayToId(long danhMucGiayToId) {
		this.danhMucGiayToId = danhMucGiayToId;
	}
	/**
	 * @return the thuTuc2GiayToId
	 */
	public long getThuTuc2GiayToId() {
		return thuTuc2GiayToId;
	}
	/**
	 * @param thuTuc2GiayToId the thuTuc2GiayToId to set
	 */
	public void setThuTuc2GiayToId(long thuTuc2GiayToId) {
		this.thuTuc2GiayToId = thuTuc2GiayToId;
	}
	/**
	 * @return the maTaiLieu
	 */
	public String getMaTaiLieu() {
		return maTaiLieu;
	}
	/**
	 * @param maTaiLieu the maTaiLieu to set
	 */
	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}
	/**
	 * @return the tenTaiLieu
	 */
	public String getTenTaiLieu() {
		return tenTaiLieu;
	}
	/**
	 * @param tenTaiLieu the tenTaiLieu to set
	 */
	public void setTenTaiLieu(String tenTaiLieu) {
		this.tenTaiLieu = tenTaiLieu;
	}
	/**
	 * @return the kieuTaiLieu
	 */
	public String getKieuTaiLieu() {
		return kieuTaiLieu;
	}
	/**
	 * @param kieuTaiLieu the kieuTaiLieu to set
	 */
	public void setKieuTaiLieu(String kieuTaiLieu) {
		this.kieuTaiLieu = kieuTaiLieu;
	}
	/**
	 * @return the gioiHanDungLuong
	 */
	public long getGioiHanDungLuong() {
		return gioiHanDungLuong;
	}
	/**
	 * @param gioiHanDungLuong the gioiHanDungLuong to set
	 */
	public void setGioiHanDungLuong(long gioiHanDungLuong) {
		this.gioiHanDungLuong = gioiHanDungLuong;
	}
	
}
