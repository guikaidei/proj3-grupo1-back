package br.insper.aluguelBicicletas.bicicleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BicicletaController {

    @Autowired
    private BicicletaService bicicletaService;

    @PostMapping("/bicicleta")
    @ResponseStatus(HttpStatus.CREATED)
    public Bicicleta salvarBicicleta(@RequestBody Bicicleta bicicleta) { return bicicletaService.cadastrarBicicleta(bicicleta); }

    @GetMapping("/bicicleta")
    public List<Bicicleta> getBicicletas() {
        return bicicletaService.listarBicicletas();
    }

    @DeleteMapping("/bicicleta/{id}")
    public Boolean deletarBicicleta(@PathVariable Integer id){
        return bicicletaService.excluirBicicleta(id);
    }

    @PutMapping("/bicicleta")
    public Bicicleta editarBicicleta(@RequestBody Bicicleta bicicleta) {
        return bicicletaService.editarBicicleta(bicicleta);
    }

    @GetMapping("bicicleta/{id}")
    public String mostrarStatusBicicleta(@PathVariable Integer id){
        return bicicletaService.mostrarStatus(id);
    }

    @PostMapping("/bicicleta/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Bicicleta mudarStatusBicicleta(@PathVariable Integer id){
        return bicicletaService.mudarStatus(id);
    }
}
