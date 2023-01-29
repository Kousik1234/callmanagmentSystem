package com.masai.service;

import com.masai.Dao.model.CallInfo;
import com.masai.Exception.CallCenterServiceException;

import java.sql.Date;


import com.masai.Response.CallEndedResponse;;

public interface CallHandlerService {
	
	CallInfo Savedcall(CallInfo callinfo) throws CallCenterServiceException;
	
	//CallResponse call(CallRequest callRequest) throws CallCenterServiceException;

	 CallEndedResponse endCall(Integer Id) throws CallCenterServiceException;
	 
	  // USING  DATE  get data from a single day
	 
	 
	 public String longestcallvolumebyhour(Date starttime)throws CallCenterServiceException;
	 
	 
	 public String highestcallbyhour(Date starttime) throws CallCenterServiceException;
	 
	 
	 
	// Using Normal get data from all data
	 
	 
     public String longestcallvolumebyhournormal()throws CallCenterServiceException;
	 
	 
	 public String highestcallbyhournormal() throws CallCenterServiceException;
	 
	 
	 public String longestcallvolumebyweek() throws CallCenterServiceException;
	 
	 
	 public String heighestcallvolumebyweek() throws CallCenterServiceException;
	
	
	
}
