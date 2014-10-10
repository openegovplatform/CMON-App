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

package org.oep.cmon.dao.tlct.service.persistence;

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

import org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException;
import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem;
import org.oep.cmon.dao.tlct.model.impl.LichSuGiayToDinhKemImpl;
import org.oep.cmon.dao.tlct.model.impl.LichSuGiayToDinhKemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lich su giay to dinh kem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see LichSuGiayToDinhKemPersistence
 * @see LichSuGiayToDinhKemUtil
 * @generated
 */
public class LichSuGiayToDinhKemPersistenceImpl extends BasePersistenceImpl<LichSuGiayToDinhKem>
	implements LichSuGiayToDinhKemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LichSuGiayToDinhKemUtil} to access the lich su giay to dinh kem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LichSuGiayToDinhKemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYGIAYTODINHKEMHOSOID =
		new FinderPath(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemModelImpl.FINDER_CACHE_ENABLED,
			LichSuGiayToDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByByGiayToDinhKemHoSoId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGIAYTODINHKEMHOSOID =
		new FinderPath(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemModelImpl.FINDER_CACHE_ENABLED,
			LichSuGiayToDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByByGiayToDinhKemHoSoId",
			new String[] { Long.class.getName() },
			LichSuGiayToDinhKemModelImpl.GIAYTODINHKEMHOSOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYGIAYTODINHKEMHOSOID = new FinderPath(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByByGiayToDinhKemHoSoId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYNOILUUTRUTAILIEUID =
		new FinderPath(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemModelImpl.FINDER_CACHE_ENABLED,
			LichSuGiayToDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByByNoiLuuTruTaiLieuId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNOILUUTRUTAILIEUID =
		new FinderPath(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemModelImpl.FINDER_CACHE_ENABLED,
			LichSuGiayToDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByByNoiLuuTruTaiLieuId",
			new String[] { Long.class.getName() },
			LichSuGiayToDinhKemModelImpl.NOILUUTRUTAILIEUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYNOILUUTRUTAILIEUID = new FinderPath(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByByNoiLuuTruTaiLieuId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemModelImpl.FINDER_CACHE_ENABLED,
			LichSuGiayToDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemModelImpl.FINDER_CACHE_ENABLED,
			LichSuGiayToDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the lich su giay to dinh kem in the entity cache if it is enabled.
	 *
	 * @param lichSuGiayToDinhKem the lich su giay to dinh kem
	 */
	public void cacheResult(LichSuGiayToDinhKem lichSuGiayToDinhKem) {
		EntityCacheUtil.putResult(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemImpl.class, lichSuGiayToDinhKem.getPrimaryKey(),
			lichSuGiayToDinhKem);

		lichSuGiayToDinhKem.resetOriginalValues();
	}

	/**
	 * Caches the lich su giay to dinh kems in the entity cache if it is enabled.
	 *
	 * @param lichSuGiayToDinhKems the lich su giay to dinh kems
	 */
	public void cacheResult(List<LichSuGiayToDinhKem> lichSuGiayToDinhKems) {
		for (LichSuGiayToDinhKem lichSuGiayToDinhKem : lichSuGiayToDinhKems) {
			if (EntityCacheUtil.getResult(
						LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
						LichSuGiayToDinhKemImpl.class,
						lichSuGiayToDinhKem.getPrimaryKey()) == null) {
				cacheResult(lichSuGiayToDinhKem);
			}
			else {
				lichSuGiayToDinhKem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lich su giay to dinh kems.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LichSuGiayToDinhKemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LichSuGiayToDinhKemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lich su giay to dinh kem.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LichSuGiayToDinhKem lichSuGiayToDinhKem) {
		EntityCacheUtil.removeResult(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemImpl.class, lichSuGiayToDinhKem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LichSuGiayToDinhKem> lichSuGiayToDinhKems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LichSuGiayToDinhKem lichSuGiayToDinhKem : lichSuGiayToDinhKems) {
			EntityCacheUtil.removeResult(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
				LichSuGiayToDinhKemImpl.class,
				lichSuGiayToDinhKem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lich su giay to dinh kem with the primary key. Does not add the lich su giay to dinh kem to the database.
	 *
	 * @param id the primary key for the new lich su giay to dinh kem
	 * @return the new lich su giay to dinh kem
	 */
	public LichSuGiayToDinhKem create(long id) {
		LichSuGiayToDinhKem lichSuGiayToDinhKem = new LichSuGiayToDinhKemImpl();

		lichSuGiayToDinhKem.setNew(true);
		lichSuGiayToDinhKem.setPrimaryKey(id);

		return lichSuGiayToDinhKem;
	}

	/**
	 * Removes the lich su giay to dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the lich su giay to dinh kem
	 * @return the lich su giay to dinh kem that was removed
	 * @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a lich su giay to dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LichSuGiayToDinhKem remove(long id)
		throws NoSuchLichSuGiayToDinhKemException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the lich su giay to dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lich su giay to dinh kem
	 * @return the lich su giay to dinh kem that was removed
	 * @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a lich su giay to dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LichSuGiayToDinhKem remove(Serializable primaryKey)
		throws NoSuchLichSuGiayToDinhKemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LichSuGiayToDinhKem lichSuGiayToDinhKem = (LichSuGiayToDinhKem)session.get(LichSuGiayToDinhKemImpl.class,
					primaryKey);

			if (lichSuGiayToDinhKem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLichSuGiayToDinhKemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lichSuGiayToDinhKem);
		}
		catch (NoSuchLichSuGiayToDinhKemException nsee) {
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
	protected LichSuGiayToDinhKem removeImpl(
		LichSuGiayToDinhKem lichSuGiayToDinhKem) throws SystemException {
		lichSuGiayToDinhKem = toUnwrappedModel(lichSuGiayToDinhKem);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, lichSuGiayToDinhKem);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(lichSuGiayToDinhKem);

		return lichSuGiayToDinhKem;
	}

	@Override
	public LichSuGiayToDinhKem updateImpl(
		org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem lichSuGiayToDinhKem,
		boolean merge) throws SystemException {
		lichSuGiayToDinhKem = toUnwrappedModel(lichSuGiayToDinhKem);

		boolean isNew = lichSuGiayToDinhKem.isNew();

		LichSuGiayToDinhKemModelImpl lichSuGiayToDinhKemModelImpl = (LichSuGiayToDinhKemModelImpl)lichSuGiayToDinhKem;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lichSuGiayToDinhKem, merge);

			lichSuGiayToDinhKem.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LichSuGiayToDinhKemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lichSuGiayToDinhKemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGIAYTODINHKEMHOSOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(lichSuGiayToDinhKemModelImpl.getOriginalGiayToDinhKemHoSoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYGIAYTODINHKEMHOSOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGIAYTODINHKEMHOSOID,
					args);

				args = new Object[] {
						Long.valueOf(lichSuGiayToDinhKemModelImpl.getGiayToDinhKemHoSoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYGIAYTODINHKEMHOSOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGIAYTODINHKEMHOSOID,
					args);
			}

			if ((lichSuGiayToDinhKemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNOILUUTRUTAILIEUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(lichSuGiayToDinhKemModelImpl.getOriginalNoiLuuTruTaiLieuId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYNOILUUTRUTAILIEUID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNOILUUTRUTAILIEUID,
					args);

				args = new Object[] {
						Long.valueOf(lichSuGiayToDinhKemModelImpl.getNoiLuuTruTaiLieuId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYNOILUUTRUTAILIEUID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNOILUUTRUTAILIEUID,
					args);
			}
		}

		EntityCacheUtil.putResult(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			LichSuGiayToDinhKemImpl.class, lichSuGiayToDinhKem.getPrimaryKey(),
			lichSuGiayToDinhKem);

		return lichSuGiayToDinhKem;
	}

	protected LichSuGiayToDinhKem toUnwrappedModel(
		LichSuGiayToDinhKem lichSuGiayToDinhKem) {
		if (lichSuGiayToDinhKem instanceof LichSuGiayToDinhKemImpl) {
			return lichSuGiayToDinhKem;
		}

		LichSuGiayToDinhKemImpl lichSuGiayToDinhKemImpl = new LichSuGiayToDinhKemImpl();

		lichSuGiayToDinhKemImpl.setNew(lichSuGiayToDinhKem.isNew());
		lichSuGiayToDinhKemImpl.setPrimaryKey(lichSuGiayToDinhKem.getPrimaryKey());

		lichSuGiayToDinhKemImpl.setId(lichSuGiayToDinhKem.getId());
		lichSuGiayToDinhKemImpl.setGiayToDinhKemHoSoId(lichSuGiayToDinhKem.getGiayToDinhKemHoSoId());
		lichSuGiayToDinhKemImpl.setHanhDong(lichSuGiayToDinhKem.getHanhDong());
		lichSuGiayToDinhKemImpl.setNguoiTao(lichSuGiayToDinhKem.getNguoiTao());
		lichSuGiayToDinhKemImpl.setNoiLuuTruTaiLieuId(lichSuGiayToDinhKem.getNoiLuuTruTaiLieuId());
		lichSuGiayToDinhKemImpl.setNgayTao(lichSuGiayToDinhKem.getNgayTao());
		lichSuGiayToDinhKemImpl.setTenTaiLieu(lichSuGiayToDinhKem.getTenTaiLieu());

		return lichSuGiayToDinhKemImpl;
	}

	/**
	 * Returns the lich su giay to dinh kem with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lich su giay to dinh kem
	 * @return the lich su giay to dinh kem
	 * @throws com.liferay.portal.NoSuchModelException if a lich su giay to dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LichSuGiayToDinhKem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the lich su giay to dinh kem with the primary key or throws a {@link org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException} if it could not be found.
	 *
	 * @param id the primary key of the lich su giay to dinh kem
	 * @return the lich su giay to dinh kem
	 * @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a lich su giay to dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LichSuGiayToDinhKem findByPrimaryKey(long id)
		throws NoSuchLichSuGiayToDinhKemException, SystemException {
		LichSuGiayToDinhKem lichSuGiayToDinhKem = fetchByPrimaryKey(id);

		if (lichSuGiayToDinhKem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchLichSuGiayToDinhKemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return lichSuGiayToDinhKem;
	}

	/**
	 * Returns the lich su giay to dinh kem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lich su giay to dinh kem
	 * @return the lich su giay to dinh kem, or <code>null</code> if a lich su giay to dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LichSuGiayToDinhKem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the lich su giay to dinh kem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the lich su giay to dinh kem
	 * @return the lich su giay to dinh kem, or <code>null</code> if a lich su giay to dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LichSuGiayToDinhKem fetchByPrimaryKey(long id)
		throws SystemException {
		LichSuGiayToDinhKem lichSuGiayToDinhKem = (LichSuGiayToDinhKem)EntityCacheUtil.getResult(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
				LichSuGiayToDinhKemImpl.class, id);

		if (lichSuGiayToDinhKem == _nullLichSuGiayToDinhKem) {
			return null;
		}

		if (lichSuGiayToDinhKem == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				lichSuGiayToDinhKem = (LichSuGiayToDinhKem)session.get(LichSuGiayToDinhKemImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (lichSuGiayToDinhKem != null) {
					cacheResult(lichSuGiayToDinhKem);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LichSuGiayToDinhKemModelImpl.ENTITY_CACHE_ENABLED,
						LichSuGiayToDinhKemImpl.class, id,
						_nullLichSuGiayToDinhKem);
				}

				closeSession(session);
			}
		}

		return lichSuGiayToDinhKem;
	}

	/**
	 * Returns all the lich su giay to dinh kems where giayToDinhKemHoSoId = &#63;.
	 *
	 * @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	 * @return the matching lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<LichSuGiayToDinhKem> findByByGiayToDinhKemHoSoId(
		Long giayToDinhKemHoSoId) throws SystemException {
		return findByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su giay to dinh kems where giayToDinhKemHoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	 * @param start the lower bound of the range of lich su giay to dinh kems
	 * @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	 * @return the range of matching lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<LichSuGiayToDinhKem> findByByGiayToDinhKemHoSoId(
		Long giayToDinhKemHoSoId, int start, int end) throws SystemException {
		return findByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su giay to dinh kems where giayToDinhKemHoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	 * @param start the lower bound of the range of lich su giay to dinh kems
	 * @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<LichSuGiayToDinhKem> findByByGiayToDinhKemHoSoId(
		Long giayToDinhKemHoSoId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGIAYTODINHKEMHOSOID;
			finderArgs = new Object[] { giayToDinhKemHoSoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYGIAYTODINHKEMHOSOID;
			finderArgs = new Object[] {
					giayToDinhKemHoSoId,
					
					start, end, orderByComparator
				};
		}

		List<LichSuGiayToDinhKem> list = (List<LichSuGiayToDinhKem>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_LICHSUGIAYTODINHKEM_WHERE);

			query.append(_FINDER_COLUMN_BYGIAYTODINHKEMHOSOID_GIAYTODINHKEMHOSOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LichSuGiayToDinhKemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(giayToDinhKemHoSoId.longValue());

				list = (List<LichSuGiayToDinhKem>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first lich su giay to dinh kem in the ordered set where giayToDinhKemHoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su giay to dinh kem
	 * @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a matching lich su giay to dinh kem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LichSuGiayToDinhKem findByByGiayToDinhKemHoSoId_First(
		Long giayToDinhKemHoSoId, OrderByComparator orderByComparator)
		throws NoSuchLichSuGiayToDinhKemException, SystemException {
		List<LichSuGiayToDinhKem> list = findByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("giayToDinhKemHoSoId=");
			msg.append(giayToDinhKemHoSoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLichSuGiayToDinhKemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last lich su giay to dinh kem in the ordered set where giayToDinhKemHoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su giay to dinh kem
	 * @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a matching lich su giay to dinh kem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LichSuGiayToDinhKem findByByGiayToDinhKemHoSoId_Last(
		Long giayToDinhKemHoSoId, OrderByComparator orderByComparator)
		throws NoSuchLichSuGiayToDinhKemException, SystemException {
		int count = countByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId);

		List<LichSuGiayToDinhKem> list = findByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("giayToDinhKemHoSoId=");
			msg.append(giayToDinhKemHoSoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLichSuGiayToDinhKemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the lich su giay to dinh kems before and after the current lich su giay to dinh kem in the ordered set where giayToDinhKemHoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current lich su giay to dinh kem
	 * @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su giay to dinh kem
	 * @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a lich su giay to dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LichSuGiayToDinhKem[] findByByGiayToDinhKemHoSoId_PrevAndNext(
		long id, Long giayToDinhKemHoSoId, OrderByComparator orderByComparator)
		throws NoSuchLichSuGiayToDinhKemException, SystemException {
		LichSuGiayToDinhKem lichSuGiayToDinhKem = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LichSuGiayToDinhKem[] array = new LichSuGiayToDinhKemImpl[3];

			array[0] = getByByGiayToDinhKemHoSoId_PrevAndNext(session,
					lichSuGiayToDinhKem, giayToDinhKemHoSoId,
					orderByComparator, true);

			array[1] = lichSuGiayToDinhKem;

			array[2] = getByByGiayToDinhKemHoSoId_PrevAndNext(session,
					lichSuGiayToDinhKem, giayToDinhKemHoSoId,
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

	protected LichSuGiayToDinhKem getByByGiayToDinhKemHoSoId_PrevAndNext(
		Session session, LichSuGiayToDinhKem lichSuGiayToDinhKem,
		Long giayToDinhKemHoSoId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICHSUGIAYTODINHKEM_WHERE);

		query.append(_FINDER_COLUMN_BYGIAYTODINHKEMHOSOID_GIAYTODINHKEMHOSOID_2);

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
			query.append(LichSuGiayToDinhKemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(giayToDinhKemHoSoId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lichSuGiayToDinhKem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LichSuGiayToDinhKem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63;.
	 *
	 * @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	 * @return the matching lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<LichSuGiayToDinhKem> findByByNoiLuuTruTaiLieuId(
		long noiLuuTruTaiLieuId) throws SystemException {
		return findByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	 * @param start the lower bound of the range of lich su giay to dinh kems
	 * @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	 * @return the range of matching lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<LichSuGiayToDinhKem> findByByNoiLuuTruTaiLieuId(
		long noiLuuTruTaiLieuId, int start, int end) throws SystemException {
		return findByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	 * @param start the lower bound of the range of lich su giay to dinh kems
	 * @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<LichSuGiayToDinhKem> findByByNoiLuuTruTaiLieuId(
		long noiLuuTruTaiLieuId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNOILUUTRUTAILIEUID;
			finderArgs = new Object[] { noiLuuTruTaiLieuId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYNOILUUTRUTAILIEUID;
			finderArgs = new Object[] {
					noiLuuTruTaiLieuId,
					
					start, end, orderByComparator
				};
		}

		List<LichSuGiayToDinhKem> list = (List<LichSuGiayToDinhKem>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_LICHSUGIAYTODINHKEM_WHERE);

			query.append(_FINDER_COLUMN_BYNOILUUTRUTAILIEUID_NOILUUTRUTAILIEUID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LichSuGiayToDinhKemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(noiLuuTruTaiLieuId);

				list = (List<LichSuGiayToDinhKem>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first lich su giay to dinh kem in the ordered set where noiLuuTruTaiLieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su giay to dinh kem
	 * @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a matching lich su giay to dinh kem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LichSuGiayToDinhKem findByByNoiLuuTruTaiLieuId_First(
		long noiLuuTruTaiLieuId, OrderByComparator orderByComparator)
		throws NoSuchLichSuGiayToDinhKemException, SystemException {
		List<LichSuGiayToDinhKem> list = findByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("noiLuuTruTaiLieuId=");
			msg.append(noiLuuTruTaiLieuId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLichSuGiayToDinhKemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last lich su giay to dinh kem in the ordered set where noiLuuTruTaiLieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su giay to dinh kem
	 * @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a matching lich su giay to dinh kem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LichSuGiayToDinhKem findByByNoiLuuTruTaiLieuId_Last(
		long noiLuuTruTaiLieuId, OrderByComparator orderByComparator)
		throws NoSuchLichSuGiayToDinhKemException, SystemException {
		int count = countByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId);

		List<LichSuGiayToDinhKem> list = findByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("noiLuuTruTaiLieuId=");
			msg.append(noiLuuTruTaiLieuId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLichSuGiayToDinhKemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the lich su giay to dinh kems before and after the current lich su giay to dinh kem in the ordered set where noiLuuTruTaiLieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current lich su giay to dinh kem
	 * @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su giay to dinh kem
	 * @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a lich su giay to dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LichSuGiayToDinhKem[] findByByNoiLuuTruTaiLieuId_PrevAndNext(
		long id, long noiLuuTruTaiLieuId, OrderByComparator orderByComparator)
		throws NoSuchLichSuGiayToDinhKemException, SystemException {
		LichSuGiayToDinhKem lichSuGiayToDinhKem = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LichSuGiayToDinhKem[] array = new LichSuGiayToDinhKemImpl[3];

			array[0] = getByByNoiLuuTruTaiLieuId_PrevAndNext(session,
					lichSuGiayToDinhKem, noiLuuTruTaiLieuId, orderByComparator,
					true);

			array[1] = lichSuGiayToDinhKem;

			array[2] = getByByNoiLuuTruTaiLieuId_PrevAndNext(session,
					lichSuGiayToDinhKem, noiLuuTruTaiLieuId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LichSuGiayToDinhKem getByByNoiLuuTruTaiLieuId_PrevAndNext(
		Session session, LichSuGiayToDinhKem lichSuGiayToDinhKem,
		long noiLuuTruTaiLieuId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICHSUGIAYTODINHKEM_WHERE);

		query.append(_FINDER_COLUMN_BYNOILUUTRUTAILIEUID_NOILUUTRUTAILIEUID_2);

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
			query.append(LichSuGiayToDinhKemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(noiLuuTruTaiLieuId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lichSuGiayToDinhKem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LichSuGiayToDinhKem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the lich su giay to dinh kems.
	 *
	 * @return the lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<LichSuGiayToDinhKem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su giay to dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su giay to dinh kems
	 * @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	 * @return the range of lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<LichSuGiayToDinhKem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su giay to dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su giay to dinh kems
	 * @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<LichSuGiayToDinhKem> findAll(int start, int end,
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

		List<LichSuGiayToDinhKem> list = (List<LichSuGiayToDinhKem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LICHSUGIAYTODINHKEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LICHSUGIAYTODINHKEM.concat(LichSuGiayToDinhKemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LichSuGiayToDinhKem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LichSuGiayToDinhKem>)QueryUtil.list(q,
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
	 * Removes all the lich su giay to dinh kems where giayToDinhKemHoSoId = &#63; from the database.
	 *
	 * @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByGiayToDinhKemHoSoId(Long giayToDinhKemHoSoId)
		throws SystemException {
		for (LichSuGiayToDinhKem lichSuGiayToDinhKem : findByByGiayToDinhKemHoSoId(
				giayToDinhKemHoSoId)) {
			remove(lichSuGiayToDinhKem);
		}
	}

	/**
	 * Removes all the lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63; from the database.
	 *
	 * @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByNoiLuuTruTaiLieuId(long noiLuuTruTaiLieuId)
		throws SystemException {
		for (LichSuGiayToDinhKem lichSuGiayToDinhKem : findByByNoiLuuTruTaiLieuId(
				noiLuuTruTaiLieuId)) {
			remove(lichSuGiayToDinhKem);
		}
	}

	/**
	 * Removes all the lich su giay to dinh kems from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LichSuGiayToDinhKem lichSuGiayToDinhKem : findAll()) {
			remove(lichSuGiayToDinhKem);
		}
	}

	/**
	 * Returns the number of lich su giay to dinh kems where giayToDinhKemHoSoId = &#63;.
	 *
	 * @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	 * @return the number of matching lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByGiayToDinhKemHoSoId(Long giayToDinhKemHoSoId)
		throws SystemException {
		Object[] finderArgs = new Object[] { giayToDinhKemHoSoId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYGIAYTODINHKEMHOSOID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICHSUGIAYTODINHKEM_WHERE);

			query.append(_FINDER_COLUMN_BYGIAYTODINHKEMHOSOID_GIAYTODINHKEMHOSOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(giayToDinhKemHoSoId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYGIAYTODINHKEMHOSOID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63;.
	 *
	 * @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	 * @return the number of matching lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByNoiLuuTruTaiLieuId(long noiLuuTruTaiLieuId)
		throws SystemException {
		Object[] finderArgs = new Object[] { noiLuuTruTaiLieuId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYNOILUUTRUTAILIEUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICHSUGIAYTODINHKEM_WHERE);

			query.append(_FINDER_COLUMN_BYNOILUUTRUTAILIEUID_NOILUUTRUTAILIEUID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(noiLuuTruTaiLieuId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYNOILUUTRUTAILIEUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of lich su giay to dinh kems.
	 *
	 * @return the number of lich su giay to dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LICHSUGIAYTODINHKEM);

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
	 * Initializes the lich su giay to dinh kem persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LichSuGiayToDinhKem>> listenersList = new ArrayList<ModelListener<LichSuGiayToDinhKem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LichSuGiayToDinhKem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LichSuGiayToDinhKemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DanhMucGiayToPersistence.class)
	protected DanhMucGiayToPersistence danhMucGiayToPersistence;
	@BeanReference(type = LichSuGiayToDinhKemPersistence.class)
	protected LichSuGiayToDinhKemPersistence lichSuGiayToDinhKemPersistence;
	@BeanReference(type = TaiLieuChungThucPersistence.class)
	protected TaiLieuChungThucPersistence taiLieuChungThucPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LICHSUGIAYTODINHKEM = "SELECT lichSuGiayToDinhKem FROM LichSuGiayToDinhKem lichSuGiayToDinhKem";
	private static final String _SQL_SELECT_LICHSUGIAYTODINHKEM_WHERE = "SELECT lichSuGiayToDinhKem FROM LichSuGiayToDinhKem lichSuGiayToDinhKem WHERE ";
	private static final String _SQL_COUNT_LICHSUGIAYTODINHKEM = "SELECT COUNT(lichSuGiayToDinhKem) FROM LichSuGiayToDinhKem lichSuGiayToDinhKem";
	private static final String _SQL_COUNT_LICHSUGIAYTODINHKEM_WHERE = "SELECT COUNT(lichSuGiayToDinhKem) FROM LichSuGiayToDinhKem lichSuGiayToDinhKem WHERE ";
	private static final String _FINDER_COLUMN_BYGIAYTODINHKEMHOSOID_GIAYTODINHKEMHOSOID_2 =
		"lichSuGiayToDinhKem.giayToDinhKemHoSoId = ?";
	private static final String _FINDER_COLUMN_BYNOILUUTRUTAILIEUID_NOILUUTRUTAILIEUID_2 =
		"lichSuGiayToDinhKem.noiLuuTruTaiLieuId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lichSuGiayToDinhKem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LichSuGiayToDinhKem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LichSuGiayToDinhKem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LichSuGiayToDinhKemPersistenceImpl.class);
	private static LichSuGiayToDinhKem _nullLichSuGiayToDinhKem = new LichSuGiayToDinhKemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LichSuGiayToDinhKem> toCacheModel() {
				return _nullLichSuGiayToDinhKemCacheModel;
			}
		};

	private static CacheModel<LichSuGiayToDinhKem> _nullLichSuGiayToDinhKemCacheModel =
		new CacheModel<LichSuGiayToDinhKem>() {
			public LichSuGiayToDinhKem toEntityModel() {
				return _nullLichSuGiayToDinhKem;
			}
		};
}