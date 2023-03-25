package com.taskPlanner.service;

import java.util.List;

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
public class SprintServiceImpl implements SprintService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SprintRepository sprintRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Sprint addSprint(String emailId, Sprint sprint) throws SprintException, UserException {
		User registeredUser = userRepository.findById(emailId)
				.orElseThrow(() -> new UserException("User not found witn emailId " + emailId));
		registeredUser.getSprints().add(sprint);
		sprint.setUser(registeredUser);
		Sprint registeredSprint = sprintRepository.save(sprint);
		if (registeredSprint != null) {
			return registeredSprint;
		} else {
			throw new SprintException("Sprint can not be added.");
		}
	}

	@Override
	public Sprint addTaskToSprint(Integer sprintId, Task task) throws SprintException, TaskException {
		Sprint regesteredSprint = sprintRepository.findById(sprintId)
				.orElseThrow(() -> new SprintException("Sprint not found with sprintId " + sprintId));
		regesteredSprint.getTasks().add(taskRepository.save(task));

		return sprintRepository.save(regesteredSprint);
	}

	@Override
	public Sprint getSprintById(Integer sprintId) throws SprintException {
		return sprintRepository.findById(sprintId)
				.orElseThrow(() -> new SprintException("Sprint not found with sprintId " + sprintId));
	}

	@Override
	public Sprint updateSprint(Sprint sprint) throws SprintException {
		Sprint regesteredSprint = sprintRepository.findById(sprint.getSprintId())
				.orElseThrow(() -> new SprintException("Sprint not found with sprintId " + sprint.getSprintId()));

		regesteredSprint.setName(sprint.getName());
		regesteredSprint.setStartDateTime(sprint.getStartDateTime());
		regesteredSprint.setEndDateTime(sprint.getEndDateTime());
		regesteredSprint.getTasks().addAll(sprint.getTasks());
		return sprintRepository.save(regesteredSprint);
	}

	@Override
	public Sprint deleteSprintById(Integer sprintId) throws SprintException {
		Sprint sprint = sprintRepository.findById(sprintId)
				.orElseThrow(() -> new SprintException("Sprint not found with sprintId " + sprintId));
		sprintRepository.delete(sprint);
		return sprint;
	}

	@Override
	public List<Sprint> getAllSprint(String emailId) throws SprintException, UserException {
		User registeredUser = userRepository.findById(emailId)
				.orElseThrow(() -> new UserException("User not found witn emailId " + emailId));
		List<Sprint> sprints = registeredUser.getSprints();
		if (sprints.isEmpty()) {
			throw new SprintException("Sprint not found with sprintId");
		} else {
			return sprints;
		}
	}

}
