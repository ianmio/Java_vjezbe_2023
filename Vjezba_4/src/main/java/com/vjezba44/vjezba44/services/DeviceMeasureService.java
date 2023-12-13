package com.vjezba44.vjezba44.services;

import com.vjezba44.vjezba44.entities.DeviceMeasure;
import com.vjezba44.vjezba44.repositories.DeviceMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMeasureService {
    DeviceMeasureRepository measures;
    @Autowired
    public DeviceMeasureService(DeviceMeasureRepository m) {
        measures=m;
    }
    public List<DeviceMeasure> getAllMeasures(){
        return measures.getAll();
    }
    public DeviceMeasure findMeasureById(Long x) {
        return measures.getById(x);
    }
    public void deleteDeviceMeasure(Long x) {
        measures.deleteById(x);
    }
    public void addDeviceMeasure(DeviceMeasure m) {
        measures.add(m);
    }
}
