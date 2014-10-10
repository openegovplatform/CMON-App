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

package org.oep.dlms.dao.chitietgplx.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException;
import org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX;
import org.oep.dlms.dao.chitietgplx.model.impl.ChiTietGPLXImpl;
import org.oep.dlms.dao.chitietgplx.model.impl.ChiTietGPLXModelImpl;

/**
 * The persistence implementation for the chi tiet g p l x service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hunghq
 * @see ChiTietGPLXPersistence
 * @see ChiTietGPLXUtil
 * @generated
 */
public class ChiTietGPLXPersistenceImpl extends BasePersistenceImpl<ChiTietGPLX>
	implements ChiTietGPLXPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChiTietGPLXUtil} to access the chi tiet g p l x persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChiTietGPLXImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GPLX = new FinderPath(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietGPLXModelImpl.FINDER_CACHE_ENABLED, ChiTietGPLXImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGPLX",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GPLX = new FinderPath(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietGPLXModelImpl.FINDER_CACHE_ENABLED, ChiTietGPLXImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGPLX",
			new String[] { Long.class.getName() },
			ChiTietGPLXModelImpl.IDGPLX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GPLX = new FinderPath(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietGPLXModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGPLX",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietGPLXModelImpl.FINDER_CACHE_ENABLED, ChiTietGPLXImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietGPLXModelImpl.FINDER_CACHE_ENABLED, ChiTietGPLXImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietGPLXModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the chi tiet g p l x in the entity cache if it is enabled.
	 *
	 * @param chiTietGPLX the chi tiet g p l x
	 */
	public void cacheResult(ChiTietGPLX chiTietGPLX) {
		EntityCacheUtil.putResult(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietGPLXImpl.class, chiTietGPLX.getPrimaryKey(), chiTietGPLX);

		chiTietGPLX.resetOriginalValues();
	}

	/**
	 * Caches the chi tiet g p l xs in the entity cache if it is enabled.
	 *
	 * @param chiTietGPLXs the chi tiet g p l xs
	 */
	public void cacheResult(List<ChiTietGPLX> chiTietGPLXs) {
		for (ChiTietGPLX chiTietGPLX : chiTietGPLXs) {
			if (EntityCacheUtil.getResult(
						ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
						ChiTietGPLXImpl.class, chiTietGPLX.getPrimaryKey()) == null) {
				cacheResult(chiTietGPLX);
			}
			else {
				chiTietGPLX.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chi tiet g p l xs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChiTietGPLXImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChiTietGPLXImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chi tiet g p l x.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChiTietGPLX chiTietGPLX) {
		EntityCacheUtil.removeResult(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietGPLXImpl.class, chiTietGPLX.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ChiTietGPLX> chiTietGPLXs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChiTietGPLX chiTietGPLX : chiTietGPLXs) {
			EntityCacheUtil.removeResult(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
				ChiTietGPLXImpl.class, chiTietGPLX.getPrimaryKey());
		}
	}

	/**
	 * Creates a new chi tiet g p l x with the primary key. Does not add the chi tiet g p l x to the database.
	 *
	 * @param id the primary key for the new chi tiet g p l x
	 * @return the new chi tiet g p l x
	 */
	public ChiTietGPLX create(long id) {
		ChiTietGPLX chiTietGPLX = new ChiTietGPLXImpl();

		chiTietGPLX.setNew(true);
		chiTietGPLX.setPrimaryKey(id);

		return chiTietGPLX;
	}

	/**
	 * Removes the chi tiet g p l x with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chi tiet g p l x
	 * @return the chi tiet g p l x that was removed
	 * @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChiTietGPLX remove(long id)
		throws NoSuchChiTietGPLXException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the chi tiet g p l x with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chi tiet g p l x
	 * @return the chi tiet g p l x that was removed
	 * @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietGPLX remove(Serializable primaryKey)
		throws NoSuchChiTietGPLXException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChiTietGPLX chiTietGPLX = (ChiTietGPLX)session.get(ChiTietGPLXImpl.class,
					primaryKey);

			if (chiTietGPLX == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChiTietGPLXException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chiTietGPLX);
		}
		catch (NoSuchChiTietGPLXException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ChiTietGPLX removeImpl(ChiTietGPLX chiTietGPLX)
		throws SystemException {
		chiTietGPLX = toUnwrappedModel(chiTietGPLX);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, chiTietGPLX);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(chiTietGPLX);

		return chiTietGPLX;
	}

	@Override
	public ChiTietGPLX updateImpl(
		org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX chiTietGPLX, boolean merge)
		throws SystemException {
		chiTietGPLX = toUnwrappedModel(chiTietGPLX);

		boolean isNew = chiTietGPLX.isNew();

		ChiTietGPLXModelImpl chiTietGPLXModelImpl = (ChiTietGPLXModelImpl)chiTietGPLX;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, chiTietGPLX, merge);

			chiTietGPLX.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChiTietGPLXModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((chiTietGPLXModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GPLX.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(chiTietGPLXModelImpl.getOriginalIdGPLX())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GPLX, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GPLX,
					args);

				args = new Object[] {
						Long.valueOf(chiTietGPLXModelImpl.getIdGPLX())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GPLX, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GPLX,
					args);
			}
		}

		EntityCacheUtil.putResult(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietGPLXImpl.class, chiTietGPLX.getPrimaryKey(), chiTietGPLX);

		return chiTietGPLX;
	}

	protected ChiTietGPLX toUnwrappedModel(ChiTietGPLX chiTietGPLX) {
		if (chiTietGPLX instanceof ChiTietGPLXImpl) {
			return chiTietGPLX;
		}

		ChiTietGPLXImpl chiTietGPLXImpl = new ChiTietGPLXImpl();

		chiTietGPLXImpl.setNew(chiTietGPLX.isNew());
		chiTietGPLXImpl.setPrimaryKey(chiTietGPLX.getPrimaryKey());

		chiTietGPLXImpl.setId(chiTietGPLX.getId());
		chiTietGPLXImpl.setIdGPLX(chiTietGPLX.getIdGPLX());
		chiTietGPLXImpl.setSoGPLX(chiTietGPLX.getSoGPLX());
		chiTietGPLXImpl.setIdHangGPLX(chiTietGPLX.getIdHangGPLX());
		chiTietGPLXImpl.setIdNoiCapGPLX(chiTietGPLX.getIdNoiCapGPLX());
		chiTietGPLXImpl.setIdNoiCapGPLXNuocNgoai(chiTietGPLX.getIdNoiCapGPLXNuocNgoai());
		chiTietGPLXImpl.setNgayCapGPLX(chiTietGPLX.getNgayCapGPLX());
		chiTietGPLXImpl.setNgayTrungTuyen(chiTietGPLX.getNgayTrungTuyen());
		chiTietGPLXImpl.setNgayHetHan(chiTietGPLX.getNgayHetHan());
		chiTietGPLXImpl.setIdNoiHocLaiXe(chiTietGPLX.getIdNoiHocLaiXe());
		chiTietGPLXImpl.setIdNoiHocLaiXeNuocNgoai(chiTietGPLX.getIdNoiHocLaiXeNuocNgoai());
		chiTietGPLXImpl.setNamHocLaiXe(chiTietGPLX.getNamHocLaiXe());
		chiTietGPLXImpl.setNoiHocLaiXeNuocNgoai(chiTietGPLX.getNoiHocLaiXeNuocNgoai());
		chiTietGPLXImpl.setNoiHocLaiXe(chiTietGPLX.getNoiHocLaiXe());
		chiTietGPLXImpl.setNoiCapGPLXNuocNgoai(chiTietGPLX.getNoiCapGPLXNuocNgoai());
		chiTietGPLXImpl.setNoiCapGPLX(chiTietGPLX.getNoiCapGPLX());
		chiTietGPLXImpl.setNgayTao(chiTietGPLX.getNgayTao());
		chiTietGPLXImpl.setNgaySua(chiTietGPLX.getNgaySua());
		chiTietGPLXImpl.setNguoiTao(chiTietGPLX.getNguoiTao());
		chiTietGPLXImpl.setNguoiSua(chiTietGPLX.getNguoiSua());

		return chiTietGPLXImpl;
	}

	/**
	 * Returns the chi tiet g p l x with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chi tiet g p l x
	 * @return the chi tiet g p l x
	 * @throws com.liferay.portal.NoSuchModelException if a chi tiet g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietGPLX findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the chi tiet g p l x with the primary key or throws a {@link org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException} if it could not be found.
	 *
	 * @param id the primary key of the chi tiet g p l x
	 * @return the chi tiet g p l x
	 * @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChiTietGPLX findByPrimaryKey(long id)
		throws NoSuchChiTietGPLXException, SystemException {
		ChiTietGPLX chiTietGPLX = fetchByPrimaryKey(id);

		if (chiTietGPLX == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchChiTietGPLXException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return chiTietGPLX;
	}

	/**
	 * Returns the chi tiet g p l x with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chi tiet g p l x
	 * @return the chi tiet g p l x, or <code>null</code> if a chi tiet g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietGPLX fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the chi tiet g p l x with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chi tiet g p l x
	 * @return the chi tiet g p l x, or <code>null</code> if a chi tiet g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChiTietGPLX fetchByPrimaryKey(long id) throws SystemException {
		ChiTietGPLX chiTietGPLX = (ChiTietGPLX)EntityCacheUtil.getResult(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
				ChiTietGPLXImpl.class, id);

		if (chiTietGPLX == _nullChiTietGPLX) {
			return null;
		}

		if (chiTietGPLX == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				chiTietGPLX = (ChiTietGPLX)session.get(ChiTietGPLXImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (chiTietGPLX != null) {
					cacheResult(chiTietGPLX);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ChiTietGPLXModelImpl.ENTITY_CACHE_ENABLED,
						ChiTietGPLXImpl.class, id, _nullChiTietGPLX);
				}

				closeSession(session);
			}
		}

		return chiTietGPLX;
	}

	/**
	 * Returns all the chi tiet g p l xs where idGPLX = &#63;.
	 *
	 * @param idGPLX the id g p l x
	 * @return the matching chi tiet g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChiTietGPLX> findByGPLX(long idGPLX) throws SystemException {
		return findByGPLX(idGPLX, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chi tiet g p l xs where idGPLX = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param idGPLX the id g p l x
	 * @param start the lower bound of the range of chi tiet g p l xs
	 * @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	 * @return the range of matching chi tiet g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChiTietGPLX> findByGPLX(long idGPLX, int start, int end)
		throws SystemException {
		return findByGPLX(idGPLX, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chi tiet g p l xs where idGPLX = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param idGPLX the id g p l x
	 * @param start the lower bound of the range of chi tiet g p l xs
	 * @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chi tiet g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChiTietGPLX> findByGPLX(long idGPLX, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GPLX;
			finderArgs = new Object[] { idGPLX };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GPLX;
			finderArgs = new Object[] { idGPLX, start, end, orderByComparator };
		}

		List<ChiTietGPLX> list = (List<ChiTietGPLX>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_CHITIETGPLX_WHERE);

			query.append(_FINDER_COLUMN_GPLX_IDGPLX_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idGPLX);

				list = (List<ChiTietGPLX>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first chi tiet g p l x in the ordered set where idGPLX = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param idGPLX the id g p l x
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi tiet g p l x
	 * @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a matching chi tiet g p l x could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChiTietGPLX findByGPLX_First(long idGPLX,
		OrderByComparator orderByComparator)
		throws NoSuchChiTietGPLXException, SystemException {
		List<ChiTietGPLX> list = findByGPLX(idGPLX, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("idGPLX=");
			msg.append(idGPLX);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChiTietGPLXException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chi tiet g p l x in the ordered set where idGPLX = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param idGPLX the id g p l x
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi tiet g p l x
	 * @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a matching chi tiet g p l x could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChiTietGPLX findByGPLX_Last(long idGPLX,
		OrderByComparator orderByComparator)
		throws NoSuchChiTietGPLXException, SystemException {
		int count = countByGPLX(idGPLX);

		List<ChiTietGPLX> list = findByGPLX(idGPLX, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("idGPLX=");
			msg.append(idGPLX);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChiTietGPLXException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chi tiet g p l xs before and after the current chi tiet g p l x in the ordered set where idGPLX = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chi tiet g p l x
	 * @param idGPLX the id g p l x
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chi tiet g p l x
	 * @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChiTietGPLX[] findByGPLX_PrevAndNext(long id, long idGPLX,
		OrderByComparator orderByComparator)
		throws NoSuchChiTietGPLXException, SystemException {
		ChiTietGPLX chiTietGPLX = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChiTietGPLX[] array = new ChiTietGPLXImpl[3];

			array[0] = getByGPLX_PrevAndNext(session, chiTietGPLX, idGPLX,
					orderByComparator, true);

			array[1] = chiTietGPLX;

			array[2] = getByGPLX_PrevAndNext(session, chiTietGPLX, idGPLX,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChiTietGPLX getByGPLX_PrevAndNext(Session session,
		ChiTietGPLX chiTietGPLX, long idGPLX,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHITIETGPLX_WHERE);

		query.append(_FINDER_COLUMN_GPLX_IDGPLX_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idGPLX);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chiTietGPLX);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChiTietGPLX> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chi tiet g p l xs.
	 *
	 * @return the chi tiet g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChiTietGPLX> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chi tiet g p l xs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi tiet g p l xs
	 * @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	 * @return the range of chi tiet g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChiTietGPLX> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chi tiet g p l xs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi tiet g p l xs
	 * @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chi tiet g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChiTietGPLX> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ChiTietGPLX> list = (List<ChiTietGPLX>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHITIETGPLX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHITIETGPLX;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ChiTietGPLX>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ChiTietGPLX>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the chi tiet g p l xs where idGPLX = &#63; from the database.
	 *
	 * @param idGPLX the id g p l x
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGPLX(long idGPLX) throws SystemException {
		for (ChiTietGPLX chiTietGPLX : findByGPLX(idGPLX)) {
			remove(chiTietGPLX);
		}
	}

	/**
	 * Removes all the chi tiet g p l xs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ChiTietGPLX chiTietGPLX : findAll()) {
			remove(chiTietGPLX);
		}
	}

	/**
	 * Returns the number of chi tiet g p l xs where idGPLX = &#63;.
	 *
	 * @param idGPLX the id g p l x
	 * @return the number of matching chi tiet g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGPLX(long idGPLX) throws SystemException {
		Object[] finderArgs = new Object[] { idGPLX };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GPLX,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHITIETGPLX_WHERE);

			query.append(_FINDER_COLUMN_GPLX_IDGPLX_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idGPLX);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GPLX,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chi tiet g p l xs.
	 *
	 * @return the number of chi tiet g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHITIETGPLX);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the chi tiet g p l x persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.dlms.dao.chitietgplx.model.ChiTietGPLX")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChiTietGPLX>> listenersList = new ArrayList<ModelListener<ChiTietGPLX>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChiTietGPLX>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ChiTietGPLXImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChiTietGPLXPersistence.class)
	protected ChiTietGPLXPersistence chiTietGPLXPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CHITIETGPLX = "SELECT chiTietGPLX FROM ChiTietGPLX chiTietGPLX";
	private static final String _SQL_SELECT_CHITIETGPLX_WHERE = "SELECT chiTietGPLX FROM ChiTietGPLX chiTietGPLX WHERE ";
	private static final String _SQL_COUNT_CHITIETGPLX = "SELECT COUNT(chiTietGPLX) FROM ChiTietGPLX chiTietGPLX";
	private static final String _SQL_COUNT_CHITIETGPLX_WHERE = "SELECT COUNT(chiTietGPLX) FROM ChiTietGPLX chiTietGPLX WHERE ";
	private static final String _FINDER_COLUMN_GPLX_IDGPLX_2 = "chiTietGPLX.idGPLX = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chiTietGPLX.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChiTietGPLX exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChiTietGPLX exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChiTietGPLXPersistenceImpl.class);
	private static ChiTietGPLX _nullChiTietGPLX = new ChiTietGPLXImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChiTietGPLX> toCacheModel() {
				return _nullChiTietGPLXCacheModel;
			}
		};

	private static CacheModel<ChiTietGPLX> _nullChiTietGPLXCacheModel = new CacheModel<ChiTietGPLX>() {
			public ChiTietGPLX toEntityModel() {
				return _nullChiTietGPLX;
			}
		};
}