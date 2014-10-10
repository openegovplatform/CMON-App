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

package org.oep.cmon.dao.dn.service.persistence;

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

import org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;
import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh;
import org.oep.cmon.dao.dn.model.impl.NganhNgheKinhDoanhImpl;
import org.oep.cmon.dao.dn.model.impl.NganhNgheKinhDoanhModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the nganh nghe kinh doanh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see NganhNgheKinhDoanhPersistence
 * @see NganhNgheKinhDoanhUtil
 * @generated
 */
public class NganhNgheKinhDoanhPersistenceImpl extends BasePersistenceImpl<NganhNgheKinhDoanh>
	implements NganhNgheKinhDoanhPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NganhNgheKinhDoanhUtil} to access the nganh nghe kinh doanh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NganhNgheKinhDoanhImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			NganhNgheKinhDoanhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MA = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMa",
			new String[] { String.class.getName(), Integer.class.getName() },
			NganhNgheKinhDoanhModelImpl.MA_COLUMN_BITMASK |
			NganhNgheKinhDoanhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTen",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] { String.class.getName(), Integer.class.getName() },
			NganhNgheKinhDoanhModelImpl.TEN_COLUMN_BITMASK |
			NganhNgheKinhDoanhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAP = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCap",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCap",
			new String[] { Long.class.getName(), Integer.class.getName() },
			NganhNgheKinhDoanhModelImpl.CAP_COLUMN_BITMASK |
			NganhNgheKinhDoanhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAP = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCap",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the nganh nghe kinh doanh in the entity cache if it is enabled.
	 *
	 * @param nganhNgheKinhDoanh the nganh nghe kinh doanh
	 */
	public void cacheResult(NganhNgheKinhDoanh nganhNgheKinhDoanh) {
		EntityCacheUtil.putResult(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class, nganhNgheKinhDoanh.getPrimaryKey(),
			nganhNgheKinhDoanh);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] {
				nganhNgheKinhDoanh.getMa(),
				Integer.valueOf(nganhNgheKinhDoanh.getDaXoa())
			}, nganhNgheKinhDoanh);

		nganhNgheKinhDoanh.resetOriginalValues();
	}

	/**
	 * Caches the nganh nghe kinh doanhs in the entity cache if it is enabled.
	 *
	 * @param nganhNgheKinhDoanhs the nganh nghe kinh doanhs
	 */
	public void cacheResult(List<NganhNgheKinhDoanh> nganhNgheKinhDoanhs) {
		for (NganhNgheKinhDoanh nganhNgheKinhDoanh : nganhNgheKinhDoanhs) {
			if (EntityCacheUtil.getResult(
						NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
						NganhNgheKinhDoanhImpl.class,
						nganhNgheKinhDoanh.getPrimaryKey()) == null) {
				cacheResult(nganhNgheKinhDoanh);
			}
			else {
				nganhNgheKinhDoanh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all nganh nghe kinh doanhs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NganhNgheKinhDoanhImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NganhNgheKinhDoanhImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the nganh nghe kinh doanh.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NganhNgheKinhDoanh nganhNgheKinhDoanh) {
		EntityCacheUtil.removeResult(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class, nganhNgheKinhDoanh.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(nganhNgheKinhDoanh);
	}

	@Override
	public void clearCache(List<NganhNgheKinhDoanh> nganhNgheKinhDoanhs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NganhNgheKinhDoanh nganhNgheKinhDoanh : nganhNgheKinhDoanhs) {
			EntityCacheUtil.removeResult(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
				NganhNgheKinhDoanhImpl.class, nganhNgheKinhDoanh.getPrimaryKey());

			clearUniqueFindersCache(nganhNgheKinhDoanh);
		}
	}

	protected void clearUniqueFindersCache(
		NganhNgheKinhDoanh nganhNgheKinhDoanh) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] {
				nganhNgheKinhDoanh.getMa(),
				Integer.valueOf(nganhNgheKinhDoanh.getDaXoa())
			});
	}

	/**
	 * Creates a new nganh nghe kinh doanh with the primary key. Does not add the nganh nghe kinh doanh to the database.
	 *
	 * @param id the primary key for the new nganh nghe kinh doanh
	 * @return the new nganh nghe kinh doanh
	 */
	public NganhNgheKinhDoanh create(long id) {
		NganhNgheKinhDoanh nganhNgheKinhDoanh = new NganhNgheKinhDoanhImpl();

		nganhNgheKinhDoanh.setNew(true);
		nganhNgheKinhDoanh.setPrimaryKey(id);

		return nganhNgheKinhDoanh;
	}

	/**
	 * Removes the nganh nghe kinh doanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nganh nghe kinh doanh
	 * @return the nganh nghe kinh doanh that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh remove(long id)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the nganh nghe kinh doanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nganh nghe kinh doanh
	 * @return the nganh nghe kinh doanh that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NganhNgheKinhDoanh remove(Serializable primaryKey)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NganhNgheKinhDoanh nganhNgheKinhDoanh = (NganhNgheKinhDoanh)session.get(NganhNgheKinhDoanhImpl.class,
					primaryKey);

			if (nganhNgheKinhDoanh == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNganhNgheKinhDoanhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(nganhNgheKinhDoanh);
		}
		catch (NoSuchNganhNgheKinhDoanhException nsee) {
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
	protected NganhNgheKinhDoanh removeImpl(
		NganhNgheKinhDoanh nganhNgheKinhDoanh) throws SystemException {
		nganhNgheKinhDoanh = toUnwrappedModel(nganhNgheKinhDoanh);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, nganhNgheKinhDoanh);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(nganhNgheKinhDoanh);

		return nganhNgheKinhDoanh;
	}

	@Override
	public NganhNgheKinhDoanh updateImpl(
		org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh nganhNgheKinhDoanh,
		boolean merge) throws SystemException {
		nganhNgheKinhDoanh = toUnwrappedModel(nganhNgheKinhDoanh);

		boolean isNew = nganhNgheKinhDoanh.isNew();

		NganhNgheKinhDoanhModelImpl nganhNgheKinhDoanhModelImpl = (NganhNgheKinhDoanhModelImpl)nganhNgheKinhDoanh;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, nganhNgheKinhDoanh, merge);

			nganhNgheKinhDoanh.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NganhNgheKinhDoanhModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((nganhNgheKinhDoanhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(nganhNgheKinhDoanhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(nganhNgheKinhDoanhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((nganhNgheKinhDoanhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						nganhNgheKinhDoanhModelImpl.getOriginalTen(),
						Integer.valueOf(nganhNgheKinhDoanhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] {
						nganhNgheKinhDoanhModelImpl.getTen(),
						Integer.valueOf(nganhNgheKinhDoanhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}

			if ((nganhNgheKinhDoanhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(nganhNgheKinhDoanhModelImpl.getOriginalCap()),
						Integer.valueOf(nganhNgheKinhDoanhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP,
					args);

				args = new Object[] {
						Long.valueOf(nganhNgheKinhDoanhModelImpl.getCap()),
						Integer.valueOf(nganhNgheKinhDoanhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP,
					args);
			}
		}

		EntityCacheUtil.putResult(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
			NganhNgheKinhDoanhImpl.class, nganhNgheKinhDoanh.getPrimaryKey(),
			nganhNgheKinhDoanh);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
				new Object[] {
					nganhNgheKinhDoanh.getMa(),
					Integer.valueOf(nganhNgheKinhDoanh.getDaXoa())
				}, nganhNgheKinhDoanh);
		}
		else {
			if ((nganhNgheKinhDoanhModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						nganhNgheKinhDoanhModelImpl.getOriginalMa(),
						Integer.valueOf(nganhNgheKinhDoanhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
					new Object[] {
						nganhNgheKinhDoanh.getMa(),
						Integer.valueOf(nganhNgheKinhDoanh.getDaXoa())
					}, nganhNgheKinhDoanh);
			}
		}

		return nganhNgheKinhDoanh;
	}

	protected NganhNgheKinhDoanh toUnwrappedModel(
		NganhNgheKinhDoanh nganhNgheKinhDoanh) {
		if (nganhNgheKinhDoanh instanceof NganhNgheKinhDoanhImpl) {
			return nganhNgheKinhDoanh;
		}

		NganhNgheKinhDoanhImpl nganhNgheKinhDoanhImpl = new NganhNgheKinhDoanhImpl();

		nganhNgheKinhDoanhImpl.setNew(nganhNgheKinhDoanh.isNew());
		nganhNgheKinhDoanhImpl.setPrimaryKey(nganhNgheKinhDoanh.getPrimaryKey());

		nganhNgheKinhDoanhImpl.setId(nganhNgheKinhDoanh.getId());
		nganhNgheKinhDoanhImpl.setMa(nganhNgheKinhDoanh.getMa());
		nganhNgheKinhDoanhImpl.setTen(nganhNgheKinhDoanh.getTen());
		nganhNgheKinhDoanhImpl.setChaId(nganhNgheKinhDoanh.getChaId());
		nganhNgheKinhDoanhImpl.setNgayTao(nganhNgheKinhDoanh.getNgayTao());
		nganhNgheKinhDoanhImpl.setDaXoa(nganhNgheKinhDoanh.getDaXoa());
		nganhNgheKinhDoanhImpl.setNguoiTao(nganhNgheKinhDoanh.getNguoiTao());
		nganhNgheKinhDoanhImpl.setNguoiSua(nganhNgheKinhDoanh.getNguoiSua());
		nganhNgheKinhDoanhImpl.setNgaySua(nganhNgheKinhDoanh.getNgaySua());
		nganhNgheKinhDoanhImpl.setCap(nganhNgheKinhDoanh.getCap());
		nganhNgheKinhDoanhImpl.setPhienBan(nganhNgheKinhDoanh.getPhienBan());

		return nganhNgheKinhDoanhImpl;
	}

	/**
	 * Returns the nganh nghe kinh doanh with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the nganh nghe kinh doanh
	 * @return the nganh nghe kinh doanh
	 * @throws com.liferay.portal.NoSuchModelException if a nganh nghe kinh doanh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NganhNgheKinhDoanh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the nganh nghe kinh doanh with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException} if it could not be found.
	 *
	 * @param id the primary key of the nganh nghe kinh doanh
	 * @return the nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh findByPrimaryKey(long id)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		NganhNgheKinhDoanh nganhNgheKinhDoanh = fetchByPrimaryKey(id);

		if (nganhNgheKinhDoanh == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchNganhNgheKinhDoanhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return nganhNgheKinhDoanh;
	}

	/**
	 * Returns the nganh nghe kinh doanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nganh nghe kinh doanh
	 * @return the nganh nghe kinh doanh, or <code>null</code> if a nganh nghe kinh doanh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NganhNgheKinhDoanh fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the nganh nghe kinh doanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nganh nghe kinh doanh
	 * @return the nganh nghe kinh doanh, or <code>null</code> if a nganh nghe kinh doanh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh fetchByPrimaryKey(long id)
		throws SystemException {
		NganhNgheKinhDoanh nganhNgheKinhDoanh = (NganhNgheKinhDoanh)EntityCacheUtil.getResult(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
				NganhNgheKinhDoanhImpl.class, id);

		if (nganhNgheKinhDoanh == _nullNganhNgheKinhDoanh) {
			return null;
		}

		if (nganhNgheKinhDoanh == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				nganhNgheKinhDoanh = (NganhNgheKinhDoanh)session.get(NganhNgheKinhDoanhImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (nganhNgheKinhDoanh != null) {
					cacheResult(nganhNgheKinhDoanh);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(NganhNgheKinhDoanhModelImpl.ENTITY_CACHE_ENABLED,
						NganhNgheKinhDoanhImpl.class, id,
						_nullNganhNgheKinhDoanh);
				}

				closeSession(session);
			}
		}

		return nganhNgheKinhDoanh;
	}

	/**
	 * Returns all the nganh nghe kinh doanhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nganh nghe kinh doanhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nganh nghe kinh doanhs
	 * @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	 * @return the range of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findByTrangThai(int daXoa, int start,
		int end) throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the nganh nghe kinh doanhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nganh nghe kinh doanhs
	 * @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findByTrangThai(int daXoa, int start,
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

		List<NganhNgheKinhDoanh> list = (List<NganhNgheKinhDoanh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_NGANHNGHEKINHDOANH_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(NganhNgheKinhDoanhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<NganhNgheKinhDoanh>)QueryUtil.list(q,
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
	 * Returns the first nganh nghe kinh doanh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		List<NganhNgheKinhDoanh> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNganhNgheKinhDoanhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last nganh nghe kinh doanh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		int count = countByTrangThai(daXoa);

		List<NganhNgheKinhDoanh> list = findByTrangThai(daXoa, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNganhNgheKinhDoanhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the nganh nghe kinh doanhs before and after the current nganh nghe kinh doanh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current nganh nghe kinh doanh
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		NganhNgheKinhDoanh nganhNgheKinhDoanh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NganhNgheKinhDoanh[] array = new NganhNgheKinhDoanhImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, nganhNgheKinhDoanh,
					daXoa, orderByComparator, true);

			array[1] = nganhNgheKinhDoanh;

			array[2] = getByTrangThai_PrevAndNext(session, nganhNgheKinhDoanh,
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

	protected NganhNgheKinhDoanh getByTrangThai_PrevAndNext(Session session,
		NganhNgheKinhDoanh nganhNgheKinhDoanh, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NGANHNGHEKINHDOANH_WHERE);

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
			query.append(NganhNgheKinhDoanhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(nganhNgheKinhDoanh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NganhNgheKinhDoanh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the nganh nghe kinh doanh where ma = &#63; and daXoa = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException} if it could not be found.
	 *
	 * @param ma the ma
	 * @param daXoa the da xoa
	 * @return the matching nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh findByMa(String ma, int daXoa)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		NganhNgheKinhDoanh nganhNgheKinhDoanh = fetchByMa(ma, daXoa);

		if (nganhNgheKinhDoanh == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNganhNgheKinhDoanhException(msg.toString());
		}

		return nganhNgheKinhDoanh;
	}

	/**
	 * Returns the nganh nghe kinh doanh where ma = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param daXoa the da xoa
	 * @return the matching nganh nghe kinh doanh, or <code>null</code> if a matching nganh nghe kinh doanh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh fetchByMa(String ma, int daXoa)
		throws SystemException {
		return fetchByMa(ma, daXoa, true);
	}

	/**
	 * Returns the nganh nghe kinh doanh where ma = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param daXoa the da xoa
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching nganh nghe kinh doanh, or <code>null</code> if a matching nganh nghe kinh doanh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh fetchByMa(String ma, int daXoa,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ma, daXoa };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_NGANHNGHEKINHDOANH_WHERE);

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

			query.append(_FINDER_COLUMN_MA_DAXOA_2);

			query.append(NganhNgheKinhDoanhModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				qPos.add(daXoa);

				List<NganhNgheKinhDoanh> list = q.list();

				result = list;

				NganhNgheKinhDoanh nganhNgheKinhDoanh = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs, list);
				}
				else {
					nganhNgheKinhDoanh = list.get(0);

					cacheResult(nganhNgheKinhDoanh);

					if ((nganhNgheKinhDoanh.getMa() == null) ||
							!nganhNgheKinhDoanh.getMa().equals(ma) ||
							(nganhNgheKinhDoanh.getDaXoa() != daXoa)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
							finderArgs, nganhNgheKinhDoanh);
					}
				}

				return nganhNgheKinhDoanh;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
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
				return (NganhNgheKinhDoanh)result;
			}
		}
	}

	/**
	 * Returns all the nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63;.
	 *
	 * @param ten the ten
	 * @param daXoa the da xoa
	 * @return the matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findByTen(String ten, int daXoa)
		throws SystemException {
		return findByTen(ten, daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nganh nghe kinh doanhs
	 * @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	 * @return the range of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findByTen(String ten, int daXoa, int start,
		int end) throws SystemException {
		return findByTen(ten, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nganh nghe kinh doanhs
	 * @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findByTen(String ten, int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN;
			finderArgs = new Object[] { ten, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN;
			finderArgs = new Object[] { ten, daXoa, start, end, orderByComparator };
		}

		List<NganhNgheKinhDoanh> list = (List<NganhNgheKinhDoanh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_NGANHNGHEKINHDOANH_WHERE);

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

			query.append(_FINDER_COLUMN_TEN_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(NganhNgheKinhDoanhModelImpl.ORDER_BY_JPQL);
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

				qPos.add(daXoa);

				list = (List<NganhNgheKinhDoanh>)QueryUtil.list(q,
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
	 * Returns the first nganh nghe kinh doanh in the ordered set where ten = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh findByTen_First(String ten, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		List<NganhNgheKinhDoanh> list = findByTen(ten, daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNganhNgheKinhDoanhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last nganh nghe kinh doanh in the ordered set where ten = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh findByTen_Last(String ten, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		int count = countByTen(ten, daXoa);

		List<NganhNgheKinhDoanh> list = findByTen(ten, daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNganhNgheKinhDoanhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the nganh nghe kinh doanhs before and after the current nganh nghe kinh doanh in the ordered set where ten = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current nganh nghe kinh doanh
	 * @param ten the ten
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh[] findByTen_PrevAndNext(long id, String ten,
		int daXoa, OrderByComparator orderByComparator)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		NganhNgheKinhDoanh nganhNgheKinhDoanh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NganhNgheKinhDoanh[] array = new NganhNgheKinhDoanhImpl[3];

			array[0] = getByTen_PrevAndNext(session, nganhNgheKinhDoanh, ten,
					daXoa, orderByComparator, true);

			array[1] = nganhNgheKinhDoanh;

			array[2] = getByTen_PrevAndNext(session, nganhNgheKinhDoanh, ten,
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

	protected NganhNgheKinhDoanh getByTen_PrevAndNext(Session session,
		NganhNgheKinhDoanh nganhNgheKinhDoanh, String ten, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NGANHNGHEKINHDOANH_WHERE);

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

		query.append(_FINDER_COLUMN_TEN_DAXOA_2);

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
			query.append(NganhNgheKinhDoanhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (ten != null) {
			qPos.add(ten);
		}

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(nganhNgheKinhDoanh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NganhNgheKinhDoanh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63;.
	 *
	 * @param cap the cap
	 * @param daXoa the da xoa
	 * @return the matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findByCap(long cap, int daXoa)
		throws SystemException {
		return findByCap(cap, daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cap the cap
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nganh nghe kinh doanhs
	 * @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	 * @return the range of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findByCap(long cap, int daXoa, int start,
		int end) throws SystemException {
		return findByCap(cap, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cap the cap
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nganh nghe kinh doanhs
	 * @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findByCap(long cap, int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP;
			finderArgs = new Object[] { cap, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAP;
			finderArgs = new Object[] { cap, daXoa, start, end, orderByComparator };
		}

		List<NganhNgheKinhDoanh> list = (List<NganhNgheKinhDoanh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_NGANHNGHEKINHDOANH_WHERE);

			query.append(_FINDER_COLUMN_CAP_CAP_2);

			query.append(_FINDER_COLUMN_CAP_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(NganhNgheKinhDoanhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cap);

				qPos.add(daXoa);

				list = (List<NganhNgheKinhDoanh>)QueryUtil.list(q,
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
	 * Returns the first nganh nghe kinh doanh in the ordered set where cap = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cap the cap
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh findByCap_First(long cap, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		List<NganhNgheKinhDoanh> list = findByCap(cap, daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cap=");
			msg.append(cap);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNganhNgheKinhDoanhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last nganh nghe kinh doanh in the ordered set where cap = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cap the cap
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh findByCap_Last(long cap, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		int count = countByCap(cap, daXoa);

		List<NganhNgheKinhDoanh> list = findByCap(cap, daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cap=");
			msg.append(cap);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNganhNgheKinhDoanhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the nganh nghe kinh doanhs before and after the current nganh nghe kinh doanh in the ordered set where cap = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current nganh nghe kinh doanh
	 * @param cap the cap
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nganh nghe kinh doanh
	 * @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NganhNgheKinhDoanh[] findByCap_PrevAndNext(long id, long cap,
		int daXoa, OrderByComparator orderByComparator)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		NganhNgheKinhDoanh nganhNgheKinhDoanh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NganhNgheKinhDoanh[] array = new NganhNgheKinhDoanhImpl[3];

			array[0] = getByCap_PrevAndNext(session, nganhNgheKinhDoanh, cap,
					daXoa, orderByComparator, true);

			array[1] = nganhNgheKinhDoanh;

			array[2] = getByCap_PrevAndNext(session, nganhNgheKinhDoanh, cap,
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

	protected NganhNgheKinhDoanh getByCap_PrevAndNext(Session session,
		NganhNgheKinhDoanh nganhNgheKinhDoanh, long cap, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NGANHNGHEKINHDOANH_WHERE);

		query.append(_FINDER_COLUMN_CAP_CAP_2);

		query.append(_FINDER_COLUMN_CAP_DAXOA_2);

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
			query.append(NganhNgheKinhDoanhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cap);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(nganhNgheKinhDoanh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NganhNgheKinhDoanh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the nganh nghe kinh doanhs.
	 *
	 * @return the nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nganh nghe kinh doanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of nganh nghe kinh doanhs
	 * @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	 * @return the range of nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the nganh nghe kinh doanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of nganh nghe kinh doanhs
	 * @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NganhNgheKinhDoanh> findAll(int start, int end,
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

		List<NganhNgheKinhDoanh> list = (List<NganhNgheKinhDoanh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NGANHNGHEKINHDOANH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NGANHNGHEKINHDOANH.concat(NganhNgheKinhDoanhModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<NganhNgheKinhDoanh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<NganhNgheKinhDoanh>)QueryUtil.list(q,
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
	 * Removes all the nganh nghe kinh doanhs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (NganhNgheKinhDoanh nganhNgheKinhDoanh : findByTrangThai(daXoa)) {
			remove(nganhNgheKinhDoanh);
		}
	}

	/**
	 * Removes the nganh nghe kinh doanh where ma = &#63; and daXoa = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma, int daXoa)
		throws NoSuchNganhNgheKinhDoanhException, SystemException {
		NganhNgheKinhDoanh nganhNgheKinhDoanh = findByMa(ma, daXoa);

		remove(nganhNgheKinhDoanh);
	}

	/**
	 * Removes all the nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63; from the database.
	 *
	 * @param ten the ten
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten, int daXoa) throws SystemException {
		for (NganhNgheKinhDoanh nganhNgheKinhDoanh : findByTen(ten, daXoa)) {
			remove(nganhNgheKinhDoanh);
		}
	}

	/**
	 * Removes all the nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63; from the database.
	 *
	 * @param cap the cap
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCap(long cap, int daXoa) throws SystemException {
		for (NganhNgheKinhDoanh nganhNgheKinhDoanh : findByCap(cap, daXoa)) {
			remove(nganhNgheKinhDoanh);
		}
	}

	/**
	 * Removes all the nganh nghe kinh doanhs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (NganhNgheKinhDoanh nganhNgheKinhDoanh : findAll()) {
			remove(nganhNgheKinhDoanh);
		}
	}

	/**
	 * Returns the number of nganh nghe kinh doanhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NGANHNGHEKINHDOANH_WHERE);

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
	 * Returns the number of nganh nghe kinh doanhs where ma = &#63; and daXoa = &#63;.
	 *
	 * @param ma the ma
	 * @param daXoa the da xoa
	 * @return the number of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma, int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { ma, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NGANHNGHEKINHDOANH_WHERE);

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

			query.append(_FINDER_COLUMN_MA_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MA, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63;.
	 *
	 * @param ten the ten
	 * @param daXoa the da xoa
	 * @return the number of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten, int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { ten, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NGANHNGHEKINHDOANH_WHERE);

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

			query.append(_FINDER_COLUMN_TEN_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEN, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63;.
	 *
	 * @param cap the cap
	 * @param daXoa the da xoa
	 * @return the number of matching nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCap(long cap, int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { cap, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NGANHNGHEKINHDOANH_WHERE);

			query.append(_FINDER_COLUMN_CAP_CAP_2);

			query.append(_FINDER_COLUMN_CAP_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cap);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAP, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of nganh nghe kinh doanhs.
	 *
	 * @return the number of nganh nghe kinh doanhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NGANHNGHEKINHDOANH);

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
	 * Initializes the nganh nghe kinh doanh persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NganhNgheKinhDoanh>> listenersList = new ArrayList<ModelListener<NganhNgheKinhDoanh>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NganhNgheKinhDoanh>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NganhNgheKinhDoanhImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DoanhNghiepPersistence.class)
	protected DoanhNghiepPersistence doanhNghiepPersistence;
	@BeanReference(type = DoanhNghiep2NganhNghePersistence.class)
	protected DoanhNghiep2NganhNghePersistence doanhNghiep2NganhNghePersistence;
	@BeanReference(type = LoaiDoanhNghiepPersistence.class)
	protected LoaiDoanhNghiepPersistence loaiDoanhNghiepPersistence;
	@BeanReference(type = NganhNgheKinhDoanhPersistence.class)
	protected NganhNgheKinhDoanhPersistence nganhNgheKinhDoanhPersistence;
	@BeanReference(type = TrangThaiDoanhNghiepPersistence.class)
	protected TrangThaiDoanhNghiepPersistence trangThaiDoanhNghiepPersistence;
	@BeanReference(type = YeuCauDangKyDNPersistence.class)
	protected YeuCauDangKyDNPersistence yeuCauDangKyDNPersistence;
	@BeanReference(type = YeuCauDangKyDoanhNghiepPersistence.class)
	protected YeuCauDangKyDoanhNghiepPersistence yeuCauDangKyDoanhNghiepPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_NGANHNGHEKINHDOANH = "SELECT nganhNgheKinhDoanh FROM NganhNgheKinhDoanh nganhNgheKinhDoanh";
	private static final String _SQL_SELECT_NGANHNGHEKINHDOANH_WHERE = "SELECT nganhNgheKinhDoanh FROM NganhNgheKinhDoanh nganhNgheKinhDoanh WHERE ";
	private static final String _SQL_COUNT_NGANHNGHEKINHDOANH = "SELECT COUNT(nganhNgheKinhDoanh) FROM NganhNgheKinhDoanh nganhNgheKinhDoanh";
	private static final String _SQL_COUNT_NGANHNGHEKINHDOANH_WHERE = "SELECT COUNT(nganhNgheKinhDoanh) FROM NganhNgheKinhDoanh nganhNgheKinhDoanh WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "nganhNgheKinhDoanh.daXoa = ?";
	private static final String _FINDER_COLUMN_MA_MA_1 = "nganhNgheKinhDoanh.ma IS NULL AND ";
	private static final String _FINDER_COLUMN_MA_MA_2 = "nganhNgheKinhDoanh.ma = ? AND ";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(nganhNgheKinhDoanh.ma IS NULL OR nganhNgheKinhDoanh.ma = ?) AND ";
	private static final String _FINDER_COLUMN_MA_DAXOA_2 = "nganhNgheKinhDoanh.daXoa = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "nganhNgheKinhDoanh.ten IS NULL AND ";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "nganhNgheKinhDoanh.ten = ? AND ";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(nganhNgheKinhDoanh.ten IS NULL OR nganhNgheKinhDoanh.ten = ?) AND ";
	private static final String _FINDER_COLUMN_TEN_DAXOA_2 = "nganhNgheKinhDoanh.daXoa = ?";
	private static final String _FINDER_COLUMN_CAP_CAP_2 = "nganhNgheKinhDoanh.cap = ? AND ";
	private static final String _FINDER_COLUMN_CAP_DAXOA_2 = "nganhNgheKinhDoanh.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nganhNgheKinhDoanh.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NganhNgheKinhDoanh exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NganhNgheKinhDoanh exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NganhNgheKinhDoanhPersistenceImpl.class);
	private static NganhNgheKinhDoanh _nullNganhNgheKinhDoanh = new NganhNgheKinhDoanhImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NganhNgheKinhDoanh> toCacheModel() {
				return _nullNganhNgheKinhDoanhCacheModel;
			}
		};

	private static CacheModel<NganhNgheKinhDoanh> _nullNganhNgheKinhDoanhCacheModel =
		new CacheModel<NganhNgheKinhDoanh>() {
			public NganhNgheKinhDoanh toEntityModel() {
				return _nullNganhNgheKinhDoanh;
			}
		};
}