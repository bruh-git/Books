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
		Livro l1 = new Livro();
		Livro l2 = new Livro();
		l1.setIsbn("121312312");
		l1.setTitulo("Duna");
		l2.setIsbn("121312313");
		l2.setTitulo("Padrões de Projeto");
		
		LivroService service = new LivroService();
		service.save(l1);
		service.save(l2);
		
		List<Livro> livros = service.list();
		
		livros.forEach((livro) -> {
			System.out.println(livro);
		});

	}

}
