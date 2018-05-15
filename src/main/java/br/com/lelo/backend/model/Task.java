package br.com.lelo.backend.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	@Column(name = "dod")
	private String definitionOfDone;

	@Enumerated(EnumType.STRING)
	private TaskPercepcaoEnum percepcao;

	private boolean concordancia;

	private Date done;

	@ElementCollection
	@CollectionTable(name = "Attendee", joinColumns = @JoinColumn(name = "taskid"))
	@Column(name = "name")
	private Set<String> participantes;

	public String getDefinitionOfDone() {
		return definitionOfDone;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<String> getParticipantes() {
		return participantes;
	}

	public TaskPercepcaoEnum getPercepcao() {
		return percepcao;
	}

	public Date getDone() {
		return done;
	}

	public void setDone(Date done) {
		this.done = done;
	}

	public void setConcordancia(boolean concordancia) {
		this.concordancia = concordancia;
	}

	public void setDefinitionOfDone(String definitionOfDone) {
		this.definitionOfDone = definitionOfDone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParticipantes(Set<String> participantes) {
		this.participantes = participantes;
	}

	public void setPercepcao(TaskPercepcaoEnum percepcao) {
		this.percepcao = percepcao;
	}

	public boolean isConcordancia() {
		return concordancia;
	}

}
