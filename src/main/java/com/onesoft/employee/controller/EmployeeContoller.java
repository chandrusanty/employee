package com.onesoft.employee.controller;

import java.util.List;


import javax.naming.NameNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.employee.Exception.GenderNotFoundException;
import com.onesoft.employee.Exception.InvalidAgeException;
import com.onesoft.employee.Exception.SalaryNotFoundException;
import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.service.EmployeeService;
import com.onesoft.employee.service.SalaryNotEligibleException;

import jakarta.persistence.Transient;

@RestController
@RequestMapping(value="emp")
public class EmployeeContoller {
	@Autowired
	EmployeeService employeeservice;
	
	private static final Logger logger=Logger.getLogger(EmployeeContoller.class); 
	
			
	@PostMapping("add")
	public String insertEmployee(@RequestBody Employee e) throws InvalidAgeException {
		return employeeservice.insertEmployee(e);
	}
	@PostMapping("addall")
	
	public String addallEmployee(@RequestBody List<Employee> f) throws SalaryNotEligibleException {
		
		return employeeservice.addallEmployee(f);
	}
	@GetMapping("getone/{x}")
	public Employee getones(@PathVariable int x) {
		return employeeservice.getones(x);
	}
	@GetMapping("/getall")
	public List<Employee> getbyall() {
		PropertyConfigurator.configure("log4j");
		logger.info("Set the Employee from logger info");
		logger.info(employeeservice.getbyall());
		return employeeservice.getbyall();
	}
	@Transient
	@GetMapping("getbrand/{a}")
	public List<Employee> getbybrand(@PathVariable String a) {
	   return employeeservice.getbybrand(a);
	}
	@GetMapping("getmaxsalary")
	public Employee getmax() {
		return employeeservice.getmax();
	}
	@GetMapping("getminsalary")
	public Employee getmin() {
		return employeeservice.getmin();
	}
	@PutMapping("improve")
	public String getimprove(@RequestBody Employee update ) {
		return employeeservice.getimprove(update);
	}
	@DeleteMapping("deleteid/{a}")
	public String del(@PathVariable int a) {
		return employeeservice.del(a);
	}
	@GetMapping("getByAge/{age}")
	public List<Employee> getage(@PathVariable int age) {
		return employeeservice.getage(age);
	}
	@GetMapping("getByGender/{gender}")
	public List<Employee> getgender(@PathVariable String gender) {
		return employeeservice.getgender(gender);
	}
	@GetMapping("getBySalary/{salary}")
	public List<Employee> getsalary(@PathVariable int salary) {
		return employeeservice.getsalary(salary);
	} 
	@GetMapping("getSalary/{a}/{b}")
	public List<Employee> getSal(@PathVariable int a,@PathVariable int b) {
		return employeeservice.getsal(a,b);
	}
	@GetMapping("getbyage/{a}")                                       //jquery
	public List<Employee> getbyage(@PathVariable int a) {
		return employeeservice.getbyage(a);
	}
	@GetMapping("getbyname/{name}")
	public List<Employee>getname(@PathVariable String name) throws NameNotFoundException {
		return employeeservice.getname(name);
	}
	@GetMapping("getbygender/{gender}")
	public List<Employee>getbygender(@PathVariable String gender) throws GenderNotFoundException {
		return employeeservice.getbygender(gender);
	}
	@GetMapping("getbysalary/{salary}")
	public List<Employee>getbysalary(@PathVariable int salary) throws SalaryNotFoundException {
		return employeeservice.getbysalary(salary);
	}
}
