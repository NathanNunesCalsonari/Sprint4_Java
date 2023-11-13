package br.com.fiap.guinchoseguro.service;

import br.com.fiap.guinchoseguro.data.GuinchoDao;
import br.com.fiap.guinchoseguro.model.Guincho;

import java.util.ArrayList;

public class GuinchoService {
    private final GuinchoDao guinchoDao;

    public GuinchoService() {
        this.guinchoDao = new GuinchoDao();
    }

    public ArrayList<Guincho> listaDeGuinchos() {
        return guinchoDao.listaDeGuinchos();
    }

    public Guincho obterGuinchoPorId(long guinchoId) {
        return guinchoDao.obterGuinchoPorId(guinchoId);
    }

    public boolean deletarGuincho(long guinchoId) {
        return guinchoDao.deletarGuincho(guinchoId);
    }

    public boolean novoGuincho(Guincho novoGuincho) {
        return guinchoDao.novoGuincho(novoGuincho);
    }

    public boolean atualizarGuincho(long guinchoId, Guincho guincho) {
        return guinchoDao.atualizarGuincho(guinchoId, guincho);
    }
}
