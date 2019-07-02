package com.chicosfas.order.payload;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success",
    "number",
    "response"
})

@Data
public class FASOrderNumberServiceResponseData {

	    @JsonProperty("success")
	    private boolean success;
	    
	    @JsonProperty("number")
	    private int number;
	    
	    @JsonProperty("response")
	    private Response response;
}
