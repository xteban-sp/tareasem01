package org.acme.errors;

public class EscuelaNotFoundException extends RuntimeException {

    public EscuelaNotFoundException(Long id) {
        super("No existe la escuela con el id: " + id);
    }
}