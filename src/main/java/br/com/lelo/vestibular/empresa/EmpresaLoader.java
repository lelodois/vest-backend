package br.com.lelo.vestibular.empresa;

import br.com.lelo.vestibular.empresa.domain.Empresa;
import br.com.lelo.vestibular.empresa.service.EmpresaCommandService;
import br.com.lelo.vestibular.empresa.service.EmpresaQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class EmpresaLoader implements ApplicationListener<ContextRefreshedEvent> {

    private EmpresaCommandService command;
    private EmpresaQueryService query;

    @Autowired
    public EmpresaLoader(EmpresaCommandService command, EmpresaQueryService query) {
        this.command = command;
        this.query = query;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (query.empresasIsEmpty()) {
            command.save(new Empresa("Unesp - Universidade Estadual de SP"));
            command.save(new Empresa("Usp - Universidade de SP"));
            command.save(new Empresa("Unicamp - Universidade de Campinas"));
        }
    }

}
