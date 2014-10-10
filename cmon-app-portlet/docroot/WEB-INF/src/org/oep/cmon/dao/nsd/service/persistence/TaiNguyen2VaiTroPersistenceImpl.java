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

import org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro;
import org.oep.cmon.dao.nsd.model.impl.TaiNguyen2VaiTroImpl;
import org.oep.cmon.dao.nsd.model.impl.TaiNguyen2VaiTroModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tai nguyen2 vai tro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TaiNguyen2VaiTroPersistence
 * @see TaiNguyen2VaiTroUtil
 * @generated
 */
public class TaiNguyen2VaiTroPersistenceImpl extends BasePersistenceImpl<TaiNguyen2VaiTro>
	implements TaiNguyen2VaiTroPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaiNguyen2VaiTroUtil} to access the tai nguyen2 vai tro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaiNguyen2VaiTroImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VAITROID = new FinderPath(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyen2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			TaiNguyen2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVaiTroID",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID =
		new FinderPath(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyen2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			TaiNguyen2VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVaiTroID",
			new String[] { Long.class.getName(), Integer.class.getName() },
			TaiNguyen2VaiTroModelImpl.VAITROID_COLUMN_BITMASK |
			TaiNguyen2VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VAITROID = new FinderPath(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyen2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVaiTroID",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyen2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			TaiNguyen2VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyen2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			TaiNguyen2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyen2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tai nguyen2 vai tro in the entity cache if it is enabled.
	 *
	 * @param taiNguyen2VaiTro the tai nguyen2 vai tro
	 */
	public void cacheResult(TaiNguyen2VaiTro taiNguyen2VaiTro) {
		EntityCacheUtil.putResult(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyen2VaiTroImpl.class, taiNguyen2VaiTro.getPrimaryKey(),
			taiNguyen2VaiTro);

		taiNguyen2VaiTro.resetOriginalValues();
	}

	/**
	 * Caches the tai nguyen2 vai tros in the entity cache if it is enabled.
	 *
	 * @param taiNguyen2VaiTros the tai nguyen2 vai tros
	 */
	public void cacheResult(List<TaiNguyen2VaiTro> taiNguyen2VaiTros) {
		for (TaiNguyen2VaiTro taiNguyen2VaiTro : taiNguyen2VaiTros) {
			if (EntityCacheUtil.getResult(
						TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
						TaiNguyen2VaiTroImpl.class,
						taiNguyen2VaiTro.getPrimaryKey()) == null) {
				cacheResult(taiNguyen2VaiTro);
			}
			else {
				taiNguyen2VaiTro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tai nguyen2 vai tros.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaiNguyen2VaiTroImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaiNguyen2VaiTroImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tai nguyen2 vai tro.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaiNguyen2VaiTro taiNguyen2VaiTro) {
		EntityCacheUtil.removeResult(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyen2VaiTroImpl.class, taiNguyen2VaiTro.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaiNguyen2VaiTro> taiNguyen2VaiTros) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaiNguyen2VaiTro taiNguyen2VaiTro : taiNguyen2VaiTros) {
			EntityCacheUtil.removeResult(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
				TaiNguyen2VaiTroImpl.class, taiNguyen2VaiTro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tai nguyen2 vai tro with the primary key. Does not add the tai nguyen2 vai tro to the database.
	 *
	 * @param id the primary key for the new tai nguyen2 vai tro
	 * @return the new tai nguyen2 vai tro
	 */
	public TaiNguyen2VaiTro create(long id) {
		TaiNguyen2VaiTro taiNguyen2VaiTro = new TaiNguyen2VaiTroImpl();

		taiNguyen2VaiTro.setNew(true);
		taiNguyen2VaiTro.setPrimaryKey(id);

		return taiNguyen2VaiTro;
	}

	/**
	 * Removes the tai nguyen2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tai nguyen2 vai tro
	 * @return the tai nguyen2 vai tro that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException if a tai nguyen2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen2VaiTro remove(long id)
		throws NoSuchTaiNguyen2VaiTroException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the tai nguyen2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tai nguyen2 vai tro
	 * @return the tai nguyen2 vai tro that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException if a tai nguyen2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiNguyen2VaiTro remove(Serializable primaryKey)
		throws NoSuchTaiNguyen2VaiTroException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaiNguyen2VaiTro taiNguyen2VaiTro = (TaiNguyen2VaiTro)session.get(TaiNguyen2VaiTroImpl.class,
					primaryKey);

			if (taiNguyen2VaiTro == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaiNguyen2VaiTroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taiNguyen2VaiTro);
		}
		catch (NoSuchTaiNguyen2VaiTroException nsee) {
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
	protected TaiNguyen2VaiTro removeImpl(TaiNguyen2VaiTro taiNguyen2VaiTro)
		throws SystemException {
		taiNguyen2VaiTro = toUnwrappedModel(taiNguyen2VaiTro);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, taiNguyen2VaiTro);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(taiNguyen2VaiTro);

		return taiNguyen2VaiTro;
	}

	@Override
	public TaiNguyen2VaiTro updateImpl(
		org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro taiNguyen2VaiTro,
		boolean merge) throws SystemException {
		taiNguyen2VaiTro = toUnwrappedModel(taiNguyen2VaiTro);

		boolean isNew = taiNguyen2VaiTro.isNew();

		TaiNguyen2VaiTroModelImpl taiNguyen2VaiTroModelImpl = (TaiNguyen2VaiTroModelImpl)taiNguyen2VaiTro;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, taiNguyen2VaiTro, merge);

			taiNguyen2VaiTro.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TaiNguyen2VaiTroModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((taiNguyen2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(taiNguyen2VaiTroModelImpl.getOriginalVaiTroId()),
						Integer.valueOf(taiNguyen2VaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAITROID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID,
					args);

				args = new Object[] {
						Long.valueOf(taiNguyen2VaiTroModelImpl.getVaiTroId()),
						Integer.valueOf(taiNguyen2VaiTroModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAITROID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID,
					args);
			}
		}

		EntityCacheUtil.putResult(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyen2VaiTroImpl.class, taiNguyen2VaiTro.getPrimaryKey(),
			taiNguyen2VaiTro);

		return taiNguyen2VaiTro;
	}

	protected TaiNguyen2VaiTro toUnwrappedModel(
		TaiNguyen2VaiTro taiNguyen2VaiTro) {
		if (taiNguyen2VaiTro instanceof TaiNguyen2VaiTroImpl) {
			return taiNguyen2VaiTro;
		}

		TaiNguyen2VaiTroImpl taiNguyen2VaiTroImpl = new TaiNguyen2VaiTroImpl();

		taiNguyen2VaiTroImpl.setNew(taiNguyen2VaiTro.isNew());
		taiNguyen2VaiTroImpl.setPrimaryKey(taiNguyen2VaiTro.getPrimaryKey());

		taiNguyen2VaiTroImpl.setId(taiNguyen2VaiTro.getId());
		taiNguyen2VaiTroImpl.setTaiNguyenId(taiNguyen2VaiTro.getTaiNguyenId());
		taiNguyen2VaiTroImpl.setVaiTroId(taiNguyen2VaiTro.getVaiTroId());
		taiNguyen2VaiTroImpl.setHanhDong(taiNguyen2VaiTro.getHanhDong());
		taiNguyen2VaiTroImpl.setNgayTao(taiNguyen2VaiTro.getNgayTao());
		taiNguyen2VaiTroImpl.setNguoiTao(taiNguyen2VaiTro.getNguoiTao());
		taiNguyen2VaiTroImpl.setNgaySua(taiNguyen2VaiTro.getNgaySua());
		taiNguyen2VaiTroImpl.setNguoiSua(taiNguyen2VaiTro.getNguoiSua());
		taiNguyen2VaiTroImpl.setDaXoa(taiNguyen2VaiTro.getDaXoa());

		return taiNguyen2VaiTroImpl;
	}

	/**
	 * Returns the tai nguyen2 vai tro with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai nguyen2 vai tro
	 * @return the tai nguyen2 vai tro
	 * @throws com.liferay.portal.NoSuchModelException if a tai nguyen2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiNguyen2VaiTro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tai nguyen2 vai tro with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException} if it could not be found.
	 *
	 * @param id the primary key of the tai nguyen2 vai tro
	 * @return the tai nguyen2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException if a tai nguyen2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen2VaiTro findByPrimaryKey(long id)
		throws NoSuchTaiNguyen2VaiTroException, SystemException {
		TaiNguyen2VaiTro taiNguyen2VaiTro = fetchByPrimaryKey(id);

		if (taiNguyen2VaiTro == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTaiNguyen2VaiTroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return taiNguyen2VaiTro;
	}

	/**
	 * Returns the tai nguyen2 vai tro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai nguyen2 vai tro
	 * @return the tai nguyen2 vai tro, or <code>null</code> if a tai nguyen2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiNguyen2VaiTro fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tai nguyen2 vai tro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tai nguyen2 vai tro
	 * @return the tai nguyen2 vai tro, or <code>null</code> if a tai nguyen2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen2VaiTro fetchByPrimaryKey(long id)
		throws SystemException {
		TaiNguyen2VaiTro taiNguyen2VaiTro = (TaiNguyen2VaiTro)EntityCacheUtil.getResult(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
				TaiNguyen2VaiTroImpl.class, id);

		if (taiNguyen2VaiTro == _nullTaiNguyen2VaiTro) {
			return null;
		}

		if (taiNguyen2VaiTro == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				taiNguyen2VaiTro = (TaiNguyen2VaiTro)session.get(TaiNguyen2VaiTroImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (taiNguyen2VaiTro != null) {
					cacheResult(taiNguyen2VaiTro);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TaiNguyen2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
						TaiNguyen2VaiTroImpl.class, id, _nullTaiNguyen2VaiTro);
				}

				closeSession(session);
			}
		}

		return taiNguyen2VaiTro;
	}

	/**
	 * Returns all the tai nguyen2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @return the matching tai nguyen2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiNguyen2VaiTro> findByVaiTroID(Long vaiTroId, int daXoa)
		throws SystemException {
		return findByVaiTroID(vaiTroId, daXoa, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai nguyen2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of tai nguyen2 vai tros
	 * @param end the upper bound of the range of tai nguyen2 vai tros (not inclusive)
	 * @return the range of matching tai nguyen2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiNguyen2VaiTro> findByVaiTroID(Long vaiTroId, int daXoa,
		int start, int end) throws SystemException {
		return findByVaiTroID(vaiTroId, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai nguyen2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of tai nguyen2 vai tros
	 * @param end the upper bound of the range of tai nguyen2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai nguyen2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiNguyen2VaiTro> findByVaiTroID(Long vaiTroId, int daXoa,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID;
			finderArgs = new Object[] { vaiTroId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VAITROID;
			finderArgs = new Object[] {
					vaiTroId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<TaiNguyen2VaiTro> list = (List<TaiNguyen2VaiTro>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TAINGUYEN2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_VAITROID_VAITROID_2);

			query.append(_FINDER_COLUMN_VAITROID_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vaiTroId.longValue());

				qPos.add(daXoa);

				list = (List<TaiNguyen2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tai nguyen2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai nguyen2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException if a matching tai nguyen2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen2VaiTro findByVaiTroID_First(Long vaiTroId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTaiNguyen2VaiTroException, SystemException {
		List<TaiNguyen2VaiTro> list = findByVaiTroID(vaiTroId, daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiNguyen2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last tai nguyen2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai nguyen2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException if a matching tai nguyen2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen2VaiTro findByVaiTroID_Last(Long vaiTroId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTaiNguyen2VaiTroException, SystemException {
		int count = countByVaiTroID(vaiTroId, daXoa);

		List<TaiNguyen2VaiTro> list = findByVaiTroID(vaiTroId, daXoa,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiNguyen2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the tai nguyen2 vai tros before and after the current tai nguyen2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current tai nguyen2 vai tro
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai nguyen2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException if a tai nguyen2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen2VaiTro[] findByVaiTroID_PrevAndNext(long id,
		Long vaiTroId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchTaiNguyen2VaiTroException, SystemException {
		TaiNguyen2VaiTro taiNguyen2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TaiNguyen2VaiTro[] array = new TaiNguyen2VaiTroImpl[3];

			array[0] = getByVaiTroID_PrevAndNext(session, taiNguyen2VaiTro,
					vaiTroId, daXoa, orderByComparator, true);

			array[1] = taiNguyen2VaiTro;

			array[2] = getByVaiTroID_PrevAndNext(session, taiNguyen2VaiTro,
					vaiTroId, daXoa, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaiNguyen2VaiTro getByVaiTroID_PrevAndNext(Session session,
		TaiNguyen2VaiTro taiNguyen2VaiTro, Long vaiTroId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAINGUYEN2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_VAITROID_VAITROID_2);

		query.append(_FINDER_COLUMN_VAITROID_DAXOA_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vaiTroId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taiNguyen2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TaiNguyen2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tai nguyen2 vai tros.
	 *
	 * @return the tai nguyen2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiNguyen2VaiTro> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai nguyen2 vai tros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai nguyen2 vai tros
	 * @param end the upper bound of the range of tai nguyen2 vai tros (not inclusive)
	 * @return the range of tai nguyen2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiNguyen2VaiTro> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai nguyen2 vai tros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai nguyen2 vai tros
	 * @param end the upper bound of the range of tai nguyen2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai nguyen2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiNguyen2VaiTro> findAll(int start, int end,
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

		List<TaiNguyen2VaiTro> list = (List<TaiNguyen2VaiTro>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAINGUYEN2VAITRO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAINGUYEN2VAITRO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TaiNguyen2VaiTro>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TaiNguyen2VaiTro>)QueryUtil.list(q,
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
	 * Removes all the tai nguyen2 vai tros where vaiTroId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVaiTroID(Long vaiTroId, int daXoa)
		throws SystemException {
		for (TaiNguyen2VaiTro taiNguyen2VaiTro : findByVaiTroID(vaiTroId, daXoa)) {
			remove(taiNguyen2VaiTro);
		}
	}

	/**
	 * Removes all the tai nguyen2 vai tros from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TaiNguyen2VaiTro taiNguyen2VaiTro : findAll()) {
			remove(taiNguyen2VaiTro);
		}
	}

	/**
	 * Returns the number of tai nguyen2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @return the number of matching tai nguyen2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVaiTroID(Long vaiTroId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { vaiTroId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VAITROID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAINGUYEN2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_VAITROID_VAITROID_2);

			query.append(_FINDER_COLUMN_VAITROID_DAXOA_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VAITROID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tai nguyen2 vai tros.
	 *
	 * @return the number of tai nguyen2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAINGUYEN2VAITRO);

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
	 * Initializes the tai nguyen2 vai tro persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaiNguyen2VaiTro>> listenersList = new ArrayList<ModelListener<TaiNguyen2VaiTro>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaiNguyen2VaiTro>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaiNguyen2VaiTroImpl.class.getName());
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
	private static final String _SQL_SELECT_TAINGUYEN2VAITRO = "SELECT taiNguyen2VaiTro FROM TaiNguyen2VaiTro taiNguyen2VaiTro";
	private static final String _SQL_SELECT_TAINGUYEN2VAITRO_WHERE = "SELECT taiNguyen2VaiTro FROM TaiNguyen2VaiTro taiNguyen2VaiTro WHERE ";
	private static final String _SQL_COUNT_TAINGUYEN2VAITRO = "SELECT COUNT(taiNguyen2VaiTro) FROM TaiNguyen2VaiTro taiNguyen2VaiTro";
	private static final String _SQL_COUNT_TAINGUYEN2VAITRO_WHERE = "SELECT COUNT(taiNguyen2VaiTro) FROM TaiNguyen2VaiTro taiNguyen2VaiTro WHERE ";
	private static final String _FINDER_COLUMN_VAITROID_VAITROID_2 = "taiNguyen2VaiTro.vaiTroId = ? AND ";
	private static final String _FINDER_COLUMN_VAITROID_DAXOA_2 = "taiNguyen2VaiTro.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taiNguyen2VaiTro.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaiNguyen2VaiTro exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaiNguyen2VaiTro exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaiNguyen2VaiTroPersistenceImpl.class);
	private static TaiNguyen2VaiTro _nullTaiNguyen2VaiTro = new TaiNguyen2VaiTroImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaiNguyen2VaiTro> toCacheModel() {
				return _nullTaiNguyen2VaiTroCacheModel;
			}
		};

	private static CacheModel<TaiNguyen2VaiTro> _nullTaiNguyen2VaiTroCacheModel = new CacheModel<TaiNguyen2VaiTro>() {
			public TaiNguyen2VaiTro toEntityModel() {
				return _nullTaiNguyen2VaiTro;
			}
		};
}