package org.example.model;

public class Livro {
    private int livroID;
    private String nome;
    private String editora;
    private int autorID;

    public Livro(int livroID, String nome, String editora, int autorID) {
        this.livroID = livroID;
        this.nome = nome;
        this.editora = editora;
        this.autorID = autorID;
    }

    // Método getter para livroID
    public int getLivroID() {
        return livroID;
    }

    // Método setter para livroID
    public void setLivroID(int livroID) {
        this.livroID = livroID;
    }

    // Método getter para nome
    public String getNome() {
        return nome;
    }

    // Método setter para anoPublicacao
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para editora
    public String getEditora() {
        return editora;
    }

    // Método setter para editora
    public void setEditora(String editora) {
        this.editora = editora;
    }

    // Método getter para autorID
    public int getAutorID() {
        return autorID;
    }

    // Método setter para autorID
    public void setAutorID(int autorID) {
        this.autorID = autorID;
    }
}
