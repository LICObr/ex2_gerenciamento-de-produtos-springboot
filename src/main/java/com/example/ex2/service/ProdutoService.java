package com.example.ex2.service;

import com.example.ex2.entity.Produto;
import com.example.ex2.repository.ProdutoRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto Save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto atualizar(Long id, Produto produto) {
        return produtoRepository.save(produto);
    }
}
