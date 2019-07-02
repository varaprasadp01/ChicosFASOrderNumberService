package com.chicosfas.order.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chicosfas.order.config.FasServiceConfiguration;
import com.chicosfas.order.payload.FASOrderNumberServiceRequestData;
import com.chicosfas.order.payload.FASOrderNumberServiceResponseData;
import com.chicosfas.order.payload.Response;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class FASOrderNumberServiceImpl {

	@Autowired
	private FasServiceConfiguration fasServiceConfiguration;
	
	public FASOrderNumberServiceResponseData createOrderNumber(FASOrderNumberServiceRequestData fasPayloadRequestData) {
		FASOrderNumberServiceResponseData orderNumberServiceResponse = new FASOrderNumberServiceResponseData();
		if(fasServiceConfiguration.isStubEnabled()) {
			log.info("Inside stub Mode");
	   		try {
				int orderNumber = Integer.parseInt(fasServiceConfiguration.getBrandSeedMap().get(fasPayloadRequestData.getBrand()))
						+ new Random().nextInt(99999999);
				orderNumberServiceResponse.setNumber(orderNumber);
				orderNumberServiceResponse.setSuccess(true);
	   		}catch(Exception e) {
	   			orderNumberServiceResponse.setSuccess(false);
	   			
	   		}
	   		return  orderNumberServiceResponse;
		}else {
			//orderNumberServiceResponse.setSuccess(false);
			Response response = new Response();
			response.setSuccess(false);
			
		}
	
	return orderNumberServiceResponse;
	}
}
