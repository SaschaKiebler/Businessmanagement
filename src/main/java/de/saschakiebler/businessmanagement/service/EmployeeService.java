package de.saschakiebler.businessmanagement.service;

import de.saschakiebler.businessmanagement.model.Employee;
import de.saschakiebler.businessmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.saschakiebler.businessmanagement.service.RecognizeIllegalInputStatements.*;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(String em_id){
        if (recognizeAnySQLRelevantWords(em_id))
            return employeeRepository.getEmployeeById(em_id);
        else
            return null;
    }

    public void addEmployee(Employee employee){
        if (recognizeAnySQLRelevantWords(employee.toString()))
            employeeRepository.addEmployee(employee);
    }

    public void updateEmployee(Employee employee){
        if (recognizeAnySQLRelevantWords(employee.toString()))
            employeeRepository.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee){
        if (recognizeAnySQLRelevantWords(employee.toString()))
            employeeRepository.deleteEmployee(employee);
    }
}
