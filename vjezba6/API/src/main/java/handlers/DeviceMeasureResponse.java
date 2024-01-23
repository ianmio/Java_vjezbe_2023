package handlers;

import entities.DeviceMeasure;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class DeviceMeasureResponse {
    private int consumption;
    private List<DeviceMeasure> measures;
    private String description;
}
