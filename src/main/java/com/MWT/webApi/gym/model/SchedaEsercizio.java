package com.MWT.webApi.gym.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "scheda_esercizio")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SchedaEsercizio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	public int id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "nome")
	private String nome;
	@Column(name = "info")
	private String info;
	@CreationTimestamp
	@Column(name = "data_inserimento")
	private Date dataInserimento;
	
    @ToString.Exclude()
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    private Utente utente;
	
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "scheda_esercizio_esercizio", joinColumns = 
	@JoinColumn(name = "scheda_esercizio_id", referencedColumnName = "id", nullable = true), 
				inverseJoinColumns = @JoinColumn(name = "esercizio_id", referencedColumnName = "id"))
    private List<Esercizio> esercizi;

}
