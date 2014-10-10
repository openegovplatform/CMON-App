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

import org.oep.cmon.dao.nsd.NoSuchTaiNguyenException;
import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.model.impl.TaiNguyenImpl;
import org.oep.cmon.dao.nsd.model.impl.TaiNguyenModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tai nguyen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TaiNguyenPersistence
 * @see TaiNguyenUtil
 * @generated
 */
public class TaiNguyenPersistenceImpl extends BasePersistenceImpl<TaiNguyen>
	implements TaiNguyenPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaiNguyenUtil} to access the tai nguyen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaiNguyenImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_TEN = new FinderPath(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyenModelImpl.FINDER_CACHE_ENABLED, TaiNguyenImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTen",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				String.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			TaiNguyenModelImpl.TEN_COLUMN_BITMASK |
			TaiNguyenModelImpl.LOAI_COLUMN_BITMASK |
			TaiNguyenModelImpl.GIATRI_COLUMN_BITMASK |
			TaiNguyenModelImpl.UNGDUNGID_COLUMN_BITMASK |
			TaiNguyenModelImpl.HETHONGID_COLUMN_BITMASK |
			TaiNguyenModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				String.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyenModelImpl.FINDER_CACHE_ENABLED, TaiNguyenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyenModelImpl.FINDER_CACHE_ENABLED, TaiNguyenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tai nguyen in the entity cache if it is enabled.
	 *
	 * @param taiNguyen the tai nguyen
	 */
	public void cacheResult(TaiNguyen taiNguyen) {
		EntityCacheUtil.putResult(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyenImpl.class, taiNguyen.getPrimaryKey(), taiNguyen);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] {
				taiNguyen.getTen(), Integer.valueOf(taiNguyen.getLoai()),
				
			taiNguyen.getGiaTri(), Long.valueOf(taiNguyen.getUngDungId()),
				Long.valueOf(taiNguyen.getHeThongId()),
				Integer.valueOf(taiNguyen.getDaXoa())
			}, taiNguyen);

		taiNguyen.resetOriginalValues();
	}

	/**
	 * Caches the tai nguyens in the entity cache if it is enabled.
	 *
	 * @param taiNguyens the tai nguyens
	 */
	public void cacheResult(List<TaiNguyen> taiNguyens) {
		for (TaiNguyen taiNguyen : taiNguyens) {
			if (EntityCacheUtil.getResult(
						TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
						TaiNguyenImpl.class, taiNguyen.getPrimaryKey()) == null) {
				cacheResult(taiNguyen);
			}
			else {
				taiNguyen.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tai nguyens.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaiNguyenImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaiNguyenImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tai nguyen.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaiNguyen taiNguyen) {
		EntityCacheUtil.removeResult(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyenImpl.class, taiNguyen.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(taiNguyen);
	}

	@Override
	public void clearCache(List<TaiNguyen> taiNguyens) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaiNguyen taiNguyen : taiNguyens) {
			EntityCacheUtil.removeResult(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
				TaiNguyenImpl.class, taiNguyen.getPrimaryKey());

			clearUniqueFindersCache(taiNguyen);
		}
	}

	protected void clearUniqueFindersCache(TaiNguyen taiNguyen) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] {
				taiNguyen.getTen(), Integer.valueOf(taiNguyen.getLoai()),
				
			taiNguyen.getGiaTri(), Long.valueOf(taiNguyen.getUngDungId()),
				Long.valueOf(taiNguyen.getHeThongId()),
				Integer.valueOf(taiNguyen.getDaXoa())
			});
	}

	/**
	 * Creates a new tai nguyen with the primary key. Does not add the tai nguyen to the database.
	 *
	 * @param id the primary key for the new tai nguyen
	 * @return the new tai nguyen
	 */
	public TaiNguyen create(long id) {
		TaiNguyen taiNguyen = new TaiNguyenImpl();

		taiNguyen.setNew(true);
		taiNguyen.setPrimaryKey(id);

		return taiNguyen;
	}

	/**
	 * Removes the tai nguyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tai nguyen
	 * @return the tai nguyen that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a tai nguyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen remove(long id)
		throws NoSuchTaiNguyenException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the tai nguyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tai nguyen
	 * @return the tai nguyen that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a tai nguyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiNguyen remove(Serializable primaryKey)
		throws NoSuchTaiNguyenException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaiNguyen taiNguyen = (TaiNguyen)session.get(TaiNguyenImpl.class,
					primaryKey);

			if (taiNguyen == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaiNguyenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taiNguyen);
		}
		catch (NoSuchTaiNguyenException nsee) {
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
	protected TaiNguyen removeImpl(TaiNguyen taiNguyen)
		throws SystemException {
		taiNguyen = toUnwrappedModel(taiNguyen);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, taiNguyen);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(taiNguyen);

		return taiNguyen;
	}

	@Override
	public TaiNguyen updateImpl(
		org.oep.cmon.dao.nsd.model.TaiNguyen taiNguyen, boolean merge)
		throws SystemException {
		taiNguyen = toUnwrappedModel(taiNguyen);

		boolean isNew = taiNguyen.isNew();

		TaiNguyenModelImpl taiNguyenModelImpl = (TaiNguyenModelImpl)taiNguyen;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, taiNguyen, merge);

			taiNguyen.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TaiNguyenModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
			TaiNguyenImpl.class, taiNguyen.getPrimaryKey(), taiNguyen);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
				new Object[] {
					taiNguyen.getTen(), Integer.valueOf(taiNguyen.getLoai()),
					
				taiNguyen.getGiaTri(), Long.valueOf(taiNguyen.getUngDungId()),
					Long.valueOf(taiNguyen.getHeThongId()),
					Integer.valueOf(taiNguyen.getDaXoa())
				}, taiNguyen);
		}
		else {
			if ((taiNguyenModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taiNguyenModelImpl.getOriginalTen(),
						Integer.valueOf(taiNguyenModelImpl.getOriginalLoai()),
						
						taiNguyenModelImpl.getOriginalGiaTri(),
						Long.valueOf(taiNguyenModelImpl.getOriginalUngDungId()),
						Long.valueOf(taiNguyenModelImpl.getOriginalHeThongId()),
						Integer.valueOf(taiNguyenModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
					new Object[] {
						taiNguyen.getTen(), Integer.valueOf(taiNguyen.getLoai()),
						
					taiNguyen.getGiaTri(),
						Long.valueOf(taiNguyen.getUngDungId()),
						Long.valueOf(taiNguyen.getHeThongId()),
						Integer.valueOf(taiNguyen.getDaXoa())
					}, taiNguyen);
			}
		}

		return taiNguyen;
	}

	protected TaiNguyen toUnwrappedModel(TaiNguyen taiNguyen) {
		if (taiNguyen instanceof TaiNguyenImpl) {
			return taiNguyen;
		}

		TaiNguyenImpl taiNguyenImpl = new TaiNguyenImpl();

		taiNguyenImpl.setNew(taiNguyen.isNew());
		taiNguyenImpl.setPrimaryKey(taiNguyen.getPrimaryKey());

		taiNguyenImpl.setId(taiNguyen.getId());
		taiNguyenImpl.setTen(taiNguyen.getTen());
		taiNguyenImpl.setMoTa(taiNguyen.getMoTa());
		taiNguyenImpl.setLoai(taiNguyen.getLoai());
		taiNguyenImpl.setGiaTri(taiNguyen.getGiaTri());
		taiNguyenImpl.setTrangThai(taiNguyen.getTrangThai());
		taiNguyenImpl.setNgayTao(taiNguyen.getNgayTao());
		taiNguyenImpl.setNguoiTao(taiNguyen.getNguoiTao());
		taiNguyenImpl.setNgaySua(taiNguyen.getNgaySua());
		taiNguyenImpl.setNguoiSua(taiNguyen.getNguoiSua());
		taiNguyenImpl.setDaXoa(taiNguyen.getDaXoa());
		taiNguyenImpl.setUngDungId(taiNguyen.getUngDungId());
		taiNguyenImpl.setHeThongId(taiNguyen.getHeThongId());

		return taiNguyenImpl;
	}

	/**
	 * Returns the tai nguyen with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai nguyen
	 * @return the tai nguyen
	 * @throws com.liferay.portal.NoSuchModelException if a tai nguyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiNguyen findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tai nguyen with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiNguyenException} if it could not be found.
	 *
	 * @param id the primary key of the tai nguyen
	 * @return the tai nguyen
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a tai nguyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen findByPrimaryKey(long id)
		throws NoSuchTaiNguyenException, SystemException {
		TaiNguyen taiNguyen = fetchByPrimaryKey(id);

		if (taiNguyen == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTaiNguyenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return taiNguyen;
	}

	/**
	 * Returns the tai nguyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai nguyen
	 * @return the tai nguyen, or <code>null</code> if a tai nguyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiNguyen fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tai nguyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tai nguyen
	 * @return the tai nguyen, or <code>null</code> if a tai nguyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen fetchByPrimaryKey(long id) throws SystemException {
		TaiNguyen taiNguyen = (TaiNguyen)EntityCacheUtil.getResult(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
				TaiNguyenImpl.class, id);

		if (taiNguyen == _nullTaiNguyen) {
			return null;
		}

		if (taiNguyen == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				taiNguyen = (TaiNguyen)session.get(TaiNguyenImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (taiNguyen != null) {
					cacheResult(taiNguyen);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TaiNguyenModelImpl.ENTITY_CACHE_ENABLED,
						TaiNguyenImpl.class, id, _nullTaiNguyen);
				}

				closeSession(session);
			}
		}

		return taiNguyen;
	}

	/**
	 * Returns the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiNguyenException} if it could not be found.
	 *
	 * @param ten the ten
	 * @param loai the loai
	 * @param giaTri the gia tri
	 * @param ungDungId the ung dung ID
	 * @param heThongId the he thong ID
	 * @param daXoa the da xoa
	 * @return the matching tai nguyen
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a matching tai nguyen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen findByTen(String ten, int loai, String giaTri,
		Long ungDungId, Long heThongId, int daXoa)
		throws NoSuchTaiNguyenException, SystemException {
		TaiNguyen taiNguyen = fetchByTen(ten, loai, giaTri, ungDungId,
				heThongId, daXoa);

		if (taiNguyen == null) {
			StringBundler msg = new StringBundler(14);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(", loai=");
			msg.append(loai);

			msg.append(", giaTri=");
			msg.append(giaTri);

			msg.append(", ungDungId=");
			msg.append(ungDungId);

			msg.append(", heThongId=");
			msg.append(heThongId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTaiNguyenException(msg.toString());
		}

		return taiNguyen;
	}

	/**
	 * Returns the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @param loai the loai
	 * @param giaTri the gia tri
	 * @param ungDungId the ung dung ID
	 * @param heThongId the he thong ID
	 * @param daXoa the da xoa
	 * @return the matching tai nguyen, or <code>null</code> if a matching tai nguyen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen fetchByTen(String ten, int loai, String giaTri,
		Long ungDungId, Long heThongId, int daXoa) throws SystemException {
		return fetchByTen(ten, loai, giaTri, ungDungId, heThongId, daXoa, true);
	}

	/**
	 * Returns the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param loai the loai
	 * @param giaTri the gia tri
	 * @param ungDungId the ung dung ID
	 * @param heThongId the he thong ID
	 * @param daXoa the da xoa
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tai nguyen, or <code>null</code> if a matching tai nguyen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiNguyen fetchByTen(String ten, int loai, String giaTri,
		Long ungDungId, Long heThongId, int daXoa, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				ten, loai, giaTri, ungDungId, heThongId, daXoa
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TEN,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(8);

			query.append(_SQL_SELECT_TAINGUYEN_WHERE);

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

			query.append(_FINDER_COLUMN_TEN_LOAI_2);

			if (giaTri == null) {
				query.append(_FINDER_COLUMN_TEN_GIATRI_1);
			}
			else {
				if (giaTri.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_GIATRI_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_GIATRI_2);
				}
			}

			query.append(_FINDER_COLUMN_TEN_UNGDUNGID_2);

			query.append(_FINDER_COLUMN_TEN_HETHONGID_2);

			query.append(_FINDER_COLUMN_TEN_DAXOA_2);

			query.append(TaiNguyenModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				qPos.add(loai);

				if (giaTri != null) {
					qPos.add(giaTri);
				}

				qPos.add(ungDungId.longValue());

				qPos.add(heThongId.longValue());

				qPos.add(daXoa);

				List<TaiNguyen> list = q.list();

				result = list;

				TaiNguyen taiNguyen = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
						finderArgs, list);
				}
				else {
					taiNguyen = list.get(0);

					cacheResult(taiNguyen);

					if ((taiNguyen.getTen() == null) ||
							!taiNguyen.getTen().equals(ten) ||
							(taiNguyen.getLoai() != loai) ||
							(taiNguyen.getGiaTri() == null) ||
							!taiNguyen.getGiaTri().equals(giaTri) ||
							(taiNguyen.getUngDungId() != ungDungId) ||
							(taiNguyen.getHeThongId() != heThongId) ||
							(taiNguyen.getDaXoa() != daXoa)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
							finderArgs, taiNguyen);
					}
				}

				return taiNguyen;
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
				return (TaiNguyen)result;
			}
		}
	}

	/**
	 * Returns all the tai nguyens.
	 *
	 * @return the tai nguyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiNguyen> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai nguyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai nguyens
	 * @param end the upper bound of the range of tai nguyens (not inclusive)
	 * @return the range of tai nguyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiNguyen> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai nguyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai nguyens
	 * @param end the upper bound of the range of tai nguyens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai nguyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiNguyen> findAll(int start, int end,
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

		List<TaiNguyen> list = (List<TaiNguyen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAINGUYEN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAINGUYEN.concat(TaiNguyenModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TaiNguyen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TaiNguyen>)QueryUtil.list(q, getDialect(),
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
	 * Removes the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param ten the ten
	 * @param loai the loai
	 * @param giaTri the gia tri
	 * @param ungDungId the ung dung ID
	 * @param heThongId the he thong ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten, int loai, String giaTri,
		Long ungDungId, Long heThongId, int daXoa)
		throws NoSuchTaiNguyenException, SystemException {
		TaiNguyen taiNguyen = findByTen(ten, loai, giaTri, ungDungId,
				heThongId, daXoa);

		remove(taiNguyen);
	}

	/**
	 * Removes all the tai nguyens from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TaiNguyen taiNguyen : findAll()) {
			remove(taiNguyen);
		}
	}

	/**
	 * Returns the number of tai nguyens where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63;.
	 *
	 * @param ten the ten
	 * @param loai the loai
	 * @param giaTri the gia tri
	 * @param ungDungId the ung dung ID
	 * @param heThongId the he thong ID
	 * @param daXoa the da xoa
	 * @return the number of matching tai nguyens
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten, int loai, String giaTri, Long ungDungId,
		Long heThongId, int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] {
				ten, loai, giaTri, ungDungId, heThongId, daXoa
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_TAINGUYEN_WHERE);

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

			query.append(_FINDER_COLUMN_TEN_LOAI_2);

			if (giaTri == null) {
				query.append(_FINDER_COLUMN_TEN_GIATRI_1);
			}
			else {
				if (giaTri.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_GIATRI_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_GIATRI_2);
				}
			}

			query.append(_FINDER_COLUMN_TEN_UNGDUNGID_2);

			query.append(_FINDER_COLUMN_TEN_HETHONGID_2);

			query.append(_FINDER_COLUMN_TEN_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				qPos.add(loai);

				if (giaTri != null) {
					qPos.add(giaTri);
				}

				qPos.add(ungDungId.longValue());

				qPos.add(heThongId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEN, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tai nguyens.
	 *
	 * @return the number of tai nguyens
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAINGUYEN);

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
	 * Initializes the tai nguyen persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.nsd.model.TaiNguyen")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaiNguyen>> listenersList = new ArrayList<ModelListener<TaiNguyen>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaiNguyen>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaiNguyenImpl.class.getName());
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
	private static final String _SQL_SELECT_TAINGUYEN = "SELECT taiNguyen FROM TaiNguyen taiNguyen";
	private static final String _SQL_SELECT_TAINGUYEN_WHERE = "SELECT taiNguyen FROM TaiNguyen taiNguyen WHERE ";
	private static final String _SQL_COUNT_TAINGUYEN = "SELECT COUNT(taiNguyen) FROM TaiNguyen taiNguyen";
	private static final String _SQL_COUNT_TAINGUYEN_WHERE = "SELECT COUNT(taiNguyen) FROM TaiNguyen taiNguyen WHERE ";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "taiNguyen.ten IS NULL AND ";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "taiNguyen.ten = ? AND ";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(taiNguyen.ten IS NULL OR taiNguyen.ten = ?) AND ";
	private static final String _FINDER_COLUMN_TEN_LOAI_2 = "taiNguyen.loai = ? AND ";
	private static final String _FINDER_COLUMN_TEN_GIATRI_1 = "taiNguyen.giaTri IS NULL AND ";
	private static final String _FINDER_COLUMN_TEN_GIATRI_2 = "taiNguyen.giaTri = ? AND ";
	private static final String _FINDER_COLUMN_TEN_GIATRI_3 = "(taiNguyen.giaTri IS NULL OR taiNguyen.giaTri = ?) AND ";
	private static final String _FINDER_COLUMN_TEN_UNGDUNGID_2 = "taiNguyen.ungDungId = ? AND ";
	private static final String _FINDER_COLUMN_TEN_HETHONGID_2 = "taiNguyen.heThongId = ? AND ";
	private static final String _FINDER_COLUMN_TEN_DAXOA_2 = "taiNguyen.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taiNguyen.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaiNguyen exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaiNguyen exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaiNguyenPersistenceImpl.class);
	private static TaiNguyen _nullTaiNguyen = new TaiNguyenImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaiNguyen> toCacheModel() {
				return _nullTaiNguyenCacheModel;
			}
		};

	private static CacheModel<TaiNguyen> _nullTaiNguyenCacheModel = new CacheModel<TaiNguyen>() {
			public TaiNguyen toEntityModel() {
				return _nullTaiNguyen;
			}
		};
}