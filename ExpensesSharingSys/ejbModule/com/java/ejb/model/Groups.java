package com.java.ejb.model;

import java.io.Serializable;
import java.sql.Date;

public class Groups implements Serializable{
	
	
	private int groupId;
	private String name;
	private Date createdAt;

	
	
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Groups() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groups(int groupId, String name, Date createdAt) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Groups [groupId=" + groupId + ", name=" + name + ", createdAt=" + createdAt + ", getGroupId()="
				+ getGroupId() + ", getName()=" + getName() + ", getCreatedAt()=" + getCreatedAt() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}