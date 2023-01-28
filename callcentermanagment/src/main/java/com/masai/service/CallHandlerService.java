package com.masai.service;

import com.masai.Dao.model.CallInfo;
import com.masai.Exception.CallCenterServiceException;
import com.masai.Request.CallRequest;
import com.masai.Response.CallEndedResponse;
import com.masai.Response.CallResponse;

public interface CallHandlerService {
	
	CallInfo Savedcall(CallInfo callinfo) throws CallCenterServiceException;
	
	//CallResponse call(CallRequest callRequest) throws CallCenterServiceException;

	 CallEndedResponse endCall(Integer Id) throws CallCenterServiceException;
	 
	 
	 public String longestcallvolumebyhour()throws CallCenterServiceException;
	 
	 
	 public String longestcallvolumebyweek() throws CallCenterServiceException;
	 
	 
	 public String longestcallvolumebyweekday() throws CallCenterServiceException;
	
	
}
