package com.sangeetha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sangeetha.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee , Integer>{

}
