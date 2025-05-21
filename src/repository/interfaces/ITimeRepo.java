package repository.interfaces;

import model.Time;

import java.util.List;

public interface ITimeRepo {

    void adicionar(Time time);
    void remover(Time time);
    List<Time> listarTodos();
    Time buscarPorNome(String nome);
    Time buscarPorIndice(int index);
    void limpar();

}
