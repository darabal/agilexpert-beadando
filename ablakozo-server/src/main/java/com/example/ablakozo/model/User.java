package com.example.ablakozo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.ablakozo.enums.Theme;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long addedBy;
	@JsonManagedReference
	@OneToMany(
			mappedBy = "user", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
	private List<Application> apps = new ArrayList<Application>();
	private String theme;
	private String background;

	public User(Long id, String name, Long addedBy) {
		this.name = name;
		this.addedBy = addedBy;
		this.theme = Theme.DEFAULT.getThemeName();
		this.background = "default.jpg";
	}

	public User() {
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

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<Application> getApps() {
		return apps;
	}

	public void setApps(List<Application> apps) {
		this.apps = apps;
	}

	public String getBackgroundUrl() {
		return background;
	}

	public void setBackgroundUrl(String backgroundUrl) {
		this.background = backgroundUrl;
	}
}
