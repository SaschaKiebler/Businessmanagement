package de.saschakiebler.businessmanagement.service;

import de.saschakiebler.businessmanagement.model.Em_Contract;
import de.saschakiebler.businessmanagement.repository.Em_ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static de.saschakiebler.businessmanagement.service.RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords;

@Service
public class Em_ContractService {

    Em_ContractRepository em_contractRepository;

    @Autowired
    public Em_ContractService(Em_ContractRepository em_contractRepository) {
        this.em_contractRepository = em_contractRepository;
    }

    public void addEm_Contract(Em_Contract em_contract){
        if (recognizeAnySQLRelevantWords(em_contract.toString()))
            em_contractRepository.addEm_Contract(em_contract);
    }

    public void deleteEm_Contract(Em_Contract em_contract){
        if (recognizeAnySQLRelevantWords(em_contract.toString()))
            em_contractRepository.deleteEm_Contract(em_contract);
    }

    public void updateEm_Contract(Em_Contract em_contract){
        if (recognizeAnySQLRelevantWords(em_contract.toString()))
            em_contractRepository.updateEm_Contract(em_contract);
    }

    public Em_Contract getEm_contractById(String em_id){
        if (recognizeAnySQLRelevantWords(em_id))
            return em_contractRepository.getEm_ContractByID(em_id);
        else
            return null;
    }


}
