package org.acme.dtos;

import java.time.LocalDate;

public class AlumnoResponse {

    private Long id;
    private String dni;
    private String apellidos;
    private String nombres;
    private LocalDate fechaNac;
    private String direccion;
    private String telefono;
    private String correo;

    private Long escuelaId;
    private String escuelaNombre;

    public AlumnoResponse() {
    }

    public AlumnoResponse(Long id, String dni, String apellidos, String nombres,
                          LocalDate fechaNac, String direccion, String telefono,
                          String correo, Long escuelaId, String escuelaNombre) {
        this.id = id;
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.escuelaId = escuelaId;
        this.escuelaNombre = escuelaNombre;
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

    public Long getEscuelaId() {
        return escuelaId;
    }

    public String getEscuelaNombre() {
        return escuelaNombre;
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

    public void setEscuelaId(Long escuelaId) {
        this.escuelaId = escuelaId;
    }

    public void setEscuelaNombre(String escuelaNombre) {
        this.escuelaNombre = escuelaNombre;
    }
}
