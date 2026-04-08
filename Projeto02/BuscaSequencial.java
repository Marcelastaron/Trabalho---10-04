
package Projeto02;

import javax.swing.JOptionPane;

public class BuscaSequencial {

    public static void main(String[] args) {

        int vetor[] = {8, 5, 1, 7, 6};
        int valor;
        boolean encontraValor = false;
        int posicao = -1;

        valor = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o valor que deseja encontrar:")
        );

        int i = 0;

        while (i < vetor.length && encontraValor == false) {

            if (vetor[i] == valor) {
                encontraValor = true;
                posicao = i;
            }

            i++;
        }

        if (encontraValor == false) {

            JOptionPane.showMessageDialog(
                null,
                "Valor informado não existe no vetor."
            );

        } else {

            JOptionPane.showMessageDialog(
                null,
                "Valor encontrado na posição: " + posicao
            );
        }
    }
}
  