package com.skt.coveysQuad.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.skt.coveysQuad.entities.Task;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TaskRestControllerTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	public void getTask() {
		ResponseEntity<Task> entity = template.getForEntity("/tasks/1", Task.class);
		assertEquals(entity.getBody().getTask(), "Meditation");
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
	}

}
