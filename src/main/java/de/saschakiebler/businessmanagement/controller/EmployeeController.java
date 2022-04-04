package de.saschakiebler.businessmanagement.controller;


import de.saschakiebler.businessmanagement.model.Employee;
import de.saschakiebler.businessmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/get/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/get/{em_id}")
    public Employee getEmployeeById(@PathVariable String em_id){
        return employeeService.getEmployeeById(em_id);
    }

    @PostMapping(path = "/add")
    public void addEmployee(Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping(path = "/update")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping(path = "/delete")
    public void deleteEmployee(@RequestBody Employee employee){
        employeeService.deleteEmployee(employee);
    }

}
