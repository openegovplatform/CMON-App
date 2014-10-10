package org.oep.cmon.dao.beans.giaytodinhkemhoso;

import org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKem;

public interface GiayToDinhKemHoSo extends GiayToDinhKem {
	public void setFileDinhKemId(long fileDinhKemId);
	public long getFileDinhKemId();
	public void setNoiLuuTruTaiLieuId(Long noiLuuTruTaiLieuId);
	public Long getNoiLuuTruTaiLieuId(boolean notNull);
	public void setLaBanChinh(boolean laBanChinh);
	public boolean getLaBanChinh();
	public void setDaNhan(boolean daNhan);
	public boolean getDaNhan();
	public void setDownloadLink(String downloadLink);
	public String getDownloadLink();
}