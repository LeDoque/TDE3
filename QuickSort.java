public class QuickSort {
    public static void main(String[] args) {
        int[] vetor = new int[100];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }

        long startTime = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        quick(vetor, 0, vetor.length - 1);

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
    public static void quick(int[] vetor, int esquerda, int direita){
        if(esquerda < direita){
            int pivo = pedaco(vetor, esquerda, direita);
            quick(vetor, esquerda, pivo);
            quick(vetor, pivo + 1, direita);
        }
    }
    public static int pedaco(int[] vetor, int esquerda, int direita){
        int meio = (int) (esquerda + direita) / 2;
        int pivot = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        while(true) {
            do{
                i++;
            } while (vetor[i] < pivot);
            do {
                j--;
            } while (vetor[j] > pivot);
            if (i >= j) {
                return j;
            }
            int holder = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = holder;
        }
    }
}
