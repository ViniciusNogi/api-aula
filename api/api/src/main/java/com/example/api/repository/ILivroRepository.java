package com.example.api.repository;

import java.util.List;

import com.example.api.entity.LivroEntity;

public interface ILivroRepository {
    public LivroEntity create(LivroEntity livroEntity);
    
    public List<LivroEntity> getAll();
    
    public LivroEntity getById(Long id);

    public void update(LivroEntity livroEntity);

    public void delete(Long id);
    
} 
