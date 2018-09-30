package com.mahesh.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
public class SetOfAddresses {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESSES",
	 joinColumns=@JoinColumn(name="user_id")
			)
	@GenericGenerator(name="sequence", strategy="sequence")
	@CollectionId(columns = { @Column(name="address_id") }, generator = "sequence", type = @Type(type="long"))
	Collection<Address> setOfAddresses = new ArrayList<Address>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Address> getSetOfAddresses() {
		return setOfAddresses;
	}
	public void setSetOfAddresses(Set<Address> setOfAddresses) {
		this.setOfAddresses = setOfAddresses;
	}
	
	

}
