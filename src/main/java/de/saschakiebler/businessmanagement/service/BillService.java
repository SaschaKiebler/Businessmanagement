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

    @Autowired
    BillRepository billRepository;

    @Autowired
    ClientRepository clientRepository;

    public void addBill(Bill bill){

        billRepository.addBill(bill);
    }

    public Bill getBillByNumber(String billNumber){

        return billRepository.getBillByNumber(billNumber);
    }

    public Bill getBillByID(String bill_id){

        return billRepository.getBillByID(bill_id);
    }

    public List<Bill> getAllBillsFromClient(String client_id){
        Client client = clientRepository.getClientByID(client_id);
        return billRepository.getAllBillsFromClient(client);
    }

    public void updateBill(Bill bill){

        billRepository.updateBill(bill);
    }

    public void deleteBill(String bill_id){
        billRepository.deleteBill(bill_id);
    }
}
