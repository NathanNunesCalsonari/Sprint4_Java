package br.com.fiap.guinchoseguro.model;

public record Segurado (	
		Long idSegurado,
		String cpfSegurado,
		int numeroDaApolice
	) {}
