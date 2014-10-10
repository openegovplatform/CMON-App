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

import org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException;
import org.oep.cmon.dao.cd.model.TinhTrangHonNhan;
import org.oep.cmon.dao.cd.model.impl.TinhTrangHonNhanImpl;
import org.oep.cmon.dao.cd.model.impl.TinhTrangHonNhanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tinh trang hon nhan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see TinhTrangHonNhanPersistence
 * @see TinhTrangHonNhanUtil
 * @generated
 */
public class TinhTrangHonNhanPersistenceImpl extends BasePersistenceImpl<TinhTrangHonNhan>
	implements TinhTrangHonNhanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TinhTrangHonNhanUtil} to access the tinh trang hon nhan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TinhTrangHonNhanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
			TinhTrangHonNhanModelImpl.FINDER_CACHE_ENABLED,
			TinhTrangHonNhanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
			TinhTrangHonNhanModelImpl.FINDER_CACHE_ENABLED,
			TinhTrangHonNhanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			TinhTrangHonNhanModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
			TinhTrangHonNhanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
			TinhTrangHonNhanModelImpl.FINDER_CACHE_ENABLED,
			TinhTrangHonNhanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
			TinhTrangHonNhanModelImpl.FINDER_CACHE_ENABLED,
			TinhTrangHonNhanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
			TinhTrangHonNhanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tinh trang hon nhan in the entity cache if it is enabled.
	 *
	 * @param tinhTrangHonNhan the tinh trang hon nhan
	 */
	public void cacheResult(TinhTrangHonNhan tinhTrangHonNhan) {
		EntityCacheUtil.putResult(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
			TinhTrangHonNhanImpl.class, tinhTrangHonNhan.getPrimaryKey(),
			tinhTrangHonNhan);

		tinhTrangHonNhan.resetOriginalValues();
	}

	/**
	 * Caches the tinh trang hon nhans in the entity cache if it is enabled.
	 *
	 * @param tinhTrangHonNhans the tinh trang hon nhans
	 */
	public void cacheResult(List<TinhTrangHonNhan> tinhTrangHonNhans) {
		for (TinhTrangHonNhan tinhTrangHonNhan : tinhTrangHonNhans) {
			if (EntityCacheUtil.getResult(
						TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
						TinhTrangHonNhanImpl.class,
						tinhTrangHonNhan.getPrimaryKey()) == null) {
				cacheResult(tinhTrangHonNhan);
			}
			else {
				tinhTrangHonNhan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tinh trang hon nhans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TinhTrangHonNhanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TinhTrangHonNhanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tinh trang hon nhan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TinhTrangHonNhan tinhTrangHonNhan) {
		EntityCacheUtil.removeResult(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
			TinhTrangHonNhanImpl.class, tinhTrangHonNhan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TinhTrangHonNhan> tinhTrangHonNhans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TinhTrangHonNhan tinhTrangHonNhan : tinhTrangHonNhans) {
			EntityCacheUtil.removeResult(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
				TinhTrangHonNhanImpl.class, tinhTrangHonNhan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tinh trang hon nhan with the primary key. Does not add the tinh trang hon nhan to the database.
	 *
	 * @param id the primary key for the new tinh trang hon nhan
	 * @return the new tinh trang hon nhan
	 */
	public TinhTrangHonNhan create(long id) {
		TinhTrangHonNhan tinhTrangHonNhan = new TinhTrangHonNhanImpl();

		tinhTrangHonNhan.setNew(true);
		tinhTrangHonNhan.setPrimaryKey(id);

		return tinhTrangHonNhan;
	}

	/**
	 * Removes the tinh trang hon nhan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tinh trang hon nhan
	 * @return the tinh trang hon nhan that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TinhTrangHonNhan remove(long id)
		throws NoSuchTinhTrangHonNhanException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the tinh trang hon nhan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tinh trang hon nhan
	 * @return the tinh trang hon nhan that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinhTrangHonNhan remove(Serializable primaryKey)
		throws NoSuchTinhTrangHonNhanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TinhTrangHonNhan tinhTrangHonNhan = (TinhTrangHonNhan)session.get(TinhTrangHonNhanImpl.class,
					primaryKey);

			if (tinhTrangHonNhan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTinhTrangHonNhanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tinhTrangHonNhan);
		}
		catch (NoSuchTinhTrangHonNhanException nsee) {
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
	protected TinhTrangHonNhan removeImpl(TinhTrangHonNhan tinhTrangHonNhan)
		throws SystemException {
		tinhTrangHonNhan = toUnwrappedModel(tinhTrangHonNhan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tinhTrangHonNhan);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tinhTrangHonNhan);

		return tinhTrangHonNhan;
	}

	@Override
	public TinhTrangHonNhan updateImpl(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan,
		boolean merge) throws SystemException {
		tinhTrangHonNhan = toUnwrappedModel(tinhTrangHonNhan);

		boolean isNew = tinhTrangHonNhan.isNew();

		TinhTrangHonNhanModelImpl tinhTrangHonNhanModelImpl = (TinhTrangHonNhanModelImpl)tinhTrangHonNhan;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tinhTrangHonNhan, merge);

			tinhTrangHonNhan.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TinhTrangHonNhanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tinhTrangHonNhanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(tinhTrangHonNhanModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(tinhTrangHonNhanModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
			TinhTrangHonNhanImpl.class, tinhTrangHonNhan.getPrimaryKey(),
			tinhTrangHonNhan);

		return tinhTrangHonNhan;
	}

	protected TinhTrangHonNhan toUnwrappedModel(
		TinhTrangHonNhan tinhTrangHonNhan) {
		if (tinhTrangHonNhan instanceof TinhTrangHonNhanImpl) {
			return tinhTrangHonNhan;
		}

		TinhTrangHonNhanImpl tinhTrangHonNhanImpl = new TinhTrangHonNhanImpl();

		tinhTrangHonNhanImpl.setNew(tinhTrangHonNhan.isNew());
		tinhTrangHonNhanImpl.setPrimaryKey(tinhTrangHonNhan.getPrimaryKey());

		tinhTrangHonNhanImpl.setId(tinhTrangHonNhan.getId());
		tinhTrangHonNhanImpl.setTen(tinhTrangHonNhan.getTen());
		tinhTrangHonNhanImpl.setNgayTao(tinhTrangHonNhan.getNgayTao());
		tinhTrangHonNhanImpl.setNgaySua(tinhTrangHonNhan.getNgaySua());
		tinhTrangHonNhanImpl.setNguoiTao(tinhTrangHonNhan.getNguoiTao());
		tinhTrangHonNhanImpl.setDaXoa(tinhTrangHonNhan.getDaXoa());
		tinhTrangHonNhanImpl.setNguoiSua(tinhTrangHonNhan.getNguoiSua());

		return tinhTrangHonNhanImpl;
	}

	/**
	 * Returns the tinh trang hon nhan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tinh trang hon nhan
	 * @return the tinh trang hon nhan
	 * @throws com.liferay.portal.NoSuchModelException if a tinh trang hon nhan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinhTrangHonNhan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tinh trang hon nhan with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException} if it could not be found.
	 *
	 * @param id the primary key of the tinh trang hon nhan
	 * @return the tinh trang hon nhan
	 * @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TinhTrangHonNhan findByPrimaryKey(long id)
		throws NoSuchTinhTrangHonNhanException, SystemException {
		TinhTrangHonNhan tinhTrangHonNhan = fetchByPrimaryKey(id);

		if (tinhTrangHonNhan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTinhTrangHonNhanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return tinhTrangHonNhan;
	}

	/**
	 * Returns the tinh trang hon nhan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tinh trang hon nhan
	 * @return the tinh trang hon nhan, or <code>null</code> if a tinh trang hon nhan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinhTrangHonNhan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tinh trang hon nhan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tinh trang hon nhan
	 * @return the tinh trang hon nhan, or <code>null</code> if a tinh trang hon nhan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TinhTrangHonNhan fetchByPrimaryKey(long id)
		throws SystemException {
		TinhTrangHonNhan tinhTrangHonNhan = (TinhTrangHonNhan)EntityCacheUtil.getResult(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
				TinhTrangHonNhanImpl.class, id);

		if (tinhTrangHonNhan == _nullTinhTrangHonNhan) {
			return null;
		}

		if (tinhTrangHonNhan == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tinhTrangHonNhan = (TinhTrangHonNhan)session.get(TinhTrangHonNhanImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tinhTrangHonNhan != null) {
					cacheResult(tinhTrangHonNhan);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TinhTrangHonNhanModelImpl.ENTITY_CACHE_ENABLED,
						TinhTrangHonNhanImpl.class, id, _nullTinhTrangHonNhan);
				}

				closeSession(session);
			}
		}

		return tinhTrangHonNhan;
	}

	/**
	 * Returns all the tinh trang hon nhans where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching tinh trang hon nhans
	 * @throws SystemException if a system exception occurred
	 */
	public List<TinhTrangHonNhan> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tinh trang hon nhans where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of tinh trang hon nhans
	 * @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	 * @return the range of matching tinh trang hon nhans
	 * @throws SystemException if a system exception occurred
	 */
	public List<TinhTrangHonNhan> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tinh trang hon nhans where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of tinh trang hon nhans
	 * @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tinh trang hon nhans
	 * @throws SystemException if a system exception occurred
	 */
	public List<TinhTrangHonNhan> findByTrangThai(int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<TinhTrangHonNhan> list = (List<TinhTrangHonNhan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TINHTRANGHONNHAN_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TinhTrangHonNhanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<TinhTrangHonNhan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tinh trang hon nhan in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tinh trang hon nhan
	 * @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a matching tinh trang hon nhan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TinhTrangHonNhan findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTinhTrangHonNhanException, SystemException {
		List<TinhTrangHonNhan> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTinhTrangHonNhanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last tinh trang hon nhan in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tinh trang hon nhan
	 * @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a matching tinh trang hon nhan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TinhTrangHonNhan findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTinhTrangHonNhanException, SystemException {
		int count = countByTrangThai(daXoa);

		List<TinhTrangHonNhan> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTinhTrangHonNhanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the tinh trang hon nhans before and after the current tinh trang hon nhan in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current tinh trang hon nhan
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tinh trang hon nhan
	 * @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TinhTrangHonNhan[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTinhTrangHonNhanException, SystemException {
		TinhTrangHonNhan tinhTrangHonNhan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TinhTrangHonNhan[] array = new TinhTrangHonNhanImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, tinhTrangHonNhan,
					daXoa, orderByComparator, true);

			array[1] = tinhTrangHonNhan;

			array[2] = getByTrangThai_PrevAndNext(session, tinhTrangHonNhan,
					daXoa, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TinhTrangHonNhan getByTrangThai_PrevAndNext(Session session,
		TinhTrangHonNhan tinhTrangHonNhan, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TINHTRANGHONNHAN_WHERE);

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
			query.append(TinhTrangHonNhanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tinhTrangHonNhan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TinhTrangHonNhan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tinh trang hon nhans.
	 *
	 * @return the tinh trang hon nhans
	 * @throws SystemException if a system exception occurred
	 */
	public List<TinhTrangHonNhan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tinh trang hon nhans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tinh trang hon nhans
	 * @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	 * @return the range of tinh trang hon nhans
	 * @throws SystemException if a system exception occurred
	 */
	public List<TinhTrangHonNhan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tinh trang hon nhans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tinh trang hon nhans
	 * @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tinh trang hon nhans
	 * @throws SystemException if a system exception occurred
	 */
	public List<TinhTrangHonNhan> findAll(int start, int end,
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

		List<TinhTrangHonNhan> list = (List<TinhTrangHonNhan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TINHTRANGHONNHAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TINHTRANGHONNHAN.concat(TinhTrangHonNhanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TinhTrangHonNhan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TinhTrangHonNhan>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the tinh trang hon nhans where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (TinhTrangHonNhan tinhTrangHonNhan : findByTrangThai(daXoa)) {
			remove(tinhTrangHonNhan);
		}
	}

	/**
	 * Removes all the tinh trang hon nhans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TinhTrangHonNhan tinhTrangHonNhan : findAll()) {
			remove(tinhTrangHonNhan);
		}
	}

	/**
	 * Returns the number of tinh trang hon nhans where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching tinh trang hon nhans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TINHTRANGHONNHAN_WHERE);

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
	 * Returns the number of tinh trang hon nhans.
	 *
	 * @return the number of tinh trang hon nhans
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TINHTRANGHONNHAN);

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
	 * Initializes the tinh trang hon nhan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cd.model.TinhTrangHonNhan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TinhTrangHonNhan>> listenersList = new ArrayList<ModelListener<TinhTrangHonNhan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TinhTrangHonNhan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TinhTrangHonNhanImpl.class.getName());
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
	private static final String _SQL_SELECT_TINHTRANGHONNHAN = "SELECT tinhTrangHonNhan FROM TinhTrangHonNhan tinhTrangHonNhan";
	private static final String _SQL_SELECT_TINHTRANGHONNHAN_WHERE = "SELECT tinhTrangHonNhan FROM TinhTrangHonNhan tinhTrangHonNhan WHERE ";
	private static final String _SQL_COUNT_TINHTRANGHONNHAN = "SELECT COUNT(tinhTrangHonNhan) FROM TinhTrangHonNhan tinhTrangHonNhan";
	private static final String _SQL_COUNT_TINHTRANGHONNHAN_WHERE = "SELECT COUNT(tinhTrangHonNhan) FROM TinhTrangHonNhan tinhTrangHonNhan WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "tinhTrangHonNhan.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tinhTrangHonNhan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TinhTrangHonNhan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TinhTrangHonNhan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TinhTrangHonNhanPersistenceImpl.class);
	private static TinhTrangHonNhan _nullTinhTrangHonNhan = new TinhTrangHonNhanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TinhTrangHonNhan> toCacheModel() {
				return _nullTinhTrangHonNhanCacheModel;
			}
		};

	private static CacheModel<TinhTrangHonNhan> _nullTinhTrangHonNhanCacheModel = new CacheModel<TinhTrangHonNhan>() {
			public TinhTrangHonNhan toEntityModel() {
				return _nullTinhTrangHonNhan;
			}
		};
}