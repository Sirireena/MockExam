package com.springboot.restapi.onetomany;

import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Vechiles {
	
	private long id;
	private String Carname;
	private String Modelname;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	List<User> user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarname() {
		return Carname;
	}

	public void setCarname(String carname) {
		Carname = carname;
	}

	public String getModelname() {
		return Modelname;
	}

	public void setModelname(String modelname) {
		Modelname = modelname;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Vechiles(String carname, String modelname) {
		super();
		Carname = carname;
		Modelname = modelname;
	}

	public Vechiles() {
		super();
	}
	
	

}
