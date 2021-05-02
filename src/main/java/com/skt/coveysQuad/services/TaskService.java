package com.skt.coveysQuad.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skt.coveysQuad.data.entities.Task;
import com.skt.coveysQuad.exceptions.TaskNotFoundException;

@Service
public class TaskService {

	private List<Task> tasks = new ArrayList<Task>(Arrays.asList(new Task(1, "Meditation"), new Task(2, "Exercise")));

	public List<Task> getTasks() {
		return tasks;
	}

	public Task getTask(Integer id) {

		Optional<Task> searchedTask = tasks.stream().filter(task -> task.getId() == id).findFirst();

		if (id < 0 || !searchedTask.isPresent()) {
			throw new TaskNotFoundException("Task id Not Found : " + id);
		}

		return searchedTask.get();

	}

	public void addTask(Task task) {
		task.setId(1 + (int) Math.random());
		tasks.add(task);
	}

	public void deleteTask(Integer id) {
		tasks.removeIf(t -> t.getId() == id);
	}

}
