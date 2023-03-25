package com.taskPlanner.service;

import com.taskPlanner.entity.User;
import com.taskPlanner.exception.UserException;

public interface UserService {

	public User registerUser(User user) throws UserException;

	public User getUser(String emailId) throws UserException;

	public User updateUser(User user) throws UserException;

	public User deleteUser(String emailId) throws UserException;

}
