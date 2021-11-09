package com.karabelyov.yordan.Employees.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "No results found for this...")
public class EmployeeNotFound extends RuntimeException{
}
