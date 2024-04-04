package org.example.model;

public class Carro {
    private String tipo = "Carro";
    private int idCarro;
    private String modelo;
    private String marca;
    private int anoFabricacao;
    private Integer idPlaca;

    // Construtor sem o campo idPlaca
    public Carro(int idCarro, String modelo, String marca, int anoFabricacao) {
        this.idCarro = idCarro;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.idPlaca = null; // Inicializado como nulo
    }

    // Construtor com o campo idPlaca
    public Carro(int idCarro, String modelo, String marca, int anoFabricacao, Integer idPlaca) {
        this.idCarro = idCarro;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.idPlaca = idPlaca; // Pode ser nulo ou conter um valor
    }

    // Método getter para idCarro
    public int getIdCarro() {
        return idCarro;
    }

    // Método setter para idCarro
    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    // Método getter para modelo
    public String getModelo() {
        return modelo;
    }

    // Método setter para modelo
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Método getter para marca
    public String getMarca() {
        return marca;
    }

    // Método setter para marca
    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Método getter para anoFabricacao
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    // Método setter para anoFabricacao
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    // Método getter para idPlaca
    public Integer getIdPlaca() {
        return idPlaca;
    }

    // Método setter para idPlaca
    public void setIdPlaca(Integer idPlaca) {
        this.idPlaca = idPlaca;
    }
}