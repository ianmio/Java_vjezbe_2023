package com.vjezba5.vjezba5.entities;

import com.vjezba5.vjezba5.handlers.DateClass;
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
    private DateClass date;
}
