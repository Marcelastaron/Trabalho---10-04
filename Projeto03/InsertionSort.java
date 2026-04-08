import javax.swing.JOptionPane;

public class InsertionSort{

    public static void main(String[] args) {

        int vetor[] = {8, 5, 1, 7, 6};

        int x, y, chave;

        for (x = 1; x < vetor.length; x++) {

            chave = vetor[x];
            y = x - 1;

            while (y >= 0 && vetor[y] > chave) {

                vetor[y + 1] = vetor[y];
                y--;
            }

            vetor[y + 1] = chave;
        }

        String resultado = "Vetor ordenado:\n";

        for (x = 0; x < vetor.length; x++) {
            resultado += vetor[x] + " ";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}