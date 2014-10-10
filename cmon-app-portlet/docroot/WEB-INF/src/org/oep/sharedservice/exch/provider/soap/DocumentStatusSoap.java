package org.oep.sharedservice.exch.provider.soap;

import java.io.Serializable;

import com.liferay.portal.kernel.util.StringPool;

public class DocumentStatusSoap implements Serializable {
	
	private static final long serialVersionUID = -4351388580015905139L;

	/** ID cua record  */
	private long onlineId = 0l;
	
	/** Ma so ho so */
	private String maSoHoSo = StringPool.BLANK;
	
	/** Ngay hen tra */
	private String ngayHenTra = StringPool.BLANK;
	
	/** Ma nguoi xu ly hien tai */
	private String maNguoiXuLyHienTai = StringPool.BLANK;
	
	/** Ten nguoi xu ly hien tai */
	private String tenNguoiXuLyHienTai = StringPool.BLANK;
	
	/** Ten phong ban xu ly hien tai */
	private String tenPhongBanXuLyHienTai = StringPool.BLANK;
	
	/** Ngay gio thuc hien luan chuyen dd/mm/yyyy hh:mm:ss */
	private String ngayGioLuanChuyen = StringPool.BLANK;
	
	/** So gio yeu cau xu ly */
	private int soGioYeuCauXuLy = 0;
	
	/** Noi dung yeu cau xu ly */
	private String noiDungYeuCauXuLy = StringPool.BLANK;
	
	/** So gio thuc hien */
	private int soGioThucHien = 0;
	
	/** Trang thai hien tai */
	private int trangThaiHienTai = -1;
	
	/** Ma nguoi xu ly ke tiep */
	private String maNguoiXuLyKeTiep = StringPool.BLANK;
	
	/** Ten nguoi xu ly ke tiep */
	private String tenNguoiXuLyKeTiep = StringPool.BLANK;
	
	/** Ten phong ban xu ly ke tiep */
	private String tenPhongBanXuLyKeTiep = StringPool.BLANK;
	
	/** Trang thai ke tiep */
	private int trangThaiKeTiep = -1;

	/**
	 * @return the onlineId
	 */
	public long getOnlineId() {
		return onlineId;
	}

	/**
	 * @param onlineId the onlineId to set
	 */
	public void setOnlineId(long onlineId) {
		this.onlineId = onlineId;
	}

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
	 * @return the ngayHenTra
	 */
	public String getNgayHenTra() {
		return ngayHenTra;
	}

	/**
	 * @param ngayHenTra the ngayHenTra to set
	 */
	public void setNgayHenTra(String ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}

	/**
	 * @return the maNguoiXuLyHienTai
	 */
	public String getMaNguoiXuLyHienTai() {
		return maNguoiXuLyHienTai;
	}

	/**
	 * @param maNguoiXuLyHienTai the maNguoiXuLyHienTai to set
	 */
	public void setMaNguoiXuLyHienTai(String maNguoiXuLyHienTai) {
		this.maNguoiXuLyHienTai = maNguoiXuLyHienTai;
	}

	/**
	 * @return the tenNguoiXuLyHienTai
	 */
	public String getTenNguoiXuLyHienTai() {
		return tenNguoiXuLyHienTai;
	}

	/**
	 * @param tenNguoiXuLyHienTai the tenNguoiXuLyHienTai to set
	 */
	public void setTenNguoiXuLyHienTai(String tenNguoiXuLyHienTai) {
		this.tenNguoiXuLyHienTai = tenNguoiXuLyHienTai;
	}

	/**
	 * @return the tenPhongBanXuLyHienTai
	 */
	public String getTenPhongBanXuLyHienTai() {
		return tenPhongBanXuLyHienTai;
	}

	/**
	 * @param tenPhongBanXuLyHienTai the tenPhongBanXuLyHienTai to set
	 */
	public void setTenPhongBanXuLyHienTai(String tenPhongBanXuLyHienTai) {
		this.tenPhongBanXuLyHienTai = tenPhongBanXuLyHienTai;
	}

