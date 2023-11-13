package br.com.fiap.guinchoseguro.resource;

import br.com.fiap.guinchoseguro.model.Funcionario;
import br.com.fiap.guinchoseguro.service.FuncionarioService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("funcionario")
public class FuncionarioResource {
    private final FuncionarioService funcionarioService;

    public FuncionarioResource() {
        this.funcionarioService = new FuncionarioService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFuncionarios() {
        ArrayList<Funcionario> funcionarios = funcionarioService.listaDeFuncionarios();

        if (funcionarios != null) {
            return Response.ok(funcionarios).build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getFuncionarioPorId(@PathParam("id") long funcionarioId) {
        Funcionario funcionario = funcionarioService.obterFuncionarioPorId(funcionarioId);

        if (funcionario != null) {
            return Response.ok(funcionario).build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteFuncionarioPorId(@PathParam("id") long funcionarioId) {
        boolean deleted = funcionarioService.deletarFuncionario(funcionarioId);

        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response novoFuncionario(Funcionario funcionario) {
        boolean created = funcionarioService.novoFuncionario(funcionario);

        if (created) {
            return Response.status(Response.Status.CREATED).build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response atualizarFuncionario(@PathParam("id") long funcionarioId, Funcionario funcionario) {
        boolean updated = funcionarioService.atualizarFuncionario(funcionarioId, funcionario);

        if (updated) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
