package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Tabela {
    private ArrayList<Time> times;
    private ArrayList<Partida> partidasAtuais;

    public Tabela(ArrayList<Time> times) {
        this.times = new ArrayList<>(times);
    }

    public boolean temCampeao() {

        int naoEliminados = 0;
        for(Time t : times) {
            if(!t.isEliminado()) {
                naoEliminados++;
            }
        }
        return naoEliminados == 1;
    }

    public Time getCampeao() {
        for(Time t : times) {
            if(!t.isEliminado()) {
                return t;
            }
        }
        return null;
    }

    public void gerarConfrontos() {
        ArrayList<Time> emJogo = new ArrayList<>();
        for(Time t : times) {
            if(!t.isEliminado()) {
                emJogo.add(t);
            }
        }

        partidasAtuais = new ArrayList<>();

        if (emJogo.size() % 2 != 0) {
            Time avanca = emJogo.remove(emJogo.size() - 1);
            System.out.println(avanca.getNome() + " avança automaticamente!");
            partidasAtuais.add(new Partida(avanca,null));
        }

        for (int i = 0; i < emJogo.size(); i += 2) {
            partidasAtuais.add(new Partida(emJogo.get(i), emJogo.get(i + 1)));
        }
    }

    public void mostrarConfrontos() {
        System.out.println("\nConfrontos da rodada:");
        for (Partida p : partidasAtuais) {
            p.exibirPartida();
        }
    }

    public void jogarRodada(Scanner sc) {
        ArrayList<Time> vencedores = new ArrayList<>();

        for (Partida p : partidasAtuais) {
            Time t1 = p.getTime1();
            Time t2 = p.getTime2();

            if (t2 == null) {
                vencedores.add(t1);
                continue;
            }

            int opcao;
            while (true) {
                try {
                    System.out.print("\n" + t1.getNome() + " vs " + t2.getNome() + " - Quem venceu? (Digite 1 para \"" + t1.getNome() + "\" ou 2 para \"" + t2.getNome() + "\"): ");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    if (opcao == 1 || opcao == 2) {
                        break;
                    } else {
                        System.out.println("Digite apenas 1 ou 2!");
                    }
                } catch (Exception e) {
                    System.out.println("Valor inválido! Digite 1 ou 2.");
                    sc.nextLine();
                }
            }

            if (opcao == 1) {
                p.definirVencedor(t1);
                vencedores.add(t1);
            } else {
                p.definirVencedor(t2);
                vencedores.add(t2);
            }
        }

        this.times = vencedores;
    }

    public void adicionarTime(Time novoTime) {
        times.add(novoTime);
    }
}