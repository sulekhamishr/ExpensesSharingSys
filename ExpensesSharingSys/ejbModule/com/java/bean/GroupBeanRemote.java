package com.java.bean;

import javax.ejb.Remote;

import com.java.ejb.model.Groups;

@Remote
public interface GroupBeanRemote {

	public String CreateGroupDao(Groups groups);

}
