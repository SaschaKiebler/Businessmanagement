package de.saschakiebler.businessmanagement.controller;

import de.saschakiebler.businessmanagement.exceptions.ClientNotFoundException;
import de.saschakiebler.businessmanagement.model.Contract;
import de.saschakiebler.businessmanagement.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contract")
@CrossOrigin("*")
public class ContractController {

    ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public List<Contract> getAllContracts(){
        return contractService.getAllContracts();
    }

    @GetMapping(path = "/get/{contract_id}")
    public Contract getContractByID(@PathVariable String contract_id){
        return contractService.getContractByID(contract_id);
    }

    @GetMapping(path = "/get/client/{cl_id}")
    public List<Contract> getAllContractsFromClient(@PathVariable String cl_id){
        try {
            return contractService.getAllContractsFromClient(cl_id);
        }catch (ClientNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
        }

    @PostMapping(path = "/new")
    public void addContract(@RequestBody Contract contract){
        contractService.addContract(contract);
    }

    @PutMapping(path = "/update")
    public void updateContract(@RequestBody Contract contract){
        contractService.updateContract(contract);
    }

    @DeleteMapping(path = "/delete/{contract_id}")
    public void deleteContract(@PathVariable String contract_id){
        contractService.deleteContract(contract_id);
    }
}