	/**
	 * @return the ngayGioLuanChuyen
	 */
	public String getNgayGioLuanChuyen() {
		return ngayGioLuanChuyen;
	}

	/**
	 * @param ngayGioLuanChuyen the ngayGioLuanChuyen to set
	 */
	public void setNgayGioLuanChuyen(String ngayGioLuanChuyen) {
		this.ngayGioLuanChuyen = ngayGioLuanChuyen;
	}

	/**
	 * @return the soGioYeuCauXuLy
	 */
	public int getSoGioYeuCauXuLy() {
		return soGioYeuCauXuLy;
	}

	/**
	 * @param soGioYeuCauXuLy the soGioYeuCauXuLy to set
	 */
	public void setSoGioYeuCauXuLy(int soGioYeuCauXuLy) {
		this.soGioYeuCauXuLy = soGioYeuCauXuLy;
	}

	/**
	 * @return the noiDungYeuCauXuLy
	 */
	public String getNoiDungYeuCauXuLy() {
		return noiDungYeuCauXuLy;
	}

	/**
	 * @param noiDungYeuCauXuLy the noiDungYeuCauXuLy to set
	 */
	public void setNoiDungYeuCauXuLy(String noiDungYeuCauXuLy) {
		this.noiDungYeuCauXuLy = noiDungYeuCauXuLy;
	}

	/**
	 * @return the soGioThucHien
	 */
	public int getSoGioThucHien() {
		return soGioThucHien;
	}

	/**
	 * @param soGioThucHien the soGioThucHien to set
	 */
	public void setSoGioThucHien(int soGioThucHien) {
		this.soGioThucHien = soGioThucHien;
	}

	/**
	 * @return the trangThaiHienTai
	 */
	public int getTrangThaiHienTai() {
		return trangThaiHienTai;
	}

	/**
	 * @param trangThaiHienTai the trangThaiHienTai to set
	 */
	public void setTrangThaiHienTai(int trangThaiHienTai) {
		this.trangThaiHienTai = trangThaiHienTai;
	}

	/**
	 * @return the maNguoiXuLyKeTiep
	 */
	public String getMaNguoiXuLyKeTiep() {
		return maNguoiXuLyKeTiep;
	}

	/**
	 * @param maNguoiXuLyKeTiep the maNguoiXuLyKeTiep to set
	 */
	public void setMaNguoiXuLyKeTiep(String maNguoiXuLyKeTiep) {
		this.maNguoiXuLyKeTiep = maNguoiXuLyKeTiep;
	}

	/**
	 * @return the tenNguoiXuLyKeTiep
	 */
	public String getTenNguoiXuLyKeTiep() {
		return tenNguoiXuLyKeTiep;
	}

	/**
	 * @param tenNguoiXuLyKeTiep the tenNguoiXuLyKeTiep to set
	 */
	public void setTenNguoiXuLyKeTiep(String tenNguoiXuLyKeTiep) {
		this.tenNguoiXuLyKeTiep = tenNguoiXuLyKeTiep;
	}

	/**
	 * @return the tenPhongBanXuLyKeTiep
	 */
	public String getTenPhongBanXuLyKeTiep() {
		return tenPhongBanXuLyKeTiep;
	}

	/**
	 * @param tenPhongBanXuLyKeTiep the tenPhongBanXuLyKeTiep to set
	 */
	public void setTenPhongBanXuLyKeTiep(String tenPhongBanXuLyKeTiep) {
		this.tenPhongBanXuLyKeTiep = tenPhongBanXuLyKeTiep;
	}

	/**
	 * @return the trangThaiKeTiep
	 */
	public int getTrangThaiKeTiep() {
		return trangThaiKeTiep;
	}

	/**
	 * @param trangThaiKeTiep the trangThaiKeTiep to set
	 */
	public void setTrangThaiKeTiep(int trangThaiKeTiep) {
		this.trangThaiKeTiep = trangThaiKeTiep;
	}
}
