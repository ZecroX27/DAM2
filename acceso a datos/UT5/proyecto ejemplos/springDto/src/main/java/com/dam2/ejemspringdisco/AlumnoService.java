package com.dam2.ejemspringdisco;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    boolean existeDisco(Long id);
    Optional<AlumnoDto> getDiscoById(Long id);
    List<AlumnoDto> getAll();
    void guarda(AlumnoDto ad);
    AlumnoDto actualiza(Long id, AlumnoDto ad);
    void borra(Long id);
}
