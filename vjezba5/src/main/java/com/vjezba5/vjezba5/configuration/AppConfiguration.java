package com.vjezba5.vjezba5.configuration;

import com.vjezba5.vjezba5.entities.DeviceMeasure;
import com.vjezba5.vjezba5.handlers.DateClass;
import com.vjezba5.vjezba5.repositories.DeviceMeasureRepository;
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
        var d1=new DateClass(1,1,2015);
        var d2=new DateClass(1,2,2015);

        var m1=new DeviceMeasure(1L,random.nextInt(),"K",new Random().nextLong(),d1);
        var m2=new DeviceMeasure(2L, random.nextInt(),"K",new Random().nextLong(),d2);
        m.add(m1);
        m.add(m2);
    }
}