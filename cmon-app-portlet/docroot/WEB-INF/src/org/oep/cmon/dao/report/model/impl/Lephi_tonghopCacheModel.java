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

import org.oep.cmon.dao.report.model.Lephi_tonghop;

import java.io.Serializable;

/**
 * The cache model class for representing Lephi_tonghop in entity cache.
 *
 * @author VIENPN
 * @see Lephi_tonghop
 * @generated
 */
public class Lephi_tonghopCacheModel implements CacheModel<Lephi_tonghop>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{NHOMTHUTUCHANHCHINHID=");
		sb.append(NHOMTHUTUCHANHCHINHID);
		sb.append(", TONGHOSO=");
		sb.append(TONGHOSO);
		sb.append(", LEPHI=");
		sb.append(LEPHI);
		sb.append(", PHIHOSO=");
		sb.append(PHIHOSO);
		sb.append(", TONGLEPHI=");
		sb.append(TONGLEPHI);
		sb.append(", THANGNHAN=");
		sb.append(THANGNHAN);
		sb.append("}");

		return sb.toString();
	}

	public Lephi_tonghop toEntityModel() {
		Lephi_tonghopImpl lephi_tonghopImpl = new Lephi_tonghopImpl();

		lephi_tonghopImpl.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);

		if (TONGHOSO == null) {
			lephi_tonghopImpl.setTONGHOSO(StringPool.BLANK);
		}
		else {
			lephi_tonghopImpl.setTONGHOSO(TONGHOSO);
		}

		if (LEPHI == null) {
			lephi_tonghopImpl.setLEPHI(StringPool.BLANK);
		}
		else {
			lephi_tonghopImpl.setLEPHI(LEPHI);
		}

		if (PHIHOSO == null) {
			lephi_tonghopImpl.setPHIHOSO(StringPool.BLANK);
		}
		else {
			lephi_tonghopImpl.setPHIHOSO(PHIHOSO);
		}

		if (TONGLEPHI == null) {
			lephi_tonghopImpl.setTONGLEPHI(StringPool.BLANK);
		}
		else {
			lephi_tonghopImpl.setTONGLEPHI(TONGLEPHI);
		}

		if (THANGNHAN == null) {
			lephi_tonghopImpl.setTHANGNHAN(StringPool.BLANK);
		}
		else {
			lephi_tonghopImpl.setTHANGNHAN(THANGNHAN);
		}

		lephi_tonghopImpl.resetOriginalValues();

		return lephi_tonghopImpl;
	}

	public int NHOMTHUTUCHANHCHINHID;
	public String TONGHOSO;
	public String LEPHI;
	public String PHIHOSO;
	public String TONGLEPHI;
	public String THANGNHAN;
}