package com.lucasfoltran.restauranteuniversitario.service.aluno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasfoltran.restauranteuniversitario.domain.aluno.Aluno;
import com.lucasfoltran.restauranteuniversitario.domain.aluno.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }
    
}
