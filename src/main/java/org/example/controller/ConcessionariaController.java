package org.example.controller;

import com.google.gson.Gson;
import org.example.model.Carro;
import org.example.model.PlacaCarro;
import org.example.service.Concessionaria;

import static spark.Spark.*;

public class ConcessionariaController {
    private Concessionaria concessionaria;

    public ConcessionariaController(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
        setupRoutes();
    }

    private void setupRoutes() {
        // Rota para adicionar ou alterar um carro
        post("/relacao1_1.mustache/carro", (req, res) -> {
            //System.out.println("Carro antes: " + concessionaria.obterCarro(1));
            //System.out.println("Carro antes: " + concessionaria.obterCarro(1).getMarca());
            Gson gson = new Gson();
            Carro carro = gson.fromJson(req.body(), Carro.class);
            //System.out.println("Carro recebido: " + carro);
            //System.out.println("Carro recebido: " + carro.getIdCarro());
           // System.out.println("Carro recebido: " + carro.getMarca());// Verifica se o carro recebido está correto
            concessionaria.adicionarCarro(carro.getIdCarro(), carro);
            //System.out.println("Carro adddddicionado: " + carro.getIdCarro());
           // System.out.println("Carro adicionado: " + concessionaria.obterCarro(1));
            //System.out.println("Carro adicionado: " + concessionaria.obterCarro(1).getMarca()); // Verifica se o carro foi adicionado corretamente
            res.status(201); // Código HTTP 201 para criado
            return "Carro adicionado com sucesso!";
        });

        // Rota para pegar um carro
        get("/relacao1_1.mustache/carro/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Carro carro = concessionaria.obterCarro(id);
            //System.out.println("ID DADO: " + concessionaria.obterCarro(id).getIdCarro());
            if (carro != null) {
                Gson gson = new Gson();
                String jsonCarro = gson.toJson(carro);
                res.status(200); // Código HTTP 200 para sucesso
                return jsonCarro;
            } else {
                res.status(404); // Código HTTP 404 para não encontrado
                return "Carro não encontrado";
            }
        });

        // Rota para remover um carro
        delete("/relacao1_1.mustache/carro/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            //System.out.println("ID DADO: " + id);
            //Carro carro = concessionaria.obterCarro(id);
            concessionaria.removerCarro(id);
            concessionaria.removerPlacaCarro(id);
            res.status(200); // Código HTTP 200 para sucesso
            return "Carro removido com sucesso!";
        });

        ////////////////////////////////////////////////////////////////////////////////

        // Rota para adicionar ou alterar uma placa de carro
        post("/relacao1_1.mustache/placa-carro", (req, res) -> {
            Gson gson = new Gson();
            PlacaCarro placaCarro = gson.fromJson(req.body(), PlacaCarro.class);

            // Obtém o valor do parâmetro "idCarro"
            Integer idCarro = Integer.valueOf(placaCarro.getIdCarro());

            System.out.println("INDO PARA O CARRO" + idCarro);
            concessionaria.adicionarPlacaCarro(idCarro, placaCarro);

            res.status(201); // Código HTTP 201 para criado
            return "Placa de carro adicionada com sucesso!";
        });

        // Rota para pegar uma placa de carro
        get("/relacao1_1.mustache/placa-carro/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            PlacaCarro placaCarro = concessionaria.obterPlacaCarro(id);
            if (placaCarro != null) {
                Gson gson = new Gson();
                String jsonPlacaCarro = gson.toJson(placaCarro);
                res.status(200); // Código HTTP 200 para sucesso
                return jsonPlacaCarro;
            } else {
                res.status(404); // Código HTTP 404 para não encontrado
                return "Placa de carro não encontrada";
            }
        });

        // Rota para remover uma placa de carro
        delete("/relacao1_1.mustache/placa-carro/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            concessionaria.removerPlacaCarro(id);
            res.status(200); // Código HTTP 200 para sucesso
            return "Placa de carro removida com sucesso!";
        });
    }
}