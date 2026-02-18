package com.dam2.ej1sprintializr;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    Optional<Empleado> findById(Long id);
    List<Empleado> findAll();
    void saveEmpleado(Empleado e);
    Empleado updateEmpleado(Long id, Empleado emp);

    void deleteEmpleado(Long id);
}
