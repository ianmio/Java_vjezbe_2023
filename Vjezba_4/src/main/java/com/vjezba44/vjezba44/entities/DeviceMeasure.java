package com.vjezba44.vjezba44.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceMeasure {
    private Long id;
    private int value;
    private String unit;
    private Long deviceId;
}
