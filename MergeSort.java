public class MergeSort {

    static int trocas;
    static int iteracoes;

    public static void main(String[] args) {
        MergeSort main = new MergeSort();

        int[] vetor = new int[10000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }

        long startTime = System.nanoTime();

        main.mergeSort(vetor, 0, vetor.length - 1);

        long endTime = System.nanoTime();
        long tempoDeExecucao = endTime - startTime;

        System.out.println("\n\n\nVetor ordenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        System.out.println("Tempo de Execução: " + tempoDeExecucao + " ns");
        System.out.println("Número de Trocas: " + trocas);
        System.out.println("Número de Iterações: " + iteracoes);
    }

    public void mergeSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(vetor, esquerda, meio);
            mergeSort(vetor, meio + 1, direita);
            merge(vetor, esquerda, meio, direita);
        }
    }

    public void merge(int[] vetor, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = vetor[esquerda + i];
            iteracoes++;
        }
        for (int j = 0; j < n2; j++) {
            R[j] = vetor[meio + 1 + j];
            iteracoes++;
        }

        int i = 0, j = 0;
        int k = esquerda;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                vetor[k] = L[i];
                i++;
            } else {
                vetor[k] = R[j];
                j++;
            }
            k++;
            iteracoes++;
            trocas++;
        }

        while (i < n1) {
            vetor[k] = L[i];
            i++;
            k++;
            trocas++;
        }

        while (j < n2) {
            vetor[k] = R[j];
            j++;
            k++;
            trocas++;
        }
    }
}