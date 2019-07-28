package com.cognizant.sba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.sba.eo.UserEO;
import com.cognizant.sba.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public UserEO addNewUser(UserEO user) {
		UserEO n = new UserEO();
		n.setFirstName(user.getFirstName());
		n.setLastName(user.getLastName());
		n.setEmployeeId(user.getEmployeeId());
		return userRepo.save(n);
	}

	public Iterable<UserEO> findAll() {

		return userRepo.findAll();
	}

	public UserEO updateUser(UserEO user) {
		UserEO n = userRepo.findOne(user.getUserId());
		n.setEmployeeId(user.getEmployeeId());
		n.setFirstName(user.getFirstName());
		n.setLastName(user.getLastName());
		return n;
	}

}
