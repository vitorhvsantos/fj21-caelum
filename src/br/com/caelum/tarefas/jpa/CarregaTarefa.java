package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class CarregaTarefa {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefa = manager.find(Tarefa.class, 2L);
		
		
		System.out.println("Tarefa: \n"+ tarefa);
		
		manager.close();
		
	}

}
