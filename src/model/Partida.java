package model;

public class Partida {
    private Time time1;
    private Time time2;
    private Time vencedor;

    public Partida(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
    }

    public void definirVencedor(Time vencedor) {
        this.vencedor = vencedor;
        if(vencedor.equals(time1)) {
            time2.eliminar();
        } else {
            time1.eliminar();
        }
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    public Time getVencedor() {
        return vencedor;
    }

    @Override
    public String toString() {
        if (time2 == null) {
            return time1 + " avança automaticamente.";
        }
        return time1 + " vs " + time2;
    }

    public void exibirPartida() {
        if (time2 == null) {
            System.out.println(time1 + " avança automaticamente.");
        }
        else {
            System.out.println(time1 + " vs " + time2);
        }
    }
}