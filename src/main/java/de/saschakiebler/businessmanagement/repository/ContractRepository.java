package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ContractRepository implements ContractRepoInterface{

    JdbcTemplate jdbcTemplate;

    public ContractRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Contract> getAllContracts() {
        return this.jdbcTemplate.query("SELECT * FROM contract" , (rs, rowNum) ->
                new Contract(
                        UUID.fromString(rs.getString("contract_id")),
                        rs.getString("contract_name"),
                        rs.getString("contract_description"),
                        rs.getString("contract_plannedstartdate"),
                        rs.getString("contract_startdate"),
                        rs.getString("contract_plannedenddate"),
                        rs.getString("contract_enddate")
                ));
    }

    @Override
    public Contract getContractByID(String contract_id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM contract WHERE contract_id = '" + contract_id + "'",
                (rs, rowNum) -> new Contract(
                        UUID.fromString(rs.getString("contract_id")),
                        rs.getString("contract_name"),
                        rs.getString("contract_description"),
                        rs.getString("contract_plannedstartdate"),
                        rs.getString("contract_startdate"),
                        rs.getString("contract_plannedenddate"),
                        rs.getString("contract_enddate")
                ));
    }

    @Override
    public List<Contract> getAllContractsFromClient(String cl_id) {
        return this.jdbcTemplate.query("SELECT contract.contract_id,contract.contract_name," +
                " contract.contract_description,contract.contract_plannedstartdate," +
                " contract.contract_startdate,contract.contract_plannedenddate," +
                " contract.contract_enddate FROM contract " +
                " INNER JOIN bill ON contract.contract_id = bill.contract_id" +
                " INNER JOIN client ON bill.cl_id = client.cl_id WHERE client.cl_id = '" + cl_id + "'",
                (rs, rowNum) -> new Contract(
                        UUID.fromString(rs.getString("contract_id")),
                        rs.getString("contract_name"),
                        rs.getString("contract_description"),
                        rs.getString("contract_plannedstartdate"),
                        rs.getString("contract_startdate"),
                        rs.getString("contract_plannedenddate"),
                        rs.getString("contract_enddate")
                )
                );
    }

    @Override
    public void addContract(Contract contract) {
        this.jdbcTemplate.execute("INSERT INTO contract (contract_name, contract_description, " +
                "contract_plannedstartdate, contract_startdate, " +
                "contract_plannedenddate, contract_enddate) VALUES ('" +
                contract.getContract_name() + "','" + contract.getContract_description() + "','"
        + testIfNull(contract.getContract_plannedstartdate()) + "','" + testIfNull(contract.getContract_startdate()) + "','"
        + testIfNull(contract.getContract_plannedenddate()) + "','" + testIfNull(contract.getContract_enddate()) + "')");
    }

    @Override
    public void updateContract(Contract contract) {
        this.jdbcTemplate.execute("UPDATE contract SET " +
                "contract_name = '" + contract.getContract_name()
                + "' , contract_description = '" + testIfNull(contract.getContract_description())
                + "' , contract_plannedstartdate = '" + testIfNull(contract.getContract_plannedstartdate())
                + "' , contract_startdate = '" + testIfNull(contract.getContract_startdate())
                + "' , contract_plannedenddate = '" + testIfNull(contract.getContract_plannedenddate())
                + "' , contract_enddate = '" + testIfNull(contract.getContract_enddate()) + "'");
    }

    @Override
    public void deleteContract(String contract_id) {
        this.jdbcTemplate.execute("DELETE FROM contract WHERE contract_id = '" + contract_id + "'");
    }

    private String testIfNull(String string){
        return string==null ? "1000-01-01" : string;
    }
}
