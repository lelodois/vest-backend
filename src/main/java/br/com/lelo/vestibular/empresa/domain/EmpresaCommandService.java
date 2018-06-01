package br.com.lelo.vestibular.empresa.domain;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lelo.vestibular.empresa.Empresa;

@Service
public class EmpresaCommandService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaQueryService queryRepository;

    @Transactional(readOnly = false)
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

}
