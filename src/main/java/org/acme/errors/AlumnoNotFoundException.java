package org.acme.errors;

public class AlumnoNotFoundException extends RuntimeException {

    public AlumnoNotFoundException(Long id) {
        super("No existe el alumno con el id: " + id);
    }
}