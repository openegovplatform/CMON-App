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

package org.oep.cmon.anhcongdan.service.persistence;

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

import org.oep.cmon.anhcongdan.NoSuchAnhCongDanException;
import org.oep.cmon.anhcongdan.model.AnhCongDan;
import org.oep.cmon.anhcongdan.model.impl.AnhCongDanImpl;
import org.oep.cmon.anhcongdan.model.impl.AnhCongDanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the anh cong dan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see AnhCongDanPersistence
 * @see AnhCongDanUtil
 * @generated
 */
public class AnhCongDanPersistenceImpl extends BasePersistenceImpl<AnhCongDan>
	implements AnhCongDanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnhCongDanUtil} to access the anh cong dan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnhCongDanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MA = new FinderPath(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanModelImpl.FINDER_CACHE_ENABLED, AnhCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA = new FinderPath(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanModelImpl.FINDER_CACHE_ENABLED, AnhCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] { String.class.getName() },
			AnhCongDanModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanModelImpl.FINDER_CACHE_ENABLED, AnhCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanModelImpl.FINDER_CACHE_ENABLED, AnhCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] { String.class.getName() },
			AnhCongDanModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanModelImpl.FINDER_CACHE_ENABLED, AnhCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanModelImpl.FINDER_CACHE_ENABLED, AnhCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the anh cong dan in the entity cache if it is enabled.
	 *
	 * @param anhCongDan the anh cong dan
	 */
	public void cacheResult(AnhCongDan anhCongDan) {
		EntityCacheUtil.putResult(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanImpl.class, anhCongDan.getPrimaryKey(), anhCongDan);

		anhCongDan.resetOriginalValues();
	}

	/**
	 * Caches the anh cong dans in the entity cache if it is enabled.
	 *
	 * @param anhCongDans the anh cong dans
	 */
	public void cacheResult(List<AnhCongDan> anhCongDans) {
		for (AnhCongDan anhCongDan : anhCongDans) {
			if (EntityCacheUtil.getResult(
						AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
						AnhCongDanImpl.class, anhCongDan.getPrimaryKey()) == null) {
				cacheResult(anhCongDan);
			}
			else {
				anhCongDan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all anh cong dans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnhCongDanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnhCongDanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the anh cong dan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnhCongDan anhCongDan) {
		EntityCacheUtil.removeResult(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanImpl.class, anhCongDan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnhCongDan> anhCongDans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnhCongDan anhCongDan : anhCongDans) {
			EntityCacheUtil.removeResult(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
				AnhCongDanImpl.class, anhCongDan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new anh cong dan with the primary key. Does not add the anh cong dan to the database.
	 *
	 * @param id the primary key for the new anh cong dan
	 * @return the new anh cong dan
	 */
	public AnhCongDan create(long id) {
		AnhCongDan anhCongDan = new AnhCongDanImpl();

		anhCongDan.setNew(true);
		anhCongDan.setPrimaryKey(id);

		return anhCongDan;
	}

	/**
	 * Removes the anh cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the anh cong dan
	 * @return the anh cong dan that was removed
	 * @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a anh cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhCongDan remove(long id)
		throws NoSuchAnhCongDanException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the anh cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the anh cong dan
	 * @return the anh cong dan that was removed
	 * @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a anh cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnhCongDan remove(Serializable primaryKey)
		throws NoSuchAnhCongDanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AnhCongDan anhCongDan = (AnhCongDan)session.get(AnhCongDanImpl.class,
					primaryKey);

			if (anhCongDan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnhCongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(anhCongDan);
		}
		catch (NoSuchAnhCongDanException nsee) {
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
	protected AnhCongDan removeImpl(AnhCongDan anhCongDan)
		throws SystemException {
		anhCongDan = toUnwrappedModel(anhCongDan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, anhCongDan);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(anhCongDan);

		return anhCongDan;
	}

	@Override
	public AnhCongDan updateImpl(
		org.oep.cmon.anhcongdan.model.AnhCongDan anhCongDan, boolean merge)
		throws SystemException {
		anhCongDan = toUnwrappedModel(anhCongDan);

		boolean isNew = anhCongDan.isNew();

		AnhCongDanModelImpl anhCongDanModelImpl = (AnhCongDanModelImpl)anhCongDan;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, anhCongDan, merge);

			anhCongDan.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnhCongDanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((anhCongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { anhCongDanModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);

				args = new Object[] { anhCongDanModelImpl.getMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);
			}

			if ((anhCongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						anhCongDanModelImpl.getOriginalEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);

				args = new Object[] { anhCongDanModelImpl.getEmail() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);
			}
		}

		EntityCacheUtil.putResult(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhCongDanImpl.class, anhCongDan.getPrimaryKey(), anhCongDan);

		return anhCongDan;
	}

	protected AnhCongDan toUnwrappedModel(AnhCongDan anhCongDan) {
		if (anhCongDan instanceof AnhCongDanImpl) {
			return anhCongDan;
		}

		AnhCongDanImpl anhCongDanImpl = new AnhCongDanImpl();

		anhCongDanImpl.setNew(anhCongDan.isNew());
		anhCongDanImpl.setPrimaryKey(anhCongDan.getPrimaryKey());

		anhCongDanImpl.setId(anhCongDan.getId());
		anhCongDanImpl.setMa(anhCongDan.getMa());
		anhCongDanImpl.setEmail(anhCongDan.getEmail());
		anhCongDanImpl.setAnh(anhCongDan.getAnh());

		return anhCongDanImpl;
	}

	/**
	 * Returns the anh cong dan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the anh cong dan
	 * @return the anh cong dan
	 * @throws com.liferay.portal.NoSuchModelException if a anh cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnhCongDan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the anh cong dan with the primary key or throws a {@link org.oep.cmon.anhcongdan.NoSuchAnhCongDanException} if it could not be found.
	 *
	 * @param id the primary key of the anh cong dan
	 * @return the anh cong dan
	 * @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a anh cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhCongDan findByPrimaryKey(long id)
		throws NoSuchAnhCongDanException, SystemException {
		AnhCongDan anhCongDan = fetchByPrimaryKey(id);

		if (anhCongDan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchAnhCongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return anhCongDan;
	}

	/**
	 * Returns the anh cong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the anh cong dan
	 * @return the anh cong dan, or <code>null</code> if a anh cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnhCongDan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the anh cong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the anh cong dan
	 * @return the anh cong dan, or <code>null</code> if a anh cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhCongDan fetchByPrimaryKey(long id) throws SystemException {
		AnhCongDan anhCongDan = (AnhCongDan)EntityCacheUtil.getResult(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
				AnhCongDanImpl.class, id);

		if (anhCongDan == _nullAnhCongDan) {
			return null;
		}

		if (anhCongDan == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				anhCongDan = (AnhCongDan)session.get(AnhCongDanImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (anhCongDan != null) {
					cacheResult(anhCongDan);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AnhCongDanModelImpl.ENTITY_CACHE_ENABLED,
						AnhCongDanImpl.class, id, _nullAnhCongDan);
				}

				closeSession(session);
			}
		}

		return anhCongDan;
	}

	/**
	 * Returns all the anh cong dans where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhCongDan> findByMa(String ma) throws SystemException {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anh cong dans where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of anh cong dans
	 * @param end the upper bound of the range of anh cong dans (not inclusive)
	 * @return the range of matching anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhCongDan> findByMa(String ma, int start, int end)
		throws SystemException {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anh cong dans where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of anh cong dans
	 * @param end the upper bound of the range of anh cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhCongDan> findByMa(String ma, int start, int end,
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

		List<AnhCongDan> list = (List<AnhCongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_ANHCONGDAN_WHERE);

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
				query.append(AnhCongDanModelImpl.ORDER_BY_JPQL);
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

				list = (List<AnhCongDan>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first anh cong dan in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anh cong dan
	 * @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a matching anh cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhCongDan findByMa_First(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchAnhCongDanException, SystemException {
		List<AnhCongDan> list = findByMa(ma, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last anh cong dan in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anh cong dan
	 * @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a matching anh cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhCongDan findByMa_Last(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchAnhCongDanException, SystemException {
		int count = countByMa(ma);

		List<AnhCongDan> list = findByMa(ma, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the anh cong dans before and after the current anh cong dan in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current anh cong dan
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anh cong dan
	 * @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a anh cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhCongDan[] findByMa_PrevAndNext(long id, String ma,
		OrderByComparator orderByComparator)
		throws NoSuchAnhCongDanException, SystemException {
		AnhCongDan anhCongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AnhCongDan[] array = new AnhCongDanImpl[3];

			array[0] = getByMa_PrevAndNext(session, anhCongDan, ma,
					orderByComparator, true);

			array[1] = anhCongDan;

			array[2] = getByMa_PrevAndNext(session, anhCongDan, ma,
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

	protected AnhCongDan getByMa_PrevAndNext(Session session,
		AnhCongDan anhCongDan, String ma, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANHCONGDAN_WHERE);

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
			query.append(AnhCongDanModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(anhCongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnhCongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the anh cong dans where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhCongDan> findByEmail(String email) throws SystemException {
		return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anh cong dans where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of anh cong dans
	 * @param end the upper bound of the range of anh cong dans (not inclusive)
	 * @return the range of matching anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhCongDan> findByEmail(String email, int start, int end)
		throws SystemException {
		return findByEmail(email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anh cong dans where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of anh cong dans
	 * @param end the upper bound of the range of anh cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhCongDan> findByEmail(String email, int start, int end,
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

		List<AnhCongDan> list = (List<AnhCongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_ANHCONGDAN_WHERE);

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
				query.append(AnhCongDanModelImpl.ORDER_BY_JPQL);
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

				list = (List<AnhCongDan>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first anh cong dan in the ordered set where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anh cong dan
	 * @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a matching anh cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhCongDan findByEmail_First(String email,
		OrderByComparator orderByComparator)
		throws NoSuchAnhCongDanException, SystemException {
		List<AnhCongDan> list = findByEmail(email, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last anh cong dan in the ordered set where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anh cong dan
	 * @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a matching anh cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhCongDan findByEmail_Last(String email,
		OrderByComparator orderByComparator)
		throws NoSuchAnhCongDanException, SystemException {
		int count = countByEmail(email);

		List<AnhCongDan> list = findByEmail(email, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the anh cong dans before and after the current anh cong dan in the ordered set where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current anh cong dan
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anh cong dan
	 * @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a anh cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhCongDan[] findByEmail_PrevAndNext(long id, String email,
		OrderByComparator orderByComparator)
		throws NoSuchAnhCongDanException, SystemException {
		AnhCongDan anhCongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AnhCongDan[] array = new AnhCongDanImpl[3];

			array[0] = getByEmail_PrevAndNext(session, anhCongDan, email,
					orderByComparator, true);

			array[1] = anhCongDan;

			array[2] = getByEmail_PrevAndNext(session, anhCongDan, email,
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

	protected AnhCongDan getByEmail_PrevAndNext(Session session,
		AnhCongDan anhCongDan, String email,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANHCONGDAN_WHERE);

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
			query.append(AnhCongDanModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(anhCongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnhCongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the anh cong dans.
	 *
	 * @return the anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhCongDan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anh cong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of anh cong dans
	 * @param end the upper bound of the range of anh cong dans (not inclusive)
	 * @return the range of anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhCongDan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the anh cong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of anh cong dans
	 * @param end the upper bound of the range of anh cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhCongDan> findAll(int start, int end,
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

		List<AnhCongDan> list = (List<AnhCongDan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANHCONGDAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANHCONGDAN.concat(AnhCongDanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AnhCongDan>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AnhCongDan>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the anh cong dans where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma) throws SystemException {
		for (AnhCongDan anhCongDan : findByMa(ma)) {
			remove(anhCongDan);
		}
	}

	/**
	 * Removes all the anh cong dans where email = &#63; from the database.
	 *
	 * @param email the email
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEmail(String email) throws SystemException {
		for (AnhCongDan anhCongDan : findByEmail(email)) {
			remove(anhCongDan);
		}
	}

	/**
	 * Removes all the anh cong dans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AnhCongDan anhCongDan : findAll()) {
			remove(anhCongDan);
		}
	}

	/**
	 * Returns the number of anh cong dans where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANHCONGDAN_WHERE);

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
	 * Returns the number of anh cong dans where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEmail(String email) throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAIL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANHCONGDAN_WHERE);

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
	 * Returns the number of anh cong dans.
	 *
	 * @return the number of anh cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANHCONGDAN);

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
	 * Initializes the anh cong dan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.anhcongdan.model.AnhCongDan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AnhCongDan>> listenersList = new ArrayList<ModelListener<AnhCongDan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AnhCongDan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnhCongDanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AnhCongDanPersistence.class)
	protected AnhCongDanPersistence anhCongDanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ANHCONGDAN = "SELECT anhCongDan FROM AnhCongDan anhCongDan";
	private static final String _SQL_SELECT_ANHCONGDAN_WHERE = "SELECT anhCongDan FROM AnhCongDan anhCongDan WHERE ";
	private static final String _SQL_COUNT_ANHCONGDAN = "SELECT COUNT(anhCongDan) FROM AnhCongDan anhCongDan";
	private static final String _SQL_COUNT_ANHCONGDAN_WHERE = "SELECT COUNT(anhCongDan) FROM AnhCongDan anhCongDan WHERE ";
	private static final String _FINDER_COLUMN_MA_MA_1 = "anhCongDan.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "anhCongDan.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(anhCongDan.ma IS NULL OR anhCongDan.ma = ?)";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "anhCongDan.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "anhCongDan.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(anhCongDan.email IS NULL OR anhCongDan.email = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "anhCongDan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnhCongDan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AnhCongDan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnhCongDanPersistenceImpl.class);
	private static AnhCongDan _nullAnhCongDan = new AnhCongDanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AnhCongDan> toCacheModel() {
				return _nullAnhCongDanCacheModel;
			}
		};

	private static CacheModel<AnhCongDan> _nullAnhCongDanCacheModel = new CacheModel<AnhCongDan>() {
			public AnhCongDan toEntityModel() {
				return _nullAnhCongDan;
			}
		};
}