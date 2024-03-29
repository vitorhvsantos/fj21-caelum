package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message="Nao pode ser nullo") @Size(min=4, message="nao pode ser menor que 4")
	private String descricao;
	private boolean finalizado;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFinalizacao;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	
	@Override
	public String toString() {
		
	return "Descricao: " + descricao + "\nFinalizado? " 
	+ finalizado + "\nData Finalizacao: " + dataFinalizacao.getTime(); 
	}

}
