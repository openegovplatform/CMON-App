package org.oep.cmon.dao.beans.giaytodinhkem;

public interface GiayToDinhKem {
	public void setThuTuc2GiayToId(Long thuTuc2GiayToId);
	public Long getThuTuc2GiayToId(boolean notNull);
	public void setDanhMucGiayToId(Long danhMucGiayToId);
	public Long getDanhMucGiayToId(boolean notNull);
	public void setTenGiayTo(String tenGiayTo);
	public String getTenGiayTo();
	public void setDinhDangChoPhep(String dinhDangChoPhep);
	public String getDinhDangChoPhep();
	public void setGioiHanDungLuong(long gioiHanDungLuong);
	public long getGioiHanDungLuong();
}