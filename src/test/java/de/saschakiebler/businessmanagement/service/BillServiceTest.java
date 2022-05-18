package de.saschakiebler.businessmanagement.service;

import de.saschakiebler.businessmanagement.model.Bill;
import de.saschakiebler.businessmanagement.repository.BillRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BillServiceTest {

    @Test
    public void test_addBill_for_valid_input(){
        BillRepository billRepository = mock(BillRepository.class);
        Bill bill = new Bill();
        when(billRepository.addBill(bill)).thenReturn(true);
        BillService billService = new BillService(billRepository,null);
        assertTrue(billService.addBill(bill));
    }

    @Test
    public void test_addBill_for_invalid_input_add_Bill_with_same_id_twice(){
        BillRepository billRepository = mock(BillRepository.class);
        UUID id = UUID.randomUUID();
        Bill bill = new Bill(id);
        when(billRepository.addBill(bill)).thenReturn(false);
        BillService billService = new BillService(billRepository,null);
        billService.addBill(bill);
        assertFalse(billService.addBill(bill));
    }
}