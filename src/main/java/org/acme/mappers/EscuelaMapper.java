package org.acme.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dtos.EscuelaRequest;
import org.acme.dtos.EscuelaResponse;
import org.acme.entities.EscuelaEntity;

@ApplicationScoped
public class EscuelaMapper {

    public EscuelaEntity toEntity(EscuelaRequest request) {
        EscuelaEntity entity = new EscuelaEntity();
        entity.setNombre(request.getNombre());
        return entity;
    }

    public EscuelaResponse toResponse(EscuelaEntity entity) {
        return new EscuelaResponse(
                entity.getId(),
                entity.getNombre()
        );
    }

    public void updateEntity(EscuelaEntity entity, EscuelaRequest request) {
        entity.setNombre(request.getNombre());
    }
}