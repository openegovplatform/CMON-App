package org.oep.cmon.dao.beans.thongtinthutuc;

import org.oep.egovcore.jsptag.optionlist.OptionData;


public interface ThongTinThuTuc extends OptionData {
	public void setThuTucId(long thuTucId);
	public long getThuTucId();
	public void setMaThuTuc(String maThuTuc);
	public String getMaThuTuc();
	public void setTenThuTuc(String tenThuTuc);
	public String getTenThuTuc();
	public void setNhomThuTucId(long nhomThuTucId);
	public long getNhomThuTucId();
	public void setMaNhomThuTuc(String maNhomThuTuc);
	public String getMaNhomThuTuc();
	public void setTenNhomThuTuc(String tenNhomThuTuc);
	public String getTenNhomThuTuc();
	public void setDanhMucUngDungId(long danhMucUngDungId);
	public long getDanhMucUngDungId();
	public void setMaDanhMucUngDung(String maDanhMucUngDung);
	public String getMaDanhMucUngDung();
	public void setTenDanhMucUngDung(String tenDanhMucUngDung);
	public String getTenDanhMucUngDung();
	public void setThuocUngDungCongAn(boolean thuocUngDungCongAn);
	public boolean getThuocUngDungCongAn();
}