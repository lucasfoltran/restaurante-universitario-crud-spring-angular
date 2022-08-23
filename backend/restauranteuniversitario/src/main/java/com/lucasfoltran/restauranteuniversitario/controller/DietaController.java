package com.lucasfoltran.restauranteuniversitario.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lucasfoltran.restauranteuniversitario.entity.Dieta;
import com.lucasfoltran.restauranteuniversitario.service.DietaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dieta")
@RequiredArgsConstructor
public class DietaController {

  private final DietaService dietaService;

  @GetMapping("/{id}")
  public ResponseEntity<Dieta> getDieta(@PathVariable Long id) {
    Optional<Dieta> result = dietaService.buscarDieta(id);
    if (result.isPresent())
      return ResponseEntity.ok(result.get());
    else 
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }
  
}
