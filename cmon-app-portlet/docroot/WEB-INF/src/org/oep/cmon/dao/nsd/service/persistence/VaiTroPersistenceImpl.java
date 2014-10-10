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

package org.oep.cmon.dao.nsd.service.persistence;

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

import org.oep.cmon.dao.nsd.NoSuchVaiTroException;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.model.impl.VaiTroImpl;
import org.oep.cmon.dao.nsd.model.impl.VaiTroModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vai tro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see VaiTroPersistence
 * @see VaiTroUtil
 * @generated
 */
public class VaiTroPersistenceImpl extends BasePersistenceImpl<VaiTro>
	implements VaiTroPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VaiTroUtil} to access the vai tro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VaiTroImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MA = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] { String.class.getName() },
			VaiTroModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTen",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] { String.class.getName() },
			VaiTroModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MOTA = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMoTa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOTA = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMoTa",
			new String[] { String.class.getName() },
			VaiTroModelImpl.MOTA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MOTA = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMoTa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_BYMA = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByByMa",
			new String[] { String.class.getName() },
			VaiTroModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYMA = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_BYTEN = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByByTen",
			new String[] { String.class.getName() },
			VaiTroModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYTEN = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vai tro in the entity cache if it is enabled.
	 *
	 * @param vaiTro the vai tro
	 */
	public void cacheResult(VaiTro vaiTro) {
		EntityCacheUtil.putResult(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroImpl.class, vaiTro.getPrimaryKey(), vaiTro);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYMA,
			new Object[] { vaiTro.getMa() }, vaiTro);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYTEN,
			new Object[] { vaiTro.getTen() }, vaiTro);

		vaiTro.resetOriginalValues();
	}

	/**
	 * Caches the vai tros in the entity cache if it is enabled.
	 *
	 * @param vaiTros the vai tros
	 */
	public void cacheResult(List<VaiTro> vaiTros) {
		for (VaiTro vaiTro : vaiTros) {
			if (EntityCacheUtil.getResult(
						VaiTroModelImpl.ENTITY_CACHE_ENABLED, VaiTroImpl.class,
						vaiTro.getPrimaryKey()) == null) {
				cacheResult(vaiTro);
			}
			else {
				vaiTro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vai tros.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VaiTroImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VaiTroImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vai tro.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VaiTro vaiTro) {
		EntityCacheUtil.removeResult(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroImpl.class, vaiTro.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(vaiTro);
	}

	@Override
	public void clearCache(List<VaiTro> vaiTros) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VaiTro vaiTro : vaiTros) {
			EntityCacheUtil.removeResult(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
				VaiTroImpl.class, vaiTro.getPrimaryKey());

			clearUniqueFindersCache(vaiTro);
		}
	}

	protected void clearUniqueFindersCache(VaiTro vaiTro) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYMA,
			new Object[] { vaiTro.getMa() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYTEN,
			new Object[] { vaiTro.getTen() });
	}

	/**
	 * Creates a new vai tro with the primary key. Does not add the vai tro to the database.
	 *
	 * @param id the primary key for the new vai tro
	 * @return the new vai tro
	 */
	public VaiTro create(long id) {
		VaiTro vaiTro = new VaiTroImpl();

		vaiTro.setNew(true);
		vaiTro.setPrimaryKey(id);

		return vaiTro;
	}

	/**
	 * Removes the vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vai tro
	 * @return the vai tro that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro remove(long id) throws NoSuchVaiTroException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vai tro
	 * @return the vai tro that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VaiTro remove(Serializable primaryKey)
		throws NoSuchVaiTroException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VaiTro vaiTro = (VaiTro)session.get(VaiTroImpl.class, primaryKey);

			if (vaiTro == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVaiTroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vaiTro);
		}
		catch (NoSuchVaiTroException nsee) {
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
	protected VaiTro removeImpl(VaiTro vaiTro) throws SystemException {
		vaiTro = toUnwrappedModel(vaiTro);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vaiTro);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vaiTro);

		return vaiTro;
	}

	@Override
	public VaiTro updateImpl(org.oep.cmon.dao.nsd.model.VaiTro vaiTro,
		boolean merge) throws SystemException {
		vaiTro = toUnwrappedModel(vaiTro);

		boolean isNew = vaiTro.isNew();

		VaiTroModelImpl vaiTroModelImpl = (VaiTroModelImpl)vaiTro;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vaiTro, merge);

			vaiTro.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VaiTroModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vaiTroModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);

				args = new Object[] { vaiTroModelImpl.getMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);
			}

			if ((vaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vaiTroModelImpl.getOriginalTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] { vaiTroModelImpl.getTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}

			if ((vaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOTA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vaiTroModelImpl.getOriginalMoTa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MOTA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOTA,
					args);

				args = new Object[] { vaiTroModelImpl.getMoTa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MOTA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOTA,
					args);
			}

			if ((vaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(vaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] { Integer.valueOf(vaiTroModelImpl.getDaXoa()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			VaiTroImpl.class, vaiTro.getPrimaryKey(), vaiTro);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYMA,
				new Object[] { vaiTro.getMa() }, vaiTro);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYTEN,
				new Object[] { vaiTro.getTen() }, vaiTro);
		}
		else {
			if ((vaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BYMA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vaiTroModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYMA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYMA, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYMA,
					new Object[] { vaiTro.getMa() }, vaiTro);
			}

			if ((vaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BYTEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vaiTroModelImpl.getOriginalTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYTEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYTEN, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYTEN,
					new Object[] { vaiTro.getTen() }, vaiTro);
			}
		}

		return vaiTro;
	}

	protected VaiTro toUnwrappedModel(VaiTro vaiTro) {
		if (vaiTro instanceof VaiTroImpl) {
			return vaiTro;
		}

		VaiTroImpl vaiTroImpl = new VaiTroImpl();

		vaiTroImpl.setNew(vaiTro.isNew());
		vaiTroImpl.setPrimaryKey(vaiTro.getPrimaryKey());

		vaiTroImpl.setId(vaiTro.getId());
		vaiTroImpl.setMa(vaiTro.getMa());
		vaiTroImpl.setTen(vaiTro.getTen());
		vaiTroImpl.setMoTa(vaiTro.getMoTa());
		vaiTroImpl.setNgayTao(vaiTro.getNgayTao());
		vaiTroImpl.setDaXoa(vaiTro.getDaXoa());
		vaiTroImpl.setNguoiTao(vaiTro.getNguoiTao());
		vaiTroImpl.setNgaySua(vaiTro.getNgaySua());
		vaiTroImpl.setNguoiSua(vaiTro.getNguoiSua());
		vaiTroImpl.setTrangThai(vaiTro.getTrangThai());
		vaiTroImpl.setUngDungId(vaiTro.getUngDungId());

		return vaiTroImpl;
	}

	/**
	 * Returns the vai tro with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vai tro
	 * @return the vai tro
	 * @throws com.liferay.portal.NoSuchModelException if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VaiTro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vai tro with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchVaiTroException} if it could not be found.
	 *
	 * @param id the primary key of the vai tro
	 * @return the vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByPrimaryKey(long id)
		throws NoSuchVaiTroException, SystemException {
		VaiTro vaiTro = fetchByPrimaryKey(id);

		if (vaiTro == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchVaiTroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return vaiTro;
	}

	/**
	 * Returns the vai tro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vai tro
	 * @return the vai tro, or <code>null</code> if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VaiTro fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vai tro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vai tro
	 * @return the vai tro, or <code>null</code> if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro fetchByPrimaryKey(long id) throws SystemException {
		VaiTro vaiTro = (VaiTro)EntityCacheUtil.getResult(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
				VaiTroImpl.class, id);

		if (vaiTro == _nullVaiTro) {
			return null;
		}

		if (vaiTro == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vaiTro = (VaiTro)session.get(VaiTroImpl.class, Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vaiTro != null) {
					cacheResult(vaiTro);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VaiTroModelImpl.ENTITY_CACHE_ENABLED,
						VaiTroImpl.class, id, _nullVaiTro);
				}

				closeSession(session);
			}
		}

		return vaiTro;
	}

	/**
	 * Returns all the vai tros where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByMa(String ma) throws SystemException {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vai tros where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @return the range of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByMa(String ma, int start, int end)
		throws SystemException {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vai tros where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByMa(String ma, int start, int end,
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

		List<VaiTro> list = (List<VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VAITRO_WHERE);

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
				query.append(VaiTroModelImpl.ORDER_BY_JPQL);
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

				list = (List<VaiTro>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first vai tro in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByMa_First(String ma, OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		List<VaiTro> list = findByMa(ma, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vai tro in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByMa_Last(String ma, OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		int count = countByMa(ma);

		List<VaiTro> list = findByMa(ma, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vai tros before and after the current vai tro in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current vai tro
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro[] findByMa_PrevAndNext(long id, String ma,
		OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		VaiTro vaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VaiTro[] array = new VaiTroImpl[3];

			array[0] = getByMa_PrevAndNext(session, vaiTro, ma,
					orderByComparator, true);

			array[1] = vaiTro;

			array[2] = getByMa_PrevAndNext(session, vaiTro, ma,
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

	protected VaiTro getByMa_PrevAndNext(Session session, VaiTro vaiTro,
		String ma, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VAITRO_WHERE);

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
			query.append(VaiTroModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vai tros where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByTen(String ten) throws SystemException {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vai tros where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @return the range of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByTen(String ten, int start, int end)
		throws SystemException {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vai tros where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByTen(String ten, int start, int end,
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

		List<VaiTro> list = (List<VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VAITRO_WHERE);

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
				query.append(VaiTroModelImpl.ORDER_BY_JPQL);
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

				list = (List<VaiTro>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first vai tro in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByTen_First(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		List<VaiTro> list = findByTen(ten, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vai tro in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByTen_Last(String ten, OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		int count = countByTen(ten);

		List<VaiTro> list = findByTen(ten, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vai tros before and after the current vai tro in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current vai tro
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro[] findByTen_PrevAndNext(long id, String ten,
		OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		VaiTro vaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VaiTro[] array = new VaiTroImpl[3];

			array[0] = getByTen_PrevAndNext(session, vaiTro, ten,
					orderByComparator, true);

			array[1] = vaiTro;

			array[2] = getByTen_PrevAndNext(session, vaiTro, ten,
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

	protected VaiTro getByTen_PrevAndNext(Session session, VaiTro vaiTro,
		String ten, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VAITRO_WHERE);

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
			query.append(VaiTroModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vai tros where moTa = &#63;.
	 *
	 * @param moTa the mo ta
	 * @return the matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByMoTa(String moTa) throws SystemException {
		return findByMoTa(moTa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vai tros where moTa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param moTa the mo ta
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @return the range of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByMoTa(String moTa, int start, int end)
		throws SystemException {
		return findByMoTa(moTa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vai tros where moTa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param moTa the mo ta
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByMoTa(String moTa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOTA;
			finderArgs = new Object[] { moTa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MOTA;
			finderArgs = new Object[] { moTa, start, end, orderByComparator };
		}

		List<VaiTro> list = (List<VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VAITRO_WHERE);

			if (moTa == null) {
				query.append(_FINDER_COLUMN_MOTA_MOTA_1);
			}
			else {
				if (moTa.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MOTA_MOTA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MOTA_MOTA_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (moTa != null) {
					qPos.add(moTa);
				}

				list = (List<VaiTro>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first vai tro in the ordered set where moTa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param moTa the mo ta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByMoTa_First(String moTa,
		OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		List<VaiTro> list = findByMoTa(moTa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("moTa=");
			msg.append(moTa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vai tro in the ordered set where moTa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param moTa the mo ta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByMoTa_Last(String moTa,
		OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		int count = countByMoTa(moTa);

		List<VaiTro> list = findByMoTa(moTa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("moTa=");
			msg.append(moTa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vai tros before and after the current vai tro in the ordered set where moTa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current vai tro
	 * @param moTa the mo ta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro[] findByMoTa_PrevAndNext(long id, String moTa,
		OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		VaiTro vaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VaiTro[] array = new VaiTroImpl[3];

			array[0] = getByMoTa_PrevAndNext(session, vaiTro, moTa,
					orderByComparator, true);

			array[1] = vaiTro;

			array[2] = getByMoTa_PrevAndNext(session, vaiTro, moTa,
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

	protected VaiTro getByMoTa_PrevAndNext(Session session, VaiTro vaiTro,
		String moTa, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VAITRO_WHERE);

		if (moTa == null) {
			query.append(_FINDER_COLUMN_MOTA_MOTA_1);
		}
		else {
			if (moTa.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MOTA_MOTA_3);
			}
			else {
				query.append(_FINDER_COLUMN_MOTA_MOTA_2);
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
			query.append(VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (moTa != null) {
			qPos.add(moTa);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the vai tro where ma = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchVaiTroException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByByMa(String ma)
		throws NoSuchVaiTroException, SystemException {
		VaiTro vaiTro = fetchByByMa(ma);

		if (vaiTro == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVaiTroException(msg.toString());
		}

		return vaiTro;
	}

	/**
	 * Returns the vai tro where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro fetchByByMa(String ma) throws SystemException {
		return fetchByByMa(ma, true);
	}

	/**
	 * Returns the vai tro where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro fetchByByMa(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BYMA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_VAITRO_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_BYMA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BYMA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_BYMA_MA_2);
				}
			}

			query.append(VaiTroModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<VaiTro> list = q.list();

				result = list;

				VaiTro vaiTro = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYMA,
						finderArgs, list);
				}
				else {
					vaiTro = list.get(0);

					cacheResult(vaiTro);

					if ((vaiTro.getMa() == null) || !vaiTro.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYMA,
							finderArgs, vaiTro);
					}
				}

				return vaiTro;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYMA,
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
				return (VaiTro)result;
			}
		}
	}

	/**
	 * Returns the vai tro where ten = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchVaiTroException} if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByByTen(String ten)
		throws NoSuchVaiTroException, SystemException {
		VaiTro vaiTro = fetchByByTen(ten);

		if (vaiTro == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVaiTroException(msg.toString());
		}

		return vaiTro;
	}

	/**
	 * Returns the vai tro where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro fetchByByTen(String ten) throws SystemException {
		return fetchByByTen(ten, true);
	}

	/**
	 * Returns the vai tro where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro fetchByByTen(String ten, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BYTEN,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_VAITRO_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_BYTEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BYTEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_BYTEN_TEN_2);
				}
			}

			query.append(VaiTroModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				List<VaiTro> list = q.list();

				result = list;

				VaiTro vaiTro = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYTEN,
						finderArgs, list);
				}
				else {
					vaiTro = list.get(0);

					cacheResult(vaiTro);

					if ((vaiTro.getTen() == null) ||
							!vaiTro.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYTEN,
							finderArgs, vaiTro);
					}
				}

				return vaiTro;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYTEN,
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
				return (VaiTro)result;
			}
		}
	}

	/**
	 * Returns all the vai tros where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByTrangThai(int daXoa) throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vai tros where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @return the range of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vai tros where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findByTrangThai(int daXoa, int start, int end,
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

		List<VaiTro> list = (List<VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VAITRO_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VaiTroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<VaiTro>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first vai tro in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		List<VaiTro> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vai tro in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		int count = countByTrangThai(daXoa);

		List<VaiTro> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vai tros before and after the current vai tro in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current vai tro
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VaiTro[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchVaiTroException, SystemException {
		VaiTro vaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VaiTro[] array = new VaiTroImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, vaiTro, daXoa,
					orderByComparator, true);

			array[1] = vaiTro;

			array[2] = getByTrangThai_PrevAndNext(session, vaiTro, daXoa,
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

	protected VaiTro getByTrangThai_PrevAndNext(Session session, VaiTro vaiTro,
		int daXoa, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VAITRO_WHERE);

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
			query.append(VaiTroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vai tros.
	 *
	 * @return the vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vai tros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @return the range of vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vai tros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vai tros
	 * @param end the upper bound of the range of vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<VaiTro> findAll(int start, int end,
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

		List<VaiTro> list = (List<VaiTro>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VAITRO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VAITRO.concat(VaiTroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VaiTro>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VaiTro>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the vai tros where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma) throws SystemException {
		for (VaiTro vaiTro : findByMa(ma)) {
			remove(vaiTro);
		}
	}

	/**
	 * Removes all the vai tros where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten) throws SystemException {
		for (VaiTro vaiTro : findByTen(ten)) {
			remove(vaiTro);
		}
	}

	/**
	 * Removes all the vai tros where moTa = &#63; from the database.
	 *
	 * @param moTa the mo ta
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMoTa(String moTa) throws SystemException {
		for (VaiTro vaiTro : findByMoTa(moTa)) {
			remove(vaiTro);
		}
	}

	/**
	 * Removes the vai tro where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByMa(String ma)
		throws NoSuchVaiTroException, SystemException {
		VaiTro vaiTro = findByByMa(ma);

		remove(vaiTro);
	}

	/**
	 * Removes the vai tro where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByTen(String ten)
		throws NoSuchVaiTroException, SystemException {
		VaiTro vaiTro = findByByTen(ten);

		remove(vaiTro);
	}

	/**
	 * Removes all the vai tros where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (VaiTro vaiTro : findByTrangThai(daXoa)) {
			remove(vaiTro);
		}
	}

	/**
	 * Removes all the vai tros from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VaiTro vaiTro : findAll()) {
			remove(vaiTro);
		}
	}

	/**
	 * Returns the number of vai tros where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VAITRO_WHERE);

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
	 * Returns the number of vai tros where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VAITRO_WHERE);

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
	 * Returns the number of vai tros where moTa = &#63;.
	 *
	 * @param moTa the mo ta
	 * @return the number of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMoTa(String moTa) throws SystemException {
		Object[] finderArgs = new Object[] { moTa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MOTA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VAITRO_WHERE);

			if (moTa == null) {
				query.append(_FINDER_COLUMN_MOTA_MOTA_1);
			}
			else {
				if (moTa.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MOTA_MOTA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MOTA_MOTA_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (moTa != null) {
					qPos.add(moTa);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MOTA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vai tros where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYMA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VAITRO_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_BYMA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BYMA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_BYMA_MA_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYMA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vai tros where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYTEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VAITRO_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_BYTEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BYTEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_BYTEN_TEN_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYTEN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vai tros where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VAITRO_WHERE);

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
	 * Returns the number of vai tros.
	 *
	 * @return the number of vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VAITRO);

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
	 * Initializes the vai tro persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.nsd.model.VaiTro")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VaiTro>> listenersList = new ArrayList<ModelListener<VaiTro>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VaiTro>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VaiTroImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = NguoiDung2VaiTroPersistence.class)
	protected NguoiDung2VaiTroPersistence nguoiDung2VaiTroPersistence;
	@BeanReference(type = NhomNguoiDungPersistence.class)
	protected NhomNguoiDungPersistence nhomNguoiDungPersistence;
	@BeanReference(type = TaiKhoanNguoiDungPersistence.class)
	protected TaiKhoanNguoiDungPersistence taiKhoanNguoiDungPersistence;
	@BeanReference(type = TaiNguyenPersistence.class)
	protected TaiNguyenPersistence taiNguyenPersistence;
	@BeanReference(type = TaiNguyen2VaiTroPersistence.class)
	protected TaiNguyen2VaiTroPersistence taiNguyen2VaiTroPersistence;
	@BeanReference(type = VaiTroPersistence.class)
	protected VaiTroPersistence vaiTroPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VAITRO = "SELECT vaiTro FROM VaiTro vaiTro";
	private static final String _SQL_SELECT_VAITRO_WHERE = "SELECT vaiTro FROM VaiTro vaiTro WHERE ";
	private static final String _SQL_COUNT_VAITRO = "SELECT COUNT(vaiTro) FROM VaiTro vaiTro";
	private static final String _SQL_COUNT_VAITRO_WHERE = "SELECT COUNT(vaiTro) FROM VaiTro vaiTro WHERE ";
	private static final String _FINDER_COLUMN_MA_MA_1 = "vaiTro.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "vaiTro.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(vaiTro.ma IS NULL OR vaiTro.ma = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "vaiTro.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "vaiTro.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(vaiTro.ten IS NULL OR vaiTro.ten = ?)";
	private static final String _FINDER_COLUMN_MOTA_MOTA_1 = "vaiTro.moTa IS NULL";
	private static final String _FINDER_COLUMN_MOTA_MOTA_2 = "vaiTro.moTa = ?";
	private static final String _FINDER_COLUMN_MOTA_MOTA_3 = "(vaiTro.moTa IS NULL OR vaiTro.moTa = ?)";
	private static final String _FINDER_COLUMN_BYMA_MA_1 = "vaiTro.ma IS NULL";
	private static final String _FINDER_COLUMN_BYMA_MA_2 = "vaiTro.ma = ?";
	private static final String _FINDER_COLUMN_BYMA_MA_3 = "(vaiTro.ma IS NULL OR vaiTro.ma = ?)";
	private static final String _FINDER_COLUMN_BYTEN_TEN_1 = "vaiTro.ten IS NULL";
	private static final String _FINDER_COLUMN_BYTEN_TEN_2 = "vaiTro.ten = ?";
	private static final String _FINDER_COLUMN_BYTEN_TEN_3 = "(vaiTro.ten IS NULL OR vaiTro.ten = ?)";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "vaiTro.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vaiTro.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VaiTro exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VaiTro exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VaiTroPersistenceImpl.class);
	private static VaiTro _nullVaiTro = new VaiTroImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VaiTro> toCacheModel() {
				return _nullVaiTroCacheModel;
			}
		};

	private static CacheModel<VaiTro> _nullVaiTroCacheModel = new CacheModel<VaiTro>() {
			public VaiTro toEntityModel() {
				return _nullVaiTro;
			}
		};
}