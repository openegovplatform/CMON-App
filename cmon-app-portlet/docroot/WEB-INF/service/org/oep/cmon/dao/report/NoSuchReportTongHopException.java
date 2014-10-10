/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package org.oep.cmon.dao.report;

import com.liferay.portal.NoSuchModelException;

/**
 * @author VIENPN
 */
public class NoSuchReportTongHopException extends NoSuchModelException {

	public NoSuchReportTongHopException() {
		super();
	}

	public NoSuchReportTongHopException(String msg) {
		super(msg);
	}

	public NoSuchReportTongHopException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchReportTongHopException(Throwable cause) {
		super(cause);
	}

}