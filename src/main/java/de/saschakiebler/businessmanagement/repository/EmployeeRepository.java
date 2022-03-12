package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeRepository implements EmployeeRepoInterface{

    JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.jdbcTemplate.query("SELECT * FROM employee",
                (rs, rowNum) -> new Employee(
                        UUID.fromString(rs.getString("em_id")),
                        rs.getString("em_firstname"),
                        rs.getString("em_lastname"),
                        rs.getString("em_dob"),
                        rs.getString("em_citizenship"),
                        rs.getString("em_cathlic").charAt(0),
                        rs.getString("em_taxnumber")
                ));
    }

    @Override
    public Employee getEmployeeById(String em_id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM employee WHERE em_id = '" + em_id + "'",
                (rs, rowNum) -> new Employee(
                        UUID.fromString(rs.getString("em_id")),
                        rs.getString("em_firstname"),
                        rs.getString("em_lastname"),
                        rs.getString("em_dob"),
                        rs.getString("em_citizenship"),
                        rs.getString("em_cathlic").charAt(0),
                        rs.getString("em_taxnumber")
                ));
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return this.jdbcTemplate.query("SELECT * FROM employee " +
                        "WHERE em_firstname = '%" + name + "%' " +
                        "OR em_lastname ='%" + name + "%'",
                (rs, rowNum) -> new Employee(
                        UUID.fromString(rs.getString("em_id")),
                        rs.getString("em_firstname"),
                        rs.getString("em_lastname"),
                        rs.getString("em_dob"),
                        rs.getString("em_citizenship"),
                        rs.getString("em_cathlic").charAt(0),
                        rs.getString("em_taxnumber")
                ));
    }

    @Override
    public void addEmployee(Employee employee) {
        this.jdbcTemplate.execute("INSERT INTO employee " +
                "(em_firstname, em_lastname, em_dob, em_citizenship, em_cathlic, em_taxnumber) " +
                "VALUES ('" + employee.getEm_firstname() + "','" +
                employee.getEm_lastname() + "','" +
                employee.getEm_dob() + "','" +
                employee.getEm_citizenship() + "','" +
                employee.getEm_cathlic() + "','" +
                employee.getEm_taxnumber() + "')");
    }

    @Override
    public void updateEmployee(Employee employee) {
        this.jdbcTemplate.execute("UPDATE employee " +
                "SET em_firstname = '" + employee.getEm_firstname() +"', " +
                "em_lastname = '" + employee.getEm_lastname() +"', " +
                "em_dob = " + employee.getEm_dob() + ", " +
                "em_citizenship = '" + employee.getEm_citizenship() + "', " +
                "em_cathlic = '" + employee.getEm_cathlic() + "', " +
                "em_taxnumber = '" + employee.getEm_taxnumber() + "'" +
                "WHERE em_id = '" + employee.getEm_id() + "'");
    }

    @Override
    public void deleteEmployee(Employee employee) {
        this.jdbcTemplate.execute("DELETE FROM employee " +
                "WHERE em_id = '" + employee.getEm_id() + "'");
    }
}
