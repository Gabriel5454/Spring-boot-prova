package com.example.demo.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AlterarNome {

    @NotNull(message = "Nome não pose ser nulo")
    @NotBlank(message = "Nome não pose ser branco")
    private String nomeAntigo;

    @NotNull(message = "Nome não pose ser nulo")
    @NotBlank(message = "Nome não pose ser branco")
    private String novoNome;

    public String getNomeAntigo() {
        return nomeAntigo;
    }

    public void setNomeAntigo(String nomeAntigo) {
        this.nomeAntigo = nomeAntigo;
    }

    public String getNovoNome() {
        return novoNome;
    }

    public void setNovoNome(String novoNome) {
        this.novoNome = novoNome;
    }
}