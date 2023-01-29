package com.masai.Controller;


import java.sql.Date;


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

	
	 @GetMapping("/endcall/{Id}")
	    public ResponseEntity<CallEndedResponse> endCall(@PathVariable("Id") Integer Id) {
	        return ResponseEntity.ok(callHandlerService.endCall(Id));
	    }
	 
	 @GetMapping("/call/{starttime}")
	 public ResponseEntity<String> longestcallbyhour(@PathVariable("starttime") Date starttime){
		 return ResponseEntity.ok(callHandlerService.longestcallvolumebyhour(starttime));
	 }
	 
	 
	 @GetMapping("/calls/{starttime}")
	 public ResponseEntity<String> heighestcallbyhour(@PathVariable("starttime") Date starttime){
		 return ResponseEntity.ok(callHandlerService.highestcallbyhour(starttime));
	 }
	 
	 
	 @GetMapping("/callnormal/")
	 public ResponseEntity<String> longestcallbyhournormal(){
		 return ResponseEntity.ok(callHandlerService.longestcallvolumebyhournormal());
	 }
	 
	 
	 @GetMapping("/callsnormal/")
	 public ResponseEntity<String> heighestcallbyhournormal(){
		 return ResponseEntity.ok(callHandlerService.highestcallbyhournormal());
	 }
	 
	 
	 
	 @GetMapping("/week/")
	 public ResponseEntity<String> longestcallbyweek(){
		 return ResponseEntity.ok(callHandlerService.longestcallvolumebyweek());
	 }
	 
	 
	 @GetMapping("/weekh/")
	 public ResponseEntity<String> heighestcallbyweek(){
		 return ResponseEntity.ok(callHandlerService.heighestcallvolumebyweek());
	 }
	 
}
