import java.util.HashMap;
import java.util.Map;

class Carro {
    private int idCarro;
    private Integer idPlaca; // Permitindo objeto nulo para a ID da placa

    public Carro(int idCarro) {
        this.idCarro = idCarro;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public Integer getIdPlaca() {
        return idPlaca;
    }

    public void setIdPlaca(Integer idPlaca) {
        this.idPlaca = idPlaca;
    }
}

class PlacaCarro {
    private int idPlaca;

    public PlacaCarro(int idPlaca) {
        this.idPlaca = idPlaca;
    }

    public int getPlacaCarroID() {
        return idPlaca;
    }
}

public class TesteConcessionaria {
    private Map<Integer, Carro> carros = new HashMap<>();
    private Map<Integer, PlacaCarro> placasCarro = new HashMap<>();

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

    public Carro obterCarro(Integer id) {
        return carros.get(id);
    }

    public static void main(String[] args) {
        TesteConcessionaria concessionaria = new TesteConcessionaria();

        // Criando um carro e uma placa de carro
        Carro carro = new Carro(1);
        PlacaCarro placaCarro = new PlacaCarro(1);

        // Adicionando a placa de carro ao carro
        concessionaria.adicionarPlacaCarro(carro.getIdCarro(), placaCarro);
    }
}