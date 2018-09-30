package com.mahesh.hibernate;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_details")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	private Date joiningDate;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride (name="street", column=@Column(name="home_street_name")),
			@AttributeOverride (name="city", column=@Column(name="home_city_name")),
			@AttributeOverride (name="state", column=@Column(name="home_state_name")),
			@AttributeOverride (name="pincode", column=@Column(name="home_pincode_num"))
	}
			)
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride (name="street", column=@Column(name="office_street_name")),
		@AttributeOverride (name="city", column=@Column(name="office_city_name")),
		@AttributeOverride (name="state", column=@Column(name="office_state_name")),
		@AttributeOverride (name="pincode", column=@Column(name="office_pincode_num"))
}
		)
	private Address officeAddress;
	private String designation;
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getDesignation() {
		return designation;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
