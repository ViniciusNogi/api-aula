package com.example.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.api.config.DBConfig;
import com.example.api.entity.LivroEntity;
import com.example.api.repository.LivroRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		LivroEntity livro = new LivroEntity();
		
		livro.setAutor("Vinicius");
		livro.setTitulo("eu");
		livro.setAnoPublicacao(1991);

		var connection = DBConfig.getConnection();

		LivroRepository repository = new LivroRepository(connection);
		repository.create(livro);
		System.out.println(repository.getAll());
	}

}
