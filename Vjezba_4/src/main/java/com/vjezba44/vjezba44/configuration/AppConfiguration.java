package com.vjezba44.vjezba44.configuration;

import com.vjezba44.vjezba44.entities.Address;
import com.vjezba44.vjezba44.entities.Client;
import com.vjezba44.vjezba44.entities.Device;
import com.vjezba44.vjezba44.entities.DeviceMeasure;
import com.vjezba44.vjezba44.repositories.ClientRepository;
import com.vjezba44.vjezba44.repositories.DeviceMeasureRepository;
import com.vjezba44.vjezba44.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AppConfiguration implements CommandLineRunner {

    @Autowired
    private DeviceMeasureRepository m;


    @Override
    public void run(String... args) throws Exception {
        var random=new Random();
        DeviceMeasure measure=new DeviceMeasure(15L, random.nextInt(), "Celsius", random.nextLong());
        m.add(measure);
    }
}