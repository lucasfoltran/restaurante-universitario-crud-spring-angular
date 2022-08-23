package com.lucasfoltran.restauranteuniversitario.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dieta {

  @Id
  Long id;

  String nome;

  String descricao;

}
