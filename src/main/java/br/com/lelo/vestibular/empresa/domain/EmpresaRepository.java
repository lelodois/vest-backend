package br.com.lelo.vestibular.empresa.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.lelo.vestibular.empresa.Empresa;

@org.springframework.stereotype.Repository
interface EmpresaRepository extends Repository<Empresa, Long> {

    List<Empresa> findAll();

    @Query("Select count(*) From Empresa")
    int count();

    Empresa save(Empresa empresa);

}
