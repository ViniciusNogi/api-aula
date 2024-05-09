package com.example.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.LivroEntity;
import com.example.api.service.LivroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;







@RequestMapping(value = "/livros")
public class LivroController {

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }
    
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroEntity> create(@RequestBody LivroEntity obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.create(obj));
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(livroService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<LivroEntity>> getAll() {
        return ResponseEntity.ok().body(livroService.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroEntity> update(@PathVariable Long id, @RequestBody LivroEntity obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(livroService.update(obj));
    }
    
}
