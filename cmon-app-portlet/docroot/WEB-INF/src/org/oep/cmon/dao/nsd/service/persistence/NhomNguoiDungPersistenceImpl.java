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

import org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException;
import org.oep.cmon.dao.nsd.model.NhomNguoiDung;
import org.oep.cmon.dao.nsd.model.impl.NhomNguoiDungImpl;
import org.oep.cmon.dao.nsd.model.impl.NhomNguoiDungModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the nhom nguoi dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see NhomNguoiDungPersistence
 * @see NhomNguoiDungUtil
 * @generated
 */
public class NhomNguoiDungPersistenceImpl extends BasePersistenceImpl<NhomNguoiDung>
	implements NhomNguoiDungPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NhomNguoiDungUtil} to access the nhom nguoi dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NhomNguoiDungImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			NhomNguoiDungImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTen",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			NhomNguoiDungImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTen", new String[] { String.class.getName() },
			NhomNguoiDungModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			NhomNguoiDungImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			NhomNguoiDungImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTrangThai", new String[] { Integer.class.getName() },
			NhomNguoiDungModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			NhomNguoiDungImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			NhomNguoiDungImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the nhom nguoi dung in the entity cache if it is enabled.
	 *
	 * @param nhomNguoiDung the nhom nguoi dung
	 */
	public void cacheResult(NhomNguoiDung nhomNguoiDung) {
		EntityCacheUtil.putResult(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungImpl.class, nhomNguoiDung.getPrimaryKey(),
			nhomNguoiDung);

		nhomNguoiDung.resetOriginalValues();
	}

	/**
	 * Caches the nhom nguoi dungs in the entity cache if it is enabled.
	 *
	 * @param nhomNguoiDungs the nhom nguoi dungs
	 */
	public void cacheResult(List<NhomNguoiDung> nhomNguoiDungs) {
		for (NhomNguoiDung nhomNguoiDung : nhomNguoiDungs) {
			if (EntityCacheUtil.getResult(
						NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
						NhomNguoiDungImpl.class, nhomNguoiDung.getPrimaryKey()) == null) {
				cacheResult(nhomNguoiDung);
			}
			else {
				nhomNguoiDung.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all nhom nguoi dungs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NhomNguoiDungImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NhomNguoiDungImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the nhom nguoi dung.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NhomNguoiDung nhomNguoiDung) {
		EntityCacheUtil.removeResult(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungImpl.class, nhomNguoiDung.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NhomNguoiDung> nhomNguoiDungs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NhomNguoiDung nhomNguoiDung : nhomNguoiDungs) {
			EntityCacheUtil.removeResult(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
				NhomNguoiDungImpl.class, nhomNguoiDung.getPrimaryKey());
		}
	}

	/**
	 * Creates a new nhom nguoi dung with the primary key. Does not add the nhom nguoi dung to the database.
	 *
	 * @param id the primary key for the new nhom nguoi dung
	 * @return the new nhom nguoi dung
	 */
	public NhomNguoiDung create(long id) {
		NhomNguoiDung nhomNguoiDung = new NhomNguoiDungImpl();

		nhomNguoiDung.setNew(true);
		nhomNguoiDung.setPrimaryKey(id);

		return nhomNguoiDung;
	}

	/**
	 * Removes the nhom nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom nguoi dung
	 * @return the nhom nguoi dung that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a nhom nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NhomNguoiDung remove(long id)
		throws NoSuchNhomNguoiDungException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the nhom nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nhom nguoi dung
	 * @return the nhom nguoi dung that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a nhom nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NhomNguoiDung remove(Serializable primaryKey)
		throws NoSuchNhomNguoiDungException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NhomNguoiDung nhomNguoiDung = (NhomNguoiDung)session.get(NhomNguoiDungImpl.class,
					primaryKey);

			if (nhomNguoiDung == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNhomNguoiDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(nhomNguoiDung);
		}
		catch (NoSuchNhomNguoiDungException nsee) {
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
	protected NhomNguoiDung removeImpl(NhomNguoiDung nhomNguoiDung)
		throws SystemException {
		nhomNguoiDung = toUnwrappedModel(nhomNguoiDung);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, nhomNguoiDung);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(nhomNguoiDung);

		return nhomNguoiDung;
	}

	@Override
	public NhomNguoiDung updateImpl(
		org.oep.cmon.dao.nsd.model.NhomNguoiDung nhomNguoiDung, boolean merge)
		throws SystemException {
		nhomNguoiDung = toUnwrappedModel(nhomNguoiDung);

		boolean isNew = nhomNguoiDung.isNew();

		NhomNguoiDungModelImpl nhomNguoiDungModelImpl = (NhomNguoiDungModelImpl)nhomNguoiDung;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, nhomNguoiDung, merge);

			nhomNguoiDung.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NhomNguoiDungModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((nhomNguoiDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						nhomNguoiDungModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] { nhomNguoiDungModelImpl.getTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}

			if ((nhomNguoiDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(nhomNguoiDungModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(nhomNguoiDungModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			NhomNguoiDungImpl.class, nhomNguoiDung.getPrimaryKey(),
			nhomNguoiDung);

		return nhomNguoiDung;
	}

	protected NhomNguoiDung toUnwrappedModel(NhomNguoiDung nhomNguoiDung) {
		if (nhomNguoiDung instanceof NhomNguoiDungImpl) {
			return nhomNguoiDung;
		}

		NhomNguoiDungImpl nhomNguoiDungImpl = new NhomNguoiDungImpl();

		nhomNguoiDungImpl.setNew(nhomNguoiDung.isNew());
		nhomNguoiDungImpl.setPrimaryKey(nhomNguoiDung.getPrimaryKey());

		nhomNguoiDungImpl.setId(nhomNguoiDung.getId());
		nhomNguoiDungImpl.setTen(nhomNguoiDung.getTen());
		nhomNguoiDungImpl.setMoTa(nhomNguoiDung.getMoTa());
		nhomNguoiDungImpl.setNgayTao(nhomNguoiDung.getNgayTao());
		nhomNguoiDungImpl.setDaXoa(nhomNguoiDung.getDaXoa());
		nhomNguoiDungImpl.setNgaySua(nhomNguoiDung.getNgaySua());
		nhomNguoiDungImpl.setNguoiTao(nhomNguoiDung.getNguoiTao());
		nhomNguoiDungImpl.setNguoiSua(nhomNguoiDung.getNguoiSua());
		nhomNguoiDungImpl.setTrangThai(nhomNguoiDung.getTrangThai());

		return nhomNguoiDungImpl;
	}

	/**
	 * Returns the nhom nguoi dung with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the nhom nguoi dung
	 * @return the nhom nguoi dung
	 * @throws com.liferay.portal.NoSuchModelException if a nhom nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NhomNguoiDung findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the nhom nguoi dung with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException} if it could not be found.
	 *
	 * @param id the primary key of the nhom nguoi dung
	 * @return the nhom nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a nhom nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NhomNguoiDung findByPrimaryKey(long id)
		throws NoSuchNhomNguoiDungException, SystemException {
		NhomNguoiDung nhomNguoiDung = fetchByPrimaryKey(id);

		if (nhomNguoiDung == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchNhomNguoiDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return nhomNguoiDung;
	}

	/**
	 * Returns the nhom nguoi dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nhom nguoi dung
	 * @return the nhom nguoi dung, or <code>null</code> if a nhom nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NhomNguoiDung fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the nhom nguoi dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom nguoi dung
	 * @return the nhom nguoi dung, or <code>null</code> if a nhom nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NhomNguoiDung fetchByPrimaryKey(long id) throws SystemException {
		NhomNguoiDung nhomNguoiDung = (NhomNguoiDung)EntityCacheUtil.getResult(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
				NhomNguoiDungImpl.class, id);

		if (nhomNguoiDung == _nullNhomNguoiDung) {
			return null;
		}

		if (nhomNguoiDung == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				nhomNguoiDung = (NhomNguoiDung)session.get(NhomNguoiDungImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (nhomNguoiDung != null) {
					cacheResult(nhomNguoiDung);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(NhomNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
						NhomNguoiDungImpl.class, id, _nullNhomNguoiDung);
				}

				closeSession(session);
			}
		}

		return nhomNguoiDung;
	}

	/**
	 * Returns all the nhom nguoi dungs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NhomNguoiDung> findByTen(String ten) throws SystemException {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nhom nguoi dungs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of nhom nguoi dungs
	 * @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	 * @return the range of matching nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NhomNguoiDung> findByTen(String ten, int start, int end)
		throws SystemException {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the nhom nguoi dungs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of nhom nguoi dungs
	 * @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NhomNguoiDung> findByTen(String ten, int start, int end,
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

		List<NhomNguoiDung> list = (List<NhomNguoiDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_NHOMNGUOIDUNG_WHERE);

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
				query.append(NhomNguoiDungModelImpl.ORDER_BY_JPQL);
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

				list = (List<NhomNguoiDung>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first nhom nguoi dung in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nhom nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a matching nhom nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NhomNguoiDung findByTen_First(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchNhomNguoiDungException, SystemException {
		List<NhomNguoiDung> list = findByTen(ten, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNhomNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last nhom nguoi dung in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nhom nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a matching nhom nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NhomNguoiDung findByTen_Last(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchNhomNguoiDungException, SystemException {
		int count = countByTen(ten);

		List<NhomNguoiDung> list = findByTen(ten, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNhomNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the nhom nguoi dungs before and after the current nhom nguoi dung in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current nhom nguoi dung
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nhom nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a nhom nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NhomNguoiDung[] findByTen_PrevAndNext(long id, String ten,
		OrderByComparator orderByComparator)
		throws NoSuchNhomNguoiDungException, SystemException {
		NhomNguoiDung nhomNguoiDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NhomNguoiDung[] array = new NhomNguoiDungImpl[3];

			array[0] = getByTen_PrevAndNext(session, nhomNguoiDung, ten,
					orderByComparator, true);

			array[1] = nhomNguoiDung;

			array[2] = getByTen_PrevAndNext(session, nhomNguoiDung, ten,
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

	protected NhomNguoiDung getByTen_PrevAndNext(Session session,
		NhomNguoiDung nhomNguoiDung, String ten,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NHOMNGUOIDUNG_WHERE);

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
			query.append(NhomNguoiDungModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(nhomNguoiDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NhomNguoiDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the nhom nguoi dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NhomNguoiDung> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nhom nguoi dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nhom nguoi dungs
	 * @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	 * @return the range of matching nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NhomNguoiDung> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the nhom nguoi dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nhom nguoi dungs
	 * @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NhomNguoiDung> findByTrangThai(int daXoa, int start, int end,
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

		List<NhomNguoiDung> list = (List<NhomNguoiDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_NHOMNGUOIDUNG_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(NhomNguoiDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<NhomNguoiDung>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first nhom nguoi dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nhom nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a matching nhom nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NhomNguoiDung findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNhomNguoiDungException, SystemException {
		List<NhomNguoiDung> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNhomNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last nhom nguoi dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nhom nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a matching nhom nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NhomNguoiDung findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNhomNguoiDungException, SystemException {
		int count = countByTrangThai(daXoa);

		List<NhomNguoiDung> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNhomNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the nhom nguoi dungs before and after the current nhom nguoi dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current nhom nguoi dung
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nhom nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a nhom nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NhomNguoiDung[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNhomNguoiDungException, SystemException {
		NhomNguoiDung nhomNguoiDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NhomNguoiDung[] array = new NhomNguoiDungImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, nhomNguoiDung,
					daXoa, orderByComparator, true);

			array[1] = nhomNguoiDung;

			array[2] = getByTrangThai_PrevAndNext(session, nhomNguoiDung,
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

	protected NhomNguoiDung getByTrangThai_PrevAndNext(Session session,
		NhomNguoiDung nhomNguoiDung, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NHOMNGUOIDUNG_WHERE);

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
			query.append(NhomNguoiDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(nhomNguoiDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NhomNguoiDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the nhom nguoi dungs.
	 *
	 * @return the nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NhomNguoiDung> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nhom nguoi dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom nguoi dungs
	 * @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	 * @return the range of nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NhomNguoiDung> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the nhom nguoi dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom nguoi dungs
	 * @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<NhomNguoiDung> findAll(int start, int end,
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

		List<NhomNguoiDung> list = (List<NhomNguoiDung>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NHOMNGUOIDUNG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NHOMNGUOIDUNG.concat(NhomNguoiDungModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<NhomNguoiDung>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<NhomNguoiDung>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the nhom nguoi dungs where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten) throws SystemException {
		for (NhomNguoiDung nhomNguoiDung : findByTen(ten)) {
			remove(nhomNguoiDung);
		}
	}

	/**
	 * Removes all the nhom nguoi dungs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (NhomNguoiDung nhomNguoiDung : findByTrangThai(daXoa)) {
			remove(nhomNguoiDung);
		}
	}

	/**
	 * Removes all the nhom nguoi dungs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (NhomNguoiDung nhomNguoiDung : findAll()) {
			remove(nhomNguoiDung);
		}
	}

	/**
	 * Returns the number of nhom nguoi dungs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NHOMNGUOIDUNG_WHERE);

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
	 * Returns the number of nhom nguoi dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NHOMNGUOIDUNG_WHERE);

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
	 * Returns the number of nhom nguoi dungs.
	 *
	 * @return the number of nhom nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NHOMNGUOIDUNG);

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
	 * Initializes the nhom nguoi dung persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.nsd.model.NhomNguoiDung")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NhomNguoiDung>> listenersList = new ArrayList<ModelListener<NhomNguoiDung>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NhomNguoiDung>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NhomNguoiDungImpl.class.getName());
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
	private static final String _SQL_SELECT_NHOMNGUOIDUNG = "SELECT nhomNguoiDung FROM NhomNguoiDung nhomNguoiDung";
	private static final String _SQL_SELECT_NHOMNGUOIDUNG_WHERE = "SELECT nhomNguoiDung FROM NhomNguoiDung nhomNguoiDung WHERE ";
	private static final String _SQL_COUNT_NHOMNGUOIDUNG = "SELECT COUNT(nhomNguoiDung) FROM NhomNguoiDung nhomNguoiDung";
	private static final String _SQL_COUNT_NHOMNGUOIDUNG_WHERE = "SELECT COUNT(nhomNguoiDung) FROM NhomNguoiDung nhomNguoiDung WHERE ";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "nhomNguoiDung.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "nhomNguoiDung.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(nhomNguoiDung.ten IS NULL OR nhomNguoiDung.ten = ?)";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "nhomNguoiDung.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nhomNguoiDung.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NhomNguoiDung exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NhomNguoiDung exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NhomNguoiDungPersistenceImpl.class);
	private static NhomNguoiDung _nullNhomNguoiDung = new NhomNguoiDungImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NhomNguoiDung> toCacheModel() {
				return _nullNhomNguoiDungCacheModel;
			}
		};

	private static CacheModel<NhomNguoiDung> _nullNhomNguoiDungCacheModel = new CacheModel<NhomNguoiDung>() {
			public NhomNguoiDung toEntityModel() {
				return _nullNhomNguoiDung;
			}
		};
}