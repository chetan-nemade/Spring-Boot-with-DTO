package com.user.app.service;

import java.util.List;
import java.util.Optional;

import com.user.app.entity.User;

public interface UserService {

	public User saveUser(User user);
	public Optional<User> getUser(Integer userId);
	public List<User> getAllUsers();
}
