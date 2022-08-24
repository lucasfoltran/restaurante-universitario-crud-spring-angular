package com.lucasfoltran.restauranteuniversitario.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefeicaoDTO {
  
  Long id;
  String nome;
  Long idDieta;

}
