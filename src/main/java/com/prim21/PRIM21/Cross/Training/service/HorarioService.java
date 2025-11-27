package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public Horario criar(Horario horario) {
        return horarioRepository.save(horario);
    }

    public List<Horario> listar() {
        return horarioRepository.findAll();
    }

    public Horario buscarPorId(int id) {
        return horarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Horário não encontrado"));
    }

    public Horario atualizar(Horario horario) {
        return horarioRepository.save(horario);
    }

    public void excluir(int id) {
        horarioRepository.deleteById(id);
    }
}
