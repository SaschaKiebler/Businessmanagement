package de.saschakiebler.businessmanagement.controller;

import de.saschakiebler.businessmanagement.model.Client;
import de.saschakiebler.businessmanagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
@CrossOrigin("*")
public class ClientController {

    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService=clientService;
    }

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping(path = "/{id}")
    public Client getClientByID(@PathVariable String id){
        return clientService.getClientByID(id);
    }

    @GetMapping(path = "/search")
    public List<Client> getClientByName(@RequestBody Client name){

        return clientService.getClientByName(name);
    }

    @PostMapping(path = "/add")
    public void addClient(@RequestBody Client client){
        System.out.println("du huan");
        clientService.addClient(client);
    }

}
