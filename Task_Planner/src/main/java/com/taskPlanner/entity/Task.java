package com.taskPlanner.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {

	@Id
	@GeneratedValue
	private Integer taskId;
	private String type;
	private String description;
	private String assignee;
	private String status;
	private Date startDateTime;
	private Date endDateTime;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Sprint sprint;

}
