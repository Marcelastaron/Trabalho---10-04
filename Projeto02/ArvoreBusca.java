package Projeto02;

import javax.swing.JOptionPane;

public class ArvoreBusca {

    static class No {
        int valor;
        No esquerda, direita;

        public No(int valor) {
            this.valor = valor;
            esquerda = direita = null;
        }
    }

    public static No inserir(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserir(raiz.esquerda, valor);
        } else {
            raiz.direita = inserir(raiz.direita, valor);
        }

        return raiz;
    }

    public static boolean buscar(No raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (raiz.valor == valor) {
            return true;
        }

        if (valor < raiz.valor) {
            return buscar(raiz.esquerda, valor);
        } else {
            return buscar(raiz.direita, valor);
        }
    }

    public static void main(String[] args) {

        No raiz = null;

        int[] valores = {8, 5, 1, 7, 6};

        for (int v : valores) {
            raiz = inserir(raiz, v);
        }

        int valor = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o valor que deseja buscar na árvore:")
        );

        boolean encontrado = buscar(raiz, valor);

        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Valor encontrado na árvore!");
        } else {
            JOptionPane.showMessageDialog(null, "Valor NÃO encontrado na árvore.");
        }
    }
}