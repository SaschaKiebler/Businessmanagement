package de.saschakiebler.businessmanagement.model;

import java.util.Objects;
import java.util.UUID;

public class Bill {

    private UUID bill_id;
    private UUID cl_id;
    private UUID contract_id;
    private String bill_number;
    private String bill_description;
    private double bill_sum;

    public Bill() {
    }

    public Bill(UUID bill_id, UUID cl_id, UUID contract_id, String bill_number, String bill_description, double bill_sum) {
        this.bill_id = bill_id;
        this.cl_id = cl_id;
        this.contract_id = contract_id;
        this.bill_number = bill_number;
        this.bill_description = bill_description;
        this.bill_sum = bill_sum;
    }

    public Bill(UUID cl_id, UUID contract_id, String bill_number, String bill_description, double bill_sum) {
        this.cl_id = cl_id;
        this.contract_id = contract_id;
        this.bill_number = bill_number;
        this.bill_description = bill_description;
        this.bill_sum = bill_sum;
    }

    public Bill(String bill_number, String bill_description, double bill_sum) {
        this.bill_number = bill_number;
        this.bill_description = bill_description;
        this.bill_sum = bill_sum;
    }

    public UUID getBill_id() {
        return bill_id;
    }

    public void setBill_id(UUID bill_id) {
        this.bill_id = bill_id;
    }

    public UUID getCl_id() {
        return cl_id;
    }

    public void setCl_id(UUID cl_id) {
        this.cl_id = cl_id;
    }

    public UUID getContract_id() {
        return contract_id;
    }

    public void setContract_id(UUID contract_id) {
        this.contract_id = contract_id;
    }

    public String getBill_number() {
        return bill_number;
    }

    public void setBill_number(String bill_number) {
        this.bill_number = bill_number;
    }

    public String getBill_description() {
        return bill_description;
    }

    public void setBill_description(String bill_description) {
        this.bill_description = bill_description;
    }

    public double getBill_sum() {
        return bill_sum;
    }

    public void setBill_sum(double bill_sum) {
        this.bill_sum = bill_sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(cl_id, bill.cl_id) && Objects.equals(contract_id, bill.contract_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cl_id, contract_id);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bill_id=" + bill_id +
                ", cl_id=" + cl_id +
                ", contract_id=" + contract_id +
                ", bill_number='" + bill_number + '\'' +
                ", bill_description='" + bill_description + '\'' +
                ", bill_sum=" + bill_sum +
                '}';
    }
}
