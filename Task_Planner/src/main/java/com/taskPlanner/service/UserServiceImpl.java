package com.taskPlanner.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskPlanner.entity.User;
import com.taskPlanner.exception.UserException;
import com.taskPlanner.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) throws UserException {
		Optional<User> userOptional = userRepository.findById(user.getEmailId());
		if (userOptional.isPresent()) {
			throw new UserException("User can not be registr.");
		}
		User registeredUser = userRepository.save(user);
		if (registeredUser != null) {
			return registeredUser;
		} else {
			throw new UserException("User not registred.");
		}
	}

	@Override
	public User getUser(String emailId) throws UserException {
		return userRepository.findById(emailId)
				.orElseThrow(() -> new UserException("User not found witn emailId " + emailId));
	}

	@Override
	public User updateUser(User user) throws UserException {
		User registeredUser = userRepository.findById(user.getEmailId())
				.orElseThrow(() -> new UserException("User not found witn emailId " + user.getEmailId()));
		registeredUser.setName(user.getName());
		registeredUser.setRole(user.getRole());
		registeredUser.getSprints().addAll(user.getSprints());
		return userRepository.save(registeredUser);
	}

	@Override
	public User deleteUser(String emailId) throws UserException {
		User user = userRepository.findById(emailId)
				.orElseThrow(() -> new UserException("User not found witn emailId " + emailId));
		userRepository.delete(user);
		return user;
	}

}
