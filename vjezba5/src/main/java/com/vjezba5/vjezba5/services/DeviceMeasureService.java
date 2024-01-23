package com.vjezba5.vjezba5.services;

import com.vjezba5.vjezba5.entities.DeviceMeasure;
import com.vjezba5.vjezba5.handlers.DateClass;
import com.vjezba5.vjezba5.handlers.DeviceMeasureResponse;
import com.vjezba5.vjezba5.handlers.Handler;
import com.vjezba5.vjezba5.repositories.DeviceMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public boolean findMeasureByDate(DateClass d) {
        return measures.findByDate(d);
    }
    public int getConsumptionByYear(int year) {
        return measures.getYearConsumption(year);
    }
    public List<DeviceMeasure>getAllMeasuresByYear(int year){
        return measures.getAllByYear(year);
    }
    public DeviceMeasure getMeasureByMonthAndYear(int month,int year) {
        return measures.getByMonthAndYear(month, year);
    }
    public DeviceMeasureResponse getConsumption(String year, String month) {
        if(month==null &&year!=null && Handler.isNumeric(year) &&Integer.parseInt(year)>0){
            int y=Integer.parseInt(year);
            return new DeviceMeasureResponse(this.getConsumptionByYear(y), null, "Whole consumption for "+y+" year");
        }
        else if(month.equals("all") && Handler.isNumeric(year)) {
            int y=Integer.parseInt(year);
            List<DeviceMeasure>list=this.getAllMeasuresByYear(y);
            return list==null
                    ?new DeviceMeasureResponse(0, list, "No such records for "+y+" year")
                    :new DeviceMeasureResponse(0, list, "Alll measures for "+y+" year");
        }
        else if(Handler.isNumeric(month) && Integer.parseInt(month)>0 && Integer.parseInt(month)<=12 ) {
            var measure = this.getMeasureByMonthAndYear(Integer.parseInt(month),Integer.parseInt(year));
            List<DeviceMeasure> m=new ArrayList<>();
            m.add(measure);
            return	measure==null
                    ? new DeviceMeasureResponse(0,m, "No such records for "+Integer.parseInt(year)+" year and "+Integer.parseInt(month))
                    : new DeviceMeasureResponse(0,m, "Record for "+Integer.parseInt(year)+" year and "+Integer.parseInt(month));
        }
        else {
            return new DeviceMeasureResponse(0, null, "Invalid parameters");
        }
    }

}
