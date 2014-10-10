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

import org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;
import org.oep.cmon.dao.hosohcc.model.HoSoAnhXa;
import org.oep.cmon.dao.hosohcc.model.impl.HoSoAnhXaImpl;
import org.oep.cmon.dao.hosohcc.model.impl.HoSoAnhXaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ho so anh xa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see HoSoAnhXaPersistence
 * @see HoSoAnhXaUtil
 * @generated
 */
public class HoSoAnhXaPersistenceImpl extends BasePersistenceImpl<HoSoAnhXa>
	implements HoSoAnhXaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HoSoAnhXaUtil} to access the ho so anh xa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HoSoAnhXaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_ID = new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, HoSoAnhXaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchById",
			new String[] { Long.class.getName() },
			HoSoAnhXaModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_HOSOTTHCCONGID = new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, HoSoAnhXaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByHoSoTTHCCongId",
			new String[] { Long.class.getName() },
			HoSoAnhXaModelImpl.HOSOTTHCCONGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOSOTTHCCONGID = new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHoSoTTHCCongId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAHOSO = new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, HoSoAnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMaHoSo",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAHOSO =
		new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, HoSoAnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMaHoSo",
			new String[] { String.class.getName() },
			HoSoAnhXaModelImpl.MAHOSO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAHOSO = new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaHoSo",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, HoSoAnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, HoSoAnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ho so anh xa in the entity cache if it is enabled.
	 *
	 * @param hoSoAnhXa the ho so anh xa
	 */
	public void cacheResult(HoSoAnhXa hoSoAnhXa) {
		EntityCacheUtil.putResult(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaImpl.class, hoSoAnhXa.getPrimaryKey(), hoSoAnhXa);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(hoSoAnhXa.getId()) }, hoSoAnhXa);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSOTTHCCONGID,
			new Object[] { Long.valueOf(hoSoAnhXa.getHoSoTTHCCongId()) },
			hoSoAnhXa);

		hoSoAnhXa.resetOriginalValues();
	}

	/**
	 * Caches the ho so anh xas in the entity cache if it is enabled.
	 *
	 * @param hoSoAnhXas the ho so anh xas
	 */
	public void cacheResult(List<HoSoAnhXa> hoSoAnhXas) {
		for (HoSoAnhXa hoSoAnhXa : hoSoAnhXas) {
			if (EntityCacheUtil.getResult(
						HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
						HoSoAnhXaImpl.class, hoSoAnhXa.getPrimaryKey()) == null) {
				cacheResult(hoSoAnhXa);
			}
			else {
				hoSoAnhXa.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ho so anh xas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HoSoAnhXaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HoSoAnhXaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ho so anh xa.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HoSoAnhXa hoSoAnhXa) {
		EntityCacheUtil.removeResult(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaImpl.class, hoSoAnhXa.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(hoSoAnhXa);
	}

	@Override
	public void clearCache(List<HoSoAnhXa> hoSoAnhXas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HoSoAnhXa hoSoAnhXa : hoSoAnhXas) {
			EntityCacheUtil.removeResult(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
				HoSoAnhXaImpl.class, hoSoAnhXa.getPrimaryKey());

			clearUniqueFindersCache(hoSoAnhXa);
		}
	}

	protected void clearUniqueFindersCache(HoSoAnhXa hoSoAnhXa) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(hoSoAnhXa.getId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HOSOTTHCCONGID,
			new Object[] { Long.valueOf(hoSoAnhXa.getHoSoTTHCCongId()) });
	}

	/**
	 * Creates a new ho so anh xa with the primary key. Does not add the ho so anh xa to the database.
	 *
	 * @param id the primary key for the new ho so anh xa
	 * @return the new ho so anh xa
	 */
	public HoSoAnhXa create(long id) {
		HoSoAnhXa hoSoAnhXa = new HoSoAnhXaImpl();

		hoSoAnhXa.setNew(true);
		hoSoAnhXa.setPrimaryKey(id);

		return hoSoAnhXa;
	}

	/**
	 * Removes the ho so anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ho so anh xa
	 * @return the ho so anh xa that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa remove(long id)
		throws NoSuchHoSoAnhXaException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the ho so anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ho so anh xa
	 * @return the ho so anh xa that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoAnhXa remove(Serializable primaryKey)
		throws NoSuchHoSoAnhXaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HoSoAnhXa hoSoAnhXa = (HoSoAnhXa)session.get(HoSoAnhXaImpl.class,
					primaryKey);

			if (hoSoAnhXa == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHoSoAnhXaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hoSoAnhXa);
		}
		catch (NoSuchHoSoAnhXaException nsee) {
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
	protected HoSoAnhXa removeImpl(HoSoAnhXa hoSoAnhXa)
		throws SystemException {
		hoSoAnhXa = toUnwrappedModel(hoSoAnhXa);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, hoSoAnhXa);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(hoSoAnhXa);

		return hoSoAnhXa;
	}

	@Override
	public HoSoAnhXa updateImpl(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa, boolean merge)
		throws SystemException {
		hoSoAnhXa = toUnwrappedModel(hoSoAnhXa);

		boolean isNew = hoSoAnhXa.isNew();

		HoSoAnhXaModelImpl hoSoAnhXaModelImpl = (HoSoAnhXaModelImpl)hoSoAnhXa;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, hoSoAnhXa, merge);

			hoSoAnhXa.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HoSoAnhXaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((hoSoAnhXaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAHOSO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoAnhXaModelImpl.getOriginalMaHoSo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAHOSO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAHOSO,
					args);

				args = new Object[] { hoSoAnhXaModelImpl.getMaHoSo() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAHOSO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAHOSO,
					args);
			}
		}

		EntityCacheUtil.putResult(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoAnhXaImpl.class, hoSoAnhXa.getPrimaryKey(), hoSoAnhXa);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
				new Object[] { Long.valueOf(hoSoAnhXa.getId()) }, hoSoAnhXa);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSOTTHCCONGID,
				new Object[] { Long.valueOf(hoSoAnhXa.getHoSoTTHCCongId()) },
				hoSoAnhXa);
		}
		else {
			if ((hoSoAnhXaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(hoSoAnhXaModelImpl.getOriginalId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
					new Object[] { Long.valueOf(hoSoAnhXa.getId()) }, hoSoAnhXa);
			}

			if ((hoSoAnhXaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_HOSOTTHCCONGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(hoSoAnhXaModelImpl.getOriginalHoSoTTHCCongId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HOSOTTHCCONGID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSOTTHCCONGID,
					new Object[] { Long.valueOf(hoSoAnhXa.getHoSoTTHCCongId()) },
					hoSoAnhXa);
			}
		}

		return hoSoAnhXa;
	}

	protected HoSoAnhXa toUnwrappedModel(HoSoAnhXa hoSoAnhXa) {
		if (hoSoAnhXa instanceof HoSoAnhXaImpl) {
			return hoSoAnhXa;
		}

		HoSoAnhXaImpl hoSoAnhXaImpl = new HoSoAnhXaImpl();

		hoSoAnhXaImpl.setNew(hoSoAnhXa.isNew());
		hoSoAnhXaImpl.setPrimaryKey(hoSoAnhXa.getPrimaryKey());

		hoSoAnhXaImpl.setId(hoSoAnhXa.getId());
		hoSoAnhXaImpl.setHoSoTTHCCongId(hoSoAnhXa.getHoSoTTHCCongId());
		hoSoAnhXaImpl.setMaHoSo(hoSoAnhXa.getMaHoSo());
		hoSoAnhXaImpl.setTrangThai(hoSoAnhXa.getTrangThai());
		hoSoAnhXaImpl.setNgaySua(hoSoAnhXa.getNgaySua());
		hoSoAnhXaImpl.setNgayTao(hoSoAnhXa.getNgayTao());

		return hoSoAnhXaImpl;
	}

	/**
	 * Returns the ho so anh xa with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so anh xa
	 * @return the ho so anh xa
	 * @throws com.liferay.portal.NoSuchModelException if a ho so anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoAnhXa findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so anh xa with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException} if it could not be found.
	 *
	 * @param id the primary key of the ho so anh xa
	 * @return the ho so anh xa
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa findByPrimaryKey(long id)
		throws NoSuchHoSoAnhXaException, SystemException {
		HoSoAnhXa hoSoAnhXa = fetchByPrimaryKey(id);

		if (hoSoAnhXa == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchHoSoAnhXaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return hoSoAnhXa;
	}

	/**
	 * Returns the ho so anh xa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so anh xa
	 * @return the ho so anh xa, or <code>null</code> if a ho so anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoAnhXa fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so anh xa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ho so anh xa
	 * @return the ho so anh xa, or <code>null</code> if a ho so anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa fetchByPrimaryKey(long id) throws SystemException {
		HoSoAnhXa hoSoAnhXa = (HoSoAnhXa)EntityCacheUtil.getResult(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
				HoSoAnhXaImpl.class, id);

		if (hoSoAnhXa == _nullHoSoAnhXa) {
			return null;
		}

		if (hoSoAnhXa == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				hoSoAnhXa = (HoSoAnhXa)session.get(HoSoAnhXaImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (hoSoAnhXa != null) {
					cacheResult(hoSoAnhXa);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HoSoAnhXaModelImpl.ENTITY_CACHE_ENABLED,
						HoSoAnhXaImpl.class, id, _nullHoSoAnhXa);
				}

				closeSession(session);
			}
		}

		return hoSoAnhXa;
	}

	/**
	 * Returns the ho so anh xa where id = &#63; or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException} if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching ho so anh xa
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa findById(long id)
		throws NoSuchHoSoAnhXaException, SystemException {
		HoSoAnhXa hoSoAnhXa = fetchById(id);

		if (hoSoAnhXa == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchHoSoAnhXaException(msg.toString());
		}

		return hoSoAnhXa;
	}

	/**
	 * Returns the ho so anh xa where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa fetchById(long id) throws SystemException {
		return fetchById(id, true);
	}

	/**
	 * Returns the ho so anh xa where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa fetchById(long id, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_HOSOANHXA_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			query.append(HoSoAnhXaModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				List<HoSoAnhXa> list = q.list();

				result = list;

				HoSoAnhXa hoSoAnhXa = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs, list);
				}
				else {
					hoSoAnhXa = list.get(0);

					cacheResult(hoSoAnhXa);

					if ((hoSoAnhXa.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
							finderArgs, hoSoAnhXa);
					}
				}

				return hoSoAnhXa;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (HoSoAnhXa)result;
			}
		}
	}

	/**
	 * Returns the ho so anh xa where hoSoTTHCCongId = &#63; or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException} if it could not be found.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @return the matching ho so anh xa
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa findByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws NoSuchHoSoAnhXaException, SystemException {
		HoSoAnhXa hoSoAnhXa = fetchByHoSoTTHCCongId(hoSoTTHCCongId);

		if (hoSoAnhXa == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoTTHCCongId=");
			msg.append(hoSoTTHCCongId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchHoSoAnhXaException(msg.toString());
		}

		return hoSoAnhXa;
	}

	/**
	 * Returns the ho so anh xa where hoSoTTHCCongId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa fetchByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws SystemException {
		return fetchByHoSoTTHCCongId(hoSoTTHCCongId, true);
	}

	/**
	 * Returns the ho so anh xa where hoSoTTHCCongId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa fetchByHoSoTTHCCongId(long hoSoTTHCCongId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { hoSoTTHCCongId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_HOSOTTHCCONGID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_HOSOANHXA_WHERE);

			query.append(_FINDER_COLUMN_HOSOTTHCCONGID_HOSOTTHCCONGID_2);

			query.append(HoSoAnhXaModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoTTHCCongId);

				List<HoSoAnhXa> list = q.list();

				result = list;

				HoSoAnhXa hoSoAnhXa = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSOTTHCCONGID,
						finderArgs, list);
				}
				else {
					hoSoAnhXa = list.get(0);

					cacheResult(hoSoAnhXa);

					if ((hoSoAnhXa.getHoSoTTHCCongId() != hoSoTTHCCongId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSOTTHCCONGID,
							finderArgs, hoSoAnhXa);
					}
				}

				return hoSoAnhXa;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HOSOTTHCCONGID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (HoSoAnhXa)result;
			}
		}
	}

	/**
	 * Returns all the ho so anh xas where maHoSo = &#63;.
	 *
	 * @param maHoSo the ma ho so
	 * @return the matching ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoAnhXa> findByMaHoSo(String maHoSo)
		throws SystemException {
		return findByMaHoSo(maHoSo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so anh xas where maHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maHoSo the ma ho so
	 * @param start the lower bound of the range of ho so anh xas
	 * @param end the upper bound of the range of ho so anh xas (not inclusive)
	 * @return the range of matching ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoAnhXa> findByMaHoSo(String maHoSo, int start, int end)
		throws SystemException {
		return findByMaHoSo(maHoSo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so anh xas where maHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maHoSo the ma ho so
	 * @param start the lower bound of the range of ho so anh xas
	 * @param end the upper bound of the range of ho so anh xas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoAnhXa> findByMaHoSo(String maHoSo, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAHOSO;
			finderArgs = new Object[] { maHoSo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAHOSO;
			finderArgs = new Object[] { maHoSo, start, end, orderByComparator };
		}

		List<HoSoAnhXa> list = (List<HoSoAnhXa>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOANHXA_WHERE);

			if (maHoSo == null) {
				query.append(_FINDER_COLUMN_MAHOSO_MAHOSO_1);
			}
			else {
				if (maHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MAHOSO_MAHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_MAHOSO_MAHOSO_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoAnhXaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maHoSo != null) {
					qPos.add(maHoSo);
				}

				list = (List<HoSoAnhXa>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first ho so anh xa in the ordered set where maHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maHoSo the ma ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so anh xa
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa findByMaHoSo_First(String maHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoAnhXaException, SystemException {
		List<HoSoAnhXa> list = findByMaHoSo(maHoSo, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maHoSo=");
			msg.append(maHoSo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so anh xa in the ordered set where maHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maHoSo the ma ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so anh xa
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa findByMaHoSo_Last(String maHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoAnhXaException, SystemException {
		int count = countByMaHoSo(maHoSo);

		List<HoSoAnhXa> list = findByMaHoSo(maHoSo, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maHoSo=");
			msg.append(maHoSo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so anh xas before and after the current ho so anh xa in the ordered set where maHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so anh xa
	 * @param maHoSo the ma ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so anh xa
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoAnhXa[] findByMaHoSo_PrevAndNext(long id, String maHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoAnhXaException, SystemException {
		HoSoAnhXa hoSoAnhXa = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoAnhXa[] array = new HoSoAnhXaImpl[3];

			array[0] = getByMaHoSo_PrevAndNext(session, hoSoAnhXa, maHoSo,
					orderByComparator, true);

			array[1] = hoSoAnhXa;

			array[2] = getByMaHoSo_PrevAndNext(session, hoSoAnhXa, maHoSo,
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

	protected HoSoAnhXa getByMaHoSo_PrevAndNext(Session session,
		HoSoAnhXa hoSoAnhXa, String maHoSo,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOANHXA_WHERE);

		if (maHoSo == null) {
			query.append(_FINDER_COLUMN_MAHOSO_MAHOSO_1);
		}
		else {
			if (maHoSo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MAHOSO_MAHOSO_3);
			}
			else {
				query.append(_FINDER_COLUMN_MAHOSO_MAHOSO_2);
			}
		}

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
			query.append(HoSoAnhXaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (maHoSo != null) {
			qPos.add(maHoSo);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoAnhXa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoAnhXa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so anh xas.
	 *
	 * @return the ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoAnhXa> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so anh xas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so anh xas
	 * @param end the upper bound of the range of ho so anh xas (not inclusive)
	 * @return the range of ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoAnhXa> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so anh xas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so anh xas
	 * @param end the upper bound of the range of ho so anh xas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoAnhXa> findAll(int start, int end,
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

		List<HoSoAnhXa> list = (List<HoSoAnhXa>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HOSOANHXA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOSOANHXA.concat(HoSoAnhXaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HoSoAnhXa>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HoSoAnhXa>)QueryUtil.list(q, getDialect(),
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
	 * Removes the ho so anh xa where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeById(long id)
		throws NoSuchHoSoAnhXaException, SystemException {
		HoSoAnhXa hoSoAnhXa = findById(id);

		remove(hoSoAnhXa);
	}

	/**
	 * Removes the ho so anh xa where hoSoTTHCCongId = &#63; from the database.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws NoSuchHoSoAnhXaException, SystemException {
		HoSoAnhXa hoSoAnhXa = findByHoSoTTHCCongId(hoSoTTHCCongId);

		remove(hoSoAnhXa);
	}

	/**
	 * Removes all the ho so anh xas where maHoSo = &#63; from the database.
	 *
	 * @param maHoSo the ma ho so
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMaHoSo(String maHoSo) throws SystemException {
		for (HoSoAnhXa hoSoAnhXa : findByMaHoSo(maHoSo)) {
			remove(hoSoAnhXa);
		}
	}

	/**
	 * Removes all the ho so anh xas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HoSoAnhXa hoSoAnhXa : findAll()) {
			remove(hoSoAnhXa);
		}
	}

	/**
	 * Returns the number of ho so anh xas where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public int countById(long id) throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOANHXA_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so anh xas where hoSoTTHCCongId = &#63;.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @return the number of matching ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws SystemException {
		Object[] finderArgs = new Object[] { hoSoTTHCCongId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOANHXA_WHERE);

			query.append(_FINDER_COLUMN_HOSOTTHCCONGID_HOSOTTHCCONGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoTTHCCongId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so anh xas where maHoSo = &#63;.
	 *
	 * @param maHoSo the ma ho so
	 * @return the number of matching ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMaHoSo(String maHoSo) throws SystemException {
		Object[] finderArgs = new Object[] { maHoSo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MAHOSO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOANHXA_WHERE);

			if (maHoSo == null) {
				query.append(_FINDER_COLUMN_MAHOSO_MAHOSO_1);
			}
			else {
				if (maHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MAHOSO_MAHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_MAHOSO_MAHOSO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maHoSo != null) {
					qPos.add(maHoSo);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAHOSO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so anh xas.
	 *
	 * @return the number of ho so anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOSOANHXA);

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
	 * Initializes the ho so anh xa persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.hosohcc.model.HoSoAnhXa")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HoSoAnhXa>> listenersList = new ArrayList<ModelListener<HoSoAnhXa>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HoSoAnhXa>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HoSoAnhXaImpl.class.getName());
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
	private static final String _SQL_SELECT_HOSOANHXA = "SELECT hoSoAnhXa FROM HoSoAnhXa hoSoAnhXa";
	private static final String _SQL_SELECT_HOSOANHXA_WHERE = "SELECT hoSoAnhXa FROM HoSoAnhXa hoSoAnhXa WHERE ";
	private static final String _SQL_COUNT_HOSOANHXA = "SELECT COUNT(hoSoAnhXa) FROM HoSoAnhXa hoSoAnhXa";
	private static final String _SQL_COUNT_HOSOANHXA_WHERE = "SELECT COUNT(hoSoAnhXa) FROM HoSoAnhXa hoSoAnhXa WHERE ";
	private static final String _FINDER_COLUMN_ID_ID_2 = "hoSoAnhXa.id = ?";
	private static final String _FINDER_COLUMN_HOSOTTHCCONGID_HOSOTTHCCONGID_2 = "hoSoAnhXa.hoSoTTHCCongId = ?";
	private static final String _FINDER_COLUMN_MAHOSO_MAHOSO_1 = "hoSoAnhXa.maHoSo IS NULL";
	private static final String _FINDER_COLUMN_MAHOSO_MAHOSO_2 = "hoSoAnhXa.maHoSo = ?";
	private static final String _FINDER_COLUMN_MAHOSO_MAHOSO_3 = "(hoSoAnhXa.maHoSo IS NULL OR hoSoAnhXa.maHoSo = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hoSoAnhXa.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HoSoAnhXa exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HoSoAnhXa exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HoSoAnhXaPersistenceImpl.class);
	private static HoSoAnhXa _nullHoSoAnhXa = new HoSoAnhXaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HoSoAnhXa> toCacheModel() {
				return _nullHoSoAnhXaCacheModel;
			}
		};

	private static CacheModel<HoSoAnhXa> _nullHoSoAnhXaCacheModel = new CacheModel<HoSoAnhXa>() {
			public HoSoAnhXa toEntityModel() {
				return _nullHoSoAnhXa;
			}
		};
}