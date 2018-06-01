package br.com.lelo.vestibular.empresa.service;

import br.com.lelo.vestibular.empresa.domain.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaCommandService {

    private EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaCommandService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    public Empresa save(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

}
