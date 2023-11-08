public class HeapSort {
    public static void main(String[] args) {
        int[] vetor = new int[10];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }

        long startTime = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        int n = vetor.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            heap(vetor, n, i);
        }

        for(int j = n - 1; j > 0; j--){
           int holder = vetor[0];
           vetor[0] = vetor[j];
           vetor[j] = holder;

             heap(vetor, j, 0);
        }

        long endTime = System.nanoTime();
        long tempoDeExecucao = endTime - startTime;

        System.out.println("\nVetor ordenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        System.out.println("\n\n\nTempo de Execução: " + tempoDeExecucao + " ns");
        System.out.println("Número de Trocas: " + trocas);
        System.out.println("Número de Iterações: " + iteracoes);
    }
    private static void heap(int[] vetor, int n, int i){
        int raiz = i;
        int esquerda = 2*i + 1;
        int direita = 2*i + 2;

        if (esquerda < n && vetor[esquerda] > vetor[raiz]){
            raiz = esquerda;
        }
        if(direita < n && vetor[direita] > vetor[raiz]) {
            raiz = direita;
        }
        if (raiz != i) {
            int holder = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz] = holder;

            heap(vetor, n, raiz);
        }
    }
}