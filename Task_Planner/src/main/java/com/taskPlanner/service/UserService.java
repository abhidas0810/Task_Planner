package com.taskPlanner.service;

import com.taskPlanner.entity.User;
import com.taskPlanner.exception.UserException;

public interface UserService {

	public User registerUser(User user) throws UserException;

}
