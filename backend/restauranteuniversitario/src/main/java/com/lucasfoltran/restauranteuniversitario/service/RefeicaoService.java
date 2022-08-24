package com.lucasfoltran.restauranteuniversitario.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lucasfoltran.restauranteuniversitario.entity.Refeicao;
import com.lucasfoltran.restauranteuniversitario.repository.RefeicaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefeicaoService {

  private final RefeicaoRepository refeicaoRepository;

  public Optional<Refeicao> buscarRefeicao(Long id) {
    return refeicaoRepository.findById(id);
  }

  public Iterable<Refeicao> buscarTodasRefeicoes() {
    return refeicaoRepository.findAll();
  }

  public Refeicao salvarRefeicao(Refeicao refeicao) {
    return refeicaoRepository.save(refeicao);
  }

  public void excluirRefeicao(Long id) {
    refeicaoRepository.deleteById(id);
  }

}
