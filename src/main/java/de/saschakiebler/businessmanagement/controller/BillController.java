package de.saschakiebler.businessmanagement.controller;

import de.saschakiebler.businessmanagement.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import de.saschakiebler.businessmanagement.model.Bill;

import java.util.List;
@RestController
@RequestMapping(path = "/bill")
@CrossOrigin("*")
public class BillController {


    BillService billService;

    @Autowired
    public BillController(BillService billService){
        this.billService=billService;
    }

    @PostMapping(path = "/add")
    public void addBill(@RequestBody Bill bill){
        billService.addBill(bill);
    }

    @GetMapping(path = "/rNumb/{billNumber}")
    public Bill getBillByNumber(@PathVariable String billNumber){
        return billService.getBillByNumber(billNumber);
    }

    @GetMapping(path = "/id/{bill_id}")
    public Bill getBillByID(@PathVariable String bill_id){
        return billService.getBillByID(bill_id);
    }

    @GetMapping(path = "/client/{client_id}")
    public List<Bill> getAllBillsFromClient(@PathVariable String client_id){

        return billService.getAllBillsFromClient(client_id);
    }
    @PutMapping(path = "/update")
    public void updateBill(@RequestBody Bill bill){
            billService.updateBill(bill);
    }
    @DeleteMapping(path = "/delete/{bill_id}")
    public void deleteBill(@PathVariable String bill_id){
        billService.deleteBill(bill_id);
    }
}
