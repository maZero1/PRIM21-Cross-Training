package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusAluno;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String telefone;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Enumerated(EnumType.STRING)
    private StatusAluno status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mensalidade> mensalidades = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatriculaHorario> matriculas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReposicaoAula> reposicoes = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(int id, String nome, String telefone, String email, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public void atualizarDados(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public void marcarComoInadimplente() {
        this.status = StatusAluno.INADIMPLENTE;
    }

    public void marcarComoAtivo() {
        this.status = StatusAluno.ATIVO;
    }

    public List<Mensalidade> obterMensalidadesEmAberto() {
        return mensalidades.stream()
                .filter(m -> !m.estaPaga())
                .toList();
    }

    public List<Horario> obterHorarios() {
        return matriculas.stream()
                .filter(MatriculaHorario::estaAtiva)
                .map(MatriculaHorario::getHorario)
                .toList();
    }

    public ReposicaoAula solicitarReposicao(Date dataOriginal, String motivo) {
        ReposicaoAula r = new ReposicaoAula();
        r.setDataOriginal(dataOriginal);
        r.setMotivo(motivo);
        r.solicitar();
        reposicoes.add(r);
        return r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public StatusAluno getStatus() {
        return status;
    }

    public void setStatus(StatusAluno status) {
        this.status = status;
    }

    public List<Mensalidade> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }

    public List<MatriculaHorario> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<MatriculaHorario> matriculas) {
        this.matriculas = matriculas;
    }

    public List<ReposicaoAula> getReposicoes() {
        return reposicoes;
    }

    public void setReposicoes(List<ReposicaoAula> reposicoes) {
        this.reposicoes = reposicoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return id == aluno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
