package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Bill;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
class BillRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;



    @Test
    void addBill() {
    BillRepository billRepository = new BillRepository(jdbcTemplate);
        UUID id = UUID.randomUUID();
        Bill bill = new Bill(id);
    billRepository.addBill(bill);

        assertEquals(bill, billRepository.getBillByID(id.toString()));

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