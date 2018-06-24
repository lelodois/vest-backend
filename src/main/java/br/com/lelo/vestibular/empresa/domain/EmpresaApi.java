package br.com.lelo.vestibular.empresa.domain;

import br.com.lelo.vestibular.empresa.service.EmpresaQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresas/")
public class EmpresaApi {

    private EmpresaQueryService query;

    @Autowired
    public EmpresaApi(EmpresaQueryService query) {
        this.query = query;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public Iterable<Empresa> list() {
        return query.empresasFindAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{codigoEmpresa}")
    public Empresa findByCodigo(@PathVariable(value = "codigoEmpresa") Long codigoEmpresa) {
        return query.empresaFindByCodigo(codigoEmpresa);
    }

}
