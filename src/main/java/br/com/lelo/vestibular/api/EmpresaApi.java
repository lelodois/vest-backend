package br.com.lelo.vestibular.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lelo.vestibular.ciclo.Ciclo;
import br.com.lelo.vestibular.ciclo.domain.CicloQueryService;
import br.com.lelo.vestibular.empresa.Empresa;
import br.com.lelo.vestibular.empresa.domain.EmpresaQueryService;

@RestController
@RequestMapping(name = "/api/empresas")
@CrossOrigin(origins = "*")
public class EmpresaApi {

    @Autowired
    private EmpresaQueryService query;

    @Autowired
    private CicloQueryService cicloQuery;

    @GetMapping("/")
    public Iterable<Empresa> list() throws Exception {
        return query.empresasFindAll();
    }

    @GetMapping(value = "/{codigoEmpresa}/ciclos")
    public Iterable<Ciclo> list(@RequestParam(value = "codigoEmpresa") Long codigoEmpresa) throws Exception {
        return cicloQuery.ciclosFindByCodigoEmpresa(codigoEmpresa);
    }

}
