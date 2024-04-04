package org.example.controller;

import com.google.gson.Gson;
import org.example.model.Autor;
import org.example.model.Carro;
import org.example.model.Livro;
import org.example.model.PlacaCarro;
import org.example.service.Biblioteca;

import static spark.Spark.*;
import static spark.Spark.delete;

public class BibliotecaController {
    private Biblioteca biblioteca;

    public BibliotecaController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setupRoutes();
    }

    private void setupRoutes() {
        // Rota para adicionar ou alterar um carro
        post("/relacao1_x.mustache/livro", (req, res) -> {
            Gson gson = new Gson();
            Livro livro = gson.fromJson(req.body(), Livro.class);
            biblioteca.adicionarLivro(livro);
            res.status(201); // Código HTTP 201 para criado
            return "Livro adicionado com sucesso!";
        });

        // Rota para pegar um carro
        get("/relacao1_x.mustache/livro/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Livro livro = biblioteca.obterLivro(id);
            if (livro != null) {
                Gson gson = new Gson();
                String jsonCarro = gson.toJson(livro);
                res.status(200); // Código HTTP 200 para sucesso
                return jsonCarro;
            } else {
                res.status(404); // Not Found
                return "Livro não encontrado";
            }
        });

        // Rota para remover um carro
        delete("/relacao1_x.mustache/livro/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            biblioteca.removerLivro(id);
            res.status(200); // Código HTTP 200 para sucesso
            return "Livro removido com sucesso!";
        });

        ////////////////////////////////////////////////////////////////////////////////

        // Rota para adicionar ou alterar um autor
        post("/relacao1_x.mustache/autor", (req, res) -> {
            Gson gson = new Gson();
            Autor autor = gson.fromJson(req.body(), Autor.class);

            // Obtém o valor do parâmetro "idCarro"
            int autorID = autor.getAutorID();

            System.out.println("INDO PARA O ATOR " + autorID);
            biblioteca.adicionarAutor(autorID, autor);

            res.status(201); // Código HTTP 201 para criado
            return "Autor adicionado com sucesso!";
        });

        // Rota para pegar um autor
        get("/relacao1_x.mustache/autor/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Autor autor = biblioteca.obterAutor(id);
            if (autor != null) {
                Gson gson = new Gson();
                String jsonPlacaCarro = gson.toJson(autor);
                res.status(200); // Código HTTP 200 para sucesso
                return jsonPlacaCarro;
            } else {
                res.status(404); // Código HTTP 404 para não encontrado
                return "autor não encontrado";
            }
        });

        // Rota para remover um autor
        delete("/relacao1_x.mustache/autor/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            biblioteca.removerAutor(id);
            res.status(200); // Código HTTP 200 para sucesso
            return "autor removido com sucesso!";
        });
    }
}
