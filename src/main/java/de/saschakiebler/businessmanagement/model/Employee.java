package de.saschakiebler.businessmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;


public class Employee {


    private UUID em_id;
    private String em_firstname;
    private String em_lastname;
    private String em_dob;
    private String em_citizenship;
    private char em_cathlic;
    private String em_taxnumber;

    public Employee() {
    }

    public Employee(UUID em_id) {
        this.em_id = em_id;
    }

    public Employee(UUID em_id, String em_firstname, String em_lastname, String em_dob, String em_citizenship, char em_cathlic, String em_taxnumber) {
        this.em_id = em_id;
        this.em_firstname = em_firstname;
        this.em_lastname = em_lastname;
        this.em_dob = em_dob;
        this.em_citizenship = em_citizenship;
        this.em_cathlic = em_cathlic;
        this.em_taxnumber = em_taxnumber;
    }

    public Employee(String em_firstname, String em_lastname, String em_dob, String em_citizenship, char em_cathlic, String em_taxnumber) {
        this.em_firstname = em_firstname;
        this.em_lastname = em_lastname;
        this.em_dob = em_dob;
        this.em_citizenship = em_citizenship;
        this.em_cathlic = em_cathlic;
        this.em_taxnumber = em_taxnumber;
    }

    public UUID getEm_id() {
        return em_id;
    }

    public void setEm_id(UUID em_id) {
        this.em_id = em_id;
    }

    public String getEm_firstname() {
        return em_firstname;
    }

    public void setEm_firstname(String em_firstname) {
        this.em_firstname = em_firstname;
    }

    public String getEm_lastname() {
        return em_lastname;
    }

    public void setEm_lastname(String em_lastname) {
        this.em_lastname = em_lastname;
    }

    public String getEm_dob() {
        return em_dob;
    }

    public void setEm_dob(String em_dob) {
        this.em_dob = em_dob;
    }

    public String getEm_citizenship() {
        return em_citizenship;
    }

    public void setEm_citizenship(String em_citizenship) {
        this.em_citizenship = em_citizenship;
    }

    public char getEm_cathlic() {
        return em_cathlic;
    }

    public void setEm_cathlic(char em_cathlic) {
        this.em_cathlic = em_cathlic;
    }

    public String getEm_taxnumber() {
        return em_taxnumber;
    }

    public void setEm_taxnumber(String em_taxnumber) {
        this.em_taxnumber = em_taxnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return em_cathlic == employee.em_cathlic && Objects.equals(em_id, employee.em_id) && Objects.equals(em_firstname, employee.em_firstname) && Objects.equals(em_lastname, employee.em_lastname) && Objects.equals(em_dob, employee.em_dob) && Objects.equals(em_citizenship, employee.em_citizenship) && Objects.equals(em_taxnumber, employee.em_taxnumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(em_id, em_firstname, em_lastname, em_dob, em_citizenship, em_cathlic, em_taxnumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "em_id=" + em_id +
                ", em_firstname='" + em_firstname + '\'' +
                ", em_lastname='" + em_lastname + '\'' +
                ", em_dob='" + em_dob + '\'' +
                ", em_citizenship='" + em_citizenship + '\'' +
                ", em_cathlic=" + em_cathlic +
                ", em_taxnumber='" + em_taxnumber + '\'' +
                '}';
    }
}
