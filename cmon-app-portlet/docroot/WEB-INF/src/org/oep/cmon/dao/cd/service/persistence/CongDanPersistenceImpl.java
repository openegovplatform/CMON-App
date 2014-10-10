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

package org.oep.cmon.dao.cd.service.persistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import org.oep.cmon.dao.cd.NoSuchCongDanException;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.model.impl.CongDanImpl;
import org.oep.cmon.dao.cd.model.impl.CongDanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the cong dan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CongDanPersistence
 * @see CongDanUtil
 * @generated
 */
public class CongDanPersistenceImpl extends BasePersistenceImpl<CongDan>
	implements CongDanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CongDanUtil} to access the cong dan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CongDanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			CongDanModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MA = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] { String.class.getName() },
			CongDanModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILANDCMND = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmailAndCMND",
			new String[] { String.class.getName(), String.class.getName() },
			CongDanModelImpl.EMAIL_COLUMN_BITMASK |
			CongDanModelImpl.SOCMND_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILANDCMND = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAndCMND",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_NGAYSINHANDCMND = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNgaySinhAndCMND",
			new String[] { Date.class.getName(), String.class.getName() },
			CongDanModelImpl.NGAYSINH_COLUMN_BITMASK |
			CongDanModelImpl.SOCMND_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NGAYSINHANDCMND = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNgaySinhAndCMND",
			new String[] { Date.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_NGAYSINH = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNgaySinh",
			new String[] { Date.class.getName(), String.class.getName() },
			CongDanModelImpl.NGAYSINH_COLUMN_BITMASK |
			CongDanModelImpl.SOCMND_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NGAYSINH = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNgaySinh",
			new String[] { Date.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTen",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] { String.class.getName() },
			CongDanModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] { String.class.getName() },
			CongDanModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCMND = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySoCmnd",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND =
		new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySoCmnd",
			new String[] { String.class.getName() },
			CongDanModelImpl.SOCMND_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SOCMND = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySoCmnd",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_M_T_S = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByM_T_S",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T_S = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByM_T_S",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			CongDanModelImpl.MA_COLUMN_BITMASK |
			CongDanModelImpl.TEN_COLUMN_BITMASK |
			CongDanModelImpl.SOCMND_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_M_T_S = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByM_T_S",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, CongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cong dan in the entity cache if it is enabled.
	 *
	 * @param congDan the cong dan
	 */
	public void cacheResult(CongDan congDan) {
		EntityCacheUtil.putResult(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanImpl.class, congDan.getPrimaryKey(), congDan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { congDan.getMa() }, congDan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCMND,
			new Object[] { congDan.getEmail(), congDan.getSoCmnd() }, congDan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINHANDCMND,
			new Object[] { congDan.getNgaySinh(), congDan.getSoCmnd() }, congDan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINH,
			new Object[] { congDan.getNgaySinh(), congDan.getSoCmnd() }, congDan);

		congDan.resetOriginalValues();
	}

	/**
	 * Caches the cong dans in the entity cache if it is enabled.
	 *
	 * @param congDans the cong dans
	 */
	public void cacheResult(List<CongDan> congDans) {
		for (CongDan congDan : congDans) {
			if (EntityCacheUtil.getResult(
						CongDanModelImpl.ENTITY_CACHE_ENABLED,
						CongDanImpl.class, congDan.getPrimaryKey()) == null) {
				cacheResult(congDan);
			}
			else {
				congDan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cong dans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CongDanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CongDanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cong dan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CongDan congDan) {
		EntityCacheUtil.removeResult(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanImpl.class, congDan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(congDan);
	}

	@Override
	public void clearCache(List<CongDan> congDans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CongDan congDan : congDans) {
			EntityCacheUtil.removeResult(CongDanModelImpl.ENTITY_CACHE_ENABLED,
				CongDanImpl.class, congDan.getPrimaryKey());

			clearUniqueFindersCache(congDan);
		}
	}

	protected void clearUniqueFindersCache(CongDan congDan) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { congDan.getMa() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILANDCMND,
			new Object[] { congDan.getEmail(), congDan.getSoCmnd() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NGAYSINHANDCMND,
			new Object[] { congDan.getNgaySinh(), congDan.getSoCmnd() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NGAYSINH,
			new Object[] { congDan.getNgaySinh(), congDan.getSoCmnd() });
	}

	/**
	 * Creates a new cong dan with the primary key. Does not add the cong dan to the database.
	 *
	 * @param id the primary key for the new cong dan
	 * @return the new cong dan
	 */
	public CongDan create(long id) {
		CongDan congDan = new CongDanImpl();

		congDan.setNew(true);
		congDan.setPrimaryKey(id);

		return congDan;
	}

	/**
	 * Removes the cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cong dan
	 * @return the cong dan that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan remove(long id)
		throws NoSuchCongDanException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cong dan
	 * @return the cong dan that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongDan remove(Serializable primaryKey)
		throws NoSuchCongDanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CongDan congDan = (CongDan)session.get(CongDanImpl.class, primaryKey);

			if (congDan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(congDan);
		}
		catch (NoSuchCongDanException nsee) {
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
	protected CongDan removeImpl(CongDan congDan) throws SystemException {
		congDan = toUnwrappedModel(congDan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, congDan);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(congDan);

		return congDan;
	}

	@Override
	public CongDan updateImpl(org.oep.cmon.dao.cd.model.CongDan congDan,
		boolean merge) throws SystemException {
		congDan = toUnwrappedModel(congDan);

		boolean isNew = congDan.isNew();

		CongDanModelImpl congDanModelImpl = (CongDanModelImpl)congDan;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, congDan, merge);

			congDan.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CongDanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((congDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(congDanModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] { Integer.valueOf(congDanModelImpl.getDaXoa()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((congDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { congDanModelImpl.getOriginalTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] { congDanModelImpl.getTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}

			if ((congDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { congDanModelImpl.getOriginalEmail() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);

				args = new Object[] { congDanModelImpl.getEmail() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);
			}

			if ((congDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						congDanModelImpl.getOriginalSoCmnd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCMND, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND,
					args);

				args = new Object[] { congDanModelImpl.getSoCmnd() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCMND, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND,
					args);
			}

			if ((congDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						congDanModelImpl.getOriginalMa(),
						
						congDanModelImpl.getOriginalTen(),
						
						congDanModelImpl.getOriginalSoCmnd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_M_T_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T_S,
					args);

				args = new Object[] {
						congDanModelImpl.getMa(),
						
						congDanModelImpl.getTen(),
						
						congDanModelImpl.getSoCmnd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_M_T_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T_S,
					args);
			}
		}

		EntityCacheUtil.putResult(CongDanModelImpl.ENTITY_CACHE_ENABLED,
			CongDanImpl.class, congDan.getPrimaryKey(), congDan);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
				new Object[] { congDan.getMa() }, congDan);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCMND,
				new Object[] { congDan.getEmail(), congDan.getSoCmnd() },
				congDan);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINHANDCMND,
				new Object[] { congDan.getNgaySinh(), congDan.getSoCmnd() },
				congDan);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINH,
				new Object[] { congDan.getNgaySinh(), congDan.getSoCmnd() },
				congDan);
		}
		else {
			if ((congDanModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { congDanModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
					new Object[] { congDan.getMa() }, congDan);
			}

			if ((congDanModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILANDCMND.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						congDanModelImpl.getOriginalEmail(),
						
						congDanModelImpl.getOriginalSoCmnd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILANDCMND,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILANDCMND,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCMND,
					new Object[] { congDan.getEmail(), congDan.getSoCmnd() },
					congDan);
			}

			if ((congDanModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NGAYSINHANDCMND.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						congDanModelImpl.getOriginalNgaySinh(),
						
						congDanModelImpl.getOriginalSoCmnd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NGAYSINHANDCMND,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NGAYSINHANDCMND,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINHANDCMND,
					new Object[] { congDan.getNgaySinh(), congDan.getSoCmnd() },
					congDan);
			}

			if ((congDanModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NGAYSINH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						congDanModelImpl.getOriginalNgaySinh(),
						
						congDanModelImpl.getOriginalSoCmnd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NGAYSINH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NGAYSINH, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINH,
					new Object[] { congDan.getNgaySinh(), congDan.getSoCmnd() },
					congDan);
			}
		}

		return congDan;
	}

	protected CongDan toUnwrappedModel(CongDan congDan) {
		if (congDan instanceof CongDanImpl) {
			return congDan;
		}

		CongDanImpl congDanImpl = new CongDanImpl();

		congDanImpl.setNew(congDan.isNew());
		congDanImpl.setPrimaryKey(congDan.getPrimaryKey());

		congDanImpl.setId(congDan.getId());
		congDanImpl.setMa(congDan.getMa());
		congDanImpl.setHo(congDan.getHo());
		congDanImpl.setDem(congDan.getDem());
		congDanImpl.setTen(congDan.getTen());
		congDanImpl.setNgaySinh(congDan.getNgaySinh());
		congDanImpl.setSoCmnd(congDan.getSoCmnd());
		congDanImpl.setNgayCapCmnd(congDan.getNgayCapCmnd());
		congDanImpl.setGhiChuCmnd(congDan.getGhiChuCmnd());
		congDanImpl.setSoHoChieu(congDan.getSoHoChieu());
		congDanImpl.setNgayCapHoChieu(congDan.getNgayCapHoChieu());
		congDanImpl.setNgayHetHanHoChieu(congDan.getNgayHetHanHoChieu());
		congDanImpl.setNoiCapHoChieuId(congDan.getNoiCapHoChieuId());
		congDanImpl.setGhiChuHoChieu(congDan.getGhiChuHoChieu());
		congDanImpl.setSoBaoHiemYTe(congDan.getSoBaoHiemYTe());
		congDanImpl.setMaSoThueCaNhan(congDan.getMaSoThueCaNhan());
		congDanImpl.setDiaChiThuongTru(congDan.getDiaChiThuongTru());
		congDanImpl.setDiaChiHienNay(congDan.getDiaChiHienNay());
		congDanImpl.setDienThoaiCoDinh(congDan.getDienThoaiCoDinh());
		congDanImpl.setDienThoaiDiDong(congDan.getDienThoaiDiDong());
		congDanImpl.setHoTenCha(congDan.getHoTenCha());
		congDanImpl.setHoTenMe(congDan.getHoTenMe());
		congDanImpl.setHoTenVoHoacChong(congDan.getHoTenVoHoacChong());
		congDanImpl.setSoHoKhau(congDan.getSoHoKhau());
		congDanImpl.setLaChuHo(congDan.getLaChuHo());
		congDanImpl.setTinhTrangHonNhanId(congDan.getTinhTrangHonNhanId());
		congDanImpl.setEmail(congDan.getEmail());
		congDanImpl.setTrinhDoChuyenMonId(congDan.getTrinhDoChuyenMonId());
		congDanImpl.setSoDinhDanhChaId(congDan.getSoDinhDanhChaId());
		congDanImpl.setSoDinhDanhVoHoacChongId(congDan.getSoDinhDanhVoHoacChongId());
		congDanImpl.setDanTocId(congDan.getDanTocId());
		congDanImpl.setDiaChiHienNayHuyenId(congDan.getDiaChiHienNayHuyenId());
		congDanImpl.setDiaChiHienNayTinhId(congDan.getDiaChiHienNayTinhId());
		congDanImpl.setDiaChiHienNayXaId(congDan.getDiaChiHienNayXaId());
		congDanImpl.setDiaChiThuongTruHuyenId(congDan.getDiaChiThuongTruHuyenId());
		congDanImpl.setDiaChiThuongTruTinhId(congDan.getDiaChiThuongTruTinhId());
		congDanImpl.setDiaChiThuongTruXaId(congDan.getDiaChiThuongTruXaId());
		congDanImpl.setGioiTinh(congDan.getGioiTinh());
		congDanImpl.setNgheNghiepId(congDan.getNgheNghiepId());
		congDanImpl.setNoiSinhHuyenId(congDan.getNoiSinhHuyenId());
		congDanImpl.setNoiSinhTinhId(congDan.getNoiSinhTinhId());
		congDanImpl.setNoiSinhXaId(congDan.getNoiSinhXaId());
		congDanImpl.setNoiSinhChiTiet(congDan.getNoiSinhChiTiet());
		congDanImpl.setNoiCapCmndId(congDan.getNoiCapCmndId());
		congDanImpl.setTonGiaoId(congDan.getTonGiaoId());
		congDanImpl.setSoDinhDanhMeId(congDan.getSoDinhDanhMeId());
		congDanImpl.setTrinhDoHocVanId(congDan.getTrinhDoHocVanId());
		congDanImpl.setTaiKhoanNguoiDungId(congDan.getTaiKhoanNguoiDungId());
		congDanImpl.setQuanHeChuHoId(congDan.getQuanHeChuHoId());
		congDanImpl.setQuocTichId(congDan.getQuocTichId());
		congDanImpl.setDoanhNghiepId(congDan.getDoanhNghiepId());
		congDanImpl.setTenDayDu(congDan.getTenDayDu());
		congDanImpl.setNgayTao(congDan.getNgayTao());
		congDanImpl.setNgaySua(congDan.getNgaySua());
		congDanImpl.setNguoiTao(congDan.getNguoiTao());
		congDanImpl.setNguoiSua(congDan.getNguoiSua());
		congDanImpl.setDaXoa(congDan.getDaXoa());
		congDanImpl.setFax(congDan.getFax());
		congDanImpl.setWebsite(congDan.getWebsite());
		congDanImpl.setTinhtrang(congDan.getTinhtrang());

		return congDanImpl;
	}

	/**
	 * Returns the cong dan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong dan
	 * @return the cong dan
	 * @throws com.liferay.portal.NoSuchModelException if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongDan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cong dan with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	 *
	 * @param id the primary key of the cong dan
	 * @return the cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByPrimaryKey(long id)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = fetchByPrimaryKey(id);

		if (congDan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return congDan;
	}

	/**
	 * Returns the cong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong dan
	 * @return the cong dan, or <code>null</code> if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongDan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cong dan
	 * @return the cong dan, or <code>null</code> if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan fetchByPrimaryKey(long id) throws SystemException {
		CongDan congDan = (CongDan)EntityCacheUtil.getResult(CongDanModelImpl.ENTITY_CACHE_ENABLED,
				CongDanImpl.class, id);

		if (congDan == _nullCongDan) {
			return null;
		}

		if (congDan == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				congDan = (CongDan)session.get(CongDanImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (congDan != null) {
					cacheResult(congDan);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CongDanModelImpl.ENTITY_CACHE_ENABLED,
						CongDanImpl.class, id, _nullCongDan);
				}

				closeSession(session);
			}
		}

		return congDan;
	}

	/**
	 * Returns all the cong dans where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByTrangThai(int daXoa) throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong dans where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @return the range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong dans where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByTrangThai(int daXoa, int start, int end,
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

		List<CongDan> list = (List<CongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGDAN_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<CongDan>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first cong dan in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		List<CongDan> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong dan in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		int count = countByTrangThai(daXoa);

		List<CongDan> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong dans before and after the current cong dan in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong dan
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongDan[] array = new CongDanImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, congDan, daXoa,
					orderByComparator, true);

			array[1] = congDan;

			array[2] = getByTrangThai_PrevAndNext(session, congDan, daXoa,
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

	protected CongDan getByTrangThai_PrevAndNext(Session session,
		CongDan congDan, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGDAN_WHERE);

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
			query.append(CongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(congDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the cong dan where ma = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByMa(String ma)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = fetchByMa(ma);

		if (congDan == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCongDanException(msg.toString());
		}

		return congDan;
	}

	/**
	 * Returns the cong dan where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan fetchByMa(String ma) throws SystemException {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the cong dan where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan fetchByMa(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONGDAN_WHERE);

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

			query.append(CongDanModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<CongDan> list = q.list();

				result = list;

				CongDan congDan = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs, list);
				}
				else {
					congDan = list.get(0);

					cacheResult(congDan);

					if ((congDan.getMa() == null) ||
							!congDan.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
							finderArgs, congDan);
					}
				}

				return congDan;
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
				return (CongDan)result;
			}
		}
	}

	/**
	 * Returns the cong dan where email = &#63; and soCmnd = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	 *
	 * @param email the email
	 * @param soCmnd the so cmnd
	 * @return the matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByEmailAndCMND(String email, String soCmnd)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = fetchByEmailAndCMND(email, soCmnd);

		if (congDan == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(", soCmnd=");
			msg.append(soCmnd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCongDanException(msg.toString());
		}

		return congDan;
	}

	/**
	 * Returns the cong dan where email = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @param soCmnd the so cmnd
	 * @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan fetchByEmailAndCMND(String email, String soCmnd)
		throws SystemException {
		return fetchByEmailAndCMND(email, soCmnd, true);
	}

	/**
	 * Returns the cong dan where email = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param soCmnd the so cmnd
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan fetchByEmailAndCMND(String email, String soCmnd,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { email, soCmnd };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILANDCMND,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONGDAN_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAILANDCMND_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAILANDCMND_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAILANDCMND_EMAIL_2);
				}
			}

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_EMAILANDCMND_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAILANDCMND_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAILANDCMND_SOCMND_2);
				}
			}

			query.append(CongDanModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
				}

				if (soCmnd != null) {
					qPos.add(soCmnd);
				}

				List<CongDan> list = q.list();

				result = list;

				CongDan congDan = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCMND,
						finderArgs, list);
				}
				else {
					congDan = list.get(0);

					cacheResult(congDan);

					if ((congDan.getEmail() == null) ||
							!congDan.getEmail().equals(email) ||
							(congDan.getSoCmnd() == null) ||
							!congDan.getSoCmnd().equals(soCmnd)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCMND,
							finderArgs, congDan);
					}
				}

				return congDan;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILANDCMND,
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
				return (CongDan)result;
			}
		}
	}

	/**
	 * Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @return the matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByNgaySinhAndCMND(Date ngaySinh, String soCmnd)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = fetchByNgaySinhAndCMND(ngaySinh, soCmnd);

		if (congDan == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ngaySinh=");
			msg.append(ngaySinh);

			msg.append(", soCmnd=");
			msg.append(soCmnd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCongDanException(msg.toString());
		}

		return congDan;
	}

	/**
	 * Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan fetchByNgaySinhAndCMND(Date ngaySinh, String soCmnd)
		throws SystemException {
		return fetchByNgaySinhAndCMND(ngaySinh, soCmnd, true);
	}

	/**
	 * Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan fetchByNgaySinhAndCMND(Date ngaySinh, String soCmnd,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ngaySinh, soCmnd };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NGAYSINHANDCMND,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONGDAN_WHERE);

			if (ngaySinh == null) {
				query.append(_FINDER_COLUMN_NGAYSINHANDCMND_NGAYSINH_1);
			}
			else {
				query.append(_FINDER_COLUMN_NGAYSINHANDCMND_NGAYSINH_2);
			}

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_NGAYSINHANDCMND_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NGAYSINHANDCMND_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_NGAYSINHANDCMND_SOCMND_2);
				}
			}

			query.append(CongDanModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ngaySinh != null) {
					qPos.add(CalendarUtil.getTimestamp(ngaySinh));
				}

				if (soCmnd != null) {
					qPos.add(soCmnd);
				}

				List<CongDan> list = q.list();

				result = list;

				CongDan congDan = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINHANDCMND,
						finderArgs, list);
				}
				else {
					congDan = list.get(0);

					cacheResult(congDan);

					if ((congDan.getNgaySinh() == null) ||
							!congDan.getNgaySinh().equals(ngaySinh) ||
							(congDan.getSoCmnd() == null) ||
							!congDan.getSoCmnd().equals(soCmnd)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINHANDCMND,
							finderArgs, congDan);
					}
				}

				return congDan;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NGAYSINHANDCMND,
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
				return (CongDan)result;
			}
		}
	}

	/**
	 * Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @return the matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByNgaySinh(Date ngaySinh, String soCmnd)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = fetchByNgaySinh(ngaySinh, soCmnd);

		if (congDan == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ngaySinh=");
			msg.append(ngaySinh);

			msg.append(", soCmnd=");
			msg.append(soCmnd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCongDanException(msg.toString());
		}

		return congDan;
	}

	/**
	 * Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan fetchByNgaySinh(Date ngaySinh, String soCmnd)
		throws SystemException {
		return fetchByNgaySinh(ngaySinh, soCmnd, true);
	}

	/**
	 * Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan fetchByNgaySinh(Date ngaySinh, String soCmnd,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ngaySinh, soCmnd };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NGAYSINH,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONGDAN_WHERE);

			if (ngaySinh == null) {
				query.append(_FINDER_COLUMN_NGAYSINH_NGAYSINH_1);
			}
			else {
				query.append(_FINDER_COLUMN_NGAYSINH_NGAYSINH_2);
			}

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_NGAYSINH_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NGAYSINH_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_NGAYSINH_SOCMND_2);
				}
			}

			query.append(CongDanModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ngaySinh != null) {
					qPos.add(CalendarUtil.getTimestamp(ngaySinh));
				}

				if (soCmnd != null) {
					qPos.add(soCmnd);
				}

				List<CongDan> list = q.list();

				result = list;

				CongDan congDan = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINH,
						finderArgs, list);
				}
				else {
					congDan = list.get(0);

					cacheResult(congDan);

					if ((congDan.getNgaySinh() == null) ||
							!congDan.getNgaySinh().equals(ngaySinh) ||
							(congDan.getSoCmnd() == null) ||
							!congDan.getSoCmnd().equals(soCmnd)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NGAYSINH,
							finderArgs, congDan);
					}
				}

				return congDan;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NGAYSINH,
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
				return (CongDan)result;
			}
		}
	}

	/**
	 * Returns all the cong dans where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByTen(String ten) throws SystemException {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong dans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @return the range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByTen(String ten, int start, int end)
		throws SystemException {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong dans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByTen(String ten, int start, int end,
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

		List<CongDan> list = (List<CongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGDAN_WHERE);

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
				query.append(CongDanModelImpl.ORDER_BY_JPQL);
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

				list = (List<CongDan>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first cong dan in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByTen_First(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		List<CongDan> list = findByTen(ten, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong dan in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByTen_Last(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		int count = countByTen(ten);

		List<CongDan> list = findByTen(ten, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong dans before and after the current cong dan in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong dan
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan[] findByTen_PrevAndNext(long id, String ten,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongDan[] array = new CongDanImpl[3];

			array[0] = getByTen_PrevAndNext(session, congDan, ten,
					orderByComparator, true);

			array[1] = congDan;

			array[2] = getByTen_PrevAndNext(session, congDan, ten,
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

	protected CongDan getByTen_PrevAndNext(Session session, CongDan congDan,
		String ten, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGDAN_WHERE);

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
			query.append(CongDanModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(congDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cong dans where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByEmail(String email) throws SystemException {
		return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong dans where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @return the range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByEmail(String email, int start, int end)
		throws SystemException {
		return findByEmail(email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong dans where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByEmail(String email, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email, start, end, orderByComparator };
		}

		List<CongDan> list = (List<CongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGDAN_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
				}

				list = (List<CongDan>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first cong dan in the ordered set where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByEmail_First(String email,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		List<CongDan> list = findByEmail(email, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong dan in the ordered set where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByEmail_Last(String email,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		int count = countByEmail(email);

		List<CongDan> list = findByEmail(email, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong dans before and after the current cong dan in the ordered set where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong dan
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan[] findByEmail_PrevAndNext(long id, String email,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongDan[] array = new CongDanImpl[3];

			array[0] = getByEmail_PrevAndNext(session, congDan, email,
					orderByComparator, true);

			array[1] = congDan;

			array[2] = getByEmail_PrevAndNext(session, congDan, email,
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

	protected CongDan getByEmail_PrevAndNext(Session session, CongDan congDan,
		String email, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGDAN_WHERE);

		if (email == null) {
			query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
		}
		else {
			if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
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
			query.append(CongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (email != null) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(congDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cong dans where soCmnd = &#63;.
	 *
	 * @param soCmnd the so cmnd
	 * @return the matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findBySoCmnd(String soCmnd) throws SystemException {
		return findBySoCmnd(soCmnd, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong dans where soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soCmnd the so cmnd
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @return the range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findBySoCmnd(String soCmnd, int start, int end)
		throws SystemException {
		return findBySoCmnd(soCmnd, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong dans where soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soCmnd the so cmnd
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findBySoCmnd(String soCmnd, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND;
			finderArgs = new Object[] { soCmnd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCMND;
			finderArgs = new Object[] { soCmnd, start, end, orderByComparator };
		}

		List<CongDan> list = (List<CongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGDAN_WHERE);

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SOCMND_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_SOCMND_SOCMND_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (soCmnd != null) {
					qPos.add(soCmnd);
				}

				list = (List<CongDan>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first cong dan in the ordered set where soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soCmnd the so cmnd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findBySoCmnd_First(String soCmnd,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		List<CongDan> list = findBySoCmnd(soCmnd, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soCmnd=");
			msg.append(soCmnd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong dan in the ordered set where soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soCmnd the so cmnd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findBySoCmnd_Last(String soCmnd,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		int count = countBySoCmnd(soCmnd);

		List<CongDan> list = findBySoCmnd(soCmnd, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soCmnd=");
			msg.append(soCmnd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong dans before and after the current cong dan in the ordered set where soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong dan
	 * @param soCmnd the so cmnd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan[] findBySoCmnd_PrevAndNext(long id, String soCmnd,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongDan[] array = new CongDanImpl[3];

			array[0] = getBySoCmnd_PrevAndNext(session, congDan, soCmnd,
					orderByComparator, true);

			array[1] = congDan;

			array[2] = getBySoCmnd_PrevAndNext(session, congDan, soCmnd,
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

	protected CongDan getBySoCmnd_PrevAndNext(Session session, CongDan congDan,
		String soCmnd, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGDAN_WHERE);

		if (soCmnd == null) {
			query.append(_FINDER_COLUMN_SOCMND_SOCMND_1);
		}
		else {
			if (soCmnd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_3);
			}
			else {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_2);
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
			query.append(CongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (soCmnd != null) {
			qPos.add(soCmnd);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(congDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	 *
	 * @param ma the ma
	 * @param ten the ten
	 * @param soCmnd the so cmnd
	 * @return the matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByM_T_S(String ma, String ten, String soCmnd)
		throws SystemException {
		return findByM_T_S(ma, ten, soCmnd, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param ten the ten
	 * @param soCmnd the so cmnd
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @return the range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByM_T_S(String ma, String ten, String soCmnd,
		int start, int end) throws SystemException {
		return findByM_T_S(ma, ten, soCmnd, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param ten the ten
	 * @param soCmnd the so cmnd
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findByM_T_S(String ma, String ten, String soCmnd,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T_S;
			finderArgs = new Object[] { ma, ten, soCmnd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_M_T_S;
			finderArgs = new Object[] {
					ma, ten, soCmnd,
					
					start, end, orderByComparator
				};
		}

		List<CongDan> list = (List<CongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGDAN_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_M_T_S_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_M_T_S_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_M_T_S_MA_2);
				}
			}

			if (ten == null) {
				query.append(_FINDER_COLUMN_M_T_S_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_M_T_S_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_M_T_S_TEN_2);
				}
			}

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_M_T_S_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_M_T_S_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_M_T_S_SOCMND_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CongDanModelImpl.ORDER_BY_JPQL);
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

				if (ten != null) {
					qPos.add(ten);
				}

				if (soCmnd != null) {
					qPos.add(soCmnd);
				}

				list = (List<CongDan>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first cong dan in the ordered set where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param ten the ten
	 * @param soCmnd the so cmnd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByM_T_S_First(String ma, String ten, String soCmnd,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		List<CongDan> list = findByM_T_S(ma, ten, soCmnd, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(", ten=");
			msg.append(ten);

			msg.append(", soCmnd=");
			msg.append(soCmnd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong dan in the ordered set where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param ten the ten
	 * @param soCmnd the so cmnd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan findByM_T_S_Last(String ma, String ten, String soCmnd,
		OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		int count = countByM_T_S(ma, ten, soCmnd);

		List<CongDan> list = findByM_T_S(ma, ten, soCmnd, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(", ten=");
			msg.append(ten);

			msg.append(", soCmnd=");
			msg.append(soCmnd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong dans before and after the current cong dan in the ordered set where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong dan
	 * @param ma the ma
	 * @param ten the ten
	 * @param soCmnd the so cmnd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong dan
	 * @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongDan[] findByM_T_S_PrevAndNext(long id, String ma, String ten,
		String soCmnd, OrderByComparator orderByComparator)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongDan[] array = new CongDanImpl[3];

			array[0] = getByM_T_S_PrevAndNext(session, congDan, ma, ten,
					soCmnd, orderByComparator, true);

			array[1] = congDan;

			array[2] = getByM_T_S_PrevAndNext(session, congDan, ma, ten,
					soCmnd, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CongDan getByM_T_S_PrevAndNext(Session session, CongDan congDan,
		String ma, String ten, String soCmnd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGDAN_WHERE);

		if (ma == null) {
			query.append(_FINDER_COLUMN_M_T_S_MA_1);
		}
		else {
			if (ma.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_M_T_S_MA_3);
			}
			else {
				query.append(_FINDER_COLUMN_M_T_S_MA_2);
			}
		}

		if (ten == null) {
			query.append(_FINDER_COLUMN_M_T_S_TEN_1);
		}
		else {
			if (ten.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_M_T_S_TEN_3);
			}
			else {
				query.append(_FINDER_COLUMN_M_T_S_TEN_2);
			}
		}

		if (soCmnd == null) {
			query.append(_FINDER_COLUMN_M_T_S_SOCMND_1);
		}
		else {
			if (soCmnd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_M_T_S_SOCMND_3);
			}
			else {
				query.append(_FINDER_COLUMN_M_T_S_SOCMND_2);
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
			query.append(CongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (ma != null) {
			qPos.add(ma);
		}

		if (ten != null) {
			qPos.add(ten);
		}

		if (soCmnd != null) {
			qPos.add(soCmnd);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(congDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cong dans.
	 *
	 * @return the cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @return the range of cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong dans
	 * @param end the upper bound of the range of cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongDan> findAll(int start, int end,
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

		List<CongDan> list = (List<CongDan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONGDAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONGDAN.concat(CongDanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CongDan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CongDan>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cong dans where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (CongDan congDan : findByTrangThai(daXoa)) {
			remove(congDan);
		}
	}

	/**
	 * Removes the cong dan where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = findByMa(ma);

		remove(congDan);
	}

	/**
	 * Removes the cong dan where email = &#63; and soCmnd = &#63; from the database.
	 *
	 * @param email the email
	 * @param soCmnd the so cmnd
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEmailAndCMND(String email, String soCmnd)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = findByEmailAndCMND(email, soCmnd);

		remove(congDan);
	}

	/**
	 * Removes the cong dan where ngaySinh = &#63; and soCmnd = &#63; from the database.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNgaySinhAndCMND(Date ngaySinh, String soCmnd)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = findByNgaySinhAndCMND(ngaySinh, soCmnd);

		remove(congDan);
	}

	/**
	 * Removes the cong dan where ngaySinh = &#63; and soCmnd = &#63; from the database.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNgaySinh(Date ngaySinh, String soCmnd)
		throws NoSuchCongDanException, SystemException {
		CongDan congDan = findByNgaySinh(ngaySinh, soCmnd);

		remove(congDan);
	}

	/**
	 * Removes all the cong dans where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten) throws SystemException {
		for (CongDan congDan : findByTen(ten)) {
			remove(congDan);
		}
	}

	/**
	 * Removes all the cong dans where email = &#63; from the database.
	 *
	 * @param email the email
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEmail(String email) throws SystemException {
		for (CongDan congDan : findByEmail(email)) {
			remove(congDan);
		}
	}

	/**
	 * Removes all the cong dans where soCmnd = &#63; from the database.
	 *
	 * @param soCmnd the so cmnd
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySoCmnd(String soCmnd) throws SystemException {
		for (CongDan congDan : findBySoCmnd(soCmnd)) {
			remove(congDan);
		}
	}

	/**
	 * Removes all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param ten the ten
	 * @param soCmnd the so cmnd
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByM_T_S(String ma, String ten, String soCmnd)
		throws SystemException {
		for (CongDan congDan : findByM_T_S(ma, ten, soCmnd)) {
			remove(congDan);
		}
	}

	/**
	 * Removes all the cong dans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CongDan congDan : findAll()) {
			remove(congDan);
		}
	}

	/**
	 * Returns the number of cong dans where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGDAN_WHERE);

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
	 * Returns the number of cong dans where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGDAN_WHERE);

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
	 * Returns the number of cong dans where email = &#63; and soCmnd = &#63;.
	 *
	 * @param email the email
	 * @param soCmnd the so cmnd
	 * @return the number of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEmailAndCMND(String email, String soCmnd)
		throws SystemException {
		Object[] finderArgs = new Object[] { email, soCmnd };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILANDCMND,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONGDAN_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAILANDCMND_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAILANDCMND_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAILANDCMND_EMAIL_2);
				}
			}

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_EMAILANDCMND_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAILANDCMND_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAILANDCMND_SOCMND_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
				}

				if (soCmnd != null) {
					qPos.add(soCmnd);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILANDCMND,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong dans where ngaySinh = &#63; and soCmnd = &#63;.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @return the number of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNgaySinhAndCMND(Date ngaySinh, String soCmnd)
		throws SystemException {
		Object[] finderArgs = new Object[] { ngaySinh, soCmnd };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NGAYSINHANDCMND,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONGDAN_WHERE);

			if (ngaySinh == null) {
				query.append(_FINDER_COLUMN_NGAYSINHANDCMND_NGAYSINH_1);
			}
			else {
				query.append(_FINDER_COLUMN_NGAYSINHANDCMND_NGAYSINH_2);
			}

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_NGAYSINHANDCMND_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NGAYSINHANDCMND_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_NGAYSINHANDCMND_SOCMND_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ngaySinh != null) {
					qPos.add(CalendarUtil.getTimestamp(ngaySinh));
				}

				if (soCmnd != null) {
					qPos.add(soCmnd);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NGAYSINHANDCMND,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong dans where ngaySinh = &#63; and soCmnd = &#63;.
	 *
	 * @param ngaySinh the ngay sinh
	 * @param soCmnd the so cmnd
	 * @return the number of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNgaySinh(Date ngaySinh, String soCmnd)
		throws SystemException {
		Object[] finderArgs = new Object[] { ngaySinh, soCmnd };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NGAYSINH,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONGDAN_WHERE);

			if (ngaySinh == null) {
				query.append(_FINDER_COLUMN_NGAYSINH_NGAYSINH_1);
			}
			else {
				query.append(_FINDER_COLUMN_NGAYSINH_NGAYSINH_2);
			}

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_NGAYSINH_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NGAYSINH_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_NGAYSINH_SOCMND_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ngaySinh != null) {
					qPos.add(CalendarUtil.getTimestamp(ngaySinh));
				}

				if (soCmnd != null) {
					qPos.add(soCmnd);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NGAYSINH,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong dans where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGDAN_WHERE);

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
	 * Returns the number of cong dans where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEmail(String email) throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAIL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGDAN_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong dans where soCmnd = &#63;.
	 *
	 * @param soCmnd the so cmnd
	 * @return the number of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySoCmnd(String soCmnd) throws SystemException {
		Object[] finderArgs = new Object[] { soCmnd };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SOCMND,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGDAN_WHERE);

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SOCMND_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_SOCMND_SOCMND_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (soCmnd != null) {
					qPos.add(soCmnd);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SOCMND,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	 *
	 * @param ma the ma
	 * @param ten the ten
	 * @param soCmnd the so cmnd
	 * @return the number of matching cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByM_T_S(String ma, String ten, String soCmnd)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma, ten, soCmnd };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_M_T_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONGDAN_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_M_T_S_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_M_T_S_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_M_T_S_MA_2);
				}
			}

			if (ten == null) {
				query.append(_FINDER_COLUMN_M_T_S_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_M_T_S_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_M_T_S_TEN_2);
				}
			}

			if (soCmnd == null) {
				query.append(_FINDER_COLUMN_M_T_S_SOCMND_1);
			}
			else {
				if (soCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_M_T_S_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_M_T_S_SOCMND_2);
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

				if (ten != null) {
					qPos.add(ten);
				}

				if (soCmnd != null) {
					qPos.add(soCmnd);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_M_T_S,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong dans.
	 *
	 * @return the number of cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONGDAN);

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
	 * Initializes the cong dan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cd.model.CongDan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CongDan>> listenersList = new ArrayList<ModelListener<CongDan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CongDan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CongDanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChuyenMonPersistence.class)
	protected ChuyenMonPersistence chuyenMonPersistence;
	@BeanReference(type = CongDanPersistence.class)
	protected CongDanPersistence congDanPersistence;
	@BeanReference(type = DanTocPersistence.class)
	protected DanTocPersistence danTocPersistence;
	@BeanReference(type = GioiTinhPersistence.class)
	protected GioiTinhPersistence gioiTinhPersistence;
	@BeanReference(type = HeThongPersistence.class)
	protected HeThongPersistence heThongPersistence;
	@BeanReference(type = HoChieuCMNDPersistence.class)
	protected HoChieuCMNDPersistence hoChieuCMNDPersistence;
	@BeanReference(type = NgheNghiepPersistence.class)
	protected NgheNghiepPersistence ngheNghiepPersistence;
	@BeanReference(type = QuanHeGiaDinhPersistence.class)
	protected QuanHeGiaDinhPersistence quanHeGiaDinhPersistence;
	@BeanReference(type = TinhTrangHonNhanPersistence.class)
	protected TinhTrangHonNhanPersistence tinhTrangHonNhanPersistence;
	@BeanReference(type = TonGiaoPersistence.class)
	protected TonGiaoPersistence tonGiaoPersistence;
	@BeanReference(type = TrinhDoChuyenMonPersistence.class)
	protected TrinhDoChuyenMonPersistence trinhDoChuyenMonPersistence;
	@BeanReference(type = TrinhDoHocVanPersistence.class)
	protected TrinhDoHocVanPersistence trinhDoHocVanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CONGDAN = "SELECT congDan FROM CongDan congDan";
	private static final String _SQL_SELECT_CONGDAN_WHERE = "SELECT congDan FROM CongDan congDan WHERE ";
	private static final String _SQL_COUNT_CONGDAN = "SELECT COUNT(congDan) FROM CongDan congDan";
	private static final String _SQL_COUNT_CONGDAN_WHERE = "SELECT COUNT(congDan) FROM CongDan congDan WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "congDan.daXoa = ?";
	private static final String _FINDER_COLUMN_MA_MA_1 = "congDan.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "congDan.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(congDan.ma IS NULL OR congDan.ma = ?)";
	private static final String _FINDER_COLUMN_EMAILANDCMND_EMAIL_1 = "congDan.email IS NULL AND ";
	private static final String _FINDER_COLUMN_EMAILANDCMND_EMAIL_2 = "congDan.email = ? AND ";
	private static final String _FINDER_COLUMN_EMAILANDCMND_EMAIL_3 = "(congDan.email IS NULL OR congDan.email = ?) AND ";
	private static final String _FINDER_COLUMN_EMAILANDCMND_SOCMND_1 = "congDan.soCmnd IS NULL";
	private static final String _FINDER_COLUMN_EMAILANDCMND_SOCMND_2 = "congDan.soCmnd = ?";
	private static final String _FINDER_COLUMN_EMAILANDCMND_SOCMND_3 = "(congDan.soCmnd IS NULL OR congDan.soCmnd = ?)";
	private static final String _FINDER_COLUMN_NGAYSINHANDCMND_NGAYSINH_1 = "congDan.ngaySinh IS NULL AND ";
	private static final String _FINDER_COLUMN_NGAYSINHANDCMND_NGAYSINH_2 = "congDan.ngaySinh = ? AND ";
	private static final String _FINDER_COLUMN_NGAYSINHANDCMND_SOCMND_1 = "congDan.soCmnd IS NULL";
	private static final String _FINDER_COLUMN_NGAYSINHANDCMND_SOCMND_2 = "congDan.soCmnd = ?";
	private static final String _FINDER_COLUMN_NGAYSINHANDCMND_SOCMND_3 = "(congDan.soCmnd IS NULL OR congDan.soCmnd = ?)";
	private static final String _FINDER_COLUMN_NGAYSINH_NGAYSINH_1 = "congDan.ngaySinh IS NULL AND ";
	private static final String _FINDER_COLUMN_NGAYSINH_NGAYSINH_2 = "congDan.ngaySinh = ? AND ";
	private static final String _FINDER_COLUMN_NGAYSINH_SOCMND_1 = "congDan.soCmnd IS NULL";
	private static final String _FINDER_COLUMN_NGAYSINH_SOCMND_2 = "congDan.soCmnd = ?";
	private static final String _FINDER_COLUMN_NGAYSINH_SOCMND_3 = "(congDan.soCmnd IS NULL OR congDan.soCmnd = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "congDan.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "congDan.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(congDan.ten IS NULL OR congDan.ten = ?)";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "congDan.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "congDan.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(congDan.email IS NULL OR congDan.email = ?)";
	private static final String _FINDER_COLUMN_SOCMND_SOCMND_1 = "congDan.soCmnd IS NULL";
	private static final String _FINDER_COLUMN_SOCMND_SOCMND_2 = "congDan.soCmnd = ?";
	private static final String _FINDER_COLUMN_SOCMND_SOCMND_3 = "(congDan.soCmnd IS NULL OR congDan.soCmnd = ?)";
	private static final String _FINDER_COLUMN_M_T_S_MA_1 = "congDan.ma IS NULL AND ";
	private static final String _FINDER_COLUMN_M_T_S_MA_2 = "congDan.ma = ? AND ";
	private static final String _FINDER_COLUMN_M_T_S_MA_3 = "(congDan.ma IS NULL OR congDan.ma = ?) AND ";
	private static final String _FINDER_COLUMN_M_T_S_TEN_1 = "congDan.ten IS NULL AND ";
	private static final String _FINDER_COLUMN_M_T_S_TEN_2 = "congDan.ten = ? AND ";
	private static final String _FINDER_COLUMN_M_T_S_TEN_3 = "(congDan.ten IS NULL OR congDan.ten = ?) AND ";
	private static final String _FINDER_COLUMN_M_T_S_SOCMND_1 = "congDan.soCmnd IS NULL";
	private static final String _FINDER_COLUMN_M_T_S_SOCMND_2 = "congDan.soCmnd = ?";
	private static final String _FINDER_COLUMN_M_T_S_SOCMND_3 = "(congDan.soCmnd IS NULL OR congDan.soCmnd = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "congDan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CongDan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CongDan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CongDanPersistenceImpl.class);
	private static CongDan _nullCongDan = new CongDanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CongDan> toCacheModel() {
				return _nullCongDanCacheModel;
			}
		};

	private static CacheModel<CongDan> _nullCongDanCacheModel = new CacheModel<CongDan>() {
			public CongDan toEntityModel() {
				return _nullCongDan;
			}
		};
}