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

import org.oep.cmon.dao.report.model.Baocaochitiet;

import java.io.Serializable;

/**
 * The cache model class for representing Baocaochitiet in entity cache.
 *
 * @author VIENPN
 * @see Baocaochitiet
 * @generated
 */
public class BaocaochitietCacheModel implements CacheModel<Baocaochitiet>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{LINHVUCID=");
		sb.append(LINHVUCID);
		sb.append(", MASOHOSO=");
		sb.append(MASOHOSO);
		sb.append(", TEN=");
		sb.append(TEN);
		sb.append(", TRANGTHAI=");
		sb.append(TRANGTHAI);
		sb.append(", DIACHIHIENNAY=");
		sb.append(DIACHIHIENNAY);
		sb.append(", DIENTHOAIDIDONG=");
		sb.append(DIENTHOAIDIDONG);
		sb.append(", HOTENNGUOINOPHOSO=");
		sb.append(HOTENNGUOINOPHOSO);
		sb.append(", NGUOIDAIDIENPHAPLUAT=");
		sb.append(NGUOIDAIDIENPHAPLUAT);
		sb.append(", NGAYNHANHOSO=");
		sb.append(NGAYNHANHOSO);
		sb.append(", NGAYTRAKETQUA=");
		sb.append(NGAYTRAKETQUA);
		sb.append(", NGAYHENTRAKETQUA=");
		sb.append(NGAYHENTRAKETQUA);
		sb.append(", LINHVUC=");
		sb.append(LINHVUC);
		sb.append(", GHICHU=");
		sb.append(GHICHU);
		sb.append("}");

		return sb.toString();
	}

	public Baocaochitiet toEntityModel() {
		BaocaochitietImpl baocaochitietImpl = new BaocaochitietImpl();

		baocaochitietImpl.setLINHVUCID(LINHVUCID);

		if (MASOHOSO == null) {
			baocaochitietImpl.setMASOHOSO(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setMASOHOSO(MASOHOSO);
		}

		if (TEN == null) {
			baocaochitietImpl.setTEN(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setTEN(TEN);
		}

		if (TRANGTHAI == null) {
			baocaochitietImpl.setTRANGTHAI(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setTRANGTHAI(TRANGTHAI);
		}

		if (DIACHIHIENNAY == null) {
			baocaochitietImpl.setDIACHIHIENNAY(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setDIACHIHIENNAY(DIACHIHIENNAY);
		}

		if (DIENTHOAIDIDONG == null) {
			baocaochitietImpl.setDIENTHOAIDIDONG(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setDIENTHOAIDIDONG(DIENTHOAIDIDONG);
		}

		if (HOTENNGUOINOPHOSO == null) {
			baocaochitietImpl.setHOTENNGUOINOPHOSO(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setHOTENNGUOINOPHOSO(HOTENNGUOINOPHOSO);
		}

		if (NGUOIDAIDIENPHAPLUAT == null) {
			baocaochitietImpl.setNGUOIDAIDIENPHAPLUAT(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setNGUOIDAIDIENPHAPLUAT(NGUOIDAIDIENPHAPLUAT);
		}

		if (NGAYNHANHOSO == null) {
			baocaochitietImpl.setNGAYNHANHOSO(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setNGAYNHANHOSO(NGAYNHANHOSO);
		}

		if (NGAYTRAKETQUA == null) {
			baocaochitietImpl.setNGAYTRAKETQUA(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setNGAYTRAKETQUA(NGAYTRAKETQUA);
		}

		if (NGAYHENTRAKETQUA == null) {
			baocaochitietImpl.setNGAYHENTRAKETQUA(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setNGAYHENTRAKETQUA(NGAYHENTRAKETQUA);
		}

		if (LINHVUC == null) {
			baocaochitietImpl.setLINHVUC(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setLINHVUC(LINHVUC);
		}

		if (GHICHU == null) {
			baocaochitietImpl.setGHICHU(StringPool.BLANK);
		}
		else {
			baocaochitietImpl.setGHICHU(GHICHU);
		}

		baocaochitietImpl.resetOriginalValues();

		return baocaochitietImpl;
	}

	public long LINHVUCID;
	public String MASOHOSO;
	public String TEN;
	public String TRANGTHAI;
	public String DIACHIHIENNAY;
	public String DIENTHOAIDIDONG;
	public String HOTENNGUOINOPHOSO;
	public String NGUOIDAIDIENPHAPLUAT;
	public String NGAYNHANHOSO;
	public String NGAYTRAKETQUA;
	public String NGAYHENTRAKETQUA;
	public String LINHVUC;
	public String GHICHU;
}