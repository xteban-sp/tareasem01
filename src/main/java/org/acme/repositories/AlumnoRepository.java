package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.AlumnoEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AlumnoRepository implements PanacheRepository<AlumnoEntity> {

    public List<AlumnoEntity> listarTodos() {
        return listAll();
    }

    public Optional<AlumnoEntity> buscarPorId(Long id) {
        return findByIdOptional(id);
    }

    public List<AlumnoEntity> buscarPorDni(String dni) {
        return find("dni", dni).list();
    }

    public List<AlumnoEntity> buscarPorNombre(String nombre) {
        return find("lower(nombres) like lower(?1) or lower(apellidos) like lower(?1)",
                "%" + nombre + "%").list();
    }

    public List<AlumnoEntity> buscarPorEscuela(Long escuelaId) {
        return find("escuela.id", escuelaId).list();
    }

    public boolean existePorDni(String dni) {
        return count("dni", dni) > 0;
    }

    public boolean existePorCorreo(String correo) {
        return count("correo", correo) > 0;
    }
}
