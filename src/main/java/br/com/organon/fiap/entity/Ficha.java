package br.com.organon.fiap.entity;

import br.com.organon.fiap.entity.enums.Parentesco;
import br.com.organon.fiap.entity.enums.TipoCadastro;
import br.com.organon.fiap.entity.enums.TipoSanguineo;

import javax.persistence.*;

@Entity
@Table(name="tb_ficha")
@SequenceGenerator(name = "ficha", sequenceName = "ficha_sequence", allocationSize = 1)
public class Ficha {

    @Id
    @Column(name = "cd_ficha", unique = true, nullable = false)
    @GeneratedValue(generator = "ficha", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "tp_cadastro", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCadastro tipoCadastro;

    @Column(name = "tp_sanguineo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoSanguineo tipoSanguineo;

    @Column(name = "nm_peso", nullable = false)
    private double peso;

    @Column(name = "nm_idade", nullable = false)
    private int idade;

    @Column(name = "nm_altura", nullable = false)
    private double altura;

    public Ficha() { }

    public Ficha(TipoCadastro tipoCadastro, TipoSanguineo tipoSanguineo, double peso, int idade, double altura) {
        this.tipoCadastro = tipoCadastro;
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.idade = idade;
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setIdade(int indade) {
        this.idade = indade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setTipoCadastro(TipoCadastro tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }

}
