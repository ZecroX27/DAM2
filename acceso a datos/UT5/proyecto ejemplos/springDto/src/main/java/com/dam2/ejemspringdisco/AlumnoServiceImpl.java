package com.dam2.ejemspringdisco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoRepository ar;

    @Override
    public boolean existeDisco(Long id) {
        if (ar.findById(id).isPresent())
            return true;
        return false;
    }

    @Override
    public Optional<AlumnoDto> getDiscoById(Long id) {
        return ar.findById(id).map(alumno -> mapToDTO(alumno, new AlumnoDto()));
    }

    @Override
    public List<AlumnoDto> getAll() {
         List<Alumno> alumnos = (List<Alumno>) ar.findAll();
         return alumnos.stream().
                 map(alumno -> mapToDTO(alumno, new AlumnoDto())).
                 toList();
    }

    @Override
    public void guarda(AlumnoDto ad) {
        Alumno alumno = new Alumno();
        mapToEntity(ad,alumno);
        ar.save(alumno);
    }

    @Override
    public AlumnoDto actualiza(Long id, AlumnoDto d) {
        Alumno aux = ar.findById(id).get();
        AlumnoDto auxdto = new AlumnoDto();
        auxdto = mapToDTO(aux,auxdto);
        if ((auxdto != null) && (auxdto.getNom() != null))
        {
            auxdto = d;
            //auxdto.setId(id);
            ar.save(aux);
            return auxdto;
        }
        return null;
    }

    @Override
    public void borra(Long id) {
        ar.deleteById(id);
    }

    private AlumnoDto mapToDTO(final Alumno alumno, final AlumnoDto alumnoDto) {
        alumnoDto.setNom(alumno.getNom());
        String nomVia = alumnoDto.getDir().getNom();
        int numVia = alumnoDto.getDir().getNum();
        DireccionDto dirDto = new DireccionDto(nomVia,numVia);
        alumnoDto.setDir(dirDto);
        return alumnoDto;
    }

    private Alumno mapToEntity(final AlumnoDto alumnoDto, final Alumno alumno) {
        alumno.setNom(alumnoDto.getNom());
        //alumnoDto.getDir();
       // Direccion direccion =
        alumno.getDir().setNom(alumnoDto.getDir().getNom());
        alumno.getDir().setNum(alumnoDto.getDir().getNum());
        return alumno;
    }
}
