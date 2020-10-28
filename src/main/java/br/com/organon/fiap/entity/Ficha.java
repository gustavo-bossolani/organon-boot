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

    @Column(name = "tipo_cadastro_ficha", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCadastro tipoCadastro;

    @Column(name = "grau_parentesco_ficha", nullable = false)
    @Enumerated(EnumType.STRING)
    private Parentesco grauParentesco;

    @Column(name = "tipo_sanguineo_ficha", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoSanguineo tipoSanguineo;

    @Column(name = "peso_ficha", nullable = false)
    private double peso;

    @Column(name = "idade_ficha", nullable = false)
    private int indade;

    @Column(name = "altura_ficha", nullable = false)
    private double altura;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parentesco getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(Parentesco grauParentesco) {
        this.grauParentesco = grauParentesco;
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

    public int getIndade() {
        return indade;
    }

    public void setIndade(int indade) {
        this.indade = indade;
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
