package br.com.fiap.guinchoseguro.model;

public class Veiculo {
		private Long id;
		private String descricaoModificacao;
		private Double pesoDoVeiculo;
		private Segurado segurado;
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getDescricaoModificacao() {
			return descricaoModificacao;
		}
		
		public void setDescricaoModificacao(String descricaoModificacao) {
			this.descricaoModificacao = descricaoModificacao;
		}
		
		public Double getPesoDoVeiculo() {
			return pesoDoVeiculo;
		}
		
		public void setPesoDoVeiculo(Double pesoDoVeiculo) {
			this.pesoDoVeiculo = pesoDoVeiculo;
		}
		
		public String informacoesVeiculo() {
			return "Veiculo:" + segurado + getDescricaoModificacao() + getPesoDoVeiculo();
		}
}