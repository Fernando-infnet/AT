package org.example.service;

import org.example.model.Autor;
import org.example.model.Carro;
import org.example.model.Livro;
import org.example.model.PlacaCarro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private static int proximoIdAutor = 1;
    private static Map<Integer, Autor> autores = new HashMap<>();
    private static int proximoIdLivro = 1;
    private static Map<Integer, Livro> livros = new HashMap<>();

    public Biblioteca() {
        // Populando dados estáticos de autores
        Autor autor1 = new Autor(1, "Stephen King");
        Autor autor2 = new Autor(2, "J.K. Rowling");
        Autor autor3 = new Autor(3, "George R.R. Martin");
        Autor autor4 = new Autor(4, "Agatha Christie");
        Autor autor5 = new Autor(5, "Haruki Murakami");
        Autor autor6 = new Autor(6, "Gabriel García Márquez");
        Autor autor7 = new Autor(7, "Jane Austen");
        Autor autor8 = new Autor(8, "Leo Tolstoy");

        autores.put(proximoIdAutor++, autor1);
        autores.put(proximoIdAutor++, autor2);
        autores.put(proximoIdAutor++, autor3);
        autores.put(proximoIdAutor++, autor4);
        autores.put(proximoIdAutor++, autor5);
        autores.put(proximoIdAutor++, autor6);
        autores.put(proximoIdAutor++, autor7);
        autores.put(proximoIdAutor++, autor8);
        // Populando dados estáticos de livros
        Livro livro1 = new Livro(1, "It", 1);
        Livro livro2 = new Livro(2, "Harry Potter and the Philosopher's Stone", 2);
        Livro livro3 = new Livro(3, "A Game of Thrones", 3);
        Livro livro4 = new Livro(4, "Murder on the Orient Express", 4);
        Livro livro5 = new Livro(5, "Norwegian Wood", 5);
        Livro livro6 = new Livro(6, "One Hundred Years of Solitude", 6);
        Livro livro7 = new Livro(7, "Pride and Prejudice", 7);
        Livro livro8 = new Livro(8, "War and Peace", 8);

        livros.put(proximoIdLivro++, livro1);
        livros.put(proximoIdLivro++, livro2);
        livros.put(proximoIdLivro++, livro3);
        livros.put(proximoIdLivro++, livro4);
        livros.put(proximoIdLivro++, livro5);
        livros.put(proximoIdLivro++, livro6);
        livros.put(proximoIdLivro++, livro7);
        livros.put(proximoIdLivro++, livro8);

        Livro livro9 = new Livro(9, "O Senhor dos Anéis: A Sociedade do Anel", 1);
        Livro livro10 = new Livro(10, "O Hobbit", 1);
        Livro livro11 = new Livro(11, "1984", 3);
        Livro livro12 = new Livro(12, "A Revolução dos Bichos", 4);
        Livro livro13 = new Livro(13, "Fahrenheit 451", 7);

        livros.put(proximoIdLivro++, livro9);
        livros.put(proximoIdLivro++, livro10);
        livros.put(proximoIdLivro++, livro11);
        livros.put(proximoIdLivro++, livro12);
        livros.put(proximoIdLivro++, livro13);

        autor1.adicionarLivro(livro1);
        autor3.adicionarLivro(livro3);
        autor4.adicionarLivro(livro4);
        autor5.adicionarLivro(livro5);
        autor6.adicionarLivro(livro6);
        autor7.adicionarLivro(livro7);
        autor8.adicionarLivro(livro8);
        autor1.adicionarLivro(livro9);
        autor1.adicionarLivro(livro10);
        autor3.adicionarLivro(livro11);
        autor4.adicionarLivro(livro12);
        autor7.adicionarLivro(livro13);
    }

    // Métodos para adicionar mais autores e livros
    public void adicionarAutor(int autorID, Autor autor) {
        // Obtém o autor do livro, se existir
        Autor autorExistente = autores.get(autorID);

        // Se o autor não existir, cria um novo autor e atualiza a referência
        if (autorExistente == null) {
            autorExistente = new Autor(autorID, autor.getNome());
            autores.put(autorID, autorExistente);
        }
    }
    public void adicionarLivro(Livro livro) {
        System.out.println("Adicionando livro com ID: " + livro.getLivroID() + " e autor com ID: " + livro.getAutorID());
        int autorID = livro.getAutorID();

        // Verifica se o autor do livro existe na lista de autores
        if (!autores.containsKey(autorID)) {
            System.out.println("Autor do livro com ID " + autorID + " não encontrado na biblioteca.");
            return;
        }

        // Verifica se o livro já existe na lista de livros
        int livroID = livro.getLivroID();

        // Obtém o autor do livro, se existir
        Autor autorExistente = autores.get(autorID);

        // Remove o livro do autor anterior, se existir
        if (autorExistente != null) {
            Livro livroExistente = autorExistente.obterLivro(livroID);
            if (livroExistente != null) {
                autorExistente.removerLivro(livroExistente);
                System.out.println("Livro removido do autor anterior com ID: " + autorExistente.getAutorID());
            }
        }

        // Adiciona o livro à lista de livros da biblioteca
        livros.put(livroID, livro);

        // Associa o livro ao autor na lista de autores
        autorExistente.adicionarLivro(livro);

        System.out.println("Livro adicionado com sucesso.");
    }

    // Métodos para obter autores e livros
    public Autor obterAutor(int id) {
        return autores.get(id);
    }

    public Livro obterLivro(int id) {
        return livros.get(id);
    }

    public static Map<Integer, Autor> getAutores() {
        return autores;
    }

    public static Map<Integer, Livro> getLivros() {
        return livros;
    }

    public void removerAutor(int id) {
        if (!autores.containsKey(id)) {
            System.out.println("Autor não encontrado na biblioteca.");
            return;
        }

        Autor autorRemovido = autores.remove(id);
        if (autorRemovido != null) {
            List<Livro> livrosDoAutor = autorRemovido.getLivros();
            for (Livro livro : livrosDoAutor) {
                livros.remove(livro.getLivroID());
            }
        }
    }

    public void removerLivro(int id) {
        if(!livros.containsKey(id)){
            System.out.println("Livro não encontrado na biblioteca.");
            return;
        }

        Livro livroRemovido = livros.remove(id);
        if (livroRemovido != null) {
            // Obtém o autor do livro removido
            Autor autor = autores.get(livroRemovido.getAutorID());
            if (autor != null) {
                // Remove o livro do autor
                autor.removerLivro(livroRemovido);
            }
        }
    }
}
