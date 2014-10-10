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

import org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;
import org.oep.cmon.dao.qlhc.model.impl.ChucVu2VaiTroImpl;
import org.oep.cmon.dao.qlhc.model.impl.ChucVu2VaiTroModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the chuc vu2 vai tro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see ChucVu2VaiTroPersistence
 * @see ChucVu2VaiTroUtil
 * @generated
 */
public class ChucVu2VaiTroPersistenceImpl extends BasePersistenceImpl<ChucVu2VaiTro>
	implements ChucVu2VaiTroPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChucVu2VaiTroUtil} to access the chuc vu2 vai tro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChucVu2VaiTroImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_CHUCVU2VAITRO = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByChucVu2VaiTro",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ChucVu2VaiTroModelImpl.VAITROID_COLUMN_BITMASK |
			ChucVu2VaiTroModelImpl.COQUANQUANLYID_COLUMN_BITMASK |
			ChucVu2VaiTroModelImpl.CHUCVUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHUCVU2VAITRO = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChucVu2VaiTro",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VAITROID = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVaiTroId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVaiTroId", new String[] { Long.class.getName() },
			ChucVu2VaiTroModelImpl.VAITROID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VAITROID = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVaiTroId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANQUANLYID =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCoQuanQuanLyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCoQuanQuanLyId", new String[] { Long.class.getName() },
			ChucVu2VaiTroModelImpl.COQUANQUANLYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COQUANQUANLYID = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCoQuanQuanLyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHUCVUID = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByChucVuId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChucVuId", new String[] { Long.class.getName() },
			ChucVu2VaiTroModelImpl.CHUCVUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHUCVUID = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChucVuId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VAITROIDANDDAXOA =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVaiTroIdAndDaXoa",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROIDANDDAXOA =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVaiTroIdAndDaXoa",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ChucVu2VaiTroModelImpl.VAITROID_COLUMN_BITMASK |
			ChucVu2VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VAITROIDANDDAXOA = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVaiTroIdAndDaXoa",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANQUANLYIDANDDAXOA =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCoQuanQuanLyIdAndDaXoa",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYIDANDDAXOA =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCoQuanQuanLyIdAndDaXoa",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ChucVu2VaiTroModelImpl.COQUANQUANLYID_COLUMN_BITMASK |
			ChucVu2VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COQUANQUANLYIDANDDAXOA = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCoQuanQuanLyIdAndDaXoa",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHUCVUIDANDDAXOA =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByChucVuIdAndDaXoa",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDDAXOA =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChucVuIdAndDaXoa",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ChucVu2VaiTroModelImpl.CHUCVUID_COLUMN_BITMASK |
			ChucVu2VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHUCVUIDANDDAXOA = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChucVuIdAndDaXoa",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHUCVUIDANDCOQUANQUANLYID =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByChucVuIdAndCoQuanQuanLyId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDCOQUANQUANLYID =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChucVuIdAndCoQuanQuanLyId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ChucVu2VaiTroModelImpl.CHUCVUID_COLUMN_BITMASK |
			ChucVu2VaiTroModelImpl.COQUANQUANLYID_COLUMN_BITMASK |
			ChucVu2VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHUCVUIDANDCOQUANQUANLYID =
		new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChucVuIdAndCoQuanQuanLyId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DAXOA = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDaXoa",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDaXoa", new String[] { Integer.class.getName() },
			ChucVu2VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DAXOA = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDaXoa",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the chuc vu2 vai tro in the entity cache if it is enabled.
	 *
	 * @param chucVu2VaiTro the chuc vu2 vai tro
	 */
	public void cacheResult(ChucVu2VaiTro chucVu2VaiTro) {
		EntityCacheUtil.putResult(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, chucVu2VaiTro.getPrimaryKey(),
			chucVu2VaiTro);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHUCVU2VAITRO,
			new Object[] {
				Long.valueOf(chucVu2VaiTro.getVaiTroId()),
				Long.valueOf(chucVu2VaiTro.getCoQuanQuanLyId()),
				Long.valueOf(chucVu2VaiTro.getChucVuId())
			}, chucVu2VaiTro);

		chucVu2VaiTro.resetOriginalValues();
	}

	/**
	 * Caches the chuc vu2 vai tros in the entity cache if it is enabled.
	 *
	 * @param chucVu2VaiTros the chuc vu2 vai tros
	 */
	public void cacheResult(List<ChucVu2VaiTro> chucVu2VaiTros) {
		for (ChucVu2VaiTro chucVu2VaiTro : chucVu2VaiTros) {
			if (EntityCacheUtil.getResult(
						ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
						ChucVu2VaiTroImpl.class, chucVu2VaiTro.getPrimaryKey()) == null) {
				cacheResult(chucVu2VaiTro);
			}
			else {
				chucVu2VaiTro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chuc vu2 vai tros.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChucVu2VaiTroImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChucVu2VaiTroImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chuc vu2 vai tro.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChucVu2VaiTro chucVu2VaiTro) {
		EntityCacheUtil.removeResult(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, chucVu2VaiTro.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(chucVu2VaiTro);
	}

	@Override
	public void clearCache(List<ChucVu2VaiTro> chucVu2VaiTros) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChucVu2VaiTro chucVu2VaiTro : chucVu2VaiTros) {
			EntityCacheUtil.removeResult(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
				ChucVu2VaiTroImpl.class, chucVu2VaiTro.getPrimaryKey());

			clearUniqueFindersCache(chucVu2VaiTro);
		}
	}

	protected void clearUniqueFindersCache(ChucVu2VaiTro chucVu2VaiTro) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHUCVU2VAITRO,
			new Object[] {
				Long.valueOf(chucVu2VaiTro.getVaiTroId()),
				Long.valueOf(chucVu2VaiTro.getCoQuanQuanLyId()),
				Long.valueOf(chucVu2VaiTro.getChucVuId())
			});
	}

	/**
	 * Creates a new chuc vu2 vai tro with the primary key. Does not add the chuc vu2 vai tro to the database.
	 *
	 * @param id the primary key for the new chuc vu2 vai tro
	 * @return the new chuc vu2 vai tro
	 */
	public ChucVu2VaiTro create(long id) {
		ChucVu2VaiTro chucVu2VaiTro = new ChucVu2VaiTroImpl();

		chucVu2VaiTro.setNew(true);
		chucVu2VaiTro.setPrimaryKey(id);

		return chucVu2VaiTro;
	}

	/**
	 * Removes the chuc vu2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chuc vu2 vai tro
	 * @return the chuc vu2 vai tro that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro remove(long id)
		throws NoSuchChucVu2VaiTroException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the chuc vu2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chuc vu2 vai tro
	 * @return the chuc vu2 vai tro that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChucVu2VaiTro remove(Serializable primaryKey)
		throws NoSuchChucVu2VaiTroException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChucVu2VaiTro chucVu2VaiTro = (ChucVu2VaiTro)session.get(ChucVu2VaiTroImpl.class,
					primaryKey);

			if (chucVu2VaiTro == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChucVu2VaiTroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chucVu2VaiTro);
		}
		catch (NoSuchChucVu2VaiTroException nsee) {
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
	protected ChucVu2VaiTro removeImpl(ChucVu2VaiTro chucVu2VaiTro)
		throws SystemException {
		chucVu2VaiTro = toUnwrappedModel(chucVu2VaiTro);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, chucVu2VaiTro);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(chucVu2VaiTro);

		return chucVu2VaiTro;
	}

	@Override
	public ChucVu2VaiTro updateImpl(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro, boolean merge)
		throws SystemException {
		chucVu2VaiTro = toUnwrappedModel(chucVu2VaiTro);

		boolean isNew = chucVu2VaiTro.isNew();

		ChucVu2VaiTroModelImpl chucVu2VaiTroModelImpl = (ChucVu2VaiTroModelImpl)chucVu2VaiTro;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, chucVu2VaiTro, merge);

			chucVu2VaiTro.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChucVu2VaiTroModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((chucVu2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalVaiTroId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAITROID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID,
					args);

				args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getVaiTroId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAITROID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID,
					args);
			}

			if ((chucVu2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalCoQuanQuanLyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID,
					args);

				args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getCoQuanQuanLyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID,
					args);
			}

			if ((chucVu2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalChucVuId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHUCVUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID,
					args);

				args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getChucVuId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHUCVUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID,
					args);
			}

			if ((chucVu2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROIDANDDAXOA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalVaiTroId()),
						Integer.valueOf(chucVu2VaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAITROIDANDDAXOA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROIDANDDAXOA,
					args);

				args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getVaiTroId()),
						Integer.valueOf(chucVu2VaiTroModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAITROIDANDDAXOA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROIDANDDAXOA,
					args);
			}

			if ((chucVu2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYIDANDDAXOA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalCoQuanQuanLyId()),
						Integer.valueOf(chucVu2VaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANQUANLYIDANDDAXOA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYIDANDDAXOA,
					args);

				args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getCoQuanQuanLyId()),
						Integer.valueOf(chucVu2VaiTroModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANQUANLYIDANDDAXOA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYIDANDDAXOA,
					args);
			}

			if ((chucVu2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDDAXOA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalChucVuId()),
						Integer.valueOf(chucVu2VaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHUCVUIDANDDAXOA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDDAXOA,
					args);

				args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getChucVuId()),
						Integer.valueOf(chucVu2VaiTroModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHUCVUIDANDDAXOA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDDAXOA,
					args);
			}

			if ((chucVu2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDCOQUANQUANLYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalChucVuId()),
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalCoQuanQuanLyId()),
						Integer.valueOf(chucVu2VaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHUCVUIDANDCOQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDCOQUANQUANLYID,
					args);

				args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getChucVuId()),
						Long.valueOf(chucVu2VaiTroModelImpl.getCoQuanQuanLyId()),
						Integer.valueOf(chucVu2VaiTroModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHUCVUIDANDCOQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDCOQUANQUANLYID,
					args);
			}

			if ((chucVu2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(chucVu2VaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAXOA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA,
					args);

				args = new Object[] {
						Integer.valueOf(chucVu2VaiTroModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAXOA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA,
					args);
			}
		}

		EntityCacheUtil.putResult(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			ChucVu2VaiTroImpl.class, chucVu2VaiTro.getPrimaryKey(),
			chucVu2VaiTro);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHUCVU2VAITRO,
				new Object[] {
					Long.valueOf(chucVu2VaiTro.getVaiTroId()),
					Long.valueOf(chucVu2VaiTro.getCoQuanQuanLyId()),
					Long.valueOf(chucVu2VaiTro.getChucVuId())
				}, chucVu2VaiTro);
		}
		else {
			if ((chucVu2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CHUCVU2VAITRO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalVaiTroId()),
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalCoQuanQuanLyId()),
						Long.valueOf(chucVu2VaiTroModelImpl.getOriginalChucVuId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHUCVU2VAITRO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHUCVU2VAITRO,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHUCVU2VAITRO,
					new Object[] {
						Long.valueOf(chucVu2VaiTro.getVaiTroId()),
						Long.valueOf(chucVu2VaiTro.getCoQuanQuanLyId()),
						Long.valueOf(chucVu2VaiTro.getChucVuId())
					}, chucVu2VaiTro);
			}
		}

		return chucVu2VaiTro;
	}

	protected ChucVu2VaiTro toUnwrappedModel(ChucVu2VaiTro chucVu2VaiTro) {
		if (chucVu2VaiTro instanceof ChucVu2VaiTroImpl) {
			return chucVu2VaiTro;
		}

		ChucVu2VaiTroImpl chucVu2VaiTroImpl = new ChucVu2VaiTroImpl();

		chucVu2VaiTroImpl.setNew(chucVu2VaiTro.isNew());
		chucVu2VaiTroImpl.setPrimaryKey(chucVu2VaiTro.getPrimaryKey());

		chucVu2VaiTroImpl.setId(chucVu2VaiTro.getId());
		chucVu2VaiTroImpl.setNgayTao(chucVu2VaiTro.getNgayTao());
		chucVu2VaiTroImpl.setNgaySua(chucVu2VaiTro.getNgaySua());
		chucVu2VaiTroImpl.setDaXoa(chucVu2VaiTro.getDaXoa());
		chucVu2VaiTroImpl.setNguoiTao(chucVu2VaiTro.getNguoiTao());
		chucVu2VaiTroImpl.setNguoiSua(chucVu2VaiTro.getNguoiSua());
		chucVu2VaiTroImpl.setVaiTroId(chucVu2VaiTro.getVaiTroId());
		chucVu2VaiTroImpl.setCoQuanQuanLyId(chucVu2VaiTro.getCoQuanQuanLyId());
		chucVu2VaiTroImpl.setChucVuId(chucVu2VaiTro.getChucVuId());

		return chucVu2VaiTroImpl;
	}

	/**
	 * Returns the chuc vu2 vai tro with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chuc vu2 vai tro
	 * @return the chuc vu2 vai tro
	 * @throws com.liferay.portal.NoSuchModelException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChucVu2VaiTro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the chuc vu2 vai tro with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException} if it could not be found.
	 *
	 * @param id the primary key of the chuc vu2 vai tro
	 * @return the chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByPrimaryKey(long id)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = fetchByPrimaryKey(id);

		if (chucVu2VaiTro == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchChucVu2VaiTroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return chucVu2VaiTro;
	}

	/**
	 * Returns the chuc vu2 vai tro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chuc vu2 vai tro
	 * @return the chuc vu2 vai tro, or <code>null</code> if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChucVu2VaiTro fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the chuc vu2 vai tro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chuc vu2 vai tro
	 * @return the chuc vu2 vai tro, or <code>null</code> if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro fetchByPrimaryKey(long id) throws SystemException {
		ChucVu2VaiTro chucVu2VaiTro = (ChucVu2VaiTro)EntityCacheUtil.getResult(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
				ChucVu2VaiTroImpl.class, id);

		if (chucVu2VaiTro == _nullChucVu2VaiTro) {
			return null;
		}

		if (chucVu2VaiTro == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				chucVu2VaiTro = (ChucVu2VaiTro)session.get(ChucVu2VaiTroImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (chucVu2VaiTro != null) {
					cacheResult(chucVu2VaiTro);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ChucVu2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
						ChucVu2VaiTroImpl.class, id, _nullChucVu2VaiTro);
				}

				closeSession(session);
			}
		}

		return chucVu2VaiTro;
	}

	/**
	 * Returns the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException} if it could not be found.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param chucVuId the chuc vu ID
	 * @return the matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByChucVu2VaiTro(Long vaiTroId,
		Long coQuanQuanLyId, Long chucVuId)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = fetchByChucVu2VaiTro(vaiTroId,
				coQuanQuanLyId, chucVuId);

		if (chucVu2VaiTro == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(", coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(", chucVuId=");
			msg.append(chucVuId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}

		return chucVu2VaiTro;
	}

	/**
	 * Returns the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param chucVuId the chuc vu ID
	 * @return the matching chuc vu2 vai tro, or <code>null</code> if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro fetchByChucVu2VaiTro(Long vaiTroId,
		Long coQuanQuanLyId, Long chucVuId) throws SystemException {
		return fetchByChucVu2VaiTro(vaiTroId, coQuanQuanLyId, chucVuId, true);
	}

	/**
	 * Returns the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param chucVuId the chuc vu ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching chuc vu2 vai tro, or <code>null</code> if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro fetchByChucVu2VaiTro(Long vaiTroId,
		Long coQuanQuanLyId, Long chucVuId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { vaiTroId, coQuanQuanLyId, chucVuId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CHUCVU2VAITRO,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_CHUCVU2VAITRO_VAITROID_2);

			query.append(_FINDER_COLUMN_CHUCVU2VAITRO_COQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_CHUCVU2VAITRO_CHUCVUID_2);

			query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vaiTroId.longValue());

				qPos.add(coQuanQuanLyId.longValue());

				qPos.add(chucVuId.longValue());

				List<ChucVu2VaiTro> list = q.list();

				result = list;

				ChucVu2VaiTro chucVu2VaiTro = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHUCVU2VAITRO,
						finderArgs, list);
				}
				else {
					chucVu2VaiTro = list.get(0);

					cacheResult(chucVu2VaiTro);

					if ((chucVu2VaiTro.getVaiTroId() != vaiTroId) ||
							(chucVu2VaiTro.getCoQuanQuanLyId() != coQuanQuanLyId) ||
							(chucVu2VaiTro.getChucVuId() != chucVuId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHUCVU2VAITRO,
							finderArgs, chucVu2VaiTro);
					}
				}

				return chucVu2VaiTro;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHUCVU2VAITRO,
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
				return (ChucVu2VaiTro)result;
			}
		}
	}

	/**
	 * Returns all the chuc vu2 vai tros where vaiTroId = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @return the matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByVaiTroId(Long vaiTroId)
		throws SystemException {
		return findByVaiTroId(vaiTroId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the chuc vu2 vai tros where vaiTroId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @return the range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByVaiTroId(Long vaiTroId, int start, int end)
		throws SystemException {
		return findByVaiTroId(vaiTroId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vu2 vai tros where vaiTroId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByVaiTroId(Long vaiTroId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID;
			finderArgs = new Object[] { vaiTroId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VAITROID;
			finderArgs = new Object[] { vaiTroId, start, end, orderByComparator };
		}

		List<ChucVu2VaiTro> list = (List<ChucVu2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_VAITROID_VAITROID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vaiTroId.longValue());

				list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chuc vu2 vai tro in the ordered set where vaiTroId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByVaiTroId_First(Long vaiTroId,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		List<ChucVu2VaiTro> list = findByVaiTroId(vaiTroId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu2 vai tro in the ordered set where vaiTroId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByVaiTroId_Last(Long vaiTroId,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		int count = countByVaiTroId(vaiTroId);

		List<ChucVu2VaiTro> list = findByVaiTroId(vaiTroId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where vaiTroId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu2 vai tro
	 * @param vaiTroId the vai tro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro[] findByVaiTroId_PrevAndNext(long id, Long vaiTroId,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu2VaiTro[] array = new ChucVu2VaiTroImpl[3];

			array[0] = getByVaiTroId_PrevAndNext(session, chucVu2VaiTro,
					vaiTroId, orderByComparator, true);

			array[1] = chucVu2VaiTro;

			array[2] = getByVaiTroId_PrevAndNext(session, chucVu2VaiTro,
					vaiTroId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChucVu2VaiTro getByVaiTroId_PrevAndNext(Session session,
		ChucVu2VaiTro chucVu2VaiTro, Long vaiTroId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_VAITROID_VAITROID_2);

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
			query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vaiTroId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @return the matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByCoQuanQuanLyId(Long coQuanQuanLyId)
		throws SystemException {
		return findByCoQuanQuanLyId(coQuanQuanLyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @return the range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByCoQuanQuanLyId(Long coQuanQuanLyId,
		int start, int end) throws SystemException {
		return findByCoQuanQuanLyId(coQuanQuanLyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByCoQuanQuanLyId(Long coQuanQuanLyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID;
			finderArgs = new Object[] { coQuanQuanLyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANQUANLYID;
			finderArgs = new Object[] {
					coQuanQuanLyId,
					
					start, end, orderByComparator
				};
		}

		List<ChucVu2VaiTro> list = (List<ChucVu2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId.longValue());

				list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByCoQuanQuanLyId_First(Long coQuanQuanLyId,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		List<ChucVu2VaiTro> list = findByCoQuanQuanLyId(coQuanQuanLyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByCoQuanQuanLyId_Last(Long coQuanQuanLyId,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		int count = countByCoQuanQuanLyId(coQuanQuanLyId);

		List<ChucVu2VaiTro> list = findByCoQuanQuanLyId(coQuanQuanLyId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu2 vai tro
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro[] findByCoQuanQuanLyId_PrevAndNext(long id,
		Long coQuanQuanLyId, OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu2VaiTro[] array = new ChucVu2VaiTroImpl[3];

			array[0] = getByCoQuanQuanLyId_PrevAndNext(session, chucVu2VaiTro,
					coQuanQuanLyId, orderByComparator, true);

			array[1] = chucVu2VaiTro;

			array[2] = getByCoQuanQuanLyId_PrevAndNext(session, chucVu2VaiTro,
					coQuanQuanLyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChucVu2VaiTro getByCoQuanQuanLyId_PrevAndNext(Session session,
		ChucVu2VaiTro chucVu2VaiTro, Long coQuanQuanLyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2);

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
			query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(coQuanQuanLyId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vu2 vai tros where chucVuId = &#63;.
	 *
	 * @param chucVuId the chuc vu ID
	 * @return the matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByChucVuId(Long chucVuId)
		throws SystemException {
		return findByChucVuId(chucVuId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the chuc vu2 vai tros where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @return the range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByChucVuId(Long chucVuId, int start, int end)
		throws SystemException {
		return findByChucVuId(chucVuId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vu2 vai tros where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByChucVuId(Long chucVuId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID;
			finderArgs = new Object[] { chucVuId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHUCVUID;
			finderArgs = new Object[] { chucVuId, start, end, orderByComparator };
		}

		List<ChucVu2VaiTro> list = (List<ChucVu2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_CHUCVUID_CHUCVUID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chucVuId.longValue());

				list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chuc vu2 vai tro in the ordered set where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByChucVuId_First(Long chucVuId,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		List<ChucVu2VaiTro> list = findByChucVuId(chucVuId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chucVuId=");
			msg.append(chucVuId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu2 vai tro in the ordered set where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByChucVuId_Last(Long chucVuId,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		int count = countByChucVuId(chucVuId);

		List<ChucVu2VaiTro> list = findByChucVuId(chucVuId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chucVuId=");
			msg.append(chucVuId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu2 vai tro
	 * @param chucVuId the chuc vu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro[] findByChucVuId_PrevAndNext(long id, Long chucVuId,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu2VaiTro[] array = new ChucVu2VaiTroImpl[3];

			array[0] = getByChucVuId_PrevAndNext(session, chucVu2VaiTro,
					chucVuId, orderByComparator, true);

			array[1] = chucVu2VaiTro;

			array[2] = getByChucVuId_PrevAndNext(session, chucVu2VaiTro,
					chucVuId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChucVu2VaiTro getByChucVuId_PrevAndNext(Session session,
		ChucVu2VaiTro chucVu2VaiTro, Long chucVuId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_CHUCVUID_CHUCVUID_2);

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
			query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chucVuId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @return the matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByVaiTroIdAndDaXoa(Long vaiTroId, int daXoa)
		throws SystemException {
		return findByVaiTroIdAndDaXoa(vaiTroId, daXoa, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @return the range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByVaiTroIdAndDaXoa(Long vaiTroId, int daXoa,
		int start, int end) throws SystemException {
		return findByVaiTroIdAndDaXoa(vaiTroId, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByVaiTroIdAndDaXoa(Long vaiTroId, int daXoa,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROIDANDDAXOA;
			finderArgs = new Object[] { vaiTroId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VAITROIDANDDAXOA;
			finderArgs = new Object[] {
					vaiTroId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<ChucVu2VaiTro> list = (List<ChucVu2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_VAITROIDANDDAXOA_VAITROID_2);

			query.append(_FINDER_COLUMN_VAITROIDANDDAXOA_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vaiTroId.longValue());

				qPos.add(daXoa);

				list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chuc vu2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByVaiTroIdAndDaXoa_First(Long vaiTroId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		List<ChucVu2VaiTro> list = findByVaiTroIdAndDaXoa(vaiTroId, daXoa, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByVaiTroIdAndDaXoa_Last(Long vaiTroId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		int count = countByVaiTroIdAndDaXoa(vaiTroId, daXoa);

		List<ChucVu2VaiTro> list = findByVaiTroIdAndDaXoa(vaiTroId, daXoa,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu2 vai tro
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro[] findByVaiTroIdAndDaXoa_PrevAndNext(long id,
		Long vaiTroId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu2VaiTro[] array = new ChucVu2VaiTroImpl[3];

			array[0] = getByVaiTroIdAndDaXoa_PrevAndNext(session,
					chucVu2VaiTro, vaiTroId, daXoa, orderByComparator, true);

			array[1] = chucVu2VaiTro;

			array[2] = getByVaiTroIdAndDaXoa_PrevAndNext(session,
					chucVu2VaiTro, vaiTroId, daXoa, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChucVu2VaiTro getByVaiTroIdAndDaXoa_PrevAndNext(Session session,
		ChucVu2VaiTro chucVu2VaiTro, Long vaiTroId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_VAITROIDANDDAXOA_VAITROID_2);

		query.append(_FINDER_COLUMN_VAITROIDANDDAXOA_DAXOA_2);

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
			query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vaiTroId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @return the matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByCoQuanQuanLyIdAndDaXoa(
		Long coQuanQuanLyId, int daXoa) throws SystemException {
		return findByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @return the range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByCoQuanQuanLyIdAndDaXoa(
		Long coQuanQuanLyId, int daXoa, int start, int end)
		throws SystemException {
		return findByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId, daXoa, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByCoQuanQuanLyIdAndDaXoa(
		Long coQuanQuanLyId, int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYIDANDDAXOA;
			finderArgs = new Object[] { coQuanQuanLyId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANQUANLYIDANDDAXOA;
			finderArgs = new Object[] {
					coQuanQuanLyId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<ChucVu2VaiTro> list = (List<ChucVu2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_COQUANQUANLYIDANDDAXOA_COQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_COQUANQUANLYIDANDDAXOA_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId.longValue());

				qPos.add(daXoa);

				list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByCoQuanQuanLyIdAndDaXoa_First(
		Long coQuanQuanLyId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		List<ChucVu2VaiTro> list = findByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId,
				daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByCoQuanQuanLyIdAndDaXoa_Last(
		Long coQuanQuanLyId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		int count = countByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId, daXoa);

		List<ChucVu2VaiTro> list = findByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId,
				daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu2 vai tro
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro[] findByCoQuanQuanLyIdAndDaXoa_PrevAndNext(long id,
		Long coQuanQuanLyId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu2VaiTro[] array = new ChucVu2VaiTroImpl[3];

			array[0] = getByCoQuanQuanLyIdAndDaXoa_PrevAndNext(session,
					chucVu2VaiTro, coQuanQuanLyId, daXoa, orderByComparator,
					true);

			array[1] = chucVu2VaiTro;

			array[2] = getByCoQuanQuanLyIdAndDaXoa_PrevAndNext(session,
					chucVu2VaiTro, coQuanQuanLyId, daXoa, orderByComparator,
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

	protected ChucVu2VaiTro getByCoQuanQuanLyIdAndDaXoa_PrevAndNext(
		Session session, ChucVu2VaiTro chucVu2VaiTro, Long coQuanQuanLyId,
		int daXoa, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_COQUANQUANLYIDANDDAXOA_COQUANQUANLYID_2);

		query.append(_FINDER_COLUMN_COQUANQUANLYIDANDDAXOA_DAXOA_2);

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
			query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(coQuanQuanLyId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	 *
	 * @param chucVuId the chuc vu ID
	 * @param daXoa the da xoa
	 * @return the matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByChucVuIdAndDaXoa(Long chucVuId, int daXoa)
		throws SystemException {
		return findByChucVuIdAndDaXoa(chucVuId, daXoa, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @return the range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByChucVuIdAndDaXoa(Long chucVuId, int daXoa,
		int start, int end) throws SystemException {
		return findByChucVuIdAndDaXoa(chucVuId, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByChucVuIdAndDaXoa(Long chucVuId, int daXoa,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDDAXOA;
			finderArgs = new Object[] { chucVuId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHUCVUIDANDDAXOA;
			finderArgs = new Object[] {
					chucVuId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<ChucVu2VaiTro> list = (List<ChucVu2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_CHUCVUIDANDDAXOA_CHUCVUID_2);

			query.append(_FINDER_COLUMN_CHUCVUIDANDDAXOA_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chucVuId.longValue());

				qPos.add(daXoa);

				list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chuc vu2 vai tro in the ordered set where chucVuId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByChucVuIdAndDaXoa_First(Long chucVuId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		List<ChucVu2VaiTro> list = findByChucVuIdAndDaXoa(chucVuId, daXoa, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chucVuId=");
			msg.append(chucVuId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu2 vai tro in the ordered set where chucVuId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByChucVuIdAndDaXoa_Last(Long chucVuId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		int count = countByChucVuIdAndDaXoa(chucVuId, daXoa);

		List<ChucVu2VaiTro> list = findByChucVuIdAndDaXoa(chucVuId, daXoa,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chucVuId=");
			msg.append(chucVuId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where chucVuId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu2 vai tro
	 * @param chucVuId the chuc vu ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro[] findByChucVuIdAndDaXoa_PrevAndNext(long id,
		Long chucVuId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu2VaiTro[] array = new ChucVu2VaiTroImpl[3];

			array[0] = getByChucVuIdAndDaXoa_PrevAndNext(session,
					chucVu2VaiTro, chucVuId, daXoa, orderByComparator, true);

			array[1] = chucVu2VaiTro;

			array[2] = getByChucVuIdAndDaXoa_PrevAndNext(session,
					chucVu2VaiTro, chucVuId, daXoa, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChucVu2VaiTro getByChucVuIdAndDaXoa_PrevAndNext(Session session,
		ChucVu2VaiTro chucVu2VaiTro, Long chucVuId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_CHUCVUIDANDDAXOA_CHUCVUID_2);

		query.append(_FINDER_COLUMN_CHUCVUIDANDDAXOA_DAXOA_2);

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
			query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chucVuId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * @param chucVuId the chuc vu ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @return the matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByChucVuIdAndCoQuanQuanLyId(Long chucVuId,
		Long coQuanQuanLyId, int daXoa) throws SystemException {
		return findByChucVuIdAndCoQuanQuanLyId(chucVuId, coQuanQuanLyId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @return the range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByChucVuIdAndCoQuanQuanLyId(Long chucVuId,
		Long coQuanQuanLyId, int daXoa, int start, int end)
		throws SystemException {
		return findByChucVuIdAndCoQuanQuanLyId(chucVuId, coQuanQuanLyId, daXoa,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByChucVuIdAndCoQuanQuanLyId(Long chucVuId,
		Long coQuanQuanLyId, int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUIDANDCOQUANQUANLYID;
			finderArgs = new Object[] { chucVuId, coQuanQuanLyId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHUCVUIDANDCOQUANQUANLYID;
			finderArgs = new Object[] {
					chucVuId, coQuanQuanLyId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<ChucVu2VaiTro> list = (List<ChucVu2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_CHUCVUID_2);

			query.append(_FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_COQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chucVuId.longValue());

				qPos.add(coQuanQuanLyId.longValue());

				qPos.add(daXoa);

				list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chuc vu2 vai tro in the ordered set where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByChucVuIdAndCoQuanQuanLyId_First(Long chucVuId,
		Long coQuanQuanLyId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		List<ChucVu2VaiTro> list = findByChucVuIdAndCoQuanQuanLyId(chucVuId,
				coQuanQuanLyId, daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chucVuId=");
			msg.append(chucVuId);

			msg.append(", coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu2 vai tro in the ordered set where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByChucVuIdAndCoQuanQuanLyId_Last(Long chucVuId,
		Long coQuanQuanLyId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		int count = countByChucVuIdAndCoQuanQuanLyId(chucVuId, coQuanQuanLyId,
				daXoa);

		List<ChucVu2VaiTro> list = findByChucVuIdAndCoQuanQuanLyId(chucVuId,
				coQuanQuanLyId, daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chucVuId=");
			msg.append(chucVuId);

			msg.append(", coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu2 vai tro
	 * @param chucVuId the chuc vu ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro[] findByChucVuIdAndCoQuanQuanLyId_PrevAndNext(
		long id, Long chucVuId, Long coQuanQuanLyId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu2VaiTro[] array = new ChucVu2VaiTroImpl[3];

			array[0] = getByChucVuIdAndCoQuanQuanLyId_PrevAndNext(session,
					chucVu2VaiTro, chucVuId, coQuanQuanLyId, daXoa,
					orderByComparator, true);

			array[1] = chucVu2VaiTro;

			array[2] = getByChucVuIdAndCoQuanQuanLyId_PrevAndNext(session,
					chucVu2VaiTro, chucVuId, coQuanQuanLyId, daXoa,
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

	protected ChucVu2VaiTro getByChucVuIdAndCoQuanQuanLyId_PrevAndNext(
		Session session, ChucVu2VaiTro chucVu2VaiTro, Long chucVuId,
		Long coQuanQuanLyId, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_CHUCVUID_2);

		query.append(_FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_COQUANQUANLYID_2);

		query.append(_FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_DAXOA_2);

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
			query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chucVuId.longValue());

		qPos.add(coQuanQuanLyId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vu2 vai tros where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByDaXoa(int daXoa) throws SystemException {
		return findByDaXoa(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vu2 vai tros where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @return the range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByDaXoa(int daXoa, int start, int end)
		throws SystemException {
		return findByDaXoa(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vu2 vai tros where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findByDaXoa(int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA;
			finderArgs = new Object[] { daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DAXOA;
			finderArgs = new Object[] { daXoa, start, end, orderByComparator };
		}

		List<ChucVu2VaiTro> list = (List<ChucVu2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_DAXOA_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chuc vu2 vai tro in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByDaXoa_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		List<ChucVu2VaiTro> list = findByDaXoa(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu2 vai tro in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro findByDaXoa_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		int count = countByDaXoa(daXoa);

		List<ChucVu2VaiTro> list = findByDaXoa(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVu2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu2 vai tro
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu2 vai tro
	 * @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu2VaiTro[] findByDaXoa_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu2VaiTro[] array = new ChucVu2VaiTroImpl[3];

			array[0] = getByDaXoa_PrevAndNext(session, chucVu2VaiTro, daXoa,
					orderByComparator, true);

			array[1] = chucVu2VaiTro;

			array[2] = getByDaXoa_PrevAndNext(session, chucVu2VaiTro, daXoa,
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

	protected ChucVu2VaiTro getByDaXoa_PrevAndNext(Session session,
		ChucVu2VaiTro chucVu2VaiTro, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_DAXOA_DAXOA_2);

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
			query.append(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vu2 vai tros.
	 *
	 * @return the chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vu2 vai tros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @return the range of chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vu2 vai tros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of chuc vu2 vai tros
	 * @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu2VaiTro> findAll(int start, int end,
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

		List<ChucVu2VaiTro> list = (List<ChucVu2VaiTro>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHUCVU2VAITRO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHUCVU2VAITRO.concat(ChucVu2VaiTroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ChucVu2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Removes the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; from the database.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param chucVuId the chuc vu ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByChucVu2VaiTro(Long vaiTroId, Long coQuanQuanLyId,
		Long chucVuId) throws NoSuchChucVu2VaiTroException, SystemException {
		ChucVu2VaiTro chucVu2VaiTro = findByChucVu2VaiTro(vaiTroId,
				coQuanQuanLyId, chucVuId);

		remove(chucVu2VaiTro);
	}

	/**
	 * Removes all the chuc vu2 vai tros where vaiTroId = &#63; from the database.
	 *
	 * @param vaiTroId the vai tro ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVaiTroId(Long vaiTroId) throws SystemException {
		for (ChucVu2VaiTro chucVu2VaiTro : findByVaiTroId(vaiTroId)) {
			remove(chucVu2VaiTro);
		}
	}

	/**
	 * Removes all the chuc vu2 vai tros where coQuanQuanLyId = &#63; from the database.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCoQuanQuanLyId(Long coQuanQuanLyId)
		throws SystemException {
		for (ChucVu2VaiTro chucVu2VaiTro : findByCoQuanQuanLyId(coQuanQuanLyId)) {
			remove(chucVu2VaiTro);
		}
	}

	/**
	 * Removes all the chuc vu2 vai tros where chucVuId = &#63; from the database.
	 *
	 * @param chucVuId the chuc vu ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByChucVuId(Long chucVuId) throws SystemException {
		for (ChucVu2VaiTro chucVu2VaiTro : findByChucVuId(chucVuId)) {
			remove(chucVu2VaiTro);
		}
	}

	/**
	 * Removes all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVaiTroIdAndDaXoa(Long vaiTroId, int daXoa)
		throws SystemException {
		for (ChucVu2VaiTro chucVu2VaiTro : findByVaiTroIdAndDaXoa(vaiTroId,
				daXoa)) {
			remove(chucVu2VaiTro);
		}
	}

	/**
	 * Removes all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCoQuanQuanLyIdAndDaXoa(Long coQuanQuanLyId, int daXoa)
		throws SystemException {
		for (ChucVu2VaiTro chucVu2VaiTro : findByCoQuanQuanLyIdAndDaXoa(
				coQuanQuanLyId, daXoa)) {
			remove(chucVu2VaiTro);
		}
	}

	/**
	 * Removes all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param chucVuId the chuc vu ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByChucVuIdAndDaXoa(Long chucVuId, int daXoa)
		throws SystemException {
		for (ChucVu2VaiTro chucVu2VaiTro : findByChucVuIdAndDaXoa(chucVuId,
				daXoa)) {
			remove(chucVu2VaiTro);
		}
	}

	/**
	 * Removes all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param chucVuId the chuc vu ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByChucVuIdAndCoQuanQuanLyId(Long chucVuId,
		Long coQuanQuanLyId, int daXoa) throws SystemException {
		for (ChucVu2VaiTro chucVu2VaiTro : findByChucVuIdAndCoQuanQuanLyId(
				chucVuId, coQuanQuanLyId, daXoa)) {
			remove(chucVu2VaiTro);
		}
	}

	/**
	 * Removes all the chuc vu2 vai tros where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDaXoa(int daXoa) throws SystemException {
		for (ChucVu2VaiTro chucVu2VaiTro : findByDaXoa(daXoa)) {
			remove(chucVu2VaiTro);
		}
	}

	/**
	 * Removes all the chuc vu2 vai tros from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ChucVu2VaiTro chucVu2VaiTro : findAll()) {
			remove(chucVu2VaiTro);
		}
	}

	/**
	 * Returns the number of chuc vu2 vai tros where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param chucVuId the chuc vu ID
	 * @return the number of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByChucVu2VaiTro(Long vaiTroId, Long coQuanQuanLyId,
		Long chucVuId) throws SystemException {
		Object[] finderArgs = new Object[] { vaiTroId, coQuanQuanLyId, chucVuId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CHUCVU2VAITRO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_CHUCVU2VAITRO_VAITROID_2);

			query.append(_FINDER_COLUMN_CHUCVU2VAITRO_COQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_CHUCVU2VAITRO_CHUCVUID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vaiTroId.longValue());

				qPos.add(coQuanQuanLyId.longValue());

				qPos.add(chucVuId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHUCVU2VAITRO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chuc vu2 vai tros where vaiTroId = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @return the number of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVaiTroId(Long vaiTroId) throws SystemException {
		Object[] finderArgs = new Object[] { vaiTroId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VAITROID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_VAITROID_VAITROID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vaiTroId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VAITROID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @return the number of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCoQuanQuanLyId(Long coQuanQuanLyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { coQuanQuanLyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chuc vu2 vai tros where chucVuId = &#63;.
	 *
	 * @param chucVuId the chuc vu ID
	 * @return the number of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByChucVuId(Long chucVuId) throws SystemException {
		Object[] finderArgs = new Object[] { chucVuId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CHUCVUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_CHUCVUID_CHUCVUID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chucVuId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHUCVUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @return the number of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVaiTroIdAndDaXoa(Long vaiTroId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { vaiTroId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VAITROIDANDDAXOA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_VAITROIDANDDAXOA_VAITROID_2);

			query.append(_FINDER_COLUMN_VAITROIDANDDAXOA_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vaiTroId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VAITROIDANDDAXOA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @return the number of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCoQuanQuanLyIdAndDaXoa(Long coQuanQuanLyId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { coQuanQuanLyId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COQUANQUANLYIDANDDAXOA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_COQUANQUANLYIDANDDAXOA_COQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_COQUANQUANLYIDANDDAXOA_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COQUANQUANLYIDANDDAXOA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	 *
	 * @param chucVuId the chuc vu ID
	 * @param daXoa the da xoa
	 * @return the number of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByChucVuIdAndDaXoa(Long chucVuId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { chucVuId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CHUCVUIDANDDAXOA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_CHUCVUIDANDDAXOA_CHUCVUID_2);

			query.append(_FINDER_COLUMN_CHUCVUIDANDDAXOA_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chucVuId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHUCVUIDANDDAXOA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	 *
	 * @param chucVuId the chuc vu ID
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param daXoa the da xoa
	 * @return the number of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByChucVuIdAndCoQuanQuanLyId(Long chucVuId,
		Long coQuanQuanLyId, int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { chucVuId, coQuanQuanLyId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CHUCVUIDANDCOQUANQUANLYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_CHUCVUID_2);

			query.append(_FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_COQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chucVuId.longValue());

				qPos.add(coQuanQuanLyId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHUCVUIDANDCOQUANQUANLYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chuc vu2 vai tros where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDaXoa(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAXOA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHUCVU2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_DAXOA_DAXOA_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAXOA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of chuc vu2 vai tros.
	 *
	 * @return the number of chuc vu2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHUCVU2VAITRO);

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
	 * Initializes the chuc vu2 vai tro persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChucVu2VaiTro>> listenersList = new ArrayList<ModelListener<ChucVu2VaiTro>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChucVu2VaiTro>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChucVu2VaiTroImpl.class.getName());
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
	private static final String _SQL_SELECT_CHUCVU2VAITRO = "SELECT chucVu2VaiTro FROM ChucVu2VaiTro chucVu2VaiTro";
	private static final String _SQL_SELECT_CHUCVU2VAITRO_WHERE = "SELECT chucVu2VaiTro FROM ChucVu2VaiTro chucVu2VaiTro WHERE ";
	private static final String _SQL_COUNT_CHUCVU2VAITRO = "SELECT COUNT(chucVu2VaiTro) FROM ChucVu2VaiTro chucVu2VaiTro";
	private static final String _SQL_COUNT_CHUCVU2VAITRO_WHERE = "SELECT COUNT(chucVu2VaiTro) FROM ChucVu2VaiTro chucVu2VaiTro WHERE ";
	private static final String _FINDER_COLUMN_CHUCVU2VAITRO_VAITROID_2 = "chucVu2VaiTro.vaiTroId = ? AND ";
	private static final String _FINDER_COLUMN_CHUCVU2VAITRO_COQUANQUANLYID_2 = "chucVu2VaiTro.coQuanQuanLyId = ? AND ";
	private static final String _FINDER_COLUMN_CHUCVU2VAITRO_CHUCVUID_2 = "chucVu2VaiTro.chucVuId = ?";
	private static final String _FINDER_COLUMN_VAITROID_VAITROID_2 = "chucVu2VaiTro.vaiTroId = ?";
	private static final String _FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2 = "chucVu2VaiTro.coQuanQuanLyId = ?";
	private static final String _FINDER_COLUMN_CHUCVUID_CHUCVUID_2 = "chucVu2VaiTro.chucVuId = ?";
	private static final String _FINDER_COLUMN_VAITROIDANDDAXOA_VAITROID_2 = "chucVu2VaiTro.vaiTroId = ? AND ";
	private static final String _FINDER_COLUMN_VAITROIDANDDAXOA_DAXOA_2 = "chucVu2VaiTro.daXoa = ?";
	private static final String _FINDER_COLUMN_COQUANQUANLYIDANDDAXOA_COQUANQUANLYID_2 =
		"chucVu2VaiTro.coQuanQuanLyId = ? AND ";
	private static final String _FINDER_COLUMN_COQUANQUANLYIDANDDAXOA_DAXOA_2 = "chucVu2VaiTro.daXoa = ?";
	private static final String _FINDER_COLUMN_CHUCVUIDANDDAXOA_CHUCVUID_2 = "chucVu2VaiTro.chucVuId = ? AND ";
	private static final String _FINDER_COLUMN_CHUCVUIDANDDAXOA_DAXOA_2 = "chucVu2VaiTro.daXoa = ?";
	private static final String _FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_CHUCVUID_2 =
		"chucVu2VaiTro.chucVuId = ? AND ";
	private static final String _FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_COQUANQUANLYID_2 =
		"chucVu2VaiTro.coQuanQuanLyId = ? AND ";
	private static final String _FINDER_COLUMN_CHUCVUIDANDCOQUANQUANLYID_DAXOA_2 =
		"chucVu2VaiTro.daXoa = ?";
	private static final String _FINDER_COLUMN_DAXOA_DAXOA_2 = "chucVu2VaiTro.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chucVu2VaiTro.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChucVu2VaiTro exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChucVu2VaiTro exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChucVu2VaiTroPersistenceImpl.class);
	private static ChucVu2VaiTro _nullChucVu2VaiTro = new ChucVu2VaiTroImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChucVu2VaiTro> toCacheModel() {
				return _nullChucVu2VaiTroCacheModel;
			}
		};

	private static CacheModel<ChucVu2VaiTro> _nullChucVu2VaiTroCacheModel = new CacheModel<ChucVu2VaiTro>() {
			public ChucVu2VaiTro toEntityModel() {
				return _nullChucVu2VaiTro;
			}
		};
}