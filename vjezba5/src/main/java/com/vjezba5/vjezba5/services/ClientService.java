package com.vjezba5.vjezba5.services;

import com.vjezba5.vjezba5.entities.Client;
import com.vjezba5.vjezba5.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clients;
    @Autowired
    public ClientService(ClientRepository u) {
        this.clients=u;
    }

    public List<Client> findAllClients(){
        return clients.getAll();
    }
    public Client findClientById(Long x) {
        return clients.getById(x);
    }
    public void addClient(Client u) {
        clients.add(u);
    }
    public void deleteClient(Long x) {
        clients.deleteById(x);
    }
}
