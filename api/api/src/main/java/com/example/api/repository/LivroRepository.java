package com.example.api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.example.api.entity.LivroEntity;


public class LivroRepository implements ILivroRepository {

    private Connection connection;

    public LivroRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public LivroEntity create(LivroEntity livroEntity) {
        String sql = "INSERT INTO tb_livro(id, titulo, autor, anoPublicacao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, livroEntity.getId());
            ps.setString(2, livroEntity.getTitulo());
            ps.setString(3, livroEntity.getAutor());
            ps.setInt(4, livroEntity.getAnoPublicacao());
            ps.executeUpdate();
            return livroEntity;
        } catch (SQLException e) {

            System.out.println("Erro ao cadastrar livro.");
        }
        return null;
    }

    @Override
    public List<LivroEntity> getAll() {
        List<LivroEntity> livros = new ArrayList<>();
        String sql = "SELECT * FROM tb_livro";
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                LivroEntity livro = new LivroEntity();
                livro.setId(rs.getLong("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setAnoPublicacao(rs.getInt("anoPublicacao"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            System.out.println("Erro");
        }
        return livros;
    }

    @Override
    public LivroEntity getById(Long id) {
        String sql = "SELECT * FROM tb_livro WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    LivroEntity livro = new LivroEntity();
                    livro.setId(rs.getLong("id"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setAutor(rs.getString("autor"));
                    livro.setAnoPublicacao(rs.getInt("anoPublicacao"));
                    return livro;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro");
        }
        return null;
    }

    @Override
    public void update(LivroEntity livroEntity) {
        String sql = "UPDATE tb_livro SET titulo = ?, autor = ?, anoPublicacao = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, livroEntity.getTitulo());
            ps.setString(2, livroEntity.getAutor());
            ps.setInt(3, livroEntity.getAnoPublicacao());
            ps.setLong(4, livroEntity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro");
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM tb_livro WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao deletar.");
        }

    }

}