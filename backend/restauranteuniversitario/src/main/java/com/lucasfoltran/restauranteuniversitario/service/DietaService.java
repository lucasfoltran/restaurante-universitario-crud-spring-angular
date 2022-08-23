package com.lucasfoltran.restauranteuniversitario.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lucasfoltran.restauranteuniversitario.entity.Dieta;
import com.lucasfoltran.restauranteuniversitario.repository.DietaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DietaService {

  private final DietaRepository dietaRepository;

  public Optional<Dieta> buscarDieta(Long id) {
    return dietaRepository.findById(id);
  }

}
