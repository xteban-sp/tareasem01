package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dtos.EscuelaRequest;
import org.acme.dtos.EscuelaResponse;
import org.acme.entities.EscuelaEntity;
import org.acme.errors.EscuelaNotFoundException;
import org.acme.mappers.EscuelaMapper;
import org.acme.repositories.EscuelaRepository;

import java.util.List;

@ApplicationScoped
public class EscuelaService {

    private final EscuelaRepository escuelaRepository;
    private final EscuelaMapper escuelaMapper;

    public EscuelaService(EscuelaRepository escuelaRepository, EscuelaMapper escuelaMapper) {
        this.escuelaRepository = escuelaRepository;
        this.escuelaMapper = escuelaMapper;
    }

    public List<EscuelaResponse> listar() {
        return escuelaRepository.listarTodos()
                .stream()
                .map(escuelaMapper::toResponse)
                .toList();
    }

    public EscuelaResponse obtenerPorId(Long id) {
        EscuelaEntity entity = escuelaRepository.buscarPorId(id)
                .orElseThrow(() -> new EscuelaNotFoundException(id));

        return escuelaMapper.toResponse(entity);
    }

    @Transactional
    public EscuelaResponse registrar(EscuelaRequest request) {
        EscuelaEntity entity = escuelaMapper.toEntity(request);
        escuelaRepository.persist(entity);
        return escuelaMapper.toResponse(entity);
    }

    @Transactional
    public EscuelaResponse actualizar(Long id, EscuelaRequest request) {
        EscuelaEntity entity = escuelaRepository.buscarPorId(id)
                .orElseThrow(() -> new EscuelaNotFoundException(id));

        escuelaMapper.updateEntity(entity, request);
        return escuelaMapper.toResponse(entity);
    }

    @Transactional
    public void eliminar(Long id) {
        EscuelaEntity entity = escuelaRepository.buscarPorId(id)
                .orElseThrow(() -> new EscuelaNotFoundException(id));

        escuelaRepository.delete(entity);
    }

    public List<EscuelaResponse> buscarPorNombre(String nombre) {
        return escuelaRepository.buscarPorNombre(nombre)
                .stream()
                .map(escuelaMapper::toResponse)
                .toList();
    }
}