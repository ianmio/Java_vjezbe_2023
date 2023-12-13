package com.vjezba44.vjezba44.controllers;

import com.vjezba44.vjezba44.entities.Client;
import com.vjezba44.vjezba44.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService service;
    @GetMapping("/listClients")
    public ResponseEntity<List<Client>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllClients());
    }
    @PostMapping("/addClients")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addClients(@RequestBody Client d) {
        if(d==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client is null");
        }
        service.addClient(d);
        return ResponseEntity.status(HttpStatus.OK).body("Client added!");
    }
    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<String>deleteClient(@PathVariable Long id){
        service.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Device deleted");
    }
}
