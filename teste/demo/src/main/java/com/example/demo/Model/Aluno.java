package com.example.demo.Model;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Aluno extends Pessoa {

    public Aluno(String nome, Integer idade, String cpf ) {
        super(nome, idade, cpf);  // Chama o construtor da classe mãe (Pessoa)
    }
     @NotNull(message = "Nome não pose ser nulo")
     @NotBlank(message = "Nome não pose ser branco")
    private String curso;
   
    public String getCurso() {
        return curso;

    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
