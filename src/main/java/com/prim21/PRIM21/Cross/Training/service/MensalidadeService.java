package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.repository.MensalidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MensalidadeService {

    private final MensalidadeRepository mensalidadeRepository;

    public MensalidadeService(MensalidadeRepository mensalidadeRepository) {
        this.mensalidadeRepository = mensalidadeRepository;
    }

    public Mensalidade criar(Mensalidade mensalidade) {
        return mensalidadeRepository.save(mensalidade);
    }

    public List<Mensalidade> listarTodas() {
        return mensalidadeRepository.findAll();
    }

    public Mensalidade buscarPorId(int id) {
        return mensalidadeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mensalidade não encontrada"));
    }

    public Mensalidade registrarPagamento(int mensalidadeId, Date dataPagamento) {
        Mensalidade m = buscarPorId(mensalidadeId);
        m.registrarPagamento(dataPagamento);
        return mensalidadeRepository.save(m);
    }

    public Mensalidade marcarComoAtrasada(int mensalidadeId) {
        Mensalidade m = buscarPorId(mensalidadeId);
        m.marcarComoAtrasada();
        return mensalidadeRepository.save(m);
    }
}
