package com.cognizant.sba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.sba.dto.TaskDTO;
import com.cognizant.sba.eo.TaskEO;
import com.cognizant.sba.service.TaskService;

@CrossOrigin
@Controller
@RequestMapping(path = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewTask(@RequestBody TaskDTO task) {

		return taskService.addNewTask(task);
	}

	@GetMapping(path = "/all")
	public @ResponseBody List<TaskDTO> getAllTasks() {
		return taskService.getAllTasks();
	}

	@PutMapping(path = "/update")
	public @ResponseBody TaskEO updateTask(@RequestBody TaskDTO task) {

		return taskService.updateTask(task);
	}

	@PutMapping(path = "/end-task")
	public @ResponseBody TaskEO endTask(@RequestBody TaskDTO task) {

		return taskService.endTask(task);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public @ResponseBody Iterable<TaskDTO> getTasksByProject(@PathVariable("id") Long id) {

		return taskService.getTasksByProject(id);

	}

}
