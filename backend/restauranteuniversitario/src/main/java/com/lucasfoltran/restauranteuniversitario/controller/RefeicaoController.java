package com.lucasfoltran.restauranteuniversitario.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lucasfoltran.restauranteuniversitario.controller.dto.NovaRefeicaoDTO;
import com.lucasfoltran.restauranteuniversitario.controller.dto.RefeicaoDTO;
import com.lucasfoltran.restauranteuniversitario.entity.Dieta;
import com.lucasfoltran.restauranteuniversitario.entity.Refeicao;
import com.lucasfoltran.restauranteuniversitario.service.RefeicaoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/refeicoes")
@RequiredArgsConstructor
@Tag(name = "Refeicoes", description = "API para Refeicoes")
public class RefeicaoController {

  private final RefeicaoService refeicaoService;
  private final ModelMapper modelMapper;

  private Refeicao convertToEntity(NovaRefeicaoDTO novaRefeicaoDTO) {
    return convertToEntity(new RefeicaoDTO(null, novaRefeicaoDTO.getNome(), novaRefeicaoDTO.getIdDieta()));
  }

  private Refeicao convertToEntity(RefeicaoDTO refeicaoDTO) {
    Refeicao refeicao = modelMapper.map(refeicaoDTO, Refeicao.class);
    if(refeicaoDTO.getIdDieta()!=null) {
      refeicao.setDieta(new Dieta());
      refeicao.getDieta().setId(refeicaoDTO.getIdDieta());
    }
    return refeicao;
  }

  private RefeicaoDTO convertFromEntity(Refeicao refeicao) {
    RefeicaoDTO refeicaoDTO = modelMapper.map(refeicao, RefeicaoDTO.class);
    if(refeicao.getDieta()!=null) refeicaoDTO.setIdDieta(refeicao.getDieta().getId());
    return refeicaoDTO;
  }

  @GetMapping("/")
  public ResponseEntity<List<RefeicaoDTO>> getRefeicoes() {
    List<Refeicao> result = StreamSupport.stream(refeicaoService.buscarTodasRefeicoes().spliterator(), false).collect(Collectors.toList());
    if (result != null)
      return ResponseEntity.ok(
        // List<Refeicao> stream map to List<RefeicaoDTO>
        result.stream().map(this::convertFromEntity).collect(Collectors.toList())
      );
    else 
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }


  @GetMapping("/{id}")
  public ResponseEntity<RefeicaoDTO> getRefeicao(@PathVariable Long id) {
    Optional<Refeicao> result = refeicaoService.buscarRefeicao(id);
    if (result.isPresent())
      return ResponseEntity.ok(convertFromEntity(result.get()));
    else 
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }
  
  @PostMapping
  public ResponseEntity<RefeicaoDTO> criarRefeicao(@RequestBody NovaRefeicaoDTO novaRefeicaoDTO) {
    Refeicao result = refeicaoService.salvarRefeicao(convertToEntity(novaRefeicaoDTO));
    if (result != null)
      return ResponseEntity.ok(modelMapper.map(result, RefeicaoDTO.class));
    else 
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RefeicaoDTO> atualizarRefeicao(@PathVariable Long id, @RequestBody RefeicaoDTO refeicaoDTO) {
    Refeicao result = refeicaoService.salvarRefeicao(convertToEntity(refeicaoDTO));
    if (result != null)
      return ResponseEntity.ok(convertFromEntity(result));
    else 
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void excluirRefeicao(@PathVariable Long id) {
    refeicaoService.excluirRefeicao(id);
  }
  
}
