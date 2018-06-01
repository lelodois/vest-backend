package br.com.lelo.vestibular;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lelo.vestibular.empresa.Empresa;
import br.com.lelo.vestibular.empresa.domain.EmpresaCommandService;
import br.com.lelo.vestibular.empresa.domain.EmpresaQueryService;

@Component
public class EmpresaInitializer {

    @Autowired
    private EmpresaCommandService command;

    @Autowired
    private EmpresaQueryService query;

    @PostConstruct
    public void initializer() {
        if (query.empresasIsEmpty()) {
            command.save(new Empresa("Unesp - Universidade Estadual de SP"));
            command.save(new Empresa("Usp - Universidade de SP"));
            command.save(new Empresa("Unicamp - Universidade de Campinas"));
        }
    }

}
