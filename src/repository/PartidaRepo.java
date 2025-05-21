package repository;

import model.Partida;
import repository.interfaces.IPartidaRepo;

import java.util.ArrayList;
import java.util.List;

public class PartidaRepo implements IPartidaRepo {
    private ArrayList<Partida> partidas = new ArrayList<>();

    public void adicionar(Partida partida) {
        partidas.add(partida);
    }

    public void remover(Partida partida) {
        partidas.remove(partida);
    }

    public List<Partida> listarTodas() {
        return new ArrayList<>(partidas);
    }

    public void limpar() {
        partidas.clear();
    }
}
