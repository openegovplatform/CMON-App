package org.oep.sharedservice.exch.provider.soap;

import java.io.Serializable;

import com.liferay.portal.kernel.util.StringPool;

public class OSSDocumentSoap implements Serializable {

	private static final long serialVersionUID = -8450806589717350932L;

	/** Ma so ho so */
	private String maSoHoSo = StringPool.BLANK;
	
	/** Ma loai ho so */
	private String maLoaiHoSo = StringPool.BLANK;
	
	/** Ma don vi tiep nhan */
	private String maDonViTiepNhan = StringPool.BLANK;
	
	/** Ngay nop ho so */
	private String ngayNopHoSo = StringPool.BLANK;
	
	/** Ngay hen tra */
	private String ngayHenTra = StringPool.BLANK;
	
	/** Ho va ten nguoi nop */
	private String hoTenNguoiNop = StringPool.BLANK;
	
	/** So cmnd */
	private String soCmnd = StringPool.BLANK;
	
	/** Ngay sinh */
	private String ngaySinh = StringPool.BLANK;
	
	/** Ma tinh thuong tru */
	private String maTinhThuongTru = StringPool.BLANK;
	
	/** Mo ta dia chi thuong tru */
	private String moTaDiaChiThuongTru = StringPool.BLANK;
	
	/** Gioi tinh */
	private int gioiTinh = 0;
	
	/** Ma nguoi tiep nhan */
	private String maNguoiTiepNhan = StringPool.BLANK;
	
	/** Ten nguoi tiep nhan */
	private String tenNguoiTiepNhan = StringPool.BLANK;

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
	 * @return the maLoaiHoSo
	 */
	public String getMaLoaiHoSo() {
		return maLoaiHoSo;
	}

	/**
	 * @param maLoaiHoSo the maLoaiHoSo to set
	 */
	public void setMaLoaiHoSo(String maLoaiHoSo) {
		this.maLoaiHoSo = maLoaiHoSo;
	}

	/**
	 * @return the maDonViTiepNhan
	 */
	public String getMaDonViTiepNhan() {
		return maDonViTiepNhan;
	}

	/**
	 * @param maDonViTiepNhan the maDonViTiepNhan to set
	 */
	public void setMaDonViTiepNhan(String maDonViTiepNhan) {
		this.maDonViTiepNhan = maDonViTiepNhan;
	}

	/**
	 * @return the ngayNopHoSo
	 */
	public String getNgayNopHoSo() {
		return ngayNopHoSo;
	}

	/**
	 * @param ngayNopHoSo the ngayNopHoSo to set
	 */
	public void setNgayNopHoSo(String ngayNopHoSo) {
		this.ngayNopHoSo = ngayNopHoSo;
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
	 * @return the hoTenNguoiNop
	 */
	public String getHoTenNguoiNop() {
		return hoTenNguoiNop;
	}

	/**
	 * @param hoTenNguoiNop the hoTenNguoiNop to set
	 */
	public void setHoTenNguoiNop(String hoTenNguoiNop) {
		this.hoTenNguoiNop = hoTenNguoiNop;
	}

	/**
	 * @return the soCmnd
	 */
	public String getSoCmnd() {
		return soCmnd;
	}

	/**
	 * @param soCmnd the soCmnd to set
	 */
	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}

	/**
	 * @return the ngaySinh
	 */
	public String getNgaySinh() {
		return ngaySinh;
	}

	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	/**
	 * @return the maTinhThuongTru
	 */
	public String getMaTinhThuongTru() {
		return maTinhThuongTru;
	}

	/**
	 * @param maTinhThuongTru the maTinhThuongTru to set
	 */
	public void setMaTinhThuongTru(String maTinhThuongTru) {
		this.maTinhThuongTru = maTinhThuongTru;
	}

	/**
	 * @return the moTaDiaChiThuongTru
	 */
	public String getMoTaDiaChiThuongTru() {
		return moTaDiaChiThuongTru;
	}

	/**
	 * @param moTaDiaChiThuongTru the moTaDiaChiThuongTru to set
	 */
	public void setMoTaDiaChiThuongTru(String moTaDiaChiThuongTru) {
		this.moTaDiaChiThuongTru = moTaDiaChiThuongTru;
	}

	/**
	 * @return the gioiTinh
	 */
	public int getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the maNguoiTiepNhan
	 */
	public String getMaNguoiTiepNhan() {
		return maNguoiTiepNhan;
	}

	/**
	 * @param maNguoiTiepNhan the maNguoiTiepNhan to set
	 */
	public void setMaNguoiTiepNhan(String maNguoiTiepNhan) {
		this.maNguoiTiepNhan = maNguoiTiepNhan;
	}

	/**
	 * @return the tenNguoiTiepNhan
	 */
	public String getTenNguoiTiepNhan() {
		return tenNguoiTiepNhan;
	}

	/**
	 * @param tenNguoiTiepNhan the tenNguoiTiepNhan to set
	 */
	public void setTenNguoiTiepNhan(String tenNguoiTiepNhan) {
		this.tenNguoiTiepNhan = tenNguoiTiepNhan;
	}	

}
