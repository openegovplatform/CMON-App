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

import org.oep.cmon.dao.cd.NoSuchTonGiaoException;
import org.oep.cmon.dao.cd.model.TonGiao;
import org.oep.cmon.dao.cd.model.impl.TonGiaoImpl;
import org.oep.cmon.dao.cd.model.impl.TonGiaoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ton giao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see TonGiaoPersistence
 * @see TonGiaoUtil
 * @generated
 */
public class TonGiaoPersistenceImpl extends BasePersistenceImpl<TonGiao>
	implements TonGiaoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TonGiaoUtil} to access the ton giao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TonGiaoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
			TonGiaoModelImpl.FINDER_CACHE_ENABLED, TonGiaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
			TonGiaoModelImpl.FINDER_CACHE_ENABLED, TonGiaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			TonGiaoModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
			TonGiaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
			TonGiaoModelImpl.FINDER_CACHE_ENABLED, TonGiaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
			TonGiaoModelImpl.FINDER_CACHE_ENABLED, TonGiaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
			TonGiaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ton giao in the entity cache if it is enabled.
	 *
	 * @param tonGiao the ton giao
	 */
	public void cacheResult(TonGiao tonGiao) {
		EntityCacheUtil.putResult(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
			TonGiaoImpl.class, tonGiao.getPrimaryKey(), tonGiao);

		tonGiao.resetOriginalValues();
	}

	/**
	 * Caches the ton giaos in the entity cache if it is enabled.
	 *
	 * @param tonGiaos the ton giaos
	 */
	public void cacheResult(List<TonGiao> tonGiaos) {
		for (TonGiao tonGiao : tonGiaos) {
			if (EntityCacheUtil.getResult(
						TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
						TonGiaoImpl.class, tonGiao.getPrimaryKey()) == null) {
				cacheResult(tonGiao);
			}
			else {
				tonGiao.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ton giaos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TonGiaoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TonGiaoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ton giao.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TonGiao tonGiao) {
		EntityCacheUtil.removeResult(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
			TonGiaoImpl.class, tonGiao.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TonGiao> tonGiaos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TonGiao tonGiao : tonGiaos) {
			EntityCacheUtil.removeResult(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
				TonGiaoImpl.class, tonGiao.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ton giao with the primary key. Does not add the ton giao to the database.
	 *
	 * @param id the primary key for the new ton giao
	 * @return the new ton giao
	 */
	public TonGiao create(long id) {
		TonGiao tonGiao = new TonGiaoImpl();

		tonGiao.setNew(true);
		tonGiao.setPrimaryKey(id);

		return tonGiao;
	}

	/**
	 * Removes the ton giao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ton giao
	 * @return the ton giao that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a ton giao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao remove(long id)
		throws NoSuchTonGiaoException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the ton giao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ton giao
	 * @return the ton giao that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a ton giao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TonGiao remove(Serializable primaryKey)
		throws NoSuchTonGiaoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TonGiao tonGiao = (TonGiao)session.get(TonGiaoImpl.class, primaryKey);

			if (tonGiao == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTonGiaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tonGiao);
		}
		catch (NoSuchTonGiaoException nsee) {
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
	protected TonGiao removeImpl(TonGiao tonGiao) throws SystemException {
		tonGiao = toUnwrappedModel(tonGiao);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tonGiao);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tonGiao);

		return tonGiao;
	}

	@Override
	public TonGiao updateImpl(org.oep.cmon.dao.cd.model.TonGiao tonGiao,
		boolean merge) throws SystemException {
		tonGiao = toUnwrappedModel(tonGiao);

		boolean isNew = tonGiao.isNew();

		TonGiaoModelImpl tonGiaoModelImpl = (TonGiaoModelImpl)tonGiao;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tonGiao, merge);

			tonGiao.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TonGiaoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tonGiaoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(tonGiaoModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] { Integer.valueOf(tonGiaoModelImpl.getDaXoa()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
			TonGiaoImpl.class, tonGiao.getPrimaryKey(), tonGiao);

		return tonGiao;
	}

	protected TonGiao toUnwrappedModel(TonGiao tonGiao) {
		if (tonGiao instanceof TonGiaoImpl) {
			return tonGiao;
		}

		TonGiaoImpl tonGiaoImpl = new TonGiaoImpl();

		tonGiaoImpl.setNew(tonGiao.isNew());
		tonGiaoImpl.setPrimaryKey(tonGiao.getPrimaryKey());

		tonGiaoImpl.setId(tonGiao.getId());
		tonGiaoImpl.setMa(tonGiao.getMa());
		tonGiaoImpl.setTen(tonGiao.getTen());
		tonGiaoImpl.setNgayTao(tonGiao.getNgayTao());
		tonGiaoImpl.setDaXoa(tonGiao.getDaXoa());
		tonGiaoImpl.setNguoiTao(tonGiao.getNguoiTao());
		tonGiaoImpl.setNguoiSua(tonGiao.getNguoiSua());
		tonGiaoImpl.setNgaySua(tonGiao.getNgaySua());
		tonGiaoImpl.setPhienBan(tonGiao.getPhienBan());

		return tonGiaoImpl;
	}

	/**
	 * Returns the ton giao with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ton giao
	 * @return the ton giao
	 * @throws com.liferay.portal.NoSuchModelException if a ton giao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TonGiao findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ton giao with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchTonGiaoException} if it could not be found.
	 *
	 * @param id the primary key of the ton giao
	 * @return the ton giao
	 * @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a ton giao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao findByPrimaryKey(long id)
		throws NoSuchTonGiaoException, SystemException {
		TonGiao tonGiao = fetchByPrimaryKey(id);

		if (tonGiao == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTonGiaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return tonGiao;
	}

	/**
	 * Returns the ton giao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ton giao
	 * @return the ton giao, or <code>null</code> if a ton giao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TonGiao fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ton giao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ton giao
	 * @return the ton giao, or <code>null</code> if a ton giao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao fetchByPrimaryKey(long id) throws SystemException {
		TonGiao tonGiao = (TonGiao)EntityCacheUtil.getResult(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
				TonGiaoImpl.class, id);

		if (tonGiao == _nullTonGiao) {
			return null;
		}

		if (tonGiao == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tonGiao = (TonGiao)session.get(TonGiaoImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tonGiao != null) {
					cacheResult(tonGiao);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TonGiaoModelImpl.ENTITY_CACHE_ENABLED,
						TonGiaoImpl.class, id, _nullTonGiao);
				}

				closeSession(session);
			}
		}

		return tonGiao;
	}

	/**
	 * Returns all the ton giaos where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TonGiao> findByTrangThai(int daXoa) throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ton giaos where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of ton giaos
	 * @param end the upper bound of the range of ton giaos (not inclusive)
	 * @return the range of matching ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TonGiao> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ton giaos where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of ton giaos
	 * @param end the upper bound of the range of ton giaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TonGiao> findByTrangThai(int daXoa, int start, int end,
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

		List<TonGiao> list = (List<TonGiao>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TONGIAO_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TonGiaoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<TonGiao>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first ton giao in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ton giao
	 * @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a matching ton giao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTonGiaoException, SystemException {
		List<TonGiao> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTonGiaoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ton giao in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ton giao
	 * @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a matching ton giao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTonGiaoException, SystemException {
		int count = countByTrangThai(daXoa);

		List<TonGiao> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTonGiaoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ton giaos before and after the current ton giao in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ton giao
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ton giao
	 * @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a ton giao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTonGiaoException, SystemException {
		TonGiao tonGiao = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TonGiao[] array = new TonGiaoImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, tonGiao, daXoa,
					orderByComparator, true);

			array[1] = tonGiao;

			array[2] = getByTrangThai_PrevAndNext(session, tonGiao, daXoa,
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

	protected TonGiao getByTrangThai_PrevAndNext(Session session,
		TonGiao tonGiao, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TONGIAO_WHERE);

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
			query.append(TonGiaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tonGiao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TonGiao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ton giaos.
	 *
	 * @return the ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TonGiao> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ton giaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ton giaos
	 * @param end the upper bound of the range of ton giaos (not inclusive)
	 * @return the range of ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TonGiao> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ton giaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ton giaos
	 * @param end the upper bound of the range of ton giaos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TonGiao> findAll(int start, int end,
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

		List<TonGiao> list = (List<TonGiao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TONGIAO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TONGIAO.concat(TonGiaoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TonGiao>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TonGiao>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ton giaos where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (TonGiao tonGiao : findByTrangThai(daXoa)) {
			remove(tonGiao);
		}
	}

	/**
	 * Removes all the ton giaos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TonGiao tonGiao : findAll()) {
			remove(tonGiao);
		}
	}

	/**
	 * Returns the number of ton giaos where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TONGIAO_WHERE);

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
	 * Returns the number of ton giaos.
	 *
	 * @return the number of ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TONGIAO);

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
	 * Initializes the ton giao persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cd.model.TonGiao")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TonGiao>> listenersList = new ArrayList<ModelListener<TonGiao>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TonGiao>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TonGiaoImpl.class.getName());
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
	private static final String _SQL_SELECT_TONGIAO = "SELECT tonGiao FROM TonGiao tonGiao";
	private static final String _SQL_SELECT_TONGIAO_WHERE = "SELECT tonGiao FROM TonGiao tonGiao WHERE ";
	private static final String _SQL_COUNT_TONGIAO = "SELECT COUNT(tonGiao) FROM TonGiao tonGiao";
	private static final String _SQL_COUNT_TONGIAO_WHERE = "SELECT COUNT(tonGiao) FROM TonGiao tonGiao WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "tonGiao.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tonGiao.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TonGiao exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TonGiao exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TonGiaoPersistenceImpl.class);
	private static TonGiao _nullTonGiao = new TonGiaoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TonGiao> toCacheModel() {
				return _nullTonGiaoCacheModel;
			}
		};

	private static CacheModel<TonGiao> _nullTonGiaoCacheModel = new CacheModel<TonGiao>() {
			public TonGiao toEntityModel() {
				return _nullTonGiao;
			}
		};
}