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

package org.oep.exch.dao.hoso.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing UpdateHoSoTrucTuyen in entity cache.
 *
 * @author NAM
 * @see UpdateHoSoTrucTuyen
 * @generated
 */
public class UpdateHoSoTrucTuyenCacheModel implements CacheModel<UpdateHoSoTrucTuyen>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", TrangThaiXuLy=");
		sb.append(TrangThaiXuLy);
		sb.append(", NgayChuyen=");
		sb.append(NgayChuyen);
		sb.append("}");

		return sb.toString();
	}

	public UpdateHoSoTrucTuyen toEntityModel() {
		UpdateHoSoTrucTuyenImpl updateHoSoTrucTuyenImpl = new UpdateHoSoTrucTuyenImpl();

		updateHoSoTrucTuyenImpl.setId(id);
		updateHoSoTrucTuyenImpl.setTrangThaiXuLy(TrangThaiXuLy);

		if (NgayChuyen == Long.MIN_VALUE) {
			updateHoSoTrucTuyenImpl.setNgayChuyen(null);
		}
		else {
			updateHoSoTrucTuyenImpl.setNgayChuyen(new Date(NgayChuyen));
		}

		updateHoSoTrucTuyenImpl.resetOriginalValues();

		return updateHoSoTrucTuyenImpl;
	}

	public long id;
	public int TrangThaiXuLy;
	public long NgayChuyen;
}