package br.com.lelo.vestibular.ciclo.service;

import br.com.lelo.vestibular.ciclo.domain.Ciclo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CicloQueryService {

    private CicloRepository cicloRepository;

    @Autowired
    public CicloQueryService(CicloRepository cicloRepository) {
        this.cicloRepository = cicloRepository;
    }

    @Transactional(readOnly = true)
    public Iterable<Ciclo> ciclosFindByCodigoEmpresa(Long codigoEmpresa) {
        return cicloRepository.findByEmpresaCodigoEmpresa(codigoEmpresa);
    }

}
