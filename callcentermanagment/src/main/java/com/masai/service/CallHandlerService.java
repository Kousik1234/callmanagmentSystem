package com.masai.service;

import com.masai.Dao.model.CallInfo;
import com.masai.Exception.CallCenterServiceException;

import java.sql.Date;


import com.masai.Response.CallEndedResponse;;

public interface CallHandlerService {
	
	CallInfo Savedcall(CallInfo callinfo) throws CallCenterServiceException;
	
	//CallResponse call(CallRequest callRequest) throws CallCenterServiceException;

	 CallEndedResponse endCall(Integer Id) throws CallCenterServiceException;
	 
	 
	 public String longestcallvolumebyhour(Date starttime)throws CallCenterServiceException;
	 
	 
	 public String highestcallbyhour(Date starttime) throws CallCenterServiceException;
	 
	 
	 public String longestcallvolumebyweek() throws CallCenterServiceException;
	 
	 
	 public String heighestcallvolumebyweek() throws CallCenterServiceException;
	
	
	
}
