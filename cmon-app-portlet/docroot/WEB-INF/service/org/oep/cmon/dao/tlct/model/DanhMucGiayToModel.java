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

package org.oep.cmon.dao.tlct.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DanhMucGiayTo service. Represents a row in the &quot;CMON_DANHMUCGIAYTO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.oep.cmon.dao.tlct.model.impl.DanhMucGiayToModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.oep.cmon.dao.tlct.model.impl.DanhMucGiayToImpl}.
 * </p>
 *
 * @author Liemnn
 * @see DanhMucGiayTo
 * @see org.oep.cmon.dao.tlct.model.impl.DanhMucGiayToImpl
 * @see org.oep.cmon.dao.tlct.model.impl.DanhMucGiayToModelImpl
 * @generated
 */
public interface DanhMucGiayToModel extends BaseModel<DanhMucGiayTo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a danh muc giay to model instance should use the {@link DanhMucGiayTo} interface instead.
	 */

	/**
	 * Returns the primary key of this danh muc giay to.
	 *
	 * @return the primary key of this danh muc giay to
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this danh muc giay to.
	 *
	 * @param primaryKey the primary key of this danh muc giay to
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this danh muc giay to.
	 *
	 * @return the ID of this danh muc giay to
	 */
	public long getId();

	/**
	 * Sets the ID of this danh muc giay to.
	 *
	 * @param id the ID of this danh muc giay to
	 */
	public void setId(long id);

	/**
	 * Returns the ma of this danh muc giay to.
	 *
	 * @return the ma of this danh muc giay to
	 */
	@AutoEscape
	public String getMa();

	/**
	 * Sets the ma of this danh muc giay to.
	 *
	 * @param ma the ma of this danh muc giay to
	 */
	public void setMa(String ma);

	/**
	 * Returns the ten of this danh muc giay to.
	 *
	 * @return the ten of this danh muc giay to
	 */
	@AutoEscape
	public String getTen();

	/**
	 * Sets the ten of this danh muc giay to.
	 *
	 * @param ten the ten of this danh muc giay to
	 */
	public void setTen(String ten);

	/**
	 * Returns the mota of this danh muc giay to.
	 *
	 * @return the mota of this danh muc giay to
	 */
	@AutoEscape
	public String getMota();

	/**
	 * Sets the mota of this danh muc giay to.
	 *
	 * @param mota the mota of this danh muc giay to
	 */
	public void setMota(String mota);

	/**
	 * Returns the gioi han dung luong of this danh muc giay to.
	 *
	 * @return the gioi han dung luong of this danh muc giay to
	 */
	public long getGioiHanDungLuong();

	/**
	 * Sets the gioi han dung luong of this danh muc giay to.
	 *
	 * @param gioiHanDungLuong the gioi han dung luong of this danh muc giay to
	 */
	public void setGioiHanDungLuong(long gioiHanDungLuong);

	/**
	 * Returns the kieu tai lieu of this danh muc giay to.
	 *
	 * @return the kieu tai lieu of this danh muc giay to
	 */
	@AutoEscape
	public String getKieuTaiLieu();

	/**
	 * Sets the kieu tai lieu of this danh muc giay to.
	 *
	 * @param kieuTaiLieu the kieu tai lieu of this danh muc giay to
	 */
	public void setKieuTaiLieu(String kieuTaiLieu);

	/**
	 * Returns the nguoi tao of this danh muc giay to.
	 *
	 * @return the nguoi tao of this danh muc giay to
	 */
	@AutoEscape
	public String getNguoiTao();

	/**
	 * Sets the nguoi tao of this danh muc giay to.
	 *
	 * @param nguoiTao the nguoi tao of this danh muc giay to
	 */
	public void setNguoiTao(String nguoiTao);

	/**
	 * Returns the ngay tao of this danh muc giay to.
	 *
	 * @return the ngay tao of this danh muc giay to
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this danh muc giay to.
	 *
	 * @param ngayTao the ngay tao of this danh muc giay to
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the nguoi sua of this danh muc giay to.
	 *
	 * @return the nguoi sua of this danh muc giay to
	 */
	@AutoEscape
	public String getNguoiSua();

	/**
	 * Sets the nguoi sua of this danh muc giay to.
	 *
	 * @param nguoiSua the nguoi sua of this danh muc giay to
	 */
	public void setNguoiSua(String nguoiSua);

	/**
	 * Returns the ngay sua of this danh muc giay to.
	 *
	 * @return the ngay sua of this danh muc giay to
	 */
	public Date getNgaySua();

	/**
	 * Sets the ngay sua of this danh muc giay to.
	 *
	 * @param ngaySua the ngay sua of this danh muc giay to
	 */
	public void setNgaySua(Date ngaySua);

	/**
	 * Returns the da xoa of this danh muc giay to.
	 *
	 * @return the da xoa of this danh muc giay to
	 */
	public int getDaXoa();

	/**
	 * Sets the da xoa of this danh muc giay to.
	 *
	 * @param daXoa the da xoa of this danh muc giay to
	 */
	public void setDaXoa(int daXoa);

	/**
	 * Returns the phien ban of this danh muc giay to.
	 *
	 * @return the phien ban of this danh muc giay to
	 */
	public long getPhienBan();

	/**
	 * Sets the phien ban of this danh muc giay to.
	 *
	 * @param phienBan the phien ban of this danh muc giay to
	 */
	public void setPhienBan(long phienBan);

	/**
	 * Returns the tailieu thay the ID of this danh muc giay to.
	 *
	 * @return the tailieu thay the ID of this danh muc giay to
	 */
	public Long getTailieuThayTheId();

	/**
	 * Sets the tailieu thay the ID of this danh muc giay to.
	 *
	 * @param tailieuThayTheId the tailieu thay the ID of this danh muc giay to
	 */
	public void setTailieuThayTheId(Long tailieuThayTheId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(DanhMucGiayTo danhMucGiayTo);

	public int hashCode();

	public CacheModel<DanhMucGiayTo> toCacheModel();

	public DanhMucGiayTo toEscapedModel();

	public String toString();

	public String toXmlString();
}