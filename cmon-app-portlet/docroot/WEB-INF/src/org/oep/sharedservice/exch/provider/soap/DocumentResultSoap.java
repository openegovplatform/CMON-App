package org.oep.sharedservice.exch.provider.soap;

import java.io.Serializable;

import com.liferay.portal.kernel.util.StringPool;

public class DocumentResultSoap implements Serializable {

	private static final long serialVersionUID = -5440935003300467219L;

	/** Ma so ho so */
	private String maSoHoSo = StringPool.BLANK;
	
	/** Ten nguoi nhan ket qua */
	private String tenNguoiNhanKetQua = StringPool.BLANK;
	
	/** Ngay nhan ket qua */
	private String ngayNhanKetQua = StringPool.BLANK;
	
	/** Le phi ho so */
	private int lePhiHoSo = 0;
	
	/** Phi xu ly ho so */
	private int phiXuLyHoSo = 0;
	
	/**
	 * @return the phiXuLyHoSo
	 */
	public int getPhiXuLyHoSo() {
		return phiXuLyHoSo;
	}

	/**
	 * @param phiXuLyHoSo the phiXuLyHoSo to set
	 */
	public void setPhiXuLyHoSo(int phiXuLyHoSo) {
		this.phiXuLyHoSo = phiXuLyHoSo;
	}

	/** Ngay hoan thanh */
	private String ngayHoanThanh = StringPool.BLANK;
	
	/** Ma can bo tra ket qua */
	private String maCanBoTraKetQua = StringPool.BLANK;
	
	/** Ten can bo tra ket qua */
	private String tenCanBoTraKetQua = StringPool.BLANK;

	/**
	 * @return the maSoHoSo
	 */
	public String getMaSoHoSo() {
		return maSoHoSo;
	}

	/**
	 * @param maSoHoSo the maSoHoSo to set
	 */
	public void setMaSoHoSo(String maSoHoSo) {
		this.maSoHoSo = maSoHoSo;
	}

	/**
	 * @return the tenNguoiNhanKetQua
	 */
	public String getTenNguoiNhanKetQua() {
		return tenNguoiNhanKetQua;
	}

	/**
	 * @param tenNguoiNhanKetQua the tenNguoiNhanKetQua to set
	 */
	public void setTenNguoiNhanKetQua(String tenNguoiNhanKetQua) {
		this.tenNguoiNhanKetQua = tenNguoiNhanKetQua;
	}

	/**
	 * @return the ngayNhanKetQua
	 */
	public String getNgayNhanKetQua() {
		return ngayNhanKetQua;
	}

	/**
	 * @param ngayNhanKetQua the ngayNhanKetQua to set
	 */
	public void setNgayNhanKetQua(String ngayNhanKetQua) {
		this.ngayNhanKetQua = ngayNhanKetQua;
	}

	/**
	 * @return the lePhiHoSo
	 */
	public int getLePhiHoSo() {
		return lePhiHoSo;
	}

	/**
	 * @param lePhiHoSo the lePhiHoSo to set
	 */
	public void setLePhiHoSo(int lePhiHoSo) {
		this.lePhiHoSo = lePhiHoSo;
	}

	/**
	 * @return the ngayHoanThanh
	 */
	public String getNgayHoanThanh() {
		return ngayHoanThanh;
	}

	/**
	 * @param ngayHoanThanh the ngayHoanThanh to set
	 */
	public void setNgayHoanThanh(String ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}

	/**
	 * @return the maCanBoTraKetQua
	 */
	public String getMaCanBoTraKetQua() {
		return maCanBoTraKetQua;
	}

	/**
	 * @param maCanBoTraKetQua the maCanBoTraKetQua to set
	 */
	public void setMaCanBoTraKetQua(String maCanBoTraKetQua) {
		this.maCanBoTraKetQua = maCanBoTraKetQua;
	}

	/**
	 * @return the tenCanBoTraKetQua
	 */
	public String getTenCanBoTraKetQua() {
		return tenCanBoTraKetQua;
	}

	/**
	 * @param tenCanBoTraKetQua the tenCanBoTraKetQua to set
	 */
	public void setTenCanBoTraKetQua(String tenCanBoTraKetQua) {
		this.tenCanBoTraKetQua = tenCanBoTraKetQua;
	}
}
