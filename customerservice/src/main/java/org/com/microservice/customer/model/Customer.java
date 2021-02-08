package org.com.microservice.customer.model;

import org.com.microservice.customer.constant.HibernateConstants;

import org.hibernate.annotations.Type;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class Customer {

	@Id
	@Column(name = "USER_ID", nullable = false)
	private String id;

	@Column(name = "USER_NAME")
	private String name;

	@Type(type = HibernateConstants.DATE_TYPE)
	@Column(name = "DOB")
	private ZonedDateTime dob;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Customer customer = (Customer) o;

		return id.equals(customer.id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ZonedDateTime getDob() {
		return dob;
	}

	public void setDob(ZonedDateTime dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
