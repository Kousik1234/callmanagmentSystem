package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Dao.model.CallInfo;
import com.masai.Response.CallEndedResponse;
import com.masai.service.CallHandlerService;

import jakarta.validation.Valid;

@RestController
public class CallController {

	private CallHandlerService callHandlerService;
	
	 @Autowired
	    public CallController(CallHandlerService callHandlerService) {
	        this.callHandlerService = callHandlerService;
	    }
	 
	 
	 @PostMapping("/SaveCall")
	    public ResponseEntity<CallInfo> handleCall(@Valid @RequestBody CallInfo callInfo) {
	        CallInfo response = callHandlerService.Savedcall(callInfo);
	        return ResponseEntity.ok(response);

	    }
//	 
//	   @PostMapping("/Call")
//	    public ResponseEntity<CallResponse> Call(@Valid @RequestBody CallRequest callRequest) {
//	        CallResponse response = callHandlerService.call(callRequest);
//	        return ResponseEntity.ok(response);
//
//	    }
//	 
	
	 @GetMapping("/endcall/{Id}")
	    public ResponseEntity<CallEndedResponse> endCall(@PathVariable("Id") Integer Id) {
	        return ResponseEntity.ok(callHandlerService.endCall(Id));
	    }
	 
	 @GetMapping("/call/")
	 public ResponseEntity<String> longestcallbyhour(){
		 return ResponseEntity.ok(callHandlerService.longestcallvolumebyhour());
	 }
	 
	 @GetMapping("/week/")
	 public ResponseEntity<String> longestcallbyweek(){
		 return ResponseEntity.ok(callHandlerService.longestcallvolumebyweek());
	 }
	 
	 @GetMapping("/weekday/")
	 public ResponseEntity<String> longestcallbyweekday(){
		 return ResponseEntity.ok(callHandlerService.longestcallvolumebyweekday());
	 }
	 
}
