package com.dam2.ej1sprintializr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    @Override
    public void saveEmpleado(Empleado e) {
        empleadoRepository.save(e);
    }

    @Override
    public Empleado updateEmpleado(Long id, Empleado emp) {
        Empleado viejo = empleadoRepository.findById(id).get();
        String nombre = emp.getNom();
        if ((nombre != null) && !( nombre.isEmpty()))
            viejo.setNom(nombre);
        double sal = emp.getSalario();
        if (Objects.nonNull(sal))
            viejo.setSalario(sal);
        empleadoRepository.save(viejo);
        return viejo;
    }

    @Override
    public void deleteEmpleado(Long id) {
            empleadoRepository.deleteById(id);
    }
}
