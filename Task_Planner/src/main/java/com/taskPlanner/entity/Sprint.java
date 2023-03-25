package com.taskPlanner.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sprint {

	@Id
	@GeneratedValue
	private Integer sprintId;
	private String name;
	private Date startDateTime;
	private Date endDateTime;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sprint")
	@JsonIgnore
	private List<Task> tasks = new ArrayList<>();

}
