package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Em_Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class Em_ContractRepository implements Em_ContractRepoInterface{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addEm_Contract(Em_Contract em_contract) {
        this.jdbcTemplate.execute("INSERT INTO em_contract (em_id, contract_id, em_contract_hours) " +
                "VALUES ('" + em_contract.getContract_id().toString() + "','"
                + em_contract.getEm_id().toString() + "',"
                + em_contract.getEm_contract_hours() + ")");
    }

    @Override
    public void deleteEm_Contract(String em_contract_id) {
        this.jdbcTemplate.execute("DELETE FROM em_contract WHERE contract_id='" + em_contract_id + "'");
    }

    @Override
    public void updateEm_Contract(Em_Contract em_contract) {
        this.jdbcTemplate.execute("UPDATE em_contract SET em_contract_hours = "
                + em_contract.getEm_contract_hours()
                + " WHERE em_contract_id = '"
                + em_contract.getEm_contract_id() + "'");
    }

    @Override
    public Em_Contract getEm_ContractByID(String em_contract_id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM em_contract where em_contract_id = '"
                + em_contract_id + "'",
                (rs,rowN) -> new Em_Contract(
                        UUID.fromString(rs.getString("em_contract_id")),
                        UUID.fromString(rs.getString("em_id")),
                        UUID.fromString(rs.getString("contract_id")),
                        rs.getInt("em_contract_hours")
                ));
    }

    @Override
    public List<Em_Contract> getAllEm_Contract() {
        return this.jdbcTemplate.query("SELECT * FROM em_contract" , (rs, rowNum) ->
                new Em_Contract(
                        UUID.fromString(rs.getString("em_contract_id")),
                        UUID.fromString(rs.getString("em_id")),
                        UUID.fromString(rs.getString("contract_id")),
                        rs.getInt("em_contract_hours")
                ));
    }

    @Override
    public List<Em_Contract> getAllEm_ContractsOfContract(String contract_id) {
        return  this.jdbcTemplate.query("SELECT * FROM em_contract WHERE contract_id = '"
                + contract_id + "'" ,
                (rs, rowNum) -> new Em_Contract(
                        UUID.fromString(rs.getString("em_contract_id")),
                        UUID.fromString(rs.getString("em_id")),
                        UUID.fromString(rs.getString("contract_id")),
                        rs.getInt("em_contract_hours")
                ));
    }

    @Override
    public List<Em_Contract> getAllEm_ContractsOfEmployee(String em_id) {
        return  this.jdbcTemplate.query("SELECT * FROM em_contract WHERE em_id = '"
                        + em_id + "'" ,
                (rs, rowNum) -> new Em_Contract(
                        UUID.fromString(rs.getString("em_contract_id")),
                        UUID.fromString(rs.getString("em_id")),
                        UUID.fromString(rs.getString("contract_id")),
                        rs.getInt("em_contract_hours")
                ));
    }

    @Override
    public int getAllHoursOfEmployeeFromContract(String em_id, String contract_id) {
        try {
            return this.jdbcTemplate.queryForObject("SELECT em_contract_hours " +
                            "FROM em_contract WHERE " +
                            "contract_id  = '" + contract_id + "' AND " +
                            "em_id = '" + em_id + "'",
                    (rs, rowNum) -> rs.getInt("em_contract_hours"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
