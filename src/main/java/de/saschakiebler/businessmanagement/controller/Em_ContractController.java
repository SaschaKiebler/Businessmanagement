package de.saschakiebler.businessmanagement.controller;


import de.saschakiebler.businessmanagement.model.Em_Contract;
import de.saschakiebler.businessmanagement.service.Em_ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/em_contract")
public class Em_ContractController {

    Em_ContractService em_contractService;

    public Em_ContractController(Em_ContractService em_contractService) {
        this.em_contractService = em_contractService;
    }

    @PostMapping(path = "/add")
    public void addEm_Contract(@RequestBody Em_Contract em_contract){
        em_contractService.addEm_Contract(em_contract);
    }

    @DeleteMapping(path = "/delete")
    public void deleteEm_Contract(@RequestBody Em_Contract em_contract){
        em_contractService.deleteEm_Contract(em_contract);
    }

    @PutMapping(path = "/update")
    public void updateEm_Contract(@RequestBody Em_Contract em_contract){
        em_contractService.updateEm_Contract(em_contract);
    }

    @GetMapping(path = "/get/{em_id}")
    public Em_Contract getEm_ContractById(@PathVariable String em_id){
        return em_contractService.getEm_contractById(em_id);
    }

    @GetMapping(path = "/get/all")
    public List<Em_Contract> getAllEm_Contract(){
        return em_contractService.getAllEm_Contract();
    }

    @GetMapping(path = "/get/fromContract/{contract_id}")
    public List<Em_Contract> getAllEm_contractsOfContract(@PathVariable String contract_id){
        return em_contractService.getAllEm_ContractsOfContract(contract_id);
    }

    @GetMapping(path = "/get/fromEmployee/{em_id}")
    public List<Em_Contract> getAllEm_ContractsOfEmployee(@PathVariable String em_id){
        return em_contractService.getAllEm_ContractsOfEmployee(em_id);
    }

    @GetMapping(path = "/get/hoursFromEmployee/{em_id}/ofContract/{contract_id}")
    public int getAllHoursOfEmployeeFromContract(@PathVariable String em_id,@PathVariable String contract_id){
        return em_contractService.getAllHoursOfEmployeeFromContract(em_id,contract_id);
    }

}
