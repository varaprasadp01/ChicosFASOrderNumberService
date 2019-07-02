package com.chicosfas.order.web;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chicosfas.order.config.FasServiceConfiguration;
import com.chicosfas.order.payload.FASOrderNumberServiceRequestData;
import com.chicosfas.order.payload.FASOrderNumberServiceResponseData;
import com.chicosfas.order.payload.Response;
import com.chicosfas.order.service.FASOrderNumberServiceImpl;
import com.chicosfas.order.util.FASBase;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(path = "/v1")
@Log4j2
public class FasOrderNumberServiceController extends FASBase {
	
	@Autowired
	private FASOrderNumberServiceImpl fasOrderNumberService;
	
	@ApiOperation(value = "API for Order Number Service",response = FASOrderNumberServiceResponseData.class, produces="application/json")
	 @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully returned Order Number"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="create", method = RequestMethod.POST)
	public ResponseEntity<String> genericAuthorize(@RequestBody FASOrderNumberServiceRequestData fasPayloadRequestData) {
		log.info("FasOrderNumberServiceController.java createOrderNumber Start" );
		FASOrderNumberServiceResponseData orderNumberServiceResponse = fasOrderNumberService.createOrderNumber(fasPayloadRequestData);
	 	
		if( orderNumberServiceResponse == null ) {
			orderNumberServiceResponse = new FASOrderNumberServiceResponseData();
			orderNumberServiceResponse.setSuccess(false);
		}
		
		return ResponseEntity.ok(convertObjectToJSONString(orderNumberServiceResponse));
	}
	
	
	
	
	

	
}
