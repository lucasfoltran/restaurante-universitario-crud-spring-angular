package com.lucasfoltran.restauranteuniversitario.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Dieta {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dieta_gen")
  @SequenceGenerator(name="dieta_gen", sequenceName="dieta_seq", allocationSize = 1, initialValue = 4)
  Long id;

  String nome;

  String descricao;

  @OneToMany(mappedBy = "dieta")
  @JsonIgnore
  private List<Refeicao> refeicoes;

}
