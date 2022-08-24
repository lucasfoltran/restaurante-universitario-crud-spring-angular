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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lucasfoltran.restauranteuniversitario.controller.dto.DietaDTO;
import com.lucasfoltran.restauranteuniversitario.controller.dto.NovaDietaDTO;
import com.lucasfoltran.restauranteuniversitario.entity.Dieta;
import com.lucasfoltran.restauranteuniversitario.service.DietaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dietas")
@RequiredArgsConstructor
@Tag(name = "Dietas", description = "API para Dietas")
public class DietaController {

  private final DietaService dietaService;
  private final ModelMapper modelMapper;
  
  private Dieta convertToEntity(NovaDietaDTO novaDietaDTO) {
    return convertToEntity(new DietaDTO(null, novaDietaDTO.getNome(), novaDietaDTO.getDescricao()));
  }

  private Dieta convertToEntity(DietaDTO dietaDTO) {
    return modelMapper.map(dietaDTO, Dieta.class);
  }

  @GetMapping("/")
  public ResponseEntity<List<DietaDTO>> getDietas() {
    List<Dieta> result = StreamSupport.stream(dietaService.buscarTodasDietas().spliterator(), false).collect(Collectors.toList());
    if (result != null)
      return ResponseEntity.ok(
        // List<Dieta> stream map to List<DietaDTO>
        result.stream().map(d -> modelMapper.map(d, DietaDTO.class)).collect(Collectors.toList())
      );
    else 
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }


  @GetMapping("/{id}")
  public ResponseEntity<DietaDTO> getDieta(@PathVariable Long id) {
    Optional<Dieta> result = dietaService.buscarDieta(id);
    if (result.isPresent())
      return ResponseEntity.ok(modelMapper.map(result, DietaDTO.class));
    else 
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }
  
  @PostMapping
  public ResponseEntity<DietaDTO> criarDieta(@RequestBody NovaDietaDTO novaDietaDTO) {
    Dieta result = dietaService.salvarDieta(convertToEntity(novaDietaDTO));
    if (result != null)
      return ResponseEntity.ok(modelMapper.map(result, DietaDTO.class));
    else 
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
  }

  @PutMapping("/{id}")
  public ResponseEntity<DietaDTO> atualizarDieta(@PathVariable Long id, @RequestBody DietaDTO dietaDTO) {
    Dieta result = dietaService.salvarDieta(modelMapper.map(dietaDTO, Dieta.class));
    if (result != null)
      return ResponseEntity.ok(modelMapper.map(result, DietaDTO.class));
    else 
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void excluirDieta(@PathVariable Long id) {
    dietaService.excluirDieta(id);
  }
  
}
