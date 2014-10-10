package org.oep.sharedservice.cmon.provider.model;

import org.oep.cmon.dao.tlct.model.DanhMucGiayToSoap;

import org.oep.cmon.dao.tlct.model.TaiLieuChungThucSoap;

public class TaiLieuDinhKem extends DanhMucGiayToSoap{
	
	private static final long serialVersionUID = 1L;
	private TaiLieuChungThucSoap tailieuChungThuc;
	private String url;
	private boolean batBuoc;
	private Long thuTuc2GiayToId;
	private TaiLieuDinhKem taiLieuThayThe;
	
	
	/**
	 * 
	 */
	
	public TaiLieuDinhKem(DanhMucGiayToSoap model){
		setId(model.getId());
		setMa(model.getMa());
		setTen(model.getTen());
		setMota(model.getMota());
		setGioiHanDungLuong(model.getGioiHanDungLuong());
		setKieuTaiLieu(model.getKieuTaiLieu());
		setNguoiTao(model.getNguoiTao());
		setNgayTao(model.getNgayTao());
		setNguoiSua(model.getNguoiSua());
		setNgaySua(model.getNgaySua());
		setDaXoa(model.getDaXoa());
		setPhienBan(model.getPhienBan());
	}
	
	
	
	
	

	public Long getThuTuc2GiayToId() {
		return thuTuc2GiayToId;
	}






	public void setThuTuc2GiayToId(Long thuTuc2GiayToId) {
		this.thuTuc2GiayToId = thuTuc2GiayToId;
	}






	public TaiLieuDinhKem getTaiLieuThayThe() {
		return taiLieuThayThe;
	}






	public void setTaiLieuThayThe(TaiLieuDinhKem taiLieuThayThe) {
		this.taiLieuThayThe = taiLieuThayThe;
	}






	public boolean isBatBuoc() {
		return batBuoc;
	}

	public void setBatBuoc(boolean batBuoc) {
		this.batBuoc = batBuoc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TaiLieuChungThucSoap getTailieuChungThuc() {
		return tailieuChungThuc;
	}

	public void setTailieuChungThuc(TaiLieuChungThucSoap tailieuChungThuc) {
		this.tailieuChungThuc = tailieuChungThuc;
	}
	
	

}
