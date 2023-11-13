package br.com.fiap.guinchoseguro.resource;

import br.com.fiap.guinchoseguro.model.Guincho;
import br.com.fiap.guinchoseguro.service.GuinchoService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("guincho")
public class GuinchoResource {
    private final GuinchoService guinchoService;

    public GuinchoResource() {
        this.guinchoService = new GuinchoService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGuinchos() {
        ArrayList<Guincho> guinchos = guinchoService.listaDeGuinchos();

        if (guinchos != null) {
            return Response.ok(guinchos).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getGuinchoPorId(@PathParam("id") long guinchoId) {
        Guincho guincho = guinchoService.obterGuinchoPorId(guinchoId);

        if (guincho != null) {
            return Response.ok(guincho).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteGuinchoPorId(@PathParam("id") long guinchoId) {
        boolean deleted = guinchoService.deletarGuincho(guinchoId);

        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response novoGuincho(Guincho guincho) {
        boolean created = guinchoService.novoGuincho(guincho);

        if (created) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response atualizarGuincho(@PathParam("id") long guinchoId, Guincho guincho) {
        boolean updated = guinchoService.atualizarGuincho(guinchoId, guincho);

        if (updated) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
