package com.vjezba44.vjezba44.controllers;

import com.vjezba44.vjezba44.entities.DeviceMeasure;
import com.vjezba44.vjezba44.services.DeviceMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceMeasureController {
    @Autowired
    private DeviceMeasureService service;
    @GetMapping("/listDeviceMeasures")
    public ResponseEntity<List<DeviceMeasure>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllMeasures());
    }
    @PostMapping("/addDeviceMeasure")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addDeviceMeasure(@RequestBody DeviceMeasure d) {
        if(d==null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Measure is null");
        }
        service.addDeviceMeasure(d);
        return ResponseEntity.status(HttpStatus.OK).body("Measure added sucessfully");
    }
    @DeleteMapping("/deleteDeviceMeasure/{id}")
    public ResponseEntity<String>deleteDeviceMeasure(@PathVariable Long id){
        service.deleteDeviceMeasure(id);
        return ResponseEntity.status(HttpStatus.OK).body("Measure deleted");
    }
}
