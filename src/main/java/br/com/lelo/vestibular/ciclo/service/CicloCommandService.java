package br.com.lelo.vestibular.ciclo.service;

import br.com.lelo.vestibular.ciclo.domain.Ciclo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CicloCommandService {

    private CicloRepository cicloRepository;

    @Autowired
    public CicloCommandService(CicloRepository cicloRepository) {
        this.cicloRepository = cicloRepository;
    }

    @Transactional
    public Ciclo save(Ciclo task) {
        return cicloRepository.save(task);
    }

}
