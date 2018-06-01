package br.com.lelo.vestibular.empresa.service;

import br.com.lelo.vestibular.empresa.domain.Empresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
interface EmpresaRepository extends Repository<Empresa, Long> {

    List<Empresa> findAll();

    @Query("Select count(*) From Empresa")
    int count();

    Empresa save(Empresa empresa);

    Iterable<Empresa> findByCodigoEmpresa(Long codigoEmpresa);
}
