package com.example.demo.Model;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Professor extends Pessoa{
    public Professor(String nome, Integer idade, String cpf ) {
        super(nome, idade, cpf);  // Chama o construtor da classe mãe (Pessoa)
    }

    @NotNull(message = "Diciplina  não pose ser nulo")
    @NotBlank(message = "Diciplina não pose ser branco")
    private String diciplina;




    public String getDicipliba() {
        return diciplina;

    }

    public void setDiciplina (String diciplina) {
        this.diciplina = diciplina;
    }

    
}


