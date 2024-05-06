package br.insper.aluguelBicicletas.bicicleta;

public class BicicletaNaoEncontradaException extends RuntimeException{

    public BicicletaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
