package com.cognizant.sba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.sba.eo.ParentTaskEO;

@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTaskEO, Integer> {

}
