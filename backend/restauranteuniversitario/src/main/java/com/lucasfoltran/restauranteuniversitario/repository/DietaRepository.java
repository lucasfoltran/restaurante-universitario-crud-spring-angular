package com.lucasfoltran.restauranteuniversitario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.lucasfoltran.restauranteuniversitario.entity.Dieta;

@Repository
public interface DietaRepository extends CrudRepository<Dieta, Long> {

}
