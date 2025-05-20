package model;

public class Time {
    private String nome;
    private boolean eliminado;

    public Time(String nome) {
        this.nome = nome;
        this.eliminado = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void eliminar() {
        this.eliminado = true;
    }

    @Override
    public String toString() {
        return nome;
    }
}