package com.taskPlanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskPlanner.entity.Sprint;
import com.taskPlanner.entity.Task;
import com.taskPlanner.entity.User;
import com.taskPlanner.exception.SprintException;
import com.taskPlanner.exception.TaskException;
import com.taskPlanner.exception.UserException;
import com.taskPlanner.service.SprintService;
import com.taskPlanner.service.TaskService;
import com.taskPlanner.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SprintService sprintService;

	@Autowired
	private TaskService taskService;

	// user endpoints

	@PostMapping("/registration")
	public ResponseEntity<User> registerUserHandler(@Valid @RequestBody User user) throws UserException {
		return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);
	}

	// sprint endpoints

	@PostMapping("/addSprint/{emailId}")
	public ResponseEntity<Sprint> addSprintHandler(@PathVariable("emailId") String emailId, @RequestBody Sprint sprint)
			throws SprintException, UserException {
		return new ResponseEntity<Sprint>(sprintService.addSprint(emailId, sprint), HttpStatus.CREATED);
	}

	@PostMapping("/addTaskToSprint/{sprintId}")
	public ResponseEntity<Sprint> addTaskToSprintHandler(@PathVariable("sprintId") Integer sprintId,
			@RequestBody Task task) throws SprintException, TaskException {
		return new ResponseEntity<Sprint>(sprintService.addTaskToSprint(sprintId, task), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getSprint/{sprintId}")
	public ResponseEntity<Sprint> getSprintByIdHandler(@PathVariable("sprintId") Integer sprintId)
			throws SprintException {
		return new ResponseEntity<Sprint>(sprintService.getSprintById(sprintId), HttpStatus.OK);
	}

	@PutMapping("/updateSprint")
	public ResponseEntity<Sprint> updateSprintHandler(@RequestBody Sprint sprint) throws SprintException {
		return new ResponseEntity<Sprint>(sprintService.updateSprint(sprint), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteSprint/{sprintId}")
	public ResponseEntity<Sprint> deleteSprintByIdHandler(@PathVariable("sprintId") Integer sprintId)
			throws SprintException {
		return new ResponseEntity<Sprint>(sprintService.deleteSprintById(sprintId), HttpStatus.OK);
	}

	@GetMapping("/getSprints/{emailId}")
	public ResponseEntity<List<Sprint>> getAllSprintHandler(String emailId) throws SprintException, UserException {
		return new ResponseEntity<List<Sprint>>(sprintService.getAllSprint(emailId), HttpStatus.OK);
	}

	// task endpoints

	@PostMapping("/addTask/{sprintId}")
	public ResponseEntity<Task> addTaskHandler(@PathVariable("sprintId") Integer sprintId, @RequestBody Task task)
			throws TaskException, SprintException {
		return new ResponseEntity<Task>(taskService.addTask(sprintId, task), HttpStatus.CREATED);
	}

	@GetMapping("/getTask/{taskId}")
	public ResponseEntity<Task> getTaskByIdHandler(@PathVariable("taskId") Integer taskId) throws TaskException {
		return new ResponseEntity<Task>(taskService.getTaskById(taskId), HttpStatus.OK);
	}

	@GetMapping("/getTasks/{emailId}")
	public ResponseEntity<List<Task>> getAllTaskHandler(@PathVariable("emailId") String emailId)
			throws TaskException, UserException {
		return new ResponseEntity<List<Task>>(taskService.getAllTask(emailId), HttpStatus.OK);
	}

	@PutMapping("/updateTask/{task}")
	public ResponseEntity<Task> updateTaskByIdHandler(@RequestBody Task task) throws TaskException {
		return new ResponseEntity<Task>(taskService.updateTaskById(task), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delateTask/{taskId}")
	public ResponseEntity<Task> delateTaskByIdHandler(@PathVariable("taskId") Integer taskId) throws TaskException {
		return new ResponseEntity<Task>(taskService.delateTaskById(taskId), HttpStatus.OK);
	}

}
