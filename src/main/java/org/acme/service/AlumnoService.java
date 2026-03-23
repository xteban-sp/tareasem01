package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dtos.AlumnoRequest;
import org.acme.dtos.AlumnoResponse;
import org.acme.entities.AlumnoEntity;
import org.acme.errors.AlumnoNotFoundException;
import org.acme.mappers.AlumnoMapper;
import org.acme.repositories.AlumnoRepository;

import java.util.List;

@ApplicationScoped
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    public AlumnoService(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    public List<AlumnoResponse> listar() {
        return alumnoRepository.listarTodos()
                .stream()
                .map(alumnoMapper::toResponse)
                .toList();
    }

    public AlumnoResponse obtenerPorId(Long id) {
        AlumnoEntity entity = alumnoRepository.buscarPorId(id)
                .orElseThrow(() -> new AlumnoNotFoundException(id));

        return alumnoMapper.toResponse(entity);
    }

    @Transactional
    public AlumnoResponse registrar(AlumnoRequest request) {
        if (alumnoRepository.existePorDni(request.getDni())) {
            throw new RuntimeException("Ya existe un alumno con el DNI: " + request.getDni());
        }

        if (alumnoRepository.existePorCorreo(request.getCorreo())) {
            throw new RuntimeException("Ya existe un alumno con el correo: " + request.getCorreo());
        }

        AlumnoEntity entity = alumnoMapper.toEntity(request);
        alumnoRepository.persist(entity);
        return alumnoMapper.toResponse(entity);
    }

    @Transactional
    public AlumnoResponse actualizar(Long id, AlumnoRequest request) {
        AlumnoEntity entity = alumnoRepository.buscarPorId(id)
                .orElseThrow(() -> new AlumnoNotFoundException(id));

        if (!entity.getDni().equals(request.getDni()) && alumnoRepository.existePorDni(request.getDni())) {
            throw new RuntimeException("Ya existe un alumno con el DNI: " + request.getDni());
        }

        if (!entity.getCorreo().equals(request.getCorreo()) && alumnoRepository.existePorCorreo(request.getCorreo())) {
            throw new RuntimeException("Ya existe un alumno con el correo: " + request.getCorreo());
        }

        alumnoMapper.updateEntity(entity, request);
        return alumnoMapper.toResponse(entity);
    }

    @Transactional
    public void eliminar(Long id) {
        AlumnoEntity entity = alumnoRepository.buscarPorId(id)
                .orElseThrow(() -> new AlumnoNotFoundException(id));

        alumnoRepository.delete(entity);
    }

    public List<AlumnoResponse> buscarPorNombre(String nombre) {
        return alumnoRepository.buscarPorNombre(nombre)
                .stream()
                .map(alumnoMapper::toResponse)
                .toList();
    }

    public List<AlumnoResponse> buscarPorDni(String dni) {
        return alumnoRepository.buscarPorDni(dni)
                .stream()
                .map(alumnoMapper::toResponse)
                .toList();
    }

    public List<AlumnoResponse> buscarPorEscuela(Long escuelaId) {
        return alumnoRepository.buscarPorEscuela(escuelaId)
                .stream()
                .map(alumnoMapper::toResponse)
                .toList();
    }
}