package br.com.fiap.guinchoseguro.resource;

import br.com.fiap.guinchoseguro.model.Segurado;
import br.com.fiap.guinchoseguro.service.SeguradoService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("segurado")
public class SeguradoResource {
    private final SeguradoService seguradoService;

    public SeguradoResource() {
        this.seguradoService = new SeguradoService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSegurados() {
        ArrayList<Segurado> segurados = seguradoService.listaDeSegurados();

        if (segurados != null) {
            return Response.ok(segurados).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getSeguradoPorId(@PathParam("id") long seguradoId) {
        Segurado segurado = seguradoService.obterSeguradoPorId(seguradoId);

        if (segurado != null) {
            return Response.ok(segurado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSeguradoPorId(@PathParam("id") long seguradoId) {
        boolean deleted = seguradoService.deletarSegurado(seguradoId);

        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response novoSegurado(Segurado segurado) {
        boolean created = seguradoService.novoSegurado(segurado);

        if (created) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response atualizarSegurado(@PathParam("id") long seguradoId, Segurado segurado) {
        boolean updated = seguradoService.atualizarSegurado(seguradoId, segurado);

        if (updated) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
