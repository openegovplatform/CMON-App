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

package org.oep.cmon.dao.thamso.service.persistence;

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

import org.oep.cmon.dao.thamso.NoSuchAnhXaException;
import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.model.impl.AnhXaImpl;
import org.oep.cmon.dao.thamso.model.impl.AnhXaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the anh xa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see AnhXaPersistence
 * @see AnhXaUtil
 * @generated
 */
public class AnhXaPersistenceImpl extends BasePersistenceImpl<AnhXa>
	implements AnhXaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnhXaUtil} to access the anh xa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnhXaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNGDUNG = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUngDung",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNGDUNG =
		new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUngDung",
			new String[] { Long.class.getName() },
			AnhXaModelImpl.UNGDUNGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNGDUNG = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUngDung",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TENBANG = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytenBang",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENBANG =
		new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytenBang",
			new String[] { String.class.getName() },
			AnhXaModelImpl.TENBANG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TENBANG = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytenBang",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UD_TB = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUD_TB",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUD_TB",
			new String[] { Long.class.getName(), String.class.getName() },
			AnhXaModelImpl.UNGDUNGID_COLUMN_BITMASK |
			AnhXaModelImpl.TENBANG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UD_TB = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUD_TB",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UD_TB_MADNG =
		new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUD_TB_MaDNG",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB_MADNG =
		new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUD_TB_MaDNG",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			AnhXaModelImpl.UNGDUNGID_COLUMN_BITMASK |
			AnhXaModelImpl.TENBANG_COLUMN_BITMASK |
			AnhXaModelImpl.MADNG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UD_TB_MADNG = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUD_TB_MaDNG",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, AnhXaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the anh xa in the entity cache if it is enabled.
	 *
	 * @param anhXa the anh xa
	 */
	public void cacheResult(AnhXa anhXa) {
		EntityCacheUtil.putResult(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaImpl.class, anhXa.getPrimaryKey(), anhXa);

		anhXa.resetOriginalValues();
	}

	/**
	 * Caches the anh xas in the entity cache if it is enabled.
	 *
	 * @param anhXas the anh xas
	 */
	public void cacheResult(List<AnhXa> anhXas) {
		for (AnhXa anhXa : anhXas) {
			if (EntityCacheUtil.getResult(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
						AnhXaImpl.class, anhXa.getPrimaryKey()) == null) {
				cacheResult(anhXa);
			}
			else {
				anhXa.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all anh xas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnhXaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnhXaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the anh xa.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnhXa anhXa) {
		EntityCacheUtil.removeResult(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaImpl.class, anhXa.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnhXa> anhXas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnhXa anhXa : anhXas) {
			EntityCacheUtil.removeResult(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
				AnhXaImpl.class, anhXa.getPrimaryKey());
		}
	}

	/**
	 * Creates a new anh xa with the primary key. Does not add the anh xa to the database.
	 *
	 * @param Id the primary key for the new anh xa
	 * @return the new anh xa
	 */
	public AnhXa create(long Id) {
		AnhXa anhXa = new AnhXaImpl();

		anhXa.setNew(true);
		anhXa.setPrimaryKey(Id);

		return anhXa;
	}

	/**
	 * Removes the anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the anh xa
	 * @return the anh xa that was removed
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa remove(long Id) throws NoSuchAnhXaException, SystemException {
		return remove(Long.valueOf(Id));
	}

	/**
	 * Removes the anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the anh xa
	 * @return the anh xa that was removed
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnhXa remove(Serializable primaryKey)
		throws NoSuchAnhXaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AnhXa anhXa = (AnhXa)session.get(AnhXaImpl.class, primaryKey);

			if (anhXa == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnhXaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(anhXa);
		}
		catch (NoSuchAnhXaException nsee) {
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
	protected AnhXa removeImpl(AnhXa anhXa) throws SystemException {
		anhXa = toUnwrappedModel(anhXa);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, anhXa);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(anhXa);

		return anhXa;
	}

	@Override
	public AnhXa updateImpl(org.oep.cmon.dao.thamso.model.AnhXa anhXa,
		boolean merge) throws SystemException {
		anhXa = toUnwrappedModel(anhXa);

		boolean isNew = anhXa.isNew();

		AnhXaModelImpl anhXaModelImpl = (AnhXaModelImpl)anhXa;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, anhXa, merge);

			anhXa.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnhXaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((anhXaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNGDUNG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(anhXaModelImpl.getOriginalUngDungId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNGDUNG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNGDUNG,
					args);

				args = new Object[] { Long.valueOf(anhXaModelImpl.getUngDungId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNGDUNG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNGDUNG,
					args);
			}

			if ((anhXaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENBANG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { anhXaModelImpl.getOriginalTenBang() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENBANG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENBANG,
					args);

				args = new Object[] { anhXaModelImpl.getTenBang() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENBANG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENBANG,
					args);
			}

			if ((anhXaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(anhXaModelImpl.getOriginalUngDungId()),
						
						anhXaModelImpl.getOriginalTenBang()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UD_TB, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB,
					args);

				args = new Object[] {
						Long.valueOf(anhXaModelImpl.getUngDungId()),
						
						anhXaModelImpl.getTenBang()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UD_TB, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB,
					args);
			}

			if ((anhXaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB_MADNG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(anhXaModelImpl.getOriginalUngDungId()),
						
						anhXaModelImpl.getOriginalTenBang(),
						
						anhXaModelImpl.getOriginalMaDNG()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UD_TB_MADNG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB_MADNG,
					args);

				args = new Object[] {
						Long.valueOf(anhXaModelImpl.getUngDungId()),
						
						anhXaModelImpl.getTenBang(),
						
						anhXaModelImpl.getMaDNG()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UD_TB_MADNG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB_MADNG,
					args);
			}
		}

		EntityCacheUtil.putResult(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
			AnhXaImpl.class, anhXa.getPrimaryKey(), anhXa);

		return anhXa;
	}

	protected AnhXa toUnwrappedModel(AnhXa anhXa) {
		if (anhXa instanceof AnhXaImpl) {
			return anhXa;
		}

		AnhXaImpl anhXaImpl = new AnhXaImpl();

		anhXaImpl.setNew(anhXa.isNew());
		anhXaImpl.setPrimaryKey(anhXa.getPrimaryKey());

		anhXaImpl.setId(anhXa.getId());
		anhXaImpl.setMaDNG(anhXa.getMaDNG());
		anhXaImpl.setTenDNG(anhXa.getTenDNG());
		anhXaImpl.setMaKhac(anhXa.getMaKhac());
		anhXaImpl.setTenKhac(anhXa.getTenKhac());
		anhXaImpl.setTenBang(anhXa.getTenBang());
		anhXaImpl.setUngDungId(anhXa.getUngDungId());
		anhXaImpl.setNgayTao(anhXa.getNgayTao());
		anhXaImpl.setNguoiTao(anhXa.getNguoiTao());
		anhXaImpl.setNgaySua(anhXa.getNgaySua());
		anhXaImpl.setNguoiSua(anhXa.getNguoiSua());
		anhXaImpl.setDaXoa(anhXa.getDaXoa());

		return anhXaImpl;
	}

	/**
	 * Returns the anh xa with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the anh xa
	 * @return the anh xa
	 * @throws com.liferay.portal.NoSuchModelException if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnhXa findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the anh xa with the primary key or throws a {@link org.oep.cmon.dao.thamso.NoSuchAnhXaException} if it could not be found.
	 *
	 * @param Id the primary key of the anh xa
	 * @return the anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa findByPrimaryKey(long Id)
		throws NoSuchAnhXaException, SystemException {
		AnhXa anhXa = fetchByPrimaryKey(Id);

		if (anhXa == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + Id);
			}

			throw new NoSuchAnhXaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				Id);
		}

		return anhXa;
	}

	/**
	 * Returns the anh xa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the anh xa
	 * @return the anh xa, or <code>null</code> if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnhXa fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the anh xa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the anh xa
	 * @return the anh xa, or <code>null</code> if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa fetchByPrimaryKey(long Id) throws SystemException {
		AnhXa anhXa = (AnhXa)EntityCacheUtil.getResult(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
				AnhXaImpl.class, Id);

		if (anhXa == _nullAnhXa) {
			return null;
		}

		if (anhXa == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				anhXa = (AnhXa)session.get(AnhXaImpl.class, Long.valueOf(Id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (anhXa != null) {
					cacheResult(anhXa);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AnhXaModelImpl.ENTITY_CACHE_ENABLED,
						AnhXaImpl.class, Id, _nullAnhXa);
				}

				closeSession(session);
			}
		}

		return anhXa;
	}

	/**
	 * Returns all the anh xas where UngDungId = &#63;.
	 *
	 * @param UngDungId the ung dung ID
	 * @return the matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findByUngDung(long UngDungId) throws SystemException {
		return findByUngDung(UngDungId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the anh xas where UngDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @return the range of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findByUngDung(long UngDungId, int start, int end)
		throws SystemException {
		return findByUngDung(UngDungId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anh xas where UngDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findByUngDung(long UngDungId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNGDUNG;
			finderArgs = new Object[] { UngDungId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UNGDUNG;
			finderArgs = new Object[] { UngDungId, start, end, orderByComparator };
		}

		List<AnhXa> list = (List<AnhXa>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_ANHXA_WHERE);

			query.append(_FINDER_COLUMN_UNGDUNG_UNGDUNGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AnhXaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(UngDungId);

				list = (List<AnhXa>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first anh xa in the ordered set where UngDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa findByUngDung_First(long UngDungId,
		OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		List<AnhXa> list = findByUngDung(UngDungId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("UngDungId=");
			msg.append(UngDungId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last anh xa in the ordered set where UngDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa findByUngDung_Last(long UngDungId,
		OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		int count = countByUngDung(UngDungId);

		List<AnhXa> list = findByUngDung(UngDungId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("UngDungId=");
			msg.append(UngDungId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the anh xas before and after the current anh xa in the ordered set where UngDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param Id the primary key of the current anh xa
	 * @param UngDungId the ung dung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa[] findByUngDung_PrevAndNext(long Id, long UngDungId,
		OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		AnhXa anhXa = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			AnhXa[] array = new AnhXaImpl[3];

			array[0] = getByUngDung_PrevAndNext(session, anhXa, UngDungId,
					orderByComparator, true);

			array[1] = anhXa;

			array[2] = getByUngDung_PrevAndNext(session, anhXa, UngDungId,
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

	protected AnhXa getByUngDung_PrevAndNext(Session session, AnhXa anhXa,
		long UngDungId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANHXA_WHERE);

		query.append(_FINDER_COLUMN_UNGDUNG_UNGDUNGID_2);

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
			query.append(AnhXaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(UngDungId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(anhXa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnhXa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the anh xas where tenBang = &#63;.
	 *
	 * @param tenBang the ten bang
	 * @return the matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findBytenBang(String tenBang) throws SystemException {
		return findBytenBang(tenBang, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anh xas where tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenBang the ten bang
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @return the range of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findBytenBang(String tenBang, int start, int end)
		throws SystemException {
		return findBytenBang(tenBang, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anh xas where tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenBang the ten bang
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findBytenBang(String tenBang, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENBANG;
			finderArgs = new Object[] { tenBang };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TENBANG;
			finderArgs = new Object[] { tenBang, start, end, orderByComparator };
		}

		List<AnhXa> list = (List<AnhXa>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_ANHXA_WHERE);

			if (tenBang == null) {
				query.append(_FINDER_COLUMN_TENBANG_TENBANG_1);
			}
			else {
				if (tenBang.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENBANG_TENBANG_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENBANG_TENBANG_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AnhXaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenBang != null) {
					qPos.add(tenBang);
				}

				list = (List<AnhXa>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first anh xa in the ordered set where tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenBang the ten bang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa findBytenBang_First(String tenBang,
		OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		List<AnhXa> list = findBytenBang(tenBang, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenBang=");
			msg.append(tenBang);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last anh xa in the ordered set where tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenBang the ten bang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa findBytenBang_Last(String tenBang,
		OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		int count = countBytenBang(tenBang);

		List<AnhXa> list = findBytenBang(tenBang, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenBang=");
			msg.append(tenBang);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the anh xas before and after the current anh xa in the ordered set where tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param Id the primary key of the current anh xa
	 * @param tenBang the ten bang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa[] findBytenBang_PrevAndNext(long Id, String tenBang,
		OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		AnhXa anhXa = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			AnhXa[] array = new AnhXaImpl[3];

			array[0] = getBytenBang_PrevAndNext(session, anhXa, tenBang,
					orderByComparator, true);

			array[1] = anhXa;

			array[2] = getBytenBang_PrevAndNext(session, anhXa, tenBang,
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

	protected AnhXa getBytenBang_PrevAndNext(Session session, AnhXa anhXa,
		String tenBang, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANHXA_WHERE);

		if (tenBang == null) {
			query.append(_FINDER_COLUMN_TENBANG_TENBANG_1);
		}
		else {
			if (tenBang.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TENBANG_TENBANG_3);
			}
			else {
				query.append(_FINDER_COLUMN_TENBANG_TENBANG_2);
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
			query.append(AnhXaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (tenBang != null) {
			qPos.add(tenBang);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(anhXa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnhXa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the anh xas where UngDungId = &#63; and tenBang = &#63;.
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @return the matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findByUD_TB(long UngDungId, String tenBang)
		throws SystemException {
		return findByUD_TB(UngDungId, tenBang, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anh xas where UngDungId = &#63; and tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @return the range of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findByUD_TB(long UngDungId, String tenBang, int start,
		int end) throws SystemException {
		return findByUD_TB(UngDungId, tenBang, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anh xas where UngDungId = &#63; and tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findByUD_TB(long UngDungId, String tenBang, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB;
			finderArgs = new Object[] { UngDungId, tenBang };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UD_TB;
			finderArgs = new Object[] {
					UngDungId, tenBang,
					
					start, end, orderByComparator
				};
		}

		List<AnhXa> list = (List<AnhXa>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_ANHXA_WHERE);

			query.append(_FINDER_COLUMN_UD_TB_UNGDUNGID_2);

			if (tenBang == null) {
				query.append(_FINDER_COLUMN_UD_TB_TENBANG_1);
			}
			else {
				if (tenBang.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UD_TB_TENBANG_3);
				}
				else {
					query.append(_FINDER_COLUMN_UD_TB_TENBANG_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AnhXaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(UngDungId);

				if (tenBang != null) {
					qPos.add(tenBang);
				}

				list = (List<AnhXa>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa findByUD_TB_First(long UngDungId, String tenBang,
		OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		List<AnhXa> list = findByUD_TB(UngDungId, tenBang, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("UngDungId=");
			msg.append(UngDungId);

			msg.append(", tenBang=");
			msg.append(tenBang);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa findByUD_TB_Last(long UngDungId, String tenBang,
		OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		int count = countByUD_TB(UngDungId, tenBang);

		List<AnhXa> list = findByUD_TB(UngDungId, tenBang, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("UngDungId=");
			msg.append(UngDungId);

			msg.append(", tenBang=");
			msg.append(tenBang);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the anh xas before and after the current anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param Id the primary key of the current anh xa
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa[] findByUD_TB_PrevAndNext(long Id, long UngDungId,
		String tenBang, OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		AnhXa anhXa = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			AnhXa[] array = new AnhXaImpl[3];

			array[0] = getByUD_TB_PrevAndNext(session, anhXa, UngDungId,
					tenBang, orderByComparator, true);

			array[1] = anhXa;

			array[2] = getByUD_TB_PrevAndNext(session, anhXa, UngDungId,
					tenBang, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnhXa getByUD_TB_PrevAndNext(Session session, AnhXa anhXa,
		long UngDungId, String tenBang, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANHXA_WHERE);

		query.append(_FINDER_COLUMN_UD_TB_UNGDUNGID_2);

		if (tenBang == null) {
			query.append(_FINDER_COLUMN_UD_TB_TENBANG_1);
		}
		else {
			if (tenBang.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UD_TB_TENBANG_3);
			}
			else {
				query.append(_FINDER_COLUMN_UD_TB_TENBANG_2);
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
			query.append(AnhXaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(UngDungId);

		if (tenBang != null) {
			qPos.add(tenBang);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(anhXa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnhXa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param maDNG the ma d n g
	 * @return the matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findByUD_TB_MaDNG(long UngDungId, String tenBang,
		String maDNG) throws SystemException {
		return findByUD_TB_MaDNG(UngDungId, tenBang, maDNG, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param maDNG the ma d n g
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @return the range of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findByUD_TB_MaDNG(long UngDungId, String tenBang,
		String maDNG, int start, int end) throws SystemException {
		return findByUD_TB_MaDNG(UngDungId, tenBang, maDNG, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param maDNG the ma d n g
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findByUD_TB_MaDNG(long UngDungId, String tenBang,
		String maDNG, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UD_TB_MADNG;
			finderArgs = new Object[] { UngDungId, tenBang, maDNG };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UD_TB_MADNG;
			finderArgs = new Object[] {
					UngDungId, tenBang, maDNG,
					
					start, end, orderByComparator
				};
		}

		List<AnhXa> list = (List<AnhXa>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_ANHXA_WHERE);

			query.append(_FINDER_COLUMN_UD_TB_MADNG_UNGDUNGID_2);

			if (tenBang == null) {
				query.append(_FINDER_COLUMN_UD_TB_MADNG_TENBANG_1);
			}
			else {
				if (tenBang.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UD_TB_MADNG_TENBANG_3);
				}
				else {
					query.append(_FINDER_COLUMN_UD_TB_MADNG_TENBANG_2);
				}
			}

			if (maDNG == null) {
				query.append(_FINDER_COLUMN_UD_TB_MADNG_MADNG_1);
			}
			else {
				if (maDNG.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UD_TB_MADNG_MADNG_3);
				}
				else {
					query.append(_FINDER_COLUMN_UD_TB_MADNG_MADNG_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AnhXaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(UngDungId);

				if (tenBang != null) {
					qPos.add(tenBang);
				}

				if (maDNG != null) {
					qPos.add(maDNG);
				}

				list = (List<AnhXa>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param maDNG the ma d n g
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa findByUD_TB_MaDNG_First(long UngDungId, String tenBang,
		String maDNG, OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		List<AnhXa> list = findByUD_TB_MaDNG(UngDungId, tenBang, maDNG, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("UngDungId=");
			msg.append(UngDungId);

			msg.append(", tenBang=");
			msg.append(tenBang);

			msg.append(", maDNG=");
			msg.append(maDNG);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param maDNG the ma d n g
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa findByUD_TB_MaDNG_Last(long UngDungId, String tenBang,
		String maDNG, OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		int count = countByUD_TB_MaDNG(UngDungId, tenBang, maDNG);

		List<AnhXa> list = findByUD_TB_MaDNG(UngDungId, tenBang, maDNG,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("UngDungId=");
			msg.append(UngDungId);

			msg.append(", tenBang=");
			msg.append(tenBang);

			msg.append(", maDNG=");
			msg.append(maDNG);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAnhXaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the anh xas before and after the current anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param Id the primary key of the current anh xa
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param maDNG the ma d n g
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anh xa
	 * @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhXa[] findByUD_TB_MaDNG_PrevAndNext(long Id, long UngDungId,
		String tenBang, String maDNG, OrderByComparator orderByComparator)
		throws NoSuchAnhXaException, SystemException {
		AnhXa anhXa = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			AnhXa[] array = new AnhXaImpl[3];

			array[0] = getByUD_TB_MaDNG_PrevAndNext(session, anhXa, UngDungId,
					tenBang, maDNG, orderByComparator, true);

			array[1] = anhXa;

			array[2] = getByUD_TB_MaDNG_PrevAndNext(session, anhXa, UngDungId,
					tenBang, maDNG, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnhXa getByUD_TB_MaDNG_PrevAndNext(Session session, AnhXa anhXa,
		long UngDungId, String tenBang, String maDNG,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANHXA_WHERE);

		query.append(_FINDER_COLUMN_UD_TB_MADNG_UNGDUNGID_2);

		if (tenBang == null) {
			query.append(_FINDER_COLUMN_UD_TB_MADNG_TENBANG_1);
		}
		else {
			if (tenBang.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UD_TB_MADNG_TENBANG_3);
			}
			else {
				query.append(_FINDER_COLUMN_UD_TB_MADNG_TENBANG_2);
			}
		}

		if (maDNG == null) {
			query.append(_FINDER_COLUMN_UD_TB_MADNG_MADNG_1);
		}
		else {
			if (maDNG.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UD_TB_MADNG_MADNG_3);
			}
			else {
				query.append(_FINDER_COLUMN_UD_TB_MADNG_MADNG_2);
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
			query.append(AnhXaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(UngDungId);

		if (tenBang != null) {
			qPos.add(tenBang);
		}

		if (maDNG != null) {
			qPos.add(maDNG);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(anhXa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnhXa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the anh xas.
	 *
	 * @return the anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anh xas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @return the range of anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the anh xas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of anh xas
	 * @param end the upper bound of the range of anh xas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhXa> findAll(int start, int end,
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

		List<AnhXa> list = (List<AnhXa>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANHXA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANHXA.concat(AnhXaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AnhXa>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AnhXa>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the anh xas where UngDungId = &#63; from the database.
	 *
	 * @param UngDungId the ung dung ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUngDung(long UngDungId) throws SystemException {
		for (AnhXa anhXa : findByUngDung(UngDungId)) {
			remove(anhXa);
		}
	}

	/**
	 * Removes all the anh xas where tenBang = &#63; from the database.
	 *
	 * @param tenBang the ten bang
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBytenBang(String tenBang) throws SystemException {
		for (AnhXa anhXa : findBytenBang(tenBang)) {
			remove(anhXa);
		}
	}

	/**
	 * Removes all the anh xas where UngDungId = &#63; and tenBang = &#63; from the database.
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUD_TB(long UngDungId, String tenBang)
		throws SystemException {
		for (AnhXa anhXa : findByUD_TB(UngDungId, tenBang)) {
			remove(anhXa);
		}
	}

	/**
	 * Removes all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63; from the database.
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param maDNG the ma d n g
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUD_TB_MaDNG(long UngDungId, String tenBang, String maDNG)
		throws SystemException {
		for (AnhXa anhXa : findByUD_TB_MaDNG(UngDungId, tenBang, maDNG)) {
			remove(anhXa);
		}
	}

	/**
	 * Removes all the anh xas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AnhXa anhXa : findAll()) {
			remove(anhXa);
		}
	}

	/**
	 * Returns the number of anh xas where UngDungId = &#63;.
	 *
	 * @param UngDungId the ung dung ID
	 * @return the number of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUngDung(long UngDungId) throws SystemException {
		Object[] finderArgs = new Object[] { UngDungId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UNGDUNG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANHXA_WHERE);

			query.append(_FINDER_COLUMN_UNGDUNG_UNGDUNGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(UngDungId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UNGDUNG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of anh xas where tenBang = &#63;.
	 *
	 * @param tenBang the ten bang
	 * @return the number of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public int countBytenBang(String tenBang) throws SystemException {
		Object[] finderArgs = new Object[] { tenBang };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TENBANG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANHXA_WHERE);

			if (tenBang == null) {
				query.append(_FINDER_COLUMN_TENBANG_TENBANG_1);
			}
			else {
				if (tenBang.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENBANG_TENBANG_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENBANG_TENBANG_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenBang != null) {
					qPos.add(tenBang);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TENBANG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of anh xas where UngDungId = &#63; and tenBang = &#63;.
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @return the number of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUD_TB(long UngDungId, String tenBang)
		throws SystemException {
		Object[] finderArgs = new Object[] { UngDungId, tenBang };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UD_TB,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANHXA_WHERE);

			query.append(_FINDER_COLUMN_UD_TB_UNGDUNGID_2);

			if (tenBang == null) {
				query.append(_FINDER_COLUMN_UD_TB_TENBANG_1);
			}
			else {
				if (tenBang.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UD_TB_TENBANG_3);
				}
				else {
					query.append(_FINDER_COLUMN_UD_TB_TENBANG_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(UngDungId);

				if (tenBang != null) {
					qPos.add(tenBang);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UD_TB,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	 *
	 * @param UngDungId the ung dung ID
	 * @param tenBang the ten bang
	 * @param maDNG the ma d n g
	 * @return the number of matching anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUD_TB_MaDNG(long UngDungId, String tenBang, String maDNG)
		throws SystemException {
		Object[] finderArgs = new Object[] { UngDungId, tenBang, maDNG };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UD_TB_MADNG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ANHXA_WHERE);

			query.append(_FINDER_COLUMN_UD_TB_MADNG_UNGDUNGID_2);

			if (tenBang == null) {
				query.append(_FINDER_COLUMN_UD_TB_MADNG_TENBANG_1);
			}
			else {
				if (tenBang.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UD_TB_MADNG_TENBANG_3);
				}
				else {
					query.append(_FINDER_COLUMN_UD_TB_MADNG_TENBANG_2);
				}
			}

			if (maDNG == null) {
				query.append(_FINDER_COLUMN_UD_TB_MADNG_MADNG_1);
			}
			else {
				if (maDNG.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UD_TB_MADNG_MADNG_3);
				}
				else {
					query.append(_FINDER_COLUMN_UD_TB_MADNG_MADNG_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(UngDungId);

				if (tenBang != null) {
					qPos.add(tenBang);
				}

				if (maDNG != null) {
					qPos.add(maDNG);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UD_TB_MADNG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of anh xas.
	 *
	 * @return the number of anh xas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANHXA);

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
	 * Initializes the anh xa persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.thamso.model.AnhXa")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AnhXa>> listenersList = new ArrayList<ModelListener<AnhXa>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AnhXa>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnhXaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AnhXaPersistence.class)
	protected AnhXaPersistence anhXaPersistence;
	@BeanReference(type = ThamSoPersistence.class)
	protected ThamSoPersistence thamSoPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ANHXA = "SELECT anhXa FROM AnhXa anhXa";
	private static final String _SQL_SELECT_ANHXA_WHERE = "SELECT anhXa FROM AnhXa anhXa WHERE ";
	private static final String _SQL_COUNT_ANHXA = "SELECT COUNT(anhXa) FROM AnhXa anhXa";
	private static final String _SQL_COUNT_ANHXA_WHERE = "SELECT COUNT(anhXa) FROM AnhXa anhXa WHERE ";
	private static final String _FINDER_COLUMN_UNGDUNG_UNGDUNGID_2 = "anhXa.UngDungId = ?";
	private static final String _FINDER_COLUMN_TENBANG_TENBANG_1 = "anhXa.tenBang IS NULL";
	private static final String _FINDER_COLUMN_TENBANG_TENBANG_2 = "anhXa.tenBang = ?";
	private static final String _FINDER_COLUMN_TENBANG_TENBANG_3 = "(anhXa.tenBang IS NULL OR anhXa.tenBang = ?)";
	private static final String _FINDER_COLUMN_UD_TB_UNGDUNGID_2 = "anhXa.UngDungId = ? AND ";
	private static final String _FINDER_COLUMN_UD_TB_TENBANG_1 = "anhXa.tenBang IS NULL";
	private static final String _FINDER_COLUMN_UD_TB_TENBANG_2 = "anhXa.tenBang = ?";
	private static final String _FINDER_COLUMN_UD_TB_TENBANG_3 = "(anhXa.tenBang IS NULL OR anhXa.tenBang = ?)";
	private static final String _FINDER_COLUMN_UD_TB_MADNG_UNGDUNGID_2 = "anhXa.UngDungId = ? AND ";
	private static final String _FINDER_COLUMN_UD_TB_MADNG_TENBANG_1 = "anhXa.tenBang IS NULL AND ";
	private static final String _FINDER_COLUMN_UD_TB_MADNG_TENBANG_2 = "anhXa.tenBang = ? AND ";
	private static final String _FINDER_COLUMN_UD_TB_MADNG_TENBANG_3 = "(anhXa.tenBang IS NULL OR anhXa.tenBang = ?) AND ";
	private static final String _FINDER_COLUMN_UD_TB_MADNG_MADNG_1 = "anhXa.maDNG IS NULL";
	private static final String _FINDER_COLUMN_UD_TB_MADNG_MADNG_2 = "anhXa.maDNG = ?";
	private static final String _FINDER_COLUMN_UD_TB_MADNG_MADNG_3 = "(anhXa.maDNG IS NULL OR anhXa.maDNG = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "anhXa.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnhXa exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AnhXa exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnhXaPersistenceImpl.class);
	private static AnhXa _nullAnhXa = new AnhXaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AnhXa> toCacheModel() {
				return _nullAnhXaCacheModel;
			}
		};

	private static CacheModel<AnhXa> _nullAnhXaCacheModel = new CacheModel<AnhXa>() {
			public AnhXa toEntityModel() {
				return _nullAnhXa;
			}
		};
}