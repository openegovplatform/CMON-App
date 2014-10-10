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

package org.oep.cmon.dao.cc.service.persistence;

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

import org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;
import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc;
import org.oep.cmon.dao.cc.model.impl.CongChuc2NhomThuTucImpl;
import org.oep.cmon.dao.cc.model.impl.CongChuc2NhomThuTucModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cong chuc2 nhom thu tuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see CongChuc2NhomThuTucPersistence
 * @see CongChuc2NhomThuTucUtil
 * @generated
 */
public class CongChuc2NhomThuTucPersistenceImpl extends BasePersistenceImpl<CongChuc2NhomThuTuc>
	implements CongChuc2NhomThuTucPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CongChuc2NhomThuTucUtil} to access the cong chuc2 nhom thu tuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CongChuc2NhomThuTucImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_ID = new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED,
			CongChuc2NhomThuTucImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchById", new String[] { Long.class.getName() },
			CongChuc2NhomThuTucModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONGCHUC = new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED,
			CongChuc2NhomThuTucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCongChuc",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGCHUC =
		new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED,
			CongChuc2NhomThuTucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCongChuc",
			new String[] { Long.class.getName() },
			CongChuc2NhomThuTucModelImpl.CONGCHUCID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONGCHUC = new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCongChuc",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC = new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED,
			CongChuc2NhomThuTucImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCongChucAndNhomThuTuc",
			new String[] { Long.class.getName(), Long.class.getName() },
			CongChuc2NhomThuTucModelImpl.CONGCHUCID_COLUMN_BITMASK |
			CongChuc2NhomThuTucModelImpl.NHOMTHUTUCID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONGCHUCANDNHOMTHUTUC = new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCongChucAndNhomThuTuc",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED,
			CongChuc2NhomThuTucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED,
			CongChuc2NhomThuTucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cong chuc2 nhom thu tuc in the entity cache if it is enabled.
	 *
	 * @param congChuc2NhomThuTuc the cong chuc2 nhom thu tuc
	 */
	public void cacheResult(CongChuc2NhomThuTuc congChuc2NhomThuTuc) {
		EntityCacheUtil.putResult(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucImpl.class, congChuc2NhomThuTuc.getPrimaryKey(),
			congChuc2NhomThuTuc);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(congChuc2NhomThuTuc.getId()) },
			congChuc2NhomThuTuc);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC,
			new Object[] {
				Long.valueOf(congChuc2NhomThuTuc.getCongChucId()),
				Long.valueOf(congChuc2NhomThuTuc.getNhomThuTucId())
			}, congChuc2NhomThuTuc);

		congChuc2NhomThuTuc.resetOriginalValues();
	}

	/**
	 * Caches the cong chuc2 nhom thu tucs in the entity cache if it is enabled.
	 *
	 * @param congChuc2NhomThuTucs the cong chuc2 nhom thu tucs
	 */
	public void cacheResult(List<CongChuc2NhomThuTuc> congChuc2NhomThuTucs) {
		for (CongChuc2NhomThuTuc congChuc2NhomThuTuc : congChuc2NhomThuTucs) {
			if (EntityCacheUtil.getResult(
						CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
						CongChuc2NhomThuTucImpl.class,
						congChuc2NhomThuTuc.getPrimaryKey()) == null) {
				cacheResult(congChuc2NhomThuTuc);
			}
			else {
				congChuc2NhomThuTuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cong chuc2 nhom thu tucs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CongChuc2NhomThuTucImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CongChuc2NhomThuTucImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cong chuc2 nhom thu tuc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CongChuc2NhomThuTuc congChuc2NhomThuTuc) {
		EntityCacheUtil.removeResult(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucImpl.class, congChuc2NhomThuTuc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(congChuc2NhomThuTuc);
	}

	@Override
	public void clearCache(List<CongChuc2NhomThuTuc> congChuc2NhomThuTucs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CongChuc2NhomThuTuc congChuc2NhomThuTuc : congChuc2NhomThuTucs) {
			EntityCacheUtil.removeResult(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
				CongChuc2NhomThuTucImpl.class,
				congChuc2NhomThuTuc.getPrimaryKey());

			clearUniqueFindersCache(congChuc2NhomThuTuc);
		}
	}

	protected void clearUniqueFindersCache(
		CongChuc2NhomThuTuc congChuc2NhomThuTuc) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(congChuc2NhomThuTuc.getId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC,
			new Object[] {
				Long.valueOf(congChuc2NhomThuTuc.getCongChucId()),
				Long.valueOf(congChuc2NhomThuTuc.getNhomThuTucId())
			});
	}

	/**
	 * Creates a new cong chuc2 nhom thu tuc with the primary key. Does not add the cong chuc2 nhom thu tuc to the database.
	 *
	 * @param id the primary key for the new cong chuc2 nhom thu tuc
	 * @return the new cong chuc2 nhom thu tuc
	 */
	public CongChuc2NhomThuTuc create(long id) {
		CongChuc2NhomThuTuc congChuc2NhomThuTuc = new CongChuc2NhomThuTucImpl();

		congChuc2NhomThuTuc.setNew(true);
		congChuc2NhomThuTuc.setPrimaryKey(id);

		return congChuc2NhomThuTuc;
	}

	/**
	 * Removes the cong chuc2 nhom thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cong chuc2 nhom thu tuc
	 * @return the cong chuc2 nhom thu tuc that was removed
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc remove(long id)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the cong chuc2 nhom thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cong chuc2 nhom thu tuc
	 * @return the cong chuc2 nhom thu tuc that was removed
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongChuc2NhomThuTuc remove(Serializable primaryKey)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CongChuc2NhomThuTuc congChuc2NhomThuTuc = (CongChuc2NhomThuTuc)session.get(CongChuc2NhomThuTucImpl.class,
					primaryKey);

			if (congChuc2NhomThuTuc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCongChuc2NhomThuTucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(congChuc2NhomThuTuc);
		}
		catch (NoSuchCongChuc2NhomThuTucException nsee) {
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
	protected CongChuc2NhomThuTuc removeImpl(
		CongChuc2NhomThuTuc congChuc2NhomThuTuc) throws SystemException {
		congChuc2NhomThuTuc = toUnwrappedModel(congChuc2NhomThuTuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, congChuc2NhomThuTuc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(congChuc2NhomThuTuc);

		return congChuc2NhomThuTuc;
	}

	@Override
	public CongChuc2NhomThuTuc updateImpl(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc,
		boolean merge) throws SystemException {
		congChuc2NhomThuTuc = toUnwrappedModel(congChuc2NhomThuTuc);

		boolean isNew = congChuc2NhomThuTuc.isNew();

		CongChuc2NhomThuTucModelImpl congChuc2NhomThuTucModelImpl = (CongChuc2NhomThuTucModelImpl)congChuc2NhomThuTuc;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, congChuc2NhomThuTuc, merge);

			congChuc2NhomThuTuc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CongChuc2NhomThuTucModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((congChuc2NhomThuTucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGCHUC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(congChuc2NhomThuTucModelImpl.getOriginalCongChucId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONGCHUC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGCHUC,
					args);

				args = new Object[] {
						Long.valueOf(congChuc2NhomThuTucModelImpl.getCongChucId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONGCHUC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGCHUC,
					args);
			}
		}

		EntityCacheUtil.putResult(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2NhomThuTucImpl.class, congChuc2NhomThuTuc.getPrimaryKey(),
			congChuc2NhomThuTuc);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
				new Object[] { Long.valueOf(congChuc2NhomThuTuc.getId()) },
				congChuc2NhomThuTuc);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC,
				new Object[] {
					Long.valueOf(congChuc2NhomThuTuc.getCongChucId()),
					Long.valueOf(congChuc2NhomThuTuc.getNhomThuTucId())
				}, congChuc2NhomThuTuc);
		}
		else {
			if ((congChuc2NhomThuTucModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(congChuc2NhomThuTucModelImpl.getOriginalId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
					new Object[] { Long.valueOf(congChuc2NhomThuTuc.getId()) },
					congChuc2NhomThuTuc);
			}

			if ((congChuc2NhomThuTucModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(congChuc2NhomThuTucModelImpl.getOriginalCongChucId()),
						Long.valueOf(congChuc2NhomThuTucModelImpl.getOriginalNhomThuTucId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONGCHUCANDNHOMTHUTUC,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC,
					new Object[] {
						Long.valueOf(congChuc2NhomThuTuc.getCongChucId()),
						Long.valueOf(congChuc2NhomThuTuc.getNhomThuTucId())
					}, congChuc2NhomThuTuc);
			}
		}

		return congChuc2NhomThuTuc;
	}

	protected CongChuc2NhomThuTuc toUnwrappedModel(
		CongChuc2NhomThuTuc congChuc2NhomThuTuc) {
		if (congChuc2NhomThuTuc instanceof CongChuc2NhomThuTucImpl) {
			return congChuc2NhomThuTuc;
		}

		CongChuc2NhomThuTucImpl congChuc2NhomThuTucImpl = new CongChuc2NhomThuTucImpl();

		congChuc2NhomThuTucImpl.setNew(congChuc2NhomThuTuc.isNew());
		congChuc2NhomThuTucImpl.setPrimaryKey(congChuc2NhomThuTuc.getPrimaryKey());

		congChuc2NhomThuTucImpl.setId(congChuc2NhomThuTuc.getId());
		congChuc2NhomThuTucImpl.setCongChucId(congChuc2NhomThuTuc.getCongChucId());
		congChuc2NhomThuTucImpl.setNhomThuTucId(congChuc2NhomThuTuc.getNhomThuTucId());
		congChuc2NhomThuTucImpl.setNgayTao(congChuc2NhomThuTuc.getNgayTao());
		congChuc2NhomThuTucImpl.setNguoiTao(congChuc2NhomThuTuc.getNguoiTao());
		congChuc2NhomThuTucImpl.setNgaySua(congChuc2NhomThuTuc.getNgaySua());
		congChuc2NhomThuTucImpl.setNguoiSua(congChuc2NhomThuTuc.getNguoiSua());
		congChuc2NhomThuTucImpl.setDaXoa(congChuc2NhomThuTuc.getDaXoa());
		congChuc2NhomThuTucImpl.setDuocPhepEditCongDan(congChuc2NhomThuTuc.getDuocPhepEditCongDan());

		return congChuc2NhomThuTucImpl;
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong chuc2 nhom thu tuc
	 * @return the cong chuc2 nhom thu tuc
	 * @throws com.liferay.portal.NoSuchModelException if a cong chuc2 nhom thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongChuc2NhomThuTuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc with the primary key or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException} if it could not be found.
	 *
	 * @param id the primary key of the cong chuc2 nhom thu tuc
	 * @return the cong chuc2 nhom thu tuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc findByPrimaryKey(long id)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		CongChuc2NhomThuTuc congChuc2NhomThuTuc = fetchByPrimaryKey(id);

		if (congChuc2NhomThuTuc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCongChuc2NhomThuTucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return congChuc2NhomThuTuc;
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong chuc2 nhom thu tuc
	 * @return the cong chuc2 nhom thu tuc, or <code>null</code> if a cong chuc2 nhom thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongChuc2NhomThuTuc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cong chuc2 nhom thu tuc
	 * @return the cong chuc2 nhom thu tuc, or <code>null</code> if a cong chuc2 nhom thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc fetchByPrimaryKey(long id)
		throws SystemException {
		CongChuc2NhomThuTuc congChuc2NhomThuTuc = (CongChuc2NhomThuTuc)EntityCacheUtil.getResult(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
				CongChuc2NhomThuTucImpl.class, id);

		if (congChuc2NhomThuTuc == _nullCongChuc2NhomThuTuc) {
			return null;
		}

		if (congChuc2NhomThuTuc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				congChuc2NhomThuTuc = (CongChuc2NhomThuTuc)session.get(CongChuc2NhomThuTucImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (congChuc2NhomThuTuc != null) {
					cacheResult(congChuc2NhomThuTuc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CongChuc2NhomThuTucModelImpl.ENTITY_CACHE_ENABLED,
						CongChuc2NhomThuTucImpl.class, id,
						_nullCongChuc2NhomThuTuc);
				}

				closeSession(session);
			}
		}

		return congChuc2NhomThuTuc;
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc where id = &#63; or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException} if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching cong chuc2 nhom thu tuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc findById(long id)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		CongChuc2NhomThuTuc congChuc2NhomThuTuc = fetchById(id);

		if (congChuc2NhomThuTuc == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCongChuc2NhomThuTucException(msg.toString());
		}

		return congChuc2NhomThuTuc;
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc fetchById(long id) throws SystemException {
		return fetchById(id, true);
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc fetchById(long id, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_CONGCHUC2NHOMTHUTUC_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				List<CongChuc2NhomThuTuc> list = q.list();

				result = list;

				CongChuc2NhomThuTuc congChuc2NhomThuTuc = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs, list);
				}
				else {
					congChuc2NhomThuTuc = list.get(0);

					cacheResult(congChuc2NhomThuTuc);

					if ((congChuc2NhomThuTuc.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
							finderArgs, congChuc2NhomThuTuc);
					}
				}

				return congChuc2NhomThuTuc;
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
				return (CongChuc2NhomThuTuc)result;
			}
		}
	}

	/**
	 * Returns all the cong chuc2 nhom thu tucs where congChucId = &#63;.
	 *
	 * @param congChucId the cong chuc ID
	 * @return the matching cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc2NhomThuTuc> findByCongChuc(long congChucId)
		throws SystemException {
		return findByCongChuc(congChucId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the cong chuc2 nhom thu tucs where congChucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congChucId the cong chuc ID
	 * @param start the lower bound of the range of cong chuc2 nhom thu tucs
	 * @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	 * @return the range of matching cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc2NhomThuTuc> findByCongChuc(long congChucId, int start,
		int end) throws SystemException {
		return findByCongChuc(congChucId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong chuc2 nhom thu tucs where congChucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congChucId the cong chuc ID
	 * @param start the lower bound of the range of cong chuc2 nhom thu tucs
	 * @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc2NhomThuTuc> findByCongChuc(long congChucId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGCHUC;
			finderArgs = new Object[] { congChucId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONGCHUC;
			finderArgs = new Object[] { congChucId, start, end, orderByComparator };
		}

		List<CongChuc2NhomThuTuc> list = (List<CongChuc2NhomThuTuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGCHUC2NHOMTHUTUC_WHERE);

			query.append(_FINDER_COLUMN_CONGCHUC_CONGCHUCID_2);

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

				qPos.add(congChucId);

				list = (List<CongChuc2NhomThuTuc>)QueryUtil.list(q,
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
	 * Returns the first cong chuc2 nhom thu tuc in the ordered set where congChucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congChucId the cong chuc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong chuc2 nhom thu tuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc findByCongChuc_First(long congChucId,
		OrderByComparator orderByComparator)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		List<CongChuc2NhomThuTuc> list = findByCongChuc(congChucId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("congChucId=");
			msg.append(congChucId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChuc2NhomThuTucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong chuc2 nhom thu tuc in the ordered set where congChucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congChucId the cong chuc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong chuc2 nhom thu tuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc findByCongChuc_Last(long congChucId,
		OrderByComparator orderByComparator)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		int count = countByCongChuc(congChucId);

		List<CongChuc2NhomThuTuc> list = findByCongChuc(congChucId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("congChucId=");
			msg.append(congChucId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChuc2NhomThuTucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong chuc2 nhom thu tucs before and after the current cong chuc2 nhom thu tuc in the ordered set where congChucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong chuc2 nhom thu tuc
	 * @param congChucId the cong chuc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong chuc2 nhom thu tuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc[] findByCongChuc_PrevAndNext(long id,
		long congChucId, OrderByComparator orderByComparator)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		CongChuc2NhomThuTuc congChuc2NhomThuTuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongChuc2NhomThuTuc[] array = new CongChuc2NhomThuTucImpl[3];

			array[0] = getByCongChuc_PrevAndNext(session, congChuc2NhomThuTuc,
					congChucId, orderByComparator, true);

			array[1] = congChuc2NhomThuTuc;

			array[2] = getByCongChuc_PrevAndNext(session, congChuc2NhomThuTuc,
					congChucId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CongChuc2NhomThuTuc getByCongChuc_PrevAndNext(Session session,
		CongChuc2NhomThuTuc congChuc2NhomThuTuc, long congChucId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGCHUC2NHOMTHUTUC_WHERE);

		query.append(_FINDER_COLUMN_CONGCHUC_CONGCHUCID_2);

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

		qPos.add(congChucId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(congChuc2NhomThuTuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongChuc2NhomThuTuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException} if it could not be found.
	 *
	 * @param congChucId the cong chuc ID
	 * @param nhomThuTucId the nhom thu tuc ID
	 * @return the matching cong chuc2 nhom thu tuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc findByCongChucAndNhomThuTuc(long congChucId,
		long nhomThuTucId)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		CongChuc2NhomThuTuc congChuc2NhomThuTuc = fetchByCongChucAndNhomThuTuc(congChucId,
				nhomThuTucId);

		if (congChuc2NhomThuTuc == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("congChucId=");
			msg.append(congChucId);

			msg.append(", nhomThuTucId=");
			msg.append(nhomThuTucId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCongChuc2NhomThuTucException(msg.toString());
		}

		return congChuc2NhomThuTuc;
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param congChucId the cong chuc ID
	 * @param nhomThuTucId the nhom thu tuc ID
	 * @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc fetchByCongChucAndNhomThuTuc(long congChucId,
		long nhomThuTucId) throws SystemException {
		return fetchByCongChucAndNhomThuTuc(congChucId, nhomThuTucId, true);
	}

	/**
	 * Returns the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param congChucId the cong chuc ID
	 * @param nhomThuTucId the nhom thu tuc ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2NhomThuTuc fetchByCongChucAndNhomThuTuc(long congChucId,
		long nhomThuTucId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { congChucId, nhomThuTucId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONGCHUC2NHOMTHUTUC_WHERE);

			query.append(_FINDER_COLUMN_CONGCHUCANDNHOMTHUTUC_CONGCHUCID_2);

			query.append(_FINDER_COLUMN_CONGCHUCANDNHOMTHUTUC_NHOMTHUTUCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(congChucId);

				qPos.add(nhomThuTucId);

				List<CongChuc2NhomThuTuc> list = q.list();

				result = list;

				CongChuc2NhomThuTuc congChuc2NhomThuTuc = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC,
						finderArgs, list);
				}
				else {
					congChuc2NhomThuTuc = list.get(0);

					cacheResult(congChuc2NhomThuTuc);

					if ((congChuc2NhomThuTuc.getCongChucId() != congChucId) ||
							(congChuc2NhomThuTuc.getNhomThuTucId() != nhomThuTucId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC,
							finderArgs, congChuc2NhomThuTuc);
					}
				}

				return congChuc2NhomThuTuc;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONGCHUCANDNHOMTHUTUC,
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
				return (CongChuc2NhomThuTuc)result;
			}
		}
	}

	/**
	 * Returns all the cong chuc2 nhom thu tucs.
	 *
	 * @return the cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc2NhomThuTuc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong chuc2 nhom thu tucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong chuc2 nhom thu tucs
	 * @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	 * @return the range of cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc2NhomThuTuc> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong chuc2 nhom thu tucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong chuc2 nhom thu tucs
	 * @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc2NhomThuTuc> findAll(int start, int end,
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

		List<CongChuc2NhomThuTuc> list = (List<CongChuc2NhomThuTuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONGCHUC2NHOMTHUTUC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONGCHUC2NHOMTHUTUC;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CongChuc2NhomThuTuc>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CongChuc2NhomThuTuc>)QueryUtil.list(q,
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
	 * Removes the cong chuc2 nhom thu tuc where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeById(long id)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		CongChuc2NhomThuTuc congChuc2NhomThuTuc = findById(id);

		remove(congChuc2NhomThuTuc);
	}

	/**
	 * Removes all the cong chuc2 nhom thu tucs where congChucId = &#63; from the database.
	 *
	 * @param congChucId the cong chuc ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCongChuc(long congChucId) throws SystemException {
		for (CongChuc2NhomThuTuc congChuc2NhomThuTuc : findByCongChuc(
				congChucId)) {
			remove(congChuc2NhomThuTuc);
		}
	}

	/**
	 * Removes the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; from the database.
	 *
	 * @param congChucId the cong chuc ID
	 * @param nhomThuTucId the nhom thu tuc ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCongChucAndNhomThuTuc(long congChucId, long nhomThuTucId)
		throws NoSuchCongChuc2NhomThuTucException, SystemException {
		CongChuc2NhomThuTuc congChuc2NhomThuTuc = findByCongChucAndNhomThuTuc(congChucId,
				nhomThuTucId);

		remove(congChuc2NhomThuTuc);
	}

	/**
	 * Removes all the cong chuc2 nhom thu tucs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CongChuc2NhomThuTuc congChuc2NhomThuTuc : findAll()) {
			remove(congChuc2NhomThuTuc);
		}
	}

	/**
	 * Returns the number of cong chuc2 nhom thu tucs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countById(long id) throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGCHUC2NHOMTHUTUC_WHERE);

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
	 * Returns the number of cong chuc2 nhom thu tucs where congChucId = &#63;.
	 *
	 * @param congChucId the cong chuc ID
	 * @return the number of matching cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCongChuc(long congChucId) throws SystemException {
		Object[] finderArgs = new Object[] { congChucId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONGCHUC,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGCHUC2NHOMTHUTUC_WHERE);

			query.append(_FINDER_COLUMN_CONGCHUC_CONGCHUCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(congChucId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONGCHUC,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong chuc2 nhom thu tucs where congChucId = &#63; and nhomThuTucId = &#63;.
	 *
	 * @param congChucId the cong chuc ID
	 * @param nhomThuTucId the nhom thu tuc ID
	 * @return the number of matching cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCongChucAndNhomThuTuc(long congChucId, long nhomThuTucId)
		throws SystemException {
		Object[] finderArgs = new Object[] { congChucId, nhomThuTucId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONGCHUCANDNHOMTHUTUC,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONGCHUC2NHOMTHUTUC_WHERE);

			query.append(_FINDER_COLUMN_CONGCHUCANDNHOMTHUTUC_CONGCHUCID_2);

			query.append(_FINDER_COLUMN_CONGCHUCANDNHOMTHUTUC_NHOMTHUTUCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(congChucId);

				qPos.add(nhomThuTucId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONGCHUCANDNHOMTHUTUC,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong chuc2 nhom thu tucs.
	 *
	 * @return the number of cong chuc2 nhom thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONGCHUC2NHOMTHUTUC);

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
	 * Initializes the cong chuc2 nhom thu tuc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CongChuc2NhomThuTuc>> listenersList = new ArrayList<ModelListener<CongChuc2NhomThuTuc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CongChuc2NhomThuTuc>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CongChuc2NhomThuTucImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChucVuPersistence.class)
	protected ChucVuPersistence chucVuPersistence;
	@BeanReference(type = CongChucPersistence.class)
	protected CongChucPersistence congChucPersistence;
	@BeanReference(type = CongChuc2NhomThuTucPersistence.class)
	protected CongChuc2NhomThuTucPersistence congChuc2NhomThuTucPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CONGCHUC2NHOMTHUTUC = "SELECT congChuc2NhomThuTuc FROM CongChuc2NhomThuTuc congChuc2NhomThuTuc";
	private static final String _SQL_SELECT_CONGCHUC2NHOMTHUTUC_WHERE = "SELECT congChuc2NhomThuTuc FROM CongChuc2NhomThuTuc congChuc2NhomThuTuc WHERE ";
	private static final String _SQL_COUNT_CONGCHUC2NHOMTHUTUC = "SELECT COUNT(congChuc2NhomThuTuc) FROM CongChuc2NhomThuTuc congChuc2NhomThuTuc";
	private static final String _SQL_COUNT_CONGCHUC2NHOMTHUTUC_WHERE = "SELECT COUNT(congChuc2NhomThuTuc) FROM CongChuc2NhomThuTuc congChuc2NhomThuTuc WHERE ";
	private static final String _FINDER_COLUMN_ID_ID_2 = "congChuc2NhomThuTuc.id = ? AND congChuc2NhomThuTuc.daXoa = 0";
	private static final String _FINDER_COLUMN_CONGCHUC_CONGCHUCID_2 = "congChuc2NhomThuTuc.congChucId = ? AND congChuc2NhomThuTuc.daXoa = 0";
	private static final String _FINDER_COLUMN_CONGCHUCANDNHOMTHUTUC_CONGCHUCID_2 =
		"congChuc2NhomThuTuc.congChucId = ? AND ";
	private static final String _FINDER_COLUMN_CONGCHUCANDNHOMTHUTUC_NHOMTHUTUCID_2 =
		"congChuc2NhomThuTuc.nhomThuTucId = ? AND congChuc2NhomThuTuc.daXoa = 0";
	private static final String _ORDER_BY_ENTITY_ALIAS = "congChuc2NhomThuTuc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CongChuc2NhomThuTuc exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CongChuc2NhomThuTuc exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CongChuc2NhomThuTucPersistenceImpl.class);
	private static CongChuc2NhomThuTuc _nullCongChuc2NhomThuTuc = new CongChuc2NhomThuTucImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CongChuc2NhomThuTuc> toCacheModel() {
				return _nullCongChuc2NhomThuTucCacheModel;
			}
		};

	private static CacheModel<CongChuc2NhomThuTuc> _nullCongChuc2NhomThuTucCacheModel =
		new CacheModel<CongChuc2NhomThuTuc>() {
			public CongChuc2NhomThuTuc toEntityModel() {
				return _nullCongChuc2NhomThuTuc;
			}
		};
}