package com.vjezba5.vjezba5.controllers;

import com.vjezba5.vjezba5.entities.DeviceMeasure;
import com.vjezba5.vjezba5.handlers.DeviceMeasureResponse;
import com.vjezba5.vjezba5.services.DeviceMeasureService;
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
        return ResponseEntity.status(HttpStatus.OK).body("Measure added sucesfully");
    }
    @DeleteMapping("/deleteDeviceMeasure/{id}")
    public ResponseEntity<String>deleteDeviceMeasure(@PathVariable Long id){
        service.deleteDeviceMeasure(id);
        return ResponseEntity.status(HttpStatus.OK).body("Measure deleted");
    }
    @PutMapping("/deviceMeasure/update/{id}")
    public ResponseEntity<String> updateMeasure(@PathVariable Long id,@RequestBody DeviceMeasure m) {
        DeviceMeasure measure=service.findMeasureById(id);
        measure.setValue(m.getValue());
        return ResponseEntity.status(HttpStatus.OK).body("Measure updated");
    }
    @GetMapping("/deviceConsumption")
    public  ResponseEntity<DeviceMeasureResponse> getConsumptionByYear(@RequestParam String year, @RequestParam(required=false) String month) {
        var measureResponse=service.getConsumption(year, month);
        if(measureResponse.getDescription().equals("Invalid parameters")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(measureResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(measureResponse);
        }
    }

}
