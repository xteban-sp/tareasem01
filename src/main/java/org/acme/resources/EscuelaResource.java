package org.acme.resources;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.EscuelaRequest;
import org.acme.dtos.EscuelaResponse;
import org.acme.service.EscuelaService;

import java.net.URI;
import java.util.List;

@Path("/api/escuelas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EscuelaResource {

    private final EscuelaService escuelaService;

    public EscuelaResource(EscuelaService escuelaService) {
        this.escuelaService = escuelaService;
    }

    @GET
    public List<EscuelaResponse> listar() {
        return escuelaService.listar();
    }

    @GET
    @Path("/{id}")
    public EscuelaResponse obtenerPorId(@PathParam("id") Long id) {
        return escuelaService.obtenerPorId(id);
    }

    @GET
    @Path("/buscar")
    public List<EscuelaResponse> buscarPorNombre(@QueryParam("nombre") String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return escuelaService.listar();
        }
        return escuelaService.buscarPorNombre(nombre);
    }

    @POST
    public Response registrar(@Valid EscuelaRequest request) {
        EscuelaResponse response = escuelaService.registrar(request);
        return Response.created(URI.create("/api/escuelas/" + response.getId()))
                .entity(response)
                .build();
    }

    @PUT
    @Path("/{id}")
    public EscuelaResponse actualizar(@PathParam("id") Long id,
                                      @Valid EscuelaRequest request) {
        return escuelaService.actualizar(id, request);
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        escuelaService.eliminar(id);
        return Response.noContent().build();
    }
}
