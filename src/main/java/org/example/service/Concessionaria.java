package org.example.service;

import org.example.model.Carro;
import org.example.model.PlacaCarro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Concessionaria {
    public static int proximoIdCarro = 1;
    public static int proximoIdPlaca = 1;
    private Map<Integer, Carro> carros = new HashMap<>();
    private Map<Integer, PlacaCarro> placasCarro = new HashMap<>();

    public Concessionaria(){
        // Populando dados estáticos de carros
        carros.put(proximoIdCarro++, new Carro(1, "Fiat", "Palio", 2010, 1));
        carros.put(proximoIdCarro++, new Carro(2, "Chevrolet", "Onix", 2015, 2));
        carros.put(proximoIdCarro++, new Carro(3, "Ford", "Fiesta", 2012, 3));
        carros.put(proximoIdCarro++, new Carro(4, "Volkswagen", "Gol", 2018, 4));
        carros.put(proximoIdCarro++, new Carro(5, "Toyota", "Corolla", 2019, 5));
        carros.put(proximoIdCarro++, new Carro(6, "Honda", "Civic", 2017, 6));
        carros.put(proximoIdCarro++, new Carro(7, "Hyundai", "HB20", 2016, 7));
        carros.put(proximoIdCarro++, new Carro(8, "Renault", "Kwid", 2020, 8));
        carros.put(proximoIdCarro++, new Carro(9, "Nissan", "Versa", 2014, 9));
        carros.put(proximoIdCarro++, new Carro(10, "Mitsubishi", "Lancer", 2013, 10));

        // Populando dados estáticos de placas de carro
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(1, "SP", "ABC123", 1));
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(2, "RJ", "XYZ987", 2));
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(3, "MG", "DEF456", 3));
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(4, "PR", "HIJ789", 4));
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(5, "RS", "KLM012", 5));
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(6, "SC", "NOP345", 6));
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(7, "BA", "QRS678", 7));
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(8, "ES", "TUV901", 8));
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(9, "GO", "WXY234", 9));
        placasCarro.put(proximoIdPlaca++, new PlacaCarro(10, "DF", "ZAB567", 10));

        Map<String,Object> model = new HashMap<>();
        model.put("carros",carros.values());
        model.put("placasCarro",placasCarro.values());
    }

    public Map<Integer, Carro> getCarros() {
        return carros;
    }

    public Map<Integer, PlacaCarro> getPlacasCarro() {
        return placasCarro;
    }

    // Métodos para adicionar, obter e remover carros
    public void adicionarCarro(Integer id, Carro carro) {

        if (carros.containsKey(id)) {
            Carro carroExistente = carros.get(id);
            //System.out.println("Carro com ID " + id + " já existe: " + carroExistente);
            carros.remove(id);
            placasCarro.remove(id);
            carros.put(id, carro);
        }
        else {
            //System.out.println("Carro com ID " + id + "não existe: ");
            carros.put(id, carro);
            //System.out.println("Carro não encontrado, novo adicionado com sucesso");
        }
    }

    public Carro obterCarro(Integer id) {
        //System.out.println("Buscando carro com ID: " + id);
        for (Carro carro : carros.values()) {
            //System.out.println("Verificando carro com ID: " + carro.getIdCarro());
            if (carro.getIdCarro() == id) {
                //System.out.println("Carro encontrado: " + carro);
                return carro;
            }
        }
        //System.out.println("Carro não encontrado.");
        return null;
    }

    public void removerCarro(Integer id) {
        if (carros.containsKey(id)) {
            Carro carroExistente = carros.get(id);
            System.out.println("Carro com ID " + id + " já existe: " + carroExistente);
            placasCarro.remove(id);
            carros.remove(id);
        }
    }

    public void adicionarPlacaCarro(Integer idCarro, PlacaCarro placaCarro) {
        System.out.println("Adicionando placa de carro ao carro com ID: " + idCarro);

        if (carros.containsKey(idCarro)) {
            Carro carro = carros.get(idCarro);
            System.out.println("Carro encontrado: " + carro.getIdCarro());

            if (carro.getIdPlaca() == null) {
                System.out.println("Carro não possui placa associada.");

                carro.setIdPlaca(placaCarro.getPlacaCarroID());
                System.out.println("ID da placa atribuído ao carro: " + placaCarro.getPlacaCarroID());

                carros.put(idCarro, carro);
                System.out.println("Carro atualizado na lista de carros.");

                placasCarro.put(placaCarro.getPlacaCarroID(), placaCarro);
                System.out.println("Placa de carro adicionada à lista de placasCarro.");
            } else {
                System.out.println("Carro com ID " + idCarro + " já possui uma placa associada.");
            }
        } else {
            System.out.println("Carro com ID " + idCarro + " não encontrado.");
        }
    }

    public PlacaCarro obterPlacaCarro(Integer id) {
        //System.out.println("Buscando carro com ID: " + id);
        for (PlacaCarro placaCarro : placasCarro.values()) {
            //System.out.println("Verificando carro com ID: " + carro.getIdCarro());
            if (placaCarro.getPlacaCarroID() == id) {
                //System.out.println("Carro encontrado: " + carro);
                return placaCarro;
            }
        }
        //System.out.println("Carro não encontrado.");
        return null;
    }

    public PlacaCarro removerPlacaCarro(Integer id) {
        Carro carro = null;
        // Encontrar o carro associado ao ID
        for (Carro c : carros.values()) {
            if (c.getIdPlaca() != null && c.getIdPlaca() == id) {
                carro = c;
                break;
            }
        }

        // Se o carro for encontrado, remover a placa
        if (carro != null) {
            carro.setIdPlaca(null); // Remover a referência da placa do carro
            return placasCarro.remove(id); // Remover a placa
        } else {
            System.out.println("Carro com ID da placa " + id + " não encontrado.");
            return null;
        }
    }




}

