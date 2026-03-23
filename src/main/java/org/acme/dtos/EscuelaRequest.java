package org.acme.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EscuelaRequest {

    @NotBlank(message = "El nombre de la escuela es obligatorio")
    @Size(max = 120, message = "El nombre de la escuela no debe exceder 120 caracteres")
    private String nombre;

    public EscuelaRequest() {
    }

    public EscuelaRequest(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
