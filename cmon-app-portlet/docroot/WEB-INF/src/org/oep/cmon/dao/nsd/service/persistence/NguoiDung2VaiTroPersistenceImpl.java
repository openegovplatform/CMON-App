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

import org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException;
import org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro;
import org.oep.cmon.dao.nsd.model.impl.NguoiDung2VaiTroImpl;
import org.oep.cmon.dao.nsd.model.impl.NguoiDung2VaiTroModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the nguoi dung2 vai tro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see NguoiDung2VaiTroPersistence
 * @see NguoiDung2VaiTroUtil
 * @generated
 */
public class NguoiDung2VaiTroPersistenceImpl extends BasePersistenceImpl<NguoiDung2VaiTro>
	implements NguoiDung2VaiTroPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NguoiDung2VaiTroUtil} to access the nguoi dung2 vai tro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NguoiDung2VaiTroImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VAITROID = new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVaiTroID",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID =
		new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVaiTroID",
			new String[] { Long.class.getName(), Integer.class.getName() },
			NguoiDung2VaiTroModelImpl.VAITROID_COLUMN_BITMASK |
			NguoiDung2VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VAITROID = new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVaiTroID",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID =
		new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByVaiTroIDAndTaiKhoanNguoiDungId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			NguoiDung2VaiTroModelImpl.VAITROID_COLUMN_BITMASK |
			NguoiDung2VaiTroModelImpl.TAIKHOANNGUOIDUNGID_COLUMN_BITMASK |
			NguoiDung2VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VAITROIDANDTAIKHOANNGUOIDUNGID =
		new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVaiTroIDAndTaiKhoanNguoiDungId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID =
		new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTaiKhoanNguoiDungId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID =
		new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTaiKhoanNguoiDungId",
			new String[] { Long.class.getName(), Integer.class.getName() },
			NguoiDung2VaiTroModelImpl.TAIKHOANNGUOIDUNGID_COLUMN_BITMASK |
			NguoiDung2VaiTroModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNGID = new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaiKhoanNguoiDungId",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the nguoi dung2 vai tro in the entity cache if it is enabled.
	 *
	 * @param nguoiDung2VaiTro the nguoi dung2 vai tro
	 */
	public void cacheResult(NguoiDung2VaiTro nguoiDung2VaiTro) {
		EntityCacheUtil.putResult(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class, nguoiDung2VaiTro.getPrimaryKey(),
			nguoiDung2VaiTro);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
			new Object[] {
				Long.valueOf(nguoiDung2VaiTro.getVaiTroId()),
				Long.valueOf(nguoiDung2VaiTro.getTaiKhoanNguoiDungId()),
				Integer.valueOf(nguoiDung2VaiTro.getDaXoa())
			}, nguoiDung2VaiTro);

		nguoiDung2VaiTro.resetOriginalValues();
	}

	/**
	 * Caches the nguoi dung2 vai tros in the entity cache if it is enabled.
	 *
	 * @param nguoiDung2VaiTros the nguoi dung2 vai tros
	 */
	public void cacheResult(List<NguoiDung2VaiTro> nguoiDung2VaiTros) {
		for (NguoiDung2VaiTro nguoiDung2VaiTro : nguoiDung2VaiTros) {
			if (EntityCacheUtil.getResult(
						NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
						NguoiDung2VaiTroImpl.class,
						nguoiDung2VaiTro.getPrimaryKey()) == null) {
				cacheResult(nguoiDung2VaiTro);
			}
			else {
				nguoiDung2VaiTro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all nguoi dung2 vai tros.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NguoiDung2VaiTroImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NguoiDung2VaiTroImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the nguoi dung2 vai tro.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NguoiDung2VaiTro nguoiDung2VaiTro) {
		EntityCacheUtil.removeResult(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class, nguoiDung2VaiTro.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(nguoiDung2VaiTro);
	}

	@Override
	public void clearCache(List<NguoiDung2VaiTro> nguoiDung2VaiTros) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NguoiDung2VaiTro nguoiDung2VaiTro : nguoiDung2VaiTros) {
			EntityCacheUtil.removeResult(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
				NguoiDung2VaiTroImpl.class, nguoiDung2VaiTro.getPrimaryKey());

			clearUniqueFindersCache(nguoiDung2VaiTro);
		}
	}

	protected void clearUniqueFindersCache(NguoiDung2VaiTro nguoiDung2VaiTro) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
			new Object[] {
				Long.valueOf(nguoiDung2VaiTro.getVaiTroId()),
				Long.valueOf(nguoiDung2VaiTro.getTaiKhoanNguoiDungId()),
				Integer.valueOf(nguoiDung2VaiTro.getDaXoa())
			});
	}

	/**
	 * Creates a new nguoi dung2 vai tro with the primary key. Does not add the nguoi dung2 vai tro to the database.
	 *
	 * @param id the primary key for the new nguoi dung2 vai tro
	 * @return the new nguoi dung2 vai tro
	 */
	public NguoiDung2VaiTro create(long id) {
		NguoiDung2VaiTro nguoiDung2VaiTro = new NguoiDung2VaiTroImpl();

		nguoiDung2VaiTro.setNew(true);
		nguoiDung2VaiTro.setPrimaryKey(id);

		return nguoiDung2VaiTro;
	}

	/**
	 * Removes the nguoi dung2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nguoi dung2 vai tro
	 * @return the nguoi dung2 vai tro that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a nguoi dung2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro remove(long id)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the nguoi dung2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nguoi dung2 vai tro
	 * @return the nguoi dung2 vai tro that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a nguoi dung2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NguoiDung2VaiTro remove(Serializable primaryKey)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NguoiDung2VaiTro nguoiDung2VaiTro = (NguoiDung2VaiTro)session.get(NguoiDung2VaiTroImpl.class,
					primaryKey);

			if (nguoiDung2VaiTro == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNguoiDung2VaiTroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(nguoiDung2VaiTro);
		}
		catch (NoSuchNguoiDung2VaiTroException nsee) {
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
	protected NguoiDung2VaiTro removeImpl(NguoiDung2VaiTro nguoiDung2VaiTro)
		throws SystemException {
		nguoiDung2VaiTro = toUnwrappedModel(nguoiDung2VaiTro);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, nguoiDung2VaiTro);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(nguoiDung2VaiTro);

		return nguoiDung2VaiTro;
	}

	@Override
	public NguoiDung2VaiTro updateImpl(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro,
		boolean merge) throws SystemException {
		nguoiDung2VaiTro = toUnwrappedModel(nguoiDung2VaiTro);

		boolean isNew = nguoiDung2VaiTro.isNew();

		NguoiDung2VaiTroModelImpl nguoiDung2VaiTroModelImpl = (NguoiDung2VaiTroModelImpl)nguoiDung2VaiTro;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, nguoiDung2VaiTro, merge);

			nguoiDung2VaiTro.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NguoiDung2VaiTroModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((nguoiDung2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(nguoiDung2VaiTroModelImpl.getOriginalVaiTroId()),
						Integer.valueOf(nguoiDung2VaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAITROID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID,
					args);

				args = new Object[] {
						Long.valueOf(nguoiDung2VaiTroModelImpl.getVaiTroId()),
						Integer.valueOf(nguoiDung2VaiTroModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAITROID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VAITROID,
					args);
			}

			if ((nguoiDung2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(nguoiDung2VaiTroModelImpl.getOriginalTaiKhoanNguoiDungId()),
						Integer.valueOf(nguoiDung2VaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID,
					args);

				args = new Object[] {
						Long.valueOf(nguoiDung2VaiTroModelImpl.getTaiKhoanNguoiDungId()),
						Integer.valueOf(nguoiDung2VaiTroModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID,
					args);
			}
		}

		EntityCacheUtil.putResult(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
			NguoiDung2VaiTroImpl.class, nguoiDung2VaiTro.getPrimaryKey(),
			nguoiDung2VaiTro);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
				new Object[] {
					Long.valueOf(nguoiDung2VaiTro.getVaiTroId()),
					Long.valueOf(nguoiDung2VaiTro.getTaiKhoanNguoiDungId()),
					Integer.valueOf(nguoiDung2VaiTro.getDaXoa())
				}, nguoiDung2VaiTro);
		}
		else {
			if ((nguoiDung2VaiTroModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(nguoiDung2VaiTroModelImpl.getOriginalVaiTroId()),
						Long.valueOf(nguoiDung2VaiTroModelImpl.getOriginalTaiKhoanNguoiDungId()),
						Integer.valueOf(nguoiDung2VaiTroModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
					new Object[] {
						Long.valueOf(nguoiDung2VaiTro.getVaiTroId()),
						Long.valueOf(nguoiDung2VaiTro.getTaiKhoanNguoiDungId()),
						Integer.valueOf(nguoiDung2VaiTro.getDaXoa())
					}, nguoiDung2VaiTro);
			}
		}

		return nguoiDung2VaiTro;
	}

	protected NguoiDung2VaiTro toUnwrappedModel(
		NguoiDung2VaiTro nguoiDung2VaiTro) {
		if (nguoiDung2VaiTro instanceof NguoiDung2VaiTroImpl) {
			return nguoiDung2VaiTro;
		}

		NguoiDung2VaiTroImpl nguoiDung2VaiTroImpl = new NguoiDung2VaiTroImpl();

		nguoiDung2VaiTroImpl.setNew(nguoiDung2VaiTro.isNew());
		nguoiDung2VaiTroImpl.setPrimaryKey(nguoiDung2VaiTro.getPrimaryKey());

		nguoiDung2VaiTroImpl.setId(nguoiDung2VaiTro.getId());
		nguoiDung2VaiTroImpl.setVaiTroId(nguoiDung2VaiTro.getVaiTroId());
		nguoiDung2VaiTroImpl.setTaiKhoanNguoiDungId(nguoiDung2VaiTro.getTaiKhoanNguoiDungId());
		nguoiDung2VaiTroImpl.setNgayTao(nguoiDung2VaiTro.getNgayTao());
		nguoiDung2VaiTroImpl.setNguoiTao(nguoiDung2VaiTro.getNguoiTao());
		nguoiDung2VaiTroImpl.setDaXoa(nguoiDung2VaiTro.getDaXoa());

		return nguoiDung2VaiTroImpl;
	}

	/**
	 * Returns the nguoi dung2 vai tro with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the nguoi dung2 vai tro
	 * @return the nguoi dung2 vai tro
	 * @throws com.liferay.portal.NoSuchModelException if a nguoi dung2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NguoiDung2VaiTro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the nguoi dung2 vai tro with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException} if it could not be found.
	 *
	 * @param id the primary key of the nguoi dung2 vai tro
	 * @return the nguoi dung2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a nguoi dung2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro findByPrimaryKey(long id)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		NguoiDung2VaiTro nguoiDung2VaiTro = fetchByPrimaryKey(id);

		if (nguoiDung2VaiTro == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchNguoiDung2VaiTroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return nguoiDung2VaiTro;
	}

	/**
	 * Returns the nguoi dung2 vai tro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nguoi dung2 vai tro
	 * @return the nguoi dung2 vai tro, or <code>null</code> if a nguoi dung2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NguoiDung2VaiTro fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the nguoi dung2 vai tro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nguoi dung2 vai tro
	 * @return the nguoi dung2 vai tro, or <code>null</code> if a nguoi dung2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro fetchByPrimaryKey(long id)
		throws SystemException {
		NguoiDung2VaiTro nguoiDung2VaiTro = (NguoiDung2VaiTro)EntityCacheUtil.getResult(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
				NguoiDung2VaiTroImpl.class, id);

		if (nguoiDung2VaiTro == _nullNguoiDung2VaiTro) {
			return null;
		}

		if (nguoiDung2VaiTro == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				nguoiDung2VaiTro = (NguoiDung2VaiTro)session.get(NguoiDung2VaiTroImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (nguoiDung2VaiTro != null) {
					cacheResult(nguoiDung2VaiTro);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(NguoiDung2VaiTroModelImpl.ENTITY_CACHE_ENABLED,
						NguoiDung2VaiTroImpl.class, id, _nullNguoiDung2VaiTro);
				}

				closeSession(session);
			}
		}

		return nguoiDung2VaiTro;
	}

	/**
	 * Returns all the nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @return the matching nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<NguoiDung2VaiTro> findByVaiTroID(Long vaiTroId, int daXoa)
		throws SystemException {
		return findByVaiTroID(vaiTroId, daXoa, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nguoi dung2 vai tros
	 * @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	 * @return the range of matching nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<NguoiDung2VaiTro> findByVaiTroID(Long vaiTroId, int daXoa,
		int start, int end) throws SystemException {
		return findByVaiTroID(vaiTroId, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nguoi dung2 vai tros
	 * @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<NguoiDung2VaiTro> findByVaiTroID(Long vaiTroId, int daXoa,
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

		List<NguoiDung2VaiTro> list = (List<NguoiDung2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_NGUOIDUNG2VAITRO_WHERE);

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

				list = (List<NguoiDung2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first nguoi dung2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nguoi dung2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro findByVaiTroID_First(Long vaiTroId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		List<NguoiDung2VaiTro> list = findByVaiTroID(vaiTroId, daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNguoiDung2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last nguoi dung2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nguoi dung2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro findByVaiTroID_Last(Long vaiTroId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		int count = countByVaiTroID(vaiTroId, daXoa);

		List<NguoiDung2VaiTro> list = findByVaiTroID(vaiTroId, daXoa,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNguoiDung2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the nguoi dung2 vai tros before and after the current nguoi dung2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current nguoi dung2 vai tro
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nguoi dung2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a nguoi dung2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro[] findByVaiTroID_PrevAndNext(long id,
		Long vaiTroId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		NguoiDung2VaiTro nguoiDung2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NguoiDung2VaiTro[] array = new NguoiDung2VaiTroImpl[3];

			array[0] = getByVaiTroID_PrevAndNext(session, nguoiDung2VaiTro,
					vaiTroId, daXoa, orderByComparator, true);

			array[1] = nguoiDung2VaiTro;

			array[2] = getByVaiTroID_PrevAndNext(session, nguoiDung2VaiTro,
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

	protected NguoiDung2VaiTro getByVaiTroID_PrevAndNext(Session session,
		NguoiDung2VaiTro nguoiDung2VaiTro, Long vaiTroId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NGUOIDUNG2VAITRO_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(nguoiDung2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NguoiDung2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the nguoi dung2 vai tro where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException} if it could not be found.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @return the matching nguoi dung2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro findByVaiTroIDAndTaiKhoanNguoiDungId(
		Long vaiTroId, Long taiKhoanNguoiDungId, int daXoa)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		NguoiDung2VaiTro nguoiDung2VaiTro = fetchByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
				taiKhoanNguoiDungId, daXoa);

		if (nguoiDung2VaiTro == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vaiTroId=");
			msg.append(vaiTroId);

			msg.append(", taiKhoanNguoiDungId=");
			msg.append(taiKhoanNguoiDungId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNguoiDung2VaiTroException(msg.toString());
		}

		return nguoiDung2VaiTro;
	}

	/**
	 * Returns the nguoi dung2 vai tro where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @return the matching nguoi dung2 vai tro, or <code>null</code> if a matching nguoi dung2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro fetchByVaiTroIDAndTaiKhoanNguoiDungId(
		Long vaiTroId, Long taiKhoanNguoiDungId, int daXoa)
		throws SystemException {
		return fetchByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
			taiKhoanNguoiDungId, daXoa, true);
	}

	/**
	 * Returns the nguoi dung2 vai tro where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching nguoi dung2 vai tro, or <code>null</code> if a matching nguoi dung2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro fetchByVaiTroIDAndTaiKhoanNguoiDungId(
		Long vaiTroId, Long taiKhoanNguoiDungId, int daXoa,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { vaiTroId, taiKhoanNguoiDungId, daXoa };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_NGUOIDUNG2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_VAITROIDANDTAIKHOANNGUOIDUNGID_VAITROID_2);

			query.append(_FINDER_COLUMN_VAITROIDANDTAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2);

			query.append(_FINDER_COLUMN_VAITROIDANDTAIKHOANNGUOIDUNGID_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vaiTroId.longValue());

				qPos.add(taiKhoanNguoiDungId.longValue());

				qPos.add(daXoa);

				List<NguoiDung2VaiTro> list = q.list();

				result = list;

				NguoiDung2VaiTro nguoiDung2VaiTro = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
						finderArgs, list);
				}
				else {
					nguoiDung2VaiTro = list.get(0);

					cacheResult(nguoiDung2VaiTro);

					if ((nguoiDung2VaiTro.getVaiTroId() != vaiTroId) ||
							(nguoiDung2VaiTro.getTaiKhoanNguoiDungId() != taiKhoanNguoiDungId) ||
							(nguoiDung2VaiTro.getDaXoa() != daXoa)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
							finderArgs, nguoiDung2VaiTro);
					}
				}

				return nguoiDung2VaiTro;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
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
				return (NguoiDung2VaiTro)result;
			}
		}
	}

	/**
	 * Returns all the nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @return the matching nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<NguoiDung2VaiTro> findByTaiKhoanNguoiDungId(
		Long taiKhoanNguoiDungId, int daXoa) throws SystemException {
		return findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nguoi dung2 vai tros
	 * @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	 * @return the range of matching nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<NguoiDung2VaiTro> findByTaiKhoanNguoiDungId(
		Long taiKhoanNguoiDungId, int daXoa, int start, int end)
		throws SystemException {
		return findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, daXoa, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of nguoi dung2 vai tros
	 * @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<NguoiDung2VaiTro> findByTaiKhoanNguoiDungId(
		Long taiKhoanNguoiDungId, int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID;
			finderArgs = new Object[] { taiKhoanNguoiDungId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID;
			finderArgs = new Object[] {
					taiKhoanNguoiDungId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<NguoiDung2VaiTro> list = (List<NguoiDung2VaiTro>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_NGUOIDUNG2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNGID_DAXOA_2);

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

				qPos.add(taiKhoanNguoiDungId.longValue());

				qPos.add(daXoa);

				list = (List<NguoiDung2VaiTro>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first nguoi dung2 vai tro in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nguoi dung2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro findByTaiKhoanNguoiDungId_First(
		Long taiKhoanNguoiDungId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		List<NguoiDung2VaiTro> list = findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId,
				daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taiKhoanNguoiDungId=");
			msg.append(taiKhoanNguoiDungId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNguoiDung2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last nguoi dung2 vai tro in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nguoi dung2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro findByTaiKhoanNguoiDungId_Last(
		Long taiKhoanNguoiDungId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		int count = countByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, daXoa);

		List<NguoiDung2VaiTro> list = findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId,
				daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taiKhoanNguoiDungId=");
			msg.append(taiKhoanNguoiDungId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNguoiDung2VaiTroException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the nguoi dung2 vai tros before and after the current nguoi dung2 vai tro in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current nguoi dung2 vai tro
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nguoi dung2 vai tro
	 * @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a nguoi dung2 vai tro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NguoiDung2VaiTro[] findByTaiKhoanNguoiDungId_PrevAndNext(long id,
		Long taiKhoanNguoiDungId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		NguoiDung2VaiTro nguoiDung2VaiTro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NguoiDung2VaiTro[] array = new NguoiDung2VaiTroImpl[3];

			array[0] = getByTaiKhoanNguoiDungId_PrevAndNext(session,
					nguoiDung2VaiTro, taiKhoanNguoiDungId, daXoa,
					orderByComparator, true);

			array[1] = nguoiDung2VaiTro;

			array[2] = getByTaiKhoanNguoiDungId_PrevAndNext(session,
					nguoiDung2VaiTro, taiKhoanNguoiDungId, daXoa,
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

	protected NguoiDung2VaiTro getByTaiKhoanNguoiDungId_PrevAndNext(
		Session session, NguoiDung2VaiTro nguoiDung2VaiTro,
		Long taiKhoanNguoiDungId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NGUOIDUNG2VAITRO_WHERE);

		query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2);

		query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNGID_DAXOA_2);

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

		qPos.add(taiKhoanNguoiDungId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(nguoiDung2VaiTro);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NguoiDung2VaiTro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the nguoi dung2 vai tros.
	 *
	 * @return the nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<NguoiDung2VaiTro> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nguoi dung2 vai tros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of nguoi dung2 vai tros
	 * @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	 * @return the range of nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<NguoiDung2VaiTro> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the nguoi dung2 vai tros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of nguoi dung2 vai tros
	 * @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public List<NguoiDung2VaiTro> findAll(int start, int end,
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

		List<NguoiDung2VaiTro> list = (List<NguoiDung2VaiTro>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NGUOIDUNG2VAITRO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NGUOIDUNG2VAITRO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<NguoiDung2VaiTro>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<NguoiDung2VaiTro>)QueryUtil.list(q,
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
	 * Removes all the nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVaiTroID(Long vaiTroId, int daXoa)
		throws SystemException {
		for (NguoiDung2VaiTro nguoiDung2VaiTro : findByVaiTroID(vaiTroId, daXoa)) {
			remove(nguoiDung2VaiTro);
		}
	}

	/**
	 * Removes the nguoi dung2 vai tro where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVaiTroIDAndTaiKhoanNguoiDungId(Long vaiTroId,
		Long taiKhoanNguoiDungId, int daXoa)
		throws NoSuchNguoiDung2VaiTroException, SystemException {
		NguoiDung2VaiTro nguoiDung2VaiTro = findByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
				taiKhoanNguoiDungId, daXoa);

		remove(nguoiDung2VaiTro);
	}

	/**
	 * Removes all the nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId, int daXoa)
		throws SystemException {
		for (NguoiDung2VaiTro nguoiDung2VaiTro : findByTaiKhoanNguoiDungId(
				taiKhoanNguoiDungId, daXoa)) {
			remove(nguoiDung2VaiTro);
		}
	}

	/**
	 * Removes all the nguoi dung2 vai tros from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (NguoiDung2VaiTro nguoiDung2VaiTro : findAll()) {
			remove(nguoiDung2VaiTro);
		}
	}

	/**
	 * Returns the number of nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param daXoa the da xoa
	 * @return the number of matching nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVaiTroID(Long vaiTroId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { vaiTroId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VAITROID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NGUOIDUNG2VAITRO_WHERE);

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
	 * Returns the number of nguoi dung2 vai tros where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * @param vaiTroId the vai tro ID
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @return the number of matching nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVaiTroIDAndTaiKhoanNguoiDungId(Long vaiTroId,
		Long taiKhoanNguoiDungId, int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { vaiTroId, taiKhoanNguoiDungId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_NGUOIDUNG2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_VAITROIDANDTAIKHOANNGUOIDUNGID_VAITROID_2);

			query.append(_FINDER_COLUMN_VAITROIDANDTAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2);

			query.append(_FINDER_COLUMN_VAITROIDANDTAIKHOANNGUOIDUNGID_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vaiTroId.longValue());

				qPos.add(taiKhoanNguoiDungId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VAITROIDANDTAIKHOANNGUOIDUNGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @return the number of matching nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { taiKhoanNguoiDungId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NGUOIDUNG2VAITRO_WHERE);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNGID_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanNguoiDungId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of nguoi dung2 vai tros.
	 *
	 * @return the number of nguoi dung2 vai tros
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NGUOIDUNG2VAITRO);

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
	 * Initializes the nguoi dung2 vai tro persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NguoiDung2VaiTro>> listenersList = new ArrayList<ModelListener<NguoiDung2VaiTro>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NguoiDung2VaiTro>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NguoiDung2VaiTroImpl.class.getName());
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
	private static final String _SQL_SELECT_NGUOIDUNG2VAITRO = "SELECT nguoiDung2VaiTro FROM NguoiDung2VaiTro nguoiDung2VaiTro";
	private static final String _SQL_SELECT_NGUOIDUNG2VAITRO_WHERE = "SELECT nguoiDung2VaiTro FROM NguoiDung2VaiTro nguoiDung2VaiTro WHERE ";
	private static final String _SQL_COUNT_NGUOIDUNG2VAITRO = "SELECT COUNT(nguoiDung2VaiTro) FROM NguoiDung2VaiTro nguoiDung2VaiTro";
	private static final String _SQL_COUNT_NGUOIDUNG2VAITRO_WHERE = "SELECT COUNT(nguoiDung2VaiTro) FROM NguoiDung2VaiTro nguoiDung2VaiTro WHERE ";
	private static final String _FINDER_COLUMN_VAITROID_VAITROID_2 = "nguoiDung2VaiTro.vaiTroId = ? AND ";
	private static final String _FINDER_COLUMN_VAITROID_DAXOA_2 = "nguoiDung2VaiTro.daXoa = ?";
	private static final String _FINDER_COLUMN_VAITROIDANDTAIKHOANNGUOIDUNGID_VAITROID_2 =
		"nguoiDung2VaiTro.vaiTroId = ? AND ";
	private static final String _FINDER_COLUMN_VAITROIDANDTAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2 =
		"nguoiDung2VaiTro.taiKhoanNguoiDungId = ? AND ";
	private static final String _FINDER_COLUMN_VAITROIDANDTAIKHOANNGUOIDUNGID_DAXOA_2 =
		"nguoiDung2VaiTro.daXoa = ?";
	private static final String _FINDER_COLUMN_TAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2 =
		"nguoiDung2VaiTro.taiKhoanNguoiDungId = ? AND ";
	private static final String _FINDER_COLUMN_TAIKHOANNGUOIDUNGID_DAXOA_2 = "nguoiDung2VaiTro.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nguoiDung2VaiTro.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NguoiDung2VaiTro exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NguoiDung2VaiTro exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NguoiDung2VaiTroPersistenceImpl.class);
	private static NguoiDung2VaiTro _nullNguoiDung2VaiTro = new NguoiDung2VaiTroImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NguoiDung2VaiTro> toCacheModel() {
				return _nullNguoiDung2VaiTroCacheModel;
			}
		};

	private static CacheModel<NguoiDung2VaiTro> _nullNguoiDung2VaiTroCacheModel = new CacheModel<NguoiDung2VaiTro>() {
			public NguoiDung2VaiTro toEntityModel() {
				return _nullNguoiDung2VaiTro;
			}
		};
}