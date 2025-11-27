package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.*;
import com.prim21.PRIM21.Cross.Training.service.AdministradorService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping("/alunos/cadastrar")
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return administradorService.cadastrarAluno(aluno);
    }

    @PutMapping("/alunos/atualizar")
    public Aluno atualizarAluno(@RequestBody Aluno aluno) {
        return administradorService.atualizarAluno(aluno);
    }

    @PostMapping("/mensalidades/{id}/pagar")
    public Mensalidade registrarPagamento(@PathVariable int id,
                                          @RequestParam Date data) {
        return administradorService.registrarPagamento(id, data);
    }

    @PostMapping("/horarios/criar")
    public Horario criarHorario(@RequestBody Horario horario) {
        return administradorService.criarHorario(horario);
    }

    @PostMapping("/agendar")
    public MatriculaHorario agendar(
            @RequestParam int alunoId,
            @RequestParam int horarioId) {
        return administradorService.agendarAlunoEmHorario(alunoId, horarioId);
    }

    @PostMapping("/reposicoes/{alunoId}")
    public ReposicaoAula registrarReposicao(@PathVariable int alunoId,
                                            @RequestBody ReposicaoAula reposicao) {
        return administradorService.registrarReposicao(alunoId, reposicao);
    }

    @GetMapping("/relatorio/inadimplentes")
    public List<Aluno> gerarRelatorioInadimplentes() {
        return administradorService.gerarRelatorioInadimplentes();
    }
}
