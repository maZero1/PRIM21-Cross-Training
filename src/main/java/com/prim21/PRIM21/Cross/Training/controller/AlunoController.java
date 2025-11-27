package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable int id) {
        return alunoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable int id, @RequestBody Aluno alunoAtualizado) {
        return alunoService.atualizar(id, alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) {
        alunoService.excluir(id);
    }
}
