package br.com.fiap.guinchoseguro.model;

public class FuncionarioGuincho {
    private Guincho guincho;
    private Funcionario funcionario;

    public FuncionarioGuincho(Guincho guincho, Funcionario funcionario) {
        this.guincho = guincho;
        this.funcionario = funcionario;
    }

    public Guincho getGuincho() {
        return guincho;
    }

    public void setGuincho(Guincho guincho) {
        this.guincho = guincho;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String informacoesFuncionario() {
        return "FuncionarioGuincho{" +
                "guincho=" + guincho +
                ", funcionario=" + funcionario +
                '}';
    }
}
