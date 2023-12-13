package com.vjezba44.vjezba44.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device{
    private Long id;
    private Set<DeviceMeasure> measures;
}
