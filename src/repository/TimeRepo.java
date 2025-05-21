package repository;

import model.Time;
import repository.interfaces.ITimeRepo;

import java.util.ArrayList;
import java.util.List;

public class TimeRepo implements ITimeRepo {
    private List<Time> times = new ArrayList<>();

    public void adicionar(Time time) {
        if (buscarPorNome(time.getNome()) == null) {
            times.add(time);
        }
        else {
            System.out.println(" Já existe um time com esse nome.");
        }
    }

    public void remover(Time time) {
        times.remove(time);
    }

    public List<Time> listarTodos() {
        return new ArrayList<>(times);
    }

    public Time buscarPorNome(String nome) {
        for (Time t : times) {
            if (t.getNome().equalsIgnoreCase(nome)) {
                return t;
            }
        }
        return null;
    }

    public Time buscarPorIndice(int index) {
        if (index >= 0 && index < times.size()) {
            return times.get(index);
        }
        System.out.println("Indice não encontrado:" + index);
        return null;
    }

    public void limpar() {
        times.clear();
    }
}
