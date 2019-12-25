package com.vbusers.dao;

import java.util.List;

import com.vbusers.entity.VbUser;

public interface UserDao {

	public boolean isValidUser(String username, String password);
	
	public List<VbUser> getVbUsers();
	
	public VbUser getVbUserById(long id);
	
	public int update(VbUser vbUser);
	
	public void save(VbUser vbUser);
	
	public int delete(long id);
	
}
