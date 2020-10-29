package br.com.organon.fiap.entity;

import br.com.organon.fiap.entity.enums.Parentesco;
import br.com.organon.fiap.entity.enums.StatusMatch;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tb_match")
@SequenceGenerator(name = "match", sequenceName = "match_sequence", allocationSize = 1)
public class Match {

    @Id
    @Column(name = "cd_match", unique = true, nullable = false)
    @GeneratedValue(generator = "match", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nm_funcionario")
    private String nomeFuncionario;

    @Column(name = "st_match", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusMatch status;

    @Column(name = "dt_hr_gravacao", nullable = false)
    private LocalDate dataGravacao;

    @Column(name = "dt_hr_alteracao", nullable = false)
    private LocalDate dataAtualizacao;

    @Column(name = "grau_parentesco", nullable = false)
    @Enumerated(EnumType.STRING)
    private Parentesco grauParentesco;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "cd_ficha_doador", nullable = false, unique = true)
    private Ficha pacienteDoador;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "cd_ficha_receptor", nullable = false, unique = true)
    private Ficha pacienteReceptor;

    public Match() { }

    public Match(String nomeFuncionario, StatusMatch status, LocalDate dataGravacao, LocalDate dataAtualizacao, Parentesco grauParentesco, Ficha pacienteDoador, Ficha pacienteReceptor) {
        this.nomeFuncionario = nomeFuncionario;
        this.status = status;
        this.dataGravacao = dataGravacao;
        this.dataAtualizacao = dataAtualizacao;
        this.grauParentesco = grauParentesco;
        this.pacienteDoador = pacienteDoador;
        this.pacienteReceptor = pacienteReceptor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public StatusMatch getStatus() {
        return status;
    }

    public void setStatus(StatusMatch status) {
        this.status = status;
    }

    public LocalDate getDataGravacao() {
        return dataGravacao;
    }

    public void setDataGravacao(LocalDate dataGravacao) {
        this.dataGravacao = dataGravacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Ficha getPacienteDoador() {
        return pacienteDoador;
    }

    public void setPacienteDoador(Ficha pacienteDoador) {
        this.pacienteDoador = pacienteDoador;
    }

    public Ficha getPacienteReceptor() {
        return pacienteReceptor;
    }

    public void setPacienteReceptor(Ficha pacienteReceptor) {
        this.pacienteReceptor = pacienteReceptor;
    }

    public Parentesco getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(Parentesco grauParentesco) {
        this.grauParentesco = grauParentesco;
    }
}

