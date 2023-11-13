package br.com.fiap.guinchoseguro.service;

import br.com.fiap.guinchoseguro.data.FuncionarioDao;
import br.com.fiap.guinchoseguro.model.Funcionario;

import java.util.ArrayList;

public class FuncionarioService {
    private final FuncionarioDao funcionarioDao;

    public FuncionarioService() {
        this.funcionarioDao = new FuncionarioDao();
    }

    public ArrayList<Funcionario> listaDeFuncionarios() {
        return funcionarioDao.listaDeFuncionarios();
    }

    public Funcionario obterFuncionarioPorId(long funcionarioId) {
        return funcionarioDao.obterFuncionarioPorId(funcionarioId);
    }

    public boolean deletarFuncionario(long funcionarioId) {
        return funcionarioDao.deletarFuncionario(funcionarioId);
    }

    public boolean novoFuncionario(Funcionario novoFuncionario) {
        return funcionarioDao.novoFuncionario(novoFuncionario);
    }

    public boolean atualizarFuncionario(long funcionarioId, Funcionario funcionario) {
        return funcionarioDao.atualizarFuncionario(funcionarioId, funcionario);
    }
}
