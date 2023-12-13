package com.vjezba44.vjezba44.repositories;

import com.vjezba44.vjezba44.entities.DeviceMeasure;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

}
