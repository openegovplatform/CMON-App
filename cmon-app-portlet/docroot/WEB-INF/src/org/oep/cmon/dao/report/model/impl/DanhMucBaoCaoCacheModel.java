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

package org.oep.cmon.dao.report.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.report.model.DanhMucBaoCao;

import java.io.Serializable;

/**
 * The cache model class for representing DanhMucBaoCao in entity cache.
 *
 * @author VIENPN
 * @see DanhMucBaoCao
 * @generated
 */
public class DanhMucBaoCaoCacheModel implements CacheModel<DanhMucBaoCao>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", TENBAOCAO=");
		sb.append(TENBAOCAO);
		sb.append(", DUONGDAN=");
		sb.append(DUONGDAN);
		sb.append(", ORDERS=");
		sb.append(ORDERS);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append(", PUBLISH=");
		sb.append(PUBLISH);
		sb.append("}");

		return sb.toString();
	}

	public DanhMucBaoCao toEntityModel() {
		DanhMucBaoCaoImpl danhMucBaoCaoImpl = new DanhMucBaoCaoImpl();

		danhMucBaoCaoImpl.setID(ID);

		if (TENBAOCAO == null) {
			danhMucBaoCaoImpl.setTENBAOCAO(StringPool.BLANK);
		}
		else {
			danhMucBaoCaoImpl.setTENBAOCAO(TENBAOCAO);
		}

		if (DUONGDAN == null) {
			danhMucBaoCaoImpl.setDUONGDAN(StringPool.BLANK);
		}
		else {
			danhMucBaoCaoImpl.setDUONGDAN(DUONGDAN);
		}

		danhMucBaoCaoImpl.setORDERS(ORDERS);
		danhMucBaoCaoImpl.setSTATUS(STATUS);
		danhMucBaoCaoImpl.setPUBLISH(PUBLISH);

		danhMucBaoCaoImpl.resetOriginalValues();

		return danhMucBaoCaoImpl;
	}

	public long ID;
	public String TENBAOCAO;
	public String DUONGDAN;
	public int ORDERS;
	public int STATUS;
	public int PUBLISH;
}