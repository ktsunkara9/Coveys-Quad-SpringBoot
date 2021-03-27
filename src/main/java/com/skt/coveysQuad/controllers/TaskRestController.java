package com.skt.coveysQuad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skt.coveysQuad.entities.Task;
import com.skt.coveysQuad.services.TaskService;

@RestController
public class TaskRestController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskService.getTasks();
	}

}
