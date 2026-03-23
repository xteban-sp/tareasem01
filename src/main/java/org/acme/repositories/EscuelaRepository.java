package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.EscuelaEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EscuelaRepository implements PanacheRepository<EscuelaEntity> {

    public List<EscuelaEntity> listarTodos() {
        return listAll();
    }

    public Optional<EscuelaEntity> buscarPorId(Long id) {
        return findByIdOptional(id);
    }

    public List<EscuelaEntity> buscarPorNombre(String nombre) {
        return find("lower(nombre) like lower(?1)", "%" + nombre + "%").list();
    }
}