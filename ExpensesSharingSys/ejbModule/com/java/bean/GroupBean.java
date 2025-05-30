package com.java.bean;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import com.java.ejb.dao.GroupDao;
import com.java.ejb.dao.GroupsDaoImpl;
import com.java.ejb.model.Groups;

/**
 * Session Bean implementation class GroupBean
 */
@Stateful
@Remote(GroupBeanRemote.class)
public class GroupBean implements GroupBeanRemote {

    /**
     * Default constructor. 
     */
	static GroupDao groupDao;
	
	static {
		groupDao=new GroupsDaoImpl();
		
	}
	
    public GroupBean() {
        // TODO Auto-generated constructor stub
    }
    
	public String CreateGroupDao(Groups groups) {
		return groupDao.CreateGroupDao(groups);
		
	}

}
