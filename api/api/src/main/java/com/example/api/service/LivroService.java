package com.example.api.service;

import java.util.List;

import com.example.api.entity.LivroEntity;
import com.example.api.repository.LivroRepository;


public class LivroService {

    public LivroService(LivroRepository repository){
        this.repository = repository;
    }
    
    private LivroRepository repository;

    public LivroEntity create(LivroEntity obj) {
        return repository.create(obj);
    }

    public List<LivroEntity> getAll() {
        return repository.getAll();
    }

    public LivroEntity getById(Long id) {
        return repository.getById(id);

    }

    public LivroEntity update(LivroEntity livro) {
        repository.update(livro);
        return livro;
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
