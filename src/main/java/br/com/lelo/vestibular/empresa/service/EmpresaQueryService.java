package br.com.lelo.vestibular.empresa.service;

import br.com.lelo.vestibular.empresa.domain.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaQueryService {

    private EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaQueryService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Transactional(readOnly = true)
    public boolean empresasIsEmpty() {
        return empresaRepository.count() == 0;
    }

    @Transactional(readOnly = true)
    public Iterable<Empresa> empresasFindAll() {
        return empresaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Iterable<Empresa> empresasFindByCodigo(Long codigoEmpresa) {
        return empresaRepository.findByCodigoEmpresa(codigoEmpresa);
    }
}
