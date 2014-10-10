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

package org.oep.cmon.dao.hosohcc.service.persistence;

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

import org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.impl.YKienTraoDoiImpl;
import org.oep.cmon.dao.hosohcc.model.impl.YKienTraoDoiModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the y kien trao doi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see YKienTraoDoiPersistence
 * @see YKienTraoDoiUtil
 * @generated
 */
public class YKienTraoDoiPersistenceImpl extends BasePersistenceImpl<YKienTraoDoi>
	implements YKienTraoDoiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YKienTraoDoiUtil} to access the y kien trao doi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YKienTraoDoiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAI = new FinderPath(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiModelImpl.FINDER_CACHE_ENABLED, YKienTraoDoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLoai",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAI = new FinderPath(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiModelImpl.FINDER_CACHE_ENABLED, YKienTraoDoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLoai",
			new String[] { Long.class.getName() },
			YKienTraoDoiModelImpl.LOAI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOAI = new FinderPath(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLoai",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiModelImpl.FINDER_CACHE_ENABLED, YKienTraoDoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiModelImpl.FINDER_CACHE_ENABLED, YKienTraoDoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Long.class.getName() },
			YKienTraoDoiModelImpl.TRANGTHAI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiModelImpl.FINDER_CACHE_ENABLED, YKienTraoDoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiModelImpl.FINDER_CACHE_ENABLED, YKienTraoDoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the y kien trao doi in the entity cache if it is enabled.
	 *
	 * @param yKienTraoDoi the y kien trao doi
	 */
	public void cacheResult(YKienTraoDoi yKienTraoDoi) {
		EntityCacheUtil.putResult(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiImpl.class, yKienTraoDoi.getPrimaryKey(), yKienTraoDoi);

		yKienTraoDoi.resetOriginalValues();
	}

	/**
	 * Caches the y kien trao dois in the entity cache if it is enabled.
	 *
	 * @param yKienTraoDois the y kien trao dois
	 */
	public void cacheResult(List<YKienTraoDoi> yKienTraoDois) {
		for (YKienTraoDoi yKienTraoDoi : yKienTraoDois) {
			if (EntityCacheUtil.getResult(
						YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
						YKienTraoDoiImpl.class, yKienTraoDoi.getPrimaryKey()) == null) {
				cacheResult(yKienTraoDoi);
			}
			else {
				yKienTraoDoi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all y kien trao dois.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(YKienTraoDoiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(YKienTraoDoiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the y kien trao doi.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YKienTraoDoi yKienTraoDoi) {
		EntityCacheUtil.removeResult(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiImpl.class, yKienTraoDoi.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<YKienTraoDoi> yKienTraoDois) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YKienTraoDoi yKienTraoDoi : yKienTraoDois) {
			EntityCacheUtil.removeResult(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
				YKienTraoDoiImpl.class, yKienTraoDoi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new y kien trao doi with the primary key. Does not add the y kien trao doi to the database.
	 *
	 * @param id the primary key for the new y kien trao doi
	 * @return the new y kien trao doi
	 */
	public YKienTraoDoi create(long id) {
		YKienTraoDoi yKienTraoDoi = new YKienTraoDoiImpl();

		yKienTraoDoi.setNew(true);
		yKienTraoDoi.setPrimaryKey(id);

		return yKienTraoDoi;
	}

	/**
	 * Removes the y kien trao doi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the y kien trao doi
	 * @return the y kien trao doi that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKienTraoDoi remove(long id)
		throws NoSuchYKienTraoDoiException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the y kien trao doi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the y kien trao doi
	 * @return the y kien trao doi that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKienTraoDoi remove(Serializable primaryKey)
		throws NoSuchYKienTraoDoiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			YKienTraoDoi yKienTraoDoi = (YKienTraoDoi)session.get(YKienTraoDoiImpl.class,
					primaryKey);

			if (yKienTraoDoi == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYKienTraoDoiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(yKienTraoDoi);
		}
		catch (NoSuchYKienTraoDoiException nsee) {
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
	protected YKienTraoDoi removeImpl(YKienTraoDoi yKienTraoDoi)
		throws SystemException {
		yKienTraoDoi = toUnwrappedModel(yKienTraoDoi);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, yKienTraoDoi);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(yKienTraoDoi);

		return yKienTraoDoi;
	}

	@Override
	public YKienTraoDoi updateImpl(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi, boolean merge)
		throws SystemException {
		yKienTraoDoi = toUnwrappedModel(yKienTraoDoi);

		boolean isNew = yKienTraoDoi.isNew();

		YKienTraoDoiModelImpl yKienTraoDoiModelImpl = (YKienTraoDoiModelImpl)yKienTraoDoi;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, yKienTraoDoi, merge);

			yKienTraoDoi.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !YKienTraoDoiModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((yKienTraoDoiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(yKienTraoDoiModelImpl.getOriginalLoai())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAI, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAI,
					args);

				args = new Object[] {
						Long.valueOf(yKienTraoDoiModelImpl.getLoai())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAI, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAI,
					args);
			}

			if ((yKienTraoDoiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(yKienTraoDoiModelImpl.getOriginalTrangThai())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Long.valueOf(yKienTraoDoiModelImpl.getTrangThai())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
			YKienTraoDoiImpl.class, yKienTraoDoi.getPrimaryKey(), yKienTraoDoi);

		return yKienTraoDoi;
	}

	protected YKienTraoDoi toUnwrappedModel(YKienTraoDoi yKienTraoDoi) {
		if (yKienTraoDoi instanceof YKienTraoDoiImpl) {
			return yKienTraoDoi;
		}

		YKienTraoDoiImpl yKienTraoDoiImpl = new YKienTraoDoiImpl();

		yKienTraoDoiImpl.setNew(yKienTraoDoi.isNew());
		yKienTraoDoiImpl.setPrimaryKey(yKienTraoDoi.getPrimaryKey());

		yKienTraoDoiImpl.setId(yKienTraoDoi.getId());
		yKienTraoDoiImpl.setTieuDe(yKienTraoDoi.getTieuDe());
		yKienTraoDoiImpl.setNoiDungYKien(yKienTraoDoi.getNoiDungYKien());
		yKienTraoDoiImpl.setThoiGianGuiYKien(yKienTraoDoi.getThoiGianGuiYKien());
		yKienTraoDoiImpl.setTrangThai(yKienTraoDoi.getTrangThai());
		yKienTraoDoiImpl.setHoSoTTHCCongId(yKienTraoDoi.getHoSoTTHCCongId());
		yKienTraoDoiImpl.setNguoiNhanId(yKienTraoDoi.getNguoiNhanId());
		yKienTraoDoiImpl.setNguoiGuiId(yKienTraoDoi.getNguoiGuiId());
		yKienTraoDoiImpl.setChaiId(yKienTraoDoi.getChaiId());
		yKienTraoDoiImpl.setNoiLuuTruId(yKienTraoDoi.getNoiLuuTruId());
		yKienTraoDoiImpl.setLoai(yKienTraoDoi.getLoai());

		return yKienTraoDoiImpl;
	}

	/**
	 * Returns the y kien trao doi with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the y kien trao doi
	 * @return the y kien trao doi
	 * @throws com.liferay.portal.NoSuchModelException if a y kien trao doi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKienTraoDoi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the y kien trao doi with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException} if it could not be found.
	 *
	 * @param id the primary key of the y kien trao doi
	 * @return the y kien trao doi
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKienTraoDoi findByPrimaryKey(long id)
		throws NoSuchYKienTraoDoiException, SystemException {
		YKienTraoDoi yKienTraoDoi = fetchByPrimaryKey(id);

		if (yKienTraoDoi == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchYKienTraoDoiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return yKienTraoDoi;
	}

	/**
	 * Returns the y kien trao doi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the y kien trao doi
	 * @return the y kien trao doi, or <code>null</code> if a y kien trao doi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKienTraoDoi fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the y kien trao doi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the y kien trao doi
	 * @return the y kien trao doi, or <code>null</code> if a y kien trao doi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKienTraoDoi fetchByPrimaryKey(long id) throws SystemException {
		YKienTraoDoi yKienTraoDoi = (YKienTraoDoi)EntityCacheUtil.getResult(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
				YKienTraoDoiImpl.class, id);

		if (yKienTraoDoi == _nullYKienTraoDoi) {
			return null;
		}

		if (yKienTraoDoi == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				yKienTraoDoi = (YKienTraoDoi)session.get(YKienTraoDoiImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (yKienTraoDoi != null) {
					cacheResult(yKienTraoDoi);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(YKienTraoDoiModelImpl.ENTITY_CACHE_ENABLED,
						YKienTraoDoiImpl.class, id, _nullYKienTraoDoi);
				}

				closeSession(session);
			}
		}

		return yKienTraoDoi;
	}

	/**
	 * Returns all the y kien trao dois where loai = &#63;.
	 *
	 * @param loai the loai
	 * @return the matching y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKienTraoDoi> findByLoai(long loai) throws SystemException {
		return findByLoai(loai, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the y kien trao dois where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loai the loai
	 * @param start the lower bound of the range of y kien trao dois
	 * @param end the upper bound of the range of y kien trao dois (not inclusive)
	 * @return the range of matching y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKienTraoDoi> findByLoai(long loai, int start, int end)
		throws SystemException {
		return findByLoai(loai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the y kien trao dois where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loai the loai
	 * @param start the lower bound of the range of y kien trao dois
	 * @param end the upper bound of the range of y kien trao dois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKienTraoDoi> findByLoai(long loai, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAI;
			finderArgs = new Object[] { loai };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAI;
			finderArgs = new Object[] { loai, start, end, orderByComparator };
		}

		List<YKienTraoDoi> list = (List<YKienTraoDoi>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_YKIENTRAODOI_WHERE);

			query.append(_FINDER_COLUMN_LOAI_LOAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(YKienTraoDoiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loai);

				list = (List<YKienTraoDoi>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first y kien trao doi in the ordered set where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y kien trao doi
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKienTraoDoi findByLoai_First(long loai,
		OrderByComparator orderByComparator)
		throws NoSuchYKienTraoDoiException, SystemException {
		List<YKienTraoDoi> list = findByLoai(loai, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loai=");
			msg.append(loai);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchYKienTraoDoiException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last y kien trao doi in the ordered set where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y kien trao doi
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKienTraoDoi findByLoai_Last(long loai,
		OrderByComparator orderByComparator)
		throws NoSuchYKienTraoDoiException, SystemException {
		int count = countByLoai(loai);

		List<YKienTraoDoi> list = findByLoai(loai, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loai=");
			msg.append(loai);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchYKienTraoDoiException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the y kien trao dois before and after the current y kien trao doi in the ordered set where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current y kien trao doi
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next y kien trao doi
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKienTraoDoi[] findByLoai_PrevAndNext(long id, long loai,
		OrderByComparator orderByComparator)
		throws NoSuchYKienTraoDoiException, SystemException {
		YKienTraoDoi yKienTraoDoi = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			YKienTraoDoi[] array = new YKienTraoDoiImpl[3];

			array[0] = getByLoai_PrevAndNext(session, yKienTraoDoi, loai,
					orderByComparator, true);

			array[1] = yKienTraoDoi;

			array[2] = getByLoai_PrevAndNext(session, yKienTraoDoi, loai,
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

	protected YKienTraoDoi getByLoai_PrevAndNext(Session session,
		YKienTraoDoi yKienTraoDoi, long loai,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YKIENTRAODOI_WHERE);

		query.append(_FINDER_COLUMN_LOAI_LOAI_2);

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
			query.append(YKienTraoDoiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loai);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(yKienTraoDoi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YKienTraoDoi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the y kien trao dois where trangThai = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @return the matching y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKienTraoDoi> findByTrangThai(long trangThai)
		throws SystemException {
		return findByTrangThai(trangThai, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the y kien trao dois where trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of y kien trao dois
	 * @param end the upper bound of the range of y kien trao dois (not inclusive)
	 * @return the range of matching y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKienTraoDoi> findByTrangThai(long trangThai, int start, int end)
		throws SystemException {
		return findByTrangThai(trangThai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the y kien trao dois where trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of y kien trao dois
	 * @param end the upper bound of the range of y kien trao dois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKienTraoDoi> findByTrangThai(long trangThai, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { trangThai };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { trangThai, start, end, orderByComparator };
		}

		List<YKienTraoDoi> list = (List<YKienTraoDoi>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_YKIENTRAODOI_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(YKienTraoDoiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThai);

				list = (List<YKienTraoDoi>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first y kien trao doi in the ordered set where trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y kien trao doi
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKienTraoDoi findByTrangThai_First(long trangThai,
		OrderByComparator orderByComparator)
		throws NoSuchYKienTraoDoiException, SystemException {
		List<YKienTraoDoi> list = findByTrangThai(trangThai, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("trangThai=");
			msg.append(trangThai);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchYKienTraoDoiException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last y kien trao doi in the ordered set where trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y kien trao doi
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKienTraoDoi findByTrangThai_Last(long trangThai,
		OrderByComparator orderByComparator)
		throws NoSuchYKienTraoDoiException, SystemException {
		int count = countByTrangThai(trangThai);

		List<YKienTraoDoi> list = findByTrangThai(trangThai, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("trangThai=");
			msg.append(trangThai);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchYKienTraoDoiException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the y kien trao dois before and after the current y kien trao doi in the ordered set where trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current y kien trao doi
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next y kien trao doi
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKienTraoDoi[] findByTrangThai_PrevAndNext(long id, long trangThai,
		OrderByComparator orderByComparator)
		throws NoSuchYKienTraoDoiException, SystemException {
		YKienTraoDoi yKienTraoDoi = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			YKienTraoDoi[] array = new YKienTraoDoiImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, yKienTraoDoi,
					trangThai, orderByComparator, true);

			array[1] = yKienTraoDoi;

			array[2] = getByTrangThai_PrevAndNext(session, yKienTraoDoi,
					trangThai, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected YKienTraoDoi getByTrangThai_PrevAndNext(Session session,
		YKienTraoDoi yKienTraoDoi, long trangThai,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YKIENTRAODOI_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

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
			query.append(YKienTraoDoiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(trangThai);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(yKienTraoDoi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YKienTraoDoi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the y kien trao dois.
	 *
	 * @return the y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKienTraoDoi> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the y kien trao dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of y kien trao dois
	 * @param end the upper bound of the range of y kien trao dois (not inclusive)
	 * @return the range of y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKienTraoDoi> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the y kien trao dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of y kien trao dois
	 * @param end the upper bound of the range of y kien trao dois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKienTraoDoi> findAll(int start, int end,
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

		List<YKienTraoDoi> list = (List<YKienTraoDoi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_YKIENTRAODOI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YKIENTRAODOI.concat(YKienTraoDoiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<YKienTraoDoi>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<YKienTraoDoi>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the y kien trao dois where loai = &#63; from the database.
	 *
	 * @param loai the loai
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLoai(long loai) throws SystemException {
		for (YKienTraoDoi yKienTraoDoi : findByLoai(loai)) {
			remove(yKienTraoDoi);
		}
	}

	/**
	 * Removes all the y kien trao dois where trangThai = &#63; from the database.
	 *
	 * @param trangThai the trang thai
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(long trangThai) throws SystemException {
		for (YKienTraoDoi yKienTraoDoi : findByTrangThai(trangThai)) {
			remove(yKienTraoDoi);
		}
	}

	/**
	 * Removes all the y kien trao dois from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (YKienTraoDoi yKienTraoDoi : findAll()) {
			remove(yKienTraoDoi);
		}
	}

	/**
	 * Returns the number of y kien trao dois where loai = &#63;.
	 *
	 * @param loai the loai
	 * @return the number of matching y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLoai(long loai) throws SystemException {
		Object[] finderArgs = new Object[] { loai };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YKIENTRAODOI_WHERE);

			query.append(_FINDER_COLUMN_LOAI_LOAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loai);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOAI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of y kien trao dois where trangThai = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @return the number of matching y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(long trangThai) throws SystemException {
		Object[] finderArgs = new Object[] { trangThai };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YKIENTRAODOI_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThai);

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
	 * Returns the number of y kien trao dois.
	 *
	 * @return the number of y kien trao dois
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_YKIENTRAODOI);

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
	 * Initializes the y kien trao doi persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.hosohcc.model.YKienTraoDoi")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<YKienTraoDoi>> listenersList = new ArrayList<ModelListener<YKienTraoDoi>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<YKienTraoDoi>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(YKienTraoDoiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = FileDinhKemPersistence.class)
	protected FileDinhKemPersistence fileDinhKemPersistence;
	@BeanReference(type = HoSoAnhXaPersistence.class)
	protected HoSoAnhXaPersistence hoSoAnhXaPersistence;
	@BeanReference(type = HoSoTTHCCongPersistence.class)
	protected HoSoTTHCCongPersistence hoSoTTHCCongPersistence;
	@BeanReference(type = TrangThaiHoSoPersistence.class)
	protected TrangThaiHoSoPersistence trangThaiHoSoPersistence;
	@BeanReference(type = YKienTraoDoiPersistence.class)
	protected YKienTraoDoiPersistence yKienTraoDoiPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_YKIENTRAODOI = "SELECT yKienTraoDoi FROM YKienTraoDoi yKienTraoDoi";
	private static final String _SQL_SELECT_YKIENTRAODOI_WHERE = "SELECT yKienTraoDoi FROM YKienTraoDoi yKienTraoDoi WHERE ";
	private static final String _SQL_COUNT_YKIENTRAODOI = "SELECT COUNT(yKienTraoDoi) FROM YKienTraoDoi yKienTraoDoi";
	private static final String _SQL_COUNT_YKIENTRAODOI_WHERE = "SELECT COUNT(yKienTraoDoi) FROM YKienTraoDoi yKienTraoDoi WHERE ";
	private static final String _FINDER_COLUMN_LOAI_LOAI_2 = "yKienTraoDoi.loai = ?";
	private static final String _FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2 = "yKienTraoDoi.trangThai = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "yKienTraoDoi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YKienTraoDoi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No YKienTraoDoi exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(YKienTraoDoiPersistenceImpl.class);
	private static YKienTraoDoi _nullYKienTraoDoi = new YKienTraoDoiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<YKienTraoDoi> toCacheModel() {
				return _nullYKienTraoDoiCacheModel;
			}
		};

	private static CacheModel<YKienTraoDoi> _nullYKienTraoDoiCacheModel = new CacheModel<YKienTraoDoi>() {
			public YKienTraoDoi toEntityModel() {
				return _nullYKienTraoDoi;
			}
		};
}