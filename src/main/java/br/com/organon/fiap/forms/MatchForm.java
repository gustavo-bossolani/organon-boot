package br.com.organon.fiap.forms;

import br.com.organon.fiap.entity.Ficha;
import br.com.organon.fiap.entity.enums.Parentesco;
import br.com.organon.fiap.entity.enums.StatusMatch;

import java.time.LocalDate;

public class MatchForm {

    private String nomeFuncionario;
    private StatusMatch status;
    private LocalDate dataGravacao;
    private LocalDate dataAtualizacao;
    private Parentesco grauParentesco;
    private int pacienteDoador;
    private int pacienteReceptor;



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

    public int getPacienteDoador() {
        return pacienteDoador;
    }

    public void setPacienteDoador(int pacienteDoador) {
        this.pacienteDoador = pacienteDoador;
    }

    public int getPacienteReceptor() {
        return pacienteReceptor;
    }

    public void setPacienteReceptor(int pacienteReceptor) {
        this.pacienteReceptor = pacienteReceptor;
    }

    public Parentesco getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(Parentesco grauParentesco) {
        this.grauParentesco = grauParentesco;
    }
}
