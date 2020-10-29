package br.com.organon.fiap.forms;

import br.com.organon.fiap.entity.enums.Parentesco;
import br.com.organon.fiap.entity.enums.TipoCadastro;
import br.com.organon.fiap.entity.enums.TipoSanguineo;

public class FichaForm {

    private TipoCadastro tipoCadastro;
    private TipoSanguineo tipoSanguineo;
    private double peso;
    private int idade;
    private double altura;

    public TipoCadastro getTipoCadastro() {
        return tipoCadastro;
    }

    public void setTipoCadastro(TipoCadastro tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
