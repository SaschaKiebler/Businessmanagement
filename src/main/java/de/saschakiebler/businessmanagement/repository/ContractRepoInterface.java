package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Contract;

import java.util.List;

public interface ContractRepoInterface {

    List<Contract> getAllContracts();
    Contract getContractByID(String contract_id);
    List<Contract> getAllContractsFromClient(String cl_id);
    void addContract(Contract contract);
    void updateContract(Contract contract);
    void deleteContract(String contract_id);
}
