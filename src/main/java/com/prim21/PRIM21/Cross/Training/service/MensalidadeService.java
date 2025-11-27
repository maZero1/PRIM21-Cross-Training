package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.repository.MensalidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MensalidadeService {

    private final MensalidadeRepository repository;

    public MensalidadeService(MensalidadeRepository repository) {
        this.repository = repository;
    }

    public Mensalidade criar(Mensalidade m) {
        return repository.save(m);
    }

    public List<Mensalidade> listar() {
        return repository.findAll();
    }

    public Mensalidade buscar(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensalidade não encontrada"));
    }

    public Mensalidade registrarPagamento(int id) {
        Mensalidade m = buscar(id);
        m.registrarPagamento(new Date());
        return repository.save(m);
    }
}
