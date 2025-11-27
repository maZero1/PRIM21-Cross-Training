package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.service.ReposicaoAulaService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reposicoes")
public class ReposicaoAulaController {

    private final ReposicaoAulaService reposicaoAulaService;

    public ReposicaoAulaController(ReposicaoAulaService reposicaoAulaService) {
        this.reposicaoAulaService = reposicaoAulaService;
    }

    @GetMapping("/{id}")
    public ReposicaoAula buscar(@PathVariable int id) {
        return reposicaoAulaService.buscar(id);
    }

    @GetMapping("/listar")
    public List<ReposicaoAula> listar() {
        return reposicaoAulaService.listar();
    }

    @PutMapping("/{id}/aprovar")
    public ReposicaoAula aprovar(@PathVariable int id,
                                 @RequestParam Date dataReposicao) {
        return reposicaoAulaService.aprovar(id, dataReposicao);
    }

    @PutMapping("/{id}/realizar")
    public ReposicaoAula registrarRealizacao(@PathVariable int id) {
        return reposicaoAulaService.registrarRealizacao(id);
    }

    @PutMapping("/{id}/cancelar")
    public ReposicaoAula cancelar(@PathVariable int id,
                                  @RequestParam String motivo) {
        return reposicaoAulaService.cancelar(id, motivo);
    }
}
