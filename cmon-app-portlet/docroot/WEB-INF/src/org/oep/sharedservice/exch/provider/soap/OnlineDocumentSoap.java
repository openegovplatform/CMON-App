package org.oep.sharedservice.exch.provider.soap;

import java.io.Serializable;
import java.util.ArrayList;

import com.liferay.portal.kernel.util.StringPool;

public class OnlineDocumentSoap implements Serializable {
	
	private static final long serialVersionUID = 7087091961049813003L;

	/** ID cua record tai he thong */
	private long onlineId = 0l;
	
	/** Ma loai ho so */
	private String maLoaiHoSo = StringPool.BLANK;
	
	/** Ma don vi tiep nhan */
	private String maDonViTiepNhan = StringPool.BLANK;
	
	/** Ho va ten nguoi nop */
	private String hoTenNguoiNop = StringPool.BLANK;
	
	/** Dia chi nguoi nop */
	private String diaChiNguoiNop = StringPool.BLANK;
	
	/** Ngay sinh */
	private String ngaySinh = StringPool.BLANK;
	
	/** So CMND */
	private String soCmnd = StringPool.BLANK;
	
	/** Email */
	private String email = StringPool.BLANK;
	
	/** So dien thoai di dong */
	private String soDtDiDong = StringPool.BLANK;
	
	/** So dien thoai co dinh */
	private String soDtCoDinh = StringPool.BLANK;
	
	/** Ngay dang ky ho so */
	private String ngayDangKyHoSo = StringPool.BLANK;
	
	/** Gioi tinh cong dan */
	private int gioiTinh = 0;
	
	/** Chu so huu ho so */
	private String chuSoHuuHoSo = StringPool.BLANK;
	
	/** Attachment list cua ho so */
	private ArrayList<OnlineAttachmentSoap> attachmentList = new ArrayList<OnlineAttachmentSoap>();
	
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
	 * @return the diaChiNguoiNop
	 */
	public String getDiaChiNguoiNop() {
		return diaChiNguoiNop;
	}

	/**
	 * @param diaChiNguoiNop the diaChiNguoiNop to set
	 */
	public void setDiaChiNguoiNop(String diaChiNguoiNop) {
		this.diaChiNguoiNop = diaChiNguoiNop;
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
	 * @return the soCmnd
	 */
	public String getSoCmnd() {
		return soCmnd;
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
	 * @return the chuSoHuuHoSo
	 */
	public String getChuSoHuuHoSo() {
		return chuSoHuuHoSo;
	}

	/**
	 * @param chuSoHuuHoSo the chuSoHuuHoSo to set
	 */
	public void setChuSoHuuHoSo(String chuSoHuuHoSo) {
		this.chuSoHuuHoSo = chuSoHuuHoSo;
	}

	/**
	 * @param soCmnd the soCmnd to set
	 */
	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the soDtDiDong
	 */
	public String getSoDtDiDong() {
		return soDtDiDong;
	}

	/**
	 * @param soDtDiDong the soDtDiDong to set
	 */
	public void setSoDtDiDong(String soDtDiDong) {
		this.soDtDiDong = soDtDiDong;
	}

	/**
	 * @return the soDtCoDinh
	 */
	public String getSoDtCoDinh() {
		return soDtCoDinh;
	}

	/**
	 * @param soDtCoDinh the soDtCoDinh to set
	 */
	public void setSoDtCoDinh(String soDtCoDinh) {
		this.soDtCoDinh = soDtCoDinh;
	}

	/**
	 * @return the ngayDangKyHoSo
	 */
	public String getNgayDangKyHoSo() {
		return ngayDangKyHoSo;
	}

	/**
	 * @param ngayDangKyHoSo the ngayDangKyHoSo to set
	 */
	public void setNgayDangKyHoSo(String ngayDangKyHoSo) {
		this.ngayDangKyHoSo = ngayDangKyHoSo;
	}

	/**
	 * @return the attachmentList
	 */
	public ArrayList<OnlineAttachmentSoap> getAttachmentList() {
		return attachmentList;
	}

	/**
	 * @param attachmentList the attachmentList to set
	 */
	public void setAttachmentList(ArrayList<OnlineAttachmentSoap> attachmentList) {
		this.attachmentList = attachmentList;
	}
}
