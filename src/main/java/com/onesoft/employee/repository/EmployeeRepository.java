package com.onesoft.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onesoft.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
@Query(value="select * from employee where salary> ? and salary<= ? ",nativeQuery=true)
	List<Employee> getSal(int a, int b);
@Query(value="select e from Employee e where e.age<:a ")    //entity name(Employee) //jquery
       List<Employee> getbyage(@Param(value ="a")int a);
@Query(value="select * from employee where name= ? ",nativeQuery=true)
       List<Employee> getname(String name);
@Query(value="select * from employee where gender = ? ",nativeQuery=true)
       List<Employee> getbygender(String gender);
@Query(value="select * from employee where salary = ? ",nativeQuery=true)
       List<Employee> getbysalary(int salary);
}
