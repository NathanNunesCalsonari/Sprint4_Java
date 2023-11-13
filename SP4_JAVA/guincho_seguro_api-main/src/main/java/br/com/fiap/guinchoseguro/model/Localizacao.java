package br.com.fiap.guinchoseguro.model;

public class Localizacao {	
		private Long idLocalizacao;
		private Double coordenadaX;
		private Double coordenadaY;
		
		public Long getIdLocalizacao() {
			return idLocalizacao;
		}
		
		public void setIdLocalizacao(Long idLocalizacao) {
			this.idLocalizacao = idLocalizacao;
		}
		
		public Double getCoordenadaX() {
			return coordenadaX;
		}
		
		public void setCoordenadaX(Double coordenadaX) {
			this.coordenadaX = coordenadaX;
		}
		
		public Double getCoordenadaY() {
			return coordenadaY;
		}
		
		public void setCoordenadaY(Double coordenadaY) {
			this.coordenadaY = coordenadaY;
		}
		
		public String localDoAcidente () {
			return "Local:" + getCoordenadaX() + getCoordenadaY();
		}
}