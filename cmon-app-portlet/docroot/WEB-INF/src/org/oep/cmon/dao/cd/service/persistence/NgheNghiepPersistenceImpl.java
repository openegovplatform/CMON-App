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

package org.oep.cmon.dao.cd.service.persistence;

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

import org.oep.cmon.dao.cd.NoSuchNgheNghiepException;
import org.oep.cmon.dao.cd.model.NgheNghiep;
import org.oep.cmon.dao.cd.model.impl.NgheNghiepImpl;
import org.oep.cmon.dao.cd.model.impl.NgheNghiepModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the nghe nghiep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see NgheNghiepPersistence
 * @see NgheNghiepUtil
 * @generated
 */
public class NgheNghiepPersistenceImpl extends BasePersistenceImpl<NgheNghiep>
	implements NgheNghiepPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NgheNghiepUtil} to access the nghe nghiep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NgheNghiepImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
			NgheNghiepModelImpl.FINDER_CACHE_ENABLED, NgheNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
			NgheNghiepModelImpl.FINDER_CACHE_ENABLED, NgheNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			NgheNghiepModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
			NgheNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
			NgheNghiepModelImpl.FINDER_CACHE_ENABLED, NgheNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
			NgheNghiepModelImpl.FINDER_CACHE_ENABLED, NgheNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
			NgheNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the nghe nghiep in the entity cache if it is enabled.
	 *
	 * @param ngheNghiep the nghe nghiep
	 */
	public void cacheResult(NgheNghiep ngheNghiep) {
		EntityCacheUtil.putResult(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
			NgheNghiepImpl.class, ngheNghiep.getPrimaryKey(), ngheNghiep);

		ngheNghiep.resetOriginalValues();
	}

	/**
	 * Caches the nghe nghieps in the entity cache if it is enabled.
	 *
	 * @param ngheNghieps the nghe nghieps
	 */
	public void cacheResult(List<NgheNghiep> ngheNghieps) {
		for (NgheNghiep ngheNghiep : ngheNghieps) {
			if (EntityCacheUtil.getResult(
						NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
						NgheNghiepImpl.class, ngheNghiep.getPrimaryKey()) == null) {
				cacheResult(ngheNghiep);
			}
			else {
				ngheNghiep.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all nghe nghieps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NgheNghiepImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NgheNghiepImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the nghe nghiep.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NgheNghiep ngheNghiep) {
		EntityCacheUtil.removeResult(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
			NgheNghiepImpl.class, ngheNghiep.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NgheNghiep> ngheNghieps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NgheNghiep ngheNghiep : ngheNghieps) {
			EntityCacheUtil.removeResult(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
				NgheNghiepImpl.class, ngheNghiep.getPrimaryKey());
		}
	}

	/**
	 * Creates a new nghe nghiep with the primary key. Does not add the nghe nghiep to the database.
	 *
	 * @param id the primary key for the new nghe nghiep
	 * @return the new nghe nghiep
	 */
	public NgheNghiep create(long id) {
		NgheNghiep ngheNghiep = new NgheNghiepImpl();

		ngheNghiep.setNew(true);
		ngheNghiep.setPrimaryKey(id);

		return ngheNghiep;
	}

	/**
	 * Removes the nghe nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nghe nghiep
	 * @return the nghe nghiep that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchNgheNghiepException if a nghe nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NgheNghiep remove(long id)
		throws NoSuchNgheNghiepException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the nghe nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nghe nghiep
	 * @return the nghe nghiep that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchNgheNghiepException if a nghe nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NgheNghiep remove(Serializable primaryKey)
		throws NoSuchNgheNghiepException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NgheNghiep ngheNghiep = (NgheNghiep)session.get(NgheNghiepImpl.class,
					primaryKey);

			if (ngheNghiep == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNgheNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ngheNghiep);
		}
		catch (NoSuchNgheNghiepException nsee) {
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
	protected NgheNghiep removeImpl(NgheNghiep ngheNghiep)
		throws SystemException {
		ngheNghiep = toUnwrappedModel(ngheNghiep);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ngheNghiep);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ngheNghiep);

		return ngheNghiep;
	}

	@Override
	public NgheNghiep updateImpl(
		org.oep.cmon.dao.cd.model.NgheNghiep ngheNghiep, boolean merge)
		throws SystemException {
		ngheNghiep = toUnwrappedModel(ngheNghiep);

		boolean isNew = ngheNghiep.isNew();

		NgheNghiepModelImpl ngheNghiepModelImpl = (NgheNghiepModelImpl)ngheNghiep;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ngheNghiep, merge);

			ngheNghiep.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NgheNghiepModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ngheNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(ngheNghiepModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(ngheNghiepModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
			NgheNghiepImpl.class, ngheNghiep.getPrimaryKey(), ngheNghiep);

		return ngheNghiep;
	}

	protected NgheNghiep toUnwrappedModel(NgheNghiep ngheNghiep) {
		if (ngheNghiep instanceof NgheNghiepImpl) {
			return ngheNghiep;
		}

		NgheNghiepImpl ngheNghiepImpl = new NgheNghiepImpl();

		ngheNghiepImpl.setNew(ngheNghiep.isNew());
		ngheNghiepImpl.setPrimaryKey(ngheNghiep.getPrimaryKey());

		ngheNghiepImpl.setId(ngheNghiep.getId());
		ngheNghiepImpl.setMa(ngheNghiep.getMa());
		ngheNghiepImpl.setTen(ngheNghiep.getTen());
		ngheNghiepImpl.setNgayTao(ngheNghiep.getNgayTao());
		ngheNghiepImpl.setDaXoa(ngheNghiep.getDaXoa());
		ngheNghiepImpl.setNguoiTao(ngheNghiep.getNguoiTao());
		ngheNghiepImpl.setNguoiSua(ngheNghiep.getNguoiSua());
		ngheNghiepImpl.setNgaySua(ngheNghiep.getNgaySua());
		ngheNghiepImpl.setPhienBan(ngheNghiep.getPhienBan());

		return ngheNghiepImpl;
	}

	/**
	 * Returns the nghe nghiep with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the nghe nghiep
	 * @return the nghe nghiep
	 * @throws com.liferay.portal.NoSuchModelException if a nghe nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NgheNghiep findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the nghe nghiep with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchNgheNghiepException} if it could not be found.
	 *
	 * @param id the primary key of the nghe nghiep
	 * @return the nghe nghiep
	 * @throws org.oep.cmon.dao.cd.NoSuchNgheNghiepException if a nghe nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NgheNghiep findByPrimaryKey(long id)
		throws NoSuchNgheNghiepException, SystemException {
		NgheNghiep ngheNghiep = fetchByPrimaryKey(id);

		if (ngheNghiep == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchNgheNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return ngheNghiep;
	}

	/**
	 * Returns the nghe nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nghe nghiep
	 * @return the nghe nghiep, or <code>null</code> if a nghe nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NgheNghiep fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the nghe nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nghe nghiep
	 * @return the nghe nghiep, or <code>null</code> if a nghe nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NgheNghiep fetchByPrimaryKey(long id) throws SystemException {
		NgheNghiep ngheNghiep = (NgheNghiep)EntityCacheUtil.getResult(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
				NgheNghiepImpl.class, id);

		if (ngheNghiep == _nullNgheNghiep) {
			return null;
		}

		if (ngheNghiep == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ngheNghiep = (NgheNghiep)session.get(NgheNghiepImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ngheNghiep != null) {
					cacheResult(ngheNghiep);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(NgheNghiepModelImpl.ENTITY_CACHE_ENABLED,
						NgheNghiepImpl.class, id, _nullNgheNghiep);
				}

				closeSession(session);
			}
		}

		return ngheNghiep;
	}

	/**
	 * Returns all the nghe nghieps where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching nghe nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<NgheNghiep> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nghe nghieps where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nghe nghieps
	 * @param end the upper bound of the range of nghe nghieps (not inclusive)
	 * @return the range of matching nghe nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<NgheNghiep> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the nghe nghieps where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nghe nghieps
	 * @param end the upper bound of the range of nghe nghieps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nghe nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<NgheNghiep> findByTrangThai(int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { daXoa, start, end, orderByComparator };
		}

		List<NgheNghiep> list = (List<NgheNghiep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_NGHENGHIEP_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(NgheNghiepModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<NgheNghiep>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first nghe nghiep in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nghe nghiep
	 * @throws org.oep.cmon.dao.cd.NoSuchNgheNghiepException if a matching nghe nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NgheNghiep findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNgheNghiepException, SystemException {
		List<NgheNghiep> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNgheNghiepException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last nghe nghiep in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nghe nghiep
	 * @throws org.oep.cmon.dao.cd.NoSuchNgheNghiepException if a matching nghe nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NgheNghiep findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNgheNghiepException, SystemException {
		int count = countByTrangThai(daXoa);

		List<NgheNghiep> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNgheNghiepException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the nghe nghieps before and after the current nghe nghiep in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current nghe nghiep
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nghe nghiep
	 * @throws org.oep.cmon.dao.cd.NoSuchNgheNghiepException if a nghe nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NgheNghiep[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNgheNghiepException, SystemException {
		NgheNghiep ngheNghiep = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NgheNghiep[] array = new NgheNghiepImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, ngheNghiep, daXoa,
					orderByComparator, true);

			array[1] = ngheNghiep;

			array[2] = getByTrangThai_PrevAndNext(session, ngheNghiep, daXoa,
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

	protected NgheNghiep getByTrangThai_PrevAndNext(Session session,
		NgheNghiep ngheNghiep, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NGHENGHIEP_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

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

		else {
			query.append(NgheNghiepModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ngheNghiep);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NgheNghiep> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the nghe nghieps.
	 *
	 * @return the nghe nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<NgheNghiep> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nghe nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of nghe nghieps
	 * @param end the upper bound of the range of nghe nghieps (not inclusive)
	 * @return the range of nghe nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<NgheNghiep> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the nghe nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of nghe nghieps
	 * @param end the upper bound of the range of nghe nghieps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nghe nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<NgheNghiep> findAll(int start, int end,
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

		List<NgheNghiep> list = (List<NgheNghiep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NGHENGHIEP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NGHENGHIEP.concat(NgheNghiepModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<NgheNghiep>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<NgheNghiep>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the nghe nghieps where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (NgheNghiep ngheNghiep : findByTrangThai(daXoa)) {
			remove(ngheNghiep);
		}
	}

	/**
	 * Removes all the nghe nghieps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (NgheNghiep ngheNghiep : findAll()) {
			remove(ngheNghiep);
		}
	}

	/**
	 * Returns the number of nghe nghieps where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching nghe nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NGHENGHIEP_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of nghe nghieps.
	 *
	 * @return the number of nghe nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NGHENGHIEP);

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
	 * Initializes the nghe nghiep persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cd.model.NgheNghiep")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NgheNghiep>> listenersList = new ArrayList<ModelListener<NgheNghiep>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NgheNghiep>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NgheNghiepImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChuyenMonPersistence.class)
	protected ChuyenMonPersistence chuyenMonPersistence;
	@BeanReference(type = CongDanPersistence.class)
	protected CongDanPersistence congDanPersistence;
	@BeanReference(type = DanTocPersistence.class)
	protected DanTocPersistence danTocPersistence;
	@BeanReference(type = GioiTinhPersistence.class)
	protected GioiTinhPersistence gioiTinhPersistence;
	@BeanReference(type = HeThongPersistence.class)
	protected HeThongPersistence heThongPersistence;
	@BeanReference(type = HoChieuCMNDPersistence.class)
	protected HoChieuCMNDPersistence hoChieuCMNDPersistence;
	@BeanReference(type = NgheNghiepPersistence.class)
	protected NgheNghiepPersistence ngheNghiepPersistence;
	@BeanReference(type = QuanHeGiaDinhPersistence.class)
	protected QuanHeGiaDinhPersistence quanHeGiaDinhPersistence;
	@BeanReference(type = TinhTrangHonNhanPersistence.class)
	protected TinhTrangHonNhanPersistence tinhTrangHonNhanPersistence;
	@BeanReference(type = TonGiaoPersistence.class)
	protected TonGiaoPersistence tonGiaoPersistence;
	@BeanReference(type = TrinhDoChuyenMonPersistence.class)
	protected TrinhDoChuyenMonPersistence trinhDoChuyenMonPersistence;
	@BeanReference(type = TrinhDoHocVanPersistence.class)
	protected TrinhDoHocVanPersistence trinhDoHocVanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_NGHENGHIEP = "SELECT ngheNghiep FROM NgheNghiep ngheNghiep";
	private static final String _SQL_SELECT_NGHENGHIEP_WHERE = "SELECT ngheNghiep FROM NgheNghiep ngheNghiep WHERE ";
	private static final String _SQL_COUNT_NGHENGHIEP = "SELECT COUNT(ngheNghiep) FROM NgheNghiep ngheNghiep";
	private static final String _SQL_COUNT_NGHENGHIEP_WHERE = "SELECT COUNT(ngheNghiep) FROM NgheNghiep ngheNghiep WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "ngheNghiep.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ngheNghiep.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NgheNghiep exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NgheNghiep exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NgheNghiepPersistenceImpl.class);
	private static NgheNghiep _nullNgheNghiep = new NgheNghiepImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NgheNghiep> toCacheModel() {
				return _nullNgheNghiepCacheModel;
			}
		};

	private static CacheModel<NgheNghiep> _nullNgheNghiepCacheModel = new CacheModel<NgheNghiep>() {
			public NgheNghiep toEntityModel() {
				return _nullNgheNghiep;
			}
		};
}