package de.saschakiebler.businessmanagement.service;

import de.saschakiebler.businessmanagement.model.Employee;
import de.saschakiebler.businessmanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {


    @Test
    public void test_get_All_Employees_for_3_Employees(){
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        EmployeeService employeeService = new EmployeeService(employeeRepository);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee());
        employeeList.add(new Employee());
        employeeList.add(new Employee());
        Mockito.when(employeeRepository.getAllEmployees())
                .thenReturn(employeeList);
        assertEquals(employeeList.size(),employeeService.getAllEmployees().size());
    }

    @Test
    public void test_get_All_Employees_for_0_Employees(){
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        EmployeeService employeeService = new EmployeeService(employeeRepository);
        List<Employee> employeeList = new ArrayList<>();
        Mockito.when(employeeRepository.getAllEmployees())
                .thenReturn(employeeList);
        assertEquals(employeeList.size(),employeeService.getAllEmployees().size());
    }

    @Test
    public void test_getEmployeeById_for_valid_id(){
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        EmployeeService employeeService = new EmployeeService(employeeRepository);
        UUID id = UUID.randomUUID();
        Employee anna = new Employee(id);
        Mockito.when(employeeRepository.getEmployeeById(id.toString()))
                .thenReturn(anna);
        assertEquals(id,employeeService.getEmployeeById(id.toString()).getEm_id());
    }

    @Test
    public void test_getEmployeeById_for_false_id(){
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        EmployeeService employeeService = new EmployeeService(employeeRepository);
        UUID id = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Employee anna = new Employee(id);
        Mockito.when(employeeRepository.getEmployeeById(id.toString()))
                .thenReturn(anna);
        assertNotEquals(id2,employeeService.getEmployeeById(id.toString()).getEm_id());
    }

    @Test
    public void test_getEmployeeById_for_illegal_input(){
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        assertEquals(null,employeeService.getEmployeeById("asas"));
    }
    
}