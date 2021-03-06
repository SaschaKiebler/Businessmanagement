package de.saschakiebler.businessmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

public class Client {

    private UUID cl_id;
    private String cl_firstname;
    private String cl_lastname;
    private String cl_dob;


    public Client() {
    }

    public Client(String cl_firstname) {
        this.cl_firstname = cl_firstname;
    }


    public Client(String cl_firstname, String cl_lastname, String cl_dob) {
        this.cl_firstname = cl_firstname;
        this.cl_lastname = cl_lastname;
        this.cl_dob = cl_dob;
    }

    public Client(UUID cl_id, String cl_firstname, String cl_lastname, String cl_dob) {
        this.cl_id = cl_id;
        this.cl_firstname = cl_firstname;
        this.cl_lastname = cl_lastname;
        this.cl_dob = cl_dob;
    }

    public UUID getCl_id() {
        return cl_id;
    }

    public void setCl_id(UUID cli_id) {
        this.cl_id = cli_id;
    }

    public String getCl_firstname() {
        return cl_firstname;
    }

    public void setCl_firstname(String cl_firstname) {
        this.cl_firstname = cl_firstname;
    }

    public String getCl_lastname() {
        return cl_lastname;
    }

    public void setCl_lastname(String cl_lastname) {
        this.cl_lastname = cl_lastname;
    }

    public String getCl_dob() {
        return cl_dob;
    }

    public void setCl_dob(String cl_dob) {
        this.cl_dob = cl_dob;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cli_id=" + cl_id +
                ", cl_firstname='" + cl_firstname + '\'' +
                ", cl_lastname='" + cl_lastname + '\'' +
                ", cl_dob='" + cl_dob + '\'' +
                '}';
    }


}

