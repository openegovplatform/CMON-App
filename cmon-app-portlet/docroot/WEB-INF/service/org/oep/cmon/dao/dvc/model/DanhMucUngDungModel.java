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

package org.oep.cmon.dao.dvc.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DanhMucUngDung service. Represents a row in the &quot;CMON_DANHMUCUNGDUNG&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.oep.cmon.dao.dvc.model.impl.DanhMucUngDungModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.oep.cmon.dao.dvc.model.impl.DanhMucUngDungImpl}.
 * </p>
 *
 * @author liemnn
 * @see DanhMucUngDung
 * @see org.oep.cmon.dao.dvc.model.impl.DanhMucUngDungImpl
 * @see org.oep.cmon.dao.dvc.model.impl.DanhMucUngDungModelImpl
 * @generated
 */
public interface DanhMucUngDungModel extends BaseModel<DanhMucUngDung> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a danh muc ung dung model instance should use the {@link DanhMucUngDung} interface instead.
	 */

	/**
	 * Returns the primary key of this danh muc ung dung.
	 *
	 * @return the primary key of this danh muc ung dung
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this danh muc ung dung.
	 *
	 * @param primaryKey the primary key of this danh muc ung dung
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this danh muc ung dung.
	 *
	 * @return the ID of this danh muc ung dung
	 */
	public long getId();

	/**
	 * Sets the ID of this danh muc ung dung.
	 *
	 * @param id the ID of this danh muc ung dung
	 */
	public void setId(long id);

	/**
	 * Returns the ma of this danh muc ung dung.
	 *
	 * @return the ma of this danh muc ung dung
	 */
	@AutoEscape
	public String getMa();

	/**
	 * Sets the ma of this danh muc ung dung.
	 *
	 * @param ma the ma of this danh muc ung dung
	 */
	public void setMa(String ma);

	/**
	 * Returns the ten of this danh muc ung dung.
	 *
	 * @return the ten of this danh muc ung dung
	 */
	@AutoEscape
	public String getTen();

	/**
	 * Sets the ten of this danh muc ung dung.
	 *
	 * @param ten the ten of this danh muc ung dung
	 */
	public void setTen(String ten);

	/**
	 * Returns the ngay tao of this danh muc ung dung.
	 *
	 * @return the ngay tao of this danh muc ung dung
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this danh muc ung dung.
	 *
	 * @param ngayTao the ngay tao of this danh muc ung dung
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the ngay sua of this danh muc ung dung.
	 *
	 * @return the ngay sua of this danh muc ung dung
	 */
	public Date getNgaySua();

	/**
	 * Sets the ngay sua of this danh muc ung dung.
	 *
	 * @param ngaySua the ngay sua of this danh muc ung dung
	 */
	public void setNgaySua(Date ngaySua);

	/**
	 * Returns the da xoa of this danh muc ung dung.
	 *
	 * @return the da xoa of this danh muc ung dung
	 */
	public int getDaXoa();

	/**
	 * Sets the da xoa of this danh muc ung dung.
	 *
	 * @param daXoa the da xoa of this danh muc ung dung
	 */
	public void setDaXoa(int daXoa);

	/**
	 * Returns the nguoi sua of this danh muc ung dung.
	 *
	 * @return the nguoi sua of this danh muc ung dung
	 */
	@AutoEscape
	public String getNguoiSua();

	/**
	 * Sets the nguoi sua of this danh muc ung dung.
	 *
	 * @param nguoiSua the nguoi sua of this danh muc ung dung
	 */
	public void setNguoiSua(String nguoiSua);

	/**
	 * Returns the nguoi tao of this danh muc ung dung.
	 *
	 * @return the nguoi tao of this danh muc ung dung
	 */
	@AutoEscape
	public String getNguoiTao();

	/**
	 * Sets the nguoi tao of this danh muc ung dung.
	 *
	 * @param nguoiTao the nguoi tao of this danh muc ung dung
	 */
	public void setNguoiTao(String nguoiTao);

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

	public int compareTo(DanhMucUngDung danhMucUngDung);

	public int hashCode();

	public CacheModel<DanhMucUngDung> toCacheModel();

	public DanhMucUngDung toEscapedModel();

	public String toString();

	public String toXmlString();
}