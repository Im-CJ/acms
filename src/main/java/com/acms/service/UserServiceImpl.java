package com.acms.service;

import org.springframework.stereotype.Service;

import com.acms.model.User;

@Service
public class UserServiceImpl implements UserService {

	private static final String ADMIN= "admin";
	
	private static final String USER= "user";
	
	@Override
	public boolean validateUser(User user) {
		if(USER.equals(user.getUserName()) && USER.equals(user.getPassword())) {
			return Boolean.TRUE;
		}else if(ADMIN.equals(user.getUserName()) && ADMIN.equals(user.getPassword())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
