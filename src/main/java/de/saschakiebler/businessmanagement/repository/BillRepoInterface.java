package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Bill;
import de.saschakiebler.businessmanagement.model.Client;

import java.util.List;

public interface BillRepoInterface {
    public void addBill(Bill bill);
    public Bill getBillByNumber(String billnumber);
    public Bill getBillByID(String bill_id);
    public List<Bill> getAllBillsFromClient(Client client);
    public void updateBill(Bill bill);

}
