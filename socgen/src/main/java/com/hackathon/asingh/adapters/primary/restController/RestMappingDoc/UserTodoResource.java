package com.hackathon.asingh.adapters.primary.restController.RestMappingDoc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.asingh.adapters.primary.restController.BaseController;
import com.hackathon.asingh.corelogic.usecases.todoHandler;

@RestController
@RequestMapping("/v1/todo")

public class UserTodoResource extends BaseController {

	@Autowired
	todoHandler todoTasks;

	java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserTodoResource.class.toString());

	@GetMapping(value = { "/tasks" })
	public ResponseEntity<Map<String, Object>> AllTasks(

	) {

		logger.info("User Requested for all the Task List");
		return execute(() -> todoTasks.handleTasks());
	}

	@PostMapping(value = { "/tasks/{taskname}" })
	public ResponseEntity<Map<String, Object>> AddTasks(
			@PathVariable("taskname") String taskname

	) {

		logger.info("User Trying to add a new Task with name " + taskname);
		return execute(() -> todoTasks.handleAddTasks(taskname));
	}

	@DeleteMapping(value = { "/Deletetask/{id}" })
	public ResponseEntity<Map<String, Object>> DeleteTask(@PathVariable("id") int id

	) {
		logger.info("User Deleting Task with id " + id);
		return execute(() -> todoTasks.deleteTaskHandler(id));
	}

	@PutMapping(value = { "/UpdateStatus/{id}" })
	public ResponseEntity<Map<String, Object>> UpdateTask(@PathVariable("id") int id

	) {

		logger.info("User updating the Task status with id " + id);
		return execute(() -> todoTasks.UpdateTask(id));
	}

	@PutMapping(value = { "/taskStatus/{id}/{category}" })
	public ResponseEntity<Map<String, Object>> UpdateTaskStatus(@PathVariable("id") int id,
			@PathVariable("category") String category

	) {
		logger.info("User updating the Task category with id " + id + "to" + category);
		return execute(() -> todoTasks.UpdateTaskHandler(id, category));
	}

}
