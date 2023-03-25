package com.taskPlanner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskPlanner.entity.Sprint;
import com.taskPlanner.entity.Task;
import com.taskPlanner.entity.User;
import com.taskPlanner.exception.SprintException;
import com.taskPlanner.exception.TaskException;
import com.taskPlanner.exception.UserException;
import com.taskPlanner.repository.SprintRepository;
import com.taskPlanner.repository.TaskRepository;
import com.taskPlanner.repository.UserRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private SprintRepository sprintRepository;

	@Override
	public Task addTask(Integer sprintId, Task task) throws TaskException, SprintException {
		Sprint sprint = sprintRepository.findById(sprintId)
				.orElseThrow(() -> new SprintException("Please enter a valid sprintId " + sprintId));
		task.setSprint(sprint);
		sprint.getTasks().add(task);
		Task regesteredTask = taskRepository.save(task);
		if (regesteredTask == null) {
			throw new TaskException("Task can not be added.");
		} else {
			return regesteredTask;
		}
	}

	@Override
	public Task getTaskById(Integer taskId) throws TaskException {
		return taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskException("Task not found with taskId " + taskId));
	}

	@Override
	public List<Task> getAllTask(String emailId) throws TaskException, UserException {
		User registeredUser = userRepository.findById(emailId)
				.orElseThrow(() -> new UserException("User not found witn emailId " + emailId));
		List<Task> tasks = new ArrayList<>();
		registeredUser.getSprints().stream().filter(sprint -> sprint.getUser().equals(emailId))
				.collect(Collectors.toList()).forEach(sprint -> tasks.addAll(sprint.getTasks()));
		if (tasks.isEmpty()) {
			throw new TaskException("No task found.");
		} else {
			return tasks;
		}
	}

	@Override
	public Task updateTaskById(Task task) throws TaskException {
		Task registeredtask = taskRepository.findById(task.getTaskId())
				.orElseThrow(() -> new TaskException("Task not found with taskId " + task.getTaskId()));
		registeredtask.setType(task.getType());
		registeredtask.setDescription(task.getDescription());
		registeredtask.setAssignee(task.getAssignee());
		registeredtask.setStatus(task.getStatus());
		registeredtask.setStartDateTime(task.getStartDateTime());
		registeredtask.setEndDateTime(task.getStartDateTime());
		registeredtask.setSprint(task.getSprint());
		return taskRepository.save(registeredtask);
	}

	@Override
	public Task delateTaskById(Integer taskId) throws TaskException {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskException("Task not found with taskId " + taskId));
		taskRepository.delete(task);
		return task;
	}

}
