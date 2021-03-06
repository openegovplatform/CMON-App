/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.oep.cmon.dao.hosolienthong.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;
import org.oep.cmon.dao.hosolienthong.model.HoSoLienThongModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the HoSoLienThong service. Represents a row in the &quot;CMON_HOSOLIENTHONG&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.oep.cmon.dao.hosolienthong.model.HoSoLienThongModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HoSoLienThongImpl}.
 * </p>
 *
 * @author hoangtrung.nguyen
 * @see HoSoLienThongImpl
 * @see org.oep.cmon.dao.hosolienthong.model.HoSoLienThong
 * @see org.oep.cmon.dao.hosolienthong.model.HoSoLienThongModel
 * @generated
 */
public class HoSoLienThongModelImpl extends BaseModelImpl<HoSoLienThong>
	implements HoSoLienThongModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ho so lien thong model instance should use the {@link org.oep.cmon.dao.hosolienthong.model.HoSoLienThong} interface instead.
	 */
	public static final String TABLE_NAME = "CMON_HOSOLIENTHONG";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "HOSOID", Types.BIGINT },
			{ "COQUANGUIID", Types.BIGINT },
			{ "COQUANNHANID", Types.BIGINT },
			{ "THUTUCGUIID", Types.BIGINT },
			{ "THUTUCNHANID", Types.BIGINT },
			{ "MASOBIENNHANGUI", Types.VARCHAR },
			{ "MASOBIENNHANNHAN", Types.VARCHAR },
			{ "CANBOGUIID", Types.BIGINT },
			{ "CANBONHANID", Types.BIGINT },
			{ "NGAYGUI", Types.TIMESTAMP },
			{ "NGAYNHAN", Types.TIMESTAMP },
			{ "HOTENCANBOGUI", Types.VARCHAR },
			{ "HOTENCANBONHAN", Types.VARCHAR },
			{ "CANBONOPHOSOGIAYID", Types.BIGINT },
			{ "HOTENCANBONOPHOSOGIAY", Types.VARCHAR },
			{ "TRANGTHAILIENTHONG", Types.INTEGER },
			{ "GHICHUGUILIENTHONG", Types.VARCHAR },
			{ "HOTENCONGDANNOP", Types.VARCHAR },
			{ "DIACHIDAYDUCONGDANNOP", Types.VARCHAR },
			{ "NGAYTUCHOI", Types.TIMESTAMP },
			{ "NGAYNOINHANTRAKETQUA", Types.TIMESTAMP },
			{ "NGAYNOIGUINHANKETQUA", Types.TIMESTAMP },
			{ "CANBOTIEPNHANNOIGUIID", Types.BIGINT },
			{ "HOTENCANBOTIEPNHANNOIGUI", Types.VARCHAR },
			{ "TENCOQUANGUI", Types.VARCHAR },
			{ "TENTHUTUCGUI", Types.VARCHAR },
			{ "TENCOQUANNHAN", Types.VARCHAR },
			{ "TENTHUTUCNHAN", Types.VARCHAR },
			{ "THUTULIENTHONG", Types.INTEGER },
			{ "NGAYNOINHANHENTRA", Types.TIMESTAMP },
			{ "SONGAYNOINHANXULYDUKIEN", Types.INTEGER },
			{ "NGUOITAO", Types.VARCHAR },
			{ "NGAYTAO", Types.TIMESTAMP },
			{ "NGUOISUA", Types.VARCHAR },
			{ "NGAYSUA", Types.TIMESTAMP },
			{ "DAXOA", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table CMON_HOSOLIENTHONG (ID LONG not null primary key,HOSOID LONG,COQUANGUIID LONG,COQUANNHANID LONG,THUTUCGUIID LONG,THUTUCNHANID LONG,MASOBIENNHANGUI VARCHAR(75) null,MASOBIENNHANNHAN VARCHAR(75) null,CANBOGUIID LONG,CANBONHANID LONG null,NGAYGUI DATE null,NGAYNHAN DATE null,HOTENCANBOGUI VARCHAR(75) null,HOTENCANBONHAN VARCHAR(75) null,CANBONOPHOSOGIAYID LONG null,HOTENCANBONOPHOSOGIAY VARCHAR(75) null,TRANGTHAILIENTHONG INTEGER,GHICHUGUILIENTHONG VARCHAR(75) null,HOTENCONGDANNOP VARCHAR(75) null,DIACHIDAYDUCONGDANNOP VARCHAR(75) null,NGAYTUCHOI DATE null,NGAYNOINHANTRAKETQUA DATE null,NGAYNOIGUINHANKETQUA DATE null,CANBOTIEPNHANNOIGUIID LONG,HOTENCANBOTIEPNHANNOIGUI VARCHAR(75) null,TENCOQUANGUI VARCHAR(75) null,TENTHUTUCGUI VARCHAR(75) null,TENCOQUANNHAN VARCHAR(75) null,TENTHUTUCNHAN VARCHAR(75) null,THUTULIENTHONG INTEGER,NGAYNOINHANHENTRA DATE null,SONGAYNOINHANXULYDUKIEN INTEGER,NGUOITAO VARCHAR(75) null,NGAYTAO DATE null,NGUOISUA VARCHAR(75) null,NGAYSUA DATE null,DAXOA INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table CMON_HOSOLIENTHONG";
	public static final String DATA_SOURCE = "egovDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"),
			true);
	public static long HOSOID_COLUMN_BITMASK = 1L;
	public static long MASOBIENNHANLUCGUI_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"));

	public HoSoLienThongModelImpl() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return HoSoLienThong.class;
	}

	public String getModelClassName() {
		return HoSoLienThong.class.getName();
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getHoSoId() {
		return _hoSoId;
	}

	public void setHoSoId(long hoSoId) {
		_columnBitmask |= HOSOID_COLUMN_BITMASK;

		if (!_setOriginalHoSoId) {
			_setOriginalHoSoId = true;

			_originalHoSoId = _hoSoId;
		}

		_hoSoId = hoSoId;
	}

	public long getOriginalHoSoId() {
		return _originalHoSoId;
	}

	public long getCoQuanGuiId() {
		return _coQuanGuiId;
	}

	public void setCoQuanGuiId(long coQuanGuiId) {
		_coQuanGuiId = coQuanGuiId;
	}

	public long getCoQuanNhanId() {
		return _coQuanNhanId;
	}

	public void setCoQuanNhanId(long coQuanNhanId) {
		_coQuanNhanId = coQuanNhanId;
	}

	public long getThuTucGuiId() {
		return _thuTucGuiId;
	}

	public void setThuTucGuiId(long thuTucGuiId) {
		_thuTucGuiId = thuTucGuiId;
	}

	public long getThuTucNhanId() {
		return _thuTucNhanId;
	}

	public void setThuTucNhanId(long thuTucNhanId) {
		_thuTucNhanId = thuTucNhanId;
	}

	public String getMaSoBienNhanLucGui() {
		if (_maSoBienNhanLucGui == null) {
			return StringPool.BLANK;
		}
		else {
			return _maSoBienNhanLucGui;
		}
	}

	public void setMaSoBienNhanLucGui(String maSoBienNhanLucGui) {
		_columnBitmask |= MASOBIENNHANLUCGUI_COLUMN_BITMASK;

		if (_originalMaSoBienNhanLucGui == null) {
			_originalMaSoBienNhanLucGui = _maSoBienNhanLucGui;
		}

		_maSoBienNhanLucGui = maSoBienNhanLucGui;
	}

	public String getOriginalMaSoBienNhanLucGui() {
		return GetterUtil.getString(_originalMaSoBienNhanLucGui);
	}

	public String getMaSoBienNhanLucNhan() {
		if (_maSoBienNhanLucNhan == null) {
			return StringPool.BLANK;
		}
		else {
			return _maSoBienNhanLucNhan;
		}
	}

	public void setMaSoBienNhanLucNhan(String maSoBienNhanLucNhan) {
		_maSoBienNhanLucNhan = maSoBienNhanLucNhan;
	}

	public long getCanBoGuiId() {
		return _canBoGuiId;
	}

	public void setCanBoGuiId(long canBoGuiId) {
		_canBoGuiId = canBoGuiId;
	}

	public Long getCanBoNhanId() {
		return _canBoNhanId;
	}

	public void setCanBoNhanId(Long canBoNhanId) {
		_canBoNhanId = canBoNhanId;
	}

	public Date getNgayGui() {
		return _ngayGui;
	}

	public void setNgayGui(Date ngayGui) {
		_ngayGui = ngayGui;
	}

	public Date getNgayNhan() {
		return _ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		_ngayNhan = ngayNhan;
	}

	public String getHoTenCanBoGui() {
		if (_hoTenCanBoGui == null) {
			return StringPool.BLANK;
		}
		else {
			return _hoTenCanBoGui;
		}
	}

	public void setHoTenCanBoGui(String hoTenCanBoGui) {
		_hoTenCanBoGui = hoTenCanBoGui;
	}

	public String getHoTenCanBoNhan() {
		if (_hoTenCanBoNhan == null) {
			return StringPool.BLANK;
		}
		else {
			return _hoTenCanBoNhan;
		}
	}

	public void setHoTenCanBoNhan(String hoTenCanBoNhan) {
		_hoTenCanBoNhan = hoTenCanBoNhan;
	}

	public Long getCanBoNopHoSoGiayId() {
		return _canBoNopHoSoGiayId;
	}

	public void setCanBoNopHoSoGiayId(Long canBoNopHoSoGiayId) {
		_canBoNopHoSoGiayId = canBoNopHoSoGiayId;
	}

	public String getHoTenCanBoNopHoSoGiay() {
		if (_hoTenCanBoNopHoSoGiay == null) {
			return StringPool.BLANK;
		}
		else {
			return _hoTenCanBoNopHoSoGiay;
		}
	}

	public void setHoTenCanBoNopHoSoGiay(String hoTenCanBoNopHoSoGiay) {
		_hoTenCanBoNopHoSoGiay = hoTenCanBoNopHoSoGiay;
	}

	public int getTrangThaiLienThong() {
		return _trangThaiLienThong;
	}

	public void setTrangThaiLienThong(int trangThaiLienThong) {
		_trangThaiLienThong = trangThaiLienThong;
	}

	public String getGhiChuGuiLienThong() {
		if (_ghiChuGuiLienThong == null) {
			return StringPool.BLANK;
		}
		else {
			return _ghiChuGuiLienThong;
		}
	}

	public void setGhiChuGuiLienThong(String ghiChuGuiLienThong) {
		_ghiChuGuiLienThong = ghiChuGuiLienThong;
	}

	public String getHoTenCongDanNop() {
		if (_hoTenCongDanNop == null) {
			return StringPool.BLANK;
		}
		else {
			return _hoTenCongDanNop;
		}
	}

	public void setHoTenCongDanNop(String hoTenCongDanNop) {
		_hoTenCongDanNop = hoTenCongDanNop;
	}

	public String getDiaChiDayDuCongDanNop() {
		if (_diaChiDayDuCongDanNop == null) {
			return StringPool.BLANK;
		}
		else {
			return _diaChiDayDuCongDanNop;
		}
	}

	public void setDiaChiDayDuCongDanNop(String diaChiDayDuCongDanNop) {
		_diaChiDayDuCongDanNop = diaChiDayDuCongDanNop;
	}

	public Date getNgayTuChoi() {
		return _ngayTuChoi;
	}

	public void setNgayTuChoi(Date ngayTuChoi) {
		_ngayTuChoi = ngayTuChoi;
	}

	public Date getNgayNoiNhanTraKetQua() {
		return _ngayNoiNhanTraKetQua;
	}

	public void setNgayNoiNhanTraKetQua(Date ngayNoiNhanTraKetQua) {
		_ngayNoiNhanTraKetQua = ngayNoiNhanTraKetQua;
	}

	public Date getNgayNoiGuiNhanKetQua() {
		return _ngayNoiGuiNhanKetQua;
	}

	public void setNgayNoiGuiNhanKetQua(Date ngayNoiGuiNhanKetQua) {
		_ngayNoiGuiNhanKetQua = ngayNoiGuiNhanKetQua;
	}

	public long getCanBoTiepNhanNoiGuiId() {
		return _canBoTiepNhanNoiGuiId;
	}

	public void setCanBoTiepNhanNoiGuiId(long canBoTiepNhanNoiGuiId) {
		_canBoTiepNhanNoiGuiId = canBoTiepNhanNoiGuiId;
	}

	public String getHoTenCanBoTiepNhanNoiGui() {
		if (_hoTenCanBoTiepNhanNoiGui == null) {
			return StringPool.BLANK;
		}
		else {
			return _hoTenCanBoTiepNhanNoiGui;
		}
	}

	public void setHoTenCanBoTiepNhanNoiGui(String hoTenCanBoTiepNhanNoiGui) {
		_hoTenCanBoTiepNhanNoiGui = hoTenCanBoTiepNhanNoiGui;
	}

	public String getTenCoQuanGui() {
		if (_tenCoQuanGui == null) {
			return StringPool.BLANK;
		}
		else {
			return _tenCoQuanGui;
		}
	}

	public void setTenCoQuanGui(String tenCoQuanGui) {
		_tenCoQuanGui = tenCoQuanGui;
	}

	public String getTenThuTucGui() {
		if (_tenThuTucGui == null) {
			return StringPool.BLANK;
		}
		else {
			return _tenThuTucGui;
		}
	}

	public void setTenThuTucGui(String tenThuTucGui) {
		_tenThuTucGui = tenThuTucGui;
	}

	public String getTenCoQuanNhan() {
		if (_tenCoQuanNhan == null) {
			return StringPool.BLANK;
		}
		else {
			return _tenCoQuanNhan;
		}
	}

	public void setTenCoQuanNhan(String tenCoQuanNhan) {
		_tenCoQuanNhan = tenCoQuanNhan;
	}

	public String getTenThuTucNhan() {
		if (_tenThuTucNhan == null) {
			return StringPool.BLANK;
		}
		else {
			return _tenThuTucNhan;
		}
	}

	public void setTenThuTucNhan(String tenThuTucNhan) {
		_tenThuTucNhan = tenThuTucNhan;
	}

	public int getThuTuLienThong() {
		return _thuTuLienThong;
	}

	public void setThuTuLienThong(int thuTuLienThong) {
		_thuTuLienThong = thuTuLienThong;
	}

	public Date getNgayNoiNhanHenTra() {
		return _ngayNoiNhanHenTra;
	}

	public void setNgayNoiNhanHenTra(Date ngayNoiNhanHenTra) {
		_ngayNoiNhanHenTra = ngayNoiNhanHenTra;
	}

	public int getSoNgayNoiNhanXuLyDuKien() {
		return _soNgayNoiNhanXuLyDuKien;
	}

	public void setSoNgayNoiNhanXuLyDuKien(int soNgayNoiNhanXuLyDuKien) {
		_soNgayNoiNhanXuLyDuKien = soNgayNoiNhanXuLyDuKien;
	}

	public String getNguoiTao() {
		if (_nguoiTao == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoiTao;
		}
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiSua() {
		if (_nguoiSua == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoiSua;
		}
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public HoSoLienThong toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (HoSoLienThong)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					HoSoLienThong.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		HoSoLienThongImpl hoSoLienThongImpl = new HoSoLienThongImpl();

		hoSoLienThongImpl.setId(getId());
		hoSoLienThongImpl.setHoSoId(getHoSoId());
		hoSoLienThongImpl.setCoQuanGuiId(getCoQuanGuiId());
		hoSoLienThongImpl.setCoQuanNhanId(getCoQuanNhanId());
		hoSoLienThongImpl.setThuTucGuiId(getThuTucGuiId());
		hoSoLienThongImpl.setThuTucNhanId(getThuTucNhanId());
		hoSoLienThongImpl.setMaSoBienNhanLucGui(getMaSoBienNhanLucGui());
		hoSoLienThongImpl.setMaSoBienNhanLucNhan(getMaSoBienNhanLucNhan());
		hoSoLienThongImpl.setCanBoGuiId(getCanBoGuiId());
		hoSoLienThongImpl.setCanBoNhanId(getCanBoNhanId());
		hoSoLienThongImpl.setNgayGui(getNgayGui());
		hoSoLienThongImpl.setNgayNhan(getNgayNhan());
		hoSoLienThongImpl.setHoTenCanBoGui(getHoTenCanBoGui());
		hoSoLienThongImpl.setHoTenCanBoNhan(getHoTenCanBoNhan());
		hoSoLienThongImpl.setCanBoNopHoSoGiayId(getCanBoNopHoSoGiayId());
		hoSoLienThongImpl.setHoTenCanBoNopHoSoGiay(getHoTenCanBoNopHoSoGiay());
		hoSoLienThongImpl.setTrangThaiLienThong(getTrangThaiLienThong());
		hoSoLienThongImpl.setGhiChuGuiLienThong(getGhiChuGuiLienThong());
		hoSoLienThongImpl.setHoTenCongDanNop(getHoTenCongDanNop());
		hoSoLienThongImpl.setDiaChiDayDuCongDanNop(getDiaChiDayDuCongDanNop());
		hoSoLienThongImpl.setNgayTuChoi(getNgayTuChoi());
		hoSoLienThongImpl.setNgayNoiNhanTraKetQua(getNgayNoiNhanTraKetQua());
		hoSoLienThongImpl.setNgayNoiGuiNhanKetQua(getNgayNoiGuiNhanKetQua());
		hoSoLienThongImpl.setCanBoTiepNhanNoiGuiId(getCanBoTiepNhanNoiGuiId());
		hoSoLienThongImpl.setHoTenCanBoTiepNhanNoiGui(getHoTenCanBoTiepNhanNoiGui());
		hoSoLienThongImpl.setTenCoQuanGui(getTenCoQuanGui());
		hoSoLienThongImpl.setTenThuTucGui(getTenThuTucGui());
		hoSoLienThongImpl.setTenCoQuanNhan(getTenCoQuanNhan());
		hoSoLienThongImpl.setTenThuTucNhan(getTenThuTucNhan());
		hoSoLienThongImpl.setThuTuLienThong(getThuTuLienThong());
		hoSoLienThongImpl.setNgayNoiNhanHenTra(getNgayNoiNhanHenTra());
		hoSoLienThongImpl.setSoNgayNoiNhanXuLyDuKien(getSoNgayNoiNhanXuLyDuKien());
		hoSoLienThongImpl.setNguoiTao(getNguoiTao());
		hoSoLienThongImpl.setNgayTao(getNgayTao());
		hoSoLienThongImpl.setNguoiSua(getNguoiSua());
		hoSoLienThongImpl.setNgaySua(getNgaySua());
		hoSoLienThongImpl.setDaXoa(getDaXoa());

		hoSoLienThongImpl.resetOriginalValues();

		return hoSoLienThongImpl;
	}

	public int compareTo(HoSoLienThong hoSoLienThong) {
		long primaryKey = hoSoLienThong.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HoSoLienThong hoSoLienThong = null;

		try {
			hoSoLienThong = (HoSoLienThong)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hoSoLienThong.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		HoSoLienThongModelImpl hoSoLienThongModelImpl = this;

		hoSoLienThongModelImpl._originalHoSoId = hoSoLienThongModelImpl._hoSoId;

		hoSoLienThongModelImpl._setOriginalHoSoId = false;

		hoSoLienThongModelImpl._originalMaSoBienNhanLucGui = hoSoLienThongModelImpl._maSoBienNhanLucGui;

		hoSoLienThongModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<HoSoLienThong> toCacheModel() {
		HoSoLienThongCacheModel hoSoLienThongCacheModel = new HoSoLienThongCacheModel();

		hoSoLienThongCacheModel.id = getId();

		hoSoLienThongCacheModel.hoSoId = getHoSoId();

		hoSoLienThongCacheModel.coQuanGuiId = getCoQuanGuiId();

		hoSoLienThongCacheModel.coQuanNhanId = getCoQuanNhanId();

		hoSoLienThongCacheModel.thuTucGuiId = getThuTucGuiId();

		hoSoLienThongCacheModel.thuTucNhanId = getThuTucNhanId();

		hoSoLienThongCacheModel.maSoBienNhanLucGui = getMaSoBienNhanLucGui();

		String maSoBienNhanLucGui = hoSoLienThongCacheModel.maSoBienNhanLucGui;

		if ((maSoBienNhanLucGui != null) && (maSoBienNhanLucGui.length() == 0)) {
			hoSoLienThongCacheModel.maSoBienNhanLucGui = null;
		}

		hoSoLienThongCacheModel.maSoBienNhanLucNhan = getMaSoBienNhanLucNhan();

		String maSoBienNhanLucNhan = hoSoLienThongCacheModel.maSoBienNhanLucNhan;

		if ((maSoBienNhanLucNhan != null) &&
				(maSoBienNhanLucNhan.length() == 0)) {
			hoSoLienThongCacheModel.maSoBienNhanLucNhan = null;
		}

		hoSoLienThongCacheModel.canBoGuiId = getCanBoGuiId();

		hoSoLienThongCacheModel.canBoNhanId = getCanBoNhanId();

		Date ngayGui = getNgayGui();

		if (ngayGui != null) {
			hoSoLienThongCacheModel.ngayGui = ngayGui.getTime();
		}
		else {
			hoSoLienThongCacheModel.ngayGui = Long.MIN_VALUE;
		}

		Date ngayNhan = getNgayNhan();

		if (ngayNhan != null) {
			hoSoLienThongCacheModel.ngayNhan = ngayNhan.getTime();
		}
		else {
			hoSoLienThongCacheModel.ngayNhan = Long.MIN_VALUE;
		}

		hoSoLienThongCacheModel.hoTenCanBoGui = getHoTenCanBoGui();

		String hoTenCanBoGui = hoSoLienThongCacheModel.hoTenCanBoGui;

		if ((hoTenCanBoGui != null) && (hoTenCanBoGui.length() == 0)) {
			hoSoLienThongCacheModel.hoTenCanBoGui = null;
		}

		hoSoLienThongCacheModel.hoTenCanBoNhan = getHoTenCanBoNhan();

		String hoTenCanBoNhan = hoSoLienThongCacheModel.hoTenCanBoNhan;

		if ((hoTenCanBoNhan != null) && (hoTenCanBoNhan.length() == 0)) {
			hoSoLienThongCacheModel.hoTenCanBoNhan = null;
		}

		hoSoLienThongCacheModel.canBoNopHoSoGiayId = getCanBoNopHoSoGiayId();

		hoSoLienThongCacheModel.hoTenCanBoNopHoSoGiay = getHoTenCanBoNopHoSoGiay();

		String hoTenCanBoNopHoSoGiay = hoSoLienThongCacheModel.hoTenCanBoNopHoSoGiay;

		if ((hoTenCanBoNopHoSoGiay != null) &&
				(hoTenCanBoNopHoSoGiay.length() == 0)) {
			hoSoLienThongCacheModel.hoTenCanBoNopHoSoGiay = null;
		}

		hoSoLienThongCacheModel.trangThaiLienThong = getTrangThaiLienThong();

		hoSoLienThongCacheModel.ghiChuGuiLienThong = getGhiChuGuiLienThong();

		String ghiChuGuiLienThong = hoSoLienThongCacheModel.ghiChuGuiLienThong;

		if ((ghiChuGuiLienThong != null) && (ghiChuGuiLienThong.length() == 0)) {
			hoSoLienThongCacheModel.ghiChuGuiLienThong = null;
		}

		hoSoLienThongCacheModel.hoTenCongDanNop = getHoTenCongDanNop();

		String hoTenCongDanNop = hoSoLienThongCacheModel.hoTenCongDanNop;

		if ((hoTenCongDanNop != null) && (hoTenCongDanNop.length() == 0)) {
			hoSoLienThongCacheModel.hoTenCongDanNop = null;
		}

		hoSoLienThongCacheModel.diaChiDayDuCongDanNop = getDiaChiDayDuCongDanNop();

		String diaChiDayDuCongDanNop = hoSoLienThongCacheModel.diaChiDayDuCongDanNop;

		if ((diaChiDayDuCongDanNop != null) &&
				(diaChiDayDuCongDanNop.length() == 0)) {
			hoSoLienThongCacheModel.diaChiDayDuCongDanNop = null;
		}

		Date ngayTuChoi = getNgayTuChoi();

		if (ngayTuChoi != null) {
			hoSoLienThongCacheModel.ngayTuChoi = ngayTuChoi.getTime();
		}
		else {
			hoSoLienThongCacheModel.ngayTuChoi = Long.MIN_VALUE;
		}

		Date ngayNoiNhanTraKetQua = getNgayNoiNhanTraKetQua();

		if (ngayNoiNhanTraKetQua != null) {
			hoSoLienThongCacheModel.ngayNoiNhanTraKetQua = ngayNoiNhanTraKetQua.getTime();
		}
		else {
			hoSoLienThongCacheModel.ngayNoiNhanTraKetQua = Long.MIN_VALUE;
		}

		Date ngayNoiGuiNhanKetQua = getNgayNoiGuiNhanKetQua();

		if (ngayNoiGuiNhanKetQua != null) {
			hoSoLienThongCacheModel.ngayNoiGuiNhanKetQua = ngayNoiGuiNhanKetQua.getTime();
		}
		else {
			hoSoLienThongCacheModel.ngayNoiGuiNhanKetQua = Long.MIN_VALUE;
		}

		hoSoLienThongCacheModel.canBoTiepNhanNoiGuiId = getCanBoTiepNhanNoiGuiId();

		hoSoLienThongCacheModel.hoTenCanBoTiepNhanNoiGui = getHoTenCanBoTiepNhanNoiGui();

		String hoTenCanBoTiepNhanNoiGui = hoSoLienThongCacheModel.hoTenCanBoTiepNhanNoiGui;

		if ((hoTenCanBoTiepNhanNoiGui != null) &&
				(hoTenCanBoTiepNhanNoiGui.length() == 0)) {
			hoSoLienThongCacheModel.hoTenCanBoTiepNhanNoiGui = null;
		}

		hoSoLienThongCacheModel.tenCoQuanGui = getTenCoQuanGui();

		String tenCoQuanGui = hoSoLienThongCacheModel.tenCoQuanGui;

		if ((tenCoQuanGui != null) && (tenCoQuanGui.length() == 0)) {
			hoSoLienThongCacheModel.tenCoQuanGui = null;
		}

		hoSoLienThongCacheModel.tenThuTucGui = getTenThuTucGui();

		String tenThuTucGui = hoSoLienThongCacheModel.tenThuTucGui;

		if ((tenThuTucGui != null) && (tenThuTucGui.length() == 0)) {
			hoSoLienThongCacheModel.tenThuTucGui = null;
		}

		hoSoLienThongCacheModel.tenCoQuanNhan = getTenCoQuanNhan();

		String tenCoQuanNhan = hoSoLienThongCacheModel.tenCoQuanNhan;

		if ((tenCoQuanNhan != null) && (tenCoQuanNhan.length() == 0)) {
			hoSoLienThongCacheModel.tenCoQuanNhan = null;
		}

		hoSoLienThongCacheModel.tenThuTucNhan = getTenThuTucNhan();

		String tenThuTucNhan = hoSoLienThongCacheModel.tenThuTucNhan;

		if ((tenThuTucNhan != null) && (tenThuTucNhan.length() == 0)) {
			hoSoLienThongCacheModel.tenThuTucNhan = null;
		}

		hoSoLienThongCacheModel.thuTuLienThong = getThuTuLienThong();

		Date ngayNoiNhanHenTra = getNgayNoiNhanHenTra();

		if (ngayNoiNhanHenTra != null) {
			hoSoLienThongCacheModel.ngayNoiNhanHenTra = ngayNoiNhanHenTra.getTime();
		}
		else {
			hoSoLienThongCacheModel.ngayNoiNhanHenTra = Long.MIN_VALUE;
		}

		hoSoLienThongCacheModel.soNgayNoiNhanXuLyDuKien = getSoNgayNoiNhanXuLyDuKien();

		hoSoLienThongCacheModel.nguoiTao = getNguoiTao();

		String nguoiTao = hoSoLienThongCacheModel.nguoiTao;

		if ((nguoiTao != null) && (nguoiTao.length() == 0)) {
			hoSoLienThongCacheModel.nguoiTao = null;
		}

		Date ngayTao = getNgayTao();

		if (ngayTao != null) {
			hoSoLienThongCacheModel.ngayTao = ngayTao.getTime();
		}
		else {
			hoSoLienThongCacheModel.ngayTao = Long.MIN_VALUE;
		}

		hoSoLienThongCacheModel.nguoiSua = getNguoiSua();

		String nguoiSua = hoSoLienThongCacheModel.nguoiSua;

		if ((nguoiSua != null) && (nguoiSua.length() == 0)) {
			hoSoLienThongCacheModel.nguoiSua = null;
		}

		Date ngaySua = getNgaySua();

		if (ngaySua != null) {
			hoSoLienThongCacheModel.ngaySua = ngaySua.getTime();
		}
		else {
			hoSoLienThongCacheModel.ngaySua = Long.MIN_VALUE;
		}

		hoSoLienThongCacheModel.daXoa = getDaXoa();

		return hoSoLienThongCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", hoSoId=");
		sb.append(getHoSoId());
		sb.append(", coQuanGuiId=");
		sb.append(getCoQuanGuiId());
		sb.append(", coQuanNhanId=");
		sb.append(getCoQuanNhanId());
		sb.append(", thuTucGuiId=");
		sb.append(getThuTucGuiId());
		sb.append(", thuTucNhanId=");
		sb.append(getThuTucNhanId());
		sb.append(", maSoBienNhanLucGui=");
		sb.append(getMaSoBienNhanLucGui());
		sb.append(", maSoBienNhanLucNhan=");
		sb.append(getMaSoBienNhanLucNhan());
		sb.append(", canBoGuiId=");
		sb.append(getCanBoGuiId());
		sb.append(", canBoNhanId=");
		sb.append(getCanBoNhanId());
		sb.append(", ngayGui=");
		sb.append(getNgayGui());
		sb.append(", ngayNhan=");
		sb.append(getNgayNhan());
		sb.append(", hoTenCanBoGui=");
		sb.append(getHoTenCanBoGui());
		sb.append(", hoTenCanBoNhan=");
		sb.append(getHoTenCanBoNhan());
		sb.append(", canBoNopHoSoGiayId=");
		sb.append(getCanBoNopHoSoGiayId());
		sb.append(", hoTenCanBoNopHoSoGiay=");
		sb.append(getHoTenCanBoNopHoSoGiay());
		sb.append(", trangThaiLienThong=");
		sb.append(getTrangThaiLienThong());
		sb.append(", ghiChuGuiLienThong=");
		sb.append(getGhiChuGuiLienThong());
		sb.append(", hoTenCongDanNop=");
		sb.append(getHoTenCongDanNop());
		sb.append(", diaChiDayDuCongDanNop=");
		sb.append(getDiaChiDayDuCongDanNop());
		sb.append(", ngayTuChoi=");
		sb.append(getNgayTuChoi());
		sb.append(", ngayNoiNhanTraKetQua=");
		sb.append(getNgayNoiNhanTraKetQua());
		sb.append(", ngayNoiGuiNhanKetQua=");
		sb.append(getNgayNoiGuiNhanKetQua());
		sb.append(", canBoTiepNhanNoiGuiId=");
		sb.append(getCanBoTiepNhanNoiGuiId());
		sb.append(", hoTenCanBoTiepNhanNoiGui=");
		sb.append(getHoTenCanBoTiepNhanNoiGui());
		sb.append(", tenCoQuanGui=");
		sb.append(getTenCoQuanGui());
		sb.append(", tenThuTucGui=");
		sb.append(getTenThuTucGui());
		sb.append(", tenCoQuanNhan=");
		sb.append(getTenCoQuanNhan());
		sb.append(", tenThuTucNhan=");
		sb.append(getTenThuTucNhan());
		sb.append(", thuTuLienThong=");
		sb.append(getThuTuLienThong());
		sb.append(", ngayNoiNhanHenTra=");
		sb.append(getNgayNoiNhanHenTra());
		sb.append(", soNgayNoiNhanXuLyDuKien=");
		sb.append(getSoNgayNoiNhanXuLyDuKien());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(115);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.hosolienthong.model.HoSoLienThong");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoSoId</column-name><column-value><![CDATA[");
		sb.append(getHoSoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanGuiId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanGuiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanNhanId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTucGuiId</column-name><column-value><![CDATA[");
		sb.append(getThuTucGuiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTucNhanId</column-name><column-value><![CDATA[");
		sb.append(getThuTucNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoBienNhanLucGui</column-name><column-value><![CDATA[");
		sb.append(getMaSoBienNhanLucGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoBienNhanLucNhan</column-name><column-value><![CDATA[");
		sb.append(getMaSoBienNhanLucNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoGuiId</column-name><column-value><![CDATA[");
		sb.append(getCanBoGuiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoNhanId</column-name><column-value><![CDATA[");
		sb.append(getCanBoNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayGui</column-name><column-value><![CDATA[");
		sb.append(getNgayGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNhan</column-name><column-value><![CDATA[");
		sb.append(getNgayNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCanBoGui</column-name><column-value><![CDATA[");
		sb.append(getHoTenCanBoGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCanBoNhan</column-name><column-value><![CDATA[");
		sb.append(getHoTenCanBoNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoNopHoSoGiayId</column-name><column-value><![CDATA[");
		sb.append(getCanBoNopHoSoGiayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCanBoNopHoSoGiay</column-name><column-value><![CDATA[");
		sb.append(getHoTenCanBoNopHoSoGiay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiLienThong</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiLienThong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChuGuiLienThong</column-name><column-value><![CDATA[");
		sb.append(getGhiChuGuiLienThong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCongDanNop</column-name><column-value><![CDATA[");
		sb.append(getHoTenCongDanNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiDayDuCongDanNop</column-name><column-value><![CDATA[");
		sb.append(getDiaChiDayDuCongDanNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTuChoi</column-name><column-value><![CDATA[");
		sb.append(getNgayTuChoi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNoiNhanTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayNoiNhanTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNoiGuiNhanKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayNoiGuiNhanKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoTiepNhanNoiGuiId</column-name><column-value><![CDATA[");
		sb.append(getCanBoTiepNhanNoiGuiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenCanBoTiepNhanNoiGui</column-name><column-value><![CDATA[");
		sb.append(getHoTenCanBoTiepNhanNoiGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCoQuanGui</column-name><column-value><![CDATA[");
		sb.append(getTenCoQuanGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenThuTucGui</column-name><column-value><![CDATA[");
		sb.append(getTenThuTucGui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCoQuanNhan</column-name><column-value><![CDATA[");
		sb.append(getTenCoQuanNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenThuTucNhan</column-name><column-value><![CDATA[");
		sb.append(getTenThuTucNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTuLienThong</column-name><column-value><![CDATA[");
		sb.append(getThuTuLienThong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNoiNhanHenTra</column-name><column-value><![CDATA[");
		sb.append(getNgayNoiNhanHenTra());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNgayNoiNhanXuLyDuKien</column-name><column-value><![CDATA[");
		sb.append(getSoNgayNoiNhanXuLyDuKien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = HoSoLienThong.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			HoSoLienThong.class
		};
	private long _id;
	private long _hoSoId;
	private long _originalHoSoId;
	private boolean _setOriginalHoSoId;
	private long _coQuanGuiId;
	private long _coQuanNhanId;
	private long _thuTucGuiId;
	private long _thuTucNhanId;
	private String _maSoBienNhanLucGui;
	private String _originalMaSoBienNhanLucGui;
	private String _maSoBienNhanLucNhan;
	private long _canBoGuiId;
	private Long _canBoNhanId;
	private Date _ngayGui;
	private Date _ngayNhan;
	private String _hoTenCanBoGui;
	private String _hoTenCanBoNhan;
	private Long _canBoNopHoSoGiayId;
	private String _hoTenCanBoNopHoSoGiay;
	private int _trangThaiLienThong;
	private String _ghiChuGuiLienThong;
	private String _hoTenCongDanNop;
	private String _diaChiDayDuCongDanNop;
	private Date _ngayTuChoi;
	private Date _ngayNoiNhanTraKetQua;
	private Date _ngayNoiGuiNhanKetQua;
	private long _canBoTiepNhanNoiGuiId;
	private String _hoTenCanBoTiepNhanNoiGui;
	private String _tenCoQuanGui;
	private String _tenThuTucGui;
	private String _tenCoQuanNhan;
	private String _tenThuTucNhan;
	private int _thuTuLienThong;
	private Date _ngayNoiNhanHenTra;
	private int _soNgayNoiNhanXuLyDuKien;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private int _daXoa;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private HoSoLienThong _escapedModelProxy;
}