package Projeto02;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class BuscaBinaria {

    public static void main(String[] args) {

        int vetor[] = {1, 5, 6, 7, 8};
        int valor;
        int inicio = 0;
        int fim = vetor.length - 1;
        int meio;
        boolean encontrou = false;
        int posicao = -1;

        valor = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o valor que deseja encontrar:")
        );

        while (inicio <= fim) {

            meio = (inicio + fim) / 2;

            if (vetor[meio] == valor) {
                encontrou = true;
                posicao = meio;
                break;
            } else if (vetor[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (encontrou == false) {

            JOptionPane.showMessageDialog(
                null,
                "Valor não encontrado no vetor."
            );

        } else {

            JOptionPane.showMessageDialog(
                null,
                "Valor encontrado na posição: " + posicao
            );
        }
    }
}