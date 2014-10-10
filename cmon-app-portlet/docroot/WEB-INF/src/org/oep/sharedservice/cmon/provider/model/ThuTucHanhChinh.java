package org.oep.sharedservice.cmon.provider.model;

import java.util.List;

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhSoap;

public class ThuTucHanhChinh extends ThuTucHanhChinhSoap {
	
	/**
	 * 
	 */
	public ThuTucHanhChinh(ThuTucHanhChinhSoap model){
		setId(model.getId());
		setMa(model.getMa());
		setTen(model.getTen());
		setSoNgayXuLy(model.getSoNgayXuLy());
		setNgayTao(model.getNgayTao());
		setNgaySua(model.getNgaySua());
		setDaXoa(model.getDaXoa());
		setNguoiTao(model.getNguoiTao());
		setNguoiSua(model.getNguoiSua());
		setNhomThuTucHanhChinhId(model.getNhomThuTucHanhChinhId());
		setTrangThai(model.getTrangThai());
		setPhienBan(model.getPhienBan());
		
	}
	
	private static final long serialVersionUID = 1L;
	
	
	private List<TaiLieuDinhKem> taiLieuDinhKems;


	public List<TaiLieuDinhKem> getTaiLieuDinhKems() {
		return taiLieuDinhKems;
	}


	public void setTaiLieuDinhKems(List<TaiLieuDinhKem> taiLieuDinhKems) {
		this.taiLieuDinhKems = taiLieuDinhKems;
	}
	
	
	
	

}
