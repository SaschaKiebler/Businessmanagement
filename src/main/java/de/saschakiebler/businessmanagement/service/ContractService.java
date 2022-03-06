package de.saschakiebler.businessmanagement.service;

import de.saschakiebler.businessmanagement.exceptions.ClientNotFoundException;
import de.saschakiebler.businessmanagement.model.Contract;
import de.saschakiebler.businessmanagement.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService{

    ContractRepository contractRepository;
    ClientService clientService;

    @Autowired
    public ContractService(ContractRepository contractRepository, ClientService clientService) {
        this.contractRepository = contractRepository;
        this.clientService = clientService;
    }



    public List<Contract> getAllContracts() {
        return contractRepository.getAllContracts();
    }


    public Contract getContractByID(String contract_id) {
        if (RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(contract_id))
            return contractRepository.getContractByID(contract_id);

        return null;
    }


    public List<Contract> getAllContractsFromClient(String cl_id) throws ClientNotFoundException{
        if (RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(cl_id)){
        if (contractRepository.getAllContractsFromClient(cl_id).toArray().length==0)
            throw new ClientNotFoundException("client has no contracts");

        return contractRepository.getAllContractsFromClient(cl_id);}
        return null;
    }


    public void addContract(Contract contract) {
        if(RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(contract.toString()))
            contractRepository.addContract(contract);
    }


    public void updateContract(Contract contract) {
        if(RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(contract.toString()))
            contractRepository.updateContract(contract);
    }


    public void deleteContract(String contract_id) {
        if(RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(contract_id))
            contractRepository.deleteContract(contract_id);
    }
}
