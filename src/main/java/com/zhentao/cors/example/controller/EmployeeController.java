package com.zhentao.cors.example.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codahale.metrics.annotation.Timed;
import com.zhentao.cors.example.exception.EmployeeExistsException;
import com.zhentao.cors.example.exception.EmployeeNotExistsException;
import com.zhentao.cors.example.exception.IdNotMatchException;
import com.zhentao.cors.example.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private static ConcurrentHashMap<Long, Employee> employees = new ConcurrentHashMap<Long, Employee>();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Timed
    public Employee get(@PathVariable long id) {
        Employee employee = employees.get(id);
        if (employee == null) {
            throw new EmployeeNotExistsException("Employee with id: " + id + " doesn't exist");
        }
        return employee;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/json" })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Timed
    public void update(@RequestBody Employee employee, @PathVariable long id) {
        if (employee.getId() != id) {
            throw new IdNotMatchException("path parameter id: " + id + " doesn't match the id from employee: "
                                            + employee.getId());
        }
        employees.put(id, employee);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = { "application/json" })
    @Timed
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        if (employees.containsKey(employee.getId())) {
            throw new EmployeeExistsException("employee with id " + employee.getId() + " already exists");
        }
        employees.put(employee.getId(), employee);

        HttpHeaders headers = new HttpHeaders();
        // This is required for CORS request to retrieve Location header
        headers.add("Access-Control-Expose-Headers", "Location");

        URI newLocation = linkTo(methodOn(EmployeeController.class).get(employee.getId())).toUri();
        headers.setLocation(newLocation);

        ResponseEntity<Employee> entity = new ResponseEntity<Employee>(headers, HttpStatus.CREATED);
        return entity;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @Timed
    public void delete(@PathVariable long id) {
        if (!employees.containsKey(id)) {
            throw new EmployeeNotExistsException("Employee with id: " + id + " doesn't exist");
        }
        employees.remove(id);
    }
}
