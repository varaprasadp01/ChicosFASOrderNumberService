package com.chicosfas.order.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config")
public class FasServiceConfiguration {
	private boolean stubEnabled=false;
	
	@Value("#{${brand-seed-map}}")
	private Map<String,String> brandSeedMap;

	public boolean isStubEnabled() {
		return stubEnabled;
	}

	public void setStubEnabled(boolean stubEnabled) {
		this.stubEnabled = stubEnabled;
	}

	public Map<String, String> getBrandSeedMap() {
		return brandSeedMap;
	}

	public void setBrandSeedMap(Map<String, String> brandSeedMap) {
		this.brandSeedMap = brandSeedMap;
	}

	
}
