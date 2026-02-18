package com.dam2.ej1sprintializr;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,Long> {

}
