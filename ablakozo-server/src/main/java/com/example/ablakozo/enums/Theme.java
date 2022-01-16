package com.example.ablakozo.enums;

public enum Theme {
	DEFAULT ("Default"),
	DARK ("Dark"),
	OAK ("Oak"),
	MIRROR ("Mirror"),
	PINK ("Pink");
	
	private final String themeName;
	
	Theme(String theme) {
		this.themeName = theme;
	}
	
	public String getThemeName() {
		return this.themeName;
	}

	
}
