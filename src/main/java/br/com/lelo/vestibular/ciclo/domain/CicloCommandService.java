package br.com.lelo.vestibular.ciclo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lelo.vestibular.ciclo.Ciclo;

@Service
public class CicloCommandService {

    @Autowired
    private CicloRepository cicloRepository;

    @Transactional(readOnly = false)
    public Ciclo save(Ciclo task) {
        return cicloRepository.save(task);
    }

}
