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

package org.oep.cmon.dao.qlhc.service.persistence;

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

import org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the co quan quan ly service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CoQuanQuanLyPersistence
 * @see CoQuanQuanLyUtil
 * @generated
 */
public class CoQuanQuanLyPersistenceImpl extends BasePersistenceImpl<CoQuanQuanLy>
	implements CoQuanQuanLyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CoQuanQuanLyUtil} to access the co quan quan ly persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CoQuanQuanLyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MA = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] { String.class.getName() },
			CoQuanQuanLyModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHA = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCha",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHA = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCha",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CoQuanQuanLyModelImpl.CHAID_COLUMN_BITMASK |
			CoQuanQuanLyModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHA = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCha",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAPCOQUANQUANLY =
		new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCapCoQuanQuanLy",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPCOQUANQUANLY =
		new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCapCoQuanQuanLy",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CoQuanQuanLyModelImpl.CAPCOQUANQUANLYID_COLUMN_BITMASK |
			CoQuanQuanLyModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAPCOQUANQUANLY = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCapCoQuanQuanLy",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DONVIHANHCHINHID =
		new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydonViHanhChinhId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONVIHANHCHINHID =
		new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBydonViHanhChinhId",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CoQuanQuanLyModelImpl.DONVIHANHCHINHID_COLUMN_BITMASK |
			CoQuanQuanLyModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DONVIHANHCHINHID = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydonViHanhChinhId",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the co quan quan ly in the entity cache if it is enabled.
	 *
	 * @param coQuanQuanLy the co quan quan ly
	 */
	public void cacheResult(CoQuanQuanLy coQuanQuanLy) {
		EntityCacheUtil.putResult(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyImpl.class, coQuanQuanLy.getPrimaryKey(), coQuanQuanLy);

		coQuanQuanLy.resetOriginalValues();
	}

	/**
	 * Caches the co quan quan lies in the entity cache if it is enabled.
	 *
	 * @param coQuanQuanLies the co quan quan lies
	 */
	public void cacheResult(List<CoQuanQuanLy> coQuanQuanLies) {
		for (CoQuanQuanLy coQuanQuanLy : coQuanQuanLies) {
			if (EntityCacheUtil.getResult(
						CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
						CoQuanQuanLyImpl.class, coQuanQuanLy.getPrimaryKey()) == null) {
				cacheResult(coQuanQuanLy);
			}
			else {
				coQuanQuanLy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all co quan quan lies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CoQuanQuanLyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CoQuanQuanLyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the co quan quan ly.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CoQuanQuanLy coQuanQuanLy) {
		EntityCacheUtil.removeResult(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyImpl.class, coQuanQuanLy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CoQuanQuanLy> coQuanQuanLies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CoQuanQuanLy coQuanQuanLy : coQuanQuanLies) {
			EntityCacheUtil.removeResult(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
				CoQuanQuanLyImpl.class, coQuanQuanLy.getPrimaryKey());
		}
	}

	/**
	 * Creates a new co quan quan ly with the primary key. Does not add the co quan quan ly to the database.
	 *
	 * @param id the primary key for the new co quan quan ly
	 * @return the new co quan quan ly
	 */
	public CoQuanQuanLy create(long id) {
		CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();

		coQuanQuanLy.setNew(true);
		coQuanQuanLy.setPrimaryKey(id);

		return coQuanQuanLy;
	}

	/**
	 * Removes the co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the co quan quan ly
	 * @return the co quan quan ly that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy remove(long id)
		throws NoSuchCoQuanQuanLyException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the co quan quan ly
	 * @return the co quan quan ly that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanQuanLy remove(Serializable primaryKey)
		throws NoSuchCoQuanQuanLyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CoQuanQuanLy coQuanQuanLy = (CoQuanQuanLy)session.get(CoQuanQuanLyImpl.class,
					primaryKey);

			if (coQuanQuanLy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoQuanQuanLyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coQuanQuanLy);
		}
		catch (NoSuchCoQuanQuanLyException nsee) {
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
	protected CoQuanQuanLy removeImpl(CoQuanQuanLy coQuanQuanLy)
		throws SystemException {
		coQuanQuanLy = toUnwrappedModel(coQuanQuanLy);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, coQuanQuanLy);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(coQuanQuanLy);

		return coQuanQuanLy;
	}

	@Override
	public CoQuanQuanLy updateImpl(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy, boolean merge)
		throws SystemException {
		coQuanQuanLy = toUnwrappedModel(coQuanQuanLy);

		boolean isNew = coQuanQuanLy.isNew();

		CoQuanQuanLyModelImpl coQuanQuanLyModelImpl = (CoQuanQuanLyModelImpl)coQuanQuanLy;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, coQuanQuanLy, merge);

			coQuanQuanLy.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CoQuanQuanLyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((coQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coQuanQuanLyModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);

				args = new Object[] { coQuanQuanLyModelImpl.getMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);
			}

			if ((coQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(coQuanQuanLyModelImpl.getOriginalChaId()),
						Integer.valueOf(coQuanQuanLyModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHA,
					args);

				args = new Object[] {
						Long.valueOf(coQuanQuanLyModelImpl.getChaId()),
						Integer.valueOf(coQuanQuanLyModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHA,
					args);
			}

			if ((coQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPCOQUANQUANLY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(coQuanQuanLyModelImpl.getOriginalCapCoQuanQuanlyId()),
						Integer.valueOf(coQuanQuanLyModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAPCOQUANQUANLY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPCOQUANQUANLY,
					args);

				args = new Object[] {
						Long.valueOf(coQuanQuanLyModelImpl.getCapCoQuanQuanlyId()),
						Integer.valueOf(coQuanQuanLyModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAPCOQUANQUANLY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPCOQUANQUANLY,
					args);
			}

			if ((coQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONVIHANHCHINHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(coQuanQuanLyModelImpl.getOriginalDonViHanhChinhId()),
						Integer.valueOf(coQuanQuanLyModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DONVIHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONVIHANHCHINHID,
					args);

				args = new Object[] {
						Long.valueOf(coQuanQuanLyModelImpl.getDonViHanhChinhId()),
						Integer.valueOf(coQuanQuanLyModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DONVIHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONVIHANHCHINHID,
					args);
			}
		}

		EntityCacheUtil.putResult(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLyImpl.class, coQuanQuanLy.getPrimaryKey(), coQuanQuanLy);

		return coQuanQuanLy;
	}

	protected CoQuanQuanLy toUnwrappedModel(CoQuanQuanLy coQuanQuanLy) {
		if (coQuanQuanLy instanceof CoQuanQuanLyImpl) {
			return coQuanQuanLy;
		}

		CoQuanQuanLyImpl coQuanQuanLyImpl = new CoQuanQuanLyImpl();

		coQuanQuanLyImpl.setNew(coQuanQuanLy.isNew());
		coQuanQuanLyImpl.setPrimaryKey(coQuanQuanLy.getPrimaryKey());

		coQuanQuanLyImpl.setId(coQuanQuanLy.getId());
		coQuanQuanLyImpl.setMa(coQuanQuanLy.getMa());
		coQuanQuanLyImpl.setTen(coQuanQuanLy.getTen());
		coQuanQuanLyImpl.setDiaChi(coQuanQuanLy.getDiaChi());
		coQuanQuanLyImpl.setDienThoai(coQuanQuanLy.getDienThoai());
		coQuanQuanLyImpl.setEmail(coQuanQuanLy.getEmail());
		coQuanQuanLyImpl.setFax(coQuanQuanLy.getFax());
		coQuanQuanLyImpl.setWebsite(coQuanQuanLy.getWebsite());
		coQuanQuanLyImpl.setNoiBo(coQuanQuanLy.getNoiBo());
		coQuanQuanLyImpl.setPhienBan(coQuanQuanLy.getPhienBan());
		coQuanQuanLyImpl.setDaXoa(coQuanQuanLy.getDaXoa());
		coQuanQuanLyImpl.setDonViHanhChinhId(coQuanQuanLy.getDonViHanhChinhId());
		coQuanQuanLyImpl.setCapCoQuanQuanlyId(coQuanQuanLy.getCapCoQuanQuanlyId());
		coQuanQuanLyImpl.setChaId(coQuanQuanLy.getChaId());
		coQuanQuanLyImpl.setNguoiTao(coQuanQuanLy.getNguoiTao());
		coQuanQuanLyImpl.setNgayTao(coQuanQuanLy.getNgayTao());
		coQuanQuanLyImpl.setNguoiSua(coQuanQuanLy.getNguoiSua());
		coQuanQuanLyImpl.setNgaySua(coQuanQuanLy.getNgaySua());
		coQuanQuanLyImpl.setMerchant(coQuanQuanLy.getMerchant());
		coQuanQuanLyImpl.setAccessCode(coQuanQuanLy.getAccessCode());
		coQuanQuanLyImpl.setSecureSecret(coQuanQuanLy.getSecureSecret());
		coQuanQuanLyImpl.setMaCapSoBienNhan(coQuanQuanLy.getMaCapSoBienNhan());

		return coQuanQuanLyImpl;
	}

	/**
	 * Returns the co quan quan ly with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the co quan quan ly
	 * @return the co quan quan ly
	 * @throws com.liferay.portal.NoSuchModelException if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanQuanLy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the co quan quan ly with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException} if it could not be found.
	 *
	 * @param id the primary key of the co quan quan ly
	 * @return the co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy findByPrimaryKey(long id)
		throws NoSuchCoQuanQuanLyException, SystemException {
		CoQuanQuanLy coQuanQuanLy = fetchByPrimaryKey(id);

		if (coQuanQuanLy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCoQuanQuanLyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return coQuanQuanLy;
	}

	/**
	 * Returns the co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the co quan quan ly
	 * @return the co quan quan ly, or <code>null</code> if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanQuanLy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the co quan quan ly
	 * @return the co quan quan ly, or <code>null</code> if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy fetchByPrimaryKey(long id) throws SystemException {
		CoQuanQuanLy coQuanQuanLy = (CoQuanQuanLy)EntityCacheUtil.getResult(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
				CoQuanQuanLyImpl.class, id);

		if (coQuanQuanLy == _nullCoQuanQuanLy) {
			return null;
		}

		if (coQuanQuanLy == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				coQuanQuanLy = (CoQuanQuanLy)session.get(CoQuanQuanLyImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (coQuanQuanLy != null) {
					cacheResult(coQuanQuanLy);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
						CoQuanQuanLyImpl.class, id, _nullCoQuanQuanLy);
				}

				closeSession(session);
			}
		}

		return coQuanQuanLy;
	}

	/**
	 * Returns all the co quan quan lies where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findByMa(String ma) throws SystemException {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan quan lies where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @return the range of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findByMa(String ma, int start, int end)
		throws SystemException {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan quan lies where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findByMa(String ma, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA;
			finderArgs = new Object[] { ma };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MA;
			finderArgs = new Object[] { ma, start, end, orderByComparator };
		}

		List<CoQuanQuanLy> list = (List<CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_COQUANQUANLY_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MA_MA_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				list = (List<CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first co quan quan ly in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy findByMa_First(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		List<CoQuanQuanLy> list = findByMa(ma, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last co quan quan ly in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy findByMa_Last(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		int count = countByMa(ma);

		List<CoQuanQuanLy> list = findByMa(ma, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current co quan quan ly
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy[] findByMa_PrevAndNext(long id, String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		CoQuanQuanLy coQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CoQuanQuanLy[] array = new CoQuanQuanLyImpl[3];

			array[0] = getByMa_PrevAndNext(session, coQuanQuanLy, ma,
					orderByComparator, true);

			array[1] = coQuanQuanLy;

			array[2] = getByMa_PrevAndNext(session, coQuanQuanLy, ma,
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

	protected CoQuanQuanLy getByMa_PrevAndNext(Session session,
		CoQuanQuanLy coQuanQuanLy, String ma,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COQUANQUANLY_WHERE);

		if (ma == null) {
			query.append(_FINDER_COLUMN_MA_MA_1);
		}
		else {
			if (ma.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MA_MA_3);
			}
			else {
				query.append(_FINDER_COLUMN_MA_MA_2);
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
			query.append(CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (ma != null) {
			qPos.add(ma);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the co quan quan lies where chaId = &#63; and daXoa = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @return the matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findByCha(Long chaId, int daXoa)
		throws SystemException {
		return findByCha(chaId, daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the co quan quan lies where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @return the range of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findByCha(Long chaId, int daXoa, int start,
		int end) throws SystemException {
		return findByCha(chaId, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan quan lies where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findByCha(Long chaId, int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHA;
			finderArgs = new Object[] { chaId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHA;
			finderArgs = new Object[] {
					chaId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<CoQuanQuanLy> list = (List<CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_CHA_CHAID_2);

			query.append(_FINDER_COLUMN_CHA_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId.longValue());

				qPos.add(daXoa);

				list = (List<CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first co quan quan ly in the ordered set where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy findByCha_First(Long chaId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		List<CoQuanQuanLy> list = findByCha(chaId, daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chaId=");
			msg.append(chaId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last co quan quan ly in the ordered set where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy findByCha_Last(Long chaId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		int count = countByCha(chaId, daXoa);

		List<CoQuanQuanLy> list = findByCha(chaId, daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chaId=");
			msg.append(chaId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current co quan quan ly
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy[] findByCha_PrevAndNext(long id, Long chaId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		CoQuanQuanLy coQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CoQuanQuanLy[] array = new CoQuanQuanLyImpl[3];

			array[0] = getByCha_PrevAndNext(session, coQuanQuanLy, chaId,
					daXoa, orderByComparator, true);

			array[1] = coQuanQuanLy;

			array[2] = getByCha_PrevAndNext(session, coQuanQuanLy, chaId,
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

	protected CoQuanQuanLy getByCha_PrevAndNext(Session session,
		CoQuanQuanLy coQuanQuanLy, Long chaId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COQUANQUANLY_WHERE);

		query.append(_FINDER_COLUMN_CHA_CHAID_2);

		query.append(_FINDER_COLUMN_CHA_DAXOA_2);

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
			query.append(CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chaId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	 *
	 * @param capCoQuanQuanlyId the cap co quan quanly ID
	 * @param daXoa the da xoa
	 * @return the matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findByCapCoQuanQuanLy(Long capCoQuanQuanlyId,
		int daXoa) throws SystemException {
		return findByCapCoQuanQuanLy(capCoQuanQuanlyId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param capCoQuanQuanlyId the cap co quan quanly ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @return the range of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findByCapCoQuanQuanLy(Long capCoQuanQuanlyId,
		int daXoa, int start, int end) throws SystemException {
		return findByCapCoQuanQuanLy(capCoQuanQuanlyId, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param capCoQuanQuanlyId the cap co quan quanly ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findByCapCoQuanQuanLy(Long capCoQuanQuanlyId,
		int daXoa, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPCOQUANQUANLY;
			finderArgs = new Object[] { capCoQuanQuanlyId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAPCOQUANQUANLY;
			finderArgs = new Object[] {
					capCoQuanQuanlyId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<CoQuanQuanLy> list = (List<CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_CAPCOQUANQUANLY_CAPCOQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_CAPCOQUANQUANLY_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(capCoQuanQuanlyId.longValue());

				qPos.add(daXoa);

				list = (List<CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first co quan quan ly in the ordered set where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param capCoQuanQuanlyId the cap co quan quanly ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy findByCapCoQuanQuanLy_First(Long capCoQuanQuanlyId,
		int daXoa, OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		List<CoQuanQuanLy> list = findByCapCoQuanQuanLy(capCoQuanQuanlyId,
				daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("capCoQuanQuanlyId=");
			msg.append(capCoQuanQuanlyId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last co quan quan ly in the ordered set where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param capCoQuanQuanlyId the cap co quan quanly ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy findByCapCoQuanQuanLy_Last(Long capCoQuanQuanlyId,
		int daXoa, OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		int count = countByCapCoQuanQuanLy(capCoQuanQuanlyId, daXoa);

		List<CoQuanQuanLy> list = findByCapCoQuanQuanLy(capCoQuanQuanlyId,
				daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("capCoQuanQuanlyId=");
			msg.append(capCoQuanQuanlyId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current co quan quan ly
	 * @param capCoQuanQuanlyId the cap co quan quanly ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy[] findByCapCoQuanQuanLy_PrevAndNext(long id,
		Long capCoQuanQuanlyId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		CoQuanQuanLy coQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CoQuanQuanLy[] array = new CoQuanQuanLyImpl[3];

			array[0] = getByCapCoQuanQuanLy_PrevAndNext(session, coQuanQuanLy,
					capCoQuanQuanlyId, daXoa, orderByComparator, true);

			array[1] = coQuanQuanLy;

			array[2] = getByCapCoQuanQuanLy_PrevAndNext(session, coQuanQuanLy,
					capCoQuanQuanlyId, daXoa, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CoQuanQuanLy getByCapCoQuanQuanLy_PrevAndNext(Session session,
		CoQuanQuanLy coQuanQuanLy, Long capCoQuanQuanlyId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COQUANQUANLY_WHERE);

		query.append(_FINDER_COLUMN_CAPCOQUANQUANLY_CAPCOQUANQUANLYID_2);

		query.append(_FINDER_COLUMN_CAPCOQUANQUANLY_DAXOA_2);

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
			query.append(CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(capCoQuanQuanlyId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param donViHanhChinhId the don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findBydonViHanhChinhId(Long donViHanhChinhId,
		int daXoa) throws SystemException {
		return findBydonViHanhChinhId(donViHanhChinhId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param donViHanhChinhId the don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @return the range of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findBydonViHanhChinhId(Long donViHanhChinhId,
		int daXoa, int start, int end) throws SystemException {
		return findBydonViHanhChinhId(donViHanhChinhId, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param donViHanhChinhId the don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findBydonViHanhChinhId(Long donViHanhChinhId,
		int daXoa, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONVIHANHCHINHID;
			finderArgs = new Object[] { donViHanhChinhId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DONVIHANHCHINHID;
			finderArgs = new Object[] {
					donViHanhChinhId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<CoQuanQuanLy> list = (List<CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_DONVIHANHCHINHID_DONVIHANHCHINHID_2);

			query.append(_FINDER_COLUMN_DONVIHANHCHINHID_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(donViHanhChinhId.longValue());

				qPos.add(daXoa);

				list = (List<CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first co quan quan ly in the ordered set where donViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param donViHanhChinhId the don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy findBydonViHanhChinhId_First(Long donViHanhChinhId,
		int daXoa, OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		List<CoQuanQuanLy> list = findBydonViHanhChinhId(donViHanhChinhId,
				daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("donViHanhChinhId=");
			msg.append(donViHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last co quan quan ly in the ordered set where donViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param donViHanhChinhId the don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy findBydonViHanhChinhId_Last(Long donViHanhChinhId,
		int daXoa, OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		int count = countBydonViHanhChinhId(donViHanhChinhId, daXoa);

		List<CoQuanQuanLy> list = findBydonViHanhChinhId(donViHanhChinhId,
				daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("donViHanhChinhId=");
			msg.append(donViHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where donViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current co quan quan ly
	 * @param donViHanhChinhId the don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy[] findBydonViHanhChinhId_PrevAndNext(long id,
		Long donViHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchCoQuanQuanLyException, SystemException {
		CoQuanQuanLy coQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CoQuanQuanLy[] array = new CoQuanQuanLyImpl[3];

			array[0] = getBydonViHanhChinhId_PrevAndNext(session, coQuanQuanLy,
					donViHanhChinhId, daXoa, orderByComparator, true);

			array[1] = coQuanQuanLy;

			array[2] = getBydonViHanhChinhId_PrevAndNext(session, coQuanQuanLy,
					donViHanhChinhId, daXoa, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CoQuanQuanLy getBydonViHanhChinhId_PrevAndNext(Session session,
		CoQuanQuanLy coQuanQuanLy, Long donViHanhChinhId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COQUANQUANLY_WHERE);

		query.append(_FINDER_COLUMN_DONVIHANHCHINHID_DONVIHANHCHINHID_2);

		query.append(_FINDER_COLUMN_DONVIHANHCHINHID_DAXOA_2);

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
			query.append(CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(donViHanhChinhId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the co quan quan lies.
	 *
	 * @return the co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan quan lies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @return the range of co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan quan lies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of co quan quan lies
	 * @param end the upper bound of the range of co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy> findAll(int start, int end,
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

		List<CoQuanQuanLy> list = (List<CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COQUANQUANLY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COQUANQUANLY.concat(CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the co quan quan lies where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma) throws SystemException {
		for (CoQuanQuanLy coQuanQuanLy : findByMa(ma)) {
			remove(coQuanQuanLy);
		}
	}

	/**
	 * Removes all the co quan quan lies where chaId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCha(Long chaId, int daXoa) throws SystemException {
		for (CoQuanQuanLy coQuanQuanLy : findByCha(chaId, daXoa)) {
			remove(coQuanQuanLy);
		}
	}

	/**
	 * Removes all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param capCoQuanQuanlyId the cap co quan quanly ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCapCoQuanQuanLy(Long capCoQuanQuanlyId, int daXoa)
		throws SystemException {
		for (CoQuanQuanLy coQuanQuanLy : findByCapCoQuanQuanLy(
				capCoQuanQuanlyId, daXoa)) {
			remove(coQuanQuanLy);
		}
	}

	/**
	 * Removes all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param donViHanhChinhId the don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBydonViHanhChinhId(Long donViHanhChinhId, int daXoa)
		throws SystemException {
		for (CoQuanQuanLy coQuanQuanLy : findBydonViHanhChinhId(
				donViHanhChinhId, daXoa)) {
			remove(coQuanQuanLy);
		}
	}

	/**
	 * Removes all the co quan quan lies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CoQuanQuanLy coQuanQuanLy : findAll()) {
			remove(coQuanQuanLy);
		}
	}

	/**
	 * Returns the number of co quan quan lies where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COQUANQUANLY_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MA_MA_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MA, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of co quan quan lies where chaId = &#63; and daXoa = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @return the number of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCha(Long chaId, int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { chaId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CHA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_CHA_CHAID_2);

			query.append(_FINDER_COLUMN_CHA_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHA, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	 *
	 * @param capCoQuanQuanlyId the cap co quan quanly ID
	 * @param daXoa the da xoa
	 * @return the number of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCapCoQuanQuanLy(Long capCoQuanQuanlyId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { capCoQuanQuanlyId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAPCOQUANQUANLY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_CAPCOQUANQUANLY_CAPCOQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_CAPCOQUANQUANLY_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(capCoQuanQuanlyId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAPCOQUANQUANLY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param donViHanhChinhId the don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the number of matching co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countBydonViHanhChinhId(Long donViHanhChinhId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { donViHanhChinhId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DONVIHANHCHINHID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_DONVIHANHCHINHID_DONVIHANHCHINHID_2);

			query.append(_FINDER_COLUMN_DONVIHANHCHINHID_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(donViHanhChinhId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DONVIHANHCHINHID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of co quan quan lies.
	 *
	 * @return the number of co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COQUANQUANLY);

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
	 * Initializes the co quan quan ly persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.qlhc.model.CoQuanQuanLy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CoQuanQuanLy>> listenersList = new ArrayList<ModelListener<CoQuanQuanLy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CoQuanQuanLy>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CoQuanQuanLyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CapCoQuanQuanLyPersistence.class)
	protected CapCoQuanQuanLyPersistence capCoQuanQuanLyPersistence;
	@BeanReference(type = CapDonViHanhChinhPersistence.class)
	protected CapDonViHanhChinhPersistence capDonViHanhChinhPersistence;
	@BeanReference(type = ChucVu2VaiTroPersistence.class)
	protected ChucVu2VaiTroPersistence chucVu2VaiTroPersistence;
	@BeanReference(type = CoQuanHanhChinhSuNghiepPersistence.class)
	protected CoQuanHanhChinhSuNghiepPersistence coQuanHanhChinhSuNghiepPersistence;
	@BeanReference(type = CoQuanQuanLyPersistence.class)
	protected CoQuanQuanLyPersistence coQuanQuanLyPersistence;
	@BeanReference(type = DonViHanhChinhPersistence.class)
	protected DonViHanhChinhPersistence donViHanhChinhPersistence;
	@BeanReference(type = QuocGiaPersistence.class)
	protected QuocGiaPersistence quocGiaPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_COQUANQUANLY = "SELECT coQuanQuanLy FROM CoQuanQuanLy coQuanQuanLy";
	private static final String _SQL_SELECT_COQUANQUANLY_WHERE = "SELECT coQuanQuanLy FROM CoQuanQuanLy coQuanQuanLy WHERE ";
	private static final String _SQL_COUNT_COQUANQUANLY = "SELECT COUNT(coQuanQuanLy) FROM CoQuanQuanLy coQuanQuanLy";
	private static final String _SQL_COUNT_COQUANQUANLY_WHERE = "SELECT COUNT(coQuanQuanLy) FROM CoQuanQuanLy coQuanQuanLy WHERE ";
	private static final String _FINDER_COLUMN_MA_MA_1 = "coQuanQuanLy.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "coQuanQuanLy.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(coQuanQuanLy.ma IS NULL OR coQuanQuanLy.ma = ?)";
	private static final String _FINDER_COLUMN_CHA_CHAID_2 = "coQuanQuanLy.chaId = ? AND ";
	private static final String _FINDER_COLUMN_CHA_DAXOA_2 = "coQuanQuanLy.daXoa = ?";
	private static final String _FINDER_COLUMN_CAPCOQUANQUANLY_CAPCOQUANQUANLYID_2 =
		"coQuanQuanLy.capCoQuanQuanlyId = ? AND ";
	private static final String _FINDER_COLUMN_CAPCOQUANQUANLY_DAXOA_2 = "coQuanQuanLy.daXoa = ?";
	private static final String _FINDER_COLUMN_DONVIHANHCHINHID_DONVIHANHCHINHID_2 =
		"coQuanQuanLy.donViHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_DONVIHANHCHINHID_DAXOA_2 = "coQuanQuanLy.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coQuanQuanLy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CoQuanQuanLy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CoQuanQuanLy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CoQuanQuanLyPersistenceImpl.class);
	private static CoQuanQuanLy _nullCoQuanQuanLy = new CoQuanQuanLyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CoQuanQuanLy> toCacheModel() {
				return _nullCoQuanQuanLyCacheModel;
			}
		};

	private static CacheModel<CoQuanQuanLy> _nullCoQuanQuanLyCacheModel = new CacheModel<CoQuanQuanLy>() {
			public CoQuanQuanLy toEntityModel() {
				return _nullCoQuanQuanLy;
			}
		};
}