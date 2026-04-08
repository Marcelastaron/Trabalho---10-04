import javax.swing.JOptionPane;

public class BubbleSort {

    public static void main(String[] args) {

        int vetor[] = {8, 5, 1, 7, 6};

        int x, y, aux;

        for (x = 0; x < vetor.length - 1; x++) {

            for (y = 0; y < vetor.length - 1 - x; y++) {

                if (vetor[y] > vetor[y + 1]) {

                    aux = vetor[y];
                    vetor[y] = vetor[y + 1];
                    vetor[y + 1] = aux;
                }
            }
        }

        String resultado = "Vetor ordenado:\n";

        for (x = 0; x < vetor.length; x++) {
            resultado += vetor[x] + " ";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}