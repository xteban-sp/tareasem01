package org.acme.entities;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "alumno")
public class AlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "fecha_nac", nullable = false)
    private LocalDate fechaNac;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "telefono", length = 9)
    private String telefono;

    @Column(name = "correo", nullable = false, length = 120, unique = true)
    private String correo;

    // Relación N:1 (muchos alumnos pertenecen a una escuela)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escuela_id", nullable = false)
    private EscuelaEntity escuela;

    public AlumnoEntity() {
    }

    public AlumnoEntity(Long id, String dni, String apellidos, String nombres,
                        LocalDate fechaNac, String direccion,
                        String telefono, String correo, EscuelaEntity escuela) {
        this.id = id;
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.escuela = escuela;
    }

    public Long getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public EscuelaEntity getEscuela() {
        return escuela;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEscuela(EscuelaEntity escuela) {
        this.escuela = escuela;
    }
}
