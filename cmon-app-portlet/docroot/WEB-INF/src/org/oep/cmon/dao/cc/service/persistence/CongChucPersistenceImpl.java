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

import org.oep.cmon.dao.cc.NoSuchCongChucException;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.impl.CongChucImpl;
import org.oep.cmon.dao.cc.model.impl.CongChucModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cong chuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see CongChucPersistence
 * @see CongChucUtil
 * @generated
 */
public class CongChucPersistenceImpl extends BasePersistenceImpl<CongChuc>
	implements CongChucPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CongChucUtil} to access the cong chuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CongChucImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MA = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] { String.class.getName() },
			CongChucModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID =
		new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTaiKhoanNguoiDungId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID =
		new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTaiKhoanNguoiDungId", new String[] { Long.class.getName() },
			CongChucModelImpl.TAIKHOANNGUOIDUNGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNGID = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaiKhoanNguoiDungId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHUCVUID = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChucVuId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID =
		new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChucVuId",
			new String[] { Long.class.getName() },
			CongChucModelImpl.CHUCVUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHUCVUID = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChucVuId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANQUANLYID =
		new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCoQuanQuanLyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID =
		new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCoQuanQuanLyId",
			new String[] { Long.class.getName() },
			CongChucModelImpl.COQUANQUANLYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COQUANQUANLYID = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCoQuanQuanLyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			CongChucModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, CongChucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cong chuc in the entity cache if it is enabled.
	 *
	 * @param congChuc the cong chuc
	 */
	public void cacheResult(CongChuc congChuc) {
		EntityCacheUtil.putResult(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucImpl.class, congChuc.getPrimaryKey(), congChuc);

		congChuc.resetOriginalValues();
	}

	/**
	 * Caches the cong chucs in the entity cache if it is enabled.
	 *
	 * @param congChucs the cong chucs
	 */
	public void cacheResult(List<CongChuc> congChucs) {
		for (CongChuc congChuc : congChucs) {
			if (EntityCacheUtil.getResult(
						CongChucModelImpl.ENTITY_CACHE_ENABLED,
						CongChucImpl.class, congChuc.getPrimaryKey()) == null) {
				cacheResult(congChuc);
			}
			else {
				congChuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cong chucs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CongChucImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CongChucImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cong chuc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CongChuc congChuc) {
		EntityCacheUtil.removeResult(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucImpl.class, congChuc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CongChuc> congChucs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CongChuc congChuc : congChucs) {
			EntityCacheUtil.removeResult(CongChucModelImpl.ENTITY_CACHE_ENABLED,
				CongChucImpl.class, congChuc.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cong chuc with the primary key. Does not add the cong chuc to the database.
	 *
	 * @param id the primary key for the new cong chuc
	 * @return the new cong chuc
	 */
	public CongChuc create(long id) {
		CongChuc congChuc = new CongChucImpl();

		congChuc.setNew(true);
		congChuc.setPrimaryKey(id);

		return congChuc;
	}

	/**
	 * Removes the cong chuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cong chuc
	 * @return the cong chuc that was removed
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc remove(long id)
		throws NoSuchCongChucException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the cong chuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cong chuc
	 * @return the cong chuc that was removed
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongChuc remove(Serializable primaryKey)
		throws NoSuchCongChucException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CongChuc congChuc = (CongChuc)session.get(CongChucImpl.class,
					primaryKey);

			if (congChuc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCongChucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(congChuc);
		}
		catch (NoSuchCongChucException nsee) {
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
	protected CongChuc removeImpl(CongChuc congChuc) throws SystemException {
		congChuc = toUnwrappedModel(congChuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, congChuc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(congChuc);

		return congChuc;
	}

	@Override
	public CongChuc updateImpl(org.oep.cmon.dao.cc.model.CongChuc congChuc,
		boolean merge) throws SystemException {
		congChuc = toUnwrappedModel(congChuc);

		boolean isNew = congChuc.isNew();

		CongChucModelImpl congChucModelImpl = (CongChucModelImpl)congChuc;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, congChuc, merge);

			congChuc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CongChucModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((congChucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { congChucModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);

				args = new Object[] { congChucModelImpl.getMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);
			}

			if ((congChucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(congChucModelImpl.getOriginalTaiKhoanNguoiDungId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID,
					args);

				args = new Object[] {
						Long.valueOf(congChucModelImpl.getTaiKhoanNguoiDungId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID,
					args);
			}

			if ((congChucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(congChucModelImpl.getOriginalChucVuId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHUCVUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID,
					args);

				args = new Object[] {
						Long.valueOf(congChucModelImpl.getChucVuId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHUCVUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID,
					args);
			}

			if ((congChucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(congChucModelImpl.getOriginalCoQuanQuanLyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID,
					args);

				args = new Object[] {
						Long.valueOf(congChucModelImpl.getCoQuanQuanLyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID,
					args);
			}

			if ((congChucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(congChucModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(congChucModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(CongChucModelImpl.ENTITY_CACHE_ENABLED,
			CongChucImpl.class, congChuc.getPrimaryKey(), congChuc);

		return congChuc;
	}

	protected CongChuc toUnwrappedModel(CongChuc congChuc) {
		if (congChuc instanceof CongChucImpl) {
			return congChuc;
		}

		CongChucImpl congChucImpl = new CongChucImpl();

		congChucImpl.setNew(congChuc.isNew());
		congChucImpl.setPrimaryKey(congChuc.getPrimaryKey());

		congChucImpl.setId(congChuc.getId());
		congChucImpl.setMa(congChuc.getMa());
		congChucImpl.setHoVaTen(congChuc.getHoVaTen());
		congChucImpl.setNgaySinh(congChuc.getNgaySinh());
		congChucImpl.setSoCmnd(congChuc.getSoCmnd());
		congChucImpl.setNgayCapCmnd(congChuc.getNgayCapCmnd());
		congChucImpl.setNoiCapCmnd(congChuc.getNoiCapCmnd());
		congChucImpl.setGioiTinhId(congChuc.getGioiTinhId());
		congChucImpl.setNgayTao(congChuc.getNgayTao());
		congChucImpl.setNgaySua(congChuc.getNgaySua());
		congChucImpl.setDaXoa(congChuc.getDaXoa());
		congChucImpl.setTaiKhoanNguoiDungId(congChuc.getTaiKhoanNguoiDungId());
		congChucImpl.setNguoiSua(congChuc.getNguoiSua());
		congChucImpl.setChucVuId(congChuc.getChucVuId());
		congChucImpl.setCoQuanQuanLyId(congChuc.getCoQuanQuanLyId());
		congChucImpl.setNguoiTao(congChuc.getNguoiTao());

		return congChucImpl;
	}

	/**
	 * Returns the cong chuc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong chuc
	 * @return the cong chuc
	 * @throws com.liferay.portal.NoSuchModelException if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongChuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cong chuc with the primary key or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChucException} if it could not be found.
	 *
	 * @param id the primary key of the cong chuc
	 * @return the cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByPrimaryKey(long id)
		throws NoSuchCongChucException, SystemException {
		CongChuc congChuc = fetchByPrimaryKey(id);

		if (congChuc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCongChucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return congChuc;
	}

	/**
	 * Returns the cong chuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong chuc
	 * @return the cong chuc, or <code>null</code> if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongChuc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cong chuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cong chuc
	 * @return the cong chuc, or <code>null</code> if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc fetchByPrimaryKey(long id) throws SystemException {
		CongChuc congChuc = (CongChuc)EntityCacheUtil.getResult(CongChucModelImpl.ENTITY_CACHE_ENABLED,
				CongChucImpl.class, id);

		if (congChuc == _nullCongChuc) {
			return null;
		}

		if (congChuc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				congChuc = (CongChuc)session.get(CongChucImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (congChuc != null) {
					cacheResult(congChuc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CongChucModelImpl.ENTITY_CACHE_ENABLED,
						CongChucImpl.class, id, _nullCongChuc);
				}

				closeSession(session);
			}
		}

		return congChuc;
	}

	/**
	 * Returns all the cong chucs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByMa(String ma) throws SystemException {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong chucs where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @return the range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByMa(String ma, int start, int end)
		throws SystemException {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong chucs where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByMa(String ma, int start, int end,
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

		List<CongChuc> list = (List<CongChuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGCHUC_WHERE);

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
				query.append(CongChucModelImpl.ORDER_BY_JPQL);
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

				list = (List<CongChuc>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first cong chuc in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByMa_First(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		List<CongChuc> list = findByMa(ma, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong chuc in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByMa_Last(String ma, OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		int count = countByMa(ma);

		List<CongChuc> list = findByMa(ma, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong chucs before and after the current cong chuc in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong chuc
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc[] findByMa_PrevAndNext(long id, String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		CongChuc congChuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongChuc[] array = new CongChucImpl[3];

			array[0] = getByMa_PrevAndNext(session, congChuc, ma,
					orderByComparator, true);

			array[1] = congChuc;

			array[2] = getByMa_PrevAndNext(session, congChuc, ma,
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

	protected CongChuc getByMa_PrevAndNext(Session session, CongChuc congChuc,
		String ma, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGCHUC_WHERE);

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
			query.append(CongChucModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(congChuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongChuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cong chucs where taiKhoanNguoiDungId = &#63;.
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @return the matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId)
		throws SystemException {
		return findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong chucs where taiKhoanNguoiDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @return the range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId,
		int start, int end) throws SystemException {
		return findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong chucs where taiKhoanNguoiDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID;
			finderArgs = new Object[] { taiKhoanNguoiDungId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNGID;
			finderArgs = new Object[] {
					taiKhoanNguoiDungId,
					
					start, end, orderByComparator
				};
		}

		List<CongChuc> list = (List<CongChuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGCHUC_WHERE);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CongChucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanNguoiDungId.longValue());

				list = (List<CongChuc>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first cong chuc in the ordered set where taiKhoanNguoiDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByTaiKhoanNguoiDungId_First(Long taiKhoanNguoiDungId,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		List<CongChuc> list = findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taiKhoanNguoiDungId=");
			msg.append(taiKhoanNguoiDungId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong chuc in the ordered set where taiKhoanNguoiDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByTaiKhoanNguoiDungId_Last(Long taiKhoanNguoiDungId,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		int count = countByTaiKhoanNguoiDungId(taiKhoanNguoiDungId);

		List<CongChuc> list = findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taiKhoanNguoiDungId=");
			msg.append(taiKhoanNguoiDungId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong chucs before and after the current cong chuc in the ordered set where taiKhoanNguoiDungId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong chuc
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc[] findByTaiKhoanNguoiDungId_PrevAndNext(long id,
		Long taiKhoanNguoiDungId, OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		CongChuc congChuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongChuc[] array = new CongChucImpl[3];

			array[0] = getByTaiKhoanNguoiDungId_PrevAndNext(session, congChuc,
					taiKhoanNguoiDungId, orderByComparator, true);

			array[1] = congChuc;

			array[2] = getByTaiKhoanNguoiDungId_PrevAndNext(session, congChuc,
					taiKhoanNguoiDungId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CongChuc getByTaiKhoanNguoiDungId_PrevAndNext(Session session,
		CongChuc congChuc, Long taiKhoanNguoiDungId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGCHUC_WHERE);

		query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2);

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
			query.append(CongChucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taiKhoanNguoiDungId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(congChuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongChuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cong chucs where chucVuId = &#63;.
	 *
	 * @param chucVuId the chuc vu ID
	 * @return the matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByChucVuId(long chucVuId)
		throws SystemException {
		return findByChucVuId(chucVuId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the cong chucs where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @return the range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByChucVuId(long chucVuId, int start, int end)
		throws SystemException {
		return findByChucVuId(chucVuId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong chucs where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByChucVuId(long chucVuId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHUCVUID;
			finderArgs = new Object[] { chucVuId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHUCVUID;
			finderArgs = new Object[] { chucVuId, start, end, orderByComparator };
		}

		List<CongChuc> list = (List<CongChuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGCHUC_WHERE);

			query.append(_FINDER_COLUMN_CHUCVUID_CHUCVUID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CongChucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chucVuId);

				list = (List<CongChuc>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first cong chuc in the ordered set where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByChucVuId_First(long chucVuId,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		List<CongChuc> list = findByChucVuId(chucVuId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chucVuId=");
			msg.append(chucVuId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong chuc in the ordered set where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param chucVuId the chuc vu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByChucVuId_Last(long chucVuId,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		int count = countByChucVuId(chucVuId);

		List<CongChuc> list = findByChucVuId(chucVuId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chucVuId=");
			msg.append(chucVuId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong chucs before and after the current cong chuc in the ordered set where chucVuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong chuc
	 * @param chucVuId the chuc vu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc[] findByChucVuId_PrevAndNext(long id, long chucVuId,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		CongChuc congChuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongChuc[] array = new CongChucImpl[3];

			array[0] = getByChucVuId_PrevAndNext(session, congChuc, chucVuId,
					orderByComparator, true);

			array[1] = congChuc;

			array[2] = getByChucVuId_PrevAndNext(session, congChuc, chucVuId,
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

	protected CongChuc getByChucVuId_PrevAndNext(Session session,
		CongChuc congChuc, long chucVuId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGCHUC_WHERE);

		query.append(_FINDER_COLUMN_CHUCVUID_CHUCVUID_2);

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
			query.append(CongChucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chucVuId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(congChuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongChuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cong chucs where coQuanQuanLyId = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @return the matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByCoQuanQuanLyId(long coQuanQuanLyId)
		throws SystemException {
		return findByCoQuanQuanLyId(coQuanQuanLyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong chucs where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @return the range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByCoQuanQuanLyId(long coQuanQuanLyId, int start,
		int end) throws SystemException {
		return findByCoQuanQuanLyId(coQuanQuanLyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong chucs where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByCoQuanQuanLyId(long coQuanQuanLyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID;
			finderArgs = new Object[] { coQuanQuanLyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANQUANLYID;
			finderArgs = new Object[] {
					coQuanQuanLyId,
					
					start, end, orderByComparator
				};
		}

		List<CongChuc> list = (List<CongChuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGCHUC_WHERE);

			query.append(_FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CongChucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId);

				list = (List<CongChuc>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first cong chuc in the ordered set where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByCoQuanQuanLyId_First(long coQuanQuanLyId,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		List<CongChuc> list = findByCoQuanQuanLyId(coQuanQuanLyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong chuc in the ordered set where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByCoQuanQuanLyId_Last(long coQuanQuanLyId,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		int count = countByCoQuanQuanLyId(coQuanQuanLyId);

		List<CongChuc> list = findByCoQuanQuanLyId(coQuanQuanLyId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong chucs before and after the current cong chuc in the ordered set where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong chuc
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc[] findByCoQuanQuanLyId_PrevAndNext(long id,
		long coQuanQuanLyId, OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		CongChuc congChuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongChuc[] array = new CongChucImpl[3];

			array[0] = getByCoQuanQuanLyId_PrevAndNext(session, congChuc,
					coQuanQuanLyId, orderByComparator, true);

			array[1] = congChuc;

			array[2] = getByCoQuanQuanLyId_PrevAndNext(session, congChuc,
					coQuanQuanLyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CongChuc getByCoQuanQuanLyId_PrevAndNext(Session session,
		CongChuc congChuc, long coQuanQuanLyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGCHUC_WHERE);

		query.append(_FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2);

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
			query.append(CongChucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(coQuanQuanLyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(congChuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongChuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cong chucs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByTrangThai(int daXoa) throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong chucs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @return the range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong chucs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findByTrangThai(int daXoa, int start, int end,
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

		List<CongChuc> list = (List<CongChuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CONGCHUC_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CongChucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<CongChuc>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first cong chuc in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		List<CongChuc> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cong chuc in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		int count = countByTrangThai(daXoa);

		List<CongChuc> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCongChucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cong chucs before and after the current cong chuc in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cong chuc
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong chuc
	 * @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCongChucException, SystemException {
		CongChuc congChuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CongChuc[] array = new CongChucImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, congChuc, daXoa,
					orderByComparator, true);

			array[1] = congChuc;

			array[2] = getByTrangThai_PrevAndNext(session, congChuc, daXoa,
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

	protected CongChuc getByTrangThai_PrevAndNext(Session session,
		CongChuc congChuc, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGCHUC_WHERE);

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
			query.append(CongChucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(congChuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CongChuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cong chucs.
	 *
	 * @return the cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @return the range of cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong chucs
	 * @param end the upper bound of the range of cong chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc> findAll(int start, int end,
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

		List<CongChuc> list = (List<CongChuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONGCHUC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONGCHUC.concat(CongChucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CongChuc>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CongChuc>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cong chucs where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma) throws SystemException {
		for (CongChuc congChuc : findByMa(ma)) {
			remove(congChuc);
		}
	}

	/**
	 * Removes all the cong chucs where taiKhoanNguoiDungId = &#63; from the database.
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId)
		throws SystemException {
		for (CongChuc congChuc : findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId)) {
			remove(congChuc);
		}
	}

	/**
	 * Removes all the cong chucs where chucVuId = &#63; from the database.
	 *
	 * @param chucVuId the chuc vu ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByChucVuId(long chucVuId) throws SystemException {
		for (CongChuc congChuc : findByChucVuId(chucVuId)) {
			remove(congChuc);
		}
	}

	/**
	 * Removes all the cong chucs where coQuanQuanLyId = &#63; from the database.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCoQuanQuanLyId(long coQuanQuanLyId)
		throws SystemException {
		for (CongChuc congChuc : findByCoQuanQuanLyId(coQuanQuanLyId)) {
			remove(congChuc);
		}
	}

	/**
	 * Removes all the cong chucs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (CongChuc congChuc : findByTrangThai(daXoa)) {
			remove(congChuc);
		}
	}

	/**
	 * Removes all the cong chucs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CongChuc congChuc : findAll()) {
			remove(congChuc);
		}
	}

	/**
	 * Returns the number of cong chucs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGCHUC_WHERE);

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
	 * Returns the number of cong chucs where taiKhoanNguoiDungId = &#63;.
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @return the number of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId)
		throws SystemException {
		Object[] finderArgs = new Object[] { taiKhoanNguoiDungId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGCHUC_WHERE);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanNguoiDungId.longValue());

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
	 * Returns the number of cong chucs where chucVuId = &#63;.
	 *
	 * @param chucVuId the chuc vu ID
	 * @return the number of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByChucVuId(long chucVuId) throws SystemException {
		Object[] finderArgs = new Object[] { chucVuId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CHUCVUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGCHUC_WHERE);

			query.append(_FINDER_COLUMN_CHUCVUID_CHUCVUID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chucVuId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHUCVUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong chucs where coQuanQuanLyId = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @return the number of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCoQuanQuanLyId(long coQuanQuanLyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { coQuanQuanLyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGCHUC_WHERE);

			query.append(_FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cong chucs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGCHUC_WHERE);

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
	 * Returns the number of cong chucs.
	 *
	 * @return the number of cong chucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONGCHUC);

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
	 * Initializes the cong chuc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cc.model.CongChuc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CongChuc>> listenersList = new ArrayList<ModelListener<CongChuc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CongChuc>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CongChucImpl.class.getName());
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
	private static final String _SQL_SELECT_CONGCHUC = "SELECT congChuc FROM CongChuc congChuc";
	private static final String _SQL_SELECT_CONGCHUC_WHERE = "SELECT congChuc FROM CongChuc congChuc WHERE ";
	private static final String _SQL_COUNT_CONGCHUC = "SELECT COUNT(congChuc) FROM CongChuc congChuc";
	private static final String _SQL_COUNT_CONGCHUC_WHERE = "SELECT COUNT(congChuc) FROM CongChuc congChuc WHERE ";
	private static final String _FINDER_COLUMN_MA_MA_1 = "congChuc.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "congChuc.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(congChuc.ma IS NULL OR congChuc.ma = ?)";
	private static final String _FINDER_COLUMN_TAIKHOANNGUOIDUNGID_TAIKHOANNGUOIDUNGID_2 =
		"congChuc.taiKhoanNguoiDungId = ?";
	private static final String _FINDER_COLUMN_CHUCVUID_CHUCVUID_2 = "congChuc.chucVuId = ?";
	private static final String _FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2 = "congChuc.coQuanQuanLyId = ?";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "congChuc.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "congChuc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CongChuc exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CongChuc exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CongChucPersistenceImpl.class);
	private static CongChuc _nullCongChuc = new CongChucImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CongChuc> toCacheModel() {
				return _nullCongChucCacheModel;
			}
		};

	private static CacheModel<CongChuc> _nullCongChucCacheModel = new CacheModel<CongChuc>() {
			public CongChuc toEntityModel() {
				return _nullCongChuc;
			}
		};
}