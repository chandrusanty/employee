package com.onesoft.employee.exceptionhandling;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onesoft.employee.Exception.GenderNotFoundException;
import com.onesoft.employee.Exception.SalaryNotFoundException;

@RestControllerAdvice
public class GlobalExceptions {
@ExceptionHandler(NameNotFoundException.class)
public ResponseEntity<Object> nameNotFoundExceptionHandling(NameNotFoundException ne) {
	return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
}
@ExceptionHandler(GenderNotFoundException.class)
public ResponseEntity<Object> genderNotFoundExceptionHandling(GenderNotFoundException ge) {
	return new ResponseEntity<>(ge.getMessage(),HttpStatus.NOT_FOUND);
}
@ExceptionHandler(SalaryNotFoundException.class)
public ResponseEntity<Object> x(SalaryNotFoundException se) {
	return new ResponseEntity<>(se.getMessage(),HttpStatus.NOT_FOUND);
}
}
