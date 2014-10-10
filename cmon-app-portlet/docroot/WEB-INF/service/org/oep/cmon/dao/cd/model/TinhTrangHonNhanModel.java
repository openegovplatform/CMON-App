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

package org.oep.cmon.dao.cd.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TinhTrangHonNhan service. Represents a row in the &quot;CMON_TINHTRANGHONNHAN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.oep.cmon.dao.cd.model.impl.TinhTrangHonNhanModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.oep.cmon.dao.cd.model.impl.TinhTrangHonNhanImpl}.
 * </p>
 *
 * @author LIEMNN
 * @see TinhTrangHonNhan
 * @see org.oep.cmon.dao.cd.model.impl.TinhTrangHonNhanImpl
 * @see org.oep.cmon.dao.cd.model.impl.TinhTrangHonNhanModelImpl
 * @generated
 */
public interface TinhTrangHonNhanModel extends BaseModel<TinhTrangHonNhan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tinh trang hon nhan model instance should use the {@link TinhTrangHonNhan} interface instead.
	 */

	/**
	 * Returns the primary key of this tinh trang hon nhan.
	 *
	 * @return the primary key of this tinh trang hon nhan
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tinh trang hon nhan.
	 *
	 * @param primaryKey the primary key of this tinh trang hon nhan
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this tinh trang hon nhan.
	 *
	 * @return the ID of this tinh trang hon nhan
	 */
	public long getId();

	/**
	 * Sets the ID of this tinh trang hon nhan.
	 *
	 * @param id the ID of this tinh trang hon nhan
	 */
	public void setId(long id);

	/**
	 * Returns the ten of this tinh trang hon nhan.
	 *
	 * @return the ten of this tinh trang hon nhan
	 */
	@AutoEscape
	public String getTen();

	/**
	 * Sets the ten of this tinh trang hon nhan.
	 *
	 * @param ten the ten of this tinh trang hon nhan
	 */
	public void setTen(String ten);

	/**
	 * Returns the ngay tao of this tinh trang hon nhan.
	 *
	 * @return the ngay tao of this tinh trang hon nhan
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this tinh trang hon nhan.
	 *
	 * @param ngayTao the ngay tao of this tinh trang hon nhan
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the ngay sua of this tinh trang hon nhan.
	 *
	 * @return the ngay sua of this tinh trang hon nhan
	 */
	public Date getNgaySua();

	/**
	 * Sets the ngay sua of this tinh trang hon nhan.
	 *
	 * @param ngaySua the ngay sua of this tinh trang hon nhan
	 */
	public void setNgaySua(Date ngaySua);

	/**
	 * Returns the nguoi tao of this tinh trang hon nhan.
	 *
	 * @return the nguoi tao of this tinh trang hon nhan
	 */
	@AutoEscape
	public String getNguoiTao();

	/**
	 * Sets the nguoi tao of this tinh trang hon nhan.
	 *
	 * @param nguoiTao the nguoi tao of this tinh trang hon nhan
	 */
	public void setNguoiTao(String nguoiTao);

	/**
	 * Returns the da xoa of this tinh trang hon nhan.
	 *
	 * @return the da xoa of this tinh trang hon nhan
	 */
	public int getDaXoa();

	/**
	 * Sets the da xoa of this tinh trang hon nhan.
	 *
	 * @param daXoa the da xoa of this tinh trang hon nhan
	 */
	public void setDaXoa(int daXoa);

	/**
	 * Returns the nguoi sua of this tinh trang hon nhan.
	 *
	 * @return the nguoi sua of this tinh trang hon nhan
	 */
	@AutoEscape
	public String getNguoiSua();

	/**
	 * Sets the nguoi sua of this tinh trang hon nhan.
	 *
	 * @param nguoiSua the nguoi sua of this tinh trang hon nhan
	 */
	public void setNguoiSua(String nguoiSua);

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

	public int compareTo(TinhTrangHonNhan tinhTrangHonNhan);

	public int hashCode();

	public CacheModel<TinhTrangHonNhan> toCacheModel();

	public TinhTrangHonNhan toEscapedModel();

	public String toString();

	public String toXmlString();
}