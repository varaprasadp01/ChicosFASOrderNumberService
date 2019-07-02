
package com.chicosfas.order.payload;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "source",
    "brand"
})

@Data
public class FASOrderNumberServiceRequestData {
    @JsonProperty("source")
    private String source;
    
	@NotBlank
    @JsonProperty("brand")
    private String brand;
    
	//source eg: csc occ
	//brand: chicos chicosotr soma whbm whbmotr

}
