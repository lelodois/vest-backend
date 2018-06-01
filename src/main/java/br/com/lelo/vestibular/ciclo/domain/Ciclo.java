package br.com.lelo.vestibular.ciclo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.lelo.vestibular.empresa.domain.Empresa;

@Entity
public class Ciclo {

    @Id
    @GeneratedValue
    private Long codigo;
    private int ano;
    private int semestre;
    private boolean situacaoMatricula;
    private boolean situacaoInscricao;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean isSituacaoMatricula() {
        return situacaoMatricula;
    }

    public void setSituacaoMatricula(boolean situacaoMatricula) {
        this.situacaoMatricula = situacaoMatricula;
    }

    public boolean isSituacaoInscricao() {
        return situacaoInscricao;
    }

    public void setSituacaoInscricao(boolean situacaoInscricao) {
        this.situacaoInscricao = situacaoInscricao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
