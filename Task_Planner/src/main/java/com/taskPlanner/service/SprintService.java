package com.taskPlanner.service;

import java.util.List;

import com.taskPlanner.entity.Sprint;
import com.taskPlanner.entity.Task;
import com.taskPlanner.exception.SprintException;
import com.taskPlanner.exception.TaskException;
import com.taskPlanner.exception.UserException;

public interface SprintService {

	public Sprint addSprint(String emailId, Sprint sprint) throws SprintException, UserException;

	public Sprint addTaskToSprint(Integer sprintId, Task task) throws SprintException, TaskException;

	public Sprint getSprintById(Integer sprintId) throws SprintException;

	public Sprint updateSprint(Sprint sprint) throws SprintException;

	public Sprint deleteSprintById(Integer sprintId) throws SprintException;

	public List<Sprint> getAllSprint(String emailId) throws SprintException, UserException;

}
