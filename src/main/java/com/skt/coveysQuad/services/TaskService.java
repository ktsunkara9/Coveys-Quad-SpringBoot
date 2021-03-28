package com.skt.coveysQuad.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skt.coveysQuad.entities.Task;

@Service
public class TaskService {

	private List<Task> tasks = new ArrayList<Task>(Arrays.asList(new Task(1, "Meditation"), new Task(2, "Exercise")));

	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		task.setId(1 + (int) Math.random());
		tasks.add(task);
	}

}
