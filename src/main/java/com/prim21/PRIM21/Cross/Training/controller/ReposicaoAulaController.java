package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.service.ReposicaoAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reposicoes")
@CrossOrigin("*")
public class ReposicaoAulaController {

    @Autowired
    private ReposicaoAulaService reposicaoService;

    @GetMapping
    public List<ReposicaoAula> listar() {
        return reposicaoService.listar();
    }

    @GetMapping("/aluno/{id}")
    public List<ReposicaoAula> porAluno(@PathVariable Long id) {
        return reposicaoService.listarPorAluno(id);
    }

    @PostMapping
    public ReposicaoAula salvar(@RequestBody ReposicaoAula reposicao) {
        return reposicaoService.salvar(reposicao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        reposicaoService.deletar(id);
    }
}
