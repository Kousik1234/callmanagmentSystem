package com.masai.service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.masai.Dao.model.CallInfo;
import com.masai.Dao.model.CallInfoRepository;
import com.masai.Exception.CallCenterServiceException;
import com.masai.Response.CallEndedResponse;





@Service
public class CallHandlerServiceImpl implements CallHandlerService{
	
     @Autowired
	 private CallInfoRepository callInfoRepository;
	
//	 @Autowired
//	    public CallHandlerServiceImpl( CallInfoRepository callInfoRepository) {
//	        this.callInfoRepository = callInfoRepository;
//	    }

	
	 @Override
		public CallInfo Savedcall(CallInfo callinfo) throws CallCenterServiceException {
			
		 
		 // create call info object in the db
		 
		  callinfo.setStartedAt(Instant.now());
	       
	       
	        CallInfo savedCallInfo = callInfoRepository.save(callinfo);
	      
	        return savedCallInfo;
		 
		 
		 
		}


	
	 
	 
	
	@Override
	public CallEndedResponse endCall(Integer Id) throws CallCenterServiceException {
		
		 CallInfo callInfo = new CallInfo();
		 
		 callInfo = callInfoRepository.findById(Id).orElseThrow(() -> new CallCenterServiceException("callInfoId does not exist", HttpStatus.NOT_FOUND));
		
		 callInfo.setEndedAt(Instant.now());
		 
		// callInfo.setDate(callRequest.getDate());
		 
		 
		 if(callInfo.getStartedAt() != null && callInfo.getEndedAt() != null) {
	            callInfo.setDuration(String.format("%d seconds", Duration.between(callInfo.getStartedAt(), callInfo.getEndedAt()).toSeconds()));
	        }		 
		 
		 
		 
//		 Date d1=
//		 
//		 if(callInfo.getStartedAt() != null && callInfo.getEndedAt() != null) {
//            callInfo.setDuration((callInfo.get))-(callInfo.getEndedAt()).toSeconds());
//		 }
////		 
//		 
		 callInfoRepository.save(callInfo);
		 
		 return toCallEndedResponse(callInfo);
		// return callInfo;
	}


	    private CallEndedResponse toCallEndedResponse(CallInfo callInfo) {
	        CallEndedResponse callEndedResponse = new CallEndedResponse();
	        callEndedResponse.setFrom_Number(callInfo.getFrom_Number());
	        

	        if(callInfo.getStartedAt() != null && callInfo.getEndedAt() != null) {
	            callEndedResponse.setDuration(String.format("%d seconds", Duration.between(callInfo.getStartedAt(), callInfo.getEndedAt()).toSeconds()));
	        }
	        return callEndedResponse;
	    }


		@Override
		public String longestcallvolumebyhour() throws CallCenterServiceException {
			// TODO Auto-generated method stub
			
			List<Object[]> list=callInfoRepository.longestcallbyhour();
			
			if(list==null) {
				throw new CallCenterServiceException("data not found");
			}
			 Object[] data=list.get(0);
			Integer start=(int)data[0];
			
			if(start==0) {
				return "Hour of the day when call volume is longest is 12-1 AM";
			}
			if(start>=1 && start<=11) {
				return "Hour of the day when call volume is longest is "+start+"AM -"+(start+1)+" AM";
			}
			if(start==11) {
				return "Hour of the day when the call volume is longest is "+start+"AM - "+(start+1);
			}
			else {
				return"Hour of the day when the call volume is longest is "+(start-12)+"-"+(start-11)+" PM";
			}
			
		}


		@Override
		public String longestcallvolumebyweek() throws CallCenterServiceException {
			
			
			List<Object[]> list=callInfoRepository.longestcallbyweek();
			if(list==null) {
				throw new CallCenterServiceException("Data not Found");
			}
			
			Object[] data=list.get(0);
			
			String day=(String)data[0];
			
			return "Day of the week the call volume is longest is "+day;
			
			
		}


		@Override
		public String longestcallvolumebyweekday() throws CallCenterServiceException {
			List<Object[]> list=callInfoRepository.longestcallbyweekdate();
			if(list==null) {
				throw new CallCenterServiceException("Data not Found");
			}
			
			Object[] data=list.get(0);
			
			Integer day=(int)data[0];
			
			return "Day of the week the call volume is longest is "+day;
			
		}


		
	}



