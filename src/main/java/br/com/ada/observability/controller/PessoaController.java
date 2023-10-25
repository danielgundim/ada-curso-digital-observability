package br.com.ada.observability.controller;


import br.com.ada.observability.model.Pessoa;
import br.com.ada.observability.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        int random = new Random().nextInt(10);

        if (random <= 1 ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else if (random <= 3) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        System.out.println("Pessoa: " + pessoa);
        return pessoaRepository.save(pessoa);
    }
}

