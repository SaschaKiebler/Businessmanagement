package de.saschakiebler.businessmanagement.service;

import de.saschakiebler.businessmanagement.model.Client;
import de.saschakiebler.businessmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class ClientService {

    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientService() {
    }

    public List<Client> getAllClients(){
        return clientRepository.getAllClients();
    }

    public Client getClientByID(String cl_id){
        return clientRepository.getClientByID(cl_id);
    }

    public List<Client> getClientByName(Client cl_name){

        String[] fAndLname = cl_name.getCl_firstname().split(" ");
        fAndLname[0]=fAndLname[0].toLowerCase(Locale.ROOT);
        if(fAndLname.length==1) {
            return clientRepository.getClientByName(firstLetterToUpperCase(fAndLname[0]));
        }
            else{
            fAndLname[1]=fAndLname[1].toLowerCase(Locale.ROOT);
            return clientRepository.getClientByName(firstLetterToUpperCase(fAndLname[0]),firstLetterToUpperCase(fAndLname[1]));
        }
    }

    public void addClient(Client client){
        clientRepository.addClient(client);
    }

    private String firstLetterToUpperCase(String string){

        return string.substring(0,1).toUpperCase(Locale.ROOT)+string.substring(1);
    }

}