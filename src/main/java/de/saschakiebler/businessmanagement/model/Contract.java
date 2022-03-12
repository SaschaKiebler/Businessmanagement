package de.saschakiebler.businessmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;
import java.util.UUID;

public class Contract {

    UUID contract_id;
    String contract_name;
    String contract_description;
    String contract_plannedstartdate;
    String contract_startdate;
    String contract_plannedenddate;
    String contract_enddate;

    public Contract() {
    }

    public Contract(UUID contract_id, String contract_name, String contract_description, String contract_plannedstartdate, String contract_startdate, String contract_plannedenddate, String contract_enddate) {
        this.contract_id = contract_id;
        this.contract_name = contract_name;
        this.contract_description = contract_description;
        this.contract_plannedstartdate = contract_plannedstartdate;
        this.contract_startdate = contract_startdate;
        this.contract_plannedenddate = contract_plannedenddate;
        this.contract_enddate = contract_enddate;
    }

    public Contract(String contract_name, String contract_description, String contract_plannedstartdate, String contract_startdate, String contract_plannedenddate, String contract_enddate) {
        this.contract_name = contract_name;
        this.contract_description = contract_description;
        this.contract_plannedstartdate = contract_plannedstartdate;
        this.contract_startdate = contract_startdate;
        this.contract_plannedenddate = contract_plannedenddate;
        this.contract_enddate = contract_enddate;
    }

    public Contract(String contract_name, String contract_description) {
        this.contract_name = contract_name;
        this.contract_description = contract_description;
    }

    public Contract(String contract_name, String contract_description, String contract_plannedstartdate) {
        this.contract_name = contract_name;
        this.contract_description = contract_description;
        this.contract_plannedstartdate = contract_plannedstartdate;
    }

    public Contract(String contract_name, String contract_description, String contract_plannedstartdate, String contract_startdate) {
        this.contract_name = contract_name;
        this.contract_description = contract_description;
        this.contract_plannedstartdate = contract_plannedstartdate;
        this.contract_startdate = contract_startdate;
    }

    public UUID getContract_id() {
        return contract_id;
    }

    public void setContract_id(UUID contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getContract_description() {
        return contract_description;
    }

    public void setContract_description(String contract_description) {
        this.contract_description = contract_description;
    }

    public String getContract_plannedstartdate() {
        return contract_plannedstartdate;
    }

    public void setContract_plannedstartdate(String contract_plannedstartdate) {
        this.contract_plannedstartdate = contract_plannedstartdate;
    }

    public String getContract_startdate() {
        return contract_startdate;
    }

    public void setContract_startdate(String contract_startdate) {
        this.contract_startdate = contract_startdate;
    }

    public String getContract_plannedenddate() {
        return contract_plannedenddate;
    }

    public void setContract_plannedenddate(String contract_plannedenddate) {
        this.contract_plannedenddate = contract_plannedenddate;
    }

    public String getContract_enddate() {
        return contract_enddate;
    }

    public void setContract_enddate(String contract_enddate) {
        this.contract_enddate = contract_enddate;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contract_id=" + contract_id +
                ", contract_name='" + contract_name + '\'' +
                ", contract_description='" + contract_description + '\'' +
                ", contract_plannedstartdate='" + contract_plannedstartdate + '\'' +
                ", contract_startdate='" + contract_startdate + '\'' +
                ", contract_plannedenddate='" + contract_plannedenddate + '\'' +
                ", contract_enddate='" + contract_enddate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(contract_name, contract.contract_name) && Objects.equals(contract_description, contract.contract_description) && Objects.equals(contract_plannedstartdate, contract.contract_plannedstartdate) && Objects.equals(contract_startdate, contract.contract_startdate) && Objects.equals(contract_plannedenddate, contract.contract_plannedenddate) && Objects.equals(contract_enddate, contract.contract_enddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contract_name, contract_description, contract_plannedstartdate, contract_startdate, contract_plannedenddate, contract_enddate);
    }
}
