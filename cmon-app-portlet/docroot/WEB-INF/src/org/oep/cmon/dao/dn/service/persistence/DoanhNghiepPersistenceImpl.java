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

import org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;
import org.oep.cmon.dao.dn.model.DoanhNghiep;
import org.oep.cmon.dao.dn.model.impl.DoanhNghiepImpl;
import org.oep.cmon.dao.dn.model.impl.DoanhNghiepModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the doanh nghiep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see DoanhNghiepPersistence
 * @see DoanhNghiepUtil
 * @generated
 */
public class DoanhNghiepPersistenceImpl extends BasePersistenceImpl<DoanhNghiep>
	implements DoanhNghiepPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DoanhNghiepUtil} to access the doanh nghiep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DoanhNghiepImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_MA = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] { String.class.getName() },
			DoanhNghiepModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MASOTHUE = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMaSoThue",
			new String[] { String.class.getName() },
			DoanhNghiepModelImpl.MASOTHUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASOTHUE = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaSoThue",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_TEN = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTen",
			new String[] { String.class.getName() },
			DoanhNghiepModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_SOGCNDKKD = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySoGCNDKKD",
			new String[] { String.class.getName() },
			DoanhNghiepModelImpl.SOGCNDKKD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SOGCNDKKD = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySoGCNDKKD",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_CHAID = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByChaId",
			new String[] { Long.class.getName() },
			DoanhNghiepModelImpl.CHAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHAID = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChaId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_NGUOIDAIDIENID = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNguoiDaiDienId",
			new String[] { Long.class.getName() },
			DoanhNghiepModelImpl.NGUOIDAIDIENID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NGUOIDAIDIENID = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNguoiDaiDienId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GETNGUOIDAIDIENDOITUONG =
		new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGetNguoiDaiDienDoiTuong",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETNGUOIDAIDIENDOITUONG =
		new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGetNguoiDaiDienDoiTuong",
			new String[] { Long.class.getName(), Long.class.getName() },
			DoanhNghiepModelImpl.NGUOIDAIDIENID_COLUMN_BITMASK |
			DoanhNghiepModelImpl.LOAIDOITUONGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETNGUOIDAIDIENDOITUONG = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGetNguoiDaiDienDoiTuong",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GETLOAIHINHDOANHNGHIEP =
		new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGetLoaiHinhDoanhNghiep",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLOAIHINHDOANHNGHIEP =
		new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGetLoaiHinhDoanhNghiep",
			new String[] { Long.class.getName() },
			DoanhNghiepModelImpl.LOAIHINHDOANHNGHIEPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETLOAIHINHDOANHNGHIEP = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGetLoaiHinhDoanhNghiep",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, DoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the doanh nghiep in the entity cache if it is enabled.
	 *
	 * @param doanhNghiep the doanh nghiep
	 */
	public void cacheResult(DoanhNghiep doanhNghiep) {
		EntityCacheUtil.putResult(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepImpl.class, doanhNghiep.getPrimaryKey(), doanhNghiep);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { doanhNghiep.getMa() }, doanhNghiep);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOTHUE,
			new Object[] { doanhNghiep.getMaSoThue() }, doanhNghiep);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { doanhNghiep.getTen() }, doanhNghiep);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SOGCNDKKD,
			new Object[] { doanhNghiep.getSoGCNDKKD() }, doanhNghiep);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAID,
			new Object[] { Long.valueOf(doanhNghiep.getChaId()) }, doanhNghiep);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGUOIDAIDIENID,
			new Object[] { Long.valueOf(doanhNghiep.getNguoiDaiDienId()) },
			doanhNghiep);

		doanhNghiep.resetOriginalValues();
	}

	/**
	 * Caches the doanh nghieps in the entity cache if it is enabled.
	 *
	 * @param doanhNghieps the doanh nghieps
	 */
	public void cacheResult(List<DoanhNghiep> doanhNghieps) {
		for (DoanhNghiep doanhNghiep : doanhNghieps) {
			if (EntityCacheUtil.getResult(
						DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
						DoanhNghiepImpl.class, doanhNghiep.getPrimaryKey()) == null) {
				cacheResult(doanhNghiep);
			}
			else {
				doanhNghiep.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all doanh nghieps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DoanhNghiepImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DoanhNghiepImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the doanh nghiep.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DoanhNghiep doanhNghiep) {
		EntityCacheUtil.removeResult(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepImpl.class, doanhNghiep.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(doanhNghiep);
	}

	@Override
	public void clearCache(List<DoanhNghiep> doanhNghieps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DoanhNghiep doanhNghiep : doanhNghieps) {
			EntityCacheUtil.removeResult(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
				DoanhNghiepImpl.class, doanhNghiep.getPrimaryKey());

			clearUniqueFindersCache(doanhNghiep);
		}
	}

	protected void clearUniqueFindersCache(DoanhNghiep doanhNghiep) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { doanhNghiep.getMa() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MASOTHUE,
			new Object[] { doanhNghiep.getMaSoThue() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { doanhNghiep.getTen() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SOGCNDKKD,
			new Object[] { doanhNghiep.getSoGCNDKKD() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHAID,
			new Object[] { Long.valueOf(doanhNghiep.getChaId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NGUOIDAIDIENID,
			new Object[] { Long.valueOf(doanhNghiep.getNguoiDaiDienId()) });
	}

	/**
	 * Creates a new doanh nghiep with the primary key. Does not add the doanh nghiep to the database.
	 *
	 * @param id the primary key for the new doanh nghiep
	 * @return the new doanh nghiep
	 */
	public DoanhNghiep create(long id) {
		DoanhNghiep doanhNghiep = new DoanhNghiepImpl();

		doanhNghiep.setNew(true);
		doanhNghiep.setPrimaryKey(id);

		return doanhNghiep;
	}

	/**
	 * Removes the doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the doanh nghiep
	 * @return the doanh nghiep that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep remove(long id)
		throws NoSuchDoanhNghiepException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the doanh nghiep
	 * @return the doanh nghiep that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DoanhNghiep remove(Serializable primaryKey)
		throws NoSuchDoanhNghiepException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DoanhNghiep doanhNghiep = (DoanhNghiep)session.get(DoanhNghiepImpl.class,
					primaryKey);

			if (doanhNghiep == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDoanhNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(doanhNghiep);
		}
		catch (NoSuchDoanhNghiepException nsee) {
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
	protected DoanhNghiep removeImpl(DoanhNghiep doanhNghiep)
		throws SystemException {
		doanhNghiep = toUnwrappedModel(doanhNghiep);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, doanhNghiep);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(doanhNghiep);

		return doanhNghiep;
	}

	@Override
	public DoanhNghiep updateImpl(
		org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep, boolean merge)
		throws SystemException {
		doanhNghiep = toUnwrappedModel(doanhNghiep);

		boolean isNew = doanhNghiep.isNew();

		DoanhNghiepModelImpl doanhNghiepModelImpl = (DoanhNghiepModelImpl)doanhNghiep;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, doanhNghiep, merge);

			doanhNghiep.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DoanhNghiepModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((doanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETNGUOIDAIDIENDOITUONG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(doanhNghiepModelImpl.getOriginalNguoiDaiDienId()),
						Long.valueOf(doanhNghiepModelImpl.getOriginalLoaiDoiTuongId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GETNGUOIDAIDIENDOITUONG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETNGUOIDAIDIENDOITUONG,
					args);

				args = new Object[] {
						Long.valueOf(doanhNghiepModelImpl.getNguoiDaiDienId()),
						Long.valueOf(doanhNghiepModelImpl.getLoaiDoiTuongId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GETNGUOIDAIDIENDOITUONG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETNGUOIDAIDIENDOITUONG,
					args);
			}

			if ((doanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLOAIHINHDOANHNGHIEP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(doanhNghiepModelImpl.getOriginalLoaiHinhDoanhNghiepId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GETLOAIHINHDOANHNGHIEP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLOAIHINHDOANHNGHIEP,
					args);

				args = new Object[] {
						Long.valueOf(doanhNghiepModelImpl.getLoaiHinhDoanhNghiepId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GETLOAIHINHDOANHNGHIEP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLOAIHINHDOANHNGHIEP,
					args);
			}
		}

		EntityCacheUtil.putResult(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiepImpl.class, doanhNghiep.getPrimaryKey(), doanhNghiep);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
				new Object[] { doanhNghiep.getMa() }, doanhNghiep);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOTHUE,
				new Object[] { doanhNghiep.getMaSoThue() }, doanhNghiep);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
				new Object[] { doanhNghiep.getTen() }, doanhNghiep);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SOGCNDKKD,
				new Object[] { doanhNghiep.getSoGCNDKKD() }, doanhNghiep);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAID,
				new Object[] { Long.valueOf(doanhNghiep.getChaId()) },
				doanhNghiep);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGUOIDAIDIENID,
				new Object[] { Long.valueOf(doanhNghiep.getNguoiDaiDienId()) },
				doanhNghiep);
		}
		else {
			if ((doanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						doanhNghiepModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
					new Object[] { doanhNghiep.getMa() }, doanhNghiep);
			}

			if ((doanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MASOTHUE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						doanhNghiepModelImpl.getOriginalMaSoThue()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOTHUE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MASOTHUE, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOTHUE,
					new Object[] { doanhNghiep.getMaSoThue() }, doanhNghiep);
			}

			if ((doanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						doanhNghiepModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
					new Object[] { doanhNghiep.getTen() }, doanhNghiep);
			}

			if ((doanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SOGCNDKKD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						doanhNghiepModelImpl.getOriginalSoGCNDKKD()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOGCNDKKD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SOGCNDKKD,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SOGCNDKKD,
					new Object[] { doanhNghiep.getSoGCNDKKD() }, doanhNghiep);
			}

			if ((doanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CHAID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(doanhNghiepModelImpl.getOriginalChaId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHAID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAID,
					new Object[] { Long.valueOf(doanhNghiep.getChaId()) },
					doanhNghiep);
			}

			if ((doanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NGUOIDAIDIENID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(doanhNghiepModelImpl.getOriginalNguoiDaiDienId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NGUOIDAIDIENID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NGUOIDAIDIENID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGUOIDAIDIENID,
					new Object[] { Long.valueOf(doanhNghiep.getNguoiDaiDienId()) },
					doanhNghiep);
			}
		}

		return doanhNghiep;
	}

	protected DoanhNghiep toUnwrappedModel(DoanhNghiep doanhNghiep) {
		if (doanhNghiep instanceof DoanhNghiepImpl) {
			return doanhNghiep;
		}

		DoanhNghiepImpl doanhNghiepImpl = new DoanhNghiepImpl();

		doanhNghiepImpl.setNew(doanhNghiep.isNew());
		doanhNghiepImpl.setPrimaryKey(doanhNghiep.getPrimaryKey());

		doanhNghiepImpl.setId(doanhNghiep.getId());
		doanhNghiepImpl.setMa(doanhNghiep.getMa());
		doanhNghiepImpl.setTen(doanhNghiep.getTen());
		doanhNghiepImpl.setMaSoThue(doanhNghiep.getMaSoThue());
		doanhNghiepImpl.setTenTiengNuocNgoai(doanhNghiep.getTenTiengNuocNgoai());
		doanhNghiepImpl.setTenVietTat(doanhNghiep.getTenVietTat());
		doanhNghiepImpl.setDiaChiDoanhNghiep(doanhNghiep.getDiaChiDoanhNghiep());
		doanhNghiepImpl.setDienThoaiDoanhNghiep(doanhNghiep.getDienThoaiDoanhNghiep());
		doanhNghiepImpl.setFax(doanhNghiep.getFax());
		doanhNghiepImpl.setEmailDoanhNghiep(doanhNghiep.getEmailDoanhNghiep());
		doanhNghiepImpl.setWebsite(doanhNghiep.getWebsite());
		doanhNghiepImpl.setTongSoVon(doanhNghiep.getTongSoVon());
		doanhNghiepImpl.setMoTaNganhNgheKinhDoanh(doanhNghiep.getMoTaNganhNgheKinhDoanh());
		doanhNghiepImpl.setSoGCNDKKD(doanhNghiep.getSoGCNDKKD());
		doanhNghiepImpl.setNgayCapGCNDKKD(doanhNghiep.getNgayCapGCNDKKD());
		doanhNghiepImpl.setNoiLuuTruId(doanhNghiep.getNoiLuuTruId());
		doanhNghiepImpl.setNgayDieuLeDuocThongQua(doanhNghiep.getNgayDieuLeDuocThongQua());
		doanhNghiepImpl.setTenChiNhanh(doanhNghiep.getTenChiNhanh());
		doanhNghiepImpl.setDiaChiChiNhanh(doanhNghiep.getDiaChiChiNhanh());
		doanhNghiepImpl.setTenVanPhongDaiDien(doanhNghiep.getTenVanPhongDaiDien());
		doanhNghiepImpl.setDiaChiVanPhongDaiDien(doanhNghiep.getDiaChiVanPhongDaiDien());
		doanhNghiepImpl.setNgayBatDauTamNgung(doanhNghiep.getNgayBatDauTamNgung());
		doanhNghiepImpl.setNgayKetThucTamNgung(doanhNghiep.getNgayKetThucTamNgung());
		doanhNghiepImpl.setLyDoTamNgung(doanhNghiep.getLyDoTamNgung());
		doanhNghiepImpl.setNgayChamDutHoatDongKD(doanhNghiep.getNgayChamDutHoatDongKD());
		doanhNghiepImpl.setLoai(doanhNghiep.getLoai());
		doanhNghiepImpl.setDiaChiDoanhNghiepHuyenId(doanhNghiep.getDiaChiDoanhNghiepHuyenId());
		doanhNghiepImpl.setDiaChiDoanhNghiepTinhId(doanhNghiep.getDiaChiDoanhNghiepTinhId());
		doanhNghiepImpl.setDiaChiDoanhNghiepXaId(doanhNghiep.getDiaChiDoanhNghiepXaId());
		doanhNghiepImpl.setLoaiDoiTuongId(doanhNghiep.getLoaiDoiTuongId());
		doanhNghiepImpl.setNguoiDaiDienId(doanhNghiep.getNguoiDaiDienId());
		doanhNghiepImpl.setTrangThaiDoanhNghiepId(doanhNghiep.getTrangThaiDoanhNghiepId());
		doanhNghiepImpl.setVonDieuLe(doanhNghiep.getVonDieuLe());
		doanhNghiepImpl.setVonToiThieuMotXaVien(doanhNghiep.getVonToiThieuMotXaVien());
		doanhNghiepImpl.setGhiChu(doanhNghiep.getGhiChu());
		doanhNghiepImpl.setQuocGiaId(doanhNghiep.getQuocGiaId());
		doanhNghiepImpl.setCoQuanCapId(doanhNghiep.getCoQuanCapId());
		doanhNghiepImpl.setTenCoQuanCap(doanhNghiep.getTenCoQuanCap());
		doanhNghiepImpl.setSoLanDieuChinh(doanhNghiep.getSoLanDieuChinh());
		doanhNghiepImpl.setNgayDieuChinh(doanhNghiep.getNgayDieuChinh());
		doanhNghiepImpl.setChucVuNguoiDaiDien(doanhNghiep.getChucVuNguoiDaiDien());
		doanhNghiepImpl.setNgayTao(doanhNghiep.getNgayTao());
		doanhNghiepImpl.setDaXoa(doanhNghiep.getDaXoa());
		doanhNghiepImpl.setNgaySua(doanhNghiep.getNgaySua());
		doanhNghiepImpl.setChaId(doanhNghiep.getChaId());
		doanhNghiepImpl.setNguoiTao(doanhNghiep.getNguoiTao());
		doanhNghiepImpl.setNguoiSua(doanhNghiep.getNguoiSua());
		doanhNghiepImpl.setTaiKhoanNguoiDungId(doanhNghiep.getTaiKhoanNguoiDungId());
		doanhNghiepImpl.setTenDiaDiemKinhDoanh(doanhNghiep.getTenDiaDiemKinhDoanh());
		doanhNghiepImpl.setNgayDangKyKinhDoanh(doanhNghiep.getNgayDangKyKinhDoanh());
		doanhNghiepImpl.setLoaiHinhDoanhNghiepId(doanhNghiep.getLoaiHinhDoanhNghiepId());

		return doanhNghiepImpl;
	}

	/**
	 * Returns the doanh nghiep with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the doanh nghiep
	 * @return the doanh nghiep
	 * @throws com.liferay.portal.NoSuchModelException if a doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DoanhNghiep findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the doanh nghiep with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	 *
	 * @param id the primary key of the doanh nghiep
	 * @return the doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByPrimaryKey(long id)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = fetchByPrimaryKey(id);

		if (doanhNghiep == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDoanhNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return doanhNghiep;
	}

	/**
	 * Returns the doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doanh nghiep
	 * @return the doanh nghiep, or <code>null</code> if a doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DoanhNghiep fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the doanh nghiep
	 * @return the doanh nghiep, or <code>null</code> if a doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByPrimaryKey(long id) throws SystemException {
		DoanhNghiep doanhNghiep = (DoanhNghiep)EntityCacheUtil.getResult(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
				DoanhNghiepImpl.class, id);

		if (doanhNghiep == _nullDoanhNghiep) {
			return null;
		}

		if (doanhNghiep == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				doanhNghiep = (DoanhNghiep)session.get(DoanhNghiepImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (doanhNghiep != null) {
					cacheResult(doanhNghiep);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
						DoanhNghiepImpl.class, id, _nullDoanhNghiep);
				}

				closeSession(session);
			}
		}

		return doanhNghiep;
	}

	/**
	 * Returns the doanh nghiep where ma = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByMa(String ma)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = fetchByMa(ma);

		if (doanhNghiep == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDoanhNghiepException(msg.toString());
		}

		return doanhNghiep;
	}

	/**
	 * Returns the doanh nghiep where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByMa(String ma) throws SystemException {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the doanh nghiep where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByMa(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

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

			query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<DoanhNghiep> list = q.list();

				result = list;

				DoanhNghiep doanhNghiep = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs, list);
				}
				else {
					doanhNghiep = list.get(0);

					cacheResult(doanhNghiep);

					if ((doanhNghiep.getMa() == null) ||
							!doanhNghiep.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
							finderArgs, doanhNghiep);
					}
				}

				return doanhNghiep;
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
				return (DoanhNghiep)result;
			}
		}
	}

	/**
	 * Returns the doanh nghiep where maSoThue = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	 *
	 * @param maSoThue the ma so thue
	 * @return the matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByMaSoThue(String maSoThue)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = fetchByMaSoThue(maSoThue);

		if (doanhNghiep == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maSoThue=");
			msg.append(maSoThue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDoanhNghiepException(msg.toString());
		}

		return doanhNghiep;
	}

	/**
	 * Returns the doanh nghiep where maSoThue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param maSoThue the ma so thue
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByMaSoThue(String maSoThue)
		throws SystemException {
		return fetchByMaSoThue(maSoThue, true);
	}

	/**
	 * Returns the doanh nghiep where maSoThue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param maSoThue the ma so thue
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByMaSoThue(String maSoThue,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { maSoThue };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MASOTHUE,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

			if (maSoThue == null) {
				query.append(_FINDER_COLUMN_MASOTHUE_MASOTHUE_1);
			}
			else {
				if (maSoThue.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOTHUE_MASOTHUE_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOTHUE_MASOTHUE_2);
				}
			}

			query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maSoThue != null) {
					qPos.add(maSoThue);
				}

				List<DoanhNghiep> list = q.list();

				result = list;

				DoanhNghiep doanhNghiep = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOTHUE,
						finderArgs, list);
				}
				else {
					doanhNghiep = list.get(0);

					cacheResult(doanhNghiep);

					if ((doanhNghiep.getMaSoThue() == null) ||
							!doanhNghiep.getMaSoThue().equals(maSoThue)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOTHUE,
							finderArgs, doanhNghiep);
					}
				}

				return doanhNghiep;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MASOTHUE,
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
				return (DoanhNghiep)result;
			}
		}
	}

	/**
	 * Returns the doanh nghiep where ten = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByTen(String ten)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = fetchByTen(ten);

		if (doanhNghiep == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDoanhNghiepException(msg.toString());
		}

		return doanhNghiep;
	}

	/**
	 * Returns the doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByTen(String ten) throws SystemException {
		return fetchByTen(ten, true);
	}

	/**
	 * Returns the doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByTen(String ten, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TEN,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

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

			query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				List<DoanhNghiep> list = q.list();

				result = list;

				DoanhNghiep doanhNghiep = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
						finderArgs, list);
				}
				else {
					doanhNghiep = list.get(0);

					cacheResult(doanhNghiep);

					if ((doanhNghiep.getTen() == null) ||
							!doanhNghiep.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
							finderArgs, doanhNghiep);
					}
				}

				return doanhNghiep;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
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
				return (DoanhNghiep)result;
			}
		}
	}

	/**
	 * Returns the doanh nghiep where soGCNDKKD = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	 *
	 * @param soGCNDKKD the so g c n d k k d
	 * @return the matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findBySoGCNDKKD(String soGCNDKKD)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = fetchBySoGCNDKKD(soGCNDKKD);

		if (doanhNghiep == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soGCNDKKD=");
			msg.append(soGCNDKKD);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDoanhNghiepException(msg.toString());
		}

		return doanhNghiep;
	}

	/**
	 * Returns the doanh nghiep where soGCNDKKD = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soGCNDKKD the so g c n d k k d
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchBySoGCNDKKD(String soGCNDKKD)
		throws SystemException {
		return fetchBySoGCNDKKD(soGCNDKKD, true);
	}

	/**
	 * Returns the doanh nghiep where soGCNDKKD = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soGCNDKKD the so g c n d k k d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchBySoGCNDKKD(String soGCNDKKD,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { soGCNDKKD };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SOGCNDKKD,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

			if (soGCNDKKD == null) {
				query.append(_FINDER_COLUMN_SOGCNDKKD_SOGCNDKKD_1);
			}
			else {
				if (soGCNDKKD.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SOGCNDKKD_SOGCNDKKD_3);
				}
				else {
					query.append(_FINDER_COLUMN_SOGCNDKKD_SOGCNDKKD_2);
				}
			}

			query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (soGCNDKKD != null) {
					qPos.add(soGCNDKKD);
				}

				List<DoanhNghiep> list = q.list();

				result = list;

				DoanhNghiep doanhNghiep = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SOGCNDKKD,
						finderArgs, list);
				}
				else {
					doanhNghiep = list.get(0);

					cacheResult(doanhNghiep);

					if ((doanhNghiep.getSoGCNDKKD() == null) ||
							!doanhNghiep.getSoGCNDKKD().equals(soGCNDKKD)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SOGCNDKKD,
							finderArgs, doanhNghiep);
					}
				}

				return doanhNghiep;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SOGCNDKKD,
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
				return (DoanhNghiep)result;
			}
		}
	}

	/**
	 * Returns the doanh nghiep where chaId = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	 *
	 * @param chaId the cha ID
	 * @return the matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByChaId(Long chaId)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = fetchByChaId(chaId);

		if (doanhNghiep == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chaId=");
			msg.append(chaId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDoanhNghiepException(msg.toString());
		}

		return doanhNghiep;
	}

	/**
	 * Returns the doanh nghiep where chaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param chaId the cha ID
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByChaId(Long chaId) throws SystemException {
		return fetchByChaId(chaId, true);
	}

	/**
	 * Returns the doanh nghiep where chaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param chaId the cha ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByChaId(Long chaId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { chaId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CHAID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_CHAID_CHAID_2);

			query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId.longValue());

				List<DoanhNghiep> list = q.list();

				result = list;

				DoanhNghiep doanhNghiep = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAID,
						finderArgs, list);
				}
				else {
					doanhNghiep = list.get(0);

					cacheResult(doanhNghiep);

					if ((doanhNghiep.getChaId() != chaId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAID,
							finderArgs, doanhNghiep);
					}
				}

				return doanhNghiep;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHAID,
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
				return (DoanhNghiep)result;
			}
		}
	}

	/**
	 * Returns the doanh nghiep where nguoiDaiDienId = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @return the matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByNguoiDaiDienId(Long nguoiDaiDienId)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = fetchByNguoiDaiDienId(nguoiDaiDienId);

		if (doanhNghiep == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nguoiDaiDienId=");
			msg.append(nguoiDaiDienId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDoanhNghiepException(msg.toString());
		}

		return doanhNghiep;
	}

	/**
	 * Returns the doanh nghiep where nguoiDaiDienId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByNguoiDaiDienId(Long nguoiDaiDienId)
		throws SystemException {
		return fetchByNguoiDaiDienId(nguoiDaiDienId, true);
	}

	/**
	 * Returns the doanh nghiep where nguoiDaiDienId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep fetchByNguoiDaiDienId(Long nguoiDaiDienId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { nguoiDaiDienId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NGUOIDAIDIENID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_NGUOIDAIDIENID_NGUOIDAIDIENID_2);

			query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nguoiDaiDienId.longValue());

				List<DoanhNghiep> list = q.list();

				result = list;

				DoanhNghiep doanhNghiep = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGUOIDAIDIENID,
						finderArgs, list);
				}
				else {
					doanhNghiep = list.get(0);

					cacheResult(doanhNghiep);

					if ((doanhNghiep.getNguoiDaiDienId() != nguoiDaiDienId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGUOIDAIDIENID,
							finderArgs, doanhNghiep);
					}
				}

				return doanhNghiep;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NGUOIDAIDIENID,
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
				return (DoanhNghiep)result;
			}
		}
	}

	/**
	 * Returns all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @return the matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		Long nguoiDaiDienId, Long loaiDoiTuongId) throws SystemException {
		return findByGetNguoiDaiDienDoiTuong(nguoiDaiDienId, loaiDoiTuongId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param start the lower bound of the range of doanh nghieps
	 * @param end the upper bound of the range of doanh nghieps (not inclusive)
	 * @return the range of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		Long nguoiDaiDienId, Long loaiDoiTuongId, int start, int end)
		throws SystemException {
		return findByGetNguoiDaiDienDoiTuong(nguoiDaiDienId, loaiDoiTuongId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param start the lower bound of the range of doanh nghieps
	 * @param end the upper bound of the range of doanh nghieps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		Long nguoiDaiDienId, Long loaiDoiTuongId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETNGUOIDAIDIENDOITUONG;
			finderArgs = new Object[] { nguoiDaiDienId, loaiDoiTuongId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GETNGUOIDAIDIENDOITUONG;
			finderArgs = new Object[] {
					nguoiDaiDienId, loaiDoiTuongId,
					
					start, end, orderByComparator
				};
		}

		List<DoanhNghiep> list = (List<DoanhNghiep>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_GETNGUOIDAIDIENDOITUONG_NGUOIDAIDIENID_2);

			query.append(_FINDER_COLUMN_GETNGUOIDAIDIENDOITUONG_LOAIDOITUONGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nguoiDaiDienId.longValue());

				qPos.add(loaiDoiTuongId.longValue());

				list = (List<DoanhNghiep>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first doanh nghiep in the ordered set where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByGetNguoiDaiDienDoiTuong_First(
		Long nguoiDaiDienId, Long loaiDoiTuongId,
		OrderByComparator orderByComparator)
		throws NoSuchDoanhNghiepException, SystemException {
		List<DoanhNghiep> list = findByGetNguoiDaiDienDoiTuong(nguoiDaiDienId,
				loaiDoiTuongId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nguoiDaiDienId=");
			msg.append(nguoiDaiDienId);

			msg.append(", loaiDoiTuongId=");
			msg.append(loaiDoiTuongId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDoanhNghiepException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last doanh nghiep in the ordered set where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByGetNguoiDaiDienDoiTuong_Last(Long nguoiDaiDienId,
		Long loaiDoiTuongId, OrderByComparator orderByComparator)
		throws NoSuchDoanhNghiepException, SystemException {
		int count = countByGetNguoiDaiDienDoiTuong(nguoiDaiDienId,
				loaiDoiTuongId);

		List<DoanhNghiep> list = findByGetNguoiDaiDienDoiTuong(nguoiDaiDienId,
				loaiDoiTuongId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nguoiDaiDienId=");
			msg.append(nguoiDaiDienId);

			msg.append(", loaiDoiTuongId=");
			msg.append(loaiDoiTuongId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDoanhNghiepException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the doanh nghieps before and after the current doanh nghiep in the ordered set where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current doanh nghiep
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep[] findByGetNguoiDaiDienDoiTuong_PrevAndNext(long id,
		Long nguoiDaiDienId, Long loaiDoiTuongId,
		OrderByComparator orderByComparator)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DoanhNghiep[] array = new DoanhNghiepImpl[3];

			array[0] = getByGetNguoiDaiDienDoiTuong_PrevAndNext(session,
					doanhNghiep, nguoiDaiDienId, loaiDoiTuongId,
					orderByComparator, true);

			array[1] = doanhNghiep;

			array[2] = getByGetNguoiDaiDienDoiTuong_PrevAndNext(session,
					doanhNghiep, nguoiDaiDienId, loaiDoiTuongId,
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

	protected DoanhNghiep getByGetNguoiDaiDienDoiTuong_PrevAndNext(
		Session session, DoanhNghiep doanhNghiep, Long nguoiDaiDienId,
		Long loaiDoiTuongId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

		query.append(_FINDER_COLUMN_GETNGUOIDAIDIENDOITUONG_NGUOIDAIDIENID_2);

		query.append(_FINDER_COLUMN_GETNGUOIDAIDIENDOITUONG_LOAIDOITUONGID_2);

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
			query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nguoiDaiDienId.longValue());

		qPos.add(loaiDoiTuongId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(doanhNghiep);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DoanhNghiep> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	 *
	 * @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	 * @return the matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep> findByGetLoaiHinhDoanhNghiep(
		Long loaiHinhDoanhNghiepId) throws SystemException {
		return findByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	 * @param start the lower bound of the range of doanh nghieps
	 * @param end the upper bound of the range of doanh nghieps (not inclusive)
	 * @return the range of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep> findByGetLoaiHinhDoanhNghiep(
		Long loaiHinhDoanhNghiepId, int start, int end)
		throws SystemException {
		return findByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	 * @param start the lower bound of the range of doanh nghieps
	 * @param end the upper bound of the range of doanh nghieps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep> findByGetLoaiHinhDoanhNghiep(
		Long loaiHinhDoanhNghiepId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLOAIHINHDOANHNGHIEP;
			finderArgs = new Object[] { loaiHinhDoanhNghiepId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GETLOAIHINHDOANHNGHIEP;
			finderArgs = new Object[] {
					loaiHinhDoanhNghiepId,
					
					start, end, orderByComparator
				};
		}

		List<DoanhNghiep> list = (List<DoanhNghiep>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_GETLOAIHINHDOANHNGHIEP_LOAIHINHDOANHNGHIEPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiHinhDoanhNghiepId.longValue());

				list = (List<DoanhNghiep>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first doanh nghiep in the ordered set where loaiHinhDoanhNghiepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByGetLoaiHinhDoanhNghiep_First(
		Long loaiHinhDoanhNghiepId, OrderByComparator orderByComparator)
		throws NoSuchDoanhNghiepException, SystemException {
		List<DoanhNghiep> list = findByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiHinhDoanhNghiepId=");
			msg.append(loaiHinhDoanhNghiepId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDoanhNghiepException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last doanh nghiep in the ordered set where loaiHinhDoanhNghiepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep findByGetLoaiHinhDoanhNghiep_Last(
		Long loaiHinhDoanhNghiepId, OrderByComparator orderByComparator)
		throws NoSuchDoanhNghiepException, SystemException {
		int count = countByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId);

		List<DoanhNghiep> list = findByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiHinhDoanhNghiepId=");
			msg.append(loaiHinhDoanhNghiepId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDoanhNghiepException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the doanh nghieps before and after the current doanh nghiep in the ordered set where loaiHinhDoanhNghiepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current doanh nghiep
	 * @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep[] findByGetLoaiHinhDoanhNghiep_PrevAndNext(long id,
		Long loaiHinhDoanhNghiepId, OrderByComparator orderByComparator)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DoanhNghiep[] array = new DoanhNghiepImpl[3];

			array[0] = getByGetLoaiHinhDoanhNghiep_PrevAndNext(session,
					doanhNghiep, loaiHinhDoanhNghiepId, orderByComparator, true);

			array[1] = doanhNghiep;

			array[2] = getByGetLoaiHinhDoanhNghiep_PrevAndNext(session,
					doanhNghiep, loaiHinhDoanhNghiepId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DoanhNghiep getByGetLoaiHinhDoanhNghiep_PrevAndNext(
		Session session, DoanhNghiep doanhNghiep, Long loaiHinhDoanhNghiepId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOANHNGHIEP_WHERE);

		query.append(_FINDER_COLUMN_GETLOAIHINHDOANHNGHIEP_LOAIHINHDOANHNGHIEPID_2);

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
			query.append(DoanhNghiepModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loaiHinhDoanhNghiepId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(doanhNghiep);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DoanhNghiep> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the doanh nghieps.
	 *
	 * @return the doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doanh nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of doanh nghieps
	 * @param end the upper bound of the range of doanh nghieps (not inclusive)
	 * @return the range of doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the doanh nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of doanh nghieps
	 * @param end the upper bound of the range of doanh nghieps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep> findAll(int start, int end,
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

		List<DoanhNghiep> list = (List<DoanhNghiep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOANHNGHIEP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOANHNGHIEP.concat(DoanhNghiepModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DoanhNghiep>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DoanhNghiep>)QueryUtil.list(q, getDialect(),
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
	 * Removes the doanh nghiep where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = findByMa(ma);

		remove(doanhNghiep);
	}

	/**
	 * Removes the doanh nghiep where maSoThue = &#63; from the database.
	 *
	 * @param maSoThue the ma so thue
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMaSoThue(String maSoThue)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = findByMaSoThue(maSoThue);

		remove(doanhNghiep);
	}

	/**
	 * Removes the doanh nghiep where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = findByTen(ten);

		remove(doanhNghiep);
	}

	/**
	 * Removes the doanh nghiep where soGCNDKKD = &#63; from the database.
	 *
	 * @param soGCNDKKD the so g c n d k k d
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySoGCNDKKD(String soGCNDKKD)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = findBySoGCNDKKD(soGCNDKKD);

		remove(doanhNghiep);
	}

	/**
	 * Removes the doanh nghiep where chaId = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByChaId(Long chaId)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = findByChaId(chaId);

		remove(doanhNghiep);
	}

	/**
	 * Removes the doanh nghiep where nguoiDaiDienId = &#63; from the database.
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNguoiDaiDienId(Long nguoiDaiDienId)
		throws NoSuchDoanhNghiepException, SystemException {
		DoanhNghiep doanhNghiep = findByNguoiDaiDienId(nguoiDaiDienId);

		remove(doanhNghiep);
	}

	/**
	 * Removes all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63; from the database.
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGetNguoiDaiDienDoiTuong(Long nguoiDaiDienId,
		Long loaiDoiTuongId) throws SystemException {
		for (DoanhNghiep doanhNghiep : findByGetNguoiDaiDienDoiTuong(
				nguoiDaiDienId, loaiDoiTuongId)) {
			remove(doanhNghiep);
		}
	}

	/**
	 * Removes all the doanh nghieps where loaiHinhDoanhNghiepId = &#63; from the database.
	 *
	 * @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGetLoaiHinhDoanhNghiep(Long loaiHinhDoanhNghiepId)
		throws SystemException {
		for (DoanhNghiep doanhNghiep : findByGetLoaiHinhDoanhNghiep(
				loaiHinhDoanhNghiepId)) {
			remove(doanhNghiep);
		}
	}

	/**
	 * Removes all the doanh nghieps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DoanhNghiep doanhNghiep : findAll()) {
			remove(doanhNghiep);
		}
	}

	/**
	 * Returns the number of doanh nghieps where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOANHNGHIEP_WHERE);

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
	 * Returns the number of doanh nghieps where maSoThue = &#63;.
	 *
	 * @param maSoThue the ma so thue
	 * @return the number of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMaSoThue(String maSoThue) throws SystemException {
		Object[] finderArgs = new Object[] { maSoThue };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MASOTHUE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOANHNGHIEP_WHERE);

			if (maSoThue == null) {
				query.append(_FINDER_COLUMN_MASOTHUE_MASOTHUE_1);
			}
			else {
				if (maSoThue.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOTHUE_MASOTHUE_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOTHUE_MASOTHUE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maSoThue != null) {
					qPos.add(maSoThue);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MASOTHUE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of doanh nghieps where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOANHNGHIEP_WHERE);

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
	 * Returns the number of doanh nghieps where soGCNDKKD = &#63;.
	 *
	 * @param soGCNDKKD the so g c n d k k d
	 * @return the number of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySoGCNDKKD(String soGCNDKKD) throws SystemException {
		Object[] finderArgs = new Object[] { soGCNDKKD };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SOGCNDKKD,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOANHNGHIEP_WHERE);

			if (soGCNDKKD == null) {
				query.append(_FINDER_COLUMN_SOGCNDKKD_SOGCNDKKD_1);
			}
			else {
				if (soGCNDKKD.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SOGCNDKKD_SOGCNDKKD_3);
				}
				else {
					query.append(_FINDER_COLUMN_SOGCNDKKD_SOGCNDKKD_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (soGCNDKKD != null) {
					qPos.add(soGCNDKKD);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SOGCNDKKD,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of doanh nghieps where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @return the number of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByChaId(Long chaId) throws SystemException {
		Object[] finderArgs = new Object[] { chaId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CHAID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_CHAID_CHAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId.longValue());

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
	 * Returns the number of doanh nghieps where nguoiDaiDienId = &#63;.
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @return the number of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNguoiDaiDienId(Long nguoiDaiDienId)
		throws SystemException {
		Object[] finderArgs = new Object[] { nguoiDaiDienId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NGUOIDAIDIENID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_NGUOIDAIDIENID_NGUOIDAIDIENID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nguoiDaiDienId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NGUOIDAIDIENID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	 *
	 * @param nguoiDaiDienId the nguoi dai dien ID
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @return the number of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGetNguoiDaiDienDoiTuong(Long nguoiDaiDienId,
		Long loaiDoiTuongId) throws SystemException {
		Object[] finderArgs = new Object[] { nguoiDaiDienId, loaiDoiTuongId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GETNGUOIDAIDIENDOITUONG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_GETNGUOIDAIDIENDOITUONG_NGUOIDAIDIENID_2);

			query.append(_FINDER_COLUMN_GETNGUOIDAIDIENDOITUONG_LOAIDOITUONGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nguoiDaiDienId.longValue());

				qPos.add(loaiDoiTuongId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GETNGUOIDAIDIENDOITUONG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	 *
	 * @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	 * @return the number of matching doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGetLoaiHinhDoanhNghiep(Long loaiHinhDoanhNghiepId)
		throws SystemException {
		Object[] finderArgs = new Object[] { loaiHinhDoanhNghiepId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GETLOAIHINHDOANHNGHIEP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_GETLOAIHINHDOANHNGHIEP_LOAIHINHDOANHNGHIEPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiHinhDoanhNghiepId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GETLOAIHINHDOANHNGHIEP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of doanh nghieps.
	 *
	 * @return the number of doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOANHNGHIEP);

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
	 * Initializes the doanh nghiep persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dn.model.DoanhNghiep")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DoanhNghiep>> listenersList = new ArrayList<ModelListener<DoanhNghiep>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DoanhNghiep>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DoanhNghiepImpl.class.getName());
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
	private static final String _SQL_SELECT_DOANHNGHIEP = "SELECT doanhNghiep FROM DoanhNghiep doanhNghiep";
	private static final String _SQL_SELECT_DOANHNGHIEP_WHERE = "SELECT doanhNghiep FROM DoanhNghiep doanhNghiep WHERE ";
	private static final String _SQL_COUNT_DOANHNGHIEP = "SELECT COUNT(doanhNghiep) FROM DoanhNghiep doanhNghiep";
	private static final String _SQL_COUNT_DOANHNGHIEP_WHERE = "SELECT COUNT(doanhNghiep) FROM DoanhNghiep doanhNghiep WHERE ";
	private static final String _FINDER_COLUMN_MA_MA_1 = "doanhNghiep.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "doanhNghiep.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(doanhNghiep.ma IS NULL OR doanhNghiep.ma = ?)";
	private static final String _FINDER_COLUMN_MASOTHUE_MASOTHUE_1 = "doanhNghiep.maSoThue IS NULL";
	private static final String _FINDER_COLUMN_MASOTHUE_MASOTHUE_2 = "doanhNghiep.maSoThue = ?";
	private static final String _FINDER_COLUMN_MASOTHUE_MASOTHUE_3 = "(doanhNghiep.maSoThue IS NULL OR doanhNghiep.maSoThue = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "doanhNghiep.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "doanhNghiep.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(doanhNghiep.ten IS NULL OR doanhNghiep.ten = ?)";
	private static final String _FINDER_COLUMN_SOGCNDKKD_SOGCNDKKD_1 = "doanhNghiep.soGCNDKKD IS NULL";
	private static final String _FINDER_COLUMN_SOGCNDKKD_SOGCNDKKD_2 = "doanhNghiep.soGCNDKKD = ?";
	private static final String _FINDER_COLUMN_SOGCNDKKD_SOGCNDKKD_3 = "(doanhNghiep.soGCNDKKD IS NULL OR doanhNghiep.soGCNDKKD = ?)";
	private static final String _FINDER_COLUMN_CHAID_CHAID_2 = "doanhNghiep.chaId = ?";
	private static final String _FINDER_COLUMN_NGUOIDAIDIENID_NGUOIDAIDIENID_2 = "doanhNghiep.nguoiDaiDienId = ?";
	private static final String _FINDER_COLUMN_GETNGUOIDAIDIENDOITUONG_NGUOIDAIDIENID_2 =
		"doanhNghiep.nguoiDaiDienId = ? AND ";
	private static final String _FINDER_COLUMN_GETNGUOIDAIDIENDOITUONG_LOAIDOITUONGID_2 =
		"doanhNghiep.loaiDoiTuongId = ?";
	private static final String _FINDER_COLUMN_GETLOAIHINHDOANHNGHIEP_LOAIHINHDOANHNGHIEPID_2 =
		"doanhNghiep.loaiHinhDoanhNghiepId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "doanhNghiep.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DoanhNghiep exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DoanhNghiep exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DoanhNghiepPersistenceImpl.class);
	private static DoanhNghiep _nullDoanhNghiep = new DoanhNghiepImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DoanhNghiep> toCacheModel() {
				return _nullDoanhNghiepCacheModel;
			}
		};

	private static CacheModel<DoanhNghiep> _nullDoanhNghiepCacheModel = new CacheModel<DoanhNghiep>() {
			public DoanhNghiep toEntityModel() {
				return _nullDoanhNghiep;
			}
		};
}