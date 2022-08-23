package com.lucasfoltran.restauranteuniversitario.restapi;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lucasfoltran.restauranteuniversitario.domain.aluno.Aluno;
import com.lucasfoltran.restauranteuniversitario.service.aluno.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoAPI {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno create(Aluno aluno){  
        return alunoService.save(aluno);   
    }

    @GetMapping
    public List<Aluno> findAll(){
        return alunoService.findAll();
    }
    
}
