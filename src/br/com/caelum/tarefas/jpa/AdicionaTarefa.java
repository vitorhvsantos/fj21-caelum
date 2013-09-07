package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class AdicionaTarefa {

	public static void main(String[] args) {
		Tarefa t1 = new Tarefa();
		t1.setDescricao("Chico fj21");
		t1.setFinalizado(true);
		t1.setDataFinalizacao(Calendar.getInstance());

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("tarefas");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(t1);
		manager.getTransaction().commit();

		System.out.println("id da tarefa: " + t1.getId());

		manager.close();

	}

}
