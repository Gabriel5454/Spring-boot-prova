package com.example.demo.Model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Pessoa {
  @NotNull(message = "Nome não pose ser nulo")
    @NotBlank(message = "Nome não pose ser branco")
    private String nome;

    @NotNull(message = "idade não pose ser nulo")    
    private Integer idade;

    @CPF(message = "Cpf invalido")
    @NotNull(message = "Cpf não pose ser nulo")
    @NotBlank(message = "Cpf não pose ser branco")
    private String cpf;

    public Pessoa(String nome, Integer idade, String cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;

    }

    public void setIdade (Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;

    }

    public void setCpf (String cpf) {
        this.cpf = cpf;
    }

    
}
