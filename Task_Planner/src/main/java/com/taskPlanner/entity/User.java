package com.taskPlanner.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@Id
	@Email
	private String emailId;
	private String name;
	private String password;
	private String role;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<Sprint> sprints = new ArrayList<>();

}
