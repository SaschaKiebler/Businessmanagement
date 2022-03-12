package de.saschakiebler.businessmanagement.service;

import de.saschakiebler.businessmanagement.model.Bill;
import de.saschakiebler.businessmanagement.model.Client;
import de.saschakiebler.businessmanagement.repository.BillRepository;
import de.saschakiebler.businessmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BillService {

    BillRepository billRepository;

    ClientRepository clientRepository;

    public BillService(BillRepository billRepository, ClientRepository clientRepository) {
        this.billRepository = billRepository;
        this.clientRepository = clientRepository;
    }

    public void addBill(Bill bill){

        billRepository.addBill(bill);
    }

    public Bill getBillByNumber(String billNumber){

        if(RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(billNumber))
            return billRepository.getBillByNumber(billNumber);

        return null;
    }

    public Bill getBillByID(String bill_id){
        if (RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(bill_id))
            return billRepository.getBillByID(bill_id);

        return null;
    }

    public List<Bill> getAllBillsFromClient(String client_id){
        if (RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(client_id)) {
            Client client = clientRepository.getClientByID(client_id);
            return billRepository.getAllBillsFromClient(client);
        }
        return null;
    }

    public void updateBill(Bill bill){
        if (RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(bill.toString()))
        billRepository.updateBill(bill);
    }

    public void deleteBill(String bill_id){
        if (RecognizeIllegalInputStatements.recognizeAnySQLRelevantWords(bill_id))
        billRepository.deleteBill(bill_id);
    }
}
