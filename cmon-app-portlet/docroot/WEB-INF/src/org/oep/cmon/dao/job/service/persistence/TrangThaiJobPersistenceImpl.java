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

import org.oep.cmon.dao.job.NoSuchTrangThaiJobException;
import org.oep.cmon.dao.job.model.TrangThaiJob;
import org.oep.cmon.dao.job.model.impl.TrangThaiJobImpl;
import org.oep.cmon.dao.job.model.impl.TrangThaiJobModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the trang thai job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see TrangThaiJobPersistence
 * @see TrangThaiJobUtil
 * @generated
 */
public class TrangThaiJobPersistenceImpl extends BasePersistenceImpl<TrangThaiJob>
	implements TrangThaiJobPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrangThaiJobUtil} to access the trang thai job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrangThaiJobImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBID = new FinderPath(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiJobModelImpl.FINDER_CACHE_ENABLED, TrangThaiJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBID = new FinderPath(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiJobModelImpl.FINDER_CACHE_ENABLED, TrangThaiJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJobId",
			new String[] { Integer.class.getName() },
			TrangThaiJobModelImpl.JOBID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBID = new FinderPath(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiJobModelImpl.FINDER_CACHE_ENABLED, TrangThaiJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiJobModelImpl.FINDER_CACHE_ENABLED, TrangThaiJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the trang thai job in the entity cache if it is enabled.
	 *
	 * @param trangThaiJob the trang thai job
	 */
	public void cacheResult(TrangThaiJob trangThaiJob) {
		EntityCacheUtil.putResult(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiJobImpl.class, trangThaiJob.getPrimaryKey(), trangThaiJob);

		trangThaiJob.resetOriginalValues();
	}

	/**
	 * Caches the trang thai jobs in the entity cache if it is enabled.
	 *
	 * @param trangThaiJobs the trang thai jobs
	 */
	public void cacheResult(List<TrangThaiJob> trangThaiJobs) {
		for (TrangThaiJob trangThaiJob : trangThaiJobs) {
			if (EntityCacheUtil.getResult(
						TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiJobImpl.class, trangThaiJob.getPrimaryKey()) == null) {
				cacheResult(trangThaiJob);
			}
			else {
				trangThaiJob.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trang thai jobs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrangThaiJobImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrangThaiJobImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trang thai job.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrangThaiJob trangThaiJob) {
		EntityCacheUtil.removeResult(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiJobImpl.class, trangThaiJob.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TrangThaiJob> trangThaiJobs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrangThaiJob trangThaiJob : trangThaiJobs) {
			EntityCacheUtil.removeResult(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiJobImpl.class, trangThaiJob.getPrimaryKey());
		}
	}

	/**
	 * Creates a new trang thai job with the primary key. Does not add the trang thai job to the database.
	 *
	 * @param ID the primary key for the new trang thai job
	 * @return the new trang thai job
	 */
	public TrangThaiJob create(long ID) {
		TrangThaiJob trangThaiJob = new TrangThaiJobImpl();

		trangThaiJob.setNew(true);
		trangThaiJob.setPrimaryKey(ID);

		return trangThaiJob;
	}

	/**
	 * Removes the trang thai job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the trang thai job
	 * @return the trang thai job that was removed
	 * @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a trang thai job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiJob remove(long ID)
		throws NoSuchTrangThaiJobException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the trang thai job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trang thai job
	 * @return the trang thai job that was removed
	 * @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a trang thai job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiJob remove(Serializable primaryKey)
		throws NoSuchTrangThaiJobException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TrangThaiJob trangThaiJob = (TrangThaiJob)session.get(TrangThaiJobImpl.class,
					primaryKey);

			if (trangThaiJob == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrangThaiJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trangThaiJob);
		}
		catch (NoSuchTrangThaiJobException nsee) {
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
	protected TrangThaiJob removeImpl(TrangThaiJob trangThaiJob)
		throws SystemException {
		trangThaiJob = toUnwrappedModel(trangThaiJob);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, trangThaiJob);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(trangThaiJob);

		return trangThaiJob;
	}

	@Override
	public TrangThaiJob updateImpl(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob, boolean merge)
		throws SystemException {
		trangThaiJob = toUnwrappedModel(trangThaiJob);

		boolean isNew = trangThaiJob.isNew();

		TrangThaiJobModelImpl trangThaiJobModelImpl = (TrangThaiJobModelImpl)trangThaiJob;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, trangThaiJob, merge);

			trangThaiJob.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrangThaiJobModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trangThaiJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(trangThaiJobModelImpl.getOriginalJobId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBID,
					args);

				args = new Object[] {
						Integer.valueOf(trangThaiJobModelImpl.getJobId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBID,
					args);
			}
		}

		EntityCacheUtil.putResult(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiJobImpl.class, trangThaiJob.getPrimaryKey(), trangThaiJob);

		return trangThaiJob;
	}

	protected TrangThaiJob toUnwrappedModel(TrangThaiJob trangThaiJob) {
		if (trangThaiJob instanceof TrangThaiJobImpl) {
			return trangThaiJob;
		}

		TrangThaiJobImpl trangThaiJobImpl = new TrangThaiJobImpl();

		trangThaiJobImpl.setNew(trangThaiJob.isNew());
		trangThaiJobImpl.setPrimaryKey(trangThaiJob.getPrimaryKey());

		trangThaiJobImpl.setID(trangThaiJob.getID());
		trangThaiJobImpl.setJobId(trangThaiJob.getJobId());
		trangThaiJobImpl.setJobName(trangThaiJob.getJobName());
		trangThaiJobImpl.setStartTime(trangThaiJob.getStartTime());
		trangThaiJobImpl.setEndTime(trangThaiJob.getEndTime());
		trangThaiJobImpl.setStatus(trangThaiJob.getStatus());
		trangThaiJobImpl.setRunMode(trangThaiJob.getRunMode());
		trangThaiJobImpl.setMessage(trangThaiJob.getMessage());

		return trangThaiJobImpl;
	}

	/**
	 * Returns the trang thai job with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai job
	 * @return the trang thai job
	 * @throws com.liferay.portal.NoSuchModelException if a trang thai job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiJob findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trang thai job with the primary key or throws a {@link org.oep.cmon.dao.job.NoSuchTrangThaiJobException} if it could not be found.
	 *
	 * @param ID the primary key of the trang thai job
	 * @return the trang thai job
	 * @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a trang thai job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiJob findByPrimaryKey(long ID)
		throws NoSuchTrangThaiJobException, SystemException {
		TrangThaiJob trangThaiJob = fetchByPrimaryKey(ID);

		if (trangThaiJob == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchTrangThaiJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return trangThaiJob;
	}

	/**
	 * Returns the trang thai job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai job
	 * @return the trang thai job, or <code>null</code> if a trang thai job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiJob fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trang thai job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the trang thai job
	 * @return the trang thai job, or <code>null</code> if a trang thai job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiJob fetchByPrimaryKey(long ID) throws SystemException {
		TrangThaiJob trangThaiJob = (TrangThaiJob)EntityCacheUtil.getResult(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiJobImpl.class, ID);

		if (trangThaiJob == _nullTrangThaiJob) {
			return null;
		}

		if (trangThaiJob == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				trangThaiJob = (TrangThaiJob)session.get(TrangThaiJobImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (trangThaiJob != null) {
					cacheResult(trangThaiJob);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TrangThaiJobModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiJobImpl.class, ID, _nullTrangThaiJob);
				}

				closeSession(session);
			}
		}

		return trangThaiJob;
	}

	/**
	 * Returns all the trang thai jobs where JobId = &#63;.
	 *
	 * @param JobId the job ID
	 * @return the matching trang thai jobs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiJob> findByJobId(int JobId) throws SystemException {
		return findByJobId(JobId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trang thai jobs where JobId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param JobId the job ID
	 * @param start the lower bound of the range of trang thai jobs
	 * @param end the upper bound of the range of trang thai jobs (not inclusive)
	 * @return the range of matching trang thai jobs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiJob> findByJobId(int JobId, int start, int end)
		throws SystemException {
		return findByJobId(JobId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai jobs where JobId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param JobId the job ID
	 * @param start the lower bound of the range of trang thai jobs
	 * @param end the upper bound of the range of trang thai jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trang thai jobs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiJob> findByJobId(int JobId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBID;
			finderArgs = new Object[] { JobId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBID;
			finderArgs = new Object[] { JobId, start, end, orderByComparator };
		}

		List<TrangThaiJob> list = (List<TrangThaiJob>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TRANGTHAIJOB_WHERE);

			query.append(_FINDER_COLUMN_JOBID_JOBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TrangThaiJobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(JobId);

				list = (List<TrangThaiJob>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first trang thai job in the ordered set where JobId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param JobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai job
	 * @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a matching trang thai job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiJob findByJobId_First(int JobId,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiJobException, SystemException {
		List<TrangThaiJob> list = findByJobId(JobId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("JobId=");
			msg.append(JobId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrangThaiJobException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last trang thai job in the ordered set where JobId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param JobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai job
	 * @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a matching trang thai job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiJob findByJobId_Last(int JobId,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiJobException, SystemException {
		int count = countByJobId(JobId);

		List<TrangThaiJob> list = findByJobId(JobId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("JobId=");
			msg.append(JobId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrangThaiJobException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the trang thai jobs before and after the current trang thai job in the ordered set where JobId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ID the primary key of the current trang thai job
	 * @param JobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trang thai job
	 * @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a trang thai job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiJob[] findByJobId_PrevAndNext(long ID, int JobId,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiJobException, SystemException {
		TrangThaiJob trangThaiJob = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			TrangThaiJob[] array = new TrangThaiJobImpl[3];

			array[0] = getByJobId_PrevAndNext(session, trangThaiJob, JobId,
					orderByComparator, true);

			array[1] = trangThaiJob;

			array[2] = getByJobId_PrevAndNext(session, trangThaiJob, JobId,
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

	protected TrangThaiJob getByJobId_PrevAndNext(Session session,
		TrangThaiJob trangThaiJob, int JobId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANGTHAIJOB_WHERE);

		query.append(_FINDER_COLUMN_JOBID_JOBID_2);

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
			query.append(TrangThaiJobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(JobId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trangThaiJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrangThaiJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the trang thai jobs.
	 *
	 * @return the trang thai jobs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiJob> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trang thai jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai jobs
	 * @param end the upper bound of the range of trang thai jobs (not inclusive)
	 * @return the range of trang thai jobs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiJob> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai jobs
	 * @param end the upper bound of the range of trang thai jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trang thai jobs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiJob> findAll(int start, int end,
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

		List<TrangThaiJob> list = (List<TrangThaiJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANGTHAIJOB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANGTHAIJOB.concat(TrangThaiJobModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TrangThaiJob>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TrangThaiJob>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the trang thai jobs where JobId = &#63; from the database.
	 *
	 * @param JobId the job ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByJobId(int JobId) throws SystemException {
		for (TrangThaiJob trangThaiJob : findByJobId(JobId)) {
			remove(trangThaiJob);
		}
	}

	/**
	 * Removes all the trang thai jobs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TrangThaiJob trangThaiJob : findAll()) {
			remove(trangThaiJob);
		}
	}

	/**
	 * Returns the number of trang thai jobs where JobId = &#63;.
	 *
	 * @param JobId the job ID
	 * @return the number of matching trang thai jobs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByJobId(int JobId) throws SystemException {
		Object[] finderArgs = new Object[] { JobId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_JOBID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAIJOB_WHERE);

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
	 * Returns the number of trang thai jobs.
	 *
	 * @return the number of trang thai jobs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRANGTHAIJOB);

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
	 * Initializes the trang thai job persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.job.model.TrangThaiJob")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TrangThaiJob>> listenersList = new ArrayList<ModelListener<TrangThaiJob>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TrangThaiJob>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TrangThaiJobImpl.class.getName());
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
	private static final String _SQL_SELECT_TRANGTHAIJOB = "SELECT trangThaiJob FROM TrangThaiJob trangThaiJob";
	private static final String _SQL_SELECT_TRANGTHAIJOB_WHERE = "SELECT trangThaiJob FROM TrangThaiJob trangThaiJob WHERE ";
	private static final String _SQL_COUNT_TRANGTHAIJOB = "SELECT COUNT(trangThaiJob) FROM TrangThaiJob trangThaiJob";
	private static final String _SQL_COUNT_TRANGTHAIJOB_WHERE = "SELECT COUNT(trangThaiJob) FROM TrangThaiJob trangThaiJob WHERE ";
	private static final String _FINDER_COLUMN_JOBID_JOBID_2 = "trangThaiJob.JobId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trangThaiJob.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrangThaiJob exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrangThaiJob exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrangThaiJobPersistenceImpl.class);
	private static TrangThaiJob _nullTrangThaiJob = new TrangThaiJobImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrangThaiJob> toCacheModel() {
				return _nullTrangThaiJobCacheModel;
			}
		};

	private static CacheModel<TrangThaiJob> _nullTrangThaiJobCacheModel = new CacheModel<TrangThaiJob>() {
			public TrangThaiJob toEntityModel() {
				return _nullTrangThaiJob;
			}
		};
}