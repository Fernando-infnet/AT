package org.example.model;

public class Autor {
    private int autorID;
    private String nome;
    private String cpf;
    private Boolean vivo;

    // Construtor
    public Autor(Integer autorID,String nome, String cpf, Boolean vivo) {
        this.autorID = autorID;
        this.nome = nome;
        this.cpf = cpf;
        this.vivo = vivo;
    }

    // Métodos Getters e Setters
    public int getAutorID() {
        return autorID;
    }

    public void getAutorID(Integer autorID) {
        this.autorID = autorID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getVivo() {
        return vivo;
    }

    public void setNacionalidade(Boolean vivo) {
        this.vivo = vivo;
    }
}
