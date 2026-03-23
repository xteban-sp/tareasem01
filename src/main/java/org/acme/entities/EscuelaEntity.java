package org.acme.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "escuela")
public class EscuelaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 120)
    private String nombre;

    // Relación 1:N (una escuela tiene muchos alumnos)
    @OneToMany(mappedBy = "escuela", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlumnoEntity> alumnos;

    public EscuelaEntity() {
    }

    public EscuelaEntity(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<AlumnoEntity> getAlumnos() {
        return alumnos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlumnos(List<AlumnoEntity> alumnos) {
        this.alumnos = alumnos;
    }
}
