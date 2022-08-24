package com.lucasfoltran.restauranteuniversitario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Refeicao {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refeicao_gen")
  @SequenceGenerator(name="refeicao_gen", sequenceName="refeicao_seq", allocationSize = 1, initialValue = 2)
  Long id;

  @Column(nullable=false)
  String nome;

  @ManyToOne
  @JoinColumn(name="id_dieta")
  Dieta dieta;

}
