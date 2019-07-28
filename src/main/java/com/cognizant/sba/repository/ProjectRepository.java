package com.cognizant.sba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.sba.eo.ProjectEO;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEO, Long> {

}
