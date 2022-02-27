import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Questao1 {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>Escada de tamanho dinamico<<<<<<<");
        System.out.println();

        System.out.print("Quantos degraus? ");

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            // faz a conversao da entrada(string) em inteiro
            int qtdDegraus = Integer.parseInt(entrada.readLine());

            imprime(qtdDegraus);
        } catch (IOException e) {
            System.err.println("Problema identificado: " + e.getMessage());
        }
    }

    public static void imprime(int qtdDegraus)
    {
        int degrauAtual = 1;
        for (int degrau = 0; degrau < qtdDegraus; degrau++) {
            for (int passos = qtdDegraus; passos > 0; passos--) {
                if (passos <= degrauAtual) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
            degrauAtual++;
        }
    }
}
