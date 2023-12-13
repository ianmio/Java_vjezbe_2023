package com.vjezba44.vjezba44.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    private Long id;
    private Long deviceId;
    private Address address;
}
