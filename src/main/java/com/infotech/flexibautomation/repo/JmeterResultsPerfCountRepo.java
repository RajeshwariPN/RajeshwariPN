package com.infotech.flexibautomation.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infotech.flexibautomation.entity.JmeterResults;

public interface JmeterResultsPerfCountRepo extends JpaRepository<JmeterResults, Integer> {

	@Query("select count(*) from JmeterResults jm where  jm.dateExecuted between ( :fromDate ) and  ( :toDate )")
	public Integer getTotalCount(Date fromDate, Date toDate);

	@Query("select count(*) from JmeterResults jm where jm.error >= 5 and jm.dateExecuted between ( :fromDate ) and  ( :toDate )")
	public Integer getFailedCount(Date fromDate, Date toDate);

	@Query("select count(*) from JmeterResults jm where jm.error < 5 and jm.dateExecuted between ( :fromDate ) and  ( :toDate )")
	public Integer getPassedCount(Date fromDate, Date toDate);

}
