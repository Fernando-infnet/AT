package org.example;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.controller.BibliotecaController;
import org.example.model.Carro;
import org.example.model.PlacaCarro;
import org.example.service.Biblioteca;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
import org.example.controller.ConcessionariaController;
import org.example.service.Concessionaria;

public class Main {
    public static void main(String[] args) {
        // Define a porta para o servidor Spark Java (padrão: 4567)
        port(8080);

        // Configuração do mecanismo de template Mustache
        MustacheTemplateEngine templateEngine = new MustacheTemplateEngine();

        // Instanciar a concessionária e o controller
        Concessionaria concessionaria = new Concessionaria();
        ConcessionariaController concessionariaController = new ConcessionariaController(concessionaria);

        Biblioteca biblioteca = new Biblioteca();
        BibliotecaController bibliotecaController = new BibliotecaController(biblioteca);

        // Define a rota para a página inicial
        get("/", (request, response) -> {
            // Criando um mapa para armazenar os dados a serem passados para o template
            Map<String, Object> model = new HashMap<>();
            model.put("title", "Aplicação Spark Java");
            model.put("pageTitle", "Bem-vindo à Minha Aplicação Spark Java");
            model.put("pageContent", "Este texto é gerado pela interação do Spark com meu Index. Este código, ao se" +
                    "redirecionar aos outros caminhos desta aplicação, você se depará com 4 classes, uma que referência a" +
                    "a maneira de relação um para um, e a classe um para X, respectivamente, a primeira estará com um " +
                    "relacionamento de carro com placa, e o segundo será livros com autor");

            // Renderizando o template Mustache e retornando como resposta
            return templateEngine.render(new ModelAndView(model, "index.mustache"));
        });

        get("/relacao1_1.mustache", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            // Cria uma lista vazia para armazenar os objetos
            List<Object> objetos = new ArrayList<>();

            // Converte o mapa em uma lista
            objetos.addAll(concessionaria.getCarros().values());
            objetos.addAll(concessionaria.getPlacasCarro().values());

            model.put("objetos", objetos);

            return templateEngine.render(new ModelAndView(model, "relacao1_1.mustache"));
        });

        get("/relacao1_x.mustache",(request, response) -> {
            Map<String, Object> model = new HashMap<>();

            // Cria listas separadas para livros e autores
            List<Object> livros = new ArrayList<>();
            List<Object> autores = new ArrayList<>();

            // Adiciona os livros à lista de livros
            livros.addAll(Biblioteca.getLivros().values());

            // Adiciona os autores à lista de autores
            autores.addAll(Biblioteca.getAutores().values());

            model.put("livros", livros);
            model.put("autores", autores);

            return templateEngine.render(new ModelAndView(model, "relacao1_x.mustache"));
        });
    }
}
