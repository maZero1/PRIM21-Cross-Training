package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.service.MensalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensalidades")
@CrossOrigin("*")
public class MensalidadeController {

    @Autowired
    private MensalidadeService mensalidadeService;

    @GetMapping
    public List<Mensalidade> listar() {
        return mensalidadeService.listar();
    }

    @GetMapping("/aluno/{id}")
    public List<Mensalidade> porAluno(@PathVariable Long id) {
        return mensalidadeService.listarPorAluno(id);
    }

    @PostMapping
    public Mensalidade salvar(@RequestBody Mensalidade mensalidade) {
        return mensalidadeService.salvar(mensalidade);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        mensalidadeService.deletar(id);
    }
}
