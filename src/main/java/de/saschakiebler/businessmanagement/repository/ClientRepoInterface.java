package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Client;

import java.util.List;

public interface ClientRepoInterface {

    List<Client> getAllClients();
    Client getClientByID(String cl_id);
    List<Client> getClientByName(String firstname, String lastname);
    Client getClientAge(String cl_id);
    void addClient(Client client);

}
