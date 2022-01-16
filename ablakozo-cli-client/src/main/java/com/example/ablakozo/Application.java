package com.example.ablakozo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Application {
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("appName")
	private String appName;
	@JsonProperty("appUrl")
	private String appUrl;
	@JsonProperty("status")
	private String status;
	
	
	public Application() {
		super();
	}


	public Application(Long id, String appName, String appUrl, String status) {
		super();
		this.id = id;
		this.appName = appName;
		this.appUrl = appUrl;
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAppName() {
		return appName;
	}


	public void setAppName(String appName) {
		this.appName = appName;
	}


	public String getAppUrl() {
		return appUrl;
	}


	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
