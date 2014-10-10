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

import org.oep.cmon.dao.report.model.Lephi_linhvuc;

import java.io.Serializable;

/**
 * The cache model class for representing Lephi_linhvuc in entity cache.
 *
 * @author VIENPN
 * @see Lephi_linhvuc
 * @generated
 */
public class Lephi_linhvucCacheModel implements CacheModel<Lephi_linhvuc>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{NHOMTHUTUCHANHCHINHID=");
		sb.append(NHOMTHUTUCHANHCHINHID);
		sb.append(", TONGHOSO=");
		sb.append(TONGHOSO);
		sb.append(", LEPHIHOSO=");
		sb.append(LEPHIHOSO);
		sb.append(", PHIHOSO=");
		sb.append(PHIHOSO);
		sb.append(", TONGLEPHI=");
		sb.append(TONGLEPHI);
		sb.append("}");

		return sb.toString();
	}

	public Lephi_linhvuc toEntityModel() {
		Lephi_linhvucImpl lephi_linhvucImpl = new Lephi_linhvucImpl();

		lephi_linhvucImpl.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);

		if (TONGHOSO == null) {
			lephi_linhvucImpl.setTONGHOSO(StringPool.BLANK);
		}
		else {
			lephi_linhvucImpl.setTONGHOSO(TONGHOSO);
		}

		if (LEPHIHOSO == null) {
			lephi_linhvucImpl.setLEPHIHOSO(StringPool.BLANK);
		}
		else {
			lephi_linhvucImpl.setLEPHIHOSO(LEPHIHOSO);
		}

		if (PHIHOSO == null) {
			lephi_linhvucImpl.setPHIHOSO(StringPool.BLANK);
		}
		else {
			lephi_linhvucImpl.setPHIHOSO(PHIHOSO);
		}

		if (TONGLEPHI == null) {
			lephi_linhvucImpl.setTONGLEPHI(StringPool.BLANK);
		}
		else {
			lephi_linhvucImpl.setTONGLEPHI(TONGLEPHI);
		}

		lephi_linhvucImpl.resetOriginalValues();

		return lephi_linhvucImpl;
	}

	public int NHOMTHUTUCHANHCHINHID;
	public String TONGHOSO;
	public String LEPHIHOSO;
	public String PHIHOSO;
	public String TONGLEPHI;
}