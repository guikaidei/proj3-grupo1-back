package br.insper.aluguelBicicletas.bicicleta;

import br.insper.aluguelBicicletas.common.Erro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@ControllerAdvice
public class BicicletaAdvice {

    @ExceptionHandler(BicicletaNaoEncontradaException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Erro bicicletaNaoEncontradaHandler(BicicletaNaoEncontradaException e) {
        Erro erro = new Erro();
        erro.setMensagem(e.getMessage());
        erro.setData(LocalDateTime.now());
        erro.setCodigo(404);
        return erro;
    }
}
