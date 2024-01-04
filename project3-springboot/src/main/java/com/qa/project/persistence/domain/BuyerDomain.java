package com.qa.project.persistence.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*
 * This class BuyerDomain is used to represent an 'buyer' record in the database table. 
 * The class is annotated as JPA Entity, which is used to define the mapping between the 
 * class and the database table. The class also has private fields that are annotated 
 * with @Column annotation which is used to map the fields to the corresponding columns 
 * in the table. The field id is annotated with @Id and @GeneratedValue(strategy = GenerationType.IDENTITY) 
 * this is used to indicate that the field is primary key and the value will be generated by the database. 
 */

@Entity
@Table(name = "buyer")
public class BuyerDomain {
	
	@Id // This sets the variable to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this Auto-Increments for us
	@Column(name = "buyer_id") // assign a custom name to the column
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "buyer")
	private List<PropertyDomain> properties;
	
	// default constructor
	public BuyerDomain() {
		super();
	}
	
	// all arguments constructor
	public BuyerDomain(Long id, String firstName, String surname, String address, String postcode, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.address = address;
		this.postcode = postcode;
		this.phone = phone;
	}

	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<PropertyDomain> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyDomain> properties) {
		this.properties = properties;
	}
	
}