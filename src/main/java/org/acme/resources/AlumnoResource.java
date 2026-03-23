package org.acme.resources;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.AlumnoRequest;
import org.acme.dtos.AlumnoResponse;
import org.acme.service.AlumnoService;

import java.net.URI;
import java.util.List;

@Path("/api/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoResource {

    private final AlumnoService alumnoService;

    public AlumnoResource(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GET
    public List<AlumnoResponse> listar() {
        return alumnoService.listar();
    }

    @GET
    @Path("/{id}")
    public AlumnoResponse obtenerPorId(@PathParam("id") Long id) {
        return alumnoService.obtenerPorId(id);
    }

    @GET
    @Path("/buscar")
    public List<AlumnoResponse> buscarPorNombre(@QueryParam("nombre") String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return alumnoService.listar();
        }
        return alumnoService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/dni/{dni}")
    public List<AlumnoResponse> buscarPorDni(@PathParam("dni") String dni) {
        return alumnoService.buscarPorDni(dni);
    }

    @GET
    @Path("/escuela/{escuelaId}")
    public List<AlumnoResponse> buscarPorEscuela(@PathParam("escuelaId") Long escuelaId) {
        return alumnoService.buscarPorEscuela(escuelaId);
    }

    @POST
    public Response registrar(@Valid AlumnoRequest request) {
        AlumnoResponse response = alumnoService.registrar(request);
        return Response.created(URI.create("/api/alumnos/" + response.getId()))
                .entity(response)
                .build();
    }

    @PUT
    @Path("/{id}")
    public AlumnoResponse actualizar(@PathParam("id") Long id,
                                     @Valid AlumnoRequest request) {
        return alumnoService.actualizar(id, request);
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        alumnoService.eliminar(id);
        return Response.noContent().build();
    }
}