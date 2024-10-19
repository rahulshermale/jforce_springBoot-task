package com.example.Servicess;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.example.Repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUser() {

		List<User> users = userRepository.findAll();
		return users;

	}


	public void deletUser(Long userid) {

		userRepository.deleteById(userid);

	}

	public List<User> getAllUser1() {

		List<User> users = userRepository.findAll();
		return users;

	}

	public User saveUser(User user) {
		User users = userRepository.save(user);
		return users;
	}


	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	  

	public Object UserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
