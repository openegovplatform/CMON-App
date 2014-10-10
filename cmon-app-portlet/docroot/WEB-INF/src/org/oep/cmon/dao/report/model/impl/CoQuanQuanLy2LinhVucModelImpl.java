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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc;
import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVucModel;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the CoQuanQuanLy2LinhVuc service. Represents a row in the &quot;DNICT_CoQuanQuanLy2LinhVuc&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVucModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CoQuanQuanLy2LinhVucImpl}.
 * </p>
 *
 * @author VIENPN
 * @see CoQuanQuanLy2LinhVucImpl
 * @see org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc
 * @see org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVucModel
 * @generated
 */
public class CoQuanQuanLy2LinhVucModelImpl extends BaseModelImpl<CoQuanQuanLy2LinhVuc>
	implements CoQuanQuanLy2LinhVucModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a co quan quan ly2 linh vuc model instance should use the {@link org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc} interface instead.
	 */
	public static final String TABLE_NAME = "DNICT_CoQuanQuanLy2LinhVuc";
	public static final Object[][] TABLE_COLUMNS = {
			{ "NHOMTHUTUCHANHCHINHID", Types.BIGINT },
			{ "TENNHOMTTHC", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table DNICT_CoQuanQuanLy2LinhVuc (NHOMTHUTUCHANHCHINHID LONG not null primary key,TENNHOMTTHC VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table DNICT_CoQuanQuanLy2LinhVuc";
	public static final String ORDER_BY_JPQL = " ORDER BY coQuanQuanLy2LinhVuc.NHOMTHUTUCHANHCHINHID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DNICT_CoQuanQuanLy2LinhVuc.NHOMTHUTUCHANHCHINHID ASC";
	public static final String DATA_SOURCE = "egovDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc"));

	public CoQuanQuanLy2LinhVucModelImpl() {
	}

	public long getPrimaryKey() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setPrimaryKey(long primaryKey) {
		setNHOMTHUTUCHANHCHINHID(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_NHOMTHUTUCHANHCHINHID);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return CoQuanQuanLy2LinhVuc.class;
	}

	public String getModelClassName() {
		return CoQuanQuanLy2LinhVuc.class.getName();
	}

	public long getNHOMTHUTUCHANHCHINHID() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setNHOMTHUTUCHANHCHINHID(long NHOMTHUTUCHANHCHINHID) {
		_NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
	}

	public String getTENNHOMTTHC() {
		if (_TENNHOMTTHC == null) {
			return StringPool.BLANK;
		}
		else {
			return _TENNHOMTTHC;
		}
	}

	public void setTENNHOMTTHC(String TENNHOMTTHC) {
		_TENNHOMTTHC = TENNHOMTTHC;
	}

	@Override
	public CoQuanQuanLy2LinhVuc toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CoQuanQuanLy2LinhVuc)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					CoQuanQuanLy2LinhVuc.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		CoQuanQuanLy2LinhVucImpl coQuanQuanLy2LinhVucImpl = new CoQuanQuanLy2LinhVucImpl();

		coQuanQuanLy2LinhVucImpl.setNHOMTHUTUCHANHCHINHID(getNHOMTHUTUCHANHCHINHID());
		coQuanQuanLy2LinhVucImpl.setTENNHOMTTHC(getTENNHOMTTHC());

		coQuanQuanLy2LinhVucImpl.resetOriginalValues();

		return coQuanQuanLy2LinhVucImpl;
	}

	public int compareTo(CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) {
		int value = 0;

		if (getNHOMTHUTUCHANHCHINHID() < coQuanQuanLy2LinhVuc.getNHOMTHUTUCHANHCHINHID()) {
			value = -1;
		}
		else if (getNHOMTHUTUCHANHCHINHID() > coQuanQuanLy2LinhVuc.getNHOMTHUTUCHANHCHINHID()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc = null;

		try {
			coQuanQuanLy2LinhVuc = (CoQuanQuanLy2LinhVuc)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = coQuanQuanLy2LinhVuc.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<CoQuanQuanLy2LinhVuc> toCacheModel() {
		CoQuanQuanLy2LinhVucCacheModel coQuanQuanLy2LinhVucCacheModel = new CoQuanQuanLy2LinhVucCacheModel();

		coQuanQuanLy2LinhVucCacheModel.NHOMTHUTUCHANHCHINHID = getNHOMTHUTUCHANHCHINHID();

		coQuanQuanLy2LinhVucCacheModel.TENNHOMTTHC = getTENNHOMTTHC();

		String TENNHOMTTHC = coQuanQuanLy2LinhVucCacheModel.TENNHOMTTHC;

		if ((TENNHOMTTHC != null) && (TENNHOMTTHC.length() == 0)) {
			coQuanQuanLy2LinhVucCacheModel.TENNHOMTTHC = null;
		}

		return coQuanQuanLy2LinhVucCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{NHOMTHUTUCHANHCHINHID=");
		sb.append(getNHOMTHUTUCHANHCHINHID());
		sb.append(", TENNHOMTTHC=");
		sb.append(getTENNHOMTTHC());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>NHOMTHUTUCHANHCHINHID</column-name><column-value><![CDATA[");
		sb.append(getNHOMTHUTUCHANHCHINHID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TENNHOMTTHC</column-name><column-value><![CDATA[");
		sb.append(getTENNHOMTTHC());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CoQuanQuanLy2LinhVuc.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CoQuanQuanLy2LinhVuc.class
		};
	private long _NHOMTHUTUCHANHCHINHID;
	private String _TENNHOMTTHC;
	private transient ExpandoBridge _expandoBridge;
	private CoQuanQuanLy2LinhVuc _escapedModelProxy;
}