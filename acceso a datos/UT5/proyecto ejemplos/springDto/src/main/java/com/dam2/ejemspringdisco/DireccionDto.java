package com.dam2.ejemspringdisco;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class DireccionDto implements Serializable {
    private  String nom;
    private  int num;
}
