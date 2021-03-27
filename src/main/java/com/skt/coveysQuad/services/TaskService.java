package com.skt.coveysQuad.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skt.coveysQuad.entities.Task;

@Service
public class TaskService {

	private List<Task> tasks = Arrays.asList(new Task(1, "Exercise"), new Task(2, "Meditate"));

	public List<Task> getTasks() {
		return tasks;
	}

}
