package com.cognizant.sba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.sba.eo.UserEO;

@Repository
public interface UserRepository extends JpaRepository<UserEO, Integer> {

}