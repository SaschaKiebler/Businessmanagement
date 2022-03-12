package de.saschakiebler.businessmanagement.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.UUID;

public class Em_Contract {

    private UUID em_contract_id;
    private UUID em_id;
    private UUID contract_id;
    private int em_contract_hours;


    public Em_Contract() {
    }

    public Em_Contract(UUID em_contract_id, UUID em_id, UUID contract_id, int em_contract_hours) {
        this.em_contract_id = em_contract_id;
        this.em_id = em_id;
        this.contract_id = contract_id;
        this.em_contract_hours = em_contract_hours;
    }

    public Em_Contract(UUID em_id, UUID contract_id, int em_contract_hours) {
        this.em_id = em_id;
        this.contract_id = contract_id;
        this.em_contract_hours = em_contract_hours;
    }

    public UUID getEm_contract_id() {
        return em_contract_id;
    }

    public void setEm_contract_id(UUID em_contract_id) {
        this.em_contract_id = em_contract_id;
    }

    public UUID getEm_id() {
        return em_id;
    }

    public void setEm_id(UUID em_id) {
        this.em_id = em_id;
    }

    public UUID getContract_id() {
        return contract_id;
    }

    public void setContract_id(UUID contract_id) {
        this.contract_id = contract_id;
    }

    public int getEm_contract_hours() {
        return em_contract_hours;
    }

    public void setEm_contract_hours(int em_contract_hours) {
        this.em_contract_hours = em_contract_hours;
    }

    @Override
    public String toString() {
        return "Em_Contract{" +
                "em_contract_id=" + em_contract_id +
                ", em_id=" + em_id +
                ", contract_id=" + contract_id +
                ", em_contract_hours=" + em_contract_hours +
                '}';
    }
}
