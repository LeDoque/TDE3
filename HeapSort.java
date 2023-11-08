public class HeapSort {
    public static void main(String[] args) {
        int[] vetor = new int[10000];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }

        long startTime = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        int n = vetor.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            iteracoes++;
             heap(vetor, n, i);
        }

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
    public static void heap(int[] vetor, int n, int i){
        int raiz = i;
        int esquerda = 2*i + 1;
        int direita = 2*i + 2;

        if (esquerda < n && vetor[esquerda] > vetor[raiz]){
            raiz = esquerda;
        } else if(direita < n && vetor[esquerda] > vetor[raiz]) {
            raiz = direita;
        } else if (raiz != raiz) {
            int holder = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz] = vetor[holder];

            heap(vetor, n, raiz);
        }
    }
}