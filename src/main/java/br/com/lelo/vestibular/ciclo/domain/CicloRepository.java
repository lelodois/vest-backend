package br.com.lelo.vestibular.ciclo.domain;

import org.springframework.data.repository.Repository;

import br.com.lelo.vestibular.ciclo.Ciclo;

@org.springframework.stereotype.Repository
interface CicloRepository extends Repository<Ciclo, Long> {

    Iterable<Ciclo> findByEmpresaCodigoEmpresa(Long codigoEmpresa);

    Ciclo save(Ciclo task);
}
