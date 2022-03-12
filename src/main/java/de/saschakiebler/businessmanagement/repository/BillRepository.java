package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Bill;
import de.saschakiebler.businessmanagement.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public class BillRepository implements BillRepoInterface{


    JdbcTemplate jdbcTemplate;

    public BillRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addBill(Bill bill) {
        this.jdbcTemplate.execute("INSERT INTO bill (cl_id,contract_id,bill_number,bill_description,bill_sum) " +
                "VALUES ('"
                + bill.getCl_id() + "','"
                + bill.getContract_id() + "','"
                + bill.getBill_number() + "','"
                + bill.getBill_description() + "',"
                + bill.getBill_sum() + ")");
    }

    @Override
    public Bill getBillByNumber(String billnumber) {

        return this.jdbcTemplate.queryForObject("SELECT * FROM bill WHERE bill_number = '" + billnumber + "'" ,
                (rs, rowNum) -> new Bill(
                        UUID.fromString(rs.getString("bill_id")),
                                UUID.fromString(rs.getString("cl_id")),
                                        UUID.fromString(rs.getString("contract_id")),
                                                rs.getString("bill_number"),
                                                rs.getString("bill_description"),
                                                rs.getDouble("bill_sum")
                                )
                );
    }

    @Override
    public Bill getBillByID(String bill_id) {
        String sql = "SELECT * FROM bill WHERE bill_id = '" + bill_id + "'";

        return this.jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> new Bill(
                        UUID.fromString(rs.getString("bill_id")),
                        UUID.fromString(rs.getString("cl_id")),
                        UUID.fromString(rs.getString("contract_id")),
                        rs.getString("bill_number"),
                        rs.getString("bill_description"),
                        rs.getDouble("bill_sum")
                )
        );


    }

    @Override
    public List<Bill> getAllBillsFromClient(Client client) {
        return this.jdbcTemplate.query("SELECT * FROM bill WHERE cl_id = '" + client.getCli_id() + "'" ,
                (rs, rowNum) -> new Bill(
                        UUID.fromString(rs.getString("bill_id")),
                        UUID.fromString(rs.getString("cl_id")),
                        UUID.fromString(rs.getString("contract_id")),
                        rs.getString("bill_number"),
                        rs.getString("bill_description"),
                        rs.getDouble("bill_sum")
                )
        );
    }

    @Override
    public void updateBill(Bill bill) {
        this.jdbcTemplate.execute("UPDATE bill SET "
                + "bill_description = '" + bill.getBill_description()
                + "', bill_sum = " + bill.getBill_sum()
                + " WHERE bill_id = '" + bill.getBill_id() + "'");
    }

    public void deleteBill(String bill_id) {
        this.jdbcTemplate.execute("DELETE FROM bill WHERE bill_id = '" + bill_id + "'");
    }
}
