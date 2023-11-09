import com.sun.tools.javac.Main;

public class HeapSort {

    static int trocas;
    static int iteracoes;
    public static void main(String[] args) {
        HeapSort main = new HeapSort();

        int[] vetor = new int[10000];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }


        long startTime = System.nanoTime();

        int n = vetor.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            main.heap(vetor, n, i);
        }

        for(int j = n - 1; j > 0; j--){
           int holder = vetor[0];
           vetor[0] = vetor[j];
           vetor[j] = holder;

             main.heap(vetor, j, 0);
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
    private void heap(int[] vetor, int n, int i){
        int raiz = i;
        int esquerda = 2*i + 1;
        int direita = 2*i + 2;

        if (esquerda < n && vetor[esquerda] > vetor[raiz]){
            raiz = esquerda;
            iteracoes++;
        }
        if(direita < n && vetor[direita] > vetor[raiz]) {
            raiz = direita;
            iteracoes++;
        }
        if (raiz != i) {
            int holder = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz] = holder;
            trocas++;
            heap(vetor, n, raiz);
        }

    }

}