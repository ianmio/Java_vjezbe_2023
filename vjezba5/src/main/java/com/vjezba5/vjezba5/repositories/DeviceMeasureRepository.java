package com.vjezba5.vjezba5.repositories;

import com.vjezba5.vjezba5.entities.DeviceMeasure;
import com.vjezba5.vjezba5.handlers.DateClass;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DeviceMeasureRepository implements MainRepository<DeviceMeasure>{
    private static List<DeviceMeasure> measures;
    public DeviceMeasureRepository() {
        measures=new ArrayList<>();
    }
    public List<DeviceMeasure> getAll(){
        return measures;
    }
    public DeviceMeasure getById(Long x){
        DeviceMeasure tmp=new DeviceMeasure();
        for (DeviceMeasure m :measures) {
            if(m.getId()==x) {
                tmp=m;
                break;
            }
        }
        return tmp;
    }
    public void add(DeviceMeasure m) {
        measures.add(m);
    }
    public void deleteById(Long x) {
        for (DeviceMeasure m : measures) {
            if (m.getDeviceId()==x) {
                measures.remove(m);
                break;
            }
        }
    }
    public boolean findByDate(DateClass d) {
        boolean found=measures.stream().anyMatch(m->m.getDate().equals(d));
        return found;
    }
    public int getYearConsumption(int year) {
        return measures.stream()
                .filter(measure -> measure.getDate().getYear() == year)
                .mapToInt(measure -> measure.getValue())
                .sum();
    }
    public List<DeviceMeasure>getAllByYear(int year){
        return measures.stream()
                .filter(measure->measure.getDate().getYear()==year)
                .collect(Collectors.toList());
    }
    public DeviceMeasure getByMonthAndYear(int month,int year) {
        return measures.stream()
                .filter(measure->measure.getDate().getYear()==year && measure.getDate().getMonth()==month)
                .findAny().orElse(null);
    }

}
