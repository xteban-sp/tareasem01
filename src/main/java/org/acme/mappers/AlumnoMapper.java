package org.acme.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dtos.AlumnoRequest;
import org.acme.dtos.AlumnoResponse;
import org.acme.entities.AlumnoEntity;
import org.acme.entities.EscuelaEntity;
import org.acme.errors.EscuelaNotFoundException;
import org.acme.repositories.EscuelaRepository;

@ApplicationScoped
public class AlumnoMapper {

    @Inject
    EscuelaRepository escuelaRepository;

    public AlumnoEntity toEntity(AlumnoRequest request) {
        EscuelaEntity escuela = escuelaRepository.findByIdOptional(request.getEscuelaId())
                .orElseThrow(() -> new EscuelaNotFoundException(request.getEscuelaId()));

        AlumnoEntity entity = new AlumnoEntity();
        entity.setDni(request.getDni());
        entity.setApellidos(request.getApellidos());
        entity.setNombres(request.getNombres());
        entity.setFechaNac(request.getFechaNac());
        entity.setDireccion(request.getDireccion());
        entity.setTelefono(request.getTelefono());
        entity.setCorreo(request.getCorreo());
        entity.setEscuela(escuela);

        return entity;
    }

    public AlumnoResponse toResponse(AlumnoEntity entity) {
        return new AlumnoResponse(
                entity.getId(),
                entity.getDni(),
                entity.getApellidos(),
                entity.getNombres(),
                entity.getFechaNac(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getCorreo(),
                entity.getEscuela().getId(),
                entity.getEscuela().getNombre()
        );
    }

    public void updateEntity(AlumnoEntity entity, AlumnoRequest request) {
        EscuelaEntity escuela = escuelaRepository.findByIdOptional(request.getEscuelaId())
                .orElseThrow(() -> new EscuelaNotFoundException(request.getEscuelaId()));

        entity.setDni(request.getDni());
        entity.setApellidos(request.getApellidos());
        entity.setNombres(request.getNombres());
        entity.setFechaNac(request.getFechaNac());
        entity.setDireccion(request.getDireccion());
        entity.setTelefono(request.getTelefono());
        entity.setCorreo(request.getCorreo());
        entity.setEscuela(escuela);
    }
}