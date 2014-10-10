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

import org.oep.cmon.dao.qlhc.NoSuchQuocGiaException;
import org.oep.cmon.dao.qlhc.model.QuocGia;
import org.oep.cmon.dao.qlhc.model.impl.QuocGiaImpl;
import org.oep.cmon.dao.qlhc.model.impl.QuocGiaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the quoc gia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see QuocGiaPersistence
 * @see QuocGiaUtil
 * @generated
 */
public class QuocGiaPersistenceImpl extends BasePersistenceImpl<QuocGia>
	implements QuocGiaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuocGiaUtil} to access the quoc gia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuocGiaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MA = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, QuocGiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, QuocGiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] { String.class.getName() },
			QuocGiaModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_TEN = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, QuocGiaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTen",
			new String[] { String.class.getName() },
			QuocGiaModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MAQUOCGIA = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, QuocGiaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMaQuocGia",
			new String[] { String.class.getName() },
			QuocGiaModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAQUOCGIA = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaQuocGia",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, QuocGiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, QuocGiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			QuocGiaModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, QuocGiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, QuocGiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the quoc gia in the entity cache if it is enabled.
	 *
	 * @param quocGia the quoc gia
	 */
	public void cacheResult(QuocGia quocGia) {
		EntityCacheUtil.putResult(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaImpl.class, quocGia.getPrimaryKey(), quocGia);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { quocGia.getTen() }, quocGia);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAQUOCGIA,
			new Object[] { quocGia.getMa() }, quocGia);

		quocGia.resetOriginalValues();
	}

	/**
	 * Caches the quoc gias in the entity cache if it is enabled.
	 *
	 * @param quocGias the quoc gias
	 */
	public void cacheResult(List<QuocGia> quocGias) {
		for (QuocGia quocGia : quocGias) {
			if (EntityCacheUtil.getResult(
						QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
						QuocGiaImpl.class, quocGia.getPrimaryKey()) == null) {
				cacheResult(quocGia);
			}
			else {
				quocGia.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all quoc gias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QuocGiaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QuocGiaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quoc gia.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuocGia quocGia) {
		EntityCacheUtil.removeResult(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaImpl.class, quocGia.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(quocGia);
	}

	@Override
	public void clearCache(List<QuocGia> quocGias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuocGia quocGia : quocGias) {
			EntityCacheUtil.removeResult(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
				QuocGiaImpl.class, quocGia.getPrimaryKey());

			clearUniqueFindersCache(quocGia);
		}
	}

	protected void clearUniqueFindersCache(QuocGia quocGia) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { quocGia.getTen() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAQUOCGIA,
			new Object[] { quocGia.getMa() });
	}

	/**
	 * Creates a new quoc gia with the primary key. Does not add the quoc gia to the database.
	 *
	 * @param id the primary key for the new quoc gia
	 * @return the new quoc gia
	 */
	public QuocGia create(long id) {
		QuocGia quocGia = new QuocGiaImpl();

		quocGia.setNew(true);
		quocGia.setPrimaryKey(id);

		return quocGia;
	}

	/**
	 * Removes the quoc gia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the quoc gia
	 * @return the quoc gia that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a quoc gia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia remove(long id)
		throws NoSuchQuocGiaException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the quoc gia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quoc gia
	 * @return the quoc gia that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a quoc gia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuocGia remove(Serializable primaryKey)
		throws NoSuchQuocGiaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			QuocGia quocGia = (QuocGia)session.get(QuocGiaImpl.class, primaryKey);

			if (quocGia == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuocGiaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(quocGia);
		}
		catch (NoSuchQuocGiaException nsee) {
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
	protected QuocGia removeImpl(QuocGia quocGia) throws SystemException {
		quocGia = toUnwrappedModel(quocGia);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, quocGia);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(quocGia);

		return quocGia;
	}

	@Override
	public QuocGia updateImpl(org.oep.cmon.dao.qlhc.model.QuocGia quocGia,
		boolean merge) throws SystemException {
		quocGia = toUnwrappedModel(quocGia);

		boolean isNew = quocGia.isNew();

		QuocGiaModelImpl quocGiaModelImpl = (QuocGiaModelImpl)quocGia;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, quocGia, merge);

			quocGia.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !QuocGiaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((quocGiaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { quocGiaModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);

				args = new Object[] { quocGiaModelImpl.getMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);
			}

			if ((quocGiaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(quocGiaModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] { Integer.valueOf(quocGiaModelImpl.getDaXoa()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
			QuocGiaImpl.class, quocGia.getPrimaryKey(), quocGia);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
				new Object[] { quocGia.getTen() }, quocGia);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAQUOCGIA,
				new Object[] { quocGia.getMa() }, quocGia);
		}
		else {
			if ((quocGiaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { quocGiaModelImpl.getOriginalTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
					new Object[] { quocGia.getTen() }, quocGia);
			}

			if ((quocGiaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MAQUOCGIA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { quocGiaModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAQUOCGIA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAQUOCGIA,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAQUOCGIA,
					new Object[] { quocGia.getMa() }, quocGia);
			}
		}

		return quocGia;
	}

	protected QuocGia toUnwrappedModel(QuocGia quocGia) {
		if (quocGia instanceof QuocGiaImpl) {
			return quocGia;
		}

		QuocGiaImpl quocGiaImpl = new QuocGiaImpl();

		quocGiaImpl.setNew(quocGia.isNew());
		quocGiaImpl.setPrimaryKey(quocGia.getPrimaryKey());

		quocGiaImpl.setId(quocGia.getId());
		quocGiaImpl.setMa(quocGia.getMa());
		quocGiaImpl.setTen(quocGia.getTen());
		quocGiaImpl.setNgayTao(quocGia.getNgayTao());
		quocGiaImpl.setNgaySua(quocGia.getNgaySua());
		quocGiaImpl.setDaXoa(quocGia.getDaXoa());
		quocGiaImpl.setNguoiTao(quocGia.getNguoiTao());
		quocGiaImpl.setNguoiSua(quocGia.getNguoiSua());
		quocGiaImpl.setPhienBan(quocGia.getPhienBan());

		return quocGiaImpl;
	}

	/**
	 * Returns the quoc gia with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the quoc gia
	 * @return the quoc gia
	 * @throws com.liferay.portal.NoSuchModelException if a quoc gia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuocGia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the quoc gia with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchQuocGiaException} if it could not be found.
	 *
	 * @param id the primary key of the quoc gia
	 * @return the quoc gia
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a quoc gia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia findByPrimaryKey(long id)
		throws NoSuchQuocGiaException, SystemException {
		QuocGia quocGia = fetchByPrimaryKey(id);

		if (quocGia == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchQuocGiaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return quocGia;
	}

	/**
	 * Returns the quoc gia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quoc gia
	 * @return the quoc gia, or <code>null</code> if a quoc gia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuocGia fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the quoc gia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the quoc gia
	 * @return the quoc gia, or <code>null</code> if a quoc gia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia fetchByPrimaryKey(long id) throws SystemException {
		QuocGia quocGia = (QuocGia)EntityCacheUtil.getResult(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
				QuocGiaImpl.class, id);

		if (quocGia == _nullQuocGia) {
			return null;
		}

		if (quocGia == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				quocGia = (QuocGia)session.get(QuocGiaImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (quocGia != null) {
					cacheResult(quocGia);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(QuocGiaModelImpl.ENTITY_CACHE_ENABLED,
						QuocGiaImpl.class, id, _nullQuocGia);
				}

				closeSession(session);
			}
		}

		return quocGia;
	}

	/**
	 * Returns all the quoc gias where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuocGia> findByMa(String ma) throws SystemException {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quoc gias where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of quoc gias
	 * @param end the upper bound of the range of quoc gias (not inclusive)
	 * @return the range of matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuocGia> findByMa(String ma, int start, int end)
		throws SystemException {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quoc gias where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of quoc gias
	 * @param end the upper bound of the range of quoc gias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuocGia> findByMa(String ma, int start, int end,
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

		List<QuocGia> list = (List<QuocGia>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_QUOCGIA_WHERE);

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
				query.append(QuocGiaModelImpl.ORDER_BY_JPQL);
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

				list = (List<QuocGia>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first quoc gia in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quoc gia
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia findByMa_First(String ma, OrderByComparator orderByComparator)
		throws NoSuchQuocGiaException, SystemException {
		List<QuocGia> list = findByMa(ma, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuocGiaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last quoc gia in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quoc gia
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia findByMa_Last(String ma, OrderByComparator orderByComparator)
		throws NoSuchQuocGiaException, SystemException {
		int count = countByMa(ma);

		List<QuocGia> list = findByMa(ma, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuocGiaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the quoc gias before and after the current quoc gia in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current quoc gia
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quoc gia
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a quoc gia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia[] findByMa_PrevAndNext(long id, String ma,
		OrderByComparator orderByComparator)
		throws NoSuchQuocGiaException, SystemException {
		QuocGia quocGia = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			QuocGia[] array = new QuocGiaImpl[3];

			array[0] = getByMa_PrevAndNext(session, quocGia, ma,
					orderByComparator, true);

			array[1] = quocGia;

			array[2] = getByMa_PrevAndNext(session, quocGia, ma,
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

	protected QuocGia getByMa_PrevAndNext(Session session, QuocGia quocGia,
		String ma, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUOCGIA_WHERE);

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
			query.append(QuocGiaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(quocGia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QuocGia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the quoc gia where ten = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchQuocGiaException} if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching quoc gia
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia findByTen(String ten)
		throws NoSuchQuocGiaException, SystemException {
		QuocGia quocGia = fetchByTen(ten);

		if (quocGia == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchQuocGiaException(msg.toString());
		}

		return quocGia;
	}

	/**
	 * Returns the quoc gia where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching quoc gia, or <code>null</code> if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia fetchByTen(String ten) throws SystemException {
		return fetchByTen(ten, true);
	}

	/**
	 * Returns the quoc gia where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching quoc gia, or <code>null</code> if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia fetchByTen(String ten, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TEN,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_QUOCGIA_WHERE);

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

			query.append(QuocGiaModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				List<QuocGia> list = q.list();

				result = list;

				QuocGia quocGia = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
						finderArgs, list);
				}
				else {
					quocGia = list.get(0);

					cacheResult(quocGia);

					if ((quocGia.getTen() == null) ||
							!quocGia.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
							finderArgs, quocGia);
					}
				}

				return quocGia;
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
				return (QuocGia)result;
			}
		}
	}

	/**
	 * Returns the quoc gia where ma = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchQuocGiaException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching quoc gia
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia findByMaQuocGia(String ma)
		throws NoSuchQuocGiaException, SystemException {
		QuocGia quocGia = fetchByMaQuocGia(ma);

		if (quocGia == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchQuocGiaException(msg.toString());
		}

		return quocGia;
	}

	/**
	 * Returns the quoc gia where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching quoc gia, or <code>null</code> if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia fetchByMaQuocGia(String ma) throws SystemException {
		return fetchByMaQuocGia(ma, true);
	}

	/**
	 * Returns the quoc gia where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching quoc gia, or <code>null</code> if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia fetchByMaQuocGia(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MAQUOCGIA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_QUOCGIA_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MAQUOCGIA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MAQUOCGIA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MAQUOCGIA_MA_2);
				}
			}

			query.append(QuocGiaModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<QuocGia> list = q.list();

				result = list;

				QuocGia quocGia = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAQUOCGIA,
						finderArgs, list);
				}
				else {
					quocGia = list.get(0);

					cacheResult(quocGia);

					if ((quocGia.getMa() == null) ||
							!quocGia.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAQUOCGIA,
							finderArgs, quocGia);
					}
				}

				return quocGia;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAQUOCGIA,
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
				return (QuocGia)result;
			}
		}
	}

	/**
	 * Returns all the quoc gias where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuocGia> findByTrangThai(int daXoa) throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quoc gias where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of quoc gias
	 * @param end the upper bound of the range of quoc gias (not inclusive)
	 * @return the range of matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuocGia> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quoc gias where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of quoc gias
	 * @param end the upper bound of the range of quoc gias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuocGia> findByTrangThai(int daXoa, int start, int end,
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

		List<QuocGia> list = (List<QuocGia>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_QUOCGIA_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(QuocGiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<QuocGia>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first quoc gia in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quoc gia
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchQuocGiaException, SystemException {
		List<QuocGia> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuocGiaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last quoc gia in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quoc gia
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchQuocGiaException, SystemException {
		int count = countByTrangThai(daXoa);

		List<QuocGia> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuocGiaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the quoc gias before and after the current quoc gia in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current quoc gia
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quoc gia
	 * @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a quoc gia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuocGia[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchQuocGiaException, SystemException {
		QuocGia quocGia = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			QuocGia[] array = new QuocGiaImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, quocGia, daXoa,
					orderByComparator, true);

			array[1] = quocGia;

			array[2] = getByTrangThai_PrevAndNext(session, quocGia, daXoa,
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

	protected QuocGia getByTrangThai_PrevAndNext(Session session,
		QuocGia quocGia, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUOCGIA_WHERE);

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
			query.append(QuocGiaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(quocGia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QuocGia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the quoc gias.
	 *
	 * @return the quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuocGia> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quoc gias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of quoc gias
	 * @param end the upper bound of the range of quoc gias (not inclusive)
	 * @return the range of quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuocGia> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quoc gias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of quoc gias
	 * @param end the upper bound of the range of quoc gias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuocGia> findAll(int start, int end,
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

		List<QuocGia> list = (List<QuocGia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUOCGIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUOCGIA.concat(QuocGiaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<QuocGia>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<QuocGia>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the quoc gias where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma) throws SystemException {
		for (QuocGia quocGia : findByMa(ma)) {
			remove(quocGia);
		}
	}

	/**
	 * Removes the quoc gia where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten)
		throws NoSuchQuocGiaException, SystemException {
		QuocGia quocGia = findByTen(ten);

		remove(quocGia);
	}

	/**
	 * Removes the quoc gia where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMaQuocGia(String ma)
		throws NoSuchQuocGiaException, SystemException {
		QuocGia quocGia = findByMaQuocGia(ma);

		remove(quocGia);
	}

	/**
	 * Removes all the quoc gias where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (QuocGia quocGia : findByTrangThai(daXoa)) {
			remove(quocGia);
		}
	}

	/**
	 * Removes all the quoc gias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (QuocGia quocGia : findAll()) {
			remove(quocGia);
		}
	}

	/**
	 * Returns the number of quoc gias where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUOCGIA_WHERE);

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
	 * Returns the number of quoc gias where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUOCGIA_WHERE);

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
	 * Returns the number of quoc gias where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMaQuocGia(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MAQUOCGIA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUOCGIA_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MAQUOCGIA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MAQUOCGIA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MAQUOCGIA_MA_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAQUOCGIA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of quoc gias where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUOCGIA_WHERE);

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
	 * Returns the number of quoc gias.
	 *
	 * @return the number of quoc gias
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUOCGIA);

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
	 * Initializes the quoc gia persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.qlhc.model.QuocGia")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<QuocGia>> listenersList = new ArrayList<ModelListener<QuocGia>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<QuocGia>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(QuocGiaImpl.class.getName());
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
	private static final String _SQL_SELECT_QUOCGIA = "SELECT quocGia FROM QuocGia quocGia";
	private static final String _SQL_SELECT_QUOCGIA_WHERE = "SELECT quocGia FROM QuocGia quocGia WHERE ";
	private static final String _SQL_COUNT_QUOCGIA = "SELECT COUNT(quocGia) FROM QuocGia quocGia";
	private static final String _SQL_COUNT_QUOCGIA_WHERE = "SELECT COUNT(quocGia) FROM QuocGia quocGia WHERE ";
	private static final String _FINDER_COLUMN_MA_MA_1 = "quocGia.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "quocGia.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(quocGia.ma IS NULL OR quocGia.ma = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "quocGia.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "quocGia.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(quocGia.ten IS NULL OR quocGia.ten = ?)";
	private static final String _FINDER_COLUMN_MAQUOCGIA_MA_1 = "quocGia.ma IS NULL";
	private static final String _FINDER_COLUMN_MAQUOCGIA_MA_2 = "quocGia.ma = ?";
	private static final String _FINDER_COLUMN_MAQUOCGIA_MA_3 = "(quocGia.ma IS NULL OR quocGia.ma = ?)";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "quocGia.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "quocGia.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QuocGia exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No QuocGia exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QuocGiaPersistenceImpl.class);
	private static QuocGia _nullQuocGia = new QuocGiaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<QuocGia> toCacheModel() {
				return _nullQuocGiaCacheModel;
			}
		};

	private static CacheModel<QuocGia> _nullQuocGiaCacheModel = new CacheModel<QuocGia>() {
			public QuocGia toEntityModel() {
				return _nullQuocGia;
			}
		};
}