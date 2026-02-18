package com.dam2.ejemspringdisco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlumnoDto implements Serializable {
    private String nom;
    private DireccionDto dir;
}
