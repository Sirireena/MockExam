package com.springboot.restapi.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="vechiles_tbl")
public class Vechiles {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String Carname;
	private String Modelname;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	

	public Vechiles(String carname, String modelname) {
		super();
		Carname = carname;
		Modelname = modelname;
	}

	public Vechiles() {
		super();
	}
	
	

}
