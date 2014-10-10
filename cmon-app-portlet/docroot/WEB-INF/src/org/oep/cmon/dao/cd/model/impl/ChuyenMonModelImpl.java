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

package org.oep.cmon.dao.cd.model.impl;

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

import org.oep.cmon.dao.cd.model.ChuyenMon;
import org.oep.cmon.dao.cd.model.ChuyenMonModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the ChuyenMon service. Represents a row in the &quot;CMON_CHUYENMON&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.oep.cmon.dao.cd.model.ChuyenMonModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChuyenMonImpl}.
 * </p>
 *
 * @author LIEMNN
 * @see ChuyenMonImpl
 * @see org.oep.cmon.dao.cd.model.ChuyenMon
 * @see org.oep.cmon.dao.cd.model.ChuyenMonModel
 * @generated
 */
public class ChuyenMonModelImpl extends BaseModelImpl<ChuyenMon>
	implements ChuyenMonModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chuyen mon model instance should use the {@link org.oep.cmon.dao.cd.model.ChuyenMon} interface instead.
	 */
	public static final String TABLE_NAME = "CMON_CHUYENMON";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "MA", Types.VARCHAR },
			{ "TEN", Types.VARCHAR },
			{ "PHIENBAN", Types.BIGINT },
			{ "NGAYTAO", Types.TIMESTAMP },
			{ "NGUOITAO", Types.VARCHAR },
			{ "NGAYSUA", Types.TIMESTAMP },
			{ "NGUOISUA", Types.VARCHAR },
			{ "DAXOA", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table CMON_CHUYENMON (ID LONG not null primary key,MA VARCHAR(75) null,TEN VARCHAR(75) null,PHIENBAN LONG,NGAYTAO DATE null,NGUOITAO VARCHAR(75) null,NGAYSUA DATE null,NGUOISUA VARCHAR(75) null,DAXOA LONG)";
	public static final String TABLE_SQL_DROP = "drop table CMON_CHUYENMON";
	public static final String ORDER_BY_JPQL = " ORDER BY chuyenMon.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CMON_CHUYENMON.ID ASC";
	public static final String DATA_SOURCE = "egovDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.oep.cmon.dao.cd.model.ChuyenMon"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.oep.cmon.dao.cd.model.ChuyenMon"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.oep.cmon.dao.cd.model.ChuyenMon"));

	public ChuyenMonModelImpl() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return ChuyenMon.class;
	}

	public String getModelClassName() {
		return ChuyenMon.class.getName();
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getMa() {
		if (_ma == null) {
			return StringPool.BLANK;
		}
		else {
			return _ma;
		}
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getTen() {
		if (_ten == null) {
			return StringPool.BLANK;
		}
		else {
			return _ten;
		}
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public long getPhienban() {
		return _phienban;
	}

	public void setPhienban(long phienban) {
		_phienban = phienban;
	}

	public Date getNgaytao() {
		return _ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		_ngaytao = ngaytao;
	}

	public String getNguoitao() {
		if (_nguoitao == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoitao;
		}
	}

	public void setNguoitao(String nguoitao) {
		_nguoitao = nguoitao;
	}

	public Date getNgaysua() {
		return _ngaysua;
	}

	public void setNgaysua(Date ngaysua) {
		_ngaysua = ngaysua;
	}

	public String getNguoisua() {
		if (_nguoisua == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoisua;
		}
	}

	public void setNguoisua(String nguoisua) {
		_nguoisua = nguoisua;
	}

	public long getDaxoa() {
		return _daxoa;
	}

	public void setDaxoa(long daxoa) {
		_daxoa = daxoa;
	}

	@Override
	public ChuyenMon toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ChuyenMon)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					ChuyenMon.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		ChuyenMonImpl chuyenMonImpl = new ChuyenMonImpl();

		chuyenMonImpl.setId(getId());
		chuyenMonImpl.setMa(getMa());
		chuyenMonImpl.setTen(getTen());
		chuyenMonImpl.setPhienban(getPhienban());
		chuyenMonImpl.setNgaytao(getNgaytao());
		chuyenMonImpl.setNguoitao(getNguoitao());
		chuyenMonImpl.setNgaysua(getNgaysua());
		chuyenMonImpl.setNguoisua(getNguoisua());
		chuyenMonImpl.setDaxoa(getDaxoa());

		chuyenMonImpl.resetOriginalValues();

		return chuyenMonImpl;
	}

	public int compareTo(ChuyenMon chuyenMon) {
		int value = 0;

		if (getId() < chuyenMon.getId()) {
			value = -1;
		}
		else if (getId() > chuyenMon.getId()) {
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

		ChuyenMon chuyenMon = null;

		try {
			chuyenMon = (ChuyenMon)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = chuyenMon.getPrimaryKey();

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
	public CacheModel<ChuyenMon> toCacheModel() {
		ChuyenMonCacheModel chuyenMonCacheModel = new ChuyenMonCacheModel();

		chuyenMonCacheModel.id = getId();

		chuyenMonCacheModel.ma = getMa();

		String ma = chuyenMonCacheModel.ma;

		if ((ma != null) && (ma.length() == 0)) {
			chuyenMonCacheModel.ma = null;
		}

		chuyenMonCacheModel.ten = getTen();

		String ten = chuyenMonCacheModel.ten;

		if ((ten != null) && (ten.length() == 0)) {
			chuyenMonCacheModel.ten = null;
		}

		chuyenMonCacheModel.phienban = getPhienban();

		Date ngaytao = getNgaytao();

		if (ngaytao != null) {
			chuyenMonCacheModel.ngaytao = ngaytao.getTime();
		}
		else {
			chuyenMonCacheModel.ngaytao = Long.MIN_VALUE;
		}

		chuyenMonCacheModel.nguoitao = getNguoitao();

		String nguoitao = chuyenMonCacheModel.nguoitao;

		if ((nguoitao != null) && (nguoitao.length() == 0)) {
			chuyenMonCacheModel.nguoitao = null;
		}

		Date ngaysua = getNgaysua();

		if (ngaysua != null) {
			chuyenMonCacheModel.ngaysua = ngaysua.getTime();
		}
		else {
			chuyenMonCacheModel.ngaysua = Long.MIN_VALUE;
		}

		chuyenMonCacheModel.nguoisua = getNguoisua();

		String nguoisua = chuyenMonCacheModel.nguoisua;

		if ((nguoisua != null) && (nguoisua.length() == 0)) {
			chuyenMonCacheModel.nguoisua = null;
		}

		chuyenMonCacheModel.daxoa = getDaxoa();

		return chuyenMonCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", phienban=");
		sb.append(getPhienban());
		sb.append(", ngaytao=");
		sb.append(getNgaytao());
		sb.append(", nguoitao=");
		sb.append(getNguoitao());
		sb.append(", ngaysua=");
		sb.append(getNgaysua());
		sb.append(", nguoisua=");
		sb.append(getNguoisua());
		sb.append(", daxoa=");
		sb.append(getDaxoa());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.cd.model.ChuyenMon");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ma</column-name><column-value><![CDATA[");
		sb.append(getMa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phienban</column-name><column-value><![CDATA[");
		sb.append(getPhienban());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaytao</column-name><column-value><![CDATA[");
		sb.append(getNgaytao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoitao</column-name><column-value><![CDATA[");
		sb.append(getNguoitao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaysua</column-name><column-value><![CDATA[");
		sb.append(getNgaysua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoisua</column-name><column-value><![CDATA[");
		sb.append(getNguoisua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daxoa</column-name><column-value><![CDATA[");
		sb.append(getDaxoa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ChuyenMon.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ChuyenMon.class
		};
	private long _id;
	private String _ma;
	private String _ten;
	private long _phienban;
	private Date _ngaytao;
	private String _nguoitao;
	private Date _ngaysua;
	private String _nguoisua;
	private long _daxoa;
	private transient ExpandoBridge _expandoBridge;
	private ChuyenMon _escapedModelProxy;
}