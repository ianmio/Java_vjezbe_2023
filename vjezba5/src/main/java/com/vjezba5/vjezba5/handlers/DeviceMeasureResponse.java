package com.vjezba5.vjezba5.handlers;

import com.vjezba5.vjezba5.entities.DeviceMeasure;
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
