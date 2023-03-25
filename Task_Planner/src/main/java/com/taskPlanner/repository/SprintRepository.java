package com.taskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskPlanner.entity.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer> {

}
