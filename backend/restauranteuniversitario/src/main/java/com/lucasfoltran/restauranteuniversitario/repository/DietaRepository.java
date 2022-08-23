package com.lucasfoltran.restauranteuniversitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasfoltran.restauranteuniversitario.entity.Dieta;

@Repository
public interface DietaRepository extends JpaRepository<Dieta, Long> {

}
