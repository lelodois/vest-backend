package br.com.lelo.vestibular.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lelo.vestibular.ciclo.Ciclo;
import br.com.lelo.vestibular.ciclo.domain.CicloCommandService;

@RestController
@RequestMapping(name = "/api/ciclos")
public class CicloApi {

    @Autowired
    private CicloCommandService command;

    @PostMapping("/")
    public Ciclo novo(@Valid @RequestBody Ciclo task) throws Exception {
        return command.save(task);
    }

}
