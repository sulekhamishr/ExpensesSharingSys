package com.java.controller;

import com.java.ejb.dao.GroupsDao;
import com.java.ejb.model.Groups;

public class ControllerGroups {

    private GroupsDao groupsDao;
    private Groups groups;

    public GroupsDao getGroupsDao() {
        return groupsDao;
    }

    public void setGroupsDao(GroupsDao groupsDao) {
        this.groupsDao = groupsDao;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public String createGroup() {
        return groupsDao.CreateGroupDao(groups);
    }
}
