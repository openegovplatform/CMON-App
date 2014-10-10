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

import org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException;
import org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc;
import org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucImpl;
import org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the thanh phan ho so chung thuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vietho
 * @see ThanhPhanHoSoChungThucPersistence
 * @see ThanhPhanHoSoChungThucUtil
 * @generated
 */
public class ThanhPhanHoSoChungThucPersistenceImpl extends BasePersistenceImpl<ThanhPhanHoSoChungThuc>
	implements ThanhPhanHoSoChungThucPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ThanhPhanHoSoChungThucUtil} to access the thanh phan ho so chung thuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ThanhPhanHoSoChungThucImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOHOSOCHUNGTHUCID =
		new FinderPath(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			ThanhPhanHoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			ThanhPhanHoSoChungThucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTheoHoSoChungThucId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOHOSOCHUNGTHUCID =
		new FinderPath(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			ThanhPhanHoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			ThanhPhanHoSoChungThucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTheoHoSoChungThucId", new String[] { Long.class.getName() },
			ThanhPhanHoSoChungThucModelImpl.HOSOCHUNGTHUCID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THEOHOSOCHUNGTHUCID = new FinderPath(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			ThanhPhanHoSoChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTheoHoSoChungThucId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			ThanhPhanHoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			ThanhPhanHoSoChungThucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			ThanhPhanHoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			ThanhPhanHoSoChungThucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			ThanhPhanHoSoChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the thanh phan ho so chung thuc in the entity cache if it is enabled.
	 *
	 * @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	 */
	public void cacheResult(ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc) {
		EntityCacheUtil.putResult(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			ThanhPhanHoSoChungThucImpl.class,
			thanhPhanHoSoChungThuc.getPrimaryKey(), thanhPhanHoSoChungThuc);

		thanhPhanHoSoChungThuc.resetOriginalValues();
	}

	/**
	 * Caches the thanh phan ho so chung thucs in the entity cache if it is enabled.
	 *
	 * @param thanhPhanHoSoChungThucs the thanh phan ho so chung thucs
	 */
	public void cacheResult(
		List<ThanhPhanHoSoChungThuc> thanhPhanHoSoChungThucs) {
		for (ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc : thanhPhanHoSoChungThucs) {
			if (EntityCacheUtil.getResult(
						ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
						ThanhPhanHoSoChungThucImpl.class,
						thanhPhanHoSoChungThuc.getPrimaryKey()) == null) {
				cacheResult(thanhPhanHoSoChungThuc);
			}
			else {
				thanhPhanHoSoChungThuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all thanh phan ho so chung thucs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ThanhPhanHoSoChungThucImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ThanhPhanHoSoChungThucImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the thanh phan ho so chung thuc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc) {
		EntityCacheUtil.removeResult(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			ThanhPhanHoSoChungThucImpl.class,
			thanhPhanHoSoChungThuc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ThanhPhanHoSoChungThuc> thanhPhanHoSoChungThucs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc : thanhPhanHoSoChungThucs) {
			EntityCacheUtil.removeResult(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
				ThanhPhanHoSoChungThucImpl.class,
				thanhPhanHoSoChungThuc.getPrimaryKey());
		}
	}

	/**
	 * Creates a new thanh phan ho so chung thuc with the primary key. Does not add the thanh phan ho so chung thuc to the database.
	 *
	 * @param thanhPhanHoSoId the primary key for the new thanh phan ho so chung thuc
	 * @return the new thanh phan ho so chung thuc
	 */
	public ThanhPhanHoSoChungThuc create(long thanhPhanHoSoId) {
		ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc = new ThanhPhanHoSoChungThucImpl();

		thanhPhanHoSoChungThuc.setNew(true);
		thanhPhanHoSoChungThuc.setPrimaryKey(thanhPhanHoSoId);

		return thanhPhanHoSoChungThuc;
	}

	/**
	 * Removes the thanh phan ho so chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	 * @return the thanh phan ho so chung thuc that was removed
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a thanh phan ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThanhPhanHoSoChungThuc remove(long thanhPhanHoSoId)
		throws NoSuchThanhPhanHoSoChungThucException, SystemException {
		return remove(Long.valueOf(thanhPhanHoSoId));
	}

	/**
	 * Removes the thanh phan ho so chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thanh phan ho so chung thuc
	 * @return the thanh phan ho so chung thuc that was removed
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a thanh phan ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThanhPhanHoSoChungThuc remove(Serializable primaryKey)
		throws NoSuchThanhPhanHoSoChungThucException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc = (ThanhPhanHoSoChungThuc)session.get(ThanhPhanHoSoChungThucImpl.class,
					primaryKey);

			if (thanhPhanHoSoChungThuc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThanhPhanHoSoChungThucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(thanhPhanHoSoChungThuc);
		}
		catch (NoSuchThanhPhanHoSoChungThucException nsee) {
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
	protected ThanhPhanHoSoChungThuc removeImpl(
		ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws SystemException {
		thanhPhanHoSoChungThuc = toUnwrappedModel(thanhPhanHoSoChungThuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, thanhPhanHoSoChungThuc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(thanhPhanHoSoChungThuc);

		return thanhPhanHoSoChungThuc;
	}

	@Override
	public ThanhPhanHoSoChungThuc updateImpl(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc,
		boolean merge) throws SystemException {
		thanhPhanHoSoChungThuc = toUnwrappedModel(thanhPhanHoSoChungThuc);

		boolean isNew = thanhPhanHoSoChungThuc.isNew();

		ThanhPhanHoSoChungThucModelImpl thanhPhanHoSoChungThucModelImpl = (ThanhPhanHoSoChungThucModelImpl)thanhPhanHoSoChungThuc;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, thanhPhanHoSoChungThuc, merge);

			thanhPhanHoSoChungThuc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ThanhPhanHoSoChungThucModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((thanhPhanHoSoChungThucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOHOSOCHUNGTHUCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(thanhPhanHoSoChungThucModelImpl.getOriginalHoSoChungThucId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOHOSOCHUNGTHUCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOHOSOCHUNGTHUCID,
					args);

				args = new Object[] {
						Long.valueOf(thanhPhanHoSoChungThucModelImpl.getHoSoChungThucId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOHOSOCHUNGTHUCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOHOSOCHUNGTHUCID,
					args);
			}
		}

		EntityCacheUtil.putResult(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			ThanhPhanHoSoChungThucImpl.class,
			thanhPhanHoSoChungThuc.getPrimaryKey(), thanhPhanHoSoChungThuc);

		return thanhPhanHoSoChungThuc;
	}

	protected ThanhPhanHoSoChungThuc toUnwrappedModel(
		ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc) {
		if (thanhPhanHoSoChungThuc instanceof ThanhPhanHoSoChungThucImpl) {
			return thanhPhanHoSoChungThuc;
		}

		ThanhPhanHoSoChungThucImpl thanhPhanHoSoChungThucImpl = new ThanhPhanHoSoChungThucImpl();

		thanhPhanHoSoChungThucImpl.setNew(thanhPhanHoSoChungThuc.isNew());
		thanhPhanHoSoChungThucImpl.setPrimaryKey(thanhPhanHoSoChungThuc.getPrimaryKey());

		thanhPhanHoSoChungThucImpl.setThanhPhanHoSoId(thanhPhanHoSoChungThuc.getThanhPhanHoSoId());
		thanhPhanHoSoChungThucImpl.setTieuDe(thanhPhanHoSoChungThuc.getTieuDe());
		thanhPhanHoSoChungThucImpl.setMoTa(thanhPhanHoSoChungThuc.getMoTa());
		thanhPhanHoSoChungThucImpl.setHoSoChungThucId(thanhPhanHoSoChungThuc.getHoSoChungThucId());
		thanhPhanHoSoChungThucImpl.setThuTuc2GiayToId(thanhPhanHoSoChungThuc.getThuTuc2GiayToId());
		thanhPhanHoSoChungThucImpl.setNoiLuuTruHoSoDinhKemId(thanhPhanHoSoChungThuc.getNoiLuuTruHoSoDinhKemId());

		return thanhPhanHoSoChungThucImpl;
	}

	/**
	 * Returns the thanh phan ho so chung thuc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the thanh phan ho so chung thuc
	 * @return the thanh phan ho so chung thuc
	 * @throws com.liferay.portal.NoSuchModelException if a thanh phan ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThanhPhanHoSoChungThuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the thanh phan ho so chung thuc with the primary key or throws a {@link org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException} if it could not be found.
	 *
	 * @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	 * @return the thanh phan ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a thanh phan ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThanhPhanHoSoChungThuc findByPrimaryKey(long thanhPhanHoSoId)
		throws NoSuchThanhPhanHoSoChungThucException, SystemException {
		ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc = fetchByPrimaryKey(thanhPhanHoSoId);

		if (thanhPhanHoSoChungThuc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + thanhPhanHoSoId);
			}

			throw new NoSuchThanhPhanHoSoChungThucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				thanhPhanHoSoId);
		}

		return thanhPhanHoSoChungThuc;
	}

	/**
	 * Returns the thanh phan ho so chung thuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thanh phan ho so chung thuc
	 * @return the thanh phan ho so chung thuc, or <code>null</code> if a thanh phan ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThanhPhanHoSoChungThuc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the thanh phan ho so chung thuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	 * @return the thanh phan ho so chung thuc, or <code>null</code> if a thanh phan ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThanhPhanHoSoChungThuc fetchByPrimaryKey(long thanhPhanHoSoId)
		throws SystemException {
		ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc = (ThanhPhanHoSoChungThuc)EntityCacheUtil.getResult(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
				ThanhPhanHoSoChungThucImpl.class, thanhPhanHoSoId);

		if (thanhPhanHoSoChungThuc == _nullThanhPhanHoSoChungThuc) {
			return null;
		}

		if (thanhPhanHoSoChungThuc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				thanhPhanHoSoChungThuc = (ThanhPhanHoSoChungThuc)session.get(ThanhPhanHoSoChungThucImpl.class,
						Long.valueOf(thanhPhanHoSoId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (thanhPhanHoSoChungThuc != null) {
					cacheResult(thanhPhanHoSoChungThuc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
						ThanhPhanHoSoChungThucImpl.class, thanhPhanHoSoId,
						_nullThanhPhanHoSoChungThuc);
				}

				closeSession(session);
			}
		}

		return thanhPhanHoSoChungThuc;
	}

	/**
	 * Returns all the thanh phan ho so chung thucs where hoSoChungThucId = &#63;.
	 *
	 * @param hoSoChungThucId the ho so chung thuc ID
	 * @return the matching thanh phan ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThanhPhanHoSoChungThuc> findByTheoHoSoChungThucId(
		Long hoSoChungThucId) throws SystemException {
		return findByTheoHoSoChungThucId(hoSoChungThucId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thanh phan ho so chung thucs where hoSoChungThucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the ho so chung thuc ID
	 * @param start the lower bound of the range of thanh phan ho so chung thucs
	 * @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	 * @return the range of matching thanh phan ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThanhPhanHoSoChungThuc> findByTheoHoSoChungThucId(
		Long hoSoChungThucId, int start, int end) throws SystemException {
		return findByTheoHoSoChungThucId(hoSoChungThucId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the thanh phan ho so chung thucs where hoSoChungThucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the ho so chung thuc ID
	 * @param start the lower bound of the range of thanh phan ho so chung thucs
	 * @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thanh phan ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThanhPhanHoSoChungThuc> findByTheoHoSoChungThucId(
		Long hoSoChungThucId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOHOSOCHUNGTHUCID;
			finderArgs = new Object[] { hoSoChungThucId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOHOSOCHUNGTHUCID;
			finderArgs = new Object[] {
					hoSoChungThucId,
					
					start, end, orderByComparator
				};
		}

		List<ThanhPhanHoSoChungThuc> list = (List<ThanhPhanHoSoChungThuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_THANHPHANHOSOCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_THEOHOSOCHUNGTHUCID_HOSOCHUNGTHUCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ThanhPhanHoSoChungThucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoChungThucId.longValue());

				list = (List<ThanhPhanHoSoChungThuc>)QueryUtil.list(q,
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
	 * Returns the first thanh phan ho so chung thuc in the ordered set where hoSoChungThucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the ho so chung thuc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thanh phan ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a matching thanh phan ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThanhPhanHoSoChungThuc findByTheoHoSoChungThucId_First(
		Long hoSoChungThucId, OrderByComparator orderByComparator)
		throws NoSuchThanhPhanHoSoChungThucException, SystemException {
		List<ThanhPhanHoSoChungThuc> list = findByTheoHoSoChungThucId(hoSoChungThucId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoChungThucId=");
			msg.append(hoSoChungThucId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThanhPhanHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last thanh phan ho so chung thuc in the ordered set where hoSoChungThucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the ho so chung thuc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thanh phan ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a matching thanh phan ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThanhPhanHoSoChungThuc findByTheoHoSoChungThucId_Last(
		Long hoSoChungThucId, OrderByComparator orderByComparator)
		throws NoSuchThanhPhanHoSoChungThucException, SystemException {
		int count = countByTheoHoSoChungThucId(hoSoChungThucId);

		List<ThanhPhanHoSoChungThuc> list = findByTheoHoSoChungThucId(hoSoChungThucId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoChungThucId=");
			msg.append(hoSoChungThucId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThanhPhanHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the thanh phan ho so chung thucs before and after the current thanh phan ho so chung thuc in the ordered set where hoSoChungThucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thanhPhanHoSoId the primary key of the current thanh phan ho so chung thuc
	 * @param hoSoChungThucId the ho so chung thuc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thanh phan ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a thanh phan ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThanhPhanHoSoChungThuc[] findByTheoHoSoChungThucId_PrevAndNext(
		long thanhPhanHoSoId, Long hoSoChungThucId,
		OrderByComparator orderByComparator)
		throws NoSuchThanhPhanHoSoChungThucException, SystemException {
		ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc = findByPrimaryKey(thanhPhanHoSoId);

		Session session = null;

		try {
			session = openSession();

			ThanhPhanHoSoChungThuc[] array = new ThanhPhanHoSoChungThucImpl[3];

			array[0] = getByTheoHoSoChungThucId_PrevAndNext(session,
					thanhPhanHoSoChungThuc, hoSoChungThucId, orderByComparator,
					true);

			array[1] = thanhPhanHoSoChungThuc;

			array[2] = getByTheoHoSoChungThucId_PrevAndNext(session,
					thanhPhanHoSoChungThuc, hoSoChungThucId, orderByComparator,
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

	protected ThanhPhanHoSoChungThuc getByTheoHoSoChungThucId_PrevAndNext(
		Session session, ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc,
		Long hoSoChungThucId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THANHPHANHOSOCHUNGTHUC_WHERE);

		query.append(_FINDER_COLUMN_THEOHOSOCHUNGTHUCID_HOSOCHUNGTHUCID_2);

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
			query.append(ThanhPhanHoSoChungThucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hoSoChungThucId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thanhPhanHoSoChungThuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThanhPhanHoSoChungThuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the thanh phan ho so chung thucs.
	 *
	 * @return the thanh phan ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThanhPhanHoSoChungThuc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thanh phan ho so chung thucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of thanh phan ho so chung thucs
	 * @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	 * @return the range of thanh phan ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThanhPhanHoSoChungThuc> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the thanh phan ho so chung thucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of thanh phan ho so chung thucs
	 * @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thanh phan ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThanhPhanHoSoChungThuc> findAll(int start, int end,
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

		List<ThanhPhanHoSoChungThuc> list = (List<ThanhPhanHoSoChungThuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_THANHPHANHOSOCHUNGTHUC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THANHPHANHOSOCHUNGTHUC.concat(ThanhPhanHoSoChungThucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ThanhPhanHoSoChungThuc>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ThanhPhanHoSoChungThuc>)QueryUtil.list(q,
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
	 * Removes all the thanh phan ho so chung thucs where hoSoChungThucId = &#63; from the database.
	 *
	 * @param hoSoChungThucId the ho so chung thuc ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTheoHoSoChungThucId(Long hoSoChungThucId)
		throws SystemException {
		for (ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc : findByTheoHoSoChungThucId(
				hoSoChungThucId)) {
			remove(thanhPhanHoSoChungThuc);
		}
	}

	/**
	 * Removes all the thanh phan ho so chung thucs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc : findAll()) {
			remove(thanhPhanHoSoChungThuc);
		}
	}

	/**
	 * Returns the number of thanh phan ho so chung thucs where hoSoChungThucId = &#63;.
	 *
	 * @param hoSoChungThucId the ho so chung thuc ID
	 * @return the number of matching thanh phan ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTheoHoSoChungThucId(Long hoSoChungThucId)
		throws SystemException {
		Object[] finderArgs = new Object[] { hoSoChungThucId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THEOHOSOCHUNGTHUCID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THANHPHANHOSOCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_THEOHOSOCHUNGTHUCID_HOSOCHUNGTHUCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoChungThucId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THEOHOSOCHUNGTHUCID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of thanh phan ho so chung thucs.
	 *
	 * @return the number of thanh phan ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THANHPHANHOSOCHUNGTHUC);

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
	 * Initializes the thanh phan ho so chung thuc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ThanhPhanHoSoChungThuc>> listenersList = new ArrayList<ModelListener<ThanhPhanHoSoChungThuc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ThanhPhanHoSoChungThuc>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ThanhPhanHoSoChungThucImpl.class.getName());
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
	private static final String _SQL_SELECT_THANHPHANHOSOCHUNGTHUC = "SELECT thanhPhanHoSoChungThuc FROM ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc";
	private static final String _SQL_SELECT_THANHPHANHOSOCHUNGTHUC_WHERE = "SELECT thanhPhanHoSoChungThuc FROM ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc WHERE ";
	private static final String _SQL_COUNT_THANHPHANHOSOCHUNGTHUC = "SELECT COUNT(thanhPhanHoSoChungThuc) FROM ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc";
	private static final String _SQL_COUNT_THANHPHANHOSOCHUNGTHUC_WHERE = "SELECT COUNT(thanhPhanHoSoChungThuc) FROM ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc WHERE ";
	private static final String _FINDER_COLUMN_THEOHOSOCHUNGTHUCID_HOSOCHUNGTHUCID_2 =
		"thanhPhanHoSoChungThuc.hoSoChungThucId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "thanhPhanHoSoChungThuc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ThanhPhanHoSoChungThuc exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ThanhPhanHoSoChungThuc exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ThanhPhanHoSoChungThucPersistenceImpl.class);
	private static ThanhPhanHoSoChungThuc _nullThanhPhanHoSoChungThuc = new ThanhPhanHoSoChungThucImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ThanhPhanHoSoChungThuc> toCacheModel() {
				return _nullThanhPhanHoSoChungThucCacheModel;
			}
		};

	private static CacheModel<ThanhPhanHoSoChungThuc> _nullThanhPhanHoSoChungThucCacheModel =
		new CacheModel<ThanhPhanHoSoChungThuc>() {
			public ThanhPhanHoSoChungThuc toEntityModel() {
				return _nullThanhPhanHoSoChungThuc;
			}
		};
}