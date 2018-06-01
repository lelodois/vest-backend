package br.com.lelo.vestibular.empresa.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lelo.vestibular.empresa.Empresa;

@Service
public class EmpresaQueryService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional(readOnly = true)
    public boolean empresasIsEmpty() {
        return empresaRepository.count() == 0;
    }

    @Transactional(readOnly = true)
    public Iterable<Empresa> empresasFindAll() {
        return empresaRepository.findAll();
    }

}
