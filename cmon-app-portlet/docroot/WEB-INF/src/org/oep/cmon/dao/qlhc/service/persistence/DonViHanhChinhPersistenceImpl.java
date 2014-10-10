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

import org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.model.impl.DonViHanhChinhImpl;
import org.oep.cmon.dao.qlhc.model.impl.DonViHanhChinhModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the don vi hanh chinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see DonViHanhChinhPersistence
 * @see DonViHanhChinhUtil
 * @generated
 */
public class DonViHanhChinhPersistenceImpl extends BasePersistenceImpl<DonViHanhChinh>
	implements DonViHanhChinhPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DonViHanhChinhUtil} to access the don vi hanh chinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DonViHanhChinhImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MA = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] { String.class.getName() },
			DonViHanhChinhModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTen",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] { String.class.getName() },
			DonViHanhChinhModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAPDONVIHANHCHINHID =
		new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCapDonViHanhChinhId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPDONVIHANHCHINHID =
		new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCapDonViHanhChinhId",
			new String[] { Long.class.getName(), Integer.class.getName() },
			DonViHanhChinhModelImpl.CAPDONVIHANHCHINHID_COLUMN_BITMASK |
			DonViHanhChinhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAPDONVIHANHCHINHID = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCapDonViHanhChinhId",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHAID = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByChaId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAID = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChaId",
			new String[] { Long.class.getName(), Integer.class.getName() },
			DonViHanhChinhModelImpl.CHAID_COLUMN_BITMASK |
			DonViHanhChinhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHAID = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChaId",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUOCGIAID =
		new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByQuocGiaId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUOCGIAID =
		new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuocGiaId",
			new String[] { Long.class.getName() },
			DonViHanhChinhModelImpl.QUOCGIAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUOCGIAID = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuocGiaId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			DonViHanhChinhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MADVHC = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMaDVHC", new String[] { String.class.getName() },
			DonViHanhChinhModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MADVHC = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaDVHC",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_TENDVHC = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTenDVHC", new String[] { String.class.getName() },
			DonViHanhChinhModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TENDVHC = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTenDVHC",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYQUOCID = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByByQuocId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYQUOCID =
		new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByQuocId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			DonViHanhChinhModelImpl.QUOCGIAID_COLUMN_BITMASK |
			DonViHanhChinhModelImpl.CAPDONVIHANHCHINHID_COLUMN_BITMASK |
			DonViHanhChinhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYQUOCID = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByQuocId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			DonViHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the don vi hanh chinh in the entity cache if it is enabled.
	 *
	 * @param donViHanhChinh the don vi hanh chinh
	 */
	public void cacheResult(DonViHanhChinh donViHanhChinh) {
		EntityCacheUtil.putResult(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhImpl.class, donViHanhChinh.getPrimaryKey(),
			donViHanhChinh);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADVHC,
			new Object[] { donViHanhChinh.getMa() }, donViHanhChinh);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDVHC,
			new Object[] { donViHanhChinh.getTen() }, donViHanhChinh);

		donViHanhChinh.resetOriginalValues();
	}

	/**
	 * Caches the don vi hanh chinhs in the entity cache if it is enabled.
	 *
	 * @param donViHanhChinhs the don vi hanh chinhs
	 */
	public void cacheResult(List<DonViHanhChinh> donViHanhChinhs) {
		for (DonViHanhChinh donViHanhChinh : donViHanhChinhs) {
			if (EntityCacheUtil.getResult(
						DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
						DonViHanhChinhImpl.class, donViHanhChinh.getPrimaryKey()) == null) {
				cacheResult(donViHanhChinh);
			}
			else {
				donViHanhChinh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all don vi hanh chinhs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DonViHanhChinhImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DonViHanhChinhImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the don vi hanh chinh.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DonViHanhChinh donViHanhChinh) {
		EntityCacheUtil.removeResult(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhImpl.class, donViHanhChinh.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(donViHanhChinh);
	}

	@Override
	public void clearCache(List<DonViHanhChinh> donViHanhChinhs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DonViHanhChinh donViHanhChinh : donViHanhChinhs) {
			EntityCacheUtil.removeResult(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				DonViHanhChinhImpl.class, donViHanhChinh.getPrimaryKey());

			clearUniqueFindersCache(donViHanhChinh);
		}
	}

	protected void clearUniqueFindersCache(DonViHanhChinh donViHanhChinh) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MADVHC,
			new Object[] { donViHanhChinh.getMa() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TENDVHC,
			new Object[] { donViHanhChinh.getTen() });
	}

	/**
	 * Creates a new don vi hanh chinh with the primary key. Does not add the don vi hanh chinh to the database.
	 *
	 * @param id the primary key for the new don vi hanh chinh
	 * @return the new don vi hanh chinh
	 */
	public DonViHanhChinh create(long id) {
		DonViHanhChinh donViHanhChinh = new DonViHanhChinhImpl();

		donViHanhChinh.setNew(true);
		donViHanhChinh.setPrimaryKey(id);

		return donViHanhChinh;
	}

	/**
	 * Removes the don vi hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the don vi hanh chinh
	 * @return the don vi hanh chinh that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh remove(long id)
		throws NoSuchDonViHanhChinhException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the don vi hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the don vi hanh chinh
	 * @return the don vi hanh chinh that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DonViHanhChinh remove(Serializable primaryKey)
		throws NoSuchDonViHanhChinhException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DonViHanhChinh donViHanhChinh = (DonViHanhChinh)session.get(DonViHanhChinhImpl.class,
					primaryKey);

			if (donViHanhChinh == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDonViHanhChinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(donViHanhChinh);
		}
		catch (NoSuchDonViHanhChinhException nsee) {
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
	protected DonViHanhChinh removeImpl(DonViHanhChinh donViHanhChinh)
		throws SystemException {
		donViHanhChinh = toUnwrappedModel(donViHanhChinh);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, donViHanhChinh);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(donViHanhChinh);

		return donViHanhChinh;
	}

	@Override
	public DonViHanhChinh updateImpl(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh, boolean merge)
		throws SystemException {
		donViHanhChinh = toUnwrappedModel(donViHanhChinh);

		boolean isNew = donViHanhChinh.isNew();

		DonViHanhChinhModelImpl donViHanhChinhModelImpl = (DonViHanhChinhModelImpl)donViHanhChinh;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, donViHanhChinh, merge);

			donViHanhChinh.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DonViHanhChinhModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((donViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						donViHanhChinhModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);

				args = new Object[] { donViHanhChinhModelImpl.getMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);
			}

			if ((donViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						donViHanhChinhModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] { donViHanhChinhModelImpl.getTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}

			if ((donViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPDONVIHANHCHINHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(donViHanhChinhModelImpl.getOriginalCapDonViHanhChinhId()),
						Integer.valueOf(donViHanhChinhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAPDONVIHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPDONVIHANHCHINHID,
					args);

				args = new Object[] {
						Long.valueOf(donViHanhChinhModelImpl.getCapDonViHanhChinhId()),
						Integer.valueOf(donViHanhChinhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAPDONVIHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPDONVIHANHCHINHID,
					args);
			}

			if ((donViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(donViHanhChinhModelImpl.getOriginalChaId()),
						Integer.valueOf(donViHanhChinhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAID,
					args);

				args = new Object[] {
						Long.valueOf(donViHanhChinhModelImpl.getChaId()),
						Integer.valueOf(donViHanhChinhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAID,
					args);
			}

			if ((donViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUOCGIAID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(donViHanhChinhModelImpl.getOriginalQuocGiaId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUOCGIAID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUOCGIAID,
					args);

				args = new Object[] {
						Long.valueOf(donViHanhChinhModelImpl.getQuocGiaId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUOCGIAID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUOCGIAID,
					args);
			}

			if ((donViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(donViHanhChinhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(donViHanhChinhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((donViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYQUOCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(donViHanhChinhModelImpl.getOriginalQuocGiaId()),
						Long.valueOf(donViHanhChinhModelImpl.getOriginalCapDonViHanhChinhId()),
						Integer.valueOf(donViHanhChinhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYQUOCID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYQUOCID,
					args);

				args = new Object[] {
						Long.valueOf(donViHanhChinhModelImpl.getQuocGiaId()),
						Long.valueOf(donViHanhChinhModelImpl.getCapDonViHanhChinhId()),
						Integer.valueOf(donViHanhChinhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYQUOCID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYQUOCID,
					args);
			}
		}

		EntityCacheUtil.putResult(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			DonViHanhChinhImpl.class, donViHanhChinh.getPrimaryKey(),
			donViHanhChinh);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADVHC,
				new Object[] { donViHanhChinh.getMa() }, donViHanhChinh);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDVHC,
				new Object[] { donViHanhChinh.getTen() }, donViHanhChinh);
		}
		else {
			if ((donViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MADVHC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						donViHanhChinhModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MADVHC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MADVHC, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADVHC,
					new Object[] { donViHanhChinh.getMa() }, donViHanhChinh);
			}

			if ((donViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TENDVHC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						donViHanhChinhModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENDVHC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TENDVHC, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDVHC,
					new Object[] { donViHanhChinh.getTen() }, donViHanhChinh);
			}
		}

		return donViHanhChinh;
	}

	protected DonViHanhChinh toUnwrappedModel(DonViHanhChinh donViHanhChinh) {
		if (donViHanhChinh instanceof DonViHanhChinhImpl) {
			return donViHanhChinh;
		}

		DonViHanhChinhImpl donViHanhChinhImpl = new DonViHanhChinhImpl();

		donViHanhChinhImpl.setNew(donViHanhChinh.isNew());
		donViHanhChinhImpl.setPrimaryKey(donViHanhChinh.getPrimaryKey());

		donViHanhChinhImpl.setId(donViHanhChinh.getId());
		donViHanhChinhImpl.setMa(donViHanhChinh.getMa());
		donViHanhChinhImpl.setTen(donViHanhChinh.getTen());
		donViHanhChinhImpl.setNgayTao(donViHanhChinh.getNgayTao());
		donViHanhChinhImpl.setPhienBan(donViHanhChinh.getPhienBan());
		donViHanhChinhImpl.setDaXoa(donViHanhChinh.getDaXoa());
		donViHanhChinhImpl.setNgaySua(donViHanhChinh.getNgaySua());
		donViHanhChinhImpl.setCapDonViHanhChinhId(donViHanhChinh.getCapDonViHanhChinhId());
		donViHanhChinhImpl.setChaId(donViHanhChinh.getChaId());
		donViHanhChinhImpl.setNguoiTao(donViHanhChinh.getNguoiTao());
		donViHanhChinhImpl.setQuocGiaId(donViHanhChinh.getQuocGiaId());
		donViHanhChinhImpl.setNguoiSua(donViHanhChinh.getNguoiSua());

		return donViHanhChinhImpl;
	}

	/**
	 * Returns the don vi hanh chinh with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the don vi hanh chinh
	 * @return the don vi hanh chinh
	 * @throws com.liferay.portal.NoSuchModelException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DonViHanhChinh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the don vi hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException} if it could not be found.
	 *
	 * @param id the primary key of the don vi hanh chinh
	 * @return the don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByPrimaryKey(long id)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = fetchByPrimaryKey(id);

		if (donViHanhChinh == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDonViHanhChinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return donViHanhChinh;
	}

	/**
	 * Returns the don vi hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the don vi hanh chinh
	 * @return the don vi hanh chinh, or <code>null</code> if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DonViHanhChinh fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the don vi hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the don vi hanh chinh
	 * @return the don vi hanh chinh, or <code>null</code> if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh fetchByPrimaryKey(long id) throws SystemException {
		DonViHanhChinh donViHanhChinh = (DonViHanhChinh)EntityCacheUtil.getResult(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				DonViHanhChinhImpl.class, id);

		if (donViHanhChinh == _nullDonViHanhChinh) {
			return null;
		}

		if (donViHanhChinh == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				donViHanhChinh = (DonViHanhChinh)session.get(DonViHanhChinhImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (donViHanhChinh != null) {
					cacheResult(donViHanhChinh);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
						DonViHanhChinhImpl.class, id, _nullDonViHanhChinh);
				}

				closeSession(session);
			}
		}

		return donViHanhChinh;
	}

	/**
	 * Returns all the don vi hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByMa(String ma) throws SystemException {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the don vi hanh chinhs where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @return the range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByMa(String ma, int start, int end)
		throws SystemException {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the don vi hanh chinhs where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByMa(String ma, int start, int end,
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

		List<DonViHanhChinh> list = (List<DonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

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
				query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
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

				list = (List<DonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first don vi hanh chinh in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByMa_First(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		List<DonViHanhChinh> list = findByMa(ma, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last don vi hanh chinh in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByMa_Last(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		int count = countByMa(ma);

		List<DonViHanhChinh> list = findByMa(ma, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current don vi hanh chinh
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh[] findByMa_PrevAndNext(long id, String ma,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DonViHanhChinh[] array = new DonViHanhChinhImpl[3];

			array[0] = getByMa_PrevAndNext(session, donViHanhChinh, ma,
					orderByComparator, true);

			array[1] = donViHanhChinh;

			array[2] = getByMa_PrevAndNext(session, donViHanhChinh, ma,
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

	protected DonViHanhChinh getByMa_PrevAndNext(Session session,
		DonViHanhChinh donViHanhChinh, String ma,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

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
			query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(donViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the don vi hanh chinhs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByTen(String ten) throws SystemException {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the don vi hanh chinhs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @return the range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByTen(String ten, int start, int end)
		throws SystemException {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the don vi hanh chinhs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByTen(String ten, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN;
			finderArgs = new Object[] { ten };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN;
			finderArgs = new Object[] { ten, start, end, orderByComparator };
		}

		List<DonViHanhChinh> list = (List<DonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_TEN_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				list = (List<DonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first don vi hanh chinh in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByTen_First(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		List<DonViHanhChinh> list = findByTen(ten, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last don vi hanh chinh in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByTen_Last(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		int count = countByTen(ten);

		List<DonViHanhChinh> list = findByTen(ten, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current don vi hanh chinh
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh[] findByTen_PrevAndNext(long id, String ten,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DonViHanhChinh[] array = new DonViHanhChinhImpl[3];

			array[0] = getByTen_PrevAndNext(session, donViHanhChinh, ten,
					orderByComparator, true);

			array[1] = donViHanhChinh;

			array[2] = getByTen_PrevAndNext(session, donViHanhChinh, ten,
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

	protected DonViHanhChinh getByTen_PrevAndNext(Session session,
		DonViHanhChinh donViHanhChinh, String ten,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

		if (ten == null) {
			query.append(_FINDER_COLUMN_TEN_TEN_1);
		}
		else {
			if (ten.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEN_TEN_3);
			}
			else {
				query.append(_FINDER_COLUMN_TEN_TEN_2);
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
			query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (ten != null) {
			qPos.add(ten);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(donViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByCapDonViHanhChinhId(
		long capDonViHanhChinhId, int daXoa) throws SystemException {
		return findByCapDonViHanhChinhId(capDonViHanhChinhId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @return the range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByCapDonViHanhChinhId(
		long capDonViHanhChinhId, int daXoa, int start, int end)
		throws SystemException {
		return findByCapDonViHanhChinhId(capDonViHanhChinhId, daXoa, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByCapDonViHanhChinhId(
		long capDonViHanhChinhId, int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAPDONVIHANHCHINHID;
			finderArgs = new Object[] { capDonViHanhChinhId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAPDONVIHANHCHINHID;
			finderArgs = new Object[] {
					capDonViHanhChinhId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<DonViHanhChinh> list = (List<DonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_CAPDONVIHANHCHINHID_CAPDONVIHANHCHINHID_2);

			query.append(_FINDER_COLUMN_CAPDONVIHANHCHINHID_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(capDonViHanhChinhId);

				qPos.add(daXoa);

				list = (List<DonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first don vi hanh chinh in the ordered set where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByCapDonViHanhChinhId_First(
		long capDonViHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		List<DonViHanhChinh> list = findByCapDonViHanhChinhId(capDonViHanhChinhId,
				daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("capDonViHanhChinhId=");
			msg.append(capDonViHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last don vi hanh chinh in the ordered set where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByCapDonViHanhChinhId_Last(
		long capDonViHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		int count = countByCapDonViHanhChinhId(capDonViHanhChinhId, daXoa);

		List<DonViHanhChinh> list = findByCapDonViHanhChinhId(capDonViHanhChinhId,
				daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("capDonViHanhChinhId=");
			msg.append(capDonViHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current don vi hanh chinh
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh[] findByCapDonViHanhChinhId_PrevAndNext(long id,
		long capDonViHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DonViHanhChinh[] array = new DonViHanhChinhImpl[3];

			array[0] = getByCapDonViHanhChinhId_PrevAndNext(session,
					donViHanhChinh, capDonViHanhChinhId, daXoa,
					orderByComparator, true);

			array[1] = donViHanhChinh;

			array[2] = getByCapDonViHanhChinhId_PrevAndNext(session,
					donViHanhChinh, capDonViHanhChinhId, daXoa,
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

	protected DonViHanhChinh getByCapDonViHanhChinhId_PrevAndNext(
		Session session, DonViHanhChinh donViHanhChinh,
		long capDonViHanhChinhId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

		query.append(_FINDER_COLUMN_CAPDONVIHANHCHINHID_CAPDONVIHANHCHINHID_2);

		query.append(_FINDER_COLUMN_CAPDONVIHANHCHINHID_DAXOA_2);

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
			query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(capDonViHanhChinhId);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(donViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @return the matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByChaId(Long chaId, int daXoa)
		throws SystemException {
		return findByChaId(chaId, daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @return the range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByChaId(Long chaId, int daXoa, int start,
		int end) throws SystemException {
		return findByChaId(chaId, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByChaId(Long chaId, int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAID;
			finderArgs = new Object[] { chaId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHAID;
			finderArgs = new Object[] {
					chaId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<DonViHanhChinh> list = (List<DonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_CHAID_CHAID_2);

			query.append(_FINDER_COLUMN_CHAID_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId.longValue());

				qPos.add(daXoa);

				list = (List<DonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first don vi hanh chinh in the ordered set where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByChaId_First(Long chaId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		List<DonViHanhChinh> list = findByChaId(chaId, daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chaId=");
			msg.append(chaId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last don vi hanh chinh in the ordered set where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByChaId_Last(Long chaId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		int count = countByChaId(chaId, daXoa);

		List<DonViHanhChinh> list = findByChaId(chaId, daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chaId=");
			msg.append(chaId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where chaId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current don vi hanh chinh
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh[] findByChaId_PrevAndNext(long id, Long chaId,
		int daXoa, OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DonViHanhChinh[] array = new DonViHanhChinhImpl[3];

			array[0] = getByChaId_PrevAndNext(session, donViHanhChinh, chaId,
					daXoa, orderByComparator, true);

			array[1] = donViHanhChinh;

			array[2] = getByChaId_PrevAndNext(session, donViHanhChinh, chaId,
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

	protected DonViHanhChinh getByChaId_PrevAndNext(Session session,
		DonViHanhChinh donViHanhChinh, Long chaId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

		query.append(_FINDER_COLUMN_CHAID_CHAID_2);

		query.append(_FINDER_COLUMN_CHAID_DAXOA_2);

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
			query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chaId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(donViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the don vi hanh chinhs where quocGiaId = &#63;.
	 *
	 * @param quocGiaId the quoc gia ID
	 * @return the matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByQuocGiaId(long quocGiaId)
		throws SystemException {
		return findByQuocGiaId(quocGiaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the don vi hanh chinhs where quocGiaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @return the range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByQuocGiaId(long quocGiaId, int start,
		int end) throws SystemException {
		return findByQuocGiaId(quocGiaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the don vi hanh chinhs where quocGiaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByQuocGiaId(long quocGiaId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUOCGIAID;
			finderArgs = new Object[] { quocGiaId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUOCGIAID;
			finderArgs = new Object[] { quocGiaId, start, end, orderByComparator };
		}

		List<DonViHanhChinh> list = (List<DonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_QUOCGIAID_QUOCGIAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quocGiaId);

				list = (List<DonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first don vi hanh chinh in the ordered set where quocGiaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByQuocGiaId_First(long quocGiaId,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		List<DonViHanhChinh> list = findByQuocGiaId(quocGiaId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("quocGiaId=");
			msg.append(quocGiaId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last don vi hanh chinh in the ordered set where quocGiaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByQuocGiaId_Last(long quocGiaId,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		int count = countByQuocGiaId(quocGiaId);

		List<DonViHanhChinh> list = findByQuocGiaId(quocGiaId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("quocGiaId=");
			msg.append(quocGiaId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where quocGiaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current don vi hanh chinh
	 * @param quocGiaId the quoc gia ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh[] findByQuocGiaId_PrevAndNext(long id,
		long quocGiaId, OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DonViHanhChinh[] array = new DonViHanhChinhImpl[3];

			array[0] = getByQuocGiaId_PrevAndNext(session, donViHanhChinh,
					quocGiaId, orderByComparator, true);

			array[1] = donViHanhChinh;

			array[2] = getByQuocGiaId_PrevAndNext(session, donViHanhChinh,
					quocGiaId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DonViHanhChinh getByQuocGiaId_PrevAndNext(Session session,
		DonViHanhChinh donViHanhChinh, long quocGiaId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

		query.append(_FINDER_COLUMN_QUOCGIAID_QUOCGIAID_2);

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
			query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(quocGiaId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(donViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the don vi hanh chinhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the don vi hanh chinhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @return the range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the don vi hanh chinhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByTrangThai(int daXoa, int start, int end,
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

		List<DonViHanhChinh> list = (List<DonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<DonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first don vi hanh chinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		List<DonViHanhChinh> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last don vi hanh chinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		int count = countByTrangThai(daXoa);

		List<DonViHanhChinh> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current don vi hanh chinh
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DonViHanhChinh[] array = new DonViHanhChinhImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, donViHanhChinh,
					daXoa, orderByComparator, true);

			array[1] = donViHanhChinh;

			array[2] = getByTrangThai_PrevAndNext(session, donViHanhChinh,
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

	protected DonViHanhChinh getByTrangThai_PrevAndNext(Session session,
		DonViHanhChinh donViHanhChinh, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

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
			query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(donViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the don vi hanh chinh where ma = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByMaDVHC(String ma)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = fetchByMaDVHC(ma);

		if (donViHanhChinh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}

		return donViHanhChinh;
	}

	/**
	 * Returns the don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh fetchByMaDVHC(String ma) throws SystemException {
		return fetchByMaDVHC(ma, true);
	}

	/**
	 * Returns the don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh fetchByMaDVHC(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MADVHC,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MADVHC_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MADVHC_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MADVHC_MA_2);
				}
			}

			query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<DonViHanhChinh> list = q.list();

				result = list;

				DonViHanhChinh donViHanhChinh = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADVHC,
						finderArgs, list);
				}
				else {
					donViHanhChinh = list.get(0);

					cacheResult(donViHanhChinh);

					if ((donViHanhChinh.getMa() == null) ||
							!donViHanhChinh.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADVHC,
							finderArgs, donViHanhChinh);
					}
				}

				return donViHanhChinh;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MADVHC,
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
				return (DonViHanhChinh)result;
			}
		}
	}

	/**
	 * Returns the don vi hanh chinh where ten = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException} if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByTenDVHC(String ten)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = fetchByTenDVHC(ten);

		if (donViHanhChinh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}

		return donViHanhChinh;
	}

	/**
	 * Returns the don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh fetchByTenDVHC(String ten) throws SystemException {
		return fetchByTenDVHC(ten, true);
	}

	/**
	 * Returns the don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh fetchByTenDVHC(String ten, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TENDVHC,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TENDVHC_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENDVHC_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENDVHC_TEN_2);
				}
			}

			query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				List<DonViHanhChinh> list = q.list();

				result = list;

				DonViHanhChinh donViHanhChinh = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDVHC,
						finderArgs, list);
				}
				else {
					donViHanhChinh = list.get(0);

					cacheResult(donViHanhChinh);

					if ((donViHanhChinh.getTen() == null) ||
							!donViHanhChinh.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDVHC,
							finderArgs, donViHanhChinh);
					}
				}

				return donViHanhChinh;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TENDVHC,
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
				return (DonViHanhChinh)result;
			}
		}
	}

	/**
	 * Returns all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByByQuocId(long quocGiaId,
		long capDonViHanhChinhId, int daXoa) throws SystemException {
		return findByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @return the range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByByQuocId(long quocGiaId,
		long capDonViHanhChinhId, int daXoa, int start, int end)
		throws SystemException {
		return findByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findByByQuocId(long quocGiaId,
		long capDonViHanhChinhId, int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYQUOCID;
			finderArgs = new Object[] { quocGiaId, capDonViHanhChinhId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYQUOCID;
			finderArgs = new Object[] {
					quocGiaId, capDonViHanhChinhId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<DonViHanhChinh> list = (List<DonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_BYQUOCID_QUOCGIAID_2);

			query.append(_FINDER_COLUMN_BYQUOCID_CAPDONVIHANHCHINHID_2);

			query.append(_FINDER_COLUMN_BYQUOCID_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quocGiaId);

				qPos.add(capDonViHanhChinhId);

				qPos.add(daXoa);

				list = (List<DonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first don vi hanh chinh in the ordered set where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByByQuocId_First(long quocGiaId,
		long capDonViHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		List<DonViHanhChinh> list = findByByQuocId(quocGiaId,
				capDonViHanhChinhId, daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("quocGiaId=");
			msg.append(quocGiaId);

			msg.append(", capDonViHanhChinhId=");
			msg.append(capDonViHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last don vi hanh chinh in the ordered set where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh findByByQuocId_Last(long quocGiaId,
		long capDonViHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		int count = countByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa);

		List<DonViHanhChinh> list = findByByQuocId(quocGiaId,
				capDonViHanhChinhId, daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("quocGiaId=");
			msg.append(quocGiaId);

			msg.append(", capDonViHanhChinhId=");
			msg.append(capDonViHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current don vi hanh chinh
	 * @param quocGiaId the quoc gia ID
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next don vi hanh chinh
	 * @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViHanhChinh[] findByByQuocId_PrevAndNext(long id, long quocGiaId,
		long capDonViHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DonViHanhChinh[] array = new DonViHanhChinhImpl[3];

			array[0] = getByByQuocId_PrevAndNext(session, donViHanhChinh,
					quocGiaId, capDonViHanhChinhId, daXoa, orderByComparator,
					true);

			array[1] = donViHanhChinh;

			array[2] = getByByQuocId_PrevAndNext(session, donViHanhChinh,
					quocGiaId, capDonViHanhChinhId, daXoa, orderByComparator,
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

	protected DonViHanhChinh getByByQuocId_PrevAndNext(Session session,
		DonViHanhChinh donViHanhChinh, long quocGiaId,
		long capDonViHanhChinhId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DONVIHANHCHINH_WHERE);

		query.append(_FINDER_COLUMN_BYQUOCID_QUOCGIAID_2);

		query.append(_FINDER_COLUMN_BYQUOCID_CAPDONVIHANHCHINHID_2);

		query.append(_FINDER_COLUMN_BYQUOCID_DAXOA_2);

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
			query.append(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(quocGiaId);

		qPos.add(capDonViHanhChinhId);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(donViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the don vi hanh chinhs.
	 *
	 * @return the don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the don vi hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @return the range of don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the don vi hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of don vi hanh chinhs
	 * @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViHanhChinh> findAll(int start, int end,
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

		List<DonViHanhChinh> list = (List<DonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DONVIHANHCHINH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DONVIHANHCHINH.concat(DonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DonViHanhChinh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DonViHanhChinh>)QueryUtil.list(q,
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
	 * Removes all the don vi hanh chinhs where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma) throws SystemException {
		for (DonViHanhChinh donViHanhChinh : findByMa(ma)) {
			remove(donViHanhChinh);
		}
	}

	/**
	 * Removes all the don vi hanh chinhs where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten) throws SystemException {
		for (DonViHanhChinh donViHanhChinh : findByTen(ten)) {
			remove(donViHanhChinh);
		}
	}

	/**
	 * Removes all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCapDonViHanhChinhId(long capDonViHanhChinhId, int daXoa)
		throws SystemException {
		for (DonViHanhChinh donViHanhChinh : findByCapDonViHanhChinhId(
				capDonViHanhChinhId, daXoa)) {
			remove(donViHanhChinh);
		}
	}

	/**
	 * Removes all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByChaId(Long chaId, int daXoa) throws SystemException {
		for (DonViHanhChinh donViHanhChinh : findByChaId(chaId, daXoa)) {
			remove(donViHanhChinh);
		}
	}

	/**
	 * Removes all the don vi hanh chinhs where quocGiaId = &#63; from the database.
	 *
	 * @param quocGiaId the quoc gia ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuocGiaId(long quocGiaId) throws SystemException {
		for (DonViHanhChinh donViHanhChinh : findByQuocGiaId(quocGiaId)) {
			remove(donViHanhChinh);
		}
	}

	/**
	 * Removes all the don vi hanh chinhs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (DonViHanhChinh donViHanhChinh : findByTrangThai(daXoa)) {
			remove(donViHanhChinh);
		}
	}

	/**
	 * Removes the don vi hanh chinh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMaDVHC(String ma)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = findByMaDVHC(ma);

		remove(donViHanhChinh);
	}

	/**
	 * Removes the don vi hanh chinh where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTenDVHC(String ten)
		throws NoSuchDonViHanhChinhException, SystemException {
		DonViHanhChinh donViHanhChinh = findByTenDVHC(ten);

		remove(donViHanhChinh);
	}

	/**
	 * Removes all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByQuocId(long quocGiaId, long capDonViHanhChinhId,
		int daXoa) throws SystemException {
		for (DonViHanhChinh donViHanhChinh : findByByQuocId(quocGiaId,
				capDonViHanhChinhId, daXoa)) {
			remove(donViHanhChinh);
		}
	}

	/**
	 * Removes all the don vi hanh chinhs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DonViHanhChinh donViHanhChinh : findAll()) {
			remove(donViHanhChinh);
		}
	}

	/**
	 * Returns the number of don vi hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DONVIHANHCHINH_WHERE);

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
	 * Returns the number of don vi hanh chinhs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DONVIHANHCHINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_TEN_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEN, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the number of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCapDonViHanhChinhId(long capDonViHanhChinhId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { capDonViHanhChinhId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAPDONVIHANHCHINHID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_CAPDONVIHANHCHINHID_CAPDONVIHANHCHINHID_2);

			query.append(_FINDER_COLUMN_CAPDONVIHANHCHINHID_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(capDonViHanhChinhId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAPDONVIHANHCHINHID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param daXoa the da xoa
	 * @return the number of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByChaId(Long chaId, int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { chaId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CHAID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_CHAID_CHAID_2);

			query.append(_FINDER_COLUMN_CHAID_DAXOA_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHAID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of don vi hanh chinhs where quocGiaId = &#63;.
	 *
	 * @param quocGiaId the quoc gia ID
	 * @return the number of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuocGiaId(long quocGiaId) throws SystemException {
		Object[] finderArgs = new Object[] { quocGiaId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUOCGIAID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_QUOCGIAID_QUOCGIAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quocGiaId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUOCGIAID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of don vi hanh chinhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DONVIHANHCHINH_WHERE);

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
	 * Returns the number of don vi hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMaDVHC(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MADVHC,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DONVIHANHCHINH_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MADVHC_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MADVHC_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MADVHC_MA_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MADVHC,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of don vi hanh chinhs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTenDVHC(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TENDVHC,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DONVIHANHCHINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TENDVHC_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENDVHC_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENDVHC_TEN_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TENDVHC,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param quocGiaId the quoc gia ID
	 * @param capDonViHanhChinhId the cap don vi hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the number of matching don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByQuocId(long quocGiaId, long capDonViHanhChinhId,
		int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { quocGiaId, capDonViHanhChinhId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYQUOCID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_BYQUOCID_QUOCGIAID_2);

			query.append(_FINDER_COLUMN_BYQUOCID_CAPDONVIHANHCHINHID_2);

			query.append(_FINDER_COLUMN_BYQUOCID_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quocGiaId);

				qPos.add(capDonViHanhChinhId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYQUOCID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of don vi hanh chinhs.
	 *
	 * @return the number of don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DONVIHANHCHINH);

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
	 * Initializes the don vi hanh chinh persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.qlhc.model.DonViHanhChinh")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DonViHanhChinh>> listenersList = new ArrayList<ModelListener<DonViHanhChinh>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DonViHanhChinh>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DonViHanhChinhImpl.class.getName());
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
	private static final String _SQL_SELECT_DONVIHANHCHINH = "SELECT donViHanhChinh FROM DonViHanhChinh donViHanhChinh";
	private static final String _SQL_SELECT_DONVIHANHCHINH_WHERE = "SELECT donViHanhChinh FROM DonViHanhChinh donViHanhChinh WHERE ";
	private static final String _SQL_COUNT_DONVIHANHCHINH = "SELECT COUNT(donViHanhChinh) FROM DonViHanhChinh donViHanhChinh";
	private static final String _SQL_COUNT_DONVIHANHCHINH_WHERE = "SELECT COUNT(donViHanhChinh) FROM DonViHanhChinh donViHanhChinh WHERE ";
	private static final String _FINDER_COLUMN_MA_MA_1 = "donViHanhChinh.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "donViHanhChinh.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(donViHanhChinh.ma IS NULL OR donViHanhChinh.ma = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "donViHanhChinh.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "donViHanhChinh.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(donViHanhChinh.ten IS NULL OR donViHanhChinh.ten = ?)";
	private static final String _FINDER_COLUMN_CAPDONVIHANHCHINHID_CAPDONVIHANHCHINHID_2 =
		"donViHanhChinh.capDonViHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_CAPDONVIHANHCHINHID_DAXOA_2 = "donViHanhChinh.daXoa = ?";
	private static final String _FINDER_COLUMN_CHAID_CHAID_2 = "donViHanhChinh.chaId = ? AND ";
	private static final String _FINDER_COLUMN_CHAID_DAXOA_2 = "donViHanhChinh.daXoa = ?";
	private static final String _FINDER_COLUMN_QUOCGIAID_QUOCGIAID_2 = "donViHanhChinh.quocGiaId = ?";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "donViHanhChinh.daXoa = ?";
	private static final String _FINDER_COLUMN_MADVHC_MA_1 = "donViHanhChinh.ma IS NULL";
	private static final String _FINDER_COLUMN_MADVHC_MA_2 = "donViHanhChinh.ma = ?";
	private static final String _FINDER_COLUMN_MADVHC_MA_3 = "(donViHanhChinh.ma IS NULL OR donViHanhChinh.ma = ?)";
	private static final String _FINDER_COLUMN_TENDVHC_TEN_1 = "donViHanhChinh.ten IS NULL";
	private static final String _FINDER_COLUMN_TENDVHC_TEN_2 = "donViHanhChinh.ten = ?";
	private static final String _FINDER_COLUMN_TENDVHC_TEN_3 = "(donViHanhChinh.ten IS NULL OR donViHanhChinh.ten = ?)";
	private static final String _FINDER_COLUMN_BYQUOCID_QUOCGIAID_2 = "donViHanhChinh.quocGiaId = ? AND ";
	private static final String _FINDER_COLUMN_BYQUOCID_CAPDONVIHANHCHINHID_2 = "donViHanhChinh.capDonViHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_BYQUOCID_DAXOA_2 = "donViHanhChinh.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "donViHanhChinh.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DonViHanhChinh exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DonViHanhChinh exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DonViHanhChinhPersistenceImpl.class);
	private static DonViHanhChinh _nullDonViHanhChinh = new DonViHanhChinhImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DonViHanhChinh> toCacheModel() {
				return _nullDonViHanhChinhCacheModel;
			}
		};

	private static CacheModel<DonViHanhChinh> _nullDonViHanhChinhCacheModel = new CacheModel<DonViHanhChinh>() {
			public DonViHanhChinh toEntityModel() {
				return _nullDonViHanhChinh;
			}
		};
}