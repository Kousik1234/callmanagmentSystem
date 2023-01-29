package com.masai.Dao.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface CallInfoRepository extends JpaRepository<CallInfo, Integer>{

	
	@Query("Select Hour(c.startedAt) as start,Count(c) as volume From CallInfo c Group by Hour(c.startedAt)Order by volume Desc")
	public List<Object[]> longestcallbyhour();
	
	
	@Query("Select DAYNAME(c.startedAt) as start,Count(c) as volume From CallInfo c Group by DAYNAME(c.startedAt)Order by volume Desc")
	public List<Object[]> longestcallbyweek();
	
	
	@Query("Select DAYOFWEEK(c.startedAt) as start,Count(c) as volume From CallInfo c Group by DAYOFWEEK(c.startedAt)Order by volume Desc")
	public List<Object[]> longestcallbyweekdate();
	
	
	
}
