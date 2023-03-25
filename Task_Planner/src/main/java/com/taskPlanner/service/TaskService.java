package com.taskPlanner.service;

import java.util.List;

import com.taskPlanner.entity.Task;
import com.taskPlanner.exception.SprintException;
import com.taskPlanner.exception.TaskException;
import com.taskPlanner.exception.UserException;

public interface TaskService {

	public Task addTask(Integer sprintId, Task task) throws TaskException, SprintException;

	public Task getTaskById(Integer taskId) throws TaskException;

	public List<Task> getAllTask(String emailId) throws TaskException, UserException;

	public Task updateTaskById(Task task) throws TaskException;

	public Task delateTaskById(Integer taskId) throws TaskException;

}
