package com.example.demo.PessoaRestService;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.Model.Aluno;
import com.example.demo.Model.Professor;
import com.example.demo.Model.Pessoa;
import com.example.demo.Request.AlterarNome;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class PessoaRestService {
    private List<Pessoa> pessoas = new ArrayList<>();

    @GetMapping("/pessoa/listar")
    public Map<String, List<Pessoa>> getPessoas() {
        List<Pessoa> alunos = pessoas.stream()
            .filter(p -> p instanceof Aluno)
            .collect(Collectors.toList());

        List<Pessoa> professores = pessoas.stream()
            .filter(p -> p instanceof Professor)
            .collect(Collectors.toList());

        return Map.of(
            "alunos", alunos,
            "professores", professores
        );
    }

    @PostMapping("/alunos/inserir")
    public List<Pessoa> insertAluno(@RequestBody @Valid Aluno aluno) {
        System.out.println("Inserindo aluno: " + aluno);
        pessoas.add(aluno);
        return pessoas;
    }

    @PostMapping("/professor/inserir")
    public List<Pessoa> insertProfessor(@RequestBody @Valid Professor professor) {
        System.out.println("Inserindo professor: " + professor);
        pessoas.add(professor);
        return pessoas;
    }

    @PutMapping("/pessoa/alterar")
    public String alterarNome(@RequestBody AlterarNome request) {
        Optional<Pessoa> pessoaEncontrada = pessoas.stream()
            .filter(p -> p.getNome().equalsIgnoreCase(request.getNomeAntigo()))
            .findFirst();

        if (pessoaEncontrada.isPresent()) {
            Pessoa pessoa = pessoaEncontrada.get();
            if (pessoa.getIdade() >= 18) {
                pessoa.setNome(request.getNovoNome());
                return "Nome da pessoa atualizado para " + request.getNovoNome();
            } else {
                return "Erro: Apenas maiores de 18 anos podem trocar de nome.";
            }
        }
        return "Erro: Pessoa não encontrada.";
    }
}
