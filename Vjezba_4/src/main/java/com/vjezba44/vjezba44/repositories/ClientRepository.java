package com.vjezba44.vjezba44.repositories;

import com.vjezba44.vjezba44.entities.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository implements MainRepository<Client>{
    private static List<Client> clients=new ArrayList<>();
    public List<Client> getAll(){
        return clients;
    };
    public Client getById(Long x) {
        Client t = null;
        for (Client u:clients) {
            if(u.getDeviceId()==x) {
                return u;
            }
        }
        return t;
    };
    public void add(Client u) {
        clients.add(u);
    };
    public void deleteById(Long x) {
        for(Client u:clients) {
            if(u.getId()==x) {
                clients.remove(u);
            }
        }
    };

}
