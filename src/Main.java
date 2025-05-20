import model.Time;
import model.Torneio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Time> times = new ArrayList<>();

        System.out.println("\nBem vindo ao Torneio de Times!");

        // CADASTRO DOS TIMES
        System.out.println("\nCadastro de Times:");
        int quantidade;
        while(true) {
            System.out.print("Digite um numero PAR de times (minimo 2): ");
            if(sc.hasNextInt()) {
                quantidade = sc.nextInt();
                sc.nextLine();
                if(quantidade >= 2 && quantidade % 2 == 0) {
                    break;
                } else {
                    System.out.println("A quantidade deve ser par e maior ou igual a 2!");
                }
            } else {
                System.out.println("Por favor, digite um numero valido!");
                sc.nextLine();
            }
        }

        System.out.println(
                """
                        
                        -----------------------------
                        Observação: a ordem de cadastro dos times define os confrontos!
                        
                        O time digitado depois enfrentará o time digitado antes. Exemplo:
                        - 1º time: A
                        - 2º time: B → confronto será A vs B
                        - 3º time: C
                        - 4º time: D → confronto será C vs D
                        
                        Se quiser que os confrontos sejam aleatórios, você poderá escolher isso na próxima etapa!
                        -----------------------------"""
        );

        for(int i = 0; i < quantidade; i++) {
            System.out.print("Nome do " + (i + 1) + "º time: ");
            times.add(new Time(sc.nextLine()));
        }


        System.out.print("\nDeseja sortear os confrontos aleatoriamente? (Sim/Não): ");
        String resposta = sc.nextLine();
        if(resposta.equalsIgnoreCase("Sim")) {
            Collections.shuffle(times);
            System.out.println("\nTimes foram embaralhados para confrontos aleatórios!");
        }

        // TORNEIO
        Torneio torneio = new Torneio(times);

        while(!torneio.temCampeao()) {
            System.out.println("\n--- Confrontos do Torneio ---");
            torneio.gerarConfrontos();
            torneio.mostrarConfrontos();
            torneio.jogarRodada(sc);
        }

        System.out.println("\nCAMPEÃO: " + torneio.getCampeao().getNome());
        sc.close();
    }
}