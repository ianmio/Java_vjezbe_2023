package com.vjezba44.vjezba44.controllers;

import com.vjezba44.vjezba44.entities.Device;
import com.vjezba44.vjezba44.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    private DeviceService service;
    @GetMapping("/listDevices")
    public ResponseEntity<List<Device>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllDevices());
    }
    @PostMapping("/addDevice")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addDevice(@RequestBody Device d) {
        if(d==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Device is null");
        }
        service.addDevice(d);
        return ResponseEntity.status(HttpStatus.OK).body("Device added!");
    }
    @DeleteMapping("/deleteDevice/{id}")
    public ResponseEntity<String>deleteDevice(@PathVariable Long id){
        service.deleteDevice(id);
        return ResponseEntity.status(HttpStatus.OK).body("Device deleted");
    }
}
