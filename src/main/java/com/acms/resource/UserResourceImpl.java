package com.acms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acms.model.User;
import com.acms.service.UserService;

@Controller
public class UserResourceImpl implements UserResource {
	
	private final UserService userService;

    @Autowired
    public UserResourceImpl(UserService userService) {
        this.userService = userService;
    }
    
	@Override
	public boolean validateUser(User user) {
		return userService.validateUser(user);
	}
}
