package com.livro.java.hibernate;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.livro.java.hibernate.entity.Livro;
import com.livro.java.hibernate.service.LivroService;

public class Application {
	EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("com.livro.java.hibernate.samplehibernate");
	public static void main(String[] args) {
		Livro l = new Livro();
		l.setIsbn("121312312");
		l.setTitulo("Duna");
		
		LivroService service = new LivroService();
		service.save(l);
		
		List<Livro> livros = service.list();
		
		livros.forEach((livro) -> {
			System.out.println(livro);
		});

	}

}
