package com.cognizant.sba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.sba.eo.TaskEO;

@Repository
public interface TaskRepository extends JpaRepository<TaskEO, Integer> {
}
