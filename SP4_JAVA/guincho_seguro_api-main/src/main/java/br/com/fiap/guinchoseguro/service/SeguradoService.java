package br.com.fiap.guinchoseguro.service;

import br.com.fiap.guinchoseguro.data.SeguradoDao;
import br.com.fiap.guinchoseguro.model.Segurado;

import java.util.ArrayList;

public class SeguradoService {
    private final SeguradoDao seguradoDao;

    public SeguradoService() {
        this.seguradoDao = new SeguradoDao();
    }

    public ArrayList<Segurado> listaDeSegurados() {
        return seguradoDao.listaDeSegurados();
    }

    public Segurado obterSeguradoPorId(long seguradoId) {
        return seguradoDao.obterSeguradoPorId(seguradoId);
    }

    public boolean deletarSegurado(long seguradoId) {
        return seguradoDao.deletarSegurado(seguradoId);
    }

    public boolean novoSegurado(Segurado novoSegurado) {
        return seguradoDao.novoSegurado(novoSegurado);
    }

    public boolean atualizarSegurado(long seguradoId, Segurado segurado) {
        return seguradoDao.atualizarSegurado(seguradoId, segurado);
    }
}
