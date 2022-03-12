package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Bill;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class BillRepositoryTest {



    JdbcTemplate jdbcTemplate;


    BillRepository billRepository;


    @BeforeEach
    void setUp() {
        billRepository = new BillRepository(jdbcTemplate);
        jdbcTemplate.execute("insert into bill " +
                    "(bill_number, bill_description, bill_sum) " +
                    "values " +
                    "('01234','Test Bill for Test Purpose', 1000)," +
                    "('12345','Test Bill 2', 2000)," +
                    "('123456','Test Bill 3', 3000)");
    }


    void tearDown() {
        jdbcTemplate.execute("delete from em_contract");
        jdbcTemplate.execute("delete from employee");
        jdbcTemplate.execute("delete from contract");
        jdbcTemplate.execute("delete from bill");
        jdbcTemplate.execute("delete from client");



    }

    @Test
    void addBill() {

        billRepository = new BillRepository(jdbcTemplate);
        billRepository.addBill(new Bill("4","new Bill", 4000));
        List<Bill> result = this.jdbcTemplate.query("select * from bill",
                (rs, rowNum) -> new Bill(
                        rs.getString("bill_number"),
                        rs.getString("bill_description"),
                        rs.getInt("bill_sum")
                ));

        assertEquals(4,result.size());

    }

    @Test
    void getBillByNumber() {
    }

    @Test
    void getBillByID() {
    }

    @Test
    void getAllBillsFromClient() {
    }

    @Test
    void updateBill() {
    }

    @Test
    void deleteBill() {
    }
}