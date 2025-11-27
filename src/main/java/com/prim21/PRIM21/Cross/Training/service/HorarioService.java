package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> listar() {
        return horarioRepository.findAll();
    }

    public Horario salvar(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Horario buscar(Long id) {
        return horarioRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        horarioRepository.deleteById(id);
    }
}
