package br.com.lelo.vestibular.empresa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Empresa {

    @Id
    @GeneratedValue
    private Long codigoEmpresa;

    @NotBlank
    private String nomeFantasia;

    public Empresa() {

    }

    public Empresa(String nomeFantasia) {
        super();
        this.nomeFantasia = nomeFantasia;
    }

    public Long getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Long codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

}
