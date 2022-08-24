package com.lucasfoltran.restauranteuniversitario.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DietaDTO {
  Long id;
  String nome;
  String descricao;
}
