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

import org.oep.cmon.dao.report.model.Lephi_chitiet;

import java.io.Serializable;

/**
 * The cache model class for representing Lephi_chitiet in entity cache.
 *
 * @author VIENPN
 * @see Lephi_chitiet
 * @generated
 */
public class Lephi_chitietCacheModel implements CacheModel<Lephi_chitiet>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", TENHOSO=");
		sb.append(TENHOSO);
		sb.append(", NGUOINOP=");
		sb.append(NGUOINOP);
		sb.append(", CHUHOSO=");
		sb.append(CHUHOSO);
		sb.append(", DIACHI=");
		sb.append(DIACHI);
		sb.append(", SOBOHOSO=");
		sb.append(SOBOHOSO);
		sb.append(", LEPHI=");
		sb.append(LEPHI);
		sb.append(", PHIHOSO=");
		sb.append(PHIHOSO);
		sb.append(", TONGLEPHI=");
		sb.append(TONGLEPHI);
		sb.append(", GHICHU=");
		sb.append(GHICHU);
		sb.append(", NHOMTHUTUCHANHCHINHID=");
		sb.append(NHOMTHUTUCHANHCHINHID);
		sb.append("}");

		return sb.toString();
	}

	public Lephi_chitiet toEntityModel() {
		Lephi_chitietImpl lephi_chitietImpl = new Lephi_chitietImpl();

		lephi_chitietImpl.setID(ID);

		if (TENHOSO == null) {
			lephi_chitietImpl.setTENHOSO(StringPool.BLANK);
		}
		else {
			lephi_chitietImpl.setTENHOSO(TENHOSO);
		}

		if (NGUOINOP == null) {
			lephi_chitietImpl.setNGUOINOP(StringPool.BLANK);
		}
		else {
			lephi_chitietImpl.setNGUOINOP(NGUOINOP);
		}

		if (CHUHOSO == null) {
			lephi_chitietImpl.setCHUHOSO(StringPool.BLANK);
		}
		else {
			lephi_chitietImpl.setCHUHOSO(CHUHOSO);
		}

		if (DIACHI == null) {
			lephi_chitietImpl.setDIACHI(StringPool.BLANK);
		}
		else {
			lephi_chitietImpl.setDIACHI(DIACHI);
		}

		if (SOBOHOSO == null) {
			lephi_chitietImpl.setSOBOHOSO(StringPool.BLANK);
		}
		else {
			lephi_chitietImpl.setSOBOHOSO(SOBOHOSO);
		}

		if (LEPHI == null) {
			lephi_chitietImpl.setLEPHI(StringPool.BLANK);
		}
		else {
			lephi_chitietImpl.setLEPHI(LEPHI);
		}

		if (PHIHOSO == null) {
			lephi_chitietImpl.setPHIHOSO(StringPool.BLANK);
		}
		else {
			lephi_chitietImpl.setPHIHOSO(PHIHOSO);
		}

		if (TONGLEPHI == null) {
			lephi_chitietImpl.setTONGLEPHI(StringPool.BLANK);
		}
		else {
			lephi_chitietImpl.setTONGLEPHI(TONGLEPHI);
		}

		if (GHICHU == null) {
			lephi_chitietImpl.setGHICHU(StringPool.BLANK);
		}
		else {
			lephi_chitietImpl.setGHICHU(GHICHU);
		}

		lephi_chitietImpl.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);

		lephi_chitietImpl.resetOriginalValues();

		return lephi_chitietImpl;
	}

	public long ID;
	public String TENHOSO;
	public String NGUOINOP;
	public String CHUHOSO;
	public String DIACHI;
	public String SOBOHOSO;
	public String LEPHI;
	public String PHIHOSO;
	public String TONGLEPHI;
	public String GHICHU;
	public int NHOMTHUTUCHANHCHINHID;
}