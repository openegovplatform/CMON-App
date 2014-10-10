package org.oep.egovcore.sqlutil;

import java.util.List;

public interface QueryResult<T> {
	public long getResultCount();
	public int getFetchedCount();
	public List<T> getResult();
}