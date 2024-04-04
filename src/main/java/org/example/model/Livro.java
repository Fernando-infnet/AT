package org.example.model;

public class Livro {
    private int livroID;
    private String nomeLivro;
    private int autorID;

    public Livro(int livroID, String nomeLivro, int autorID) {
        this.livroID = livroID;
        this.nomeLivro = nomeLivro;
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

    // Método getter para nomeLivro
    public String getNomeLivro() {
        return nomeLivro;
    }

    // Método setter para nomeLivro
    public void setNome(String nomeLivro) {
        this.nomeLivro = nomeLivro;
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
