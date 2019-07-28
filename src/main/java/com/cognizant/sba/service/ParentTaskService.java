package com.cognizant.sba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.sba.eo.ParentTaskEO;
import com.cognizant.sba.repository.ParentTaskRepository;

@Service
public class ParentTaskService {
	
	@Autowired
	private ParentTaskRepository repo;
	

	public Iterable<ParentTaskEO> getAllUsers() {
		return repo.findAll();
	}
	
	

	public ParentTaskEO addNew(String task) {
		ParentTaskEO ptask = new ParentTaskEO();
		ptask.setParentTask(task);
		return repo.save(ptask);
	}
	

}
