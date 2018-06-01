package br.com.lelo.vestibular;

import br.com.lelo.vestibular.empresa.domain.Empresa;
import br.com.lelo.vestibular.empresa.service.EmpresaCommandService;
import br.com.lelo.vestibular.empresa.service.EmpresaQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmpresaConfiguration {

    private EmpresaCommandService command;
    private EmpresaQueryService query;

    @Autowired
    public EmpresaConfiguration(EmpresaCommandService command, EmpresaQueryService query) {
        this.command = command;
        this.query = query;
    }

    @PostConstruct
    public void initializer() {
        if (query.empresasIsEmpty()) {
            command.save(new Empresa("Unesp - Universidade Estadual de SP"));
            command.save(new Empresa("Usp - Universidade de SP"));
            command.save(new Empresa("Unicamp - Universidade de Campinas"));
        }
    }

}
