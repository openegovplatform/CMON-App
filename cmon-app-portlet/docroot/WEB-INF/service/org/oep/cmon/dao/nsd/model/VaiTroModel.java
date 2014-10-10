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

package org.oep.cmon.dao.nsd.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the VaiTro service. Represents a row in the &quot;CMON_VAITRO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.oep.cmon.dao.nsd.model.impl.VaiTroModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.oep.cmon.dao.nsd.model.impl.VaiTroImpl}.
 * </p>
 *
 * @author Liemnn
 * @see VaiTro
 * @see org.oep.cmon.dao.nsd.model.impl.VaiTroImpl
 * @see org.oep.cmon.dao.nsd.model.impl.VaiTroModelImpl
 * @generated
 */
public interface VaiTroModel extends BaseModel<VaiTro> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vai tro model instance should use the {@link VaiTro} interface instead.
	 */

	/**
	 * Returns the primary key of this vai tro.
	 *
	 * @return the primary key of this vai tro
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vai tro.
	 *
	 * @param primaryKey the primary key of this vai tro
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this vai tro.
	 *
	 * @return the ID of this vai tro
	 */
	public long getId();

	/**
	 * Sets the ID of this vai tro.
	 *
	 * @param id the ID of this vai tro
	 */
	public void setId(long id);

	/**
	 * Returns the ma of this vai tro.
	 *
	 * @return the ma of this vai tro
	 */
	@AutoEscape
	public String getMa();

	/**
	 * Sets the ma of this vai tro.
	 *
	 * @param ma the ma of this vai tro
	 */
	public void setMa(String ma);

	/**
	 * Returns the ten of this vai tro.
	 *
	 * @return the ten of this vai tro
	 */
	@AutoEscape
	public String getTen();

	/**
	 * Sets the ten of this vai tro.
	 *
	 * @param ten the ten of this vai tro
	 */
	public void setTen(String ten);

	/**
	 * Returns the mo ta of this vai tro.
	 *
	 * @return the mo ta of this vai tro
	 */
	@AutoEscape
	public String getMoTa();

	/**
	 * Sets the mo ta of this vai tro.
	 *
	 * @param moTa the mo ta of this vai tro
	 */
	public void setMoTa(String moTa);

	/**
	 * Returns the ngay tao of this vai tro.
	 *
	 * @return the ngay tao of this vai tro
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this vai tro.
	 *
	 * @param ngayTao the ngay tao of this vai tro
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the da xoa of this vai tro.
	 *
	 * @return the da xoa of this vai tro
	 */
	public int getDaXoa();

	/**
	 * Sets the da xoa of this vai tro.
	 *
	 * @param daXoa the da xoa of this vai tro
	 */
	public void setDaXoa(int daXoa);

	/**
	 * Returns the nguoi tao of this vai tro.
	 *
	 * @return the nguoi tao of this vai tro
	 */
	@AutoEscape
	public String getNguoiTao();

	/**
	 * Sets the nguoi tao of this vai tro.
	 *
	 * @param nguoiTao the nguoi tao of this vai tro
	 */
	public void setNguoiTao(String nguoiTao);

	/**
	 * Returns the ngay sua of this vai tro.
	 *
	 * @return the ngay sua of this vai tro
	 */
	public Date getNgaySua();

	/**
	 * Sets the ngay sua of this vai tro.
	 *
	 * @param ngaySua the ngay sua of this vai tro
	 */
	public void setNgaySua(Date ngaySua);

	/**
	 * Returns the nguoi sua of this vai tro.
	 *
	 * @return the nguoi sua of this vai tro
	 */
	@AutoEscape
	public String getNguoiSua();

	/**
	 * Sets the nguoi sua of this vai tro.
	 *
	 * @param nguoiSua the nguoi sua of this vai tro
	 */
	public void setNguoiSua(String nguoiSua);

	/**
	 * Returns the trang thai of this vai tro.
	 *
	 * @return the trang thai of this vai tro
	 */
	public int getTrangThai();

	/**
	 * Sets the trang thai of this vai tro.
	 *
	 * @param trangThai the trang thai of this vai tro
	 */
	public void setTrangThai(int trangThai);

	/**
	 * Returns the ung dung ID of this vai tro.
	 *
	 * @return the ung dung ID of this vai tro
	 */
	public Long getUngDungId();

	/**
	 * Sets the ung dung ID of this vai tro.
	 *
	 * @param ungDungId the ung dung ID of this vai tro
	 */
	public void setUngDungId(Long ungDungId);

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

	public int compareTo(VaiTro vaiTro);

	public int hashCode();

	public CacheModel<VaiTro> toCacheModel();

	public VaiTro toEscapedModel();

	public String toString();

	public String toXmlString();
}