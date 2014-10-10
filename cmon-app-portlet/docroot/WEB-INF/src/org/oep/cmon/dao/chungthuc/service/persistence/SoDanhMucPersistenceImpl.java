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

package org.oep.cmon.dao.chungthuc.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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

import org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;
import org.oep.cmon.dao.chungthuc.model.SoDanhMuc;
import org.oep.cmon.dao.chungthuc.model.impl.SoDanhMucImpl;
import org.oep.cmon.dao.chungthuc.model.impl.SoDanhMucModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the so danh muc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vietho
 * @see SoDanhMucPersistence
 * @see SoDanhMucUtil
 * @generated
 */
public class SoDanhMucPersistenceImpl extends BasePersistenceImpl<SoDanhMuc>
	implements SoDanhMucPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SoDanhMucUtil} to access the so danh muc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SoDanhMucImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOTTHCID =
		new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, SoDanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTheoTTHCID",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID =
		new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, SoDanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTheoTTHCID",
			new String[] { Long.class.getName() },
			SoDanhMucModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THEOTTHCID = new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTheoTTHCID",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOCOQUANQUANLYID =
		new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, SoDanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTheoCOQUANQUANLYID",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOCOQUANQUANLYID =
		new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, SoDanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTheoCOQUANQUANLYID", new String[] { Long.class.getName() },
			SoDanhMucModelImpl.COQUANQUANLIID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THEOCOQUANQUANLYID = new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTheoCOQUANQUANLYID", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOTTHCIDANDCQQLID =
		new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, SoDanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTheoTTHCIDAndCQQLID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDCQQLID =
		new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, SoDanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTheoTTHCIDAndCQQLID",
			new String[] { Long.class.getName(), Long.class.getName() },
			SoDanhMucModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK |
			SoDanhMucModelImpl.COQUANQUANLIID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THEOTTHCIDANDCQQLID = new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTheoTTHCIDAndCQQLID",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, SoDanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, SoDanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the so danh muc in the entity cache if it is enabled.
	 *
	 * @param soDanhMuc the so danh muc
	 */
	public void cacheResult(SoDanhMuc soDanhMuc) {
		EntityCacheUtil.putResult(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucImpl.class, soDanhMuc.getPrimaryKey(), soDanhMuc);

		soDanhMuc.resetOriginalValues();
	}

	/**
	 * Caches the so danh mucs in the entity cache if it is enabled.
	 *
	 * @param soDanhMucs the so danh mucs
	 */
	public void cacheResult(List<SoDanhMuc> soDanhMucs) {
		for (SoDanhMuc soDanhMuc : soDanhMucs) {
			if (EntityCacheUtil.getResult(
						SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
						SoDanhMucImpl.class, soDanhMuc.getPrimaryKey()) == null) {
				cacheResult(soDanhMuc);
			}
			else {
				soDanhMuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all so danh mucs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SoDanhMucImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SoDanhMucImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the so danh muc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SoDanhMuc soDanhMuc) {
		EntityCacheUtil.removeResult(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucImpl.class, soDanhMuc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SoDanhMuc> soDanhMucs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SoDanhMuc soDanhMuc : soDanhMucs) {
			EntityCacheUtil.removeResult(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
				SoDanhMucImpl.class, soDanhMuc.getPrimaryKey());
		}
	}

	/**
	 * Creates a new so danh muc with the primary key. Does not add the so danh muc to the database.
	 *
	 * @param id the primary key for the new so danh muc
	 * @return the new so danh muc
	 */
	public SoDanhMuc create(long id) {
		SoDanhMuc soDanhMuc = new SoDanhMucImpl();

		soDanhMuc.setNew(true);
		soDanhMuc.setPrimaryKey(id);

		return soDanhMuc;
	}

	/**
	 * Removes the so danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the so danh muc
	 * @return the so danh muc that was removed
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc remove(long id)
		throws NoSuchSoDanhMucException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the so danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the so danh muc
	 * @return the so danh muc that was removed
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SoDanhMuc remove(Serializable primaryKey)
		throws NoSuchSoDanhMucException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SoDanhMuc soDanhMuc = (SoDanhMuc)session.get(SoDanhMucImpl.class,
					primaryKey);

			if (soDanhMuc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSoDanhMucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(soDanhMuc);
		}
		catch (NoSuchSoDanhMucException nsee) {
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
	protected SoDanhMuc removeImpl(SoDanhMuc soDanhMuc)
		throws SystemException {
		soDanhMuc = toUnwrappedModel(soDanhMuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, soDanhMuc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(soDanhMuc);

		return soDanhMuc;
	}

	@Override
	public SoDanhMuc updateImpl(
		org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc, boolean merge)
		throws SystemException {
		soDanhMuc = toUnwrappedModel(soDanhMuc);

		boolean isNew = soDanhMuc.isNew();

		SoDanhMucModelImpl soDanhMucModelImpl = (SoDanhMucModelImpl)soDanhMuc;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, soDanhMuc, merge);

			soDanhMuc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SoDanhMucModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((soDanhMucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(soDanhMucModelImpl.getOriginalThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOTTHCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID,
					args);

				args = new Object[] {
						Long.valueOf(soDanhMucModelImpl.getThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOTTHCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID,
					args);
			}

			if ((soDanhMucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOCOQUANQUANLYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(soDanhMucModelImpl.getOriginalCoQuanQuanLiId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOCOQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOCOQUANQUANLYID,
					args);

				args = new Object[] {
						Long.valueOf(soDanhMucModelImpl.getCoQuanQuanLiId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOCOQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOCOQUANQUANLYID,
					args);
			}

			if ((soDanhMucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDCQQLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(soDanhMucModelImpl.getOriginalThuTucHanhChinhId()),
						Long.valueOf(soDanhMucModelImpl.getOriginalCoQuanQuanLiId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOTTHCIDANDCQQLID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDCQQLID,
					args);

				args = new Object[] {
						Long.valueOf(soDanhMucModelImpl.getThuTucHanhChinhId()),
						Long.valueOf(soDanhMucModelImpl.getCoQuanQuanLiId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOTTHCIDANDCQQLID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDCQQLID,
					args);
			}
		}

		EntityCacheUtil.putResult(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
			SoDanhMucImpl.class, soDanhMuc.getPrimaryKey(), soDanhMuc);

		return soDanhMuc;
	}

	protected SoDanhMuc toUnwrappedModel(SoDanhMuc soDanhMuc) {
		if (soDanhMuc instanceof SoDanhMucImpl) {
			return soDanhMuc;
		}

		SoDanhMucImpl soDanhMucImpl = new SoDanhMucImpl();

		soDanhMucImpl.setNew(soDanhMuc.isNew());
		soDanhMucImpl.setPrimaryKey(soDanhMuc.getPrimaryKey());

		soDanhMucImpl.setId(soDanhMuc.getId());
		soDanhMucImpl.setTenSo(soDanhMuc.getTenSo());
		soDanhMucImpl.setSoSo(soDanhMuc.getSoSo());
		soDanhMucImpl.setThuTucHanhChinhId(soDanhMuc.getThuTucHanhChinhId());
		soDanhMucImpl.setNam(soDanhMuc.getNam());
		soDanhMucImpl.setTheoQuyetDinh(soDanhMuc.getTheoQuyetDinh());
		soDanhMucImpl.setCoQuanQuanLiId(soDanhMuc.getCoQuanQuanLiId());

		return soDanhMucImpl;
	}

	/**
	 * Returns the so danh muc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the so danh muc
	 * @return the so danh muc
	 * @throws com.liferay.portal.NoSuchModelException if a so danh muc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SoDanhMuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the so danh muc with the primary key or throws a {@link org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException} if it could not be found.
	 *
	 * @param id the primary key of the so danh muc
	 * @return the so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc findByPrimaryKey(long id)
		throws NoSuchSoDanhMucException, SystemException {
		SoDanhMuc soDanhMuc = fetchByPrimaryKey(id);

		if (soDanhMuc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchSoDanhMucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return soDanhMuc;
	}

	/**
	 * Returns the so danh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the so danh muc
	 * @return the so danh muc, or <code>null</code> if a so danh muc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SoDanhMuc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the so danh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the so danh muc
	 * @return the so danh muc, or <code>null</code> if a so danh muc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc fetchByPrimaryKey(long id) throws SystemException {
		SoDanhMuc soDanhMuc = (SoDanhMuc)EntityCacheUtil.getResult(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
				SoDanhMucImpl.class, id);

		if (soDanhMuc == _nullSoDanhMuc) {
			return null;
		}

		if (soDanhMuc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				soDanhMuc = (SoDanhMuc)session.get(SoDanhMucImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (soDanhMuc != null) {
					cacheResult(soDanhMuc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SoDanhMucModelImpl.ENTITY_CACHE_ENABLED,
						SoDanhMucImpl.class, id, _nullSoDanhMuc);
				}

				closeSession(session);
			}
		}

		return soDanhMuc;
	}

	/**
	 * Returns all the so danh mucs where thuTucHanhChinhId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findByTheoTTHCID(Long thuTucHanhChinhId)
		throws SystemException {
		return findByTheoTTHCID(thuTucHanhChinhId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the so danh mucs where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @return the range of matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findByTheoTTHCID(Long thuTucHanhChinhId, int start,
		int end) throws SystemException {
		return findByTheoTTHCID(thuTucHanhChinhId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the so danh mucs where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findByTheoTTHCID(Long thuTucHanhChinhId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID;
			finderArgs = new Object[] { thuTucHanhChinhId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOTTHCID;
			finderArgs = new Object[] {
					thuTucHanhChinhId,
					
					start, end, orderByComparator
				};
		}

		List<SoDanhMuc> list = (List<SoDanhMuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SODANHMUC_WHERE);

			query.append(_FINDER_COLUMN_THEOTTHCID_THUTUCHANHCHINHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SoDanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				list = (List<SoDanhMuc>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first so danh muc in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc findByTheoTTHCID_First(Long thuTucHanhChinhId,
		OrderByComparator orderByComparator)
		throws NoSuchSoDanhMucException, SystemException {
		List<SoDanhMuc> list = findByTheoTTHCID(thuTucHanhChinhId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSoDanhMucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last so danh muc in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc findByTheoTTHCID_Last(Long thuTucHanhChinhId,
		OrderByComparator orderByComparator)
		throws NoSuchSoDanhMucException, SystemException {
		int count = countByTheoTTHCID(thuTucHanhChinhId);

		List<SoDanhMuc> list = findByTheoTTHCID(thuTucHanhChinhId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSoDanhMucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the so danh mucs before and after the current so danh muc in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current so danh muc
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc[] findByTheoTTHCID_PrevAndNext(long id,
		Long thuTucHanhChinhId, OrderByComparator orderByComparator)
		throws NoSuchSoDanhMucException, SystemException {
		SoDanhMuc soDanhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SoDanhMuc[] array = new SoDanhMucImpl[3];

			array[0] = getByTheoTTHCID_PrevAndNext(session, soDanhMuc,
					thuTucHanhChinhId, orderByComparator, true);

			array[1] = soDanhMuc;

			array[2] = getByTheoTTHCID_PrevAndNext(session, soDanhMuc,
					thuTucHanhChinhId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SoDanhMuc getByTheoTTHCID_PrevAndNext(Session session,
		SoDanhMuc soDanhMuc, Long thuTucHanhChinhId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SODANHMUC_WHERE);

		query.append(_FINDER_COLUMN_THEOTTHCID_THUTUCHANHCHINHID_2);

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
			query.append(SoDanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(soDanhMuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SoDanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the so danh mucs where coQuanQuanLiId = &#63;.
	 *
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @return the matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findByTheoCOQUANQUANLYID(Long coQuanQuanLiId)
		throws SystemException {
		return findByTheoCOQUANQUANLYID(coQuanQuanLiId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the so danh mucs where coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @return the range of matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findByTheoCOQUANQUANLYID(Long coQuanQuanLiId,
		int start, int end) throws SystemException {
		return findByTheoCOQUANQUANLYID(coQuanQuanLiId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the so danh mucs where coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findByTheoCOQUANQUANLYID(Long coQuanQuanLiId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOCOQUANQUANLYID;
			finderArgs = new Object[] { coQuanQuanLiId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOCOQUANQUANLYID;
			finderArgs = new Object[] {
					coQuanQuanLiId,
					
					start, end, orderByComparator
				};
		}

		List<SoDanhMuc> list = (List<SoDanhMuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SODANHMUC_WHERE);

			query.append(_FINDER_COLUMN_THEOCOQUANQUANLYID_COQUANQUANLIID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SoDanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLiId.longValue());

				list = (List<SoDanhMuc>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first so danh muc in the ordered set where coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc findByTheoCOQUANQUANLYID_First(Long coQuanQuanLiId,
		OrderByComparator orderByComparator)
		throws NoSuchSoDanhMucException, SystemException {
		List<SoDanhMuc> list = findByTheoCOQUANQUANLYID(coQuanQuanLiId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLiId=");
			msg.append(coQuanQuanLiId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSoDanhMucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last so danh muc in the ordered set where coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc findByTheoCOQUANQUANLYID_Last(Long coQuanQuanLiId,
		OrderByComparator orderByComparator)
		throws NoSuchSoDanhMucException, SystemException {
		int count = countByTheoCOQUANQUANLYID(coQuanQuanLiId);

		List<SoDanhMuc> list = findByTheoCOQUANQUANLYID(coQuanQuanLiId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLiId=");
			msg.append(coQuanQuanLiId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSoDanhMucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the so danh mucs before and after the current so danh muc in the ordered set where coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current so danh muc
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc[] findByTheoCOQUANQUANLYID_PrevAndNext(long id,
		Long coQuanQuanLiId, OrderByComparator orderByComparator)
		throws NoSuchSoDanhMucException, SystemException {
		SoDanhMuc soDanhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SoDanhMuc[] array = new SoDanhMucImpl[3];

			array[0] = getByTheoCOQUANQUANLYID_PrevAndNext(session, soDanhMuc,
					coQuanQuanLiId, orderByComparator, true);

			array[1] = soDanhMuc;

			array[2] = getByTheoCOQUANQUANLYID_PrevAndNext(session, soDanhMuc,
					coQuanQuanLiId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SoDanhMuc getByTheoCOQUANQUANLYID_PrevAndNext(Session session,
		SoDanhMuc soDanhMuc, Long coQuanQuanLiId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SODANHMUC_WHERE);

		query.append(_FINDER_COLUMN_THEOCOQUANQUANLYID_COQUANQUANLIID_2);

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
			query.append(SoDanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(coQuanQuanLiId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(soDanhMuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SoDanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @return the matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findByTheoTTHCIDAndCQQLID(Long thuTucHanhChinhId,
		Long coQuanQuanLiId) throws SystemException {
		return findByTheoTTHCIDAndCQQLID(thuTucHanhChinhId, coQuanQuanLiId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @return the range of matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findByTheoTTHCIDAndCQQLID(Long thuTucHanhChinhId,
		Long coQuanQuanLiId, int start, int end) throws SystemException {
		return findByTheoTTHCIDAndCQQLID(thuTucHanhChinhId, coQuanQuanLiId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findByTheoTTHCIDAndCQQLID(Long thuTucHanhChinhId,
		Long coQuanQuanLiId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDCQQLID;
			finderArgs = new Object[] { thuTucHanhChinhId, coQuanQuanLiId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOTTHCIDANDCQQLID;
			finderArgs = new Object[] {
					thuTucHanhChinhId, coQuanQuanLiId,
					
					start, end, orderByComparator
				};
		}

		List<SoDanhMuc> list = (List<SoDanhMuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SODANHMUC_WHERE);

			query.append(_FINDER_COLUMN_THEOTTHCIDANDCQQLID_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THEOTTHCIDANDCQQLID_COQUANQUANLIID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SoDanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				qPos.add(coQuanQuanLiId.longValue());

				list = (List<SoDanhMuc>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first so danh muc in the ordered set where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc findByTheoTTHCIDAndCQQLID_First(Long thuTucHanhChinhId,
		Long coQuanQuanLiId, OrderByComparator orderByComparator)
		throws NoSuchSoDanhMucException, SystemException {
		List<SoDanhMuc> list = findByTheoTTHCIDAndCQQLID(thuTucHanhChinhId,
				coQuanQuanLiId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", coQuanQuanLiId=");
			msg.append(coQuanQuanLiId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSoDanhMucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last so danh muc in the ordered set where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc findByTheoTTHCIDAndCQQLID_Last(Long thuTucHanhChinhId,
		Long coQuanQuanLiId, OrderByComparator orderByComparator)
		throws NoSuchSoDanhMucException, SystemException {
		int count = countByTheoTTHCIDAndCQQLID(thuTucHanhChinhId, coQuanQuanLiId);

		List<SoDanhMuc> list = findByTheoTTHCIDAndCQQLID(thuTucHanhChinhId,
				coQuanQuanLiId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", coQuanQuanLiId=");
			msg.append(coQuanQuanLiId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSoDanhMucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the so danh mucs before and after the current so danh muc in the ordered set where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current so danh muc
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next so danh muc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SoDanhMuc[] findByTheoTTHCIDAndCQQLID_PrevAndNext(long id,
		Long thuTucHanhChinhId, Long coQuanQuanLiId,
		OrderByComparator orderByComparator)
		throws NoSuchSoDanhMucException, SystemException {
		SoDanhMuc soDanhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SoDanhMuc[] array = new SoDanhMucImpl[3];

			array[0] = getByTheoTTHCIDAndCQQLID_PrevAndNext(session, soDanhMuc,
					thuTucHanhChinhId, coQuanQuanLiId, orderByComparator, true);

			array[1] = soDanhMuc;

			array[2] = getByTheoTTHCIDAndCQQLID_PrevAndNext(session, soDanhMuc,
					thuTucHanhChinhId, coQuanQuanLiId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SoDanhMuc getByTheoTTHCIDAndCQQLID_PrevAndNext(Session session,
		SoDanhMuc soDanhMuc, Long thuTucHanhChinhId, Long coQuanQuanLiId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SODANHMUC_WHERE);

		query.append(_FINDER_COLUMN_THEOTTHCIDANDCQQLID_THUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_THEOTTHCIDANDCQQLID_COQUANQUANLIID_2);

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
			query.append(SoDanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId.longValue());

		qPos.add(coQuanQuanLiId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(soDanhMuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SoDanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the so danh mucs.
	 *
	 * @return the so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the so danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @return the range of so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the so danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SoDanhMuc> findAll(int start, int end,
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

		List<SoDanhMuc> list = (List<SoDanhMuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SODANHMUC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SODANHMUC.concat(SoDanhMucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SoDanhMuc>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SoDanhMuc>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the so danh mucs where thuTucHanhChinhId = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTheoTTHCID(Long thuTucHanhChinhId)
		throws SystemException {
		for (SoDanhMuc soDanhMuc : findByTheoTTHCID(thuTucHanhChinhId)) {
			remove(soDanhMuc);
		}
	}

	/**
	 * Removes all the so danh mucs where coQuanQuanLiId = &#63; from the database.
	 *
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTheoCOQUANQUANLYID(Long coQuanQuanLiId)
		throws SystemException {
		for (SoDanhMuc soDanhMuc : findByTheoCOQUANQUANLYID(coQuanQuanLiId)) {
			remove(soDanhMuc);
		}
	}

	/**
	 * Removes all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTheoTTHCIDAndCQQLID(Long thuTucHanhChinhId,
		Long coQuanQuanLiId) throws SystemException {
		for (SoDanhMuc soDanhMuc : findByTheoTTHCIDAndCQQLID(
				thuTucHanhChinhId, coQuanQuanLiId)) {
			remove(soDanhMuc);
		}
	}

	/**
	 * Removes all the so danh mucs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SoDanhMuc soDanhMuc : findAll()) {
			remove(soDanhMuc);
		}
	}

	/**
	 * Returns the number of so danh mucs where thuTucHanhChinhId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the number of matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTheoTTHCID(Long thuTucHanhChinhId)
		throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THEOTTHCID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SODANHMUC_WHERE);

			query.append(_FINDER_COLUMN_THEOTTHCID_THUTUCHANHCHINHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THEOTTHCID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of so danh mucs where coQuanQuanLiId = &#63;.
	 *
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @return the number of matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTheoCOQUANQUANLYID(Long coQuanQuanLiId)
		throws SystemException {
		Object[] finderArgs = new Object[] { coQuanQuanLiId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THEOCOQUANQUANLYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SODANHMUC_WHERE);

			query.append(_FINDER_COLUMN_THEOCOQUANQUANLYID_COQUANQUANLIID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLiId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THEOCOQUANQUANLYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param coQuanQuanLiId the co quan quan li ID
	 * @return the number of matching so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTheoTTHCIDAndCQQLID(Long thuTucHanhChinhId,
		Long coQuanQuanLiId) throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId, coQuanQuanLiId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THEOTTHCIDANDCQQLID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SODANHMUC_WHERE);

			query.append(_FINDER_COLUMN_THEOTTHCIDANDCQQLID_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THEOTTHCIDANDCQQLID_COQUANQUANLIID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				qPos.add(coQuanQuanLiId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THEOTTHCIDANDCQQLID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of so danh mucs.
	 *
	 * @return the number of so danh mucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SODANHMUC);

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
	 * Returns all the ho so chung thucs associated with the so danh muc.
	 *
	 * @param pk the primary key of the so danh muc
	 * @return the ho so chung thucs associated with the so danh muc
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucs(
		long pk) throws SystemException {
		return getHoSoChungThucs(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the ho so chung thucs associated with the so danh muc.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the so danh muc
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @return the range of ho so chung thucs associated with the so danh muc
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucs(
		long pk, int start, int end) throws SystemException {
		return getHoSoChungThucs(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_HOSOCHUNGTHUCS = new FinderPath(org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl.class,
			org.oep.cmon.dao.chungthuc.service.persistence.HoSoChungThucPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getHoSoChungThucs",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Returns an ordered range of all the ho so chung thucs associated with the so danh muc.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the so danh muc
	 * @param start the lower bound of the range of so danh mucs
	 * @param end the upper bound of the range of so danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ho so chung thucs associated with the so danh muc
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucs(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> list = (List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc>)FinderCacheUtil.getResult(FINDER_PATH_GET_HOSOCHUNGTHUCS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETHOSOCHUNGTHUCS.concat(ORDER_BY_CLAUSE)
												.concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETHOSOCHUNGTHUCS.concat(org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("CMON_HOSOCHUNGTHUC",
					org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_HOSOCHUNGTHUCS,
						finderArgs);
				}
				else {
					hoSoChungThucPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_HOSOCHUNGTHUCS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_HOSOCHUNGTHUCS_SIZE = new FinderPath(org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl.class,
			org.oep.cmon.dao.chungthuc.service.persistence.HoSoChungThucPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getHoSoChungThucsSize", new String[] { Long.class.getName() });

	/**
	 * Returns the number of ho so chung thucs associated with the so danh muc.
	 *
	 * @param pk the primary key of the so danh muc
	 * @return the number of ho so chung thucs associated with the so danh muc
	 * @throws SystemException if a system exception occurred
	 */
	public int getHoSoChungThucsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_HOSOCHUNGTHUCS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETHOSOCHUNGTHUCSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_HOSOCHUNGTHUCS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_HOSOCHUNGTHUC = new FinderPath(org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl.class,
			org.oep.cmon.dao.chungthuc.service.persistence.HoSoChungThucPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsHoSoChungThuc",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the ho so chung thuc is associated with the so danh muc.
	 *
	 * @param pk the primary key of the so danh muc
	 * @param hoSoChungThucPK the primary key of the ho so chung thuc
	 * @return <code>true</code> if the ho so chung thuc is associated with the so danh muc; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsHoSoChungThuc(long pk, long hoSoChungThucPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, hoSoChungThucPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_HOSOCHUNGTHUC,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsHoSoChungThuc.contains(pk,
							hoSoChungThucPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_HOSOCHUNGTHUC,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the so danh muc has any ho so chung thucs associated with it.
	 *
	 * @param pk the primary key of the so danh muc to check for associations with ho so chung thucs
	 * @return <code>true</code> if the so danh muc has any ho so chung thucs associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsHoSoChungThucs(long pk) throws SystemException {
		if (getHoSoChungThucsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the so danh muc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.chungthuc.model.SoDanhMuc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SoDanhMuc>> listenersList = new ArrayList<ModelListener<SoDanhMuc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SoDanhMuc>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsHoSoChungThuc = new ContainsHoSoChungThuc();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SoDanhMucImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = HoSoChungThucPersistence.class)
	protected HoSoChungThucPersistence hoSoChungThucPersistence;
	@BeanReference(type = SoDanhMucPersistence.class)
	protected SoDanhMucPersistence soDanhMucPersistence;
	@BeanReference(type = ThanhPhanHoSoChungThucPersistence.class)
	protected ThanhPhanHoSoChungThucPersistence thanhPhanHoSoChungThucPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsHoSoChungThuc containsHoSoChungThuc;

	protected class ContainsHoSoChungThuc {
		protected ContainsHoSoChungThuc() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSHOSOCHUNGTHUC,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long id, long hoSoChungThucId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(id), new Long(hoSoChungThucId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_SODANHMUC = "SELECT soDanhMuc FROM SoDanhMuc soDanhMuc";
	private static final String _SQL_SELECT_SODANHMUC_WHERE = "SELECT soDanhMuc FROM SoDanhMuc soDanhMuc WHERE ";
	private static final String _SQL_COUNT_SODANHMUC = "SELECT COUNT(soDanhMuc) FROM SoDanhMuc soDanhMuc";
	private static final String _SQL_COUNT_SODANHMUC_WHERE = "SELECT COUNT(soDanhMuc) FROM SoDanhMuc soDanhMuc WHERE ";
	private static final String _SQL_GETHOSOCHUNGTHUCS = "SELECT {CMON_HOSOCHUNGTHUC.*} FROM CMON_HOSOCHUNGTHUC INNER JOIN CMON_SODANHMUC ON (CMON_SODANHMUC.ID = CMON_HOSOCHUNGTHUC.ID) WHERE (CMON_SODANHMUC.ID = ?)";
	private static final String _SQL_GETHOSOCHUNGTHUCSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM CMON_HOSOCHUNGTHUC WHERE ID = ?";
	private static final String _SQL_CONTAINSHOSOCHUNGTHUC = "SELECT COUNT(*) AS COUNT_VALUE FROM CMON_HOSOCHUNGTHUC WHERE ID = ? AND ID = ?";
	private static final String _FINDER_COLUMN_THEOTTHCID_THUTUCHANHCHINHID_2 = "soDanhMuc.thuTucHanhChinhId = ?";
	private static final String _FINDER_COLUMN_THEOCOQUANQUANLYID_COQUANQUANLIID_2 =
		"soDanhMuc.coQuanQuanLiId = ?";
	private static final String _FINDER_COLUMN_THEOTTHCIDANDCQQLID_THUTUCHANHCHINHID_2 =
		"soDanhMuc.thuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_THEOTTHCIDANDCQQLID_COQUANQUANLIID_2 =
		"soDanhMuc.coQuanQuanLiId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "soDanhMuc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SoDanhMuc exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SoDanhMuc exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SoDanhMucPersistenceImpl.class);
	private static SoDanhMuc _nullSoDanhMuc = new SoDanhMucImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SoDanhMuc> toCacheModel() {
				return _nullSoDanhMucCacheModel;
			}
		};

	private static CacheModel<SoDanhMuc> _nullSoDanhMucCacheModel = new CacheModel<SoDanhMuc>() {
			public SoDanhMuc toEntityModel() {
				return _nullSoDanhMuc;
			}
		};
}