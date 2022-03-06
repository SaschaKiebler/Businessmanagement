package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Employee;

import java.util.List;

public interface EmployeeRepoInterface {

    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(String em_id);
    public List<Employee> getEmployeeByName(String name);
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
}
