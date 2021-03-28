package com.skt.coveysQuad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skt.coveysQuad.entities.Task;
import com.skt.coveysQuad.services.TaskService;

@CrossOrigin
@RestController
public class TaskRestController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskService.getTasks();
	}
	
	@PostMapping("/tasks")
	public void addTask(@RequestBody Task task) {
		taskService.addTask(task);
	}

}
