package repository.interfaces;

import model.Partida;

import java.util.List;

public interface IPartidaRepo {

    void adicionar(Partida partida);
    void remover(Partida partida);
    List<Partida> listarTodas();
    void limpar();
}
