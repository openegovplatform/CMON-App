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

package org.oep.cmon.dao.cc.service.persistence;

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

import org.oep.cmon.dao.cc.NoSuchChucVuException;
import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.model.impl.ChucVuImpl;
import org.oep.cmon.dao.cc.model.impl.ChucVuModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the chuc vu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see ChucVuPersistence
 * @see ChucVuUtil
 * @generated
 */
public class ChucVuPersistenceImpl extends BasePersistenceImpl<ChucVu>
	implements ChucVuPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChucVuUtil} to access the chuc vu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChucVuImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, ChucVuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, ChucVuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			ChucVuModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MA = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, ChucVuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, ChucVuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] { String.class.getName() },
			ChucVuModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, ChucVuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTen",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, ChucVuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] { String.class.getName() },
			ChucVuModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, ChucVuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, ChucVuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the chuc vu in the entity cache if it is enabled.
	 *
	 * @param chucVu the chuc vu
	 */
	public void cacheResult(ChucVu chucVu) {
		EntityCacheUtil.putResult(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuImpl.class, chucVu.getPrimaryKey(), chucVu);

		chucVu.resetOriginalValues();
	}

	/**
	 * Caches the chuc vus in the entity cache if it is enabled.
	 *
	 * @param chucVus the chuc vus
	 */
	public void cacheResult(List<ChucVu> chucVus) {
		for (ChucVu chucVu : chucVus) {
			if (EntityCacheUtil.getResult(
						ChucVuModelImpl.ENTITY_CACHE_ENABLED, ChucVuImpl.class,
						chucVu.getPrimaryKey()) == null) {
				cacheResult(chucVu);
			}
			else {
				chucVu.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chuc vus.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChucVuImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChucVuImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chuc vu.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChucVu chucVu) {
		EntityCacheUtil.removeResult(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuImpl.class, chucVu.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ChucVu> chucVus) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChucVu chucVu : chucVus) {
			EntityCacheUtil.removeResult(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
				ChucVuImpl.class, chucVu.getPrimaryKey());
		}
	}

	/**
	 * Creates a new chuc vu with the primary key. Does not add the chuc vu to the database.
	 *
	 * @param id the primary key for the new chuc vu
	 * @return the new chuc vu
	 */
	public ChucVu create(long id) {
		ChucVu chucVu = new ChucVuImpl();

		chucVu.setNew(true);
		chucVu.setPrimaryKey(id);

		return chucVu;
	}

	/**
	 * Removes the chuc vu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chuc vu
	 * @return the chuc vu that was removed
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu remove(long id) throws NoSuchChucVuException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the chuc vu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chuc vu
	 * @return the chuc vu that was removed
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChucVu remove(Serializable primaryKey)
		throws NoSuchChucVuException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChucVu chucVu = (ChucVu)session.get(ChucVuImpl.class, primaryKey);

			if (chucVu == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChucVuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chucVu);
		}
		catch (NoSuchChucVuException nsee) {
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
	protected ChucVu removeImpl(ChucVu chucVu) throws SystemException {
		chucVu = toUnwrappedModel(chucVu);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, chucVu);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(chucVu);

		return chucVu;
	}

	@Override
	public ChucVu updateImpl(org.oep.cmon.dao.cc.model.ChucVu chucVu,
		boolean merge) throws SystemException {
		chucVu = toUnwrappedModel(chucVu);

		boolean isNew = chucVu.isNew();

		ChucVuModelImpl chucVuModelImpl = (ChucVuModelImpl)chucVu;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, chucVu, merge);

			chucVu.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChucVuModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((chucVuModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(chucVuModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] { Integer.valueOf(chucVuModelImpl.getDaXoa()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((chucVuModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { chucVuModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);

				args = new Object[] { chucVuModelImpl.getMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);
			}

			if ((chucVuModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { chucVuModelImpl.getOriginalTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] { chucVuModelImpl.getTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}
		}

		EntityCacheUtil.putResult(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
			ChucVuImpl.class, chucVu.getPrimaryKey(), chucVu);

		return chucVu;
	}

	protected ChucVu toUnwrappedModel(ChucVu chucVu) {
		if (chucVu instanceof ChucVuImpl) {
			return chucVu;
		}

		ChucVuImpl chucVuImpl = new ChucVuImpl();

		chucVuImpl.setNew(chucVu.isNew());
		chucVuImpl.setPrimaryKey(chucVu.getPrimaryKey());

		chucVuImpl.setId(chucVu.getId());
		chucVuImpl.setMa(chucVu.getMa());
		chucVuImpl.setTen(chucVu.getTen());
		chucVuImpl.setPhienBan(chucVu.getPhienBan());
		chucVuImpl.setNgayTao(chucVu.getNgayTao());
		chucVuImpl.setDaXoa(chucVu.getDaXoa());
		chucVuImpl.setNgaySua(chucVu.getNgaySua());
		chucVuImpl.setNguoiTao(chucVu.getNguoiTao());
		chucVuImpl.setNguoiSua(chucVu.getNguoiSua());

		return chucVuImpl;
	}

	/**
	 * Returns the chuc vu with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chuc vu
	 * @return the chuc vu
	 * @throws com.liferay.portal.NoSuchModelException if a chuc vu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChucVu findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the chuc vu with the primary key or throws a {@link org.oep.cmon.dao.cc.NoSuchChucVuException} if it could not be found.
	 *
	 * @param id the primary key of the chuc vu
	 * @return the chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu findByPrimaryKey(long id)
		throws NoSuchChucVuException, SystemException {
		ChucVu chucVu = fetchByPrimaryKey(id);

		if (chucVu == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchChucVuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return chucVu;
	}

	/**
	 * Returns the chuc vu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chuc vu
	 * @return the chuc vu, or <code>null</code> if a chuc vu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChucVu fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the chuc vu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chuc vu
	 * @return the chuc vu, or <code>null</code> if a chuc vu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu fetchByPrimaryKey(long id) throws SystemException {
		ChucVu chucVu = (ChucVu)EntityCacheUtil.getResult(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
				ChucVuImpl.class, id);

		if (chucVu == _nullChucVu) {
			return null;
		}

		if (chucVu == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				chucVu = (ChucVu)session.get(ChucVuImpl.class, Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (chucVu != null) {
					cacheResult(chucVu);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ChucVuModelImpl.ENTITY_CACHE_ENABLED,
						ChucVuImpl.class, id, _nullChucVu);
				}

				closeSession(session);
			}
		}

		return chucVu;
	}

	/**
	 * Returns all the chuc vus where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findByTrangThai(int daXoa) throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vus where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vus
	 * @param end the upper bound of the range of chuc vus (not inclusive)
	 * @return the range of matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vus where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of chuc vus
	 * @param end the upper bound of the range of chuc vus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findByTrangThai(int daXoa, int start, int end,
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

		List<ChucVu> list = (List<ChucVu>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChucVuModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<ChucVu>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first chuc vu in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVuException, SystemException {
		List<ChucVu> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVuException, SystemException {
		int count = countByTrangThai(daXoa);

		List<ChucVu> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vus before and after the current chuc vu in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchChucVuException, SystemException {
		ChucVu chucVu = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu[] array = new ChucVuImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, chucVu, daXoa,
					orderByComparator, true);

			array[1] = chucVu;

			array[2] = getByTrangThai_PrevAndNext(session, chucVu, daXoa,
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

	protected ChucVu getByTrangThai_PrevAndNext(Session session, ChucVu chucVu,
		int daXoa, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU_WHERE);

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
			query.append(ChucVuModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vus where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findByMa(String ma) throws SystemException {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vus where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of chuc vus
	 * @param end the upper bound of the range of chuc vus (not inclusive)
	 * @return the range of matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findByMa(String ma, int start, int end)
		throws SystemException {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vus where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of chuc vus
	 * @param end the upper bound of the range of chuc vus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findByMa(String ma, int start, int end,
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

		List<ChucVu> list = (List<ChucVu>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU_WHERE);

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
				query.append(ChucVuModelImpl.ORDER_BY_JPQL);
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

				list = (List<ChucVu>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first chuc vu in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu findByMa_First(String ma, OrderByComparator orderByComparator)
		throws NoSuchChucVuException, SystemException {
		List<ChucVu> list = findByMa(ma, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu findByMa_Last(String ma, OrderByComparator orderByComparator)
		throws NoSuchChucVuException, SystemException {
		int count = countByMa(ma);

		List<ChucVu> list = findByMa(ma, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vus before and after the current chuc vu in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu[] findByMa_PrevAndNext(long id, String ma,
		OrderByComparator orderByComparator)
		throws NoSuchChucVuException, SystemException {
		ChucVu chucVu = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu[] array = new ChucVuImpl[3];

			array[0] = getByMa_PrevAndNext(session, chucVu, ma,
					orderByComparator, true);

			array[1] = chucVu;

			array[2] = getByMa_PrevAndNext(session, chucVu, ma,
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

	protected ChucVu getByMa_PrevAndNext(Session session, ChucVu chucVu,
		String ma, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU_WHERE);

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
			query.append(ChucVuModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vus where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findByTen(String ten) throws SystemException {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vus where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of chuc vus
	 * @param end the upper bound of the range of chuc vus (not inclusive)
	 * @return the range of matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findByTen(String ten, int start, int end)
		throws SystemException {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vus where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of chuc vus
	 * @param end the upper bound of the range of chuc vus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findByTen(String ten, int start, int end,
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

		List<ChucVu> list = (List<ChucVu>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CHUCVU_WHERE);

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
				query.append(ChucVuModelImpl.ORDER_BY_JPQL);
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

				list = (List<ChucVu>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first chuc vu in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu findByTen_First(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchChucVuException, SystemException {
		List<ChucVu> list = findByTen(ten, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last chuc vu in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu findByTen_Last(String ten, OrderByComparator orderByComparator)
		throws NoSuchChucVuException, SystemException {
		int count = countByTen(ten);

		List<ChucVu> list = findByTen(ten, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchChucVuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the chuc vus before and after the current chuc vu in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current chuc vu
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chuc vu
	 * @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChucVu[] findByTen_PrevAndNext(long id, String ten,
		OrderByComparator orderByComparator)
		throws NoSuchChucVuException, SystemException {
		ChucVu chucVu = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChucVu[] array = new ChucVuImpl[3];

			array[0] = getByTen_PrevAndNext(session, chucVu, ten,
					orderByComparator, true);

			array[1] = chucVu;

			array[2] = getByTen_PrevAndNext(session, chucVu, ten,
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

	protected ChucVu getByTen_PrevAndNext(Session session, ChucVu chucVu,
		String ten, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHUCVU_WHERE);

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
			query.append(ChucVuModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(chucVu);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChucVu> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the chuc vus.
	 *
	 * @return the chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuc vus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of chuc vus
	 * @param end the upper bound of the range of chuc vus (not inclusive)
	 * @return the range of chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuc vus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of chuc vus
	 * @param end the upper bound of the range of chuc vus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChucVu> findAll(int start, int end,
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

		List<ChucVu> list = (List<ChucVu>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHUCVU);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHUCVU.concat(ChucVuModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ChucVu>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ChucVu>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the chuc vus where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (ChucVu chucVu : findByTrangThai(daXoa)) {
			remove(chucVu);
		}
	}

	/**
	 * Removes all the chuc vus where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma) throws SystemException {
		for (ChucVu chucVu : findByMa(ma)) {
			remove(chucVu);
		}
	}

	/**
	 * Removes all the chuc vus where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten) throws SystemException {
		for (ChucVu chucVu : findByTen(ten)) {
			remove(chucVu);
		}
	}

	/**
	 * Removes all the chuc vus from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ChucVu chucVu : findAll()) {
			remove(chucVu);
		}
	}

	/**
	 * Returns the number of chuc vus where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHUCVU_WHERE);

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
	 * Returns the number of chuc vus where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHUCVU_WHERE);

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
	 * Returns the number of chuc vus where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHUCVU_WHERE);

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
	 * Returns the number of chuc vus.
	 *
	 * @return the number of chuc vus
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHUCVU);

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
	 * Initializes the chuc vu persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cc.model.ChucVu")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChucVu>> listenersList = new ArrayList<ModelListener<ChucVu>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChucVu>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChucVuImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChucVuPersistence.class)
	protected ChucVuPersistence chucVuPersistence;
	@BeanReference(type = CongChucPersistence.class)
	protected CongChucPersistence congChucPersistence;
	@BeanReference(type = CongChuc2NhomThuTucPersistence.class)
	protected CongChuc2NhomThuTucPersistence congChuc2NhomThuTucPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CHUCVU = "SELECT chucVu FROM ChucVu chucVu";
	private static final String _SQL_SELECT_CHUCVU_WHERE = "SELECT chucVu FROM ChucVu chucVu WHERE ";
	private static final String _SQL_COUNT_CHUCVU = "SELECT COUNT(chucVu) FROM ChucVu chucVu";
	private static final String _SQL_COUNT_CHUCVU_WHERE = "SELECT COUNT(chucVu) FROM ChucVu chucVu WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "chucVu.daXoa = ?";
	private static final String _FINDER_COLUMN_MA_MA_1 = "chucVu.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "chucVu.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(chucVu.ma IS NULL OR chucVu.ma = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "chucVu.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "chucVu.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(chucVu.ten IS NULL OR chucVu.ten = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chucVu.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChucVu exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChucVu exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChucVuPersistenceImpl.class);
	private static ChucVu _nullChucVu = new ChucVuImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChucVu> toCacheModel() {
				return _nullChucVuCacheModel;
			}
		};

	private static CacheModel<ChucVu> _nullChucVuCacheModel = new CacheModel<ChucVu>() {
			public ChucVu toEntityModel() {
				return _nullChucVu;
			}
		};
}