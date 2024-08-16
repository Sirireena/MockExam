package com.springboot.restapi.onetomany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	List<Vechiles> vechiles;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Vechiles> getVechiles() {
		return vechiles;
	}


	public void setVechiles(List<Vechiles> vechiles) {
		this.vechiles = vechiles;
	}


	public User(String name) {
		super();
		this.name = name;
	}


	public User() {
		super();
	}
	

}
