package br.com.lelo.vestibular.ciclo.service;

import br.com.lelo.vestibular.ciclo.domain.Ciclo;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
interface CicloRepository extends Repository<Ciclo, Long> {

    Iterable<Ciclo> findByEmpresaCodigoEmpresa(Long codigoEmpresa);

    Ciclo save(Ciclo task);
}
