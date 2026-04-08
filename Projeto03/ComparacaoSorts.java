
import java.util.Random;

public class ComparacaoSorts {

    public static void main(String[] args) {

        int[] tamanhos = {1000, 5000, 10000};
        int repeticoes = 5;

        for (int n : tamanhos) {

            System.out.println("TAMANHO: " );

            testarCaso("Melhor Caso", criarOrdenado(n), repeticoes);
            testarCaso("Caso Médio", criarAleatorio(n), repeticoes);
            testarCaso("Pior Caso", criarInvertido(n), repeticoes);
        }
    }

    public static void testarCaso(String nomeCaso, int[] vetorBase, int repeticoes) {

        double[] temposBubble = new double[repeticoes];
        double[] temposInsertion = new double[repeticoes];

        for (int i = 0; i < repeticoes; i++) {

            int[] v1 = vetorBase.clone();
            int[] v2 = vetorBase.clone();

            long inicio = System.nanoTime();
            bubbleSort(v1);
            long fim = System.nanoTime();
            temposBubble[i] = (fim - inicio) / 1_000_000.0;

            inicio = System.nanoTime();
            insertionSort(v2);
            fim = System.nanoTime();
            temposInsertion[i] = (fim - inicio) / 1_000_000.0;
        }

        System.out.println("\n--- " + nomeCaso + " ---");

        System.out.println("Bubble Sort:");
        mostrarEstatisticas(temposBubble);

        System.out.println("Insertion Sort:");
        mostrarEstatisticas(temposInsertion);
    }

    public static void bubbleSort(int[] vetor) {
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
    }

    public static void insertionSort(int[] vetor) {
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
    }

    public static int[] criarOrdenado(int n) {
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = i;
        }
        return v;
    }

    public static int[] criarAleatorio(int n) {
        Random rand = new Random();
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = rand.nextInt(10000);
        }

        return v;
    }

    public static int[] criarInvertido(int n) {
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = n - i;
        }

        return v;
    }
    public static void mostrarEstatisticas(double[] tempos) {

        double soma = 0;

        for (double t : tempos) {
            soma += t;
        }

        double media = soma / tempos.length;

        double variancia = 0;

        for (double t : tempos) {
            variancia += Math.pow(t - media, 2);
        }

        double desvio = Math.sqrt(variancia / tempos.length);

        System.out.println("Média: " + media + " ms");
        System.out.println("Desvio padrão: " + desvio + " ms");
    }
}