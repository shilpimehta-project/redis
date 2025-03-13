package com.sm.RedisCacheSpringBootDemo.entity;

import java.io.Serializable;

/*import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;*/

/*@Entity
@Table(name="Users")*/
public class User implements Serializable {
	
	 private static final long serialVersionUID = -4439114469417994311L;

		/*
		 * @Id
		 * 
		 * @GeneratedValue(strategy = GenerationType.IDENTITY)
		 */
	private Integer id;
	private String name;
	private String email;
	
	public User() {
		
	}
	public User(Integer id, String name, String email) {
		this.id=id;
		this.name = name;
		this.email = email;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
