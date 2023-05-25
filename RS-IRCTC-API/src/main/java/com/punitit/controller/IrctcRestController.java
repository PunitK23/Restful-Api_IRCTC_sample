package com.punitit.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.punitit.request.PassengerRequest;
import com.punitit.response.TicketResponse;

@RestController
public class IrctcRestController {
	
	@PostMapping(
			value = "/bookticket",
			consumes = {
					"application/json",
					"application/xml"
					},
			produces = {
					"application/json",
					"application/xml"
					}
			)
	public ResponseEntity<TicketResponse> bookTicket(@RequestBody PassengerRequest request) {
		//logic to book ticket
		TicketResponse response = new TicketResponse();
		response.setStatus("confirmed");
		response.setPrice(1000.00);
		BeanUtils.copyProperties(request, response);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}

}
