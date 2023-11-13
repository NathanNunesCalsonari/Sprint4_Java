package br.com.fiap.guinchoseguro.model;

public class Chamado {
	private Long idChamado;
	private String descricaoChamado;
	private String dataDoChamado;
	private Veiculo veiculo; 
	private Localizacao localizacao; 
	private FuncionarioGuincho funcionarioGuincho;

    public Chamado(Long idChamado, String descricaoChamado, String dataDoChamado, Veiculo veiculo, Localizacao localizacao, FuncionarioGuincho funcionarioGuincho) {
        this.idChamado = idChamado;
        this.descricaoChamado = descricaoChamado;
        this.dataDoChamado = dataDoChamado;
        this.veiculo = veiculo;
        this.localizacao = localizacao;
        this.funcionarioGuincho = funcionarioGuincho;
    }

    public Long getId() {
		return idChamado;
	}

	public void setId(Long idChamado) {
		this.idChamado = idChamado;
	}

	public String getDescricaoChamado() {
		return descricaoChamado;
	}

	public void setDescricaoChamado(String descricaoChamado) {
		this.descricaoChamado = descricaoChamado;
	}

	public String getDataDoChamado() {
		return dataDoChamado;
	}

	public void setDataDoChamado(String dataDoChamado) {
		this.dataDoChamado = dataDoChamado;
	}
	
    public String chamado() {
        return "Chamado{" +
                "Localização=" + localizacao.localDoAcidente() +
                ", veiculo=" + veiculo.informacoesVeiculo() +
                ", funcionario=" + funcionarioGuincho.informacoesFuncionario() +
                '}';
    }
}
