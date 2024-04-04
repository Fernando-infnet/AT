package org.example.model;

public class PlacaCarro {
    private String tipo = "PlacaCarro";
    private int idPlaca;
    private String estado;
    private String numero;
    private int idCarro;

    public PlacaCarro(int idPlaca, String estado, String numero, int carroID) {
        this.idPlaca = idPlaca;
        this.estado = estado;
        this.numero = numero;
        this.idCarro = carroID;
    }

    // Método getter para idPlaca
    public int getPlacaCarroID() {
        return idPlaca;
    }

    // Método setter para idPlaca
    public void setPlacaCarroID(int idPlaca) {
        this.idPlaca = idPlaca;
    }

    // Método getter para estado
    public String getEstado() {
        return estado;
    }

    // Método setter para estado
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método getter para numero
    public String getNumero() {
        return numero;
    }

    // Método setter para numero
    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Método getter para carroID
    public int getIdCarro() {
        return idCarro;
    }

    // Método setter para carroID
    public void setCarroID(int carroID) {
        this.idCarro = carroID;
    }
}