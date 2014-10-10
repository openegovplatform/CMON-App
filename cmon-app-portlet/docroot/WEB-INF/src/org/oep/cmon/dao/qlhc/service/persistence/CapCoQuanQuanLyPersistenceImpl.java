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

import org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.impl.CapCoQuanQuanLyImpl;
import org.oep.cmon.dao.qlhc.model.impl.CapCoQuanQuanLyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cap co quan quan ly service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CapCoQuanQuanLyPersistence
 * @see CapCoQuanQuanLyUtil
 * @generated
 */
public class CapCoQuanQuanLyPersistenceImpl extends BasePersistenceImpl<CapCoQuanQuanLy>
	implements CapCoQuanQuanLyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CapCoQuanQuanLyUtil} to access the cap co quan quan ly persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CapCoQuanQuanLyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MA = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] { String.class.getName() },
			CapCoQuanQuanLyModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTen",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] { String.class.getName() },
			CapCoQuanQuanLyModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			CapCoQuanQuanLyModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cap co quan quan ly in the entity cache if it is enabled.
	 *
	 * @param capCoQuanQuanLy the cap co quan quan ly
	 */
	public void cacheResult(CapCoQuanQuanLy capCoQuanQuanLy) {
		EntityCacheUtil.putResult(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class, capCoQuanQuanLy.getPrimaryKey(),
			capCoQuanQuanLy);

		capCoQuanQuanLy.resetOriginalValues();
	}

	/**
	 * Caches the cap co quan quan lies in the entity cache if it is enabled.
	 *
	 * @param capCoQuanQuanLies the cap co quan quan lies
	 */
	public void cacheResult(List<CapCoQuanQuanLy> capCoQuanQuanLies) {
		for (CapCoQuanQuanLy capCoQuanQuanLy : capCoQuanQuanLies) {
			if (EntityCacheUtil.getResult(
						CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
						CapCoQuanQuanLyImpl.class,
						capCoQuanQuanLy.getPrimaryKey()) == null) {
				cacheResult(capCoQuanQuanLy);
			}
			else {
				capCoQuanQuanLy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cap co quan quan lies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CapCoQuanQuanLyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CapCoQuanQuanLyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cap co quan quan ly.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CapCoQuanQuanLy capCoQuanQuanLy) {
		EntityCacheUtil.removeResult(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class, capCoQuanQuanLy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CapCoQuanQuanLy> capCoQuanQuanLies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CapCoQuanQuanLy capCoQuanQuanLy : capCoQuanQuanLies) {
			EntityCacheUtil.removeResult(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
				CapCoQuanQuanLyImpl.class, capCoQuanQuanLy.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cap co quan quan ly with the primary key. Does not add the cap co quan quan ly to the database.
	 *
	 * @param id the primary key for the new cap co quan quan ly
	 * @return the new cap co quan quan ly
	 */
	public CapCoQuanQuanLy create(long id) {
		CapCoQuanQuanLy capCoQuanQuanLy = new CapCoQuanQuanLyImpl();

		capCoQuanQuanLy.setNew(true);
		capCoQuanQuanLy.setPrimaryKey(id);

		return capCoQuanQuanLy;
	}

	/**
	 * Removes the cap co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cap co quan quan ly
	 * @return the cap co quan quan ly that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy remove(long id)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the cap co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cap co quan quan ly
	 * @return the cap co quan quan ly that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapCoQuanQuanLy remove(Serializable primaryKey)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CapCoQuanQuanLy capCoQuanQuanLy = (CapCoQuanQuanLy)session.get(CapCoQuanQuanLyImpl.class,
					primaryKey);

			if (capCoQuanQuanLy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCapCoQuanQuanLyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(capCoQuanQuanLy);
		}
		catch (NoSuchCapCoQuanQuanLyException nsee) {
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
	protected CapCoQuanQuanLy removeImpl(CapCoQuanQuanLy capCoQuanQuanLy)
		throws SystemException {
		capCoQuanQuanLy = toUnwrappedModel(capCoQuanQuanLy);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, capCoQuanQuanLy);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(capCoQuanQuanLy);

		return capCoQuanQuanLy;
	}

	@Override
	public CapCoQuanQuanLy updateImpl(
		org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy capCoQuanQuanLy,
		boolean merge) throws SystemException {
		capCoQuanQuanLy = toUnwrappedModel(capCoQuanQuanLy);

		boolean isNew = capCoQuanQuanLy.isNew();

		CapCoQuanQuanLyModelImpl capCoQuanQuanLyModelImpl = (CapCoQuanQuanLyModelImpl)capCoQuanQuanLy;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, capCoQuanQuanLy, merge);

			capCoQuanQuanLy.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CapCoQuanQuanLyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((capCoQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						capCoQuanQuanLyModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);

				args = new Object[] { capCoQuanQuanLyModelImpl.getMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);
			}

			if ((capCoQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						capCoQuanQuanLyModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] { capCoQuanQuanLyModelImpl.getTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}

			if ((capCoQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(capCoQuanQuanLyModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(capCoQuanQuanLyModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			CapCoQuanQuanLyImpl.class, capCoQuanQuanLy.getPrimaryKey(),
			capCoQuanQuanLy);

		return capCoQuanQuanLy;
	}

	protected CapCoQuanQuanLy toUnwrappedModel(CapCoQuanQuanLy capCoQuanQuanLy) {
		if (capCoQuanQuanLy instanceof CapCoQuanQuanLyImpl) {
			return capCoQuanQuanLy;
		}

		CapCoQuanQuanLyImpl capCoQuanQuanLyImpl = new CapCoQuanQuanLyImpl();

		capCoQuanQuanLyImpl.setNew(capCoQuanQuanLy.isNew());
		capCoQuanQuanLyImpl.setPrimaryKey(capCoQuanQuanLy.getPrimaryKey());

		capCoQuanQuanLyImpl.setId(capCoQuanQuanLy.getId());
		capCoQuanQuanLyImpl.setMa(capCoQuanQuanLy.getMa());
		capCoQuanQuanLyImpl.setTen(capCoQuanQuanLy.getTen());
		capCoQuanQuanLyImpl.setCap(capCoQuanQuanLy.getCap());
		capCoQuanQuanLyImpl.setChaId(capCoQuanQuanLy.getChaId());
		capCoQuanQuanLyImpl.setNgayTao(capCoQuanQuanLy.getNgayTao());
		capCoQuanQuanLyImpl.setNgaySua(capCoQuanQuanLy.getNgaySua());
		capCoQuanQuanLyImpl.setDaXoa(capCoQuanQuanLy.getDaXoa());
		capCoQuanQuanLyImpl.setPhienBan(capCoQuanQuanLy.getPhienBan());
		capCoQuanQuanLyImpl.setNguoiTao(capCoQuanQuanLy.getNguoiTao());
		capCoQuanQuanLyImpl.setNguoiSua(capCoQuanQuanLy.getNguoiSua());

		return capCoQuanQuanLyImpl;
	}

	/**
	 * Returns the cap co quan quan ly with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cap co quan quan ly
	 * @return the cap co quan quan ly
	 * @throws com.liferay.portal.NoSuchModelException if a cap co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapCoQuanQuanLy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cap co quan quan ly with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException} if it could not be found.
	 *
	 * @param id the primary key of the cap co quan quan ly
	 * @return the cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy findByPrimaryKey(long id)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		CapCoQuanQuanLy capCoQuanQuanLy = fetchByPrimaryKey(id);

		if (capCoQuanQuanLy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCapCoQuanQuanLyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return capCoQuanQuanLy;
	}

	/**
	 * Returns the cap co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cap co quan quan ly
	 * @return the cap co quan quan ly, or <code>null</code> if a cap co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapCoQuanQuanLy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cap co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cap co quan quan ly
	 * @return the cap co quan quan ly, or <code>null</code> if a cap co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy fetchByPrimaryKey(long id) throws SystemException {
		CapCoQuanQuanLy capCoQuanQuanLy = (CapCoQuanQuanLy)EntityCacheUtil.getResult(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
				CapCoQuanQuanLyImpl.class, id);

		if (capCoQuanQuanLy == _nullCapCoQuanQuanLy) {
			return null;
		}

		if (capCoQuanQuanLy == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				capCoQuanQuanLy = (CapCoQuanQuanLy)session.get(CapCoQuanQuanLyImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (capCoQuanQuanLy != null) {
					cacheResult(capCoQuanQuanLy);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CapCoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
						CapCoQuanQuanLyImpl.class, id, _nullCapCoQuanQuanLy);
				}

				closeSession(session);
			}
		}

		return capCoQuanQuanLy;
	}

	/**
	 * Returns all the cap co quan quan lies where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findByMa(String ma) throws SystemException {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap co quan quan lies where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of cap co quan quan lies
	 * @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	 * @return the range of matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findByMa(String ma, int start, int end)
		throws SystemException {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap co quan quan lies where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of cap co quan quan lies
	 * @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findByMa(String ma, int start, int end,
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

		List<CapCoQuanQuanLy> list = (List<CapCoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CAPCOQUANQUANLY_WHERE);

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
				query.append(CapCoQuanQuanLyModelImpl.ORDER_BY_JPQL);
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

				list = (List<CapCoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cap co quan quan ly in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy findByMa_First(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		List<CapCoQuanQuanLy> list = findByMa(ma, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cap co quan quan ly in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy findByMa_Last(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		int count = countByMa(ma);

		List<CapCoQuanQuanLy> list = findByMa(ma, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cap co quan quan lies before and after the current cap co quan quan ly in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cap co quan quan ly
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy[] findByMa_PrevAndNext(long id, String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		CapCoQuanQuanLy capCoQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CapCoQuanQuanLy[] array = new CapCoQuanQuanLyImpl[3];

			array[0] = getByMa_PrevAndNext(session, capCoQuanQuanLy, ma,
					orderByComparator, true);

			array[1] = capCoQuanQuanLy;

			array[2] = getByMa_PrevAndNext(session, capCoQuanQuanLy, ma,
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

	protected CapCoQuanQuanLy getByMa_PrevAndNext(Session session,
		CapCoQuanQuanLy capCoQuanQuanLy, String ma,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAPCOQUANQUANLY_WHERE);

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
			query.append(CapCoQuanQuanLyModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(capCoQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CapCoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cap co quan quan lies where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findByTen(String ten)
		throws SystemException {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap co quan quan lies where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of cap co quan quan lies
	 * @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	 * @return the range of matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findByTen(String ten, int start, int end)
		throws SystemException {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap co quan quan lies where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of cap co quan quan lies
	 * @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findByTen(String ten, int start, int end,
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

		List<CapCoQuanQuanLy> list = (List<CapCoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CAPCOQUANQUANLY_WHERE);

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
				query.append(CapCoQuanQuanLyModelImpl.ORDER_BY_JPQL);
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

				list = (List<CapCoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cap co quan quan ly in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy findByTen_First(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		List<CapCoQuanQuanLy> list = findByTen(ten, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cap co quan quan ly in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy findByTen_Last(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		int count = countByTen(ten);

		List<CapCoQuanQuanLy> list = findByTen(ten, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cap co quan quan lies before and after the current cap co quan quan ly in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cap co quan quan ly
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy[] findByTen_PrevAndNext(long id, String ten,
		OrderByComparator orderByComparator)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		CapCoQuanQuanLy capCoQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CapCoQuanQuanLy[] array = new CapCoQuanQuanLyImpl[3];

			array[0] = getByTen_PrevAndNext(session, capCoQuanQuanLy, ten,
					orderByComparator, true);

			array[1] = capCoQuanQuanLy;

			array[2] = getByTen_PrevAndNext(session, capCoQuanQuanLy, ten,
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

	protected CapCoQuanQuanLy getByTen_PrevAndNext(Session session,
		CapCoQuanQuanLy capCoQuanQuanLy, String ten,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAPCOQUANQUANLY_WHERE);

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
			query.append(CapCoQuanQuanLyModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(capCoQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CapCoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cap co quan quan lies where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap co quan quan lies where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of cap co quan quan lies
	 * @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	 * @return the range of matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap co quan quan lies where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of cap co quan quan lies
	 * @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findByTrangThai(int daXoa, int start, int end,
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

		List<CapCoQuanQuanLy> list = (List<CapCoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CAPCOQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CapCoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<CapCoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cap co quan quan ly in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		List<CapCoQuanQuanLy> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cap co quan quan ly in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		int count = countByTrangThai(daXoa);

		List<CapCoQuanQuanLy> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapCoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cap co quan quan lies before and after the current cap co quan quan ly in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cap co quan quan ly
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cap co quan quan ly
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapCoQuanQuanLy[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCapCoQuanQuanLyException, SystemException {
		CapCoQuanQuanLy capCoQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CapCoQuanQuanLy[] array = new CapCoQuanQuanLyImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, capCoQuanQuanLy,
					daXoa, orderByComparator, true);

			array[1] = capCoQuanQuanLy;

			array[2] = getByTrangThai_PrevAndNext(session, capCoQuanQuanLy,
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

	protected CapCoQuanQuanLy getByTrangThai_PrevAndNext(Session session,
		CapCoQuanQuanLy capCoQuanQuanLy, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAPCOQUANQUANLY_WHERE);

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
			query.append(CapCoQuanQuanLyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(capCoQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CapCoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cap co quan quan lies.
	 *
	 * @return the cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap co quan quan lies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cap co quan quan lies
	 * @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	 * @return the range of cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap co quan quan lies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cap co quan quan lies
	 * @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapCoQuanQuanLy> findAll(int start, int end,
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

		List<CapCoQuanQuanLy> list = (List<CapCoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAPCOQUANQUANLY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAPCOQUANQUANLY.concat(CapCoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CapCoQuanQuanLy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CapCoQuanQuanLy>)QueryUtil.list(q,
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
	 * Removes all the cap co quan quan lies where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma) throws SystemException {
		for (CapCoQuanQuanLy capCoQuanQuanLy : findByMa(ma)) {
			remove(capCoQuanQuanLy);
		}
	}

	/**
	 * Removes all the cap co quan quan lies where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten) throws SystemException {
		for (CapCoQuanQuanLy capCoQuanQuanLy : findByTen(ten)) {
			remove(capCoQuanQuanLy);
		}
	}

	/**
	 * Removes all the cap co quan quan lies where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (CapCoQuanQuanLy capCoQuanQuanLy : findByTrangThai(daXoa)) {
			remove(capCoQuanQuanLy);
		}
	}

	/**
	 * Removes all the cap co quan quan lies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CapCoQuanQuanLy capCoQuanQuanLy : findAll()) {
			remove(capCoQuanQuanLy);
		}
	}

	/**
	 * Returns the number of cap co quan quan lies where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPCOQUANQUANLY_WHERE);

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
	 * Returns the number of cap co quan quan lies where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPCOQUANQUANLY_WHERE);

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
	 * Returns the number of cap co quan quan lies where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPCOQUANQUANLY_WHERE);

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
	 * Returns the number of cap co quan quan lies.
	 *
	 * @return the number of cap co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAPCOQUANQUANLY);

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
	 * Initializes the cap co quan quan ly persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CapCoQuanQuanLy>> listenersList = new ArrayList<ModelListener<CapCoQuanQuanLy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CapCoQuanQuanLy>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CapCoQuanQuanLyImpl.class.getName());
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
	private static final String _SQL_SELECT_CAPCOQUANQUANLY = "SELECT capCoQuanQuanLy FROM CapCoQuanQuanLy capCoQuanQuanLy";
	private static final String _SQL_SELECT_CAPCOQUANQUANLY_WHERE = "SELECT capCoQuanQuanLy FROM CapCoQuanQuanLy capCoQuanQuanLy WHERE ";
	private static final String _SQL_COUNT_CAPCOQUANQUANLY = "SELECT COUNT(capCoQuanQuanLy) FROM CapCoQuanQuanLy capCoQuanQuanLy";
	private static final String _SQL_COUNT_CAPCOQUANQUANLY_WHERE = "SELECT COUNT(capCoQuanQuanLy) FROM CapCoQuanQuanLy capCoQuanQuanLy WHERE ";
	private static final String _FINDER_COLUMN_MA_MA_1 = "capCoQuanQuanLy.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "capCoQuanQuanLy.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(capCoQuanQuanLy.ma IS NULL OR capCoQuanQuanLy.ma = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "capCoQuanQuanLy.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "capCoQuanQuanLy.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(capCoQuanQuanLy.ten IS NULL OR capCoQuanQuanLy.ten = ?)";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "capCoQuanQuanLy.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "capCoQuanQuanLy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CapCoQuanQuanLy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CapCoQuanQuanLy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CapCoQuanQuanLyPersistenceImpl.class);
	private static CapCoQuanQuanLy _nullCapCoQuanQuanLy = new CapCoQuanQuanLyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CapCoQuanQuanLy> toCacheModel() {
				return _nullCapCoQuanQuanLyCacheModel;
			}
		};

	private static CacheModel<CapCoQuanQuanLy> _nullCapCoQuanQuanLyCacheModel = new CacheModel<CapCoQuanQuanLy>() {
			public CapCoQuanQuanLy toEntityModel() {
				return _nullCapCoQuanQuanLy;
			}
		};
}