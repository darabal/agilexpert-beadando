package com.example.ablakozo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("addedBy")
	private Long addedBy;
	@JsonProperty("apps")
	private List<Application> apps = new ArrayList<Application>();
	@JsonProperty("theme")
	private String theme;
	@JsonProperty("background")
	private String background;
	
	
	
	
	public User() {
		super();
	}
	
	public User(Long id, String name, Long addedBy, List<Application> apps, String theme, String background) {
		super();
		this.id = id;
		this.name = name;
		this.addedBy = addedBy;
		this.apps = apps;
		this.theme = theme;
		this.background = background;
	}
	
	
	@Override
	public String toString() {
		String response = "("+id+") "+name+" | theme: "+theme+" background: "+background;
		if(apps != null) {
			for (Application application : apps) {
				System.out.print(application.getAppName()+"("+ application.getStatus() +") ");
			}
		}
		return response;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(Long addedBy) {
		this.addedBy = addedBy;
	}
	public List<Application> getApps() {
		return apps;
	}
	public void setApps(List<Application> apps) {
		this.apps = apps;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
}  
