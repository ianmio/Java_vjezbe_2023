package com.vjezba5.vjezba5.services;

import com.vjezba5.vjezba5.entities.Device;
import com.vjezba5.vjezba5.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private DeviceRepository devices;
    @Autowired
    public DeviceService(DeviceRepository r) {
        devices=r;
    }
    public List<Device> findAllDevices(){
        return devices.getAll();
    }
    public Device findDeviceById(Long x) {
        return devices.getById(x);
    }
    public void deleteDevice(Long x) {
        devices.deleteById(x);
    }
    public void addDevice(Device d) {
        devices.add(d);
    }

}
