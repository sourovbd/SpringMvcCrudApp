package com.vbusers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbusers.dao.UserDao;
import com.vbusers.entity.VbUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	public List<VbUser> getVbUsers() {
		
		return userDao.getVbUsers();
	}


	public boolean isValidUser(String username, String password) {
		
		return userDao.isValidUser(username, password);
	}


	public VbUser getVbUserById(long id) {
		
		return userDao.getVbUserById(id);
	}
	
	public int update(VbUser vbUser) {
		
		return userDao.update(vbUser);
	}
	
	public void save(VbUser vbUser) {
		
		userDao.save(vbUser);
	}


	public int delete(long id) {
		
		return userDao.delete(id);
	}
	
	
}
