package com.example.ex2.controller;

import com.example.ex2.entity.Produto;
import com.example.ex2.repository.ProdutoRepository;
import com.example.ex2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> request = produtoService.findAll();
        return ResponseEntity.ok(request);

    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto save = produtoService.save(produto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .path("/{id}").buildAndExpand(save.getId()).toUri();
            return ResponseEntity.created(uri).body(save);
    }
}
