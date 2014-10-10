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

package org.oep.cmon.dao.job.service.persistence;

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

import org.oep.cmon.dao.job.NoSuchDanhSachJobException;
import org.oep.cmon.dao.job.model.DanhSachJob;
import org.oep.cmon.dao.job.model.impl.DanhSachJobImpl;
import org.oep.cmon.dao.job.model.impl.DanhSachJobModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the danh sach job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see DanhSachJobPersistence
 * @see DanhSachJobUtil
 * @generated
 */
public class DanhSachJobPersistenceImpl extends BasePersistenceImpl<DanhSachJob>
	implements DanhSachJobPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DanhSachJobUtil} to access the danh sach job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DanhSachJobImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_JOBCLASS = new FinderPath(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobModelImpl.FINDER_CACHE_ENABLED, DanhSachJobImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByJobClass",
			new String[] { String.class.getName() },
			DanhSachJobModelImpl.JOBCLASS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBCLASS = new FinderPath(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobClass",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_JOBID = new FinderPath(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobModelImpl.FINDER_CACHE_ENABLED, DanhSachJobImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByJobId",
			new String[] { Integer.class.getName() },
			DanhSachJobModelImpl.JOBID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBID = new FinderPath(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobModelImpl.FINDER_CACHE_ENABLED, DanhSachJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobModelImpl.FINDER_CACHE_ENABLED, DanhSachJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the danh sach job in the entity cache if it is enabled.
	 *
	 * @param danhSachJob the danh sach job
	 */
	public void cacheResult(DanhSachJob danhSachJob) {
		EntityCacheUtil.putResult(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobImpl.class, danhSachJob.getPrimaryKey(), danhSachJob);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBCLASS,
			new Object[] { danhSachJob.getJobClass() }, danhSachJob);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID,
			new Object[] { Integer.valueOf(danhSachJob.getJobId()) },
			danhSachJob);

		danhSachJob.resetOriginalValues();
	}

	/**
	 * Caches the danh sach jobs in the entity cache if it is enabled.
	 *
	 * @param danhSachJobs the danh sach jobs
	 */
	public void cacheResult(List<DanhSachJob> danhSachJobs) {
		for (DanhSachJob danhSachJob : danhSachJobs) {
			if (EntityCacheUtil.getResult(
						DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
						DanhSachJobImpl.class, danhSachJob.getPrimaryKey()) == null) {
				cacheResult(danhSachJob);
			}
			else {
				danhSachJob.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all danh sach jobs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DanhSachJobImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DanhSachJobImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the danh sach job.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DanhSachJob danhSachJob) {
		EntityCacheUtil.removeResult(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobImpl.class, danhSachJob.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(danhSachJob);
	}

	@Override
	public void clearCache(List<DanhSachJob> danhSachJobs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanhSachJob danhSachJob : danhSachJobs) {
			EntityCacheUtil.removeResult(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
				DanhSachJobImpl.class, danhSachJob.getPrimaryKey());

			clearUniqueFindersCache(danhSachJob);
		}
	}

	protected void clearUniqueFindersCache(DanhSachJob danhSachJob) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBCLASS,
			new Object[] { danhSachJob.getJobClass() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBID,
			new Object[] { Integer.valueOf(danhSachJob.getJobId()) });
	}

	/**
	 * Creates a new danh sach job with the primary key. Does not add the danh sach job to the database.
	 *
	 * @param ID the primary key for the new danh sach job
	 * @return the new danh sach job
	 */
	public DanhSachJob create(long ID) {
		DanhSachJob danhSachJob = new DanhSachJobImpl();

		danhSachJob.setNew(true);
		danhSachJob.setPrimaryKey(ID);

		return danhSachJob;
	}

	/**
	 * Removes the danh sach job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the danh sach job
	 * @return the danh sach job that was removed
	 * @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a danh sach job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachJob remove(long ID)
		throws NoSuchDanhSachJobException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the danh sach job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the danh sach job
	 * @return the danh sach job that was removed
	 * @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a danh sach job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachJob remove(Serializable primaryKey)
		throws NoSuchDanhSachJobException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DanhSachJob danhSachJob = (DanhSachJob)session.get(DanhSachJobImpl.class,
					primaryKey);

			if (danhSachJob == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanhSachJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(danhSachJob);
		}
		catch (NoSuchDanhSachJobException nsee) {
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
	protected DanhSachJob removeImpl(DanhSachJob danhSachJob)
		throws SystemException {
		danhSachJob = toUnwrappedModel(danhSachJob);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, danhSachJob);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(danhSachJob);

		return danhSachJob;
	}

	@Override
	public DanhSachJob updateImpl(
		org.oep.cmon.dao.job.model.DanhSachJob danhSachJob, boolean merge)
		throws SystemException {
		danhSachJob = toUnwrappedModel(danhSachJob);

		boolean isNew = danhSachJob.isNew();

		DanhSachJobModelImpl danhSachJobModelImpl = (DanhSachJobModelImpl)danhSachJob;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, danhSachJob, merge);

			danhSachJob.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DanhSachJobModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachJobImpl.class, danhSachJob.getPrimaryKey(), danhSachJob);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBCLASS,
				new Object[] { danhSachJob.getJobClass() }, danhSachJob);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID,
				new Object[] { Integer.valueOf(danhSachJob.getJobId()) },
				danhSachJob);
		}
		else {
			if ((danhSachJobModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_JOBCLASS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						danhSachJobModelImpl.getOriginalJobClass()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBCLASS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBCLASS, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBCLASS,
					new Object[] { danhSachJob.getJobClass() }, danhSachJob);
			}

			if ((danhSachJobModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_JOBID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(danhSachJobModelImpl.getOriginalJobId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID,
					new Object[] { Integer.valueOf(danhSachJob.getJobId()) },
					danhSachJob);
			}
		}

		return danhSachJob;
	}

	protected DanhSachJob toUnwrappedModel(DanhSachJob danhSachJob) {
		if (danhSachJob instanceof DanhSachJobImpl) {
			return danhSachJob;
		}

		DanhSachJobImpl danhSachJobImpl = new DanhSachJobImpl();

		danhSachJobImpl.setNew(danhSachJob.isNew());
		danhSachJobImpl.setPrimaryKey(danhSachJob.getPrimaryKey());

		danhSachJobImpl.setID(danhSachJob.getID());
		danhSachJobImpl.setJobClass(danhSachJob.getJobClass());
		danhSachJobImpl.setJobId(danhSachJob.getJobId());
		danhSachJobImpl.setJobName(danhSachJob.getJobName());
		danhSachJobImpl.setDescription(danhSachJob.getDescription());

		return danhSachJobImpl;
	}

	/**
	 * Returns the danh sach job with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh sach job
	 * @return the danh sach job
	 * @throws com.liferay.portal.NoSuchModelException if a danh sach job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachJob findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh sach job with the primary key or throws a {@link org.oep.cmon.dao.job.NoSuchDanhSachJobException} if it could not be found.
	 *
	 * @param ID the primary key of the danh sach job
	 * @return the danh sach job
	 * @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a danh sach job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachJob findByPrimaryKey(long ID)
		throws NoSuchDanhSachJobException, SystemException {
		DanhSachJob danhSachJob = fetchByPrimaryKey(ID);

		if (danhSachJob == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchDanhSachJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return danhSachJob;
	}

	/**
	 * Returns the danh sach job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh sach job
	 * @return the danh sach job, or <code>null</code> if a danh sach job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachJob fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh sach job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the danh sach job
	 * @return the danh sach job, or <code>null</code> if a danh sach job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachJob fetchByPrimaryKey(long ID) throws SystemException {
		DanhSachJob danhSachJob = (DanhSachJob)EntityCacheUtil.getResult(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
				DanhSachJobImpl.class, ID);

		if (danhSachJob == _nullDanhSachJob) {
			return null;
		}

		if (danhSachJob == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				danhSachJob = (DanhSachJob)session.get(DanhSachJobImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (danhSachJob != null) {
					cacheResult(danhSachJob);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DanhSachJobModelImpl.ENTITY_CACHE_ENABLED,
						DanhSachJobImpl.class, ID, _nullDanhSachJob);
				}

				closeSession(session);
			}
		}

		return danhSachJob;
	}

	/**
	 * Returns the danh sach job where JobClass = &#63; or throws a {@link org.oep.cmon.dao.job.NoSuchDanhSachJobException} if it could not be found.
	 *
	 * @param JobClass the job class
	 * @return the matching danh sach job
	 * @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a matching danh sach job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachJob findByJobClass(String JobClass)
		throws NoSuchDanhSachJobException, SystemException {
		DanhSachJob danhSachJob = fetchByJobClass(JobClass);

		if (danhSachJob == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("JobClass=");
			msg.append(JobClass);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDanhSachJobException(msg.toString());
		}

		return danhSachJob;
	}

	/**
	 * Returns the danh sach job where JobClass = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param JobClass the job class
	 * @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachJob fetchByJobClass(String JobClass)
		throws SystemException {
		return fetchByJobClass(JobClass, true);
	}

	/**
	 * Returns the danh sach job where JobClass = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param JobClass the job class
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachJob fetchByJobClass(String JobClass,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { JobClass };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_JOBCLASS,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_DANHSACHJOB_WHERE);

			if (JobClass == null) {
				query.append(_FINDER_COLUMN_JOBCLASS_JOBCLASS_1);
			}
			else {
				if (JobClass.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_JOBCLASS_JOBCLASS_3);
				}
				else {
					query.append(_FINDER_COLUMN_JOBCLASS_JOBCLASS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (JobClass != null) {
					qPos.add(JobClass);
				}

				List<DanhSachJob> list = q.list();

				result = list;

				DanhSachJob danhSachJob = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBCLASS,
						finderArgs, list);
				}
				else {
					danhSachJob = list.get(0);

					cacheResult(danhSachJob);

					if ((danhSachJob.getJobClass() == null) ||
							!danhSachJob.getJobClass().equals(JobClass)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBCLASS,
							finderArgs, danhSachJob);
					}
				}

				return danhSachJob;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBCLASS,
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
				return (DanhSachJob)result;
			}
		}
	}

	/**
	 * Returns the danh sach job where JobId = &#63; or throws a {@link org.oep.cmon.dao.job.NoSuchDanhSachJobException} if it could not be found.
	 *
	 * @param JobId the job ID
	 * @return the matching danh sach job
	 * @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a matching danh sach job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachJob findByJobId(int JobId)
		throws NoSuchDanhSachJobException, SystemException {
		DanhSachJob danhSachJob = fetchByJobId(JobId);

		if (danhSachJob == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("JobId=");
			msg.append(JobId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDanhSachJobException(msg.toString());
		}

		return danhSachJob;
	}

	/**
	 * Returns the danh sach job where JobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param JobId the job ID
	 * @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachJob fetchByJobId(int JobId) throws SystemException {
		return fetchByJobId(JobId, true);
	}

	/**
	 * Returns the danh sach job where JobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param JobId the job ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachJob fetchByJobId(int JobId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { JobId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_JOBID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_DANHSACHJOB_WHERE);

			query.append(_FINDER_COLUMN_JOBID_JOBID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(JobId);

				List<DanhSachJob> list = q.list();

				result = list;

				DanhSachJob danhSachJob = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID,
						finderArgs, list);
				}
				else {
					danhSachJob = list.get(0);

					cacheResult(danhSachJob);

					if ((danhSachJob.getJobId() != JobId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID,
							finderArgs, danhSachJob);
					}
				}

				return danhSachJob;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBID,
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
				return (DanhSachJob)result;
			}
		}
	}

	/**
	 * Returns all the danh sach jobs.
	 *
	 * @return the danh sach jobs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachJob> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh sach jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh sach jobs
	 * @param end the upper bound of the range of danh sach jobs (not inclusive)
	 * @return the range of danh sach jobs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachJob> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh sach jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh sach jobs
	 * @param end the upper bound of the range of danh sach jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh sach jobs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachJob> findAll(int start, int end,
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

		List<DanhSachJob> list = (List<DanhSachJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DANHSACHJOB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANHSACHJOB;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DanhSachJob>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DanhSachJob>)QueryUtil.list(q, getDialect(),
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
	 * Removes the danh sach job where JobClass = &#63; from the database.
	 *
	 * @param JobClass the job class
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByJobClass(String JobClass)
		throws NoSuchDanhSachJobException, SystemException {
		DanhSachJob danhSachJob = findByJobClass(JobClass);

		remove(danhSachJob);
	}

	/**
	 * Removes the danh sach job where JobId = &#63; from the database.
	 *
	 * @param JobId the job ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByJobId(int JobId)
		throws NoSuchDanhSachJobException, SystemException {
		DanhSachJob danhSachJob = findByJobId(JobId);

		remove(danhSachJob);
	}

	/**
	 * Removes all the danh sach jobs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DanhSachJob danhSachJob : findAll()) {
			remove(danhSachJob);
		}
	}

	/**
	 * Returns the number of danh sach jobs where JobClass = &#63;.
	 *
	 * @param JobClass the job class
	 * @return the number of matching danh sach jobs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByJobClass(String JobClass) throws SystemException {
		Object[] finderArgs = new Object[] { JobClass };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_JOBCLASS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHSACHJOB_WHERE);

			if (JobClass == null) {
				query.append(_FINDER_COLUMN_JOBCLASS_JOBCLASS_1);
			}
			else {
				if (JobClass.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_JOBCLASS_JOBCLASS_3);
				}
				else {
					query.append(_FINDER_COLUMN_JOBCLASS_JOBCLASS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (JobClass != null) {
					qPos.add(JobClass);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOBCLASS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of danh sach jobs where JobId = &#63;.
	 *
	 * @param JobId the job ID
	 * @return the number of matching danh sach jobs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByJobId(int JobId) throws SystemException {
		Object[] finderArgs = new Object[] { JobId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_JOBID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHSACHJOB_WHERE);

			query.append(_FINDER_COLUMN_JOBID_JOBID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(JobId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOBID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of danh sach jobs.
	 *
	 * @return the number of danh sach jobs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANHSACHJOB);

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
	 * Initializes the danh sach job persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.job.model.DanhSachJob")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DanhSachJob>> listenersList = new ArrayList<ModelListener<DanhSachJob>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DanhSachJob>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DanhSachJobImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DanhSachJobPersistence.class)
	protected DanhSachJobPersistence danhSachJobPersistence;
	@BeanReference(type = LogMailPersistence.class)
	protected LogMailPersistence logMailPersistence;
	@BeanReference(type = TrangThaiJobPersistence.class)
	protected TrangThaiJobPersistence trangThaiJobPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_DANHSACHJOB = "SELECT danhSachJob FROM DanhSachJob danhSachJob";
	private static final String _SQL_SELECT_DANHSACHJOB_WHERE = "SELECT danhSachJob FROM DanhSachJob danhSachJob WHERE ";
	private static final String _SQL_COUNT_DANHSACHJOB = "SELECT COUNT(danhSachJob) FROM DanhSachJob danhSachJob";
	private static final String _SQL_COUNT_DANHSACHJOB_WHERE = "SELECT COUNT(danhSachJob) FROM DanhSachJob danhSachJob WHERE ";
	private static final String _FINDER_COLUMN_JOBCLASS_JOBCLASS_1 = "danhSachJob.JobClass IS NULL";
	private static final String _FINDER_COLUMN_JOBCLASS_JOBCLASS_2 = "danhSachJob.JobClass = ?";
	private static final String _FINDER_COLUMN_JOBCLASS_JOBCLASS_3 = "(danhSachJob.JobClass IS NULL OR danhSachJob.JobClass = ?)";
	private static final String _FINDER_COLUMN_JOBID_JOBID_2 = "danhSachJob.JobId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "danhSachJob.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DanhSachJob exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DanhSachJob exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DanhSachJobPersistenceImpl.class);
	private static DanhSachJob _nullDanhSachJob = new DanhSachJobImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DanhSachJob> toCacheModel() {
				return _nullDanhSachJobCacheModel;
			}
		};

	private static CacheModel<DanhSachJob> _nullDanhSachJobCacheModel = new CacheModel<DanhSachJob>() {
			public DanhSachJob toEntityModel() {
				return _nullDanhSachJob;
			}
		};
}