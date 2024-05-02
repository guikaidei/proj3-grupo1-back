package br.insper.aluguelBicicletas.bicicleta;

import jakarta.persistence.*;

@Entity
public class Bicicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Float preco;

    @Column(nullable = false)
    private String status;

    public Bicicleta(Integer id, String modelo, String tipo, Float preco, String status) {
        this.id = id;
        this.modelo = modelo;
        this.tipo = tipo;
        this.preco = preco;
        this.status = status;
    }

    public Bicicleta(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
