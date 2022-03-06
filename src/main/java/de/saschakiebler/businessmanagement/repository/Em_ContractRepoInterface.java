package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Em_Contract;

import java.util.List;
import java.util.UUID;

public interface Em_ContractRepoInterface {

    public void addEm_Contract(Em_Contract em_contract);
    public void deleteEm_Contract(Em_Contract em_contract);
    public void updateEm_Contract(Em_Contract em_contract);
    public Em_Contract getEm_ContractByID(String em_contract_id);
    public List<Em_Contract> getAllEm_Contract();
    public List<Em_Contract> getAllEm_ContractsOfContract(String contract_id);
    public List<Em_Contract> getAllEm_ContractsOfEmployee(String em_id);
    public int getAllHoursOfEmployeeFromContract(String em_id, String contract_id);

}
