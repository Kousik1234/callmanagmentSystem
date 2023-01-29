package com.masai.Dao.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CallInfoRepository extends JpaRepository<CallInfo, Integer>{

	
	
	
	
	@Query("Select Hour(c.startedAt) as start,Hour(c.endedAt) as end ,Count(c) as volume From CallInfo c where DATE(c.startedAt)=date(:starttime) Group by Hour(c.startedAt)Order by volume Desc")
	public List<Object[]> longestcallbyhour(@Param("starttime") Date starttime);
	
	
//	@Query("Select Hour(c.startedAt) as start,Count(c) as volume From CallInfo c Group by Hour(c.startedAt)Order by volume Desc LIMIT 1")
//	public Object longestcallbyhour();
	
	
	@Query("Select DAYNAME(c.startedAt) as start,Count(c) as volume From CallInfo c Group by DAYNAME(c.startedAt)Order by volume Desc")
	public List<Object[]> longestcallbyweek();
	
	
	
//	@Query("Select Hour(c.startedAt) as start From CallInfo c Order by Duration Desc LIMIT 1")
//	public Object highestcallbyhour();
	
	
	@Query("Select Hour(c.startedAt) as start From CallInfo c where DATE(c.startedAt)=date(:starttime)Order by c.startedAt, Duration Desc LIMIT 1")
	public Object highestcallbyhour(@Param("starttime") Date starttime);
	
	
	@Query("Select DAYNAME(c.startedAt) as start From CallInfo c Order by Duration Desc LIMIT 1")
	public Object highestcallbyweek();
	
	
	
}
