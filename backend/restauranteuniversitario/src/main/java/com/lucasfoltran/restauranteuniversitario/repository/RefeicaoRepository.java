package com.lucasfoltran.restauranteuniversitario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.lucasfoltran.restauranteuniversitario.entity.Refeicao;

@Repository
public interface RefeicaoRepository extends CrudRepository<Refeicao, Long> {

}
