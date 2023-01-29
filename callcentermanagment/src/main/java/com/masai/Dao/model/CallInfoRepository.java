package com.masai.Dao.model;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CallInfoRepository extends JpaRepository<CallInfo, Integer>{

	
	// USING  DATE  get data from a single day
	
	
	@Query("Select Hour(c.startedAt) as start,Hour(c.endedAt) as end ,Count(c) as volume From CallInfo c where DATE(c.startedAt)=date(:starttime) Group by Hour(c.startedAt)Order by volume Desc")
	public List<Object[]> longestcallbyhour(@Param("starttime") Date starttime);
	
	
	@Query("Select Hour(c.startedAt) as start From CallInfo c where DATE(c.startedAt)=date(:starttime)Order by c.startedAt, Duration Desc LIMIT 1")
	public Object highestcallbyhour(@Param("starttime") Date starttime);
	
	
	// using date get data from a date aur an another date like month , week and year 
	
	
//	@Query("Select Hour(c.startedAt) as start,Hour(c.endedAt) as end ,Count(c) as volume From CallInfo c where DATE(c.endedAt)>=date(:endedAt) AND DATE(c.startedAt)<=date(:starttime) Group by Hour(c.startedAt)Order by volume Desc")
//	public List<Object[]> longestcallbyweek(@Param("starttime")  Date starttime , @Param("endtime") Date endtime);
	
	
//	@Query("Select Hour(c.startedAt) as start From CallInfo c where DATE(c.endedAt)>=date(:endedAt) AND  DATE(c.startedAt)<=date(:starttime)Order by c.startedAt, Duration Desc LIMIT 1")
//	public Object highestcallbyweek(@Param("starttime") Date starttime , @Param("endtime") Date endtime);
//	
	
	
	// Using Normal get data from all data
	
	@Query("Select Hour(c.startedAt) as start,Hour(c.endedAt) as end,Count(c) as volume From CallInfo c Group by Hour(c.startedAt)Order by volume Desc")
	public List<Object[]> longestcallbyhournormal();
	
	@Query("Select Hour(c.startedAt) as start From CallInfo c Order by Duration Desc LIMIT 1")
	public Object highestcallbyhournormal();
	
	
	@Query("Select DAYNAME(c.startedAt) as start,Count(c) as volume From CallInfo c Group by DAYNAME(c.startedAt)Order by volume Desc")
	public List<Object[]> longestcallbyweeknormal();	
	
	@Query("Select DAYNAME(c.startedAt) as start From CallInfo c Order by Duration Desc LIMIT 1")
	public Object highestcallbyweeknormal();
	
	
	
}
