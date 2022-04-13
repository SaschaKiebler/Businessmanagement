package de.saschakiebler.businessmanagement.service;

import de.saschakiebler.businessmanagement.model.Bill;
import de.saschakiebler.businessmanagement.model.Client;
import de.saschakiebler.businessmanagement.repository.BillRepository;
import de.saschakiebler.businessmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.saschakiebler.businessmanagement.service.CheckIfStringIsValidUUID.*;
import static de.saschakiebler.businessmanagement.service.RecognizeIllegalInputStatements.*;


@Service
public class BillService {

    BillRepository billRepository;

    ClientRepository clientRepository;

    public BillService(BillRepository billRepository, ClientRepository clientRepository) {
        this.billRepository = billRepository;
        this.clientRepository = clientRepository;
    }



    public boolean addBill(Bill bill){

        return billRepository.addBill(bill);
    }

    public Bill getBillByNumber(String billNumber){

        if(recognizeAnySQLRelevantWords(billNumber))
            return billRepository.getBillByNumber(billNumber);

        return null;
    }

    public Bill getBillByID(String bill_id){
        if (recognizeAnySQLRelevantWords(bill_id) && checkIfStringIsValidUUID(bill_id))
            return billRepository.getBillByID(bill_id);

        return null;
    }

    public List<Bill> getAllBillsFromClient(String client_id){
        if (recognizeAnySQLRelevantWords(client_id) && checkIfStringIsValidUUID(client_id)) {
            Client client = clientRepository.getClientByID(client_id);
            return billRepository.getAllBillsFromClient(client);
        }
        return null;
    }

    public void updateBill(Bill bill){
        if (recognizeAnySQLRelevantWords(bill.toString()))
        billRepository.updateBill(bill);
    }

    public void deleteBill(String bill_id){
        if (recognizeAnySQLRelevantWords(bill_id) && checkIfStringIsValidUUID(bill_id))
        billRepository.deleteBill(bill_id);
    }
}
