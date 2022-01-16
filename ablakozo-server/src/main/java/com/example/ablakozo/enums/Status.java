package com.example.ablakozo.enums;

public enum Status {
	ONLINE("Online"),
	OFFLINE("Offline");
	
	private final String status;
	
	Status(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}

}
