package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository repository;

    public HorarioService(HorarioRepository repository) {
        this.repository = repository;
    }

    public Horario criar(Horario h) {
        return repository.save(h);
    }

    public List<Horario> listar() {
        return repository.findAll();
    }

    public Horario buscarPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horário não encontrado"));
    }

    public Horario atualizar(int id, Horario dados) {
        Horario h = buscarPorId(id);

        h.setDescricao(dados.getDescricao());
        h.setDiaSemana(dados.getDiaSemana());
        h.setHoraInicio(dados.getHoraInicio());
        h.setHoraFim(dados.getHoraFim());

        return repository.save(h);
    }

    public void excluir(int id) {
        repository.deleteById(id);
    }
}
