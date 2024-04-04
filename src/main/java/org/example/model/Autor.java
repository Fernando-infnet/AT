package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private int autorID;
    private String nome;
    private List<Livro> livros;

    // Construtor

    public Autor(int autorID,String nome) {
        this.autorID = autorID;
        this.nome = nome;
        this.livros = new ArrayList<>();
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }
    public Livro obterLivro(int livroID) {
        for (Livro livro : livros) {
            if (livro.getLivroID() == livroID) {
                return livro;
            }
        }
        return null;
    }
}
