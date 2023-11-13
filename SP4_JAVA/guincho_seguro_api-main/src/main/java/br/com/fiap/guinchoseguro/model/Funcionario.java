package br.com.fiap.guinchoseguro.model;

public record Funcionario (	
			Long idFuncionario,
			String nomeFuncionario,
			String cpfFuncionario,
			String dataDeNascimento,
			Double salario
		) {}
